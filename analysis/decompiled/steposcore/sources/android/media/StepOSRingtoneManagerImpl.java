package android.media;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.settings.config.StepOSSettingsKeys;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class StepOSRingtoneManagerImpl implements StepOSRingtoneManagerStub {
    private static final int COLUMN_DATA = 3;
    private static final int COLUMN_DISPLAY_NAME = 1;
    private static final int COLUMN_ID = 0;
    private static final int COLUMN_IS_MUSIC = 5;
    private static final int COLUMN_IS_RINGTONE = 4;
    private static final int COLUMN_TITLE = 2;
    private static final String PROP_DEFAULT_ALARM = "ro.config.alarm_alert";
    private static final String PROP_DEFAULT_NOTIFICATION = "ro.config.notification_sound";
    private static final String PROP_DEFAULT_RINGTONE = "ro.config.ringtone";
    private static final String PROP_STEPOS_CALENDAR = "ro.vendor.stepos.ringtone.calendar_sound.config";
    private static final String PROP_STEPOS_EMAIL = "ro.vendor.stepos.ringtone.email_sound.config";
    private static final String PROP_STEPOS_MMS = "ro.vendor.stepos.ringtone.mms_sound.config";
    private static final String TAG = "StepOSRingtoneManager";
    private Handler mSkippedCompletionHandler;
    private static final Uri DEFAULT_MMS_SOUND_URI = Settings.System.getUriFor(StepOSSettingsKeys.SYSTEM_MMS_SOUND);
    private static final Uri DEFAULT_EMAIL_SOUND_URI = Settings.System.getUriFor(StepOSSettingsKeys.SYSTEM_EMAIL_SOUND);
    private static final Uri DEFAULT_CALENDAR_SOUND_URI = Settings.System.getUriFor(StepOSSettingsKeys.SYSTEM_CALENDAR_SOUND);
    private static final Uri DEFAULT_RINGTONE_PHONE_1_URI = Settings.System.getUriFor(StepOSSettingsKeys.SYSTEM_RINGTONE_SOUND_PHONE_1);
    private static final Uri DEFAULT_RINGTONE_PHONE_2_URI = Settings.System.getUriFor(StepOSSettingsKeys.SYSTEM_RINGTONE_SOUND_PHONE_2);
    private static final String[] AUDIO_INFO_COLUMNS = {"_id", "_display_name", "title", "_data", "is_ringtone", "is_music"};

    public boolean isStepOSType(int type) {
        return type == 256 || type == 512 || type == 1024 || type == 2048 || type == 4096;
    }

    public Uri getActualDefaultRingtoneUri(Context context, int type) {
        if (!isStepOSType(type)) {
            if (context == null) {
                return null;
            }
            return RingtoneManager.getActualDefaultRingtoneUri(context, type);
        }
        return getActualDefaultRingtoneUri(context, type, context.getUserId());
    }

    public Uri maybeHealAospDefaultRingtoneUri(Context context, int type, Uri uri) {
        Uri factoryDefault;
        if (uri == null || context == null || isStepOSType(type) || RingtoneManager.getDefaultType(uri) != -1 || !isUserUnlocked(context) || isRingtoneExist(context, uri) || (factoryDefault = computeAospDefaultRingtoneUri(context, type)) == null) {
            return uri;
        }
        try {
            RingtoneManager.setActualDefaultRingtoneUri(context, type, factoryDefault);
        } catch (Throwable t) {
            Log.w(TAG, "maybeHealAospDefaultRingtoneUri rewrite failed for type " + type + ": " + t.getMessage());
        }
        return factoryDefault;
    }

    private Uri computeAospDefaultRingtoneUri(Context context, int type) {
        String filename = getInitDefaultRingtoneName(type);
        if (TextUtils.isEmpty(filename)) {
            return null;
        }
        return queryMediaStoreByFilename(context, filename, type);
    }

    public Uri getActualDefaultRingtoneUri(Context context, int type, int userId) {
        String setting;
        Uri factoryDefault;
        if (!isStepOSType(type) || context == null || (setting = getSettingForType(type)) == null) {
            return null;
        }
        String uriStr = Settings.System.getStringForUser(context.getContentResolver(), setting, userId);
        if (TextUtils.isEmpty(uriStr)) {
            String setFlagKey = getSetFlagForType(type);
            if (setFlagKey == null || !isSet(context, setFlagKey)) {
                return getFallbackUri(context, type);
            }
            return null;
        }
        Uri uri = Uri.parse(uriStr);
        if (ContentProvider.getUserIdFromUri(uri) == userId) {
            uri = ContentProvider.getUriWithoutUserId(uri);
        }
        Uri checked = uri;
        if (isUserUnlocked(context) && !isRingtoneExist(context, uri)) {
            String filename = getInitDefaultRingtoneName(type);
            if (!TextUtils.isEmpty(filename) && (factoryDefault = queryMediaStoreByFilename(context, filename, type)) != null) {
                checked = factoryDefault;
            }
        }
        if (checked != null && !checked.equals(uri)) {
            Settings.System.putStringForUser(context.getContentResolver(), setting, checked.toString(), userId);
        }
        return checked;
    }

    public void setActualDefaultRingtoneUri(Context context, int type, Uri ringtoneUri) {
        if (!isStepOSType(type)) {
            if (context != null) {
                RingtoneManager.setActualDefaultRingtoneUri(context, type, ringtoneUri);
                return;
            }
            return;
        }
        setActualDefaultRingtoneUri(context, type, ringtoneUri, context != null ? context.getUserId() : UserHandle.getCallingUserId());
    }

    public void setActualDefaultRingtoneUri(Context context, int type, Uri ringtoneUri, int userId) {
        String key;
        String mimeType;
        if (!isStepOSType(type) || context == null || (key = getSettingForType(type)) == null) {
            return;
        }
        ContentResolver resolver = context.getContentResolver();
        if (ringtoneUri != null && !isInternalRingtoneUri(ringtoneUri)) {
            ringtoneUri = ContentProvider.maybeAddUserId(ringtoneUri, userId);
        }
        if (ringtoneUri != null && ((mimeType = resolver.getType(ringtoneUri)) == null || (!mimeType.startsWith("audio/") && !mimeType.startsWith("video/") && !mimeType.equals("application/ogg") && !mimeType.equals("application/x-flac") && !mimeType.equals("application/mp4")))) {
            Log.e(TAG, "setActualDefaultRingtoneUri: invalid MIME type " + mimeType + " for URI " + ringtoneUri + ", ignored");
            return;
        }
        Settings.System.putStringForUser(resolver, key, ringtoneUri != null ? ringtoneUri.toString() : null, userId);
        String setFlagKey = getSetFlagForType(type);
        if (setFlagKey != null) {
            Settings.System.putIntForUser(resolver, setFlagKey, 1, userId);
        }
    }

    public boolean isUserSilenced(Context context, int type) {
        String setting;
        String flagKey;
        if (!isStepOSType(type) || context == null || (setting = getSettingForType(type)) == null) {
            return false;
        }
        String uriStr = Settings.System.getStringForUser(context.getContentResolver(), setting, context.getUserId());
        return TextUtils.isEmpty(uriStr) && (flagKey = getSetFlagForType(type)) != null && isSet(context, flagKey);
    }

    public String getSettingForType(int type) {
        switch (type) {
            case 256:
                return StepOSSettingsKeys.SYSTEM_MMS_SOUND;
            case 512:
                return StepOSSettingsKeys.SYSTEM_EMAIL_SOUND;
            case 1024:
                return StepOSSettingsKeys.SYSTEM_CALENDAR_SOUND;
            case 2048:
                return StepOSSettingsKeys.SYSTEM_RINGTONE_SOUND_PHONE_1;
            case 4096:
                return StepOSSettingsKeys.SYSTEM_RINGTONE_SOUND_PHONE_2;
            default:
                return null;
        }
    }

    public Uri getDefaultUri(int type) {
        switch (type) {
            case 256:
                return DEFAULT_MMS_SOUND_URI;
            case 512:
                return DEFAULT_EMAIL_SOUND_URI;
            case 1024:
                return DEFAULT_CALENDAR_SOUND_URI;
            case 2048:
                return DEFAULT_RINGTONE_PHONE_1_URI;
            case 4096:
                return DEFAULT_RINGTONE_PHONE_2_URI;
            default:
                return RingtoneManager.getDefaultUri(type);
        }
    }

    public int getDefaultType(Uri defaultRingtoneUri) {
        if (defaultRingtoneUri == null) {
            return 0;
        }
        Uri defaultRingtoneUri2 = ContentProvider.getUriWithoutUserId(defaultRingtoneUri);
        if (DEFAULT_RINGTONE_PHONE_1_URI.equals(defaultRingtoneUri2)) {
            return 2048;
        }
        if (DEFAULT_RINGTONE_PHONE_2_URI.equals(defaultRingtoneUri2)) {
            return 4096;
        }
        if (DEFAULT_MMS_SOUND_URI.equals(defaultRingtoneUri2)) {
            return 256;
        }
        if (DEFAULT_EMAIL_SOUND_URI.equals(defaultRingtoneUri2)) {
            return 512;
        }
        if (!DEFAULT_CALENDAR_SOUND_URI.equals(defaultRingtoneUri2)) {
            return 0;
        }
        return 1024;
    }

    public Uri getCacheForType(int type) {
        return getCacheForType(type, UserHandle.getCallingUserId());
    }

    public Uri getCacheForType(int type, int userId) {
        Uri cacheUri;
        switch (type) {
            case 2048:
                cacheUri = Settings.System.getUriFor(StepOSSettingsKeys.SYSTEM_RINGTONE_SOUND_PHONE_1_CACHE);
                break;
            case 4096:
                cacheUri = Settings.System.getUriFor(StepOSSettingsKeys.SYSTEM_RINGTONE_SOUND_PHONE_2_CACHE);
                break;
            default:
                return null;
        }
        return ContentProvider.maybeAddUserId(cacheUri, userId);
    }

    public Uri checkRingtoneUri(Context context, Uri ringtoneUri, int streamType) {
        int fallbackType;
        if (context == null || !isUserUnlocked(context)) {
            return ringtoneUri;
        }
        int ringtoneType = RingtoneManager.getDefaultType(ringtoneUri);
        Uri tempUri = null;
        if (ringtoneType != -1) {
            tempUri = RingtoneManager.getActualDefaultRingtoneUri(context, ringtoneType);
            if (tempUri != null && !isRingtoneExist(context, tempUri)) {
                tempUri = null;
            }
        } else if (ringtoneUri != null && !isRingtoneExist(context, ringtoneUri)) {
            switch (streamType) {
                case 4:
                    fallbackType = 4;
                    break;
                case 5:
                    fallbackType = 2;
                    break;
                default:
                    fallbackType = 1;
                    break;
            }
            tempUri = RingtoneManager.getActualDefaultRingtoneUri(context, fallbackType);
        }
        return tempUri != null ? tempUri : ringtoneUri;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        if (new java.io.File(r13).exists() != false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045 A[PHI: r3 r6
      0x0045: PHI (r3v4 'c' android.database.Cursor) = (r3v3 'c' android.database.Cursor), (r3v6 'c' android.database.Cursor) binds: [B:30:0x0070, B:21:0x0043] A[DONT_GENERATE, DONT_INLINE]
      0x0045: PHI (r6v4 'uri' android.net.Uri) = (r6v2 'uri' android.net.Uri), (r6v5 'uri' android.net.Uri) binds: [B:30:0x0070, B:21:0x0043] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007f A[Catch: IOException -> 0x0084, TRY_LEAVE, TryCatch #1 {IOException -> 0x0084, blocks: (B:32:0x0073, B:34:0x007f), top: B:48:0x0073 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean isRingtoneExist(android.content.Context r12, android.net.Uri r13) throws java.lang.Throwable {
        /*
            r11 = this;
            r1 = 0
            if (r13 != 0) goto L4
            return r1
        L4:
            boolean r2 = android.app.ActivityThread.isSystem()
            r3 = 0
            r4 = 1
            android.content.ContentResolver r5 = r12.getContentResolver()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50
            java.lang.String r0 = "_data"
            java.lang.String[] r7 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50
            r9 = 0
            r10 = 0
            r8 = 0
            r6 = r13
            android.database.Cursor r13 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L9a
            r3 = r13
            if (r3 == 0) goto L43
            boolean r13 = r3.moveToFirst()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L9a
            if (r13 == 0) goto L43
            java.lang.String r13 = r3.getString(r1)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L9a
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L9a
            if (r0 != 0) goto L3c
            if (r2 != 0) goto L3c
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L9a
            r0.<init>(r13)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L9a
            boolean r0 = r0.exists()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L9a
            if (r0 == 0) goto L43
        L3c:
        L3d:
            if (r3 == 0) goto L42
            r3.close()
        L42:
            return r4
        L43:
            if (r3 == 0) goto L73
        L45:
            r3.close()
            goto L73
        L49:
            r0 = move-exception
            r13 = r0
            goto L53
        L4c:
            r0 = move-exception
            r6 = r13
            r13 = r0
            goto L9c
        L50:
            r0 = move-exception
            r6 = r13
            r13 = r0
        L53:
            java.lang.String r0 = "StepOSRingtoneManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9a
            r5.<init>()     // Catch: java.lang.Throwable -> L9a
            java.lang.String r7 = "isRingtoneExist query failed: "
            java.lang.StringBuilder r5 = r5.append(r7)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r7 = r13.getMessage()     // Catch: java.lang.Throwable -> L9a
            java.lang.StringBuilder r5 = r5.append(r7)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L9a
            android.util.Log.e(r0, r5)     // Catch: java.lang.Throwable -> L9a
            if (r3 == 0) goto L73
            goto L45
        L73:
            android.content.ContentResolver r13 = r12.getContentResolver()     // Catch: java.io.IOException -> L84
            java.lang.String r0 = "r"
            android.content.res.AssetFileDescriptor r13 = r13.openAssetFileDescriptor(r6, r0)     // Catch: java.io.IOException -> L84
            if (r13 == 0) goto L83
            r13.close()     // Catch: java.io.IOException -> L84
            return r4
        L83:
            goto L85
        L84:
            r0 = move-exception
        L85:
            java.lang.String r13 = r6.getPath()
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            if (r0 != 0) goto L99
            java.io.File r0 = new java.io.File
            r0.<init>(r13)
            boolean r0 = r0.exists()
            return r0
        L99:
            return r1
        L9a:
            r0 = move-exception
            r13 = r0
        L9c:
            if (r3 == 0) goto La1
            r3.close()
        La1:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.StepOSRingtoneManagerImpl.isRingtoneExist(android.content.Context, android.net.Uri):boolean");
    }

    public List<?> getAllRingtoneInfos(Context context, int type) {
        return getAllRingtoneInfos(context, type, true, true);
    }

    public StepOSRingtoneInfo getRingtoneInfo(Context context, Uri mediaUri) {
        if (context == null) {
            return null;
        }
        return getRingtoneInfo(context, mediaUri, context.getUserId());
    }

    public StepOSRingtoneInfo getRingtoneInfo(Context context, Uri mediaUri, int userId) throws Throwable {
        Uri actualUri;
        if (context == null || mediaUri == null || (actualUri = resolveActualUri(context, mediaUri, userId)) == null) {
            return null;
        }
        Uri queryUri = ContentProvider.maybeAddUserId(ContentProvider.getUriWithoutUserId(actualUri), userId);
        Cursor cursor = null;
        try {
            try {
                Cursor cursor2 = context.getContentResolver().query(queryUri, AUDIO_INFO_COLUMNS, null, null, null);
                if (cursor2 != null) {
                    try {
                        if (cursor2.moveToFirst()) {
                            int type = getRingtoneTypeForUri(mediaUri);
                            StepOSRingtoneInfo ringtoneInfoFromCursor = getRingtoneInfoFromCursor(context, cursor2, type <= 0 ? inferTypeFromCursor(cursor2) : type, isInternalRingtoneUri(actualUri), userId);
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            return ringtoneInfoFromCursor;
                        }
                    } catch (Exception e) {
                        e = e;
                        cursor = cursor2;
                        Log.w(TAG, "getRingtoneInfo failed: " + e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursor2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
            } catch (Exception e2) {
                e = e2;
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public List<StepOSRingtoneInfo> getAllRingtoneInfos(Context context, int type, boolean includeInternal, boolean includeExternal) {
        if (context == null) {
            return null;
        }
        return getAllRingtoneInfos(context, type, includeInternal, includeExternal, context.getUserId());
    }

    public List<StepOSRingtoneInfo> getAllRingtoneInfos(Context context, int type, boolean includeInternal, boolean includeExternal, int userId) {
        if (context == null) {
            return null;
        }
        return getAudioInfos(context, type, includeInternal, includeExternal, userId, null, null);
    }

    public List<StepOSRingtoneInfo> getRingtoneInfos(Context context, int type, String fileName) {
        if (context != null && !TextUtils.isEmpty(fileName)) {
            return getAudioInfos(context, type, true, true, context.getUserId(), "_display_name=?", new String[]{fileName});
        }
        return null;
    }

    public String getDefaultDisplayName(Context context, int type) throws Resources.NotFoundException {
        if (context == null) {
            return "";
        }
        String fileName = getInitDefaultRingtoneName(type);
        if (!TextUtils.isEmpty(fileName)) {
            String displayName = getDisplayName(context, fileName, type);
            if (!TextUtils.isEmpty(displayName)) {
                return displayName;
            }
        }
        StepOSRingtoneInfo info = getRingtoneInfo(context, getDefaultRingtoneUri(context, type));
        return info != null ? info.displayName : "";
    }

    public Uri getDefaultRingtoneUri(Context context, int type) {
        if (context == null) {
            return null;
        }
        String setting = getSettingForType(type);
        if (setting == null) {
            return RingtoneManager.getActualDefaultRingtoneUri(context, type);
        }
        String uri = Settings.System.getStringForUser(context.getContentResolver(), setting, context.getUserId());
        if (TextUtils.isEmpty(uri)) {
            return null;
        }
        return ContentProvider.getUriWithoutUserId(Uri.parse(uri));
    }

    private List<StepOSRingtoneInfo> getAudioInfos(Context context, int type, boolean includeInternal, boolean includeExternal, int userId, String extraSelection, String[] extraSelectionArgs) throws Throwable {
        ArrayList<StepOSRingtoneInfo> infos = new ArrayList<>();
        if (includeInternal) {
            addAudioInfos(context, infos, MediaStore.Audio.Media.INTERNAL_CONTENT_URI, type, userId, extraSelection, extraSelectionArgs);
        }
        if (includeExternal) {
            addAudioInfos(context, infos, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, type, userId, extraSelection, extraSelectionArgs);
        }
        return infos;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void addAudioInfos(android.content.Context r16, java.util.ArrayList<android.media.StepOSRingtoneInfo> r17, android.net.Uri r18, int r19, int r20, java.lang.String r21, java.lang.String[] r22) throws java.lang.Throwable {
        /*
            r15 = this;
            r1 = r18
            r7 = r20
            android.net.Uri r9 = android.content.ContentProvider.maybeAddUserId(r1, r7)
            android.net.Uri r0 = android.provider.MediaStore.Audio.Media.INTERNAL_CONTENT_URI
            boolean r6 = r0.equals(r1)
            r5 = r19
            java.lang.String r0 = r15.getWhereClause(r5, r6)
            r14 = r21
            java.lang.String r11 = appendSelection(r0, r14)
            r2 = 0
            android.content.ContentResolver r8 = r16.getContentResolver()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L67
            java.lang.String[] r10 = android.media.StepOSRingtoneManagerImpl.AUDIO_INFO_COLUMNS     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L67
            java.lang.String r13 = "title ASC"
            r12 = r22
            android.database.Cursor r4 = r8.query(r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L67
            if (r4 != 0) goto L31
            if (r4 == 0) goto L30
            r4.close()
        L30:
            return
        L31:
            boolean r0 = r4.moveToNext()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5e
            if (r0 == 0) goto L51
            r2 = r15
            r3 = r16
            android.media.StepOSRingtoneInfo r0 = r2.getRingtoneInfoFromCursor(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5e
            if (r0 == 0) goto L4a
            r3 = r17
            r3.add(r0)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            goto L4c
        L46:
            r0 = move-exception
            goto L5c
        L48:
            r0 = move-exception
            goto L61
        L4a:
            r3 = r17
        L4c:
            r5 = r19
            r7 = r20
            goto L31
        L51:
            r3 = r17
            if (r4 == 0) goto L8d
            r4.close()
            goto L8d
        L59:
            r0 = move-exception
            r3 = r17
        L5c:
            r2 = r4
            goto L8f
        L5e:
            r0 = move-exception
            r3 = r17
        L61:
            r2 = r4
            goto L6a
        L63:
            r0 = move-exception
            r3 = r17
            goto L8f
        L67:
            r0 = move-exception
            r3 = r17
        L6a:
            java.lang.String r4 = "StepOSRingtoneManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8e
            r5.<init>()     // Catch: java.lang.Throwable -> L8e
            java.lang.String r7 = "addAudioInfos failed: "
            java.lang.StringBuilder r5 = r5.append(r7)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r7 = r0.getMessage()     // Catch: java.lang.Throwable -> L8e
            java.lang.StringBuilder r5 = r5.append(r7)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L8e
            android.util.Log.w(r4, r5)     // Catch: java.lang.Throwable -> L8e
            if (r2 == 0) goto L8c
            r2.close()
        L8c:
            r4 = r2
        L8d:
            return
        L8e:
            r0 = move-exception
        L8f:
            if (r2 == 0) goto L94
            r2.close()
        L94:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.StepOSRingtoneManagerImpl.addAudioInfos(android.content.Context, java.util.ArrayList, android.net.Uri, int, int, java.lang.String, java.lang.String[]):void");
    }

    private StepOSRingtoneInfo getRingtoneInfoFromCursor(Context context, Cursor cursor, int type, boolean isInternal, int userId) throws Resources.NotFoundException {
        String displayName;
        boolean z;
        String fileName = getCursorString(cursor, 1);
        String title = getCursorString(cursor, 2);
        String displayName2 = getDisplayName(context, fileName, type);
        if (!TextUtils.isEmpty(displayName2)) {
            displayName = displayName2;
        } else {
            displayName = !TextUtils.isEmpty(title) ? title : stripExtension(fileName);
        }
        String cursorString = getCursorString(cursor, 3);
        Uri uriFromCursor = getUriFromCursor(context, cursor, isInternal, userId);
        boolean z2 = false;
        if (cursor.getInt(5) == 1) {
            z = false;
            z2 = true;
        } else {
            z = false;
        }
        return new StepOSRingtoneInfo(fileName, title, displayName, cursorString, uriFromCursor, isInternal, z2, cursor.getInt(4) == 1 ? true : z);
    }

    private Uri getUriFromCursor(Context context, Cursor cursor, boolean isInternal, int userId) {
        Uri baseUri = isInternal ? MediaStore.Audio.Media.INTERNAL_CONTENT_URI : MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Uri uri = ContentUris.withAppendedId(baseUri, cursor.getLong(0));
        return context.getContentResolver().canonicalizeOrElse(ContentProvider.maybeAddUserId(uri, userId));
    }

    private Uri resolveActualUri(Context context, Uri uri, int userId) {
        int type = getRingtoneTypeForUri(uri);
        if (type > 0) {
            if (isStepOSType(type)) {
                return getActualDefaultRingtoneUri(context, type, userId);
            }
            return RingtoneManager.getActualDefaultRingtoneUri(context, type);
        }
        return uri;
    }

    private int getRingtoneTypeForUri(Uri uri) {
        int type = getDefaultType(uri);
        return type > 0 ? type : RingtoneManager.getDefaultType(uri);
    }

    private int inferTypeFromCursor(Cursor cursor) {
        return cursor.getInt(4) == 1 ? 1 : 2;
    }

    private String getWhereClause(int type, boolean isInternal) {
        String col;
        switch (type) {
            case 1:
            case 2048:
            case 4096:
                col = "is_ringtone";
                break;
            case 2:
            case 256:
            case 512:
            case 1024:
                col = "is_notification";
                break;
            case 4:
                col = "is_alarm";
                break;
            default:
                return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("((").append(col).append("=1)");
        if (!isInternal) {
            sb.append(" OR (").append("is_music").append("=1)");
            sb.append(" OR (").append("is_ringtone").append("=1)");
        }
        sb.append(")");
        return sb.toString();
    }

    private String getDisplayName(Context context, String fileName, int type) throws Resources.NotFoundException {
        int valueList;
        int nameList;
        if (context == null || TextUtils.isEmpty(fileName)) {
            return "";
        }
        switch (type) {
            case 2:
            case 256:
            case 512:
            case 1024:
                valueList = 17236334;
                nameList = 17236333;
                break;
            case 4:
                valueList = 17236332;
                nameList = 17236331;
                break;
            default:
                valueList = 17236336;
                nameList = 17236335;
                break;
        }
        String[] values = context.getResources().getStringArray(valueList);
        String[] names = context.getResources().getStringArray(nameList);
        int count = Math.min(values.length, names.length);
        for (int i = 0; i < count; i++) {
            if (fileName.equals(values[i])) {
                return names[i];
            }
        }
        return "";
    }

    private String getInitDefaultRingtoneName(int type) {
        switch (type) {
            case 1:
            case 2048:
            case 4096:
                return SystemProperties.get(PROP_DEFAULT_RINGTONE, "");
            case 4:
                return SystemProperties.get(PROP_DEFAULT_ALARM, "");
            default:
                return SystemProperties.get(PROP_DEFAULT_NOTIFICATION, "");
        }
    }

    private static String appendSelection(String baseSelection, String extraSelection) {
        return TextUtils.isEmpty(baseSelection) ? extraSelection : TextUtils.isEmpty(extraSelection) ? baseSelection : "(" + baseSelection + ") AND (" + extraSelection + ")";
    }

    private static String getCursorString(Cursor cursor, int columnIndex) {
        if (cursor.isNull(columnIndex)) {
            return null;
        }
        return cursor.getString(columnIndex);
    }

    private static String stripExtension(String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            return "";
        }
        int dotIndex = fileName.lastIndexOf(46);
        return dotIndex > 0 ? fileName.substring(0, dotIndex) : fileName;
    }

    public void ensureDefaultRingtones(Context context) {
        if (context == null) {
            return;
        }
        Uri defaultRingtone = RingtoneManager.getActualDefaultRingtoneUri(context, 1);
        if (!isSet(context, StepOSSettingsKeys.SYSTEM_RINGTONE_SOUND_PHONE_1_SET_FLAG) && defaultRingtone != null) {
            setActualDefaultRingtoneUri(context, 2048, defaultRingtone);
        }
        if (!isSet(context, StepOSSettingsKeys.SYSTEM_RINGTONE_SOUND_PHONE_2_SET_FLAG) && defaultRingtone != null) {
            setActualDefaultRingtoneUri(context, 4096, defaultRingtone);
        }
        ensureExtTypeDefault(context, 256, PROP_STEPOS_MMS);
        ensureExtTypeDefault(context, 512, PROP_STEPOS_EMAIL);
        ensureExtTypeDefault(context, 1024, PROP_STEPOS_CALENDAR);
    }

    public void onMediaReady(Context context) {
        ensureDefaultRingtones(context);
    }

    private void ensureExtTypeDefault(Context context, int type, String propKey) {
        Uri uri;
        if (isSet(context, getSetFlagForType(type))) {
            return;
        }
        String filename = SystemProperties.get(propKey, "");
        if (!TextUtils.isEmpty(filename) && (uri = queryMediaStoreByFilename(context, filename, type)) != null) {
            setActualDefaultRingtoneUri(context, type, uri);
            return;
        }
        Uri fallback = RingtoneManager.getActualDefaultRingtoneUri(context, 2);
        if (fallback != null) {
            setActualDefaultRingtoneUri(context, type, fallback);
        }
    }

    private Uri queryMediaStoreByFilename(Context context, String filename, int type) {
        ContentResolver resolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            try {
                cursor = resolver.query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, new String[]{"_id"}, appendSelection(getWhereClause(type, true), "_display_name=?"), new String[]{filename}, null);
            } catch (Exception e) {
                Log.w(TAG, "queryMediaStoreByFilename failed: " + e.getMessage());
                if (cursor == null) {
                    return null;
                }
            }
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor == null) {
                    return null;
                }
                cursor.close();
                return null;
            }
            long id = cursor.getLong(0);
            Uri uriCanonicalizeOrElse = resolver.canonicalizeOrElse(ContentUris.withAppendedId(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, id));
            if (cursor != null) {
                cursor.close();
            }
            return uriCanonicalizeOrElse;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static Uri getFallbackUri(Context context, int type) {
        switch (type) {
            case 256:
            case 512:
            case 1024:
                return RingtoneManager.getActualDefaultRingtoneUri(context, 2);
            case 2048:
            case 4096:
                return RingtoneManager.getActualDefaultRingtoneUri(context, 1);
            default:
                return null;
        }
    }

    private static String getSetFlagForType(int type) {
        switch (type) {
            case 256:
                return StepOSSettingsKeys.SYSTEM_MMS_SOUND_SET_FLAG;
            case 512:
                return StepOSSettingsKeys.SYSTEM_EMAIL_SOUND_SET_FLAG;
            case 1024:
                return StepOSSettingsKeys.SYSTEM_CALENDAR_SOUND_SET_FLAG;
            case 2048:
                return StepOSSettingsKeys.SYSTEM_RINGTONE_SOUND_PHONE_1_SET_FLAG;
            case 4096:
                return StepOSSettingsKeys.SYSTEM_RINGTONE_SOUND_PHONE_2_SET_FLAG;
            default:
                return null;
        }
    }

    private static boolean isSet(Context context, String flagKey) {
        return (flagKey == null || Settings.System.getInt(context.getContentResolver(), flagKey, 0) == 0) ? false : true;
    }

    private static int inferStreamType(int type) {
        switch (type) {
            case 256:
            case 512:
            case 1024:
                break;
            case 2048:
            case 4096:
                break;
        }
        return 2;
    }

    private static boolean isInternalRingtoneUri(Uri uri) {
        if (uri == null) {
            return false;
        }
        return ContentProvider.getUriWithoutUserId(uri).toString().startsWith(MediaStore.Audio.Media.INTERNAL_CONTENT_URI.toString());
    }

    private static boolean isUserUnlocked(Context context) {
        return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
    }

    public void onLocalPlaybackSkipped(Object token, final MediaPlayer player, boolean looping, final MediaPlayer.OnCompletionListener listener) {
        int duration;
        cancelSkippedPlaybackCompletion(token);
        if (token == null || player == null || listener == null || looping) {
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            Log.w(TAG, "No main looper, cannot report completion of skipped playback");
            return;
        }
        try {
            duration = player.getDuration();
        } catch (IllegalStateException e) {
            Log.w(TAG, "Could not read duration of skipped playback", e);
            duration = 0;
        }
        Log.d(TAG, "Playback skipped on muted stream, reporting completion in " + duration + "ms");
        if (this.mSkippedCompletionHandler == null) {
            this.mSkippedCompletionHandler = new Handler(mainLooper);
        }
        this.mSkippedCompletionHandler.postDelayed(new Runnable() { // from class: android.media.StepOSRingtoneManagerImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                listener.onCompletion(player);
            }
        }, token, Math.max(duration, 0));
    }

    public void cancelSkippedPlaybackCompletion(Object token) {
        if (this.mSkippedCompletionHandler != null && token != null) {
            this.mSkippedCompletionHandler.removeCallbacksAndMessages(token);
        }
    }
}

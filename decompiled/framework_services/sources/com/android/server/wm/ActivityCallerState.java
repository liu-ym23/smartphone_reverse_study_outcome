package com.android.server.wm;

import android.content.ClipData;
import android.content.ContentProvider;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.os.UserHandle;
import android.util.ArraySet;
import android.util.Slog;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.uri.GrantUri;
import java.io.IOException;
import java.util.ArrayList;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
final class ActivityCallerState {
    private static final String ATTR_CALLER_IS_SHARE_ENABLED = "caller_is_share_enabled";
    private static final String ATTR_CALLER_PACKAGE = "caller_package";
    private static final String ATTR_CALLER_UID = "caller_uid";
    private static final String ATTR_PREFIX = "prefix";
    private static final String ATTR_SOURCE_USER_ID = "source_user_id";
    private static final String ATTR_URI = "uri";
    private static final String TAG = "ActivityTaskManager";
    private static final String TAG_INACCESSIBLE_CONTENT_URI = "inaccessible_content_uri";
    private static final String TAG_READABLE_CONTENT_URI = "readable_content_uri";
    private static final String TAG_WRITABLE_CONTENT_URI = "writable_content_uri";
    final ActivityTaskManagerService mAtmService;
    private final WeakHashMap<IBinder, CallerInfo> mCallerTokenInfoMap;

    public static final class CallerInfo {
        final ArraySet<GrantUri> mInaccessibleContentUris;
        final boolean mIsShareIdentityEnabled;
        final String mPackageName;
        final ArraySet<GrantUri> mReadableContentUris;
        final int mUid;
        final ArraySet<GrantUri> mWritableContentUris;

        CallerInfo(int uid, String packageName, boolean isShareIdentityEnabled) {
            this.mReadableContentUris = new ArraySet();
            this.mWritableContentUris = new ArraySet();
            this.mInaccessibleContentUris = new ArraySet();
            this.mUid = uid;
            this.mPackageName = packageName;
            this.mIsShareIdentityEnabled = isShareIdentityEnabled;
        }

        public void saveToXml(TypedXmlSerializer out) throws IOException, XmlPullParserException {
            out.attributeInt(null, ActivityCallerState.ATTR_CALLER_UID, this.mUid);
            if (this.mPackageName == null) goto L5;
            out.attribute(null, ActivityCallerState.ATTR_CALLER_PACKAGE, this.mPackageName);
        L5:
            out.attributeBoolean(null, ActivityCallerState.ATTR_CALLER_IS_SHARE_ENABLED, this.mIsShareIdentityEnabled);
            int i = this.mReadableContentUris.size() - 1;
        L6:
            if (i < 0) goto L8;
            saveGrantUriToXml(out, this.mReadableContentUris.valueAt(i), ActivityCallerState.TAG_READABLE_CONTENT_URI);
            i = i - 1;
            goto L6
        L8:
            int i2 = this.mWritableContentUris.size() - 1;
        L9:
            if (i2 < 0) goto L11;
            saveGrantUriToXml(out, this.mWritableContentUris.valueAt(i2), ActivityCallerState.TAG_WRITABLE_CONTENT_URI);
            i2 = i2 - 1;
            goto L9
        L11:
            int i3 = this.mInaccessibleContentUris.size() - 1;
        L12:
            if (i3 < 0) goto L15;
            saveGrantUriToXml(out, this.mInaccessibleContentUris.valueAt(i3), ActivityCallerState.TAG_INACCESSIBLE_CONTENT_URI);
            i3 = i3 - 1;
            goto L12
        }

        public static CallerInfo restoreFromXml(TypedXmlPullParser in) throws IOException, XmlPullParserException {
            int uid = in.getAttributeInt(null, ActivityCallerState.ATTR_CALLER_UID, 0);
            String packageName = in.getAttributeValue(null, ActivityCallerState.ATTR_CALLER_PACKAGE);
            boolean isShareIdentityEnabled = in.getAttributeBoolean(null, ActivityCallerState.ATTR_CALLER_IS_SHARE_ENABLED, false);
            CallerInfo callerInfo = new CallerInfo(uid, packageName, isShareIdentityEnabled);
            int outerDepth = in.getDepth();
        L3:
            int event = in.next();
            if (event == 1) goto L22;
            if (event != 3) goto L10;
            if (in.getDepth() < outerDepth) goto L22;
        L10:
            if (event != 2) goto L3;
            String name = in.getName();
            if (ActivityCallerState.TAG_READABLE_CONTENT_URI.equals(name) == true) goto L13;
            if (ActivityCallerState.TAG_WRITABLE_CONTENT_URI.equals(name) == true) goto L16;
            if (ActivityCallerState.TAG_INACCESSIBLE_CONTENT_URI.equals(name) == true) goto L19;
            Slog.w(ActivityCallerState.TAG, "restoreActivity: unexpected name=" + name);
            XmlUtils.skipCurrentTag(in);
            goto L3
        L19:
            callerInfo.mInaccessibleContentUris.add(restoreGrantUriFromXml(in));
            goto L3
        L16:
            callerInfo.mWritableContentUris.add(restoreGrantUriFromXml(in));
            goto L3
        L13:
            callerInfo.mReadableContentUris.add(restoreGrantUriFromXml(in));
        L22:
            return callerInfo;
        }

        private void saveGrantUriToXml(TypedXmlSerializer out, GrantUri grantUri, String tag) throws IOException, XmlPullParserException {
            out.startTag(null, tag);
            out.attributeInt(null, ActivityCallerState.ATTR_SOURCE_USER_ID, grantUri.sourceUserId);
            out.attribute(null, ActivityCallerState.ATTR_URI, String.valueOf(grantUri.uri));
            out.attributeBoolean(null, ActivityCallerState.ATTR_PREFIX, grantUri.prefix);
            out.endTag(null, tag);
        }

        private static GrantUri restoreGrantUriFromXml(TypedXmlPullParser in) throws IOException, XmlPullParserException {
            int r2 = 0;
            int sourceUserId = in.getAttributeInt(null, ActivityCallerState.ATTR_SOURCE_USER_ID, 0);
            Uri uri = Uri.parse(in.getAttributeValue(null, ActivityCallerState.ATTR_URI));
            boolean prefix = in.getAttributeBoolean(null, ActivityCallerState.ATTR_PREFIX, false);
            if (prefix == false) goto L6;
            r2 = 128;
        L6:
            return new GrantUri(sourceUserId, uri, r2);
        }
    }

    ActivityCallerState(ActivityTaskManagerService service) {
        this.mCallerTokenInfoMap = new WeakHashMap();
        this.mAtmService = service;
    }

    CallerInfo getCallerInfoOrNull(IBinder callerToken) {
        return this.mCallerTokenInfoMap.getOrDefault(callerToken, null);
    }

    boolean hasCaller(IBinder callerToken) {
        if (getCallerInfoOrNull(callerToken) == null) goto L5;
        return true;
    L5:
        return false;
    }

    int getUid(IBinder callerToken) {
        CallerInfo callerInfo = getCallerInfoOrNull(callerToken);
        if (callerInfo != null) goto L7;
        return -1;
    L7:
        return callerInfo.mUid;
    }

    String getPackage(IBinder callerToken) {
        CallerInfo callerInfo = getCallerInfoOrNull(callerToken);
        if (callerInfo != null) goto L7;
        return null;
    L7:
        return callerInfo.mPackageName;
    }

    boolean isShareIdentityEnabled(IBinder callerToken) {
        CallerInfo callerInfo = getCallerInfoOrNull(callerToken);
        if (callerInfo != null) goto L7;
        return false;
    L7:
        return callerInfo.mIsShareIdentityEnabled;
    }

    void add(IBinder callerToken, CallerInfo callerInfo) {
        this.mCallerTokenInfoMap.put(callerToken, callerInfo);
    }

    void computeCallerInfo(IBinder callerToken, Intent intent, int callerUid, String callerPackageName, boolean isCallerShareIdentityEnabled) {
        CallerInfo callerInfo = new CallerInfo(callerUid, callerPackageName, isCallerShareIdentityEnabled);
        this.mCallerTokenInfoMap.put(callerToken, callerInfo);
        ArraySet<Uri> contentUris = getContentUrisFromIntent(intent);
        int i = contentUris.size() - 1;
    L3:
        if (i < 0) goto L10;
        Uri contentUri = contentUris.valueAt(i);
        boolean hasRead = addContentUriIfUidHasPermission(contentUri, callerUid, 1, callerInfo.mReadableContentUris);
        boolean hasWrite = addContentUriIfUidHasPermission(contentUri, callerUid, 2, callerInfo.mWritableContentUris);
        if (hasRead == true) goto L8;
        if (hasWrite == true) goto L8;
        callerInfo.mInaccessibleContentUris.add(convertToGrantUri(contentUri, 0, callerUid));
    L8:
        i = i - 1;
        goto L3
    }

    boolean checkContentUriPermission(IBinder callerToken, GrantUri grantUri, int modeFlags) {
        if (Intent.isAccessUriMode(modeFlags) == false) goto L33;
        CallerInfo callerInfo = this.mCallerTokenInfoMap.getOrDefault(callerToken, null);
        if (callerInfo != null) goto L9;
        Slog.e(TAG, "Caller not found for checkContentUriPermission of: " + grantUri.uri.toSafeString());
        return false;
    L9:
        if (callerInfo.mInaccessibleContentUris.contains(grantUri) == false) goto L11;
        return false;
    L11:
        boolean readMet = callerInfo.mReadableContentUris.contains(grantUri);
        boolean writeMet = callerInfo.mWritableContentUris.contains(grantUri);
        if (readMet == true) goto L18;
        if (writeMet == true) goto L18;
        throw new IllegalArgumentException("The supplied URI wasn't passed at launch in #getData, #EXTRA_STREAM, nor #getClipData: " + grantUri.uri.toSafeString());
    L18:
        if ((modeFlags & 1) == 0) goto L20;
        boolean checkRead = true;
    L21:
        if (checkRead == false) goto L25;
        if (readMet == true) goto L25;
        return false;
    L25:
        if ((modeFlags & 2) == 0) goto L27;
        boolean checkWrite = true;
    L28:
        if (checkWrite == false) goto L31;
        if (writeMet == true) goto L31;
        return false;
    L31:
        return true;
    L27:
        checkWrite = false;
        goto L28
    L20:
        checkRead = false;
        goto L21
    L33:
        throw new IllegalArgumentException("Mode flags are not access URI mode flags: " + modeFlags);
    }

    private boolean addContentUriIfUidHasPermission(Uri contentUri, int uid, int modeFlags, ArraySet<GrantUri> grantUris) {
        GrantUri grantUri = convertToGrantUri(contentUri, modeFlags, uid);
        if (this.mAtmService.mUgmInternal.checkUriPermission(grantUri, uid, modeFlags, true) == false) goto L6;
        grantUris.add(grantUri);
        return true;
    L6:
        return false;
    }

    private static GrantUri convertToGrantUri(Uri contentUri, int modeFlags, int uid) {
        return new GrantUri(ContentProvider.getUserIdFromUri(contentUri, UserHandle.getUserId(uid)), ContentProvider.getUriWithoutUserId(contentUri), modeFlags);
    }

    private static ArraySet<Uri> getContentUrisFromIntent(Intent intent) {
        ArraySet<Uri> uris = new ArraySet();
        if (intent != null) goto L5;
        return uris;
    L5:
        addUriIfContentUri(intent.getData(), uris);
        if (intent.hasExtra("android.intent.extra.STREAM") == false) goto L13;
        ArrayList<Uri> streams = tryToUnparcelArrayListExtraStreamsUri(intent);
        if (streams != null) goto L10;
        addUriIfContentUri(tryToUnparcelExtraStreamUri(intent), uris);
        goto L13
    L10:
        int i = streams.size() - 1;
    L11:
        if (i < 0) goto L13;
        addUriIfContentUri(streams.get(i), uris);
        i = i - 1;
    L13:
        ClipData clipData = intent.getClipData();
        if (clipData != null) goto L16;
        return uris;
    L16:
        int i2 = 0;
    L18:
        if (i2 >= clipData.getItemCount()) goto L21;
        ClipData.Item item = clipData.getItemAt(i2);
        addUriIfContentUri(item.getUri(), uris);
        uris.addAll(getContentUrisFromIntent(item.getIntent()));
        i2 = i2 + 1;
        goto L18
    L21:
        return uris;
    }

    private static Uri tryToUnparcelExtraStreamUri(Intent intent) {
        return (Uri) intent.getParcelableExtra("android.intent.extra.STREAM", Uri.class);
    L4:
        e = move-exception;
        Slog.w(TAG, "Failed to unparcel an URI in EXTRA_STREAM, returning null: " + e);
        return null;
    }

    private static ArrayList<Uri> tryToUnparcelArrayListExtraStreamsUri(Intent intent) {
        return intent.getParcelableArrayListExtra("android.intent.extra.STREAM", Uri.class);
    L4:
        e = move-exception;
        Slog.w(TAG, "Failed to unparcel an ArrayList of URIs in EXTRA_STREAM, returning null: " + e);
        return null;
    }

    private static void addUriIfContentUri(Uri uri, ArraySet<Uri> uris) {
        if (uri != null) goto L4;
        return;
    L4:
        if (ActivityTaskManagerInternal.ASSIST_KEY_CONTENT.equals(uri.getScheme()) == false) goto L8;
        uris.add(uri);
        return;
    }
}

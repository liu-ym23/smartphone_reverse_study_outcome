package com.android.server.media.quality;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.audio.effect.DefaultExtension;
import android.hardware.tv.mediaquality.AmbientBacklightColorFormat;
import android.hardware.tv.mediaquality.AmbientBacklightMetadata;
import android.hardware.tv.mediaquality.IMediaQuality;
import android.hardware.tv.mediaquality.IMediaQualityCallback;
import android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener;
import android.hardware.tv.mediaquality.IPictureProfileChangedListener;
import android.hardware.tv.mediaquality.ISoundProfileAdjustmentListener;
import android.hardware.tv.mediaquality.ISoundProfileChangedListener;
import android.hardware.tv.mediaquality.ParamCapability;
import android.hardware.tv.mediaquality.PictureParameter;
import android.hardware.tv.mediaquality.PictureParameters;
import android.hardware.tv.mediaquality.SoundParameter;
import android.hardware.tv.mediaquality.SoundParameters;
import android.hardware.tv.mediaquality.VendorParamCapability;
import android.media.quality.ActiveProcessingPicture;
import android.media.quality.AmbientBacklightEvent;
import android.media.quality.AmbientBacklightSettings;
import android.media.quality.IActiveProcessingPictureListener;
import android.media.quality.IAmbientBacklightCallback;
import android.media.quality.IMediaQualityManager;
import android.media.quality.IPictureProfileCallback;
import android.media.quality.ISoundProfileCallback;
import android.media.quality.ParameterCapability;
import android.media.quality.PictureProfile;
import android.media.quality.PictureProfileHandle;
import android.media.quality.SoundProfile;
import android.media.quality.SoundProfileHandle;
import android.os.Binder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.PersistableBundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.view.SurfaceControlActivePicture;
import android.view.SurfaceControlActivePictureListener;
import com.android.server.SystemService;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.utils.Slogf;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public class MediaQualityService extends SystemService {
    private static final String ALLOWLIST = "allowlist";
    private static final String COMMA_DELIMITER = ",";
    private static final boolean DEBUG = false;
    private static final String PICTURE_PROFILE_PREFERENCE = "picture_profile_preference";
    private static final String SOUND_PROFILE_PREFERENCE = "sound_profile_preference";
    private static final String TAG = "MediaQualityService";
    private final Object mAmbientBacklightLock;
    private final Map<String, AmbientBacklightCallbackRecord> mCallbackRecords;
    private final Context mContext;
    private final BiMap<Long, Long> mCurrentPictureHandleToOriginal;
    private final HalAmbientBacklightCallback mHalAmbientBacklightCallback;
    private HalNotifier mHalNotifier;
    private final Map<Long, PictureProfile> mHandleToPictureProfile;
    private Handler mHandler;
    private IMediaQuality mMediaQuality;
    private final MediaQualityDbHelper mMediaQualityDbHelper;
    private MqDatabaseUtils mMqDatabaseUtils;
    private MqManagerNotifier mMqManagerNotifier;
    private final Map<String, Long> mPackageDefaultPictureProfileHandleMap;
    private final PackageManager mPackageManager;
    private PictureProfileAdjustmentListenerImpl mPictureProfileAdjListener;
    private final Object mPictureProfileLock;
    private SharedPreferences mPictureProfileSharedPreference;
    private final BiMap<Long, String> mPictureProfileTempIdMap;
    private IPictureProfileChangedListener mPpChangedListener;
    private SoundProfileAdjustmentListenerImpl mSoundProfileAdjListener;
    private final Object mSoundProfileLock;
    private SharedPreferences mSoundProfileSharedPreference;
    private final BiMap<Long, String> mSoundProfileTempIdMap;
    private ISoundProfileChangedListener mSpChangedListener;
    private SurfaceControlActivePictureListener mSurfaceControlActivePictureListener;
    private final Object mUserStateLock;
    private final SparseArray<UserState> mUserStates;

    private class ActiveProcessingPictureCallbackList extends RemoteCallbackList<IActiveProcessingPictureListener> {
        final /* synthetic */ MediaQualityService this$0;

        /* synthetic */ ActiveProcessingPictureCallbackList(MediaQualityService r1, MediaQualityServiceIA r2) {
            this(r1);
        }

        private ActiveProcessingPictureCallbackList(MediaQualityService r1) {
            this.this$0 = r1;
        }

        @Override // android.os.RemoteCallbackList
        public /* bridge */ /* synthetic */ void onCallbackDied(IInterface r1) {
            onCallbackDied((IActiveProcessingPictureListener) r1);
        }

        public void onCallbackDied(IActiveProcessingPictureListener l) {
            Object r0 = MediaQualityService.m5854$$Nest$fgetmPictureProfileLock(this.this$0);
            monitor-enter(r0);
            int i = 0;
        L15:
        L8:
            th = move-exception;
            throw th;
        L6:
            if (i >= MediaQualityService.m5862$$Nest$fgetmUserStates(this.this$0).size()) goto L11;
            int userId = MediaQualityService.m5862$$Nest$fgetmUserStates(this.this$0).keyAt(i);     // Catch: Throwable -> L8
            UserState userState = MediaQualityService.m5863$$Nest$mgetOrCreateUserState(this.this$0, userId);     // Catch: Throwable -> L8
            UserState.m5893$$Nest$fgetmActiveProcessingPictureListenerMap(userState).remove(l);     // Catch: Throwable -> L8
            i = i + 1;     // Catch: Throwable -> L8
            goto L15
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L8
        }
    }

    private final class ActiveProcessingPictureListenerInfo {
        private String mPackageName;
        private int mPid;
        private int mUid;

        /* JADX INFO: renamed from: -$$Nest$fgetmPid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m5868$$Nest$fgetmPid(ActiveProcessingPictureListenerInfo r0) {
            return r0.mPid;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m5869$$Nest$fgetmUid(ActiveProcessingPictureListenerInfo r0) {
            return r0.mUid;
        }

        ActiveProcessingPictureListenerInfo(MediaQualityService r1, int uid, int pid, String packageName) {
            this.mUid = uid;
            this.mPid = pid;
            this.mPackageName = packageName;
        }
    }

    private final class AmbientBacklightCallbackRecord implements IBinder.DeathRecipient {
        final IAmbientBacklightCallback mCallback;
        final String mPackageName;
        final /* synthetic */ MediaQualityService this$0;

        AmbientBacklightCallbackRecord(MediaQualityService r3, String pkgName, IAmbientBacklightCallback cb) {
            this.this$0 = r3;
            this.mPackageName = pkgName;
            this.mCallback = cb;
            this.mCallback.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.e(MediaQualityService.TAG, "Failed to link to death", e);
        }

        void release() {
            this.mCallback.asBinder().unlinkToDeath(this, 0);     // Catch: NoSuchElementException -> L4
            return;
        L4:
            e = move-exception;
            Slog.e(MediaQualityService.TAG, "Failed to unlink to death", e);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Map r0 = MediaQualityService.m5841$$Nest$fgetmCallbackRecords(this.this$0);
            monitor-enter(r0);
            MediaQualityService.m5841$$Nest$fgetmCallbackRecords(this.this$0).remove(this.mPackageName);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private final class BinderService extends IMediaQualityManager.Stub {
        final /* synthetic */ MediaQualityService this$0;

        public static /* synthetic */ void $r8$lambda$3BOZ1m5IOgjfAwaLKmmUAxLDfNA(BinderService r0, boolean r1) {
            r0.lambda$setSuperResolutionEnabled$9(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$6Jl4LU_IDMKH-Y2IS1vE7aJoZtU, reason: not valid java name */
        public static /* synthetic */ void m5870$r8$lambda$6Jl4LU_IDMKHY2IS1vE7aJoZtU(BinderService r0, String r1) {
            r0.lambda$removeSoundProfile$5(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$9W6Ea2aO9aVOqh_m-F6O454YrJs, reason: not valid java name */
        public static /* synthetic */ void m5871$r8$lambda$9W6Ea2aO9aVOqh_mF6O454YrJs(BinderService r0, String r1) {
            r0.lambda$removePictureProfile$2(r1);
        }

        public static /* synthetic */ void $r8$lambda$BcS_KZxAMxZghtaMYpP1IBsrRzM(BinderService r0, List r1) {
            r0.lambda$setSoundProfileAllowList$7(r1);
        }

        public static /* synthetic */ void $r8$lambda$BioHXLslaDYXkOxV_Nf_dqvNVTM(BinderService r0, SoundProfile r1) {
            r0.lambda$createSoundProfile$3(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$ELtWD0g-bkBCZrMQSIwJcVub4VI, reason: not valid java name */
        public static /* synthetic */ void m5872$r8$lambda$ELtWD0gbkBCZrMQSIwJcVub4VI(BinderService r0, boolean r1) {
            r0.lambda$setAutoPictureQualityEnabled$8(r1);
        }

        public static /* synthetic */ void $r8$lambda$NEEhBlKOS0hKcMyUqylZYEkMH74(BinderService r0, String r1, SoundProfile r2) {
            r0.lambda$updateSoundProfile$4(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$lkyQAVm9D1cFC9e587tBDup9_QI(BinderService r0, boolean r1) {
            r0.lambda$setAutoSoundQualityEnabled$10(r1);
        }

        public static /* synthetic */ void $r8$lambda$oEI3bkIiBng7ZNtWxZcS2xyccM8(BinderService r0, String r1, PictureProfile r2) {
            r0.lambda$updatePictureProfile$1(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$uHkse-zuKFzcjht-iekkBq_FX6w, reason: not valid java name */
        public static /* synthetic */ void m5873$r8$lambda$uHksezuKFzcjhtiekkBq_FX6w(BinderService r0, List r1) {
            r0.lambda$setPictureProfileAllowList$6(r1);
        }

        public static /* synthetic */ void $r8$lambda$zF_A4d8t4DYQTUMNJ6Otwdl1apk(BinderService r0, PictureProfile r1) {
            r0.lambda$createPictureProfile$0(r1);
        }

        /* synthetic */ BinderService(MediaQualityService r1, MediaQualityServiceIA r2) {
            this(r1);
        }

        private BinderService(MediaQualityService r1) {
            this.this$0 = r1;
        }

        public void createPictureProfile(final PictureProfile pp, int userId) {
            MediaQualityService.m5847$$Nest$fgetmHandler(this.this$0).post(new MediaQualityService$BinderService$$ExternalSyntheticLambda0(this, pp));
        }

        private /* synthetic */ void lambda$createPictureProfile$0(PictureProfile pp) {
            if (pp.getPackageName() != null) goto L5;
        L11:
            Object r2 = MediaQualityService.m5854$$Nest$fgetmPictureProfileLock(this.this$0);
            monitor-enter(r2);
            SQLiteDatabase db = MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0).getWritableDatabase();     // Catch: Throwable -> L20
            Integer r5 = Integer.valueOf(pp.getProfileType());     // Catch: Throwable -> L20
            String r6 = pp.getName();     // Catch: Throwable -> L20
            if (pp.getPackageName() == null) goto L22;
            if (pp.getPackageName().isEmpty() == true) goto L22;
            String r3 = pp.getPackageName();     // Catch: Throwable -> L20
        L19:
            String r7 = r3;
            ContentValues values = MediaQualityUtils.getContentValues(null, r5, r6, r7, pp.getInputId(), pp.getParameters());     // Catch: Throwable -> L20
            MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0);     // Catch: Throwable -> L20
            Long id = Long.valueOf(db.insert(MediaQualityDbHelper.PICTURE_QUALITY_TABLE_NAME, null, values));     // Catch: Throwable -> L20
            MediaQualityUtils.populateTempIdMap(MediaQualityService.m5856$$Nest$fgetmPictureProfileTempIdMap(this.this$0), id);     // Catch: Throwable -> L20
            String value = (String) MediaQualityService.m5856$$Nest$fgetmPictureProfileTempIdMap(this.this$0).getValue(id);     // Catch: Throwable -> L20
            pp.setProfileId(value);     // Catch: Throwable -> L20
            MqManagerNotifier.m5881$$Nest$mnotifyOnPictureProfileAdded(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), value, pp, Binder.getCallingUid(), Binder.getCallingPid());     // Catch: Throwable -> L20
            if (MediaQualityService.m5865$$Nest$misPackageDefaultPictureProfile(this.this$0, pp) == false) goto L26;
            MediaQualityService.m5852$$Nest$fgetmPackageDefaultPictureProfileHandleMap(this.this$0).put(pp.getPackageName(), Long.valueOf(pp.getHandle().getId()));     // Catch: Throwable -> L20
        L26:
            monitor-exit(r2);     // Catch: Throwable -> L20
            return;
        L22:
            r3 = getPackageOfCallingUid();     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            throw th;
        L5:
            if (pp.getPackageName().isEmpty() == true) goto L11;
            if (incomingPackageEqualsCallingUidPackage(pp.getPackageName()) == true) goto L11;
            if (hasGlobalPictureQualityServicePermission() == true) goto L11;
            MqManagerNotifier.m5882$$Nest$mnotifyOnPictureProfileError(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), null, 1, Binder.getCallingUid(), Binder.getCallingPid());
            goto L11
        }

        public void updatePictureProfile(final String id, final PictureProfile pp, int userId) {
            MediaQualityService.m5847$$Nest$fgetmHandler(this.this$0).post(new MediaQualityService$BinderService$$ExternalSyntheticLambda8(this, id, pp));
        }

        private /* synthetic */ void lambda$updatePictureProfile$1(String id, PictureProfile pp) {
            Long dbId = (Long) MediaQualityService.m5856$$Nest$fgetmPictureProfileTempIdMap(this.this$0).getKey(id);
            if (hasPermissionToUpdatePictureProfile(dbId, pp) == true) goto L5;
            MqManagerNotifier.m5882$$Nest$mnotifyOnPictureProfileError(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), id, 1, Binder.getCallingUid(), Binder.getCallingPid());
        L5:
            Object r7 = MediaQualityService.m5854$$Nest$fgetmPictureProfileLock(this.this$0);
            monitor-enter(r7);
            ContentValues values = MediaQualityUtils.getContentValues(dbId, Integer.valueOf(pp.getProfileType()), pp.getName(), pp.getPackageName(), pp.getInputId(), pp.getParameters());     // Catch: Throwable -> L10
            this.this$0.updateDatabaseOnPictureProfileAndNotifyManagerAndHal(values, pp.getParameters());     // Catch: Throwable -> L10
            if (MediaQualityService.m5865$$Nest$misPackageDefaultPictureProfile(this.this$0, pp) == false) goto L12;
            MediaQualityService.m5852$$Nest$fgetmPackageDefaultPictureProfileHandleMap(this.this$0).put(pp.getPackageName(), Long.valueOf(pp.getHandle().getId()));     // Catch: Throwable -> L10
        L12:
            monitor-exit(r7);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        private boolean hasPermissionToUpdatePictureProfile(Long dbId, PictureProfile toUpdate) {
            PictureProfile fromDb = MqDatabaseUtils.m5877$$Nest$mgetPictureProfile(MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0), dbId);
            if (fromDb.getProfileType() == toUpdate.getProfileType()) goto L5;
        L11:
            return false;
        L5:
            if (fromDb.getPackageName().equals(toUpdate.getPackageName()) == false) goto L11;
            if (fromDb.getName().equals(toUpdate.getName()) == false) goto L11;
            if (fromDb.getName().equals(getPackageOfCallingUid()) == false) goto L11;
            return true;
        }

        public void removePictureProfile(final String id, int userId) {
            MediaQualityService.m5847$$Nest$fgetmHandler(this.this$0).post(new MediaQualityService$BinderService$$ExternalSyntheticLambda12(this, id));
        }

        private /* synthetic */ void lambda$removePictureProfile$2(String id) {
            Object r0 = MediaQualityService.m5854$$Nest$fgetmPictureProfileLock(this.this$0);
            monitor-enter(r0);
            Long dbId = (Long) MediaQualityService.m5856$$Nest$fgetmPictureProfileTempIdMap(this.this$0).getKey(id);     // Catch: Throwable -> L7
            PictureProfile toDelete = MqDatabaseUtils.m5877$$Nest$mgetPictureProfile(MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0), dbId);     // Catch: Throwable -> L7
            if (hasPermissionToRemovePictureProfile(toDelete) == true) goto L9;
            MqManagerNotifier.m5882$$Nest$mnotifyOnPictureProfileError(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), id, 1, Binder.getCallingUid(), Binder.getCallingPid());     // Catch: Throwable -> L7
        L9:
            if (dbId == null) goto L15;
            SQLiteDatabase db = MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0).getWritableDatabase();     // Catch: Throwable -> L7
            String[] selectionArgs = {Long.toString(dbId.longValue())};     // Catch: Throwable -> L7
            MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0);     // Catch: Throwable -> L7
            int result = db.delete(MediaQualityDbHelper.PICTURE_QUALITY_TABLE_NAME, "_id = ?", selectionArgs);     // Catch: Throwable -> L7
            if (result != 0) goto L13;
            MqManagerNotifier.m5882$$Nest$mnotifyOnPictureProfileError(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), id, 3, Binder.getCallingUid(), Binder.getCallingPid());     // Catch: Throwable -> L7
            goto L15
        L13:
            MqManagerNotifier.m5884$$Nest$mnotifyOnPictureProfileRemoved(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), (String) MediaQualityService.m5856$$Nest$fgetmPictureProfileTempIdMap(this.this$0).getValue(dbId), toDelete, Binder.getCallingUid(), Binder.getCallingPid());     // Catch: Throwable -> L7
            MediaQualityService.m5856$$Nest$fgetmPictureProfileTempIdMap(this.this$0).remove(dbId);     // Catch: Throwable -> L7
            HalNotifier.m5874$$Nest$mnotifyHalOnPictureProfileChange(MediaQualityService.m5845$$Nest$fgetmHalNotifier(this.this$0), dbId, null);     // Catch: Throwable -> L7
        L15:
            if (MediaQualityService.m5865$$Nest$misPackageDefaultPictureProfile(this.this$0, toDelete) == false) goto L17;
            MediaQualityService.m5852$$Nest$fgetmPackageDefaultPictureProfileHandleMap(this.this$0).remove(toDelete.getPackageName());     // Catch: Throwable -> L7
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private boolean hasPermissionToRemovePictureProfile(PictureProfile toDelete) {
            if (toDelete != null) goto L4;
            return false;
        L4:
            return toDelete.getName().equalsIgnoreCase(getPackageOfCallingUid());
        }

        public PictureProfile getPictureProfile(int type, String name, boolean includeParams, int userId) {
            String[] selectionArguments = {Integer.toString(type), name, getPackageOfCallingUid()};
            Object r3 = MediaQualityService.m5854$$Nest$fgetmPictureProfileLock(this.this$0);
            monitor-enter(r3);
            MqDatabaseUtils r0 = MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0);     // Catch: Throwable -> L12
            MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0);     // Catch: Throwable -> L12
            Cursor cursor = MqDatabaseUtils.m5876$$Nest$mgetCursorAfterQuerying(r0, MediaQualityDbHelper.PICTURE_QUALITY_TABLE_NAME, MediaQualityUtils.getMediaProfileColumns(includeParams), "_type = ? AND _name = ? AND _package = ?", selectionArguments);     // Catch: Throwable -> L12
            int count = cursor.getCount();     // Catch: Throwable -> L20
            if (count != 0) goto L15;
            cursor.close();     // Catch: Throwable -> L12
            monitor-exit(r3);     // Catch: Throwable -> L12
            return null;
        L15:
            if (count <= 1) goto L22;
            String r7 = String.valueOf(Locale.US);     // Catch: Throwable -> L20
            Integer r9 = Integer.valueOf(count);     // Catch: Throwable -> L20
            Integer r10 = Integer.valueOf(type);     // Catch: Throwable -> L20
            MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0);     // Catch: Throwable -> L20
            Log.wtf(MediaQualityService.TAG, TextUtils.formatSimple(r7, new Object[]{"%d entries found for type=%d and name=%s in %s. Should only ever be 0 or 1.", r9, r10, name, MediaQualityDbHelper.PICTURE_QUALITY_TABLE_NAME}));     // Catch: Throwable -> L20
            cursor.close();     // Catch: Throwable -> L12
            monitor-exit(r3);     // Catch: Throwable -> L12
            return null;
        L22:
            cursor.moveToFirst();     // Catch: Throwable -> L20
            PictureProfile r5 = MediaQualityUtils.convertCursorToPictureProfileWithTempId(cursor, MediaQualityService.m5856$$Nest$fgetmPictureProfileTempIdMap(this.this$0));     // Catch: Throwable -> L20
            cursor.close();     // Catch: Throwable -> L12
            monitor-exit(r3);     // Catch: Throwable -> L12
            return r5;
        L20:
            th = move-exception;
            if (cursor == null) goto L39;
            cursor.close();     // Catch: Throwable -> L29
        L40:
            throw th;     // Catch: Throwable -> L12
        L29:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L39:
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        public List<PictureProfile> getPictureProfilesByPackage(String packageName, boolean includeParams, int userId) {
            if (hasGlobalPictureQualityServicePermission() == true) goto L5;
            MqManagerNotifier.m5882$$Nest$mnotifyOnPictureProfileError(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), null, 1, Binder.getCallingUid(), Binder.getCallingPid());
        L5:
            Object r0 = MediaQualityService.m5854$$Nest$fgetmPictureProfileLock(this.this$0);
            monitor-enter(r0);
            String[] selectionArguments = {packageName};     // Catch: Throwable -> L10
            List<PictureProfile> r3 = MqDatabaseUtils.m5878$$Nest$mgetPictureProfilesBasedOnConditions(MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0), MediaQualityUtils.getMediaProfileColumns(includeParams), "_package = ?", selectionArguments);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L10:
            th = move-exception;
            throw th;
        }

        public List<PictureProfile> getAvailablePictureProfiles(boolean includeParams, int userId) {
            String packageName = getPackageOfCallingUid();
            if (packageName == null) goto L7;
            return getPictureProfilesByPackage(packageName, includeParams, userId);
        L7:
            return new ArrayList();
        }

        public boolean setDefaultPictureProfile(String profileId, int userId) {
            if (hasGlobalPictureQualityServicePermission() == true) goto L5;
            MqManagerNotifier.m5882$$Nest$mnotifyOnPictureProfileError(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), profileId, 1, Binder.getCallingUid(), Binder.getCallingPid());
        L5:
            Long longId = (Long) MediaQualityService.m5856$$Nest$fgetmPictureProfileTempIdMap(this.this$0).getKey(profileId);
            if (longId != null) goto L8;
            return false;
        L8:
            PictureProfile pictureProfile = MqDatabaseUtils.m5877$$Nest$mgetPictureProfile(MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0), longId);
            PersistableBundle params = pictureProfile.getParameters();
        L13:
            e = move-exception;
            Slog.e(MediaQualityService.TAG, "Failed to set default picture profile", e);
        L17:
            return false;
        L10:
            if (MediaQualityService.m5848$$Nest$fgetmMediaQuality(this.this$0) == null) goto L17;
            PictureParameters pp = new PictureParameters();     // Catch: RemoteException -> L13
            params.putLong("_id", longId.longValue());     // Catch: RemoteException -> L13
            PictureParameter[] pictureParameters = MediaQualityUtils.convertPersistableBundleToPictureParameterList(params);     // Catch: RemoteException -> L13
            Parcel parcel = Parcel.obtain();     // Catch: RemoteException -> L13
            MediaQualityService.m5866$$Nest$msetVendorPictureParameters(this.this$0, pp, parcel, params);     // Catch: RemoteException -> L13
            pp.pictureParameters = pictureParameters;     // Catch: RemoteException -> L13
            MediaQualityService.m5848$$Nest$fgetmMediaQuality(this.this$0).sendDefaultPictureParameters(pp);     // Catch: RemoteException -> L13
            parcel.recycle();     // Catch: RemoteException -> L13
            return true;
        }

        public List<String> getPictureProfilePackageNames(int userId) {
            if (hasGlobalPictureQualityServicePermission() == true) goto L5;
            MqManagerNotifier.m5882$$Nest$mnotifyOnPictureProfileError(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), null, 1, Binder.getCallingUid(), Binder.getCallingPid());
        L5:
            String[] column = {"_package"};
            Object r2 = MediaQualityService.m5854$$Nest$fgetmPictureProfileLock(this.this$0);
            monitor-enter(r2);
            List<PictureProfile> pictureProfiles = MqDatabaseUtils.m5878$$Nest$mgetPictureProfilesBasedOnConditions(MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0), column, null, null);     // Catch: Throwable -> L10
            List<String> r3 = (List) pictureProfiles.stream().map(new MediaQualityService$BinderService$$ExternalSyntheticLambda4()).distinct().collect(Collectors.toList());     // Catch: Throwable -> L10
            monitor-exit(r2);     // Catch: Throwable -> L10
            return r3;
        L10:
            th = move-exception;
            throw th;
        }

        public List<PictureProfileHandle> getPictureProfileHandle(String[] ids, int userId) {
            List<PictureProfileHandle> toReturn = new ArrayList();
            Object r1 = MediaQualityService.m5854$$Nest$fgetmPictureProfileLock(this.this$0);
            monitor-enter(r1);
            int r2 = ids.length;     // Catch: Throwable -> L9
            int r3 = 0;
        L5:
            if (r3 >= r2) goto L13;
            String id = ids[r3];     // Catch: Throwable -> L9
            Long key = (Long) MediaQualityService.m5856$$Nest$fgetmPictureProfileTempIdMap(this.this$0).getKey(id);     // Catch: Throwable -> L9
            if (key == null) goto L11;
            toReturn.add(new PictureProfileHandle(key.longValue()));     // Catch: Throwable -> L9
        L12:
            r3 = r3 + 1;     // Catch: Throwable -> L9
            goto L5
        L11:
            toReturn.add(null);     // Catch: Throwable -> L9
            goto L12
        L13:
            monitor-exit(r1);     // Catch: Throwable -> L9
            return toReturn;
        L9:
            th = move-exception;
            throw th;
        }

        public long getPictureProfileHandleValue(String id, int userId) {
            Object r0 = MediaQualityService.m5854$$Nest$fgetmPictureProfileLock(this.this$0);
            monitor-enter(r0);
            Long value = (Long) MediaQualityService.m5856$$Nest$fgetmPictureProfileTempIdMap(this.this$0).getKey(id);     // Catch: Throwable -> L7
            if (value == null) goto L9;
            long r2 = value.longValue();     // Catch: Throwable -> L7
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L9:
            r2 = -1;
        L7:
            th = move-exception;
            throw th;
        }

        public long getDefaultPictureProfileHandleValue(int userId) {
            Object r0 = MediaQualityService.m5854$$Nest$fgetmPictureProfileLock(this.this$0);
            monitor-enter(r0);
            String packageName = getPackageOfCallingUid();     // Catch: Throwable -> L7
            Long value = null;
            if (packageName == null) goto L9;
            value = (Long) MediaQualityService.m5852$$Nest$fgetmPackageDefaultPictureProfileHandleMap(this.this$0).get(packageName);     // Catch: Throwable -> L7
        L9:
            if (value == null) goto L11;
            long r3 = value.longValue();     // Catch: Throwable -> L7
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L11:
            r3 = -1;
        L7:
            th = move-exception;
            throw th;
        }

        public void notifyPictureProfileHandleSelection(long handle, int userId) {
            PictureProfile profile = MqDatabaseUtils.m5877$$Nest$mgetPictureProfile(MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0), Long.valueOf(handle));
            if (profile == null) goto L6;
            HalNotifier.m5874$$Nest$mnotifyHalOnPictureProfileChange(MediaQualityService.m5845$$Nest$fgetmHalNotifier(this.this$0), Long.valueOf(handle), profile.getParameters());
            return;
        }

        public long getPictureProfileForTvInput(String inputId, int userId) {
            if (hasGlobalPictureQualityServicePermission() == true) goto L5;
            MqManagerNotifier.m5882$$Nest$mnotifyOnPictureProfileError(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), null, 1, Binder.getCallingUid(), Binder.getCallingPid());
        L5:
            String[] columns = {"_id"};
            String[] selectionArguments = {Integer.toString(1), "default", inputId};
            Object r3 = MediaQualityService.m5854$$Nest$fgetmPictureProfileLock(this.this$0);
            monitor-enter(r3);
            MqDatabaseUtils r4 = MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0);     // Catch: Throwable -> L14
            MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0);     // Catch: Throwable -> L14
            Cursor cursor = MqDatabaseUtils.m5876$$Nest$mgetCursorAfterQuerying(r4, MediaQualityDbHelper.PICTURE_QUALITY_TABLE_NAME, columns, "_type = ? AND _name = ? AND _input_id = ?", selectionArguments);     // Catch: Throwable -> L14
            int count = cursor.getCount();     // Catch: Throwable -> L21
            if (count != 0) goto L16;
            cursor.close();     // Catch: Throwable -> L14
            monitor-exit(r3);     // Catch: Throwable -> L14
            return -1;
        L16:
            long handle = -1;
            cursor.moveToFirst();     // Catch: Throwable -> L21
            int colIndex = cursor.getColumnIndex("_id");     // Catch: Throwable -> L21
            if (colIndex == (-1)) goto L24;
            handle = cursor.getLong(colIndex);     // Catch: Throwable -> L21
            goto L24
        L24:
            cursor.close();     // Catch: Throwable -> L14
            monitor-exit(r3);     // Catch: Throwable -> L14
            return handle;
        L21:
            th = move-exception;
            if (cursor != null) goto L37;
        L33:
            throw th;     // Catch: Throwable -> L14
        L37:
            cursor.close();     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            throw th;
        }

        public List<SoundProfileHandle> getSoundProfileHandle(String[] ids, int userId) {
            List<SoundProfileHandle> toReturn = new ArrayList();
            Object r1 = MediaQualityService.m5858$$Nest$fgetmSoundProfileLock(this.this$0);
            monitor-enter(r1);
            int r2 = ids.length;     // Catch: Throwable -> L9
            int r3 = 0;
        L5:
            if (r3 >= r2) goto L13;
            String id = ids[r3];     // Catch: Throwable -> L9
            Long key = (Long) MediaQualityService.m5860$$Nest$fgetmSoundProfileTempIdMap(this.this$0).getKey(id);     // Catch: Throwable -> L9
            if (key == null) goto L11;
            toReturn.add(MediaQualityUtils.SOUND_PROFILE_HANDLE_NONE);     // Catch: Throwable -> L9
        L12:
            r3 = r3 + 1;     // Catch: Throwable -> L9
            goto L5
        L11:
            toReturn.add(null);     // Catch: Throwable -> L9
            goto L12
        L13:
            monitor-exit(r1);     // Catch: Throwable -> L9
            return toReturn;
        L9:
            th = move-exception;
            throw th;
        }

        public void createSoundProfile(final SoundProfile sp, int userId) {
            MediaQualityService.m5847$$Nest$fgetmHandler(this.this$0).post(new MediaQualityService$BinderService$$ExternalSyntheticLambda11(this, sp));
        }

        private /* synthetic */ void lambda$createSoundProfile$3(SoundProfile sp) {
            if (sp.getPackageName() != null) goto L5;
        L11:
            Object r2 = MediaQualityService.m5858$$Nest$fgetmSoundProfileLock(this.this$0);
            monitor-enter(r2);
            SQLiteDatabase db = MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0).getWritableDatabase();     // Catch: Throwable -> L20
            Integer r5 = Integer.valueOf(sp.getProfileType());     // Catch: Throwable -> L20
            String r6 = sp.getName();     // Catch: Throwable -> L20
            if (sp.getPackageName() == null) goto L22;
            if (sp.getPackageName().isEmpty() == true) goto L22;
            String r3 = sp.getPackageName();     // Catch: Throwable -> L20
        L19:
            String r7 = r3;
            ContentValues values = MediaQualityUtils.getContentValues(null, r5, r6, r7, sp.getInputId(), sp.getParameters());     // Catch: Throwable -> L20
            MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0);     // Catch: Throwable -> L20
            Long id = Long.valueOf(db.insert(MediaQualityDbHelper.SOUND_QUALITY_TABLE_NAME, null, values));     // Catch: Throwable -> L20
            MediaQualityUtils.populateTempIdMap(MediaQualityService.m5860$$Nest$fgetmSoundProfileTempIdMap(this.this$0), id);     // Catch: Throwable -> L20
            String value = (String) MediaQualityService.m5860$$Nest$fgetmSoundProfileTempIdMap(this.this$0).getValue(id);     // Catch: Throwable -> L20
            sp.setProfileId(value);     // Catch: Throwable -> L20
            MqManagerNotifier.m5886$$Nest$mnotifyOnSoundProfileAdded(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), value, sp, Binder.getCallingUid(), Binder.getCallingPid());     // Catch: Throwable -> L20
            monitor-exit(r2);     // Catch: Throwable -> L20
            return;
        L22:
            r3 = getPackageOfCallingUid();     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            throw th;
        L5:
            if (sp.getPackageName().isEmpty() == true) goto L11;
            if (incomingPackageEqualsCallingUidPackage(sp.getPackageName()) == true) goto L11;
            if (hasGlobalSoundQualityServicePermission() == true) goto L11;
            MqManagerNotifier.m5887$$Nest$mnotifyOnSoundProfileError(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), null, 1, Binder.getCallingUid(), Binder.getCallingPid());
            goto L11
        }

        public void updateSoundProfile(final String id, final SoundProfile sp, int userId) {
            MediaQualityService.m5847$$Nest$fgetmHandler(this.this$0).post(new MediaQualityService$BinderService$$ExternalSyntheticLambda5(this, id, sp));
        }

        private /* synthetic */ void lambda$updateSoundProfile$4(String id, SoundProfile sp) {
            Long dbId = (Long) MediaQualityService.m5860$$Nest$fgetmSoundProfileTempIdMap(this.this$0).getKey(id);
            if (hasPermissionToUpdateSoundProfile(dbId, sp) == true) goto L5;
            MqManagerNotifier.m5887$$Nest$mnotifyOnSoundProfileError(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), id, 1, Binder.getCallingUid(), Binder.getCallingPid());
        L5:
            Object r7 = MediaQualityService.m5858$$Nest$fgetmSoundProfileLock(this.this$0);
            monitor-enter(r7);
            ContentValues values = MediaQualityUtils.getContentValues(dbId, Integer.valueOf(sp.getProfileType()), sp.getName(), sp.getPackageName(), sp.getInputId(), sp.getParameters());     // Catch: Throwable -> L10
            this.this$0.updateDatabaseOnSoundProfileAndNotifyManagerAndHal(values, sp.getParameters());     // Catch: Throwable -> L10
            monitor-exit(r7);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        private boolean hasPermissionToUpdateSoundProfile(Long dbId, SoundProfile sp) {
            SoundProfile fromDb = MqDatabaseUtils.m5879$$Nest$mgetSoundProfile(MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0), dbId);
            if (fromDb.getProfileType() == sp.getProfileType()) goto L5;
        L11:
            return false;
        L5:
            if (fromDb.getPackageName().equals(sp.getPackageName()) == false) goto L11;
            if (fromDb.getName().equals(sp.getName()) == false) goto L11;
            if (fromDb.getName().equals(getPackageOfCallingUid()) == false) goto L11;
            return true;
        }

        public void removeSoundProfile(final String id, int userId) {
            MediaQualityService.m5847$$Nest$fgetmHandler(this.this$0).post(new MediaQualityService$BinderService$$ExternalSyntheticLambda2(this, id));
        }

        private /* synthetic */ void lambda$removeSoundProfile$5(String id) {
            Object r0 = MediaQualityService.m5858$$Nest$fgetmSoundProfileLock(this.this$0);
            monitor-enter(r0);
            Long dbId = (Long) MediaQualityService.m5860$$Nest$fgetmSoundProfileTempIdMap(this.this$0).getKey(id);     // Catch: Throwable -> L7
            SoundProfile toDelete = MqDatabaseUtils.m5879$$Nest$mgetSoundProfile(MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0), dbId);     // Catch: Throwable -> L7
            if (hasPermissionToRemoveSoundProfile(toDelete) == true) goto L9;
            MqManagerNotifier.m5887$$Nest$mnotifyOnSoundProfileError(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), id, 1, Binder.getCallingUid(), Binder.getCallingPid());     // Catch: Throwable -> L7
        L9:
            if (dbId == null) goto L14;
            SQLiteDatabase db = MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0).getWritableDatabase();     // Catch: Throwable -> L7
            String[] selectionArgs = {Long.toString(dbId.longValue())};     // Catch: Throwable -> L7
            MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0);     // Catch: Throwable -> L7
            int result = db.delete(MediaQualityDbHelper.SOUND_QUALITY_TABLE_NAME, "_id = ?", selectionArgs);     // Catch: Throwable -> L7
            if (result != 0) goto L13;
            MqManagerNotifier.m5887$$Nest$mnotifyOnSoundProfileError(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), id, 3, Binder.getCallingUid(), Binder.getCallingPid());     // Catch: Throwable -> L7
            goto L14
        L13:
            MqManagerNotifier.m5889$$Nest$mnotifyOnSoundProfileRemoved(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), (String) MediaQualityService.m5860$$Nest$fgetmSoundProfileTempIdMap(this.this$0).getValue(dbId), toDelete, Binder.getCallingUid(), Binder.getCallingPid());     // Catch: Throwable -> L7
            MediaQualityService.m5860$$Nest$fgetmSoundProfileTempIdMap(this.this$0).remove(dbId);     // Catch: Throwable -> L7
            HalNotifier.m5875$$Nest$mnotifyHalOnSoundProfileChange(MediaQualityService.m5845$$Nest$fgetmHalNotifier(this.this$0), dbId, null);     // Catch: Throwable -> L7
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private boolean hasPermissionToRemoveSoundProfile(SoundProfile toDelete) {
            if (toDelete != null) goto L4;
            return false;
        L4:
            return toDelete.getName().equalsIgnoreCase(getPackageOfCallingUid());
        }

        public SoundProfile getSoundProfile(int type, String name, boolean includeParams, int userId) {
            String[] selectionArguments = {String.valueOf(type), name, getPackageOfCallingUid()};
            Object r2 = MediaQualityService.m5858$$Nest$fgetmSoundProfileLock(this.this$0);
            monitor-enter(r2);
            MqDatabaseUtils r3 = MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0);     // Catch: Throwable -> L11
            MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0);     // Catch: Throwable -> L11
            Cursor cursor = MqDatabaseUtils.m5876$$Nest$mgetCursorAfterQuerying(r3, MediaQualityDbHelper.SOUND_QUALITY_TABLE_NAME, MediaQualityUtils.getMediaProfileColumns(includeParams), "_type = ? AND _name = ? AND _package = ?", selectionArguments);     // Catch: Throwable -> L11
            int count = cursor.getCount();     // Catch: Throwable -> L19
            if (count != 0) goto L14;
            cursor.close();     // Catch: Throwable -> L11
            monitor-exit(r2);     // Catch: Throwable -> L11
            return null;
        L14:
            if (count <= 1) goto L21;
            String r7 = String.valueOf(Locale.US);     // Catch: Throwable -> L19
            String r9 = String.valueOf(count);     // Catch: Throwable -> L19
            MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0);     // Catch: Throwable -> L19
            Log.wtf(MediaQualityService.TAG, TextUtils.formatSimple(r7, new Object[]{"%d entries found for name=%s in %s. Should only ever be 0 or 1.", r9, name, MediaQualityDbHelper.SOUND_QUALITY_TABLE_NAME}));     // Catch: Throwable -> L19
            cursor.close();     // Catch: Throwable -> L11
            monitor-exit(r2);     // Catch: Throwable -> L11
            return null;
        L21:
            cursor.moveToFirst();     // Catch: Throwable -> L19
            SoundProfile r5 = MediaQualityUtils.convertCursorToSoundProfileWithTempId(cursor, MediaQualityService.m5860$$Nest$fgetmSoundProfileTempIdMap(this.this$0));     // Catch: Throwable -> L19
            cursor.close();     // Catch: Throwable -> L11
            monitor-exit(r2);     // Catch: Throwable -> L11
            return r5;
        L19:
            th = move-exception;
            if (cursor != null) goto L36;
        L31:
            throw th;     // Catch: Throwable -> L11
        L36:
            cursor.close();     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        public List<SoundProfile> getSoundProfilesByPackage(String packageName, boolean includeParams, int userId) {
            if (hasGlobalSoundQualityServicePermission() == true) goto L5;
            MqManagerNotifier.m5887$$Nest$mnotifyOnSoundProfileError(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), null, 1, Binder.getCallingUid(), Binder.getCallingPid());
        L5:
            Object r0 = MediaQualityService.m5858$$Nest$fgetmSoundProfileLock(this.this$0);
            monitor-enter(r0);
            String[] selectionArguments = {packageName};     // Catch: Throwable -> L10
            List<SoundProfile> r3 = MqDatabaseUtils.m5880$$Nest$mgetSoundProfilesBasedOnConditions(MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0), MediaQualityUtils.getMediaProfileColumns(includeParams), "_package = ?", selectionArguments);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L10:
            th = move-exception;
            throw th;
        }

        public List<SoundProfile> getAvailableSoundProfiles(boolean includeParams, int userId) {
            String packageName = getPackageOfCallingUid();
            if (packageName == null) goto L7;
            return getSoundProfilesByPackage(packageName, includeParams, userId);
        L7:
            return new ArrayList();
        }

        public boolean setDefaultSoundProfile(String profileId, int userId) {
            if (hasGlobalSoundQualityServicePermission() == true) goto L5;
            MqManagerNotifier.m5887$$Nest$mnotifyOnSoundProfileError(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), profileId, 1, Binder.getCallingUid(), Binder.getCallingPid());
        L5:
            Long longId = (Long) MediaQualityService.m5860$$Nest$fgetmSoundProfileTempIdMap(this.this$0).getKey(profileId);
            if (longId != null) goto L8;
            return false;
        L8:
            SoundProfile soundProfile = MqDatabaseUtils.m5879$$Nest$mgetSoundProfile(MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0), longId);
            PersistableBundle params = soundProfile.getParameters();
        L13:
            e = move-exception;
            Slog.e(MediaQualityService.TAG, "Failed to set default sound profile", e);
        L17:
            return false;
        L10:
            if (MediaQualityService.m5848$$Nest$fgetmMediaQuality(this.this$0) == null) goto L17;
            SoundParameters sp = new SoundParameters();     // Catch: RemoteException -> L13
            params.putLong("_id", longId.longValue());     // Catch: RemoteException -> L13
            SoundParameter[] soundParameters = MediaQualityUtils.convertPersistableBundleToSoundParameterList(params);     // Catch: RemoteException -> L13
            Parcel parcel = Parcel.obtain();     // Catch: RemoteException -> L13
            MediaQualityService.m5867$$Nest$msetVendorSoundParameters(this.this$0, sp, parcel, params);     // Catch: RemoteException -> L13
            sp.soundParameters = soundParameters;     // Catch: RemoteException -> L13
            MediaQualityService.m5848$$Nest$fgetmMediaQuality(this.this$0).sendDefaultSoundParameters(sp);     // Catch: RemoteException -> L13
            return true;
        }

        public List<String> getSoundProfilePackageNames(int userId) {
            if (hasGlobalSoundQualityServicePermission() == true) goto L5;
            MqManagerNotifier.m5887$$Nest$mnotifyOnSoundProfileError(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), null, 1, Binder.getCallingUid(), Binder.getCallingPid());
        L5:
            String[] column = {"_name"};
            Object r2 = MediaQualityService.m5858$$Nest$fgetmSoundProfileLock(this.this$0);
            monitor-enter(r2);
            List<SoundProfile> soundProfiles = MqDatabaseUtils.m5880$$Nest$mgetSoundProfilesBasedOnConditions(MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0), column, null, null);     // Catch: Throwable -> L10
            List<String> r3 = (List) soundProfiles.stream().map(new MediaQualityService$BinderService$$ExternalSyntheticLambda7()).distinct().collect(Collectors.toList());     // Catch: Throwable -> L10
            monitor-exit(r2);     // Catch: Throwable -> L10
            return r3;
        L10:
            th = move-exception;
            throw th;
        }

        private String getPackageOfCallingUid() {
            String[] packageNames = MediaQualityService.m5853$$Nest$fgetmPackageManager(this.this$0).getPackagesForUid(Binder.getCallingUid());
            if (packageNames != null) goto L5;
            return null;
        L5:
            if (packageNames.length == 1) goto L7;
            return null;
        L7:
            if (packageNames[0].isEmpty() == false) goto L9;
            return null;
        L9:
            return packageNames[0];
        }

        private boolean incomingPackageEqualsCallingUidPackage(String incomingPackage) {
            return incomingPackage.equalsIgnoreCase(getPackageOfCallingUid());
        }

        private boolean hasGlobalPictureQualityServicePermission() {
            if (MediaQualityService.m5842$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.MANAGE_GLOBAL_PICTURE_QUALITY_SERVICE") != 0) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean hasGlobalSoundQualityServicePermission() {
            if (MediaQualityService.m5842$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.MANAGE_GLOBAL_SOUND_QUALITY_SERVICE") != 0) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean hasReadColorZonesPermission() {
            if (MediaQualityService.m5842$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.READ_COLOR_ZONES") != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void registerPictureProfileCallback(IPictureProfileCallback callback) {
            int callingPid = Binder.getCallingPid();
            int callingUid = Binder.getCallingUid();
            UserState userState = MediaQualityService.m5863$$Nest$mgetOrCreateUserState(this.this$0, Binder.getCallingUid());
            UserState.m5894$$Nest$fgetmPictureProfileCallbackPidUidMap(userState).put(callback, Pair.create(Integer.valueOf(callingPid), Integer.valueOf(callingUid)));
        }

        public void registerSoundProfileCallback(ISoundProfileCallback callback) {
            int callingPid = Binder.getCallingPid();
            int callingUid = Binder.getCallingUid();
            UserState userState = MediaQualityService.m5863$$Nest$mgetOrCreateUserState(this.this$0, Binder.getCallingUid());
            UserState.m5896$$Nest$fgetmSoundProfileCallbackPidUidMap(userState).put(callback, Pair.create(Integer.valueOf(callingPid), Integer.valueOf(callingUid)));
        }

        public void registerActiveProcessingPictureListener(IActiveProcessingPictureListener l) {
            int callingPid = Binder.getCallingPid();
            int callingUid = Binder.getCallingUid();
            UserState userState = MediaQualityService.m5863$$Nest$mgetOrCreateUserState(this.this$0, Binder.getCallingUid());
            String packageName = getPackageOfCallingUid();
            UserState.m5893$$Nest$fgetmActiveProcessingPictureListenerMap(userState).put(l, new ActiveProcessingPictureListenerInfo(this.this$0, callingUid, callingPid, packageName));
        }

        public void registerAmbientBacklightCallback(IAmbientBacklightCallback callback) {
            hasReadColorZonesPermission();
            String callingPackageName = getPackageOfCallingUid();
            Map r1 = MediaQualityService.m5841$$Nest$fgetmCallbackRecords(this.this$0);
            monitor-enter(r1);
            AmbientBacklightCallbackRecord record = (AmbientBacklightCallbackRecord) MediaQualityService.m5841$$Nest$fgetmCallbackRecords(this.this$0).get(callingPackageName);     // Catch: Throwable -> L11
            if (record != null) goto L7;
        L14:
            MediaQualityService.m5841$$Nest$fgetmCallbackRecords(this.this$0).put(callingPackageName, new AmbientBacklightCallbackRecord(this.this$0, callingPackageName, callback));     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return;
        L7:
            if (record.mCallback.asBinder().equals(callback.asBinder()) == false) goto L13;
            Slog.w(MediaQualityService.TAG, "AmbientBacklight Callback already registered");     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return;
        L13:
            record.release();     // Catch: Throwable -> L11
            MediaQualityService.m5841$$Nest$fgetmCallbackRecords(this.this$0).remove(callingPackageName);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        public void unregisterAmbientBacklightCallback(IAmbientBacklightCallback callback) {
            hasReadColorZonesPermission();
            Map r0 = MediaQualityService.m5841$$Nest$fgetmCallbackRecords(this.this$0);
            monitor-enter(r0);
            Iterator r1 = MediaQualityService.m5841$$Nest$fgetmCallbackRecords(this.this$0).values().iterator();     // Catch: Throwable -> L12
        L6:
            if (r1.hasNext() == false) goto L15;
            AmbientBacklightCallbackRecord record = (AmbientBacklightCallbackRecord) r1.next();     // Catch: Throwable -> L12
            if (record.mCallback.asBinder().equals(callback.asBinder()) == false) goto L6;
            record.release();     // Catch: Throwable -> L12
            MediaQualityService.m5841$$Nest$fgetmCallbackRecords(this.this$0).remove(record.mPackageName);     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        public void setAmbientBacklightSettings(AmbientBacklightSettings settings, int userId) {
            hasReadColorZonesPermission();
        L7:
            e = move-exception;
            Slog.e(MediaQualityService.TAG, "Failed to set ambient backlight settings", e);
            return;
        L4:
            if (MediaQualityService.m5848$$Nest$fgetmMediaQuality(this.this$0) == null) goto L14;
            android.hardware.tv.mediaquality.AmbientBacklightSettings halSettings = new android.hardware.tv.mediaquality.AmbientBacklightSettings();     // Catch: RemoteException -> L7
            halSettings.uid = Binder.getCallingUid();     // Catch: RemoteException -> L7
            halSettings.source = (byte) settings.getSource();     // Catch: RemoteException -> L7
            halSettings.maxFramerate = settings.getMaxFps();     // Catch: RemoteException -> L7
            halSettings.colorFormat = (byte) settings.getColorFormat();     // Catch: RemoteException -> L7
            halSettings.hZonesNumber = settings.getHorizontalZonesCount();     // Catch: RemoteException -> L7
            halSettings.vZonesNumber = settings.getVerticalZonesCount();     // Catch: RemoteException -> L7
            halSettings.hasLetterbox = settings.isLetterboxOmitted();     // Catch: RemoteException -> L7
            halSettings.colorThreshold = settings.getThreshold();     // Catch: RemoteException -> L7
            MediaQualityService.m5848$$Nest$fgetmMediaQuality(this.this$0).setAmbientBacklightDetector(halSettings);     // Catch: RemoteException -> L7
            MediaQualityService.m5844$$Nest$fgetmHalAmbientBacklightCallback(this.this$0).setAmbientBacklightClientPackageName(getPackageOfCallingUid());     // Catch: RemoteException -> L7
            return;
        }

        public void setAmbientBacklightEnabled(boolean enabled, int userId) {
            hasReadColorZonesPermission();
        L7:
            e = move-exception;
            Slog.e(MediaQualityService.TAG, "Failed to set ambient backlight enabled", e);
            return;
        L4:
            if (MediaQualityService.m5848$$Nest$fgetmMediaQuality(this.this$0) == null) goto L17;
            MediaQualityService.m5848$$Nest$fgetmMediaQuality(this.this$0).setAmbientBacklightDetectionEnabled(enabled);     // Catch: RemoteException -> L7 UnsupportedOperationException -> L9
            goto L13
        L19:
            return;
        L17:
            return;
        L13:
            Slog.e(MediaQualityService.TAG, "The current device is not supported");
        }

        public List<ParameterCapability> getParameterCapabilities(List<String> names, int userId) {
            byte[] byteArray = MediaQualityUtils.convertParameterToByteArray(names);
            ParamCapability[] caps = new ParamCapability[byteArray.length];
            MediaQualityService.m5848$$Nest$fgetmMediaQuality(this.this$0).getParamCaps(byteArray, caps);     // Catch: RemoteException -> L5
        L8:
            return getListParameterCapability(caps);
        L5:
            e = move-exception;
            Slog.e(MediaQualityService.TAG, "Failed to get parameter capabilities", e);
            goto L8
        }

        private List<ParameterCapability> getListParameterCapability(ParamCapability[] caps) {
            List<ParameterCapability> pcList = new ArrayList();
            if (caps == null) goto L15;
            int r1 = caps.length;
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L15;
            ParamCapability pcHal = caps[r3];
            if (pcHal == null) goto L14;
            String name = MediaQualityUtils.getParameterName(pcHal.name);
            boolean isSupported = pcHal.isSupported;
            if (pcHal.defaultValue != null) goto L12;
            int type = 0;
        L13:
            Bundle bundle = MediaQualityUtils.convertToCaps(type, pcHal.range);
            pcList.add(new ParameterCapability(name, isSupported, type, bundle));
            goto L14
        L12:
            type = pcHal.defaultValue.getTag() + 1;
        L14:
            r3 = r3 + 1;
        L15:
            return pcList;
        }

        public List<String> getPictureProfileAllowList(int userId) {
            if (hasGlobalPictureQualityServicePermission() == true) goto L5;
            MqManagerNotifier.m5882$$Nest$mnotifyOnPictureProfileError(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), null, 1, Binder.getCallingUid(), Binder.getCallingPid());
        L5:
            String allowlist = MediaQualityService.m5855$$Nest$fgetmPictureProfileSharedPreference(this.this$0).getString(MediaQualityService.ALLOWLIST, null);
            if (allowlist == null) goto L10;
            String[] stringArray = allowlist.split(MediaQualityService.COMMA_DELIMITER);
            return new ArrayList(Arrays.asList(stringArray));
        L10:
            return new ArrayList();
        }

        public void setPictureProfileAllowList(final List<String> packages, int userId) {
            MediaQualityService.m5847$$Nest$fgetmHandler(this.this$0).post(new MediaQualityService$BinderService$$ExternalSyntheticLambda1(this, packages));
        }

        private /* synthetic */ void lambda$setPictureProfileAllowList$6(List packages) {
            if (hasGlobalPictureQualityServicePermission() == true) goto L5;
            MqManagerNotifier.m5882$$Nest$mnotifyOnPictureProfileError(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), null, 1, Binder.getCallingUid(), Binder.getCallingPid());
        L5:
            SharedPreferences.Editor editor = MediaQualityService.m5855$$Nest$fgetmPictureProfileSharedPreference(this.this$0).edit();
            editor.putString(MediaQualityService.ALLOWLIST, String.join(MediaQualityService.COMMA_DELIMITER, packages));
            editor.commit();
        }

        public List<String> getSoundProfileAllowList(int userId) {
            if (hasGlobalSoundQualityServicePermission() == true) goto L5;
            MqManagerNotifier.m5887$$Nest$mnotifyOnSoundProfileError(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), null, 1, Binder.getCallingUid(), Binder.getCallingPid());
        L5:
            String allowlist = MediaQualityService.m5859$$Nest$fgetmSoundProfileSharedPreference(this.this$0).getString(MediaQualityService.ALLOWLIST, null);
            if (allowlist == null) goto L10;
            String[] stringArray = allowlist.split(MediaQualityService.COMMA_DELIMITER);
            return new ArrayList(Arrays.asList(stringArray));
        L10:
            return new ArrayList();
        }

        public void setSoundProfileAllowList(final List<String> packages, int userId) {
            MediaQualityService.m5847$$Nest$fgetmHandler(this.this$0).post(new MediaQualityService$BinderService$$ExternalSyntheticLambda3(this, packages));
        }

        private /* synthetic */ void lambda$setSoundProfileAllowList$7(List packages) {
            if (hasGlobalSoundQualityServicePermission() == true) goto L5;
            MqManagerNotifier.m5887$$Nest$mnotifyOnSoundProfileError(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), null, 1, Binder.getCallingUid(), Binder.getCallingPid());
        L5:
            SharedPreferences.Editor editor = MediaQualityService.m5859$$Nest$fgetmSoundProfileSharedPreference(this.this$0).edit();
            editor.putString(MediaQualityService.ALLOWLIST, String.join(MediaQualityService.COMMA_DELIMITER, packages));
            editor.commit();
        }

        public boolean isSupported(int userId) {
            return false;
        }

        public void setAutoPictureQualityEnabled(final boolean enabled, int userId) {
            MediaQualityService.m5847$$Nest$fgetmHandler(this.this$0).post(new MediaQualityService$BinderService$$ExternalSyntheticLambda10(this, enabled));
        }

        private /* synthetic */ void lambda$setAutoPictureQualityEnabled$8(boolean enabled) {
            /*  JADX ERROR: Simple mode code generation failed
                java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
                	at java.base/java.util.Objects.checkIndex(Objects.java:365)
                	at java.base/java.util.ArrayList.get(ArrayList.java:428)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */
            /*
                this = this;
                boolean r0 = r5.hasGlobalPictureQualityServicePermission()
                if (r0 != 0) goto L19
                com.android.server.media.quality.MediaQualityService r0 = r5.this$0
                com.android.server.media.quality.MediaQualityService$MqManagerNotifier r0 = com.android.server.media.quality.MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(r0)
                int r1 = android.os.Binder.getCallingUid()
                int r2 = android.os.Binder.getCallingPid()
                r3 = 0
                r4 = 1
                com.android.server.media.quality.MediaQualityService.MqManagerNotifier.m5882$$Nest$mnotifyOnPictureProfileError(r0, r3, r4, r1, r2)
            L19:
                com.android.server.media.quality.MediaQualityService r0 = r5.this$0
                java.lang.Object r0 = com.android.server.media.quality.MediaQualityService.m5854$$Nest$fgetmPictureProfileLock(r0)
                monitor-enter(r0)
                com.android.server.media.quality.MediaQualityService r1 = r5.this$0     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                android.hardware.tv.mediaquality.IMediaQuality r1 = com.android.server.media.quality.MediaQualityService.m5848$$Nest$fgetmMediaQuality(r1)     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                if (r1 == 0) goto L42
                com.android.server.media.quality.MediaQualityService r1 = r5.this$0     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                android.hardware.tv.mediaquality.IMediaQuality r1 = com.android.server.media.quality.MediaQualityService.m5848$$Nest$fgetmMediaQuality(r1)     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                boolean r1 = r1.isAutoPqSupported()     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                if (r1 == 0) goto L42
                com.android.server.media.quality.MediaQualityService r1 = r5.this$0     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                android.hardware.tv.mediaquality.IMediaQuality r1 = com.android.server.media.quality.MediaQualityService.m5848$$Nest$fgetmMediaQuality(r1)     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                r1.setAutoPqEnabled(r6)     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                goto L42
            L3e:
                r1 = move-exception
                goto L4d
            L40:
                r1 = move-exception
                goto L43
            L42:
                goto L4b
            L43:
                java.lang.String r2 = "MediaQualityService"
                java.lang.String r3 = "Failed to set auto picture quality"
                android.util.Slog.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L3e
            L4b:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
                return
            L4d:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.server.media.quality.MediaQualityService.BinderService.lambda$setAutoPictureQualityEnabled$8(boolean):void");
        }

        public boolean isAutoPictureQualityEnabled(int userId) {
            /*  JADX ERROR: Simple mode code generation failed
                java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
                	at java.base/java.util.Objects.checkIndex(Objects.java:365)
                	at java.base/java.util.ArrayList.get(ArrayList.java:428)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */
            /*
                this = this;
                com.android.server.media.quality.MediaQualityService r0 = r4.this$0
                java.lang.Object r0 = com.android.server.media.quality.MediaQualityService.m5854$$Nest$fgetmPictureProfileLock(r0)
                monitor-enter(r0)
                com.android.server.media.quality.MediaQualityService r1 = r4.this$0     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                android.hardware.tv.mediaquality.IMediaQuality r1 = com.android.server.media.quality.MediaQualityService.m5848$$Nest$fgetmMediaQuality(r1)     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                if (r1 == 0) goto L2b
                com.android.server.media.quality.MediaQualityService r1 = r4.this$0     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                android.hardware.tv.mediaquality.IMediaQuality r1 = com.android.server.media.quality.MediaQualityService.m5848$$Nest$fgetmMediaQuality(r1)     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                boolean r1 = r1.isAutoPqSupported()     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                if (r1 == 0) goto L2b
                com.android.server.media.quality.MediaQualityService r1 = r4.this$0     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                android.hardware.tv.mediaquality.IMediaQuality r1 = com.android.server.media.quality.MediaQualityService.m5848$$Nest$fgetmMediaQuality(r1)     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                boolean r1 = r1.getAutoPqEnabled()     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L27
                return r1
            L27:
                r1 = move-exception
                goto L37
            L29:
                r1 = move-exception
                goto L2c
            L2b:
                goto L34
            L2c:
                java.lang.String r2 = "MediaQualityService"
                java.lang.String r3 = "Failed to get auto picture quality"
                android.util.Slog.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L27
            L34:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L27
                r0 = 0
                return r0
            L37:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L27
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.server.media.quality.MediaQualityService.BinderService.isAutoPictureQualityEnabled(int):boolean");
        }

        public void setSuperResolutionEnabled(final boolean enabled, int userId) {
            MediaQualityService.m5847$$Nest$fgetmHandler(this.this$0).post(new MediaQualityService$BinderService$$ExternalSyntheticLambda6(this, enabled));
        }

        private /* synthetic */ void lambda$setSuperResolutionEnabled$9(boolean enabled) {
            /*  JADX ERROR: Simple mode code generation failed
                java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
                	at java.base/java.util.Objects.checkIndex(Objects.java:365)
                	at java.base/java.util.ArrayList.get(ArrayList.java:428)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */
            /*
                this = this;
                boolean r0 = r5.hasGlobalPictureQualityServicePermission()
                if (r0 != 0) goto L19
                com.android.server.media.quality.MediaQualityService r0 = r5.this$0
                com.android.server.media.quality.MediaQualityService$MqManagerNotifier r0 = com.android.server.media.quality.MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(r0)
                int r1 = android.os.Binder.getCallingUid()
                int r2 = android.os.Binder.getCallingPid()
                r3 = 0
                r4 = 1
                com.android.server.media.quality.MediaQualityService.MqManagerNotifier.m5882$$Nest$mnotifyOnPictureProfileError(r0, r3, r4, r1, r2)
            L19:
                com.android.server.media.quality.MediaQualityService r0 = r5.this$0
                java.lang.Object r0 = com.android.server.media.quality.MediaQualityService.m5854$$Nest$fgetmPictureProfileLock(r0)
                monitor-enter(r0)
                com.android.server.media.quality.MediaQualityService r1 = r5.this$0     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                android.hardware.tv.mediaquality.IMediaQuality r1 = com.android.server.media.quality.MediaQualityService.m5848$$Nest$fgetmMediaQuality(r1)     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                if (r1 == 0) goto L42
                com.android.server.media.quality.MediaQualityService r1 = r5.this$0     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                android.hardware.tv.mediaquality.IMediaQuality r1 = com.android.server.media.quality.MediaQualityService.m5848$$Nest$fgetmMediaQuality(r1)     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                boolean r1 = r1.isAutoSrSupported()     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                if (r1 == 0) goto L42
                com.android.server.media.quality.MediaQualityService r1 = r5.this$0     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                android.hardware.tv.mediaquality.IMediaQuality r1 = com.android.server.media.quality.MediaQualityService.m5848$$Nest$fgetmMediaQuality(r1)     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                r1.setAutoSrEnabled(r6)     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                goto L42
            L3e:
                r1 = move-exception
                goto L4d
            L40:
                r1 = move-exception
                goto L43
            L42:
                goto L4b
            L43:
                java.lang.String r2 = "MediaQualityService"
                java.lang.String r3 = "Failed to set super resolution"
                android.util.Slog.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L3e
            L4b:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
                return
            L4d:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.server.media.quality.MediaQualityService.BinderService.lambda$setSuperResolutionEnabled$9(boolean):void");
        }

        public boolean isSuperResolutionEnabled(int userId) {
            /*  JADX ERROR: Simple mode code generation failed
                java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
                	at java.base/java.util.Objects.checkIndex(Objects.java:365)
                	at java.base/java.util.ArrayList.get(ArrayList.java:428)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */
            /*
                this = this;
                com.android.server.media.quality.MediaQualityService r0 = r4.this$0
                java.lang.Object r0 = com.android.server.media.quality.MediaQualityService.m5854$$Nest$fgetmPictureProfileLock(r0)
                monitor-enter(r0)
                com.android.server.media.quality.MediaQualityService r1 = r4.this$0     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                android.hardware.tv.mediaquality.IMediaQuality r1 = com.android.server.media.quality.MediaQualityService.m5848$$Nest$fgetmMediaQuality(r1)     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                if (r1 == 0) goto L2b
                com.android.server.media.quality.MediaQualityService r1 = r4.this$0     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                android.hardware.tv.mediaquality.IMediaQuality r1 = com.android.server.media.quality.MediaQualityService.m5848$$Nest$fgetmMediaQuality(r1)     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                boolean r1 = r1.isAutoSrSupported()     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                if (r1 == 0) goto L2b
                com.android.server.media.quality.MediaQualityService r1 = r4.this$0     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                android.hardware.tv.mediaquality.IMediaQuality r1 = com.android.server.media.quality.MediaQualityService.m5848$$Nest$fgetmMediaQuality(r1)     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                boolean r1 = r1.getAutoSrEnabled()     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L27
                return r1
            L27:
                r1 = move-exception
                goto L37
            L29:
                r1 = move-exception
                goto L2c
            L2b:
                goto L34
            L2c:
                java.lang.String r2 = "MediaQualityService"
                java.lang.String r3 = "Failed to get super resolution"
                android.util.Slog.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L27
            L34:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L27
                r0 = 0
                return r0
            L37:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L27
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.server.media.quality.MediaQualityService.BinderService.isSuperResolutionEnabled(int):boolean");
        }

        public void setAutoSoundQualityEnabled(final boolean enabled, int userId) {
            MediaQualityService.m5847$$Nest$fgetmHandler(this.this$0).post(new MediaQualityService$BinderService$$ExternalSyntheticLambda9(this, enabled));
        }

        private /* synthetic */ void lambda$setAutoSoundQualityEnabled$10(boolean enabled) {
            /*  JADX ERROR: Simple mode code generation failed
                java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
                	at java.base/java.util.Objects.checkIndex(Objects.java:365)
                	at java.base/java.util.ArrayList.get(ArrayList.java:428)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */
            /*
                this = this;
                boolean r0 = r5.hasGlobalSoundQualityServicePermission()
                if (r0 != 0) goto L19
                com.android.server.media.quality.MediaQualityService r0 = r5.this$0
                com.android.server.media.quality.MediaQualityService$MqManagerNotifier r0 = com.android.server.media.quality.MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(r0)
                int r1 = android.os.Binder.getCallingUid()
                int r2 = android.os.Binder.getCallingPid()
                r3 = 0
                r4 = 1
                com.android.server.media.quality.MediaQualityService.MqManagerNotifier.m5887$$Nest$mnotifyOnSoundProfileError(r0, r3, r4, r1, r2)
            L19:
                com.android.server.media.quality.MediaQualityService r0 = r5.this$0
                java.lang.Object r0 = com.android.server.media.quality.MediaQualityService.m5858$$Nest$fgetmSoundProfileLock(r0)
                monitor-enter(r0)
                com.android.server.media.quality.MediaQualityService r1 = r5.this$0     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                android.hardware.tv.mediaquality.IMediaQuality r1 = com.android.server.media.quality.MediaQualityService.m5848$$Nest$fgetmMediaQuality(r1)     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                if (r1 == 0) goto L42
                com.android.server.media.quality.MediaQualityService r1 = r5.this$0     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                android.hardware.tv.mediaquality.IMediaQuality r1 = com.android.server.media.quality.MediaQualityService.m5848$$Nest$fgetmMediaQuality(r1)     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                boolean r1 = r1.isAutoAqSupported()     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                if (r1 == 0) goto L42
                com.android.server.media.quality.MediaQualityService r1 = r5.this$0     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                android.hardware.tv.mediaquality.IMediaQuality r1 = com.android.server.media.quality.MediaQualityService.m5848$$Nest$fgetmMediaQuality(r1)     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                r1.setAutoAqEnabled(r6)     // Catch: java.lang.Throwable -> L3e android.os.RemoteException -> L40
                goto L42
            L3e:
                r1 = move-exception
                goto L4d
            L40:
                r1 = move-exception
                goto L43
            L42:
                goto L4b
            L43:
                java.lang.String r2 = "MediaQualityService"
                java.lang.String r3 = "Failed to set auto sound quality"
                android.util.Slog.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L3e
            L4b:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
                return
            L4d:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.server.media.quality.MediaQualityService.BinderService.lambda$setAutoSoundQualityEnabled$10(boolean):void");
        }

        public boolean isAutoSoundQualityEnabled(int userId) {
            /*  JADX ERROR: Simple mode code generation failed
                java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
                	at java.base/java.util.Objects.checkIndex(Objects.java:365)
                	at java.base/java.util.ArrayList.get(ArrayList.java:428)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */
            /*
                this = this;
                com.android.server.media.quality.MediaQualityService r0 = r4.this$0
                java.lang.Object r0 = com.android.server.media.quality.MediaQualityService.m5858$$Nest$fgetmSoundProfileLock(r0)
                monitor-enter(r0)
                com.android.server.media.quality.MediaQualityService r1 = r4.this$0     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                android.hardware.tv.mediaquality.IMediaQuality r1 = com.android.server.media.quality.MediaQualityService.m5848$$Nest$fgetmMediaQuality(r1)     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                if (r1 == 0) goto L2b
                com.android.server.media.quality.MediaQualityService r1 = r4.this$0     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                android.hardware.tv.mediaquality.IMediaQuality r1 = com.android.server.media.quality.MediaQualityService.m5848$$Nest$fgetmMediaQuality(r1)     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                boolean r1 = r1.isAutoAqSupported()     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                if (r1 == 0) goto L2b
                com.android.server.media.quality.MediaQualityService r1 = r4.this$0     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                android.hardware.tv.mediaquality.IMediaQuality r1 = com.android.server.media.quality.MediaQualityService.m5848$$Nest$fgetmMediaQuality(r1)     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                boolean r1 = r1.getAutoAqEnabled()     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L29
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L27
                return r1
            L27:
                r1 = move-exception
                goto L37
            L29:
                r1 = move-exception
                goto L2c
            L2b:
                goto L34
            L2c:
                java.lang.String r2 = "MediaQualityService"
                java.lang.String r3 = "Failed to get auto sound quality"
                android.util.Slog.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L27
            L34:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L27
                r0 = 0
                return r0
            L37:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L27
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.server.media.quality.MediaQualityService.BinderService.isAutoSoundQualityEnabled(int):boolean");
        }

        public boolean isAmbientBacklightEnabled(int userId) {
            return false;
        }
    }

    private final class HalAmbientBacklightCallback extends IMediaQualityCallback.Stub {
        private String mAmbientBacklightClientPackageName;
        private final Object mLock;
        final /* synthetic */ MediaQualityService this$0;

        /* synthetic */ HalAmbientBacklightCallback(MediaQualityService r1, MediaQualityServiceIA r2) {
            this(r1);
        }

        private HalAmbientBacklightCallback(MediaQualityService r1) {
            this.this$0 = r1;
            this.mLock = new Object();
        }

        void setAmbientBacklightClientPackageName(String packageName) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (TextUtils.equals(this.mAmbientBacklightClientPackageName, packageName) == false) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            handleAmbientBacklightInterrupted();     // Catch: Throwable -> L8
            this.mAmbientBacklightClientPackageName = packageName;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        void handleAmbientBacklightInterrupted() {
            Map r0 = MediaQualityService.m5841$$Nest$fgetmCallbackRecords(this.this$0);
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mAmbientBacklightClientPackageName != null) goto L11;
            Slog.e(MediaQualityService.TAG, "Invalid package name in interrupted event");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            AmbientBacklightCallbackRecord record = (AmbientBacklightCallbackRecord) MediaQualityService.m5841$$Nest$fgetmCallbackRecords(this.this$0).get(this.mAmbientBacklightClientPackageName);     // Catch: Throwable -> L9
            if (record != null) goto L16;
            Slog.e(MediaQualityService.TAG, "Callback record not found for ambient backlight");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L16:
            AmbientBacklightEvent event = new AmbientBacklightEvent(4, null);     // Catch: Throwable -> L9
            record.mCallback.onAmbientBacklightEvent(event);     // Catch: Throwable -> L9 RemoteException -> L19
        L21:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L19:
            e = move-exception;
            Slog.e(MediaQualityService.TAG, "Deliver ambient backlight interrupted event failed", e);     // Catch: Throwable -> L9
            goto L21
        }

        void handleAmbientBacklightEnabled(boolean enabled) {
            if (enabled == false) goto L5;
            int r1 = 1;
        L6:
            AmbientBacklightEvent event = new AmbientBacklightEvent(r1, null);
            Map r2 = MediaQualityService.m5841$$Nest$fgetmCallbackRecords(this.this$0);
            monitor-enter(r2);
            Iterator r3 = MediaQualityService.m5841$$Nest$fgetmCallbackRecords(this.this$0).values().iterator();     // Catch: Throwable -> L14
        L10:
            if (r3.hasNext() == false) goto L19;
            AmbientBacklightCallbackRecord record = (AmbientBacklightCallbackRecord) r3.next();     // Catch: Throwable -> L14
            record.mCallback.onAmbientBacklightEvent(event);     // Catch: Throwable -> L14 RemoteException -> L16
        L16:
            e = move-exception;
            Slog.e(MediaQualityService.TAG, "Deliver ambient backlight enabled event failed", e);     // Catch: Throwable -> L14
            goto L10
        L19:
            monitor-exit(r2);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        L5:
            r1 = 2;
            goto L6
        }

        void handleAmbientBacklightMetadataEvent(AmbientBacklightMetadata halMetadata) {
            String halPackageName = MediaQualityService.m5842$$Nest$fgetmContext(this.this$0).getPackageManager().getNameForUid(halMetadata.settings.uid);
            if (TextUtils.equals(this.mAmbientBacklightClientPackageName, halPackageName) == true) goto L6;
            Slog.e(MediaQualityService.TAG, "Invalid package name in metadata event");
            return;
        L6:
            AmbientBacklightColorFormat[] zonesColorsUnion = halMetadata.zonesColors;
            int[] zonesColorsInt = new int[zonesColorsUnion.length];
            int i = 0;
        L8:
            if (i >= zonesColorsUnion.length) goto L10;
            AmbientBacklightColorFormat r2 = zonesColorsUnion[i];
            zonesColorsInt[i] = 0;
            i = i + 1;
            goto L8
        L10:
            android.media.quality.AmbientBacklightMetadata metadata = new android.media.quality.AmbientBacklightMetadata(halPackageName, halMetadata.compressAlgorithm, halMetadata.settings.source, halMetadata.settings.colorFormat, halMetadata.settings.hZonesNumber, halMetadata.settings.vZonesNumber, zonesColorsInt);
            AmbientBacklightEvent event = new AmbientBacklightEvent(3, metadata);
            Map r5 = MediaQualityService.m5841$$Nest$fgetmCallbackRecords(this.this$0);
            monitor-enter(r5);
            AmbientBacklightCallbackRecord record = (AmbientBacklightCallbackRecord) MediaQualityService.m5841$$Nest$fgetmCallbackRecords(this.this$0).get(halPackageName);     // Catch: Throwable -> L17
            if (record != null) goto L28;
            Slog.e(MediaQualityService.TAG, "Callback record not found for ambient backlight metadata");     // Catch: Throwable -> L17
            monitor-exit(r5);     // Catch: Throwable -> L17
            return;
        L28:
            record.mCallback.onAmbientBacklightEvent(event);     // Catch: Throwable -> L17 RemoteException -> L21
        L23:
            monitor-exit(r5);     // Catch: Throwable -> L17
            return;
        L21:
            e = move-exception;
            Slog.e(MediaQualityService.TAG, "Deliver ambient backlight metadata event failed", e);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;
        }

        @Override // android.hardware.tv.mediaquality.IMediaQualityCallback
        public void notifyAmbientBacklightEvent(android.hardware.tv.mediaquality.AmbientBacklightEvent halEvent) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (halEvent.getTag() != 0) goto L14;
            boolean enabled = halEvent.getEnabled();     // Catch: Throwable -> L9
            if (enabled == false) goto L11;
            handleAmbientBacklightEnabled(true);     // Catch: Throwable -> L9
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            handleAmbientBacklightEnabled(false);     // Catch: Throwable -> L9
            goto L17
        L14:
            if (halEvent.getTag() != 1) goto L16;
            handleAmbientBacklightMetadataEvent(halEvent.getMetadata());     // Catch: Throwable -> L9
            goto L17
        L16:
            Slog.e(MediaQualityService.TAG, "Invalid event type in ambient backlight event");     // Catch: Throwable -> L9
            goto L17
        }

        /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
        @Override // android.hardware.tv.mediaquality.IMediaQualityCallback
        public synchronized String getInterfaceHash() throws RemoteException {
            monitor-enter(this);
            monitor-exit(this);
            return "ac19fd80413145bec55462874afb34c24a47a12b";
        }

        @Override // android.hardware.tv.mediaquality.IMediaQualityCallback
        public int getInterfaceVersion() throws RemoteException {
            return 1;
        }
    }

    private final class HalNotifier {
        final /* synthetic */ MediaQualityService this$0;

        /* JADX INFO: renamed from: -$$Nest$mnotifyHalOnPictureProfileChange, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5874$$Nest$mnotifyHalOnPictureProfileChange(HalNotifier r0, Long r1, PersistableBundle r2) {
            r0.notifyHalOnPictureProfileChange(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyHalOnSoundProfileChange, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5875$$Nest$mnotifyHalOnSoundProfileChange(HalNotifier r0, Long r1, PersistableBundle r2) {
            r0.notifyHalOnSoundProfileChange(r1, r2);
        }

        /* synthetic */ HalNotifier(MediaQualityService r1, MediaQualityServiceIA r2) {
            this(r1);
        }

        private void notifyHalOnPictureProfileChange(Long dbId, PersistableBundle params) {
            if (MediaQualityService.m5857$$Nest$fgetmPpChangedListener(this.this$0) == null) goto L18;
            Long currentHandle = (Long) MediaQualityService.m5843$$Nest$fgetmCurrentPictureHandleToOriginal(this.this$0).getKey(dbId);
            if (currentHandle == null) goto L7;
            return;
        L7:
            Long idForHal = dbId;
            Long originalHandle = (Long) MediaQualityService.m5843$$Nest$fgetmCurrentPictureHandleToOriginal(this.this$0).getValue(dbId);     // Catch: RemoteException -> L13
            if (originalHandle == null) goto L11;
            idForHal = originalHandle;
        L11:
            MediaQualityService.m5857$$Nest$fgetmPpChangedListener(this.this$0).onPictureProfileChanged(convertToHalPictureProfile(idForHal, params));     // Catch: RemoteException -> L13
            return;
        L13:
            e = move-exception;
            Slog.e(MediaQualityService.TAG, "Failed to notify HAL on picture profile change.", e);
            return;
        }

        private android.hardware.tv.mediaquality.PictureProfile convertToHalPictureProfile(Long id, PersistableBundle params) {
            PictureParameters pictureParameters = new PictureParameters();
            pictureParameters.pictureParameters = MediaQualityUtils.convertPersistableBundleToPictureParameterList(params);
            Parcel parcel = Parcel.obtain();
            if (params == null) goto L5;
            MediaQualityService.m5866$$Nest$msetVendorPictureParameters(this.this$0, pictureParameters, parcel, params);
        L5:
            android.hardware.tv.mediaquality.PictureProfile toReturn = new android.hardware.tv.mediaquality.PictureProfile();
            toReturn.pictureProfileId = id.longValue();
            toReturn.parameters = pictureParameters;
            parcel.recycle();
            return toReturn;
        }

        private void notifyHalOnSoundProfileChange(Long dbId, PersistableBundle params) {
            if (MediaQualityService.m5861$$Nest$fgetmSpChangedListener(this.this$0) == null) goto L11;
            MediaQualityService.m5861$$Nest$fgetmSpChangedListener(this.this$0).onSoundProfileChanged(convertToHalSoundProfile(dbId, params));     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            Slog.e(MediaQualityService.TAG, "Failed to notify HAL on sound profile change.", e);
            return;
        }

        private android.hardware.tv.mediaquality.SoundProfile convertToHalSoundProfile(Long id, PersistableBundle params) {
            SoundParameters soundParameters = new SoundParameters();
            soundParameters.soundParameters = MediaQualityUtils.convertPersistableBundleToSoundParameterList(params);
            Parcel parcel = Parcel.obtain();
            if (params == null) goto L5;
            MediaQualityService.m5867$$Nest$msetVendorSoundParameters(this.this$0, soundParameters, parcel, params);
        L5:
            android.hardware.tv.mediaquality.SoundProfile toReturn = new android.hardware.tv.mediaquality.SoundProfile();
            toReturn.soundProfileId = id.longValue();
            toReturn.parameters = soundParameters;
            return toReturn;
        }

        private HalNotifier(MediaQualityService r1) {
            this.this$0 = r1;
        }
    }

    private class MediaQualityManagerPictureProfileCallbackList extends RemoteCallbackList<IPictureProfileCallback> {
        final /* synthetic */ MediaQualityService this$0;

        /* synthetic */ MediaQualityManagerPictureProfileCallbackList(MediaQualityService r1, MediaQualityServiceIA r2) {
            this(r1);
        }

        private MediaQualityManagerPictureProfileCallbackList(MediaQualityService r1) {
            this.this$0 = r1;
        }

        @Override // android.os.RemoteCallbackList
        public /* bridge */ /* synthetic */ void onCallbackDied(IInterface r1) {
            onCallbackDied((IPictureProfileCallback) r1);
        }

        public void onCallbackDied(IPictureProfileCallback callback) {
            Object r0 = MediaQualityService.m5854$$Nest$fgetmPictureProfileLock(this.this$0);
            monitor-enter(r0);
            int i = 0;
        L15:
        L8:
            th = move-exception;
            throw th;
        L6:
            if (i >= MediaQualityService.m5862$$Nest$fgetmUserStates(this.this$0).size()) goto L11;
            int userId = MediaQualityService.m5862$$Nest$fgetmUserStates(this.this$0).keyAt(i);     // Catch: Throwable -> L8
            UserState userState = MediaQualityService.m5863$$Nest$mgetOrCreateUserState(this.this$0, userId);     // Catch: Throwable -> L8
            UserState.m5894$$Nest$fgetmPictureProfileCallbackPidUidMap(userState).remove(callback);     // Catch: Throwable -> L8
            i = i + 1;     // Catch: Throwable -> L8
            goto L15
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L8
        }
    }

    private class MediaQualityManagerSoundProfileCallbackList extends RemoteCallbackList<ISoundProfileCallback> {
        final /* synthetic */ MediaQualityService this$0;

        /* synthetic */ MediaQualityManagerSoundProfileCallbackList(MediaQualityService r1, MediaQualityServiceIA r2) {
            this(r1);
        }

        private MediaQualityManagerSoundProfileCallbackList(MediaQualityService r1) {
            this.this$0 = r1;
        }

        @Override // android.os.RemoteCallbackList
        public /* bridge */ /* synthetic */ void onCallbackDied(IInterface r1) {
            onCallbackDied((ISoundProfileCallback) r1);
        }

        public void onCallbackDied(ISoundProfileCallback callback) {
            Object r0 = MediaQualityService.m5858$$Nest$fgetmSoundProfileLock(this.this$0);
            monitor-enter(r0);
            int i = 0;
        L15:
        L8:
            th = move-exception;
            throw th;
        L6:
            if (i >= MediaQualityService.m5862$$Nest$fgetmUserStates(this.this$0).size()) goto L11;
            int userId = MediaQualityService.m5862$$Nest$fgetmUserStates(this.this$0).keyAt(i);     // Catch: Throwable -> L8
            UserState userState = MediaQualityService.m5863$$Nest$mgetOrCreateUserState(this.this$0, userId);     // Catch: Throwable -> L8
            UserState.m5896$$Nest$fgetmSoundProfileCallbackPidUidMap(userState).remove(callback);     // Catch: Throwable -> L8
            i = i + 1;     // Catch: Throwable -> L8
            goto L15
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L8
        }
    }

    private final class MqDatabaseUtils {
        final /* synthetic */ MediaQualityService this$0;

        /* JADX INFO: renamed from: -$$Nest$mgetCursorAfterQuerying, reason: not valid java name */
        static /* bridge */ /* synthetic */ Cursor m5876$$Nest$mgetCursorAfterQuerying(MqDatabaseUtils r0, String r1, String[] r2, String r3, String[] r4) {
            return r0.getCursorAfterQuerying(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mgetPictureProfile, reason: not valid java name */
        static /* bridge */ /* synthetic */ PictureProfile m5877$$Nest$mgetPictureProfile(MqDatabaseUtils r0, Long r1) {
            return r0.getPictureProfile(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mgetPictureProfilesBasedOnConditions, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m5878$$Nest$mgetPictureProfilesBasedOnConditions(MqDatabaseUtils r0, String[] r1, String r2, String[] r3) {
            return r0.getPictureProfilesBasedOnConditions(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$mgetSoundProfile, reason: not valid java name */
        static /* bridge */ /* synthetic */ SoundProfile m5879$$Nest$mgetSoundProfile(MqDatabaseUtils r0, Long r1) {
            return r0.getSoundProfile(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mgetSoundProfilesBasedOnConditions, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m5880$$Nest$mgetSoundProfilesBasedOnConditions(MqDatabaseUtils r0, String[] r1, String r2, String[] r3) {
            return r0.getSoundProfilesBasedOnConditions(r1, r2, r3);
        }

        /* synthetic */ MqDatabaseUtils(MediaQualityService r1, MediaQualityServiceIA r2) {
            this(r1);
        }

        private PictureProfile getPictureProfile(Long dbId) {
            return getPictureProfile(dbId, false);
        }

        private PictureProfile getPictureProfile(Long dbId, boolean includeParams) {
            String[] selectionArguments = {Long.toString(dbId.longValue())};
            MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0);
            Cursor cursor = getCursorAfterQuerying(MediaQualityDbHelper.PICTURE_QUALITY_TABLE_NAME, MediaQualityUtils.getMediaProfileColumns(includeParams), "_id = ?", selectionArguments);
            int count = cursor.getCount();     // Catch: Throwable -> L13
            if (count != 0) goto L9;
            cursor.close();
            return null;
        L9:
            if (count <= 1) goto L15;
            String r7 = String.valueOf(Locale.US);     // Catch: Throwable -> L13
            Integer r9 = Integer.valueOf(count);     // Catch: Throwable -> L13
            MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0);     // Catch: Throwable -> L13
            Log.wtf(MediaQualityService.TAG, TextUtils.formatSimple(r7, new Object[]{"%d entries found for id=%d in %s. Should only ever be 0 or 1.", r9, dbId, MediaQualityDbHelper.PICTURE_QUALITY_TABLE_NAME}));     // Catch: Throwable -> L13
            cursor.close();
            return null;
        L15:
            cursor.moveToFirst();     // Catch: Throwable -> L13
            PictureProfile r3 = MediaQualityUtils.convertCursorToPictureProfileWithTempId(cursor, MediaQualityService.m5856$$Nest$fgetmPictureProfileTempIdMap(this.this$0));     // Catch: Throwable -> L13
            cursor.close();
            return r3;
        L13:
            th = move-exception;
            if (cursor != null) goto L25;
        L23:
            throw th;
        L25:
            cursor.close();     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            th.addSuppressed(th);
            goto L23
        }

        private List<PictureProfile> getPictureProfilesBasedOnConditions(String[] columns, String selection, String[] selectionArguments) {
            MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0);
            Cursor cursor = getCursorAfterQuerying(MediaQualityDbHelper.PICTURE_QUALITY_TABLE_NAME, columns, selection, selectionArguments);
            List<PictureProfile> pictureProfiles = new ArrayList();     // Catch: Throwable -> L8
        L5:
            if (cursor.moveToNext() == false) goto L10;
            pictureProfiles.add(MediaQualityUtils.convertCursorToPictureProfileWithTempId(cursor, MediaQualityService.m5856$$Nest$fgetmPictureProfileTempIdMap(this.this$0)));     // Catch: Throwable -> L8
            goto L5
        L10:
            cursor.close();
            return pictureProfiles;
        L8:
            th = move-exception;
            if (cursor != null) goto L18;
        L17:
            throw th;
        L18:
            cursor.close();     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            th.addSuppressed(th);
            goto L17
        }

        private SoundProfile getSoundProfile(Long dbId) {
            String[] selectionArguments = {Long.toString(dbId.longValue())};
            MqDatabaseUtils r2 = MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0);
            MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0);
            Cursor cursor = r2.getCursorAfterQuerying(MediaQualityDbHelper.SOUND_QUALITY_TABLE_NAME, MediaQualityUtils.getMediaProfileColumns(false), "_id = ?", selectionArguments);
            int count = cursor.getCount();     // Catch: Throwable -> L13
            if (count != 0) goto L9;
            cursor.close();
            return null;
        L9:
            if (count <= 1) goto L15;
            String r7 = String.valueOf(Locale.US);     // Catch: Throwable -> L13
            Integer r9 = Integer.valueOf(count);     // Catch: Throwable -> L13
            MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0);     // Catch: Throwable -> L13
            Log.wtf(MediaQualityService.TAG, TextUtils.formatSimple(r7, new Object[]{"%d entries found for id=%s in %s. Should only ever be 0 or 1.", r9, dbId, MediaQualityDbHelper.SOUND_QUALITY_TABLE_NAME}));     // Catch: Throwable -> L13
            cursor.close();
            return null;
        L15:
            cursor.moveToFirst();     // Catch: Throwable -> L13
            SoundProfile r4 = MediaQualityUtils.convertCursorToSoundProfileWithTempId(cursor, MediaQualityService.m5860$$Nest$fgetmSoundProfileTempIdMap(this.this$0));     // Catch: Throwable -> L13
            cursor.close();
            return r4;
        L13:
            th = move-exception;
            if (cursor != null) goto L24;
        L23:
            throw th;
        L24:
            cursor.close();     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            th.addSuppressed(th);
            goto L23
        }

        private List<SoundProfile> getSoundProfilesBasedOnConditions(String[] columns, String selection, String[] selectionArguments) {
            MqDatabaseUtils r0 = MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0);
            MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0);
            Cursor cursor = r0.getCursorAfterQuerying(MediaQualityDbHelper.SOUND_QUALITY_TABLE_NAME, columns, selection, selectionArguments);
            List<SoundProfile> soundProfiles = new ArrayList();     // Catch: Throwable -> L8
        L5:
            if (cursor.moveToNext() == false) goto L10;
            soundProfiles.add(MediaQualityUtils.convertCursorToSoundProfileWithTempId(cursor, MediaQualityService.m5860$$Nest$fgetmSoundProfileTempIdMap(this.this$0)));     // Catch: Throwable -> L8
            goto L5
        L10:
            cursor.close();
            return soundProfiles;
        L8:
            th = move-exception;
            if (cursor != null) goto L18;
        L17:
            throw th;
        L18:
            cursor.close();     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            th.addSuppressed(th);
            goto L17
        }

        private Cursor getCursorAfterQuerying(String table, String[] columns, String selection, String[] selectionArgs) {
            SQLiteDatabase db = MediaQualityService.m5849$$Nest$fgetmMediaQualityDbHelper(this.this$0).getReadableDatabase();
            return db.query(table, columns, selection, selectionArgs, null, null, null);
        }

        private MqDatabaseUtils(MediaQualityService r1) {
            this.this$0 = r1;
        }
    }

    private final class MqManagerNotifier {
        final /* synthetic */ MediaQualityService this$0;

        @Retention(RetentionPolicy.SOURCE)
        private @interface ProfileModes {
            public static final int ADD = 1;
            public static final int ERROR = 4;
            public static final int PARAMETER_CAPABILITY_CHANGED = 5;
            public static final int REMOVE = 3;
            public static final int UPDATE = 2;
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyOnPictureProfileAdded, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5881$$Nest$mnotifyOnPictureProfileAdded(MqManagerNotifier r0, String r1, PictureProfile r2, int r3, int r4) {
            r0.notifyOnPictureProfileAdded(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyOnPictureProfileError, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5882$$Nest$mnotifyOnPictureProfileError(MqManagerNotifier r0, String r1, int r2, int r3, int r4) {
            r0.notifyOnPictureProfileError(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyOnPictureProfileParameterCapabilitiesChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5883$$Nest$mnotifyOnPictureProfileParameterCapabilitiesChanged(MqManagerNotifier r0, Long r1, ParamCapability[] r2, int r3, int r4) {
            r0.notifyOnPictureProfileParameterCapabilitiesChanged(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyOnPictureProfileRemoved, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5884$$Nest$mnotifyOnPictureProfileRemoved(MqManagerNotifier r0, String r1, PictureProfile r2, int r3, int r4) {
            r0.notifyOnPictureProfileRemoved(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyOnPictureProfileUpdated, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5885$$Nest$mnotifyOnPictureProfileUpdated(MqManagerNotifier r0, String r1, PictureProfile r2, int r3, int r4) {
            r0.notifyOnPictureProfileUpdated(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyOnSoundProfileAdded, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5886$$Nest$mnotifyOnSoundProfileAdded(MqManagerNotifier r0, String r1, SoundProfile r2, int r3, int r4) {
            r0.notifyOnSoundProfileAdded(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyOnSoundProfileError, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5887$$Nest$mnotifyOnSoundProfileError(MqManagerNotifier r0, String r1, int r2, int r3, int r4) {
            r0.notifyOnSoundProfileError(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyOnSoundProfileParameterCapabilitiesChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5888$$Nest$mnotifyOnSoundProfileParameterCapabilitiesChanged(MqManagerNotifier r0, Long r1, ParamCapability[] r2, int r3, int r4) {
            r0.notifyOnSoundProfileParameterCapabilitiesChanged(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyOnSoundProfileRemoved, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5889$$Nest$mnotifyOnSoundProfileRemoved(MqManagerNotifier r0, String r1, SoundProfile r2, int r3, int r4) {
            r0.notifyOnSoundProfileRemoved(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyOnSoundProfileUpdated, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5890$$Nest$mnotifyOnSoundProfileUpdated(MqManagerNotifier r0, String r1, SoundProfile r2, int r3, int r4) {
            r0.notifyOnSoundProfileUpdated(r1, r2, r3, r4);
        }

        /* synthetic */ MqManagerNotifier(MediaQualityService r1, MediaQualityServiceIA r2) {
            this(r1);
        }

        private void notifyOnPictureProfileAdded(String profileId, PictureProfile profile, int uid, int pid) {
            notifyPictureProfileHelper(1, profileId, profile, null, null, uid, pid);
        }

        private void notifyOnPictureProfileUpdated(String profileId, PictureProfile profile, int uid, int pid) {
            notifyPictureProfileHelper(2, profileId, profile, null, null, uid, pid);
        }

        private void notifyOnPictureProfileRemoved(String profileId, PictureProfile profile, int uid, int pid) {
            notifyPictureProfileHelper(3, profileId, profile, null, null, uid, pid);
        }

        private void notifyOnPictureProfileError(String profileId, int errorCode, int uid, int pid) {
            notifyPictureProfileHelper(4, profileId, null, Integer.valueOf(errorCode), null, uid, pid);
        }

        private void notifyOnPictureProfileParameterCapabilitiesChanged(Long profileId, ParamCapability[] caps, int uid, int pid) {
            String uuid = (String) MediaQualityService.m5856$$Nest$fgetmPictureProfileTempIdMap(this.this$0).getValue(profileId);
            List<ParameterCapability> paramCaps = new ArrayList();
            int r0 = caps.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            ParamCapability cap = caps[r2];
            String name = MediaQualityUtils.getParameterName(cap.name);
            boolean isSupported = cap.isSupported;
            if (cap.defaultValue != null) goto L7;
            int type = 0;
        L8:
            Bundle bundle = MediaQualityUtils.convertToCaps(type, cap.range);
            paramCaps.add(new ParameterCapability(name, isSupported, type, bundle));
            r2 = r2 + 1;
            goto L3
        L7:
            type = cap.defaultValue.getTag() + 1;
            goto L8
        L9:
            notifyPictureProfileHelper(5, uuid, null, null, paramCaps, uid, pid);
        }

        private void notifyPictureProfileHelper(int mode, String profileId, PictureProfile profile, Integer errorCode, List<ParameterCapability> paramCaps, int uid, int pid) {
            UserState userState = MediaQualityService.m5863$$Nest$mgetOrCreateUserState(this.this$0, 0);
            int n = UserState.m5895$$Nest$fgetmPictureProfileCallbacks(userState).beginBroadcast();
            int i = 0;
        L3:
            if (i >= n) goto L51;
            IPictureProfileCallback callback = UserState.m5895$$Nest$fgetmPictureProfileCallbacks(userState).getBroadcastItem(i);     // Catch: RemoteException -> L35
            Pair<Integer, Integer> pidUid = (Pair) UserState.m5894$$Nest$fgetmPictureProfileCallbackPidUidMap(userState).get(callback);     // Catch: RemoteException -> L35
            if (((Integer) pidUid.first).intValue() != pid) goto L50;
            if (((Integer) pidUid.second).intValue() != uid) goto L50;
            if (mode == 1) goto L57;
            if (mode != 2) goto L17;
            UserState.m5895$$Nest$fgetmPictureProfileCallbacks(userState).getBroadcastItem(i).onPictureProfileUpdated(profileId, profile);     // Catch: RemoteException -> L13
            goto L50
        L17:
            if (mode != 3) goto L19;
            UserState.m5895$$Nest$fgetmPictureProfileCallbacks(userState).getBroadcastItem(i).onPictureProfileRemoved(profileId, profile);     // Catch: RemoteException -> L13
            goto L50
        L19:
            if (mode != 4) goto L22;
            UserState.m5895$$Nest$fgetmPictureProfileCallbacks(userState).getBroadcastItem(i).onError(profileId, errorCode.intValue());     // Catch: RemoteException -> L13
            goto L50
        L22:
            if (mode != 5) goto L50;
            UserState.m5895$$Nest$fgetmPictureProfileCallbacks(userState).getBroadcastItem(i).onParameterCapabilitiesChanged(profileId, paramCaps);     // Catch: RemoteException -> L27
        L27:
            e = e;
        L38:
            if (mode != 1) goto L40;
            Slog.e(MediaQualityService.TAG, "Failed to report added picture profile to callback", e);
            goto L50
        L40:
            if (mode != 2) goto L42;
            Slog.e(MediaQualityService.TAG, "Failed to report updated picture profile to callback", e);
            goto L50
        L42:
            if (mode != 3) goto L45;
            Slog.e(MediaQualityService.TAG, "Failed to report removed picture profile to callback", e);
            goto L50
        L45:
            if (mode != 4) goto L48;
            Slog.e(MediaQualityService.TAG, "Failed to report picture profile error to callback", e);
            goto L50
        L48:
            if (mode != 5) goto L50;
            Slog.e(MediaQualityService.TAG, "Failed to report picture profile parameter capability change to callback", e);
            goto L50
        L57:
            UserState.m5895$$Nest$fgetmPictureProfileCallbacks(userState).getBroadcastItem(i).onPictureProfileAdded(profileId, profile);     // Catch: RemoteException -> L13
        L13:
            e = e;
        L31:
            e = e;
        L50:
            i = i + 1;
        L35:
            e = e;
            goto L38
        L51:
            UserState.m5895$$Nest$fgetmPictureProfileCallbacks(userState).finishBroadcast();
        }

        private void notifyOnSoundProfileAdded(String profileId, SoundProfile profile, int uid, int pid) {
            notifySoundProfileHelper(1, profileId, profile, null, null, uid, pid);
        }

        private void notifyOnSoundProfileUpdated(String profileId, SoundProfile profile, int uid, int pid) {
            notifySoundProfileHelper(2, profileId, profile, null, null, uid, pid);
        }

        private void notifyOnSoundProfileRemoved(String profileId, SoundProfile profile, int uid, int pid) {
            notifySoundProfileHelper(3, profileId, profile, null, null, uid, pid);
        }

        private void notifyOnSoundProfileError(String profileId, int errorCode, int uid, int pid) {
            notifySoundProfileHelper(4, profileId, null, Integer.valueOf(errorCode), null, uid, pid);
        }

        private void notifyOnSoundProfileParameterCapabilitiesChanged(Long profileId, ParamCapability[] caps, int uid, int pid) {
            String uuid = (String) MediaQualityService.m5860$$Nest$fgetmSoundProfileTempIdMap(this.this$0).getValue(profileId);
            List<ParameterCapability> paramCaps = new ArrayList();
            int r0 = caps.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            ParamCapability cap = caps[r2];
            String name = MediaQualityUtils.getParameterName(cap.name);
            boolean isSupported = cap.isSupported;
            if (cap.defaultValue != null) goto L7;
            int type = 0;
        L8:
            Bundle bundle = MediaQualityUtils.convertToCaps(type, cap.range);
            paramCaps.add(new ParameterCapability(name, isSupported, type, bundle));
            r2 = r2 + 1;
            goto L3
        L7:
            type = cap.defaultValue.getTag() + 1;
            goto L8
        L9:
            notifySoundProfileHelper(5, uuid, null, null, paramCaps, uid, pid);
        }

        private void notifySoundProfileHelper(int mode, String profileId, SoundProfile profile, Integer errorCode, List<ParameterCapability> paramCaps, int uid, int pid) {
            UserState userState = MediaQualityService.m5863$$Nest$mgetOrCreateUserState(this.this$0, 0);
            int n = UserState.m5897$$Nest$fgetmSoundProfileCallbacks(userState).beginBroadcast();
            int i = 0;
        L3:
            if (i >= n) goto L51;
            ISoundProfileCallback callback = UserState.m5897$$Nest$fgetmSoundProfileCallbacks(userState).getBroadcastItem(i);     // Catch: RemoteException -> L35
            Pair<Integer, Integer> pidUid = (Pair) UserState.m5896$$Nest$fgetmSoundProfileCallbackPidUidMap(userState).get(callback);     // Catch: RemoteException -> L35
            if (((Integer) pidUid.first).intValue() != pid) goto L50;
            if (((Integer) pidUid.second).intValue() != uid) goto L50;
            if (mode == 1) goto L57;
            if (mode != 2) goto L17;
            UserState.m5897$$Nest$fgetmSoundProfileCallbacks(userState).getBroadcastItem(i).onSoundProfileUpdated(profileId, profile);     // Catch: RemoteException -> L13
            goto L50
        L17:
            if (mode != 3) goto L19;
            UserState.m5897$$Nest$fgetmSoundProfileCallbacks(userState).getBroadcastItem(i).onSoundProfileRemoved(profileId, profile);     // Catch: RemoteException -> L13
            goto L50
        L19:
            if (mode != 4) goto L22;
            UserState.m5897$$Nest$fgetmSoundProfileCallbacks(userState).getBroadcastItem(i).onError(profileId, errorCode.intValue());     // Catch: RemoteException -> L13
            goto L50
        L22:
            if (mode != 5) goto L50;
            UserState.m5897$$Nest$fgetmSoundProfileCallbacks(userState).getBroadcastItem(i).onParameterCapabilitiesChanged(profileId, paramCaps);     // Catch: RemoteException -> L27
        L27:
            e = e;
        L38:
            if (mode != 1) goto L40;
            Slog.e(MediaQualityService.TAG, "Failed to report added sound profile to callback", e);
            goto L50
        L40:
            if (mode != 2) goto L42;
            Slog.e(MediaQualityService.TAG, "Failed to report updated sound profile to callback", e);
            goto L50
        L42:
            if (mode != 3) goto L45;
            Slog.e(MediaQualityService.TAG, "Failed to report removed sound profile to callback", e);
            goto L50
        L45:
            if (mode != 4) goto L48;
            Slog.e(MediaQualityService.TAG, "Failed to report sound profile error to callback", e);
            goto L50
        L48:
            if (mode != 5) goto L50;
            Slog.e(MediaQualityService.TAG, "Failed to report sound profile parameter capability change to callback", e);
            goto L50
        L57:
            UserState.m5897$$Nest$fgetmSoundProfileCallbacks(userState).getBroadcastItem(i).onSoundProfileAdded(profileId, profile);     // Catch: RemoteException -> L13
        L13:
            e = e;
        L31:
            e = e;
        L50:
            i = i + 1;
        L35:
            e = e;
            goto L38
        L51:
            UserState.m5897$$Nest$fgetmSoundProfileCallbacks(userState).finishBroadcast();
        }

        private MqManagerNotifier(MediaQualityService r1) {
            this.this$0 = r1;
        }
    }

    private final class PictureProfileAdjustmentListenerImpl extends IPictureProfileAdjustmentListener.Stub {
        final /* synthetic */ MediaQualityService this$0;

        /* JADX INFO: renamed from: $r8$lambda$o1iLVm9eg4-NqWRAXxTtdPS5gk4, reason: not valid java name */
        public static /* synthetic */ void m5891$r8$lambda$o1iLVm9eg4NqWRAXxTtdPS5gk4(PictureProfileAdjustmentListenerImpl r0, long r1, byte r3) {
            r0.lambda$onStreamStatusChanged$0(r1, r3);
        }

        /* synthetic */ PictureProfileAdjustmentListenerImpl(MediaQualityService r1, MediaQualityServiceIA r2) {
            this(r1);
        }

        @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
        public void onPictureProfileAdjusted(android.hardware.tv.mediaquality.PictureProfile pictureProfile) throws RemoteException {
            Long dbId = Long.valueOf(pictureProfile.pictureProfileId);
            this.this$0.updatePictureProfileFromHal(dbId, MediaQualityUtils.convertPictureParameterListToPersistableBundle(pictureProfile.parameters.pictureParameters));
        }

        @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
        public void onParamCapabilityChanged(long pictureProfileId, ParamCapability[] caps) throws RemoteException {
            MqManagerNotifier.m5883$$Nest$mnotifyOnPictureProfileParameterCapabilitiesChanged(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), Long.valueOf(pictureProfileId), caps, Binder.getCallingUid(), Binder.getCallingPid());
        }

        @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
        public void onVendorParamCapabilityChanged(long pictureProfileId, VendorParamCapability[] caps) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
        public void requestPictureParameters(long pictureProfileId) throws RemoteException {
            PictureProfile profile = MqDatabaseUtils.m5877$$Nest$mgetPictureProfile(MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0), Long.valueOf(pictureProfileId));
            if (profile == null) goto L6;
            HalNotifier.m5874$$Nest$mnotifyHalOnPictureProfileChange(MediaQualityService.m5845$$Nest$fgetmHalNotifier(this.this$0), Long.valueOf(pictureProfileId), profile.getParameters());
            return;
        }

        @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
        public void onStreamStatusChanged(final long profileHandle, final byte status) throws RemoteException {
            MediaQualityService.m5847$$Nest$fgetmHandler(this.this$0).post(new MediaQualityService$PictureProfileAdjustmentListenerImpl$$ExternalSyntheticLambda0(this, profileHandle, status));
        }

        private /* synthetic */ void lambda$onStreamStatusChanged$0(long profileHandle, byte status) {
            Object r0 = MediaQualityService.m5854$$Nest$fgetmPictureProfileLock(this.this$0);
            monitor-enter(r0);
            PictureProfile previous = (PictureProfile) MediaQualityService.m5846$$Nest$fgetmHandleToPictureProfile(this.this$0).get(Long.valueOf(profileHandle));     // Catch: Throwable -> L10
            if (previous != null) goto L12;
            previous = MqDatabaseUtils.m5877$$Nest$mgetPictureProfile(MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0), Long.valueOf(profileHandle));     // Catch: Throwable -> L10
            if (previous != null) goto L12;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L12:
            String[] arr = splitNameAndStatus(previous.getName());     // Catch: Throwable -> L10
            String profileName = arr[0];     // Catch: Throwable -> L10
            String profileStatus = arr[1];     // Catch: Throwable -> L10
            if (status == 2) goto L15;
            if (status == 0) goto L27;
        L37:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L27:
            if (isSdr(profileStatus) == false) goto L31;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L31:
            if (isHdr(profileStatus) == false) goto L37;
            String[] selectionArguments = {Integer.toString(previous.getProfileType()), previous.getPackageName(), profileName, profileName + SliceClientPermissions.SliceAuthority.DELIMITER + "SDR"};     // Catch: Throwable -> L10
            List<PictureProfile> list = MqDatabaseUtils.m5878$$Nest$mgetPictureProfilesBasedOnConditions(MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0), MediaQualityUtils.getMediaProfileColumns(true), "_type = ? AND _package = ? AND (_name = ? OR _name = ?)", selectionArguments);     // Catch: Throwable -> L10
            if (list.isEmpty() == false) goto L36;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L36:
            PictureProfile current = list.get(0);     // Catch: Throwable -> L10
            MediaQualityService.m5846$$Nest$fgetmHandleToPictureProfile(this.this$0).put(Long.valueOf(profileHandle), current);     // Catch: Throwable -> L10
            MediaQualityService.m5843$$Nest$fgetmCurrentPictureHandleToOriginal(this.this$0).put(Long.valueOf(current.getHandle().getId()), Long.valueOf(profileHandle));     // Catch: Throwable -> L10
            HalNotifier.m5874$$Nest$mnotifyHalOnPictureProfileChange(MediaQualityService.m5845$$Nest$fgetmHalNotifier(this.this$0), Long.valueOf(profileHandle), current.getParameters());     // Catch: Throwable -> L10
            goto L37
        L15:
            if (isHdr(profileStatus) == false) goto L19;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L19:
            if (isSdr(profileStatus) == false) goto L37;
            String[] selectionArguments2 = {Integer.toString(previous.getProfileType()), previous.getPackageName(), profileName + SliceClientPermissions.SliceAuthority.DELIMITER + "HDR"};     // Catch: Throwable -> L10
            List<PictureProfile> list2 = MqDatabaseUtils.m5878$$Nest$mgetPictureProfilesBasedOnConditions(MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0), MediaQualityUtils.getMediaProfileColumns(true), "_type = ? AND _package = ? AND _name = ?", selectionArguments2);     // Catch: Throwable -> L10
            if (list2.isEmpty() == false) goto L24;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L24:
            PictureProfile current2 = list2.get(0);     // Catch: Throwable -> L10
            MediaQualityService.m5846$$Nest$fgetmHandleToPictureProfile(this.this$0).put(Long.valueOf(profileHandle), current2);     // Catch: Throwable -> L10
            MediaQualityService.m5843$$Nest$fgetmCurrentPictureHandleToOriginal(this.this$0).put(Long.valueOf(current2.getHandle().getId()), Long.valueOf(profileHandle));     // Catch: Throwable -> L10
            HalNotifier.m5874$$Nest$mnotifyHalOnPictureProfileChange(MediaQualityService.m5845$$Nest$fgetmHalNotifier(this.this$0), Long.valueOf(profileHandle), current2.getParameters());     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        private String[] splitNameAndStatus(String nameAndStatus) {
            int index = nameAndStatus.lastIndexOf(47);
            if (index == (-1)) goto L10;
            if (index == (nameAndStatus.length() - 1)) goto L10;
            return new String[]{nameAndStatus.substring(0, index), nameAndStatus.substring(index + 1)};
        L10:
            return new String[]{nameAndStatus, ""};
        }

        private boolean isSdr(String profileStatus) {
            if (profileStatus.equals("SDR") == false) goto L5;
        L8:
            return true;
        L5:
            if (profileStatus.isEmpty() == true) goto L8;
            return false;
        }

        private boolean isHdr(String profileStatus) {
            return profileStatus.equals("HDR");
        }

        @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
        public int getInterfaceVersion() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
        public String getInterfaceHash() throws RemoteException {
            return null;
        }

        private PictureProfileAdjustmentListenerImpl(MediaQualityService r1) {
            this.this$0 = r1;
        }
    }

    private final class SoundProfileAdjustmentListenerImpl extends ISoundProfileAdjustmentListener.Stub {
        final /* synthetic */ MediaQualityService this$0;

        /* synthetic */ SoundProfileAdjustmentListenerImpl(MediaQualityService r1, MediaQualityServiceIA r2) {
            this(r1);
        }

        @Override // android.hardware.tv.mediaquality.ISoundProfileAdjustmentListener
        public void onSoundProfileAdjusted(android.hardware.tv.mediaquality.SoundProfile soundProfile) throws RemoteException {
            Long dbId = Long.valueOf(soundProfile.soundProfileId);
            this.this$0.updateSoundProfileFromHal(dbId, MediaQualityUtils.convertSoundParameterListToPersistableBundle(soundProfile.parameters.soundParameters));
        }

        @Override // android.hardware.tv.mediaquality.ISoundProfileAdjustmentListener
        public void onParamCapabilityChanged(long soundProfileId, ParamCapability[] caps) throws RemoteException {
            MqManagerNotifier.m5888$$Nest$mnotifyOnSoundProfileParameterCapabilitiesChanged(MediaQualityService.m5851$$Nest$fgetmMqManagerNotifier(this.this$0), Long.valueOf(soundProfileId), caps, Binder.getCallingUid(), Binder.getCallingPid());
        }

        @Override // android.hardware.tv.mediaquality.ISoundProfileAdjustmentListener
        public void onVendorParamCapabilityChanged(long pictureProfileId, VendorParamCapability[] caps) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.ISoundProfileAdjustmentListener
        public void requestSoundParameters(long soundProfileId) throws RemoteException {
            SoundProfile profile = MqDatabaseUtils.m5879$$Nest$mgetSoundProfile(MediaQualityService.m5850$$Nest$fgetmMqDatabaseUtils(this.this$0), Long.valueOf(soundProfileId));
            if (profile == null) goto L6;
            HalNotifier.m5875$$Nest$mnotifyHalOnSoundProfileChange(MediaQualityService.m5845$$Nest$fgetmHalNotifier(this.this$0), Long.valueOf(soundProfileId), profile.getParameters());
            return;
        }

        @Override // android.hardware.tv.mediaquality.ISoundProfileAdjustmentListener
        public int getInterfaceVersion() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.tv.mediaquality.ISoundProfileAdjustmentListener
        public String getInterfaceHash() throws RemoteException {
            return null;
        }

        private SoundProfileAdjustmentListenerImpl(MediaQualityService r1) {
            this.this$0 = r1;
        }
    }

    private final class UserState {
        private final ActiveProcessingPictureCallbackList mActiveProcessingPictureCallbackList;
        private final Map<IActiveProcessingPictureListener, ActiveProcessingPictureListenerInfo> mActiveProcessingPictureListenerMap;
        private final Map<IPictureProfileCallback, Pair<Integer, Integer>> mPictureProfileCallbackPidUidMap;
        private final MediaQualityManagerPictureProfileCallbackList mPictureProfileCallbacks;
        private final Map<ISoundProfileCallback, Pair<Integer, Integer>> mSoundProfileCallbackPidUidMap;
        private final MediaQualityManagerSoundProfileCallbackList mSoundProfileCallbacks;
        final /* synthetic */ MediaQualityService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmActiveProcessingPictureCallbackList, reason: not valid java name */
        static /* bridge */ /* synthetic */ ActiveProcessingPictureCallbackList m5892$$Nest$fgetmActiveProcessingPictureCallbackList(UserState r0) {
            return r0.mActiveProcessingPictureCallbackList;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmActiveProcessingPictureListenerMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m5893$$Nest$fgetmActiveProcessingPictureListenerMap(UserState r0) {
            return r0.mActiveProcessingPictureListenerMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPictureProfileCallbackPidUidMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m5894$$Nest$fgetmPictureProfileCallbackPidUidMap(UserState r0) {
            return r0.mPictureProfileCallbackPidUidMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPictureProfileCallbacks, reason: not valid java name */
        static /* bridge */ /* synthetic */ MediaQualityManagerPictureProfileCallbackList m5895$$Nest$fgetmPictureProfileCallbacks(UserState r0) {
            return r0.mPictureProfileCallbacks;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSoundProfileCallbackPidUidMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m5896$$Nest$fgetmSoundProfileCallbackPidUidMap(UserState r0) {
            return r0.mSoundProfileCallbackPidUidMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSoundProfileCallbacks, reason: not valid java name */
        static /* bridge */ /* synthetic */ MediaQualityManagerSoundProfileCallbackList m5897$$Nest$fgetmSoundProfileCallbacks(UserState r0) {
            return r0.mSoundProfileCallbacks;
        }

        /* synthetic */ UserState(MediaQualityService r1, Context r2, int r3, MediaQualityServiceIA r4) {
            this(r1, r2, r3);
        }

        private UserState(MediaQualityService r3, Context context, int userId) {
            this.this$0 = r3;
            MediaQualityServiceIA r1 = null;
            this.mPictureProfileCallbacks = new MediaQualityManagerPictureProfileCallbackList(this.this$0, r1);
            this.mSoundProfileCallbacks = new MediaQualityManagerSoundProfileCallbackList(this.this$0, r1);
            this.mActiveProcessingPictureCallbackList = new ActiveProcessingPictureCallbackList(this.this$0, r1);
            this.mPictureProfileCallbackPidUidMap = new HashMap();
            this.mSoundProfileCallbackPidUidMap = new HashMap();
            this.mActiveProcessingPictureListenerMap = new HashMap();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallbackRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m5841$$Nest$fgetmCallbackRecords(MediaQualityService r0) {
        return r0.mCallbackRecords;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m5842$$Nest$fgetmContext(MediaQualityService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentPictureHandleToOriginal, reason: not valid java name */
    static /* bridge */ /* synthetic */ BiMap m5843$$Nest$fgetmCurrentPictureHandleToOriginal(MediaQualityService r0) {
        return r0.mCurrentPictureHandleToOriginal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHalAmbientBacklightCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ HalAmbientBacklightCallback m5844$$Nest$fgetmHalAmbientBacklightCallback(MediaQualityService r0) {
        return r0.mHalAmbientBacklightCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHalNotifier, reason: not valid java name */
    static /* bridge */ /* synthetic */ HalNotifier m5845$$Nest$fgetmHalNotifier(MediaQualityService r0) {
        return r0.mHalNotifier;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandleToPictureProfile, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m5846$$Nest$fgetmHandleToPictureProfile(MediaQualityService r0) {
        return r0.mHandleToPictureProfile;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m5847$$Nest$fgetmHandler(MediaQualityService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMediaQuality, reason: not valid java name */
    static /* bridge */ /* synthetic */ IMediaQuality m5848$$Nest$fgetmMediaQuality(MediaQualityService r0) {
        return r0.mMediaQuality;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMediaQualityDbHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ MediaQualityDbHelper m5849$$Nest$fgetmMediaQualityDbHelper(MediaQualityService r0) {
        return r0.mMediaQualityDbHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMqDatabaseUtils, reason: not valid java name */
    static /* bridge */ /* synthetic */ MqDatabaseUtils m5850$$Nest$fgetmMqDatabaseUtils(MediaQualityService r0) {
        return r0.mMqDatabaseUtils;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMqManagerNotifier, reason: not valid java name */
    static /* bridge */ /* synthetic */ MqManagerNotifier m5851$$Nest$fgetmMqManagerNotifier(MediaQualityService r0) {
        return r0.mMqManagerNotifier;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageDefaultPictureProfileHandleMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m5852$$Nest$fgetmPackageDefaultPictureProfileHandleMap(MediaQualityService r0) {
        return r0.mPackageDefaultPictureProfileHandleMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManager m5853$$Nest$fgetmPackageManager(MediaQualityService r0) {
        return r0.mPackageManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPictureProfileLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m5854$$Nest$fgetmPictureProfileLock(MediaQualityService r0) {
        return r0.mPictureProfileLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPictureProfileSharedPreference, reason: not valid java name */
    static /* bridge */ /* synthetic */ SharedPreferences m5855$$Nest$fgetmPictureProfileSharedPreference(MediaQualityService r0) {
        return r0.mPictureProfileSharedPreference;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPictureProfileTempIdMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ BiMap m5856$$Nest$fgetmPictureProfileTempIdMap(MediaQualityService r0) {
        return r0.mPictureProfileTempIdMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPpChangedListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ IPictureProfileChangedListener m5857$$Nest$fgetmPpChangedListener(MediaQualityService r0) {
        return r0.mPpChangedListener;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSoundProfileLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m5858$$Nest$fgetmSoundProfileLock(MediaQualityService r0) {
        return r0.mSoundProfileLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSoundProfileSharedPreference, reason: not valid java name */
    static /* bridge */ /* synthetic */ SharedPreferences m5859$$Nest$fgetmSoundProfileSharedPreference(MediaQualityService r0) {
        return r0.mSoundProfileSharedPreference;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSoundProfileTempIdMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ BiMap m5860$$Nest$fgetmSoundProfileTempIdMap(MediaQualityService r0) {
        return r0.mSoundProfileTempIdMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSpChangedListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ ISoundProfileChangedListener m5861$$Nest$fgetmSpChangedListener(MediaQualityService r0) {
        return r0.mSpChangedListener;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserStates, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m5862$$Nest$fgetmUserStates(MediaQualityService r0) {
        return r0.mUserStates;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetOrCreateUserState, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserState m5863$$Nest$mgetOrCreateUserState(MediaQualityService r0, int r1) {
        return r0.getOrCreateUserState(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnActivePicturesChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5864$$Nest$mhandleOnActivePicturesChanged(MediaQualityService r0, SurfaceControlActivePicture[] r1) {
        r0.handleOnActivePicturesChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misPackageDefaultPictureProfile, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5865$$Nest$misPackageDefaultPictureProfile(MediaQualityService r0, PictureProfile r1) {
        return r0.isPackageDefaultPictureProfile(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetVendorPictureParameters, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5866$$Nest$msetVendorPictureParameters(MediaQualityService r0, PictureParameters r1, Parcel r2, PersistableBundle r3) {
        r0.setVendorPictureParameters(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msetVendorSoundParameters, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5867$$Nest$msetVendorSoundParameters(MediaQualityService r0, SoundParameters r1, Parcel r2, PersistableBundle r3) {
        r0.setVendorSoundParameters(r1, r2, r3);
    }

    public MediaQualityService(Context context) {
        super(context);
        this.mPackageDefaultPictureProfileHandleMap = new HashMap();
        this.mCallbackRecords = new HashMap();
        this.mUserStates = new SparseArray();
        this.mPictureProfileLock = new Object();
        this.mSoundProfileLock = new Object();
        this.mUserStateLock = new Object();
        this.mAmbientBacklightLock = new Object();
        this.mHandleToPictureProfile = new HashMap();
        this.mCurrentPictureHandleToOriginal = new BiMap();
        this.mContext = context;
        MediaQualityServiceIA r1 = null;
        this.mHalAmbientBacklightCallback = new HalAmbientBacklightCallback(this, r1);
        this.mPackageManager = this.mContext.getPackageManager();
        this.mPictureProfileTempIdMap = new BiMap();
        this.mSoundProfileTempIdMap = new BiMap();
        this.mMediaQualityDbHelper = new MediaQualityDbHelper(this.mContext);
        this.mMediaQualityDbHelper.setWriteAheadLoggingEnabled(true);
        this.mMediaQualityDbHelper.setIdleConnectionTimeout(30);
        this.mMqManagerNotifier = new MqManagerNotifier(this, r1);
        this.mMqDatabaseUtils = new MqDatabaseUtils(this, r1);
        this.mHalNotifier = new HalNotifier(this, r1);
        this.mPictureProfileAdjListener = new PictureProfileAdjustmentListenerImpl(this, r1);
        this.mSoundProfileAdjListener = new SoundProfileAdjustmentListenerImpl(this, r1);
        this.mHandler = new Handler(Looper.getMainLooper());
        Context deviceContext = this.mContext.createDeviceProtectedStorageContext();
        File pictureProfilePrefs = new File(Environment.getDataSystemDirectory(), PICTURE_PROFILE_PREFERENCE);
        this.mPictureProfileSharedPreference = deviceContext.getSharedPreferences(pictureProfilePrefs, 0);
        File soundProfilePrefs = new File(Environment.getDataSystemDirectory(), SOUND_PROFILE_PREFERENCE);
        this.mSoundProfileSharedPreference = deviceContext.getSharedPreferences(soundProfilePrefs, 0);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        IBinder binder = ServiceManager.getService(IMediaQuality.DESCRIPTOR + "/default");
        if (binder != null) goto L6;
        Slogf.d(TAG, "Binder is null");
        return;
    L6:
        Slogf.d(TAG, "Binder is not null");
        this.mSurfaceControlActivePictureListener = new AnonymousClass1(this);
        this.mSurfaceControlActivePictureListener.startListening();
        this.mMediaQuality = IMediaQuality.Stub.asInterface(binder);
        if (this.mMediaQuality != null) goto L24;
    L22:
        publishBinderService("media_quality", new BinderService(this, null));
        return;
    L24:
        this.mMediaQuality.setAmbientBacklightCallback(this.mHalAmbientBacklightCallback);     // Catch: RemoteException -> L20
        this.mPpChangedListener = this.mMediaQuality.getPictureProfileListener();     // Catch: RemoteException -> L20
        this.mSpChangedListener = this.mMediaQuality.getSoundProfileListener();     // Catch: RemoteException -> L20
        this.mMediaQuality.setPictureProfileAdjustmentListener(this.mPictureProfileAdjListener);     // Catch: RemoteException -> L20
        this.mMediaQuality.setSoundProfileAdjustmentListener(this.mSoundProfileAdjListener);     // Catch: RemoteException -> L20
        Object r1 = this.mPictureProfileLock;     // Catch: RemoteException -> L20
        monitor-enter(r1);     // Catch: RemoteException -> L20
        String[] selectionArguments = {Integer.toString(1), "default"};     // Catch: Throwable -> L14
        List<PictureProfile> packageDefaultPictureProfiles = MqDatabaseUtils.m5878$$Nest$mgetPictureProfilesBasedOnConditions(this.mMqDatabaseUtils, MediaQualityUtils.getMediaProfileColumns(false), "_type = ? AND _name = ?", selectionArguments);     // Catch: Throwable -> L14
        this.mPackageDefaultPictureProfileHandleMap.clear();     // Catch: Throwable -> L14
        Iterator<PictureProfile> r5 = packageDefaultPictureProfiles.iterator();     // Catch: Throwable -> L14
    L12:
        if (r5.hasNext() == false) goto L16;
        PictureProfile profile = r5.next();     // Catch: Throwable -> L14
        this.mPackageDefaultPictureProfileHandleMap.put(profile.getPackageName(), Long.valueOf(profile.getHandle().getId()));     // Catch: Throwable -> L14
        goto L12
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L20
    L20:
        e = move-exception;
        Slog.e(TAG, "Failed to set ambient backlight detector callback", e);
        goto L22
    }

    private void handleOnActivePicturesChanged(SurfaceControlActivePicture[] scActivePictures) {
        MediaQualityService r1 = this;
        Object r3 = r1.mPictureProfileLock;
        monitor-enter(r3);
        int r4 = 0;
        UserState userState = r1.getOrCreateUserState(0);     // Catch: Throwable -> L22
        int n = UserState.m5892$$Nest$fgetmActiveProcessingPictureCallbackList(userState).beginBroadcast();     // Catch: Throwable -> L22
        int i = 0;
    L7:
        if (i >= n) goto L40;
        IActiveProcessingPictureListener l = UserState.m5892$$Nest$fgetmActiveProcessingPictureCallbackList(userState).getBroadcastItem(i);     // Catch: Throwable -> L22 RemoteException -> L24
        ActiveProcessingPictureListenerInfo info = (ActiveProcessingPictureListenerInfo) UserState.m5893$$Nest$fgetmActiveProcessingPictureListenerMap(userState).get(l);     // Catch: Throwable -> L22 RemoteException -> L24
        if (info == null) goto L39;
        int uid = ActiveProcessingPictureListenerInfo.m5869$$Nest$fgetmUid(info);     // Catch: Throwable -> L22 RemoteException -> L24
        if (r1.mContext.checkPermission("android.permission.MANAGE_GLOBAL_PICTURE_QUALITY_SERVICE", ActiveProcessingPictureListenerInfo.m5868$$Nest$fgetmPid(info), uid) != 0) goto L14;
        int r10 = 1;
    L15:
        List<ActiveProcessingPicture> aps = new ArrayList();     // Catch: Throwable -> L22 RemoteException -> L24
        int r13 = scActivePictures.length;     // Catch: Throwable -> L22 RemoteException -> L24
        int r14 = r4;
    L16:
        if (r14 >= r13) goto L35;
        SurfaceControlActivePicture scap = scActivePictures[r14];     // Catch: Throwable -> L22 RemoteException -> L24
        if (r10 == 0) goto L20;
    L26:
        String profileId = r1.mPictureProfileTempIdMap.getValue(Long.valueOf(scap.getPictureProfileHandle().getId()));     // Catch: Throwable -> L22 RemoteException -> L24
        if (profileId == null) goto L34;
        int r2 = scap.getLayerId();     // Catch: Throwable -> L22 RemoteException -> L24
        if (scap.getOwnerUid() == uid) goto L32;
        boolean r5 = true;
    L33:
        aps.add(new ActiveProcessingPicture(r2, profileId, r5));     // Catch: Throwable -> L22 RemoteException -> L24
        goto L34
    L32:
        r5 = false;
    L34:
        r14 = r14 + 1;     // Catch: Throwable -> L22 RemoteException -> L24
        r1 = this;
        scActivePictures = scActivePictures;
        goto L16
    L20:
        if (scap.getOwnerUid() == uid) goto L26;
    L35:
        l.onActiveProcessingPicturesChanged(aps);     // Catch: Throwable -> L22 RemoteException -> L24
        goto L39
    L14:
        r10 = r4;
    L39:
        i = i + 1;     // Catch: Throwable -> L22
        r4 = 0;
        r1 = this;
        goto L7
    L24:
        e = move-exception;
        Slog.e(TAG, "failed to report added AD service to callback", e);     // Catch: Throwable -> L22
        goto L39
    L40:
        UserState.m5892$$Nest$fgetmActiveProcessingPictureCallbackList(userState).finishBroadcast();     // Catch: Throwable -> L22
        monitor-exit(r3);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public void updatePictureProfileFromHal(Long dbId, PersistableBundle bundle) {
        ContentValues values = MediaQualityUtils.getContentValues(dbId, null, null, null, null, bundle);
        updateDatabaseOnPictureProfileAndNotifyManagerAndHal(values, bundle);
    }

    public void updateDatabaseOnPictureProfileAndNotifyManagerAndHal(ContentValues values, PersistableBundle bundle) {
        SQLiteDatabase db = this.mMediaQualityDbHelper.getWritableDatabase();
        db.replace(MediaQualityDbHelper.PICTURE_QUALITY_TABLE_NAME, null, values);
        Long dbId = values.getAsLong("_id");
        MqManagerNotifier.m5885$$Nest$mnotifyOnPictureProfileUpdated(this.mMqManagerNotifier, this.mPictureProfileTempIdMap.getValue(dbId), MqDatabaseUtils.m5877$$Nest$mgetPictureProfile(this.mMqDatabaseUtils, dbId), Binder.getCallingUid(), Binder.getCallingPid());
        HalNotifier.m5874$$Nest$mnotifyHalOnPictureProfileChange(this.mHalNotifier, dbId, bundle);
    }

    public void updateSoundProfileFromHal(Long dbId, PersistableBundle bundle) {
        ContentValues values = MediaQualityUtils.getContentValues(dbId, null, null, null, null, bundle);
        updateDatabaseOnSoundProfileAndNotifyManagerAndHal(values, bundle);
    }

    public void updateDatabaseOnSoundProfileAndNotifyManagerAndHal(ContentValues values, PersistableBundle bundle) {
        SQLiteDatabase db = this.mMediaQualityDbHelper.getWritableDatabase();
        db.replace(MediaQualityDbHelper.SOUND_QUALITY_TABLE_NAME, null, values);
        Long dbId = values.getAsLong("_id");
        MqManagerNotifier.m5890$$Nest$mnotifyOnSoundProfileUpdated(this.mMqManagerNotifier, this.mSoundProfileTempIdMap.getValue(dbId), MqDatabaseUtils.m5879$$Nest$mgetSoundProfile(this.mMqDatabaseUtils, dbId), Binder.getCallingUid(), Binder.getCallingPid());
        HalNotifier.m5875$$Nest$mnotifyHalOnSoundProfileChange(this.mHalNotifier, dbId, bundle);
    }

    private UserState getOrCreateUserState(int userId) {
        UserState userState = getUserState(userId);
        if (userState != null) goto L12;
        UserState userState2 = new UserState(this, this.mContext, userId, null);
        Object r2 = this.mUserStateLock;
        monitor-enter(r2);
        this.mUserStates.put(userId, userState2);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return userState2;
    L9:
        th = move-exception;
        throw th;
    L12:
        return userState;
    }

    private UserState getUserState(int userId) {
        Object r0 = this.mUserStateLock;
        monitor-enter(r0);
        UserState r1 = this.mUserStates.get(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void setVendorPictureParameters(PictureParameters pictureParameters, Parcel parcel, PersistableBundle vendorPictureParameters) {
        vendorPictureParameters.writeToParcel(parcel, 0);
        byte[] vendorBundleToByteArray = parcel.marshall();
        DefaultExtension defaultExtension = new DefaultExtension();
        defaultExtension.bytes = Arrays.copyOf(vendorBundleToByteArray, vendorBundleToByteArray.length);
        pictureParameters.vendorPictureParameters.setParcelable(defaultExtension);
    }

    private void setVendorSoundParameters(SoundParameters soundParameters, Parcel parcel, PersistableBundle vendorSoundParameters) {
        vendorSoundParameters.writeToParcel(parcel, 0);
        byte[] vendorBundleToByteArray = parcel.marshall();
        DefaultExtension defaultExtension = new DefaultExtension();
        defaultExtension.bytes = Arrays.copyOf(vendorBundleToByteArray, vendorBundleToByteArray.length);
        soundParameters.vendorSoundParameters.setParcelable(defaultExtension);
    }

    private boolean isPackageDefaultPictureProfile(PictureProfile pp) {
        if (pp != null) goto L4;
    L8:
        return false;
    L4:
        if (pp.getProfileType() != 1) goto L8;
        if (pp.getName().equals("default") == false) goto L8;
        return true;
    }
}

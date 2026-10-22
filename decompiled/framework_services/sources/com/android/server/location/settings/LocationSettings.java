package com.android.server.location.settings;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.RemoteException;
import android.util.IndentingPrintWriter;
import android.util.SparseArray;
import com.android.server.FgThread;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class LocationSettings {
    private static final String LOCATION_DIRNAME = "location";
    private static final String LOCATION_SETTINGS_FILENAME = "settings";
    final Context mContext;
    private final SparseArray<LocationUserSettingsStore> mUserSettings;
    private final CopyOnWriteArrayList<LocationUserSettingsListener> mUserSettingsListeners;

    public interface LocationUserSettingsListener {
        void onLocationUserSettingsChanged(int r1, LocationUserSettings r2, LocationUserSettings r3);
    }

    class LocationUserSettingsStore extends SettingsStore<LocationUserSettings> {
        protected final int mUserId;
        final /* synthetic */ LocationSettings this$0;

        public static /* synthetic */ LocationUserSettings $r8$lambda$yOClNPCTa2Csu5CwDzIJaTFK3FQ(LocationUserSettingsStore r0, Function r1, LocationUserSettings r2) {
            return r0.lambda$update$0(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$zzWTqhG18ojZhv3BSXq3E22r9_c(LocationUserSettingsStore r0, LocationUserSettings r1, LocationUserSettings r2) {
            r0.lambda$onChange$1(r1, r2);
        }

        @Override // com.android.server.location.settings.SettingsStore
        protected /* bridge */ /* synthetic */ void onChange(SettingsStore.VersionedSettings r1, SettingsStore.VersionedSettings r2) {
            onChange((LocationUserSettings) r1, (LocationUserSettings) r2);
        }

        @Override // com.android.server.location.settings.SettingsStore
        protected /* bridge */ /* synthetic */ SettingsStore.VersionedSettings read(int r1, DataInput r2) throws IOException {
            return read(r1, r2);
        }

        @Override // com.android.server.location.settings.SettingsStore
        protected /* bridge */ /* synthetic */ void write(DataOutput r1, SettingsStore.VersionedSettings r2) throws IOException {
            write(r1, (LocationUserSettings) r2);
        }

        LocationUserSettingsStore(LocationSettings this$0, int userId, File file) {
            this.this$0 = this$0;
            super(file);
            this.mUserId = userId;
        }

        @Override // com.android.server.location.settings.SettingsStore
        protected LocationUserSettings read(int version, DataInput in) throws IOException {
            return filterSettings(LocationUserSettings.read(this.this$0.mContext.getResources(), version, in));
        }

        protected void write(DataOutput out, LocationUserSettings settings) throws IOException {
            settings.write(out);
        }

        private /* synthetic */ LocationUserSettings lambda$update$0(Function updater, LocationUserSettings settings) {
            return filterSettings((LocationUserSettings) updater.apply(settings));
        }

        @Override // com.android.server.location.settings.SettingsStore
        public void update(final Function<LocationUserSettings, LocationUserSettings> updater) {
            super.update(new LocationSettings$LocationUserSettingsStore$$ExternalSyntheticLambda0(this, updater));
        }

        private /* synthetic */ void lambda$onChange$1(LocationUserSettings oldSettings, LocationUserSettings newSettings) {
            this.this$0.fireListeners(this.mUserId, oldSettings, newSettings);
        }

        protected void onChange(final LocationUserSettings oldSettings, final LocationUserSettings newSettings) {
            FgThread.getExecutor().execute(new LocationSettings$LocationUserSettingsStore$$ExternalSyntheticLambda1(this, oldSettings, newSettings));
        }

        private LocationUserSettings filterSettings(LocationUserSettings settings) {
            if (settings.isAdasGnssLocationEnabled() == true) goto L5;
            return settings;
        L5:
            if (this.this$0.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive") == false) goto L7;
            return settings;
        L7:
            return settings.withAdasGnssLocationEnabled(false);
        }
    }

    public LocationSettings(Context context) {
        this.mContext = context;
        this.mUserSettings = new SparseArray(1);
        this.mUserSettingsListeners = new CopyOnWriteArrayList();
    }

    public final void registerLocationUserSettingsListener(LocationUserSettingsListener listener) {
        this.mUserSettingsListeners.add(listener);
    }

    public final void unregisterLocationUserSettingsListener(LocationUserSettingsListener listener) {
        this.mUserSettingsListeners.remove(listener);
    }

    protected File getUserSettingsDir(int userId) {
        return Environment.getDataSystemDeDirectory(userId);
    }

    protected LocationUserSettingsStore createUserSettingsStore(int userId, File file) {
        return new LocationUserSettingsStore(this, userId, file);
    }

    private LocationUserSettingsStore getUserSettingsStore(int userId) {
        SparseArray<LocationUserSettingsStore> r0 = this.mUserSettings;
        monitor-enter(r0);
        LocationUserSettingsStore settingsStore = this.mUserSettings.get(userId);     // Catch: Throwable -> L7
        if (settingsStore != null) goto L9;
        File file = new File(new File(getUserSettingsDir(userId), "location"), "settings");     // Catch: Throwable -> L7
        settingsStore = createUserSettingsStore(userId, file);     // Catch: Throwable -> L7
        this.mUserSettings.put(userId, settingsStore);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return settingsStore;
    L7:
        th = move-exception;
        throw th;
    }

    public final LocationUserSettings getUserSettings(int userId) {
        return getUserSettingsStore(userId).get();
    }

    public final void updateUserSettings(int userId, Function<LocationUserSettings, LocationUserSettings> updater) {
        getUserSettingsStore(userId).update(updater);
    }

    public final void dump(FileDescriptor fd, IndentingPrintWriter ipw, String[] args) {
        int[] userIds = ActivityManager.getService().getRunningUserIds();     // Catch: RemoteException -> L14
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive") == false) goto L20;
        ipw.print("ADAS Location Setting: ");
        ipw.increaseIndent();
        int r2 = 0;
        if (userIds.length <= 1) goto L11;
        ipw.println();
        int r1 = userIds.length;
    L9:
        if (r2 >= r1) goto L12;
        int userId = userIds[r2];
        ipw.print("[u");
        ipw.print(userId);
        ipw.print("] ");
        ipw.println(getUserSettings(userId).isAdasGnssLocationEnabled());
        r2 = r2 + 1;
    L12:
        ipw.decreaseIndent();
        return;
    L11:
        ipw.println(getUserSettings(userIds[0]).isAdasGnssLocationEnabled());
        goto L12
    L20:
        return;
    L14:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    final void flushFiles() throws InterruptedException {
        SparseArray<LocationUserSettingsStore> r0 = this.mUserSettings;
        monitor-enter(r0);
        int size = this.mUserSettings.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= size) goto L10;
        this.mUserSettings.valueAt(i).flushFile();     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    final void deleteFiles() throws InterruptedException {
        SparseArray<LocationUserSettingsStore> r0 = this.mUserSettings;
        monitor-enter(r0);
        int size = this.mUserSettings.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= size) goto L10;
        this.mUserSettings.valueAt(i).deleteFile();     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected final void fireListeners(int userId, LocationUserSettings oldSettings, LocationUserSettings newSettings) {
        Iterator<LocationUserSettingsListener> r0 = this.mUserSettingsListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        LocationUserSettingsListener listener = r0.next();
        listener.onLocationUserSettingsChanged(userId, oldSettings, newSettings);
        goto L4
    }
}

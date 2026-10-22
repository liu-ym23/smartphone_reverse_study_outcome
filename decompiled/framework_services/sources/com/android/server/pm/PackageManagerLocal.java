package com.android.server.pm;

import android.annotation.SystemApi;
import android.content.pm.SigningDetails;
import android.os.UserHandle;
import com.android.server.pm.pkg.PackageState;
import com.android.server.pm.pkg.SharedUserApi;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
public interface PackageManagerLocal {
    public static final int FLAG_STORAGE_CE = 2;
    public static final int FLAG_STORAGE_DE = 1;

    @SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
    public interface FilteredSnapshot extends AutoCloseable {
        @Override // java.lang.AutoCloseable
        void close();

        PackageState getPackageState(String r1);

        Map<String, PackageState> getPackageStates();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StorageFlags {
    }

    @SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
    public interface UnfilteredSnapshot extends AutoCloseable {
        @Override // java.lang.AutoCloseable
        void close();

        FilteredSnapshot filtered(int r1, UserHandle r2);

        Map<String, PackageState> getDisabledSystemPackageStates();

        Map<String, PackageState> getPackageStates();

        Map<String, SharedUserApi> getSharedUsers();
    }

    void addOverrideSigningDetails(SigningDetails r1, SigningDetails r2);

    void clearOverrideSigningDetails();

    void reconcileSdkData(String r1, String r2, List<String> r3, int r4, int r5, int r6, String r7, int r8) throws IOException;

    void removeOverrideSigningDetails(SigningDetails r1);

    FilteredSnapshot withFilteredSnapshot();

    FilteredSnapshot withFilteredSnapshot(int r1, UserHandle r2);

    UnfilteredSnapshot withUnfilteredSnapshot();
}

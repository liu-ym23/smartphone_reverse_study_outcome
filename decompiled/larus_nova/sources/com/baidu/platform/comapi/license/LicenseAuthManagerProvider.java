package com.baidu.platform.comapi.license;

import com.baidu.mapapi.PermissionUtils;
import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class LicenseAuthManagerProvider {
    private static final String FUNCTION_NAME_MULTI_SCREEN_RIDING_NAVI = "multi_screen_navi";
    private static final String FUNCTION_NAME_MULTI_SCREEN_WALKING_NAVI = "multi_screen_navi";
    private static final String SERVICE_NAME_WALK_BIKE_NAVI = "lbs_androidsdk";
    private static volatile LicenseAuthManagerProvider provider;

    public class a implements IExtraLicenseAuth {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LicenseAuthManagerProvider f32910a;

        @Override // com.baidu.platform.comapi.license.IExtraLicenseAuth
        public void check() throws BaseLicenseAuthDataStandardProcess.ProcessException {
            if (PermissionUtils.getInstance().isBWNaviMultiMapAuthorized() == false) goto L6;
            return;
        L6:
            throw new BaseLicenseAuthDataStandardProcess.ProcessException(200, "没有步骑行多实例权限");
        }

        public a(LicenseAuthManagerProvider r100) {
            this.f32910a = r100;
        }
    }

    public class b implements IExtraLicenseAuth {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LicenseAuthManagerProvider f32911a;

        @Override // com.baidu.platform.comapi.license.IExtraLicenseAuth
        public void check() throws BaseLicenseAuthDataStandardProcess.ProcessException {
            if (PermissionUtils.getInstance().isBWNaviMultiMapAuthorized() == false) goto L6;
            return;
        L6:
            throw new BaseLicenseAuthDataStandardProcess.ProcessException(200, "没有步骑行多实例权限");
        }

        public b(LicenseAuthManagerProvider r100) {
            this.f32911a = r100;
        }
    }

    public static LicenseAuthManagerProvider getInstance() {
        if (provider != null) goto L13;
        monitor-enter(LicenseAuthManagerProvider.class);
        provider = new LicenseAuthManagerProvider();     // Catch: Throwable -> L9
        monitor-exit(LicenseAuthManagerProvider.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return provider;
    }

    public ILicenseAuthManager getMultiScreenRidingNaviAuthManager() {
        ArrayList r100 = new ArrayList(1);
        r100.add(new b(this));
        return new LicenseAuthManager.Builder().serviceName(SERVICE_NAME_WALK_BIKE_NAVI).functionName("multi_screen_navi").type(1).extraAuth(r100).build();
    }

    public ILicenseAuthManager getMultiScreenWalkingNaviAuthManager() {
        ArrayList r100 = new ArrayList(1);
        r100.add(new a(this));
        return new LicenseAuthManager.Builder().serviceName(SERVICE_NAME_WALK_BIKE_NAVI).functionName("multi_screen_navi").type(1).extraAuth(r100).build();
    }

    private LicenseAuthManagerProvider() {
    }
}

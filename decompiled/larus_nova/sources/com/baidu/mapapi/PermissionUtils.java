package com.baidu.mapapi;

import com.baidu.mapsdkplatform.comapi.util.d;

/* JADX INFO: loaded from: classes39.dex */
public class PermissionUtils {

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final PermissionUtils f30503a = null;

        static {
            f30503a = new PermissionUtils(null);
        }

        public static /* synthetic */ PermissionUtils a() {
            return f30503a;
        }
    }

    public static PermissionUtils getInstance() {
        return b.a();
    }

    public int getAdvancedPermission() {
        return d.b().a();
    }

    public boolean isBWNaviInfoAuthorized() {
        return d.b().c();
    }

    public boolean isBWNaviMultiMapAuthorized() {
        return d.b().d();
    }

    public boolean isBWNaviTrafficLightAuthorized() {
        return d.b().e();
    }

    public boolean isEnglishMapAuthorized() {
        return d.b().f();
    }

    public boolean isEnglishWalkBikeNaviAuthorized() {
        return d.b().g();
    }

    public boolean isIndoorNaviAuthorized() {
        return d.b().h();
    }

    public boolean isIntegralRoutePlanAuthorized() {
        return d.b().i();
    }

    public boolean isWalkARNaviAuthorized() {
        return d.b().j();
    }

    private PermissionUtils() {
    }

    public /* synthetic */ PermissionUtils(a r100) {
        this();
    }
}

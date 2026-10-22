package com.bytedance.android.openlive.inner;

import com.bytedance.android.livehostapi.platform.IHostSessionAuth;
import com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth;
import com.bytedance.android.openlive.inner.host.IOpenHostAction;
import com.bytedance.android.openlive.inner.host.IOpenHostBusiness;
import com.bytedance.android.openlive.inner.host.IOpenHostParams;
import com.bytedance.android.openlive.inner.host.IOpenHostPlugin;
import com.bytedance.android.openlive.inner.host.IOpenHostShare;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/openlive/inner/IHostParams;", "", "getOpenHostAction", "Lcom/bytedance/android/openlive/inner/host/IOpenHostAction;", "getOpenHostAuth", "Lcom/bytedance/android/livehostapi/platform/IHostTokenInjectionAuth;", "getOpenHostBusiness", "Lcom/bytedance/android/openlive/inner/host/IOpenHostBusiness;", "getOpenHostParams", "Lcom/bytedance/android/openlive/inner/host/IOpenHostParams;", "getOpenHostPlugin", "Lcom/bytedance/android/openlive/inner/host/IOpenHostPlugin;", "getOpenHostShare", "Lcom/bytedance/android/openlive/inner/host/IOpenHostShare;", "getSessionHostAuth", "Lcom/bytedance/android/livehostapi/platform/IHostSessionAuth;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostParams {

    /* JADX INFO: renamed from: com.bytedance.android.openlive.inner.IHostParams$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static IHostTokenInjectionAuth $default$getOpenHostAuth(IHostParams r100) {
            return null;
        }

        public static IOpenHostBusiness $default$getOpenHostBusiness(IHostParams r100) {
            return null;
        }

        public static IOpenHostPlugin $default$getOpenHostPlugin(IHostParams r100) {
            return null;
        }

        public static IOpenHostShare $default$getOpenHostShare(IHostParams r100) {
            return null;
        }

        public static IHostSessionAuth $default$getSessionHostAuth(IHostParams r100) {
            return null;
        }

        public static /* synthetic */ IHostTokenInjectionAuth access$getOpenHostAuth$jd(IHostParams r100) {
            return $default$getOpenHostAuth(r100);
        }

        public static /* synthetic */ IOpenHostBusiness access$getOpenHostBusiness$jd(IHostParams r100) {
            return $default$getOpenHostBusiness(r100);
        }

        public static /* synthetic */ IOpenHostPlugin access$getOpenHostPlugin$jd(IHostParams r100) {
            return $default$getOpenHostPlugin(r100);
        }

        public static /* synthetic */ IOpenHostShare access$getOpenHostShare$jd(IHostParams r100) {
            return $default$getOpenHostShare(r100);
        }

        public static /* synthetic */ IHostSessionAuth access$getSessionHostAuth$jd(IHostParams r100) {
            return $default$getSessionHostAuth(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static IHostTokenInjectionAuth getOpenHostAuth(IHostParams r100) {
            return CC.access$getOpenHostAuth$jd(r100);
        }

        public static IOpenHostBusiness getOpenHostBusiness(IHostParams r100) {
            return CC.access$getOpenHostBusiness$jd(r100);
        }

        public static IOpenHostPlugin getOpenHostPlugin(IHostParams r100) {
            return CC.access$getOpenHostPlugin$jd(r100);
        }

        public static IOpenHostShare getOpenHostShare(IHostParams r100) {
            return CC.access$getOpenHostShare$jd(r100);
        }

        public static IHostSessionAuth getSessionHostAuth(IHostParams r100) {
            return CC.access$getSessionHostAuth$jd(r100);
        }
    }

    IOpenHostAction getOpenHostAction();

    IHostTokenInjectionAuth getOpenHostAuth();

    IOpenHostBusiness getOpenHostBusiness();

    IOpenHostParams getOpenHostParams();

    IOpenHostPlugin getOpenHostPlugin();

    IOpenHostShare getOpenHostShare();

    IHostSessionAuth getSessionHostAuth();
}

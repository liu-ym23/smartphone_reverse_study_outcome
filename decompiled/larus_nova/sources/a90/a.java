package a90;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.android.live.browser.jsbridge.newmethods.ba;
import com.bytedance.android.live.browser.jsbridge.newmethods.ca;
import com.bytedance.android.live.core.verify.utils.IIdentityVerifyService;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.business.IHostOCRApiProxy;
import com.bytedance.android.livehostapi.business.IHostOCRPreloadApiProxy;
import com.bytedance.android.livesdk.config.tj;
import com.bytedance.android.livesdk.model.n;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class a implements IIdentityVerifyService {

    /* JADX INFO: renamed from: a90.a$a, reason: collision with other inner class name */
    public static final class C0029a implements com.bytedance.android.live.core.verify.utils.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IIdentityVerifyService.a f2219a;

        public C0029a(IIdentityVerifyService.a r100) {
            this.f2219a = r100;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.bytedance.android.live.core.verify.utils.a.d
        public final void a(String r110) {
            ba r100 = (ba) this.f2219a;
            ca r101 = r100.f63319a;
            IIdentityVerifyService r102 = r100.f63320b;
            JsonObject r103 = r100.f63321c;
            String r104 = r100.f63322d;
            JsonObject r105 = r100.f63323e;
            r101.getClass();
            JsonObject r106 = new JsonObject();
            r106.addProperty("live_certification_setting_face_identify", r110);
            n r107 = tj.f121303a.getValue();
            if (r107 == null) goto L13;
            boolean r108 = r102.hostOCRSdkReady();
            if (r108 == false) goto L7;
            String r109 = r107.b();
        L8:
            r106.addProperty("live_certification_setting_info_input", r109);
            r106.addProperty("live_certification_setting_show_artificial_entrance", Boolean.valueOf(r107.a()));
            if (r108 == false) goto L11;
            int r111 = r107.c();
        L12:
            r106.addProperty("live_certification_setting_manual_use_ocr", Integer.valueOf(r111));
            r106.addProperty("live_certification_setting_use_reflection", Boolean.valueOf(r107.d()));
            r103.add(r104, r106);
            r102.mobReadSetting(r102.getFaceIdentify(), r110);
            goto L13
        L11:
            r111 = 0;
            goto L12
        L7:
            r109 = "default";
        L13:
            r105.add("data", r103);
            r101.finishWithResult(r105);
        }
    }

    public static final class b implements com.bytedance.android.live.core.verify.utils.a.g {
        @Override // com.bytedance.android.live.core.verify.utils.a.g
        public final void onVerify(boolean r100, Map<String, Object> r101) {
        }

        public b() {
        }
    }

    public static final class c implements com.bytedance.android.live.core.verify.utils.a.f {
        public c() {
        }

        @Override // com.bytedance.android.live.core.verify.utils.a.f
        public final Observable<Response<w80.a>> a(Map<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "m");
            throw null;
        }
    }

    public a() {
    }

    @Override // com.bytedance.android.live.core.verify.utils.IIdentityVerifyService
    public String getFaceIdentify() {
        com.bytedance.android.live.base.abtest.b.a r100 = com.bytedance.android.live.base.abtest.b.f58812b;
        ClientABTestKey<String> r101 = com.bytedance.android.live.base.abtest.a.f58806a;
        r100.getClass();
        return (String) com.bytedance.android.live.base.abtest.b.a.a(r101);
    }

    @Override // com.bytedance.android.live.core.verify.utils.IIdentityVerifyService
    public boolean hostOCRSdkReady() {
        IHostOCRApiProxy r100 = (IHostOCRApiProxy) k.f(IHostOCRApiProxy.class);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isSDKReady();
    }

    @Override // com.bytedance.android.live.core.verify.utils.IIdentityVerifyService
    public boolean supportTryPreload() {
        IHostOCRPreloadApiProxy r100 = (IHostOCRPreloadApiProxy) k.f(IHostOCRPreloadApiProxy.class);
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.supportTryPreload() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.core.verify.utils.IIdentityVerifyService
    public String getRealFaceIdentify() {
        return com.bytedance.android.live.core.verify.utils.a.d();
    }

    @Override // com.bytedance.android.live.core.verify.utils.IIdentityVerifyService
    public int getRealVerifyType() {
        return com.bytedance.android.live.core.verify.utils.a.g();
    }

    @Override // com.bytedance.android.live.core.verify.utils.IIdentityVerifyService
    public String getVerifiedConfirmPageSource() {
        return com.bytedance.android.live.core.verify.utils.a.h(com.bytedance.android.live.core.verify.utils.a.g());
    }

    @Override // com.bytedance.android.live.core.verify.utils.IIdentityVerifyService
    public void mobReadSetting(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "realType");
        IHostOCRPreloadApiProxy r102 = (IHostOCRPreloadApiProxy) k.f(IHostOCRPreloadApiProxy.class);
        if (r102 == null) goto L6;
        r102.mobReadSetting(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.core.verify.utils.IIdentityVerifyService
    public void getRealFaceIdentifySync(Context r100, boolean r101, IIdentityVerifyService.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "getRealFaceIdentifySyncInterface");
        com.bytedance.android.live.core.verify.utils.a.e(r100, r101, new C0029a(r102));
    }

    @Override // com.bytedance.android.live.core.verify.utils.IIdentityVerifyService
    public void verify(Activity r110, w80.a r111, String r112, Bundle r113, int r114, String r115, boolean r116, IIdentityVerifyService.c r210, IIdentityVerifyService.b r211, boolean r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r210, "onVerifyCallBack");
        Intrinsics.checkNotNullParameter(r211, "getZhiMaSubmitInterface");
        com.bytedance.android.live.core.verify.utils.a.o(r110, r111, r112, r113, r114, r115, r116, new b(), new c(), r212, r213);
    }
}

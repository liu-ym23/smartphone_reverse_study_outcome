package a76;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.lynx.impl.page.AbsLynxPageActivity;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XBridgeMethod.Access f2023a;

    /* JADX INFO: renamed from: a76.a$a, reason: collision with other inner class name */
    public static final class C0022a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f2024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f2025b;

        public final void a() {
            Intrinsics.checkNotNullParameter("context is not instance of AbsLynxPageActivity", "msg");
            XCoreBridgeMethod.onFailure$default(this.f2024a, this.f2025b, 0, "context is not instance of AbsLynxPageActivity", null, 8, null);
        }

        public C0022a(a r100, XBridgeMethod.Callback r101) {
            this.f2024a = r100;
            this.f2025b = r101;
        }

        public final void b(i66.b r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = i66.b.f488436a;
            Map<String, Object> r103 = i66.b.a.a(r100);
            this.f2024a.onSuccess(this.f2025b, r103, r101);
        }
    }

    public a() {
        this.f2023a = XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f2023a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<com.bytedance.ies.xbridge.model.params.b> provideParamModel() {
        return com.bytedance.ies.xbridge.model.params.b.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<i66.b> provideResultModel() {
        return i66.b.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        int r103 = com.bytedance.ies.xbridge.model.params.b.f249508a;
        Intrinsics.checkNotNullParameter(r100, "params");
        com.bytedance.ies.xbridge.model.params.b r104 = new com.bytedance.ies.xbridge.model.params.b();
        C0022a r105 = new C0022a(this, r101);
        Intrinsics.checkNotNullParameter(r104, "params");
        Intrinsics.checkNotNullParameter(r105, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        Context r106 = (Context) ((je5.c) this).provideContext(Context.class);
        int r107 = ie5.c.f489477a;
        if ((r106 instanceof AbsLynxPageActivity) == false) goto L8;
        AbsLynxPageActivity r108 = (AbsLynxPageActivity) r106;
        FrameLayout r109 = r108.f229881e;
        if (r109 == null) goto L7;
        r108.C1(r109);
    L7:
        boolean r110 = true;
    L9:
        if (r110 == false) goto L11;
        r105.b(new i66.b(), "");
        return;
    L11:
        r105.a();
        return;
    L8:
        r110 = false;
        goto L9
    }
}

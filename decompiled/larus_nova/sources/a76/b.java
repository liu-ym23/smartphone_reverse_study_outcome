package a76;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.lynx.impl.page.AbsLynxPageActivity;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import java.util.Map;
import je5.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b extends XCoreBridgeMethod {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f2026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f2027b;

        public final void a() {
            Intrinsics.checkNotNullParameter("context is not instance of AbsLynxPageActivity", "msg");
            XCoreBridgeMethod.onFailure$default(this.f2026a, this.f2027b, 0, "context is not instance of AbsLynxPageActivity", null, 8, null);
        }

        public a(b r100, XBridgeMethod.Callback r101) {
            this.f2026a = r100;
            this.f2027b = r101;
        }

        public final void b(i66.b r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = i66.b.f488436a;
            Map<String, Object> r103 = i66.b.a.a(r100);
            this.f2026a.onSuccess(this.f2027b, r103, r101);
        }
    }

    public b() {
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return XBridgeMethod.Access.PRIVATE;
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
        a r105 = new a(this, r101);
        Intrinsics.checkNotNullParameter(r104, "params");
        Intrinsics.checkNotNullParameter(r105, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        Context r106 = (Context) ((e) this).provideContext(Context.class);
        int r107 = ie5.c.f489477a;
        if ((r106 instanceof AbsLynxPageActivity) == false) goto L8;
        AbsLynxPageActivity r108 = (AbsLynxPageActivity) r106;
        FrameLayout r109 = r108.f229881e;
        if (r109 == null) goto L7;
        r108.D1(r109);
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

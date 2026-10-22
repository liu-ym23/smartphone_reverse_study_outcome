package a76;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.Map;
import je5.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class c extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XBridgeMethod.Access f2028a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f2029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f2030b;

        public final void a() {
            Intrinsics.checkNotNullParameter("context not provided in host", "msg");
            XCoreBridgeMethod.onFailure$default(this.f2029a, this.f2030b, 0, "context not provided in host", null, 8, null);
        }

        public a(c r100, XBridgeMethod.Callback r101) {
            this.f2029a = r100;
            this.f2030b = r101;
        }

        public final void b(i66.b r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = i66.b.f488436a;
            Map<String, Object> r103 = i66.b.a.a(r100);
            this.f2029a.onSuccess(this.f2030b, r103, r101);
        }
    }

    public c() {
        this.f2028a = XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f2028a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<b76.a> provideParamModel() {
        return b76.a.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<i66.b> provideResultModel() {
        return i66.b.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r110, XBridgeMethod.Callback r111, XBridgePlatformType r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        int r100 = b76.a.f17957d;
        Intrinsics.checkNotNullParameter(r110, "param");
        String r101 = s.f(r110, "message", "");
        boolean r113 = true;
        int r114 = 0;
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L13;
        String r103 = s.f(r110, "type", "");
        if (r103.length() == 0) goto L12;
        r113 = false;
    L12:
        if (r113 == true) goto L13;
        int r115 = 3000;
        if (r110.hasKey("duration") == true) goto L18;
    L23:
        b76.a r104 = new b76.a();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r104.f17958a = r101;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r104.f17959b = r103;
        r104.f17960c = Integer.valueOf(r115);
    L24:
        if (r104 != null) goto L27;
        XCoreBridgeMethod.onFailure$default(this, r111, -3, null, null, 12, null);
        return;
    L27:
        a r105 = new a(this, r111);
        Intrinsics.checkNotNullParameter(r104, "params");
        Intrinsics.checkNotNullParameter(r105, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        tt5.a.b("ccm-lynx: CCMShowToastMethod", "handle()...type = " + r104.getType());
        Context r106 = (Context) ((f) this).provideContext(Context.class);
        if (r106 != null) goto L30;
        r105.a();
        return;
    L30:
        String r107 = r104.getType();
        switch(r107.hashCode()) {
            case -1867169789: goto L63;
            case -1364013995: goto L56;
            case -1039745817: goto L49;
            case 3135262: goto L42;
            case 216239514: goto L38;
            case 724809599: goto L34;
            default: goto L69;
        };
    L69:
        r105.b(new i66.b(), "");
        return;
    L34:
        if (r107.equals(DyPayConstant.KEY_SHOW_LOADING) == false) goto L69;
        Toast.showLoading(r106, r104.a());
        goto L69
    L38:
        if (r107.equals("hideLoading") == false) goto L69;
        Toast.cancelLoading();
        goto L69
    L42:
        if (r107.equals("fail") == false) goto L69;
        String r108 = r104.a();
        Integer r109 = r104.f17960c;
        if (r109 == null) goto L47;
        r114 = r109.intValue();
    L47:
        Toast.showFailureText(r106, r108, r114);
        goto L69
    L49:
        if (r107.equals("normal") == false) goto L69;
        String r116 = r104.a();
        Integer r117 = r104.f17960c;
        if (r117 == null) goto L54;
        r114 = r117.intValue();
    L54:
        Toast.showText(r106, r116, r114);
        goto L69
    L56:
        if (r107.equals("center") == false) goto L69;
        String r118 = r104.a();
        Integer r119 = r104.f17960c;
        if (r119 == null) goto L61;
        r114 = r119.intValue();
    L61:
        Toast.showCenterToast(r106, r118, r114);
        goto L69
    L63:
        if (r107.equals("success") == false) goto L69;
        String r120 = r104.a();
        Integer r121 = r104.f17960c;
        if (r121 == null) goto L68;
        r114 = r121.intValue();
    L68:
        Toast.showSuccessText(r106, r120, r114);
        goto L69
    L18:
        if (r110.get("duration").getType() != XReadableType.Int) goto L21;
        r115 = s.d(r110, "duration", 3000);
        goto L23
    L21:
        if (r110.get("duration").getType() != XReadableType.Number) goto L23;
        r115 = (int) s.c(r110, "duration", 3000.0d);
    L13:
        r104 = null;
        goto L24
    L5:
        r102 = false;
        goto L6
    }
}

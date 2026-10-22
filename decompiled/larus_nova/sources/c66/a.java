package c66;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.ss.android.lark.log.Log;
import eu5.c;
import je5.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XBridgeMethod.Access f22594a;

    /* JADX INFO: renamed from: c66.a$a, reason: collision with other inner class name */
    public static final class C0410a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f22595a;

        public C0410a(XBridgeMethod.Callback r100) {
            this.f22595a = r100;
        }
    }

    public a() {
        this.f22594a = XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f22594a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<d66.a> provideParamModel() {
        return d66.a.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<i66.b> provideResultModel() {
        return i66.b.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r110, XBridgeMethod.Callback r111, XBridgePlatformType r210) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r210, "type");
        int r100 = d66.a.f467198e;
        Intrinsics.checkNotNullParameter(r110, "params");
        String r101 = "";
        String r102 = s.f(r110, "level", "");
        boolean r112 = true;
        int r113 = 0;
        if (r102.length() != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L20;
        String r104 = s.f(r110, "message", "");
        if (r104.length() != 0) goto L12;
        boolean r114 = true;
    L13:
        if (r114 == true) goto L20;
        String r115 = s.f(r110, "tag", "");
        if (r115.length() == 0) goto L19;
        r112 = false;
    L19:
        if (r112 == true) goto L20;
        XReadableMap r105 = s.e(r110, "codePosition");
        if (r105 == null) goto L24;
        r113 = s.d(r105, "line", 0);
        String r116 = s.f(r105, "function", "");
        r101 = s.f(r105, "file", "");
    L25:
        d66.a.C5640a r106 = new d66.a.C5640a(r101, r116, r113);
        d66.a r107 = new d66.a();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r107.f467199a = r102;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r107.f467200b = r104;
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r107.f467201c = r115;
        r107.f467202d = r106;
    L26:
        if (r107 != null) goto L29;
        XCoreBridgeMethod.onFailure$default(this, r111, -3, null, null, 12, null);
        return;
    L29:
        C0410a r108 = new C0410a(r111);
        d r109 = (d) this;
        Intrinsics.checkNotNullParameter(r107, "params");
        Intrinsics.checkNotNullParameter(r108, "callback");
        Intrinsics.checkNotNullParameter(r210, "type");
        String r117 = r107.f467200b;
        if (r117 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("message");
        r117 = null;
    L33:
        StringBuilder r118 = new StringBuilder(r117.length() + 100);
        r118.append("[");
        d66.a.C5640a r119 = r107.f467202d;
        if (r119 == null) goto L36;
        String r120 = r119.f467203a;
    L37:
        r118.append(r120);
        r118.append(", ");
        d66.a.C5640a r121 = r107.f467202d;
        if (r121 == null) goto L40;
        String r122 = r121.f467204b;
    L41:
        r118.append(r122);
        r118.append(", ");
        d66.a.C5640a r123 = r107.f467202d;
        if (r123 == null) goto L44;
        Integer r124 = Integer.valueOf(r123.f467205c);
    L45:
        r118.append(r124);
        r118.append("]");
        String r125 = r107.f467200b;
        if (r125 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("message");
        r125 = null;
    L49:
        r118.append(r125);
        String r126 = r118.toString();
        String r127 = r107.f467201c;
        if (r127 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("tag");
        r127 = null;
    L53:
        String r128 = r109.e(r127);
        String r129 = r107.f467199a;
        if (r129 == null) goto L56;
        String r130 = r129;
    L58:
        switch(r130.hashCode()) {
            case 3237038: goto L77;
            case 3641990: goto L73;
            case 95458899: goto L69;
            case 96784904: goto L65;
            case 351107458: goto L61;
            default: goto L81;
        };
    L61:
        if (r130.equals("verbose") == false) goto L81;
        Log.v(tt5.a.a(r128), r126);
        return;
    L65:
        if (r130.equals("error") == false) goto L81;
        tt5.a.d(r128, r126);
        return;
    L69:
        if (r130.equals("debug") == false) goto L81;
        tt5.a.b(r128, r126);
        return;
    L73:
        if (r130.equals("warn") == false) goto L81;
        tt5.a.k(r128, r126);
        return;
    L77:
        if (r130.equals("info") == false) goto L81;
        tt5.a.h(r128, r126);
        return;
    L81:
        if (c.a() == true) goto L85;
        tt5.a.h(r128, r126);
        return;
    L85:
        throw new IllegalArgumentException("Illegal level!");
    L56:
        Intrinsics.throwUninitializedPropertyAccessException("level");
        r130 = null;
        goto L58
    L44:
        r124 = null;
        goto L45
    L40:
        r122 = null;
        goto L41
    L36:
        r120 = null;
        goto L37
    L24:
        r116 = "";
        goto L25
    L12:
        r114 = false;
    L20:
        r107 = null;
        goto L26
    L5:
        r103 = false;
        goto L7
    }
}

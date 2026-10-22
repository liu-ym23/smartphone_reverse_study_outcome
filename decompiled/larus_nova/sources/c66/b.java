package c66;

import com.bytedance.ee.bear.contract.d;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.t;
import com.bytedance.ies.xbridge.u;
import com.bytedance.ies.xbridge.utils.j;
import com.bytedance.ies.xbridge.v;
import eu5.c;
import ie5.k;
import java.util.LinkedHashMap;
import java.util.Map;
import je5.g;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XBridgeMethod.Access f22596a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f22597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f22598b;

        public a(b r100, XBridgeMethod.Callback r101) {
            this.f22597a = r100;
            this.f22598b = r101;
        }

        public final void a(i66.b r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = i66.b.f488436a;
            Map<String, Object> r103 = i66.b.a.a(r100);
            this.f22597a.onSuccess(this.f22598b, r103, r101);
        }
    }

    public b() {
        this.f22596a = XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f22596a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<d66.b> provideParamModel() {
        return d66.b.class;
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
        int r100 = d66.b.f467206c;
        Intrinsics.checkNotNullParameter(r110, "map");
        String r101 = s.f(r110, "eventName", "");
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        String r113 = null;
        if (r102 == false) goto L9;
        d66.b r103 = null;
    L12:
        if (r103 != null) goto L15;
        XCoreBridgeMethod.onFailure$default(this, r111, -3, null, null, 12, null);
        return;
    L15:
        a r104 = new a(this, r111);
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r104, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        String r105 = r103.f467207a;
        if (r105 == null) goto L18;
        r113 = r105;
    L19:
        XReadableMap r106 = r103.f467208b;
        if (r106 == null) goto L44;
        u r107 = r106.keyIterator();
        if (r107 == null) goto L44;
        LinkedHashMap r108 = new LinkedHashMap();
    L25:
        if (r107.hasNextKey() == false) goto L43;
        String r109 = r107.nextKey();
        t r114 = r106.get(r109);
        switch(g.b.f498829a[r114.getType().ordinal()]) {
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L34;
            case 6: goto L31;
            default: goto L29;
        };
    L31:
        v r115 = r114.asArray();
        if (r115 == null) goto L25;
        String r116 = (String) r108.put(r109, j.c(r115).toString());
        goto L25
    L34:
        XReadableMap r117 = r114.asMap();
        if (r117 == null) goto L25;
        String r118 = (String) r108.put(r109, j.d(r117).toString());
        goto L25
    L37:
        r108.put(r109, r114.asString());
        goto L25
    L38:
        r108.put(r109, com.bytedance.ee.bear.lynx.impl.xbridge.a.a(r106, r109).toString());
        goto L25
    L39:
        r108.put(r109, String.valueOf(r114.asInt()));
        goto L25
    L40:
        r108.put(r109, String.valueOf(r114.asBoolean()));
        goto L25
    L29:
        if (c.a() == true) goto L42;
        tt5.a.k("ccm-lynx: XTeaEventMethod", "event param type unknown");
        Unit r119 = Unit.INSTANCE;
        goto L25
    L42:
        throw new IllegalArgumentException("Illegal level!");
    L43:
        int r120 = k.f489487a;
        ((d) k.a.a(d.class)).n(r113, r108);
    L44:
        r104.a(new i66.b(), "");
        return;
    L18:
        Intrinsics.throwUninitializedPropertyAccessException("eventName");
        goto L19
    L9:
        XReadableMap r121 = s.e(r110, "params");
        r103 = new d66.b();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r103.f467207a = r101;
        if (r121 == null) goto L12;
        r103.f467208b = r121;
        goto L12
    L5:
        r102 = false;
        goto L6
    }
}

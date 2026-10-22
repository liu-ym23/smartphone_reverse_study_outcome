package com.bytedance.android.live.browser.jsbridge.protobuf;

import am3.g;
import am3.h;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f63850c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExternalProtobufMessageDefinitions f63851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExternalProtobufShrinkConfigs f63852b;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.protobuf.a$a, reason: collision with other inner class name */
    public static final class C1048a {
    }

    static {
    }

    public a(ExternalProtobufMessageDefinitions r100, ExternalProtobufShrinkConfigs r101) {
        Intrinsics.checkNotNullParameter(r100, "definitions");
        Intrinsics.checkNotNullParameter(r101, "shrinkConfigs");
        this.f63851a = r100;
        this.f63852b = r101;
    }

    public final JSONObject b(ExternalProtobufMessageDefinitions.Message r100, g r110, ExternalProtobufShrinkConfigs.Config r111) {
        JSONObject r101 = new JSONObject();
        long r102 = r110.c();
    L3:
        int r103 = r110.f();
        if (r103 == (-1)) goto L5;
        ExternalProtobufMessageDefinitions.a r104 = r100.f63830a.get(r103);
        if (r104 == null) goto L52;
        if (r111 == null) goto L15;
        Set<String> r105 = r111.f63843c;
        if (r105 == null) goto L15;
        if (r105.contains(r104.f63832a) == false) goto L52;
    L15:
        ExternalProtobufShrinkConfigs.Config r106 = null;
        if (r104.f63835d == false) goto L36;
        JSONArray r107 = r101.optJSONArray(r104.f63832a);
        if (r107 != null) goto L20;
        r107 = new JSONArray();
        r101.put(r104.f63832a, r107);
    L20:
        if (r111 == null) goto L26;
        Map<String, ExternalProtobufShrinkConfigs.Config> r108 = r111.f63844d;
        if (r108 == null) goto L26;
        ExternalProtobufShrinkConfigs.Config r109 = r108.get(r104.f63832a);
        if (r109 == null) goto L26;
        ExternalProtobufShrinkConfigs.a.b r112 = (ExternalProtobufShrinkConfigs.a.b) r109.f63841a.get(ExternalProtobufShrinkConfigs.a.b.class);
    L27:
        if (r112 != null) goto L29;
    L31:
        if (r111 == null) goto L35;
        Map<String, ExternalProtobufShrinkConfigs.Config> r113 = r111.f63844d;
        if (r113 == null) goto L35;
        r106 = r113.get(r104.f63832a);
    L35:
        r107.put(a(this, r104, r110, r106));
    L51:
        boolean r114 = true;
    L53:
        if (r114 == true) goto L3;
        h.e(r110);
        goto L3
    L29:
        if (r107.length() < r112.f63846b) goto L31;
    L26:
        r112 = null;
        goto L27
    L36:
        if (r111 == null) goto L40;
        Map<String, ExternalProtobufShrinkConfigs.Config> r115 = r111.f63844d;
        if (r115 == null) goto L40;
        r106 = r115.get(r104.f63832a);
    L40:
        Object r116 = a(this, r104, r110, r106);
        if ((r116 instanceof Pair) == false) goto L50;
        JSONObject r117 = r101.optJSONObject(r104.f63832a);
        if (r117 != null) goto L45;
        r117 = new JSONObject();
        r101.put(r104.f63832a, r117);
    L45:
        Pair r118 = (Pair) r116;
        String r119 = String.valueOf(r118.getFirst());
        Object r120 = r118.getSecond();
        if (r120 == null) goto L49;
        r117.put(r119, r120);
        goto L51
    L49:
        throw new IllegalArgumentException(("decodedFieldData has null value: " + r116).toString());
    L50:
        r101.put(r104.f63832a, r116);
    L52:
        r114 = false;
        goto L53
    L5:
        r110.d(r102);
        return r101;
    }

    public static final Object a(a r110, ExternalProtobufMessageDefinitions.a r111, g r112, ExternalProtobufShrinkConfigs.Config r113) {
        r110.getClass();
        int r100 = r111.getType();
        boolean r101 = false;
        if (r100 != 20) goto L5;
        String r102 = r111.f63836e;
        if (r102 == null) goto L60;
        boolean r103 = true;
    L61:
        if (r103 == false) goto L71;
        ExternalProtobufMessageDefinitions.Message r104 = r110.f63851a.a(r102);
        if (r104 == null) goto L65;
        r101 = true;
    L65:
        if (r101 == false) goto L69;
        return r110.b(r104, r112, r113);
    L69:
        throw new IllegalStateException(("message with fqName [" + r111.f63836e + "] not found").toString());
    L71:
        throw new IllegalStateException(("field [" + r111.f63832a + "] is pointing to fqName but not found in def").toString());
    L60:
        r103 = false;
        goto L61
    L5:
        if (r100 == 21) goto L16;
        switch(r100) {
            case 0: goto L85;
            case 1: goto L84;
            case 2: goto L83;
            case 3: goto L82;
            case 4: goto L81;
            case 5: goto L80;
            case 6: goto L79;
            case 7: goto L81;
            case 8: goto L80;
            default: goto L8;
        };
    L8:
        throw new IllegalStateException(("field type [" + r111.getType() + "] is not supported").toString());
    L79:
        return h.c(r112);
    L80:
        return Long.valueOf(r112.j());
    L81:
        return Integer.valueOf(r112.i());
    L82:
        return Float.valueOf(Float.intBitsToFloat(r112.g()));
    L83:
        return Double.valueOf(Double.longBitsToDouble(r112.h()));
    L84:
        return h.b(r112);
    L85:
        return Boolean.valueOf(h.a(r112));
    L16:
        Pair<ExternalProtobufMessageDefinitions.a.b, ExternalProtobufMessageDefinitions.a.c> r105 = r111.f63837f;
        if (r105 == null) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L56;
        ExternalProtobufMessageDefinitions.a.b r107 = r105.getFirst();
        ExternalProtobufMessageDefinitions.a.c r108 = r111.f63837f.getSecond();
        long r109 = r112.c();
        Object r114 = null;
        Object r115 = null;
    L22:
        int r116 = r112.f();
        if (r116 == (-1)) goto L24;
        if (r116 != 1) goto L40;
        if (r113 == null) goto L53;
        ExternalProtobufShrinkConfigs.a.c r117 = (ExternalProtobufShrinkConfigs.a.c) r113.f63841a.get(ExternalProtobufShrinkConfigs.a.c.class);
        if (r117 == null) goto L53;
        ExternalProtobufShrinkConfigs.Config r118 = r117.f63847b;
    L54:
        r114 = a(r110, r107, r112, r118);
    L53:
        r118 = null;
        goto L54
    L40:
        if (r116 != 2) goto L48;
        if (r113 == null) goto L45;
        ExternalProtobufShrinkConfigs.a.d r119 = (ExternalProtobufShrinkConfigs.a.d) r113.f63841a.get(ExternalProtobufShrinkConfigs.a.d.class);
        if (r119 == null) goto L45;
        ExternalProtobufShrinkConfigs.Config r120 = r119.f63848b;
    L46:
        r115 = a(r110, r108, r112, r120);
    L45:
        r120 = null;
        goto L46
    L48:
        throw new IllegalStateException(("unknown tag [" + r116 + "] for map").toString());
    L24:
        r112.d(r109);
        if (r114 == null) goto L27;
        boolean r121 = true;
    L29:
        if (r121 == false) goto L37;
        if (r115 == null) goto L32;
        r101 = true;
    L32:
        if (r101 == false) goto L35;
        return new Pair(r114, r115);
    L35:
        throw new IllegalStateException(("malformed data: value of type [" + r108 + "] in map is null").toString());
    L37:
        throw new IllegalStateException(("malformed data: key of type [" + r107 + "] in map is null").toString());
    L27:
        r121 = false;
        goto L29
    L56:
        throw new IllegalStateException(("type of [" + r111.f63832a + "] is map but lacks mapInfo").toString());
    L19:
        r106 = false;
        goto L20
    }
}

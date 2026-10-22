package d.h;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.e;
import d.h.b.o;
import d.m.c;

/* JADX INFO: compiled from: JvmClassMapping.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static final <T> Class<T> a(c<T> r2) {
        c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
        o.e(r3, "<this>");
        Class<T> r4 = (Class<T>) ((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin")).a();
        o.a(r4, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return r4;
    }

    public static final <T> Class<T> b(c<T> r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        Class<T> r5 = (Class<T>) ((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.aiagent.plugin")).a();
        if (r5.isPrimitive() == true) goto L6;
        o.a(r5, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return r5;
    L6:
        String r0 = r5.getName();
        if (r0 != null) goto L9;
    L47:
        o.a(r5, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return r5;
    L9:
        switch(r0.hashCode()) {
            case -1325958191: goto L44;
            case 104431: goto L40;
            case 3039496: goto L36;
            case 3052374: goto L32;
            case 3327612: goto L28;
            case 3625364: goto L24;
            case 64711720: goto L20;
            case 97526364: goto L16;
            case 109413500: goto L12;
            default: goto L47;
        };
    L12:
        if (r0.equals("short") == false) goto L47;
        r5 = (Class<T>) Short.class;
        goto L47
    L16:
        if (r0.equals(WsChannelMultiProcessSharedProvider.FLOAT_TYPE) == false) goto L47;
        r5 = (Class<T>) Float.class;
        goto L47
    L20:
        if (r0.equals(WsChannelMultiProcessSharedProvider.BOOLEAN_TYPE) == false) goto L47;
        r5 = (Class<T>) Boolean.class;
        goto L47
    L24:
        if (r0.equals("void") == false) goto L47;
        r5 = (Class<T>) Void.class;
        goto L47
    L28:
        if (r0.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == false) goto L47;
        r5 = (Class<T>) Long.class;
        goto L47
    L32:
        if (r0.equals("char") == false) goto L47;
        r5 = (Class<T>) Character.class;
        goto L47
    L36:
        if (r0.equals("byte") == false) goto L47;
        r5 = (Class<T>) Byte.class;
        goto L47
    L40:
        if (r0.equals("int") == false) goto L47;
        r5 = (Class<T>) Integer.class;
        goto L47
    L44:
        if (r0.equals("double") == false) goto L47;
        r5 = (Class<T>) Double.class;
        goto L47
    }

    public static final <T> c<T> a(Class<T> r1) {
        o.e(r1, "<this>");
        return aa.b(r1);
    }
}

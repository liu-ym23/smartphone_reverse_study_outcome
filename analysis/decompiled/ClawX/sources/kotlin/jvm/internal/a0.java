package kotlin.jvm.internal;

import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a0 {
    public static String a(l lVar) {
        String string = lVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public static f0 b(v5.d dVar, List arguments) {
        p.e(arguments, "arguments");
        return new f0(dVar, arguments, 0);
    }
}

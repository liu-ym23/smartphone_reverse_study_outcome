package P3;

import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1086a = new b(0);

    public static void a(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        f1086a.invoke(3, "Ability_".concat(tag), msg, null);
    }

    public static void b(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        f1086a.invoke(4, "Ability_".concat(tag), msg, null);
    }

    public static void c(String msg) {
        k.f(msg, "msg");
        f1086a.invoke(5, "Ability_".concat("AgentService"), msg, null);
    }
}

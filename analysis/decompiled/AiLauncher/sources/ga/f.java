package ga;

import kotlin.jvm.internal.p;
import kotlin.text.Regex;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f32738a = new f();

    /* renamed from: b, reason: collision with root package name */
    public static final Regex f32739b = new Regex("[^\\p{L}\\p{Digit}]");

    /* renamed from: c, reason: collision with root package name */
    public static final String f32740c = "$context_receiver";

    public static final e a(int i10) {
        e eVarJ = e.j(f32740c + '_' + i10);
        p.h(eVarJ, "identifier(...)");
        return eVarJ;
    }

    public static final String b(String name) {
        p.i(name, "name");
        return f32739b.l(name, "_");
    }
}

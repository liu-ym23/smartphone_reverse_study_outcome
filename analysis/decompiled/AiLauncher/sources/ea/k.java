package ea;

import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class k {
    public static final boolean a(AbstractC4017a version) {
        p.i(version, "version");
        return (version.a() == 1 && version.b() >= 4) || version.a() > 1;
    }

    public static final boolean b(AbstractC4017a version) {
        p.i(version, "version");
        return a(version);
    }
}

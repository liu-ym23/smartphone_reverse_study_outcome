package h8;

import kotlin.collections.builders.MapBuilder;

/* loaded from: classes4.dex */
public abstract class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f4581a;
    public final boolean b;

    public d0(String str, boolean z10) {
        this.f4581a = str;
        this.b = z10;
    }

    public Integer a(d0 visibility) {
        kotlin.jvm.internal.k.f(visibility, "visibility");
        MapBuilder mapBuilder = c0.f4579a;
        if (this == visibility) {
            return 0;
        }
        MapBuilder mapBuilder2 = c0.f4579a;
        Integer num = (Integer) mapBuilder2.get(this);
        Integer num2 = (Integer) mapBuilder2.get(visibility);
        if (num == null || num2 == null || num.equals(num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public String b() {
        return this.f4581a;
    }

    public d0 c() {
        return this;
    }

    public final String toString() {
        return b();
    }
}

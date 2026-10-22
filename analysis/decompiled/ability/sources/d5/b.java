package d5;

import com.stepos.core.data.ContentParams;
import java.util.LinkedHashMap;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f4293a = new LinkedHashMap();

    public final ContentParams a() {
        return new ContentParams(kotlin.collections.a.Y(this.f4293a), null);
    }

    public final void b(String str, boolean z10) {
        this.f4293a.put(str, new d(z10));
    }

    public final void c(String str, float f) {
        this.f4293a.put(str, new g(f));
    }

    public final void d(String str, int i) {
        this.f4293a.put(str, new i(i));
    }

    public final void e(String str, String value) {
        kotlin.jvm.internal.k.f(value, "value");
        this.f4293a.put(str, new k(value));
    }
}

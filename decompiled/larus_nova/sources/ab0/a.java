package ab0;

import com.bytedance.android.scope.l;
import cy0.e;
import e33.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;
import u60.b;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements com.bytedance.live.kmp.core.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<e> f2447c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f2448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ai6.a f2449b;

    /* JADX INFO: renamed from: ab0.a$a, reason: collision with other inner class name */
    public static final class C0043a {
    }

    static {
        f2447c = new ArrayList();
    }

    @Override // com.bytedance.live.kmp.core.a
    public final void start() {
        List<e> r100 = f2447c;
        ArrayList r101 = (ArrayList) r100;
        r101.add(this.f2448a);
        l.a(this.f2448a);
    }

    @Override // com.bytedance.live.kmp.core.a
    public final void stop() {
        List<e> r100 = f2447c;
        ArrayList r101 = (ArrayList) r100;
        r101.remove(this.f2448a);
        l.c(this.f2448a);
        ((LinkedHashMap) this.f2449b.f3783a).clear();
    }

    public a() {
        e.f465759a.getClass();
        b r100 = new b(e.a.f465760a);
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(this, "value");
        r100.f548916e = this;
        if (this != k.f470908a) goto L5;
        String r101 = "roomInstance";
    L6:
        if (r101 != null) goto L10;
        this.f2448a = r100;
        this.f2449b = new ai6.a();
        return;
    L10:
        throw new UninitializedPropertyAccessException(r101);
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.live.kmp.core.a
    public final vh6.a a() {
        return this.f2449b;
    }

    @Override // com.bytedance.live.kmp.core.a
    public final u60.a c() {
        return this.f2448a;
    }
}

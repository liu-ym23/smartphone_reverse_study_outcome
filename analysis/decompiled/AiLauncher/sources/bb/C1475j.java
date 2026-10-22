package bb;

import Ua.I;
import Za.C1192l;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0017¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ!\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lbb/j;", "LUa/I;", "<init>", "()V", "Lkotlin/coroutines/d;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "LY8/t;", "k1", "(Lkotlin/coroutines/d;Ljava/lang/Runnable;)V", "h1", "", "parallelism", "", "name", "s1", "(ILjava/lang/String;)LUa/I;", "toString", "()Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: bb.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1475j extends I {

    /* renamed from: b, reason: collision with root package name */
    public static final C1475j f15388b = new C1475j();

    @Override // Ua.I
    public void h1(kotlin.coroutines.d context, Runnable block) {
        C1467b.f15372h.w1(block, true, false);
    }

    @Override // Ua.I
    public void k1(kotlin.coroutines.d context, Runnable block) {
        C1467b.f15372h.w1(block, true, true);
    }

    @Override // Ua.I
    public I s1(int parallelism, String name) {
        C1192l.a(parallelism);
        return parallelism >= C1474i.f15385d ? C1192l.b(this, name) : super.s1(parallelism, name);
    }

    @Override // Ua.I
    /* renamed from: toString */
    public String getName() {
        return "Dispatchers.IO";
    }
}

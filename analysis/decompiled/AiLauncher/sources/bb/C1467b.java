package bb;

import Ua.I;
import Za.C1192l;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lbb/b;", "Lbb/e;", "<init>", "()V", "", "parallelism", "", "name", "LUa/I;", "s1", "(ILjava/lang/String;)LUa/I;", "LY8/t;", "close", "toString", "()Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: bb.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1467b extends C1470e {

    /* renamed from: h, reason: collision with root package name */
    public static final C1467b f15372h = new C1467b();

    public C1467b() {
        super(C1474i.f15384c, C1474i.f15385d, C1474i.f15386e, C1474i.f15382a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // Ua.I
    public I s1(int parallelism, String name) {
        C1192l.a(parallelism);
        return parallelism >= C1474i.f15384c ? C1192l.b(this, name) : super.s1(parallelism, name);
    }

    @Override // Ua.I
    /* renamed from: toString */
    public String getName() {
        return "Dispatchers.Default";
    }
}

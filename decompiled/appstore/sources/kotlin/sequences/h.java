package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h {

    public static final class a implements Sequence {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f21231a;

        public a(Function2 r10) {
            this.f21231a = r10;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator iterator() {
            return h.a(this.f21231a);
        }
    }

    public static Iterator a(Function2 r10) {
        q.g(r10, "block");
        f r11 = new f();
        r11.f(IntrinsicsKt__IntrinsicsJvmKt.b(r10, r11, r11));
        return r11;
    }

    public static Sequence b(Function2 r10) {
        q.g(r10, "block");
        return new a(r10);
    }
}

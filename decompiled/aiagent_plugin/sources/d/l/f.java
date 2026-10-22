package d.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.Comparable;

/* JADX INFO: compiled from: Range.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface f<T extends Comparable<? super T>> {

    /* JADX INFO: compiled from: Range.kt */
    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(f<T> r2, T r3) {
            f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.aiagent.plugin");
            Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "value");
            if (r5.compareTo(r4.g()) >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r5.compareTo(r4.h()) > 0) goto L7;
            return true;
        }

        public static <T extends Comparable<? super T>> boolean a(f<T> r2) {
            f r3 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.aiagent.plugin");
            if (r3.g().compareTo(r3.h()) <= 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    boolean a(T r1);

    boolean d();

    T g();

    T h();
}

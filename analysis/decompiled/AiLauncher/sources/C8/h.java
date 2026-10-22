package C8;

import C8.f;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class h {

    public interface a<T> {
        void a(List<T> list);
    }

    public abstract void a(int i10, a<f.a> aVar);

    public abstract void b(int i10, a<f.b> aVar);

    public abstract <T extends Appendable & CharSequence> void c(T t10, String str);

    public abstract void d();
}

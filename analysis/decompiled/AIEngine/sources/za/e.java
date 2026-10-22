package za;

import cb.j;
import com.tonyodev.fetch2.PrioritySort;
import com.tonyodev.fetch2.database.DownloadInfo;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface e<T extends DownloadInfo> extends Closeable {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a<T extends DownloadInfo> {
        void a(T t8);
    }

    List<T> B(PrioritySort prioritySort);

    long V(boolean z);

    void b(T t8);

    void d(T t8);

    Pair<T, Boolean> e(T t8);

    T e0();

    List<T> f(int i10);

    void g(List<? extends T> list);

    List<T> i(List<Integer> list);

    void i0(T t8);

    a<T> j();

    T k(String str);

    void k0(j.b.a aVar);

    void m();

    void m0(ArrayList arrayList);

    hb.c t();
}

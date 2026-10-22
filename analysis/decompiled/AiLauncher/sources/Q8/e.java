package Q8;

import io.objectbox.BoxStore;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import org.greenrobot.essentials.collections.MultimapSet;

/* loaded from: classes4.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final BoxStore f5458a;

    /* renamed from: b, reason: collision with root package name */
    public final MultimapSet<Integer, U8.a<Class>> f5459b = MultimapSet.e(MultimapSet.SetType.THREAD_SAFE);

    /* renamed from: c, reason: collision with root package name */
    public final Deque<a> f5460c = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f5461d;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final U8.a<Class> f5462a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f5463b;

        public a(U8.a<Class> aVar, int[] iArr) {
            this.f5462a = aVar;
            this.f5463b = iArr;
        }
    }

    public e(BoxStore boxStore) {
        this.f5458a = boxStore;
    }

    public final void a(Class cls) {
        RuntimeException runtimeException = new RuntimeException("Observer failed while processing data for " + cls + ". Consider using an ErrorObserver");
        runtimeException.printStackTrace();
        throw runtimeException;
    }

    public void b(int[] iArr) {
        c(null, iArr);
    }

    public final void c(U8.a<Class> aVar, int[] iArr) {
        synchronized (this.f5460c) {
            try {
                this.f5460c.add(new a(aVar, iArr));
                if (!this.f5461d) {
                    this.f5461d = true;
                    this.f5458a.N0(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVarPollFirst;
        while (true) {
            try {
            } catch (Throwable th) {
                this.f5461d = false;
                throw th;
            }
            synchronized (this.f5460c) {
                aVarPollFirst = this.f5460c.pollFirst();
                if (aVarPollFirst == null) {
                    this.f5461d = false;
                    this.f5461d = false;
                    return;
                }
                this.f5461d = false;
                throw th;
            }
            for (int i10 : aVarPollFirst.f5463b) {
                Collection collectionSingletonList = aVarPollFirst.f5462a != null ? Collections.singletonList(aVarPollFirst.f5462a) : this.f5459b.get(Integer.valueOf(i10));
                if (collectionSingletonList != null && !collectionSingletonList.isEmpty()) {
                    Class<?> clsV = this.f5458a.V(i10);
                    try {
                        Iterator it = collectionSingletonList.iterator();
                        while (it.hasNext()) {
                            ((U8.a) it.next()).a(clsV);
                        }
                    } catch (RuntimeException unused) {
                        a(clsV);
                    }
                }
            }
        }
    }
}

package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class AsyncListDiffer {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Executor f4042h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ListUpdateCallback f4043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.recyclerview.widget.b f4044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Executor f4045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f4046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f4047e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f4048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4049g;

    public interface ListListener<T> {
        void onCurrentListChanged(@NonNull List<T> r10, @NonNull List<T> r11);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f4050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f4051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f4052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Runnable f4053d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AsyncListDiffer f4054e;

        /* JADX INFO: renamed from: androidx.recyclerview.widget.AsyncListDiffer$a$a, reason: collision with other inner class name */
        public class C0042a extends DiffUtil.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f4055a;

            public C0042a(a r10) {
                this.f4055a = r10;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.b
            public boolean areContentsTheSame(int r10, int r11) {
                Object r12 = this.f4055a.f4050a.get(r10);
                Object r13 = this.f4055a.f4051b.get(r11);
                if (r12 == null) goto L7;
                if (r13 == null) goto L7;
                return this.f4055a.f4054e.f4044b.b().areContentsTheSame(r12, r13);
            L7:
                if (r12 != null) goto L12;
                if (r13 != null) goto L12;
                return true;
            L12:
                throw new AssertionError();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.b
            public boolean areItemsTheSame(int r10, int r11) {
                Object r12 = this.f4055a.f4050a.get(r10);
                Object r13 = this.f4055a.f4051b.get(r11);
                if (r12 == null) goto L7;
                if (r13 == null) goto L7;
                return this.f4055a.f4054e.f4044b.b().areItemsTheSame(r12, r13);
            L7:
                if (r12 != null) goto L10;
                if (r13 != null) goto L10;
                return true;
            L10:
                return false;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.b
            public Object getChangePayload(int r10, int r11) {
                Object r12 = this.f4055a.f4050a.get(r10);
                Object r13 = this.f4055a.f4051b.get(r11);
                if (r12 == null) goto L8;
                if (r13 == null) goto L8;
                return this.f4055a.f4054e.f4044b.b().getChangePayload(r12, r13);
            L8:
                throw new AssertionError();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.b
            public int getNewListSize() {
                return this.f4055a.f4051b.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.b
            public int getOldListSize() {
                return this.f4055a.f4050a.size();
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DiffUtil.DiffResult f4056a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f4057b;

            public b(a r10, DiffUtil.DiffResult r11) {
                this.f4057b = r10;
                this.f4056a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                a r10 = this.f4057b;
                AsyncListDiffer r11 = r10.f4054e;
                if (r11.f4049g != r10.f4052c) goto L6;
                r11.c(r10.f4051b, this.f4056a, r10.f4053d);
                return;
            }
        }

        public a(AsyncListDiffer r10, List r11, List r12, int r13, Runnable r14) {
            this.f4054e = r10;
            this.f4050a = r11;
            this.f4051b = r12;
            this.f4052c = r13;
            this.f4053d = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            DiffUtil.DiffResult r10 = DiffUtil.b(new C0042a(this));
            this.f4054e.f4045c.execute(new b(this, r10));
        }
    }

    public static class b implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f4058a;

        public b() {
            this.f4058a = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r10) {
            this.f4058a.post(r10);
        }
    }

    static {
        f4042h = new b();
    }

    public AsyncListDiffer(ListUpdateCallback r10, androidx.recyclerview.widget.b r11) {
        this.f4046d = new CopyOnWriteArrayList();
        this.f4048f = Collections.emptyList();
        this.f4043a = r10;
        this.f4044b = r11;
        if (r11.c() == null) goto L5;
        this.f4045c = r11.c();
        return;
    L5:
        this.f4045c = f4042h;
    }

    public void a(ListListener r10) {
        this.f4046d.add(r10);
    }

    public List b() {
        return this.f4048f;
    }

    public void c(List r10, DiffUtil.DiffResult r11, Runnable r12) {
        List r13 = this.f4048f;
        this.f4047e = r10;
        this.f4048f = Collections.unmodifiableList(r10);
        r11.b(this.f4043a);
        d(r13, r12);
    }

    public final void d(List r10, Runnable r11) {
        Iterator r12 = this.f4046d.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((ListListener) r12.next()).onCurrentListChanged(r10, this.f4048f);
        goto L4
    L6:
        if (r11 == null) goto L10;
        r11.run();
        return;
    }

    public void e(List r10) {
        f(r10, null);
    }

    public void f(List r10, Runnable r11) {
        int r12 = this.f4049g + 1;
        this.f4049g = r12;
        List r13 = this.f4047e;
        if (r10 != r13) goto L7;
        if (r11 == null) goto L16;
        r11.run();
        return;
    L16:
        return;
    L7:
        List r14 = this.f4048f;
        if (r10 != null) goto L11;
        int r15 = r13.size();
        this.f4047e = null;
        this.f4048f = Collections.emptyList();
        this.f4043a.onRemoved(0, r15);
        d(r14, r11);
        return;
    L11:
        if (r13 != null) goto L14;
        this.f4047e = r10;
        this.f4048f = Collections.unmodifiableList(r10);
        this.f4043a.onInserted(0, r10.size());
        d(r14, r11);
        return;
    L14:
        this.f4044b.a().execute(new a(this, r13, r10, r12, r11));
    }
}

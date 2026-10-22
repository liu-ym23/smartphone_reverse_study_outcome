package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools$Pool;

/* JADX INFO: loaded from: classes.dex */
public class ViewInfoStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleArrayMap f4309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.collection.c f4310b;

    public interface ProcessCallback {
        void processAppeared(RecyclerView.ViewHolder r10, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo r11, RecyclerView.ItemAnimator.ItemHolderInfo r12);

        void processDisappeared(RecyclerView.ViewHolder r10, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r11, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo r12);

        void processPersistent(RecyclerView.ViewHolder r10, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r11, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r12);

        void unused(RecyclerView.ViewHolder r10);
    }

    public static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static Pools$Pool f4311d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.ItemAnimator.ItemHolderInfo f4313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public RecyclerView.ItemAnimator.ItemHolderInfo f4314c;

        static {
            f4311d = new androidx.core.util.d(20);
        }

        public a() {
        }

        public static void a() {
        L3:
            if (f4311d.acquire() != null) goto L3;
        }

        public static a b() {
            a r10 = (a) f4311d.acquire();
            if (r10 == null) goto L5;
            return r10;
        L5:
            return new a();
        }

        public static void c(a r10) {
            r10.f4312a = 0;
            r10.f4313b = null;
            r10.f4314c = null;
            f4311d.release(r10);
        }
    }

    public ViewInfoStore() {
        this.f4309a = new SimpleArrayMap();
        this.f4310b = new androidx.collection.c();
    }

    public void a(RecyclerView.ViewHolder r10, RecyclerView.ItemAnimator.ItemHolderInfo r11) {
        a r12 = (a) this.f4309a.get(r10);
        if (r12 != null) goto L5;
        r12 = a.b();
        this.f4309a.put(r10, r12);
    L5:
        r12.f4312a |= 2;
        r12.f4313b = r11;
    }

    public void b(RecyclerView.ViewHolder r10) {
        a r11 = (a) this.f4309a.get(r10);
        if (r11 != null) goto L5;
        r11 = a.b();
        this.f4309a.put(r10, r11);
    L5:
        r11.f4312a |= 1;
    }

    public void c(long r10, RecyclerView.ViewHolder r11) {
        this.f4310b.j(r10, r11);
    }

    public void d(RecyclerView.ViewHolder r10, RecyclerView.ItemAnimator.ItemHolderInfo r11) {
        a r12 = (a) this.f4309a.get(r10);
        if (r12 != null) goto L5;
        r12 = a.b();
        this.f4309a.put(r10, r12);
    L5:
        r12.f4314c = r11;
        r12.f4312a |= 8;
    }

    public void e(RecyclerView.ViewHolder r10, RecyclerView.ItemAnimator.ItemHolderInfo r11) {
        a r12 = (a) this.f4309a.get(r10);
        if (r12 != null) goto L5;
        r12 = a.b();
        this.f4309a.put(r10, r12);
    L5:
        r12.f4313b = r11;
        r12.f4312a |= 4;
    }

    public void f() {
        this.f4309a.clear();
        this.f4310b.a();
    }

    public RecyclerView.ViewHolder g(long r10) {
        return (RecyclerView.ViewHolder) this.f4310b.e(r10);
    }

    public boolean h(RecyclerView.ViewHolder r10) {
        a r11 = (a) this.f4309a.get(r10);
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r11.f4312a & 1) == 0) goto L7;
        return true;
    }

    public boolean i(RecyclerView.ViewHolder r10) {
        a r11 = (a) this.f4309a.get(r10);
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r11.f4312a & 4) == 0) goto L7;
        return true;
    }

    public void j() {
        a.a();
    }

    public void k(RecyclerView.ViewHolder r10) {
        p(r10);
    }

    public final RecyclerView.ItemAnimator.ItemHolderInfo l(RecyclerView.ViewHolder r10, int r11) {
        int r12 = this.f4309a.indexOfKey(r10);
        if (r12 >= 0) goto L5;
        return null;
    L5:
        a r13 = (a) this.f4309a.valueAt(r12);
        if (r13 == null) goto L21;
        int r14 = r13.f4312a;
        if ((r14 & r11) == 0) goto L21;
        int r15 = (~r11) & r14;
        r13.f4312a = r15;
        if (r11 != 4) goto L13;
        RecyclerView.ItemAnimator.ItemHolderInfo r16 = r13.f4313b;
    L16:
        if ((r15 & 12) != 0) goto L18;
        this.f4309a.removeAt(r12);
        a.c(r13);
    L18:
        return r16;
    L13:
        if (r11 != 8) goto L20;
        r16 = r13.f4314c;
        goto L16
    L20:
        throw new IllegalArgumentException("Must provide flag PRE or POST");
    L21:
        return null;
    }

    public RecyclerView.ItemAnimator.ItemHolderInfo m(RecyclerView.ViewHolder r10) {
        return l(r10, 8);
    }

    public RecyclerView.ItemAnimator.ItemHolderInfo n(RecyclerView.ViewHolder r10) {
        return l(r10, 4);
    }

    public void o(ProcessCallback r10) {
        int r11 = this.f4309a.size() - 1;
    L3:
        if (r11 < 0) goto L26;
        RecyclerView.ViewHolder r12 = (RecyclerView.ViewHolder) this.f4309a.keyAt(r11);
        a r13 = (a) this.f4309a.removeAt(r11);
        int r14 = r13.f4312a;
        if ((r14 & 3) != 3) goto L8;
        r10.unused(r12);
    L25:
        a.c(r13);
        r11 = r11 - 1;
        goto L3
    L8:
        if ((r14 & 1) == 0) goto L14;
        RecyclerView.ItemAnimator.ItemHolderInfo r15 = r13.f4313b;
        if (r15 != null) goto L12;
        r10.unused(r12);
        goto L25
    L12:
        r10.processDisappeared(r12, r15, r13.f4314c);
        goto L25
    L14:
        if ((r14 & 14) != 14) goto L17;
        r10.processAppeared(r12, r13.f4313b, r13.f4314c);
        goto L25
    L17:
        if ((r14 & 12) != 12) goto L20;
        r10.processPersistent(r12, r13.f4313b, r13.f4314c);
        goto L25
    L20:
        if ((r14 & 4) == 0) goto L23;
        r10.processDisappeared(r12, r13.f4313b, null);
        goto L25
    L23:
        if ((r14 & 8) == 0) goto L25;
        r10.processAppeared(r12, r13.f4313b, r13.f4314c);
        goto L25
    }

    public void p(RecyclerView.ViewHolder r10) {
        a r11 = (a) this.f4309a.get(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        r11.f4312a &= -2;
    }

    public void q(RecyclerView.ViewHolder r10) {
        int r11 = this.f4310b.m() - 1;
    L3:
        if (r11 < 0) goto L8;
        if (r10 == this.f4310b.n(r11)) goto L6;
        r11 = r11 - 1;
        goto L3
    L6:
        this.f4310b.l(r11);
    L8:
        a r12 = (a) this.f4309a.remove(r10);
        if (r12 == null) goto L14;
        a.c(r12);
        return;
    }
}

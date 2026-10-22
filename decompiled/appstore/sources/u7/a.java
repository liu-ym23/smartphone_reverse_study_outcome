package u7;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24888a = null;

    static {
        f24888a = new a();
    }

    public a() {
    }

    public static /* synthetic */ void c(a r10, RecyclerView r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = 1;
    L5:
        r10.b(r11, r12);
    }

    public final void a(RecyclerView r10) {
        if (r10 == null) goto L5;
        r10.addItemDecoration(new b(0, 1, null));
        return;
    }

    public final void b(RecyclerView r10, int r11) {
        if (r10 == null) goto L4;
        r10.addItemDecoration(new b(0, 1, null));
    L4:
        if (r10 == null) goto L7;
        r10.addItemDecoration(new c(r11));
        return;
    }
}

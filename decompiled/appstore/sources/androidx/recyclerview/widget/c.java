package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class c implements ListUpdateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ListUpdateCallback f4324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f4328e;

    public c(ListUpdateCallback r10) {
        this.f4325b = 0;
        this.f4326c = -1;
        this.f4327d = -1;
        this.f4328e = null;
        this.f4324a = r10;
    }

    public void a() {
        int r10 = this.f4325b;
        if (r10 != 0) goto L6;
        return;
    L6:
        if (r10 != 1) goto L8;
        this.f4324a.onInserted(this.f4326c, this.f4327d);
    L15:
        this.f4328e = null;
        this.f4325b = 0;
        return;
    L8:
        if (r10 != 2) goto L10;
        this.f4324a.onRemoved(this.f4326c, this.f4327d);
        goto L15
    L10:
        if (r10 != 3) goto L15;
        this.f4324a.onChanged(this.f4326c, this.f4327d, this.f4328e);
        goto L15
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int r10, int r11, Object r12) {
        if (this.f4325b != 3) goto L12;
        int r13 = this.f4326c;
        int r14 = this.f4327d;
        if (r10 > (r13 + r14)) goto L12;
        int r15 = r10 + r11;
        if (r15 < r13) goto L12;
        if (this.f4328e != r12) goto L12;
        this.f4326c = Math.min(r10, r13);
        this.f4327d = Math.max(r14 + r13, r15) - this.f4326c;
        return;
    L12:
        a();
        this.f4326c = r10;
        this.f4327d = r11;
        this.f4328e = r12;
        this.f4325b = 3;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int r10, int r11) {
        if (this.f4325b != 1) goto L10;
        int r12 = this.f4326c;
        if (r10 < r12) goto L10;
        int r13 = this.f4327d;
        if (r10 > (r12 + r13)) goto L10;
        this.f4327d = r13 + r11;
        this.f4326c = Math.min(r10, r12);
        return;
    L10:
        a();
        this.f4326c = r10;
        this.f4327d = r11;
        this.f4325b = 1;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int r10, int r11) {
        a();
        this.f4324a.onMoved(r10, r11);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int r10, int r11) {
        if (this.f4325b != 2) goto L10;
        int r12 = this.f4326c;
        if (r12 < r10) goto L10;
        if (r12 > (r10 + r11)) goto L10;
        this.f4327d += r11;
        this.f4326c = r10;
        return;
    L10:
        a();
        this.f4326c = r10;
        this.f4327d = r11;
        this.f4325b = 2;
    }
}

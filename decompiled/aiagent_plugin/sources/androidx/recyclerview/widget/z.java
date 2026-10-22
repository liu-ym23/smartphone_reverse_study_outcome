package androidx.recyclerview.widget;

import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SnapHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class z extends RecyclerView.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    RecyclerView f2592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Scroller f2593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RecyclerView.l f2594c;

    public abstract int a(RecyclerView.h r1, int r2, int r3);

    public abstract View a(RecyclerView.h r1);

    public abstract int[] a(RecyclerView.h r1, View r2);

    public z() {
        this.f2594c = new AnonymousClass1(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public boolean a(int r5, int r6) {
        RecyclerView.h r0 = this.f2592a.getLayoutManager();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (this.f2592a.getAdapter() != null) goto L8;
        return false;
    L8:
        int r2 = this.f2592a.getMinFlingVelocity();
        if (Math.abs(r6) > r2) goto L13;
        if (Math.abs(r5) > r2) goto L13;
        return false;
    L13:
        if (b(r0, r5, r6) == false) goto L17;
        return true;
    L17:
        return false;
    }

    public void a(RecyclerView r4) {
        RecyclerView r0 = this.f2592a;
        if (r0 != r4) goto L5;
        return;
    L5:
        if (r0 == null) goto L7;
        c();
    L7:
        this.f2592a = r4;
        if (r4 == null) goto L11;
        b();
        this.f2593b = new Scroller((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f2592a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), new DecelerateInterpolator());
        a();
        return;
    }

    private void b() {
        if (this.f2592a.getOnFlingListener() != null) goto L7;
        this.f2592a.addOnScrollListener(this.f2594c);
        this.f2592a.setOnFlingListener(this);
        return;
    L7:
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private void c() {
        this.f2592a.removeOnScrollListener(this.f2594c);
        this.f2592a.setOnFlingListener(null);
    }

    private boolean b(RecyclerView.h r3, int r4, int r5) {
        if (ZeusTransformUtils.instanceOf(r3, RecyclerView.q.b.class) == true) goto L5;
        return false;
    L5:
        RecyclerView.q r0 = b(r3);
        if (r0 != null) goto L8;
        return false;
    L8:
        int r2 = a(r3, r4, r5);
        if (r2 != (-1)) goto L11;
        return false;
    L11:
        r0.c(r2);
        r3.a(r0);
        return true;
    }

    void a() {
        RecyclerView r0 = this.f2592a;
        if (r0 != null) goto L5;
        return;
    L5:
        RecyclerView.h r1 = r0.getLayoutManager();
        if (r1 != null) goto L8;
        return;
    L8:
        View r2 = a(r1);
        if (r2 != null) goto L11;
        return;
    L11:
        int[] r3 = a(r1, r2);
        if (r3[0] == 0) goto L14;
    L15:
        this.f2592a.smoothScrollBy(r3[0], r3[1]);
        return;
    L14:
        if (r3[1] != 0) goto L15;
    }

    public RecyclerView.q b(RecyclerView.h r1) {
        return c(r1);
    }

    @Deprecated
    public p c(RecyclerView.h r4) {
        if (ZeusTransformUtils.instanceOf(r4, RecyclerView.q.b.class) == true) goto L6;
        return null;
    L6:
        final Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f2592a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        return new AnonymousClass2(this, r0);
    }
}

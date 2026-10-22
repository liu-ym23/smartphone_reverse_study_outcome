package f;

import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.view.menu.ActionMenuItemView;
import g.v0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final float f2407a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2408b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2409c;
    public final View d;

    /* renamed from: e, reason: collision with root package name */
    public v0 f2410e;

    /* renamed from: f, reason: collision with root package name */
    public v0 f2411f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2412g;

    /* renamed from: h, reason: collision with root package name */
    public int f2413h;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f2414j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f2415k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ View f2416l;

    public a(View view) {
        this.f2414j = new int[2];
        this.d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f2407a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f2408b = tapTimeout;
        this.f2409c = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        v0 v0Var = this.f2411f;
        View view = this.d;
        if (v0Var != null) {
            view.removeCallbacks(v0Var);
        }
        v0 v0Var2 = this.f2410e;
        if (v0Var2 != null) {
            view.removeCallbacks(v0Var2);
        }
    }

    public final l b() {
        g.f fVar;
        switch (this.f2415k) {
            case 0:
                b bVar = ((ActionMenuItemView) this.f2416l).f248m;
                if (bVar == null || (fVar = ((g.g) bVar).f2705a.f2729t) == null) {
                    return null;
                }
                return fVar.a();
            default:
                g.f fVar2 = ((g.h) this.f2416l).d.f2728s;
                if (fVar2 == null) {
                    return null;
                }
                return fVar2.a();
        }
    }

    public final boolean c() {
        l lVarB;
        switch (this.f2415k) {
            case 0:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) this.f2416l;
                i iVar = actionMenuItemView.f246k;
                return iVar != null && iVar.a(actionMenuItemView.f243g) && (lVarB = b()) != null && lVarB.k();
            default:
                ((g.h) this.f2416l).d.k();
                return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0124  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f2412g = false;
        this.f2413h = -1;
        v0 v0Var = this.f2410e;
        if (v0Var != null) {
            this.d.removeCallbacks(v0Var);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(ActionMenuItemView actionMenuItemView) {
        this((View) actionMenuItemView);
        this.f2415k = 0;
        this.f2416l = actionMenuItemView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(g.h hVar, g.h hVar2) {
        this(hVar2);
        this.f2415k = 1;
        this.f2416l = hVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}

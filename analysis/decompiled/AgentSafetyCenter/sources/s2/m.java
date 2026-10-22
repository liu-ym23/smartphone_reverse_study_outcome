package s2;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.activity.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends q {

    /* renamed from: h, reason: collision with root package name */
    public xb.a f11361h;
    public k i;

    /* renamed from: j, reason: collision with root package name */
    public View f11362j;

    /* renamed from: k, reason: collision with root package name */
    public j f11363k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f11364l;

    public static final void d(ViewGroup viewGroup) {
        viewGroup.setClipChildren(false);
        if (viewGroup instanceof j) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            ViewGroup viewGroup2 = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
            if (viewGroup2 != null) {
                d(viewGroup2);
            }
        }
    }

    public final void e(xb.a aVar, k kVar, o2.l lVar) {
        int i;
        j jVar = this.f11363k;
        this.f11361h = aVar;
        this.i = kVar;
        n nVar = kVar.f11356c;
        View view = this.f11362j;
        int i3 = e.f11343a;
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        boolean z10 = (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) ? false : true;
        int iOrdinal = nVar.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                z10 = true;
            } else {
                if (iOrdinal != 2) {
                    g5.f.a();
                    return;
                }
                z10 = false;
            }
        }
        Window window = getWindow();
        window.getClass();
        window.setFlags(z10 ? 8192 : -8193, 8192);
        int iOrdinal2 = lVar.ordinal();
        if (iOrdinal2 == 0) {
            i = 0;
        } else {
            if (iOrdinal2 != 1) {
                g5.f.a();
                return;
            }
            i = 1;
        }
        jVar.setLayoutDirection(i);
        boolean z11 = kVar.f11358e;
        boolean z12 = kVar.f11357d;
        Window window2 = jVar.f11348m;
        boolean z13 = (jVar.f11352q && z12 == jVar.f11350o && z11 == jVar.f11351p) ? false : true;
        jVar.f11350o = z12;
        jVar.f11351p = z11;
        if (z13) {
            WindowManager.LayoutParams attributes = window2.getAttributes();
            int i10 = z12 ? -2 : -1;
            if (i10 != attributes.width || !jVar.f11352q) {
                window2.setLayout(i10, -2);
                jVar.f11352q = true;
            }
        }
        setCanceledOnTouchOutside(kVar.f11355b);
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setSoftInputMode(z11 ? 0 : 48);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!this.i.f11354a || !keyEvent.isTracking() || keyEvent.isCanceled() || i != 111) {
            return super.onKeyUp(i, keyEvent);
        }
        this.f11361h.invoke();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008b  */
    @Override // android.app.Dialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            boolean r0 = super.onTouchEvent(r10)
            s2.k r1 = r9.i
            boolean r1 = r1.f11355b
            r2 = 3
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L8b
            s2.j r1 = r9.f11363k
            r1.getClass()
            float r5 = r10.getX()
            boolean r6 = java.lang.Float.isInfinite(r5)
            if (r6 != 0) goto L6e
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 != 0) goto L6e
            float r5 = r10.getY()
            boolean r6 = java.lang.Float.isInfinite(r5)
            if (r6 != 0) goto L6e
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 != 0) goto L6e
            android.view.View r5 = r1.getChildAt(r3)
            if (r5 != 0) goto L39
            goto L6e
        L39:
            int r6 = r1.getLeft()
            int r7 = r5.getLeft()
            int r7 = r7 + r6
            int r6 = r5.getWidth()
            int r6 = r6 + r7
            int r1 = r1.getTop()
            int r8 = r5.getTop()
            int r8 = r8 + r1
            int r1 = r5.getHeight()
            int r1 = r1 + r8
            float r5 = r10.getX()
            int r5 = ac.a.Q(r5)
            if (r7 > r5) goto L6e
            if (r5 > r6) goto L6e
            float r5 = r10.getY()
            int r5 = ac.a.Q(r5)
            if (r8 > r5) goto L6e
            if (r5 > r1) goto L6e
            goto L8b
        L6e:
            int r10 = r10.getActionMasked()
            if (r10 == 0) goto L88
            if (r10 == r4) goto L7c
            if (r10 == r2) goto L79
            goto L95
        L79:
            r9.f11364l = r3
            return r0
        L7c:
            boolean r10 = r9.f11364l
            if (r10 == 0) goto L95
            xb.a r10 = r9.f11361h
            r10.invoke()
            r9.f11364l = r3
            return r4
        L88:
            r9.f11364l = r4
            return r4
        L8b:
            int r10 = r10.getActionMasked()
            if (r10 == 0) goto L96
            if (r10 == r4) goto L96
            if (r10 == r2) goto L96
        L95:
            return r0
        L96:
            r9.f11364l = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.m.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
    }
}

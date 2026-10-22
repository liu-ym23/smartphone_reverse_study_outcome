package b41;

import android.graphics.RectF;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f17461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f17462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewTreeObserverOnGlobalLayoutListenerC0260a f17463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f17464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<RectF, Unit> f17465f;

    /* JADX INFO: renamed from: b41.a$a, reason: collision with other inner class name */
    public static final class ViewTreeObserverOnGlobalLayoutListenerC0260a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f17466a;

        public ViewTreeObserverOnGlobalLayoutListenerC0260a(a r100) {
            this.f17466a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            a r100 = this.f17466a;
            View r101 = r100.f17461b;
            RectF r102 = null;
            if (r101 != null) goto L12;
            RectF r103 = r100.f17462c;
            if (r103 == null) goto L30;
            if (r103 != null) goto L9;
        L11:
            r100.f17462c = null;
            r100.f17465f.invoke(null);
            return;
        L9:
            if (r103.equals(null) != true) goto L11;
            return;
        L30:
            return;
        L12:
            RectF r104 = a.a(r100.f17464e);
            if (r104 == null) goto L19;
            RectF r105 = a.a(r101);
            if (r105 == null) goto L19;
            float r106 = r105.left - r104.left;
            float r107 = r105.top - r104.top;
            r102 = new RectF(r106, r107, r105.width() + r106, r105.height() + r107);
        L19:
            RectF r108 = r100.f17462c;
            if (r108 != null) goto L23;
            if (r102 != null) goto L23;
            return;
        L23:
            if (r108 != null) goto L25;
        L27:
            r100.f17462c = r102;
            r100.f17465f.invoke(r102);
            return;
        L25:
            if (r108.equals(r102) != true) goto L27;
        }
    }

    public static RectF a(View r100) {
        if (ViewCompat.isAttachedToWindow(r100) == true) goto L5;
        return null;
    L5:
        Object r101 = r100.getParent();
        if ((r101 instanceof View) == true) goto L8;
        r101 = null;
    L8:
        View r102 = (View) r101;
        if (r102 != null) goto L11;
        return null;
    L11:
        int[] r103 = new int[2];
        r102.getLocationOnScreen(r103);
        float r104 = r103[0] + r100.getLeft();
        float r105 = r103[1] + r100.getTop();
        return new RectF(r104, r105, r100.getWidth() + r104, r100.getHeight() + r105);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(View r100, Function1<? super RectF, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "baseline");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f17464e = r100;
        this.f17465f = r101;
        this.f17463d = new ViewTreeObserverOnGlobalLayoutListenerC0260a(this);
    }
}

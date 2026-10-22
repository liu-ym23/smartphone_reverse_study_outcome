package cna;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.oui.material.OMaterialHelper;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f24580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f24581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f24582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f24583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f24584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f24585f;

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f24586a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        }

        public a(d r100) {
            this.f24586a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            d r101 = this.f24586a;
            if (r101.f24583d == false) goto L18;
            Object r102 = r101.f24580a.getContext().getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L9
            if (r102 == null) goto L8;
            ((WindowManager) r102).removeViewImmediate(r101.f24580a);     // Catch: Exception -> L9
        L11:
            r101.f24583d = false;
            ViewGroup r103 = r101.f24584e;
            if (r103 == null) goto L15;
            r103.removeOnAttachStateChangeListener(r101.f24585f);
        L15:
            r101.f24584e = null;
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");     // Catch: Exception -> L9
        L9:
            e = move-exception;
            wma.b.b("OFloatingWindowHelper", Intrinsics.stringPlus("Failed to remove view from WindowManager: ", e.getMessage()));
            goto L11
        }
    }

    public final void b() {
        if (this.f24581b == false) goto L10;
        boolean r100 = this.f24583d;
        if (r100 == true) goto L11;
        if (r100 == true) goto L12;
        this.f24580a.post(new b(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    public d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        this.f24580a = r100;
        this.f24582c = 1;
        this.f24585f = new a(this);
    }

    public final void c(boolean r100, final Function1<? super xma.b, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "updateLayout");
        if (r100 == false) goto L6;
        zma.a r102 = zma.a.f572881a;
        r101.invoke(zma.a.f(this.f24580a, null, true));
        this.f24580a.setOnApplyWindowInsetsListener(new cna.a(this, r101));
        return;
    }

    public final void a(View r100, com.obric.oui.material.c r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "maskView");
        Intrinsics.checkNotNullParameter(r101, "maskMaterialConfig");
        com.obric.oui.blur.a r103 = r101.f401458g;
        Intrinsics.checkNotNull(r103);
        if (r103.f398866a <= 0.0f) goto L5;
        OMaterialHelper.p(r100, r101, r102);
    L6:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        OMaterialHelper.t(r100, r100);
        return;
    L5:
        OMaterialHelper.q(r100, 0);
        goto L6
    }
}

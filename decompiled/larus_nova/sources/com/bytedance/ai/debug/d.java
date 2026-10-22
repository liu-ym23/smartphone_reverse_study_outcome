package com.bytedance.ai.debug;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.ai.widget.view.WidgetBoxView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f36201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f36202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f36203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f36204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f36205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f36206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f36207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f36208h;

    public static final class a implements com.bytedance.ai.lynx.g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f36209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f36210b;

        @Override // com.bytedance.ai.lynx.g.b
        public final boolean onTouchEvent(MotionEvent r100) {
            return this.f36209a.b(this.f36210b, r100);
        }

        public a(d r100, View r101) {
            this.f36209a = r100;
            this.f36210b = r101;
        }
    }

    public static final class b implements WidgetBoxView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f36211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f36212b;

        @Override // com.bytedance.ai.widget.view.WidgetBoxView.b
        public final boolean onTouchEvent(MotionEvent r100) {
            return this.f36211a.b(this.f36212b, r100);
        }

        public b(d r100, View r101) {
            this.f36211a = r100;
            this.f36212b = r101;
        }
    }

    public final void a(View r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof com.bytedance.ai.lynx.g) == false) goto L9;
        a r101 = new a(this, r100);
        ((com.bytedance.ai.lynx.g) r100).f36665j = r101;
        return;
    L9:
        if ((r100 instanceof WidgetBoxView) == false) goto L12;
        b r102 = new b(this, r100);
        ((WidgetBoxView) r100).f38071j = r102;
        return;
    L12:
        r100.setOnTouchListener(new c(this));
    }

    public d(boolean r100, Function0<Boolean> r101) {
        Intrinsics.checkNotNullParameter(r101, "onTap");
        this.f36201a = r100;
        this.f36202b = r101;
    }

    public final boolean b(View r100, MotionEvent r101) {
        Integer r102 = null;
        if ((r100 instanceof com.bytedance.ai.lynx.g) == false) goto L8;
        Object r103 = ((com.bytedance.ai.lynx.g) r100).getDebugOverlay();
        if ((r103 instanceof e) == false) goto L15;
        e r104 = (e) r103;
    L16:
        if (r101 == null) goto L18;
        r102 = Integer.valueOf(r101.getActionMasked());
    L18:
        boolean r105 = true;
        if (r102 != null) goto L22;
    L35:
        if (r102 == null) goto L62;
        if (r102.intValue() != 2) goto L62;
        if (this.f36203c == true) goto L43;
        return false;
    L43:
        if (this.f36201a == false) goto L57;
        if (r104 == null) goto L57;
        float r106 = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
        if (this.f36204d == true) goto L53;
        if (Math.abs(r101.getX() - this.f36205e) <= r106) goto L50;
    L51:
        this.f36204d = true;
        goto L53
    L50:
        if (Math.abs(r101.getY() - this.f36206f) > r106) goto L51;
    L53:
        if (this.f36204d == false) goto L57;
        r104.b(r100.getWidth(), r100.getHeight(), r101.getX() - this.f36207g, r101.getY() - this.f36208h);
        r100.invalidate();
        return true;
    L57:
        if (IAISDKDebugService.f36186a.p(r100, r101.getX(), r101.getY()) == true) goto L60;
        this.f36203c = false;
    L60:
        return this.f36203c;
    L62:
        if (r102 != null) goto L65;
    L80:
        if (r102 != null) goto L83;
    L85:
        return false;
    L83:
        if (r102.intValue() != 3) goto L85;
        this.f36203c = false;
        this.f36204d = false;
        this.f36205e = 0.0f;
        this.f36206f = 0.0f;
        this.f36207g = 0.0f;
        this.f36208h = 0.0f;
        goto L85
    L65:
        if (r102.intValue() != 1) goto L80;
        if (this.f36204d == false) goto L71;
        this.f36203c = false;
        this.f36204d = false;
        this.f36205e = 0.0f;
        this.f36206f = 0.0f;
        this.f36207g = 0.0f;
        this.f36208h = 0.0f;
        return true;
    L71:
        if (this.f36203c == true) goto L73;
    L77:
        r105 = false;
    L78:
        this.f36203c = false;
        this.f36204d = false;
        this.f36205e = 0.0f;
        this.f36206f = 0.0f;
        this.f36207g = 0.0f;
        this.f36208h = 0.0f;
        return r105;
    L73:
        if (IAISDKDebugService.f36186a.p(r100, r101.getX(), r101.getY()) == false) goto L77;
        if (this.f36202b.invoke().booleanValue() == false) goto L77;
    L22:
        if (r102.intValue() != 0) goto L35;
        if (r104 != null) goto L25;
    L27:
        r105 = false;
    L28:
        this.f36203c = r105;
        this.f36204d = false;
        this.f36205e = r101.getX();
        this.f36206f = r101.getY();
        if (r104 == null) goto L34;
        RectF r107 = r104.a(r100.getWidth(), r100.getHeight());
        if (r107 == null) goto L34;
        this.f36207g = r101.getX() - r107.left;
        this.f36208h = r101.getY() - r107.top;
    L34:
        return this.f36203c;
    L25:
        if (IAISDKDebugService.f36186a.p(r100, r101.getX(), r101.getY()) == false) goto L27;
    L15:
        r104 = null;
        goto L16
    L8:
        if ((r100 instanceof WidgetBoxView) == false) goto L12;
        Object r108 = ((WidgetBoxView) r100).getDebugOverlay();
        if ((r108 instanceof e) == false) goto L15;
        r104 = (e) r108;
        goto L16
    L12:
        Object r109 = r100.getForeground();
        if ((r109 instanceof e) == false) goto L15;
        r104 = (e) r109;
        goto L16
    }
}

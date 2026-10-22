package com.obric.oui.toast;

import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.PopupWindow;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OPopupNotice.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OPopupNotice {
    private static final String TAG = "OPopupNotice";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f36763a = null;
    private static final int g = 0;
    private static final int h = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f36764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PopupWindow f36765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final View f36766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f36767e;
    private Timer f;

    /* JADX INFO: compiled from: OPopupNotice.kt */
    public final class PopupOutlineProvider extends ViewOutlineProvider {
        private float radius;
        private final Rect rect;
        private float scaleX;
        private float scaleY;
        final /* synthetic */ OPopupNotice this$0;
        private int yShift;

        public PopupOutlineProvider(OPopupNotice r2, int r3, float r4, float r5) {
            o.e(r2, "this$0");
            this.this$0 = r2;
            this.yShift = r3;
            this.scaleX = r4;
            this.scaleY = r5;
            this.rect = new Rect();
            this.radius = -1.0f;
        }

        public final int getYShift() {
            return this.yShift;
        }

        public final void setYShift(int r1) {
            this.yShift = r1;
        }

        public final float getScaleX() {
            return this.scaleX;
        }

        public final void setScaleX(float r1) {
            this.scaleX = r1;
        }

        public final float getScaleY() {
            return this.scaleY;
        }

        public final void setScaleY(float r1) {
            this.scaleY = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r4, Outline r5) {
            if (this.radius != (-1.0f)) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            this.radius = g.b(OPopupNotice.a(this.this$0), OPopupNotice.b());
        L8:
            if (r4 == null) goto L14;
            Drawable r6 = r4.getBackground();
            if (r6 == null) goto L14;
            r6.copyBounds(this.rect);
        L14:
            scaleX(this.rect, this.scaleX);
            scaleY(this.rect, this.scaleY);
            this.rect.offset(0, this.yShift);
            if (r5 == null) goto L19;
            r5.setRoundRect(this.rect, this.radius);
            return;
        L19:
            return;
        L5:
            r0 = false;
            goto L6
        }

        private final void scaleX(Rect r2, float r3) {
            if (r3 != 1.0f) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L9;
            r2.left = (int) ((r2.left * r3) + 0.5f);
            r2.right = (int) ((r2.right * r3) + 0.5f);
            return;
        L9:
            return;
        L5:
            r1 = false;
            goto L6
        }

        private final void scaleY(Rect r2, float r3) {
            if (r3 != 1.0f) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L9;
            r2.top = (int) ((r2.top * r3) + 0.5f);
            r2.bottom = (int) ((r2.bottom * r3) + 0.5f);
            return;
        L9:
            return;
        L5:
            r1 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: OPopupNotice.kt */
    public final class Timer extends CountDownTimer {
        final /* synthetic */ OPopupNotice this$0;

        @Override // android.os.CountDownTimer
        public void onTick(long r1) {
        }

        public Timer(OPopupNotice r2, long r3, long r5) {
            o.e(r2, "this$0");
            this.this$0 = r2;
            super(r3, r5);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.this$0.a(e.f36770a);
        }
    }

    /* JADX INFO: compiled from: OPopupNotice.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b f36768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d f36769b;

        public final b a() {
            return this.f36768a;
        }

        public final d b() {
            return this.f36769b;
        }
    }

    /* JADX INFO: compiled from: OPopupNotice.kt */
    public interface b {
        void a(OPopupNotice r1);

        void b(OPopupNotice r1);
    }

    /* JADX INFO: compiled from: OPopupNotice.kt */
    public static final class c {
        public /* synthetic */ c(h r1) {
            this();
        }

        private c() {
        }
    }

    /* JADX INFO: compiled from: OPopupNotice.kt */
    public interface d {
        void a(OPopupNotice r1, e r2);

        void b(OPopupNotice r1, e r2);
    }

    /* JADX INFO: compiled from: OPopupNotice.kt */
    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f36770a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f36771b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f36772c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ e[] f36773d = null;

        private static final /* synthetic */ e[] a() {
            return new e[]{f36770a, f36771b, f36772c};
        }

        public static e valueOf(String r2) {
            return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
        }

        public static e[] values() {
            return (e[]) ZeusTransformUtils.preCheckCast(f36773d.clone(), e[].class, "com.obric.aiagent.plugin");
        }

        private e(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f36770a = new e("HIDE_AUTO", 0);
            f36771b = new e("HIDE_MANUAL", 1);
            f36772c = new e("HIDE_CONFLICT", 2);
            f36773d = a();
        }
    }

    public static final /* synthetic */ View a(OPopupNotice r0) {
        return r0.f36766d;
    }

    public static final /* synthetic */ int b() {
        return g;
    }

    static {
        f36763a = new c(null);
        g = 12;
        h = 24;
    }

    public final void a(e r6) {
        o.e(r6, "reason");
        if (a() == true) goto L5;
        return;
    L5:
        this.f36767e = true;
        b r0 = this.f36764b.a();
        if (r0 == null) goto L9;
        r0.a(this);
    L9:
        d r1 = this.f36764b.b();
        if (r1 == null) goto L30;
        r1.a(this, r6);
    L30:
        this.f36765c.dismiss();     // Catch: Exception -> L15
    L17:
        Timer r2 = this.f;
        if (r2 == null) goto L21;
        r2.cancel();
    L21:
        b r3 = this.f36764b.a();
        if (r3 == null) goto L25;
        r3.b(this);
    L25:
        d r4 = this.f36764b.b();
        if (r4 == null) goto L32;
        r4.b(this, r6);
        return;
    L32:
        return;
    L15:
        e = move-exception;
        com.obric.oui.common.util.e.f34568a.a(TAG, o.a("hide: ", e.getMessage()), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L17
    }

    public final boolean a() {
        return this.f36765c.isShowing();
    }
}

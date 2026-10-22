package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppCompatBackgroundHelper.java */
/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private x f404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private x f405e;
    private x f;

    a(View r2) {
        this.f403c = -1;
        this.f401a = r2;
        this.f402b = d.b();
    }

    void a(AttributeSet r14, int r15) {
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r14, AttributeSet.class, "com.obric.aiagent.plugin");
        y r16 = y.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f401a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r9, R.styleable.ViewBackgroundHelper, r15, 0);
        View r6 = this.f401a;
        ViewCompat.a(r6, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), R.styleable.ViewBackgroundHelper, r9, r16.a(), r15, 0);
    L16:
        th = move-exception;
        r16.b();
        throw th;
    L4:
        if (r16.g(ZeusTransformUtils.mapRes(R.styleable.ViewBackgroundHelper_android_background, "styleable", "ViewBackgroundHelper_android_background")) == false) goto L9;
        this.f403c = r16.g(ZeusTransformUtils.mapRes(R.styleable.ViewBackgroundHelper_android_background, "styleable", "ViewBackgroundHelper_android_background"), -1);     // Catch: Throwable -> L16
        ColorStateList r17 = this.f402b.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f401a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f403c);     // Catch: Throwable -> L16
        if (r17 == null) goto L9;
        b(r17);     // Catch: Throwable -> L16
    L9:
        if (r16.g(ZeusTransformUtils.mapRes(R.styleable.ViewBackgroundHelper_backgroundTint, "styleable", "ViewBackgroundHelper_backgroundTint")) == false) goto L12;
        ViewCompat.a(this.f401a, r16.e(ZeusTransformUtils.mapRes(R.styleable.ViewBackgroundHelper_backgroundTint, "styleable", "ViewBackgroundHelper_backgroundTint")));     // Catch: Throwable -> L16
    L12:
        if (r16.g(ZeusTransformUtils.mapRes(R.styleable.ViewBackgroundHelper_backgroundTintMode, "styleable", "ViewBackgroundHelper_backgroundTintMode")) == false) goto L14;
        ViewCompat.a(this.f401a, q.a(r16.a(ZeusTransformUtils.mapRes(R.styleable.ViewBackgroundHelper_backgroundTintMode, "styleable", "ViewBackgroundHelper_backgroundTintMode"), -1), null));     // Catch: Throwable -> L16
    L14:
        r16.b();
    }

    void a(int r5) {
        this.f403c = r5;
        d r0 = this.f402b;
        if (r0 == null) goto L5;
        ColorStateList r6 = r0.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f401a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);
    L6:
        b(r6);
        c();
        return;
    L5:
        r6 = null;
        goto L6
    }

    void a(Drawable r1) {
        this.f403c = -1;
        b(null);
        c();
    }

    void a(ColorStateList r2) {
        if (this.f405e != null) goto L5;
        this.f405e = new x();
    L5:
        this.f405e.f493a = r2;
        this.f405e.f496d = true;
        c();
    }

    ColorStateList a() {
        x r0 = this.f405e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f493a;
    }

    void a(PorterDuff.Mode r2) {
        if (this.f405e != null) goto L5;
        this.f405e = new x();
    L5:
        this.f405e.f494b = r2;
        this.f405e.f495c = true;
        c();
    }

    PorterDuff.Mode b() {
        x r0 = this.f405e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f494b;
    }

    void c() {
        Drawable r0 = this.f401a.getBackground();
        if (r0 != null) goto L5;
        return;
    L5:
        if (d() == true) goto L7;
    L9:
        x r1 = this.f405e;
        if (r1 == null) goto L12;
        d.a(r0, r1, this.f401a.getDrawableState());
        return;
    L12:
        x r2 = this.f404d;
        if (r2 == null) goto L18;
        d.a(r0, r2, this.f401a.getDrawableState());
        return;
    L18:
        return;
    L7:
        if (b(r0) == false) goto L9;
    }

    void b(ColorStateList r2) {
        if (r2 != null) goto L4;
        this.f404d = null;
    L8:
        c();
        return;
    L4:
        if (this.f404d != null) goto L6;
        this.f404d = new x();
    L6:
        this.f404d.f493a = r2;
        this.f404d.f496d = true;
        goto L8
    }

    private boolean d() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 > 21) goto L5;
        if (r0 != 21) goto L11;
        return true;
    L11:
        return false;
    L5:
        if (this.f404d == null) goto L8;
        return true;
    L8:
        return false;
    }

    private boolean b(Drawable r4) {
        if (this.f != null) goto L5;
        this.f = new x();
    L5:
        x r0 = this.f;
        r0.a();
        ColorStateList r1 = ViewCompat.B(this.f401a);
        if (r1 == null) goto L8;
        r0.f496d = true;
        r0.f493a = r1;
    L8:
        PorterDuff.Mode r2 = ViewCompat.C(this.f401a);
        if (r2 == null) goto L12;
        r0.f495c = true;
        r0.f494b = r2;
    L12:
        if (r0.f496d == false) goto L14;
    L18:
        d.a(r4, r0, this.f401a.getDrawableState());
        return true;
    L14:
        if (r0.f495c == true) goto L18;
        return false;
    }
}

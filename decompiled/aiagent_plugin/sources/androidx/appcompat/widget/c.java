package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.core.view.ViewCompat;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppCompatCompoundButtonHelper.java */
/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CompoundButton f418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorStateList f419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f422e;
    private boolean f;

    c(CompoundButton r2) {
        this.f419b = null;
        this.f420c = null;
        this.f421d = false;
        this.f422e = false;
        this.f418a = r2;
    }

    void a(AttributeSet r17, int r18) {
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r17, AttributeSet.class, "com.obric.aiagent.plugin");
        y r6 = y.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f418a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r11, R.styleable.CompoundButton, r18, 0);
        CompoundButton r8 = this.f418a;
        ViewCompat.a(r8, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), R.styleable.CompoundButton, r11, r6.a(), r18, 0);
    L24:
        th = move-exception;
        r6.b();
        throw th;
    L4:
        if (r6.g(ZeusTransformUtils.mapRes(R.styleable.CompoundButton_buttonCompat, "styleable", "CompoundButton_buttonCompat")) == false) goto L9;
        int r4 = r6.g(ZeusTransformUtils.mapRes(R.styleable.CompoundButton_buttonCompat, "styleable", "CompoundButton_buttonCompat"), 0);     // Catch: Throwable -> L24
        if (r4 == 0) goto L9;
        CompoundButton r9 = this.f418a;     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        r9.setButtonDrawable(androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        boolean r5 = true;
    L10:
        if (r5 == true) goto L17;
        if (r6.g(ZeusTransformUtils.mapRes(R.styleable.CompoundButton_android_button, "styleable", "CompoundButton_android_button")) == false) goto L17;
        int r2 = r6.g(ZeusTransformUtils.mapRes(R.styleable.CompoundButton_android_button, "styleable", "CompoundButton_android_button"), 0);     // Catch: Throwable -> L24
        if (r2 == 0) goto L17;
        CompoundButton r7 = this.f418a;     // Catch: Throwable -> L24
        r7.setButtonDrawable(androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r2));     // Catch: Throwable -> L24
    L17:
        if (r6.g(ZeusTransformUtils.mapRes(R.styleable.CompoundButton_buttonTint, "styleable", "CompoundButton_buttonTint")) == false) goto L20;
        androidx.core.widget.b.a(this.f418a, r6.e(ZeusTransformUtils.mapRes(R.styleable.CompoundButton_buttonTint, "styleable", "CompoundButton_buttonTint")));     // Catch: Throwable -> L24
    L20:
        if (r6.g(ZeusTransformUtils.mapRes(R.styleable.CompoundButton_buttonTintMode, "styleable", "CompoundButton_buttonTintMode")) == false) goto L22;
        androidx.core.widget.b.a(this.f418a, q.a(r6.a(ZeusTransformUtils.mapRes(R.styleable.CompoundButton_buttonTintMode, "styleable", "CompoundButton_buttonTintMode"), -1), null));     // Catch: Throwable -> L24
    L22:
        r6.b();
        return;
    L9:
        r5 = false;
        goto L10
    }

    void a(ColorStateList r1) {
        this.f419b = r1;
        this.f421d = true;
        d();
    }

    ColorStateList a() {
        return this.f419b;
    }

    void a(PorterDuff.Mode r1) {
        this.f420c = r1;
        this.f422e = true;
        d();
    }

    PorterDuff.Mode b() {
        return this.f420c;
    }

    void c() {
        if (this.f == false) goto L6;
        this.f = false;
        return;
    L6:
        this.f = true;
        d();
    }

    void d() {
        Drawable r0 = androidx.core.widget.b.b(this.f418a);
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.f421d == false) goto L7;
    L8:
        Drawable r1 = androidx.core.graphics.drawable.a.g(r0).mutate();
        if (this.f421d == false) goto L12;
        androidx.core.graphics.drawable.a.a(r1, this.f419b);
    L12:
        if (this.f422e == false) goto L15;
        androidx.core.graphics.drawable.a.a(r1, this.f420c);
    L15:
        if (r1.isStateful() == false) goto L17;
        r1.setState(this.f418a.getDrawableState());
    L17:
        this.f418a.setButtonDrawable(r1);
        return;
    L7:
        if (this.f422e == true) goto L8;
    }

    int a(int r3) {
        if (Build.VERSION.SDK_INT >= 17) goto L8;
        Drawable r2 = androidx.core.widget.b.b(this.f418a);
        if (r2 != null) goto L7;
        return r3;
    L7:
        return r3 + r2.getIntrinsicWidth();
    L8:
        return r3;
    }
}

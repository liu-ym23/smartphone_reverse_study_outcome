package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.core.view.ViewCompat;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppCompatCheckedTextViewHelper.java */
/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CheckedTextView f413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorStateList f414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f417e;
    private boolean f;

    b(CheckedTextView r2) {
        this.f414b = null;
        this.f415c = null;
        this.f416d = false;
        this.f417e = false;
        this.f413a = r2;
    }

    void a(AttributeSet r17, int r18) {
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r17, AttributeSet.class, "com.obric.aiagent.plugin");
        y r6 = y.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f413a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r11, R.styleable.CheckedTextView, r18, 0);
        CheckedTextView r8 = this.f413a;
        ViewCompat.a(r8, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), R.styleable.CheckedTextView, r11, r6.a(), r18, 0);
    L24:
        th = move-exception;
        r6.b();
        throw th;
    L4:
        if (r6.g(ZeusTransformUtils.mapRes(R.styleable.CheckedTextView_checkMarkCompat, "styleable", "CheckedTextView_checkMarkCompat")) == false) goto L9;
        int r4 = r6.g(ZeusTransformUtils.mapRes(R.styleable.CheckedTextView_checkMarkCompat, "styleable", "CheckedTextView_checkMarkCompat"), 0);     // Catch: Throwable -> L24
        if (r4 == 0) goto L9;
        CheckedTextView r9 = this.f413a;     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        r9.setCheckMarkDrawable(androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        boolean r5 = true;
    L10:
        if (r5 == true) goto L17;
        if (r6.g(ZeusTransformUtils.mapRes(R.styleable.CheckedTextView_android_checkMark, "styleable", "CheckedTextView_android_checkMark")) == false) goto L17;
        int r2 = r6.g(ZeusTransformUtils.mapRes(R.styleable.CheckedTextView_android_checkMark, "styleable", "CheckedTextView_android_checkMark"), 0);     // Catch: Throwable -> L24
        if (r2 == 0) goto L17;
        CheckedTextView r7 = this.f413a;     // Catch: Throwable -> L24
        r7.setCheckMarkDrawable(androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r2));     // Catch: Throwable -> L24
    L17:
        if (r6.g(ZeusTransformUtils.mapRes(R.styleable.CheckedTextView_checkMarkTint, "styleable", "CheckedTextView_checkMarkTint")) == false) goto L20;
        androidx.core.widget.a.a(this.f413a, r6.e(ZeusTransformUtils.mapRes(R.styleable.CheckedTextView_checkMarkTint, "styleable", "CheckedTextView_checkMarkTint")));     // Catch: Throwable -> L24
    L20:
        if (r6.g(ZeusTransformUtils.mapRes(R.styleable.CheckedTextView_checkMarkTintMode, "styleable", "CheckedTextView_checkMarkTintMode")) == false) goto L22;
        androidx.core.widget.a.a(this.f413a, q.a(r6.a(ZeusTransformUtils.mapRes(R.styleable.CheckedTextView_checkMarkTintMode, "styleable", "CheckedTextView_checkMarkTintMode"), -1), null));     // Catch: Throwable -> L24
    L22:
        r6.b();
        return;
    L9:
        r5 = false;
        goto L10
    }

    void a(ColorStateList r1) {
        this.f414b = r1;
        this.f416d = true;
        d();
    }

    ColorStateList a() {
        return this.f414b;
    }

    void a(PorterDuff.Mode r1) {
        this.f415c = r1;
        this.f417e = true;
        d();
    }

    PorterDuff.Mode b() {
        return this.f415c;
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
        Drawable r0 = androidx.core.widget.a.a(this.f413a);
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.f416d == false) goto L7;
    L8:
        Drawable r1 = androidx.core.graphics.drawable.a.g(r0).mutate();
        if (this.f416d == false) goto L12;
        androidx.core.graphics.drawable.a.a(r1, this.f414b);
    L12:
        if (this.f417e == false) goto L15;
        androidx.core.graphics.drawable.a.a(r1, this.f415c);
    L15:
        if (r1.isStateful() == false) goto L17;
        r1.setState(this.f413a.getDrawableState());
    L17:
        this.f413a.setCheckMarkDrawable(r1);
        return;
    L7:
        if (this.f417e == true) goto L8;
    }
}

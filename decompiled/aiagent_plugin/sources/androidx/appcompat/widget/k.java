package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.core.view.ViewCompat;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppCompatSeekBarHelper.java */
/* JADX INFO: loaded from: classes.dex */
class k extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SeekBar f443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Drawable f444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ColorStateList f445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PorterDuff.Mode f446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f447e;
    private boolean f;

    k(SeekBar r2) {
        super(r2);
        this.f445c = null;
        this.f446d = null;
        this.f447e = false;
        this.f = false;
        this.f443a = r2;
    }

    @Override // androidx.appcompat.widget.i
    void a(AttributeSet r10, int r11) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        super.a(r5, r11);
        y r12 = y.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f443a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5, R.styleable.AppCompatSeekBar, r11, 0);
        SeekBar r2 = this.f443a;
        ViewCompat.a(r2, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), R.styleable.AppCompatSeekBar, r5, r12.a(), r11, 0);
        Drawable r13 = r12.b(ZeusTransformUtils.mapRes(R.styleable.AppCompatSeekBar_android_thumb, "styleable", "AppCompatSeekBar_android_thumb"));
        if (r13 == null) goto L5;
        this.f443a.setThumb(r13);
    L5:
        a(r12.a(ZeusTransformUtils.mapRes(R.styleable.AppCompatSeekBar_tickMark, "styleable", "AppCompatSeekBar_tickMark")));
        if (r12.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatSeekBar_tickMarkTintMode, "styleable", "AppCompatSeekBar_tickMarkTintMode")) == false) goto L9;
        this.f446d = q.a(r12.a(ZeusTransformUtils.mapRes(R.styleable.AppCompatSeekBar_tickMarkTintMode, "styleable", "AppCompatSeekBar_tickMarkTintMode"), -1), this.f446d);
        this.f = true;
    L9:
        if (r12.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatSeekBar_tickMarkTint, "styleable", "AppCompatSeekBar_tickMarkTint")) == false) goto L11;
        this.f445c = r12.e(ZeusTransformUtils.mapRes(R.styleable.AppCompatSeekBar_tickMarkTint, "styleable", "AppCompatSeekBar_tickMarkTint"));
        this.f447e = true;
    L11:
        r12.b();
        d();
    }

    void a(Drawable r3) {
        Drawable r0 = this.f444b;
        if (r0 == null) goto L5;
        r0.setCallback(null);
    L5:
        this.f444b = r3;
        if (r3 == null) goto L11;
        r3.setCallback(this.f443a);
        androidx.core.graphics.drawable.a.b(r3, ViewCompat.i(this.f443a));
        if (r3.isStateful() == false) goto L10;
        r3.setState(this.f443a.getDrawableState());
    L10:
        d();
    L11:
        this.f443a.invalidate();
    }

    private void d() {
        Drawable r0 = this.f444b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.f447e == false) goto L7;
    L8:
        Drawable r1 = androidx.core.graphics.drawable.a.g(r0.mutate());
        this.f444b = r1;
        if (this.f447e == false) goto L12;
        androidx.core.graphics.drawable.a.a(r1, this.f445c);
    L12:
        if (this.f == false) goto L15;
        androidx.core.graphics.drawable.a.a(this.f444b, this.f446d);
    L15:
        if (this.f444b.isStateful() == false) goto L20;
        this.f444b.setState(this.f443a.getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.f == true) goto L8;
    }

    void b() {
        Drawable r0 = this.f444b;
        if (r0 == null) goto L6;
        r0.jumpToCurrentState();
        return;
    }

    void c() {
        Drawable r0 = this.f444b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isStateful() == true) goto L7;
        return;
    L7:
        if (r0.setState(this.f443a.getDrawableState()) == false) goto L12;
        this.f443a.invalidateDrawable(r0);
        return;
    }

    void a(Canvas r7) {
        if (this.f444b == null) goto L18;
        int r0 = this.f443a.getMax();
        int r1 = 1;
        if (r0 <= 1) goto L19;
        int r2 = this.f444b.getIntrinsicWidth();
        int r3 = this.f444b.getIntrinsicHeight();
        if (r2 < 0) goto L9;
        int r4 = r2 / 2;
    L10:
        if (r3 < 0) goto L12;
        r1 = r3 / 2;
    L12:
        this.f444b.setBounds(-r4, -r1, r4, r1);
        float r5 = ((this.f443a.getWidth() - this.f443a.getPaddingLeft()) - this.f443a.getPaddingRight()) / r0;
        int r6 = r7.save();
        r7.translate(this.f443a.getPaddingLeft(), this.f443a.getHeight() / 2);
        int r8 = 0;
    L13:
        if (r8 > r0) goto L15;
        this.f444b.draw(r7);
        r7.translate(r5, 0.0f);
        r8 = r8 + 1;
        goto L13
    L15:
        r7.restoreToCount(r6);
        return;
    L9:
        r4 = 1;
        goto L10
    L19:
        return;
    }
}

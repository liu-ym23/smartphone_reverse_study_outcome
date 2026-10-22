package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppCompatImageHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageView f435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private x f436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private x f437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private x f438d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f439e;

    public h(ImageView r2) {
        this.f439e = 0;
        this.f435a = r2;
    }

    public void a(AttributeSet r12, int r13) {
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        y r14 = y.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f435a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7, R.styleable.AppCompatImageView, r13, 0);
        ImageView r4 = this.f435a;
        ViewCompat.a(r4, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), R.styleable.AppCompatImageView, r7, r14.a(), r13, 0);
        Drawable r15 = this.f435a.getDrawable();     // Catch: Throwable -> L21
        if (r15 != null) goto L11;
        int r5 = r14.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatImageView_srcCompat, "styleable", "AppCompatImageView_srcCompat"), -1);     // Catch: Throwable -> L21
        if (r5 == (-1)) goto L11;
        r15 = androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f435a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);     // Catch: Throwable -> L21
        if (r15 == null) goto L11;
        this.f435a.setImageDrawable(r15);     // Catch: Throwable -> L21
    L11:
        if (r15 == null) goto L14;
        q.b(r15);     // Catch: Throwable -> L21
    L14:
        if (r14.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatImageView_tint, "styleable", "AppCompatImageView_tint")) == false) goto L17;
        androidx.core.widget.d.a(this.f435a, r14.e(ZeusTransformUtils.mapRes(R.styleable.AppCompatImageView_tint, "styleable", "AppCompatImageView_tint")));     // Catch: Throwable -> L21
    L17:
        if (r14.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatImageView_tintMode, "styleable", "AppCompatImageView_tintMode")) == false) goto L19;
        androidx.core.widget.d.a(this.f435a, q.a(r14.a(ZeusTransformUtils.mapRes(R.styleable.AppCompatImageView_tintMode, "styleable", "AppCompatImageView_tintMode"), -1), null));     // Catch: Throwable -> L21
    L19:
        r14.b();
        return;
    L21:
        th = move-exception;
        r14.b();
        throw th;
    }

    public void a(int r4) {
        if (r4 == 0) goto L7;
        Drawable r5 = androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f435a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
        if (r5 == null) goto L6;
        q.b(r5);
    L6:
        this.f435a.setImageDrawable(r5);
    L8:
        d();
        return;
    L7:
        this.f435a.setImageDrawable(null);
        goto L8
    }

    boolean a() {
        Drawable r2 = this.f435a.getBackground();
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r2, RippleDrawable.class) == false) goto L10;
        return false;
    L10:
        return true;
    }

    void a(ColorStateList r2) {
        if (this.f437c != null) goto L5;
        this.f437c = new x();
    L5:
        this.f437c.f493a = r2;
        this.f437c.f496d = true;
        d();
    }

    ColorStateList b() {
        x r0 = this.f437c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f493a;
    }

    void a(PorterDuff.Mode r2) {
        if (this.f437c != null) goto L5;
        this.f437c = new x();
    L5:
        this.f437c.f494b = r2;
        this.f437c.f495c = true;
        d();
    }

    PorterDuff.Mode c() {
        x r0 = this.f437c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f494b;
    }

    void d() {
        Drawable r0 = this.f435a.getDrawable();
        if (r0 == null) goto L5;
        q.b(r0);
    L5:
        if (r0 != null) goto L7;
        return;
    L7:
        if (f() == true) goto L9;
    L11:
        x r1 = this.f437c;
        if (r1 == null) goto L14;
        d.a(r0, r1, this.f435a.getDrawableState());
        return;
    L14:
        x r2 = this.f436b;
        if (r2 == null) goto L20;
        d.a(r0, r2, this.f435a.getDrawableState());
        return;
    L20:
        return;
    L9:
        if (b(r0) == false) goto L11;
    }

    private boolean f() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 > 21) goto L5;
        if (r0 != 21) goto L11;
        return true;
    L11:
        return false;
    L5:
        if (this.f436b == null) goto L8;
        return true;
    L8:
        return false;
    }

    private boolean b(Drawable r4) {
        if (this.f438d != null) goto L5;
        this.f438d = new x();
    L5:
        x r0 = this.f438d;
        r0.a();
        ColorStateList r1 = androidx.core.widget.d.a(this.f435a);
        if (r1 == null) goto L8;
        r0.f496d = true;
        r0.f493a = r1;
    L8:
        PorterDuff.Mode r2 = androidx.core.widget.d.b(this.f435a);
        if (r2 == null) goto L12;
        r0.f495c = true;
        r0.f494b = r2;
    L12:
        if (r0.f496d == false) goto L14;
    L18:
        d.a(r4, r0, this.f435a.getDrawableState());
        return true;
    L14:
        if (r0.f495c == true) goto L18;
        return false;
    }

    void a(Drawable r1) {
        this.f439e = r1.getLevel();
    }

    void e() {
        if (this.f435a.getDrawable() == null) goto L6;
        this.f435a.getDrawable().setLevel(this.f439e);
        return;
    }
}

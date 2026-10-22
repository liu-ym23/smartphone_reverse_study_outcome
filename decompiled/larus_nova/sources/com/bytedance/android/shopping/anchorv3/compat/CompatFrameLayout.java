package com.bytedance.android.shopping.anchorv3.compat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/compat/CompatFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/anchorv3/compat/c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/shopping/anchorv3/compat/c;", "getTouchInterceptor", "()Lcom/bytedance/android/shopping/anchorv3/compat/c;", "setTouchInterceptor", "(Lcom/bytedance/android/shopping/anchorv3/compat/c;)V", "touchInterceptor", "", "c", "Z", "getForbiddenDrag", "()Z", "setForbiddenDrag", "(Z)V", "forbiddenDrag", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CompatFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f164760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f164761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f164762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f164763d;

    public CompatFrameLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CompatFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final boolean getForbiddenDrag() {
        return this.f164762c;
    }

    public final c getTouchInterceptor() {
        return this.f164760a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        c r101 = this.f164760a;
        if (r101 == null) goto L5;
        r101.a(this, r100);
        Integer r102 = 0;
    L7:
        if (r102 == null) goto L14;
        if (r102.intValue() != 2) goto L14;
        return super.dispatchTouchEvent(r100);
    L46:
        return false;
    L14:
        if (r102 == null) goto L20;
        if (r102.intValue() != 1) goto L20;
        return false;
    L20:
        if (r100.getAction() != 0) goto L27;
        this.f164763d = r100.getY();
        if (this.f164762c == true) goto L27;
        Function0<Unit> r103 = this.f164761b;
        if (r103 == null) goto L27;
        Unit r104 = r103.invoke();
    L27:
        if (r100.getAction() != 2) goto L34;
        float r105 = r100.getY() - this.f164763d;
        this.f164763d = r100.getY();
        if (r105 >= 0) goto L34;
        if (this.f164762c == false) goto L34;
        return false;
    L34:
        if (r100.getAction() != 3) goto L36;
    L37:
        this.f164763d = 0.0f;
    L42:
        return super.dispatchTouchEvent(r100);
    L47:
        return false;
    L36:
        if (r100.getAction() != 1) goto L42;
    L5:
        r102 = null;
        goto L7
    }

    public final void setForbiddenDrag(boolean r100) {
        this.f164762c = r100;
    }

    public final void setTouchInterceptor(c r100) {
        this.f164760a = r100;
    }

    public CompatFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ CompatFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

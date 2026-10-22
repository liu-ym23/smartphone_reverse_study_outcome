package com.bytedance.android.live.soloktv.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/soloktv/view/FakeViewRoot;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/live/soloktv/view/h;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/live/soloktv/view/h;", "getAllViewsDisplayCallback", "()Lcom/bytedance/android/live/soloktv/view/h;", "setAllViewsDisplayCallback", "(Lcom/bytedance/android/live/soloktv/view/h;)V", "allViewsDisplayCallback", "Landroid/app/Activity;", "c", "Landroid/app/Activity;", "getBindActivity", "()Landroid/app/Activity;", "setBindActivity", "(Landroid/app/Activity;)V", "bindActivity", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FakeViewRoot extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f101668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f101669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f101670c;

    public final h getAllViewsDisplayCallback() {
        return this.f101668a;
    }

    public final Activity getBindActivity() {
        return this.f101670c;
    }

    public FakeViewRoot(Context r100) {
        this(r100, null);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        if (this.f101669b == true) goto L24;
        Iterator<View> r101 = UtilityKotlinExtentionsKt.g(this).iterator();
        boolean r102 = true;
    L6:
        if (r101.hasNext() == false) goto L12;
        View r103 = r101.next();
        if (r103.getWidth() == 0) goto L11;
        if (r103.getHeight() != 0) goto L6;
    L11:
        r102 = false;
        goto L6
    L12:
        if (r102 == false) goto L25;
        h r104 = this.f101668a;
        if (r104 == null) goto L16;
        r104.a();
    L16:
        this.f101669b = true;
        return;
    L25:
        return;
    }

    public final void setAllViewsDisplayCallback(h r100) {
        this.f101668a = r100;
    }

    public final void setBindActivity(Activity r100) {
        this.f101670c = r100;
    }

    public FakeViewRoot(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}

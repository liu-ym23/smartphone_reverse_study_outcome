package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/core/widget/ECStatusView;", "Landroid/widget/FrameLayout;", "", "status", "", "setStatus", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStatusView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oj.b f46000a;

    public static final class a {
    }

    static {
    }

    public ECStatusView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECStatusView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void c() {
        setVisibility(0);
        oj.b r100 = this.f46000a;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public final void a() {
        setVisibility(8);
        oj.b r100 = this.f46000a;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    public final void setStatus(int r100) {
        oj.b r101 = this.f46000a;
        if (r101 == null) goto L6;
        r101.setECStatus(r100);
        return;
    }

    public ECStatusView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        oj.b r103 = com.bytedance.android.ec.sdk.helper.i.f48124a.d(r100);
        this.f46000a = r103;
        boolean r104 = r103 instanceof View;
        Object r105 = r103;
        if (r104 == true) goto L5;
        r105 = null;
    L5:
        View r106 = (View) r105;
        if (r106 == null) goto L8;
        addView(r106, new FrameLayout.LayoutParams(-1, -1));
        return;
    L8:
        setVisibility(8);
    }

    public final void b(Context r100, View r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        oj.b r103 = this.f46000a;
        if (r103 == null) goto L6;
        r103.c(r100, r101, r102);
        return;
    }

    public /* synthetic */ ECStatusView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

package com.bytedance.android.livesdk.visibilityproxy;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import eu2.a;
import eu2.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/visibilityproxy/FrameLayoutVisibilityProxy;", "Landroid/widget/FrameLayout;", "Leu2/a;", "", RemoteMessageConst.Notification.VISIBILITY, "", "setVisibility", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FrameLayoutVisibilityProxy extends FrameLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f159361a;

    public FrameLayoutVisibilityProxy(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FrameLayoutVisibilityProxy(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // eu2.a
    public final void T3(d80.c r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        c r101 = this.f159361a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        r101.f474057a.add(r100);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        if (this.f159361a.a(this, r100) == true) goto L6;
        super.setVisibility(r100);
        return;
    }

    public FrameLayoutVisibilityProxy(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f159361a = new c();
    }

    public /* synthetic */ FrameLayoutVisibilityProxy(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

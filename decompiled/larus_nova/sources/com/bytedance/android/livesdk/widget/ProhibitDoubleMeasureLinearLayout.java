package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.config.vo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/widget/ProhibitDoubleMeasureLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProhibitDoubleMeasureLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f161234a;

    @Override // android.view.View, android.view.ViewParent
    @Deprecated(message = "Deprecated in Java")
    public final void requestFitSystemWindows() {
        if (this.f161234a.booleanValue() == false) goto L5;
        return;
    L5:
        super.requestFitSystemWindows();
    }

    public ProhibitDoubleMeasureLinearLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f161234a = vo.f121466a.getValue();
    }
}

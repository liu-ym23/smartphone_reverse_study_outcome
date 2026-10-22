package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/HeaderNodeView;", "Landroid/widget/FrameLayout;", "Lyd3/f;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lyd3/f;", "getHeaderNode", "()Lyd3/f;", "setHeaderNode", "(Lyd3/f;)V", "headerNode", "Lrd3/a;", "b", "Lrd3/a;", "getAnchorInflowFeedItem", "()Lrd3/a;", "setAnchorInflowFeedItem", "(Lrd3/a;)V", "anchorInflowFeedItem", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class HeaderNodeView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yd3.f f175240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public rd3.a f175241b;

    public HeaderNodeView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HeaderNodeView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final rd3.a getAnchorInflowFeedItem() {
        return this.f175241b;
    }

    public final yd3.f getHeaderNode() {
        return this.f175240a;
    }

    public void a(rd3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorInflowFeedItem");
        yd3.p r101 = r100.i();
        if (r101 == null) goto L5;
        yd3.f r102 = r101.h();
    L6:
        this.f175240a = r102;
        this.f175241b = r100;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setAnchorInflowFeedItem(rd3.a r100) {
        this.f175241b = r100;
    }

    public final void setHeaderNode(yd3.f r100) {
        this.f175240a = r100;
    }

    public HeaderNodeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        float r103 = 12;
        Resources r104 = Resources.getSystem();
        int r105 = MathKt.roundToInt(TypedValue.applyDimension(1, r103, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics())));
        Resources r106 = Resources.getSystem();
        setPadding(r105, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r103, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()))), 0);
    }

    public /* synthetic */ HeaderNodeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

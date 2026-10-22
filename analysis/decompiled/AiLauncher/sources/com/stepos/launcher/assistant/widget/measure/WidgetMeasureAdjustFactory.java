package com.stepos.launcher.assistant.widget.measure;

import Y8.h;
import android.appwidget.AppWidgetHostView;
import android.view.View;
import com.stepos.launcher.assistant.widget.measure.WidgetMeasureAdjustFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p7.AppUI;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/launcher/assistant/widget/measure/WidgetMeasureAdjustFactory;", "", "<init>", "()V", "addBaiduWidgetMeasureAdjust", "()Lcom/stepos/launcher/assistant/widget/measure/WidgetMeasureAdjustFactory;", "removeBaiduWidgetMeasureAdjust", "", "hideTitle", "withHideBaiduWidgetTitle", "(Z)Lcom/stepos/launcher/assistant/widget/measure/WidgetMeasureAdjustFactory;", "Landroid/appwidget/AppWidgetHostView;", AppUI.TYPE_WIDGET, "Landroid/view/View;", "child", "", "parentWidth", "parentHeight", "LY8/t;", "measureChild", "(Landroid/appwidget/AppWidgetHostView;Landroid/view/View;II)V", "Lcom/stepos/launcher/assistant/widget/measure/WidgetMeasureAdjustFlag;", "mFlag", "Lcom/stepos/launcher/assistant/widget/measure/WidgetMeasureAdjustFlag;", "Lcom/stepos/launcher/assistant/widget/measure/BaiDuWidgetMeasureAdjust;", "mBaiDuWidgetMeasureAdjust$delegate", "LY8/h;", "getMBaiDuWidgetMeasureAdjust", "()Lcom/stepos/launcher/assistant/widget/measure/BaiDuWidgetMeasureAdjust;", "mBaiDuWidgetMeasureAdjust", "", "Lcom/stepos/launcher/assistant/widget/measure/IWidgetMeasureAdjust;", "mWidgetMeasureList", "Ljava/util/List;", "launcherClient_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WidgetMeasureAdjustFactory {
    private WidgetMeasureAdjustFlag mFlag = WidgetMeasureAdjustFlag.DEFAULT_FLAG;

    /* renamed from: mBaiDuWidgetMeasureAdjust$delegate, reason: from kotlin metadata */
    private final h mBaiDuWidgetMeasureAdjust = C4848b.b(new InterfaceC5063a() { // from class: n7.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return WidgetMeasureAdjustFactory.mBaiDuWidgetMeasureAdjust_delegate$lambda$0();
        }
    });
    private final List<IWidgetMeasureAdjust> mWidgetMeasureList = new ArrayList();

    private final BaiDuWidgetMeasureAdjust getMBaiDuWidgetMeasureAdjust() {
        return (BaiDuWidgetMeasureAdjust) this.mBaiDuWidgetMeasureAdjust.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaiDuWidgetMeasureAdjust mBaiDuWidgetMeasureAdjust_delegate$lambda$0() {
        return new BaiDuWidgetMeasureAdjust();
    }

    public static /* synthetic */ WidgetMeasureAdjustFactory withHideBaiduWidgetTitle$default(WidgetMeasureAdjustFactory widgetMeasureAdjustFactory, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return widgetMeasureAdjustFactory.withHideBaiduWidgetTitle(z10);
    }

    public final WidgetMeasureAdjustFactory addBaiduWidgetMeasureAdjust() {
        if (!this.mWidgetMeasureList.contains(getMBaiDuWidgetMeasureAdjust())) {
            this.mWidgetMeasureList.add(getMBaiDuWidgetMeasureAdjust());
        }
        return this;
    }

    public final void measureChild(AppWidgetHostView widget, View child, int parentWidth, int parentHeight) {
        p.i(widget, "widget");
        WidgetMeasureAdjustFlag widgetMeasureAdjustFlag = this.mFlag;
        Iterator<IWidgetMeasureAdjust> it = this.mWidgetMeasureList.iterator();
        while (it.hasNext()) {
            it.next().onMeasureChild(widgetMeasureAdjustFlag, widget, child, parentWidth, parentHeight);
        }
    }

    public final WidgetMeasureAdjustFactory removeBaiduWidgetMeasureAdjust() {
        if (this.mWidgetMeasureList.contains(getMBaiDuWidgetMeasureAdjust())) {
            this.mWidgetMeasureList.remove(getMBaiDuWidgetMeasureAdjust());
        }
        return this;
    }

    public final WidgetMeasureAdjustFactory withHideBaiduWidgetTitle(boolean hideTitle) {
        this.mFlag = this.mFlag.withHideBaiduWidgetTitle(hideTitle);
        return this;
    }
}

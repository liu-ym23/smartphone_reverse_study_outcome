package com.stepos.launcher.assistant.widget.measure;

import android.appwidget.AppWidgetHostView;
import android.view.View;
import kotlin.Metadata;
import p7.b;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/stepos/launcher/assistant/widget/measure/IWidgetMeasureAdjust;", "", "onMeasureChild", "", "flag", "Lcom/stepos/launcher/assistant/widget/measure/WidgetMeasureAdjustFlag;", b.TYPE_WIDGET, "Landroid/appwidget/AppWidgetHostView;", "child", "Landroid/view/View;", "parentWidth", "", "parentHeight", "launcherClient_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public interface IWidgetMeasureAdjust {
    boolean onMeasureChild(WidgetMeasureAdjustFlag flag, AppWidgetHostView widget, View child, int parentWidth, int parentHeight);
}

package com.stepos.launcher.assistant.widget.measure;

import Z8.C1173v;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p7.b;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u0010"}, d2 = {"Lcom/stepos/launcher/assistant/widget/measure/BaiDuWidgetMeasureAdjust;", "Lcom/stepos/launcher/assistant/widget/measure/IWidgetMeasureAdjust;", "<init>", "()V", "onMeasureChild", "", "flag", "Lcom/stepos/launcher/assistant/widget/measure/WidgetMeasureAdjustFlag;", b.TYPE_WIDGET, "Landroid/appwidget/AppWidgetHostView;", "child", "Landroid/view/View;", "parentWidth", "", "parentHeight", "Companion", "launcherClient_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BaiDuWidgetMeasureAdjust implements IWidgetMeasureAdjust {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PKG_BAIDU = "com.baidu.searchbox";
    private static final List<ComponentName> BAIDU_WIDGET_COMPONENT_NAMES = C1173v.p(new ComponentName(PKG_BAIDU, "com.baidu.searchbox.openwidget.preset.PresetOpenWidgetProvider4x2Learning"), new ComponentName(PKG_BAIDU, "com.baidu.searchbox.openwidget.preset.PresetOpenWidgetProvider4x2Novel"), new ComponentName(PKG_BAIDU, "com.baidu.searchbox.openwidget.OpenWidgetProvider2x2"), new ComponentName(PKG_BAIDU, "com.baidu.searchbox.openwidget.OpenWidgetProvider4x2"), new ComponentName(PKG_BAIDU, "com.baidu.searchbox.openwidget.preset.PresetOpenWidgetProvider2x2Weather"), new ComponentName(PKG_BAIDU, "com.baidu.searchbox.openwidget.preset.PresetOpenWidgetProvider4x2Weather"), new ComponentName(PKG_BAIDU, "com.baidu.searchbox.openwidget.preset.PresetOpenWidgetProvider4x2Govern"), new ComponentName(PKG_BAIDU, "com.baidu.searchbox.openwidget.preset.PresetOpenWidgetProvider4x2Lottery"), new ComponentName(PKG_BAIDU, "com.baidu.searchbox.openwidget.preset.PresetOpenWidgetProvider4x2Sport"), new ComponentName(PKG_BAIDU, "com.baidu.searchbox.openwidget.preset.PresetOpenWidgetProvider4x2Epidemic"), new ComponentName(PKG_BAIDU, "com.baidu.searchbox.widget.ConstelWidgetProvider"), new ComponentName(PKG_BAIDU, "com.baidu.searchbox.openwidget.preset.PresetOpenWidgetProvider4x2Feed"));
    private static final String PKG_BAIDU_LITE = "com.baidu.searchbox.lite";
    private static final List<ComponentName> BAIDU_LITE_WIDGET_COMPONENT_NAMES = C1173v.p(new ComponentName(PKG_BAIDU_LITE, "com.baidu.searchbox.openwidget.preset.PresetOpenWidgetProvider4x2Novel"), new ComponentName(PKG_BAIDU_LITE, "com.baidu.searchbox.openwidget.OpenWidgetProvider2x2"), new ComponentName(PKG_BAIDU_LITE, "com.baidu.searchbox.openwidget.OpenWidgetProvider4x2"), new ComponentName(PKG_BAIDU_LITE, "com.baidu.searchbox.openwidget.preset.PresetOpenWidgetProvider4x2Weather"), new ComponentName(PKG_BAIDU_LITE, "com.baidu.searchbox.openwidget.preset.LitePresetOpenWidgetProvider2x2GameCenter"), new ComponentName(PKG_BAIDU_LITE, "com.baidu.searchbox.openwidget.preset.LitePresetOpenWidgetProvider4x2ShortPlay"), new ComponentName(PKG_BAIDU_LITE, "com.baidu.searchbox.openwidget.preset.PresetOpenWidgetProvider4x2Lottery"), new ComponentName(PKG_BAIDU_LITE, "com.baidu.searchbox.openwidget.preset.LitePresetOpenWidgetProvider4x2WebVideo"));

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/launcher/assistant/widget/measure/BaiDuWidgetMeasureAdjust$Companion;", "", "<init>", "()V", "PKG_BAIDU", "", "BAIDU_WIDGET_COMPONENT_NAMES", "", "Landroid/content/ComponentName;", "PKG_BAIDU_LITE", "BAIDU_LITE_WIDGET_COMPONENT_NAMES", "supportAdjust", "", "info", "Landroid/appwidget/AppWidgetProviderInfo;", "launcherClient_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean supportAdjust(AppWidgetProviderInfo info) {
            ComponentName componentName = info != null ? info.provider : null;
            if (componentName != null) {
                return BaiDuWidgetMeasureAdjust.BAIDU_WIDGET_COMPONENT_NAMES.contains(componentName) || BaiDuWidgetMeasureAdjust.BAIDU_LITE_WIDGET_COMPONENT_NAMES.contains(componentName);
            }
            return false;
        }

        private Companion() {
        }
    }

    private static final boolean supportAdjust(AppWidgetProviderInfo appWidgetProviderInfo) {
        return INSTANCE.supportAdjust(appWidgetProviderInfo);
    }

    @Override // com.stepos.launcher.assistant.widget.measure.IWidgetMeasureAdjust
    public boolean onMeasureChild(WidgetMeasureAdjustFlag flag, AppWidgetHostView widget, View child, int parentWidth, int parentHeight) {
        View view;
        View view2;
        p.i(flag, "flag");
        p.i(widget, "widget");
        if (!INSTANCE.supportAdjust(widget.getAppWidgetInfo())) {
            return false;
        }
        if (child instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) child;
            if (linearLayout.getChildCount() == 2) {
                View childAt = linearLayout.getChildAt(0);
                view = childAt instanceof RelativeLayout ? (RelativeLayout) childAt : null;
                View childAt2 = linearLayout.getChildAt(1);
                view = linearLayout;
                view2 = childAt2 instanceof TextView ? (TextView) childAt2 : null;
                if (view != null || view == null || view2 == null) {
                    return false;
                }
                if (flag.useHideBaiduWidgetTitle()) {
                    if (view2.getVisibility() == 0) {
                        view2.setVisibility(8);
                        view.measure(View.MeasureSpec.makeMeasureSpec(parentWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(parentHeight, 1073741824));
                    }
                } else if (view2.getVisibility() != 0) {
                    view2.setVisibility(0);
                    view.measure(View.MeasureSpec.makeMeasureSpec(parentWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(Math.min(view.getMeasuredHeight(), parentHeight), 1073741824));
                }
                return true;
            }
            view = null;
            view = linearLayout;
        } else {
            view = null;
        }
        view2 = view;
        if (view != null) {
        }
        return false;
    }
}

package com.android.ttcjpaysdk.base.utils.html.utils;

import android.content.Context;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.theme.CJPayThemeManager;
import com.android.ttcjpaysdk.base.ui.data.UIComponent;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.html.callback.UniversalClickCallback;
import com.android.ttcjpaysdk.base.utils.html.span.ClickableImageSpan;
import com.android.ttcjpaysdk.base.utils.html.span.SpacerSpan;
import com.android.ttcjpaysdk.base.utils.html.span.UniversalClickableSpan;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002J@\u0010\u0013\u001a\u00020\n2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00152\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0003J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J<\u0010\u001d\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002J\"\u0010\u001e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J<\u0010\u001f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/html/utils/UIComponentSpannableParser;", "", "()V", "TAG", "", "applyTextStyles", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "spannable", "Landroid/text/SpannableStringBuilder;", "component", "Lcom/android/ttcjpaysdk/base/ui/data/UIComponent;", "startIndex", "", "endIndex", "textViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/widget/TextView;", "convertComponentsToSpannable", "components", "", "universalClickCallback", "Lcom/android/ttcjpaysdk/base/utils/html/callback/UniversalClickCallback;", "formatCountdownTime", "msText", "isDegradeOldDarkMode", "", "processCountdownComponent", "processIconComponent", "processSpacerComponent", "processTextComponent", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIComponentSpannableParser {
    public static final UIComponentSpannableParser INSTANCE = null;
    private static final String TAG = "UIComponentSpannableParser";

    static {
        INSTANCE = new UIComponentSpannableParser();
    }

    private UIComponentSpannableParser() {
    }

    public final boolean isDegradeOldDarkMode() {
        return CJPaySettingsManager.getInstance().getBooleanConfig("cjpay_degrade_settings", "ui_component_degrade_old_dark_mode", false);
    }

    private final String formatCountdownTime(String r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L10:
        if (r100 == false) goto L17;
        return "00:00:00";
    L17:
        long r101 = CastLongProtector.parseLong(r110);     // Catch: Exception -> L14
        long r102 = 60000;
        int r111 = (int) (r101 / r102);     // Catch: Exception -> L14
        long r103 = 1000;
        int r104 = (int) ((r101 % r102) / r103);     // Catch: Exception -> L14
        int r105 = (int) ((r101 % r103) / ((long) 10));     // Catch: Exception -> L14
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L14
        return String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r111), Integer.valueOf(r104), Integer.valueOf(r105)}, 3));
    L14:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayUIUtils#formatCountdownTime", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayUIUtils#formatCountdownTime", e);
        return "00:00:00";
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L10
    }

    private final void processCountdownComponent(SpannableStringBuilder r100, UIComponent r101) {
        String r102 = r101.text;
        if (r102 != null) goto L5;
        return;
    L5:
        String r103 = formatCountdownTime(r102);
        int r104 = r100.length();
        r100.append(r103);
        int r105 = r100.length();
        String r106 = r101.color;
        boolean r107 = false;
        if (r106 != null) goto L8;
    L13:
        if (r107 == false) goto L15;
        ColorParse r108 = ColorParse.INSTANCE;
        String r109 = r101.color;
        Intrinsics.checkNotNull(r109);
        int r110 = r108.parseColor(r109);
    L16:
        r100.setSpan(new ForegroundColorSpan(r110), r104, r105, 17);
        return;
    L15:
        r110 = ColorParse.INSTANCE.parseColor("#fe2c55");
        goto L16
    L8:
        if (r106.length() <= 0) goto L10;
        boolean r111 = true;
    L11:
        if (r111 != true) goto L13;
        r107 = true;
        goto L13
    L10:
        r111 = false;
        goto L11
    }

    private final void processSpacerComponent(SpannableStringBuilder r100, UIComponent r101, Context r102) {
        if (r102 != null) goto L6;
        CJLogger.e(TAG, "processSpacerComponent: context为空，跳过间距处理");
        return;
    L6:
        int r103 = r100.length();
        r100.append("\u200b");
        int r104 = r100.length();
        int r105 = r101.width;
        if (r105 > 0) goto L10;
        r105 = 2;
    L10:
        r100.setSpan(new SpacerSpan(r105), r103, r104, 33);
        CJLogger.a(TAG, "添加间距组件成功，宽度: " + r105 + "dp");
    }

    public final SpannableStringBuilder convertComponentsToSpannable(List<UIComponent> r100, Context r101, UniversalClickCallback r110, WeakReference<TextView> r111) {
        List<UIComponent> r102 = r100;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        SpannableStringBuilder r104 = new SpannableStringBuilder();
        Iterator<T> r105 = r100.iterator();
    L14:
        if (r105.hasNext() == false) goto L34;
        UIComponent r106 = (UIComponent) r105.next();
        String r107 = r106.type.toLowerCase(Locale.ROOT);
        switch(r107.hashCode()) {
            case -896192468: goto L30;
            case 3226745: goto L26;
            case 3556653: goto L23;
            case 1352226353: goto L19;
            default: goto L33;
        };
    L23:
        if (r107.equals("text") == false) goto L33;
        INSTANCE.processTextComponent(r101, r104, r106, r110, r111);
        goto L14
    L26:
        if (r107.equals("icon") == false) goto L33;
        INSTANCE.processIconComponent(r104, r106, r101, r110, r111);
        goto L14
    L30:
        if (r107.equals("spacer") == false) goto L33;
        INSTANCE.processSpacerComponent(r104, r106, r101);
    L33:
        INSTANCE.processTextComponent(r101, r104, r106, r110, r111);
        goto L14
    L19:
        if (r107.equals("countdown") == false) goto L33;
        INSTANCE.processCountdownComponent(r104, r106);
        goto L14
    L34:
        return r104;
    L11:
        return new SpannableStringBuilder();
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    private final void processIconComponent(SpannableStringBuilder r110, UIComponent r111, Context r112, UniversalClickCallback r113, WeakReference<TextView> r114) {
        if (r112 == null) goto L42;
        String r100 = r111.url;
        boolean r101 = false;
        if (r100 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L42;
        int r103 = r110.length();
        r110.append("\u200b");
        int r115 = r110.length();
        int r104 = r111.width;
        if (r104 <= 0) goto L18;
        int r105 = r111.height;
        if (r105 <= 0) goto L18;
        int r106 = Math.max(r104, r105);
    L24:
        String r107 = r111.url;
        Intrinsics.checkNotNull(r107);
        String r108 = r111.f29369id;
        if (r108.length() <= 0) goto L27;
        r101 = true;
    L27:
        Unit r116 = null;
        if (r101 == true) goto L31;
        r108 = null;
    L31:
        final ClickableImageSpan r117 = new ClickableImageSpan(r112, r107, r108, String.valueOf(r106), r113);
        if (r114 == null) goto L36;
        TextView r109 = r114.get();
        if (r109 == null) goto L36;
        r117.setTextView(r109);
        CJLogger.a(TAG, "成功设置TextView引用到ImageSpan，图片URL: " + r111.url);
        r116 = Unit.INSTANCE;
    L36:
        if (r116 != null) goto L38;
        CJLogger.e(TAG, "textViewRef为null或TextView已被回收，图片可能无法正确重绘，图片URL: " + r111.url);
    L38:
        r110.setSpan(r117, r103, r115, 33);
        if (r113 == null) goto L44;
        r110.setSpan(new UIComponentSpannableParser$processIconComponent$clickSpan$1(r117), r103, r115, 33);
        return;
    L44:
        return;
    L18:
        Integer r118 = r111.font_size;
        if (r118 == null) goto L23;
        Intrinsics.checkNotNull(r118);
        if (r118.intValue() <= 0) goto L23;
        Integer r119 = r111.font_size;
        Intrinsics.checkNotNull(r119);
        r106 = r119.intValue();
    L23:
        r106 = 18;
        goto L24
    L7:
        if (r100.length() == 0) goto L10;
        r102 = false;
    L42:
        CJLogger.e(TAG, "processIconComponent: context为空或url为空，跳过图标处理");
    }

    private final void processTextComponent(Context r110, SpannableStringBuilder r111, UIComponent r112, UniversalClickCallback r113, WeakReference<TextView> r114) {
        String r100 = r112.text;
        if (r100 != null) goto L5;
        return;
    L5:
        int r115 = r111.length();
        r111.append(r100);
        int r116 = r111.length();
        applyTextStyles(r110, r111, r112, r115, r116, r114);
        if (r112.f29369id.length() <= 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L13;
        if (r113 == null) goto L14;
        r111.setSpan(new UniversalClickableSpan(r112.f29369id, r100, UniversalClickCallback.ClickType.TXT, r113, false, null), r115, r116, 33);
        return;
    L14:
        return;
    L13:
        return;
    L8:
        r101 = false;
        goto L9
    }

    private final void applyTextStyles(Context r110, SpannableStringBuilder r111, UIComponent r112, int r113, int r210, WeakReference<TextView> r211) {
        if (r113 < r210) goto L65;
        return;
    L65:
        String r100 = r112.color;     // Catch: Exception -> L60
        boolean r114 = false;
        if (r100 == null) goto L41;
    L38:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("UIComponentSpannableParser#applyTextStyles", e);     // Catch: Exception -> L60
        CJLogger.c(TAG, "解析颜色失败: " + r100, e);     // Catch: Exception -> L60
        goto L41
    L10:
        if (INSTANCE.isDegradeOldDarkMode() == true) goto L12;
        boolean r101 = CJPayThemeManager.getInstance().uiComponentNeedDark;     // Catch: Exception -> L38
    L13:
        Pair[] r115 = new Pair[2];     // Catch: Exception -> L38
        if (r101 == false) goto L17;
        String r116 = CustomHeaderConfig.COLOR_LIGHT;
    L18:
        r115[0] = TuplesKt.to("#161823", r116);     // Catch: Exception -> L38
        if (r101 == false) goto L22;
        String r102 = "#BFFFFFFF";
    L23:
        r115[1] = TuplesKt.to("#BF161823", r102);     // Catch: Exception -> L38
        Map r103 = MapsKt.mapOf(r115);     // Catch: Exception -> L38
        Iterator r117 = r103.keySet().iterator();     // Catch: Exception -> L38
    L25:
        if (r117.hasNext() == false) goto L29;
        Object r118 = r117.next();     // Catch: Exception -> L38
        if (StringsKt.equals((String) r118, r100, true) == false) goto L25;
    L30:
        String r119 = (String) r118;     // Catch: Exception -> L38
        if (r119 == null) goto L35;
        String r104 = (String) r103.get(r119);     // Catch: Exception -> L38
        if (r104 == null) goto L35;
    L36:
        r111.setSpan(new ForegroundColorSpan(ColorParse.INSTANCE.parseColor(r104)), r113, r210, 33);     // Catch: Exception -> L38
    L35:
        r104 = r100;
        goto L36
    L29:
        r118 = null;
        goto L30
    L22:
        r102 = "#BF161823";
        goto L23
    L17:
        r116 = "#161823";
        goto L18
    L12:
        r101 = CJPayThemeManager.instance.isThemeDark(r110);     // Catch: Exception -> L38
    L41:
        if (r112.isBold() == false) goto L46;
        if (r211 == null) goto L46;
        TextView r105 = r211.get();     // Catch: Exception -> L60
        if (r105 == null) goto L46;
        TextPaint r106 = r105.getPaint();     // Catch: Exception -> L60
        r106.setStyle(Paint.Style.FILL_AND_STROKE);     // Catch: Exception -> L60
        r106.setStrokeWidth(0.5f);     // Catch: Exception -> L60
    L46:
        Integer r107 = r112.getValidFontSize();     // Catch: Exception -> L60
        if (r107 == null) goto L70;
        float r108 = r107.intValue();     // Catch: Exception -> L60
        if (r211 == null) goto L53;
        TextView r109 = r211.get();     // Catch: Exception -> L60
        if (r109 == null) goto L53;
        float r120 = CJPayBasicExtensionKt.px2dip(r109.getTextSize(), null);     // Catch: Exception -> L60
    L54:
        float r121 = r108 / r120;     // Catch: Exception -> L60
        if (r121 != 1.0f) goto L57;
        r114 = true;
    L57:
        if (r114 == true) goto L71;
        r111.setSpan(new RelativeSizeSpan(r121), r113, r210, 33);     // Catch: Exception -> L60
        return;
    L71:
        return;
    L53:
        r120 = 15.0f;
        goto L54
    L70:
        return;
    L60:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("UIComponentSpannableParser#applyTextStyles", e);
        CJLogger.c(TAG, "应用文本样式失败", e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpannableStringBuilder convertComponentsToSpannable$default(UIComponentSpannableParser r100, List r101, Context r102, UniversalClickCallback r103, WeakReference r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r104 = null;
    L12:
        return r100.convertComponentsToSpannable(r101, r102, r103, r104);
    }
}

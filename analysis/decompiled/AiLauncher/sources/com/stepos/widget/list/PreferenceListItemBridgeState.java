package com.stepos.widget.list;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.widget.R;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import n9.C4946a;

@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0003\b\u0083\u0001\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 ¢\u00012\u00020\u0001:\u0002¢\u0001B\u008f\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\f\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\f\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\f\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\f\u0012\u0006\u0010&\u001a\u00020\f\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\b\u0010*\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\f\u0012\u0006\u0010-\u001a\u00020\f\u0012\u0006\u0010.\u001a\u00020\f\u0012\u0006\u0010/\u001a\u00020\f\u0012\u0006\u00100\u001a\u00020\u0003\u0012\u0006\u00101\u001a\u00020\u0003\u0012\u0006\u00102\u001a\u00020\u0003\u0012\u0006\u00103\u001a\u00020\u0003\u0012\u0006\u00104\u001a\u00020\u0003¢\u0006\u0004\b5\u00106J\t\u0010l\u001a\u00020\u0003HÆ\u0003J\t\u0010m\u001a\u00020\u0003HÆ\u0003J\t\u0010n\u001a\u00020\u0003HÆ\u0003J\t\u0010o\u001a\u00020\u0003HÆ\u0003J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\t\u0010q\u001a\u00020\u0003HÆ\u0003J\t\u0010r\u001a\u00020\u0003HÆ\u0003J\t\u0010s\u001a\u00020\u0003HÆ\u0003J\t\u0010t\u001a\u00020\fHÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010y\u001a\u00020\fHÆ\u0003J\u0010\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010IJ\t\u0010{\u001a\u00020\u0003HÆ\u0003J\t\u0010|\u001a\u00020\fHÆ\u0003J\u0010\u0010}\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010IJ\t\u0010~\u001a\u00020\fHÆ\u0003J\t\u0010\u007f\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u001dHÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010IJ\n\u0010\u008f\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0003HÆ\u0003Jö\u0003\u0010\u009b\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\f2\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\f2\b\b\u0002\u0010&\u001a\u00020\f2\b\b\u0002\u0010'\u001a\u00020\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\f2\b\b\u0002\u0010-\u001a\u00020\f2\b\b\u0002\u0010.\u001a\u00020\f2\b\b\u0002\u0010/\u001a\u00020\f2\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u00032\b\b\u0002\u00103\u001a\u00020\u00032\b\b\u0002\u00104\u001a\u00020\u0003HÆ\u0001¢\u0006\u0003\u0010\u009c\u0001J\u0015\u0010\u009d\u0001\u001a\u00020\f2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u009f\u0001\u001a\u00020\u0003HÖ\u0001J\u000b\u0010 \u0001\u001a\u00030¡\u0001HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u00108R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u00108R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u00108R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u00108R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u00108R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u00108R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u00108R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010CR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010CR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010CR\u0011\u0010\u0012\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bG\u0010AR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010J\u001a\u0004\bH\u0010IR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u00108R\u0011\u0010\u0015\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bL\u0010AR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010J\u001a\u0004\bM\u0010IR\u0011\u0010\u0017\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bN\u0010AR\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u00108R\u0011\u0010\u0019\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bP\u0010AR\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u00108R\u0011\u0010\u001b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bR\u0010AR\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bU\u00108R\u0011\u0010\u001f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bV\u0010AR\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bW\u00108R\u0011\u0010!\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bX\u0010AR\u0011\u0010\"\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bY\u00108R\u0011\u0010#\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010AR\u0011\u0010$\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b[\u00108R\u0011\u0010%\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010AR\u0011\u0010&\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b]\u0010AR\u0011\u0010'\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b^\u00108R\u0015\u0010(\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010J\u001a\u0004\b_\u0010IR\u0011\u0010)\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b`\u00108R\u0013\u0010*\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\ba\u0010CR\u0011\u0010+\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bb\u00108R\u0011\u0010,\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bc\u0010AR\u0011\u0010-\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bd\u0010AR\u0011\u0010.\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\be\u0010AR\u0011\u0010/\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bf\u0010AR\u0011\u00100\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bg\u00108R\u0011\u00101\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bh\u00108R\u0011\u00102\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bi\u00108R\u0011\u00103\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bj\u00108R\u0011\u00104\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bk\u00108¨\u0006£\u0001"}, d2 = {"Lcom/stepos/widget/list/PreferenceListItemBridgeState;", "", "minHeight", "", "paddingHorizontal", "paddingVertical", "iconTextGap", "titleTextAppearance", "subtitleTextAppearance", "valueTextAppearance", "subtitleMaxLines", "adaptiveTextLayoutEnabled", "", "title", "", "titleEndText", "subtitle", "rightText", "iconBackgroundExplicit", "iconBackgroundColor", "iconDrawableRes", "iconTintExplicit", "iconTint", "iconVisible", "iconStyle", "iconSizeSet", "iconSize", "iconCornerRadiusSet", "iconCornerRadius", "", "badgeStyle", "badgeTintSet", "badgeTint", "showBadge", "rightBadgeStyle", "rightBadgeTintSet", "rightBadgeTint", "showRightBadge", "showAccessory", "accessoryIconRes", "accessorySize", "trailingType", "buttonText", "lineMode", "checked", "switchChecked", "pressScaleEnabled", "showDivider", "dividerHeight", "dividerInsetStart", "dividerInsetEnd", "dividerColor", "titleStyle", "<init>", "(IIIIIIIIZLjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLjava/lang/Integer;IZLjava/lang/Integer;ZIZIZFIZIZIZIZZILjava/lang/Integer;ILjava/lang/CharSequence;IZZZZIIIII)V", "getMinHeight", "()I", "getPaddingHorizontal", "getPaddingVertical", "getIconTextGap", "getTitleTextAppearance", "getSubtitleTextAppearance", "getValueTextAppearance", "getSubtitleMaxLines", "getAdaptiveTextLayoutEnabled", "()Z", "getTitle", "()Ljava/lang/CharSequence;", "getTitleEndText", "getSubtitle", "getRightText", "getIconBackgroundExplicit", "getIconBackgroundColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIconDrawableRes", "getIconTintExplicit", "getIconTint", "getIconVisible", "getIconStyle", "getIconSizeSet", "getIconSize", "getIconCornerRadiusSet", "getIconCornerRadius", "()F", "getBadgeStyle", "getBadgeTintSet", "getBadgeTint", "getShowBadge", "getRightBadgeStyle", "getRightBadgeTintSet", "getRightBadgeTint", "getShowRightBadge", "getShowAccessory", "getAccessoryIconRes", "getAccessorySize", "getTrailingType", "getButtonText", "getLineMode", "getChecked", "getSwitchChecked", "getPressScaleEnabled", "getShowDivider", "getDividerHeight", "getDividerInsetStart", "getDividerInsetEnd", "getDividerColor", "getTitleStyle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", ChatTracker.CLICK_COPY, "(IIIIIIIIZLjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLjava/lang/Integer;IZLjava/lang/Integer;ZIZIZFIZIZIZIZZILjava/lang/Integer;ILjava/lang/CharSequence;IZZZZIIIII)Lcom/stepos/widget/list/PreferenceListItemBridgeState;", "equals", "other", "hashCode", "toString", "", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PreferenceListItemBridgeState {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int accessoryIconRes;
    private final Integer accessorySize;
    private final boolean adaptiveTextLayoutEnabled;
    private final int badgeStyle;
    private final int badgeTint;
    private final boolean badgeTintSet;
    private final CharSequence buttonText;
    private final boolean checked;
    private final int dividerColor;
    private final int dividerHeight;
    private final int dividerInsetEnd;
    private final int dividerInsetStart;
    private final Integer iconBackgroundColor;
    private final boolean iconBackgroundExplicit;
    private final float iconCornerRadius;
    private final boolean iconCornerRadiusSet;
    private final int iconDrawableRes;
    private final int iconSize;
    private final boolean iconSizeSet;
    private final int iconStyle;
    private final int iconTextGap;
    private final Integer iconTint;
    private final boolean iconTintExplicit;
    private final boolean iconVisible;
    private final int lineMode;
    private final int minHeight;
    private final int paddingHorizontal;
    private final int paddingVertical;
    private final boolean pressScaleEnabled;
    private final int rightBadgeStyle;
    private final int rightBadgeTint;
    private final boolean rightBadgeTintSet;
    private final CharSequence rightText;
    private final boolean showAccessory;
    private final boolean showBadge;
    private final boolean showDivider;
    private final boolean showRightBadge;
    private final CharSequence subtitle;
    private final int subtitleMaxLines;
    private final int subtitleTextAppearance;
    private final boolean switchChecked;
    private final CharSequence title;
    private final CharSequence titleEndText;
    private final int titleStyle;
    private final int titleTextAppearance;
    private final int trailingType;
    private final int valueTextAppearance;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\rJ\u001d\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\u0016\u0010\u000e\u001a\u00020\u000f*\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0013\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J2\u0010\u0014\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J2\u0010\u0019\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J*\u0010\u001a\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J4\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u001d"}, d2 = {"Lcom/stepos/widget/list/PreferenceListItemBridgeState$Companion;", "", "<init>", "()V", M5.e.FAIL_PARSE, "Lcom/stepos/widget/list/PreferenceListItemBridgeState;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "parse$StepOSWidget_release", "hasLocalAttr", "", "localName", "", "hasLocalAttr$StepOSWidget_release", "attrIndex", "readBooleanAttr", Const.INTENT_KEY_APIKEY, "Landroid/content/res/TypedArray;", "styleableIndex", "default", "readIntAttr", "readResourceAttr", "readTextAttr", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        private final int attrIndex(AttributeSet attrs, String localName) {
            if (attrs == null) {
                return -1;
            }
            int attributeCount = attrs.getAttributeCount();
            for (int i10 = 0; i10 < attributeCount; i10++) {
                if (p.d(attrs.getAttributeName(i10), localName)) {
                    return i10;
                }
            }
            return -1;
        }

        private final boolean hasLocalAttr(AttributeSet attributeSet, String str) {
            if (attributeSet == null) {
                return false;
            }
            return hasLocalAttr$StepOSWidget_release(attributeSet, str);
        }

        private final boolean readBooleanAttr(AttributeSet attrs, TypedArray a10, int styleableIndex, String localName, boolean z10) {
            int iAttrIndex = attrIndex(attrs, localName);
            return (iAttrIndex < 0 || attrs == null) ? a10.hasValue(styleableIndex) ? a10.getBoolean(styleableIndex, z10) : z10 : attrs.getAttributeBooleanValue(iAttrIndex, z10);
        }

        private final int readIntAttr(AttributeSet attrs, TypedArray a10, int styleableIndex, String localName, int i10) {
            int iAttrIndex = attrIndex(attrs, localName);
            return (iAttrIndex < 0 || attrs == null) ? a10.hasValue(styleableIndex) ? a10.getInt(styleableIndex, i10) : i10 : attrs.getAttributeIntValue(iAttrIndex, i10);
        }

        private final int readResourceAttr(AttributeSet attrs, TypedArray a10, int styleableIndex, String localName) {
            int attributeResourceValue;
            int iAttrIndex = attrIndex(attrs, localName);
            return (iAttrIndex < 0 || attrs == null || (attributeResourceValue = attrs.getAttributeResourceValue(iAttrIndex, 0)) == 0) ? a10.getResourceId(styleableIndex, 0) : attributeResourceValue;
        }

        private final CharSequence readTextAttr(Context context, AttributeSet attrs, TypedArray a10, int styleableIndex, String localName) {
            int iAttrIndex = attrIndex(attrs, localName);
            if (iAttrIndex < 0 || attrs == null) {
                return a10.getText(styleableIndex);
            }
            int attributeResourceValue = attrs.getAttributeResourceValue(iAttrIndex, 0);
            if (attributeResourceValue == 0) {
                return attrs.getAttributeValue(iAttrIndex);
            }
            try {
                return context.getResources().getText(attributeResourceValue);
            } catch (Exception unused) {
                return null;
            }
        }

        public final boolean hasLocalAttr$StepOSWidget_release(AttributeSet attrs, String localName) {
            p.i(attrs, "attrs");
            p.i(localName, "localName");
            int attributeCount = attrs.getAttributeCount();
            for (int i10 = 0; i10 < attributeCount; i10++) {
                if (p.d(attrs.getAttributeName(i10), localName)) {
                    return true;
                }
            }
            return false;
        }

        public final PreferenceListItemBridgeState parse$StepOSWidget_release(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) throws Exception {
            TypedArray typedArray;
            int dimensionPixelSize;
            int dimensionPixelSize2;
            int dimensionPixelSize3;
            int dimensionPixelSize4;
            int dimensionPixelSize5;
            int dimensionPixelSize6;
            int dimensionPixelSize7;
            int resourceId;
            int resourceId2;
            int resourceId3;
            Companion companion;
            int intAttr;
            AttributeSet attributeSet;
            p.i(context, "context");
            ListItemAttrIndices pREFERENCE_BRIDGE$StepOSWidget_release = ListItemAttrIndices.INSTANCE.getPREFERENCE_BRIDGE$StepOSWidget_release();
            Resources resources = context.getResources();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.StepOSPreference, defStyleAttr, defStyleRes);
            try {
                int dimensionPixelSize8 = resources.getDimensionPixelSize(R.dimen.stepos_list_item_height);
                int dimensionPixelSize9 = resources.getDimensionPixelSize(R.dimen.stepos_list_item_padding_start);
                int dimensionPixelSize10 = resources.getDimensionPixelSize(R.dimen.stepos_list_item_padding_vertical);
                int dimensionPixelSize11 = resources.getDimensionPixelSize(R.dimen.stepos_list_item_icon_text_gap);
                dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.stepos_divider_height);
                dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.stepos_divider_inset_start);
                dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.stepos_divider_inset_end);
                dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(pREFERENCE_BRIDGE$StepOSWidget_release.getMinHeight(), dimensionPixelSize8);
                dimensionPixelSize5 = typedArrayObtainStyledAttributes.getDimensionPixelSize(pREFERENCE_BRIDGE$StepOSWidget_release.getPaddingHorizontal(), dimensionPixelSize9);
                dimensionPixelSize6 = typedArrayObtainStyledAttributes.getDimensionPixelSize(pREFERENCE_BRIDGE$StepOSWidget_release.getPaddingVertical(), dimensionPixelSize10);
                dimensionPixelSize7 = typedArrayObtainStyledAttributes.getDimensionPixelSize(pREFERENCE_BRIDGE$StepOSWidget_release.getIconTextGap(), dimensionPixelSize11);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(pREFERENCE_BRIDGE$StepOSWidget_release.getTitleTextAppearance(), 0);
                resourceId2 = typedArrayObtainStyledAttributes.getResourceId(pREFERENCE_BRIDGE$StepOSWidget_release.getSubtitleTextAppearance(), 0);
                resourceId3 = typedArrayObtainStyledAttributes.getResourceId(pREFERENCE_BRIDGE$StepOSWidget_release.getValueTextAppearance(), 0);
                companion = PreferenceListItemBridgeState.INSTANCE;
                p.f(typedArrayObtainStyledAttributes);
                try {
                    intAttr = companion.readIntAttr(attrs, typedArrayObtainStyledAttributes, pREFERENCE_BRIDGE$StepOSWidget_release.getSubtitleMaxLines(), "steposListItemSubtitleMaxLines", 1);
                    typedArray = typedArrayObtainStyledAttributes;
                } catch (Throwable th) {
                    th = th;
                    typedArray = typedArrayObtainStyledAttributes;
                }
            } catch (Throwable th2) {
                th = th2;
                typedArray = typedArrayObtainStyledAttributes;
            }
            try {
                boolean z10 = typedArray.getBoolean(pREFERENCE_BRIDGE$StepOSWidget_release.getAdaptiveTextLayoutEnabled(), false);
                CharSequence textAttr = companion.readTextAttr(context, attrs, typedArray, pREFERENCE_BRIDGE$StepOSWidget_release.getTitle(), "steposListItemTitle");
                CharSequence textAttr2 = companion.readTextAttr(context, attrs, typedArray, pREFERENCE_BRIDGE$StepOSWidget_release.getTitleEndText(), "steposListItemTitleEndText");
                CharSequence textAttr3 = companion.readTextAttr(context, attrs, typedArray, pREFERENCE_BRIDGE$StepOSWidget_release.getSubtitle(), "steposListItemSubtitle");
                CharSequence textAttr4 = companion.readTextAttr(context, attrs, typedArray, pREFERENCE_BRIDGE$StepOSWidget_release.getRightText(), "steposListItemRightText");
                TypedArray typedArray2 = typedArray;
                if (textAttr4 == null) {
                    textAttr4 = companion.readTextAttr(context, attrs, typedArray2, pREFERENCE_BRIDGE$StepOSWidget_release.getValue(), "steposListItemValue");
                    attributeSet = attrs;
                    typedArray2 = typedArray2;
                } else {
                    attributeSet = attrs;
                }
                CharSequence charSequence = textAttr4;
                boolean zHasLocalAttr = companion.hasLocalAttr(attributeSet, "steposListItemIconBackground");
                Integer numValueOf = (companion.hasLocalAttr(attributeSet, "steposListItemIconBackground") && typedArray2.hasValue(pREFERENCE_BRIDGE$StepOSWidget_release.getIconBackground())) ? Integer.valueOf(typedArray2.getColor(pREFERENCE_BRIDGE$StepOSWidget_release.getIconBackground(), 0)) : null;
                int resourceAttr = companion.readResourceAttr(attributeSet, typedArray2, pREFERENCE_BRIDGE$StepOSWidget_release.getIcon(), "steposListItemIcon");
                boolean zHasLocalAttr2 = companion.hasLocalAttr(attributeSet, "steposListItemIconTint");
                Integer numValueOf2 = (companion.hasLocalAttr(attributeSet, "steposListItemIconTint") && typedArray2.hasValue(pREFERENCE_BRIDGE$StepOSWidget_release.getIconTint())) ? Integer.valueOf(typedArray2.getColor(pREFERENCE_BRIDGE$StepOSWidget_release.getIconTint(), 0)) : null;
                boolean booleanAttr = companion.readBooleanAttr(attributeSet, typedArray2, pREFERENCE_BRIDGE$StepOSWidget_release.getIconVisible(), "steposListItemIconVisible", true);
                int intAttr2 = companion.readIntAttr(attrs, typedArray2, pREFERENCE_BRIDGE$StepOSWidget_release.getIconStyle(), "steposListItemIconStyle", 0);
                boolean z11 = companion.hasLocalAttr(attrs, "steposListItemIconSize") || typedArray2.hasValue(pREFERENCE_BRIDGE$StepOSWidget_release.getIconSize());
                int dimensionPixelSize12 = typedArray2.getDimensionPixelSize(pREFERENCE_BRIDGE$StepOSWidget_release.getIconSize(), 0);
                boolean z12 = companion.hasLocalAttr(attrs, "steposListItemIconCornerRadius") || typedArray2.hasValue(pREFERENCE_BRIDGE$StepOSWidget_release.getIconCornerRadius());
                float dimension = typedArray2.getDimension(pREFERENCE_BRIDGE$StepOSWidget_release.getIconCornerRadius(), 0.0f);
                int intAttr3 = companion.readIntAttr(attrs, typedArray2, pREFERENCE_BRIDGE$StepOSWidget_release.getBadgeStyle(), "steposListItemBadgeStyle", 0);
                boolean z13 = companion.hasLocalAttr(attrs, "steposListItemBadgeTint") || typedArray2.hasValue(pREFERENCE_BRIDGE$StepOSWidget_release.getBadgeTint());
                int color = typedArray2.hasValue(pREFERENCE_BRIDGE$StepOSWidget_release.getBadgeTint()) ? typedArray2.getColor(pREFERENCE_BRIDGE$StepOSWidget_release.getBadgeTint(), 0) : 0;
                boolean booleanAttr2 = companion.readBooleanAttr(attrs, typedArray2, pREFERENCE_BRIDGE$StepOSWidget_release.getShowBadge(), "steposListItemShowBadge", false);
                int intAttr4 = companion.readIntAttr(attrs, typedArray2, pREFERENCE_BRIDGE$StepOSWidget_release.getRightBadgeStyle(), "steposListItemRightBadgeStyle", 1);
                boolean z14 = companion.hasLocalAttr(attrs, "steposListItemRightBadgeTint") || typedArray2.hasValue(pREFERENCE_BRIDGE$StepOSWidget_release.getRightBadgeTint());
                int color2 = typedArray2.hasValue(pREFERENCE_BRIDGE$StepOSWidget_release.getRightBadgeTint()) ? typedArray2.getColor(pREFERENCE_BRIDGE$StepOSWidget_release.getRightBadgeTint(), 0) : 0;
                boolean booleanAttr3 = companion.readBooleanAttr(attrs, typedArray2, pREFERENCE_BRIDGE$StepOSWidget_release.getShowRightBadge(), "steposListItemShowRightBadge", false);
                boolean booleanAttr4 = companion.readBooleanAttr(attrs, typedArray2, pREFERENCE_BRIDGE$StepOSWidget_release.getShowAccessory(), "steposListItemShowAccessory", true);
                Integer numValueOf3 = Integer.valueOf(typedArray2.getResourceId(pREFERENCE_BRIDGE$StepOSWidget_release.getRightIcon(), 0));
                if (numValueOf3.intValue() == 0) {
                    numValueOf3 = null;
                }
                int iIntValue = numValueOf3 != null ? numValueOf3.intValue() : typedArray2.getResourceId(pREFERENCE_BRIDGE$StepOSWidget_release.getAccessoryIcon(), R.drawable.stepos_icon_arrow_right);
                Integer numValueOf4 = typedArray2.hasValue(pREFERENCE_BRIDGE$StepOSWidget_release.getAccessorySize()) ? Integer.valueOf(typedArray2.getDimensionPixelSize(pREFERENCE_BRIDGE$StepOSWidget_release.getAccessorySize(), 0)) : null;
                int intAttr5 = companion.readIntAttr(attrs, typedArray2, pREFERENCE_BRIDGE$StepOSWidget_release.getTrailingType(), "steposListItemTrailingType", 1);
                typedArrayObtainStyledAttributes = typedArray2;
                typedArray = typedArrayObtainStyledAttributes;
                PreferenceListItemBridgeState preferenceListItemBridgeState = new PreferenceListItemBridgeState(dimensionPixelSize4, dimensionPixelSize5, dimensionPixelSize6, dimensionPixelSize7, resourceId, resourceId2, resourceId3, intAttr, z10, textAttr, textAttr2, textAttr3, charSequence, zHasLocalAttr, numValueOf, resourceAttr, zHasLocalAttr2, numValueOf2, booleanAttr, intAttr2, z11, dimensionPixelSize12, z12, dimension, intAttr3, z13, color, booleanAttr2, intAttr4, z14, color2, booleanAttr3, booleanAttr4, iIntValue, numValueOf4, intAttr5, companion.readTextAttr(context, attrs, typedArrayObtainStyledAttributes, pREFERENCE_BRIDGE$StepOSWidget_release.getButtonText(), "steposListItemButtonText"), companion.readIntAttr(attrs, typedArray, pREFERENCE_BRIDGE$StepOSWidget_release.getLineMode(), "steposListItemLineMode", 0), companion.readBooleanAttr(attrs, typedArray, pREFERENCE_BRIDGE$StepOSWidget_release.getChecked(), "steposListItemChecked", false), companion.readBooleanAttr(attrs, typedArray, pREFERENCE_BRIDGE$StepOSWidget_release.getSwitchChecked(), "steposListItemSwitchChecked", false), companion.readBooleanAttr(attrs, typedArray, pREFERENCE_BRIDGE$StepOSWidget_release.getPressScaleEnabled(), "steposListItemPressScaleEnabled", false), companion.readBooleanAttr(attrs, typedArray, pREFERENCE_BRIDGE$StepOSWidget_release.getShowDivider(), "steposListItemShowDivider", false), typedArray.getDimensionPixelSize(pREFERENCE_BRIDGE$StepOSWidget_release.getDividerHeight(), dimensionPixelSize), typedArray.getDimensionPixelSize(pREFERENCE_BRIDGE$StepOSWidget_release.getDividerInsetStart(), dimensionPixelSize2), typedArray.getDimensionPixelSize(pREFERENCE_BRIDGE$StepOSWidget_release.getDividerInsetEnd(), dimensionPixelSize3), typedArray.getColor(pREFERENCE_BRIDGE$StepOSWidget_release.getDividerColor(), context.getColor(R.color.stepos_divider)), companion.readIntAttr(attrs, typedArray, pREFERENCE_BRIDGE$StepOSWidget_release.getTitleStyle(), "steposListItemTitleStyle", 0));
                C4946a.a(typedArray, null);
                return preferenceListItemBridgeState;
            } catch (Throwable th3) {
                th = th3;
                Throwable th4 = th;
                try {
                    throw th4;
                } catch (Throwable th5) {
                    C4946a.a(typedArray, th4);
                    throw th5;
                }
            }
        }

        private Companion() {
        }
    }

    public PreferenceListItemBridgeState(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z11, Integer num, int i18, boolean z12, Integer num2, boolean z13, int i19, boolean z14, int i20, boolean z15, float f10, int i21, boolean z16, int i22, boolean z17, int i23, boolean z18, int i24, boolean z19, boolean z20, int i25, Integer num3, int i26, CharSequence charSequence5, int i27, boolean z21, boolean z22, boolean z23, boolean z24, int i28, int i29, int i30, int i31, int i32) {
        this.minHeight = i10;
        this.paddingHorizontal = i11;
        this.paddingVertical = i12;
        this.iconTextGap = i13;
        this.titleTextAppearance = i14;
        this.subtitleTextAppearance = i15;
        this.valueTextAppearance = i16;
        this.subtitleMaxLines = i17;
        this.adaptiveTextLayoutEnabled = z10;
        this.title = charSequence;
        this.titleEndText = charSequence2;
        this.subtitle = charSequence3;
        this.rightText = charSequence4;
        this.iconBackgroundExplicit = z11;
        this.iconBackgroundColor = num;
        this.iconDrawableRes = i18;
        this.iconTintExplicit = z12;
        this.iconTint = num2;
        this.iconVisible = z13;
        this.iconStyle = i19;
        this.iconSizeSet = z14;
        this.iconSize = i20;
        this.iconCornerRadiusSet = z15;
        this.iconCornerRadius = f10;
        this.badgeStyle = i21;
        this.badgeTintSet = z16;
        this.badgeTint = i22;
        this.showBadge = z17;
        this.rightBadgeStyle = i23;
        this.rightBadgeTintSet = z18;
        this.rightBadgeTint = i24;
        this.showRightBadge = z19;
        this.showAccessory = z20;
        this.accessoryIconRes = i25;
        this.accessorySize = num3;
        this.trailingType = i26;
        this.buttonText = charSequence5;
        this.lineMode = i27;
        this.checked = z21;
        this.switchChecked = z22;
        this.pressScaleEnabled = z23;
        this.showDivider = z24;
        this.dividerHeight = i28;
        this.dividerInsetStart = i29;
        this.dividerInsetEnd = i30;
        this.dividerColor = i31;
        this.titleStyle = i32;
    }

    /* renamed from: component1, reason: from getter */
    public final int getMinHeight() {
        return this.minHeight;
    }

    /* renamed from: component10, reason: from getter */
    public final CharSequence getTitle() {
        return this.title;
    }

    /* renamed from: component11, reason: from getter */
    public final CharSequence getTitleEndText() {
        return this.titleEndText;
    }

    /* renamed from: component12, reason: from getter */
    public final CharSequence getSubtitle() {
        return this.subtitle;
    }

    /* renamed from: component13, reason: from getter */
    public final CharSequence getRightText() {
        return this.rightText;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getIconBackgroundExplicit() {
        return this.iconBackgroundExplicit;
    }

    /* renamed from: component15, reason: from getter */
    public final Integer getIconBackgroundColor() {
        return this.iconBackgroundColor;
    }

    /* renamed from: component16, reason: from getter */
    public final int getIconDrawableRes() {
        return this.iconDrawableRes;
    }

    /* renamed from: component17, reason: from getter */
    public final boolean getIconTintExplicit() {
        return this.iconTintExplicit;
    }

    /* renamed from: component18, reason: from getter */
    public final Integer getIconTint() {
        return this.iconTint;
    }

    /* renamed from: component19, reason: from getter */
    public final boolean getIconVisible() {
        return this.iconVisible;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPaddingHorizontal() {
        return this.paddingHorizontal;
    }

    /* renamed from: component20, reason: from getter */
    public final int getIconStyle() {
        return this.iconStyle;
    }

    /* renamed from: component21, reason: from getter */
    public final boolean getIconSizeSet() {
        return this.iconSizeSet;
    }

    /* renamed from: component22, reason: from getter */
    public final int getIconSize() {
        return this.iconSize;
    }

    /* renamed from: component23, reason: from getter */
    public final boolean getIconCornerRadiusSet() {
        return this.iconCornerRadiusSet;
    }

    /* renamed from: component24, reason: from getter */
    public final float getIconCornerRadius() {
        return this.iconCornerRadius;
    }

    /* renamed from: component25, reason: from getter */
    public final int getBadgeStyle() {
        return this.badgeStyle;
    }

    /* renamed from: component26, reason: from getter */
    public final boolean getBadgeTintSet() {
        return this.badgeTintSet;
    }

    /* renamed from: component27, reason: from getter */
    public final int getBadgeTint() {
        return this.badgeTint;
    }

    /* renamed from: component28, reason: from getter */
    public final boolean getShowBadge() {
        return this.showBadge;
    }

    /* renamed from: component29, reason: from getter */
    public final int getRightBadgeStyle() {
        return this.rightBadgeStyle;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPaddingVertical() {
        return this.paddingVertical;
    }

    /* renamed from: component30, reason: from getter */
    public final boolean getRightBadgeTintSet() {
        return this.rightBadgeTintSet;
    }

    /* renamed from: component31, reason: from getter */
    public final int getRightBadgeTint() {
        return this.rightBadgeTint;
    }

    /* renamed from: component32, reason: from getter */
    public final boolean getShowRightBadge() {
        return this.showRightBadge;
    }

    /* renamed from: component33, reason: from getter */
    public final boolean getShowAccessory() {
        return this.showAccessory;
    }

    /* renamed from: component34, reason: from getter */
    public final int getAccessoryIconRes() {
        return this.accessoryIconRes;
    }

    /* renamed from: component35, reason: from getter */
    public final Integer getAccessorySize() {
        return this.accessorySize;
    }

    /* renamed from: component36, reason: from getter */
    public final int getTrailingType() {
        return this.trailingType;
    }

    /* renamed from: component37, reason: from getter */
    public final CharSequence getButtonText() {
        return this.buttonText;
    }

    /* renamed from: component38, reason: from getter */
    public final int getLineMode() {
        return this.lineMode;
    }

    /* renamed from: component39, reason: from getter */
    public final boolean getChecked() {
        return this.checked;
    }

    /* renamed from: component4, reason: from getter */
    public final int getIconTextGap() {
        return this.iconTextGap;
    }

    /* renamed from: component40, reason: from getter */
    public final boolean getSwitchChecked() {
        return this.switchChecked;
    }

    /* renamed from: component41, reason: from getter */
    public final boolean getPressScaleEnabled() {
        return this.pressScaleEnabled;
    }

    /* renamed from: component42, reason: from getter */
    public final boolean getShowDivider() {
        return this.showDivider;
    }

    /* renamed from: component43, reason: from getter */
    public final int getDividerHeight() {
        return this.dividerHeight;
    }

    /* renamed from: component44, reason: from getter */
    public final int getDividerInsetStart() {
        return this.dividerInsetStart;
    }

    /* renamed from: component45, reason: from getter */
    public final int getDividerInsetEnd() {
        return this.dividerInsetEnd;
    }

    /* renamed from: component46, reason: from getter */
    public final int getDividerColor() {
        return this.dividerColor;
    }

    /* renamed from: component47, reason: from getter */
    public final int getTitleStyle() {
        return this.titleStyle;
    }

    /* renamed from: component5, reason: from getter */
    public final int getTitleTextAppearance() {
        return this.titleTextAppearance;
    }

    /* renamed from: component6, reason: from getter */
    public final int getSubtitleTextAppearance() {
        return this.subtitleTextAppearance;
    }

    /* renamed from: component7, reason: from getter */
    public final int getValueTextAppearance() {
        return this.valueTextAppearance;
    }

    /* renamed from: component8, reason: from getter */
    public final int getSubtitleMaxLines() {
        return this.subtitleMaxLines;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getAdaptiveTextLayoutEnabled() {
        return this.adaptiveTextLayoutEnabled;
    }

    public final PreferenceListItemBridgeState copy(int minHeight, int paddingHorizontal, int paddingVertical, int iconTextGap, int titleTextAppearance, int subtitleTextAppearance, int valueTextAppearance, int subtitleMaxLines, boolean adaptiveTextLayoutEnabled, CharSequence title, CharSequence titleEndText, CharSequence subtitle, CharSequence rightText, boolean iconBackgroundExplicit, Integer iconBackgroundColor, int iconDrawableRes, boolean iconTintExplicit, Integer iconTint, boolean iconVisible, int iconStyle, boolean iconSizeSet, int iconSize, boolean iconCornerRadiusSet, float iconCornerRadius, int badgeStyle, boolean badgeTintSet, int badgeTint, boolean showBadge, int rightBadgeStyle, boolean rightBadgeTintSet, int rightBadgeTint, boolean showRightBadge, boolean showAccessory, int accessoryIconRes, Integer accessorySize, int trailingType, CharSequence buttonText, int lineMode, boolean checked, boolean switchChecked, boolean pressScaleEnabled, boolean showDivider, int dividerHeight, int dividerInsetStart, int dividerInsetEnd, int dividerColor, int titleStyle) {
        return new PreferenceListItemBridgeState(minHeight, paddingHorizontal, paddingVertical, iconTextGap, titleTextAppearance, subtitleTextAppearance, valueTextAppearance, subtitleMaxLines, adaptiveTextLayoutEnabled, title, titleEndText, subtitle, rightText, iconBackgroundExplicit, iconBackgroundColor, iconDrawableRes, iconTintExplicit, iconTint, iconVisible, iconStyle, iconSizeSet, iconSize, iconCornerRadiusSet, iconCornerRadius, badgeStyle, badgeTintSet, badgeTint, showBadge, rightBadgeStyle, rightBadgeTintSet, rightBadgeTint, showRightBadge, showAccessory, accessoryIconRes, accessorySize, trailingType, buttonText, lineMode, checked, switchChecked, pressScaleEnabled, showDivider, dividerHeight, dividerInsetStart, dividerInsetEnd, dividerColor, titleStyle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreferenceListItemBridgeState)) {
            return false;
        }
        PreferenceListItemBridgeState preferenceListItemBridgeState = (PreferenceListItemBridgeState) other;
        return this.minHeight == preferenceListItemBridgeState.minHeight && this.paddingHorizontal == preferenceListItemBridgeState.paddingHorizontal && this.paddingVertical == preferenceListItemBridgeState.paddingVertical && this.iconTextGap == preferenceListItemBridgeState.iconTextGap && this.titleTextAppearance == preferenceListItemBridgeState.titleTextAppearance && this.subtitleTextAppearance == preferenceListItemBridgeState.subtitleTextAppearance && this.valueTextAppearance == preferenceListItemBridgeState.valueTextAppearance && this.subtitleMaxLines == preferenceListItemBridgeState.subtitleMaxLines && this.adaptiveTextLayoutEnabled == preferenceListItemBridgeState.adaptiveTextLayoutEnabled && p.d(this.title, preferenceListItemBridgeState.title) && p.d(this.titleEndText, preferenceListItemBridgeState.titleEndText) && p.d(this.subtitle, preferenceListItemBridgeState.subtitle) && p.d(this.rightText, preferenceListItemBridgeState.rightText) && this.iconBackgroundExplicit == preferenceListItemBridgeState.iconBackgroundExplicit && p.d(this.iconBackgroundColor, preferenceListItemBridgeState.iconBackgroundColor) && this.iconDrawableRes == preferenceListItemBridgeState.iconDrawableRes && this.iconTintExplicit == preferenceListItemBridgeState.iconTintExplicit && p.d(this.iconTint, preferenceListItemBridgeState.iconTint) && this.iconVisible == preferenceListItemBridgeState.iconVisible && this.iconStyle == preferenceListItemBridgeState.iconStyle && this.iconSizeSet == preferenceListItemBridgeState.iconSizeSet && this.iconSize == preferenceListItemBridgeState.iconSize && this.iconCornerRadiusSet == preferenceListItemBridgeState.iconCornerRadiusSet && Float.compare(this.iconCornerRadius, preferenceListItemBridgeState.iconCornerRadius) == 0 && this.badgeStyle == preferenceListItemBridgeState.badgeStyle && this.badgeTintSet == preferenceListItemBridgeState.badgeTintSet && this.badgeTint == preferenceListItemBridgeState.badgeTint && this.showBadge == preferenceListItemBridgeState.showBadge && this.rightBadgeStyle == preferenceListItemBridgeState.rightBadgeStyle && this.rightBadgeTintSet == preferenceListItemBridgeState.rightBadgeTintSet && this.rightBadgeTint == preferenceListItemBridgeState.rightBadgeTint && this.showRightBadge == preferenceListItemBridgeState.showRightBadge && this.showAccessory == preferenceListItemBridgeState.showAccessory && this.accessoryIconRes == preferenceListItemBridgeState.accessoryIconRes && p.d(this.accessorySize, preferenceListItemBridgeState.accessorySize) && this.trailingType == preferenceListItemBridgeState.trailingType && p.d(this.buttonText, preferenceListItemBridgeState.buttonText) && this.lineMode == preferenceListItemBridgeState.lineMode && this.checked == preferenceListItemBridgeState.checked && this.switchChecked == preferenceListItemBridgeState.switchChecked && this.pressScaleEnabled == preferenceListItemBridgeState.pressScaleEnabled && this.showDivider == preferenceListItemBridgeState.showDivider && this.dividerHeight == preferenceListItemBridgeState.dividerHeight && this.dividerInsetStart == preferenceListItemBridgeState.dividerInsetStart && this.dividerInsetEnd == preferenceListItemBridgeState.dividerInsetEnd && this.dividerColor == preferenceListItemBridgeState.dividerColor && this.titleStyle == preferenceListItemBridgeState.titleStyle;
    }

    public final int getAccessoryIconRes() {
        return this.accessoryIconRes;
    }

    public final Integer getAccessorySize() {
        return this.accessorySize;
    }

    public final boolean getAdaptiveTextLayoutEnabled() {
        return this.adaptiveTextLayoutEnabled;
    }

    public final int getBadgeStyle() {
        return this.badgeStyle;
    }

    public final int getBadgeTint() {
        return this.badgeTint;
    }

    public final boolean getBadgeTintSet() {
        return this.badgeTintSet;
    }

    public final CharSequence getButtonText() {
        return this.buttonText;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final int getDividerColor() {
        return this.dividerColor;
    }

    public final int getDividerHeight() {
        return this.dividerHeight;
    }

    public final int getDividerInsetEnd() {
        return this.dividerInsetEnd;
    }

    public final int getDividerInsetStart() {
        return this.dividerInsetStart;
    }

    public final Integer getIconBackgroundColor() {
        return this.iconBackgroundColor;
    }

    public final boolean getIconBackgroundExplicit() {
        return this.iconBackgroundExplicit;
    }

    public final float getIconCornerRadius() {
        return this.iconCornerRadius;
    }

    public final boolean getIconCornerRadiusSet() {
        return this.iconCornerRadiusSet;
    }

    public final int getIconDrawableRes() {
        return this.iconDrawableRes;
    }

    public final int getIconSize() {
        return this.iconSize;
    }

    public final boolean getIconSizeSet() {
        return this.iconSizeSet;
    }

    public final int getIconStyle() {
        return this.iconStyle;
    }

    public final int getIconTextGap() {
        return this.iconTextGap;
    }

    public final Integer getIconTint() {
        return this.iconTint;
    }

    public final boolean getIconTintExplicit() {
        return this.iconTintExplicit;
    }

    public final boolean getIconVisible() {
        return this.iconVisible;
    }

    public final int getLineMode() {
        return this.lineMode;
    }

    public final int getMinHeight() {
        return this.minHeight;
    }

    public final int getPaddingHorizontal() {
        return this.paddingHorizontal;
    }

    public final int getPaddingVertical() {
        return this.paddingVertical;
    }

    public final boolean getPressScaleEnabled() {
        return this.pressScaleEnabled;
    }

    public final int getRightBadgeStyle() {
        return this.rightBadgeStyle;
    }

    public final int getRightBadgeTint() {
        return this.rightBadgeTint;
    }

    public final boolean getRightBadgeTintSet() {
        return this.rightBadgeTintSet;
    }

    public final CharSequence getRightText() {
        return this.rightText;
    }

    public final boolean getShowAccessory() {
        return this.showAccessory;
    }

    public final boolean getShowBadge() {
        return this.showBadge;
    }

    public final boolean getShowDivider() {
        return this.showDivider;
    }

    public final boolean getShowRightBadge() {
        return this.showRightBadge;
    }

    public final CharSequence getSubtitle() {
        return this.subtitle;
    }

    public final int getSubtitleMaxLines() {
        return this.subtitleMaxLines;
    }

    public final int getSubtitleTextAppearance() {
        return this.subtitleTextAppearance;
    }

    public final boolean getSwitchChecked() {
        return this.switchChecked;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public final CharSequence getTitleEndText() {
        return this.titleEndText;
    }

    public final int getTitleStyle() {
        return this.titleStyle;
    }

    public final int getTitleTextAppearance() {
        return this.titleTextAppearance;
    }

    public final int getTrailingType() {
        return this.trailingType;
    }

    public final int getValueTextAppearance() {
        return this.valueTextAppearance;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((Integer.hashCode(this.minHeight) * 31) + Integer.hashCode(this.paddingHorizontal)) * 31) + Integer.hashCode(this.paddingVertical)) * 31) + Integer.hashCode(this.iconTextGap)) * 31) + Integer.hashCode(this.titleTextAppearance)) * 31) + Integer.hashCode(this.subtitleTextAppearance)) * 31) + Integer.hashCode(this.valueTextAppearance)) * 31) + Integer.hashCode(this.subtitleMaxLines)) * 31) + Boolean.hashCode(this.adaptiveTextLayoutEnabled)) * 31;
        CharSequence charSequence = this.title;
        int iHashCode2 = (iHashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
        CharSequence charSequence2 = this.titleEndText;
        int iHashCode3 = (iHashCode2 + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
        CharSequence charSequence3 = this.subtitle;
        int iHashCode4 = (iHashCode3 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
        CharSequence charSequence4 = this.rightText;
        int iHashCode5 = (((iHashCode4 + (charSequence4 == null ? 0 : charSequence4.hashCode())) * 31) + Boolean.hashCode(this.iconBackgroundExplicit)) * 31;
        Integer num = this.iconBackgroundColor;
        int iHashCode6 = (((((iHashCode5 + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.iconDrawableRes)) * 31) + Boolean.hashCode(this.iconTintExplicit)) * 31;
        Integer num2 = this.iconTint;
        int iHashCode7 = (((((((((((((((((((((((((((((((((iHashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31) + Boolean.hashCode(this.iconVisible)) * 31) + Integer.hashCode(this.iconStyle)) * 31) + Boolean.hashCode(this.iconSizeSet)) * 31) + Integer.hashCode(this.iconSize)) * 31) + Boolean.hashCode(this.iconCornerRadiusSet)) * 31) + Float.hashCode(this.iconCornerRadius)) * 31) + Integer.hashCode(this.badgeStyle)) * 31) + Boolean.hashCode(this.badgeTintSet)) * 31) + Integer.hashCode(this.badgeTint)) * 31) + Boolean.hashCode(this.showBadge)) * 31) + Integer.hashCode(this.rightBadgeStyle)) * 31) + Boolean.hashCode(this.rightBadgeTintSet)) * 31) + Integer.hashCode(this.rightBadgeTint)) * 31) + Boolean.hashCode(this.showRightBadge)) * 31) + Boolean.hashCode(this.showAccessory)) * 31) + Integer.hashCode(this.accessoryIconRes)) * 31;
        Integer num3 = this.accessorySize;
        int iHashCode8 = (((iHashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31) + Integer.hashCode(this.trailingType)) * 31;
        CharSequence charSequence5 = this.buttonText;
        return ((((((((((((((((((((iHashCode8 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31) + Integer.hashCode(this.lineMode)) * 31) + Boolean.hashCode(this.checked)) * 31) + Boolean.hashCode(this.switchChecked)) * 31) + Boolean.hashCode(this.pressScaleEnabled)) * 31) + Boolean.hashCode(this.showDivider)) * 31) + Integer.hashCode(this.dividerHeight)) * 31) + Integer.hashCode(this.dividerInsetStart)) * 31) + Integer.hashCode(this.dividerInsetEnd)) * 31) + Integer.hashCode(this.dividerColor)) * 31) + Integer.hashCode(this.titleStyle);
    }

    public String toString() {
        int i10 = this.minHeight;
        int i11 = this.paddingHorizontal;
        int i12 = this.paddingVertical;
        int i13 = this.iconTextGap;
        int i14 = this.titleTextAppearance;
        int i15 = this.subtitleTextAppearance;
        int i16 = this.valueTextAppearance;
        int i17 = this.subtitleMaxLines;
        boolean z10 = this.adaptiveTextLayoutEnabled;
        CharSequence charSequence = this.title;
        CharSequence charSequence2 = this.titleEndText;
        CharSequence charSequence3 = this.subtitle;
        CharSequence charSequence4 = this.rightText;
        boolean z11 = this.iconBackgroundExplicit;
        Integer num = this.iconBackgroundColor;
        int i18 = this.iconDrawableRes;
        boolean z12 = this.iconTintExplicit;
        Integer num2 = this.iconTint;
        boolean z13 = this.iconVisible;
        int i19 = this.iconStyle;
        boolean z14 = this.iconSizeSet;
        int i20 = this.iconSize;
        boolean z15 = this.iconCornerRadiusSet;
        float f10 = this.iconCornerRadius;
        int i21 = this.badgeStyle;
        boolean z16 = this.badgeTintSet;
        int i22 = this.badgeTint;
        boolean z17 = this.showBadge;
        int i23 = this.rightBadgeStyle;
        boolean z18 = this.rightBadgeTintSet;
        int i24 = this.rightBadgeTint;
        boolean z19 = this.showRightBadge;
        boolean z20 = this.showAccessory;
        int i25 = this.accessoryIconRes;
        Integer num3 = this.accessorySize;
        int i26 = this.trailingType;
        CharSequence charSequence5 = this.buttonText;
        return "PreferenceListItemBridgeState(minHeight=" + i10 + ", paddingHorizontal=" + i11 + ", paddingVertical=" + i12 + ", iconTextGap=" + i13 + ", titleTextAppearance=" + i14 + ", subtitleTextAppearance=" + i15 + ", valueTextAppearance=" + i16 + ", subtitleMaxLines=" + i17 + ", adaptiveTextLayoutEnabled=" + z10 + ", title=" + ((Object) charSequence) + ", titleEndText=" + ((Object) charSequence2) + ", subtitle=" + ((Object) charSequence3) + ", rightText=" + ((Object) charSequence4) + ", iconBackgroundExplicit=" + z11 + ", iconBackgroundColor=" + num + ", iconDrawableRes=" + i18 + ", iconTintExplicit=" + z12 + ", iconTint=" + num2 + ", iconVisible=" + z13 + ", iconStyle=" + i19 + ", iconSizeSet=" + z14 + ", iconSize=" + i20 + ", iconCornerRadiusSet=" + z15 + ", iconCornerRadius=" + f10 + ", badgeStyle=" + i21 + ", badgeTintSet=" + z16 + ", badgeTint=" + i22 + ", showBadge=" + z17 + ", rightBadgeStyle=" + i23 + ", rightBadgeTintSet=" + z18 + ", rightBadgeTint=" + i24 + ", showRightBadge=" + z19 + ", showAccessory=" + z20 + ", accessoryIconRes=" + i25 + ", accessorySize=" + num3 + ", trailingType=" + i26 + ", buttonText=" + ((Object) charSequence5) + ", lineMode=" + this.lineMode + ", checked=" + this.checked + ", switchChecked=" + this.switchChecked + ", pressScaleEnabled=" + this.pressScaleEnabled + ", showDivider=" + this.showDivider + ", dividerHeight=" + this.dividerHeight + ", dividerInsetStart=" + this.dividerInsetStart + ", dividerInsetEnd=" + this.dividerInsetEnd + ", dividerColor=" + this.dividerColor + ", titleStyle=" + this.titleStyle + ")";
    }
}

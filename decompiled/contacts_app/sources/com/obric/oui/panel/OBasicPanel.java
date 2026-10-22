package com.obric.oui.panel;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.common.oui.R;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.panel.anim.AnimConfig;
import com.obric.oui.panel.header.BasicPanelHeader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OBasicPanel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0003\u0015\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/panel/OBasicPanel;", "Lcom/obric/oui/panel/OBasicPanelFragment;", "()V", "config", "Lcom/obric/oui/panel/OBasicPanel$Builder;", "getConfig", "()Lcom/obric/oui/panel/OBasicPanel$Builder;", "setConfig", "(Lcom/obric/oui/panel/OBasicPanel$Builder;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "setPanelConfig", "builder", "Builder", "Companion", "PadCompatConfig", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OBasicPanel extends OBasicPanelFragment {
    public static final Companion Companion = null;
    public static final int TOP_CORNER_RADIUS = 20;
    protected Builder config;

    /* JADX INFO: compiled from: OBasicPanel.kt */
    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005¢\u0006\u0002\u0010\u0017J\u001f\u0010\r\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u00052\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010oJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0005J\u000e\u0010p\u001a\u00020\u00002\u0006\u0010q\u001a\u00020+J\u000e\u0010r\u001a\u00020\u00002\u0006\u0010s\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010t\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0005J\u0006\u0010u\u001a\u00020vJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010w\u001a\u00020\u0005J\t\u0010x\u001a\u00020\u0003HÆ\u0003J\t\u0010y\u001a\u00020\u0005HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u0010{\u001a\u00020\u0005HÆ\u0003J\t\u0010|\u001a\u00020\u0005HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010~\u001a\u00020\u0005HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00104J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ°\u0001\u0010\u0087\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0005HÆ\u0001¢\u0006\u0003\u0010\u0088\u0001J\u0015\u0010\u0089\u0001\u001a\u00020\u00052\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0003HÖ\u0001J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0005J(\u0010\u0006\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u00032\b\b\u0002\u0010F\u001a\u00020\u0005J2\u0010\u0006\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u00032\b\b\u0002\u0010F\u001a\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u0003J\u000f\u0010\u0002\u001a\u00020\u00002\u0007\u0010\u008c\u0001\u001a\u00020\u0003J\u0018\u0010\u0002\u001a\u00020\u00002\u0007\u0010\u008c\u0001\u001a\u00020\u00032\u0007\u0010\u008d\u0001\u001a\u00020\u0005J\u000f\u0010\u0014\u001a\u00020\u00002\u0007\u0010\u008e\u0001\u001a\u00020\u0015J\u0010\u0010\u008f\u0001\u001a\u00020\u00002\u0007\u0010\u008e\u0001\u001a\u00020\u0011J\u000f\u0010_\u001a\u00020\u00002\u0007\u0010\u0090\u0001\u001a\u00020`J\u000f\u0010\u0016\u001a\u00020\u00002\u0007\u0010\u0091\u0001\u001a\u00020\u0005J\u000f\u0010\u0012\u001a\u00020\u00002\u0007\u0010\u0092\u0001\u001a\u00020\u0005J\u000f\u0010#\u001a\u00020\u00002\u0007\u0010\u0090\u0001\u001a\u00020 J\u000f\u0010>\u001a\u00020\u00002\u0007\u0010\u0093\u0001\u001a\u00020\u0005J\u0010\u0010\u0094\u0001\u001a\u00020\u00002\u0007\u0010\u008e\u0001\u001a\u00020^J\u000f\u0010k\u001a\u00020\u00002\u0007\u0010\u0095\u0001\u001a\u00020\u0003J\u000b\u0010\u0096\u0001\u001a\u00030\u0097\u0001HÖ\u0001J\u000f\u0010\u0004\u001a\u00020\u00002\u0007\u0010\u0098\u0001\u001a\u00020\u0005R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001bR\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0019\"\u0004\b(\u0010\u001bR\"\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\u001bR\u001e\u00102\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0019\"\u0004\b>\u0010\u001bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001e\u0010C\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\bD\u00104\"\u0004\bE\u00106R\u001a\u0010F\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0019\"\u0004\bH\u0010\u001bR\u001a\u0010I\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0019\"\u0004\bK\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0019\"\u0004\bM\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0019\"\u0004\bR\u0010\u001bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\bW\u00104\"\u0004\bX\u00106R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010_\u001a\u0004\u0018\u00010`X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0019\"\u0004\bf\u0010\u001bR\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0019\"\u0004\bh\u0010\u001bR\u001a\u0010i\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010T\"\u0004\bk\u0010VR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u0019\"\u0004\bm\u0010\u001b¨\u0006\u0099\u0001"}, d2 = {"Lcom/obric/oui/panel/OBasicPanel$Builder;", "", "maxPanelHeight", "", "useToneBg", "", "isExpandable", "header", "Lcom/obric/oui/panel/header/BasicPanelHeader;", Params.CONTENT, "Landroid/view/View;", "floatHeader", "backgroundDimEnable", "adaptNavBarColor", "navBarColor", "clipTopCorner", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "retainInstance", "autoSwitchDayNight", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "removeMinHeight", "(IZZLcom/obric/oui/panel/header/BasicPanelHeader;Landroid/view/View;ZZZLjava/lang/Integer;ZLandroid/content/DialogInterface$OnDismissListener;ZZLandroid/content/DialogInterface$OnCancelListener;Z)V", "getAdaptNavBarColor", "()Z", "setAdaptNavBarColor", "(Z)V", "adaptRLSlide", "getAdaptRLSlide", "setAdaptRLSlide", "animConfig", "Lcom/obric/oui/panel/anim/AnimConfig;", "getAnimConfig", "()Lcom/obric/oui/panel/anim/AnimConfig;", "setAnimConfig", "(Lcom/obric/oui/panel/anim/AnimConfig;)V", "getAutoSwitchDayNight", "setAutoSwitchDayNight", "getBackgroundDimEnable", "setBackgroundDimEnable", "bottomSheetCallbacks", "", "Lcom/obric/oui/panel/BottomSheetBehavior$BottomSheetCallback;", "getBottomSheetCallbacks", "()Ljava/util/List;", "setBottomSheetCallbacks", "(Ljava/util/List;)V", "getClipTopCorner", "setClipTopCorner", "collapsedHeight", "getCollapsedHeight", "()Ljava/lang/Integer;", "setCollapsedHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getContent", "()Landroid/view/View;", "setContent", "(Landroid/view/View;)V", "disableAutoAdaptHeight", "getDisableAutoAdaptHeight", "setDisableAutoAdaptHeight", "getDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "setDismissListener", "(Landroid/content/DialogInterface$OnDismissListener;)V", "expandedHeight", "getExpandedHeight", "setExpandedHeight", "fitsSystemWindows", "getFitsSystemWindows", "setFitsSystemWindows", "fixedPanelHeight", "getFixedPanelHeight", "setFixedPanelHeight", "getFloatHeader", "setFloatHeader", "getHeader", "()Lcom/obric/oui/panel/header/BasicPanelHeader;", "setHeader", "(Lcom/obric/oui/panel/header/BasicPanelHeader;)V", "setExpandable", "getMaxPanelHeight", "()I", "setMaxPanelHeight", "(I)V", "getNavBarColor", "setNavBarColor", "getOnCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "outsideClickListener", "Landroid/view/View$OnClickListener;", "padCompatConfig", "Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "getPadCompatConfig", "()Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "setPadCompatConfig", "(Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;)V", "getRemoveMinHeight", "setRemoveMinHeight", "getRetainInstance", "setRetainInstance", "styleId", "getStyleId", "setStyleId", "getUseToneBg", "setUseToneBg", "enable", "(ZLjava/lang/Integer;)Lcom/obric/oui/panel/OBasicPanel$Builder;", "addBottomSheetCallback", "callback", "allowHeaderFloating", "float", "autoSwitch", "build", "Lcom/obric/oui/panel/OBasicPanel;", "clip", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IZZLcom/obric/oui/panel/header/BasicPanelHeader;Landroid/view/View;ZZZLjava/lang/Integer;ZLandroid/content/DialogInterface$OnDismissListener;ZZLandroid/content/DialogInterface$OnCancelListener;Z)Lcom/obric/oui/panel/OBasicPanel$Builder;", "equals", "other", "hashCode", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "fixedHeight", "listener", "onDismissListener", "config", "remove", "retain", MaterialConfigFormatNames.DISABLE, "setOutsideClickListener", "id", "toString", "", "tongBg", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private boolean adaptNavBarColor;
        private boolean adaptRLSlide;
        private AnimConfig animConfig;
        private boolean autoSwitchDayNight;
        private boolean backgroundDimEnable;
        private List<BottomSheetBehavior.BottomSheetCallback> bottomSheetCallbacks;
        private boolean clipTopCorner;
        private Integer collapsedHeight;
        private View content;
        private boolean disableAutoAdaptHeight;
        private DialogInterface.OnDismissListener dismissListener;
        private Integer expandedHeight;
        private boolean fitsSystemWindows;
        private boolean fixedPanelHeight;
        private boolean floatHeader;
        private BasicPanelHeader header;
        private boolean isExpandable;
        private int maxPanelHeight;
        private Integer navBarColor;
        private DialogInterface.OnCancelListener onCancelListener;
        private View.OnClickListener outsideClickListener;
        private PadCompatConfig padCompatConfig;
        private boolean removeMinHeight;
        private boolean retainInstance;
        private int styleId;
        private boolean useToneBg;

        public Builder() {
            this(0, false, false, null, null, false, false, false, null, false, null, false, false, null, false, 32767, null);
        }

        public static /* synthetic */ Builder copy$default(Builder r16, int r17, boolean r18, boolean r19, BasicPanelHeader r20, View r21, boolean r22, boolean r23, boolean r24, Integer r25, boolean r26, DialogInterface.OnDismissListener r27, boolean r28, boolean r29, DialogInterface.OnCancelListener r30, boolean r31, int r32, Object r33) {
            if ((r32 & 1) == 0) goto L5;
            int r2 = r16.maxPanelHeight;
        L7:
            if ((r32 & 2) == 0) goto L9;
            boolean r3 = r16.useToneBg;
        L11:
            if ((r32 & 4) == 0) goto L13;
            boolean r4 = r16.isExpandable;
        L15:
            if ((r32 & 8) == 0) goto L17;
            BasicPanelHeader r5 = r16.header;
        L19:
            if ((r32 & 16) == 0) goto L21;
            View r6 = r16.content;
        L23:
            if ((r32 & 32) == 0) goto L25;
            boolean r7 = r16.floatHeader;
        L27:
            if ((r32 & 64) == 0) goto L29;
            boolean r8 = r16.backgroundDimEnable;
        L31:
            if ((r32 & 128) == 0) goto L33;
            boolean r9 = r16.adaptNavBarColor;
        L35:
            if ((r32 & 256) == 0) goto L37;
            Integer r10 = r16.navBarColor;
        L39:
            if ((r32 & 512) == 0) goto L41;
            boolean r11 = r16.clipTopCorner;
        L43:
            if ((r32 & 1024) == 0) goto L45;
            DialogInterface.OnDismissListener r12 = r16.dismissListener;
        L47:
            if ((r32 & 2048) == 0) goto L49;
            boolean r13 = r16.retainInstance;
        L51:
            if ((r32 & 4096) == 0) goto L53;
            boolean r14 = r16.autoSwitchDayNight;
        L55:
            if ((r32 & 8192) == 0) goto L57;
            DialogInterface.OnCancelListener r15 = r16.onCancelListener;
        L59:
            if ((r32 & 16384) == 0) goto L61;
            boolean r1 = r16.removeMinHeight;
        L63:
            return r16.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r1);
        L61:
            r1 = r31;
            goto L63
        L57:
            r15 = r30;
            goto L59
        L53:
            r14 = r29;
            goto L55
        L49:
            r13 = r28;
            goto L51
        L45:
            r12 = r27;
            goto L47
        L41:
            r11 = r26;
            goto L43
        L37:
            r10 = r25;
            goto L39
        L33:
            r9 = r24;
            goto L35
        L29:
            r8 = r23;
            goto L31
        L25:
            r7 = r22;
            goto L27
        L21:
            r6 = r21;
            goto L23
        L17:
            r5 = r20;
            goto L19
        L13:
            r4 = r19;
            goto L15
        L9:
            r3 = r18;
            goto L11
        L5:
            r2 = r17;
            goto L7
        }

        public final int component1() {
            return this.maxPanelHeight;
        }

        public final boolean component10() {
            return this.clipTopCorner;
        }

        public final DialogInterface.OnDismissListener component11() {
            return this.dismissListener;
        }

        public final boolean component12() {
            return this.retainInstance;
        }

        public final boolean component13() {
            return this.autoSwitchDayNight;
        }

        public final DialogInterface.OnCancelListener component14() {
            return this.onCancelListener;
        }

        public final boolean component15() {
            return this.removeMinHeight;
        }

        public final boolean component2() {
            return this.useToneBg;
        }

        public final boolean component3() {
            return this.isExpandable;
        }

        public final BasicPanelHeader component4() {
            return this.header;
        }

        public final View component5() {
            return this.content;
        }

        public final boolean component6() {
            return this.floatHeader;
        }

        public final boolean component7() {
            return this.backgroundDimEnable;
        }

        public final boolean component8() {
            return this.adaptNavBarColor;
        }

        public final Integer component9() {
            return this.navBarColor;
        }

        public final Builder copy(int r18, boolean r19, boolean r20, BasicPanelHeader r21, View r22, boolean r23, boolean r24, boolean r25, Integer r26, boolean r27, DialogInterface.OnDismissListener r28, boolean r29, boolean r30, DialogInterface.OnCancelListener r31, boolean r32) {
            return new Builder(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Builder) == true) goto L8;
            return false;
        L8:
            Builder r6 = (Builder) r5;
            if (this.maxPanelHeight == r6.maxPanelHeight) goto L12;
            return false;
        L12:
            if (this.useToneBg == r6.useToneBg) goto L15;
            return false;
        L15:
            if (this.isExpandable == r6.isExpandable) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.header, r6.header) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.content, r6.content) == true) goto L24;
            return false;
        L24:
            if (this.floatHeader == r6.floatHeader) goto L27;
            return false;
        L27:
            if (this.backgroundDimEnable == r6.backgroundDimEnable) goto L30;
            return false;
        L30:
            if (this.adaptNavBarColor == r6.adaptNavBarColor) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.navBarColor, r6.navBarColor) == true) goto L36;
            return false;
        L36:
            if (this.clipTopCorner == r6.clipTopCorner) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.dismissListener, r6.dismissListener) == true) goto L42;
            return false;
        L42:
            if (this.retainInstance == r6.retainInstance) goto L45;
            return false;
        L45:
            if (this.autoSwitchDayNight == r6.autoSwitchDayNight) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.onCancelListener, r6.onCancelListener) == true) goto L51;
            return false;
        L51:
            if (this.removeMinHeight == r6.removeMinHeight) goto L53;
            return false;
        L53:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v29, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11, types: [int] */
        /* JADX WARN: Type inference failed for: r1v13, types: [int] */
        /* JADX WARN: Type inference failed for: r1v15, types: [int] */
        /* JADX WARN: Type inference failed for: r1v20, types: [int] */
        /* JADX WARN: Type inference failed for: r1v25, types: [int] */
        /* JADX WARN: Type inference failed for: r1v27, types: [int] */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v30 */
        /* JADX WARN: Type inference failed for: r1v32 */
        /* JADX WARN: Type inference failed for: r1v34 */
        /* JADX WARN: Type inference failed for: r1v35 */
        /* JADX WARN: Type inference failed for: r1v36 */
        /* JADX WARN: Type inference failed for: r1v39 */
        /* JADX WARN: Type inference failed for: r1v40 */
        /* JADX WARN: Type inference failed for: r1v41 */
        /* JADX WARN: Type inference failed for: r1v42 */
        /* JADX WARN: Type inference failed for: r1v43 */
        /* JADX WARN: Type inference failed for: r1v44 */
        /* JADX WARN: Type inference failed for: r1v45 */
        /* JADX WARN: Type inference failed for: r1v46 */
        /* JADX WARN: Type inference failed for: r1v47 */
        /* JADX WARN: Type inference failed for: r1v48 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int r0 = Integer.hashCode(this.maxPanelHeight) * 31;
            boolean r1 = this.useToneBg;
            ?? r2 = 1;
            ?? r3 = r1;
            if (r1 == false) goto L5;
            r3 = 1;
        L5:
            int r4 = (r0 + r3) * 31;
            boolean r5 = this.isExpandable;
            ?? r6 = r5;
            if (r5 == false) goto L8;
            r6 = 1;
        L8:
            int r7 = (r4 + r6) * 31;
            BasicPanelHeader r8 = this.header;
            int r9 = 0;
            if (r8 != null) goto L11;
            int r10 = 0;
        L12:
            int r11 = (r7 + r10) * 31;
            View r12 = this.content;
            if (r12 != null) goto L15;
            int r13 = 0;
        L16:
            int r14 = (r11 + r13) * 31;
            boolean r15 = this.floatHeader;
            ?? r16 = r15;
            if (r15 == false) goto L19;
            r16 = 1;
        L19:
            int r17 = (r14 + r16) * 31;
            boolean r18 = this.backgroundDimEnable;
            ?? r19 = r18;
            if (r18 == false) goto L22;
            r19 = 1;
        L22:
            int r20 = (r17 + r19) * 31;
            boolean r21 = this.adaptNavBarColor;
            ?? r22 = r21;
            if (r21 == false) goto L25;
            r22 = 1;
        L25:
            int r23 = (r20 + r22) * 31;
            Integer r24 = this.navBarColor;
            if (r24 != null) goto L28;
            int r25 = 0;
        L29:
            int r26 = (r23 + r25) * 31;
            boolean r27 = this.clipTopCorner;
            ?? r28 = r27;
            if (r27 == false) goto L32;
            r28 = 1;
        L32:
            int r29 = (r26 + r28) * 31;
            DialogInterface.OnDismissListener r30 = this.dismissListener;
            if (r30 != null) goto L35;
            int r31 = 0;
        L36:
            int r32 = (r29 + r31) * 31;
            boolean r33 = this.retainInstance;
            ?? r34 = r33;
            if (r33 == false) goto L39;
            r34 = 1;
        L39:
            int r35 = (r32 + r34) * 31;
            boolean r36 = this.autoSwitchDayNight;
            ?? r37 = r36;
            if (r36 == false) goto L42;
            r37 = 1;
        L42:
            int r38 = (r35 + r37) * 31;
            DialogInterface.OnCancelListener r39 = this.onCancelListener;
            if (r39 == null) goto L46;
            r9 = r39.hashCode();
        L46:
            int r40 = (r38 + r9) * 31;
            boolean r41 = this.removeMinHeight;
            if (r41 == true) goto L51;
            r2 = r41;
        L51:
            return r40 + r2;
        L35:
            r31 = r30.hashCode();
            goto L36
        L28:
            r25 = r24.hashCode();
            goto L29
        L15:
            r13 = r12.hashCode();
            goto L16
        L11:
            r10 = r8.hashCode();
            goto L12
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("Builder(maxPanelHeight=");
            r0.append(this.maxPanelHeight).append(", useToneBg=").append(this.useToneBg).append(", isExpandable=").append(this.isExpandable).append(", header=").append(this.header).append(", content=").append(this.content).append(", floatHeader=").append(this.floatHeader).append(", backgroundDimEnable=").append(this.backgroundDimEnable).append(", adaptNavBarColor=").append(this.adaptNavBarColor).append(", navBarColor=").append(this.navBarColor).append(", clipTopCorner=").append(this.clipTopCorner).append(", dismissListener=").append(this.dismissListener).append(", retainInstance=");
            r0.append(this.retainInstance).append(", autoSwitchDayNight=").append(this.autoSwitchDayNight).append(", onCancelListener=").append(this.onCancelListener).append(", removeMinHeight=").append(this.removeMinHeight).append(')');
            return r0.toString();
        }

        public Builder(int r1, boolean r2, boolean r3, BasicPanelHeader r4, View r5, boolean r6, boolean r7, boolean r8, Integer r9, boolean r10, DialogInterface.OnDismissListener r11, boolean r12, boolean r13, DialogInterface.OnCancelListener r14, boolean r15) {
            this.maxPanelHeight = r1;
            this.useToneBg = r2;
            this.isExpandable = r3;
            this.header = r4;
            this.content = r5;
            this.floatHeader = r6;
            this.backgroundDimEnable = r7;
            this.adaptNavBarColor = r8;
            this.navBarColor = r9;
            this.clipTopCorner = r10;
            this.dismissListener = r11;
            this.retainInstance = r12;
            this.autoSwitchDayNight = r13;
            this.onCancelListener = r14;
            this.removeMinHeight = r15;
            this.fitsSystemWindows = true;
            this.styleId = R.style.OBasicPanel;
        }

        public /* synthetic */ Builder(int r17, boolean r18, boolean r19, BasicPanelHeader r20, View r21, boolean r22, boolean r23, boolean r24, Integer r25, boolean r26, DialogInterface.OnDismissListener r27, boolean r28, boolean r29, DialogInterface.OnCancelListener r30, boolean r31, int r32, DefaultConstructorMarker r33) {
            if ((r32 & 1) == 0) goto L5;
            int r1 = -1;
        L7:
            if ((r32 & 2) == 0) goto L9;
            boolean r2 = false;
        L11:
            if ((r32 & 4) == 0) goto L13;
            boolean r4 = false;
        L14:
            DialogInterface.OnCancelListener r6 = null;
            if ((r32 & 8) == 0) goto L17;
            BasicPanelHeader r5 = null;
        L19:
            if ((r32 & 16) == 0) goto L21;
            View r7 = null;
        L23:
            if ((r32 & 32) == 0) goto L25;
            boolean r8 = false;
        L26:
            boolean r10 = true;
            if ((r32 & 64) == 0) goto L29;
            boolean r9 = true;
        L31:
            if ((r32 & 128) == 0) goto L33;
            boolean r11 = false;
        L35:
            if ((r32 & 256) == 0) goto L37;
            Integer r12 = null;
        L39:
            if ((r32 & 512) != 0) goto L43;
            r10 = r26;
        L43:
            if ((r32 & 1024) == 0) goto L45;
            DialogInterface.OnDismissListener r13 = null;
        L47:
            if ((r32 & 2048) == 0) goto L49;
            boolean r14 = false;
        L51:
            if ((r32 & 4096) == 0) goto L53;
            boolean r15 = false;
        L55:
            if ((r32 & 8192) != 0) goto L59;
            r6 = r30;
        L59:
            if ((r32 & 16384) == 0) goto L61;
            boolean r0 = false;
        L62:
            this(r1, r2, r4, r5, r7, r8, r9, r11, r12, r10, r13, r14, r15, r6, r0);
            return;
        L61:
            r0 = r31;
            goto L62
        L53:
            r15 = r29;
            goto L55
        L49:
            r14 = r28;
            goto L51
        L45:
            r13 = r27;
            goto L47
        L37:
            r12 = r25;
            goto L39
        L33:
            r11 = r24;
            goto L35
        L29:
            r9 = r23;
            goto L31
        L25:
            r8 = r22;
            goto L26
        L21:
            r7 = r21;
            goto L23
        L17:
            r5 = r20;
            goto L19
        L13:
            r4 = r19;
            goto L14
        L9:
            r2 = r18;
            goto L11
        L5:
            r1 = r17;
            goto L7
        }

        public final int getMaxPanelHeight() {
            return this.maxPanelHeight;
        }

        public final void setMaxPanelHeight(int r1) {
            this.maxPanelHeight = r1;
        }

        public final boolean getUseToneBg() {
            return this.useToneBg;
        }

        public final void setUseToneBg(boolean r1) {
            this.useToneBg = r1;
        }

        public final boolean isExpandable() {
            return this.isExpandable;
        }

        public final void setExpandable(boolean r1) {
            this.isExpandable = r1;
        }

        public final BasicPanelHeader getHeader() {
            return this.header;
        }

        public final void setHeader(BasicPanelHeader r1) {
            this.header = r1;
        }

        public final View getContent() {
            return this.content;
        }

        public final void setContent(View r1) {
            this.content = r1;
        }

        public final boolean getFloatHeader() {
            return this.floatHeader;
        }

        public final void setFloatHeader(boolean r1) {
            this.floatHeader = r1;
        }

        public final boolean getBackgroundDimEnable() {
            return this.backgroundDimEnable;
        }

        public final void setBackgroundDimEnable(boolean r1) {
            this.backgroundDimEnable = r1;
        }

        public final boolean getAdaptNavBarColor() {
            return this.adaptNavBarColor;
        }

        public final void setAdaptNavBarColor(boolean r1) {
            this.adaptNavBarColor = r1;
        }

        public final Integer getNavBarColor() {
            return this.navBarColor;
        }

        public final void setNavBarColor(Integer r1) {
            this.navBarColor = r1;
        }

        public final boolean getClipTopCorner() {
            return this.clipTopCorner;
        }

        public final void setClipTopCorner(boolean r1) {
            this.clipTopCorner = r1;
        }

        public final DialogInterface.OnDismissListener getDismissListener() {
            return this.dismissListener;
        }

        public final void setDismissListener(DialogInterface.OnDismissListener r1) {
            this.dismissListener = r1;
        }

        public final boolean getRetainInstance() {
            return this.retainInstance;
        }

        public final void setRetainInstance(boolean r1) {
            this.retainInstance = r1;
        }

        public final boolean getAutoSwitchDayNight() {
            return this.autoSwitchDayNight;
        }

        public final void setAutoSwitchDayNight(boolean r1) {
            this.autoSwitchDayNight = r1;
        }

        public final DialogInterface.OnCancelListener getOnCancelListener() {
            return this.onCancelListener;
        }

        public final void setOnCancelListener(DialogInterface.OnCancelListener r1) {
            this.onCancelListener = r1;
        }

        public final boolean getRemoveMinHeight() {
            return this.removeMinHeight;
        }

        public final void setRemoveMinHeight(boolean r1) {
            this.removeMinHeight = r1;
        }

        public final PadCompatConfig getPadCompatConfig() {
            return this.padCompatConfig;
        }

        public final void setPadCompatConfig(PadCompatConfig r1) {
            this.padCompatConfig = r1;
        }

        public final List<BottomSheetBehavior.BottomSheetCallback> getBottomSheetCallbacks() {
            return this.bottomSheetCallbacks;
        }

        public final void setBottomSheetCallbacks(List<BottomSheetBehavior.BottomSheetCallback> r1) {
            this.bottomSheetCallbacks = r1;
        }

        public final boolean getFixedPanelHeight() {
            return this.fixedPanelHeight;
        }

        public final void setFixedPanelHeight(boolean r1) {
            this.fixedPanelHeight = r1;
        }

        public final Integer getCollapsedHeight() {
            return this.collapsedHeight;
        }

        public final void setCollapsedHeight(Integer r1) {
            this.collapsedHeight = r1;
        }

        public final Integer getExpandedHeight() {
            return this.expandedHeight;
        }

        public final void setExpandedHeight(Integer r1) {
            this.expandedHeight = r1;
        }

        public final boolean getFitsSystemWindows() {
            return this.fitsSystemWindows;
        }

        public final void setFitsSystemWindows(boolean r1) {
            this.fitsSystemWindows = r1;
        }

        public final AnimConfig getAnimConfig() {
            return this.animConfig;
        }

        /* JADX INFO: renamed from: setAnimConfig, reason: collision with other method in class */
        public final void m572setAnimConfig(AnimConfig r1) {
            this.animConfig = r1;
        }

        public final int getStyleId() {
            return this.styleId;
        }

        /* JADX INFO: renamed from: setStyleId, reason: collision with other method in class */
        public final void m574setStyleId(int r1) {
            this.styleId = r1;
        }

        public final boolean getAdaptRLSlide() {
            return this.adaptRLSlide;
        }

        public final void setAdaptRLSlide(boolean r1) {
            this.adaptRLSlide = r1;
        }

        public final boolean getDisableAutoAdaptHeight() {
            return this.disableAutoAdaptHeight;
        }

        /* JADX INFO: renamed from: setDisableAutoAdaptHeight, reason: collision with other method in class */
        public final void m573setDisableAutoAdaptHeight(boolean r1) {
            this.disableAutoAdaptHeight = r1;
        }

        public final Builder setOutsideClickListener(View.OnClickListener r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.outsideClickListener = r2;
            return this;
        }

        public final Builder maxPanelHeight(int r2) {
            if (r2 <= 0) goto L5;
            setExpandable(false);
        L5:
            setMaxPanelHeight(r2);
            return this;
        }

        public final Builder maxPanelHeight(int r2, boolean r3) {
            maxPanelHeight(r2);
            setFixedPanelHeight(r3);
            return this;
        }

        public final Builder useToneBg(boolean r2) {
            setUseToneBg(r2);
            return this;
        }

        public final Builder isExpandable(boolean r2) {
            setExpandable(r2);
            setMaxPanelHeight(-1);
            return this;
        }

        public static /* synthetic */ Builder isExpandable$default(Builder r0, boolean r1, int r2, int r3, boolean r4, int r5, Object r6) {
            if ((r5 & 8) == 0) goto L6;
            r4 = true;
        L6:
            return r0.isExpandable(r1, r2, r3, r4);
        }

        public final Builder isExpandable(boolean r2, int r3, int r4, boolean r5) {
            setExpandable(r2);
            setMaxPanelHeight(-1);
            setCollapsedHeight(Integer.valueOf(r3));
            setExpandedHeight(Integer.valueOf(r4));
            setFitsSystemWindows(r5);
            return this;
        }

        public static /* synthetic */ Builder isExpandable$default(Builder r6, boolean r7, int r8, int r9, boolean r10, int r11, int r12, Object r13) {
            if ((r12 & 8) == 0) goto L5;
            r10 = true;
        L5:
            boolean r4 = r10;
            if ((r12 & 16) == 0) goto L9;
            r11 = -1;
        L9:
            return r6.isExpandable(r7, r8, r9, r4, r11);
        }

        public final Builder isExpandable(boolean r2, int r3, int r4, boolean r5, int r6) {
            setExpandable(r2);
            setMaxPanelHeight(r6);
            setCollapsedHeight(Integer.valueOf(r3));
            setExpandedHeight(Integer.valueOf(r4));
            setFitsSystemWindows(r5);
            return this;
        }

        public final Builder header(BasicPanelHeader r2) {
            Intrinsics.checkNotNullParameter(r2, "header");
            setHeader(r2);
            return this;
        }

        public final Builder content(View r2) {
            Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
            setContent(r2);
            return this;
        }

        public final Builder allowHeaderFloating(boolean r2) {
            setFloatHeader(r2);
            return this;
        }

        public final Builder backgroundDimEnable(boolean r2) {
            setBackgroundDimEnable(r2);
            return this;
        }

        public static /* synthetic */ Builder adaptNavBarColor$default(Builder r0, boolean r1, Integer r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = null;
        L6:
            return r0.adaptNavBarColor(r1, r2);
        }

        public final Builder adaptNavBarColor(boolean r2, Integer r3) {
            setAdaptNavBarColor(r2);
            setNavBarColor(r3);
            return this;
        }

        public final Builder onDismissListener(DialogInterface.OnDismissListener r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            setDismissListener(r2);
            return this;
        }

        public final Builder clipTopCorner(boolean r2) {
            setClipTopCorner(r2);
            return this;
        }

        public final Builder retainInstance(boolean r2) {
            setRetainInstance(r2);
            return this;
        }

        public final Builder autoSwitchDayNight(boolean r2) {
            setAutoSwitchDayNight(r2);
            return this;
        }

        public final Builder onCancelListener(DialogInterface.OnCancelListener r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            setOnCancelListener(r2);
            return this;
        }

        public final Builder padCompatConfig(PadCompatConfig r2) {
            Intrinsics.checkNotNullParameter(r2, "config");
            setPadCompatConfig(r2);
            return this;
        }

        public final Builder removeMinHeight(boolean r2) {
            setRemoveMinHeight(r2);
            return this;
        }

        public final Builder addBottomSheetCallback(BottomSheetBehavior.BottomSheetCallback r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            if (getBottomSheetCallbacks() != null) goto L5;
            setBottomSheetCallbacks(new ArrayList());
        L5:
            List<BottomSheetBehavior.BottomSheetCallback> r0 = getBottomSheetCallbacks();
            if (r0 == null) goto L9;
            r0.add(r2);
        L9:
            return this;
        }

        public final Builder setDisableAutoAdaptHeight(boolean r2) {
            m573setDisableAutoAdaptHeight(r2);
            return this;
        }

        public final Builder setAnimConfig(AnimConfig r2) {
            Intrinsics.checkNotNullParameter(r2, "config");
            m572setAnimConfig(r2);
            return this;
        }

        public final Builder setStyleId(int r2) {
            m574setStyleId(r2);
            return this;
        }

        public final Builder adaptRLSlide(boolean r2) {
            setAdaptRLSlide(r2);
            return this;
        }

        public final OBasicPanel build() {
            OBasicPanel r0 = new OBasicPanel();
            r0.setPanelConfig(this);
            r0.setMaxPanelHeight(getMaxPanelHeight());
            r0.setUseToneBg(getUseToneBg());
            r0.setExpandable(isExpandable());
            r0.setFloatHeader(getFloatHeader());
            r0.setBackgroundDimEnable(getBackgroundDimEnable());
            r0.setAdaptNavBarColor(getAdaptNavBarColor());
            r0.setPanelHeader(getHeader());
            r0.setNavBarColor(getNavBarColor());
            r0.setOnDismissListener(getDismissListener());
            r0.setClipTopCorner(getClipTopCorner());
            r0.setRetainInstance(getRetainInstance());
            r0.setAutoSwitchDayNight(getAutoSwitchDayNight());
            r0.setOnCancelListener(getOnCancelListener());
            r0.setRemoveMinHeight(getRemoveMinHeight());
            r0.setBottomSheetCallbacks(getBottomSheetCallbacks());
            r0.setFixedPanelHeight(getFixedPanelHeight());
            r0.setAnimConfig(getAnimConfig());
            r0.setStyleId(getStyleId());
            r0.setOutsideClickListener(this.outsideClickListener);
            r0.setPadCompatConfig(getPadCompatConfig());
            r0.setCollapsedHeight(getCollapsedHeight());
            r0.setExpandedHeight(getExpandedHeight());
            r0.setFitsSystemWindows(getFitsSystemWindows());
            r0.setAdaptRLSlide(getAdaptRLSlide());
            r0.setDisableAutoAdaptHeight(getDisableAutoAdaptHeight());
            return r0;
        }
    }

    /* JADX INFO: compiled from: OBasicPanel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/panel/OBasicPanel$Companion;", "", "()V", "TOP_CORNER_RADIUS", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OBasicPanel.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001aB-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "", "isEnabled", "", "isMultiPanel", "closeIconStyle", "Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig$CloseIconStyle;", "forceEnable", "(ZZLcom/obric/oui/panel/OBasicPanel$PadCompatConfig$CloseIconStyle;Z)V", "getCloseIconStyle", "()Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig$CloseIconStyle;", "getForceEnable", "()Z", "setForceEnable", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "CloseIconStyle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PadCompatConfig {
        private final CloseIconStyle closeIconStyle;
        private boolean forceEnable;
        private final boolean isEnabled;
        private final boolean isMultiPanel;

        /* JADX INFO: compiled from: OBasicPanel.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig$CloseIconStyle;", "", "(Ljava/lang/String;I)V", "BLACK_NO_BG", "WHITE_WITH_BG", "BLACK_WITH_BG", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum CloseIconStyle extends Enum<CloseIconStyle> {
            private static final /* synthetic */ CloseIconStyle[] $VALUES = null;
            public static final CloseIconStyle BLACK_NO_BG = null;
            public static final CloseIconStyle BLACK_WITH_BG = null;
            public static final CloseIconStyle WHITE_WITH_BG = null;

            private static final /* synthetic */ CloseIconStyle[] $values() {
                return new CloseIconStyle[]{BLACK_NO_BG, WHITE_WITH_BG, BLACK_WITH_BG};
            }

            public static CloseIconStyle valueOf(String r1) {
                return (CloseIconStyle) Enum.valueOf(CloseIconStyle.class, r1);
            }

            public static CloseIconStyle[] values() {
                return (CloseIconStyle[]) $VALUES.clone();
            }

            private CloseIconStyle(String r1, int r2) {
                super(r1, r2);
            }

            static {
                BLACK_NO_BG = new CloseIconStyle("BLACK_NO_BG", 0);
                WHITE_WITH_BG = new CloseIconStyle("WHITE_WITH_BG", 1);
                BLACK_WITH_BG = new CloseIconStyle("BLACK_WITH_BG", 2);
                $VALUES = $values();
            }
        }

        public PadCompatConfig() {
            this(false, false, null, false, 15, null);
        }

        public static /* synthetic */ PadCompatConfig copy$default(PadCompatConfig r0, boolean r1, boolean r2, CloseIconStyle r3, boolean r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.isEnabled;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.isMultiPanel;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.closeIconStyle;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.forceEnable;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final boolean component1() {
            return this.isEnabled;
        }

        public final boolean component2() {
            return this.isMultiPanel;
        }

        public final CloseIconStyle component3() {
            return this.closeIconStyle;
        }

        public final boolean component4() {
            return this.forceEnable;
        }

        public final PadCompatConfig copy(boolean r1, boolean r2, CloseIconStyle r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "closeIconStyle");
            return new PadCompatConfig(r1, r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof PadCompatConfig) == true) goto L8;
            return false;
        L8:
            PadCompatConfig r6 = (PadCompatConfig) r5;
            if (this.isEnabled == r6.isEnabled) goto L12;
            return false;
        L12:
            if (this.isMultiPanel == r6.isMultiPanel) goto L15;
            return false;
        L15:
            if (this.closeIconStyle == r6.closeIconStyle) goto L18;
            return false;
        L18:
            if (this.forceEnable == r6.forceEnable) goto L20;
            return false;
        L20:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5 */
        public int hashCode() {
            boolean r0 = this.isEnabled;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.isMultiPanel;
            ?? r5 = r4;
            if (r4 == false) goto L8;
            r5 = 1;
        L8:
            int r6 = (((r3 + r5) * 31) + this.closeIconStyle.hashCode()) * 31;
            boolean r7 = this.forceEnable;
            if (r7 == true) goto L13;
            r1 = r7;
        L13:
            return r6 + r1;
        }

        public String toString() {
            return "PadCompatConfig(isEnabled=" + this.isEnabled + ", isMultiPanel=" + this.isMultiPanel + ", closeIconStyle=" + this.closeIconStyle + ", forceEnable=" + this.forceEnable + ')';
        }

        public PadCompatConfig(boolean r2, boolean r3, CloseIconStyle r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, "closeIconStyle");
            this.isEnabled = r2;
            this.isMultiPanel = r3;
            this.closeIconStyle = r4;
            this.forceEnable = r5;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        public final boolean isMultiPanel() {
            return this.isMultiPanel;
        }

        public /* synthetic */ PadCompatConfig(boolean r2, boolean r3, CloseIconStyle r4, boolean r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = true;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = false;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = CloseIconStyle.BLACK_WITH_BG;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = false;
        L14:
            this(r2, r3, r4, r5);
        }

        public final CloseIconStyle getCloseIconStyle() {
            return this.closeIconStyle;
        }

        public final boolean getForceEnable() {
            return this.forceEnable;
        }

        public final void setForceEnable(boolean r1) {
            this.forceEnable = r1;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OBasicPanel() {
    }

    protected final Builder getConfig() {
        Builder r0 = this.config;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    }

    protected final void setConfig(Builder r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.config = r2;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        if (this.config != null) goto L7;
        return null;
    L7:
        if (getConfig().getContent() == null) goto L16;
        View r4 = getConfig().getContent();
        Intrinsics.checkNotNull(r4);
        if (r4.getParent() == null) goto L16;
        View r5 = getConfig().getContent();
        Intrinsics.checkNotNull(r5);
        ViewParent r6 = r5.getParent();
        if (r6 == null) goto L14;
        ((ViewGroup) r6).removeView(getConfig().getContent());
        goto L16
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L16:
        return getConfig().getContent();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.config != null) goto L16;
        Dialog r0 = getDialog();
        boolean r1 = false;
        if (r0 != null) goto L8;
    L10:
        if (r1 == false) goto L17;
        Dialog r3 = getDialog();
        if (r3 == null) goto L18;
        r3.cancel();
        return;
    L18:
        return;
    L17:
        return;
    L8:
        if (r0.isShowing() != true) goto L10;
        r1 = true;
        goto L10
    }

    public final void setPanelConfig(Builder r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        setConfig(r2);
    }
}

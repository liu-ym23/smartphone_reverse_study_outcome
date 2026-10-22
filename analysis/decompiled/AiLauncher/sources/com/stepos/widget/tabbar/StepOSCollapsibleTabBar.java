package com.stepos.widget.tabbar;

import Y8.t;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.customview.view.AbsSavedState;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.internal.HotspotRipple;
import com.stepos.widget.tabbar.StepOSCollapsibleTabBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import n9.C4946a;
import v9.C5685n;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b%\b\u0017\u0018\u0000 Ã\u00012\u00020\u0001:\nÄ\u0001Å\u0001Æ\u0001Ç\u0001Ã\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\r2\b\b\u0001\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001d\u001a\u00020\u001c*\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\r2\b\b\u0001\u0010#\u001a\u00020\u0006¢\u0006\u0004\b$\u0010\u0012J\r\u0010%\u001a\u00020\u000b¢\u0006\u0004\b%\u0010&J+\u0010)\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u0015H\u0007¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b+\u0010\u000fJ\u0015\u0010,\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0006¢\u0006\u0004\b,\u0010\u0012J\r\u0010-\u001a\u00020\r¢\u0006\u0004\b-\u0010\u0014J\u0017\u0010.\u001a\u0004\u0018\u00010\u000b2\u0006\u0010'\u001a\u00020\u0006¢\u0006\u0004\b.\u0010/J\u0019\u00100\u001a\u0004\u0018\u00010\u000b2\b\b\u0001\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b0\u0010/J\u0017\u00102\u001a\u00020\r2\b\b\u0001\u00101\u001a\u00020\u0006¢\u0006\u0004\b2\u0010\u0012J\u0017\u00104\u001a\u00020\r2\b\b\u0001\u00103\u001a\u00020\u0006¢\u0006\u0004\b4\u0010\u0012J\u0017\u00106\u001a\u00020\r2\b\b\u0001\u00105\u001a\u00020\u0006¢\u0006\u0004\b6\u0010\u0012J\u001f\u00109\u001a\u00020\r2\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006H\u0014¢\u0006\u0004\b9\u0010:J7\u0010@\u001a\u00020\r2\u0006\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u0006H\u0014¢\u0006\u0004\b@\u0010AJ\u000f\u0010C\u001a\u00020BH\u0014¢\u0006\u0004\bC\u0010DJ\u0019\u0010F\u001a\u00020\r2\b\u0010E\u001a\u0004\u0018\u00010BH\u0014¢\u0006\u0004\bF\u0010GJ\u001d\u0010J\u001a\u00020\r2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020B0HH\u0014¢\u0006\u0004\bJ\u0010KJ\u001d\u0010L\u001a\u00020\r2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020B0HH\u0014¢\u0006\u0004\bL\u0010KJ\u000f\u0010M\u001a\u00020\rH\u0014¢\u0006\u0004\bM\u0010\u0014J)\u0010S\u001a\u00020\r2\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020\u00062\b\u0010R\u001a\u0004\u0018\u00010QH\u0016¢\u0006\u0004\bS\u0010TJ\u0017\u0010V\u001a\u00020\r2\u0006\u0010U\u001a\u00020\u0015H\u0016¢\u0006\u0004\bV\u0010\u0018J\u0017\u0010Y\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\bW\u0010XJ!\u0010\\\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u0010\u001a\u00020\u0006H\u0001¢\u0006\u0004\bZ\u0010[J!\u0010a\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010^\u001a\u0004\u0018\u00010]H\u0001¢\u0006\u0004\b_\u0010`J!\u0010e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010b\u001a\u0004\u0018\u00010\u001cH\u0001¢\u0006\u0004\bc\u0010dJ\u001f\u0010i\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u0015H\u0001¢\u0006\u0004\bg\u0010hJ\u0017\u0010k\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\bj\u0010\u000fJ!\u0010n\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010l\u001a\u00020\u0006H\u0001¢\u0006\u0004\bm\u0010[R$\u0010q\u001a\u0012\u0012\u0004\u0012\u00020\u000b0oj\b\u0012\u0004\u0012\u00020\u000b`p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010t\u001a\u00020s8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010w\u001a\u00020v8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0014\u0010y\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0014\u0010{\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010zR\u0014\u0010|\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010zR\u0014\u0010}\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010zR\u0014\u0010~\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010zR\u0017\u0010\u0080\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0019\u0010\u0082\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0084\u0001\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010zR\u0018\u0010\u0085\u0001\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010zR\u0019\u0010\u0086\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0019\u0010\u0088\u0001\u001a\u00020]8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R1\u0010\u008b\u0001\u001a\u00020\u00152\u0007\u0010\u008a\u0001\u001a\u00020\u00158\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0006\b\u008b\u0001\u0010\u0083\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0005\b\u008d\u0001\u0010\u0018R1\u0010\u008e\u0001\u001a\u00020\u00152\u0007\u0010\u008a\u0001\u001a\u00020\u00158\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0006\b\u008e\u0001\u0010\u0083\u0001\u001a\u0006\b\u008e\u0001\u0010\u008c\u0001\"\u0005\b\u008f\u0001\u0010\u0018R\u0019\u0010\u0090\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0083\u0001R2\u0010\u0091\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u008a\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0016\n\u0005\b\u0091\u0001\u0010z\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0005\b\u0094\u0001\u0010\u0012R,\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R,\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R,\u0010¤\u0001\u001a\u0005\u0018\u00010£\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¤\u0001\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R+\u0010¬\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u008a\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\bª\u0001\u0010\u0093\u0001\"\u0005\b«\u0001\u0010\u0012R)\u0010\u00ad\u0001\u001a\u00020\u00152\u0007\u0010\u008a\u0001\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b\u00ad\u0001\u0010\u008c\u0001\"\u0005\b®\u0001\u0010\u0018R*\u0010³\u0001\u001a\u00020\u001c2\u0007\u0010\u008a\u0001\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R*\u0010¸\u0001\u001a\u00020]2\u0007\u0010\u008a\u0001\u001a\u00020]8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R\u0014\u0010º\u0001\u001a\u00020\u00068F¢\u0006\b\u001a\u0006\b¹\u0001\u0010\u0093\u0001R\u0014\u0010¼\u0001\u001a\u00020\u00068F¢\u0006\b\u001a\u0006\b»\u0001\u0010\u0093\u0001R\u0014\u0010¾\u0001\u001a\u00020\u00068F¢\u0006\b\u001a\u0006\b½\u0001\u0010\u0093\u0001R+\u0010Á\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u008a\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b¿\u0001\u0010\u0093\u0001\"\u0005\bÀ\u0001\u0010\u0012R\u0014\u0010Â\u0001\u001a\u00020\u00158F¢\u0006\b\u001a\u0006\bÂ\u0001\u0010\u008c\u0001¨\u0006È\u0001"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;", "tab", "LY8/t;", "onTabClicked", "(Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;)V", "itemId", "applySelection", "(I)V", "reselectFallback", "()V", "", "announceSelection", "syncStrip", "(Z)V", "visibleCount", "expandedWidthFor", "(I)I", "Landroid/graphics/drawable/Drawable;", "copyForView", "(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "resourceId", "", "resourceName", "(I)Ljava/lang/String;", "menuRes", "inflateMenu", "newTab", "()Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;", "position", "selectNow", "addTab", "(Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;IZ)V", "removeTab", "removeTabAt", "removeAllTabs", "getTabAt", "(I)Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;", "findTabById", "colorRes", "setItemSelectedColorResource", "drawableRes", "setActionIconResource", "stringRes", "setActionContentDescriptionResource", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", VoiceWakeupReceiver.EXTRA_STATE, "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "Landroid/util/SparseArray;", "container", "dispatchSaveInstanceState", "(Landroid/util/SparseArray;)V", "dispatchRestoreInstanceState", "onDetachedFromWindow", "Landroid/view/View;", "child", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", x5.d.EXTRA_ENABLED, "setEnabled", "indexOfTab$StepOSWidget_release", "(Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;)I", "indexOfTab", "validateItemIdChange$StepOSWidget_release", "(Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;I)V", "validateItemIdChange", "", "title", "validateTitleChange$StepOSWidget_release", "(Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;Ljava/lang/CharSequence;)V", "validateTitleChange", "icon", "validateIconChange$StepOSWidget_release", "(Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;Landroid/graphics/drawable/Drawable;)V", "validateIconChange", "visible", "validateVisibilityChange$StepOSWidget_release", "(Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;Z)V", "validateVisibilityChange", "onTabChanged$StepOSWidget_release", "onTabChanged", "oldItemId", "onTabItemIdChanged$StepOSWidget_release", "onTabItemIdChanged", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tabs", "Ljava/util/ArrayList;", "Lcom/stepos/widget/tabbar/StepOSCollapsibleTabStrip;", "tabStrip", "Lcom/stepos/widget/tabbar/StepOSCollapsibleTabStrip;", "Lcom/stepos/widget/tabbar/StepOSCollapsibleActionView;", "actionView", "Lcom/stepos/widget/tabbar/StepOSCollapsibleActionView;", "desiredWidth", "I", "surfaceHeight", "actionSize", "minimumGap", "collapsedStripWidth", "", "expandedStripWidths", "[I", "constructed", "Z", "menuResourceValue", "selectedItemIdValue", "actionIconValue", "Landroid/graphics/drawable/Drawable;", "actionContentDescriptionValue", "Ljava/lang/CharSequence;", UxipConstants.f30680s, "isCollapsed", "()Z", "setCollapsed", "isGlassEnabled", "setGlassEnabled", "pressScaleEnabledValue", "itemSelectedColor", "getItemSelectedColor", "()I", "setItemSelectedColor", "Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar$OnItemSelectedListener;", "onItemSelectedListener", "Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar$OnItemSelectedListener;", "getOnItemSelectedListener", "()Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar$OnItemSelectedListener;", "setOnItemSelectedListener", "(Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar$OnItemSelectedListener;)V", "Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar$OnItemReselectedListener;", "onItemReselectedListener", "Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar$OnItemReselectedListener;", "getOnItemReselectedListener", "()Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar$OnItemReselectedListener;", "setOnItemReselectedListener", "(Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar$OnItemReselectedListener;)V", "Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar$OnActionClickListener;", "onActionClickListener", "Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar$OnActionClickListener;", "getOnActionClickListener", "()Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar$OnActionClickListener;", "setOnActionClickListener", "(Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar$OnActionClickListener;)V", "getMenuResource", "setMenuResource", "menuResource", "isPressScaleEnabled", "setPressScaleEnabled", "getActionIcon", "()Landroid/graphics/drawable/Drawable;", "setActionIcon", "(Landroid/graphics/drawable/Drawable;)V", "actionIcon", "getActionContentDescription", "()Ljava/lang/CharSequence;", "setActionContentDescription", "(Ljava/lang/CharSequence;)V", "actionContentDescription", "getTabCount", "tabCount", "getVisibleTabCount", "visibleTabCount", "getSelectedPosition", "selectedPosition", "getSelectedItemId", "setSelectedItemId", "selectedItemId", "isGlassActive", "Companion", "OnItemSelectedListener", "OnItemReselectedListener", "OnActionClickListener", "SavedState", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSCollapsibleTabBar extends FrameLayout {
    public static final int INVALID_POSITION = -1;
    public static final int MAX_ITEM_COUNT = 4;
    public static final int NO_ID = 0;
    private static final String TAG = "StepOSCollapseTab";
    private CharSequence actionContentDescriptionValue;
    private Drawable actionIconValue;
    private final int actionSize;
    private final StepOSCollapsibleActionView actionView;
    private final int collapsedStripWidth;
    private boolean constructed;
    private final int desiredWidth;
    private final int[] expandedStripWidths;
    private boolean isCollapsed;
    private boolean isGlassEnabled;
    private int itemSelectedColor;
    private int menuResourceValue;
    private final int minimumGap;
    private OnActionClickListener onActionClickListener;
    private OnItemReselectedListener onItemReselectedListener;
    private OnItemSelectedListener onItemSelectedListener;
    private boolean pressScaleEnabledValue;
    private int selectedItemIdValue;
    private final int surfaceHeight;
    private final StepOSCollapsibleTabStrip tabStrip;
    private final ArrayList<StepOSCollapsibleTab> tabs;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar$OnActionClickListener;", "", "Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar;", "tabBar", "LY8/t;", "onActionClick", "(Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnActionClickListener {
        void onActionClick(StepOSCollapsibleTabBar tabBar);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar$OnItemReselectedListener;", "", "Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;", "tab", "LY8/t;", "onItemReselected", "(Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnItemReselectedListener {
        void onItemReselected(StepOSCollapsibleTab tab);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar$OnItemSelectedListener;", "", "onItemSelected", "", "tab", "Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnItemSelectedListener {
        boolean onItemSelected(StepOSCollapsibleTab tab);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0001\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0011\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\f8\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar$SavedState;", "Landroidx/customview/view/AbsSavedState;", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;)V", "Landroid/os/Parcel;", "source", "Ljava/lang/ClassLoader;", "loader", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "out", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "selectedItemId", "I", "getSelectedItemId$StepOSWidget_release", "()I", "setSelectedItemId$StepOSWidget_release", "(I)V", "", "collapsed", "Z", "getCollapsed$StepOSWidget_release", "()Z", "setCollapsed$StepOSWidget_release", "(Z)V", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SavedState extends AbsSavedState {
        private boolean collapsed;
        private int selectedItemId;
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.stepos.widget.tabbar.StepOSCollapsibleTabBar$SavedState$Companion$CREATOR$1
            @Override // android.os.Parcelable.Creator
            public StepOSCollapsibleTabBar.SavedState[] newArray(int size) {
                return new StepOSCollapsibleTabBar.SavedState[size];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public StepOSCollapsibleTabBar.SavedState createFromParcel(Parcel source, ClassLoader loader) {
                kotlin.jvm.internal.p.i(source, "source");
                return new StepOSCollapsibleTabBar.SavedState(source, loader);
            }

            @Override // android.os.Parcelable.Creator
            public StepOSCollapsibleTabBar.SavedState createFromParcel(Parcel source) {
                kotlin.jvm.internal.p.i(source, "source");
                return new StepOSCollapsibleTabBar.SavedState(source, null);
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable superState) {
            super(superState);
            kotlin.jvm.internal.p.i(superState, "superState");
        }

        /* renamed from: getCollapsed$StepOSWidget_release, reason: from getter */
        public final boolean getCollapsed() {
            return this.collapsed;
        }

        /* renamed from: getSelectedItemId$StepOSWidget_release, reason: from getter */
        public final int getSelectedItemId() {
            return this.selectedItemId;
        }

        public final void setCollapsed$StepOSWidget_release(boolean z10) {
            this.collapsed = z10;
        }

        public final void setSelectedItemId$StepOSWidget_release(int i10) {
            this.selectedItemId = i10;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            kotlin.jvm.internal.p.i(out, "out");
            super.writeToParcel(out, flags);
            out.writeInt(this.selectedItemId);
            out.writeInt(this.collapsed ? 1 : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel source, ClassLoader classLoader) {
            super(source, classLoader);
            kotlin.jvm.internal.p.i(source, "source");
            this.selectedItemId = source.readInt();
            this.collapsed = source.readInt() != 0;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSCollapsibleTabBar(Context context) {
        this(context, null, 0, 0, 14, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(StepOSCollapsibleTabBar stepOSCollapsibleTabBar, View view) {
        OnActionClickListener onActionClickListener = stepOSCollapsibleTabBar.onActionClickListener;
        if (onActionClickListener != null) {
            onActionClickListener.onActionClick(stepOSCollapsibleTabBar);
        }
    }

    public static /* synthetic */ void addTab$default(StepOSCollapsibleTabBar stepOSCollapsibleTabBar, StepOSCollapsibleTab stepOSCollapsibleTab, int i10, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addTab");
        }
        if ((i11 & 2) != 0) {
            i10 = stepOSCollapsibleTabBar.getTabCount();
        }
        if ((i11 & 4) != 0) {
            z10 = stepOSCollapsibleTabBar.getTabCount() == 0;
        }
        stepOSCollapsibleTabBar.addTab(stepOSCollapsibleTab, i10, z10);
    }

    private final void applySelection(int itemId) {
        if (itemId == 0) {
            this.selectedItemIdValue = 0;
            syncStrip$default(this, false, 1, null);
            return;
        }
        StepOSCollapsibleTab stepOSCollapsibleTabFindTabById = findTabById(itemId);
        if (stepOSCollapsibleTabFindTabById == null) {
            throw new IllegalArgumentException(("本 StepOSCollapsibleTabBar 不存在 itemId=0x" + Integer.toHexString(itemId)).toString());
        }
        if (!stepOSCollapsibleTabFindTabById.getVisible()) {
            throw new IllegalArgumentException(("目标页签 " + stepOSCollapsibleTabFindTabById + " 当前不可见，无法选中").toString());
        }
        if (stepOSCollapsibleTabFindTabById.getEnabled()) {
            if (this.selectedItemIdValue == itemId) {
                return;
            }
            this.selectedItemIdValue = itemId;
            syncStrip(true);
            return;
        }
        throw new IllegalArgumentException(("目标页签 " + stepOSCollapsibleTabFindTabById + " 当前不可用，无法选中").toString());
    }

    private final Drawable copyForView(Drawable drawable) {
        Drawable drawableNewDrawable;
        Drawable drawableMutate;
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null && (drawableNewDrawable = constantState.newDrawable(getResources())) != null && (drawableMutate = drawableNewDrawable.mutate()) != null) {
            return drawableMutate;
        }
        Drawable drawableMutate2 = drawable.mutate();
        kotlin.jvm.internal.p.h(drawableMutate2, "mutate(...)");
        return drawableMutate2;
    }

    private final int expandedWidthFor(int visibleCount) {
        if (visibleCount <= 0) {
            return this.collapsedStripWidth;
        }
        int[] iArr = this.expandedStripWidths;
        return iArr[C5685n.n(visibleCount - 1, 0, Z8.r.d0(iArr))];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTabClicked(StepOSCollapsibleTab tab) {
        if (isEnabled() && tab.getVisible() && tab.getEnabled()) {
            if (tab.getItemId() == this.selectedItemIdValue) {
                OnItemReselectedListener onItemReselectedListener = this.onItemReselectedListener;
                if (onItemReselectedListener != null) {
                    onItemReselectedListener.onItemReselected(tab);
                    return;
                }
                return;
            }
            OnItemSelectedListener onItemSelectedListener = this.onItemSelectedListener;
            if (onItemSelectedListener != null ? onItemSelectedListener.onItemSelected(tab) : true) {
                applySelection(tab.getItemId());
            }
        }
    }

    private final void reselectFallback() {
        Object next;
        Iterator<T> it = this.tabs.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            StepOSCollapsibleTab stepOSCollapsibleTab = (StepOSCollapsibleTab) next;
            if (stepOSCollapsibleTab.getVisible() && stepOSCollapsibleTab.getEnabled()) {
                break;
            }
        }
        StepOSCollapsibleTab stepOSCollapsibleTab2 = (StepOSCollapsibleTab) next;
        this.selectedItemIdValue = stepOSCollapsibleTab2 != null ? stepOSCollapsibleTab2.getItemId() : 0;
        syncStrip$default(this, false, 1, null);
    }

    private final String resourceName(int resourceId) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(getResources().getResourceName(resourceId));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.e(objB) != null) {
            objB = "0x" + Integer.toHexString(resourceId);
        }
        return (String) objB;
    }

    private final void syncStrip(boolean announceSelection) {
        this.tabStrip.submitTabs$StepOSWidget_release(this.tabs, this.selectedItemIdValue, announceSelection);
        HotspotRipple.INSTANCE.setPressScaleEnabled$StepOSWidget_release(this, this.pressScaleEnabledValue);
        requestLayout();
    }

    public static /* synthetic */ void syncStrip$default(StepOSCollapsibleTabBar stepOSCollapsibleTabBar, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncStrip");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        stepOSCollapsibleTabBar.syncStrip(z10);
    }

    public final void addTab(StepOSCollapsibleTab tab) {
        kotlin.jvm.internal.p.i(tab, "tab");
        addTab$default(this, tab, 0, false, 6, null);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        kotlin.jvm.internal.p.i(child, "child");
        if (this.constructed) {
            throw new IllegalStateException("StepOSCollapsibleTabBar 不接受外部子 View；页签请用 addTab()/inflateMenu()，右侧操作请用 actionIcon/onActionClickListener");
        }
        super.addView(child, index, params);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        kotlin.jvm.internal.p.i(container, "container");
        dispatchThawSelfOnly(container);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        kotlin.jvm.internal.p.i(container, "container");
        dispatchFreezeSelfOnly(container);
    }

    public final StepOSCollapsibleTab findTabById(int itemId) {
        Object next;
        Iterator<T> it = this.tabs.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((StepOSCollapsibleTab) next).getItemId() == itemId) {
                break;
            }
        }
        return (StepOSCollapsibleTab) next;
    }

    /* renamed from: getActionContentDescription, reason: from getter */
    public final CharSequence getActionContentDescriptionValue() {
        return this.actionContentDescriptionValue;
    }

    /* renamed from: getActionIcon, reason: from getter */
    public final Drawable getActionIconValue() {
        return this.actionIconValue;
    }

    public final int getItemSelectedColor() {
        return this.itemSelectedColor;
    }

    /* renamed from: getMenuResource, reason: from getter */
    public final int getMenuResourceValue() {
        return this.menuResourceValue;
    }

    public final OnActionClickListener getOnActionClickListener() {
        return this.onActionClickListener;
    }

    public final OnItemReselectedListener getOnItemReselectedListener() {
        return this.onItemReselectedListener;
    }

    public final OnItemSelectedListener getOnItemSelectedListener() {
        return this.onItemSelectedListener;
    }

    /* renamed from: getSelectedItemId, reason: from getter */
    public final int getSelectedItemIdValue() {
        return this.selectedItemIdValue;
    }

    public final int getSelectedPosition() {
        Iterator<StepOSCollapsibleTab> it = this.tabs.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().getItemId() == this.selectedItemIdValue) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public final StepOSCollapsibleTab getTabAt(int position) {
        return (StepOSCollapsibleTab) F.t0(this.tabs, position);
    }

    public final int getTabCount() {
        return this.tabs.size();
    }

    public final int getVisibleTabCount() {
        ArrayList<StepOSCollapsibleTab> arrayList = this.tabs;
        int i10 = 0;
        if (arrayList != null && arrayList.isEmpty()) {
            return 0;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            if (((StepOSCollapsibleTab) it.next()).getVisible() && (i10 = i10 + 1) < 0) {
                C1173v.v();
            }
        }
        return i10;
    }

    public final int indexOfTab$StepOSWidget_release(StepOSCollapsibleTab tab) {
        kotlin.jvm.internal.p.i(tab, "tab");
        return this.tabs.indexOf(tab);
    }

    public final void inflateMenu(int menuRes) throws Exception {
        StepOSTabMenuParser stepOSTabMenuParser = StepOSTabMenuParser.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        List<ParsedTabMenuItem> list = stepOSTabMenuParser.parse$StepOSWidget_release(context, menuRes);
        if (list.size() > 4) {
            throw new IllegalArgumentException(("StepOSCollapsibleTabBar 最多支持 4 个页签，" + resourceName(menuRes) + " 实际有 " + list.size() + " 个").toString());
        }
        List<ParsedTabMenuItem> list2 = list;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                removeAllTabs();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    addTab((StepOSCollapsibleTab) it2.next(), getTabCount(), false);
                }
                this.menuResourceValue = menuRes;
                reselectFallback();
                return;
            }
            ParsedTabMenuItem parsedTabMenuItem = (ParsedTabMenuItem) it.next();
            CharSequence title = parsedTabMenuItem.getTitle();
            if (title == null || title.length() == 0) {
                throw new IllegalArgumentException((resourceName(menuRes) + " 的 " + resourceName(parsedTabMenuItem.getItemId()) + " 缺少 android:title；新版页签展开态固定显示图标和标签").toString());
            }
            if (parsedTabMenuItem.getIconResId() == 0) {
                throw new IllegalArgumentException((resourceName(menuRes) + " 的 " + resourceName(parsedTabMenuItem.getItemId()) + " 缺少 android:icon；图标同时用于展开态和收缩态").toString());
            }
            arrayList.add(newTab().setItemId(parsedTabMenuItem.getItemId()).setTitle(parsedTabMenuItem.getTitle()).setIcon(parsedTabMenuItem.getIconResId()).setContentDescription(parsedTabMenuItem.getContentDescription()).setVisible(parsedTabMenuItem.getVisible()).setEnabled(parsedTabMenuItem.getEnabled()));
        }
    }

    /* renamed from: isCollapsed, reason: from getter */
    public final boolean getIsCollapsed() {
        return this.isCollapsed;
    }

    public final boolean isGlassActive() {
        return this.tabStrip.isGlassActive$StepOSWidget_release() && this.actionView.isGlassActive$StepOSWidget_release();
    }

    /* renamed from: isGlassEnabled, reason: from getter */
    public final boolean getIsGlassEnabled() {
        return this.isGlassEnabled;
    }

    /* renamed from: isPressScaleEnabled, reason: from getter */
    public final boolean getPressScaleEnabledValue() {
        return this.pressScaleEnabledValue;
    }

    public final StepOSCollapsibleTab newTab() {
        return new StepOSCollapsibleTab(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.onItemSelectedListener = null;
        this.onItemReselectedListener = null;
        this.onActionClickListener = null;
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop() + ((((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.tabStrip.getMeasuredHeight()) / 2);
        if (getLayoutDirection() == 1) {
            StepOSCollapsibleTabStrip stepOSCollapsibleTabStrip = this.tabStrip;
            stepOSCollapsibleTabStrip.layout(width - stepOSCollapsibleTabStrip.getMeasuredWidth(), paddingTop, width, this.tabStrip.getMeasuredHeight() + paddingTop);
            StepOSCollapsibleActionView stepOSCollapsibleActionView = this.actionView;
            stepOSCollapsibleActionView.layout(paddingLeft, paddingTop, stepOSCollapsibleActionView.getMeasuredWidth() + paddingLeft, this.actionView.getMeasuredHeight() + paddingTop);
            return;
        }
        StepOSCollapsibleTabStrip stepOSCollapsibleTabStrip2 = this.tabStrip;
        stepOSCollapsibleTabStrip2.layout(paddingLeft, paddingTop, stepOSCollapsibleTabStrip2.getMeasuredWidth() + paddingLeft, this.tabStrip.getMeasuredHeight() + paddingTop);
        StepOSCollapsibleActionView stepOSCollapsibleActionView2 = this.actionView;
        stepOSCollapsibleActionView2.layout(width - stepOSCollapsibleActionView2.getMeasuredWidth(), paddingTop, width, this.actionView.getMeasuredHeight() + paddingTop);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int paddingStart = this.desiredWidth + getPaddingStart() + getPaddingEnd();
        int paddingTop = this.surfaceHeight + getPaddingTop() + getPaddingBottom();
        int iResolveSize = View.resolveSize(paddingStart, widthMeasureSpec);
        int iResolveSize2 = View.resolveSize(paddingTop, heightMeasureSpec);
        int iF = C5685n.f((iResolveSize - getPaddingStart()) - getPaddingEnd(), 0);
        int iF2 = C5685n.f((iResolveSize2 - getPaddingTop()) - getPaddingBottom(), 0);
        int iMin = Math.min(this.actionSize, iF);
        int iMin2 = Math.min(this.isCollapsed ? this.collapsedStripWidth : expandedWidthFor(getVisibleTabCount()), C5685n.f((iF - iMin) - this.minimumGap, 0));
        if (1 <= iMin2 && iMin2 < this.collapsedStripWidth) {
            Log.w(TAG, "可用宽度只能给左侧页签 " + iMin2 + "px，低于 56dp 设计尺寸；请给 StepOSCollapsibleTabBar 至少 120dp 的内容宽度");
        }
        this.tabStrip.measure(View.MeasureSpec.makeMeasureSpec(iMin2, 1073741824), View.MeasureSpec.makeMeasureSpec(Math.min(this.surfaceHeight, iF2), 1073741824));
        this.actionView.measure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), View.MeasureSpec.makeMeasureSpec(Math.min(this.actionSize, iF2), 1073741824));
        setMeasuredDimension(iResolveSize, iResolveSize2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCollapsed(savedState.getCollapsed());
        StepOSCollapsibleTab stepOSCollapsibleTabFindTabById = findTabById(savedState.getSelectedItemId());
        if (stepOSCollapsibleTabFindTabById == null || !stepOSCollapsibleTabFindTabById.getVisible() || !stepOSCollapsibleTabFindTabById.getEnabled()) {
            reselectFallback();
        } else {
            this.selectedItemIdValue = stepOSCollapsibleTabFindTabById.getItemId();
            syncStrip$default(this, false, 1, null);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = AbsSavedState.EMPTY_STATE;
        }
        kotlin.jvm.internal.p.f(parcelableOnSaveInstanceState);
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.setSelectedItemId$StepOSWidget_release(this.selectedItemIdValue);
        savedState.setCollapsed$StepOSWidget_release(this.isCollapsed);
        return savedState;
    }

    public final void onTabChanged$StepOSWidget_release(StepOSCollapsibleTab tab) {
        kotlin.jvm.internal.p.i(tab, "tab");
        if (this.tabs.contains(tab)) {
            if (tab.getItemId() != this.selectedItemIdValue || (tab.getVisible() && tab.getEnabled())) {
                syncStrip$default(this, false, 1, null);
            } else {
                reselectFallback();
            }
        }
    }

    public final void onTabItemIdChanged$StepOSWidget_release(StepOSCollapsibleTab tab, int oldItemId) {
        kotlin.jvm.internal.p.i(tab, "tab");
        if (this.tabs.contains(tab) && this.selectedItemIdValue == oldItemId) {
            this.selectedItemIdValue = tab.getItemId();
        }
        syncStrip$default(this, false, 1, null);
    }

    public final void removeAllTabs() {
        Iterator<T> it = this.tabs.iterator();
        while (it.hasNext()) {
            ((StepOSCollapsibleTab) it.next()).detach$StepOSWidget_release();
        }
        this.tabs.clear();
        this.selectedItemIdValue = 0;
        this.menuResourceValue = 0;
        syncStrip$default(this, false, 1, null);
    }

    public final void removeTab(StepOSCollapsibleTab tab) {
        kotlin.jvm.internal.p.i(tab, "tab");
        if (tab.getTabBar() != this || !this.tabs.contains(tab)) {
            throw new IllegalArgumentException("tab 不在本 StepOSCollapsibleTabBar 中，无法移除");
        }
        removeTabAt(this.tabs.indexOf(tab));
    }

    public final void removeTabAt(int position) {
        if (position < 0 || position >= this.tabs.size()) {
            throw new IllegalArgumentException(("position must be in 0.." + (this.tabs.size() - 1) + " but was " + position).toString());
        }
        StepOSCollapsibleTab stepOSCollapsibleTabRemove = this.tabs.remove(position);
        kotlin.jvm.internal.p.h(stepOSCollapsibleTabRemove, "removeAt(...)");
        StepOSCollapsibleTab stepOSCollapsibleTab = stepOSCollapsibleTabRemove;
        boolean z10 = stepOSCollapsibleTab.getItemId() == this.selectedItemIdValue;
        stepOSCollapsibleTab.detach$StepOSWidget_release();
        this.menuResourceValue = 0;
        if (z10) {
            reselectFallback();
        } else {
            syncStrip$default(this, false, 1, null);
        }
    }

    public final void setActionContentDescription(CharSequence value) {
        kotlin.jvm.internal.p.i(value, "value");
        if (value.length() <= 0) {
            throw new IllegalArgumentException("actionContentDescription 不能为空；所有图标操作项必须有无障碍文案");
        }
        this.actionContentDescriptionValue = value;
        this.actionView.setContentDescription(value);
    }

    public final void setActionContentDescriptionResource(int stringRes) {
        if (stringRes == 0) {
            throw new IllegalArgumentException("stringRes 不能为 0，请传一个有效的 @string 资源 id");
        }
        setActionContentDescription(getResources().getText(stringRes));
    }

    public final void setActionIcon(Drawable value) {
        kotlin.jvm.internal.p.i(value, "value");
        Drawable drawableCopyForView = copyForView(value);
        this.actionIconValue = drawableCopyForView;
        this.actionView.setIcon$StepOSWidget_release(drawableCopyForView);
    }

    public final void setActionIconResource(int drawableRes) {
        if (drawableRes == 0) {
            throw new IllegalArgumentException("drawableRes 不能为 0，请传一个有效的 @drawable 资源 id");
        }
        Drawable drawableE = androidx.core.content.a.e(getContext(), drawableRes);
        if (drawableE != null) {
            setActionIcon(drawableE);
            return;
        }
        throw new IllegalArgumentException(("找不到 drawable 资源 0x" + Integer.toHexString(drawableRes)).toString());
    }

    public final void setCollapsed(boolean z10) {
        if (this.isCollapsed == z10) {
            return;
        }
        this.isCollapsed = z10;
        this.tabStrip.setCollapsed$StepOSWidget_release(z10);
        requestLayout();
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (this.constructed) {
            this.tabStrip.applyHostEnabled$StepOSWidget_release(enabled);
            this.actionView.setEnabled(enabled);
        }
    }

    public final void setGlassEnabled(boolean z10) {
        if (this.isGlassEnabled == z10) {
            return;
        }
        this.isGlassEnabled = z10;
        this.tabStrip.applyGlassEnabled$StepOSWidget_release(z10);
        this.actionView.setGlassEnabled$StepOSWidget_release(z10);
    }

    public final void setItemSelectedColor(int i10) {
        if (this.itemSelectedColor == i10) {
            return;
        }
        this.itemSelectedColor = i10;
        this.tabStrip.setSelectedColor$StepOSWidget_release(i10);
    }

    public final void setItemSelectedColorResource(int colorRes) {
        if (colorRes == 0) {
            throw new IllegalArgumentException("colorRes 不能为 0，请传一个有效的 @color 资源 id");
        }
        setItemSelectedColor(androidx.core.content.a.c(getContext(), colorRes));
    }

    public final void setMenuResource(int i10) throws Exception {
        if (i10 == 0) {
            removeAllTabs();
        } else {
            inflateMenu(i10);
        }
    }

    public final void setOnActionClickListener(OnActionClickListener onActionClickListener) {
        this.onActionClickListener = onActionClickListener;
    }

    public final void setOnItemReselectedListener(OnItemReselectedListener onItemReselectedListener) {
        this.onItemReselectedListener = onItemReselectedListener;
    }

    public final void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    public final void setPressScaleEnabled(boolean z10) {
        if (this.pressScaleEnabledValue == z10) {
            return;
        }
        this.pressScaleEnabledValue = z10;
        HotspotRipple.INSTANCE.setPressScaleEnabled$StepOSWidget_release(this, z10);
    }

    public final void setSelectedItemId(int i10) {
        applySelection(i10);
    }

    public final void validateIconChange$StepOSWidget_release(StepOSCollapsibleTab tab, Drawable icon) {
        kotlin.jvm.internal.p.i(tab, "tab");
        if (this.tabs.contains(tab) && icon == null) {
            throw new IllegalArgumentException("已加入 StepOSCollapsibleTabBar 的页签不能清空 icon；图标同时用于收缩态");
        }
    }

    public final void validateItemIdChange$StepOSWidget_release(StepOSCollapsibleTab tab, int itemId) {
        Object next;
        kotlin.jvm.internal.p.i(tab, "tab");
        if (this.tabs.contains(tab)) {
            Iterator<T> it = this.tabs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                StepOSCollapsibleTab stepOSCollapsibleTab = (StepOSCollapsibleTab) next;
                if (stepOSCollapsibleTab != tab && stepOSCollapsibleTab.getItemId() == itemId) {
                    break;
                }
            }
            if (((StepOSCollapsibleTab) next) == null) {
                return;
            }
            throw new IllegalArgumentException(("itemId 重复：本 StepOSCollapsibleTabBar 已有 0x" + Integer.toHexString(itemId)).toString());
        }
    }

    public final void validateTitleChange$StepOSWidget_release(StepOSCollapsibleTab tab, CharSequence title) {
        kotlin.jvm.internal.p.i(tab, "tab");
        if (this.tabs.contains(tab)) {
            if (title == null || title.length() == 0) {
                throw new IllegalArgumentException("已加入 StepOSCollapsibleTabBar 的页签不能清空 title；展开态固定显示标签");
            }
        }
    }

    public final void validateVisibilityChange$StepOSWidget_release(StepOSCollapsibleTab tab, boolean visible) {
        kotlin.jvm.internal.p.i(tab, "tab");
        if (!this.tabs.contains(tab) || !visible || tab.getVisible() || getVisibleTabCount() < 4) {
            return;
        }
        throw new IllegalArgumentException(("可见页签最多 4 个，不能再显示 " + tab).toString());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSCollapsibleTabBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final void addTab(StepOSCollapsibleTab tab, int i10) {
        kotlin.jvm.internal.p.i(tab, "tab");
        addTab$default(this, tab, i10, false, 4, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSCollapsibleTabBar(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final void addTab(StepOSCollapsibleTab tab, int position, boolean selectNow) {
        kotlin.jvm.internal.p.i(tab, "tab");
        if (tab.getTabBar() != null && tab.getTabBar() != this) {
            throw new IllegalArgumentException("tab 属于另一个 StepOSCollapsibleTabBar，不能跨控件直接添加");
        }
        if (!this.tabs.contains(tab)) {
            if (this.tabs.size() < 4) {
                if (position >= 0 && position <= this.tabs.size()) {
                    if (tab.getItemId() != 0) {
                        if (findTabById(tab.getItemId()) == null) {
                            CharSequence title = tab.getTitle();
                            if (!(title == null || title.length() == 0)) {
                                if (tab.getIconValue() != null) {
                                    if (selectNow && (!tab.getVisible() || !tab.getEnabled())) {
                                        throw new IllegalArgumentException("selectNow=true 时页签必须可见且可用");
                                    }
                                    this.tabs.add(position, tab);
                                    tab.attachTo$StepOSWidget_release(this);
                                    this.menuResourceValue = 0;
                                    if (selectNow) {
                                        this.selectedItemIdValue = tab.getItemId();
                                    }
                                    syncStrip$default(this, false, 1, null);
                                    return;
                                }
                                throw new IllegalArgumentException("addTab 之前必须先 setIcon(...)；图标同时用于展开态和收缩态");
                            }
                            throw new IllegalArgumentException("addTab 之前必须先 setTitle(...)；新版页签展开态固定显示标签");
                        }
                        throw new IllegalArgumentException(("itemId 重复：0x" + Integer.toHexString(tab.getItemId())).toString());
                    }
                    throw new IllegalArgumentException("addTab 之前必须先 setItemId(...)");
                }
                throw new IllegalArgumentException(("position must be in 0.." + this.tabs.size() + " but was " + position).toString());
            }
            throw new IllegalArgumentException("StepOSCollapsibleTabBar 最多支持 4 个页签");
        }
        throw new IllegalArgumentException("tab 已经加入本 StepOSCollapsibleTabBar，不能重复添加");
    }

    public /* synthetic */ StepOSCollapsibleTabBar(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposCollapsibleTabBarStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_CollapsibleTabBar : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSCollapsibleTabBar(Context context, AttributeSet attributeSet, int i10, int i11) throws Exception {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.p.i(context, "context");
        this.tabs = new ArrayList<>(4);
        StepOSCollapsibleTabStrip stepOSCollapsibleTabStrip = new StepOSCollapsibleTabStrip(context, new StepOSCollapsibleTabBar$tabStrip$1(this));
        this.tabStrip = stepOSCollapsibleTabStrip;
        StepOSCollapsibleActionView stepOSCollapsibleActionView = new StepOSCollapsibleActionView(context);
        this.actionView = stepOSCollapsibleActionView;
        this.desiredWidth = getResources().getDimensionPixelSize(R.dimen.stepos_collapsible_tabbar_width);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_collapsible_tabbar_height);
        this.surfaceHeight = dimensionPixelSize;
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.stepos_collapsible_tabbar_action_size);
        this.actionSize = dimensionPixelSize2;
        this.minimumGap = getResources().getDimensionPixelSize(R.dimen.stepos_collapsible_tabbar_minimum_gap);
        this.collapsedStripWidth = getResources().getDimensionPixelSize(R.dimen.stepos_collapsible_tabbar_strip_width_collapsed);
        this.expandedStripWidths = new int[]{getResources().getDimensionPixelSize(R.dimen.stepos_collapsible_tabbar_strip_width_one), getResources().getDimensionPixelSize(R.dimen.stepos_collapsible_tabbar_strip_width_two), getResources().getDimensionPixelSize(R.dimen.stepos_collapsible_tabbar_strip_width_three), getResources().getDimensionPixelSize(R.dimen.stepos_collapsible_tabbar_strip_width_four)};
        Drawable drawableE = androidx.core.content.a.e(context, R.drawable.stepos_icon_search);
        if (drawableE != null) {
            this.actionIconValue = drawableE;
            Resources resources = getResources();
            int i12 = R.string.stepos_collapsible_tabbar_default_action_content_description;
            CharSequence text = resources.getText(i12);
            kotlin.jvm.internal.p.h(text, "getText(...)");
            this.actionContentDescriptionValue = text;
            this.isGlassEnabled = true;
            this.pressScaleEnabledValue = true;
            int i13 = R.color.stepos_collapsible_tabbar_item_selected;
            this.itemSelectedColor = androidx.core.content.a.c(context, i13);
            setClipChildren(false);
            setClipToPadding(false);
            setImportantForAccessibility(2);
            super.addView(stepOSCollapsibleTabStrip, new FrameLayout.LayoutParams(-2, dimensionPixelSize));
            super.addView(stepOSCollapsibleActionView, new FrameLayout.LayoutParams(dimensionPixelSize2, dimensionPixelSize2));
            stepOSCollapsibleActionView.setIconTint$StepOSWidget_release(ColorStateList.valueOf(androidx.core.content.a.c(context, R.color.stepos_collapsible_tabbar_action_icon)));
            stepOSCollapsibleActionView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.tabbar.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StepOSCollapsibleTabBar._init_$lambda$3(this.f31363a, view);
                }
            });
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSCollapsibleTabBar, i10, i11);
            try {
                setGlassEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSCollapsibleTabBar_steposGlassEnabled, true));
                setCollapsed(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSCollapsibleTabBar_steposCollapsibleTabBarCollapsed, false));
                setItemSelectedColor(typedArrayObtainStyledAttributes.getColor(R.styleable.StepOSCollapsibleTabBar_steposCollapsibleTabBarItemSelectedColor, androidx.core.content.a.c(context, i13)));
                Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.StepOSCollapsibleTabBar_steposCollapsibleTabBarActionIcon);
                setActionIcon(drawable == null ? this.actionIconValue : drawable);
                CharSequence text2 = typedArrayObtainStyledAttributes.getText(R.styleable.StepOSCollapsibleTabBar_steposCollapsibleTabBarActionContentDescription);
                if (text2 == null) {
                    text2 = getResources().getText(i12);
                    kotlin.jvm.internal.p.h(text2, "getText(...)");
                }
                setActionContentDescription(text2);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSCollapsibleTabBar_steposCollapsibleTabBarMenu, 0);
                this.pressScaleEnabledValue = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSCollapsibleTabBar_steposPressScaleEnabled, true);
                t tVar = t.f7040a;
                C4946a.a(typedArrayObtainStyledAttributes, null);
                stepOSCollapsibleTabStrip.setCollapsed$StepOSWidget_release(this.isCollapsed);
                stepOSCollapsibleTabStrip.applyGlassEnabled$StepOSWidget_release(this.isGlassEnabled);
                stepOSCollapsibleTabStrip.setSelectedColor$StepOSWidget_release(this.itemSelectedColor);
                stepOSCollapsibleTabStrip.applyHostEnabled$StepOSWidget_release(isEnabled());
                stepOSCollapsibleActionView.setGlassEnabled$StepOSWidget_release(this.isGlassEnabled);
                stepOSCollapsibleActionView.setEnabled(isEnabled());
                this.constructed = true;
                HotspotRipple.INSTANCE.setPressScaleEnabled$StepOSWidget_release(this, this.pressScaleEnabledValue);
                if (resourceId != 0) {
                    inflateMenu(resourceId);
                    return;
                }
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    C4946a.a(typedArrayObtainStyledAttributes, th);
                    throw th2;
                }
            }
        }
        throw new IllegalArgumentException("Required value was null.");
    }
}

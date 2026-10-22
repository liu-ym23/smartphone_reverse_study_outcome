package com.obric.oui.popover.menu;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewGroupKt;
import com.GlobalProxyLancet;
import com.android.contacts.common.dialog.CallSubjectDialog;
import com.android.vcard.VCardConfig;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.bytedance.apm.battery.dao.DBHelper;
import com.google.android.material.internal.ViewUtils;
import com.obric.common.oui.R;
import com.obric.oui.badge.OBadgeView;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.widget.MaxHeightNestedScrollView;
import com.obric.oui.divider.ODivider;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.popover.view.CheckableImageView;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.sheet.v2.OSheetBaseKt;
import com.obric.oui.text.OTextView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 ?2\u00020\u0001:\u0004>?@AB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010)\u001a\u00020\u0016H\u0002J\u0018\u0010*\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020+2\u0006\u0010,\u001a\u00020\"H\u0002J\b\u0010-\u001a\u00020\u0016H\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010\u001b2\u0006\u0010/\u001a\u00020\u0007H\u0002J\b\u00100\u001a\u00020\u0007H\u0002J\u0010\u00101\u001a\u0004\u0018\u00010+2\u0006\u0010/\u001a\u00020\u0007J\b\u00102\u001a\u00020\u0016H\u0002J0\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\"2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0014J\u0018\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0007H\u0014J\u0016\u0010<\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\"J\u0010\u0010=\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0007H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView;", "Lcom/obric/oui/popover/menu/OPopoverMenuView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomView", "Landroid/view/View;", "bottomViewHeight", "defaultMaxHeight", "imgGetter", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "isOption", "itemHeight", "itemLayoutProcess", "Lkotlin/ParameterName;", "name", "itemView", "", "itemVerticalMargin", "itemWidth", "items", "Ljava/util/ArrayList;", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$PopoverItem;", "Lkotlin/collections/ArrayList;", "maxHeight", "popOverScroll", "Lcom/obric/oui/common/widget/MaxHeightNestedScrollView;", "tailImgGetter", "titleSingleLine", "", "topDividerVisibility", "topView", "topViewHeight", "verticalPadding", "widthConstraint", "Lkotlin/Pair;", "addPopoverItems", "applyItemEnabledState", "Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout;", "enabled", "clearViews", "findItemByPosition", "position", "getAvailableItemWidth", "getItemView", "initView", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setItemEnabled", "setPopoverMaxHeight", "Builder", "Companion", "PopoverItem", "WidthLevel", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverEntranceMenuView extends OPopoverMenuView {
    public static final Companion Companion = null;
    private static final float DISABLED_ALPHA = 0.3f;
    private static final int MAX_LINES = 0;
    private static final int MIN_AVAILABLE_HEIGHT_DP = 0;
    private static final String TAG = "OPopoverEntranceMenuView";
    private static final int WIDTH_BROAD_DP = 0;
    private static final int WIDTH_STANDARD_DP = 0;
    private View bottomView;
    private int bottomViewHeight;
    private final int defaultMaxHeight;
    private Function1<? super Integer, ? extends Drawable> imgGetter;
    private int isOption;
    private int itemHeight;
    private Function1<? super View, Unit> itemLayoutProcess;
    private final int itemVerticalMargin;
    private int itemWidth;
    private ArrayList<PopoverItem> items;
    private int maxHeight;
    private MaxHeightNestedScrollView popOverScroll;
    private Function1<? super Integer, ? extends Drawable> tailImgGetter;
    private boolean titleSingleLine;
    private boolean topDividerVisibility;
    private View topView;
    private int topViewHeight;
    private final int verticalPadding;
    private Pair<Integer, Integer> widthConstraint;

    /* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
    @Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010)\u001a\u00020\u001b2\b\u0010*\u001a\u0004\u0018\u00010\u0006J±\u0001\u0010+\u001a\u00020\u00002\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\b\b\u0001\u00106\u001a\u00020\b2:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010:JÇ\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010<\u001a\u00020\r2\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\r2\n\b\u0003\u00106\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\n\b\u0002\u00104\u001a\u0004\u0018\u0001052:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010>J[\u0010?\u001a\u00020\u00002\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\b2\b\u0010/\u001a\u0004\u0018\u00010028\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108¢\u0006\u0002\u0010@J\u0006\u0010A\u001a\u00020\u001bJ§\u0001\u0010B\u001a\u00020\u00002\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\n\b\u0003\u00106\u001a\u0004\u0018\u00010\b2:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010CJ³\u0001\u0010D\u001a\u00020\u00002\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\n\b\u0003\u00106\u001a\u0004\u0018\u00010\b2:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010EJÇ\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010G\u001a\u00020\b2\b\b\u0002\u0010<\u001a\u00020\r2\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\n\b\u0003\u00106\u001a\u0004\u0018\u00010\b2:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0002¢\u0006\u0002\u0010HJ§\u0001\u0010F\u001a\u00020\u00002\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010IJ\u008f\u0001\u0010J\u001a\u00020\u00002\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010KJ\u009b\u0001\u0010L\u001a\u00020\u00002\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010MJ£\u0001\u0010N\u001a\u00020\u00002\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\b\b\u0002\u0010<\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\r2:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010OJ£\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010<\u001a\u00020\r2\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\r2:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010QJ\u000e\u0010R\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020SJ»\u0001\u0010T\u001a\u00020\u00002\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\b\b\u0002\u0010<\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\r2\n\b\u0003\u00106\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\n\b\u0002\u00104\u001a\u0004\u0018\u0001052:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010UJÇ\u0001\u0010V\u001a\u00020\u00002\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\b\b\u0002\u0010<\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\r2\n\b\u0003\u00106\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\n\b\u0002\u00104\u001a\u0004\u0018\u0001052:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010WJ\u0010\u0010X\u001a\u00020\u001b2\b\u0010*\u001a\u0004\u0018\u00010\u0006J\u0006\u0010Y\u001a\u00020ZJ\u0006\u0010[\u001a\u00020\u001bJ\u0006\u0010\\\u001a\u00020\u001bJ\u000e\u0010\f\u001a\u00020\u001b2\u0006\u0010]\u001a\u00020\rJ\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010^\u001a\u00020\rJ\u000e\u0010_\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010`\u001a\u00020\u001b2\u0016\u0010a\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013J\u0010\u0010b\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\bH\u0007J)\u0010c\u001a\u00020\u00002!\u0010d\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0013J\u000e\u0010e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bJ\u0018\u0010f\u001a\u00020\u001b2\u0006\u0010g\u001a\u00020\b2\u0006\u0010h\u001a\u00020\bH\u0007J\u000e\u0010i\u001a\u00020\u00002\u0006\u0010j\u001a\u00020\bJ\u001e\u0010k\u001a\u00020\u001b2\u0016\u0010a\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013J\u000e\u0010l\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\rJ\u000e\u0010m\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\rJ\u000e\u0010n\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\bJ\u000e\u0010o\u001a\u00020\u00002\u0006\u0010p\u001a\u00020qR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomView", "Landroid/view/View;", "bottomViewHeight", "", "getContext", "()Landroid/content/Context;", "setContext", "forceDark", "", "getForceDark", "()Z", "setForceDark", "(Z)V", "imgGetter", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "isOption", "itemHeight", "itemLayoutProcess", "Lkotlin/ParameterName;", "name", "itemView", "", "itemWidth", "popoverItems", "Ljava/util/ArrayList;", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$PopoverItem;", "Lkotlin/collections/ArrayList;", "pressedWithArrow", "tailImgGetter", "titleSingleLine", "topDividerVisibility", "topView", "topViewHeight", "widthConstraint", "Lkotlin/Pair;", "addBottomView", "view", "addCustomTitleColorPopoverItem", "imageRes", "tailImageRes", "resTint", "title", "", "subTitle", "value", "isHighlighted", "badgeInfo", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;", "titleColor", "onClick", "Lkotlin/Function2;", "pos", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;ILkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addEndOptionItem", "enableCheckable", MaterialConfigFormatNames.CHECKED, "(ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLjava/lang/Integer;Ljava/lang/CharSequence;Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Lkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addHighlightPopoverItem", "(Ljava/lang/Integer;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addItemDivider", "addNormalEntryItem", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Ljava/lang/Integer;Lkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addNormalItem", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Ljava/lang/Integer;Lkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addPopoverItem", "optionPos", "(IZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Ljava/lang/Integer;Lkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Lkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addPopoverItemWithArrow", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addPopoverItemWithBadge", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Lkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addPopoverLeftOptionItem", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZZLkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addPopoverRightOptionItem", "(ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addSectionTitle", "", "addStartOptionEntryItem", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZZLjava/lang/Integer;Ljava/lang/CharSequence;Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Lkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addStartOptionItem", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZZLjava/lang/Integer;Ljava/lang/CharSequence;Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Lkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addTopView", "build", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView;", "enableMultiOption", "enableOption", "isDark", "enable", "setBottomViewHeight", "setImgGetter", "getter", "setItemHeight", "setItemLayoutProcess", DBHelper.BATTERY_COL_PROCESS_NAME, "setItemWidth", "setItemWidthConstraint", "minWidth", "maxWidth", "setMenuWidth", "menuWidth", "setTailImgGetter", "setTitleSingleLine", "setTopDividerVisibility", "setTopViewHeight", "setWidthLevel", "level", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$WidthLevel;", "BadgeInfo", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private View bottomView;
        private int bottomViewHeight;
        private Context context;
        private boolean forceDark;
        private Function1<? super Integer, ? extends Drawable> imgGetter;
        private int isOption;
        private int itemHeight;
        private Function1<? super View, Unit> itemLayoutProcess;
        private int itemWidth;
        private ArrayList<PopoverItem> popoverItems;
        private boolean pressedWithArrow;
        private Function1<? super Integer, ? extends Drawable> tailImgGetter;
        private boolean titleSingleLine;
        private boolean topDividerVisibility;
        private View topView;
        private int topViewHeight;
        private Pair<Integer, Integer> widthConstraint;

        /* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0012B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;", "", "badgeType", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo$Style;", "count", "", "maxNumber", "(Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo$Style;II)V", "getBadgeType", "()Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo$Style;", "setBadgeType", "(Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo$Style;)V", "getCount", "()I", "setCount", "(I)V", "getMaxNumber", "setMaxNumber", "Style", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class BadgeInfo {
            private Style badgeType;
            private int count;
            private int maxNumber;

            /* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo$Style;", "", "(Ljava/lang/String;I)V", "DOT", CallSubjectDialog.ARG_NUMBER, "ELLIPSIS", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
            public static final enum Style extends Enum<Style> {
                private static final /* synthetic */ Style[] $VALUES = null;
                public static final Style DOT = null;
                public static final Style ELLIPSIS = null;
                public static final Style NUMBER = null;

                private static final /* synthetic */ Style[] $values() {
                    return new Style[]{DOT, NUMBER, ELLIPSIS};
                }

                public static Style valueOf(String r1) {
                    return (Style) Enum.valueOf(Style.class, r1);
                }

                public static Style[] values() {
                    return (Style[]) $VALUES.clone();
                }

                private Style(String r1, int r2) {
                    super(r1, r2);
                }

                static {
                    DOT = new Style("DOT", 0);
                    NUMBER = new Style(CallSubjectDialog.ARG_NUMBER, 1);
                    ELLIPSIS = new Style("ELLIPSIS", 2);
                    $VALUES = $values();
                }
            }

            public BadgeInfo() {
                this(null, 0, 0, 7, null);
            }

            public BadgeInfo(Style r2, int r3, int r4) {
                Intrinsics.checkNotNullParameter(r2, "badgeType");
                this.badgeType = r2;
                this.count = r3;
                this.maxNumber = r4;
            }

            public /* synthetic */ BadgeInfo(Style r1, int r2, int r3, int r4, DefaultConstructorMarker r5) {
                if ((r4 & 1) == 0) goto L6;
                r1 = Style.DOT;
            L6:
                if ((r4 & 2) == 0) goto L9;
                r2 = 0;
            L9:
                if ((r4 & 4) == 0) goto L11;
                r3 = OBadgeView.Companion.getMAX_COUNT();
            L11:
                this(r1, r2, r3);
            }

            public final Style getBadgeType() {
                return this.badgeType;
            }

            public final void setBadgeType(Style r2) {
                Intrinsics.checkNotNullParameter(r2, "<set-?>");
                this.badgeType = r2;
            }

            public final int getCount() {
                return this.count;
            }

            public final void setCount(int r1) {
                this.count = r1;
            }

            public final int getMaxNumber() {
                return this.maxNumber;
            }

            public final void setMaxNumber(int r1) {
                this.maxNumber = r1;
            }
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addCustomTitleColorPopoverItem(int r14) {
            return addCustomTitleColorPopoverItem$default(this, null, null, null, null, null, null, false, null, r14, null, 767, null);
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addCustomTitleColorPopoverItem(Integer r14, int r15) {
            return addCustomTitleColorPopoverItem$default(this, r14, null, null, null, null, null, false, null, r15, null, 766, null);
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addCustomTitleColorPopoverItem(Integer r14, Integer r15, int r16) {
            return addCustomTitleColorPopoverItem$default(this, r14, r15, null, null, null, null, false, null, r16, null, 764, null);
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addCustomTitleColorPopoverItem(Integer r14, Integer r15, Integer r16, int r17) {
            return addCustomTitleColorPopoverItem$default(this, r14, r15, r16, null, null, null, false, null, r17, null, 760, null);
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addCustomTitleColorPopoverItem(Integer r14, Integer r15, Integer r16, CharSequence r17, int r18) {
            return addCustomTitleColorPopoverItem$default(this, r14, r15, r16, r17, null, null, false, null, r18, null, 752, null);
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addCustomTitleColorPopoverItem(Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18, int r19) {
            return addCustomTitleColorPopoverItem$default(this, r14, r15, r16, r17, r18, null, false, null, r19, null, 736, null);
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addCustomTitleColorPopoverItem(Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18, CharSequence r19, int r20) {
            return addCustomTitleColorPopoverItem$default(this, r14, r15, r16, r17, r18, r19, false, null, r20, null, 704, null);
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addCustomTitleColorPopoverItem(Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18, CharSequence r19, boolean r20, int r21) {
            return addCustomTitleColorPopoverItem$default(this, r14, r15, r16, r17, r18, r19, r20, null, r21, null, 640, null);
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addCustomTitleColorPopoverItem(Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18, CharSequence r19, boolean r20, BadgeInfo r21, int r22) {
            return addCustomTitleColorPopoverItem$default(this, r14, r15, r16, r17, r18, r19, r20, r21, r22, null, 512, null);
        }

        public final Builder addEndOptionItem() {
            return addEndOptionItem$default(this, false, null, null, null, null, null, false, false, null, null, null, null, 4095, null);
        }

        public final Builder addEndOptionItem(boolean r16) {
            return addEndOptionItem$default(this, r16, null, null, null, null, null, false, false, null, null, null, null, 4094, null);
        }

        public final Builder addEndOptionItem(boolean r16, Integer r17) {
            return addEndOptionItem$default(this, r16, r17, null, null, null, null, false, false, null, null, null, null, 4092, null);
        }

        public final Builder addEndOptionItem(boolean r16, Integer r17, Integer r18) {
            return addEndOptionItem$default(this, r16, r17, r18, null, null, null, false, false, null, null, null, null, 4088, null);
        }

        public final Builder addEndOptionItem(boolean r16, Integer r17, Integer r18, Integer r19) {
            return addEndOptionItem$default(this, r16, r17, r18, r19, null, null, false, false, null, null, null, null, 4080, null);
        }

        public final Builder addEndOptionItem(boolean r16, Integer r17, Integer r18, Integer r19, CharSequence r20) {
            return addEndOptionItem$default(this, r16, r17, r18, r19, r20, null, false, false, null, null, null, null, 4064, null);
        }

        public final Builder addEndOptionItem(boolean r16, Integer r17, Integer r18, Integer r19, CharSequence r20, CharSequence r21) {
            return addEndOptionItem$default(this, r16, r17, r18, r19, r20, r21, false, false, null, null, null, null, 4032, null);
        }

        public final Builder addEndOptionItem(boolean r16, Integer r17, Integer r18, Integer r19, CharSequence r20, CharSequence r21, boolean r22) {
            return addEndOptionItem$default(this, r16, r17, r18, r19, r20, r21, r22, false, null, null, null, null, 3968, null);
        }

        public final Builder addEndOptionItem(boolean r16, Integer r17, Integer r18, Integer r19, CharSequence r20, CharSequence r21, boolean r22, boolean r23) {
            return addEndOptionItem$default(this, r16, r17, r18, r19, r20, r21, r22, r23, null, null, null, null, 3840, null);
        }

        public final Builder addEndOptionItem(boolean r16, Integer r17, Integer r18, Integer r19, CharSequence r20, CharSequence r21, boolean r22, boolean r23, Integer r24) {
            return addEndOptionItem$default(this, r16, r17, r18, r19, r20, r21, r22, r23, r24, null, null, null, 3584, null);
        }

        public final Builder addEndOptionItem(boolean r16, Integer r17, Integer r18, Integer r19, CharSequence r20, CharSequence r21, boolean r22, boolean r23, Integer r24, CharSequence r25) {
            return addEndOptionItem$default(this, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, null, null, 3072, null);
        }

        public final Builder addEndOptionItem(boolean r16, Integer r17, Integer r18, Integer r19, CharSequence r20, CharSequence r21, boolean r22, boolean r23, Integer r24, CharSequence r25, BadgeInfo r26) {
            return addEndOptionItem$default(this, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, null, 2048, null);
        }

        public final Builder addNormalEntryItem() {
            return addNormalEntryItem$default(this, null, null, null, null, null, false, null, null, null, 511, null);
        }

        public final Builder addNormalEntryItem(Integer r13) {
            return addNormalEntryItem$default(this, r13, null, null, null, null, false, null, null, null, 510, null);
        }

        public final Builder addNormalEntryItem(Integer r13, Integer r14) {
            return addNormalEntryItem$default(this, r13, r14, null, null, null, false, null, null, null, 508, null);
        }

        public final Builder addNormalEntryItem(Integer r13, Integer r14, CharSequence r15) {
            return addNormalEntryItem$default(this, r13, r14, r15, null, null, false, null, null, null, 504, null);
        }

        public final Builder addNormalEntryItem(Integer r13, Integer r14, CharSequence r15, CharSequence r16) {
            return addNormalEntryItem$default(this, r13, r14, r15, r16, null, false, null, null, null, 496, null);
        }

        public final Builder addNormalEntryItem(Integer r13, Integer r14, CharSequence r15, CharSequence r16, CharSequence r17) {
            return addNormalEntryItem$default(this, r13, r14, r15, r16, r17, false, null, null, null, OSheetBaseKt.SHEET_LANDSCAPE_MAX_WIDTH, null);
        }

        public final Builder addNormalEntryItem(Integer r13, Integer r14, CharSequence r15, CharSequence r16, CharSequence r17, boolean r18) {
            return addNormalEntryItem$default(this, r13, r14, r15, r16, r17, r18, null, null, null, 448, null);
        }

        public final Builder addNormalEntryItem(Integer r13, Integer r14, CharSequence r15, CharSequence r16, CharSequence r17, boolean r18, BadgeInfo r19) {
            return addNormalEntryItem$default(this, r13, r14, r15, r16, r17, r18, r19, null, null, 384, null);
        }

        public final Builder addNormalEntryItem(Integer r13, Integer r14, CharSequence r15, CharSequence r16, CharSequence r17, boolean r18, BadgeInfo r19, Integer r20) {
            return addNormalEntryItem$default(this, r13, r14, r15, r16, r17, r18, r19, r20, null, 256, null);
        }

        public final Builder addNormalItem() {
            return addNormalItem$default(this, null, null, null, null, null, null, false, null, null, null, 1023, null);
        }

        public final Builder addNormalItem(Integer r14) {
            return addNormalItem$default(this, r14, null, null, null, null, null, false, null, null, null, 1022, null);
        }

        public final Builder addNormalItem(Integer r14, Integer r15) {
            return addNormalItem$default(this, r14, r15, null, null, null, null, false, null, null, null, PointerIconCompat.TYPE_GRAB, null);
        }

        public final Builder addNormalItem(Integer r14, Integer r15, Integer r16) {
            return addNormalItem$default(this, r14, r15, r16, null, null, null, false, null, null, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null);
        }

        public final Builder addNormalItem(Integer r14, Integer r15, Integer r16, CharSequence r17) {
            return addNormalItem$default(this, r14, r15, r16, r17, null, null, false, null, null, null, PointerIconCompat.TYPE_TEXT, null);
        }

        public final Builder addNormalItem(Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18) {
            return addNormalItem$default(this, r14, r15, r16, r17, r18, null, false, null, null, null, 992, null);
        }

        public final Builder addNormalItem(Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18, CharSequence r19) {
            return addNormalItem$default(this, r14, r15, r16, r17, r18, r19, false, null, null, null, 960, null);
        }

        public final Builder addNormalItem(Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18, CharSequence r19, boolean r20) {
            return addNormalItem$default(this, r14, r15, r16, r17, r18, r19, r20, null, null, null, 896, null);
        }

        public final Builder addNormalItem(Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18, CharSequence r19, boolean r20, BadgeInfo r21) {
            return addNormalItem$default(this, r14, r15, r16, r17, r18, r19, r20, r21, null, null, ViewUtils.EDGE_TO_EDGE_FLAGS, null);
        }

        public final Builder addNormalItem(Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18, CharSequence r19, boolean r20, BadgeInfo r21, Integer r22) {
            return addNormalItem$default(this, r14, r15, r16, r17, r18, r19, r20, r21, r22, null, 512, null);
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addPopoverItem() {
            return addPopoverItem$default(this, null, null, null, null, null, null, false, null, null, 511, null);
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addPopoverItem(Integer r13) {
            return addPopoverItem$default(this, r13, null, null, null, null, null, false, null, null, 510, null);
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addPopoverItem(Integer r13, Integer r14) {
            return addPopoverItem$default(this, r13, r14, null, null, null, null, false, null, null, 508, null);
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addPopoverItem(Integer r13, Integer r14, Integer r15) {
            return addPopoverItem$default(this, r13, r14, r15, null, null, null, false, null, null, 504, null);
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addPopoverItem(Integer r13, Integer r14, Integer r15, CharSequence r16) {
            return addPopoverItem$default(this, r13, r14, r15, r16, null, null, false, null, null, 496, null);
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addPopoverItem(Integer r13, Integer r14, Integer r15, CharSequence r16, CharSequence r17) {
            return addPopoverItem$default(this, r13, r14, r15, r16, r17, null, false, null, null, OSheetBaseKt.SHEET_LANDSCAPE_MAX_WIDTH, null);
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addPopoverItem(Integer r13, Integer r14, Integer r15, CharSequence r16, CharSequence r17, CharSequence r18) {
            return addPopoverItem$default(this, r13, r14, r15, r16, r17, r18, false, null, null, 448, null);
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addPopoverItem(Integer r13, Integer r14, Integer r15, CharSequence r16, CharSequence r17, CharSequence r18, boolean r19) {
            return addPopoverItem$default(this, r13, r14, r15, r16, r17, r18, r19, null, null, 384, null);
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addPopoverItem(Integer r13, Integer r14, Integer r15, CharSequence r16, CharSequence r17, CharSequence r18, boolean r19, BadgeInfo r20) {
            return addPopoverItem$default(this, r13, r14, r15, r16, r17, r18, r19, r20, null, 256, null);
        }

        @Deprecated(message = "请使用 addNormalEntryItem() 替代")
        public final Builder addPopoverItemWithArrow() {
            return addPopoverItemWithArrow$default(this, null, null, null, null, null, false, null, WorkQueueKt.MASK, null);
        }

        @Deprecated(message = "请使用 addNormalEntryItem() 替代")
        public final Builder addPopoverItemWithArrow(Integer r11) {
            return addPopoverItemWithArrow$default(this, r11, null, null, null, null, false, null, 126, null);
        }

        @Deprecated(message = "请使用 addNormalEntryItem() 替代")
        public final Builder addPopoverItemWithArrow(Integer r11, Integer r12) {
            return addPopoverItemWithArrow$default(this, r11, r12, null, null, null, false, null, 124, null);
        }

        @Deprecated(message = "请使用 addNormalEntryItem() 替代")
        public final Builder addPopoverItemWithArrow(Integer r11, Integer r12, CharSequence r13) {
            return addPopoverItemWithArrow$default(this, r11, r12, r13, null, null, false, null, 120, null);
        }

        @Deprecated(message = "请使用 addNormalEntryItem() 替代")
        public final Builder addPopoverItemWithArrow(Integer r11, Integer r12, CharSequence r13, CharSequence r14) {
            return addPopoverItemWithArrow$default(this, r11, r12, r13, r14, null, false, null, 112, null);
        }

        @Deprecated(message = "请使用 addNormalEntryItem() 替代")
        public final Builder addPopoverItemWithArrow(Integer r11, Integer r12, CharSequence r13, CharSequence r14, CharSequence r15) {
            return addPopoverItemWithArrow$default(this, r11, r12, r13, r14, r15, false, null, 96, null);
        }

        @Deprecated(message = "请使用 addNormalEntryItem() 替代")
        public final Builder addPopoverItemWithArrow(Integer r11, Integer r12, CharSequence r13, CharSequence r14, CharSequence r15, boolean r16) {
            return addPopoverItemWithArrow$default(this, r11, r12, r13, r14, r15, r16, null, 64, null);
        }

        public final Builder addPopoverItemWithBadge() {
            return addPopoverItemWithBadge$default(this, null, null, null, null, null, false, null, null, 255, null);
        }

        public final Builder addPopoverItemWithBadge(Integer r12) {
            return addPopoverItemWithBadge$default(this, r12, null, null, null, null, false, null, null, 254, null);
        }

        public final Builder addPopoverItemWithBadge(Integer r12, Integer r13) {
            return addPopoverItemWithBadge$default(this, r12, r13, null, null, null, false, null, null, 252, null);
        }

        public final Builder addPopoverItemWithBadge(Integer r12, Integer r13, CharSequence r14) {
            return addPopoverItemWithBadge$default(this, r12, r13, r14, null, null, false, null, null, 248, null);
        }

        public final Builder addPopoverItemWithBadge(Integer r12, Integer r13, CharSequence r14, CharSequence r15) {
            return addPopoverItemWithBadge$default(this, r12, r13, r14, r15, null, false, null, null, BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND, null);
        }

        public final Builder addPopoverItemWithBadge(Integer r12, Integer r13, CharSequence r14, CharSequence r15, CharSequence r16) {
            return addPopoverItemWithBadge$default(this, r12, r13, r14, r15, r16, false, null, null, 224, null);
        }

        public final Builder addPopoverItemWithBadge(Integer r12, Integer r13, CharSequence r14, CharSequence r15, CharSequence r16, boolean r17) {
            return addPopoverItemWithBadge$default(this, r12, r13, r14, r15, r16, r17, null, null, 192, null);
        }

        public final Builder addPopoverItemWithBadge(Integer r12, Integer r13, CharSequence r14, CharSequence r15, CharSequence r16, boolean r17, BadgeInfo r18) {
            return addPopoverItemWithBadge$default(this, r12, r13, r14, r15, r16, r17, r18, null, 128, null);
        }

        @Deprecated(message = "请使用 addStartOptionItem() 替代")
        public final Builder addPopoverLeftOptionItem() {
            return addPopoverLeftOptionItem$default(this, null, null, null, null, null, false, false, false, null, 511, null);
        }

        @Deprecated(message = "请使用 addStartOptionItem() 替代")
        public final Builder addPopoverLeftOptionItem(Integer r13) {
            return addPopoverLeftOptionItem$default(this, r13, null, null, null, null, false, false, false, null, 510, null);
        }

        @Deprecated(message = "请使用 addStartOptionItem() 替代")
        public final Builder addPopoverLeftOptionItem(Integer r13, Integer r14) {
            return addPopoverLeftOptionItem$default(this, r13, r14, null, null, null, false, false, false, null, 508, null);
        }

        @Deprecated(message = "请使用 addStartOptionItem() 替代")
        public final Builder addPopoverLeftOptionItem(Integer r13, Integer r14, Integer r15) {
            return addPopoverLeftOptionItem$default(this, r13, r14, r15, null, null, false, false, false, null, 504, null);
        }

        @Deprecated(message = "请使用 addStartOptionItem() 替代")
        public final Builder addPopoverLeftOptionItem(Integer r13, Integer r14, Integer r15, CharSequence r16) {
            return addPopoverLeftOptionItem$default(this, r13, r14, r15, r16, null, false, false, false, null, 496, null);
        }

        @Deprecated(message = "请使用 addStartOptionItem() 替代")
        public final Builder addPopoverLeftOptionItem(Integer r13, Integer r14, Integer r15, CharSequence r16, CharSequence r17) {
            return addPopoverLeftOptionItem$default(this, r13, r14, r15, r16, r17, false, false, false, null, OSheetBaseKt.SHEET_LANDSCAPE_MAX_WIDTH, null);
        }

        @Deprecated(message = "请使用 addStartOptionItem() 替代")
        public final Builder addPopoverLeftOptionItem(Integer r13, Integer r14, Integer r15, CharSequence r16, CharSequence r17, boolean r18) {
            return addPopoverLeftOptionItem$default(this, r13, r14, r15, r16, r17, r18, false, false, null, 448, null);
        }

        @Deprecated(message = "请使用 addStartOptionItem() 替代")
        public final Builder addPopoverLeftOptionItem(Integer r13, Integer r14, Integer r15, CharSequence r16, CharSequence r17, boolean r18, boolean r19) {
            return addPopoverLeftOptionItem$default(this, r13, r14, r15, r16, r17, r18, r19, false, null, 384, null);
        }

        @Deprecated(message = "请使用 addStartOptionItem() 替代")
        public final Builder addPopoverLeftOptionItem(Integer r13, Integer r14, Integer r15, CharSequence r16, CharSequence r17, boolean r18, boolean r19, boolean r20) {
            return addPopoverLeftOptionItem$default(this, r13, r14, r15, r16, r17, r18, r19, r20, null, 256, null);
        }

        @Deprecated(message = "请使用 addEndOptionItem() 替代")
        public final Builder addPopoverRightOptionItem() {
            return addPopoverRightOptionItem$default(this, false, null, null, null, null, null, false, false, null, 511, null);
        }

        @Deprecated(message = "请使用 addEndOptionItem() 替代")
        public final Builder addPopoverRightOptionItem(boolean r13) {
            return addPopoverRightOptionItem$default(this, r13, null, null, null, null, null, false, false, null, 510, null);
        }

        @Deprecated(message = "请使用 addEndOptionItem() 替代")
        public final Builder addPopoverRightOptionItem(boolean r13, Integer r14) {
            return addPopoverRightOptionItem$default(this, r13, r14, null, null, null, null, false, false, null, 508, null);
        }

        @Deprecated(message = "请使用 addEndOptionItem() 替代")
        public final Builder addPopoverRightOptionItem(boolean r13, Integer r14, Integer r15) {
            return addPopoverRightOptionItem$default(this, r13, r14, r15, null, null, null, false, false, null, 504, null);
        }

        @Deprecated(message = "请使用 addEndOptionItem() 替代")
        public final Builder addPopoverRightOptionItem(boolean r13, Integer r14, Integer r15, Integer r16) {
            return addPopoverRightOptionItem$default(this, r13, r14, r15, r16, null, null, false, false, null, 496, null);
        }

        @Deprecated(message = "请使用 addEndOptionItem() 替代")
        public final Builder addPopoverRightOptionItem(boolean r13, Integer r14, Integer r15, Integer r16, CharSequence r17) {
            return addPopoverRightOptionItem$default(this, r13, r14, r15, r16, r17, null, false, false, null, OSheetBaseKt.SHEET_LANDSCAPE_MAX_WIDTH, null);
        }

        @Deprecated(message = "请使用 addEndOptionItem() 替代")
        public final Builder addPopoverRightOptionItem(boolean r13, Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18) {
            return addPopoverRightOptionItem$default(this, r13, r14, r15, r16, r17, r18, false, false, null, 448, null);
        }

        @Deprecated(message = "请使用 addEndOptionItem() 替代")
        public final Builder addPopoverRightOptionItem(boolean r13, Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18, boolean r19) {
            return addPopoverRightOptionItem$default(this, r13, r14, r15, r16, r17, r18, r19, false, null, 384, null);
        }

        @Deprecated(message = "请使用 addEndOptionItem() 替代")
        public final Builder addPopoverRightOptionItem(boolean r13, Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18, boolean r19, boolean r20) {
            return addPopoverRightOptionItem$default(this, r13, r14, r15, r16, r17, r18, r19, r20, null, 256, null);
        }

        public final Builder addStartOptionEntryItem() {
            return addStartOptionEntryItem$default(this, null, null, null, null, false, false, false, null, null, null, null, 2047, null);
        }

        public final Builder addStartOptionEntryItem(Integer r15) {
            return addStartOptionEntryItem$default(this, r15, null, null, null, false, false, false, null, null, null, null, 2046, null);
        }

        public final Builder addStartOptionEntryItem(Integer r15, Integer r16) {
            return addStartOptionEntryItem$default(this, r15, r16, null, null, false, false, false, null, null, null, null, 2044, null);
        }

        public final Builder addStartOptionEntryItem(Integer r15, Integer r16, CharSequence r17) {
            return addStartOptionEntryItem$default(this, r15, r16, r17, null, false, false, false, null, null, null, null, 2040, null);
        }

        public final Builder addStartOptionEntryItem(Integer r15, Integer r16, CharSequence r17, CharSequence r18) {
            return addStartOptionEntryItem$default(this, r15, r16, r17, r18, false, false, false, null, null, null, null, 2032, null);
        }

        public final Builder addStartOptionEntryItem(Integer r15, Integer r16, CharSequence r17, CharSequence r18, boolean r19) {
            return addStartOptionEntryItem$default(this, r15, r16, r17, r18, r19, false, false, null, null, null, null, 2016, null);
        }

        public final Builder addStartOptionEntryItem(Integer r15, Integer r16, CharSequence r17, CharSequence r18, boolean r19, boolean r20) {
            return addStartOptionEntryItem$default(this, r15, r16, r17, r18, r19, r20, false, null, null, null, null, 1984, null);
        }

        public final Builder addStartOptionEntryItem(Integer r15, Integer r16, CharSequence r17, CharSequence r18, boolean r19, boolean r20, boolean r21) {
            return addStartOptionEntryItem$default(this, r15, r16, r17, r18, r19, r20, r21, null, null, null, null, 1920, null);
        }

        public final Builder addStartOptionEntryItem(Integer r15, Integer r16, CharSequence r17, CharSequence r18, boolean r19, boolean r20, boolean r21, Integer r22) {
            return addStartOptionEntryItem$default(this, r15, r16, r17, r18, r19, r20, r21, r22, null, null, null, 1792, null);
        }

        public final Builder addStartOptionEntryItem(Integer r15, Integer r16, CharSequence r17, CharSequence r18, boolean r19, boolean r20, boolean r21, Integer r22, CharSequence r23) {
            return addStartOptionEntryItem$default(this, r15, r16, r17, r18, r19, r20, r21, r22, r23, null, null, 1536, null);
        }

        public final Builder addStartOptionEntryItem(Integer r15, Integer r16, CharSequence r17, CharSequence r18, boolean r19, boolean r20, boolean r21, Integer r22, CharSequence r23, BadgeInfo r24) {
            return addStartOptionEntryItem$default(this, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, null, 1024, null);
        }

        public final Builder addStartOptionItem() {
            return addStartOptionItem$default(this, null, null, null, null, null, false, false, false, null, null, null, null, 4095, null);
        }

        public final Builder addStartOptionItem(Integer r16) {
            return addStartOptionItem$default(this, r16, null, null, null, null, false, false, false, null, null, null, null, 4094, null);
        }

        public final Builder addStartOptionItem(Integer r16, Integer r17) {
            return addStartOptionItem$default(this, r16, r17, null, null, null, false, false, false, null, null, null, null, 4092, null);
        }

        public final Builder addStartOptionItem(Integer r16, Integer r17, Integer r18) {
            return addStartOptionItem$default(this, r16, r17, r18, null, null, false, false, false, null, null, null, null, 4088, null);
        }

        public final Builder addStartOptionItem(Integer r16, Integer r17, Integer r18, CharSequence r19) {
            return addStartOptionItem$default(this, r16, r17, r18, r19, null, false, false, false, null, null, null, null, 4080, null);
        }

        public final Builder addStartOptionItem(Integer r16, Integer r17, Integer r18, CharSequence r19, CharSequence r20) {
            return addStartOptionItem$default(this, r16, r17, r18, r19, r20, false, false, false, null, null, null, null, 4064, null);
        }

        public final Builder addStartOptionItem(Integer r16, Integer r17, Integer r18, CharSequence r19, CharSequence r20, boolean r21) {
            return addStartOptionItem$default(this, r16, r17, r18, r19, r20, r21, false, false, null, null, null, null, 4032, null);
        }

        public final Builder addStartOptionItem(Integer r16, Integer r17, Integer r18, CharSequence r19, CharSequence r20, boolean r21, boolean r22) {
            return addStartOptionItem$default(this, r16, r17, r18, r19, r20, r21, r22, false, null, null, null, null, 3968, null);
        }

        public final Builder addStartOptionItem(Integer r16, Integer r17, Integer r18, CharSequence r19, CharSequence r20, boolean r21, boolean r22, boolean r23) {
            return addStartOptionItem$default(this, r16, r17, r18, r19, r20, r21, r22, r23, null, null, null, null, 3840, null);
        }

        public final Builder addStartOptionItem(Integer r16, Integer r17, Integer r18, CharSequence r19, CharSequence r20, boolean r21, boolean r22, boolean r23, Integer r24) {
            return addStartOptionItem$default(this, r16, r17, r18, r19, r20, r21, r22, r23, r24, null, null, null, 3584, null);
        }

        public final Builder addStartOptionItem(Integer r16, Integer r17, Integer r18, CharSequence r19, CharSequence r20, boolean r21, boolean r22, boolean r23, Integer r24, CharSequence r25) {
            return addStartOptionItem$default(this, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, null, null, 3072, null);
        }

        public final Builder addStartOptionItem(Integer r16, Integer r17, Integer r18, CharSequence r19, CharSequence r20, boolean r21, boolean r22, boolean r23, Integer r24, CharSequence r25, BadgeInfo r26) {
            return addStartOptionItem$default(this, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, null, 2048, null);
        }

        @Deprecated(message = "do nothing")
        public final void setItemHeight(int r1) {
        }

        public Builder(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.context = r2;
            this.itemLayoutProcess = OPopoverEntranceMenuView$Builder$itemLayoutProcess$1.INSTANCE;
            this.popoverItems = new ArrayList();
            this.itemWidth = OUnitExtensionKt.cdp(this.context, OPopoverEntranceMenuView.access$getWIDTH_STANDARD_DP$cp());
        }

        public final Context getContext() {
            return this.context;
        }

        public final void setContext(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.context = r2;
        }

        public final boolean getForceDark() {
            return this.forceDark;
        }

        public final void setForceDark(boolean r1) {
            this.forceDark = r1;
        }

        public final void setImgGetter(Function1<? super Integer, ? extends Drawable> r1) {
            this.imgGetter = r1;
        }

        public final void setTailImgGetter(Function1<? super Integer, ? extends Drawable> r1) {
            this.tailImgGetter = r1;
        }

        public final void enableOption() {
            this.isOption = 1;
        }

        public final void enableMultiOption() {
            this.isOption = 2;
        }

        public final void addTopView(View r1) {
            this.topView = r1;
        }

        public final void addBottomView(View r1) {
            this.bottomView = r1;
        }

        public final void addItemDivider() {
            this.popoverItems.add(PopoverItem.Companion.getDIVIDER());
        }

        public final void addSectionTitle(String r21) {
            Intrinsics.checkNotNullParameter(r21, "title");
            this.popoverItems.add(new PopoverItem(0, false, 0, 0, 0, r21, null, null, false, true, null, 2, null, null, 12288, null));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder addNormalItem$default(Builder r2, Integer r3, Integer r4, Integer r5, CharSequence r6, CharSequence r7, CharSequence r8, boolean r9, BadgeInfo r10, Integer r11, Function2 r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r4 = 0;
        L9:
            if ((r13 & 4) == 0) goto L12;
            r5 = 0;
        L12:
            if ((r13 & 8) == 0) goto L15;
        L15:
            if ((r13 & 16) == 0) goto L18;
            r7 = null;
        L18:
            if ((r13 & 32) == 0) goto L21;
            r8 = null;
        L21:
            if ((r13 & 64) == 0) goto L24;
            r9 = false;
        L24:
            if ((r13 & 128) == 0) goto L27;
            r10 = null;
        L27:
            if ((r13 & 256) == 0) goto L30;
            r11 = null;
        L30:
            if ((r13 & 512) == 0) goto L33;
            r12 = null;
        L33:
            return r2.addNormalItem(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        }

        public final Builder addNormalItem(Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18, CharSequence r19, boolean r20, BadgeInfo r21, Integer r22, Function2<? super View, ? super Integer, Unit> r23) {
            return addPopoverItem(0, false, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder addNormalEntryItem$default(Builder r2, Integer r3, Integer r4, CharSequence r5, CharSequence r6, CharSequence r7, boolean r8, BadgeInfo r9, Integer r10, Function2 r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r4 = 0;
        L9:
            if ((r12 & 4) == 0) goto L12;
        L12:
            if ((r12 & 8) == 0) goto L15;
            r6 = null;
        L15:
            if ((r12 & 16) == 0) goto L18;
            r7 = null;
        L18:
            if ((r12 & 32) == 0) goto L21;
            r8 = false;
        L21:
            if ((r12 & 64) == 0) goto L24;
            r9 = null;
        L24:
            if ((r12 & 128) == 0) goto L27;
            r10 = null;
        L27:
            if ((r12 & 256) == 0) goto L30;
            r11 = null;
        L30:
            return r2.addNormalEntryItem(r3, r4, r5, r6, r7, r8, r9, r10, r11);
        }

        public final Builder addNormalEntryItem(Integer r14, Integer r15, CharSequence r16, CharSequence r17, CharSequence r18, boolean r19, BadgeInfo r20, Integer r21, Function2<? super View, ? super Integer, Unit> r22) {
            return addPopoverItem(0, false, r14, Integer.valueOf(R.drawable.o_ic_popmenu_arrow), r15, r16, r17, r18, r19, r20, r21, r22);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder addStartOptionItem$default(Builder r13, Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18, boolean r19, boolean r20, boolean r21, Integer r22, CharSequence r23, BadgeInfo r24, Function2 r25, int r26, Object r27) {
            boolean r2 = false;
            Integer r3 = 0;
            if ((r26 & 1) == 0) goto L5;
            Integer r1 = r3;
        L7:
            if ((r26 & 2) == 0) goto L9;
            Integer r4 = r3;
        L11:
            if ((r26 & 4) != 0) goto L15;
            r3 = r16;
        L15:
            if ((r26 & 8) == 0) goto L17;
        L18:
            Function2 r7 = null;
            if ((r26 & 16) == 0) goto L21;
            CharSequence r6 = null;
        L23:
            if ((r26 & 32) == 0) goto L25;
            boolean r8 = false;
        L27:
            if ((r26 & 64) == 0) goto L29;
            boolean r9 = true;
        L31:
            if ((r26 & 128) != 0) goto L35;
            r2 = r21;
        L35:
            if ((r26 & 256) == 0) goto L37;
            Integer r10 = null;
        L39:
            if ((r26 & 512) == 0) goto L41;
            CharSequence r11 = null;
        L43:
            if ((r26 & 1024) == 0) goto L45;
            BadgeInfo r12 = null;
        L47:
            if ((r26 & 2048) != 0) goto L51;
            r7 = r25;
        L51:
            return r13.addStartOptionItem(r1, r4, r3, r5, r6, r8, r9, r2, r10, r11, r12, r7);
        L45:
            r12 = r24;
            goto L47
        L41:
            r11 = r23;
            goto L43
        L37:
            r10 = r22;
            goto L39
        L29:
            r9 = r20;
            goto L31
        L25:
            r8 = r19;
            goto L27
        L21:
            r6 = r18;
            goto L23
        L17:
            CharSequence r5 = r17;
            goto L18
        L9:
            r4 = r15;
            goto L11
        L5:
            r1 = r14;
            goto L7
        }

        public final Builder addStartOptionItem(Integer r15, Integer r16, Integer r17, CharSequence r18, CharSequence r19, boolean r20, boolean r21, boolean r22, Integer r23, CharSequence r24, BadgeInfo r25, Function2<? super View, ? super Integer, Unit> r26) {
            if (r22 == false) goto L4;
            int r0 = 5;
        L6:
            return addPopoverItem(r0, r21, r15, r16, r17, r18, r19, r24, r20, r25, r23, r26);
        L4:
            r0 = 1;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder addStartOptionEntryItem$default(Builder r2, Integer r3, Integer r4, CharSequence r5, CharSequence r6, boolean r7, boolean r8, boolean r9, Integer r10, CharSequence r11, BadgeInfo r12, Function2 r13, int r14, Object r15) {
            if ((r14 & 1) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r14 & 2) == 0) goto L9;
            r4 = 0;
        L9:
            if ((r14 & 4) == 0) goto L12;
        L12:
            if ((r14 & 8) == 0) goto L15;
            r6 = null;
        L15:
            if ((r14 & 16) == 0) goto L18;
            r7 = false;
        L18:
            if ((r14 & 32) == 0) goto L21;
            r8 = true;
        L21:
            if ((r14 & 64) == 0) goto L24;
            r9 = false;
        L24:
            if ((r14 & 128) == 0) goto L27;
            r10 = null;
        L27:
            if ((r14 & 256) == 0) goto L30;
            r11 = null;
        L30:
            if ((r14 & 512) == 0) goto L33;
            r12 = null;
        L33:
            if ((r14 & 1024) == 0) goto L36;
            r13 = null;
        L36:
            return r2.addStartOptionEntryItem(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
        }

        public final Builder addStartOptionEntryItem(Integer r15, Integer r16, CharSequence r17, CharSequence r18, boolean r19, boolean r20, boolean r21, Integer r22, CharSequence r23, BadgeInfo r24, Function2<? super View, ? super Integer, Unit> r25) {
            if (r21 == false) goto L4;
            int r0 = 5;
        L6:
            return addPopoverItem(r0, r20, r15, Integer.valueOf(R.drawable.o_ic_popmenu_arrow), r16, r17, r18, r23, r19, r24, r22, r25);
        L4:
            r0 = 1;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder addEndOptionItem$default(Builder r13, boolean r14, Integer r15, Integer r16, Integer r17, CharSequence r18, CharSequence r19, boolean r20, boolean r21, Integer r22, CharSequence r23, BadgeInfo r24, Function2 r25, int r26, Object r27) {
            if ((r26 & 1) == 0) goto L5;
            boolean r1 = true;
        L6:
            boolean r3 = false;
            if ((r26 & 2) == 0) goto L9;
            Integer r2 = 0;
        L11:
            if ((r26 & 4) == 0) goto L13;
            Integer r4 = 0;
        L15:
            if ((r26 & 8) == 0) goto L17;
            Integer r5 = 0;
        L19:
            if ((r26 & 16) == 0) goto L21;
        L22:
            Function2 r8 = null;
            if ((r26 & 32) == 0) goto L25;
            CharSequence r7 = null;
        L27:
            if ((r26 & 64) == 0) goto L29;
            boolean r9 = false;
        L31:
            if ((r26 & 128) != 0) goto L35;
            r3 = r21;
        L35:
            if ((r26 & 256) == 0) goto L37;
            Integer r10 = null;
        L39:
            if ((r26 & 512) == 0) goto L41;
            CharSequence r11 = null;
        L43:
            if ((r26 & 1024) == 0) goto L45;
            BadgeInfo r12 = null;
        L47:
            if ((r26 & 2048) != 0) goto L51;
            r8 = r25;
        L51:
            return r13.addEndOptionItem(r1, r2, r4, r5, r6, r7, r9, r3, r10, r11, r12, r8);
        L45:
            r12 = r24;
            goto L47
        L41:
            r11 = r23;
            goto L43
        L37:
            r10 = r22;
            goto L39
        L29:
            r9 = r20;
            goto L31
        L25:
            r7 = r19;
            goto L27
        L21:
            CharSequence r6 = r18;
            goto L22
        L17:
            r5 = r17;
            goto L19
        L13:
            r4 = r16;
            goto L15
        L9:
            r2 = r15;
            goto L11
        L5:
            r1 = r14;
            goto L6
        }

        public final Builder addEndOptionItem(boolean r15, Integer r16, Integer r17, Integer r18, CharSequence r19, CharSequence r20, boolean r21, boolean r22, Integer r23, CharSequence r24, BadgeInfo r25, Function2<? super View, ? super Integer, Unit> r26) {
            if (r22 == false) goto L4;
            int r0 = 6;
        L6:
            return addPopoverItem(r0, r15, r16, r17, r18, r19, r20, r24, r21, r25, r23, r26);
        L4:
            r0 = 2;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder addPopoverItemWithBadge$default(Builder r2, Integer r3, Integer r4, CharSequence r5, CharSequence r6, CharSequence r7, boolean r8, BadgeInfo r9, Function2 r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r11 & 2) == 0) goto L9;
            r4 = 0;
        L9:
            if ((r11 & 4) == 0) goto L12;
        L12:
            if ((r11 & 8) == 0) goto L15;
            r6 = null;
        L15:
            if ((r11 & 16) == 0) goto L18;
            r7 = null;
        L18:
            if ((r11 & 32) == 0) goto L21;
            r8 = false;
        L21:
            if ((r11 & 64) == 0) goto L24;
            r9 = null;
        L24:
            if ((r11 & 128) == 0) goto L27;
            r10 = null;
        L27:
            return r2.addPopoverItemWithBadge(r3, r4, r5, r6, r7, r8, r9, r10);
        }

        public final Builder addPopoverItemWithBadge(Integer r14, Integer r15, CharSequence r16, CharSequence r17, CharSequence r18, boolean r19, BadgeInfo r20, Function2<? super View, ? super Integer, Unit> r21) {
            return addPopoverItem(0, false, r14, 0, r15, r16, r17, r18, r19, r20, null, r21);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder addCustomTitleColorPopoverItem$default(Builder r15, Integer r16, Integer r17, Integer r18, CharSequence r19, CharSequence r20, CharSequence r21, boolean r22, BadgeInfo r23, int r24, Function2 r25, int r26, Object r27) {
            if ((r26 & 1) == 0) goto L5;
            Integer r5 = 0;
        L7:
            if ((r26 & 2) == 0) goto L9;
            Integer r6 = 0;
        L11:
            if ((r26 & 4) == 0) goto L13;
            Integer r7 = 0;
        L15:
            if ((r26 & 8) == 0) goto L17;
        L19:
            if ((r26 & 16) == 0) goto L21;
            CharSequence r9 = null;
        L23:
            if ((r26 & 32) == 0) goto L25;
            CharSequence r10 = null;
        L27:
            if ((r26 & 64) == 0) goto L29;
            boolean r11 = false;
        L31:
            if ((r26 & 128) == 0) goto L33;
            BadgeInfo r12 = null;
        L35:
            if ((r26 & 512) == 0) goto L37;
            Function2 r14 = null;
        L39:
            return r15.addCustomTitleColorPopoverItem(r5, r6, r7, r8, r9, r10, r11, r12, r24, r14);
        L37:
            r14 = r25;
            goto L39
        L33:
            r12 = r23;
            goto L35
        L29:
            r11 = r22;
            goto L31
        L25:
            r10 = r21;
            goto L27
        L21:
            r9 = r20;
            goto L23
        L17:
            CharSequence r8 = r19;
            goto L19
        L13:
            r7 = r18;
            goto L15
        L9:
            r6 = r17;
            goto L11
        L5:
            r5 = r16;
            goto L7
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addCustomTitleColorPopoverItem(Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18, CharSequence r19, boolean r20, BadgeInfo r21, int r22, Function2<? super View, ? super Integer, Unit> r23) {
            return addPopoverItem(0, false, r14, r15, r16, r17, r18, r19, r20, r21, Integer.valueOf(r22), r23);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder addPopoverLeftOptionItem$default(Builder r2, Integer r3, Integer r4, Integer r5, CharSequence r6, CharSequence r7, boolean r8, boolean r9, boolean r10, Function2 r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r4 = 0;
        L9:
            if ((r12 & 4) == 0) goto L12;
            r5 = 0;
        L12:
            if ((r12 & 8) == 0) goto L15;
        L15:
            if ((r12 & 16) == 0) goto L18;
            r7 = null;
        L18:
            if ((r12 & 32) == 0) goto L21;
            r8 = false;
        L21:
            if ((r12 & 64) == 0) goto L24;
            r9 = true;
        L24:
            if ((r12 & 128) == 0) goto L27;
            r10 = false;
        L27:
            if ((r12 & 256) == 0) goto L30;
            r11 = null;
        L30:
            return r2.addPopoverLeftOptionItem(r3, r4, r5, r6, r7, r8, r9, r10, r11);
        }

        @Deprecated(message = "请使用 addStartOptionItem() 替代")
        public final Builder addPopoverLeftOptionItem(Integer r15, Integer r16, Integer r17, CharSequence r18, CharSequence r19, boolean r20, boolean r21, boolean r22, Function2<? super View, ? super Integer, Unit> r23) {
            if (r22 == false) goto L4;
            int r0 = 5;
        L6:
            return addPopoverItem(r0, r21, r15, r16, r17, r18, r19, null, r20, null, null, r23);
        L4:
            r0 = 1;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder addPopoverRightOptionItem$default(Builder r11, boolean r12, Integer r13, Integer r14, Integer r15, CharSequence r16, CharSequence r17, boolean r18, boolean r19, Function2 r20, int r21, Object r22) {
            if ((r21 & 1) == 0) goto L5;
            boolean r1 = true;
        L6:
            boolean r3 = false;
            if ((r21 & 2) == 0) goto L9;
            Integer r2 = 0;
        L11:
            if ((r21 & 4) == 0) goto L13;
            Integer r4 = 0;
        L15:
            if ((r21 & 8) == 0) goto L17;
            Integer r5 = 0;
        L19:
            if ((r21 & 16) == 0) goto L21;
        L22:
            Function2 r8 = null;
            if ((r21 & 32) == 0) goto L25;
            CharSequence r7 = null;
        L27:
            if ((r21 & 64) == 0) goto L29;
            boolean r9 = false;
        L31:
            if ((r21 & 128) != 0) goto L35;
            r3 = r19;
        L35:
            if ((r21 & 256) != 0) goto L39;
            r8 = r20;
        L39:
            return r11.addPopoverRightOptionItem(r1, r2, r4, r5, r6, r7, r9, r3, r8);
        L29:
            r9 = r18;
            goto L31
        L25:
            r7 = r17;
            goto L27
        L21:
            CharSequence r6 = r16;
            goto L22
        L17:
            r5 = r15;
            goto L19
        L13:
            r4 = r14;
            goto L15
        L9:
            r2 = r13;
            goto L11
        L5:
            r1 = r12;
            goto L6
        }

        @Deprecated(message = "请使用 addEndOptionItem() 替代")
        public final Builder addPopoverRightOptionItem(boolean r15, Integer r16, Integer r17, Integer r18, CharSequence r19, CharSequence r20, boolean r21, boolean r22, Function2<? super View, ? super Integer, Unit> r23) {
            if (r22 == false) goto L4;
            int r0 = 6;
        L6:
            return addPopoverItem(r0, r15, r16, r17, r18, r19, r20, null, r21, null, null, r23);
        L4:
            r0 = 2;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder addPopoverItem$default(Builder r2, Integer r3, Integer r4, Integer r5, CharSequence r6, CharSequence r7, CharSequence r8, boolean r9, BadgeInfo r10, Function2 r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r4 = 0;
        L9:
            if ((r12 & 4) == 0) goto L12;
            r5 = 0;
        L12:
            if ((r12 & 8) == 0) goto L15;
        L15:
            if ((r12 & 16) == 0) goto L18;
            r7 = null;
        L18:
            if ((r12 & 32) == 0) goto L21;
            r8 = null;
        L21:
            if ((r12 & 64) == 0) goto L24;
            r9 = false;
        L24:
            if ((r12 & 128) == 0) goto L27;
            r10 = null;
        L27:
            if ((r12 & 256) == 0) goto L30;
            r11 = null;
        L30:
            return r2.addPopoverItem(r3, r4, r5, r6, r7, r8, r9, r10, r11);
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder addPopoverItem(Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18, CharSequence r19, boolean r20, BadgeInfo r21, Function2<? super View, ? super Integer, Unit> r22) {
            return addPopoverItem(0, false, r14, r15, r16, r17, r18, r19, r20, r21, null, r22);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder addPopoverItemWithArrow$default(Builder r2, Integer r3, Integer r4, CharSequence r5, CharSequence r6, CharSequence r7, boolean r8, Function2 r9, int r10, Object r11) {
            if ((r10 & 1) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r10 & 2) == 0) goto L9;
            r4 = 0;
        L9:
            if ((r10 & 4) == 0) goto L12;
        L12:
            if ((r10 & 8) == 0) goto L15;
            r6 = null;
        L15:
            if ((r10 & 16) == 0) goto L18;
            r7 = null;
        L18:
            if ((r10 & 32) == 0) goto L21;
            r8 = false;
        L21:
            if ((r10 & 64) == 0) goto L24;
            r9 = null;
        L24:
            return r2.addPopoverItemWithArrow(r3, r4, r5, r6, r7, r8, r9);
        }

        @Deprecated(message = "请使用 addNormalEntryItem() 替代")
        public final Builder addPopoverItemWithArrow(Integer r14, Integer r15, CharSequence r16, CharSequence r17, CharSequence r18, boolean r19, Function2<? super View, ? super Integer, Unit> r20) {
            return addPopoverItem(0, false, r14, Integer.valueOf(R.drawable.o_ic_popmenu_arrow), r15, r16, r17, r18, r19, null, null, r20);
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ Builder addPopoverItem$default(Builder r13, int r14, boolean r15, Integer r16, Integer r17, Integer r18, CharSequence r19, CharSequence r20, CharSequence r21, boolean r22, BadgeInfo r23, Integer r24, Function2 r25, int r26, Object r27) {
            boolean r2 = false;
            Integer r3 = 0;
            if ((r26 & 1) == 0) goto L5;
            int r1 = 0;
        L7:
            if ((r26 & 2) == 0) goto L9;
            boolean r4 = false;
        L11:
            if ((r26 & 4) == 0) goto L13;
            Integer r5 = r3;
        L15:
            if ((r26 & 8) == 0) goto L17;
            Integer r6 = r3;
        L19:
            if ((r26 & 16) != 0) goto L23;
            r3 = r18;
        L23:
            if ((r26 & 32) == 0) goto L25;
        L26:
            Function2 r9 = null;
            if ((r26 & 64) == 0) goto L29;
            CharSequence r8 = null;
        L31:
            if ((r26 & 128) == 0) goto L33;
            CharSequence r10 = null;
        L35:
            if ((r26 & 256) != 0) goto L39;
            r2 = r22;
        L39:
            if ((r26 & 512) == 0) goto L41;
            BadgeInfo r11 = null;
        L43:
            if ((r26 & 1024) == 0) goto L45;
            Integer r12 = null;
        L47:
            if ((r26 & 2048) != 0) goto L51;
            r9 = r25;
        L51:
            return r13.addPopoverItem(r1, r4, r5, r6, r3, r7, r8, r10, r2, r11, r12, r9);
        L45:
            r12 = r24;
            goto L47
        L41:
            r11 = r23;
            goto L43
        L33:
            r10 = r21;
            goto L35
        L29:
            r8 = r20;
            goto L31
        L25:
            CharSequence r7 = r19;
            goto L26
        L17:
            r6 = r17;
            goto L19
        L13:
            r5 = r16;
            goto L15
        L9:
            r4 = r15;
            goto L11
        L5:
            r1 = r14;
            goto L7
        }

        private final Builder addPopoverItem(int r18, boolean r19, Integer r20, Integer r21, Integer r22, CharSequence r23, CharSequence r24, CharSequence r25, boolean r26, BadgeInfo r27, Integer r28, Function2<? super View, ? super Integer, Unit> r29) {
            if (this.isOption <= 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L11;
            if (r18 != 0) goto L11;
            throw new IllegalArgumentException("option menu item 请使用 addStartOptionItem() 或者 addEndOptionItem()");
        L11:
            if (r1 == true) goto L16;
            if (r18 == 0) goto L16;
            throw new IllegalArgumentException("menu item 请不要使用 addStartOptionItem() 或者 addEndOptionItem()");
        L16:
            ArrayList<PopoverItem> r15 = this.popoverItems;
            if (r20 != null) goto L19;
            int r4 = 0;
        L20:
            if (r21 != null) goto L22;
            int r5 = 0;
        L23:
            if (r22 != null) goto L25;
            int r6 = 0;
        L26:
            r15.add(new PopoverItem(r18, r19, r4, r5, r6, r23, r24, r25, r26, true, r29, 0, r27, r28));
            return this;
        L25:
            r6 = r22.intValue();
            goto L26
        L22:
            r5 = r21.intValue();
            goto L23
        L19:
            r4 = r20.intValue();
            goto L20
        L5:
            r1 = false;
            goto L6
        }

        public final void setTopViewHeight(int r1) {
            this.topViewHeight = r1;
        }

        public final void setBottomViewHeight(int r1) {
            this.bottomViewHeight = r1;
        }

        public final Builder setWidthLevel(WidthLevel r2) {
            Intrinsics.checkNotNullParameter(r2, "level");
            this.itemWidth = OUnitExtensionKt.cdp(this.context, r2.getValue());
            return this;
        }

        public final Builder setMenuWidth(int r1) {
            this.itemWidth = r1;
            return this;
        }

        public final void setItemWidth(int r3) {
            if (r3 < OUnitExtensionKt.cdp(this.context, OPopoverEntranceMenuView.access$getWIDTH_BROAD_DP$cp())) goto L5;
            setWidthLevel(WidthLevel.WIDTH_LEVEL_BROAD);
            return;
        L5:
            setWidthLevel(WidthLevel.WIDTH_LEVEL_STANDARD);
        }

        public final void setTopDividerVisibility(boolean r1) {
            this.topDividerVisibility = r1;
        }

        public final Builder setTitleSingleLine(boolean r1) {
            this.titleSingleLine = r1;
            return this;
        }

        public final Builder addHighlightPopoverItem(Integer r20, CharSequence r21, Function2<? super View, ? super Integer, Unit> r22) {
            ArrayList<PopoverItem> r1 = this.popoverItems;
            int r3 = 0;
            boolean r4 = false;
            if (r20 != null) goto L5;
            int r2 = 0;
        L6:
            r1.add(new PopoverItem(r3, r4, r2, 0, 0, r21, null, null, true, true, r22, 0, null, null, 14336, null));
            return this;
        L5:
            r2 = r20.intValue();
            goto L6
        }

        public final void pressedWithArrow(boolean r1) {
            this.pressedWithArrow = r1;
        }

        public final void forceDark(boolean r1) {
            this.forceDark = r1;
        }

        public final Builder setItemLayoutProcess(Function1<? super View, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, DBHelper.BATTERY_COL_PROCESS_NAME);
            this.itemLayoutProcess = r2;
            return this;
        }

        @Deprecated(message = "Use setWidthLevel instead")
        public final void setItemWidthConstraint(int r1, int r2) throws IllegalArgumentException {
            if (r2 < WidthLevel.WIDTH_LEVEL_BROAD.getValue()) goto L5;
            setWidthLevel(WidthLevel.WIDTH_LEVEL_BROAD);
        L6:
            this.widthConstraint = null;
            return;
        L5:
            setWidthLevel(WidthLevel.WIDTH_LEVEL_STANDARD);
            goto L6
        }

        public final OPopoverEntranceMenuView build() {
            OPopoverEntranceMenuView r6 = new OPopoverEntranceMenuView(this.context, null, 0, 6, null);
            OPopoverEntranceMenuView.access$setItems$p(r6, this.popoverItems);
            r6.setPressedWithArrow(this.pressedWithArrow);
            r6.setForceDark(getForceDark());
            OPopoverEntranceMenuView.access$setItemLayoutProcess$p(r6, this.itemLayoutProcess);
            OPopoverEntranceMenuView.access$setTopDividerVisibility$p(r6, this.topDividerVisibility);
            OPopoverEntranceMenuView.access$setTopViewHeight$p(r6, this.topViewHeight);
            OPopoverEntranceMenuView.access$setBottomViewHeight$p(r6, this.bottomViewHeight);
            OPopoverEntranceMenuView.access$setItemHeight$p(r6, this.itemHeight);
            OPopoverEntranceMenuView.access$setTopView$p(r6, this.topView);
            OPopoverEntranceMenuView.access$setBottomView$p(r6, this.bottomView);
            OPopoverEntranceMenuView.access$setOption$p(r6, this.isOption);
            OPopoverEntranceMenuView.access$setImgGetter$p(r6, this.imgGetter);
            OPopoverEntranceMenuView.access$setTailImgGetter$p(r6, this.tailImgGetter);
            OPopoverEntranceMenuView.access$setWidthConstraint$p(r6, this.widthConstraint);
            OPopoverEntranceMenuView.access$setTitleSingleLine$p(r6, this.titleSingleLine);
            OPopoverEntranceMenuView.access$setItemWidth$p(r6, this.itemWidth);
            OPopoverEntranceMenuView.access$initView(r6);
            return r6;
        }
    }

    /* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Companion;", "", "()V", "DISABLED_ALPHA", "", "MAX_LINES", "", "MIN_AVAILABLE_HEIGHT_DP", "TAG", "", "WIDTH_BROAD_DP", "WIDTH_STANDARD_DP", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b/\b\u0002\u0018\u0000 G2\u00020\u0001:\u0001GBÍ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012:\b\u0002\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001bJ\u0006\u0010C\u001a\u00020\u0005J\u0006\u0010D\u001a\u00020\u0005J\u0006\u0010E\u001a\u00020\u0005J\u0006\u0010F\u001a\u00020\u0005R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010!\"\u0004\b(\u0010#R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010!\"\u0004\b)\u0010#R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'RL\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010%\"\u0004\b1\u0010'R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010%\"\u0004\b3\u0010'R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010%\"\u0004\b9\u0010'R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00105\"\u0004\b;\u00107R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010@\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010\f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00105\"\u0004\bB\u00107¨\u0006H"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$PopoverItem;", "", "radioOption", "", "enableCheckable", "", "imageRes", "tailImageRes", "resTint", "title", "", "subTitle", "value", "isHighlighted", "isEnabled", "onClick", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "pos", "", "itemType", "badgeInfo", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;", "titleColor", "(IZIIILjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLkotlin/jvm/functions/Function2;ILcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Ljava/lang/Integer;)V", "getBadgeInfo", "()Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;", "setBadgeInfo", "(Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;)V", "getEnableCheckable", "()Z", "setEnableCheckable", "(Z)V", "getImageRes", "()I", "setImageRes", "(I)V", "setEnabled", "setHighlighted", "getItemType", "setItemType", "getOnClick", "()Lkotlin/jvm/functions/Function2;", "setOnClick", "(Lkotlin/jvm/functions/Function2;)V", "getRadioOption", "setRadioOption", "getResTint", "setResTint", "getSubTitle", "()Ljava/lang/CharSequence;", "setSubTitle", "(Ljava/lang/CharSequence;)V", "getTailImageRes", "setTailImageRes", "getTitle", "setTitle", "getTitleColor", "()Ljava/lang/Integer;", "setTitleColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getValue", "setValue", "hasImage", "isLeftRadio", "isRadioChecked", "isRightRadio", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class PopoverItem {
        public static final Companion Companion = null;
        private static final PopoverItem DIVIDER = null;
        public static final int MASK_RADIO_CHECKED = 4;
        public static final int MASK_RADIO_POS_LEFT = 1;
        public static final int MASK_RADIO_POS_RIGHT = 2;
        public static final int MULTI_OPTION = 2;
        public static final int SINGLE_OPTION = 1;
        public static final int TYPE_DIVIDER = 1;
        public static final int TYPE_ITEM = 0;
        public static final int TYPE_SECTION_BAR = 2;
        private Builder.BadgeInfo badgeInfo;
        private boolean enableCheckable;
        private int imageRes;
        private boolean isEnabled;
        private boolean isHighlighted;
        private int itemType;
        private Function2<? super View, ? super Integer, Unit> onClick;
        private int radioOption;
        private int resTint;
        private CharSequence subTitle;
        private int tailImageRes;
        private CharSequence title;
        private Integer titleColor;
        private CharSequence value;

        /* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$PopoverItem$Companion;", "", "()V", "DIVIDER", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$PopoverItem;", "getDIVIDER", "()Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$PopoverItem;", "MASK_RADIO_CHECKED", "", "MASK_RADIO_POS_LEFT", "MASK_RADIO_POS_RIGHT", "MULTI_OPTION", "SINGLE_OPTION", "TYPE_DIVIDER", "TYPE_ITEM", "TYPE_SECTION_BAR", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }

            public final PopoverItem getDIVIDER() {
                return PopoverItem.access$getDIVIDER$cp();
            }
        }

        public PopoverItem() {
            this(0, false, 0, 0, 0, null, null, null, false, false, null, 0, null, null, 16383, null);
        }

        public PopoverItem(int r1, boolean r2, int r3, int r4, int r5, CharSequence r6, CharSequence r7, CharSequence r8, boolean r9, boolean r10, Function2<? super View, ? super Integer, Unit> r11, int r12, Builder.BadgeInfo r13, Integer r14) {
            this.radioOption = r1;
            this.enableCheckable = r2;
            this.imageRes = r3;
            this.tailImageRes = r4;
            this.resTint = r5;
            this.title = r6;
            this.subTitle = r7;
            this.value = r8;
            this.isHighlighted = r9;
            this.isEnabled = r10;
            this.onClick = r11;
            this.itemType = r12;
            this.badgeInfo = r13;
            this.titleColor = r14;
        }

        public static final /* synthetic */ PopoverItem access$getDIVIDER$cp() {
            return DIVIDER;
        }

        public final int getRadioOption() {
            return this.radioOption;
        }

        public final void setRadioOption(int r1) {
            this.radioOption = r1;
        }

        public final boolean getEnableCheckable() {
            return this.enableCheckable;
        }

        public final void setEnableCheckable(boolean r1) {
            this.enableCheckable = r1;
        }

        public final int getImageRes() {
            return this.imageRes;
        }

        public final void setImageRes(int r1) {
            this.imageRes = r1;
        }

        public final int getTailImageRes() {
            return this.tailImageRes;
        }

        public final void setTailImageRes(int r1) {
            this.tailImageRes = r1;
        }

        public final int getResTint() {
            return this.resTint;
        }

        public final void setResTint(int r1) {
            this.resTint = r1;
        }

        public /* synthetic */ PopoverItem(int r16, boolean r17, int r18, int r19, int r20, CharSequence r21, CharSequence r22, CharSequence r23, boolean r24, boolean r25, Function2 r26, int r27, Builder.BadgeInfo r28, Integer r29, int r30, DefaultConstructorMarker r31) {
            int r2 = 0;
            if ((r30 & 1) == 0) goto L5;
            int r1 = 0;
        L7:
            if ((r30 & 2) == 0) goto L9;
            boolean r3 = false;
        L11:
            if ((r30 & 4) == 0) goto L13;
            int r4 = 0;
        L15:
            if ((r30 & 8) == 0) goto L17;
            int r5 = 0;
        L19:
            if ((r30 & 16) == 0) goto L21;
            int r6 = 0;
        L23:
            if ((r30 & 32) == 0) goto L25;
        L26:
            Integer r9 = null;
            if ((r30 & 64) == 0) goto L29;
            CharSequence r8 = null;
        L31:
            if ((r30 & 128) == 0) goto L33;
            CharSequence r10 = null;
        L35:
            if ((r30 & 256) == 0) goto L37;
            boolean r11 = false;
        L39:
            if ((r30 & 512) == 0) goto L41;
            boolean r12 = true;
        L43:
            if ((r30 & 1024) == 0) goto L45;
            Function2 r13 = null;
        L47:
            if ((r30 & 2048) != 0) goto L51;
            r2 = r27;
        L51:
            if ((r30 & 4096) == 0) goto L53;
            Builder.BadgeInfo r14 = null;
        L55:
            if ((r30 & 8192) != 0) goto L58;
            r9 = r29;
        L58:
            this(r1, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r2, r14, r9);
            return;
        L53:
            r14 = r28;
            goto L55
        L45:
            r13 = r26;
            goto L47
        L41:
            r12 = r25;
            goto L43
        L37:
            r11 = r24;
            goto L39
        L33:
            r10 = r23;
            goto L35
        L29:
            r8 = r22;
            goto L31
        L25:
            CharSequence r7 = r21;
            goto L26
        L21:
            r6 = r20;
            goto L23
        L17:
            r5 = r19;
            goto L19
        L13:
            r4 = r18;
            goto L15
        L9:
            r3 = r17;
            goto L11
        L5:
            r1 = r16;
            goto L7
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final void setTitle(CharSequence r1) {
            this.title = r1;
        }

        public final CharSequence getSubTitle() {
            return this.subTitle;
        }

        public final void setSubTitle(CharSequence r1) {
            this.subTitle = r1;
        }

        public final CharSequence getValue() {
            return this.value;
        }

        public final void setValue(CharSequence r1) {
            this.value = r1;
        }

        public final boolean isHighlighted() {
            return this.isHighlighted;
        }

        public final void setHighlighted(boolean r1) {
            this.isHighlighted = r1;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        public final void setEnabled(boolean r1) {
            this.isEnabled = r1;
        }

        public final Function2<View, Integer, Unit> getOnClick() {
            return this.onClick;
        }

        public final void setOnClick(Function2<? super View, ? super Integer, Unit> r1) {
            this.onClick = r1;
        }

        public final int getItemType() {
            return this.itemType;
        }

        public final void setItemType(int r1) {
            this.itemType = r1;
        }

        public final Builder.BadgeInfo getBadgeInfo() {
            return this.badgeInfo;
        }

        public final void setBadgeInfo(Builder.BadgeInfo r1) {
            this.badgeInfo = r1;
        }

        public final Integer getTitleColor() {
            return this.titleColor;
        }

        public final void setTitleColor(Integer r1) {
            this.titleColor = r1;
        }

        static {
            Companion = new Companion(null);
            DIVIDER = new PopoverItem(0, false, 0, 0, 0, null, null, null, false, false, null, 1, null, null, 14335, null);
        }

        public final boolean isRadioChecked() {
            if ((this.radioOption & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isLeftRadio() {
            if ((this.radioOption & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public final boolean isRightRadio() {
            if ((this.radioOption & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean hasImage() {
            if (this.imageRes == 0) goto L5;
        L8:
            return true;
        L5:
            if (this.tailImageRes != 0) goto L8;
            return false;
        }
    }

    /* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Builder.BadgeInfo.Style.values().length];
            r0[Builder.BadgeInfo.Style.DOT.ordinal()] = 1;
            r0[Builder.BadgeInfo.Style.NUMBER.ordinal()] = 2;
            r0[Builder.BadgeInfo.Style.ELLIPSIS.ordinal()] = 3;
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: compiled from: OPopoverEntranceMenuView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$WidthLevel;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "WIDTH_LEVEL_STANDARD", "WIDTH_LEVEL_BROAD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum WidthLevel extends Enum<WidthLevel> {
        private static final /* synthetic */ WidthLevel[] $VALUES = null;
        public static final WidthLevel WIDTH_LEVEL_BROAD = null;
        public static final WidthLevel WIDTH_LEVEL_STANDARD = null;
        private final int value;

        private static final /* synthetic */ WidthLevel[] $values() {
            return new WidthLevel[]{WIDTH_LEVEL_STANDARD, WIDTH_LEVEL_BROAD};
        }

        public static WidthLevel valueOf(String r1) {
            return (WidthLevel) Enum.valueOf(WidthLevel.class, r1);
        }

        public static WidthLevel[] values() {
            return (WidthLevel[]) $VALUES.clone();
        }

        private WidthLevel(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            WIDTH_LEVEL_STANDARD = new WidthLevel("WIDTH_LEVEL_STANDARD", 0, OPopoverEntranceMenuView.access$getWIDTH_STANDARD_DP$cp());
            WIDTH_LEVEL_BROAD = new WidthLevel("WIDTH_LEVEL_BROAD", 1, OPopoverEntranceMenuView.access$getWIDTH_BROAD_DP$cp());
            $VALUES = $values();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$26z9Iy-3_J4M4HfwEU2cCB6-D_o, reason: not valid java name */
    public static /* synthetic */ void m608$r8$lambda$26z9Iy3_J4M4HfwEU2cCB6D_o(PopoverItem r0, View r1, int r2) {
        m611addPopoverItems$lambda12$lambda3$lambda2(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$hpicKzIZAcygweqTrnG-tTvJ-o4, reason: not valid java name */
    public static /* synthetic */ void m609$r8$lambda$hpicKzIZAcygweqTrnGtTvJo4(PopoverItem r0, CheckableImageView r1, LinearLayout r2, OPopoverEntranceMenuView r3, int r4, View r5) {
        m610addPopoverItems$lambda12$lambda3(r0, r1, r2, r3, r4, r5);
    }

    public OPopoverEntranceMenuView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OPopoverEntranceMenuView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OPopoverEntranceMenuView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ int access$getWIDTH_BROAD_DP$cp() {
        return WIDTH_BROAD_DP;
    }

    public static final /* synthetic */ int access$getWIDTH_STANDARD_DP$cp() {
        return WIDTH_STANDARD_DP;
    }

    public static final /* synthetic */ void access$initView(OPopoverEntranceMenuView r0) {
        r0.initView();
    }

    public static final /* synthetic */ void access$setBottomView$p(OPopoverEntranceMenuView r0, View r1) {
        r0.bottomView = r1;
    }

    public static final /* synthetic */ void access$setBottomViewHeight$p(OPopoverEntranceMenuView r0, int r1) {
        r0.bottomViewHeight = r1;
    }

    public static final /* synthetic */ void access$setImgGetter$p(OPopoverEntranceMenuView r0, Function1 r1) {
        r0.imgGetter = r1;
    }

    public static final /* synthetic */ void access$setItemHeight$p(OPopoverEntranceMenuView r0, int r1) {
        r0.itemHeight = r1;
    }

    public static final /* synthetic */ void access$setItemLayoutProcess$p(OPopoverEntranceMenuView r0, Function1 r1) {
        r0.itemLayoutProcess = r1;
    }

    public static final /* synthetic */ void access$setItemWidth$p(OPopoverEntranceMenuView r0, int r1) {
        r0.itemWidth = r1;
    }

    public static final /* synthetic */ void access$setItems$p(OPopoverEntranceMenuView r0, ArrayList r1) {
        r0.items = r1;
    }

    public static final /* synthetic */ void access$setOption$p(OPopoverEntranceMenuView r0, int r1) {
        r0.isOption = r1;
    }

    public static final /* synthetic */ void access$setTailImgGetter$p(OPopoverEntranceMenuView r0, Function1 r1) {
        r0.tailImgGetter = r1;
    }

    public static final /* synthetic */ void access$setTitleSingleLine$p(OPopoverEntranceMenuView r0, boolean r1) {
        r0.titleSingleLine = r1;
    }

    public static final /* synthetic */ void access$setTopDividerVisibility$p(OPopoverEntranceMenuView r0, boolean r1) {
        r0.topDividerVisibility = r1;
    }

    public static final /* synthetic */ void access$setTopView$p(OPopoverEntranceMenuView r0, View r1) {
        r0.topView = r1;
    }

    public static final /* synthetic */ void access$setTopViewHeight$p(OPopoverEntranceMenuView r0, int r1) {
        r0.topViewHeight = r1;
    }

    public static final /* synthetic */ void access$setWidthConstraint$p(OPopoverEntranceMenuView r0, Pair r1) {
        r0.widthConstraint = r1;
    }

    public OPopoverEntranceMenuView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.itemLayoutProcess = OPopoverEntranceMenuView$itemLayoutProcess$1.INSTANCE;
        this.items = new ArrayList();
        this.itemWidth = OUnitExtensionKt.cdp(r2, WIDTH_STANDARD_DP);
        this.verticalPadding = OUnitExtensionKt.cdp(r2, 8);
        this.itemVerticalMargin = OUnitExtensionKt.cdp(r2, 4);
        if (r2.getResources().getConfiguration().orientation != 2) goto L5;
        int r5 = r2.getResources().getDimensionPixelSize(R.dimen.oui_popover_max_height_landscape);
    L6:
        this.defaultMaxHeight = r5;
        this.maxHeight = r5;
        return;
    L5:
        r5 = r2.getResources().getDimensionPixelSize(R.dimen.oui_popover_max_height);
        goto L6
    }

    private final void initView() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.o_view_popover_menu_type, this, true);
        MaxHeightNestedScrollView r0 = (MaxHeightNestedScrollView) findViewById(R.id.popover_scroll);
        this.popOverScroll = r0;
        if (r0 == null) goto L6;
        r0.setMaxHeight(this.maxHeight);
    L6:
        MaxHeightNestedScrollView r1 = this.popOverScroll;
        if (r1 == null) goto L10;
        int r2 = this.verticalPadding;
        r1.setPadding(0, r2, 0, r2);
    L10:
        MaxHeightNestedScrollView r3 = this.popOverScroll;
        if (r3 == null) goto L14;
        r3.setScrollBarStyle(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
    L14:
        MaxHeightNestedScrollView r4 = this.popOverScroll;
        if (r4 == null) goto L18;
        r4.setClipToPadding(false);
    L18:
        int r5 = -2;
        if (this.topView == null) goto L28;
        ViewGroup r6 = (ViewGroup) findViewById(R.id.top_container);
        r6.addView(this.topView, new ViewGroup.LayoutParams(-1, -2));
        if (this.widthConstraint == null) goto L23;
        r6.getLayoutParams().width = -2;
    L24:
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        int r8 = this.topViewHeight;
        if (r8 != 0) goto L27;
        r8 = -2;
    L27:
        r7.height = r8;
        goto L28
    L23:
        r6.getLayoutParams().width = getAvailableItemWidth();
    L28:
        addPopoverItems();
        if (this.bottomView == null) goto L40;
        ViewGroup r9 = (ViewGroup) findViewById(R.id.bottom_container);
        r9.addView(this.bottomView, new ViewGroup.LayoutParams(-1, -2));
        if (this.widthConstraint == null) goto L33;
        r9.getLayoutParams().width = -2;
    L34:
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        int r11 = this.bottomViewHeight;
        if (r11 == 0) goto L38;
        r5 = r11;
    L38:
        r10.height = r5;
        goto L40
    L33:
        r9.getLayoutParams().width = getAvailableItemWidth();
    L40:
        if (this.widthConstraint == null) goto L43;
        measure(0, 0);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "initView, handle widthConstraint: " + this.widthConstraint + ", measuredWidth: " + getMeasuredWidth());
        int r12 = getMeasuredWidth();
        Pair<Integer, Integer> r13 = this.widthConstraint;
        Intrinsics.checkNotNull(r13);
        int r14 = r13.getFirst().intValue();
        Pair<Integer, Integer> r15 = this.widthConstraint;
        Intrinsics.checkNotNull(r15);
        this.itemWidth = RangesKt.coerceIn(r12, r14, r15.getSecond().intValue());
        this.widthConstraint = null;
        clearViews();
        initView();
        return;
    }

    private final void clearViews() {
        ((FrameLayout) findViewById(R.id.top_container)).removeAllViews();
        ((LinearLayout) findViewById(R.id.popover_container)).removeAllViews();
        ((FrameLayout) findViewById(R.id.bottom_container)).removeAllViews();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void addPopoverItems() {
        LinearLayout r7 = (LinearLayout) findViewById(R.id.popover_container);
        Iterator r8 = this.items.iterator();
        boolean r9 = false;
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r8.hasNext() == false) goto L190;
        Object r0 = r8.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        final PopoverItem r13 = (PopoverItem) r0;
        if (r13.getItemType() == 1) goto L10;
        if (r13.getItemType() == 2) goto L13;
        if (r13.isLeftRadio() == false) goto L22;
    L25:
        Object[] r1 = 1;
    L27:
        if (r1 == 0) goto L33;
        View r3 = LayoutInflater.from(getContext()).inflate(R.layout.o_item_popover_menu_filter, r7, r9);
        if (r3 == null) goto L32;
        PopoverMenuLinearLayout r4 = (PopoverMenuLinearLayout) r3;
    L36:
        PopoverMenuLinearLayout r14 = r4;
        OStateGradientDrawable r2 = new OStateGradientDrawable();
        Context r5 = getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "context");
        r2.setCornerRadius(OUnitExtensionKt.cdpFloat(r5, 20));
        ColorStateList r6 = ContextCompat.getColorStateList(getContext(), R.color.o_pop_list_item_bg_color);
        Intrinsics.checkNotNull(r6);
        Intrinsics.checkNotNullExpressionValue(r6, "getColorStateList(contex…pop_list_item_bg_color)!!");
        r2.setSolidColors(r6);
        r14.setBackground(r2);
        LinearLayout r15 = (LinearLayout) r14.findViewById(R.id.item_container);
        ImageView r16 = (ImageView) r14.findViewById(R.id.iv_popover_action);
        ImageView r17 = (ImageView) r14.findViewById(R.id.iv_popover_tail_image);
        OTextView r18 = (OTextView) r14.findViewById(R.id.tv_popover_action);
        OTextView r19 = (OTextView) r14.findViewById(R.id.tv_popover_action_sub);
        OTextView r20 = (OTextView) r14.findViewById(R.id.tv_popover_value);
        LinearLayout.LayoutParams r21 = null;
        if (r1 == 0) goto L39;
        CheckableImageView r22 = (CheckableImageView) r14.findViewById(R.id.popover_menu_radio);
    L40:
        View r23 = r14.findViewById(R.id.popover_badge_default);
        OBadgeView r24 = (OBadgeView) r14.findViewById(R.id.popover_badge_number);
        OBadgeView r25 = (OBadgeView) r14.findViewById(R.id.popover_badge_ellipsis);
        LinearLayout r26 = (LinearLayout) r14.findViewById(R.id.ll_popover_text_container);
        Builder.BadgeInfo r27 = r13.getBadgeInfo();
        if (r27 == null) goto L54;
        int r28 = WhenMappings.$EnumSwitchMapping$0[r27.getBadgeType().ordinal()];
        if (r28 != 1) goto L46;
        r23.setVisibility(0);
    L53:
        Unit r29 = Unit.INSTANCE;
        Unit r30 = Unit.INSTANCE;
        goto L54
    L46:
        if (r28 != 2) goto L48;
        r24.setVisibility(0);
        r24.setMaxNumberInCount(r27.getMaxNumber());
        r24.setText(String.valueOf(r27.getCount()));
        goto L53
    L48:
        if (r28 != 3) goto L53;
        r25.setVisibility(0);
    L54:
        if (r22 != null) goto L57;
    L61:
        final CheckableImageView r31 = r22;
        final LinearLayout r32 = r7;
        LinearLayout r210 = r7;
        final int r33 = r11;
        r14.setOnClickListener(new OPopoverEntranceMenuView$$ExternalSyntheticLambda1(r13, r31, r32, this, r33));
        if (this.widthConstraint == null) goto L64;
        int r34 = -2;
        r14.getLayoutParams().width = -2;
    L66:
        if (r13.getSubTitle() != null) goto L72;
        r19.setVisibility(8);
        ViewGroup.LayoutParams r35 = r14.getLayoutParams();
        int r36 = this.itemHeight;
        if (r36 == 0) goto L71;
        r34 = r36;
    L71:
        r35.height = r34;
    L77:
        r19.setText(r13.getSubTitle());
        r20.setText(r13.getValue());
        if (TextUtils.isEmpty(r13.getValue()) == false) goto L80;
        int r37 = 8;
    L81:
        r20.setVisibility(r37);
        if (this.items.size() != 1) goto L91;
        r14.setIndexPos(PopoverMenuLinearLayout.Index.ONLY_ONE);
        ViewGroup.LayoutParams r38 = r14.getLayoutParams();
        if ((r38 instanceof LinearLayout.LayoutParams) == false) goto L86;
        LinearLayout.LayoutParams r39 = (LinearLayout.LayoutParams) r38;
    L87:
        if (r39 == null) goto L109;
        r39.topMargin = 0;
        r39.bottomMargin = 0;
        Unit r40 = Unit.INSTANCE;
    L109:
        int r41 = 0;
    L110:
        registerPressedCallback(r14);
        if (r13.getImageRes() == 0) goto L119;
        r16.setVisibility(r41);
        Function1<? super Integer, ? extends Drawable> r42 = this.imgGetter;
        if (r42 == null) goto L118;
        if (r42 != null) goto L116;
        Drawable r43 = null;
    L117:
        r16.setImageDrawable(r43);
    L121:
        if (r13.getTailImageRes() == 0) goto L129;
        ImageView r44 = r17;
        r44.setVisibility(0);
        Function1<? super Integer, ? extends Drawable> r45 = this.tailImgGetter;
        if (r45 == null) goto L128;
        if (r45 != null) goto L126;
        Drawable r46 = null;
    L127:
        r44.setImageDrawable(r46);
    L131:
        if (r13.getTitle() == null) goto L133;
        OTextView r47 = r18;
        r47.setText(r13.getTitle());
    L134:
        r47.setSingleLine(this.titleSingleLine);
        r47.setEllipsize(TextUtils.TruncateAt.END);
        if (this.titleSingleLine == false) goto L137;
        int r48 = 1;
    L138:
        r47.setMaxLines(r48);
        if (r13.getResTint() == 0) goto L141;
        r16.setImageTintList(ColorStateList.valueOf(r13.getResTint()));
        r44.setImageTintList(ColorStateList.valueOf(r13.getResTint()));
    L141:
        Integer r49 = r13.getTitleColor();
        if (r49 == null) goto L146;
        r47.setTextColor(r49.intValue());
        Unit r50 = Unit.INSTANCE;
    L146:
        if (getForceDark() == false) goto L149;
        int r51 = ContextCompat.getColor(getContext(), R.color.ConstTextInverse2);
        r47.setTextColor(r51);
        r16.setImageTintList(ColorStateList.valueOf(r51));
        r44.setImageTintList(ColorStateList.valueOf(r51));
        r14.setForceDark(true);
    L149:
        if (r13.isHighlighted() == false) goto L152;
        int r52 = ContextCompat.getColor(getContext(), R.color.Negative);
        r47.setTextColor(r52);
        r16.setImageTintList(ColorStateList.valueOf(r52));
    L152:
        if (r31 != null) goto L155;
        boolean r53 = false;
    L187:
        this.itemLayoutProcess.invoke(r14);
        applyItemEnabledState(r14, r13.isEnabled());
        r210.addView(r14);
        r11 = r11 + 1;
        r7 = r210;
        r9 = r53;
        r10 = r12;
        r8 = r8;
        goto L4
    L155:
        if (r13.getResTint() == 0) goto L157;
        int r54 = r13.getResTint();
    L158:
        r31.setImageTintList(ColorStateList.valueOf(r54));
        r31.setVisibility(0);
        r31.setChecked(r13.isRadioChecked());
        if (r13.isRightRadio() == false) goto L185;
        ViewGroup.LayoutParams r55 = r31.getLayoutParams();
        if ((r55 instanceof LinearLayout.LayoutParams) == false) goto L163;
        LinearLayout.LayoutParams r56 = (LinearLayout.LayoutParams) r55;
    L164:
        if (r56 != null) goto L166;
        String r57 = "context";
        r53 = false;
    L167:
        CheckableImageView r58 = r31;
        r15.removeView(r58);
        r15.addView(r58);
        ViewGroup.LayoutParams r59 = r16.getLayoutParams();
        if ((r59 instanceof LinearLayout.LayoutParams) == false) goto L170;
        LinearLayout.LayoutParams r60 = (LinearLayout.LayoutParams) r59;
    L172:
        if (r60 == null) goto L176;
        Context r61 = getContext();
        Intrinsics.checkNotNullExpressionValue(r61, r57);
        r60.setMarginStart(OUnitExtensionKt.cdp(r61, 12));
        Unit r62 = Unit.INSTANCE;
    L176:
        if (r16.getVisibility() != 8) goto L186;
        if (r26 == null) goto L186;
        ViewGroup.LayoutParams r63 = r26.getLayoutParams();
        if ((r63 instanceof LinearLayout.LayoutParams) == false) goto L181;
        r21 = (LinearLayout.LayoutParams) r63;
    L181:
        LinearLayout.LayoutParams r64 = r21;
        if (r64 == null) goto L186;
        Context r65 = getContext();
        Intrinsics.checkNotNullExpressionValue(r65, r57);
        r64.setMarginStart(OUnitExtensionKt.cdp(r65, 12));
        Unit r66 = Unit.INSTANCE;
    L186:
        Unit r67 = Unit.INSTANCE;
        Unit r68 = Unit.INSTANCE;
        goto L187
    L170:
        r60 = null;
        goto L172
    L166:
        r53 = false;
        r56.setMarginStart(0);
        Context r69 = getContext();
        r57 = "context";
        Intrinsics.checkNotNullExpressionValue(r69, r57);
        r56.setMarginEnd(OUnitExtensionKt.cdp(r69, 8));
        Unit r70 = Unit.INSTANCE;
        goto L167
    L163:
        r56 = null;
        goto L164
    L185:
        r53 = false;
        goto L186
    L157:
        r54 = ContextCompat.getColor(getContext(), R.color.oui_accent_fg);
        goto L158
    L137:
        r48 = MAX_LINES;
        goto L138
    L133:
        r47 = r18;
        goto L134
    L126:
        r46 = r45.invoke(Integer.valueOf(r13.getTailImageRes()));
        goto L127
    L128:
        r44.setImageResource(r13.getTailImageRes());
        goto L131
    L129:
        r44 = r17;
        r44.setVisibility(8);
        goto L131
    L116:
        r43 = r42.invoke(Integer.valueOf(r13.getImageRes()));
        goto L117
    L118:
        r16.setImageResource(r13.getImageRes());
        goto L121
    L119:
        r16.setVisibility(8);
        goto L121
    L86:
        r39 = null;
        goto L87
    L91:
        if (r10 != (this.items.size() - 1)) goto L99;
        r14.setIndexPos(PopoverMenuLinearLayout.Index.LAST);
        ViewGroup.LayoutParams r71 = r14.getLayoutParams();
        if ((r71 instanceof LinearLayout.LayoutParams) == false) goto L95;
        LinearLayout.LayoutParams r72 = (LinearLayout.LayoutParams) r71;
    L96:
        if (r72 == null) goto L109;
        r72.topMargin = 0;
        r72.bottomMargin = 0;
        Unit r73 = Unit.INSTANCE;
        goto L109
    L95:
        r72 = null;
        goto L96
    L99:
        if (r10 < 0) goto L109;
        if (r10 != 0) goto L102;
        r14.setIndexPos(PopoverMenuLinearLayout.Index.FIRST);
    L102:
        ViewGroup.LayoutParams r74 = r14.getLayoutParams();
        if ((r74 instanceof LinearLayout.LayoutParams) == false) goto L105;
        LinearLayout.LayoutParams r75 = (LinearLayout.LayoutParams) r74;
    L106:
        if (r75 == null) goto L109;
        r41 = 0;
        r75.topMargin = 0;
        r75.bottomMargin = this.itemVerticalMargin;
        Unit r76 = Unit.INSTANCE;
        goto L110
    L105:
        r75 = null;
        goto L106
    L80:
        r37 = 0;
        goto L81
    L72:
        r19.setVisibility(0);
        ViewGroup.LayoutParams r77 = r14.getLayoutParams();
        int r78 = this.itemHeight;
        if (r78 == 0) goto L76;
        r34 = r78;
    L76:
        r77.height = r34;
        goto L77
    L64:
        r34 = -2;
        r14.getLayoutParams().width = getAvailableItemWidth();
        goto L66
    L57:
        if (r13.getEnableCheckable() == false) goto L59;
        int r79 = 0;
    L60:
        r22.setVisibility(r79);
        goto L61
    L59:
        r79 = 4;
        goto L60
    L39:
        r22 = null;
        goto L40
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.menu.PopoverMenuLinearLayout");
    L33:
        View r80 = LayoutInflater.from(getContext()).inflate(R.layout.o_item_popover_menu_type, r7, r9);
        if (r80 == null) goto L189;
        r4 = (PopoverMenuLinearLayout) r80;
        goto L36
    L189:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.menu.PopoverMenuLinearLayout");
    L22:
        if (r13.isRightRadio() == true) goto L25;
        r1 = r9 ? 1 : 0;
        goto L27
    L13:
        View r81 = LayoutInflater.from(getContext()).inflate(R.layout.o_item_popover_menu_sectionbar, r7, r9);
        if (r81 == null) goto L18;
        OSectionTitleBar r82 = (OSectionTitleBar) r81;
        r82.setTitleText(String.valueOf(r13.getTitle()));
        LinearLayout.LayoutParams r83 = new LinearLayout.LayoutParams(-1, -2);
        r83.bottomMargin = this.itemVerticalMargin;
        r7.addView(r82, r83);
    L16:
        r10 = r12;
        goto L4
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.sectiontitlebar.OSectionTitleBar");
    L10:
        Context r84 = getContext();
        Intrinsics.checkNotNullExpressionValue(r84, "context");
        ODivider r85 = new ODivider(r84, null, 0, 6, null);
        r85.setBackground(getContext().getDrawable(R.drawable.o_item_vertical_divider));
        Context r86 = getContext();
        Intrinsics.checkNotNullExpressionValue(r86, "context");
        int r87 = OUnitExtensionKt.cdp(r86, 8);
        r85.setPadding(r87, r9 ? 1 : 0, r87, r9 ? 1 : 0);
        ViewGroup.MarginLayoutParams r88 = new ViewGroup.MarginLayoutParams(-1, -2);
        r88.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.oui_popover_divider_margin);
        r88.rightMargin = r88.leftMargin;
        r88.bottomMargin = this.itemVerticalMargin;
        r7.addView(r85, r88);
        goto L16
    }

    /* JADX INFO: renamed from: addPopoverItems$lambda-12$lambda-3, reason: not valid java name */
    private static final void m610addPopoverItems$lambda12$lambda3(final PopoverItem r5, CheckableImageView r6, LinearLayout r7, OPopoverEntranceMenuView r8, final int r9, final View r10) {
        Intrinsics.checkNotNullParameter(r5, "$item");
        Intrinsics.checkNotNullParameter(r8, "this$0");
        if (r5.getEnableCheckable() == false) goto L19;
        if (r6 == null) goto L19;
        boolean r0 = !r6.isChecked();
        if (r8.isOption != 1) goto L18;
        int r11 = r7.getChildCount();
        int r2 = 0;
    L9:
        if (r2 >= r11) goto L17;
        int r3 = r2 + 1;
        View r4 = r7.getChildAt(r2);
        if ((r4 instanceof PopoverMenuLinearLayout) == false) goto L16;
        CheckableImageView r12 = (CheckableImageView) r4.findViewById(R.id.popover_menu_radio);
        if (r12 == null) goto L16;
        r12.setChecked(false);
    L16:
        r2 = r3;
        goto L9
    L17:
        r6.setChecked(true);
        goto L19
    L18:
        r6.setChecked(r0);
    L19:
        r7.post(new OPopoverEntranceMenuView$$ExternalSyntheticLambda0(r5, r10, r9));
    }

    /* JADX INFO: renamed from: addPopoverItems$lambda-12$lambda-3$lambda-2, reason: not valid java name */
    private static final void m611addPopoverItems$lambda12$lambda3$lambda2(PopoverItem r1, View r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "$item");
        Function2<View, Integer, Unit> r4 = r1.getOnClick();
        if (r4 == null) goto L7;
        Intrinsics.checkNotNullExpressionValue(r2, "it");
        r4.invoke(r2, Integer.valueOf(r3));
        return;
    }

    private final void applyItemEnabledState(PopoverMenuLinearLayout r1, boolean r2) {
        r1.setEnabled(r2);
        r1.setClickable(r2);
        if (r2 == false) goto L5;
        float r0 = 1.0f;
    L6:
        r1.setAlpha(r0);
        return;
    L5:
        r0 = 0.3f;
        goto L6
    }

    private final PopoverItem findItemByPosition(int r2) {
        if (r2 >= 0) goto L6;
        return null;
    L6:
        return (PopoverItem) SequencesKt.elementAtOrNull(SequencesKt.filter(CollectionsKt.asSequence(this.items), AnonymousClass1.INSTANCE), r2);
    }

    public final void setItemEnabled(int r2, boolean r3) {
        PopoverMenuLinearLayout r0 = getItemView(r2);
        if (r0 != null) goto L5;
        return;
    L5:
        applyItemEnabledState(r0, r3);
        PopoverItem r1 = findItemByPosition(r2);
        if (r1 != null) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, Intrinsics.stringPlus("setItemEnabled: no item model for position=", Integer.valueOf(r2)));
        return;
    L9:
        r1.setEnabled(r3);
    }

    public final PopoverMenuLinearLayout getItemView(int r3) {
        if (r3 >= 0) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, Intrinsics.stringPlus("getItemView: invalid position=", Integer.valueOf(r3)));
        return null;
    L6:
        LinearLayout r2 = (LinearLayout) findViewById(R.id.popover_container);
        Intrinsics.checkNotNullExpressionValue(r2, "popoverContainer");
        PopoverMenuLinearLayout r4 = (PopoverMenuLinearLayout) SequencesKt.elementAtOrNull(SequencesKt.filter(ViewGroupKt.getChildren(r2), OPopoverEntranceMenuView$getItemView$$inlined$filterIsInstance$1.INSTANCE), r3);
        if (r4 != null) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, Intrinsics.stringPlus("getItemView: no item view for position=", Integer.valueOf(r3)));
    L9:
        return r4;
    }

    private final int getAvailableItemWidth() {
        return this.itemWidth;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r4, int r5) {
        int r0 = View.MeasureSpec.getMode(r5);
        int r6 = View.MeasureSpec.getSize(r5);
        if (r0 != Integer.MIN_VALUE) goto L5;
        int r7 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(r6, this.maxHeight), Integer.MIN_VALUE);
    L9:
        super.onMeasure(r4, r7);
        if (getMeasuredHeight() <= this.maxHeight) goto L13;
        setMeasuredDimension(getMeasuredWidth(), this.maxHeight);
        return;
    L13:
        return;
    L5:
        if (r0 == 1073741824) goto L7;
        r7 = View.MeasureSpec.makeMeasureSpec(this.maxHeight, Integer.MIN_VALUE);
        goto L9
    L7:
        r7 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(r6, this.maxHeight), 1073741824);
        goto L9
    }

    @Override // com.obric.oui.popover.menu.OPopoverMenuView
    public void setPopoverMaxHeight(int r3) {
        int r4 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r3, OUnitExtensionKt.vdp(this, MIN_AVAILABLE_HEIGHT_DP)), this.defaultMaxHeight);
        if (this.maxHeight != r4) goto L5;
        return;
    L5:
        this.maxHeight = r4;
        MaxHeightNestedScrollView r0 = this.popOverScroll;
        if (r0 == null) goto L9;
        r0.setMaxHeight(r4);
    L9:
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    static {
        Companion = new Companion(null);
        WIDTH_STANDARD_DP = 184;
        WIDTH_BROAD_DP = 208;
        MAX_LINES = 6;
        MIN_AVAILABLE_HEIGHT_DP = 40;
    }
}

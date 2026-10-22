package com.obric.oui.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.utils.log.L;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OBaseIndicator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0005tuvwxB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0007H'J\b\u0010S\u001a\u00020TH&J\b\u0010U\u001a\u00020QH\u0014J\b\u0010V\u001a\u00020QH$J\b\u0010W\u001a\u00020QH$J\b\u0010X\u001a\u00020QH$J\b\u0010Y\u001a\u00020QH$J\b\u0010Z\u001a\u00020\u0007H\u0004J\b\u0010[\u001a\u00020QH\u0002J\u0010\u0010\\\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0007H&J\u0006\u0010]\u001a\u00020QJ\b\u0010^\u001a\u00020QH\u0004J\b\u0010_\u001a\u00020QH\u0004J\b\u0010`\u001a\u00020QH\u0004J\b\u0010a\u001a\u00020QH\u0002J\b\u0010b\u001a\u00020QH&J\u0010\u0010c\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0007H'J\b\u0010d\u001a\u00020QH\u0004J\u000e\u0010e\u001a\u00020Q2\u0006\u0010f\u001a\u00020\u0007J\u000e\u0010g\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u0007J&\u0010i\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00072\b\b\u0002\u0010f\u001a\u00020\u00072\n\b\u0002\u0010j\u001a\u0004\u0018\u00010kH\u0007J\u0010\u0010l\u001a\u00020Q2\u0006\u0010m\u001a\u00020nH\u0007J\u001c\u0010l\u001a\u00020Q2\u0006\u0010m\u001a\u00020n2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00070oJ\u0016\u0010l\u001a\u00020Q2\u0006\u0010m\u001a\u00020n2\u0006\u0010h\u001a\u00020\u0007J\u001c\u0010p\u001a\u00020Q2\u0006\u0010m\u001a\u00020q2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00070oJ\u0016\u0010p\u001a\u00020Q2\u0006\u0010m\u001a\u00020q2\u0006\u0010h\u001a\u00020\u0007J\u0014\u0010r\u001a\u00020\u0007*\u00020\u00072\u0006\u0010s\u001a\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00078\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R$\u0010$\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R&\u0010'\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00078\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR$\u0010*\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R$\u0010-\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010 R\u001a\u00100\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u0010\u0014R$\u00103\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010\u001aR(\u00107\u001a\u0004\u0018\u0001062\b\u0010\u0015\u001a\u0004\u0018\u000106@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u0004\u0018\u00010<2\b\u0010\u0015\u001a\u0004\u0018\u00010<@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0012\"\u0004\bF\u0010\u0014R$\u0010G\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0018\"\u0004\bI\u0010\u001aR$\u0010J\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0018\"\u0004\bL\u0010\u001aR$\u0010M\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0018\"\u0004\bO\u0010\u001a¨\u0006y"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "custom", "Lcom/obric/oui/indicator/OBaseIndicator$CustomDot;", "getCustom", "()Lcom/obric/oui/indicator/OBaseIndicator$CustomDot;", "dotsClickable", "", "getDotsClickable", "()Z", "setDotsClickable", "(Z)V", "value", "dotsColor", "getDotsColor", "()I", "setDotsColor", "(I)V", "", "dotsCornerRadius", "getDotsCornerRadius", "()F", "setDotsCornerRadius", "(F)V", "dotsHeight", "getDotsHeight", "setDotsHeight", "dotsSpacing", "getDotsSpacing", "setDotsSpacing", "dotsStrokeColor", "getDotsStrokeColor", "setDotsStrokeColor", "dotsStrokeWidth", "getDotsStrokeWidth", "setDotsStrokeWidth", "dotsWidth", "getDotsWidth", "setDotsWidth", "initialized", "getInitialized", "setInitialized", "layoutHeight", "getLayoutHeight", "setLayoutHeight", "Lcom/obric/oui/indicator/OBaseIndicator$Pager;", "pager", "getPager", "()Lcom/obric/oui/indicator/OBaseIndicator$Pager;", "setPager", "(Lcom/obric/oui/indicator/OBaseIndicator$Pager;)V", "Lcom/obric/oui/indicator/OBaseIndicator$ReleaseMe;", "pagerDataSetObserver", "setPagerDataSetObserver", "(Lcom/obric/oui/indicator/OBaseIndicator$ReleaseMe;)V", "pendingRefreshDots", "pendingRefreshDotsDraws", "pendingRefreshDotsSize", "pendingRefreshDotsSpacing", "pendingRefreshParentLayout", "getPendingRefreshParentLayout", "setPendingRefreshParentLayout", "sidePadding", "getSidePadding", "setSidePadding", "type", "getType", "setType", "verticalSidePadding", "getVerticalSidePadding", "setVerticalSidePadding", "addDot", "", "index", "buildOnPageChangedListener", "Lcom/obric/oui/indicator/OnPageChangeListenerHelper;", "onAttachedToWindow", "onRefreshDotsDraws", "onRefreshDotsSize", "onRefreshDotsSpacing", "onRefreshIndicator", "pagerCount", "postPendingRefresh", "refreshDotDraw", "refreshDots", "refreshDotsDraws", "refreshDotsSize", "refreshDotsSpacing", "refreshOnPageChangedListener", "refreshParentLayout", "removeDot", "setInitComplete", "setManualCurrentItem", "currentItem", "setManualPageCount", "pageCount", "setManualPager", "onPageSelected", "Lcom/obric/oui/indicator/OBaseIndicator$OnManualPageSelectedListener;", "setViewPager", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "Lkotlin/Function0;", "setViewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "mod", PerfConsts.PERF_DISK_FILE_NUM, "CustomDot", "ManualPager", "OnManualPageSelectedListener", "Pager", "ReleaseMe", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OBaseIndicator extends FrameLayout {
    private final String TAG;
    private boolean dotsClickable;
    private int dotsColor;
    private float dotsCornerRadius;
    private float dotsHeight;
    private float dotsSpacing;
    private int dotsStrokeColor;
    private float dotsStrokeWidth;
    private float dotsWidth;
    private boolean initialized;
    private int layoutHeight;
    private Pager pager;
    private ReleaseMe pagerDataSetObserver;
    private boolean pendingRefreshDots;
    private boolean pendingRefreshDotsDraws;
    private boolean pendingRefreshDotsSize;
    private boolean pendingRefreshDotsSpacing;
    private boolean pendingRefreshParentLayout;
    private int sidePadding;
    private int type;
    private int verticalSidePadding;

    /* JADX INFO: compiled from: OBaseIndicator.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\t\u0012\b\b\u0001\u0010\u000b\u001a\u00020\t\u0012\b\b\u0001\u0010\f\u001a\u00020\t\u0012\b\b\u0001\u0010\r\u001a\u00020\t\u0012\b\b\u0001\u0010\u000e\u001a\u00020\t\u0012\b\b\u0001\u0010\u000f\u001a\u00020\t\u0012\b\b\u0001\u0010\u0010\u001a\u00020\t\u0012\b\b\u0001\u0010\u0011\u001a\u00020\t\u0012\b\b\u0001\u0010\u0012\u001a\u00020\t¢\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\u0095\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\t2\b\b\u0003\u0010\f\u001a\u00020\t2\b\b\u0003\u0010\r\u001a\u00020\t2\b\b\u0003\u0010\u000e\u001a\u00020\t2\b\b\u0003\u0010\u000f\u001a\u00020\t2\b\b\u0003\u0010\u0010\u001a\u00020\t2\b\b\u0003\u0010\u0011\u001a\u00020\t2\b\b\u0003\u0010\u0012\u001a\u00020\tHÆ\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\tHÖ\u0001J\t\u00108\u001a\u000209HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019¨\u0006:"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator$CustomDot;", "", "defaultWidth", "", "defaultHeight", "defaultSpacing", "styleableId", "", "typeId", "", "layoutHeightId", "dotsWidthId", "dotsHeightId", "dotsSpacingId", "dotsColorId", "dotsCornerRadiusId", "dotsClickableId", "dotsStrokeColorId", "dotsStrokeWidthId", "(FFF[IIIIIIIIIII)V", "getDefaultHeight", "()F", "getDefaultSpacing", "getDefaultWidth", "getDotsClickableId", "()I", "getDotsColorId", "getDotsCornerRadiusId", "getDotsHeightId", "getDotsSpacingId", "getDotsStrokeColorId", "getDotsStrokeWidthId", "getDotsWidthId", "getLayoutHeightId", "getStyleableId", "()[I", "getTypeId", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CustomDot {
        private final float defaultHeight;
        private final float defaultSpacing;
        private final float defaultWidth;
        private final int dotsClickableId;
        private final int dotsColorId;
        private final int dotsCornerRadiusId;
        private final int dotsHeightId;
        private final int dotsSpacingId;
        private final int dotsStrokeColorId;
        private final int dotsStrokeWidthId;
        private final int dotsWidthId;
        private final int layoutHeightId;
        private final int[] styleableId;
        private final int typeId;

        public static /* synthetic */ CustomDot copy$default(CustomDot r15, float r16, float r17, float r18, int[] r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, Object r31) {
            if ((r30 & 1) == 0) goto L5;
            float r2 = r15.defaultWidth;
        L7:
            if ((r30 & 2) == 0) goto L9;
            float r3 = r15.defaultHeight;
        L11:
            if ((r30 & 4) == 0) goto L13;
            float r4 = r15.defaultSpacing;
        L15:
            if ((r30 & 8) == 0) goto L17;
            int[] r5 = r15.styleableId;
        L19:
            if ((r30 & 16) == 0) goto L21;
            int r6 = r15.typeId;
        L23:
            if ((r30 & 32) == 0) goto L25;
            int r7 = r15.layoutHeightId;
        L27:
            if ((r30 & 64) == 0) goto L29;
            int r8 = r15.dotsWidthId;
        L31:
            if ((r30 & 128) == 0) goto L33;
            int r9 = r15.dotsHeightId;
        L35:
            if ((r30 & 256) == 0) goto L37;
            int r10 = r15.dotsSpacingId;
        L39:
            if ((r30 & 512) == 0) goto L41;
            int r11 = r15.dotsColorId;
        L43:
            if ((r30 & 1024) == 0) goto L45;
            int r12 = r15.dotsCornerRadiusId;
        L47:
            if ((r30 & 2048) == 0) goto L49;
            int r13 = r15.dotsClickableId;
        L51:
            if ((r30 & 4096) == 0) goto L53;
            int r14 = r15.dotsStrokeColorId;
        L55:
            if ((r30 & 8192) == 0) goto L57;
            int r1 = r15.dotsStrokeWidthId;
        L59:
            return r15.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r1);
        L57:
            r1 = r29;
            goto L59
        L53:
            r14 = r28;
            goto L55
        L49:
            r13 = r27;
            goto L51
        L45:
            r12 = r26;
            goto L47
        L41:
            r11 = r25;
            goto L43
        L37:
            r10 = r24;
            goto L39
        L33:
            r9 = r23;
            goto L35
        L29:
            r8 = r22;
            goto L31
        L25:
            r7 = r21;
            goto L27
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
            r2 = r16;
            goto L7
        }

        public final float component1() {
            return this.defaultWidth;
        }

        public final int component10() {
            return this.dotsColorId;
        }

        public final int component11() {
            return this.dotsCornerRadiusId;
        }

        public final int component12() {
            return this.dotsClickableId;
        }

        public final int component13() {
            return this.dotsStrokeColorId;
        }

        public final int component14() {
            return this.dotsStrokeWidthId;
        }

        public final float component2() {
            return this.defaultHeight;
        }

        public final float component3() {
            return this.defaultSpacing;
        }

        public final int[] component4() {
            return this.styleableId;
        }

        public final int component5() {
            return this.typeId;
        }

        public final int component6() {
            return this.layoutHeightId;
        }

        public final int component7() {
            return this.dotsWidthId;
        }

        public final int component8() {
            return this.dotsHeightId;
        }

        public final int component9() {
            return this.dotsSpacingId;
        }

        public final CustomDot copy(float r17, float r18, float r19, int[] r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30) {
            Intrinsics.checkNotNullParameter(r20, "styleableId");
            return new CustomDot(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof CustomDot) == true) goto L8;
            return false;
        L8:
            CustomDot r6 = (CustomDot) r5;
            if (Intrinsics.areEqual(Float.valueOf(this.defaultWidth), Float.valueOf(r6.defaultWidth)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.defaultHeight), Float.valueOf(r6.defaultHeight)) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.defaultSpacing), Float.valueOf(r6.defaultSpacing)) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.styleableId, r6.styleableId) == true) goto L21;
            return false;
        L21:
            if (this.typeId == r6.typeId) goto L24;
            return false;
        L24:
            if (this.layoutHeightId == r6.layoutHeightId) goto L27;
            return false;
        L27:
            if (this.dotsWidthId == r6.dotsWidthId) goto L30;
            return false;
        L30:
            if (this.dotsHeightId == r6.dotsHeightId) goto L33;
            return false;
        L33:
            if (this.dotsSpacingId == r6.dotsSpacingId) goto L36;
            return false;
        L36:
            if (this.dotsColorId == r6.dotsColorId) goto L39;
            return false;
        L39:
            if (this.dotsCornerRadiusId == r6.dotsCornerRadiusId) goto L42;
            return false;
        L42:
            if (this.dotsClickableId == r6.dotsClickableId) goto L45;
            return false;
        L45:
            if (this.dotsStrokeColorId == r6.dotsStrokeColorId) goto L48;
            return false;
        L48:
            if (this.dotsStrokeWidthId == r6.dotsStrokeWidthId) goto L50;
            return false;
        L50:
            return true;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((Float.hashCode(this.defaultWidth) * 31) + Float.hashCode(this.defaultHeight)) * 31) + Float.hashCode(this.defaultSpacing)) * 31) + Arrays.hashCode(this.styleableId)) * 31) + Integer.hashCode(this.typeId)) * 31) + Integer.hashCode(this.layoutHeightId)) * 31) + Integer.hashCode(this.dotsWidthId)) * 31) + Integer.hashCode(this.dotsHeightId)) * 31) + Integer.hashCode(this.dotsSpacingId)) * 31) + Integer.hashCode(this.dotsColorId)) * 31) + Integer.hashCode(this.dotsCornerRadiusId)) * 31) + Integer.hashCode(this.dotsClickableId)) * 31) + Integer.hashCode(this.dotsStrokeColorId)) * 31) + Integer.hashCode(this.dotsStrokeWidthId);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("CustomDot(defaultWidth=");
            r0.append(this.defaultWidth).append(", defaultHeight=").append(this.defaultHeight).append(", defaultSpacing=").append(this.defaultSpacing).append(", styleableId=").append(Arrays.toString(this.styleableId)).append(", typeId=").append(this.typeId).append(", layoutHeightId=").append(this.layoutHeightId).append(", dotsWidthId=").append(this.dotsWidthId).append(", dotsHeightId=").append(this.dotsHeightId).append(", dotsSpacingId=").append(this.dotsSpacingId).append(", dotsColorId=").append(this.dotsColorId).append(", dotsCornerRadiusId=").append(this.dotsCornerRadiusId).append(", dotsClickableId=");
            r0.append(this.dotsClickableId).append(", dotsStrokeColorId=").append(this.dotsStrokeColorId).append(", dotsStrokeWidthId=").append(this.dotsStrokeWidthId).append(')');
            return r0.toString();
        }

        public CustomDot(float r2, float r3, float r4, int[] r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15) {
            Intrinsics.checkNotNullParameter(r5, "styleableId");
            this.defaultWidth = r2;
            this.defaultHeight = r3;
            this.defaultSpacing = r4;
            this.styleableId = r5;
            this.typeId = r6;
            this.layoutHeightId = r7;
            this.dotsWidthId = r8;
            this.dotsHeightId = r9;
            this.dotsSpacingId = r10;
            this.dotsColorId = r11;
            this.dotsCornerRadiusId = r12;
            this.dotsClickableId = r13;
            this.dotsStrokeColorId = r14;
            this.dotsStrokeWidthId = r15;
        }

        public final float getDefaultWidth() {
            return this.defaultWidth;
        }

        public final float getDefaultHeight() {
            return this.defaultHeight;
        }

        public final float getDefaultSpacing() {
            return this.defaultSpacing;
        }

        public final int[] getStyleableId() {
            return this.styleableId;
        }

        public final int getTypeId() {
            return this.typeId;
        }

        public final int getLayoutHeightId() {
            return this.layoutHeightId;
        }

        public final int getDotsWidthId() {
            return this.dotsWidthId;
        }

        public final int getDotsHeightId() {
            return this.dotsHeightId;
        }

        public final int getDotsSpacingId() {
            return this.dotsSpacingId;
        }

        public final int getDotsColorId() {
            return this.dotsColorId;
        }

        public final int getDotsCornerRadiusId() {
            return this.dotsCornerRadiusId;
        }

        public final int getDotsClickableId() {
            return this.dotsClickableId;
        }

        public final int getDotsStrokeColorId() {
            return this.dotsStrokeColorId;
        }

        public final int getDotsStrokeWidthId() {
            return this.dotsStrokeWidthId;
        }
    }

    /* JADX INFO: compiled from: OBaseIndicator.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u000e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003R\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator$ManualPager;", "Lcom/obric/oui/indicator/OBaseIndicator$Pager;", "pageCount", "", "currentItem", "pageSelectedListener", "Lcom/obric/oui/indicator/OBaseIndicator$OnManualPageSelectedListener;", "(Lcom/obric/oui/indicator/OBaseIndicator;IILcom/obric/oui/indicator/OBaseIndicator$OnManualPageSelectedListener;)V", "<set-?>", "count", "getCount", "()I", "getCurrentItem", "isEmpty", "", "()Z", "isNotEmpty", "onPageChangeListenerHelper", "Lcom/obric/oui/indicator/OnPageChangeListenerHelper;", "addOnPageChangeListener", "", "notifyCurrentItemChanged", "removeOnPageChangeListener", "setCurrentItem", "item", "smoothScroll", "updateCurrentItem", "updatePageCount", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class ManualPager implements Pager {
        private int count;
        private int currentItem;
        private OnPageChangeListenerHelper onPageChangeListenerHelper;
        private final OnManualPageSelectedListener pageSelectedListener;
        final /* synthetic */ OBaseIndicator this$0;

        public ManualPager(OBaseIndicator r2, int r3, int r4, OnManualPageSelectedListener r5) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.this$0 = r2;
            this.pageSelectedListener = r5;
            if (r3 <= 0) goto L12;
            boolean r6 = false;
            if (r4 < 0) goto L8;
            if (r4 >= r3) goto L8;
            r6 = true;
        L8:
            if (r6 == true) goto L12;
            String r1 = "setManualPager requires currentItem in 0 until pageCount, currentItem=" + r4 + " pageCount=" + r3;
            L.w(OBaseIndicator.access$getTAG$p(r2), r1);
            throw new IllegalArgumentException(r1);
        L12:
            this.count = r3;
            this.currentItem = r4;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public int getCount() {
            return this.count;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public int getCurrentItem() {
            return this.currentItem;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public boolean isNotEmpty() {
            if (getCount() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public boolean isEmpty() {
            if (getCount() > 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public void setCurrentItem(int r1, boolean r2) {
            if (updateCurrentItem(r1) == true) goto L5;
            return;
        L5:
            notifyCurrentItemChanged();
            OnManualPageSelectedListener r3 = this.pageSelectedListener;
            if (r3 == null) goto L10;
            r3.onPageSelected(getCurrentItem());
            return;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public void removeOnPageChangeListener() {
            this.onPageChangeListenerHelper = null;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public void addOnPageChangeListener(OnPageChangeListenerHelper r2) {
            Intrinsics.checkNotNullParameter(r2, "onPageChangeListenerHelper");
            this.onPageChangeListenerHelper = r2;
        }

        public final boolean updatePageCount(int r4) {
            if (r4 < 0) goto L25;
            if (r4 > 0) goto L10;
            if (getCurrentItem() == 0) goto L10;
            String r5 = "setManualPageCount requires currentItem=0 when pageCount=" + r4 + ", currentItem=" + getCurrentItem();
            L.w(OBaseIndicator.access$getTAG$p(this.this$0), r5);
            throw new IllegalArgumentException(r5);
        L10:
            if (r4 <= 0) goto L21;
            int r2 = getCurrentItem();
            if (r2 < 0) goto L15;
            if (r2 >= r4) goto L15;
            boolean r3 = true;
        L16:
            if (r3 == true) goto L21;
            String r6 = "setManualPageCount requires currentItem in 0 until pageCount, currentItem=" + getCurrentItem() + " pageCount=" + r4;
            L.w(OBaseIndicator.access$getTAG$p(this.this$0), r6);
            throw new IllegalArgumentException(r6);
        L15:
            r3 = false;
        L21:
            if (getCount() != r4) goto L23;
            return false;
        L23:
            this.count = r4;
            return true;
        L25:
            String r7 = Intrinsics.stringPlus("setManualPageCount requires pageCount >= 0, pageCount=", Integer.valueOf(r4));
            L.w(OBaseIndicator.access$getTAG$p(this.this$0), r7);
            throw new IllegalArgumentException(r7);
        }

        public final void notifyCurrentItemChanged() {
            OnPageChangeListenerHelper r0 = this.onPageChangeListenerHelper;
            if (r0 != null) goto L5;
        L7:
            this.this$0.refreshDots();
            return;
        L5:
            if (isNotEmpty() == false) goto L7;
            r0.onPageScrolled(getCurrentItem(), 0.0f);
        }

        public final boolean updateCurrentItem(int r4) {
            if (getCount() > 0) goto L9;
            if (r4 == 0) goto L9;
            String r5 = "ManualPager requires currentItem=0 when pageCount=" + getCount() + ", currentItem=" + r4;
            L.w(OBaseIndicator.access$getTAG$p(this.this$0), r5);
            throw new IllegalArgumentException(r5);
        L9:
            if (getCount() <= 0) goto L20;
            if (r4 >= 0) goto L12;
        L14:
            boolean r0 = false;
        L15:
            if (r0 == true) goto L20;
            String r6 = "ManualPager requires currentItem in 0 until pageCount, currentItem=" + r4 + " pageCount=" + getCount();
            L.w(OBaseIndicator.access$getTAG$p(this.this$0), r6);
            throw new IllegalArgumentException(r6);
        L12:
            if (r4 >= getCount()) goto L14;
            r0 = true;
        L20:
            if (getCurrentItem() != r4) goto L22;
            return false;
        L22:
            this.currentItem = r4;
            return true;
        }
    }

    /* JADX INFO: compiled from: OBaseIndicator.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator$OnManualPageSelectedListener;", "", "onPageSelected", "", "position", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnManualPageSelectedListener {
        void onPageSelected(int r1);
    }

    /* JADX INFO: compiled from: OBaseIndicator.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\rH&J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0012\u0010\u000b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator$Pager;", "", "count", "", "getCount", "()I", "currentItem", "getCurrentItem", "isEmpty", "", "()Z", "isNotEmpty", "addOnPageChangeListener", "", "onPageChangeListenerHelper", "Lcom/obric/oui/indicator/OnPageChangeListenerHelper;", "removeOnPageChangeListener", "setCurrentItem", "item", "smoothScroll", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Pager {
        void addOnPageChangeListener(OnPageChangeListenerHelper r1);

        int getCount();

        int getCurrentItem();

        boolean isEmpty();

        boolean isNotEmpty();

        void removeOnPageChangeListener();

        void setCurrentItem(int r1, boolean r2);
    }

    /* JADX INFO: compiled from: OBaseIndicator.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator$ReleaseMe;", "", "releaseAction", "Lkotlin/Function1;", "", "getReleaseAction", "()Lkotlin/jvm/functions/Function1;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ReleaseMe {
        Function1<ReleaseMe, Unit> getReleaseAction();
    }

    /* JADX INFO: renamed from: com.obric.oui.indicator.OBaseIndicator$setViewPager$2, reason: invalid class name */
    /* JADX INFO: compiled from: OBaseIndicator.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\b\u001a\u00020\u0005H\u0016R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"com/obric/oui/indicator/OBaseIndicator$setViewPager$2", "Landroid/database/DataSetObserver;", "Lcom/obric/oui/indicator/OBaseIndicator$ReleaseMe;", "releaseAction", "Lkotlin/Function1;", "", "getReleaseAction", "()Lkotlin/jvm/functions/Function1;", "onChanged", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AnonymousClass2 extends DataSetObserver implements ReleaseMe {
        final /* synthetic */ ViewPager $viewPager;
        final /* synthetic */ OBaseIndicator this$0;

        AnonymousClass2(OBaseIndicator r1, ViewPager r2) {
            this.this$0 = r1;
            this.$viewPager = r2;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.ReleaseMe
        public Function1<ReleaseMe, Unit> getReleaseAction() {
            final ViewPager r1 = this.$viewPager;
            return new OBaseIndicator$setViewPager$2$releaseAction$1(r1);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            this.this$0.refreshDots();
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.indicator.OBaseIndicator$setViewPager$3, reason: invalid class name */
    /* JADX INFO: compiled from: OBaseIndicator.kt */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"com/obric/oui/indicator/OBaseIndicator$setViewPager$3", "Lcom/obric/oui/indicator/OBaseIndicator$Pager;", "count", "", "getCount", "()I", "currentItem", "getCurrentItem", "isEmpty", "", "()Z", "isNotEmpty", "onPageChangeListener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "getOnPageChangeListener", "()Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "setOnPageChangeListener", "(Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;)V", "addOnPageChangeListener", "", "onPageChangeListenerHelper", "Lcom/obric/oui/indicator/OnPageChangeListenerHelper;", "removeOnPageChangeListener", "setCurrentItem", "item", "smoothScroll", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AnonymousClass3 implements Pager {
        final /* synthetic */ Function0<Integer> $pageCount;
        final /* synthetic */ ViewPager $viewPager;
        private ViewPager.OnPageChangeListener onPageChangeListener;
        final /* synthetic */ OBaseIndicator this$0;

        AnonymousClass3(ViewPager r1, OBaseIndicator r2, Function0<Integer> r3) {
            this.$viewPager = r1;
            this.this$0 = r2;
            this.$pageCount = r3;
        }

        public final ViewPager.OnPageChangeListener getOnPageChangeListener() {
            return this.onPageChangeListener;
        }

        public final void setOnPageChangeListener(ViewPager.OnPageChangeListener r1) {
            this.onPageChangeListener = r1;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public boolean isNotEmpty() {
            return IndicatorExternalsKt.isNotEmpty(this.$viewPager);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public int getCurrentItem() {
            return OBaseIndicator.access$mod(this.this$0, this.$viewPager.getCurrentItem(), getCount());
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public boolean isEmpty() {
            return IndicatorExternalsKt.isEmpty(this.$viewPager);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public int getCount() {
            return this.$pageCount.invoke().intValue();
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public void setCurrentItem(int r1, boolean r2) {
            this.$viewPager.setCurrentItem(r1, r2);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public void removeOnPageChangeListener() {
            ViewPager.OnPageChangeListener r0 = this.onPageChangeListener;
            if (r0 == null) goto L7;
            this.$viewPager.removeOnPageChangeListener(r0);
            return;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public void addOnPageChangeListener(final OnPageChangeListenerHelper r3) {
            Intrinsics.checkNotNullParameter(r3, "onPageChangeListenerHelper");
            final OBaseIndicator r1 = this.this$0;
            ViewPager.OnPageChangeListener r0 = new OBaseIndicator$setViewPager$3$addOnPageChangeListener$1(r3, r1, this);
            this.onPageChangeListener = r0;
            ViewPager r2 = this.$viewPager;
            Intrinsics.checkNotNull(r0);
            r2.addOnPageChangeListener(r0);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.indicator.OBaseIndicator$setViewPager2$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OBaseIndicator.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\b\u001a\u00020\u0005H\u0016R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"com/obric/oui/indicator/OBaseIndicator$setViewPager2$2", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "Lcom/obric/oui/indicator/OBaseIndicator$ReleaseMe;", "releaseAction", "Lkotlin/Function1;", "", "getReleaseAction", "()Lkotlin/jvm/functions/Function1;", "onChanged", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C03532 extends RecyclerView.AdapterDataObserver implements ReleaseMe {
        final /* synthetic */ ViewPager2 $viewPager;
        final /* synthetic */ OBaseIndicator this$0;

        C03532(OBaseIndicator r1, ViewPager2 r2) {
            this.this$0 = r1;
            this.$viewPager = r2;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.ReleaseMe
        public Function1<ReleaseMe, Unit> getReleaseAction() {
            final ViewPager2 r1 = this.$viewPager;
            return new OBaseIndicator$setViewPager2$2$releaseAction$1(r1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            this.this$0.refreshDots();
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.indicator.OBaseIndicator$setViewPager2$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OBaseIndicator.kt */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"com/obric/oui/indicator/OBaseIndicator$setViewPager2$3", "Lcom/obric/oui/indicator/OBaseIndicator$Pager;", "count", "", "getCount", "()I", "currentItem", "getCurrentItem", "isEmpty", "", "()Z", "isNotEmpty", "onPageChangeListener", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "getOnPageChangeListener", "()Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "setOnPageChangeListener", "(Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;)V", "addOnPageChangeListener", "", "onPageChangeListenerHelper", "Lcom/obric/oui/indicator/OnPageChangeListenerHelper;", "removeOnPageChangeListener", "setCurrentItem", "item", "smoothScroll", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C03543 implements Pager {
        final /* synthetic */ Function0<Integer> $pageCount;
        final /* synthetic */ ViewPager2 $viewPager;
        private ViewPager2.OnPageChangeCallback onPageChangeListener;
        final /* synthetic */ OBaseIndicator this$0;

        C03543(ViewPager2 r1, OBaseIndicator r2, Function0<Integer> r3) {
            this.$viewPager = r1;
            this.this$0 = r2;
            this.$pageCount = r3;
        }

        public final ViewPager2.OnPageChangeCallback getOnPageChangeListener() {
            return this.onPageChangeListener;
        }

        public final void setOnPageChangeListener(ViewPager2.OnPageChangeCallback r1) {
            this.onPageChangeListener = r1;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public boolean isNotEmpty() {
            if (this.$viewPager.getChildCount() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public int getCurrentItem() {
            return OBaseIndicator.access$mod(this.this$0, this.$viewPager.getCurrentItem(), getCount());
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public boolean isEmpty() {
            if (this.$viewPager.getChildCount() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public int getCount() {
            return this.$pageCount.invoke().intValue();
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public void setCurrentItem(int r1, boolean r2) {
            this.$viewPager.setCurrentItem(r1, r2);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public void removeOnPageChangeListener() {
            ViewPager2.OnPageChangeCallback r0 = this.onPageChangeListener;
            if (r0 == null) goto L7;
            this.$viewPager.unregisterOnPageChangeCallback(r0);
            return;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public void addOnPageChangeListener(final OnPageChangeListenerHelper r3) {
            Intrinsics.checkNotNullParameter(r3, "onPageChangeListenerHelper");
            final OBaseIndicator r1 = this.this$0;
            ViewPager2.OnPageChangeCallback r0 = new OBaseIndicator$setViewPager2$3$addOnPageChangeListener$1(r3, r1, this);
            this.onPageChangeListener = r0;
            ViewPager2 r2 = this.$viewPager;
            Intrinsics.checkNotNull(r0);
            r2.registerOnPageChangeCallback(r0);
        }
    }

    public static /* synthetic */ void $r8$lambda$btDugYOLtfaXnhmkSgyzJs5Lvn8(OBaseIndicator r0) {
        m546postPendingRefresh$lambda1(r0);
    }

    public static /* synthetic */ void $r8$lambda$yPd5Isx6PNLQ3fsYPJifVqRdrLo(OBaseIndicator r0) {
        m547refreshDots$lambda0(r0);
    }

    public OBaseIndicator(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OBaseIndicator(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    @Deprecated(message = "已废弃。请先更新 adapter/pageCount 对应的数据源，indicator 会自动刷新。")
    public abstract void addDot(int r1);

    public abstract OnPageChangeListenerHelper buildOnPageChangedListener();

    public abstract CustomDot getCustom();

    protected abstract void onRefreshDotsDraws();

    protected abstract void onRefreshDotsSize();

    protected abstract void onRefreshDotsSpacing();

    protected abstract void onRefreshIndicator();

    public abstract void refreshDotDraw(int r1);

    public abstract void refreshParentLayout();

    @Deprecated(message = "已废弃。请先更新 adapter/pageCount 对应的数据源，indicator 会自动刷新。")
    public abstract void removeDot(int r1);

    public final void setManualPager(int r7) {
        setManualPager$default(this, r7, 0, null, 6, null);
    }

    public final void setManualPager(int r7, int r8) {
        setManualPager$default(this, r7, r8, null, 4, null);
    }

    public /* synthetic */ OBaseIndicator(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ String access$getTAG$p(OBaseIndicator r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ int access$mod(OBaseIndicator r0, int r1, int r2) {
        return r0.mod(r1, r2);
    }

    public OBaseIndicator(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.TAG = "OBaseIndicator";
        this.dotsWidth = getCustom().getDefaultWidth();
        this.dotsHeight = getCustom().getDefaultHeight();
        this.layoutHeight = -2;
        OBaseIndicator r0 = this;
        this.verticalSidePadding = OUnitExtensionKt.vdp(r0, 7);
        this.sidePadding = OUnitExtensionKt.vdp(r0, 10);
        this.dotsSpacing = getCustom().getDefaultSpacing();
        this.dotsColor = ContextCompat.getColor(r4, R.color.oui_text_4);
        this.dotsCornerRadius = this.dotsHeight / 2;
        this.dotsClickable = true;
        this.dotsStrokeColor = ContextCompat.getColor(r4, R.color.Transparent);
        this.dotsStrokeWidth = OUnitExtensionKt.vdpFloat(r0, 0);
        if (r5 == null) goto L6;
        TypedArray r7 = r4.obtainStyledAttributes(r5, getCustom().getStyleableId());
        Intrinsics.checkNotNullExpressionValue(r7, "context.obtainStyledAttr…ttrs, custom.styleableId)");
        setType(r7.getInt(getCustom().getTypeId(), this.type));
        setDotsWidth(r7.getDimension(getCustom().getDotsWidthId(), this.dotsWidth));
        setDotsHeight(r7.getDimension(getCustom().getDotsHeightId(), this.dotsHeight));
        setLayoutHeight(r7.getDimensionPixelSize(getCustom().getLayoutHeightId(), -2));
        setDotsSpacing(r7.getDimension(getCustom().getDotsSpacingId(), this.dotsSpacing));
        setDotsColor(r7.getColor(getCustom().getDotsColorId(), this.dotsColor));
        setDotsCornerRadius(r7.getDimension(getCustom().getDotsCornerRadiusId(), this.dotsCornerRadius));
        this.dotsClickable = r7.getBoolean(getCustom().getDotsClickableId(), true);
        setDotsStrokeColor(r7.getColor(getCustom().getDotsStrokeColorId(), this.dotsStrokeColor));
        setDotsStrokeWidth(r7.getDimension(getCustom().getDotsStrokeWidthId(), this.dotsStrokeWidth));
        r7.recycle();
        return;
    }

    protected final boolean getInitialized() {
        return this.initialized;
    }

    protected final void setInitialized(boolean r1) {
        this.initialized = r1;
    }

    protected final boolean getPendingRefreshParentLayout() {
        return this.pendingRefreshParentLayout;
    }

    protected final void setPendingRefreshParentLayout(boolean r1) {
        this.pendingRefreshParentLayout = r1;
    }

    public final float getDotsWidth() {
        return this.dotsWidth;
    }

    public final void setDotsWidth(float r2) {
        if (this.dotsWidth != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.dotsWidth = r2;
        refreshDotsSize();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final float getDotsHeight() {
        return this.dotsHeight;
    }

    public final void setDotsHeight(float r2) {
        if (this.dotsHeight != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.dotsHeight = r2;
        refreshDotsSize();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final int getLayoutHeight() {
        return this.layoutHeight;
    }

    public final void setLayoutHeight(int r2) {
        if (this.layoutHeight == r2) goto L6;
        this.layoutHeight = r2;
        refreshParentLayout();
        return;
    }

    public final int getVerticalSidePadding() {
        return this.verticalSidePadding;
    }

    public final void setVerticalSidePadding(int r2) {
        if (this.verticalSidePadding == r2) goto L6;
        this.verticalSidePadding = r2;
        refreshParentLayout();
        return;
    }

    public final int getSidePadding() {
        return this.sidePadding;
    }

    public final void setSidePadding(int r2) {
        if (this.sidePadding == r2) goto L6;
        this.sidePadding = r2;
        refreshParentLayout();
        return;
    }

    public final float getDotsSpacing() {
        return this.dotsSpacing;
    }

    public final void setDotsSpacing(float r2) {
        if (this.dotsSpacing != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.dotsSpacing = r2;
        refreshDotsSpacing();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int r2) {
        if (this.type == r2) goto L6;
        this.type = r2;
        refreshParentLayout();
        refreshDotsDraws();
        return;
    }

    public final int getDotsColor() {
        return this.dotsColor;
    }

    public final void setDotsColor(int r3) {
        if (this.type == 1) goto L5;
        this.dotsColor = r3;
        refreshDotsDraws();
        return;
    L5:
        this.dotsColor = 872415231;
        refreshDotsDraws();
    }

    public final float getDotsCornerRadius() {
        return this.dotsCornerRadius;
    }

    public final void setDotsCornerRadius(float r2) {
        if (this.dotsCornerRadius != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.dotsCornerRadius = r2;
        refreshDotsDraws();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean getDotsClickable() {
        return this.dotsClickable;
    }

    public final void setDotsClickable(boolean r1) {
        this.dotsClickable = r1;
    }

    public final int getDotsStrokeColor() {
        return this.dotsStrokeColor;
    }

    public final void setDotsStrokeColor(int r2) {
        if (this.dotsStrokeColor == r2) goto L6;
        this.dotsStrokeColor = r2;
        refreshDotsDraws();
        return;
    }

    public final float getDotsStrokeWidth() {
        return this.dotsStrokeWidth;
    }

    public final void setDotsStrokeWidth(float r2) {
        if (this.dotsStrokeWidth != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.dotsStrokeWidth = r2;
        refreshDotsDraws();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    protected final void setInitComplete() {
        this.initialized = true;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public final void setPager(Pager r2) {
        Pager r0 = this.pager;
        if (r0 == null) goto L6;
        r0.removeOnPageChangeListener();
    L6:
        this.pager = r2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        refreshDots();
        postPendingRefresh();
    }

    public final void refreshDots() {
        if (this.pager != null) goto L6;
        return;
    L6:
        if (this.initialized == true) goto L9;
        this.pendingRefreshDots = true;
        return;
    L9:
        post(new OBaseIndicator$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: renamed from: refreshDots$lambda-0, reason: not valid java name */
    private static final void m547refreshDots$lambda0(OBaseIndicator r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        boolean r1 = true;
        if (r3.initialized == true) goto L6;
        r3.pendingRefreshDots = true;
        return;
    L6:
        r3.pendingRefreshDots = false;
        r3.onRefreshIndicator();
        r3.refreshDotsSpacing();
        r3.refreshDotsDraws();
        r3.refreshDotsSize();
        r3.refreshOnPageChangedListener();
        Pager r2 = r3.pager;
        if (r2 != null) goto L10;
    L8:
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        ViewExtensionsKt.makeInvisible(r3);
        return;
    L13:
        ViewExtensionsKt.makeVisible(r3);
        return;
    L10:
        if (r2.getCount() != 1) goto L8;
        goto L8
    }

    protected final int pagerCount() {
        Pager r0 = this.pager;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getCount();
    }

    protected final void refreshDotsDraws() {
        if (this.initialized == true) goto L6;
        this.pendingRefreshDotsDraws = true;
        return;
    L6:
        this.pendingRefreshDotsDraws = false;
        onRefreshDotsDraws();
    }

    protected final void refreshDotsSpacing() {
        if (this.initialized == true) goto L6;
        this.pendingRefreshDotsSpacing = true;
        return;
    L6:
        this.pendingRefreshDotsSpacing = false;
        onRefreshDotsSpacing();
    }

    protected final void refreshDotsSize() {
        if (this.initialized == true) goto L6;
        this.pendingRefreshDotsSize = true;
        return;
    L6:
        this.pendingRefreshDotsSize = false;
        onRefreshDotsSize();
    }

    private final void postPendingRefresh() {
        post(new OBaseIndicator$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: postPendingRefresh$lambda-1, reason: not valid java name */
    private static final void m546postPendingRefresh$lambda1(OBaseIndicator r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.pendingRefreshParentLayout == false) goto L6;
        r1.refreshParentLayout();
    L6:
        if (r1.pendingRefreshDots == false) goto L10;
        r1.refreshDots();
        return;
    L10:
        if (r1.pendingRefreshDotsSpacing == false) goto L13;
        r1.refreshDotsSpacing();
    L13:
        if (r1.pendingRefreshDotsDraws == false) goto L16;
        r1.refreshDotsDraws();
    L16:
        if (r1.pendingRefreshDotsSize == false) goto L19;
        r1.refreshDotsSize();
        return;
    }

    private final void refreshOnPageChangedListener() {
        Pager r0 = this.pager;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isNotEmpty() == true) goto L8;
        return;
    L8:
        r0.removeOnPageChangeListener();
        OnPageChangeListenerHelper r2 = buildOnPageChangedListener();
        r0.addOnPageChangeListener(r2);
        r2.onPageScrolled(r0.getCurrentItem(), 0.0f);
    }

    private final void setPagerDataSetObserver(ReleaseMe r3) {
        ReleaseMe r0 = this.pagerDataSetObserver;
        if (r0 == null) goto L9;
        Function1<ReleaseMe, Unit> r1 = r0.getReleaseAction();
        if (r1 == null) goto L9;
        ReleaseMe r2 = this.pagerDataSetObserver;
        Intrinsics.checkNotNull(r2);
        r1.invoke(r2);
    L9:
        this.pagerDataSetObserver = r3;
    }

    public static /* synthetic */ void setManualPager$default(OBaseIndicator r0, int r1, int r2, OnManualPageSelectedListener r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 2) == 0) goto L7;
        r2 = 0;
    L7:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        r0.setManualPager(r1, r2, r3);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setManualPager");
    }

    public final void setManualPager(int r2, int r3, OnManualPageSelectedListener r4) {
        setPagerDataSetObserver(null);
        setPager(new ManualPager(this, r2, r3, r4));
        refreshDots();
    }

    public final void setManualPageCount(int r3) {
        Pager r0 = this.pager;
        if ((r0 instanceof ManualPager) == false) goto L5;
        ManualPager r1 = (ManualPager) r0;
    L6:
        if (r1 != null) goto L8;
        L.w(this.TAG, "setManualPageCount requires setManualPager before manual updates");
        throw new IllegalStateException("setManualPageCount requires setManualPager before manual updates");
    L8:
        if (r1.updatePageCount(r3) == false) goto L13;
        refreshDots();
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setManualCurrentItem(int r3) {
        Pager r0 = this.pager;
        if ((r0 instanceof ManualPager) == false) goto L5;
        ManualPager r1 = (ManualPager) r0;
    L6:
        if (r1 != null) goto L8;
        L.w(this.TAG, "setManualCurrentItem requires setManualPager before manual updates");
        throw new IllegalStateException("setManualCurrentItem requires setManualPager before manual updates");
    L8:
        if (r1.updateCurrentItem(r3) == false) goto L13;
        r1.notifyCurrentItemChanged();
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Deprecated(message = "需要 pageCount, 否则搭配banner的无限横划时可能出错", replaceWith = @ReplaceWith(expression = "setViewPager(ViewPager, Int) or setViewPager(ViewPager, () -> Int)", imports = {}))
    public final void setViewPager(ViewPager r2) {
        Intrinsics.checkNotNullParameter(r2, "viewPager");
        PagerAdapter r0 = r2.getAdapter();
        if (r0 != null) goto L5;
        int r1 = 1;
    L6:
        setViewPager(r2, r1);
        return;
    L5:
        r1 = r0.getCount();
        goto L6
    }

    public final void setViewPager(ViewPager r2, final int r3) {
        Intrinsics.checkNotNullParameter(r2, "viewPager");
        setViewPager(r2, new AnonymousClass1(r3));
    }

    public final void setViewPager(ViewPager r3, Function0<Integer> r4) {
        Intrinsics.checkNotNullParameter(r3, "viewPager");
        Intrinsics.checkNotNullParameter(r4, "pageCount");
        if (r3.getAdapter() == null) goto L11;
        setPagerDataSetObserver(new AnonymousClass2(this, r3));
        PagerAdapter r0 = r3.getAdapter();
        Intrinsics.checkNotNull(r0);
        Object r1 = this.pagerDataSetObserver;
        if (r1 == null) goto L9;
        r0.registerDataSetObserver((DataSetObserver) r1);
        setPager(new AnonymousClass3(r3, this, r4));
        refreshDots();
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.database.DataSetObserver");
    L11:
        throw new IllegalStateException("Set an adapter to the view pager before initializing the dots indicator ~");
    }

    public final void setViewPager2(ViewPager2 r2, final int r3) {
        Intrinsics.checkNotNullParameter(r2, "viewPager");
        setViewPager2(r2, new C03521(r3));
    }

    public final void setViewPager2(ViewPager2 r3, Function0<Integer> r4) {
        Intrinsics.checkNotNullParameter(r3, "viewPager");
        Intrinsics.checkNotNullParameter(r4, "pageCount");
        if (r3.getAdapter() == null) goto L11;
        setPagerDataSetObserver(new C03532(this, r3));
        RecyclerView.Adapter r0 = r3.getAdapter();
        Intrinsics.checkNotNull(r0);
        Object r1 = this.pagerDataSetObserver;
        if (r1 == null) goto L9;
        r0.registerAdapterDataObserver((RecyclerView.AdapterDataObserver) r1);
        setPager(new C03543(r3, this, r4));
        refreshDots();
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.AdapterDataObserver");
    L11:
        throw new IllegalStateException("Set an adapter to the view pager before initializing the dots indicator ~");
    }

    private final int mod(int r2, int r3) {
        if (r3 != 0) goto L13;
        L.w(this.TAG, "mod num is 0");
        return r2;
    L13:
        return r2 % r3;
    L7:
        e = move-exception;
        if ((e instanceof ArithmeticException) == false) goto L11;
        L.w(this.TAG, Intrinsics.stringPlus("不要乱除0呀 ", e.getMessage()));
        return r2;
    L11:
        L.w(this.TAG, Intrinsics.stringPlus("抓住了一个Exception并ignore, ", e.getMessage()));
        return r2;
    }
}

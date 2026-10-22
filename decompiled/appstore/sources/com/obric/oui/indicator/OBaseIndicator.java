package com.obric.oui.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oui.R$color;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.structure.card.FixCard;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\b48\u0084\u0001\u0085\u0001\u0086\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0004¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\nH$¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\nH$¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0014\u001a\u00020\nH$¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\nH$¢\u0006\u0004\b\u0015\u0010\fJ\u000f\u0010\u0016\u001a\u00020\nH&¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001a\u0010\fJ\r\u0010\u001b\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\fJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\nH\u0004¢\u0006\u0004\b\u001e\u0010\fJ\u000f\u0010\u001f\u001a\u00020\nH\u0004¢\u0006\u0004\b\u001f\u0010\fJ\u000f\u0010 \u001a\u00020\nH\u0004¢\u0006\u0004\b \u0010\fJ-\u0010%\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u00062\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#H\u0007¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0006¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0006¢\u0006\u0004\b)\u0010(J\u0017\u0010,\u001a\u00020\n2\u0006\u0010+\u001a\u00020*H\u0007¢\u0006\u0004\b,\u0010-J\u001d\u0010.\u001a\u00020\n2\u0006\u0010+\u001a\u00020*2\u0006\u0010!\u001a\u00020\u0006¢\u0006\u0004\b.\u0010/J#\u00101\u001a\u00020\n2\u0006\u0010+\u001a\u00020*2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000600¢\u0006\u0004\b1\u00102R\u0014\u00106\u001a\u0002038\u0002X\u0082D¢\u0006\u0006\n\u0004\b4\u00105R\"\u0010>\u001a\u0002078\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010B\u001a\u0002078\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b?\u00109\u001a\u0004\b@\u0010;\"\u0004\bA\u0010=R\u0016\u0010D\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u00109R\u0016\u0010E\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u00109R\u0016\u0010F\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u00109R\u0016\u0010G\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u00109R*\u0010O\u001a\u00020H2\u0006\u0010I\u001a\u00020H8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR*\u0010R\u001a\u00020H2\u0006\u0010I\u001a\u00020H8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010J\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010NR*\u0010V\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010S\u001a\u0004\bT\u0010\u001d\"\u0004\bU\u0010(R*\u0010Y\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010S\u001a\u0004\bW\u0010\u001d\"\u0004\bX\u0010(R*\u0010\\\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010S\u001a\u0004\bZ\u0010\u001d\"\u0004\b[\u0010(R*\u0010`\u001a\u00020H2\u0006\u0010I\u001a\u00020H8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010J\u001a\u0004\b^\u0010L\"\u0004\b_\u0010NR*\u0010c\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010S\u001a\u0004\ba\u0010\u001d\"\u0004\bb\u0010(R*\u0010g\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\bd\u0010S\u001a\u0004\be\u0010\u001d\"\u0004\bf\u0010(R*\u0010j\u001a\u00020H2\u0006\u0010I\u001a\u00020H8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010J\u001a\u0004\bh\u0010L\"\u0004\bi\u0010NR\"\u0010m\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u00109\u001a\u0004\bk\u0010;\"\u0004\bl\u0010=R*\u0010p\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010S\u001a\u0004\bn\u0010\u001d\"\u0004\bo\u0010(R*\u0010s\u001a\u00020H2\u0006\u0010I\u001a\u00020H8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010J\u001a\u0004\bq\u0010L\"\u0004\br\u0010NR.\u0010z\u001a\u0004\u0018\u00010t2\b\u0010I\u001a\u0004\u0018\u00010t8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR(\u0010\u007f\u001a\u0004\u0018\u00010{2\b\u0010I\u001a\u0004\u0018\u00010{8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0011\u0010|\"\u0004\b}\u0010~R\u0018\u0010\u0083\u0001\u001a\u00030\u0080\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001¨\u0006\u0087\u0001"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "l", "()V", "s", "num", "f", "(II)I", "u", "j", "g", "i", "h", "t", "Lcom/obric/oui/indicator/j;", "e", "()Lcom/obric/oui/indicator/j;", "onAttachedToWindow", "n", "k", "()I", "p", "r", "q", SlideCard.KEY_PAGE_COUNT, "currentItem", "Lcom/obric/oui/indicator/OBaseIndicator$OnManualPageSelectedListener;", "onPageSelected", "v", "(IILcom/obric/oui/indicator/OBaseIndicator$OnManualPageSelectedListener;)V", "setManualPageCount", "(I)V", "setManualCurrentItem", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", FixCard.FixStyle.KEY_X, "(Landroidx/viewpager/widget/ViewPager;I)V", "Lkotlin/Function0;", FixCard.FixStyle.KEY_Y, "(Landroidx/viewpager/widget/ViewPager;Lkotlin/jvm/functions/Function0;)V", "", "a", "Ljava/lang/String;", "TAG", "", "b", "Z", "getInitialized", "()Z", "setInitialized", "(Z)V", "initialized", "c", "getPendingRefreshParentLayout", "setPendingRefreshParentLayout", "pendingRefreshParentLayout", "d", "pendingRefreshDots", "pendingRefreshDotsDraws", "pendingRefreshDotsSpacing", "pendingRefreshDotsSize", "", CommonKey.KEY_VALUE, "F", "getDotsWidth", "()F", "setDotsWidth", "(F)V", "dotsWidth", "getDotsHeight", "setDotsHeight", "dotsHeight", "I", "getLayoutHeight", "setLayoutHeight", "layoutHeight", "getVerticalSidePadding", "setVerticalSidePadding", "verticalSidePadding", "getSidePadding", "setSidePadding", "sidePadding", "m", "getDotsSpacing", "setDotsSpacing", "dotsSpacing", "getType", "setType", "type", "o", "getDotsColor", "setDotsColor", "dotsColor", "getDotsCornerRadius", "setDotsCornerRadius", "dotsCornerRadius", "getDotsClickable", "setDotsClickable", "dotsClickable", "getDotsStrokeColor", "setDotsStrokeColor", "dotsStrokeColor", "getDotsStrokeWidth", "setDotsStrokeWidth", "dotsStrokeWidth", "Lcom/obric/oui/indicator/OBaseIndicator$Pager;", "Lcom/obric/oui/indicator/OBaseIndicator$Pager;", "getPager", "()Lcom/obric/oui/indicator/OBaseIndicator$Pager;", "setPager", "(Lcom/obric/oui/indicator/OBaseIndicator$Pager;)V", "pager", "Lcom/obric/oui/indicator/OBaseIndicator$ReleaseMe;", "Lcom/obric/oui/indicator/OBaseIndicator$ReleaseMe;", "setPagerDataSetObserver", "(Lcom/obric/oui/indicator/OBaseIndicator$ReleaseMe;)V", "pagerDataSetObserver", "Lcom/obric/oui/indicator/OBaseIndicator$a;", "getCustom", "()Lcom/obric/oui/indicator/OBaseIndicator$a;", "custom", "OnManualPageSelectedListener", "Pager", "ReleaseMe", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OBaseIndicator extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f14992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f14993g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f14994h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f14995i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14996j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14997k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14998l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f14999m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f15000n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f15001o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f15002p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f15003q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f15004r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f15005s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Pager f15006t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ReleaseMe f15007u;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator$OnManualPageSelectedListener;", "", "onPageSelected", "", "position", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnManualPageSelectedListener {
        void onPageSelected(int r10);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator$Pager;", "", "", "item", "", "smoothScroll", "", "setCurrentItem", "(IZ)V", "removeOnPageChangeListener", "()V", "Lcom/obric/oui/indicator/j;", "onPageChangeListenerHelper", "addOnPageChangeListener", "(Lcom/obric/oui/indicator/j;)V", "isNotEmpty", "()Z", "getCurrentItem", "()I", "currentItem", "isEmpty", "getCount", "count", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Pager {
        void addOnPageChangeListener(@NotNull j r10);

        int getCount();

        int getCurrentItem();

        boolean isEmpty();

        boolean isNotEmpty();

        void removeOnPageChangeListener();

        void setCurrentItem(int r10, boolean r11);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator$ReleaseMe;", "", "releaseAction", "Lkotlin/Function1;", "", "getReleaseAction", "()Lkotlin/jvm/functions/Function1;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ReleaseMe {
        @NotNull
        Function1<ReleaseMe, Unit> getReleaseAction();
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f15008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f15009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f15010c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f15011d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f15012e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f15013f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f15014g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f15015h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f15016i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f15017j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f15018k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f15019l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f15020m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f15021n;

        public a(float r10, float r11, float r12, int[] r13, int r14, int r15, int r16, int r17, int r18, int r19, int r110, int r111, int r112, int r113) {
            q.g(r13, "styleableId");
            this.f15008a = r10;
            this.f15009b = r11;
            this.f15010c = r12;
            this.f15011d = r13;
            this.f15012e = r14;
            this.f15013f = r15;
            this.f15014g = r16;
            this.f15015h = r17;
            this.f15016i = r18;
            this.f15017j = r19;
            this.f15018k = r110;
            this.f15019l = r111;
            this.f15020m = r112;
            this.f15021n = r113;
        }

        public final float a() {
            return this.f15009b;
        }

        public final float b() {
            return this.f15010c;
        }

        public final float c() {
            return this.f15008a;
        }

        public final int d() {
            return this.f15019l;
        }

        public final int e() {
            return this.f15017j;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (q.b(Float.valueOf(this.f15008a), Float.valueOf(r11.f15008a)) == true) goto L12;
            return false;
        L12:
            if (q.b(Float.valueOf(this.f15009b), Float.valueOf(r11.f15009b)) == true) goto L15;
            return false;
        L15:
            if (q.b(Float.valueOf(this.f15010c), Float.valueOf(r11.f15010c)) == true) goto L18;
            return false;
        L18:
            if (q.b(this.f15011d, r11.f15011d) == true) goto L21;
            return false;
        L21:
            if (this.f15012e == r11.f15012e) goto L24;
            return false;
        L24:
            if (this.f15013f == r11.f15013f) goto L27;
            return false;
        L27:
            if (this.f15014g == r11.f15014g) goto L30;
            return false;
        L30:
            if (this.f15015h == r11.f15015h) goto L33;
            return false;
        L33:
            if (this.f15016i == r11.f15016i) goto L36;
            return false;
        L36:
            if (this.f15017j == r11.f15017j) goto L39;
            return false;
        L39:
            if (this.f15018k == r11.f15018k) goto L42;
            return false;
        L42:
            if (this.f15019l == r11.f15019l) goto L45;
            return false;
        L45:
            if (this.f15020m == r11.f15020m) goto L48;
            return false;
        L48:
            if (this.f15021n == r11.f15021n) goto L50;
            return false;
        L50:
            return true;
        }

        public final int f() {
            return this.f15018k;
        }

        public final int g() {
            return this.f15015h;
        }

        public final int h() {
            return this.f15016i;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((Float.hashCode(this.f15008a) * 31) + Float.hashCode(this.f15009b)) * 31) + Float.hashCode(this.f15010c)) * 31) + Arrays.hashCode(this.f15011d)) * 31) + Integer.hashCode(this.f15012e)) * 31) + Integer.hashCode(this.f15013f)) * 31) + Integer.hashCode(this.f15014g)) * 31) + Integer.hashCode(this.f15015h)) * 31) + Integer.hashCode(this.f15016i)) * 31) + Integer.hashCode(this.f15017j)) * 31) + Integer.hashCode(this.f15018k)) * 31) + Integer.hashCode(this.f15019l)) * 31) + Integer.hashCode(this.f15020m)) * 31) + Integer.hashCode(this.f15021n);
        }

        public final int i() {
            return this.f15020m;
        }

        public final int j() {
            return this.f15021n;
        }

        public final int k() {
            return this.f15014g;
        }

        public final int l() {
            return this.f15013f;
        }

        public final int[] m() {
            return this.f15011d;
        }

        public final int n() {
            return this.f15012e;
        }

        public String toString() {
            return "CustomDot(defaultWidth=" + this.f15008a + ", defaultHeight=" + this.f15009b + ", defaultSpacing=" + this.f15010c + ", styleableId=" + Arrays.toString(this.f15011d) + ", typeId=" + this.f15012e + ", layoutHeightId=" + this.f15013f + ", dotsWidthId=" + this.f15014g + ", dotsHeightId=" + this.f15015h + ", dotsSpacingId=" + this.f15016i + ", dotsColorId=" + this.f15017j + ", dotsCornerRadiusId=" + this.f15018k + ", dotsClickableId=" + this.f15019l + ", dotsStrokeColorId=" + this.f15020m + ", dotsStrokeWidthId=" + this.f15021n + ')';
        }
    }

    public final class b implements Pager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OnManualPageSelectedListener f15022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j f15023b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15024c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15025d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ OBaseIndicator f15026e;

        public b(OBaseIndicator r10, int r11, int r12, OnManualPageSelectedListener r13) {
            q.g(r10, "this$0");
            this.f15026e = r10;
            this.f15022a = r13;
            if (r11 <= 0) goto L9;
            if (r12 < 0) goto L7;
            if (r12 < r11) goto L9;
        L7:
            String r14 = "setManualPager requires currentItem in 0 until pageCount, currentItem=" + r12 + " pageCount=" + r11;
            L.j(OBaseIndicator.c(r10), r14);
            throw new IllegalArgumentException(r14);
        L9:
            this.f15024c = r11;
            this.f15025d = r12;
        }

        public final void a() {
            j r10 = this.f15023b;
            if (r10 != null) goto L5;
        L7:
            this.f15026e.n();
            return;
        L5:
            if (isNotEmpty() == false) goto L7;
            r10.b(getCurrentItem(), 0.0f);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public void addOnPageChangeListener(j r10) {
            q.g(r10, "onPageChangeListenerHelper");
            this.f15023b = r10;
        }

        public final boolean b(int r10) {
            if (getCount() > 0) goto L9;
            if (r10 == 0) goto L9;
            String r11 = "ManualPager requires currentItem=0 when pageCount=" + getCount() + ", currentItem=" + r10;
            L.j(OBaseIndicator.c(this.f15026e), r11);
            throw new IllegalArgumentException(r11);
        L9:
            if (getCount() <= 0) goto L17;
            if (r10 >= 0) goto L12;
        L14:
            String r12 = "ManualPager requires currentItem in 0 until pageCount, currentItem=" + r10 + " pageCount=" + getCount();
            L.j(OBaseIndicator.c(this.f15026e), r12);
            throw new IllegalArgumentException(r12);
        L12:
            if (r10 >= getCount()) goto L14;
        L17:
            if (getCurrentItem() != r10) goto L20;
            return false;
        L20:
            this.f15025d = r10;
            return true;
        }

        public final boolean c(int r10) {
            if (r10 < 0) goto L22;
            if (r10 <= 0) goto L5;
        L9:
            if (r10 <= 0) goto L17;
            int r11 = getCurrentItem();
            if (r11 < 0) goto L14;
            if (r11 < r10) goto L17;
        L14:
            String r12 = "setManualPageCount requires currentItem in 0 until pageCount, currentItem=" + getCurrentItem() + " pageCount=" + r10;
            L.j(OBaseIndicator.c(this.f15026e), r12);
            throw new IllegalArgumentException(r12);
        L17:
            if (getCount() != r10) goto L20;
            return false;
        L20:
            this.f15024c = r10;
            return true;
        L5:
            if (getCurrentItem() == 0) goto L9;
            String r13 = "setManualPageCount requires currentItem=0 when pageCount=" + r10 + ", currentItem=" + getCurrentItem();
            L.j(OBaseIndicator.c(this.f15026e), r13);
            throw new IllegalArgumentException(r13);
        L22:
            String r14 = q.p("setManualPageCount requires pageCount >= 0, pageCount=", Integer.valueOf(r10));
            L.j(OBaseIndicator.c(this.f15026e), r14);
            throw new IllegalArgumentException(r14);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public int getCount() {
            return this.f15024c;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public int getCurrentItem() {
            return this.f15025d;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public boolean isEmpty() {
            if (getCount() > 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public boolean isNotEmpty() {
            if (getCount() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public void removeOnPageChangeListener() {
            this.f15023b = null;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public void setCurrentItem(int r10, boolean r11) {
            if (b(r10) == true) goto L5;
            return;
        L5:
            a();
            OnManualPageSelectedListener r12 = this.f15022a;
            if (r12 == null) goto L10;
            r12.onPageSelected(getCurrentItem());
            return;
        }
    }

    public static final class c implements Pager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ViewPager.OnPageChangeListener f15027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPager f15028b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OBaseIndicator f15029c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0 f15030d;

        public static final class a implements ViewPager.OnPageChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f15031a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ OBaseIndicator f15032b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f15033c;

            public a(j r10, OBaseIndicator r11, c r12) {
                this.f15031a = r10;
                this.f15032b = r11;
                this.f15033c = r12;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int r10) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int r10, float r11, int r12) {
                this.f15031a.b(OBaseIndicator.d(this.f15032b, r10, this.f15033c.getCount()), r11);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int r10) {
            }
        }

        public c(ViewPager r10, OBaseIndicator r11, Function0 r12) {
            this.f15028b = r10;
            this.f15029c = r11;
            this.f15030d = r12;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public void addOnPageChangeListener(j r10) {
            q.g(r10, "onPageChangeListenerHelper");
            a r11 = new a(r10, this.f15029c, this);
            this.f15027a = r11;
            ViewPager r12 = this.f15028b;
            q.d(r11);
            r12.addOnPageChangeListener(r11);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public int getCount() {
            return ((Number) this.f15030d.invoke()).intValue();
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public int getCurrentItem() {
            return OBaseIndicator.d(this.f15029c, this.f15028b.getCurrentItem(), getCount());
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public boolean isEmpty() {
            return com.obric.oui.indicator.c.a(this.f15028b);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public boolean isNotEmpty() {
            return com.obric.oui.indicator.c.b(this.f15028b);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public void removeOnPageChangeListener() {
            ViewPager.OnPageChangeListener r10 = this.f15027a;
            if (r10 == null) goto L7;
            this.f15028b.removeOnPageChangeListener(r10);
            return;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public void setCurrentItem(int r10, boolean r11) {
            this.f15028b.setCurrentItem(r10, r11);
        }

        public final void setOnPageChangeListener(@Nullable ViewPager.OnPageChangeListener r10) {
            this.f15027a = r10;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.indicator.OBaseIndicator$setViewPager$2, reason: invalid class name */
    public static final class AnonymousClass2 extends DataSetObserver implements ReleaseMe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OBaseIndicator f15034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPager f15035b;

        public AnonymousClass2(OBaseIndicator r10, ViewPager r11) {
            this.f15034a = r10;
            this.f15035b = r11;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.ReleaseMe
        public Function1 getReleaseAction() {
            final ViewPager r10 = this.f15035b;
            return new OBaseIndicator$setViewPager$2$releaseAction$1(r10);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            this.f15034a.n();
        }
    }

    @JvmOverloads
    public OBaseIndicator(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ void a(OBaseIndicator r10) {
        o(r10);
    }

    public static /* synthetic */ void b(OBaseIndicator r10) {
        m(r10);
    }

    public static final /* synthetic */ String c(OBaseIndicator r10) {
        return r10.f14987a;
    }

    public static final /* synthetic */ int d(OBaseIndicator r10, int r11, int r12) {
        return r10.f(r11, r12);
    }

    public static final void m(OBaseIndicator r10) {
        q.g(r10, "this$0");
        if (r10.f14989c == false) goto L6;
        r10.t();
    L6:
        if (r10.f14990d == false) goto L10;
        r10.n();
        return;
    L10:
        if (r10.f14992f == false) goto L13;
        r10.r();
    L13:
        if (r10.f14991e == false) goto L16;
        r10.p();
    L16:
        if (r10.f14993g == false) goto L19;
        r10.q();
        return;
    }

    public static final void o(OBaseIndicator r10) {
        q.g(r10, "this$0");
        if (r10.f14988b == true) goto L6;
        r10.f14990d = true;
        return;
    L6:
        r10.f14990d = false;
        r10.j();
        r10.r();
        r10.p();
        r10.q();
        r10.s();
        Pager r11 = r10.f15006t;
        if (r11 != null) goto L10;
    L12:
        l.m(r10);
        return;
    L10:
        if (r11.getCount() != 1) goto L12;
        l.l(r10);
    }

    private final void setPagerDataSetObserver(ReleaseMe r10) {
        ReleaseMe r11 = this.f15007u;
        if (r11 == null) goto L9;
        Function1<ReleaseMe, Unit> r12 = r11.getReleaseAction();
        if (r12 == null) goto L9;
        ReleaseMe r13 = this.f15007u;
        q.d(r13);
        r12.invoke(r13);
    L9:
        this.f15007u = r10;
    }

    public static /* synthetic */ void w(OBaseIndicator r10, int r11, int r12, OnManualPageSelectedListener r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 2) == 0) goto L7;
        r12 = 0;
    L7:
        if ((r14 & 4) == 0) goto L9;
        r13 = null;
    L9:
        r10.v(r11, r12, r13);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setManualPager");
    }

    public abstract j e();

    public final int f(int r10, int r11) {
        if (r11 != 0) goto L13;
        L.j(this.f14987a, "mod num is 0");
        return r10;
    L13:
        return r10 % r11;
    L7:
        e = move-exception;
        if ((e instanceof ArithmeticException) == false) goto L11;
        L.j(this.f14987a, q.p("不要乱除0呀 ", e.getMessage()));
        return r10;
    L11:
        L.j(this.f14987a, q.p("抓住了一个Exception并ignore, ", e.getMessage()));
        return r10;
    }

    public abstract void g();

    @NotNull
    public abstract a getCustom();

    public final boolean getDotsClickable() {
        return this.f15003q;
    }

    public final int getDotsColor() {
        return this.f15001o;
    }

    public final float getDotsCornerRadius() {
        return this.f15002p;
    }

    public final float getDotsHeight() {
        return this.f14995i;
    }

    public final float getDotsSpacing() {
        return this.f14999m;
    }

    public final int getDotsStrokeColor() {
        return this.f15004r;
    }

    public final float getDotsStrokeWidth() {
        return this.f15005s;
    }

    public final float getDotsWidth() {
        return this.f14994h;
    }

    public final boolean getInitialized() {
        return this.f14988b;
    }

    public final int getLayoutHeight() {
        return this.f14996j;
    }

    @Nullable
    public final Pager getPager() {
        return this.f15006t;
    }

    public final boolean getPendingRefreshParentLayout() {
        return this.f14989c;
    }

    public final int getSidePadding() {
        return this.f14998l;
    }

    public final int getType() {
        return this.f15000n;
    }

    public final int getVerticalSidePadding() {
        return this.f14997k;
    }

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public final int k() {
        Pager r10 = this.f15006t;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.getCount();
    }

    public final void l() {
        post(new f(this));
    }

    public final void n() {
        if (this.f15006t != null) goto L6;
        return;
    L6:
        if (this.f14988b == true) goto L9;
        this.f14990d = true;
        return;
    L9:
        post(new g(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        n();
        l();
    }

    public final void p() {
        if (this.f14988b == true) goto L6;
        this.f14991e = true;
        return;
    L6:
        this.f14991e = false;
        g();
    }

    public final void q() {
        if (this.f14988b == true) goto L6;
        this.f14993g = true;
        return;
    L6:
        this.f14993g = false;
        h();
    }

    public final void r() {
        if (this.f14988b == true) goto L6;
        this.f14992f = true;
        return;
    L6:
        this.f14992f = false;
        i();
    }

    public final void s() {
        Pager r10 = this.f15006t;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.isNotEmpty() == true) goto L8;
        return;
    L8:
        r10.removeOnPageChangeListener();
        j r11 = e();
        r10.addOnPageChangeListener(r11);
        r11.b(r10.getCurrentItem(), 0.0f);
    }

    public final void setDotsClickable(boolean r10) {
        this.f15003q = r10;
    }

    public final void setDotsColor(int r10) {
        if (this.f15000n == 1) goto L5;
        this.f15001o = r10;
        p();
        return;
    L5:
        this.f15001o = 872415231;
        p();
    }

    public final void setDotsCornerRadius(float r10) {
        if (this.f15002p == r10) goto L7;
        this.f15002p = r10;
        p();
        return;
    }

    public final void setDotsHeight(float r10) {
        if (this.f14995i == r10) goto L7;
        this.f14995i = r10;
        q();
        return;
    }

    public final void setDotsSpacing(float r10) {
        if (this.f14999m == r10) goto L7;
        this.f14999m = r10;
        r();
        return;
    }

    public final void setDotsStrokeColor(int r10) {
        if (this.f15004r == r10) goto L6;
        this.f15004r = r10;
        p();
        return;
    }

    public final void setDotsStrokeWidth(float r10) {
        if (this.f15005s == r10) goto L7;
        this.f15005s = r10;
        p();
        return;
    }

    public final void setDotsWidth(float r10) {
        if (this.f14994h == r10) goto L7;
        this.f14994h = r10;
        q();
        return;
    }

    public final void setInitialized(boolean r10) {
        this.f14988b = r10;
    }

    public final void setLayoutHeight(int r10) {
        if (this.f14996j == r10) goto L6;
        this.f14996j = r10;
        t();
        return;
    }

    public final void setManualCurrentItem(int r10) {
        Pager r11 = this.f15006t;
        if ((r11 instanceof b) == false) goto L5;
        b r12 = (b) r11;
    L6:
        if (r12 != null) goto L8;
        L.j(this.f14987a, "setManualCurrentItem requires setManualPager before manual updates");
        throw new IllegalStateException("setManualCurrentItem requires setManualPager before manual updates");
    L8:
        if (r12.b(r10) == false) goto L13;
        r12.a();
        return;
    L13:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void setManualPageCount(int r10) {
        Pager r11 = this.f15006t;
        if ((r11 instanceof b) == false) goto L5;
        b r12 = (b) r11;
    L6:
        if (r12 != null) goto L8;
        L.j(this.f14987a, "setManualPageCount requires setManualPager before manual updates");
        throw new IllegalStateException("setManualPageCount requires setManualPager before manual updates");
    L8:
        if (r12.c(r10) == false) goto L13;
        n();
        return;
    L13:
        return;
    L5:
        r12 = null;
        goto L6
    }

    @JvmOverloads
    public final void setManualPager(int r10) {
        w(this, r10, 0, null, 6, null);
    }

    public final void setPager(@Nullable Pager r10) {
        Pager r11 = this.f15006t;
        if (r11 == null) goto L6;
        r11.removeOnPageChangeListener();
    L6:
        this.f15006t = r10;
    }

    public final void setPendingRefreshParentLayout(boolean r10) {
        this.f14989c = r10;
    }

    public final void setSidePadding(int r10) {
        if (this.f14998l == r10) goto L6;
        this.f14998l = r10;
        t();
        return;
    }

    public final void setType(int r10) {
        if (this.f15000n == r10) goto L6;
        this.f15000n = r10;
        t();
        p();
        return;
    }

    public final void setVerticalSidePadding(int r10) {
        if (this.f14997k == r10) goto L6;
        this.f14997k = r10;
        t();
        return;
    }

    @Deprecated(message = "需要 pageCount, 否则搭配banner的无限横划时可能出错", replaceWith = @ReplaceWith(expression = "setViewPager(ViewPager, Int) or setViewPager(ViewPager, () -> Int)", imports = {}))
    public final void setViewPager(@NotNull ViewPager r10) {
        q.g(r10, "viewPager");
        PagerAdapter r11 = r10.getAdapter();
        if (r11 != null) goto L5;
        int r12 = 1;
    L6:
        x(r10, r12);
        return;
    L5:
        r12 = r11.getCount();
        goto L6
    }

    public abstract void t();

    public final void u() {
        this.f14988b = true;
    }

    public final void v(int r10, int r11, OnManualPageSelectedListener r12) {
        setPagerDataSetObserver(null);
        setPager(new b(this, r10, r11, r12));
        n();
    }

    public final void x(ViewPager r10, final int r11) {
        q.g(r10, "viewPager");
        y(r10, new AnonymousClass1(r11));
    }

    public final void y(ViewPager r10, Function0 r11) {
        q.g(r10, "viewPager");
        q.g(r11, SlideCard.KEY_PAGE_COUNT);
        if (r10.getAdapter() == null) goto L11;
        setPagerDataSetObserver(new AnonymousClass2(this, r10));
        PagerAdapter r12 = r10.getAdapter();
        q.d(r12);
        Object r13 = this.f15007u;
        if (r13 == null) goto L9;
        r12.registerDataSetObserver((DataSetObserver) r13);
        setPager(new c(r10, this, r11));
        n();
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.database.DataSetObserver");
    L11:
        throw new IllegalStateException("Set an adapter to the view pager before initializing the dots indicator ~");
    }

    @JvmOverloads
    public OBaseIndicator(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OBaseIndicator(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OBaseIndicator(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f14987a = "OBaseIndicator";
        this.f14994h = getCustom().c();
        this.f14995i = getCustom().a();
        this.f14996j = -2;
        this.f14997k = tc.f.r(this, 7);
        this.f14998l = tc.f.r(this, 10);
        this.f14999m = getCustom().b();
        this.f15001o = ContextCompat.b(r10, R$color.oui_text_4);
        this.f15002p = this.f14995i / 2;
        this.f15003q = true;
        this.f15004r = ContextCompat.b(r10, R$color.Transparent);
        this.f15005s = tc.f.u(this, 0);
        if (r11 == null) goto L6;
        TypedArray r13 = r10.obtainStyledAttributes(r11, getCustom().m());
        q.f(r13, "context.obtainStyledAttr…ttrs, custom.styleableId)");
        setType(r13.getInt(getCustom().n(), this.f15000n));
        setDotsWidth(r13.getDimension(getCustom().k(), this.f14994h));
        setDotsHeight(r13.getDimension(getCustom().g(), this.f14995i));
        setLayoutHeight(r13.getDimensionPixelSize(getCustom().l(), -2));
        setDotsSpacing(r13.getDimension(getCustom().h(), this.f14999m));
        setDotsColor(r13.getColor(getCustom().e(), this.f15001o));
        setDotsCornerRadius(r13.getDimension(getCustom().f(), this.f15002p));
        this.f15003q = r13.getBoolean(getCustom().d(), true);
        setDotsStrokeColor(r13.getColor(getCustom().i(), this.f15004r));
        setDotsStrokeWidth(r13.getDimension(getCustom().j(), this.f15005s));
        r13.recycle();
        return;
    }
}

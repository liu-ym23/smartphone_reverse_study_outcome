package com.obric.oui.indicator;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$styleable;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.structure.card.FixCard;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.b0;
import kotlin.collections.g0;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 a2\u00020\u0001:\b¸\u0001¹\u0001º\u0001»\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u001f\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010$\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\"H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\nH\u0002¢\u0006\u0004\b(\u0010\u0015J\u0011\u0010)\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\nH\u0002¢\u0006\u0004\b+\u0010\u0015J\u0017\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b/\u00100J\u001f\u00102\u001a\u00020\n2\u0006\u00101\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b2\u00103J\u0019\u00107\u001a\u0004\u0018\u0001062\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b7\u00108J\u0017\u0010;\u001a\u00020\n2\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b;\u0010<J\u001d\u0010@\u001a\u00020>2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020>0=H\u0002¢\u0006\u0004\b@\u0010AJ\u001d\u0010C\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020>0=H\u0002¢\u0006\u0004\bC\u0010DJ\u0017\u0010G\u001a\u00020\n2\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bG\u0010HJ\u001f\u0010J\u001a\u00020\n2\u0006\u0010:\u001a\u0002092\u0006\u0010I\u001a\u00020.H\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\nH\u0002¢\u0006\u0004\bL\u0010\u0015J\u000f\u0010M\u001a\u00020\nH\u0002¢\u0006\u0004\bM\u0010\u0015J\u000f\u0010N\u001a\u00020\nH\u0002¢\u0006\u0004\bN\u0010\u0015J\u0017\u0010O\u001a\u00020\n2\u0006\u00101\u001a\u00020\u001dH\u0002¢\u0006\u0004\bO\u0010PJ'\u0010T\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\u001d2\u0006\u0010R\u001a\u00020\u001d2\u0006\u0010S\u001a\u00020\"H\u0002¢\u0006\u0004\bT\u0010UJ\u001f\u0010W\u001a\u00020V2\u0006\u0010F\u001a\u00020E2\u0006\u00101\u001a\u00020\u001dH\u0002¢\u0006\u0004\bW\u0010XJ\u0017\u0010Z\u001a\u00020\"2\u0006\u0010Y\u001a\u00020VH\u0002¢\u0006\u0004\bZ\u0010[J\u0017\u0010\\\u001a\u00020\"2\u0006\u0010Y\u001a\u00020VH\u0002¢\u0006\u0004\b\\\u0010[J\u001f\u0010]\u001a\u00020\n2\u0006\u0010:\u001a\u0002092\u0006\u0010Y\u001a\u00020VH\u0002¢\u0006\u0004\b]\u0010^J/\u0010a\u001a\u00020\n2\u0006\u0010:\u001a\u0002092\u0006\u0010_\u001a\u00020V2\u0006\u0010`\u001a\u00020V2\u0006\u0010S\u001a\u00020\"H\u0002¢\u0006\u0004\ba\u0010bJ'\u0010e\u001a\u00020\"2\u0006\u0010c\u001a\u00020\"2\u0006\u0010d\u001a\u00020\"2\u0006\u0010S\u001a\u00020\"H\u0002¢\u0006\u0004\be\u0010fJ'\u0010g\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\bg\u0010%J'\u0010j\u001a\u00020\n2\u0006\u0010h\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u001dH\u0002¢\u0006\u0004\bj\u0010kJ\u001f\u0010m\u001a\u00020\n2\u0006\u0010F\u001a\u00020E2\u0006\u0010l\u001a\u00020\u0006H\u0002¢\u0006\u0004\bm\u0010nJ\u0019\u0010p\u001a\u0004\u0018\u00010E2\u0006\u0010o\u001a\u00020\u0006H\u0002¢\u0006\u0004\bp\u0010qJ%\u0010t\u001a\b\u0012\u0004\u0012\u0002040s2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010r\u001a\u00020,H\u0002¢\u0006\u0004\bt\u0010uJ\u0013\u0010v\u001a\u00020\u0006*\u00020,H\u0002¢\u0006\u0004\bv\u0010wJ\u0017\u0010y\u001a\u00020\n2\b\b\u0001\u0010x\u001a\u00020\u0006¢\u0006\u0004\by\u0010zJ\u0015\u0010y\u001a\u00020\n2\u0006\u0010|\u001a\u00020{¢\u0006\u0004\by\u0010}J\u000f\u0010~\u001a\u00020\nH\u0014¢\u0006\u0004\b~\u0010\u0015J\u000f\u0010\u007f\u001a\u00020\nH\u0014¢\u0006\u0004\b\u007f\u0010\u0015J\u0011\u0010\u0080\u0001\u001a\u00020\nH\u0014¢\u0006\u0005\b\u0080\u0001\u0010\u0015J\u0011\u0010\u0081\u0001\u001a\u00020\nH\u0014¢\u0006\u0005\b\u0081\u0001\u0010\u0015J\u0013\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0016¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u0011\u0010\u0085\u0001\u001a\u00020\nH\u0016¢\u0006\u0005\b\u0085\u0001\u0010\u0015R\u001a\u0010\u0089\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010\u008d\u0001\u001a\u00030\u008a\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0019\u0010\u0090\u0001\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001e\u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u00020E0\u0091\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001d\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020>0=8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0018\u0010\u0099\u0001\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0098\u0001\u00102R\u0018\u0010\u009b\u0001\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009a\u0001\u00102R\u0018\u0010\u009d\u0001\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009c\u0001\u00102R\u001b\u0010 \u0001\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0018\u0010¤\u0001\u001a\u00030¡\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R0\u0010ª\u0001\u001a\u00020\u00062\u0007\u0010¥\u0001\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0005\b¦\u0001\u0010j\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0005\b©\u0001\u0010zR/\u0010\u0010\u001a\u00020\u00062\u0007\u0010¥\u0001\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0005\b«\u0001\u0010j\u001a\u0006\b¬\u0001\u0010¨\u0001\"\u0005\b\u00ad\u0001\u0010zR/\u0010°\u0001\u001a\u00020\u00062\u0007\u0010¥\u0001\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0004\b@\u0010j\u001a\u0006\b®\u0001\u0010¨\u0001\"\u0005\b¯\u0001\u0010zR\u0017\u0010³\u0001\u001a\u00030±\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bj\u0010²\u0001R\u0018\u0010·\u0001\u001a\u00030´\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bµ\u0001\u0010¶\u0001¨\u0006¼\u0001"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator;", "Lcom/obric/oui/indicator/OBaseIndicator;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "X", "(Landroid/util/AttributeSet;)V", "Lcom/obric/oui/indicator/IndicatorAnimator;", "V", "()Lcom/obric/oui/indicator/IndicatorAnimator;", "sizeStyle", "Lcom/obric/oui/indicator/OCarouselIndicator$b;", "f0", "(I)Lcom/obric/oui/indicator/OCarouselIndicator$b;", "O", "()V", "N", PerfConsts.KEY_CURRENT_GALVANIC, "Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;", "reason", "e0", "(ILcom/obric/oui/indicator/IndicatorAnimator$RenderReason;)V", "totalCount", "Lcom/obric/oui/indicator/d;", "m0", "(II)Lcom/obric/oui/indicator/d;", "selectedPosition", "nextPosition", "", "positionOffset", "L", "(IIF)V", "n0", "()F", "r0", "i0", "()Ljava/lang/Integer;", "U", "Lbg/c;", "targetRange", "", "o0", "(Lbg/c;)Z", WsConstants.KEY_CONNECTION_STATE, "Z", "(Lcom/obric/oui/indicator/d;Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;)V", "Lcom/obric/oui/indicator/OCarouselIndicator$d;", "binding", "Lcom/obric/oui/indicator/IndicatorImageDotView;", "k0", "(Lcom/obric/oui/indicator/OCarouselIndicator$d;)Lcom/obric/oui/indicator/IndicatorImageDotView;", "Landroid/view/View;", "dotView", "T", "(Landroid/view/View;)V", "Ljava/util/ArrayDeque;", "Lcom/obric/oui/indicator/IndicatorDotView;", "reusableDefaultDots", "H", "(Ljava/util/ArrayDeque;)Lcom/obric/oui/indicator/IndicatorDotView;", "defaultDots", "a0", "(Ljava/util/ArrayDeque;)V", "Lcom/obric/oui/indicator/OCarouselIndicator$c;", "slot", "R", "(Lcom/obric/oui/indicator/OCarouselIndicator$c;)V", "preserveMargins", "q0", "(Landroid/view/View;Z)V", "c0", "d0", "s0", "P", "(Lcom/obric/oui/indicator/d;)V", "sourceState", "targetState", "progress", "Q", "(Lcom/obric/oui/indicator/d;Lcom/obric/oui/indicator/d;F)V", "Lcom/obric/oui/indicator/IndicatorDotVisualState;", "l0", "(Lcom/obric/oui/indicator/OCarouselIndicator$c;Lcom/obric/oui/indicator/d;)Lcom/obric/oui/indicator/IndicatorDotVisualState;", "visualState", "h0", "(Lcom/obric/oui/indicator/IndicatorDotVisualState;)F", "g0", "K", "(Landroid/view/View;Lcom/obric/oui/indicator/IndicatorDotVisualState;)V", "sourceVisualState", "targetVisualState", "J", "(Landroid/view/View;Lcom/obric/oui/indicator/IndicatorDotVisualState;Lcom/obric/oui/indicator/IndicatorDotVisualState;F)V", "start", "end", "Y", "(FFF)F", "M", SlideCard.KEY_INDEX, "color", "I", "(IILcom/obric/oui/indicator/d;)V", "currentItem", "b0", "(Lcom/obric/oui/indicator/OCarouselIndicator$c;I)V", "pageIndex", "W", "(I)Lcom/obric/oui/indicator/OCarouselIndicator$c;", "visibleRange", "", "j0", "(ILbg/c;)Ljava/util/List;", "p0", "(Lbg/c;)I", "iconResId", "setStartDotDrawable", "(I)V", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "j", "g", "i", "h", "Lcom/obric/oui/indicator/j;", "e", "()Lcom/obric/oui/indicator/j;", "t", "Lcom/obric/oui/indicator/IndicatorGroupLayout;", "v", "Lcom/obric/oui/indicator/IndicatorGroupLayout;", "groupLayout", "Landroid/widget/LinearLayout;", "w", "Landroid/widget/LinearLayout;", "dotsTrackLayout", FixCard.FixStyle.KEY_X, "Lcom/obric/oui/indicator/IndicatorAnimator;", "indicatorAnimator", "", FixCard.FixStyle.KEY_Y, "Ljava/util/List;", "renderedSlot", "z", "Ljava/util/ArrayDeque;", "recycledDefaultDots", "A", "hasExplicitDotsWidth", "B", "hasExplicitDotsHeight", "C", "hasExplicitDotsSpacing", "D", "Lcom/obric/oui/indicator/IndicatorImageDotView;", "startDrawableDotView", "Landroid/view/animation/DecelerateInterpolator;", "E", "Landroid/view/animation/DecelerateInterpolator;", "viewportTransitionInterpolator", CommonKey.KEY_VALUE, "F", "getMaxVisibleDots", "()I", "setMaxVisibleDots", "maxVisibleDots", "G", "getSizeStyle", "setSizeStyle", "getSelectedDotColor", "setSelectedDotColor", "selectedDotColor", "Landroid/animation/ArgbEvaluator;", "Landroid/animation/ArgbEvaluator;", "argbEvaluator", "Lcom/obric/oui/indicator/OBaseIndicator$a;", "getCustom", "()Lcom/obric/oui/indicator/OBaseIndicator$a;", "custom", "a", "b", "c", "d", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCarouselIndicator extends OBaseIndicator {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final a f15036J = null;
    public static final boolean K = false;
    public boolean A;
    public boolean B;
    public boolean C;
    public IndicatorImageDotView D;
    public final DecelerateInterpolator E;
    public int F;
    public int G;
    public int H;
    public final ArgbEvaluator I;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public IndicatorGroupLayout f15037v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public LinearLayout f15038w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public IndicatorAnimator f15039x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List f15040y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ArrayDeque f15041z;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f15042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f15043b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f15044c;

        public b(float r10, float r11, float r12) {
            this.f15042a = r10;
            this.f15043b = r11;
            this.f15044c = r12;
        }

        public final float a() {
            return this.f15043b;
        }

        public final float b() {
            return this.f15044c;
        }

        public final float c() {
            return this.f15042a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (q.b(Float.valueOf(this.f15042a), Float.valueOf(r11.f15042a)) == true) goto L12;
            return false;
        L12:
            if (q.b(Float.valueOf(this.f15043b), Float.valueOf(r11.f15043b)) == true) goto L15;
            return false;
        L15:
            if (q.b(Float.valueOf(this.f15044c), Float.valueOf(r11.f15044c)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Float.hashCode(this.f15042a) * 31) + Float.hashCode(this.f15043b)) * 31) + Float.hashCode(this.f15044c);
        }

        public String toString() {
            return "DotLayoutProfile(width=" + this.f15042a + ", height=" + this.f15043b + ", spacing=" + this.f15044c + ')';
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f15045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f15046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IndicatorIcon f15047c;

        public c(d r10, View r11, IndicatorIcon r12) {
            q.g(r10, "binding");
            q.g(r11, "view");
            q.g(r12, "indicator");
            this.f15045a = r10;
            this.f15046b = r11;
            this.f15047c = r12;
        }

        public final d a() {
            return this.f15045a;
        }

        public final IndicatorIcon b() {
            return this.f15047c;
        }

        public final View c() {
            return this.f15046b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (q.b(this.f15045a, r11.f15045a) == true) goto L12;
            return false;
        L12:
            if (q.b(this.f15046b, r11.f15046b) == true) goto L15;
            return false;
        L15:
            if (q.b(this.f15047c, r11.f15047c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f15045a.hashCode() * 31) + this.f15046b.hashCode()) * 31) + this.f15047c.hashCode();
        }

        public String toString() {
            return "RenderSlot(binding=" + this.f15045a + ", view=" + this.f15046b + ", indicator=" + this.f15047c + ')';
        }
    }

    public static abstract class d {

        public static final class a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f15048a = null;

            static {
                f15048a = new a();
            }

            public a() {
                super(null);
            }
        }

        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f15049a;

            public b(int r10) {
                super(null);
                this.f15049a = r10;
            }

            public final int a() {
                return this.f15049a;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof b) == true) goto L9;
                return false;
            L9:
                if (this.f15049a == ((b) r10).f15049a) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return Integer.hashCode(this.f15049a);
            }

            public String toString() {
                return "Page(pageIndex=" + this.f15049a + ')';
            }
        }

        public static final class c extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f15050a = null;

            static {
                f15050a = new c();
            }

            public c() {
                super(null);
            }
        }

        public /* synthetic */ d(DefaultConstructorMarker r10) {
            this();
        }

        public d() {
        }
    }

    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15051a = null;

        static {
            int[] r10 = new int[IndicatorDotVisualState.values().length];
            r10[IndicatorDotVisualState.EDGE.ordinal()] = 1;
            r10[IndicatorDotVisualState.HIDDEN.ordinal()] = 2;
            r10[IndicatorDotVisualState.ACTIVE.ordinal()] = 3;
            f15051a = r10;
        }
    }

    public static final class f extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OCarouselIndicator f15052b;

        public f(OCarouselIndicator r10) {
            this.f15052b = r10;
        }

        @Override // com.obric.oui.indicator.j
        public int a() {
            return this.f15052b.k();
        }

        @Override // com.obric.oui.indicator.j
        public void c(int r10, int r11, float r12) {
            OCarouselIndicator.A(this.f15052b, r10, r11, r12);
        }
    }

    public static final class g implements IndicatorAnimator.Host {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OCarouselIndicator f15053a;

        public g(OCarouselIndicator r10) {
            this.f15053a = r10;
        }

        @Override // com.obric.oui.indicator.IndicatorAnimator.Host
        public void applyViewportState(com.obric.oui.indicator.d r10) {
            q.g(r10, WsConstants.KEY_CONNECTION_STATE);
            OCarouselIndicator.B(this.f15053a, r10);
        }

        @Override // com.obric.oui.indicator.IndicatorAnimator.Host
        public void applyViewportTransitionProgress(com.obric.oui.indicator.d r10, com.obric.oui.indicator.d r11, float r12) {
            q.g(r10, "sourceState");
            q.g(r11, "targetState");
            OCarouselIndicator.C(this.f15053a, r10, r11, r12);
        }

        @Override // com.obric.oui.indicator.IndicatorAnimator.Host
        public void cancelVisibleDotAnimations() {
            OCarouselIndicator.D(this.f15053a);
        }

        @Override // com.obric.oui.indicator.IndicatorAnimator.Host
        public int getMaxVisibleDots() {
            return this.f15053a.getMaxVisibleDots();
        }

        @Override // com.obric.oui.indicator.IndicatorAnimator.Host
        public int getPagerCount() {
            return this.f15053a.k();
        }

        @Override // com.obric.oui.indicator.IndicatorAnimator.Host
        public void rebindVisibleSlots(com.obric.oui.indicator.d r10, IndicatorAnimator.RenderReason r11) {
            q.g(r10, WsConstants.KEY_CONNECTION_STATE);
            q.g(r11, "reason");
            OCarouselIndicator.E(this.f15053a, r10, r11);
        }

        @Override // com.obric.oui.indicator.IndicatorAnimator.Host
        public float resolveViewportStepDistance() {
            return OCarouselIndicator.F(this.f15053a);
        }

        @Override // com.obric.oui.indicator.IndicatorAnimator.Host
        public boolean shouldRebindVisibleSlots(bg.c r10) {
            q.g(r10, "targetRange");
            return OCarouselIndicator.G(this.f15053a, r10);
        }
    }

    static {
        f15036J = new a(null);
    }

    @JvmOverloads
    public OCarouselIndicator(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static final /* synthetic */ void A(OCarouselIndicator r10, int r11, int r12, float r13) {
        r10.L(r11, r12, r13);
    }

    public static final /* synthetic */ void B(OCarouselIndicator r10, com.obric.oui.indicator.d r11) {
        r10.P(r11);
    }

    public static final /* synthetic */ void C(OCarouselIndicator r10, com.obric.oui.indicator.d r11, com.obric.oui.indicator.d r12, float r13) {
        r10.Q(r11, r12, r13);
    }

    public static final /* synthetic */ void D(OCarouselIndicator r10) {
        r10.U();
    }

    public static final /* synthetic */ void E(OCarouselIndicator r10, com.obric.oui.indicator.d r11, IndicatorAnimator.RenderReason r12) {
        r10.Z(r11, r12);
    }

    public static final /* synthetic */ float F(OCarouselIndicator r10) {
        return r10.n0();
    }

    public static final /* synthetic */ boolean G(OCarouselIndicator r10, bg.c r11) {
        return r10.o0(r11);
    }

    public static final void S(c r10, OCarouselIndicator r11, View r12) {
        q.g(r10, "$slot");
        q.g(r11, "this$0");
        d r13 = r10.a();
        if ((r13 instanceof d.b) == true) goto L5;
        return;
    L5:
        if (r11.getDotsClickable() == false) goto L14;
        d.b r14 = (d.b) r13;
        if (r14.a() >= r11.k()) goto L15;
        OBaseIndicator.Pager r15 = r11.getPager();
        if (r15 == null) goto L16;
        r15.setCurrentItem(r14.a(), false);
        return;
    L16:
        return;
    L15:
        return;
    }

    public static /* synthetic */ void z(c r10, OCarouselIndicator r11, View r12) {
        S(r10, r11, r12);
    }

    public final IndicatorDotView H(ArrayDeque r10) {
        IndicatorDotView r11 = (IndicatorDotView) r10.pollFirst();
        if (r11 != null) goto L14;
        r11 = (IndicatorDotView) this.f15041z.pollFirst();
        if (r11 != null) goto L12;
        if (K == false) goto L9;
        L.a("OCarouselIndicator", "Create new default dot");
    L9:
        Context r12 = getContext();
        q.f(r12, "context");
        return new IndicatorDotView(r12, null, 0, 6, null);
    L12:
        if (K == false) goto L14;
        L.a("OCarouselIndicator", q.p("Reuse pooled default dot, remaining=", Integer.valueOf(this.f15041z.size())));
    L14:
        return r11;
    }

    public final void I(int r10, int r11, com.obric.oui.indicator.d r12) {
        if (r12.d(r10) == true) goto L5;
        return;
    L5:
        c r13 = W(r10);
        if (r13 != null) goto L8;
        return;
    L8:
        r13.b().setDotColor(r11);
        r13.b().invalidate();
    }

    public final void J(View r10, IndicatorDotVisualState r11, IndicatorDotVisualState r12, float r13) {
        if (r11 != r12) goto L5;
        K(r10, r11);
        return;
    L5:
        float r14 = h0(r11);
        float r15 = h0(r12);
        float r16 = g0(r11);
        float r17 = g0(r12);
        float r18 = Y(r14, r15, r13);
        float r19 = Y(r16, r17, r13);
        if (r13 >= 1.0f) goto L8;
    L10:
        int r20 = 0;
    L12:
        if (r10.getVisibility() == r20) goto L14;
    L20:
        T(r10);
        r10.setVisibility(r20);
        r10.setScaleX(r18);
        r10.setScaleY(r18);
        r10.setAlpha(r19);
        return;
    L14:
        if (r10.getScaleX() != r18) goto L20;
        if (r10.getScaleY() != r18) goto L20;
        if (r10.getAlpha() != r19) goto L20;
        return;
    L8:
        if (r12 != IndicatorDotVisualState.HIDDEN) goto L10;
        r20 = 4;
        goto L12
    }

    public final void K(View r10, IndicatorDotVisualState r11) {
        if (r11 != IndicatorDotVisualState.HIDDEN) goto L5;
        int r12 = 4;
    L6:
        float r13 = h0(r11);
        float r14 = g0(r11);
        if (r10.getVisibility() == r12) goto L9;
    L15:
        T(r10);
        r10.setVisibility(r12);
        r10.setScaleX(r13);
        r10.setScaleY(r13);
        r10.setAlpha(r14);
        return;
    L9:
        if (r10.getScaleX() != r13) goto L15;
        if (r10.getScaleY() != r13) goto L15;
        if (r10.getAlpha() != r14) goto L15;
        return;
    L5:
        r12 = 0;
        goto L6
    }

    public final void L(int r10, int r11, float r12) {
        int r13 = k();
        com.obric.oui.indicator.d r14 = m0(r13, r10);
        com.obric.oui.indicator.d r15 = m0(r13, r11);
        IndicatorAnimator r16 = null;
        if (q.b(r14.c(), r15.c()) == true) goto L9;
        IndicatorAnimator r17 = this.f15039x;
        if (r17 != null) goto L7;
        q.y("indicatorAnimator");
    L8:
        e0(r16.k(r10, r11, r12), IndicatorAnimator.RenderReason.SCROLL);
    L14:
        M(r10, r11, r12);
        invalidate();
        return;
    L7:
        r16 = r17;
        goto L8
    L9:
        IndicatorAnimator r18 = this.f15039x;
        if (r18 != null) goto L12;
        q.y("indicatorAnimator");
    L13:
        r16.i(IndicatorAnimator.RenderReason.REFRESH_DOTS, r14);
        Q(r14, r15, r12);
        goto L14
    L12:
        r16 = r18;
        goto L13
    }

    public final void M(int r10, int r11, float r12) {
        IndicatorAnimator r13 = this.f15039x;
        if (r13 != null) goto L5;
        q.y("indicatorAnimator");
        r13 = null;
    L5:
        com.obric.oui.indicator.d r14 = r13.g();
        if (r14 != null) goto L9;
        return;
    L9:
        if (r14.d(r10) == true) goto L11;
        return;
    L11:
        if (r14.d(r11) == false) goto L30;
        Object r15 = this.I.evaluate(r12, Integer.valueOf(this.H), Integer.valueOf(getDotsColor()));
        if (r15 == null) goto L28;
        int r16 = ((Integer) r15).intValue();
        Object r17 = this.I.evaluate(r12, Integer.valueOf(getDotsColor()), Integer.valueOf(this.H));
        if (r17 == null) goto L26;
        I(r11, ((Integer) r17).intValue(), r14);
        OBaseIndicator.Pager r18 = getPager();
        if (r18 != null) goto L21;
    L23:
        I(r10, r16, r14);
        return;
    L21:
        if (r10 != r18.getCurrentItem()) goto L23;
        r16 = this.H;
        goto L23
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L28:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final void N() {
        b r10 = f0(this.G);
        if (this.A == true) goto L6;
        setDotsWidth(r10.c());
    L6:
        if (this.B == true) goto L9;
        setDotsHeight(r10.a());
    L9:
        if (this.C == true) goto L12;
        setDotsSpacing(r10.b());
    L12:
        if (K == false) goto L15;
        L.a("OCarouselIndicator", "sizeStyle=" + this.G + " resolved to w=" + getDotsWidth() + " h=" + getDotsHeight() + " spacing=" + getDotsSpacing() + " explicit=[" + this.A + ',' + this.B + ',' + this.C + ']');
        return;
    }

    public final void O() {
        Context r10 = getContext();
        q.f(r10, "context");
        int r11 = tc.f.a(r10, 4.0f);
        Context r12 = getContext();
        q.f(r12, "context");
        int r13 = tc.f.a(r12, 4.0f);
        IndicatorGroupLayout r14 = this.f15037v;
        if (r14 != null) goto L5;
        q.y("groupLayout");
        r14 = null;
    L5:
        r14.setPadding(r11, r13, r11, r13);
    }

    public final void P(com.obric.oui.indicator.d r10) {
        OBaseIndicator.Pager r11 = getPager();
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        Iterator r13 = this.f15040y.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        c r14 = (c) r13.next();
        K(r14.c(), l0(r14, r10));
        b0(r14, r12);
        goto L8
    L10:
        return;
    L5:
        r12 = r11.getCurrentItem();
        goto L6
    }

    public final void Q(com.obric.oui.indicator.d r10, com.obric.oui.indicator.d r11, float r12) {
        OBaseIndicator.Pager r13 = getPager();
        if (r13 != null) goto L5;
        int r14 = 0;
    L6:
        Iterator r15 = this.f15040y.iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        c r16 = (c) r15.next();
        J(r16.c(), l0(r16, r10), l0(r16, r11), r12);
        b0(r16, r14);
        goto L8
    L10:
        return;
    L5:
        r14 = r13.getCurrentItem();
        goto L6
    }

    public final void R(final c r10) {
        int r11 = 0;
        q0(r10.c(), false);
        OBaseIndicator.Pager r12 = getPager();
        if (r12 == null) goto L6;
        r11 = r12.getCurrentItem();
    L6:
        b0(r10, r11);
        r10.c().setOnClickListener(new i(r10, this));
    }

    public final void T(View r10) {
        r10.animate().setListener(null).cancel();
    }

    public final void U() {
        Iterator r10 = this.f15040y.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        T(((c) r10.next()).c());
        goto L4
    }

    public final IndicatorAnimator V() {
        LinearLayout r10 = this.f15038w;
        if (r10 != null) goto L6;
        q.y("dotsTrackLayout");
        r10 = null;
    L6:
        return new IndicatorAnimator(r10, this.E, new g(this));
    }

    public final c W(int r10) {
        Iterator r11 = this.f15040y.iterator();
    L4:
        if (r11.hasNext() == false) goto L19;
        Object r12 = r11.next();
        d r13 = ((c) r12).a();
        boolean r14 = false;
        boolean r15 = true;
        if ((r13 instanceof d.b) == false) goto L11;
        if (((d.b) r13).a() != r10) goto L15;
        r14 = true;
    L15:
        if (r14 == false) goto L4;
    L21:
        return (c) r12;
    L11:
        if (q.b(r13, d.a.f15048a) == true) goto L14;
        r15 = q.b(r13, d.c.f15050a);
    L14:
        if (r15 == true) goto L15;
        throw new NoWhenBranchMatchedException();
    L19:
        r12 = null;
        goto L21
    }

    public final void X(AttributeSet r10) {
        Context r11 = getContext();
        q.f(r11, "context");
        IndicatorGroupLayout r12 = new IndicatorGroupLayout(r11, null, 0, 6, null);
        r12.setGravity(17);
        this.f15037v = r12;
        LinearLayout r13 = new LinearLayout(getContext());
        r13.setOrientation(0);
        r13.setGravity(17);
        this.f15038w = r13;
        IndicatorGroupLayout r14 = null;
        if (getType() != 1) goto L14;
        IndicatorGroupLayout r15 = this.f15037v;
        if (r15 != null) goto L7;
        q.y("groupLayout");
        r15 = null;
    L7:
        r15.setBgColor(ContextCompat.b(getContext(), R$color.carousel_indicator_bg_color));
        IndicatorGroupLayout r16 = this.f15037v;
        if (r16 != null) goto L10;
        q.y("groupLayout");
        r16 = null;
    L10:
        r16.setCornerRadius(tc.f.r(this, 100));
        IndicatorGroupLayout r17 = this.f15037v;
        if (r17 != null) goto L13;
        q.y("groupLayout");
        r17 = null;
    L13:
        r17.setDrawBackground(true);
    L18:
        IndicatorGroupLayout r18 = this.f15037v;
        if (r18 != null) goto L21;
        q.y("groupLayout");
        r18 = null;
    L21:
        r18.setPadding(getSidePadding(), 0, getSidePadding(), 0);
        IndicatorGroupLayout r19 = this.f15037v;
        if (r19 != null) goto L24;
        q.y("groupLayout");
        r19 = null;
    L24:
        LinearLayout r20 = this.f15038w;
        if (r20 != null) goto L27;
        q.y("dotsTrackLayout");
        r20 = null;
    L27:
        r19.addView(r20, new LinearLayout.LayoutParams(-2, -2));
        IndicatorGroupLayout r21 = this.f15037v;
        if (r21 != null) goto L30;
        q.y("groupLayout");
    L31:
        addView(r14, new LinearLayout.LayoutParams(-2, getLayoutHeight()));
        this.f15039x = V();
        if (r10 == null) goto L34;
        Context r22 = getContext();
        q.f(r22, "context");
        TypedArray r110 = r22.obtainStyledAttributes(r10, getCustom().m(), 0, 0);
        q.f(r110, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.A = r110.hasValue(R$styleable.OCarouselIndicator_oui_dotsWidth);
        this.B = r110.hasValue(R$styleable.OCarouselIndicator_oui_dotsHeight);
        this.C = r110.hasValue(R$styleable.OCarouselIndicator_oui_dotsSpacing);
        setSelectedDotColor(r110.getColor(R$styleable.OCarouselIndicator_oui_selectedDotColor, getSelectedDotColor()));
        setMaxVisibleDots(r110.getInt(R$styleable.OCarouselIndicator_oui_maxVisibleDots, getMaxVisibleDots()));
        setSizeStyle(r110.getInt(R$styleable.OCarouselIndicator_oui_sizeStyle, 0));
        r110.recycle();
    L34:
        N();
        if (getType() == 1) goto L37;
        return;
    L37:
        if (this.G != 1) goto L41;
        O();
        return;
    L41:
        return;
    L30:
        r14 = r21;
        goto L31
    L14:
        IndicatorGroupLayout r23 = this.f15037v;
        if (r23 != null) goto L17;
        q.y("groupLayout");
        r23 = null;
    L17:
        r23.setDrawBackground(false);
        goto L18
    }

    public final float Y(float r10, float r11, float r12) {
        return r10 + ((r11 - r10) * r12);
    }

    public final void Z(com.obric.oui.indicator.d r10, IndicatorAnimator.RenderReason r11) {
        U();
        bg.c r12 = r10.c();
        ArrayDeque r13 = new ArrayDeque();
        Iterator r14 = this.f15040y.iterator();
    L3:
        IndicatorDotView r15 = null;
        if (r14.hasNext() == false) goto L11;
        View r16 = ((c) r14.next()).c();
        if ((r16 instanceof IndicatorDotView) == false) goto L8;
        r15 = (IndicatorDotView) r16;
    L8:
        if (r15 == null) goto L3;
        r13.addLast(r15);
        goto L3
    L11:
        LinearLayout r17 = this.f15038w;
        if (r17 != null) goto L14;
        q.y("dotsTrackLayout");
        r17 = null;
    L14:
        r17.removeAllViews();
        this.f15040y.clear();
        List r18 = j0(r10.b(), r12);
        Iterator r19 = r18.iterator();
    L16:
        if (r19.hasNext() == false) goto L31;
        d r20 = (d) r19.next();
        IndicatorImageDotView r21 = k0(r20);
        IndicatorDotView r22 = r21;
        if (r21 != null) goto L20;
        r22 = H(r13);
    L20:
        ViewParent r23 = r22.getParent();
        if ((r23 instanceof ViewGroup) == false) goto L23;
        ViewGroup r24 = (ViewGroup) r23;
    L24:
        if (r24 == null) goto L27;
        r24.removeView(r22);
    L27:
        c r25 = new c(r20, r22, r22);
        R(r25);
        LinearLayout r26 = this.f15038w;
        if (r26 != null) goto L30;
        q.y("dotsTrackLayout");
        r26 = null;
    L30:
        r26.addView(r25.c());
        this.f15040y.add(r25);
        goto L16
    L23:
        r24 = null;
        goto L24
    L31:
        a0(r13);
        s0();
        if (K == false) goto L43;
        L.a("OCarouselIndicator", "Rebound slots, reason=" + r11.getLogValue() + " range=" + r12 + " bindings=" + r18 + " visible=" + this.f15040y.size() + " recycled=" + this.f15041z.size());
        return;
    }

    public final void a0(ArrayDeque r10) {
    L3:
        if (r10.isEmpty() == true) goto L5;
        IndicatorDotView r11 = (IndicatorDotView) r10.removeFirst();
        this.f15041z.addLast(r11);
        goto L3
    }

    public final void b0(c r10, int r11) {
        IndicatorIcon r12 = r10.b();
        d r13 = r10.a();
        if ((r13 instanceof d.b) == false) goto L9;
        if (((d.b) r13).a() != r11) goto L7;
        int r14 = this.H;
    L14:
        r12.setDotColor(r14);
        r10.b().setCornerRadius(getDotsCornerRadius());
        r10.b().setStrokeWidth(getDotsStrokeWidth());
        r10.b().setStrokeColor(getDotsStrokeColor());
        r10.b().invalidate();
        return;
    L7:
        r14 = getDotsColor();
        goto L14
    L9:
        if (q.b(r13, d.a.f15048a) == false) goto L11;
        boolean r15 = true;
    L12:
        if (r15 == false) goto L17;
        r14 = getDotsColor();
        goto L14
    L17:
        throw new NoWhenBranchMatchedException();
    L11:
        r15 = q.b(r13, d.c.f15050a);
        goto L12
    }

    public final void c0() {
        OBaseIndicator.Pager r10 = getPager();
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        Iterator r12 = this.f15040y.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        b0((c) r12.next(), r11);
        goto L8
    L10:
        return;
    L5:
        r11 = r10.getCurrentItem();
        goto L6
    }

    public final void d0() {
        OBaseIndicator.Pager r10 = getPager();
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        Iterator r12 = this.f15040y.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        c r13 = (c) r12.next();
        q0(r13.c(), true);
        b0(r13, r11);
        goto L8
    L10:
        Iterator r14 = this.f15041z.iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        IndicatorDotView r15 = (IndicatorDotView) r14.next();
        q.f(r15, "it");
        q0(r15, true);
        goto L12
    L14:
        IndicatorImageDotView r16 = this.D;
        if (r16 == null) goto L21;
        q0(r16, true);
        return;
    L21:
        return;
    L5:
        r11 = r10.getCurrentItem();
        goto L6
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public j e() {
        return new f(this);
    }

    public final void e0(int r10, IndicatorAnimator.RenderReason r11) {
        com.obric.oui.indicator.d r12 = m0(k(), r10);
        IndicatorAnimator r13 = this.f15039x;
        if (r13 != null) goto L5;
        q.y("indicatorAnimator");
        r13 = null;
    L5:
        r13.i(r11, r12);
    }

    public final b f0(int r10) {
        b r11 = new b(getCustom().c(), getCustom().a(), getCustom().b());
        if (r10 != 1) goto L6;
        Context r12 = getContext();
        q.f(r12, "context");
        float r13 = tc.f.d(r12, 4.0f);
        Context r14 = getContext();
        q.f(r14, "context");
        float r15 = tc.f.d(r14, 4.0f);
        Context r16 = getContext();
        q.f(r16, "context");
        return new b(r13, r15, tc.f.d(r16, 2.0f));
    L6:
        return r11;
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void g() {
        c0();
    }

    public final float g0(IndicatorDotVisualState r10) {
        int r11 = e.f15051a[r10.ordinal()];
        if (r11 != 2) goto L5;
        return 0.0f;
    L5:
        if (r11 == 3) goto L7;
        return 0.35f;
    L7:
        return 1.0f;
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    @NotNull
    public OBaseIndicator.a getCustom() {
        float r10 = tc.f.u(this, 6);
        float r11 = tc.f.u(this, 6);
        float r12 = tc.f.u(this, 4);
        int[] r13 = R$styleable.OCarouselIndicator;
        q.f(r13, "OCarouselIndicator");
        return new OBaseIndicator.a(r10, r11, r12, r13, R$styleable.OCarouselIndicator_oui_type, R$styleable.OCarouselIndicator_oui_layoutHeight, R$styleable.OCarouselIndicator_oui_dotsWidth, R$styleable.OCarouselIndicator_oui_dotsHeight, R$styleable.OCarouselIndicator_oui_dotsSpacing, R$styleable.OCarouselIndicator_oui_dotsColor, R$styleable.OCarouselIndicator_oui_dotsCornerRadius, R$styleable.OCarouselIndicator_oui_dotsClickable, R$styleable.OCarouselIndicator_oui_dotsStrokeColor, R$styleable.OCarouselIndicator_oui_dotsStrokeWidth);
    }

    public final int getMaxVisibleDots() {
        return this.F;
    }

    public final int getSelectedDotColor() {
        return this.H;
    }

    public final int getSizeStyle() {
        return this.G;
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void h() {
        r0();
        d0();
    }

    public final float h0(IndicatorDotVisualState r10) {
        int r11 = e.f15051a[r10.ordinal()];
        if (r11 != 1) goto L5;
        return 0.5f;
    L5:
        if (r11 == 2) goto L7;
        return 1.0f;
    L7:
        return 0.0f;
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void i() {
        r0();
        s0();
    }

    public final Integer i0() {
        if (getType() == 1) goto L5;
        return null;
    L5:
        int r10 = k();
        if (r10 <= 0) goto L16;
        int r11 = this.F;
        if (r10 <= r11) goto L16;
        int r12 = bg.h.d(r11, 0);
        if (r12 != 0) goto L15;
        L.j("OCarouselIndicator", q.p("Skip PIC stable content width because maxVisibleDots is invalid, maxVisibleDots=", Integer.valueOf(this.F)));
        return null;
    L15:
        return Integer.valueOf(yf.b.b((r12 * getDotsWidth()) + (((r12 - 1) * getDotsSpacing()) * 2.0f)));
    L16:
        return null;
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void j() {
        r0();
        OBaseIndicator.Pager r10 = getPager();
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        e0(r11, IndicatorAnimator.RenderReason.REFRESH_DOTS);
        return;
    L5:
        r11 = r10.getCurrentItem();
        goto L6
    }

    public final List j0(int r10, bg.c r11) {
        if (r10 <= 0) goto L24;
        if (r11.isEmpty() == true) goto L24;
        ArrayList r12 = new ArrayList(u.r(r11, 10));
        Iterator r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L11;
        r12.add(new d.b(((g0) r13).nextInt()));
        goto L8
    L11:
        if (r10 > p0(r11)) goto L13;
        return r12;
    L13:
        List r14 = s.d(r12.size() + 2);
        if (r11.a() <= 0) goto L16;
        d r15 = new d.b(r11.a() - 1);
    L17:
        r14.add(r15);
        r14.addAll(r12);
        if (r11.b() >= (r10 - 1)) goto L20;
        d r16 = new d.b(r11.b() + 1);
    L21:
        r14.add(r16);
        return s.a(r14);
    L20:
        r16 = d.c.f15050a;
        goto L21
    L16:
        r15 = d.a.f15048a;
    L24:
        return t.i();
    }

    public final IndicatorImageDotView k0(d r10) {
        if ((r10 instanceof d.b) == false) goto L8;
        if (((d.b) r10).a() == 0) goto L15;
        return null;
    L15:
        return this.D;
    L8:
        if (q.b(r10, d.a.f15048a) == false) goto L10;
        boolean r11 = true;
    L11:
        if (r11 == false) goto L14;
        return null;
    L14:
        throw new NoWhenBranchMatchedException();
    L10:
        r11 = q.b(r10, d.c.f15050a);
        goto L11
    }

    public final IndicatorDotVisualState l0(c r10, com.obric.oui.indicator.d r11) {
        d r12 = r10.a();
        if ((r12 instanceof d.b) == false) goto L6;
        return r11.a(((d.b) r12).a());
    L6:
        if (q.b(r12, d.a.f15048a) == false) goto L8;
        boolean r13 = true;
    L9:
        if (r13 == false) goto L13;
        return IndicatorDotVisualState.HIDDEN;
    L13:
        throw new NoWhenBranchMatchedException();
    L8:
        r13 = q.b(r12, d.c.f15050a);
        goto L9
    }

    public final com.obric.oui.indicator.d m0(int r10, int r11) {
        return com.obric.oui.indicator.e.a(r10, r11, this.F);
    }

    public final float n0() {
        return getDotsWidth() + (getDotsSpacing() * 2.0f);
    }

    public final boolean o0(bg.c r10) {
        List r11 = j0(k(), r10);
        if (this.f15040y.size() == r11.size()) goto L5;
        return true;
    L5:
        Iterator r12 = r11.iterator();
        int r13 = 0;
    L7:
        if (r12.hasNext() == false) goto L26;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L11;
        t.q();
    L11:
        d r16 = (d) r14;
        c r17 = (c) b0.a0(this.f15040y, r13);
        if (r17 == null) goto L13;
        IndicatorImageDotView r18 = k0(r16);
        if (q.b(r17.a(), r16) == false) goto L16;
        if (r18 != null) goto L19;
    L21:
        if (r18 != null) goto L25;
        if ((r17.c() instanceof IndicatorDotView) == true) goto L25;
        return true;
    L25:
        r13 = r15;
        goto L7
    L19:
        if (r17.c() == r18) goto L21;
        return true;
    L16:
        return true;
    L13:
        return true;
    L26:
        return false;
    }

    public final int p0(bg.c r10) {
        if (r10.isEmpty() == false) goto L6;
        return 0;
    L6:
        return (r10.b() - r10.a()) + 1;
    }

    public final void q0(View r10, boolean r11) {
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        LinearLayout.LayoutParams r13 = null;
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r12;
    L6:
        if (r14 == null) goto L9;
        r13 = new LinearLayout.LayoutParams(r14);
    L9:
        if (r13 != null) goto L11;
        r13 = new LinearLayout.LayoutParams((int) getDotsWidth(), (int) getDotsHeight());
    L11:
        r13.width = (int) getDotsWidth();
        r13.height = (int) getDotsHeight();
        if (r11 == true) goto L14;
        r13.setMargins(0, 0, 0, 0);
    L14:
        r10.setLayoutParams(r13);
        return;
    L5:
        r14 = null;
        goto L6
    }

    public final void r0() {
        Integer r10 = i0();
        IndicatorGroupLayout r11 = this.f15037v;
        IndicatorGroupLayout r12 = null;
        if (r11 != null) goto L6;
        q.y("groupLayout");
        r11 = null;
    L6:
        if (q.b(r11.getFixedContentWidthPx(), r10) == false) goto L8;
        return;
    L8:
        IndicatorGroupLayout r13 = this.f15037v;
        if (r13 != null) goto L11;
        q.y("groupLayout");
    L12:
        r12.setFixedContentWidthPx(r10);
        if (K == false) goto L16;
        L.a("OCarouselIndicator", "PIC stable content width updated, width=" + r10 + " pagerCount=" + k() + " maxVisibleDots=" + this.F);
        return;
    L16:
        return;
    L11:
        r12 = r13;
        goto L12
    }

    public final void s0() {
        if (this.f15040y.isEmpty() == false) goto L5;
        return;
    L5:
        bg.c r10 = t.j(this.f15040y);
        int r11 = (int) getDotsSpacing();
        Iterator r12 = this.f15040y.iterator();
        int r13 = 0;
    L7:
        if (r12.hasNext() == false) goto L16;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L11;
        t.q();
    L11:
        c r16 = (c) r14;
        com.obric.oui.indicator.a r17 = h.a(r13, r11, r10);
        if (r17.b() != r17.a()) goto L14;
        r16.b().setHorizontalMargin(r17.b());
    L15:
        r13 = r15;
        goto L7
    L14:
        r16.b().setStartMargin(r17.b());
        r16.b().setEndMargin(r17.a());
        goto L15
    }

    public final void setMaxVisibleDots(int r10) {
        if (this.F == r10) goto L6;
        this.F = r10;
        n();
        return;
    }

    public final void setSelectedDotColor(int r10) {
        if (getType() != 1) goto L5;
        this.H = -218103809;
        p();
        return;
    L5:
        if (this.H == r10) goto L9;
        this.H = r10;
        p();
        return;
    }

    public final void setSizeStyle(int r10) {
        if (this.G == r10) goto L6;
        this.G = r10;
        N();
        n();
        return;
    }

    public final void setStartDotDrawable(@DrawableRes int r10) {
        if (r10 == 0) goto L5;
        Drawable r11 = ContextCompat.d(getContext(), r10);
        if (r11 == null) goto L11;
        setStartDotDrawable(r11);
        return;
    L11:
        if (K == false) goto L17;
        L.e("OCarouselIndicator", q.p("setStartDotDrawable(iconResId) ignored, drawable not found for resId=", Integer.valueOf(r10)));
        return;
    L17:
        return;
    L5:
        if (K == false) goto L16;
        L.e("OCarouselIndicator", "setStartDotDrawable(iconResId) ignored, iconResId=0");
        return;
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void t() {
        if (getInitialized() == true) goto L6;
        setPendingRefreshParentLayout(true);
        return;
    L6:
        setPendingRefreshParentLayout(false);
        IndicatorGroupLayout r10 = null;
        if (getType() != 1) goto L18;
        IndicatorGroupLayout r11 = this.f15037v;
        if (r11 != null) goto L11;
        q.y("groupLayout");
        r11 = null;
    L11:
        r11.setBgColor(ContextCompat.b(getContext(), R$color.carousel_indicator_bg_color));
        IndicatorGroupLayout r12 = this.f15037v;
        if (r12 != null) goto L14;
        q.y("groupLayout");
        r12 = null;
    L14:
        r12.setCornerRadius(tc.f.r(this, 100));
        IndicatorGroupLayout r13 = this.f15037v;
        if (r13 != null) goto L17;
        q.y("groupLayout");
        r13 = null;
    L17:
        r13.setDrawBackground(true);
    L26:
        if (getType() == 1) goto L28;
    L30:
        IndicatorGroupLayout r14 = this.f15037v;
        if (r14 != null) goto L33;
        q.y("groupLayout");
        r14 = null;
    L33:
        r14.setPadding(getSidePadding(), getVerticalSidePadding(), getSidePadding(), getVerticalSidePadding());
    L34:
        r0();
        IndicatorGroupLayout r15 = this.f15037v;
        if (r15 != null) goto L37;
        q.y("groupLayout");
        r15 = null;
    L37:
        IndicatorGroupLayout r16 = this.f15037v;
        if (r16 != null) goto L40;
        q.y("groupLayout");
    L41:
        ViewGroup.LayoutParams r17 = r10.getLayoutParams();
        r17.height = getLayoutHeight();
        r15.setLayoutParams(r17);
        requestLayout();
        return;
    L40:
        r10 = r16;
        goto L41
    L28:
        if (this.G != 1) goto L30;
        O();
        goto L34
    L18:
        IndicatorGroupLayout r18 = this.f15037v;
        if (r18 != null) goto L21;
        q.y("groupLayout");
        r18 = null;
    L21:
        r18.setBgColor(ContextCompat.b(getContext(), R$color.Transparent));
        IndicatorGroupLayout r19 = this.f15037v;
        if (r19 != null) goto L24;
        q.y("groupLayout");
        r19 = null;
    L24:
        r19.setDrawBackground(false);
        goto L26
    }

    @JvmOverloads
    public OCarouselIndicator(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OCarouselIndicator(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OCarouselIndicator(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f15040y = new ArrayList();
        this.f15041z = new ArrayDeque();
        this.E = new DecelerateInterpolator();
        this.F = Channel.UNLIMITED;
        this.H = ContextCompat.b(r10, R$color.oui_text_1);
        this.I = new ArgbEvaluator();
        X(r11);
        u();
    }

    public final void setStartDotDrawable(@NotNull Drawable r10) {
        q.g(r10, "drawable");
        Drawable.ConstantState r11 = r10.getConstantState();
        if (r11 != null) goto L6;
        L.j("OCarouselIndicator", "setStartDotDrawable(drawable) ignored, drawable.constantState is null");
        return;
    L6:
        Drawable r12 = r11.newDrawable(getResources()).mutate();
        q.f(r12, "constantState.newDrawable(resources).mutate()");
        Context r13 = getContext();
        q.f(r13, "context");
        this.D = new IndicatorImageDotView(r13, r12);
        if (K == false) goto L20;
        List r14 = this.f15040y;
        boolean r15 = false;
        if (r14 != null) goto L11;
    L13:
        Iterator r16 = r14.iterator();
    L15:
        if (r16.hasNext() == false) goto L19;
        if (q.b(((c) r16.next()).a(), new d.b(0)) == false) goto L15;
        r15 = true;
    L19:
        L.a("OCarouselIndicator", q.p("Registered start drawable dot, visible=", Boolean.valueOf(r15)));
        goto L20
    L11:
        if (r14.isEmpty() == false) goto L13;
    L20:
        n();
    }
}

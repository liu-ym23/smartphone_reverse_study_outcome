package com.bytedance.android.livesdk.livecommerce.iron.ui.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.livesdk.livecommerce.iron.category.CategoryLineaLayoutManager;
import com.bytedance.android.livesdk.livecommerce.iron.category.CategoryRecyclerView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sg2.v;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\n\u000bB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/tab/CategoryExpandView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "State", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryExpandView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f149046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f149047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f149048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f149049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f149050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public State f149051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f149052g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Pair<Integer, Integer> f149053h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/tab/CategoryExpandView$State;", "", "STATE_COLLAPSED", "STATE_EXPANDED", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State STATE_COLLAPSED = null;
        public static final State STATE_EXPANDED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f149054a = null;

        static {
            State r100 = new State("STATE_COLLAPSED", 0);
            STATE_COLLAPSED = r100;
            State r101 = new State("STATE_EXPANDED", 1);
            STATE_EXPANDED = r101;
            f149054a = new State[]{r100, r101};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f149054a.clone();
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public CategoryExpandView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CategoryExpandView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final boolean T5() {
        if (this.f149051f != State.STATE_EXPANDED) goto L5;
        return true;
    L5:
        return false;
    }

    public CategoryExpandView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f149051f = State.STATE_COLLAPSED;
        LayoutInflater.from(r100).inflate(R.layout.shopping_layout_live_promotion_list_tab_expand, this, true);
        setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        this.f149046a = findViewById(R.id.expand_bg_view);
        this.f149047b = findViewById(R.id.expand_arrow);
        this.f149049d = (ConstraintLayout) findViewById(R.id.expand_area_container);
        this.f149048c = (TextView) findViewById(R.id.category_info);
        this.f149050e = (FrameLayout) findViewById(R.id.tab_container);
    }

    public final void S5(CategoryRecyclerView r100, FrameLayout r101, RelativeLayout r102) {
        Intrinsics.checkNotNullParameter(r100, "categoryRecyclerView");
        Intrinsics.checkNotNullParameter(r101, "categoryRecyclerViewContainer");
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.indexOfChild(this) == (-1)) goto L8;
        r102.removeView(this);
    L8:
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-2, -2);
        r103.gravity = 53;
        Unit r104 = Unit.INSTANCE;
        r101.addView(this, r103);
        this.f149049d.setBackgroundColor(0);
        setBackgroundColor(0);
        this.f149047b.setBackgroundResource(R.drawable.ec_list_tab_expand_arrow_down);
        View r105 = this.f149047b;
        int r106 = UtilityKotlinExtentionsKt.d(16);
        Intrinsics.checkNotNullParameter(r105, "$this$layoutMarginTop");
        ViewGroup.LayoutParams r107 = r105.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ((ViewGroup.MarginLayoutParams) r107).topMargin = r106;
        r105.setLayoutParams(r107);
    L11:
        this.f149048c.setVisibility(8);
        if (this.f149050e.indexOfChild(r100) == (-1)) goto L14;
        this.f149050e.removeView(r100);
    L14:
        Integer r108 = this.f149052g;
        if (r108 == null) goto L17;
        int r109 = r108.intValue();
    L18:
        r101.addView(r100, r109, new FrameLayout.LayoutParams(-1, UtilityKotlinExtentionsKt.d(42)));
        this.f149052g = null;
        this.f149050e.setVisibility(8);
        CategoryLineaLayoutManager r110 = new CategoryLineaLayoutManager(getContext());
        r110.setOrientation(0);
        r100.setLayoutManager(r110);
        bi2.a r111 = bi2.a.f19090a;
        int r112 = UtilityKotlinExtentionsKt.d(8);
        int r113 = UtilityKotlinExtentionsKt.d(0);
        r111.getClass();
        RecyclerView.ItemDecoration r114 = bi2.a.b(3, false, true, r112, r113);
        Intrinsics.checkNotNullParameter(r114, "decoration");
        r100.t();
        r100.addItemDecoration(r114);
        Pair<Integer, Integer> r115 = this.f149053h;
        if (r115 == null) goto L35;
        int r116 = r115.component1().intValue();
        int r117 = r115.component2().intValue();
        Intrinsics.checkNotNullParameter(r100, "$this$scrollToPositionWithOffset");
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L30
        RecyclerView.LayoutManager r119 = r100.getLayoutManager();     // Catch: Throwable -> L30
        if ((r119 instanceof LinearLayoutManager) == true) goto L24;
        r119 = null;
    L24:
        LinearLayoutManager r120 = (LinearLayoutManager) r119;     // Catch: Throwable -> L30
        if (r120 == null) goto L27;
        r120.scrollToPositionWithOffset(r116, r117);     // Catch: Throwable -> L30
        Unit r121 = Unit.INSTANCE;     // Catch: Throwable -> L30
    L28:
        Object r122 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L30
    L32:
        Throwable r123 = Result.m9452exceptionOrNullimpl(r122);
        if (r123 == null) goto L35;
        ECExceptionMonitor.e(r123);
        goto L35
    L27:
        r121 = null;
    L30:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L35:
        setOnClickListener(null);
        this.f149051f = State.STATE_COLLAPSED;
        return;
    L17:
        r109 = -1;
        goto L18
    }

    public /* synthetic */ CategoryExpandView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void R5(final CategoryRecyclerView r100, final FrameLayout r110, final RelativeLayout r111, final gi2.a r112) {
        Intrinsics.checkNotNullParameter(r100, "categoryRecyclerView");
        Intrinsics.checkNotNullParameter(r110, "categoryRecyclerViewContainer");
        Intrinsics.checkNotNullParameter(r112, "promotionListParams");
        if (r111 != null) goto L5;
        return;
    L5:
        f.c(this.f149046a, null, null, new CategoryExpandView$bind$1(this, r112, r100, r110, r111), 3);
        new v("livesdk_list_tab_more_show", r112).i("c19983.d324484");
    }
}

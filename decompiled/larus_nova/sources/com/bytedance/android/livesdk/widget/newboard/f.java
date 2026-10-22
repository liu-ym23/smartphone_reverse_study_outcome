package com.bytedance.android.livesdk.widget.newboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.view.MaxWidthLinearLayout;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.bytedance.android.livesdk.interactivity.api.expression.i;
import com.bytedance.android.livesdk.interactivity.api.expression.j;
import com.bytedance.android.livesdk.model.ExpressionSection;
import com.bytedance.android.livesdk.model.h;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.widget.board.ExpressionContext;
import com.bytedance.android.livesdk.widget.board.ExpressionSectionListAdapter;
import com.bytedance.android.livesdk.widget.board.ExpressionSectionPagerAdapter;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f extends FrameLayout implements com.bytedance.android.livesdk.interactivity.api.expression.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f161891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GridLayoutManager f161892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExpressionSectionPagerAdapter f161893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExpressionSectionListAdapter f161894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f161895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ExpressionContext f161896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f161897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f161898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f161899i;

    public static final class a {
    }

    static {
    }

    public View getView() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        com.bytedance.android.livesdk.sharedpref.e<Integer> r100 = l42.a.f507335v;
        Integer r101 = Integer.valueOf(this.f161897g);
        r100.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r100, r101);
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = l42.a.f507334u;
        Boolean r103 = Boolean.FALSE;
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        this.f161893c.j();
        this.f161899i.dispose();
        Iterator<T> r104 = this.f161894d.f161432e.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((ExpressionSection) r104.next()).d();
        goto L4
    L6:
        super.onDetachedFromWindow();
    }

    private final boolean getSelfIsVisibility() {
        if (getVisibility() == 0) goto L5;
        return false;
    L5:
        if (getHeight() > 0) goto L7;
        return false;
    L7:
        if (getWidth() > 0) goto L9;
        return false;
    L9:
        if (getAlpha() <= 0) goto L15;
        return true;
    L15:
        return false;
    }

    public static final /* synthetic */ boolean b(f r100) {
        return r100.getSelfIsVisibility();
    }

    public final View a(int r100) {
        if (this.f161891a != null) goto L5;
        this.f161891a = new LinkedHashMap();
    L5:
        View r101 = this.f161891a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f161891a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setOnCommentSendDelegate(j r100) {
        Intrinsics.checkNotNullParameter(r100, "onCommentSendDelegate");
        this.f161896f.getOnCommentSendDelegate().setValue(r100);
        int r101 = Math.max(Math.min(this.f161897g, ((ArrayList) this.f161893c.f161449g).size() - 1), 0);
        j r102 = this.f161896f.getOnCommentSendDelegate().getValue();
        if (r102 == null) goto L6;
        r102.i(((h) ListProtector.get(this.f161893c.f161449g, r101)).getPageName());
        return;
    }

    public f(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        this.f161891a = new LinkedHashMap();
        this.f161892b = new GridLayoutManager(r100, 2);
        ExpressionContext r102 = new ExpressionContext();
        this.f161896f = r102;
        this.f161898h = -1;
        this.f161899i = new CompositeDisposable();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_simple_expression_board_v3, this, true);
        setBackgroundColor(getResources().getColor(R.color.ttlive_white));
        SSViewPager r103 = (SSViewPager) findViewById(R.id.emoji_pager);
        if (r101 == true) goto L7;
        MaxWidthLinearLayout r104 = (MaxWidthLinearLayout) a(R.id.max_linear_layout);
        if (r104 == null) goto L7;
        r104.setMaxWidth(UtilityKotlinExtentionsKt.i(480));
    L7:
        this.f161895e = (RecyclerView) findViewById(R.id.emoji_section_list);
        this.f161893c = new ExpressionSectionPagerAdapter(r100, r103, r102);
        i r105 = new i();
        r105.f133221g = false;
        r105.f133223i = false;
        r105.f133222h = false;
        Unit r106 = Unit.INSTANCE;
        ArrayList r107 = CollectionsKt.arrayListOf(new h[]{new tv2.a(r101, r105)});
        ArrayList r108 = new ArrayList();
        Iterator r109 = r107.iterator();
    L9:
        if (r109.hasNext() == false) goto L11;
        r108.add(((h) r109.next()).b());
        goto L9
    L11:
        ExpressionSectionListAdapter r110 = new ExpressionSectionListAdapter(this.f161895e, r108, true);
        this.f161894d = r110;
        if (r107.isEmpty() == true) goto L46;
        this.f161895e.setLayoutManager(this.f161892b);
        this.f161895e.setAdapter(r110);
        ExpressionSectionPagerAdapter r111 = this.f161893c;
        Function3<Integer, Integer, h, Unit> r112 = new SimpleExpressionBoardV3$bindSections$1(this);
        r111.getClass();
        Intrinsics.checkNotNullParameter(r112, "onSectionChangedListener");
        r111.f161443a.add(r112);
        this.f161893c.h(r107);
        r110.f161428a = new SimpleExpressionBoardV3$bindSections$2(this);
        if (this.f161897g >= r107.size()) goto L44;
        com.bytedance.android.live.profit.vip.e r113 = yt0.c.l();
        if (r113 == null) goto L42;
        m<Boolean> r114 = r113.isFirstTimeOpenEmoji();
        if (r114 == null) goto L42;
        if (r114.getValue().booleanValue() != true) goto L42;
        Integer r115 = l42.a.f507335v.getValue();
        if (r115 != null) goto L26;
    L27:
        com.bytedance.android.live.profit.vip.e r116 = yt0.c.l();
        if (r116 == null) goto L36;
        m<? extends com.bytedance.android.live.profit.vip.h> r117 = r116.getSubscribeInfo();
        if (r117 == null) goto L36;
        com.bytedance.android.live.profit.vip.h r118 = r117.getValue();
        if (r118 == null) goto L36;
        if (r118.f89134b != 1) goto L36;
        int r119 = this.f161898h;
    L37:
        this.f161897g = r119;
        com.bytedance.android.live.profit.vip.e r120 = yt0.c.l();
        if (r120 == null) goto L43;
        m<Boolean> r121 = r120.isFirstTimeOpenEmoji();
        if (r121 == null) goto L43;
        r121.setValue(Boolean.FALSE);
    L43:
        r110.f161430c.add(Integer.valueOf(this.f161897g));
        this.f161893c.f161452j.setCurrentItem(this.f161897g, false);
    L36:
        r119 = 0;
        goto L37
    L26:
        if (r115.intValue() != 1) goto L27;
    L42:
        this.f161897g = l42.a.f507335v.getValue().intValue();
        goto L43
    L44:
        r110.f161430c.add(0);
        this.f161893c.f161452j.setCurrentItem(0, false);
    L46:
        if (r107.size() > 1) goto L48;
        UtilityKotlinExtentionsKt.t(this.f161895e);
        UIUtils.updateLayoutMargin(a(R.id.emoji_delete_container), -3, -3, -3, UtilityKotlinExtentionsKt.i(2));
        this.f161896f.getSectionShow().setValue(Boolean.FALSE);
    L49:
        ImageView r122 = (ImageView) a(R.id.emoji_delete_btn);
        if (r122 == null) goto L52;
        r122.setOnClickListener(new d(this));
    L52:
        TextView r123 = (TextView) a(R.id.emoji_send_btn);
        if (r123 == null) goto L55;
        r123.setOnClickListener(new e(this));
    L55:
        r3.a(a(R.id.emoji_delete_btn), s1.B(R.string.ttlive_a11y_delete));
        r3.a(a(R.id.emoji_send_btn), s1.B(R.string.ttlive_a11y_send));
        return;
    L48:
        this.f161896f.getSectionShow().setValue(Boolean.TRUE);
        goto L49
    }
}

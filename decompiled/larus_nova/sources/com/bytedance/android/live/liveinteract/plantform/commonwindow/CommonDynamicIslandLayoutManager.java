package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Log;
import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.k51;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import tf0.u;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/CommonDynamicIslandLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lug0/a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonDynamicIslandLayoutManager extends RecyclerView.LayoutManager implements Observer<KVData>, ug0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f75553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f75554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f75555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f75556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Integer, List<tf0.a>> f75557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Boolean f75558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f75559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f75560h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Float> f75561i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f75562j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final double f75563k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function0<Unit> f75564l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DataCenter f75565m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f75566n;

    @Override // ug0.a
    public final void U3(m r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "layoutConfig");
    }

    @Override // ug0.a
    public final void e(int r100) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // ug0.a
    public final boolean isDynamicAnimating() {
        return this.f75556d;
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> a(int r100) {
        return new Pair(Integer.valueOf(s1.f(80.0f)), Integer.valueOf(s1.f(80.0f)));
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> c(int r100) {
        return new Pair(0, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAttachedToWindow(RecyclerView r100) {
        super.onAttachedToWindow(r100);
        this.f75555c = r100;
        ALogger.i(this.f75553a, "observe DATA_DYNAMIC_ISLAND_LAYOUT_ANIMTE animRecyclerView=" + this.f75566n + ", this=" + this + ", dataCenter=" + this.f75565m + ", stack=" + Log.getStackTraceString(new Throwable()));
        DataCenter r101 = this.f75565m;
        if (r101 == null) goto L6;
        r101.observeForever("data_dynamic_island_layout_animte", this);
    L6:
        if (this.f75566n == true) goto L11;
        DataCenter r102 = this.f75565m;
        if (r102 == null) goto L12;
        r102.observeForever("data_dynamic_island_layout_seat_update", this);
        return;
    L12:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [T, com.bytedance.android.live.liveinteract.plantform.commonwindow.CommonDynamicIslandLayoutManager$onChanged$1] */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        final KVData r101 = (KVData) r100;
        Object r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getKey();
    L6:
        if (r103 == null) goto L59;
        int r104 = r103.hashCode();
        if (r104 == (-591676989)) goto L25;
        if (r104 == (-53645630)) goto L14;
        return;
    L14:
        if (r103.equals("data_dynamic_island_layout_animte") == false) goto L45;
        com.bytedance.android.live.liveinteract.animation.universalwidget.a.f71316f0.getClass();
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r105 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C1150a.a();
        if (r105 != null) goto L18;
    L23:
        u((u) r101.getData());
        return;
    L18:
        if (com.bytedance.android.live.liveinteract.animation.universalwidget.a.b.a(r105) != true) goto L23;
        final Ref.ObjectRef r106 = new Ref.ObjectRef();
        r106.element = null;
        r106.element = new AnonymousClass1(this, r101, r106);
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r107 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C1150a.a();
        if (r107 == null) goto L22;
        r107.zn((Function0) r106.element);
    L22:
        ALogger.i(this.f75553a, "3d兼容-灵活布局动画到来，但3d动画播放中，等待3d动画播完... layoutManager=" + this);
        return;
    L45:
        return;
    L25:
        if (r103.equals("data_dynamic_island_layout_seat_update") == false) goto L57;
        Object r108 = r101.getData();
        if ((r108 instanceof Integer) == false) goto L30;
        r102 = r108;
    L30:
        Integer r109 = (Integer) r102;
        if (r109 == null) goto L58;
        int r110 = r109.intValue();
        Iterator r111 = ((LinkedHashMap) this.f75557e).entrySet().iterator();
    L34:
        if (r111.hasNext() == false) goto L61;
        Map.Entry r112 = (Map.Entry) r111.next();
        Integer r113 = (Integer) r112.getKey();
        if (r113 == null) goto L34;
        if (r110 != r113.intValue()) goto L34;
        List<tf0.a> r114 = (List) r112.getValue();
        Animator r115 = t(Integer.valueOf(r110), r114, true, false);
        ALogger.i(this.f75553a, "获取绑定一个麦位的动画组 pos=" + r110 + ", animGroupList=" + r114);
        if (r115 == null) goto L43;
        r115.setDuration(0);
    L43:
        if (r115 == null) goto L34;
        r115.start();
        goto L34
    L61:
        return;
    L58:
        return;
    L57:
        return;
    L59:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final AnimatorSet s(final u r110) {
        Intrinsics.checkNotNullParameter(r110, "seatAnimateInfo");
        AnimatorSet r100 = new AnimatorSet();
        AnimatorSet.Builder r101 = r100.play(ValueAnimator.ofInt(new int[]{1}).setDuration(1));
        Map<String, List<tf0.a>> r102 = r110.a();
        if (r102 == null) goto L12;
        Iterator<Map.Entry<String, List<tf0.a>>> r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L12;
        Map.Entry<String, List<tf0.a>> r104 = r103.next();
        String r105 = r104.getKey();
        if (r105 == null) goto L10;
        Integer r106 = Integer.valueOf(CastIntegerProtector.parseInt(r105));
    L11:
        List<tf0.a> r107 = r104.getValue();
        Animator r108 = t(r106, r107, false, true);
        ALogger.i(this.f75553a, "获取一个麦位的动画组 " + r107);
        w(r101, r108);
        goto L6
    L10:
        r106 = null;
    L12:
        com.bytedance.android.live.ktv.common.midi.v2.a.a(r100, new CommonDynamicIslandLayoutManager$doAnimate$2(this, r110));
        ALogger.i(this.f75553a, "执行灵活布局动画 " + r100);
        r100.start();
        this.f75556d = true;
        return r100;
    }

    @Override // ug0.a
    public final void setDynamicAnimatorListener(Function0<Unit> r100) {
        this.f75564l = r100;
    }

    public final AnimatorSet u(u r100) {
        if (r100 != null) goto L26;
        return null;
    L26:
        ALogger.i(this.f75553a, "processAnimateInfo, lynxRelative=" + this.f75559g + " nativeRelative=" + this.f75558f + " seatAnimateInfo=" + r100);     // Catch: Exception -> L23
        String r101 = this.f75553a;     // Catch: Exception -> L23
        StringBuilder r102 = new StringBuilder("processAnimateInfo, stack_track=");     // Catch: Exception -> L23
        r102.append(Log.getStackTraceString(new Throwable()));     // Catch: Exception -> L23
        ALogger.i(r101, r102.toString());     // Catch: Exception -> L23
        if (this.f75559g != null) goto L13;
        Boolean r103 = r100.c();     // Catch: Exception -> L23
        if (r103 == null) goto L10;
        boolean r104 = r103.booleanValue();     // Catch: Exception -> L23
    L11:
        this.f75559g = Boolean.valueOf(r104);     // Catch: Exception -> L23
        goto L13
    L10:
        r104 = false;
    L13:
        if (Intrinsics.areEqual(r100.getType(), "add") == false) goto L15;
        x(r100);     // Catch: Exception -> L23
        AnimatorSet r105 = s(r100);     // Catch: Exception -> L23
    L17:
        if (getChildCount() != 0) goto L19;
    L22:
        return r105;
    L19:
        if (this.f75566n == false) goto L21;
        r100.f545700b = true;     // Catch: Exception -> L23
        goto L22
    L21:
        r100.f545699a = true;     // Catch: Exception -> L23
        goto L22
    L15:
        x(r100);     // Catch: Exception -> L23
        r105 = s(r100);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        ALogger.e(this.f75553a, "processAnimateInfo error!", e);
        return null;
    }

    public final void x(u r100) {
        if (r100 == null) goto L13;
        Map<String, List<tf0.a>> r101 = r100.a();
        if (r101 == null) goto L17;
        Iterator<Map.Entry<String, List<tf0.a>>> r102 = r101.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L18;
        Map.Entry<String, List<tf0.a>> r103 = r102.next();
        String r104 = r103.getKey();
        if (r104 == null) goto L11;
        Integer r105 = Integer.valueOf(CastIntegerProtector.parseInt(r104));
    L12:
        List<tf0.a> r106 = r103.getValue();
        this.f75557e.put(r105, r106);
        goto L7
    L11:
        r105 = null;
        goto L12
    L18:
        return;
    L17:
        return;
    }

    public CommonDynamicIslandLayoutManager(DataCenter r100, boolean r101) {
        this.f75565m = r100;
        this.f75566n = r101;
        this.f75553a = "CommonDynamicIslandLayoutManager";
        this.f75554b = new CompositeDisposable();
        this.f75557e = new LinkedHashMap();
        this.f75560h = true;
        ReadOnlyProperty r102 = vm2.d.R7;
        KProperty<?>[] r103 = vm2.d.f555776a;
        List<Float> r104 = ((k51) r102.getValue(null, r103[456(0x1c8, float:6.39E-43)])).c();
        if (r104 != null) goto L5;
        r104 = CollectionsKt.listOf(new Float[]{Float.valueOf(0.0f), Float.valueOf(0.35f), Float.valueOf(0.39f), Float.valueOf(0.42f)});
    L5:
        this.f75561i = r104;
        this.f75562j = ((k51) r102.getValue(null, r103[456(0x1c8, float:6.39E-43)])).a();
        this.f75563k = ((k51) r102.getValue(null, r103[456(0x1c8, float:6.39E-43)])).b();
    }

    public static void w(AnimatorSet.Builder r100, Animator r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$safeWith");
        if (r101 == null) goto L6;
        r100.with(r101);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAdapterChanged(RecyclerView.Adapter<?> r100, RecyclerView.Adapter<?> r101) {
        super.onAdapterChanged(r100, r101);
        ALogger.w(this.f75553a, "attach-dettach test, onAdapterChanged newAdapter " + r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onDetachedFromWindow(RecyclerView r100, RecyclerView.Recycler r101) {
        super.onDetachedFromWindow(r100, r101);
        ALogger.i(this.f75553a, "remove DATA_DYNAMIC_ISLAND_LAYOUT_ANIMTE animRecyclerView=" + this.f75566n + ", this=" + this + ", dataCenter=" + this.f75565m + ", stack=" + Log.getStackTraceString(new Throwable()));
        DataCenter r102 = this.f75565m;
        if (r102 == null) goto L5;
        r102.removeObserver(this);
    L5:
        this.f75554b.clear();
        if (this.f75566n == true) goto L11;
        DataCenter r103 = this.f75565m;
        if (r103 == null) goto L12;
        r103.put("data_dynamic_island_layout_animte", null);
        return;
    L12:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r210, RecyclerView.State r211) {
        Intrinsics.checkNotNullParameter(r210, "recycler");
        Intrinsics.checkNotNullParameter(r211, "state");
        if (r211.getItemCount() >= 8) goto L6;
        removeAndRecycleAllViews(r210);
        return;
    L6:
        detachAndScrapAttachedViews(r210);
        int r100 = r211.getItemCount();
        int r110 = 0;
    L7:
        if (r110 >= r100) goto L16;
        System.currentTimeMillis();
        View r111 = r210.getViewForPosition(r110);
        if (r111 == null) goto L10;
        Pair<Integer, Integer> r101 = a(r110);
        int r102 = r101.component1().intValue();
        int r103 = r101.component2().intValue();
        r111.getLayoutParams().width = r102;
        r111.getLayoutParams().height = r103;
        addView(r111);
        measureChildWithMargins(r111, 0, 0);
        layoutDecoratedWithMargins(r111, 0 - getDecoratedMeasuredWidth(r111), 0 - getDecoratedMeasuredHeight(r111), 0, 0);
        View r104 = r111.findViewById(R.id.ttlive_position_name);
        if (r104 == null) goto L14;
        r104.setAlpha(0.0f);
    L14:
        r110 = r110 + 1;
        goto L7
    L10:
        return;
    L16:
        if (this.f75560h == false) goto L63;
        DataCenter r105 = this.f75565m;
        PointF r106 = null;
        if (r105 == null) goto L20;
        u r107 = (u) r105.get("data_dynamic_island_layout_animte", null);
    L22:
        if (r107 == null) goto L40;
        boolean r108 = this.f75566n;
        if (r108 == false) goto L26;
        boolean r109 = r107.f545700b;
    L27:
        if (r109 == true) goto L40;
        if (r108 == false) goto L30;
        boolean r112 = r107.f545700b;
    L31:
        if (r112 == true) goto L54;
        String r113 = this.f75553a;
        if (r108 == false) goto L35;
        String r114 = "动画rv";
    L36:
        ALogger.i(r113, "3d兼容-第一次布局Lynx... ".concat(r114));
        AnimatorSet r115 = u(r107);
        this.f75556d = true;
        if (r115 == null) goto L54;
        com.bytedance.android.live.ktv.common.midi.v2.a.a(r115, new CommonDynamicIslandLayoutManager$onLayoutChildrenLynx$$inlined$let$lambda$1(this));
        goto L54
    L35:
        r114 = "布局rv";
    L54:
        this.f75560h = false;
        return;
    L30:
        r112 = r107.f545699a;
        goto L31
    L26:
        r109 = r107.f545699a;
    L40:
        ALogger.i(this.f75553a, "3d兼容-第一次布局Natvie更新...");
        AnimatorSet r116 = new AnimatorSet();
        AnimatorSet.Builder r117 = r116.play(ValueAnimator.ofInt(new int[]{1}).setDuration(0));
        int r118 = getItemCount();
        int r119 = 0;
    L41:
        if (r119 >= r118) goto L53;
        ArrayList r120 = new ArrayList();
        RecyclerView r121 = this.f75555c;
        if (r121 == null) goto L47;
        double r122 = ((((double) r119) * ((1.0d / ((double) 9)) * ((double) 360))) - ((double) 90)) * 0.017453292519943295d;
        double r123 = ((Number) ListProtector.get(this.f75561i, 2)).floatValue() * r121.getHeight();
        r106 = new PointF((float) (((double) (r121.getX() + (r121.getWidth() / 2))) + (Math.cos(r122) * r123)), (float) ((((double) (r121.getHeight() / 2)) + (Math.sin(r122) * r123)) + ((double) 15)));
        r106.x = s1.G((int) r106.x);
        r106.y = s1.G((int) r106.y);
    L47:
        if (r106 != null) goto L49;
        tf0.a r124 = null;
    L50:
        if (r124 == null) goto L52;
        r120.add(r124);
    L52:
        int r125 = this.f75562j;
        AnimatorSet r126 = r116;
        double r127 = 2;
        double r128 = 1;
        r120.add(new tf0.a("gift_icon", CollectionsKt.mutableListOf(new tf0.t[]{new tf0.t("scale", Double.valueOf(this.f75563k * r128)), new tf0.t("translate", MapsKt.mapOf(new Pair[]{TuplesKt.to("x", Double.valueOf(((double) r125) / r127)), TuplesKt.to("y", Double.valueOf(r125 - 9))}))})));
        int r129 = this.f75562j;
        r120.add(new tf0.a(InstantPlayContext.NICKNAME, CollectionsKt.mutableListOf(new tf0.t[]{new tf0.t("scale", Double.valueOf(r128 * this.f75563k)), new tf0.t("translate", MapsKt.mapOf(new Pair[]{TuplesKt.to("x", Double.valueOf(((double) r129) / r127)), TuplesKt.to("y", Double.valueOf(r129 + 8))}))})));
        this.f75558f = Boolean.TRUE;
        AnimatorSet.Builder r130 = r117;
        w(r130, t(Integer.valueOf(r119), r120, false, true));
        r119 = r119 + 1;
        r117 = r130;
        r118 = r118;
        r116 = r126;
        r106 = null;
        goto L41
    L49:
        r124 = new tf0.a("seat", CollectionsKt.mutableListOf(new tf0.t[]{new tf0.t("scale", Double.valueOf(((double) 1) * this.f75563k)), new tf0.t("translate", MapsKt.mapOf(new Pair[]{TuplesKt.to("x", Double.valueOf(r106.x)), TuplesKt.to("y", Double.valueOf(r106.y))}))}));
        goto L50
    L53:
        AnimatorSet r131 = r116;
        this.f75556d = true;
        com.bytedance.android.live.ktv.common.midi.v2.a.a(r131, new CommonDynamicIslandLayoutManager$onLayoutChildrenNative$4(this));
        r131.start();
        goto L54
    L20:
        r107 = null;
        goto L22
    }

    public final Float q(Float r100, View r101) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L12;
        int r102 = r101.getWidth();
        r101.getHeight();
        RecyclerView r103 = this.f75555c;
        if (r103 == null) goto L9;
        r103.getY();
    L9:
        return Float.valueOf(r100.floatValue() - (r102 / 2));
    L12:
        return null;
    L10:
        return null;
    }

    public static boolean p(CommonDynamicIslandLayoutManager r100, Float r101, Float r102) {
        r100.getClass();
        if (Intrinsics.areEqual(r101, r102) == false) goto L6;
    L7:
        return true;
    L6:
        if (Math.abs(r101.floatValue() - r102.floatValue()) < 0.001f) goto L7;
        return false;
    }

    public static Float r(CommonDynamicIslandLayoutManager r100, Float r101, View r102) {
        Boolean r103 = r100.f75559g;
        if (r103 == null) goto L5;
        Intrinsics.checkNotNull(r103);
        boolean r104 = r103.booleanValue();
    L9:
        boolean r105 = !r104;
        r100.getClass();
        if (r101 == null) goto L20;
        if (r102 == null) goto L20;
        r102.getWidth();
        int r106 = r102.getHeight();
        RecyclerView r107 = r100.f75555c;
        if (r107 == null) goto L16;
        Number r108 = Float.valueOf(r107.getY());
    L17:
        if (r105 == false) goto L23;
        return Float.valueOf((r101.floatValue() - (r106 / 2)) - r108.intValue());
    L23:
        return Float.valueOf(r101.floatValue() - (r106 / 2));
    L16:
        r108 = 0;
    L20:
        return null;
    L5:
        Boolean r109 = r100.f75558f;
        if (r109 == null) goto L8;
        Intrinsics.checkNotNull(r109);
        r104 = r109.booleanValue();
        goto L9
    L8:
        r104 = false;
        goto L9
    }

    public final Animator t(Integer r100, List<tf0.a> r101, boolean r110, boolean r111) {
        AnimatorSet r102 = null;
        if (r100 == null) goto L5;
        View r103 = getChildAt(r100.intValue());
    L6:
        if (r100 == null) goto L32;
        if (r101 == null) goto L32;
        if (r103 == null) goto L32;
        int r104 = r100.intValue();
        r102 = new AnimatorSet();
        AnimatorSet.Builder r105 = r102.play(ValueAnimator.ofInt(new int[]{1}).setDuration(1));
        Iterator<T> r106 = r101.iterator();
    L11:
        if (r106.hasNext() == false) goto L32;
        tf0.a r107 = (tf0.a) r106.next();
        String r108 = r107.b();
        if (r108 == null) goto L11;
        int r109 = r108.hashCode();
        if (r109 != 3526149) goto L18;
        if (r108.equals("seat") == false) goto L11;
        if (r110 == true) goto L11;
        w(r105, v(r103, r107, r111, Integer.valueOf(r104)));
        goto L11
    L18:
        if (r109 != 70690926) goto L20;
        if (r108.equals(InstantPlayContext.NICKNAME) == false) goto L11;
        w(r105, v(r103.findViewById(R.id.ttlive_guest_name_container), r107, r111, Integer.valueOf(r104)));
        w(r105, v(r103.findViewById(R.id.ttlive_empty_tips), r107, r111, Integer.valueOf(r104)));
        goto L11
    L20:
        if (r109 != 570280488) goto L11;
        if (r108.equals("gift_icon") == false) goto L11;
        w(r105, v(r103.findViewById(R.id.ttlive_guest_battle_score_view), r107, r111, Integer.valueOf(r104)));
        w(r105, v(r103.findViewById(R.id.ttlive_guest_fans_ticket_count), r107, r111, Integer.valueOf(r104)));
    L32:
        return r102;
    L5:
        r103 = null;
        goto L6
    }

    public final AnimatorSet v(final View r210, tf0.a r310, boolean r311, Integer r312) {
        if (r210 != null) goto L5;
        return null;
    L5:
        AnimatorSet r100 = new AnimatorSet();
        AnimatorSet.Builder r101 = r100.play(ValueAnimator.ofInt(new int[]{1}).setDuration(1));
        List<tf0.t> r110 = r310.a();
        if (r110 == null) goto L249;
        Iterator r111 = r110.iterator();
    L9:
        if (r111.hasNext() == false) goto L249;
        tf0.t r112 = (tf0.t) r111.next();
        String r113 = r112.f();
        float r114 = 1.0f;
        int r115 = 2;
        switch(r113.hashCode()) {
            case -1392296225: goto L181;
            case -1267206133: goto L157;
            case -787957717: goto L141;
            case 109250890: goto L117;
            case 1052832078: goto L15;
            default: goto L12;
        };
    L12:
        r100 = r100;
        r101 = r101;
        r111 = r111;
        long r102 = 1;
    L247:
        r111 = r111;
        r101 = r101;
        r100 = r100;
        goto L9
    L117:
        r100 = r100;
        r101 = r101;
        r111 = r111;
        long r103 = 1;
        if (r113.equals("scale") == false) goto L140;
        Object r104 = r112.h();
        if ((r104 instanceof Double) == true) goto L122;
        r104 = null;
    L122:
        Double r105 = (Double) r104;
        if (r105 == null) goto L125;
        r114 = (float) r105.doubleValue();
    L125:
        ObjectAnimator r106 = ObjectAnimator.ofPropertyValuesHolder(r210, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_X, new float[]{r114}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_Y, new float[]{r114})});
        r106.setDuration(r112.c());
        Long r107 = r112.b();
        if (r107 == null) goto L128;
        r106.setStartDelay(r107.longValue());
    L128:
        List<Float> r108 = r112.e();
        if (r108 != null) goto L131;
    L136:
        Long r109 = r112.g();
        if (r109 == null) goto L139;
        r106.setRepeatCount((int) r109.longValue());
    L139:
        w(r101, r106);
        goto L140
    L131:
        if (r108.size() < 4) goto L134;
        r106.setInterpolator(new PathInterpolator(((Number) ListProtector.get(r108, 0)).floatValue(), ((Number) ListProtector.get(r108, 1)).floatValue(), ((Number) ListProtector.get(r108, 2)).floatValue(), ((Number) ListProtector.get(r108, 3)).floatValue()));
        goto L136
    L134:
        if (r108.size() < 2) goto L136;
        r106.setInterpolator(new PathInterpolator(((Number) ListProtector.get(r108, 0)).floatValue(), ((Number) ListProtector.get(r108, 1)).floatValue()));
    L140:
        r102 = r103;
        goto L247
    L141:
        r100 = r100;
        r101 = r101;
        r111 = r111;
        if (r113.equals("wiggle") == false) goto L180;
        long r116 = r112.c();
        Long r117 = r112.g();
        if (r117 == null) goto L146;
        long r118 = r117.longValue();
    L147:
        long r119 = r116 * r118;
        ValueAnimator r120 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(0);
        r120.setDuration(r119);
        Object r121 = r112.h();
        if ((r121 instanceof Double) == true) goto L150;
        r121 = null;
    L150:
        Double r122 = (Double) r121;
        if (r122 == null) goto L153;
        r114 = (float) r122.doubleValue();
    L153:
        final float r123 = r210.getX();
        final float r124 = r210.getY();
        ALogger.i(this.f75553a, "wiggle at(" + r123 + ',' + r124 + "),duration=" + r119 + ",amp=");
        r120.addUpdateListener(new d(((float) 5) * r114, r210, r123, r124));
        com.bytedance.android.live.ktv.common.midi.v2.a.a(r120, new CommonDynamicIslandLayoutManager$getWiggleAnimate$2(r210, r123, r124));
        Long r125 = r112.b();
        if (r125 == null) goto L156;
        r120.setStartDelay(r125.longValue());
    L156:
        w(r101, r120);
        goto L180
    L146:
        r118 = 1;
    L180:
        r102 = 1;
        goto L247
    L157:
        r100 = r100;
        r101 = r101;
        r111 = r111;
        if (r113.equals(GXTemplateKey.STYLE_OPACITY) == false) goto L180;
        Object r126 = r112.h();
        if ((r126 instanceof Double) == true) goto L162;
        r126 = null;
    L162:
        Double r127 = (Double) r126;
        if (r127 == null) goto L165;
        r114 = (float) r127.doubleValue();
    L165:
        ObjectAnimator r128 = ObjectAnimator.ofPropertyValuesHolder(r210, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("alpha", new float[]{r114})});
        r128.setDuration(r112.c());
        Long r129 = r112.b();
        if (r129 == null) goto L168;
        r128.setStartDelay(r129.longValue());
    L168:
        List<Float> r130 = r112.e();
        if (r130 != null) goto L171;
    L176:
        Long r131 = r112.g();
        if (r131 == null) goto L179;
        r128.setRepeatCount((int) r131.longValue());
    L179:
        w(r101, r128);
        goto L180
    L171:
        if (r130.size() < 4) goto L174;
        r128.setInterpolator(new PathInterpolator(((Number) ListProtector.get(r130, 0)).floatValue(), ((Number) ListProtector.get(r130, 1)).floatValue(), ((Number) ListProtector.get(r130, 2)).floatValue(), ((Number) ListProtector.get(r130, 3)).floatValue()));
        goto L176
    L174:
        if (r130.size() < 2) goto L176;
        r128.setInterpolator(new PathInterpolator(((Number) ListProtector.get(r130, 0)).floatValue(), ((Number) ListProtector.get(r130, 1)).floatValue()));
        goto L176
    L181:
        r100 = r100;
        r101 = r101;
        r111 = r111;
        r102 = 1;
        if (r113.equals("bezier") == false) goto L247;
        Object r132 = r112.d();
        if ((r132 instanceof Map) == true) goto L186;
        r132 = null;
    L186:
        Map r133 = (Map) r132;
        if (r133 == null) goto L191;
        Double r134 = (Double) r133.get("x");
        if (r134 == null) goto L191;
        Float r135 = Float.valueOf(s1.f((float) r134.doubleValue()));
    L192:
        Object r136 = r112.d();
        if ((r136 instanceof Map) == true) goto L195;
        r136 = null;
    L195:
        Map r137 = (Map) r136;
        if (r137 == null) goto L200;
        Double r138 = (Double) r137.get("y");
        if (r138 == null) goto L200;
        Float r139 = Float.valueOf(s1.f((float) r138.doubleValue()));
    L201:
        Object r140 = r112.h();
        if ((r140 instanceof Map) == true) goto L204;
        r140 = null;
    L204:
        Map r141 = (Map) r140;
        if (r141 == null) goto L209;
        Double r142 = (Double) r141.get("x");
        if (r142 == null) goto L209;
        Float r143 = Float.valueOf(s1.f((float) r142.doubleValue()));
    L210:
        Object r144 = r112.h();
        if ((r144 instanceof Map) == true) goto L213;
        r144 = null;
    L213:
        Map r145 = (Map) r144;
        if (r145 == null) goto L218;
        Double r146 = (Double) r145.get("y");
        if (r146 == null) goto L218;
        Float r147 = Float.valueOf(s1.f((float) r146.doubleValue()));
    L219:
        if (r135 == null) goto L244;
        if (r139 == null) goto L244;
        if (r143 == null) goto L244;
        if (r147 == null) goto L244;
        if (p(this, r135, r143) == true) goto L226;
    L228:
        ALogger.i(this.f75553a, "bezier from(" + r135 + ',' + r139 + ")->to(" + r143 + ',' + r147 + "), pos=" + r312);
        Path r148 = new Path();
        r148.moveTo(r135.floatValue(), r139.floatValue());
        List<tf0.s> r149 = r112.a();
        if (r149 == null) goto L244;
        List<tf0.s> r150 = r149;
        ArrayList r151 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r150, 10));
        Iterator<T> r152 = r150.iterator();
    L232:
        if (r152.hasNext() == false) goto L234;
        tf0.s r153 = (tf0.s) r152.next();
        r151.add(new tf0.s(s1.f(r153.a()), s1.f(r153.b())));
        goto L232
    L234:
        int r154 = r151.size();
        if (r154 != 0) goto L237;
        r148.lineTo(r143.floatValue(), r147.floatValue());
    L241:
        PathMeasure r155 = new PathMeasure(r148, false);
        ValueAnimator r156 = ValueAnimator.ofFloat(new float[]{0.0f, r155.getLength()});
        r156.addUpdateListener(new b(this, r155, r210, r312));
        r156.setDuration(r112.c());
        Long r157 = r112.b();
        if (r157 == null) goto L245;
        r156.setStartDelay(r157.longValue());
    L245:
        w(r101, r156);
        goto L247
    L237:
        if (r154 == 1) goto L239;
        r148.cubicTo(((tf0.s) ListProtector.get(r151, 0)).a(), ((tf0.s) ListProtector.get(r151, 0)).b(), ((tf0.s) ListProtector.get(r151, 1)).a(), ((tf0.s) ListProtector.get(r151, 1)).b(), r143.floatValue(), r147.floatValue());
        goto L241
    L239:
        r148.quadTo(((tf0.s) ListProtector.get(r151, 0)).a(), ((tf0.s) ListProtector.get(r151, 0)).b(), r143.floatValue(), r147.floatValue());
        goto L241
    L226:
        if (p(this, r139, r147) == false) goto L228;
    L244:
        r156 = null;
    L218:
        r147 = null;
    L209:
        r143 = null;
    L200:
        r139 = null;
    L191:
        r135 = null;
        goto L192
    L15:
        if (r113.equals("translate") == false) goto L116;
        boolean r158 = Intrinsics.areEqual(r310.b(), "seat");
        Object r159 = r112.h();
        if ((r159 instanceof Map) == true) goto L19;
        r159 = null;
    L19:
        Map r160 = (Map) r159;
        if (r160 == null) goto L24;
        Double r161 = (Double) r160.get("x");
        if (r161 == null) goto L24;
        Float r162 = Float.valueOf(s1.f((float) r161.doubleValue()));
    L25:
        Object r163 = r112.h();
        if ((r163 instanceof Map) == true) goto L28;
        r163 = null;
    L28:
        Map r164 = (Map) r163;
        if (r164 == null) goto L33;
        Double r165 = (Double) r164.get("y");
        if (r165 == null) goto L33;
        Float r166 = Float.valueOf(s1.f((float) r165.doubleValue()));
    L34:
        if (r162 == null) goto L78;
        if (r166 == null) goto L78;
        if (r158 == false) goto L43;
        r162 = q(r162, r210);
        Float r167 = r(this, r166, r210);
        if (r167 == null) goto L40;
        r166 = Float.valueOf(r167.floatValue() + s1.f(10.0f));
    L41:
        ALogger.i(this.f75553a, "translate to(" + r162 + ',' + r166 + ')');
        goto L78
    L40:
        r166 = null;
        goto L41
    L43:
        int r168 = r210.getWidth();
        int r169 = r210.getHeight();
        Object r170 = r210.getParent();
        if ((r170 instanceof View) == true) goto L46;
        r170 = null;
    L46:
        View r171 = (View) r170;
        if (r171 == null) goto L50;
        View r172 = r171.findViewById(R.id.ttlive_guest_avatar);
        if (r172 == null) goto L50;
    L57:
        if (r172 != null) goto L59;
        Pair r173 = null;
    L69:
        if (r173 == null) goto L72;
        Number r174 = (Integer) r173.getSecond();
        if (r174 == null) goto L72;
    L73:
        if (r173 == null) goto L76;
        Number r175 = (Integer) r173.getFirst();
        if (r175 == null) goto L76;
    L77:
        ALogger.i(this.f75553a, "element " + r310.b() + " translate to(" + r162 + ',' + r166 + "), avatar left " + r175 + " top " + r174 + ", width " + r168 + " height " + r169);
        r162 = Float.valueOf(r162.floatValue() + r175.floatValue());
        r166 = Float.valueOf(r166.floatValue() + r174.floatValue());
    L76:
        r175 = Float.valueOf(0.0f);
    L72:
        r174 = Float.valueOf(0.0f);
        goto L73
    L59:
        int r176 = 0;
        int r177 = 0;
        int r211 = 0;
    L60:
        if (r176 >= r115) goto L68;
        if ((r172.getParent() instanceof View) == false) goto L68;
        r177 = r177 + r172.getLeft();
        r211 = r211 + r172.getTop();
        Object r178 = r172.getParent();
        if (r178 == null) goto L67;
        r172 = (View) r178;
        r176 = r176 + 1;
        r115 = 2;
        goto L60
    L67:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L68:
        r173 = new Pair(Integer.valueOf(r177), Integer.valueOf(r211));
    L50:
        Object r179 = r210.getParent();
        if ((r179 instanceof View) == true) goto L53;
        r179 = null;
    L53:
        View r180 = (View) r179;
        if (r180 == null) goto L56;
        r172 = r180.findViewById(R.id.ttlive_invite_link_guide_effect_animator);
        goto L57
    L56:
        r172 = null;
    L78:
        if (r162 == null) goto L114;
        if (r166 == null) goto L114;
        float r181 = r166.floatValue();
        float r182 = r162.floatValue();
        if (r158 == false) goto L97;
        ObjectAnimator r183 = ObjectAnimator.ofPropertyValuesHolder(r210, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("x", new float[]{r182}), PropertyValuesHolder.ofFloat("y", new float[]{r181})});
        r183.setDuration(r112.c());
        Long r184 = r112.b();
        if (r184 == null) goto L85;
        r183.setStartDelay(r184.longValue());
    L85:
        List<Float> r185 = r112.e();
        if (r185 != null) goto L88;
    L93:
        Long r186 = r112.g();
        if (r186 == null) goto L96;
        r183.setRepeatCount((int) r186.longValue());
    L96:
        r103 = 1;
        Animator r187 = r183;
    L115:
        w(r101, r187);
        goto L140
    L88:
        if (r185.size() < 4) goto L91;
        r183.setInterpolator(new PathInterpolator(((Number) ListProtector.get(r185, 0)).floatValue(), ((Number) ListProtector.get(r185, 1)).floatValue(), ((Number) ListProtector.get(r185, 2)).floatValue(), ((Number) ListProtector.get(r185, 3)).floatValue()));
        goto L93
    L91:
        if (r185.size() < 2) goto L93;
        r183.setInterpolator(new PathInterpolator(((Number) ListProtector.get(r185, 0)).floatValue(), ((Number) ListProtector.get(r185, 1)).floatValue()));
        goto L93
    L97:
        PointF r188 = new PointF(r210.getX(), r210.getY());
        PointF r189 = new PointF(r182, r181);
        r103 = 1;
        ValueAnimator r190 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(1);
        r190.setDuration(r112.c());
        Long r191 = r112.b();
        if (r191 == null) goto L100;
        r190.setStartDelay(r191.longValue());
    L100:
        if (r311 == true) goto L102;
        r190.setDuration(0);
        r190.setStartDelay(0);
    L102:
        List<Float> r192 = r112.e();
        if (r192 != null) goto L105;
    L110:
        Long r193 = r112.g();
        if (r193 == null) goto L113;
        r190.setRepeatCount((int) r193.longValue());
    L113:
        r190.addUpdateListener(new c(r189, r188, this, r210));
        r187 = r190;
        goto L115
    L105:
        if (r192.size() < 4) goto L108;
        r190.setInterpolator(new PathInterpolator(((Number) ListProtector.get(r192, 0)).floatValue(), ((Number) ListProtector.get(r192, 1)).floatValue(), ((Number) ListProtector.get(r192, 2)).floatValue(), ((Number) ListProtector.get(r192, 3)).floatValue()));
        goto L110
    L108:
        if (r192.size() < 2) goto L110;
        r190.setInterpolator(new PathInterpolator(((Number) ListProtector.get(r192, 0)).floatValue(), ((Number) ListProtector.get(r192, 1)).floatValue()));
    L114:
        r103 = 1;
        r187 = null;
    L33:
        r166 = null;
    L24:
        r162 = null;
        goto L25
    L116:
        r100 = r100;
        r101 = r101;
        r111 = r111;
    L249:
        return r100;
    }
}

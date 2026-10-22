package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.link.model.ITopTip;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0018B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u001b\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0010\u0010\u0014B#\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0010\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/PkTopTipView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdk/link/model/ITopTip;", "topTip", "", "setData", "", "b", "Z", "getPkAvailable", "()Z", "setPkAvailable", "(Z)V", "pkAvailable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkTopTipView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f97017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f97018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f97019c;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkTopTipView f97020a;

        public b(PkTopTipView r100) {
            this.f97020a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((TextView) this.f97020a._$_findCachedViewById(R.id.tv_top_tip)).setFocusable(true);     // Catch: Throwable -> L4
            ((TextView) this.f97020a._$_findCachedViewById(R.id.tv_top_tip)).setFocusableInTouchMode(true);     // Catch: Throwable -> L4
            ((TextView) this.f97020a._$_findCachedViewById(R.id.tv_top_tip)).requestFocus();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkTopTipView f97021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ITopTip f97022b;

        public c(PkTopTipView r100, ITopTip r101) {
            this.f97021a = r100;
            this.f97022b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            PkTopTipView r101 = this.f97021a;
            r101.f97019c = true;
            ((ConstraintLayout) r101._$_findCachedViewById(R.id.root_top_tip)).setVisibility(8);
            ITopTip r102 = this.f97022b;
            Integer r103 = null;
            if (r102 != null) goto L5;
        L7:
            HashMap r104 = new HashMap();
            ITopTip r105 = this.f97022b;
            if (r105 == null) goto L10;
            r103 = Integer.valueOf(r105.getTopTipType());
        L10:
            r104.put("content", String.valueOf(r103));
            r104.put("action_type", "click");
            mz0.n r106 = new mz0.n();
            Map<String, String> r107 = r106.f516447a;
            Intrinsics.checkNotNullParameter(r107, "map");
            Intrinsics.checkNotNullParameter(r104, "map");
            r107.putAll(r104);
            mz0.m r108 = new mz0.m();
            r108.b(LogCommon.ROOM);
            List<Object> r109 = r106.f516448b;
            ArrayList r110 = (ArrayList) r109;
            r110.addAll(r108.f516446a);
            cy0.e.f465759a.getClass();
            cy0.j r111 = cy0.e.a.f465760a;
            com.bytedance.android.scope.m.f163449e.getClass();
            Object r112 = com.bytedance.android.scope.m.b(r111).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r112);
            ((mz0.i) ((f80.a) r112)).w3("livesdk_pk_invite_yellow_bar", r106.f516447a, r106.f516448b);
            return;
        L5:
            if (r102.getTopTipType() != ITopTip.TopTipType.TopTipTeamTask.ordinal()) goto L7;
            l51.a.f507453i0.setValue(null, l51.a.f507436a[70], Boolean.TRUE);
            goto L7
        }
    }

    static {
    }

    public final void R5() {
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_pk_top_tip, this, true);
        a1.k(_$_findCachedViewById(R.id.root_top_tip), 0);
    }

    public final boolean getPkAvailable() {
        return this.f97018b;
    }

    public PkTopTipView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f97017a = new LinkedHashMap();
        R5();
    }

    public final View _$_findCachedViewById(int r100) {
        if (this.f97017a != null) goto L5;
        this.f97017a = new LinkedHashMap();
    L5:
        View r101 = this.f97017a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f97017a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setData(ITopTip r110) {
        if (r110 == null) goto L8;
        py.k r100 = r110.getTopImg();
        if (r100 == null) goto L8;
        ((HSImageView) _$_findCachedViewById(R.id.iv_top_tip)).setVisibility(0);
        ImageLoader.bindImage((HSImageView) _$_findCachedViewById(R.id.iv_top_tip), r100);
    L8:
        if (r110 == null) goto L10;
        String r101 = r110.getTopContent();
    L11:
        ((TextView) _$_findCachedViewById(R.id.tv_top_tip)).setText(r101);
        ((TextView) _$_findCachedViewById(R.id.tv_top_tip)).setFocusable(false);
        ((TextView) _$_findCachedViewById(R.id.tv_top_tip)).setFocusableInTouchMode(false);
        ((TextView) _$_findCachedViewById(R.id.tv_top_tip)).postDelayed(new b(this), 2000);
        if (r110 == null) goto L17;
        if (r110.getTopTipType() != ITopTip.TopTipType.TopTipPunish.ordinal()) goto L17;
        ((TextView) _$_findCachedViewById(R.id.tv_top_tip)).setTextColor(s1.h(R.color.ttlive_pk_top_tip_text_color_yellow));
        ((HSImageView) _$_findCachedViewById(R.id.iv_tip_close)).setImageResource(R.drawable.ttlive_ic_pk_top_tip_close_yellow);
        ((TextView) _$_findCachedViewById(R.id.tv_top_tip)).setVisibility(0);
        ((HSImageView) _$_findCachedViewById(R.id.iv_tip_close)).setVisibility(0);
        ((ConstraintLayout) _$_findCachedViewById(R.id.root_top_tip)).setBackgroundColor(ColorProtector.parseColor("#1FFFBC1F"));
        ((ConstraintLayout) _$_findCachedViewById(R.id.root_top_tip)).setVisibility(0);
        a1.k(_$_findCachedViewById(R.id.root_top_tip), UtilityKotlinExtentionsKt.i(38));
        HashMap r102 = new HashMap();
        r102.put("action_type", "show");
        r102.put("content", String.valueOf(r110.getTopTipType()));
        mz0.n r103 = new mz0.n();
        Map<String, String> r104 = r103.f516447a;
        Intrinsics.checkNotNullParameter(r104, "map");
        Intrinsics.checkNotNullParameter(r102, "map");
        r104.putAll(r102);
        mz0.m r105 = new mz0.m();
        r105.b(LogCommon.ROOM);
        ((ArrayList) r103.f516448b).addAll(r105.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r106 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r107 = com.bytedance.android.scope.m.b(r106).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r107);
        ((mz0.i) ((f80.a) r107)).w3("livesdk_pk_invite_yellow_bar", r103.f516447a, r103.f516448b);
    L34:
        ((HSImageView) _$_findCachedViewById(R.id.iv_tip_close)).setOnClickListener(new c(this, r110));
        return;
    L17:
        if (r110 != null) goto L19;
    L23:
        if (r110 != null) goto L25;
    L33:
        ((ConstraintLayout) _$_findCachedViewById(R.id.root_top_tip)).setVisibility(8);
        goto L34
    L25:
        if (r110.getTopTipType() != ITopTip.TopTipType.TopTipsPeakGuide.ordinal()) goto L33;
        if (this.f97019c == true) goto L33;
        ((TextView) _$_findCachedViewById(R.id.tv_top_tip)).setTextColor(s1.h(R.color.ttlive_pk_top_tip_text_color_normal));
        ((HSImageView) _$_findCachedViewById(R.id.iv_tip_close)).setImageResource(R.drawable.ttlive_ic_pk_top_tip_close);
        ((TextView) _$_findCachedViewById(R.id.tv_top_tip)).setVisibility(0);
        ((HSImageView) _$_findCachedViewById(R.id.iv_tip_close)).setVisibility(0);
        ((ConstraintLayout) _$_findCachedViewById(R.id.root_top_tip)).setVisibility(0);
        a1.k(_$_findCachedViewById(R.id.root_top_tip), UtilityKotlinExtentionsKt.i(38));
        HashMap r108 = new HashMap();
        if (this.f97018b == false) goto L31;
        String r109 = "pk_available";
    L32:
        r108.put("remind_type", r109);
        r108.put("content", String.valueOf(r110.getTopTipType()));
        mz0.n r111 = new mz0.n();
        Map<String, String> r112 = r111.f516447a;
        Intrinsics.checkNotNullParameter(r112, "map");
        Intrinsics.checkNotNullParameter(r108, "map");
        r112.putAll(r108);
        mz0.m r113 = new mz0.m();
        r113.b(LogCommon.ROOM);
        ((ArrayList) r111.f516448b).addAll(r113.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r114 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r115 = com.bytedance.android.scope.m.b(r114).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r115);
        ((mz0.i) ((f80.a) r115)).w3("livesdk_yellow_bar_show", r111.f516447a, r111.f516448b);
        goto L34
    L31:
        r109 = "pk_not_available";
        goto L32
    L19:
        if (r110.getTopTipType() != ITopTip.TopTipType.TopTipTeamTask.ordinal()) goto L23;
        if (((Boolean) l51.a.f507453i0.getValue(null, l51.a.f507436a[70])).booleanValue() == true) goto L23;
        ((TextView) _$_findCachedViewById(R.id.tv_top_tip)).setTextColor(s1.h(R.color.ttlive_pk_top_tip_text_color_normal));
        ((HSImageView) _$_findCachedViewById(R.id.iv_tip_close)).setImageResource(R.drawable.ttlive_ic_pk_top_tip_close);
        ((TextView) _$_findCachedViewById(R.id.tv_top_tip)).setVisibility(0);
        ((HSImageView) _$_findCachedViewById(R.id.iv_tip_close)).setVisibility(0);
        ((ConstraintLayout) _$_findCachedViewById(R.id.root_top_tip)).setVisibility(0);
        a1.k(_$_findCachedViewById(R.id.root_top_tip), UtilityKotlinExtentionsKt.i(38));
        HashMap r116 = new HashMap();
        r116.put("action_type", "show");
        r116.put("content", String.valueOf(r110.getTopTipType()));
        mz0.n r117 = new mz0.n();
        Map<String, String> r118 = r117.f516447a;
        Intrinsics.checkNotNullParameter(r118, "map");
        Intrinsics.checkNotNullParameter(r116, "map");
        r118.putAll(r116);
        mz0.m r119 = new mz0.m();
        r119.b(LogCommon.ROOM);
        ((ArrayList) r117.f516448b).addAll(r119.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r120 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r121 = com.bytedance.android.scope.m.b(r120).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r121);
        ((mz0.i) ((f80.a) r121)).w3("livesdk_pk_invite_yellow_bar", r117.f516447a, r117.f516448b);
        goto L34
    L10:
        r101 = null;
        goto L11
    }

    public final void setPkAvailable(boolean r100) {
        this.f97018b = r100;
    }

    public PkTopTipView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f97017a = new LinkedHashMap();
        R5();
    }

    public PkTopTipView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f97017a = new LinkedHashMap();
        R5();
    }
}

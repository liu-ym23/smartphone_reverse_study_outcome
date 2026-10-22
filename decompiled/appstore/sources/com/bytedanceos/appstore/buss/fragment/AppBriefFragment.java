package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.activity.AppFeedBackActivity;
import com.bytedanceos.appstore.buss.activity.AppPermissionActivity;
import com.bytedanceos.appstore.buss.entity.AppInfoEntity;
import com.bytedanceos.appstore.buss.entity.TvAppInfoFromEntity;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.bytedanceos.appstore.buss.widget.app.item.ItemHorizontalView;
import com.bytedanceos.common.BaseApplication;
import com.obric.appstore.R;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\t\u0010\u0004J\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0004R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00198TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/AppBriefFragment;", "Lh7/c;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "", "E", "initData", "F", "t", "Landroid/view/View;", "v", BusSupport.EVENT_ON_CLICK, "(Landroid/view/View;)V", "I", "Lcom/bytedanceos/appstore/buss/entity/AppInfoEntity;", "f", "Lkotlin/Lazy;", "G", "()Lcom/bytedanceos/appstore/buss/entity/AppInfoEntity;", "appInfoEntity", "", "n", "()I", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "Lx7/m;", "H", "()Lx7/m;", "fragmentTvAppBriefBinding", "g", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppBriefFragment extends h7.c implements View.OnClickListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f8444g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8445f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a(AppInfoEntity r10) {
            kotlin.jvm.internal.q.g(r10, "entity");
            AppBriefFragment r11 = new AppBriefFragment();
            r11.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a("entity", r10)}));
            return r11;
        }

        public a() {
        }
    }

    static {
        f8444g = new a(null);
    }

    public AppBriefFragment() {
        this.f8445f = kotlin.b.b(new AppBriefFragment$appInfoEntity$2(this));
    }

    @Override // h7.c
    public void E() {
    }

    @Override // h7.c
    public void F() {
    }

    public final AppInfoEntity G() {
        return (AppInfoEntity) this.f8445f.getValue();
    }

    public final x7.m H() {
        x7.m r10 = x7.m.a(m());
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final void I() {
        AppInfoEntity r10 = G();
        if (r10 == null) goto L47;
        H().f25695y.setItemCanClick(false);
        H().f25695y.setOnlyShowRate(true);
        ItemHorizontalView r11 = H().f25695y;
        kotlin.jvm.internal.q.f(r11, "tvNowApp");
        String r12 = null;
        ItemHorizontalView.f(r11, r10.convertCommonAppEntity(), 0, 2, null);
        H().f25695y.setPageSource("app_detail_intro_page");
        H().f25692v.setTextColor(ContextCompat.b(l(), R.color.appinfo_category_color));
        H().f25696z.setTextColor(ContextCompat.b(l(), R.color.appinfo_category_color));
        H().f25691u.setVisibility(0);
        H().f25691u.setText(r10.getBrief());
        if (TextUtils.isEmpty(r10.getNew_features()) == false) goto L7;
        H().f25676f.setVisibility(8);
    L9:
        if (TextUtils.isEmpty(r10.getCname()) == false) goto L11;
        H().f25675e.setVisibility(8);
    L12:
        H().F.setText(r10.getCategory());
        H().f25688r.setText(r10.getUpdate_time());
        H().f25670J.setText(r10.getVersion());
        if (TextUtils.isEmpty(r10.getDeveloper()) == false) goto L15;
        H().f25692v.setVisibility(8);
    L17:
        if (TextUtils.isEmpty(r10.getScalable()) == false) goto L19;
        H().f25678h.setVisibility(8);
    L21:
        if (r10.isFromSmt() == false) goto L23;
        H().f25677g.setVisibility(0);
        H().f25679i.setVisibility(8);
        H().B.setText("开发者中心");
        com.bytedanceos.common.toolbox.e.a1(H().f25692v, true);
        com.bytedanceos.common.toolbox.e.a1(H().f25696z, true);
    L36:
        if (BaseApplication.c().o() == true) goto L38;
    L42:
        H().f25672b.setVisibility(8);
        H().f25673c.setVisibility(8);
        H().f25674d.setVisibility(8);
        com.bytedanceos.common.toolbox.e.a1(H().f25674d, false);
    L44:
        if (r10.isSystemApp() == false) goto L48;
        H().f25695y.findViewById(R.id.tv_category).setVisibility(8);
        H().f25677g.setVisibility(8);
        H().f25679i.setVisibility(8);
        H().B.setVisibility(8);
        return;
    L48:
        return;
    L38:
        if (r10.getLabel() == null) goto L42;
        if (r10.getLabel().contains(8) == false) goto L42;
        H().f25672b.setVisibility(0);
        H().f25673c.setVisibility(0);
        H().f25674d.setVisibility(0);
        com.bytedanceos.common.toolbox.e.a1(H().f25674d, true);
        goto L44
    L23:
        H().f25677g.setVisibility(8);
        H().f25679i.setVisibility(0);
        TextView r13 = H().B;
        TvAppInfoFromEntity r14 = r10.getFrom();
        if (r14 == null) goto L26;
        String r15 = r14.getName();
    L27:
        r13.setText(r15);
        TextView r16 = H().f25692v;
        TvAppInfoFromEntity r17 = r10.getFrom();
        if (r17 == null) goto L30;
        String r18 = r17.getName();
    L31:
        r16.setText(r18);
        ImageView r19 = H().f25679i;
        kotlin.jvm.internal.q.f(r19, "ivFromLogo");
        TvAppInfoFromEntity r20 = r10.getFrom();
        if (r20 == null) goto L34;
        r12 = r20.getLogo();
    L34:
        ImageUtilKt.d(r19, r12);
        com.bytedanceos.common.toolbox.e.a1(H().f25692v, false);
        goto L36
    L30:
        r18 = null;
        goto L31
    L26:
        r15 = null;
        goto L27
    L19:
        H().f25678h.setVisibility(0);
        H().D.setText(r10.getScalable());
        goto L21
    L15:
        H().f25692v.setVisibility(0);
        H().f25692v.setText(r10.getDeveloper());
        goto L17
    L11:
        H().f25675e.setVisibility(0);
        H().f25685o.setText(r10.getCname());
        goto L12
    L7:
        H().f25676f.setVisibility(0);
        H().H.setText(r10.getNew_features());
        goto L9
    }

    @Override // h7.c
    public void initData() {
        h7.c.w(this, getString(R.string.summary), true, false, 4, null);
        H().f25696z.setOnClickListener(this);
        H().f25694x.setOnClickListener(this);
        H().f25692v.setOnClickListener(this);
        H().f25674d.setOnClickListener(this);
        I();
        Bundle r10 = new Bundle();
        r10.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, "page_brief");
        f9.b.b("exposure_pages_main", r10);
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_app_brief;
    }

    @Override // h7.c
    public Function0 o() {
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r11) {
        if (r11 == null) goto L5;
        Integer r12 = Integer.valueOf(r11.getId());
    L6:
        if (r12 == null) goto L26;
        if (r12.intValue() != R.id.tv_permission) goto L26;
        String r13 = G().getPkg();
        String r10 = G().getVersion();
        String r14 = G().getLogo();
        if (r13 != null) goto L13;
        return;
    L13:
        if (kotlin.text.o.r(r13) == true) goto L54;
        if (r10 != null) goto L17;
        return;
    L17:
        if (kotlin.text.o.r(r10) == true) goto L55;
        if (r14 != null) goto L21;
        return;
    L21:
        if (kotlin.text.o.r(r14) == true) goto L56;
        AppPermissionActivity.f8309h.a(l(), r13, r10, r14);
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L26:
        if (r12 != null) goto L29;
    L41:
        if (r12 != null) goto L44;
    L46:
        if (r12 != null) goto L49;
        return;
    L49:
        if (r12.intValue() != R.id.find_more) goto L63;
        i7.a.g(this, PageAppsFragment.f8615n.a("一步精选", 1, 4, true, "page_one_step_apps"), false, 2, null);
        f9.b.b("click_onestep_recommed", null);
        return;
    L63:
        return;
    L44:
        if (r12.intValue() != R.id.tv_feedback) goto L46;
        AppFeedBackActivity.f8298i.a(l(), G().getPkg(), G().getVersion_code().toString());
        return;
    L29:
        if (r12.intValue() != R.id.tv_developer) goto L41;
        String r15 = G().getDeveloper();
        String r16 = G().getDever_id();
        if (r15 != null) goto L33;
        return;
    L33:
        if (kotlin.text.o.r(r15) == true) goto L58;
        if (r16 != null) goto L37;
        return;
    L37:
        if (kotlin.text.o.r(r16) == true) goto L59;
        i7.a.g(this, DevAppsFragment.f8559m.a(r15, r16), false, 2, null);
        return;
    L59:
        return;
    L58:
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // h7.c
    public void t() {
        r();
    }
}

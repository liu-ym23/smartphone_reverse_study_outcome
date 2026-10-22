package com.bytedanceos.appstore.buss.beta.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedanceos.appstore.buss.beta.entity.BetaNavTitleEntity;
import com.bytedanceos.appstore.buss.entity.ApiType;
import com.bytedanceos.appstore.buss.fragment.AllRecommendFragment;
import com.bytedanceos.appstore.buss.fragment.AppCategoryFragment;
import com.bytedanceos.appstore.buss.fragment.AppCategorySingleFragment;
import com.bytedanceos.appstore.buss.fragment.AppRankFragment;
import com.bytedanceos.appstore.buss.fragment.AppSystemFragment;
import com.bytedanceos.appstore.buss.fragment.AppUpdateFragment;
import com.bytedanceos.appstore.buss.fragment.AppWishFragment;
import com.bytedanceos.appstore.buss.fragment.GameSubscribeFragment;
import com.bytedanceos.appstore.buss.fragment.GiftFragment;
import com.bytedanceos.appstore.buss.fragment.MyAppsFragment;
import com.bytedanceos.appstore.buss.fragment.PageAppsFragment;
import com.bytedanceos.appstore.buss.fragment.TopicFragment;
import com.bytedanceos.appstore.buss.fragment.g1;
import com.obric.appstore.R;
import h7.c;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\r8\u0014X\u0094D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001a8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/bytedanceos/appstore/buss/beta/fragment/ContainerContentFragment;", "Lh7/c;", "<init>", "()V", "", "E", "initData", "F", "t", "Landroidx/fragment/app/Fragment;", "H", "()Landroidx/fragment/app/Fragment;", "G", "", "f", "Z", "q", "()Z", "showHeader", "g", "Landroidx/fragment/app/Fragment;", "currentFragment", "", "n", "()I", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ContainerContentFragment extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f8407f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Fragment f8408g;

    public ContainerContentFragment() {
    }

    @Override // h7.c
    public void E() {
        r();
    }

    @Override // h7.c
    public void F() {
        Fragment r10 = this.f8408g;
        q.e(r10, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.base.BaseFragment");
        ((c) r10).F();
    }

    public final Fragment G() {
        Bundle r10 = getArguments();
        String r11 = null;
        if (r10 == null) goto L5;
        BetaNavTitleEntity r12 = (BetaNavTitleEntity) r10.getParcelable("entity");
    L6:
        if (r12 == null) goto L8;
        r11 = r12.getApiType();
    L8:
        if (r11 == null) goto L78;
        switch(r11.hashCode()) {
            case -2026877014: goto L73;
            case -1805127115: goto L68;
            case -1311320813: goto L63;
            case -1140116589: goto L58;
            case 3172656: goto L53;
            case 50511102: goto L48;
            case 110546223: goto L43;
            case 642318657: goto L38;
            case 858898849: goto L33;
            case 989204668: goto L28;
            case 1031995768: goto L23;
            case 1561458406: goto L18;
            case 1985941072: goto L13;
            default: goto L78;
        };
    L13:
        if (r11.equals(ApiType.setting) == false) goto L78;
        return g1.f8713i.a();
    L18:
        if (r11.equals(ApiType.categorySingle) == false) goto L78;
        return AppCategorySingleFragment.f8457n.a(r12.getTitle(), r12.getCid(), false);
    L23:
        if (r11.equals(ApiType.gameSubscribe) == false) goto L78;
        return GameSubscribeFragment.f8567l.a(r12.getPageSource());
    L28:
        if (r11.equals("recommend") == false) goto L78;
        AllRecommendFragment.a r13 = AllRecommendFragment.f8437l;
        String r14 = r12.getTitle();
        Integer r15 = r12.getSource();
        q.d(r15);
        return r13.a(r14, r15.intValue(), r12.getPageSource());
    L33:
        if (r11.equals(ApiType.pageApps) == false) goto L78;
        return PageAppsFragment.f8615n.a(r12.getTitle(), r12.getSource(), r12.getPage_id(), false, r12.getPageSource());
    L38:
        if (r11.equals(ApiType.systemApps) == false) goto L78;
        return AppSystemFragment.f8516n.a(r12.getPageSource());
    L43:
        if (r11.equals("topic") == false) goto L78;
        return TopicFragment.f8659n.a(r12.getTitle(), String.valueOf(r12.getPage_id()), false);
    L48:
        if (r11.equals("category") == false) goto L78;
        return AppCategoryFragment.f8446o.a(r12.getTitle(), r12.getCid(), -1, false);
    L53:
        if (r11.equals(ApiType.gift) == false) goto L78;
        return GiftFragment.f8579j.a();
    L58:
        if (r11.equals(ApiType.topList) == false) goto L78;
        return AppRankFragment.f8506o.a(r12.getTitle(), r12.getSource(), r12.getType(), r12.getPageSource());
    L63:
        if (r11.equals(ApiType.appManagerWish) == false) goto L78;
        return AppWishFragment.f8542q.a(r12.getPageSource());
    L68:
        if (r11.equals(ApiType.appManagerUpdate) == false) goto L78;
        return AppUpdateFragment.a.b(AppUpdateFragment.f8529q, false, false, r12.getPageSource(), 2, null);
    L73:
        if (r11.equals(ApiType.appManagerMyApps) == false) goto L78;
        return MyAppsFragment.f8592m.a(r12.getPageSource());
    L78:
        return BetaPagerBlankFragment.f8406f.a();
    L5:
        r12 = null;
        goto L6
    }

    public final Fragment H() {
        return this.f8408g;
    }

    @Override // h7.c
    public void initData() {
        FragmentTransaction r10 = getChildFragmentManager().o();
        q.f(r10, "beginTransaction(...)");
        Fragment r11 = G();
        this.f8408g = r11;
        q.d(r11);
        r10.u(R.id.fl_container, r11);
        r10.j();
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_container;
    }

    @Override // h7.c
    public Function0 o() {
        return ContainerContentFragment$onRetryListener$1.INSTANCE;
    }

    @Override // h7.c
    public boolean q() {
        return this.f8407f;
    }

    @Override // h7.c
    public void t() {
    }
}

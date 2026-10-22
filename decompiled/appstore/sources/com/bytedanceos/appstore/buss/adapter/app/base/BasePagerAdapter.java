package com.bytedanceos.appstore.buss.adapter.app.base;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.appstore.buss.adapter.app.pager.provider.PagerBannerProvider;
import com.bytedanceos.appstore.buss.adapter.app.pager.provider.PagerBannerSmallProvider;
import com.bytedanceos.appstore.buss.adapter.app.pager.provider.PagerHorizontalLargeProvider;
import com.bytedanceos.appstore.buss.adapter.app.pager.provider.PagerHorizontalProvider;
import com.bytedanceos.appstore.buss.adapter.app.pager.provider.PagerVerticalProvider;
import com.bytedanceos.appstore.buss.adapter.app.pager.provider.PagerVideoProvider;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006RZ\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007j\u0004\u0018\u0001`\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R`\u0010\u001b\u001a@\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\"\u0010+\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\"\u0010/\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001e\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001b\u00104\u001a\u0002008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b\u0010\u00103¨\u00065"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/app/base/BasePagerAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "", "pageName", "<init>", "(Ljava/lang/String;)V", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "entity", "", "Lcom/bytedanceos/appstore/buss/utilities/AppOnLongClickListener;", "a", "Lkotlin/jvm/functions/Function2;", "getAppOnLongClickListener", "()Lkotlin/jvm/functions/Function2;", "setAppOnLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "appOnLongClickListener", "Lcom/bytedanceos/appstore/buss/utilities/AppOnClickListener;", "b", "getEditAppOnClickListener", "setEditAppOnClickListener", "editAppOnClickListener", "", "c", "Z", "getShowNoBrief", "()Z", "setShowNoBrief", "(Z)V", "showNoBrief", "d", "getItemCanClick", "setItemCanClick", "itemCanClick", "e", "getEditState", "setEditState", "editState", "f", "getShowPosition", "setShowPosition", "showPosition", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "g", "Lkotlin/Lazy;", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "innerRecycledViewPool", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BasePagerAdapter extends BaseProviderMultiAdapter<AppEntityWrap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2 f8329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2 f8330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8335g;

    /* JADX WARN: Multi-variable type inference failed */
    public BasePagerAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final RecyclerView.RecycledViewPool a() {
        return (RecyclerView.RecycledViewPool) this.f8335g.getValue();
    }

    public BasePagerAdapter(String r10) {
        super(null, 1, null);
        this.f8332d = true;
        PagerHorizontalProvider r11 = new PagerHorizontalProvider(r10);
        r11.c(this.f8329a);
        r11.d(this.f8330b);
        r11.g(this.f8331c);
        r11.f(this.f8332d);
        r11.e(this.f8333e);
        r11.h(this.f8334f);
        addItemProvider(new EmptyProvider());
        addItemProvider(new PagerBannerProvider(r10));
        addItemProvider(new PagerBannerSmallProvider(r10));
        PagerHorizontalLargeProvider r12 = new PagerHorizontalLargeProvider();
        r12.c(r10);
        addItemProvider(r12);
        addItemProvider(r11);
        addItemProvider(new PagerVerticalProvider(r10));
        addItemProvider(new PagerVideoProvider());
        this.f8335g = b.b(BasePagerAdapter$innerRecycledViewPool$2.INSTANCE);
    }

    public /* synthetic */ BasePagerAdapter(String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = "";
    L5:
        this(r10);
    }
}

package com.obric.appstore.buss.rank;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import bb.e;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.utils.ActivityUtilKt;
import com.obric.appstore.base.BaseListAdapter;
import com.obric.appstore.base.BaseListFragment;
import com.obric.appstore.base.ILoadViewModel;
import com.obric.appstore.base.k;
import com.obric.appstore.buss.detail.o;
import com.obric.appstore.network.entity.template.PageType;
import com.obric.appstore.ui.adapter.AppInfoUIAdapter;
import com.obric.appstore.ui.adapter.ItemAppProvider;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00148\u0014X\u0094D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001f\u001a\u00020\u001a8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R \u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020%0$8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/obric/appstore/buss/rank/RankFragment;", "Lcom/obric/appstore/base/BaseListFragment;", "Lcom/bytedanceos/common/model/AppInfo;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/obric/appstore/buss/rank/RankVM;", "o", "Lkotlin/Lazy;", "d0", "()Lcom/obric/appstore/buss/rank/RankVM;", "rankVM", "", "p", "I", "v", "()I", "headerLayoutId", "Lcom/obric/appstore/ui/adapter/AppInfoUIAdapter;", "q", "Lcom/obric/appstore/ui/adapter/AppInfoUIAdapter;", "a0", "()Lcom/obric/appstore/ui/adapter/AppInfoUIAdapter;", "adapter", "Lcom/obric/appstore/network/entity/template/PageType;", "c0", "()Lcom/obric/appstore/network/entity/template/PageType;", "page", "Lcom/obric/appstore/base/k;", "", "b0", "()Lcom/obric/appstore/base/k;", "listVM", "", "W", "()Z", "enableNested", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRankFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RankFragment.kt\ncom/obric/appstore/buss/rank/RankFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,97:1\n106#2,15:98\n*S KotlinDebug\n*F\n+ 1 RankFragment.kt\ncom/obric/appstore/buss/rank/RankFragment\n*L\n24#1:98,15\n*E\n"})
public abstract class RankFragment extends BaseListFragment<AppInfo> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f10794o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f10795p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AppInfoUIAdapter f10796q;

    public RankFragment() {
        final Function0<Fragment> r10 = new RankFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = kotlin.b.a(LazyThreadSafetyMode.NONE, new RankFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f10794o = FragmentViewModelLazyKt.c(this, u.b(RankVM.class), new RankFragment$special$$inlined$viewModels$default$3(r11), new RankFragment$special$$inlined$viewModels$default$4(r12, r11), new RankFragment$special$$inlined$viewModels$default$5(this, r11));
        this.f10796q = new AppInfoUIAdapter();
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ BaseListAdapter U() {
        return a0();
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public boolean W() {
        return true;
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ ILoadViewModel X() {
        return b0();
    }

    public AppInfoUIAdapter a0() {
        return this.f10796q;
    }

    public k b0() {
        return d0();
    }

    public abstract PageType c0();

    public final RankVM d0() {
        return (RankVM) this.f10794o.getValue();
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onCreate(Bundle r13) {
        super.onCreate(r13);
        boolean r10 = false;
        boolean r11 = true;
        Function3 r12 = null;
        Integer r14 = null;
        boolean r15 = false;
        boolean r16 = false;
        float r17 = 0.0f;
        a0().addItemProvider(new ItemAppProvider(getPageSource(), r10, r11, r12, r14, r15, r16, r17, 184, null));
        d0().v(c0());
        ILoadViewModel.s(d0(), false, false, 3, null);
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
        final RecyclerView r12 = Y();
        if (r12 == null) goto L6;
        ActivityUtilKt.b(r12, new RankFragment$onViewCreated$1$1(r12));
        r12.setClipToPadding(false);
        r12.addItemDecoration(new e(o.c(), o.b(), o.c(), false, 0, o.b()));
        return;
    }

    @Override // com.obric.appstore.base.e
    public int v() {
        return this.f10795p;
    }
}

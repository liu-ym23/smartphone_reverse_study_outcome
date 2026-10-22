package com.obric.appstore.buss.detail.developer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import bb.e;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.utils.ActivityUtilKt;
import com.obric.appstore.base.BaseListAdapter;
import com.obric.appstore.base.BaseLoadMoreListFragment;
import com.obric.appstore.base.ILoadViewModel;
import com.obric.appstore.base.IPageLoadViewModel;
import com.obric.appstore.base.o;
import com.obric.appstore.ui.adapter.AppInfoLoadMoreUIAdapter;
import com.obric.appstore.ui.adapter.ItemAppProvider;
import com.obric.appstore.util.m;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00148\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/obric/appstore/buss/detail/developer/DeveloperFragment;", "Lcom/obric/appstore/base/BaseLoadMoreListFragment;", "Lcom/bytedanceos/common/model/AppInfo;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/obric/appstore/buss/detail/developer/DevelopAppVM;", "p", "Lkotlin/Lazy;", "e0", "()Lcom/obric/appstore/buss/detail/developer/DevelopAppVM;", "developAppVM", "Lcom/obric/appstore/ui/adapter/AppInfoLoadMoreUIAdapter;", "q", "Lcom/obric/appstore/ui/adapter/AppInfoLoadMoreUIAdapter;", "d0", "()Lcom/obric/appstore/ui/adapter/AppInfoLoadMoreUIAdapter;", "adapter", "Lcom/obric/appstore/base/o;", "f0", "()Lcom/obric/appstore/base/o;", "loadMoreVM", "r", "a", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDeveloperFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperFragment.kt\ncom/obric/appstore/buss/detail/developer/DeveloperFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,78:1\n106#2,15:79\n*S KotlinDebug\n*F\n+ 1 DeveloperFragment.kt\ncom/obric/appstore/buss/detail/developer/DeveloperFragment\n*L\n27#1:79,15\n*E\n"})
public final class DeveloperFragment extends BaseLoadMoreListFragment<AppInfo> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f10661r = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f10662p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AppInfoLoadMoreUIAdapter f10663q;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f10661r = new a(null);
    }

    public DeveloperFragment() {
        final Function0<Fragment> r10 = new DeveloperFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = b.a(LazyThreadSafetyMode.NONE, new DeveloperFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f10662p = FragmentViewModelLazyKt.c(this, u.b(DevelopAppVM.class), new DeveloperFragment$special$$inlined$viewModels$default$3(r11), new DeveloperFragment$special$$inlined$viewModels$default$4(r12, r11), new DeveloperFragment$special$$inlined$viewModels$default$5(this, r11));
        this.f10663q = new AppInfoLoadMoreUIAdapter();
    }

    @Override // com.obric.appstore.base.BaseLoadMoreListFragment, com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ BaseListAdapter U() {
        return d0();
    }

    @Override // com.obric.appstore.base.BaseLoadMoreListFragment
    public /* bridge */ /* synthetic */ IPageLoadViewModel b0() {
        return f0();
    }

    public AppInfoLoadMoreUIAdapter d0() {
        return this.f10663q;
    }

    public final DevelopAppVM e0() {
        return (DevelopAppVM) this.f10662p.getValue();
    }

    public o f0() {
        return e0();
    }

    @Override // com.obric.appstore.base.BaseLoadMoreListFragment, com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onCreate(Bundle r14) {
        super.onCreate(r14);
        m.a("appstore_page_show", AnonymousClass1.INSTANCE);
        DevelopAppVM r15 = e0();
        Intent r10 = r();
        if (r10 == null) goto L5;
        String r11 = r10.getStringExtra("developerId");
    L6:
        String r12 = "";
        if (r11 != null) goto L9;
        r11 = "";
    L9:
        r15.I(r11);
        DevelopAppVM r16 = e0();
        Intent r13 = r();
        if (r13 == null) goto L12;
        String r17 = r13.getStringExtra("developerName");
    L13:
        if (r17 == null) goto L16;
        r12 = r17;
    L16:
        r16.J(r12);
        if (e0().G().length() != 0) goto L20;
        requireActivity().finish();
        return;
    L20:
        d0().addItemProvider(new ItemAppProvider(getPageSource(), false, false, null, Integer.valueOf(com.obric.appstore.buss.detail.o.a()), false, false, 0.0f, 168, null));
        ILoadViewModel.s(e0(), false, false, 3, null);
        return;
    L12:
        r17 = null;
        goto L13
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
        OFloatingTitleBar r12 = y();
        if (r12 == null) goto L5;
        r12.setCenterTitle(e0().H());
        r12.setMaskBlurRadius(8.0f);
        m(r12);
    L5:
        final RecyclerView r13 = Y();
        if (r13 == null) goto L9;
        ActivityUtilKt.b(r13, new DeveloperFragment$onViewCreated$2$1(r13));
        r13.setClipToPadding(false);
        r13.addItemDecoration(new e(com.obric.appstore.buss.detail.o.c(), com.obric.appstore.buss.detail.o.b(), com.obric.appstore.buss.detail.o.c(), false, 0, 0, 48, null));
        return;
    }
}

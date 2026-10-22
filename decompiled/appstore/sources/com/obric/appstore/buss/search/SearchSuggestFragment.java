package com.obric.appstore.buss.search;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.appstore.base.BaseListAdapter;
import com.obric.appstore.base.BaseListFragment;
import com.obric.appstore.base.ILoadViewModel;
import com.obric.appstore.base.k;
import com.obric.appstore.ui.adapter.ItemAppProvider;
import com.obric.appstore.ui.adapter.ItemSearchSuggestWordProvider;
import com.obric.appstore.ui.adapter.ItemSpaceProvider;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\u00118\u0014X\u0094D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00118\u0014X\u0094D¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0013\u0010\u0015R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010$\u001a\u00020\u001f8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R \u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020&0%8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0013\u0010-\u001a\u0004\u0018\u00010*8F¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/obric/appstore/buss/search/SearchSuggestFragment;", "Lcom/obric/appstore/base/BaseListFragment;", "Lza/b;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", ServerElements.CONTENT, "B", "(Landroid/view/View;)V", "", "o", "I", "v", "()I", "headerLayoutId", "p", "stateLayoutId", "Lcom/obric/appstore/buss/search/SearchSuggestVM;", "q", "Lkotlin/Lazy;", "e0", "()Lcom/obric/appstore/buss/search/SearchSuggestVM;", "suggestVM", "Lcom/obric/appstore/buss/search/SearchSuggestAdapter;", "r", "Lcom/obric/appstore/buss/search/SearchSuggestAdapter;", "b0", "()Lcom/obric/appstore/buss/search/SearchSuggestAdapter;", "adapter", "Lcom/obric/appstore/base/k;", "", "c0", "()Lcom/obric/appstore/base/k;", "listVM", "Lcom/obric/appstore/buss/search/SearchContainerFragment;", "d0", "()Lcom/obric/appstore/buss/search/SearchContainerFragment;", "parent", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSearchSuggestFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchSuggestFragment.kt\ncom/obric/appstore/buss/search/SearchSuggestFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 OUnitExtension.kt\ncom/obric/oui/common/util/OUnitExtensionKt\n*L\n1#1,111:1\n106#2,15:112\n181#3,3:127\n180#3,5:130\n*S KotlinDebug\n*F\n+ 1 SearchSuggestFragment.kt\ncom/obric/appstore/buss/search/SearchSuggestFragment\n*L\n27#1:112,15\n48#1:127,3\n48#1:130,5\n*E\n"})
public final class SearchSuggestFragment extends BaseListFragment<za.b> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f10863o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f10864p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f10865q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final SearchSuggestAdapter f10866r;

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f10867a;

        public a(Function1 r10) {
            q.g(r10, "function");
            this.f10867a = r10;
        }

        public final boolean equals(Object r10) {
            if ((r10 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r10 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return q.b(getFunctionDelegate(), ((FunctionAdapter) r10).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function getFunctionDelegate() {
            return this.f10867a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r10) {
            this.f10867a.invoke(r10);
        }
    }

    public SearchSuggestFragment() {
        final Function0<Fragment> r10 = new SearchSuggestFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = kotlin.b.a(LazyThreadSafetyMode.NONE, new SearchSuggestFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f10865q = FragmentViewModelLazyKt.c(this, u.b(SearchSuggestVM.class), new SearchSuggestFragment$special$$inlined$viewModels$default$3(r11), new SearchSuggestFragment$special$$inlined$viewModels$default$4(r12, r11), new SearchSuggestFragment$special$$inlined$viewModels$default$5(this, r11));
        this.f10866r = new SearchSuggestAdapter();
    }

    public static final /* synthetic */ SearchSuggestVM a0(SearchSuggestFragment r10) {
        return r10.e0();
    }

    @Override // com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e
    public void B(View r10) {
        q.g(r10, ServerElements.CONTENT);
        super.B(r10);
        SearchContainerFragment r11 = d0();
        if (r11 == null) goto L10;
        SearchVM r12 = r11.T();
        if (r12 == null) goto L11;
        LiveData r13 = r12.j();
        if (r13 == null) goto L12;
        r13.i(getViewLifecycleOwner(), new a(new SearchSuggestFragment$onCreateContentView$1(this)));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.obric.appstore.base.BaseFragment
    public int I() {
        return this.f10864p;
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ BaseListAdapter U() {
        return b0();
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ ILoadViewModel X() {
        return c0();
    }

    public SearchSuggestAdapter b0() {
        return this.f10866r;
    }

    public k c0() {
        return e0();
    }

    public final SearchContainerFragment d0() {
        Fragment r10 = getParentFragment();
        if ((r10 instanceof SearchContainerFragment) == true) goto L7;
        return null;
    L7:
        return (SearchContainerFragment) r10;
    }

    public final SearchSuggestVM e0() {
        return (SearchSuggestVM) this.f10865q.getValue();
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onCreate(Bundle r13) {
        super.onCreate(r13);
        b0().addItemProvider(new ItemAppProvider(getPageSource(), false, false, null, null, false, false, 0.0f, 248, null));
        b0().addItemProvider(new ItemSearchSuggestWordProvider(getPageSource(), new AnonymousClass1(this)));
        b0().addItemProvider(new ItemSpaceProvider(yf.b.b(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()))));
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
        final RecyclerView r12 = Y();
        if (r12 == null) goto L6;
        u8.c.c(r12, new SearchSuggestFragment$onViewCreated$1$1(r12));
        r12.setClipToPadding(false);
        return;
    }

    @Override // com.obric.appstore.base.e
    public int v() {
        return this.f10863o;
    }
}

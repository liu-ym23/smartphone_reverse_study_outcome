package com.obric.appstore.base;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.widget.oui.ViewExtKt;
import com.obric.appstore.R;
import java.util.Collection;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u001f\u0010\u0015\u001a\u00020\u00072\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0013H\u0004¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u000f8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0011R\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR(\u0010&\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R \u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000'8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R$\u00104\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0013\u0012\u0002\b\u0003018$X¤\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u001c\u00106\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003018TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b5\u00103¨\u00067"}, d2 = {"Lcom/obric/appstore/base/BaseListFragment;", "T", "Lcom/obric/appstore/base/BaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "", "L", "()Z", "M", "", ServerElements.LIST, "Z", "(Ljava/util/List;)V", "k", "W", "enableNested", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "l", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "V", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "Landroidx/recyclerview/widget/RecyclerView;", "<set-?>", "m", "Landroidx/recyclerview/widget/RecyclerView;", "Y", "()Landroidx/recyclerview/widget/RecyclerView;", "listview", "Lcom/obric/appstore/base/BaseListAdapter;", "n", "Lcom/obric/appstore/base/BaseListAdapter;", "U", "()Lcom/obric/appstore/base/BaseListAdapter;", "adapter", "", "w", "()I", "layoutId", "Lcom/obric/appstore/base/ILoadViewModel;", "X", "()Lcom/obric/appstore/base/ILoadViewModel;", "listVM", "K", "vm", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BaseListFragment<T> extends BaseFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f10541k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DiffUtil.ItemCallback f10542l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RecyclerView f10543m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final BaseListAdapter f10544n;

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f10545a;

        public a(Function1 r10) {
            q.g(r10, "function");
            this.f10545a = r10;
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
            return this.f10545a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r10) {
            this.f10545a.invoke(r10);
        }
    }

    public BaseListFragment() {
        this.f10544n = new BaseListAdapter();
    }

    @Override // com.obric.appstore.base.BaseFragment
    public ILoadViewModel K() {
        return X();
    }

    @Override // com.obric.appstore.base.BaseFragment
    public boolean L() {
        Collection r10 = (Collection) X().k().e();
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.isEmpty() == true) goto L8;
        return false;
    }

    @Override // com.obric.appstore.base.BaseFragment
    public void M() {
        X().k().i(this, new a(new BaseListFragment$observeData$1(this)));
    }

    public BaseListAdapter U() {
        return this.f10544n;
    }

    public DiffUtil.ItemCallback V() {
        return this.f10542l;
    }

    public boolean W() {
        return this.f10541k;
    }

    public abstract ILoadViewModel X();

    public final RecyclerView Y() {
        return this.f10543m;
    }

    public final void Z(List r10) {
        if (V() == null) goto L9;
        BaseListAdapter r11 = U();
        if (r10 == null) goto L7;
        List<T> r12 = b0.z0(r10);
    L8:
        r11.setDiffNewData(r12);
        return;
    L7:
        r12 = null;
        goto L8
    L9:
        U().setList(r10);
    }

    @Override // com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        DiffUtil.ItemCallback r11 = V();
        if (r11 == null) goto L6;
        U().setDiffCallback(r11);
        return;
    }

    @Override // com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f10543m = null;
    }

    @Override // com.obric.appstore.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
        sa.a r12 = s();
        if (r12 == null) goto L9;
        FrameLayout r13 = r12.f24560b;
        if (r13 == null) goto L9;
        RecyclerView r14 = (RecyclerView) ViewExtKt.findView(r13, R.id.listview);
        if (r14 == null) goto L9;
        r14.setLayoutManager(new LinearLayoutManager(requireActivity()));
        u8.c.c(r14, BaseListFragment$onViewCreated$1$1.INSTANCE);
        r14.setAdapter(U());
    L10:
        this.f10543m = r14;
        return;
    L9:
        r14 = null;
        goto L10
    }

    @Override // com.obric.appstore.base.e
    public int w() {
        if (W() == false) goto L6;
        return R.layout.common_fragment_base_listview_nested;
    L6:
        return R.layout.common_fragment_base_listview;
    }
}

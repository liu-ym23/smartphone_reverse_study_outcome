package com.obric.appstore.base;

import android.os.Bundle;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0017\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00148$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R*\u0010\u001d\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0002\b\u00030\u00188TX\u0095\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00188TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001b¨\u0006 "}, d2 = {"Lcom/obric/appstore/base/BaseLoadMoreListFragment;", "T", "Lcom/obric/appstore/base/BaseListFragment;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "M", "", "L", "()Z", "Lcom/obric/appstore/base/BaseListAdapter;", "o", "Lcom/obric/appstore/base/BaseListAdapter;", "U", "()Lcom/obric/appstore/base/BaseListAdapter;", "adapter", "Lcom/obric/appstore/base/IPageLoadViewModel;", "b0", "()Lcom/obric/appstore/base/IPageLoadViewModel;", "loadMoreVM", "Lcom/obric/appstore/base/ILoadViewModel;", "", "X", "()Lcom/obric/appstore/base/ILoadViewModel;", "getListVM$annotations", "listVM", "K", "vm", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BaseLoadMoreListFragment<T> extends BaseListFragment<T> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final BaseListAdapter f10551o;

    public BaseLoadMoreListFragment() {
        this.f10551o = new BaseLoadMoreListAdapter();
    }

    public static /* synthetic */ void a0(BaseLoadMoreListFragment r10) {
        c0(r10);
    }

    public static final void c0(BaseLoadMoreListFragment r10) {
        q.g(r10, "this$0");
        IPageLoadViewModel.C(r10.b0(), false, false, 3, null);
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment
    public ILoadViewModel K() {
        return b0();
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment
    public boolean L() {
        Collection r10 = (Collection) b0().y().e();
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.isEmpty() == true) goto L8;
        return false;
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment
    public void M() {
        b0().k().i(this, new BaseListFragment.a(new BaseLoadMoreListFragment$observeData$1(this)));
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public BaseListAdapter U() {
        return this.f10551o;
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public ILoadViewModel X() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public abstract IPageLoadViewModel b0();

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        U().getLoadMoreModule().setOnLoadMoreListener(new i(this));
        b0().m().i(this, new BaseListFragment.a(new AnonymousClass2(this)));
    }
}

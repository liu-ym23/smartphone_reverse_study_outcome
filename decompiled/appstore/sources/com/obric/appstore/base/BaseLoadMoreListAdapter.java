package com.obric.appstore.base;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.loadmore.BaseLoadMoreView;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.module.LoadMoreModuleConfig;
import com.chad.library.adapter.base.util.AdapterUtilsKt;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u0006*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/obric/appstore/base/BaseLoadMoreListAdapter;", "T", "Lcom/obric/appstore/base/BaseListAdapter;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "<init>", "()V", "a", "b", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class BaseLoadMoreListAdapter<T> extends BaseListAdapter<T> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10550a = null;

    public static final class a extends BaseLoadMoreView {
        public a() {
        }

        @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
        public View getLoadComplete(BaseViewHolder r10) {
            q.g(r10, "holder");
            return r10.getView(R.id.load_more_load_complete_view);
        }

        @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
        public View getLoadEndView(BaseViewHolder r10) {
            q.g(r10, "holder");
            return r10.getView(R.id.load_more_load_end_view);
        }

        @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
        public View getLoadFailView(BaseViewHolder r10) {
            q.g(r10, "holder");
            return r10.getView(R.id.load_more_load_fail_view);
        }

        @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
        public View getLoadingView(BaseViewHolder r10) {
            q.g(r10, "holder");
            return r10.getView(R.id.load_more_loading_view);
        }

        @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
        public View getRootView(ViewGroup r10) {
            q.g(r10, "parent");
            return AdapterUtilsKt.getItemView(r10, R.layout.common_state_view_load_more);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public b() {
        }
    }

    static {
        f10550a = new b(null);
        LoadMoreModuleConfig.setDefLoadMoreView(new a());
    }

    public BaseLoadMoreListAdapter() {
    }
}

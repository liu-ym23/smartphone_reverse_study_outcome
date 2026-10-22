package com.bytedance.android.live.core.paging.adapter;

import android.database.Observable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.live.base.model.s;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.paging.viewmodel.PagingViewModel;
import com.bytedance.android.live.core.paging.viewmodel.PagingViewModelV2;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.r3;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes45.dex */
public abstract class PagingAdapter<T> extends PagedListAdapter<T, RecyclerView.ViewHolder> {
    public static final int TYPE_EMPTY = -1091641683;
    private static final int TYPE_FOOTER = -559038737;
    private static final int TYPE_HEADER = -559038738;
    protected static final int TYPE_LOADING = -1091576148;
    protected static final int TYPE_LOAD_ERROR = -1091576149;
    private final Observer<Boolean> emptyObserver;
    private boolean hasFooter;
    private boolean hasHeader;
    private final Observer<Boolean> hasMoreObserver;
    private boolean isEmpty;
    private boolean isLoadingShowing;
    private final Observer<Integer> itemChangeObserver;
    private final Observer<PagedList<T>> liveDataObserver;
    private NetworkStat.Status loadStatus;
    private final PagingAdapter<T>.f mObservable;
    private final Observer<NetworkStat> networkObserver;
    private final PagingAdapter<T>.g observable;
    private RecyclerView recyclerView;
    private final Observer<NetworkStat> refreshObserver;
    private NetworkStat.Status refreshStatus;
    private boolean supportEmptyView;
    private boolean supportFooter;
    private boolean supportStatusView;
    private PagingViewModel<T> viewModel;
    private PagingViewModelV2 viewModelV2;

    public static class EndViewHolder extends RecyclerView.ViewHolder {
        public EndViewHolder(View r100) {
            super(r100);
        }
    }

    public class a implements Observer<NetworkStat> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PagingAdapter f65027a;

        public a(PagingAdapter r100) {
            this.f65027a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            NetworkStat r101 = (NetworkStat) r100;
            if (r101 == null) goto L7;
            PagingAdapter.access$002(this.f65027a, r101.mStatus);
            PagingAdapter r102 = this.f65027a;
            r102.setLoadingStatus(PagingAdapter.access$100(r102));
            return;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PagingAdapter f65028a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f65028a.notifyDataSetChanged();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(PagingAdapter r100) {
            this.f65028a = r100;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f65029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PagingAdapter f65030b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f65030b.notifyItemChanged(this.f65029a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(PagingAdapter r100, int r101) {
            this.f65030b = r100;
            this.f65029a = r101;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f65031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PagingAdapter f65032b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f65032b.notifyItemInserted(this.f65031a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(PagingAdapter r100, int r101) {
            this.f65032b = r100;
            this.f65031a = r101;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f65033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PagingAdapter f65034b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f65034b.notifyItemRemoved(this.f65033a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(PagingAdapter r100, int r101) {
            this.f65034b = r100;
            this.f65033a = r101;
        }
    }

    public class f extends Observable<RecyclerView.AdapterDataObserver> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PagingAdapter f65035a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f65036a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f65037b;

            @Override // java.lang.Runnable
            public final void run() {
                ((RecyclerView.AdapterDataObserver) ListProtector.get(f.a(this.f65037b), this.f65036a)).onChanged();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(f r100, int r101) {
                this.f65037b = r100;
                this.f65036a = r101;
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f65038a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f65039b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ f f65040c;

            @Override // java.lang.Runnable
            public final void run() {
                this.f65040c.j(this.f65038a, this.f65039b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public b(f r100, int r101, int r102) {
                this.f65040c = r100;
                this.f65038a = r101;
                this.f65039b = r102;
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f65041a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f65042b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f65043c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ f f65044d;

            @Override // java.lang.Runnable
            public final void run() {
                ((RecyclerView.AdapterDataObserver) ListProtector.get(f.c(this.f65044d), this.f65041a)).onItemRangeInserted(this.f65042b, this.f65043c);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public c(f r100, int r101, int r102, int r103) {
                this.f65044d = r100;
                this.f65041a = r101;
                this.f65042b = r102;
                this.f65043c = r103;
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f65045a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f65046b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f65047c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ f f65048d;

            @Override // java.lang.Runnable
            public final void run() {
                ((RecyclerView.AdapterDataObserver) ListProtector.get(f.d(this.f65048d), this.f65045a)).onItemRangeRemoved(this.f65046b, this.f65047c);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public d(f r100, int r101, int r102, int r103) {
                this.f65048d = r100;
                this.f65045a = r101;
                this.f65046b = r102;
                this.f65047c = r103;
            }
        }

        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f65049a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f65050b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f65051c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ f f65052d;

            @Override // java.lang.Runnable
            public final void run() {
                ((RecyclerView.AdapterDataObserver) ListProtector.get(f.e(this.f65052d), this.f65049a)).onItemRangeMoved(this.f65050b, this.f65051c, 1);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public e(f r100, int r101, int r102, int r103) {
                this.f65052d = r100;
                this.f65049a = r101;
                this.f65050b = r102;
                this.f65051c = r103;
            }
        }

        public final void g() {
            int r100 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r100 < 0) goto L13;
            if (PagingAdapter.access$200(this.f65035a) != null) goto L7;
        L11:
            ((RecyclerView.AdapterDataObserver) ListProtector.get(((Observable) this).mObservers, r100)).onChanged();
        L12:
            r100 = r100 - 1;
            goto L3
        L7:
            if (PagingAdapter.access$200(this.f65035a).isComputingLayout() == false) goto L9;
        L10:
            PagingAdapter.access$200(this.f65035a).post(new a(this, r100));
            goto L12
        L9:
            if (PagingAdapter.access$200(this.f65035a).getScrollState() == 0) goto L11;
        }

        public f(PagingAdapter r100) {
            this.f65035a = r100;
        }

        public static /* synthetic */ ArrayList a(f r100) {
            return ((Observable) r100).mObservers;
        }

        public static /* synthetic */ ArrayList b(f r100) {
            return ((Observable) r100).mObservers;
        }

        public static /* synthetic */ ArrayList c(f r100) {
            return ((Observable) r100).mObservers;
        }

        public static /* synthetic */ ArrayList d(f r100) {
            return ((Observable) r100).mObservers;
        }

        public static /* synthetic */ ArrayList e(f r100) {
            return ((Observable) r100).mObservers;
        }

        public final int f(int r100) {
            if (this.f65035a.hasHeader() == true) goto L5;
            return r100;
        L5:
            return r100 + 1;
        }

        public final void h(int r100, int r101) {
            int r102 = f(r100);
            int r103 = f(r101);
            int r104 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r104 < 0) goto L13;
            if (PagingAdapter.access$200(this.f65035a) != null) goto L7;
        L11:
            ((RecyclerView.AdapterDataObserver) ListProtector.get(((Observable) this).mObservers, r104)).onItemRangeMoved(r102, r103, 1);
        L12:
            r104 = r104 - 1;
            goto L3
        L7:
            if (PagingAdapter.access$200(this.f65035a).isComputingLayout() == false) goto L9;
        L10:
            PagingAdapter.access$200(this.f65035a).post(new e(this, r104, r102, r103));
            goto L12
        L9:
            if (PagingAdapter.access$200(this.f65035a).getScrollState() == 0) goto L11;
        }

        public final void i(int r100, int r101) {
            if (PagingAdapter.access$200(this.f65035a) != null) goto L5;
        L9:
            j(r100, r101);
            return;
        L5:
            if (PagingAdapter.access$200(this.f65035a).isComputingLayout() == false) goto L7;
        L8:
            PagingAdapter.access$200(this.f65035a).post(new b(this, r100, r101));
            return;
        L7:
            if (PagingAdapter.access$200(this.f65035a).getScrollState() == 0) goto L9;
            goto L8
        }

        public final void j(int r100, int r101) {
            int r102 = f(r100);
            int r103 = ((Observable) this).mObservers.size();
        L3:
            r103 = r103 - 1;
            if (r103 < 0) goto L13;
            if (PagingAdapter.access$200(this.f65035a) == null) goto L12;
            if (PagingAdapter.access$200(this.f65035a).isComputingLayout() == true) goto L11;
            if (PagingAdapter.access$200(this.f65035a).getScrollState() == 0) goto L12;
        L11:
            PagingAdapter.access$200(this.f65035a).post(new com.bytedance.android.live.core.paging.adapter.f(this, r103, r102, r101));
        L12:
            ((RecyclerView.AdapterDataObserver) ListProtector.get(((Observable) this).mObservers, r103)).onItemRangeChanged(r102, r101, null);
            goto L3
        }

        public final void k(int r100, int r101) {
            int r102 = f(r100);
            int r103 = ((Observable) this).mObservers.size();
        L3:
            r103 = r103 - 1;
            if (r103 < 0) goto L13;
            if (PagingAdapter.access$200(this.f65035a) == null) goto L12;
            if (PagingAdapter.access$200(this.f65035a).isComputingLayout() == true) goto L11;
            if (PagingAdapter.access$200(this.f65035a).getScrollState() == 0) goto L12;
        L11:
            PagingAdapter.access$200(this.f65035a).post(new c(this, r103, r102, r101));
        L12:
            ((RecyclerView.AdapterDataObserver) ListProtector.get(((Observable) this).mObservers, r103)).onItemRangeInserted(r102, r101);
            goto L3
        }

        public final void l(int r100, int r101) {
            int r102 = f(r100);
            int r103 = ((Observable) this).mObservers.size();
        L3:
            r103 = r103 - 1;
            if (r103 < 0) goto L13;
            if (PagingAdapter.access$200(this.f65035a) == null) goto L12;
            if (PagingAdapter.access$200(this.f65035a).isComputingLayout() == true) goto L11;
            if (PagingAdapter.access$200(this.f65035a).getScrollState() == 0) goto L12;
        L11:
            PagingAdapter.access$200(this.f65035a).post(new d(this, r103, r102, r101));
        L12:
            ((RecyclerView.AdapterDataObserver) ListProtector.get(((Observable) this).mObservers, r103)).onItemRangeRemoved(r102, r101);
            goto L3
        }
    }

    public class g extends RecyclerView.AdapterDataObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PagingAdapter f65053a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f65054a;

            @Override // java.lang.Runnable
            public final void run() {
                PagingAdapter.access$300(this.f65054a.f65053a).g();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(g r100) {
                this.f65054a = r100;
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f65055a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f65056b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ g f65057c;

            @Override // java.lang.Runnable
            public final void run() {
                PagingAdapter.access$300(this.f65057c.f65053a).i(this.f65055a, this.f65056b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public b(g r100, int r101, int r102) {
                this.f65057c = r100;
                this.f65055a = r101;
                this.f65056b = r102;
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f65058a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f65059b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ g f65060c;

            @Override // java.lang.Runnable
            public final void run() {
                PagingAdapter.access$300(this.f65060c.f65053a).k(this.f65058a, this.f65059b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public c(g r100, int r101, int r102) {
                this.f65060c = r100;
                this.f65058a = r101;
                this.f65059b = r102;
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f65061a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f65062b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ g f65063c;

            @Override // java.lang.Runnable
            public final void run() {
                PagingAdapter.access$300(this.f65063c.f65053a).l(this.f65061a, this.f65062b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public d(g r100, int r101, int r102) {
                this.f65063c = r100;
                this.f65061a = r101;
                this.f65062b = r102;
            }
        }

        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f65064a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f65065b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ g f65066c;

            @Override // java.lang.Runnable
            public final void run() {
                PagingAdapter.access$300(this.f65066c.f65053a).h(this.f65064a, this.f65065b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public e(g r100, int r101, int r102) {
                this.f65066c = r100;
                this.f65064a = r101;
                this.f65065b = r102;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onChanged() {
            if (PagingAdapter.access$200(this.f65053a) != null) goto L5;
        L9:
            PagingAdapter.access$300(this.f65053a).g();
            return;
        L5:
            if (PagingAdapter.access$200(this.f65053a).isComputingLayout() == false) goto L7;
        L8:
            PagingAdapter.access$200(this.f65053a).post(new a(this));
            return;
        L7:
            if (PagingAdapter.access$200(this.f65053a).getScrollState() == 0) goto L9;
            goto L8
        }

        public g(PagingAdapter r100) {
            this.f65053a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r100, int r101) {
            if (PagingAdapter.access$200(this.f65053a) != null) goto L5;
        L9:
            PagingAdapter.access$300(this.f65053a).i(r100, r101);
            return;
        L5:
            if (PagingAdapter.access$200(this.f65053a).isComputingLayout() == false) goto L7;
        L8:
            PagingAdapter.access$200(this.f65053a).post(new b(this, r100, r101));
            return;
        L7:
            if (PagingAdapter.access$200(this.f65053a).getScrollState() == 0) goto L9;
            goto L8
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int r100, int r101) {
            if (PagingAdapter.access$200(this.f65053a) != null) goto L5;
        L9:
            PagingAdapter.access$300(this.f65053a).k(r100, r101);
            return;
        L5:
            if (PagingAdapter.access$200(this.f65053a).isComputingLayout() == false) goto L7;
        L8:
            PagingAdapter.access$200(this.f65053a).post(new c(this, r100, r101));
            return;
        L7:
            if (PagingAdapter.access$200(this.f65053a).getScrollState() == 0) goto L9;
            goto L8
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int r100, int r101) {
            if (PagingAdapter.access$200(this.f65053a) != null) goto L5;
        L9:
            PagingAdapter.access$300(this.f65053a).l(r100, r101);
            return;
        L5:
            if (PagingAdapter.access$200(this.f65053a).isComputingLayout() == false) goto L7;
        L8:
            PagingAdapter.access$200(this.f65053a).post(new d(this, r100, r101));
            return;
        L7:
            if (PagingAdapter.access$200(this.f65053a).getScrollState() == 0) goto L9;
            goto L8
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int r100, int r101, int r102) {
            if (PagingAdapter.access$200(this.f65053a) != null) goto L5;
        L9:
            PagingAdapter.access$300(this.f65053a).h(r100, r101);
            return;
        L5:
            if (PagingAdapter.access$200(this.f65053a).isComputingLayout() == false) goto L7;
        L8:
            PagingAdapter.access$200(this.f65053a).post(new e(this, r100, r101));
            return;
        L7:
            if (PagingAdapter.access$200(this.f65053a).getScrollState() == 0) goto L9;
            goto L8
        }
    }

    public static class h extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f65067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DouyinLoadingLayout f65068b;

        public class a implements Observer<NetworkStat> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h f65069a;

            public a(h r100) {
                this.f65069a = r100;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object r100) {
                NetworkStat r101 = (NetworkStat) r100;
                if (r101 != null) goto L6;
                return;
            L6:
                if (r101.isLoading() == false) goto L8;
                this.f65069a.f65068b.setVisibility(0);
                return;
            L8:
                this.f65069a.f65068b.setVisibility(8);
            }
        }

        @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter.j
        public final void unbind() {
        }

        public h(View r100) {
            super(r100);
            ViewGroup r101 = (ViewGroup) r100.findViewById(R.id.loading_container);
            this.f65067a = r101;
            DouyinLoadingLayout r102 = new DouyinLoadingLayout(r100.getContext());
            this.f65068b = r102;
            r101.addView(r102);
        }

        @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter.j
        public final void T3(LiveData<NetworkStat> r100) {
            r100.observeForever(new a(this));
        }
    }

    public static class i extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PagingViewModel f65070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f65071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f65072c;

        public i(View r100, PagingViewModel r101) {
            super(r100);
            this.f65070a = r101;
            this.f65071b = r100.findViewById(R.id.error_icon);
            this.f65072c = (TextView) r100.findViewById(R.id.error_tips);
        }
    }

    public static class j extends RecyclerView.ViewHolder {
        public void T3(LiveData<NetworkStat> r100) {
        }

        public void unbind() {
        }

        public j(View r100) {
            super(r100);
        }
    }

    public static /* synthetic */ void A2(PagingAdapter r100, Integer r101) {
        r100.lambda$new$3(r101);
    }

    public static /* synthetic */ void B2(PagingAdapter r100, NetworkStat r101) {
        r100.lambda$new$0(r101);
    }

    public static /* synthetic */ void C2(PagingAdapter r100, PagedList r101) {
        r100.onListChanged(r101);
    }

    public static /* synthetic */ void y2(PagingAdapter r100, Boolean r101) {
        r100.lambda$new$2(r101);
    }

    public static /* synthetic */ void z2(PagingAdapter r100, Boolean r101) {
        r100.lambda$new$1(r101);
    }

    public int getEmptyResId() {
        return R.layout.ttlive_core_rv_loading_empty;
    }

    public abstract int getNormalViewType(int r100, T r101);

    public int invalidateType() {
        return -8888;
    }

    public abstract RecyclerView.ViewHolder onCreateNormalViewHolder(ViewGroup r100, int r101);

    public void setRecyclerView(RecyclerView r100) {
    }

    private LiveData<NetworkStat> networkDataAdapter() {
        PagingViewModelV2 r100 = this.viewModelV2;
        if (r100 == null) goto L7;
        return r100.getNetworkState();
    L7:
        return this.viewModel.networkStat();
    }

    private LiveData<NetworkStat> refreshDataAdapter() {
        PagingViewModelV2 r100 = this.viewModelV2;
        if (r100 == null) goto L7;
        return r100.getRefreshState();
    L7:
        return this.viewModel.networkStat();
    }

    private MutableLiveData<Boolean> retryDataAdapter() {
        PagingViewModelV2 r100 = this.viewModelV2;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getRetry();
    }

    public boolean isError() {
        if (this.loadStatus != NetworkStat.Status.FAILED) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLoading() {
        if (this.loadStatus != NetworkStat.Status.RUNNING) goto L5;
        return true;
    L5:
        return false;
    }

    public final void safeNotifyDataSetChanged() {
        RecyclerView r100 = this.recyclerView;
        if (r100 != null) goto L5;
    L9:
        notifyDataSetChanged();
        return;
    L5:
        if (r100.isComputingLayout() == false) goto L7;
    L8:
        this.recyclerView.post(new b(this));
        return;
    L7:
        if (this.recyclerView.getScrollState() == 0) goto L9;
        goto L8
    }

    public void unbindViewModel() {
        PagingViewModel<T> r100 = this.viewModel;
        if (r100 == null) goto L6;
        r100.liveData().removeObserver(this.liveDataObserver);
        this.viewModel.networkStat().removeObserver(this.networkObserver);
        this.viewModel.refreshStat().removeObserver(this.refreshObserver);
        this.viewModel.hasMore().removeObserver(this.hasMoreObserver);
        this.viewModel.isDataEmpty().removeObserver(this.emptyObserver);
        this.viewModel.updateAdapterItem().removeObserver(this.itemChangeObserver);
        return;
    }

    public void unbindViewModelV2() {
        PagingViewModelV2 r100 = this.viewModelV2;
        if (r100 == null) goto L5;
        r100.getNetworkState().removeObserver(this.networkObserver);
        this.viewModelV2.getRefreshState().removeObserver(this.refreshObserver);
        this.viewModelV2.getHasMore().removeObserver(this.hasMoreObserver);
        this.viewModelV2.getEmpty().removeObserver(this.emptyObserver);
    L5:
        this.viewModelV2 = null;
    }

    private boolean hasEmpty() {
        if (isEmpty() == true) goto L5;
    L9:
        return false;
    L5:
        if (supportEmptyView() == false) goto L9;
        if (hasHeader() == true) goto L9;
        return true;
    }

    public int getDataItemCount() {
        return super.getItemCount();
    }

    @Override // androidx.paging.PagedListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        boolean r100 = hasHeader();
        boolean r101 = hasFooter();
        boolean r102 = hasEmpty();
        boolean r103 = hasLoadingStatus();
        int r104 = getDataItemCount();
        return ((((r100 ? 1 : 0) + r104) + (r101 ? 1 : 0)) + (r103 ? 1 : 0)) + (r102 ? 1 : 0);
    }

    public boolean hasFooter() {
        if (isEmpty() == false) goto L5;
    L11:
        return false;
    L5:
        if (getDataItemCount() == 0) goto L11;
        if (this.hasFooter == false) goto L11;
        if (supportFooter() == false) goto L11;
        return true;
    }

    public boolean hasLoadingStatus() {
        if (hasFooter() == false) goto L5;
    L22:
        return false;
    L5:
        if (supportStatusView() == false) goto L22;
        NetworkStat.Status r100 = this.refreshStatus;
        if (r100 != null) goto L11;
        return false;
    L11:
        if (r100 != NetworkStat.Status.SUCCESS) goto L19;
        if (isLoading() == false) goto L15;
    L16:
        return true;
    L15:
        if (isError() == true) goto L16;
        return false;
    L19:
        if (r100 != NetworkStat.Status.FAILED) goto L22;
        return isError();
    }

    public PagingViewModel<T> getViewModel() {
        return this.viewModel;
    }

    public boolean hasHeader() {
        return this.hasHeader;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public boolean supportEmptyView() {
        return this.supportEmptyView;
    }

    public boolean supportFooter() {
        return this.supportFooter;
    }

    public boolean supportStatusView() {
        return this.supportStatusView;
    }

    public PagingAdapter(DiffUtil.ItemCallback<T> r100) {
        super(r100);
        this.liveDataObserver = new com.bytedance.android.live.core.paging.adapter.a(this);
        this.networkObserver = new com.bytedance.android.live.core.paging.adapter.b(this);
        this.refreshObserver = new a(this);
        this.hasMoreObserver = new com.bytedance.android.live.core.paging.adapter.c(this);
        this.emptyObserver = new com.bytedance.android.live.core.paging.adapter.d(this);
        this.itemChangeObserver = new com.bytedance.android.live.core.paging.adapter.e(this);
        this.loadStatus = null;
        this.refreshStatus = null;
        this.isLoadingShowing = false;
        this.supportEmptyView = true;
        this.supportStatusView = true;
        this.supportFooter = true;
        PagingAdapter<T>.g r101 = new g(this);
        this.observable = r101;
        this.mObservable = new f(this);
        super.registerAdapterDataObserver(r101);
    }

    public static /* synthetic */ NetworkStat.Status access$100(PagingAdapter r100) {
        return r100.loadStatus;
    }

    public static /* synthetic */ RecyclerView access$200(PagingAdapter r100) {
        return r100.recyclerView;
    }

    public static /* synthetic */ f access$300(PagingAdapter r100) {
        return r100.mObservable;
    }

    private /* synthetic */ void lambda$new$0(NetworkStat r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        setLoadingStatus(r100.mStatus);
    }

    private /* synthetic */ void lambda$new$1(Boolean r100) {
        if (r100 != null) goto L4;
    L6:
        boolean r101 = false;
    L7:
        setHasFooter(r101);
        return;
    L4:
        if (r100.booleanValue() == true) goto L6;
        r101 = true;
        goto L7
    }

    private /* synthetic */ void lambda$new$2(Boolean r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        setIsEmpty(r100.booleanValue());
    }

    private /* synthetic */ void lambda$new$3(Integer r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.intValue() >= 0) goto L6;
        return;
    L6:
        if (r100.intValue() >= getItemCount()) goto L12;
        safeNotifyItemChanged(r100.intValue());
        return;
    }

    private void onListChanged(PagedList<T> r100) {
        submitList(r100);
    }

    public RecyclerView.ViewHolder createCustomErrorViewHolder(ViewGroup r100) {
        return new i(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_core_rv_loading_error_custom, r100, false), this.viewModel);
    }

    public T getData(int r100) {
        if (r100 >= 0) goto L4;
    L8:
        LocalTestManager.a(new Class[]{wy.a.class});
        return null;
    L4:
        if (r100 >= getDataItemCount()) goto L8;
        return (T) super.getItem(r100);
    }

    @Override // androidx.paging.PagedListAdapter
    public T getItem(int r100) {
        int r101 = getDataItemCount() + (hasHeader() ? 1 : 0);
        if (hasHeader() == false) goto L7;
        if (r100 != 0) goto L7;
        return null;
    L7:
        if (hasLoadingStatus() == false) goto L11;
        if (r100 != r101) goto L11;
        return null;
    L11:
        if (hasFooter() == false) goto L15;
        if (r100 != r101) goto L15;
        return null;
    L15:
        if (hasEmpty() == false) goto L19;
        if (r100 != r101) goto L19;
        return null;
    L19:
        return getData(mappingAdapterPos2DataPos(r100));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        int r101 = getItemCount() - 1;
        if (hasEmpty() == false) goto L8;
        if (r100 != 0) goto L8;
        return TYPE_EMPTY;
    L8:
        if (hasHeader() == false) goto L13;
        if (r100 != 0) goto L13;
        return TYPE_HEADER;
    L13:
        if (hasLoadingStatus() == false) goto L21;
        if (r100 != r101) goto L21;
        if (isError() == false) goto L18;
        return TYPE_LOAD_ERROR;
    L18:
        return TYPE_LOADING;
    L21:
        if (hasFooter() == false) goto L25;
        if (r100 != r101) goto L25;
        return TYPE_FOOTER;
    L25:
        int r102 = mappingAdapterPos2DataPos(r100);
        if (r102 < getDataItemCount()) goto L30;
        return invalidateType();
    L30:
        return getNormalViewType(r102, getData(r102));
    }

    public int mappingAdapterPos2DataPos(int r100) {
        return r100 - (hasHeader() ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        super.onViewAttachedToWindow(r100);
        if ((r100 instanceof BaseViewHolder) == false) goto L6;
        ((BaseViewHolder) r100).onViewAttachedToWindow();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        super.onViewDetachedFromWindow(r100);
        if ((r100 instanceof BaseViewHolder) == false) goto L6;
        ((BaseViewHolder) r100).onViewDetachedFromWindow();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder r100) {
        if ((r100 instanceof BaseViewHolder) == false) goto L6;
        ((BaseViewHolder) r100).unbind();
        return;
    L6:
        if ((r100 instanceof j) == false) goto L9;
        ((j) r100).unbind();
        return;
    L9:
        if ((r100 instanceof i) == false) goto L14;
        ((i) r100).getClass();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver r100) {
        this.mObservable.registerObserver(r100);
    }

    public final void safeNotifyItemChanged(int r100) {
        RecyclerView r101 = this.recyclerView;
        if (r101 != null) goto L5;
    L9:
        notifyItemChanged(r100);
        return;
    L5:
        if (r101.isComputingLayout() == false) goto L7;
    L8:
        this.recyclerView.post(new c(this, r100));
        return;
    L7:
        if (this.recyclerView.getScrollState() == 0) goto L9;
        goto L8
    }

    public final void safeNotifyItemInserted(int r100) {
        RecyclerView r101 = this.recyclerView;
        if (r101 != null) goto L5;
    L9:
        notifyItemInserted(r100);
        return;
    L5:
        if (r101.isComputingLayout() == false) goto L7;
    L8:
        this.recyclerView.post(new d(this, r100));
        return;
    L7:
        if (this.recyclerView.getScrollState() == 0) goto L9;
        goto L8
    }

    public final void safeNotifyItemRemoved(int r100) {
        RecyclerView r101 = this.recyclerView;
        if (r101 != null) goto L5;
    L9:
        notifyItemRemoved(r100);
        return;
    L5:
        if (r101.isComputingLayout() == false) goto L7;
    L8:
        this.recyclerView.post(new e(this, r100));
        return;
    L7:
        if (this.recyclerView.getScrollState() == 0) goto L9;
        goto L8
    }

    public void setFullSpan(RecyclerView.ViewHolder r100) {
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r100.itemView.getLayoutParams();
        if ((r101 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L6;
        ((StaggeredGridLayoutManager.LayoutParams) r101).setFullSpan(true);
        return;
    }

    public void setHasFooter(boolean r100) {
        if (this.hasFooter != r100) goto L5;
    L9:
        this.hasFooter = r100;
        return;
    L5:
        if (isEmpty() == true) goto L9;
        this.hasFooter = r100;
        safeNotifyDataSetChanged();
    }

    public void setHasHeader(boolean r100) {
        this.hasHeader = r100;
        safeNotifyDataSetChanged();
    }

    public void setHasHeaderWithoutNotify(boolean r100) {
        this.hasHeader = r100;
    }

    public void setIsEmpty(boolean r100) {
        if (this.isEmpty != r100) goto L5;
        return;
    L5:
        this.isEmpty = r100;
        safeNotifyDataSetChanged();
    }

    public void setLoadingStatus(NetworkStat.Status r100) {
        boolean r101 = this.isLoadingShowing;
        this.loadStatus = r100;
        boolean r102 = hasLoadingStatus();
        int r103 = getDataItemCount();
        if (r101 == true) goto L6;
        if (r102 == false) goto L6;
        safeNotifyItemInserted(r103);
    L12:
        this.isLoadingShowing = r102;
        return;
    L6:
        if (r101 == false) goto L9;
        if (r102 == true) goto L9;
        safeNotifyItemRemoved(getItemCount());
    L9:
        if (r101 == false) goto L12;
        if (r102 == false) goto L12;
        safeNotifyItemRemoved(r103);
        safeNotifyItemInserted(r103);
        goto L12
    }

    public final void setSupportEmptyView(boolean r100) {
        this.supportEmptyView = r100;
        notifyDataSetChanged();
    }

    public final void setSupportFooter(boolean r100) {
        this.supportFooter = r100;
        notifyDataSetChanged();
    }

    public final void setSupportStatusView(boolean r100) {
        this.supportStatusView = r100;
        notifyDataSetChanged();
    }

    public void setViewModel(PagingViewModel<T> r100) {
        PagingViewModel<T> r101 = this.viewModel;
        if (r101 == null) goto L5;
        r101.liveData().removeObserver(this.liveDataObserver);
        this.viewModel.networkStat().removeObserver(this.networkObserver);
        this.viewModel.refreshStat().removeObserver(this.refreshObserver);
        this.viewModel.hasMore().removeObserver(this.hasMoreObserver);
        this.viewModel.isDataEmpty().removeObserver(this.emptyObserver);
        this.viewModel.updateAdapterItem().removeObserver(this.itemChangeObserver);
    L5:
        this.viewModel = r100;
        if (r100 != null) goto L8;
        return;
    L8:
        r100.liveData().observeForever(this.liveDataObserver);
        r100.networkStat().observeForever(this.networkObserver);
        r100.refreshStat().observeForever(this.refreshObserver);
        r100.hasMore().observeForever(this.hasMoreObserver);
        r100.isDataEmpty().observeForever(this.emptyObserver);
        r100.updateAdapterItem().observeForever(this.itemChangeObserver);
    }

    public void setViewModelV2(PagingViewModelV2 r100) {
        PagingViewModelV2 r101 = this.viewModelV2;
        if (r101 == null) goto L5;
        r101.getNetworkState().removeObserver(this.networkObserver);
        this.viewModelV2.getRefreshState().removeObserver(this.refreshObserver);
        this.viewModelV2.getHasMore().removeObserver(this.hasMoreObserver);
        this.viewModelV2.getEmpty().removeObserver(this.emptyObserver);
    L5:
        this.viewModelV2 = r100;
        if (r100 != null) goto L8;
        return;
    L8:
        r100.getNetworkState().observeForever(this.networkObserver);
        r100.getRefreshState().observeForever(this.refreshObserver);
        r100.getHasMore().observeForever(this.hasMoreObserver);
        r100.getEmpty().observeForever(this.emptyObserver);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver r100) {
        this.mObservable.unregisterObserver(r100);
    }

    public static /* synthetic */ NetworkStat.Status access$002(PagingAdapter r100, NetworkStat.Status r101) {
        r100.refreshStatus = r101;
        return r101;
    }

    public RecyclerView.ViewHolder createFooterViewHolder(ViewGroup r100, int r101) {
        return new EndViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_core_rv_loading_end, r100, false));
    }

    public RecyclerView.ViewHolder createHeaderViewHolder(ViewGroup r100, int r101) {
        throw new RuntimeException("create your header view holder");
    }

    public RecyclerView.ViewHolder createLoadingViewHolder(ViewGroup r100, int r101) {
        if (r101 != TYPE_LOADING) goto L11;
        if (tb1.c.f545229a == false) goto L9;
        return new h(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_douyin_core_rv_loading_more, r100, false));
    L9:
        return new j(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_core_rv_loading_more, r100, false));
    L11:
        if (r101 != TYPE_LOAD_ERROR) goto L15;
        return new i(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_core_rv_loading_error, r100, false), this.viewModel);
    L15:
        throw new RuntimeException("unknown footer type");
    }

    public RecyclerView.ViewHolder createPpxErrorViewHolder(ViewGroup r100, int r101) {
        return new i(LayoutInflater.from(r100.getContext()).inflate(r101, r100, false), this.viewModel);
    }

    public void onBindEmptyViewHolder(RecyclerView.ViewHolder r100, int r101) {
        setFullSpan(r100);
    }

    public void onBindFooterViewHolder(RecyclerView.ViewHolder r100, int r101) {
        setFullSpan(r100);
    }

    public void onBindHeaderViewHolder(RecyclerView.ViewHolder r100, int r101) {
        setFullSpan(r100);
    }

    public void onBindLoadingViewHolder(RecyclerView.ViewHolder r100, int r101) {
        setFullSpan(r100);
        if ((r100 instanceof j) == false) goto L6;
        ((j) r100).T3(refreshDataAdapter());
        return;
    L6:
        if ((r100 instanceof i) == false) goto L24;
        final i r102 = (i) r100;
        if (isEmpty() == false) goto L10;
    L13:
        boolean r103 = true;
    L14:
        LiveData<NetworkStat> r104 = networkDataAdapter();
        final MutableLiveData<Boolean> r105 = retryDataAdapter();
        r102.getClass();
        NetworkStat r106 = r104.getValue();
        View r107 = r102.itemView.findViewById(R.id.status_error);
        r3.c(r102.itemView, "网络异常，点击重试", true);
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if (r106 != null) goto L17;
    L20:
        r108.height = -2;
        r102.f65071b.setVisibility(8);
        TextView r109 = r102.f65072c;
        r109.setTextColor(r109.getResources().getColor(R.color.ttlive_core_s1));
        r102.f65072c.setText(R.string.ttlive_core_load_status_click_retry);
    L21:
        r107.setLayoutParams(r108);
        r102.itemView.setOnClickListener(new com.bytedance.android.live.core.paging.adapter.g(r102, r105));
        return;
    L17:
        if (r106.isFailed() == false) goto L20;
        if (r103 == false) goto L20;
        r108.height = -1;
        r102.f65071b.setVisibility(0);
        TextView r110 = r102.f65072c;
        r110.setTextColor(r110.getResources().getColor(R.color.ttlive_core_s12));
        r102.f65072c.setText(R.string.ttlive_core_load_status_retry);
        goto L21
    L10:
        if (getDataItemCount() == 0) goto L13;
        r103 = false;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBindNormalViewHolder(RecyclerView.ViewHolder r100, int r101) {
        if ((r100 instanceof BaseViewHolder) == false) goto L12;
        T r102 = getItem(r101);
        if ((r102 instanceof s) == false) goto L7;
        ((s) r102).getClass();
        BaseViewHolder r103 = (BaseViewHolder) r100;
        r103.bind(r103.getData(null), r101);
    L9:
        if (((BaseViewHolder) r100).fullSpan() == false) goto L13;
        setFullSpan(r100);
        return;
    L13:
        return;
    L7:
        ((BaseViewHolder) r100).bind(r102, r101);
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        int r102 = getItemViewType(r101);
        if (r102 != TYPE_HEADER) goto L6;
        onBindHeaderViewHolder(r100, r101);
        return;
    L6:
        if (r102 != TYPE_FOOTER) goto L9;
        onBindFooterViewHolder(r100, r101);
        return;
    L9:
        if (r102 != TYPE_LOADING) goto L11;
    L17:
        onBindLoadingViewHolder(r100, r101);
        return;
    L11:
        if (r102 == TYPE_LOAD_ERROR) goto L17;
        if (r102 != (-1091641683)) goto L16;
        onBindEmptyViewHolder(r100, r101);
        return;
    L16:
        onBindNormalViewHolder(r100, r101);
    }

    public RecyclerView.ViewHolder onCreateEmptyViewHolder(ViewGroup r100, int r101) {
        return new EndViewHolder(LayoutInflater.from(r100.getContext()).inflate(getEmptyResId(), r100, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        if (r101 != TYPE_HEADER) goto L7;
        return createHeaderViewHolder(r100, r101);
    L7:
        if (r101 != TYPE_FOOTER) goto L11;
        return createFooterViewHolder(r100, r101);
    L11:
        if (r101 == TYPE_LOADING) goto L22;
        if (r101 == TYPE_LOAD_ERROR) goto L22;
        if (r101 != (-1091641683)) goto L20;
        return onCreateEmptyViewHolder(r100, r101);
    L20:
        return onCreateNormalViewHolder(r100, r101);
    L22:
        return createLoadingViewHolder(r100, r101);
    }
}

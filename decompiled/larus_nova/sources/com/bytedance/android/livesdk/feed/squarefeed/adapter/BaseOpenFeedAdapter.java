package com.bytedance.android.livesdk.feed.squarefeed.adapter;

import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.paging.adapter.SimplePagingAdapter;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import g60.c;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public abstract class BaseOpenFeedAdapter extends SimplePagingAdapter<FeedItem> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f124436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FeedDataKey f124437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.live.core.cache.a<FeedDataKey, FeedItem> f124438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Long> f124439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Long> f124440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, Long> f124441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PublishSubject<Pair<FeedItem, Long>> f124442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PublishSubject<FeedItem> f124443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PublishSubject<Object> f124444k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PublishSubject<Object> f124445l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PublishSubject<Boolean> f124446m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PublishSubject<Object> f124447n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f124448o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f124449p;

    public static class a extends DiffUtil.ItemCallback<FeedItem> {
        public a(int r100) {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final boolean areContentsTheSame(FeedItem r100, FeedItem r101) {
            int r102 = r100.type;
            if (r102 == r101.type) goto L5;
        L7:
            return false;
        L5:
            if (r102 != 1003) goto L7;
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final boolean areItemsTheSame(FeedItem r100, FeedItem r101) {
            int r102 = r100.type;
            if (r102 == r101.type) goto L5;
        L7:
            return false;
        L5:
            if (r102 != 1003) goto L7;
            return true;
        }
    }

    public BaseOpenFeedAdapter() {
        throw null;
    }

    public BaseOpenFeedAdapter(Map<Integer, b90.a> r100) {
        super(new a(0), r100);
        this.f124436c = new Handler(Looper.getMainLooper());
        this.f124442i = PublishSubject.create();
        PublishSubject<FeedItem> r101 = PublishSubject.create();
        this.f124443j = r101;
        this.f124444k = PublishSubject.create();
        this.f124445l = PublishSubject.create();
        this.f124446m = PublishSubject.create();
        this.f124447n = PublishSubject.create();
        this.f124449p = true;
        this.f124439f = new HashMap();
        this.f124440g = new HashMap();
        r101.subscribe(new uw1.a(this), new c());
    }

    public int D2(int r100) {
        return invalidateType();
    }

    @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        super.onViewAttachedToWindow(r100);
        if (this.f124448o == false) goto L5;
        return;
    L5:
        int r101 = mappingAdapterPos2DataPos(r100.getAdapterPosition());
        if (r101 >= 0) goto L8;
    L23:
        TimeCostUtil.Tag r102 = TimeCostUtil.Tag.LiveFeedInit;
        TimeCostUtil.a("viewholder", r100.getClass().toString());
        com.bytedance.android.live.core.performance.a r103 = com.bytedance.android.live.core.performance.a.f65108a;
        r102.name();
        r103.getClass();
        return;
    L8:
        if (r101 >= mappingAdapterPos2DataPos(getItemCount())) goto L23;
        FeedItem r104 = getItem(r101);
        if (r104 == null) goto L23;
        if (r104.getItem() == null) goto L23;
        String r105 = r104.getItem().getMixId();
        if (this.f124449p == false) goto L20;
        if (((HashMap) this.f124439f).get(r105) != null) goto L23;
        Map<String, Long> r106 = this.f124439f;
        HashMap r107 = (HashMap) r106;
        r107.put(r105, Long.valueOf(TimeUtils.currentTimeMillis()));
        goto L23
    L20:
        if (this.f124441h != null) goto L22;
        this.f124441h = new HashMap();
    L22:
        ((HashMap) this.f124441h).put(r105, -1L);
        goto L23
    }

    @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        super.onViewDetachedFromWindow(r100);
        int r101 = mappingAdapterPos2DataPos(r100.getAdapterPosition());
        if (r101 >= 0) goto L5;
        return;
    L5:
        if (r101 >= mappingAdapterPos2DataPos(getItemCount())) goto L19;
        FeedItem r102 = getItem(r101);
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.getItem() == null) goto L22;
        String r103 = r102.getItem().getMixId();
        if (((HashMap) this.f124439f).get(r103) == null) goto L21;
        long r104 = ((Long) ((HashMap) this.f124439f).get(r103)).longValue();
        Long r105 = (Long) ((HashMap) this.f124440g).get(r103);
        if (r105 != null) goto L16;
        r105 = 0L;
    L16:
        long r106 = TimeUtils.currentTimeMillis() - r104;
        Map<String, Long> r107 = this.f124440g;
        HashMap r108 = (HashMap) r107;
        r108.put(r103, Long.valueOf(r105.longValue() + r106));
        ((HashMap) this.f124439f).remove(r103);
        return;
    L21:
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.live.core.paging.adapter.SimplePagingAdapter, com.bytedance.android.live.core.paging.adapter.PagingAdapter
    public final int getNormalViewType(int r100, Object r101) {
        FeedItem r102 = (FeedItem) r101;
        if (r102 != null) goto L6;
        return invalidateType();
    L6:
        return D2(r102.type);
    }
}

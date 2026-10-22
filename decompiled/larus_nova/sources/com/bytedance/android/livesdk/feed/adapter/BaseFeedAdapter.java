package com.bytedance.android.livesdk.feed.adapter;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.paging.adapter.SimplePagingAdapter;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.livesdk.feed.ItemRepository;
import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import g60.c;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mv1.d;
import mv1.l;

/* JADX INFO: loaded from: classes8.dex */
public abstract class BaseFeedAdapter extends SimplePagingAdapter<FeedItem> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f123595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FeedDataKey f123596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f123597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Long> f123598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Long> f123599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, Long> f123600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PublishSubject<FeedItem> f123601i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PublishSubject<Object> f123602j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PublishSubject<Object> f123603k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PublishSubject<Boolean> f123604l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PublishSubject<Object> f123605m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f123606n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f123607o;

    public static class ItemComparator extends DiffUtil.ItemCallback<FeedItem> {
        public ItemComparator() {
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

    public final FeedItem D2(int r100) {
        ItemRepository r101 = this.f123597e.d(this.f123596d);
        if (r101 != null) goto L7;
        LocalTestManager.a(new Class[]{wy.a.class});
        return null;
    L7:
        if (Lists.isEmpty(r101.getFeedItems()) == true) goto L15;
        if (r100 < 0) goto L15;
        if (r100 >= r101.getFeedItems().size()) goto L15;
        if (((FeedItem) ListProtector.get(this.f123597e.d(this.f123596d).getFeedItems(), r100)).getItem() == null) goto L15;
        return r101.getFeedItem(((FeedItem) ListProtector.get(this.f123597e.d(this.f123596d).getFeedItems(), r100)).getItem().getMixId());
    L15:
        return null;
    }

    public int E2(int r100) {
        return invalidateType();
    }

    public final void F2(Map r100) {
        if (r100 == null) goto L8;
        HashMap r101 = (HashMap) r100;
        if (r101.size() == 0) goto L9;
        r101.clear();
        return;
    L9:
        return;
    }

    public final void G2(boolean r100) {
        this.f123607o = r100;
        if (r100 == true) goto L5;
        F2(this.f123598f);
    L14:
        this.f123604l.onNext(Boolean.valueOf(r100));
        return;
    L5:
        Map<String, Long> r101 = this.f123600h;
        if (r101 == null) goto L14;
        if (((HashMap) r101).size() == 0) goto L14;
        long r102 = TimeUtils.currentTimeMillis();
        Iterator r103 = ((HashMap) this.f123600h).entrySet().iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        String r104 = (String) ((Map.Entry) r103.next()).getKey();
        Map<String, Long> r105 = this.f123598f;
        HashMap r106 = (HashMap) r105;
        r106.put(r104, Long.valueOf(r102));
        goto L11
    L13:
        ((HashMap) this.f123600h).clear();
        this.f123600h = null;
        goto L14
    }

    public final void H2(l r100) {
        this.f123596d = r100.a();
        this.f65074b = new Object[]{r100, this.f123601i, this.f123602j, this.f123603k, this.f123604l, this.f123605m};
    }

    @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        super.onViewAttachedToWindow(r100);
        if (this.f123606n == false) goto L5;
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
        if (this.f123607o == false) goto L20;
        if (((HashMap) this.f123598f).get(r105) != null) goto L23;
        Map<String, Long> r106 = this.f123598f;
        HashMap r107 = (HashMap) r106;
        r107.put(r105, Long.valueOf(TimeUtils.currentTimeMillis()));
        goto L23
    L20:
        if (this.f123600h != null) goto L22;
        this.f123600h = new HashMap();
    L22:
        ((HashMap) this.f123600h).put(r105, -1L);
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
        if (((HashMap) this.f123598f).get(r103) == null) goto L21;
        long r104 = ((Long) ((HashMap) this.f123598f).get(r103)).longValue();
        Long r105 = (Long) ((HashMap) this.f123599g).get(r103);
        if (r105 != null) goto L16;
        r105 = 0L;
    L16:
        long r106 = TimeUtils.currentTimeMillis() - r104;
        Map<String, Long> r107 = this.f123599g;
        HashMap r108 = (HashMap) r107;
        r108.put(r103, Long.valueOf(r105.longValue() + r106));
        ((HashMap) this.f123598f).remove(r103);
        return;
    L21:
        return;
    L22:
        return;
    }

    public BaseFeedAdapter(Map<Integer, b90.a> r100, f r101) {
        this(new ItemComparator(), r100, r101);
    }

    @Override // com.bytedance.android.live.core.paging.adapter.SimplePagingAdapter, com.bytedance.android.live.core.paging.adapter.PagingAdapter
    public final int getNormalViewType(int r100, Object r101) {
        FeedItem r102 = (FeedItem) r101;
        if (r102 != null) goto L6;
        return invalidateType();
    L6:
        return E2(r102.type);
    }

    public BaseFeedAdapter(DiffUtil.ItemCallback<FeedItem> r100, Map<Integer, b90.a> r101, f r102) {
        super(r100, r101);
        this.f123595c = new Handler(Looper.getMainLooper());
        PublishSubject<FeedItem> r103 = PublishSubject.create();
        this.f123601i = r103;
        this.f123602j = PublishSubject.create();
        this.f123603k = PublishSubject.create();
        this.f123604l = PublishSubject.create();
        this.f123605m = PublishSubject.create();
        this.f123607o = true;
        this.f123597e = r102;
        this.f123598f = new HashMap();
        this.f123599g = new HashMap();
        r103.subscribe(new d(this), new c());
    }
}

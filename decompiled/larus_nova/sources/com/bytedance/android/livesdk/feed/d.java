package com.bytedance.android.livesdk.feed;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.utils.NoNullRepeatList;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.common.utility.Lists;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<FeedDataKey, a> f123664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublishSubject<FeedDataKey> f123665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.core.cache.a<FeedDataKey, FeedItem> f123666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.feed.feed.d> f123667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NoNullRepeatList f123668e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ItemRepository f123669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f123670b;

        public a(ItemRepository r100) {
            this.f123669a = r100;
            this.f123670b = 0;
        }
    }

    public d(com.bytedance.android.live.core.cache.i r100) {
        this.f123664a = new ConcurrentHashMap();
        BehaviorSubject.createDefault(Boolean.FALSE);
        this.f123665b = PublishSubject.create();
        PublishSubject.create();
        this.f123667d = new LinkedList();
        this.f123668e = new NoNullRepeatList();
        this.f123666c = r100;
    }

    @Override // com.bytedance.android.livesdk.feed.f
    public final void b(f.a r100) {
        this.f123668e.remove(r100);
    }

    @Override // com.bytedance.android.livesdk.feed.f
    public final void c(com.bytedance.android.livesdk.feed.feed.d r100) {
        ((LinkedList) this.f123667d).add(r100);
    }

    @Override // com.bytedance.android.livesdk.feed.f
    public final ItemRepository d(FeedDataKey r100) {
        a r101 = (a) ((ConcurrentHashMap) this.f123664a).get(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.f123669a;
    }

    @Override // com.bytedance.android.livesdk.feed.f
    public final void f(com.bytedance.android.livesdk.feed.feed.d r100) {
        ((LinkedList) this.f123667d).remove(r100);
    }

    @Override // com.bytedance.android.livesdk.feed.f
    public final void i(f.a r100) {
        this.f123668e.add(r100);
    }

    @Override // com.bytedance.android.livesdk.feed.f
    public final void e(FeedDataKey r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (r100 == null) goto L9;
        a r102 = (a) ((ConcurrentHashMap) this.f123664a).get(r100);
        if (r102 == null) goto L9;
        r102.f123669a.Gf(r101);
    L9:
        Iterator<T> r103 = this.f123668e.iterator();
    L11:
        if (r103.hasNext() == false) goto L15;
        f.a r104 = (f.a) r103.next();
        if (r104 == null) goto L11;
        r104.a(r101);
        goto L11
    }

    @Override // com.bytedance.android.livesdk.feed.f
    public final void g(FeedDataKey r100, ItemRepository r101) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L14;
        a r102 = (a) ((ConcurrentHashMap) this.f123664a).get(r100);
        if (r102 != null) goto L9;
        r102 = new a(r101);
        ((ConcurrentHashMap) this.f123664a).put(r100, r102);
        this.f123665b.onNext(r100);
    L9:
        if (r102.f123669a == r101) goto L11;
        r102.f123669a = r101;
    L11:
        r102.f123670b++;
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.f
    public final boolean h(FeedDataKey r100, ItemRepository r101) {
        if (r100 == null) goto L16;
        if (r101 == null) goto L18;
        a r102 = (a) ((ConcurrentHashMap) this.f123664a).get(r100);
        if (r102 == null) goto L11;
        int r103 = r102.f123670b - 1;
        r102.f123670b = r103;
        if (r103 > 0) goto L11;
        ((ConcurrentHashMap) this.f123664a).remove(r100);
    L11:
        if (r102 != null) goto L13;
    L14:
        return true;
    L13:
        if (r102.f123670b == 0) goto L14;
        return false;
    L18:
        return false;
    L16:
        return false;
    }

    @Override // com.bytedance.android.livesdk.feed.f
    public final void a(String r100, List<FeedItem> r101, FeedExtra r102, boolean r103) {
        if (Lists.notEmpty(this.f123667d) == false) goto L8;
        Iterator<com.bytedance.android.livesdk.feed.feed.d> r104 = this.f123667d.iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        r104.next().a(r100, r101, r102, r103);
        goto L6
    L10:
        return;
    }
}

package com.bytedance.android.ec.store.product.presenter.baseinf;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/store/product/presenter/baseinf/EventTags;", "", "SECKILL_INFO", "RECOMMEND_INFO", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EventTags extends Enum<EventTags> {
    public static final EventTags RECOMMEND_INFO = null;
    public static final EventTags SECKILL_INFO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventTags[] f48294a = null;

    static {
        EventTags r100 = new EventTags("SECKILL_INFO", 0);
        SECKILL_INFO = r100;
        EventTags r101 = new EventTags("RECOMMEND_INFO", 1);
        RECOMMEND_INFO = r101;
        f48294a = new EventTags[]{r100, r101};
    }

    public static EventTags valueOf(String r100) {
        return (EventTags) a.a(EventTags.class, r100);
    }

    public static EventTags[] values() {
        return (EventTags[]) f48294a.clone();
    }

    public EventTags(String r100, int r101) {
        super(r100, r101);
    }
}

package com.bytedance.android.livesdk.livecommerce.event.refactor;

import kh2.e;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/event/refactor/RequestLivePromotions;", "", "Lkh2/e;", "", "value", "I", "getValue", "()Ljava/lang/Integer;", "YES", "NO", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RequestLivePromotions extends Enum<RequestLivePromotions> implements e<Integer> {
    public static final RequestLivePromotions NO = null;
    public static final RequestLivePromotions YES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RequestLivePromotions[] f147749a = null;
    private final int value;

    static {
        RequestLivePromotions r100 = new RequestLivePromotions("YES", 0, 1);
        YES = r100;
        RequestLivePromotions r101 = new RequestLivePromotions("NO", 1, 0);
        NO = r101;
        f147749a = new RequestLivePromotions[]{r100, r101};
    }

    public static RequestLivePromotions valueOf(String r100) {
        return (RequestLivePromotions) a.a(RequestLivePromotions.class, r100);
    }

    public static RequestLivePromotions[] values() {
        return (RequestLivePromotions[]) f147749a.clone();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kh2.e
    public Integer getValue() {
        return Integer.valueOf(this.value);
    }

    @Override // kh2.e
    public /* bridge */ /* synthetic */ Integer getValue() {
        return getValue();
    }

    public RequestLivePromotions(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

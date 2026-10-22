package com.bytedance.android.window.shop.repository.tab.entity;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/CardPosition;", "", EffectConstants.NORMAL, "GLOBAL", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CardPosition extends Enum<CardPosition> {
    public static final CardPosition GLOBAL = null;
    public static final CardPosition NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardPosition[] f189498a = null;

    static {
        CardPosition r100 = new CardPosition(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        CardPosition r101 = new CardPosition("GLOBAL", 1);
        GLOBAL = r101;
        f189498a = new CardPosition[]{r100, r101};
    }

    public static CardPosition valueOf(String r100) {
        return (CardPosition) r27.a.a(CardPosition.class, r100);
    }

    public static CardPosition[] values() {
        return (CardPosition[]) f189498a.clone();
    }

    public CardPosition(String r100, int r101) {
        super(r100, r101);
    }
}

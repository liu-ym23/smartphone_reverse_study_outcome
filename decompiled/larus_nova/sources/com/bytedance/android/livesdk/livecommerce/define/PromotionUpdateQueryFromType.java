package com.bytedance.android.livesdk.livecommerce.define;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/define/PromotionUpdateQueryFromType;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "FROM_CARD_WITH_LIST_CLOSE", "FROM_CARD_WITH_LIST_OPEN", "FROM_LIST_WITH_CARD_CLOSE", "FROM_LIST_WITH_CARD_OPEN", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PromotionUpdateQueryFromType extends Enum<PromotionUpdateQueryFromType> {
    public static final a Companion = null;
    public static final PromotionUpdateQueryFromType FROM_CARD_WITH_LIST_CLOSE = null;
    public static final PromotionUpdateQueryFromType FROM_CARD_WITH_LIST_OPEN = null;
    public static final PromotionUpdateQueryFromType FROM_LIST_WITH_CARD_CLOSE = null;
    public static final PromotionUpdateQueryFromType FROM_LIST_WITH_CARD_OPEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PromotionUpdateQueryFromType[] f147709a = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    static {
        PromotionUpdateQueryFromType r100 = new PromotionUpdateQueryFromType("FROM_CARD_WITH_LIST_CLOSE", 0, 1);
        FROM_CARD_WITH_LIST_CLOSE = r100;
        PromotionUpdateQueryFromType r101 = new PromotionUpdateQueryFromType("FROM_CARD_WITH_LIST_OPEN", 1, 2);
        FROM_CARD_WITH_LIST_OPEN = r101;
        PromotionUpdateQueryFromType r102 = new PromotionUpdateQueryFromType("FROM_LIST_WITH_CARD_CLOSE", 2, 3);
        FROM_LIST_WITH_CARD_CLOSE = r102;
        PromotionUpdateQueryFromType r103 = new PromotionUpdateQueryFromType("FROM_LIST_WITH_CARD_OPEN", 3, 4);
        FROM_LIST_WITH_CARD_OPEN = r103;
        f147709a = new PromotionUpdateQueryFromType[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static PromotionUpdateQueryFromType valueOf(String r100) {
        return (PromotionUpdateQueryFromType) r27.a.a(PromotionUpdateQueryFromType.class, r100);
    }

    public static PromotionUpdateQueryFromType[] values() {
        return (PromotionUpdateQueryFromType[]) f147709a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public PromotionUpdateQueryFromType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

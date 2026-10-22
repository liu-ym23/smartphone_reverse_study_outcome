package com.bytedance.android.ec.core.monitor.listener;

import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/core/monitor/listener/BuyNowNextPage;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "THIRD_PARTY", "VIRTUAL", "SCARCE_BUY", "MEMBER_SAMPLE_APPLY", "AUCTION_PRODUCT", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BuyNowNextPage extends Enum<BuyNowNextPage> {
    public static final BuyNowNextPage AUCTION_PRODUCT = null;
    public static final BuyNowNextPage MEMBER_SAMPLE_APPLY = null;
    public static final BuyNowNextPage SCARCE_BUY = null;
    public static final BuyNowNextPage THIRD_PARTY = null;
    public static final BuyNowNextPage VIRTUAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BuyNowNextPage[] f45175a = null;
    private final String value;

    static {
        BuyNowNextPage r100 = new BuyNowNextPage("THIRD_PARTY", 0, PriorityModule.SCENE_THIRD_PARTY);
        THIRD_PARTY = r100;
        BuyNowNextPage r101 = new BuyNowNextPage("VIRTUAL", 1, "virtual");
        VIRTUAL = r101;
        BuyNowNextPage r102 = new BuyNowNextPage("SCARCE_BUY", 2, "scarce_buy");
        SCARCE_BUY = r102;
        BuyNowNextPage r103 = new BuyNowNextPage("MEMBER_SAMPLE_APPLY", 3, "member_sample_apply");
        MEMBER_SAMPLE_APPLY = r103;
        BuyNowNextPage r104 = new BuyNowNextPage("AUCTION_PRODUCT", 4, "auction_product");
        AUCTION_PRODUCT = r104;
        f45175a = new BuyNowNextPage[]{r100, r101, r102, r103, r104};
    }

    public static BuyNowNextPage valueOf(String r100) {
        return (BuyNowNextPage) r27.a.a(BuyNowNextPage.class, r100);
    }

    public static BuyNowNextPage[] values() {
        return (BuyNowNextPage[]) f45175a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public BuyNowNextPage(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

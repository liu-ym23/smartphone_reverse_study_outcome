package com.bytedance.android.ec.common.api.card;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/common/api/card/ExternalCardPriority;", "", "", "value", "I", "getValue", "()I", "EXPLAIN_CARD_HIGH_PRIORITY", "EXTERNAL_CARD_HIGH_PRIORITY", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final enum ExternalCardPriority extends Enum<ExternalCardPriority> {
    public static final ExternalCardPriority EXPLAIN_CARD_HIGH_PRIORITY = null;
    public static final ExternalCardPriority EXTERNAL_CARD_HIGH_PRIORITY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExternalCardPriority[] f42826a = null;
    private final int value;

    static {
        ExternalCardPriority r100 = new ExternalCardPriority("EXPLAIN_CARD_HIGH_PRIORITY", 0, 0);
        EXPLAIN_CARD_HIGH_PRIORITY = r100;
        ExternalCardPriority r101 = new ExternalCardPriority("EXTERNAL_CARD_HIGH_PRIORITY", 1, 1);
        EXTERNAL_CARD_HIGH_PRIORITY = r101;
        f42826a = new ExternalCardPriority[]{r100, r101};
    }

    public static ExternalCardPriority valueOf(String r100) {
        return (ExternalCardPriority) a.a(ExternalCardPriority.class, r100);
    }

    public static ExternalCardPriority[] values() {
        return (ExternalCardPriority[]) f42826a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ExternalCardPriority(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

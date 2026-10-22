package com.bytedance.applet.aibridge.ecommerce.impl;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/applet/aibridge/ecommerce/impl/ECommerceProductCardPreloadGroup;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DISABLED", "CARD_EXPOSURE", "LATEST_NEW_MESSAGE", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ECommerceProductCardPreloadGroup extends Enum<ECommerceProductCardPreloadGroup> {
    public static final ECommerceProductCardPreloadGroup CARD_EXPOSURE = null;
    public static final a Companion = null;
    public static final ECommerceProductCardPreloadGroup DISABLED = null;
    public static final ECommerceProductCardPreloadGroup LATEST_NEW_MESSAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECommerceProductCardPreloadGroup[] f191107a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f191108b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ECommerceProductCardPreloadGroup> getEntries() {
        return f191108b;
    }

    static {
        ECommerceProductCardPreloadGroup r100 = new ECommerceProductCardPreloadGroup("DISABLED", 0, 0);
        DISABLED = r100;
        ECommerceProductCardPreloadGroup r101 = new ECommerceProductCardPreloadGroup("CARD_EXPOSURE", 1, 1);
        CARD_EXPOSURE = r101;
        ECommerceProductCardPreloadGroup r102 = new ECommerceProductCardPreloadGroup("LATEST_NEW_MESSAGE", 2, 2);
        LATEST_NEW_MESSAGE = r102;
        ECommerceProductCardPreloadGroup[] r103 = {r100, r101, r102};
        f191107a = r103;
        f191108b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static ECommerceProductCardPreloadGroup[] values() {
        return (ECommerceProductCardPreloadGroup[]) f191107a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ECommerceProductCardPreloadGroup valueOf(String r100) {
        return (ECommerceProductCardPreloadGroup) r27.a.a(ECommerceProductCardPreloadGroup.class, r100);
    }

    public ECommerceProductCardPreloadGroup(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

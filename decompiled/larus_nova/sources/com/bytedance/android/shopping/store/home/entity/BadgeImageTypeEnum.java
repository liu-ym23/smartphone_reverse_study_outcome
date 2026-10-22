package com.bytedance.android.shopping.store.home.entity;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/BadgeImageTypeEnum;", "", "UNKNOWN", "UPDATE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BadgeImageTypeEnum extends Enum<BadgeImageTypeEnum> {
    public static final BadgeImageTypeEnum UNKNOWN = null;
    public static final BadgeImageTypeEnum UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BadgeImageTypeEnum[] f183629a = null;

    static {
        BadgeImageTypeEnum r100 = new BadgeImageTypeEnum("UNKNOWN", 0);
        UNKNOWN = r100;
        BadgeImageTypeEnum r101 = new BadgeImageTypeEnum("UPDATE", 1);
        UPDATE = r101;
        f183629a = new BadgeImageTypeEnum[]{r100, r101};
    }

    public static BadgeImageTypeEnum valueOf(String r100) {
        return (BadgeImageTypeEnum) r27.a.a(BadgeImageTypeEnum.class, r100);
    }

    public static BadgeImageTypeEnum[] values() {
        return (BadgeImageTypeEnum[]) f183629a.clone();
    }

    public BadgeImageTypeEnum(String r100, int r101) {
        super(r100, r101);
    }
}

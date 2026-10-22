package com.bytedance.android.ec.store.repository.vo;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/TagType;", "", "", "type", "I", "getType", "()I", "RECOMMEND_INFO", "SERVICE_TAG", "MARKET_TAG", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TagType extends Enum<TagType> {
    public static final TagType MARKET_TAG = null;
    public static final TagType RECOMMEND_INFO = null;
    public static final TagType SERVICE_TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TagType[] f48450a = null;
    private final int type;

    static {
        TagType r100 = new TagType("RECOMMEND_INFO", 0, 1);
        RECOMMEND_INFO = r100;
        TagType r101 = new TagType("SERVICE_TAG", 1, 2);
        SERVICE_TAG = r101;
        TagType r102 = new TagType("MARKET_TAG", 2, 3);
        MARKET_TAG = r102;
        f48450a = new TagType[]{r100, r101, r102};
    }

    public static TagType valueOf(String r100) {
        return (TagType) r27.a.a(TagType.class, r100);
    }

    public static TagType[] values() {
        return (TagType[]) f48450a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public TagType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}

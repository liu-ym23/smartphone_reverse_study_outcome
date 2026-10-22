package com.bytedance.android.shopping.store.slicecard.dto;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/slicecard/dto/SliceTemplateType;", "", "", "type", "I", "getType", "()I", "GECKO", "API", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SliceTemplateType extends Enum<SliceTemplateType> {
    public static final SliceTemplateType API = null;
    public static final SliceTemplateType GECKO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SliceTemplateType[] f186334a = null;
    private final int type;

    static {
        SliceTemplateType r100 = new SliceTemplateType("GECKO", 0, 0);
        GECKO = r100;
        SliceTemplateType r101 = new SliceTemplateType("API", 1, 1);
        API = r101;
        f186334a = new SliceTemplateType[]{r100, r101};
    }

    public static SliceTemplateType valueOf(String r100) {
        return (SliceTemplateType) a.a(SliceTemplateType.class, r100);
    }

    public static SliceTemplateType[] values() {
        return (SliceTemplateType[]) f186334a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public SliceTemplateType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}

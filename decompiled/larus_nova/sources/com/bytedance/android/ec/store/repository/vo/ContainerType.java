package com.bytedance.android.ec.store.repository.vo;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/ContainerType;", "", "", "type", "I", "getType", "()I", "NO_CONTAINER", "FLOAT_LYNX_CONTAINER", "NATIVE_CONTAINER", "MARKETING_CONTAINER", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ContainerType extends Enum<ContainerType> {
    public static final ContainerType FLOAT_LYNX_CONTAINER = null;
    public static final ContainerType MARKETING_CONTAINER = null;
    public static final ContainerType NATIVE_CONTAINER = null;
    public static final ContainerType NO_CONTAINER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerType[] f48395a = null;
    private final int type;

    static {
        ContainerType r100 = new ContainerType("NO_CONTAINER", 0, 0);
        NO_CONTAINER = r100;
        ContainerType r101 = new ContainerType("FLOAT_LYNX_CONTAINER", 1, 1);
        FLOAT_LYNX_CONTAINER = r101;
        ContainerType r102 = new ContainerType("NATIVE_CONTAINER", 2, 3);
        NATIVE_CONTAINER = r102;
        ContainerType r103 = new ContainerType("MARKETING_CONTAINER", 3, 4);
        MARKETING_CONTAINER = r103;
        f48395a = new ContainerType[]{r100, r101, r102, r103};
    }

    public static ContainerType valueOf(String r100) {
        return (ContainerType) r27.a.a(ContainerType.class, r100);
    }

    public static ContainerType[] values() {
        return (ContainerType[]) f48395a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ContainerType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}

package com.bytedance.android.ec.store.repository.dto;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/store/repository/dto/ComponentTypes;", "", "", "type", "I", "getType", "()I", "Native", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ComponentTypes extends Enum<ComponentTypes> {
    public static final ComponentTypes Native = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComponentTypes[] f48390a = null;
    private final int type;

    static {
        ComponentTypes r100 = new ComponentTypes();
        Native = r100;
        f48390a = new ComponentTypes[]{r100};
    }

    public static ComponentTypes valueOf(String r100) {
        return (ComponentTypes) r27.a.a(ComponentTypes.class, r100);
    }

    public static ComponentTypes[] values() {
        return (ComponentTypes[]) f48390a.clone();
    }

    public ComponentTypes() {
        super("Native", 0);
        this.type = 1;
    }

    public final int getType() {
        return this.type;
    }
}

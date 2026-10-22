package com.bytedance.android.live.core.tetris.componentx.descriptor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/core/tetris/componentx/descriptor/ComponentXLayoutType;", "", "", "code", "I", "getCode", "()I", "XML", "CONSTRAINT", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ComponentXLayoutType extends Enum<ComponentXLayoutType> {
    public static final ComponentXLayoutType CONSTRAINT = null;
    public static final ComponentXLayoutType XML = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComponentXLayoutType[] f65530a = null;
    private final int code;

    static {
        ComponentXLayoutType r100 = new ComponentXLayoutType("XML", 0, 1);
        XML = r100;
        ComponentXLayoutType r101 = new ComponentXLayoutType("CONSTRAINT", 1, 2);
        CONSTRAINT = r101;
        f65530a = new ComponentXLayoutType[]{r100, r101};
    }

    public static ComponentXLayoutType valueOf(String r100) {
        return (ComponentXLayoutType) a.a(ComponentXLayoutType.class, r100);
    }

    public static ComponentXLayoutType[] values() {
        return (ComponentXLayoutType[]) f65530a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public ComponentXLayoutType(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}

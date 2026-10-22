package com.bytedance.android.livesdkapi.depend.model.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/DslTypeInt;", "", "value", "", "(Ljava/lang/String;IJ)V", "getValue", "()J", "DslTypeUndefined", "DslTypeSlice", "DslTypeLynxAir", "DslTypeLynx", "DslTypeSchema", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DslTypeInt extends Enum<DslTypeInt> {
    private static final /* synthetic */ DslTypeInt[] $VALUES = null;
    public static final DslTypeInt DslTypeLynx = null;
    public static final DslTypeInt DslTypeLynxAir = null;
    public static final DslTypeInt DslTypeSchema = null;
    public static final DslTypeInt DslTypeSlice = null;
    public static final DslTypeInt DslTypeUndefined = null;
    private final long value;

    static {
        DslTypeInt r100 = new DslTypeInt("DslTypeUndefined", 0, 0);
        DslTypeUndefined = r100;
        DslTypeInt r101 = new DslTypeInt("DslTypeSlice", 1, 1);
        DslTypeSlice = r101;
        DslTypeInt r102 = new DslTypeInt("DslTypeLynxAir", 2, 2);
        DslTypeLynxAir = r102;
        DslTypeInt r103 = new DslTypeInt("DslTypeLynx", 3, 3);
        DslTypeLynx = r103;
        DslTypeInt r104 = new DslTypeInt("DslTypeSchema", 4, 4);
        DslTypeSchema = r104;
        $VALUES = new DslTypeInt[]{r100, r101, r102, r103, r104};
    }

    public static DslTypeInt valueOf(String r100) {
        return (DslTypeInt) a.a(DslTypeInt.class, r100);
    }

    public static DslTypeInt[] values() {
        return (DslTypeInt[]) $VALUES.clone();
    }

    public final long getValue() {
        return this.value;
    }

    private DslTypeInt(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}

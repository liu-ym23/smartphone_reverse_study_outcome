package com.bytedance.android.ec.model.clientai;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/model/clientai/SimpleFeatureReturnType;", "", "RETURN_NUMERIC", "RETURN_STRING", "RETURN_DICT", "RETURN_SEQ", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum SimpleFeatureReturnType extends Enum<SimpleFeatureReturnType> {
    public static final SimpleFeatureReturnType RETURN_DICT = null;
    public static final SimpleFeatureReturnType RETURN_NUMERIC = null;
    public static final SimpleFeatureReturnType RETURN_SEQ = null;
    public static final SimpleFeatureReturnType RETURN_STRING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SimpleFeatureReturnType[] f47854a = null;

    static {
        SimpleFeatureReturnType r100 = new SimpleFeatureReturnType("RETURN_NUMERIC", 0);
        RETURN_NUMERIC = r100;
        SimpleFeatureReturnType r101 = new SimpleFeatureReturnType("RETURN_STRING", 1);
        RETURN_STRING = r101;
        SimpleFeatureReturnType r102 = new SimpleFeatureReturnType("RETURN_DICT", 2);
        RETURN_DICT = r102;
        SimpleFeatureReturnType r103 = new SimpleFeatureReturnType("RETURN_SEQ", 3);
        RETURN_SEQ = r103;
        f47854a = new SimpleFeatureReturnType[]{r100, r101, r102, r103};
    }

    public static SimpleFeatureReturnType valueOf(String r100) {
        return (SimpleFeatureReturnType) a.a(SimpleFeatureReturnType.class, r100);
    }

    public static SimpleFeatureReturnType[] values() {
        return (SimpleFeatureReturnType[]) f47854a.clone();
    }

    public SimpleFeatureReturnType(String r100, int r101) {
        super(r100, r101);
    }
}

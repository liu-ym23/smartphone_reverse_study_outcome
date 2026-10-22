package com.bytedance.android.ec.model.clientai;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/model/clientai/UserFeatureDataType;", "", "KV_STRING", "KV_NUMERIC", "SEQ_STRING", "SEQ_NUMERIC", "SEQ_DIC", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum UserFeatureDataType extends Enum<UserFeatureDataType> {
    public static final UserFeatureDataType KV_NUMERIC = null;
    public static final UserFeatureDataType KV_STRING = null;
    public static final UserFeatureDataType SEQ_DIC = null;
    public static final UserFeatureDataType SEQ_NUMERIC = null;
    public static final UserFeatureDataType SEQ_STRING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UserFeatureDataType[] f47855a = null;

    static {
        UserFeatureDataType r100 = new UserFeatureDataType("KV_STRING", 0);
        KV_STRING = r100;
        UserFeatureDataType r101 = new UserFeatureDataType("KV_NUMERIC", 1);
        KV_NUMERIC = r101;
        UserFeatureDataType r102 = new UserFeatureDataType("SEQ_STRING", 2);
        SEQ_STRING = r102;
        UserFeatureDataType r103 = new UserFeatureDataType("SEQ_NUMERIC", 3);
        SEQ_NUMERIC = r103;
        UserFeatureDataType r104 = new UserFeatureDataType("SEQ_DIC", 4);
        SEQ_DIC = r104;
        f47855a = new UserFeatureDataType[]{r100, r101, r102, r103, r104};
    }

    public static UserFeatureDataType valueOf(String r100) {
        return (UserFeatureDataType) a.a(UserFeatureDataType.class, r100);
    }

    public static UserFeatureDataType[] values() {
        return (UserFeatureDataType[]) f47855a.clone();
    }

    public UserFeatureDataType(String r100, int r101) {
        super(r100, r101);
    }
}

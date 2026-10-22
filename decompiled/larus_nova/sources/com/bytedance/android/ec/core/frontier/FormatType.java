package com.bytedance.android.ec.core.frontier;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/core/frontier/FormatType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "JSON", "PROTOBUF", "THRIFT", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FormatType extends Enum<FormatType> {
    public static final FormatType JSON = null;
    public static final FormatType PROTOBUF = null;
    public static final FormatType THRIFT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FormatType[] f44022a = null;
    private final String type;

    static {
        FormatType r100 = new FormatType("JSON", 0, "application/json");
        JSON = r100;
        FormatType r101 = new FormatType("PROTOBUF", 1, "application/vnd.google.protobuf");
        PROTOBUF = r101;
        FormatType r102 = new FormatType("THRIFT", 2, "thrift");
        THRIFT = r102;
        f44022a = new FormatType[]{r100, r101, r102};
    }

    public static FormatType valueOf(String r100) {
        return (FormatType) r27.a.a(FormatType.class, r100);
    }

    public static FormatType[] values() {
        return (FormatType[]) f44022a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public FormatType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}

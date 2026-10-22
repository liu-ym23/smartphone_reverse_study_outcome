package com.bytedance.android.ec.window.base;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/window/base/SyncType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "HISTORY_PRODUCT", "STORE_PRODUCT", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SyncType extends Enum<SyncType> {

    @SerializedName("101")
    public static final SyncType HISTORY_PRODUCT = null;

    @SerializedName("201")
    public static final SyncType STORE_PRODUCT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SyncType[] f49101a = null;
    private final String type;

    static {
        SyncType r100 = new SyncType("HISTORY_PRODUCT", 0, "101");
        HISTORY_PRODUCT = r100;
        SyncType r101 = new SyncType("STORE_PRODUCT", 1, "201");
        STORE_PRODUCT = r101;
        f49101a = new SyncType[]{r100, r101};
    }

    public static SyncType valueOf(String r100) {
        return (SyncType) a.a(SyncType.class, r100);
    }

    public static SyncType[] values() {
        return (SyncType[]) f49101a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public SyncType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }

    public /* synthetic */ SyncType(String r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = "";
    L5:
        this(r100, r101, r102);
    }
}

package com.bytedance.android.live.openplatform.impl.miniappanchor.api.response;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/CheckSellingPointRejectType;", "", "UNKNOWN", "SENSITIVE_WORDS", "FREQUENCY_LIMIT", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CheckSellingPointRejectType extends Enum<CheckSellingPointRejectType> {
    public static final CheckSellingPointRejectType FREQUENCY_LIMIT = null;
    public static final CheckSellingPointRejectType SENSITIVE_WORDS = null;
    public static final CheckSellingPointRejectType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CheckSellingPointRejectType[] f84101a = null;

    static {
        CheckSellingPointRejectType r100 = new CheckSellingPointRejectType("UNKNOWN", 0);
        UNKNOWN = r100;
        CheckSellingPointRejectType r101 = new CheckSellingPointRejectType("SENSITIVE_WORDS", 1);
        SENSITIVE_WORDS = r101;
        CheckSellingPointRejectType r102 = new CheckSellingPointRejectType("FREQUENCY_LIMIT", 2);
        FREQUENCY_LIMIT = r102;
        f84101a = new CheckSellingPointRejectType[]{r100, r101, r102};
    }

    public static CheckSellingPointRejectType valueOf(String r100) {
        return (CheckSellingPointRejectType) r27.a.a(CheckSellingPointRejectType.class, r100);
    }

    public static CheckSellingPointRejectType[] values() {
        return (CheckSellingPointRejectType[]) f84101a.clone();
    }

    public CheckSellingPointRejectType(String r100, int r101) {
        super(r100, r101);
    }
}

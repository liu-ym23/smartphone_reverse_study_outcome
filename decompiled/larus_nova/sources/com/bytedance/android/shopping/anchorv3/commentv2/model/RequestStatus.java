package com.bytedance.android.shopping.anchorv3.commentv2.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/commentv2/model/RequestStatus;", "", "", "status", "I", "getStatus", "()I", "STATUS_DEFAULT", "STATUS_REQUESTING", "STATUS_READY", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RequestStatus extends Enum<RequestStatus> {
    public static final RequestStatus STATUS_DEFAULT = null;
    public static final RequestStatus STATUS_READY = null;
    public static final RequestStatus STATUS_REQUESTING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RequestStatus[] f164728a = null;
    private final int status;

    static {
        RequestStatus r100 = new RequestStatus("STATUS_DEFAULT", 0, -1);
        STATUS_DEFAULT = r100;
        RequestStatus r101 = new RequestStatus("STATUS_REQUESTING", 1, 0);
        STATUS_REQUESTING = r101;
        RequestStatus r102 = new RequestStatus("STATUS_READY", 2, 1);
        STATUS_READY = r102;
        f164728a = new RequestStatus[]{r100, r101, r102};
    }

    public static RequestStatus valueOf(String r100) {
        return (RequestStatus) r27.a.a(RequestStatus.class, r100);
    }

    public static RequestStatus[] values() {
        return (RequestStatus[]) f164728a.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    public RequestStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}

package com.bytedance.android.gamecp.business.download.ai;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/gamecp/business/download/ai/Status;", "", "", "code", "I", "getCode", "()I", "ENABLE", "DISABLE", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Status extends Enum<Status> {
    public static final Status DISABLE = null;
    public static final Status ENABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Status[] f52460a = null;
    private final int code;

    static {
        Status r100 = new Status("ENABLE", 0, 1);
        ENABLE = r100;
        Status r101 = new Status("DISABLE", 1, 0);
        DISABLE = r101;
        f52460a = new Status[]{r100, r101};
    }

    public static Status valueOf(String r100) {
        return (Status) r27.a.a(Status.class, r100);
    }

    public static Status[] values() {
        return (Status[]) f52460a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public Status(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}

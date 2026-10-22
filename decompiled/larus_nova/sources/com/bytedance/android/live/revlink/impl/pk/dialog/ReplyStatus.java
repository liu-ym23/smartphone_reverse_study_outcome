package com.bytedance.android.live.revlink.impl.pk.dialog;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/ReplyStatus;", "", "", "value", "I", "getValue", "()I", "Undefined", "Accept", "Reject", "RefuseByTimeOut", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ReplyStatus extends Enum<ReplyStatus> {
    public static final ReplyStatus Accept = null;
    public static final ReplyStatus RefuseByTimeOut = null;
    public static final ReplyStatus Reject = null;
    public static final ReplyStatus Undefined = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplyStatus[] f95502a = null;
    private final int value;

    static {
        ReplyStatus r100 = new ReplyStatus("Undefined", 0, 0);
        Undefined = r100;
        ReplyStatus r101 = new ReplyStatus("Accept", 1, 1);
        Accept = r101;
        ReplyStatus r102 = new ReplyStatus("Reject", 2, 2);
        Reject = r102;
        ReplyStatus r103 = new ReplyStatus("RefuseByTimeOut", 3, 5);
        RefuseByTimeOut = r103;
        f95502a = new ReplyStatus[]{r100, r101, r102, r103};
    }

    public static ReplyStatus valueOf(String r100) {
        return (ReplyStatus) r27.a.a(ReplyStatus.class, r100);
    }

    public static ReplyStatus[] values() {
        return (ReplyStatus[]) f95502a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ReplyStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

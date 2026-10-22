package com.bytedance.android.shopping.anchorv3.commentv2.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/commentv2/model/EcCommentNpsExitReason;", "", "", "reason", "I", "getReason", "()I", "INVALID_REASON", "SUBMIT", "CLOSE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EcCommentNpsExitReason extends Enum<EcCommentNpsExitReason> {
    public static final EcCommentNpsExitReason CLOSE = null;
    public static final EcCommentNpsExitReason INVALID_REASON = null;
    public static final EcCommentNpsExitReason SUBMIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EcCommentNpsExitReason[] f164726a = null;
    private final int reason;

    static {
        EcCommentNpsExitReason r100 = new EcCommentNpsExitReason("INVALID_REASON", 0, -1);
        INVALID_REASON = r100;
        EcCommentNpsExitReason r101 = new EcCommentNpsExitReason("SUBMIT", 1, 0);
        SUBMIT = r101;
        EcCommentNpsExitReason r102 = new EcCommentNpsExitReason("CLOSE", 2, 1);
        CLOSE = r102;
        f164726a = new EcCommentNpsExitReason[]{r100, r101, r102};
    }

    public static EcCommentNpsExitReason valueOf(String r100) {
        return (EcCommentNpsExitReason) r27.a.a(EcCommentNpsExitReason.class, r100);
    }

    public static EcCommentNpsExitReason[] values() {
        return (EcCommentNpsExitReason[]) f164726a.clone();
    }

    public final int getReason() {
        return this.reason;
    }

    public EcCommentNpsExitReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.reason = r102;
    }
}

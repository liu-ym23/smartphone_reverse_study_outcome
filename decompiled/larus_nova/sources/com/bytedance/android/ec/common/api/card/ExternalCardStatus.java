package com.bytedance.android.ec.common.api.card;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/common/api/card/ExternalCardStatus;", "", "", "statusCode", "I", "getStatusCode", "()I", "UNINITIALIZED", "PENDING", "SCHEDULED", "LOADING", "ANIM_SHOWING", "SHOWING", "ANIM_HIDING", "FINISHED", "INTERRUPTED", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final enum ExternalCardStatus extends Enum<ExternalCardStatus> {
    public static final ExternalCardStatus ANIM_HIDING = null;
    public static final ExternalCardStatus ANIM_SHOWING = null;
    public static final ExternalCardStatus FINISHED = null;
    public static final ExternalCardStatus INTERRUPTED = null;
    public static final ExternalCardStatus LOADING = null;
    public static final ExternalCardStatus PENDING = null;
    public static final ExternalCardStatus SCHEDULED = null;
    public static final ExternalCardStatus SHOWING = null;
    public static final ExternalCardStatus UNINITIALIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExternalCardStatus[] f42827a = null;
    private final int statusCode;

    public static ExternalCardStatus valueOf(String r100) {
        return (ExternalCardStatus) a.a(ExternalCardStatus.class, r100);
    }

    public static ExternalCardStatus[] values() {
        return (ExternalCardStatus[]) f42827a.clone();
    }

    static {
        ExternalCardStatus r100 = new ExternalCardStatus("UNINITIALIZED", 0, 0);
        UNINITIALIZED = r100;
        ExternalCardStatus r101 = new ExternalCardStatus("PENDING", 1, 100);
        PENDING = r101;
        ExternalCardStatus r102 = new ExternalCardStatus("SCHEDULED", 2, 200);
        SCHEDULED = r102;
        ExternalCardStatus r103 = new ExternalCardStatus("LOADING", 3, 300);
        LOADING = r103;
        ExternalCardStatus r104 = new ExternalCardStatus("ANIM_SHOWING", 4, 400);
        ANIM_SHOWING = r104;
        ExternalCardStatus r105 = new ExternalCardStatus("SHOWING", 5, 500);
        SHOWING = r105;
        ExternalCardStatus r106 = new ExternalCardStatus("ANIM_HIDING", 6, 600);
        ANIM_HIDING = r106;
        ExternalCardStatus r107 = new ExternalCardStatus("FINISHED", 7, 700);
        FINISHED = r107;
        ExternalCardStatus r108 = new ExternalCardStatus("INTERRUPTED", 8, 800);
        INTERRUPTED = r108;
        f42827a = new ExternalCardStatus[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public ExternalCardStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.statusCode = r102;
    }
}

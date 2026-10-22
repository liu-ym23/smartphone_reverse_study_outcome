package com.bytedance.android.gamecp.business.download.custommade;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/gamecp/business/download/custommade/InstallerStep;", "", "", "state", "Ljava/lang/String;", "getState", "()Ljava/lang/String;", ErrorCode.INIT, "PREPARING", "INSTALLING", "CANCEL", "SUCCESS", "FAIL", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InstallerStep extends Enum<InstallerStep> {
    public static final InstallerStep CANCEL = null;
    public static final InstallerStep FAIL = null;
    public static final InstallerStep INIT = null;
    public static final InstallerStep INSTALLING = null;
    public static final InstallerStep PREPARING = null;
    public static final InstallerStep SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InstallerStep[] f52585a = null;
    private final String state;

    static {
        InstallerStep r100 = new InstallerStep(ErrorCode.INIT, 0, "init");
        INIT = r100;
        InstallerStep r101 = new InstallerStep("PREPARING", 1, "preparing");
        PREPARING = r101;
        InstallerStep r102 = new InstallerStep("INSTALLING", 2, "installing");
        INSTALLING = r102;
        InstallerStep r103 = new InstallerStep("CANCEL", 3, "cancel");
        CANCEL = r103;
        InstallerStep r104 = new InstallerStep("SUCCESS", 4, "success");
        SUCCESS = r104;
        InstallerStep r105 = new InstallerStep("FAIL", 5, "fail");
        FAIL = r105;
        f52585a = new InstallerStep[]{r100, r101, r102, r103, r104, r105};
    }

    public static InstallerStep valueOf(String r100) {
        return (InstallerStep) r27.a.a(InstallerStep.class, r100);
    }

    public static InstallerStep[] values() {
        return (InstallerStep[]) f52585a.clone();
    }

    public final String getState() {
        return this.state;
    }

    public InstallerStep(String r100, int r101, String r102) {
        super(r100, r101);
        this.state = r102;
    }
}

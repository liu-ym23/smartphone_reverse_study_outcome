package com.obric.autogui.session.state.a;

import com.obric.autogui.common.api.agent.BizStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StateIdle.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f31230a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f31231b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f31232c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ e[] f31233e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f31234d;

    private static final /* synthetic */ e[] b() {
        return new e[]{f31230a, f31231b, f31232c};
    }

    private e(String r1, int r2, int r3) {
        super(r1, r2);
        this.f31234d = r3;
    }

    public final int a() {
        return this.f31234d;
    }

    static {
        f31230a = new e("NORMAL", 0, 0);
        f31231b = new e("QUEUE_FAIL_NO_NETWORK", 1, BizStatus.StatusChangedReason.QUEUEING__EXEC_NO_NETWORK);
        f31232c = new e("QUEUE_FAIL_NOT_LOGGED_IN", 2, 1301);
        e[] r0 = b();
        f31233e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static e valueOf(String r2) {
        return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
    }

    public static e[] values() {
        return (e[]) ZeusTransformUtils.preCheckCast(f31233e.clone(), e[].class, "com.obric.aiagent.plugin");
    }
}

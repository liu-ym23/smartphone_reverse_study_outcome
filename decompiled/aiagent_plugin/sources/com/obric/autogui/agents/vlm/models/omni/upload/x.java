package com.obric.autogui.agents.vlm.models.omni.upload;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniUploadTaskLifecycle.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum x extends Enum<x> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f28880a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x f28881b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x f28882c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f28883d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ x[] f28884e = null;
    private static final /* synthetic */ d.d.a f = null;

    private static final /* synthetic */ x[] a() {
        return new x[]{f28880a, f28881b, f28882c, f28883d};
    }

    private x(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f28880a = new x("UNKNOWN", 0);
        f28881b = new x("RUNNING", 1);
        f28882c = new x("FINISH_REQUESTED", 2);
        f28883d = new x("FINISHED", 3);
        x[] r0 = a();
        f28884e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static x valueOf(String r2) {
        return (x) ZeusTransformUtils.preCheckCast(Enum.valueOf(x.class, r2), x.class, "com.obric.aiagent.plugin");
    }

    public static x[] values() {
        return (x[]) ZeusTransformUtils.preCheckCast(f28884e.clone(), x[].class, "com.obric.aiagent.plugin");
    }
}

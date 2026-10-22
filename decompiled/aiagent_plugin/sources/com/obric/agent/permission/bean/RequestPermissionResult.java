package com.obric.agent.permission.bean;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.b;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: RequestPermissionResult.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RequestPermissionResult {
    private final a state;
    private final String tipsMessage;

    /* JADX INFO: compiled from: RequestPermissionResult.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f15408a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f15409b = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ a[] f15410d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f15411e = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f15412c;

        private static final /* synthetic */ a[] a() {
            return new a[]{f15408a, f15409b};
        }

        private a(String r1, int r2, String r3) {
            super(r1, r2);
            this.f15412c = r3;
        }

        static {
            f15408a = new a("Unsupported", 0, "Unsupported");
            f15409b = new a("Supported", 1, "Supported");
            a[] r0 = a();
            f15410d = r0;
            f15411e = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f15410d.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    public static /* synthetic */ RequestPermissionResult copy$default(RequestPermissionResult r0, a r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.state;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.tipsMessage;
    L9:
        return r0.copy(r1, r2);
    }

    public final a component1() {
        return this.state;
    }

    public final String component2() {
        return this.tipsMessage;
    }

    public final RequestPermissionResult copy(a r1, String r2) {
        o.e(r1, "state");
        return new RequestPermissionResult(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RequestPermissionResult.class) == true) goto L8;
        return false;
    L8:
        RequestPermissionResult r6 = (RequestPermissionResult) ZeusTransformUtils.preCheckCast(r5, RequestPermissionResult.class, "com.obric.aiagent.plugin");
        if (this.state == r6.state) goto L12;
        return false;
    L12:
        if (o.a(this.tipsMessage, r6.tipsMessage) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.state.hashCode() * 31;
        String r1 = this.tipsMessage;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "RequestPermissionResult(state=" + this.state + ", tipsMessage=" + this.tipsMessage + ')';
    }

    public RequestPermissionResult(a r2, String r3) {
        o.e(r2, "state");
        this.state = r2;
        this.tipsMessage = r3;
    }

    public /* synthetic */ RequestPermissionResult(a r1, String r2, int r3, h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final a getState() {
        return this.state;
    }

    public final String getTipsMessage() {
        return this.tipsMessage;
    }
}

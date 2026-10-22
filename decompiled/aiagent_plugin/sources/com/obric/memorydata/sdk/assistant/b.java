package com.obric.memorydata.sdk.assistant;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: WindowState.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33806a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f33807b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f33808c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f33809d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f33810e = null;
    public static final b f = null;
    private static final /* synthetic */ b[] g = null;
    private static final /* synthetic */ d.d.a h = null;

    /* JADX INFO: compiled from: WindowState.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    private static final /* synthetic */ b[] a() {
        return new b[]{f33807b, f33808c, f33809d, f33810e, f};
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f33807b = new b("NA", 0);
        f33808c = new b("CHAT_WINDOW", 1);
        f33809d = new b("HALF_WINDOW", 2);
        f33810e = new b("FULL_SCREEN", 3);
        f = new b("INVISIBLE", 4);
        b[] r0 = a();
        g = r0;
        h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f33806a = new a(null);
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(g.clone(), b[].class, "com.obric.aiagent.plugin");
    }
}

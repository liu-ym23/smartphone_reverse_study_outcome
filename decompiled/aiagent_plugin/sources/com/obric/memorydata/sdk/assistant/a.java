package com.obric.memorydata.sdk.assistant;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: QueryType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0915a f33801a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f33802b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f33803c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f33804d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ a[] f33805e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: com.obric.memorydata.sdk.assistant.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: QueryType.kt */
    public static final class C0915a {
        public /* synthetic */ C0915a(h r1) {
            this();
        }

        private C0915a() {
        }
    }

    private static final /* synthetic */ a[] a() {
        return new a[]{f33802b, f33803c, f33804d};
    }

    private a(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f33802b = new a("NA", 0);
        f33803c = new a("AUDIO", 1);
        f33804d = new a("IM", 2);
        a[] r0 = a();
        f33805e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f33801a = new C0915a(null);
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f33805e.clone(), a[].class, "com.obric.aiagent.plugin");
    }
}

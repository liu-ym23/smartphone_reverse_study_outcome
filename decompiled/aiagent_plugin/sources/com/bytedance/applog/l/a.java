package com.bytedance.applog.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DefaultReportDropStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.bytedance.applog.util.a<b> f5695a = null;

    @Override // com.bytedance.applog.l.b
    public long b() {
        return 1209600000;
    }

    @Override // com.bytedance.applog.l.b
    public int c() {
        return -1;
    }

    public a() {
    }

    static {
        f5695a = new AnonymousClass1();
    }

    public static b a() {
        return (b) ZeusTransformUtils.preCheckCast(f5695a.c(new Object[0]), b.class, "com.obric.aiagent.plugin");
    }
}

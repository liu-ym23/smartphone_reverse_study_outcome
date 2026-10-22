package com.obric.autoaction.app.launcherpage.history.historydetail.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: HistoryDetailThoughtProcessCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends com.obric.autoaction.app.launcherpage.ui.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23869a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f23871c;

    /* JADX INFO: compiled from: HistoryDetailThoughtProcessCell.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f23869a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
        if (o.a(this.f23870b, r6.f23870b) == true) goto L12;
        return false;
    L12:
        if (this.f23871c == r6.f23871c) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f23870b.hashCode() * 31) + Integer.hashCode(this.f23871c);
    }

    public String toString() {
        return "HistoryDetailThoughtProcessData(content=" + this.f23870b + ", actionType=" + this.f23871c + ')';
    }

    public final String a() {
        return this.f23870b;
    }

    public final int b() {
        return this.f23871c;
    }

    public j(String r2, int r3) {
        o.e(r2, "content");
        this.f23870b = r2;
        this.f23871c = r3;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean a(com.obric.autoaction.app.launcherpage.ui.h r2) {
        com.obric.autoaction.app.launcherpage.ui.h r1 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r1, "other");
        return ZeusTransformUtils.instanceOf(r1, j.class);
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean b(com.obric.autoaction.app.launcherpage.ui.h r3) {
        com.obric.autoaction.app.launcherpage.ui.h r4 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r4, "other");
        return o.a(r4, this);
    }
}

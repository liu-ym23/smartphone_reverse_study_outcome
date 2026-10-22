package com.obric.autogui.agents.a.f;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ActionEffectResultModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26407a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f26408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f26409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f26410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f26411e;
    private final List<String> f;
    private final int g;

    /* JADX INFO: compiled from: ActionEffectResultModels.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f26407a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26408b, r6.f26408b) == true) goto L12;
        return false;
    L12:
        if (this.f26409c == r6.f26409c) goto L15;
        return false;
    L15:
        if (o.a(this.f26410d, r6.f26410d) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f26411e, r6.f26411e) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f, r6.f) == true) goto L24;
        return false;
    L24:
        if (this.g == r6.g) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.f26408b.hashCode() * 31) + this.f26409c.hashCode()) * 31) + this.f26410d.hashCode()) * 31) + this.f26411e.hashCode()) * 31) + this.f.hashCode()) * 31) + Integer.hashCode(this.g);
    }

    public String toString() {
        return "ActionEffectError(code=" + this.f26408b + ", reason=" + this.f26409c + ", actionType=" + this.f26410d + ", attemptId=" + this.f26411e + ", evidence=" + this.f + ", detectCount=" + this.g + ')';
    }

    public d(String r3, e r4, String r5, String r6, List<String> r7, int r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        o.e(r3, MonitorConstants.CODE);
        o.e(r4, "reason");
        o.e(r5, "actionType");
        o.e(r6, "attemptId");
        o.e(r9, "evidence");
        this.f26408b = r3;
        this.f26409c = r4;
        this.f26410d = r5;
        this.f26411e = r6;
        this.f = r9;
        this.g = r8;
    }

    public /* synthetic */ d(String r8, e r9, String r10, String r11, List r12, int r13, int r14, d.h.b.h r15) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        if ((r14 & 1) == 0) goto L5;
        r8 = "ACTION_EFFECT_CHECK_FAILED";
    L5:
        this(r8, r9, r10, r11, r5, r13);
    }

    public final String a() {
        return this.f26408b;
    }
}

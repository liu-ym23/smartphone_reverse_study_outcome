package com.obric.agent.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.o.k;
import java.util.List;

/* JADX INFO: compiled from: EventTaskUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14446a = null;

    static {
        f14446a = new b();
    }

    public static /* synthetic */ CharSequence lambda$WWXw8pZTaJidOcPwoiq5GtAgmq8(String r0) {
        return c(r0);
    }

    /* JADX INFO: renamed from: lambda$eKdEib36e-2Y4o-IqYHDipJA5Y4, reason: not valid java name */
    public static /* synthetic */ CharSequence m71lambda$eKdEib36e2Y4oIqYHDipJA5Y4(String r0) {
        return b(r0);
    }

    private b() {
    }

    public final String a(String r14) {
        o.e(r14, "text");
        List r13 = p.b(new String[]{"啊", "呀", "呢", "嘛", "吧", "啦", "嗯", "呗", "哇", "哈"});
        List r0 = p.b(new String[]{"豆包豆包", "给我", "帮我", "请", "让", "帮", "给", "AI 操作手机"});
        String r15 = new k("[\\p{Punct}，。！？、；：“”‘’（）《》【】]").a((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"), "");
        String r16 = new k(p.a((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$b$eKdEib36e2Y4oIqYHDipJA5Y4.INSTANCE, 30, null)).a((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"), "");
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(new k(p.a((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$b$WWXw8pZTaJidOcPwoiq5GtAgmq8.INSTANCE, 30, null)).a((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin"), ""), CharSequence.class, "com.obric.aiagent.plugin");
        return new k("\\s+").a(r17, "");
    }

    private static final CharSequence b(String r2) {
        o.e(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(k.f38646a.a(r2), CharSequence.class, "com.obric.aiagent.plugin");
    }

    private static final CharSequence c(String r2) {
        o.e(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(k.f38646a.a(r2), CharSequence.class, "com.obric.aiagent.plugin");
    }

    public final boolean a(String r2, String r3) {
        o.e(r2, "s1");
        o.e(r3, "s2");
        return d.o.o.a(a(r2), a(r3), true);
    }

    public final float b(String r9, String r10) {
        o.e(r9, "shortCut");
        o.e(r10, "originQuery");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L9;
        return -1.0f;
    L9:
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        int r2 = 0;
        int r3 = 0;
    L11:
        if (r2 >= r11.length()) goto L17;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), r11.charAt(r2), false, 2, null) == false) goto L15;
        r3 = r3 + 1;
    L15:
        r2 = r2 + 1;
        goto L11
    L17:
        return r3 / r10.length();
    L5:
        r8 = false;
        goto L6
    }
}

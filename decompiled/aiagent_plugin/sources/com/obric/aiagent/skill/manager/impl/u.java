package com.obric.aiagent.skill.manager.impl;

import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.Block;
import com.obric.aiagent.assistant.idl.bean.BlockContent;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.bean.TextBlock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;

/* JADX INFO: compiled from: GuiLinkInstallAttribution.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements com.obric.agent.im.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f20167a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f20168b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicReference<a> f20169c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Long> f20170d = null;

    /* JADX INFO: compiled from: GuiLinkInstallAttribution.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f20172b;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20171a, r8.f20171a) == true) goto L12;
            return false;
        L12:
            if (this.f20172b == r8.f20172b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f20171a.hashCode() * 31) + Long.hashCode(this.f20172b);
        }

        public String toString() {
            return "PendingAttribution(link=" + this.f20171a + ", expiresAtElapsedMs=" + this.f20172b + ')';
        }

        public a(String r2, long r3) {
            d.h.b.o.e(r2, "link");
            this.f20171a = r2;
            this.f20172b = r3;
        }

        public final String a() {
            return this.f20171a;
        }

        public final long b() {
            return this.f20172b;
        }
    }

    /* JADX INFO: compiled from: GuiLinkInstallAttribution.kt */
    /* synthetic */ class b extends d.h.b.l implements d.h.a.b<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f20173a = null;

        static {
            f20173a = new b();
        }

        b() {
            super(1, d.o.o.class, "trim", "trim(Ljava/lang/String;)Ljava/lang/String;", 1);
        }

        public final String a(String r2) {
            d.h.b.o.e(r2, "p0");
            return d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        }

        @Override // d.h.a.b
        public /* synthetic */ String invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: GuiLinkInstallAttribution.kt */
    /* synthetic */ class c extends d.h.b.l implements d.h.a.b<String, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f20174a = null;

        static {
            f20174a = new c();
        }

        c() {
            super(1, d.o.o.class, "isNotEmpty", "isNotEmpty(Ljava/lang/CharSequence;)Z", 1);
        }

        public final Boolean a(String r2) {
            d.h.b.o.e(r2, "p0");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
            boolean r1 = true;
        L7:
            return Boolean.valueOf(r1);
        L5:
            r1 = false;
            goto L7
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    @Override // com.obric.agent.im.d
    public void onReceiveMessage(IMMessage r1) {
        d.h.b.o.e(r1, "message");
    }

    @Override // com.obric.agent.im.d
    public void onRegenMessage(IMMessage r1) {
        d.h.b.o.e(r1, "message");
    }

    @Override // com.obric.agent.im.d
    public void onUpdateMessage(IMMessage r1) {
        d.h.b.o.e(r1, "message");
    }

    private u() {
    }

    @Override // com.obric.agent.im.d
    public void onInsertMessageList(List<IMMessage> r3) {
        com.obric.agent.im.d.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    static {
        f20167a = new u();
        f20168b = new AtomicBoolean(false);
        f20169c = new AtomicReference();
        f20170d = new ConcurrentHashMap();
    }

    public final void a(String r6) {
        d.h.b.o.e(r6, "link");
        a();
        String r5 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L9;
        f20169c.set(null);
        return;
    L9:
        f20169c.set(new a(r5, SystemClock.elapsedRealtime() + 600000));
        return;
    L5:
        r7 = false;
        goto L6
    }

    public final boolean a(List<String> r8) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "rootMessageIds");
        long r1 = SystemClock.elapsedRealtime();
        Iterator r9 = ((Map) ZeusTransformUtils.preCheckCast(f20170d, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L8;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin");
        long r5 = ((Number) ZeusTransformUtils.preCheckCast(r3.getValue(), Number.class, "com.obric.aiagent.plugin")).longValue();
        if (r1 < r5) goto L4;
        f20170d.remove(r4, Long.valueOf(r5));
        goto L4
    L8:
        Iterator r10 = d.n.m.j(d.n.m.a(d.n.m.d(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(b.f20173a, d.h.a.b.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(c.f20174a, d.h.a.b.class, "com.obric.aiagent.plugin"))).a();
    L10:
        if (r10.hasNext() == false) goto L17;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin");
        Long r12 = (Long) ZeusTransformUtils.preCheckCast(f20170d.remove(r11), Long.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L10;
        if (r1 >= r12.longValue()) goto L10;
        return true;
    L17:
        return false;
    }

    @Override // com.obric.agent.im.d
    public void onSendMessage(IMMessage r8) {
        d.h.b.o.e(r8, "message");
        if (r8.getUserType() == 1) goto L5;
        return;
    L5:
        if (r8.getMessageStatusLocal() == 11) goto L7;
        return;
    L7:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8.getMessageId(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L38;
    L9:
        AtomicReference<a> r0 = f20169c;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r0.get(), a.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        long r3 = SystemClock.elapsedRealtime();
        if (r3 >= r1.b()) goto L15;
        if (a(r8) == false) goto L39;
        if (a(r8, r1.a()) == false) goto L40;
        if (r0.compareAndSet(r1, null) == false) goto L9;
        ((Map) ZeusTransformUtils.preCheckCast(f20170d, Map.class, "com.obric.aiagent.plugin")).put(r8.getMessageId(), Long.valueOf(r3 + 600000));
        return;
    L40:
        return;
    L39:
        return;
    L15:
        if (r0.compareAndSet(r1, null) == false) goto L9;
        return;
    L11:
        return;
    }

    private final void a() {
        if (f20168b.compareAndSet(false, true) == false) goto L6;
        com.obric.agent.im.a.f14573a.c((com.obric.agent.im.d) ZeusTransformUtils.preCheckCast(this, com.obric.agent.im.d.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final boolean a(IMMessage r6) {
        Map<String, String> r5 = r6.getExt();
        if (r5 == null) goto L33;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r5.get("o_omni_init_skill_ids"), String.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L33;
        boolean r2 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r7 = null;
    L10:
        if (r7 == null) goto L33;
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L26
        JSONArray r1 = new JSONArray(r7);     // Catch: Throwable -> L26
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(d.l.n.b(0, r1.length()), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L15;
    L17:
        Iterator r9 = r8.iterator();     // Catch: Throwable -> L26
    L19:
        if (r9.hasNext() == false) goto L23;
        if (d.h.b.o.a(r1.optString(((d.a.al) ZeusTransformUtils.preCheckCast(r9, d.a.al.class, "com.obric.aiagent.plugin")).a()), "skill-installer") == false) goto L19;
    L24:
        Object r10 = d.n.f(Boolean.valueOf(r2));     // Catch: Throwable -> L26
    L29:
        if (d.n.b(r10) == false) goto L32;
        r10 = false;
    L32:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L23:
        r2 = false;
        goto L24
    L15:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L17;
    L26:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        r10 = d.n.f(d.o.a(th));
    L33:
        return false;
    }

    private final boolean a(IMMessage r8, String r9) {
        List<Block> r7 = r8.getContentBlock();
        if (r7 == null) goto L26;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L7;
    L9:
        Iterator r11 = r10.iterator();
    L11:
        if (r11.hasNext() == false) goto L8;
        BlockContent r5 = ((Block) ZeusTransformUtils.preCheckCast(r11.next(), Block.class, "com.obric.aiagent.plugin")).getContent();
        if (r5 == null) goto L21;
        TextBlock r6 = r5.getTextBlock();
        if (r6 == null) goto L21;
        String r12 = r6.text;
        if (r12 == null) goto L21;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) != true) goto L21;
        boolean r13 = true;
    L22:
        if (r13 == false) goto L11;
        boolean r14 = true;
    L24:
        if (r14 != true) goto L26;
        boolean r15 = true;
    L27:
        if (r15 == false) goto L29;
        return true;
    L29:
        String r16 = r8.getContent();
        if (r16 == null) goto L35;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) != true) goto L35;
        return true;
    L35:
        return false;
    L21:
        r13 = false;
    L8:
        r14 = false;
        goto L24
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L9;
    L26:
        r15 = false;
        goto L27
    }
}

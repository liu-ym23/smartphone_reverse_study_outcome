package com.obric.agent;

import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: IMMessageCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {
    private static final String TAG = "IMMessageCache";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f15187a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f15188b = null;

    /* JADX INFO: compiled from: IMMessageCache.kt */
    public static abstract class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f15189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConcurrentHashMap<K, V> f15190b;

        public abstract K c();

        public a(int r1) {
            this.f15189a = r1;
            this.f15190b = new ConcurrentHashMap();
        }

        public final ConcurrentHashMap<K, V> a() {
            return this.f15190b;
        }

        public final void a(K r4, V r5) {
            if (((Map) ZeusTransformUtils.preCheckCast(this.f15190b, Map.class, "com.obric.aiagent.plugin")).containsKey(r4) == false) goto L6;
            ((Map) ZeusTransformUtils.preCheckCast(this.f15190b, Map.class, "com.obric.aiagent.plugin")).put(r4, r5);
            return;
        L6:
            ((Map) ZeusTransformUtils.preCheckCast(this.f15190b, Map.class, "com.obric.aiagent.plugin")).put(r4, r5);
        L8:
            if (this.f15190b.size() <= this.f15189a) goto L12;
            K r6 = c();
            if (r6 == null) goto L8;
            this.f15190b.remove(r6);
            goto L8
        }

        public final V a(K r3) {
            return (V) ((Map) ZeusTransformUtils.preCheckCast(this.f15190b, Map.class, "com.obric.aiagent.plugin")).get(r3);
        }

        public final Collection<V> b() {
            Collection<V> r1 = this.f15190b.values();
            d.h.b.o.c(r1, "<get-values>(...)");
            return r1;
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((IMMessage) ZeusTransformUtils.preCheckCast(r2, IMMessage.class, "com.obric.aiagent.plugin")).getLocalIndex()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((IMMessage) ZeusTransformUtils.preCheckCast(r3, IMMessage.class, "com.obric.aiagent.plugin")).getLocalIndex()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: IMMessageCache.kt */
    public static final class c extends a<String, IMMessage> {
        c() {
            super(10);
        }

        @Override // com.obric.agent.j.a
        public /* synthetic */ String c() {
            return d();
        }

        public String d() {
            Set<Map.Entry<String, IMMessage>> r0 = a().entrySet();
            d.h.b.o.c(r0, "<get-entries>(...)");
            Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r3 = r1.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            r2.add(Long.valueOf(((IMMessage) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), IMMessage.class, "com.obric.aiagent.plugin")).getLocalIndex()));
            goto L4
        L6:
            List r4 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
            Set<Map.Entry<String, IMMessage>> r10 = a().entrySet();
            d.h.b.o.c(r10, "<get-entries>(...)");
            Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
            if (r11.hasNext() == true) goto L9;
            Object r5 = null;
        L18:
            Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5, Map.Entry.class, "com.obric.aiagent.plugin");
            ISecureLogDepend.Companion r6 = ISecureLogDepend.Companion;
            StringBuilder r7 = new StringBuilder().append("getEldestKey called, eldest localIndex: ");
            if (r12 == null) goto L23;
            IMMessage r8 = (IMMessage) ZeusTransformUtils.preCheckCast(r12.getValue(), IMMessage.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L23;
            Long r9 = Long.valueOf(r8.getLocalIndex());
        L24:
            r6.i(j.TAG, r7.append(r9).append(", indexList: ").append(r4).toString());
            if (r12 != null) goto L27;
            return null;
        L27:
            return (String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.aiagent.plugin");
        L23:
            r9 = null;
            goto L24
        L9:
            r5 = r11.next();
            if (r11.hasNext() == false) goto L18;
            long r13 = ((IMMessage) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r5, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), IMMessage.class, "com.obric.aiagent.plugin")).getLocalIndex();
        L13:
            Object r14 = r11.next();
            long r15 = ((IMMessage) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r14, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), IMMessage.class, "com.obric.aiagent.plugin")).getLocalIndex();
            if (r13 <= r15) goto L17;
            r5 = r14;
            r13 = r15;
        L17:
            if (r11.hasNext() == true) goto L13;
            goto L18
        }
    }

    private j() {
    }

    static {
        f15187a = new j();
        f15188b = new c();
    }

    public final IMMessage a(String r6) {
        d.h.b.o.e(r6, "messageId");
        c r5 = f15188b;
        ISecureLogDepend.Companion.i(TAG, "get called, question:" + ((IMMessage) ZeusTransformUtils.preCheckCast(r5.a(r6), IMMessage.class, "com.obric.aiagent.plugin")));
        return (IMMessage) ZeusTransformUtils.preCheckCast(r5.a(r6), IMMessage.class, "com.obric.aiagent.plugin");
    }

    public final List<IMMessage> b(String r6) {
        d.h.b.o.e(r6, "collectionId");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == true) goto L8;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(f15188b.b(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r7.iterator();
    L11:
        if (r8.hasNext() == false) goto L20;
        Object r2 = r8.next();
        Map<String, String> r3 = ((IMMessage) ZeusTransformUtils.preCheckCast(r2, IMMessage.class, "com.obric.aiagent.plugin")).getExt();
        if (r3 == null) goto L15;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.get("collection_id"), String.class, "com.obric.aiagent.plugin");
    L17:
        if (d.h.b.o.a(r4, r6) == false) goto L11;
        r1.add(r2);
        goto L11
    L15:
        r4 = null;
        goto L17
    L20:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.aiagent.plugin"));
    L8:
        return d.a.p.b();
    L5:
        r5 = false;
        goto L6
    }

    public final void a(IMMessage r3) {
        d.h.b.o.e(r3, "message");
        if (r3.getMessageStatusLocal() != 11) goto L6;
        c(r3);
        return;
    }

    public final void b(IMMessage r3) {
        d.h.b.o.e(r3, "message");
        if (r3.getMessageStatusLocal() != 11) goto L6;
        c(r3);
        return;
    }

    private final void c(IMMessage r2) {
        String r1 = r2.getMessageId();
        if (w.a(r1) == false) goto L6;
        f15188b.a(r1, r2);
        return;
    }
}

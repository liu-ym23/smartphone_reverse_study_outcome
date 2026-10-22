package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import o6.C5009a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011¢\u0006\u0004\b\u0012\u0010\u0013J5\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0010J\u0015\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\bR\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/H;", "", "<init>", "()V", "", "taskId", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/H$a;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/H$a;", "", "status", "title", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "liveId", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "f", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "memory", "e", "(Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/H$a;)V", "c", "MMKV_ID", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "memories", "Ljava/util/concurrent/ConcurrentHashMap;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class H {
    private static final String MMKV_ID = "alipay_xui_island_seen";
    public static final H INSTANCE = new H();
    private static final ConcurrentHashMap<String, Memory> memories = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJB\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0019\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001a\u0010\u000fR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/H$a;", "", "", "status", "", "title", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "liveId", "", AlipayXuiIsland.REASON_CLOSED, "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", Const.INTENT_KEY_APIKEY, "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/H$a;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "I", "f", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_UMID, "e", "Z", "c", "()Z", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.alipay.H$a, reason: from toString */
    public static final /* data */ class Memory {
        private final boolean closed;
        private final String content;
        private final String liveId;
        private final int status;
        private final String title;

        public Memory(int i10, String title, String content, String liveId, boolean z10) {
            kotlin.jvm.internal.p.i(title, "title");
            kotlin.jvm.internal.p.i(content, "content");
            kotlin.jvm.internal.p.i(liveId, "liveId");
            this.status = i10;
            this.title = title;
            this.content = content;
            this.liveId = liveId;
            this.closed = z10;
        }

        public static /* synthetic */ Memory b(Memory memory, int i10, String str, String str2, String str3, boolean z10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = memory.status;
            }
            if ((i11 & 2) != 0) {
                str = memory.title;
            }
            if ((i11 & 4) != 0) {
                str2 = memory.content;
            }
            if ((i11 & 8) != 0) {
                str3 = memory.liveId;
            }
            if ((i11 & 16) != 0) {
                z10 = memory.closed;
            }
            boolean z11 = z10;
            String str4 = str2;
            return memory.a(i10, str, str4, str3, z11);
        }

        public final Memory a(int status, String title, String content, String liveId, boolean closed) {
            kotlin.jvm.internal.p.i(title, "title");
            kotlin.jvm.internal.p.i(content, "content");
            kotlin.jvm.internal.p.i(liveId, "liveId");
            return new Memory(status, title, content, liveId, closed);
        }

        /* renamed from: c, reason: from getter */
        public final boolean getClosed() {
            return this.closed;
        }

        /* renamed from: d, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: e, reason: from getter */
        public final String getLiveId() {
            return this.liveId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Memory)) {
                return false;
            }
            Memory memory = (Memory) other;
            return this.status == memory.status && kotlin.jvm.internal.p.d(this.title, memory.title) && kotlin.jvm.internal.p.d(this.content, memory.content) && kotlin.jvm.internal.p.d(this.liveId, memory.liveId) && this.closed == memory.closed;
        }

        /* renamed from: f, reason: from getter */
        public final int getStatus() {
            return this.status;
        }

        /* renamed from: g, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.status) * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31) + this.liveId.hashCode()) * 31) + Boolean.hashCode(this.closed);
        }

        public String toString() {
            return "Memory(status=" + this.status + ", title=" + this.title + ", content=" + this.content + ", liveId=" + this.liveId + ", closed=" + this.closed + ")";
        }
    }

    public final void a(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        Memory memoryD = d(taskId);
        if (memoryD == null || memoryD.getClosed()) {
            return;
        }
        Memory memoryB = Memory.b(memoryD, 0, null, null, null, true, 15, null);
        memories.put(taskId, memoryB);
        e(taskId, memoryB);
    }

    public final List<Memory> b() {
        Collection<Memory> collectionValues = memories.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            Memory memory = (Memory) obj;
            if (memory.getClosed() && AlipayXuiIsland.INSTANCE.n(Integer.valueOf(memory.getStatus()))) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final Memory c(String taskId) {
        Object objB;
        Object objB2;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(C5009a.v(C5009a.INSTANCE, MMKV_ID, taskId, null, 4, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null || La.H.x0(str)) {
            return null;
        }
        try {
            objB2 = Result.b((Memory) N5.k.INSTANCE.b().fromJson(str, Memory.class));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        return (Memory) (Result.g(objB2) ? null : objB2);
    }

    public final Memory d(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if (taskId.length() == 0) {
            return null;
        }
        ConcurrentHashMap<String, Memory> concurrentHashMap = memories;
        Memory memory = concurrentHashMap.get(taskId);
        if (memory != null) {
            return memory;
        }
        Memory memoryC = c(taskId);
        if (memoryC == null) {
            return null;
        }
        Memory memoryPutIfAbsent = concurrentHashMap.putIfAbsent(taskId, memoryC);
        return memoryPutIfAbsent == null ? memoryC : memoryPutIfAbsent;
    }

    public final void e(String taskId, Memory memory) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(N5.k.INSTANCE.b().toJson(memory));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null) {
            return;
        }
        try {
            Result.b(Boolean.valueOf(C5009a.INSTANCE.H(MMKV_ID, taskId, str)));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.b(C4849c.a(th2));
        }
    }

    public final void f(String taskId, int status, String title, String content, String liveId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(liveId, "liveId");
        if (taskId.length() == 0) {
            return;
        }
        Memory memory = new Memory(status, title, content, liveId, true);
        memories.put(taskId, memory);
        e(taskId, memory);
    }

    public final void g(String taskId, int status, String title, String content, String liveId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(liveId, "liveId");
        if (taskId.length() == 0) {
            return;
        }
        Memory memory = new Memory(status, title, content, liveId, false);
        memories.put(taskId, memory);
        e(taskId, memory);
    }
}

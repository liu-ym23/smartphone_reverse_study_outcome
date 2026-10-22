package com.stepos.ailauncher.agent.receiver;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.b;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/agent/receiver/b;", "", "<init>", "()V", "", "sessionId", "", "addImageCount", "addFileCount", "addVideoCount", "Lcom/stepos/ailauncher/agent/receiver/b$a;", "c", "(Ljava/lang/String;III)Lcom/stepos/ailauncher/agent/receiver/b$a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Lcom/stepos/ailauncher/agent/receiver/b$a;", "Ljava/util/concurrent/ConcurrentHashMap;", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final b INSTANCE = new b();
    private static final ConcurrentHashMap<String, DeleteCount> cache = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/agent/receiver/b$a;", "", "", "imageCount", "videoCount", "fileCount", "<init>", "(III)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "(III)Lcom/stepos/ailauncher/agent/receiver/b$a;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "c", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.receiver.b$a, reason: from toString */
    public static final /* data */ class DeleteCount {
        private final int fileCount;
        private final int imageCount;
        private final int videoCount;

        public DeleteCount() {
            this(0, 0, 0, 7, null);
        }

        public final DeleteCount a(int imageCount, int videoCount, int fileCount) {
            return new DeleteCount(imageCount, videoCount, fileCount);
        }

        /* renamed from: b, reason: from getter */
        public final int getFileCount() {
            return this.fileCount;
        }

        /* renamed from: c, reason: from getter */
        public final int getImageCount() {
            return this.imageCount;
        }

        /* renamed from: d, reason: from getter */
        public final int getVideoCount() {
            return this.videoCount;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DeleteCount)) {
                return false;
            }
            DeleteCount deleteCount = (DeleteCount) other;
            return this.imageCount == deleteCount.imageCount && this.videoCount == deleteCount.videoCount && this.fileCount == deleteCount.fileCount;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.imageCount) * 31) + Integer.hashCode(this.videoCount)) * 31) + Integer.hashCode(this.fileCount);
        }

        public String toString() {
            return "DeleteCount(imageCount=" + this.imageCount + ", videoCount=" + this.videoCount + ", fileCount=" + this.fileCount + ")";
        }

        public DeleteCount(int i10, int i11, int i12) {
            this.imageCount = i10;
            this.videoCount = i11;
            this.fileCount = i12;
        }

        public /* synthetic */ DeleteCount(int i10, int i11, int i12, int i13, i iVar) {
            this((i13 & 1) != 0 ? 0 : i10, (i13 & 2) != 0 ? 0 : i11, (i13 & 4) != 0 ? 0 : i12);
        }
    }

    public static /* synthetic */ DeleteCount d(b bVar, String str, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 8) != 0) {
            i12 = 0;
        }
        return bVar.c(str, i10, i11, i12);
    }

    public static final DeleteCount e(int i10, int i11, int i12, String str, DeleteCount deleteCount) {
        p.i(str, "<unused var>");
        if (deleteCount == null) {
            deleteCount = new DeleteCount(0, 0, 0, 7, null);
        }
        return deleteCount.a(deleteCount.getImageCount() + i10, deleteCount.getVideoCount() + i11, deleteCount.getFileCount() + i12);
    }

    public static final DeleteCount f(p9.p pVar, Object obj, Object obj2) {
        return (DeleteCount) pVar.invoke(obj, obj2);
    }

    public final DeleteCount c(String sessionId, final int addImageCount, final int addFileCount, final int addVideoCount) {
        p.i(sessionId, "sessionId");
        ConcurrentHashMap<String, DeleteCount> concurrentHashMap = cache;
        final p9.p pVar = new p9.p() { // from class: a5.c
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return com.stepos.ailauncher.agent.receiver.b.e(addImageCount, addVideoCount, addFileCount, (String) obj, (b.DeleteCount) obj2);
            }
        };
        DeleteCount deleteCountCompute = concurrentHashMap.compute(sessionId, new BiFunction() { // from class: a5.d
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return com.stepos.ailauncher.agent.receiver.b.f(pVar, obj, obj2);
            }
        });
        if (deleteCountCompute != null) {
            return deleteCountCompute;
        }
        return new DeleteCount(0, 0, 0, 7, null);
    }

    public final DeleteCount g(String sessionId) {
        p.i(sessionId, "sessionId");
        return cache.remove(sessionId);
    }
}

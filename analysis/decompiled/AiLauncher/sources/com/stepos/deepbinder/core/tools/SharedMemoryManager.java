package com.stepos.deepbinder.core.tools;

import android.util.Pair;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.ktor.http.ContentDisposition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0003\u0010\u0011\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fJ$\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nR \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/stepos/deepbinder/core/tools/SharedMemoryManager;", "", "<init>", "()V", "memoryBlockQueueMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/stepos/deepbinder/core/tools/SharedMemoryManager$MemoryBlock;", "readData", "", "pair", "Landroid/util/Pair;", "writeData", "key", "data", "FlagDef", "MemoryBlock", "Companion", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SharedMemoryManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int FLAG_EMPTY = 0;
    public static final int FLAG_END = -1;
    public static final int FLAG_FULL = 1;
    private static final String TAG = "SharedMemoryManager";
    private static volatile SharedMemoryManager instance;
    private final ConcurrentHashMap<Integer, ConcurrentLinkedQueue<MemoryBlock>> memoryBlockQueueMap;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stepos/deepbinder/core/tools/SharedMemoryManager$Companion;", "", "<init>", "()V", "TAG", "", "FLAG_EMPTY", "", "FLAG_FULL", "FLAG_END", "instance", "Lcom/stepos/deepbinder/core/tools/SharedMemoryManager;", "getInstance", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final SharedMemoryManager getInstance() {
            SharedMemoryManager sharedMemoryManager;
            SharedMemoryManager sharedMemoryManager2 = SharedMemoryManager.instance;
            if (sharedMemoryManager2 != null) {
                return sharedMemoryManager2;
            }
            synchronized (this) {
                sharedMemoryManager = SharedMemoryManager.instance;
                if (sharedMemoryManager == null) {
                    sharedMemoryManager = new SharedMemoryManager(null);
                    SharedMemoryManager.instance = sharedMemoryManager;
                }
            }
            return sharedMemoryManager;
        }

        private Companion() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/deepbinder/core/tools/SharedMemoryManager$FlagDef;", "", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface FlagDef {
    }

    public /* synthetic */ SharedMemoryManager(i iVar) {
        this();
    }

    public static final SharedMemoryManager getInstance() {
        return INSTANCE.getInstance();
    }

    public final byte[] readData(Pair<Integer, Integer> pair) {
        p.i(pair, "pair");
        return null;
    }

    public final Pair<Integer, Integer> writeData(int key, byte[] data) {
        p.i(data, "data");
        return null;
    }

    private SharedMemoryManager() {
        this.memoryBlockQueueMap = new ConcurrentHashMap<>();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J3\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006 "}, d2 = {"Lcom/stepos/deepbinder/core/tools/SharedMemoryManager$MemoryBlock;", "", "offset", "", ContentDisposition.Parameters.Size, "next", "flag", "<init>", "(IILcom/stepos/deepbinder/core/tools/SharedMemoryManager$MemoryBlock;I)V", "getOffset", "()I", "setOffset", "(I)V", "getSize", "setSize", "getNext", "()Lcom/stepos/deepbinder/core/tools/SharedMemoryManager$MemoryBlock;", "setNext", "(Lcom/stepos/deepbinder/core/tools/SharedMemoryManager$MemoryBlock;)V", "getFlag", "setFlag", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class MemoryBlock {
        private int flag;
        private MemoryBlock next;
        private int offset;
        private int size;

        public MemoryBlock(int i10, int i11, MemoryBlock memoryBlock, int i12) {
            this.offset = i10;
            this.size = i11;
            this.next = memoryBlock;
            this.flag = i12;
        }

        public static /* synthetic */ MemoryBlock copy$default(MemoryBlock memoryBlock, int i10, int i11, MemoryBlock memoryBlock2, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i10 = memoryBlock.offset;
            }
            if ((i13 & 2) != 0) {
                i11 = memoryBlock.size;
            }
            if ((i13 & 4) != 0) {
                memoryBlock2 = memoryBlock.next;
            }
            if ((i13 & 8) != 0) {
                i12 = memoryBlock.flag;
            }
            return memoryBlock.copy(i10, i11, memoryBlock2, i12);
        }

        /* renamed from: component1, reason: from getter */
        public final int getOffset() {
            return this.offset;
        }

        /* renamed from: component2, reason: from getter */
        public final int getSize() {
            return this.size;
        }

        /* renamed from: component3, reason: from getter */
        public final MemoryBlock getNext() {
            return this.next;
        }

        /* renamed from: component4, reason: from getter */
        public final int getFlag() {
            return this.flag;
        }

        public final MemoryBlock copy(int offset, int size, MemoryBlock next, int flag) {
            return new MemoryBlock(offset, size, next, flag);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MemoryBlock)) {
                return false;
            }
            MemoryBlock memoryBlock = (MemoryBlock) other;
            return this.offset == memoryBlock.offset && this.size == memoryBlock.size && p.d(this.next, memoryBlock.next) && this.flag == memoryBlock.flag;
        }

        public final int getFlag() {
            return this.flag;
        }

        public final MemoryBlock getNext() {
            return this.next;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final int getSize() {
            return this.size;
        }

        public int hashCode() {
            int iHashCode = ((Integer.hashCode(this.offset) * 31) + Integer.hashCode(this.size)) * 31;
            MemoryBlock memoryBlock = this.next;
            return ((iHashCode + (memoryBlock == null ? 0 : memoryBlock.hashCode())) * 31) + Integer.hashCode(this.flag);
        }

        public final void setFlag(int i10) {
            this.flag = i10;
        }

        public final void setNext(MemoryBlock memoryBlock) {
            this.next = memoryBlock;
        }

        public final void setOffset(int i10) {
            this.offset = i10;
        }

        public final void setSize(int i10) {
            this.size = i10;
        }

        public String toString() {
            return "MemoryBlock(offset=" + this.offset + ", size=" + this.size + ", next=" + this.next + ", flag=" + this.flag + ")";
        }

        public /* synthetic */ MemoryBlock(int i10, int i11, MemoryBlock memoryBlock, int i12, int i13, i iVar) {
            this(i10, (i13 & 2) != 0 ? 0 : i11, (i13 & 4) != 0 ? null : memoryBlock, (i13 & 8) != 0 ? 0 : i12);
        }
    }
}

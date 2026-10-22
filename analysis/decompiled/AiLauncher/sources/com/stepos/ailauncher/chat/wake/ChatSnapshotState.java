package com.stepos.ailauncher.chat.wake;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0005\u000b \u000f\u0017.B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J;\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\n2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0016¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0016¢\u0006\u0004\b\"\u0010!R$\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u001fR\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010-¨\u0006/"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState;", "", "Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$a;", "initial", "<init>", "(Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$a;)V", "", "sessionId", "Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$b;", "source", "Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$c;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$b;)Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$c;", "use", "", "c", "(Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$c;)Z", "", "position", "offset", "messageId", "displayOffset", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$c;IILjava/lang/String;I)V", "Lkotlin/Function1;", "persist", "Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$SaveResult;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$c;Lp9/l;)Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$SaveResult;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$a;", Const.INTENT_KEY_UMID, "()V", "e", UxipConstants.f30680s, "snapshot", "Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$a;", "f", "", "sequence", "J", "active", "Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$c;", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "SaveResult", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatSnapshotState {
    private c active;
    private long sequence;
    private Snapshot snapshot;
    private WeakReference<b> source;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$SaveResult;", "", "<init>", "(Ljava/lang/String;I)V", "SAVED", "ALREADY_SAVED", "STALE", "NO_VIEWPORT", "WRITE_FAILED", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SaveResult {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ SaveResult[] $VALUES;
        public static final SaveResult SAVED = new SaveResult("SAVED", 0);
        public static final SaveResult ALREADY_SAVED = new SaveResult("ALREADY_SAVED", 1);
        public static final SaveResult STALE = new SaveResult("STALE", 2);
        public static final SaveResult NO_VIEWPORT = new SaveResult("NO_VIEWPORT", 3);
        public static final SaveResult WRITE_FAILED = new SaveResult("WRITE_FAILED", 4);

        private static final /* synthetic */ SaveResult[] $values() {
            return new SaveResult[]{SAVED, ALREADY_SAVED, STALE, NO_VIEWPORT, WRITE_FAILED};
        }

        static {
            SaveResult[] saveResultArr$values = $values();
            $VALUES = saveResultArr$values;
            $ENTRIES = kotlin.enums.a.a(saveResultArr$values);
        }

        private SaveResult(String str, int i10) {
        }

        public static InterfaceC4149a<SaveResult> getEntries() {
            return $ENTRIES;
        }

        public static SaveResult valueOf(String str) {
            return (SaveResult) Enum.valueOf(SaveResult.class, str);
        }

        public static SaveResult[] values() {
            return (SaveResult[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0017\u0010\u000eR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0019\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$a;", "", "", "sessionId", "", "position", "offset", "messageId", "displayOffset", "<init>", "(Ljava/lang/String;IILjava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "e", "I", Const.INTENT_KEY_UMID, "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.ChatSnapshotState$a, reason: from toString */
    public static final /* data */ class Snapshot {
        private final int displayOffset;
        private final String messageId;
        private final int offset;
        private final int position;
        private final String sessionId;

        public Snapshot() {
            this(null, 0, 0, null, 0, 31, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getDisplayOffset() {
            return this.displayOffset;
        }

        /* renamed from: b, reason: from getter */
        public final String getMessageId() {
            return this.messageId;
        }

        /* renamed from: c, reason: from getter */
        public final int getOffset() {
            return this.offset;
        }

        /* renamed from: d, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        /* renamed from: e, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Snapshot)) {
                return false;
            }
            Snapshot snapshot = (Snapshot) other;
            return kotlin.jvm.internal.p.d(this.sessionId, snapshot.sessionId) && this.position == snapshot.position && this.offset == snapshot.offset && kotlin.jvm.internal.p.d(this.messageId, snapshot.messageId) && this.displayOffset == snapshot.displayOffset;
        }

        public int hashCode() {
            String str = this.sessionId;
            int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.position)) * 31) + Integer.hashCode(this.offset)) * 31;
            String str2 = this.messageId;
            return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.hashCode(this.displayOffset);
        }

        public String toString() {
            return "Snapshot(sessionId=" + this.sessionId + ", position=" + this.position + ", offset=" + this.offset + ", messageId=" + this.messageId + ", displayOffset=" + this.displayOffset + ")";
        }

        public Snapshot(String str, int i10, int i11, String str2, int i12) {
            this.sessionId = str;
            this.position = i10;
            this.offset = i11;
            this.messageId = str2;
            this.displayOffset = i12;
        }

        public /* synthetic */ Snapshot(String str, int i10, int i11, String str2, int i12, int i13, kotlin.jvm.internal.i iVar) {
            this((i13 & 1) != 0 ? null : str, (i13 & 2) != 0 ? -1 : i10, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? null : str2, (i13 & 16) != 0 ? -1 : i12);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$b;", "", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface b {
        void a();

        void b();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rR*\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$c;", "", "", "sessionId", "", "activationId", "<init>", "(Ljava/lang/String;J)V", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "J", Const.INTENT_KEY_APIKEY, "()J", "", UxipConstants.f30680s, "finalSnapshotSaved", "Z", Const.INTENT_KEY_PKGNAME, "()Z", "e", "(Z)V", "Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$d;", "viewport", "Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$d;", Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$d;", "f", "(Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$d;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c {
        private final long activationId;
        private boolean finalSnapshotSaved;
        private final String sessionId;
        private Viewport viewport;

        public c(String sessionId, long j10) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            this.sessionId = sessionId;
            this.activationId = j10;
        }

        /* renamed from: a, reason: from getter */
        public final long getActivationId() {
            return this.activationId;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getFinalSnapshotSaved() {
            return this.finalSnapshotSaved;
        }

        /* renamed from: c, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: d, reason: from getter */
        public final Viewport getViewport() {
            return this.viewport;
        }

        public final void e(boolean z10) {
            this.finalSnapshotSaved = z10;
        }

        public final void f(Viewport viewport) {
            this.viewport = viewport;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0017\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$d;", "", "", "position", "offset", "", "messageId", "displayOffset", "<init>", "(IILjava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_UMID, "c", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.ChatSnapshotState$d, reason: from toString */
    public static final /* data */ class Viewport {
        private final int displayOffset;
        private final String messageId;
        private final int offset;
        private final int position;

        public Viewport(int i10, int i11, String str, int i12) {
            this.position = i10;
            this.offset = i11;
            this.messageId = str;
            this.displayOffset = i12;
        }

        /* renamed from: a, reason: from getter */
        public final int getDisplayOffset() {
            return this.displayOffset;
        }

        /* renamed from: b, reason: from getter */
        public final String getMessageId() {
            return this.messageId;
        }

        /* renamed from: c, reason: from getter */
        public final int getOffset() {
            return this.offset;
        }

        /* renamed from: d, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Viewport)) {
                return false;
            }
            Viewport viewport = (Viewport) other;
            return this.position == viewport.position && this.offset == viewport.offset && kotlin.jvm.internal.p.d(this.messageId, viewport.messageId) && this.displayOffset == viewport.displayOffset;
        }

        public int hashCode() {
            int iHashCode = ((Integer.hashCode(this.position) * 31) + Integer.hashCode(this.offset)) * 31;
            String str = this.messageId;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.displayOffset);
        }

        public String toString() {
            return "Viewport(position=" + this.position + ", offset=" + this.offset + ", messageId=" + this.messageId + ", displayOffset=" + this.displayOffset + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatSnapshotState() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final c a(String sessionId, b source) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(source, "source");
        if (La.H.x0(sessionId)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.source = new WeakReference<>(source);
        long j10 = this.sequence + 1;
        this.sequence = j10;
        c cVar = new c(sessionId, j10);
        this.active = cVar;
        return cVar;
    }

    public final void b(c use, int position, int offset, String messageId, int displayOffset) {
        kotlin.jvm.internal.p.i(use, "use");
        if (!c(use) || position < 0) {
            return;
        }
        use.f(new Viewport(position, offset, messageId, displayOffset));
    }

    public final boolean c(c use) {
        kotlin.jvm.internal.p.i(use, "use");
        return this.active == use && !use.getFinalSnapshotSaved();
    }

    public final void d() {
        b bVar;
        WeakReference<b> weakReference = this.source;
        if (weakReference == null || (bVar = weakReference.get()) == null) {
            return;
        }
        bVar.b();
    }

    public final void e() {
        this.active = null;
        this.source = null;
        this.snapshot = new Snapshot(null, 0, 0, null, 0, 31, null);
    }

    /* renamed from: f, reason: from getter */
    public final Snapshot getSnapshot() {
        return this.snapshot;
    }

    public final Snapshot g() {
        b bVar;
        WeakReference<b> weakReference = this.source;
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            bVar.a();
        }
        return this.snapshot;
    }

    public final SaveResult h(c use, InterfaceC5074l<? super Snapshot, Boolean> persist) {
        kotlin.jvm.internal.p.i(use, "use");
        kotlin.jvm.internal.p.i(persist, "persist");
        if (this.active != use) {
            return SaveResult.STALE;
        }
        if (use.getFinalSnapshotSaved()) {
            return SaveResult.ALREADY_SAVED;
        }
        Viewport viewport = use.getViewport();
        if (viewport == null) {
            return SaveResult.NO_VIEWPORT;
        }
        Snapshot snapshot = new Snapshot(use.getSessionId(), viewport.getPosition(), viewport.getOffset(), viewport.getMessageId(), viewport.getDisplayOffset());
        if (!persist.invoke(snapshot).booleanValue()) {
            return SaveResult.WRITE_FAILED;
        }
        this.snapshot = snapshot;
        use.e(true);
        return SaveResult.SAVED;
    }

    public ChatSnapshotState(Snapshot initial) {
        kotlin.jvm.internal.p.i(initial, "initial");
        this.snapshot = initial;
    }

    public /* synthetic */ ChatSnapshotState(Snapshot snapshot, int i10, kotlin.jvm.internal.i iVar) {
        if ((i10 & 1) != 0) {
            snapshot = new Snapshot(null, 0, 0, null, 0, 31, null);
        }
        this(snapshot);
    }
}

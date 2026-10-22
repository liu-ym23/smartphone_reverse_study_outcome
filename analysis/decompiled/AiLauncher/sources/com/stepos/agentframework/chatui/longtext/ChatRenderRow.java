package com.stepos.agentframework.chatui.longtext;

import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.S1;
import com.stepos.agentframework.chatui.longtext.LongTextDocument;
import h9.InterfaceC4149a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import z4.LongTextKey;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001:\u00016Bk\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\n\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b(\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\r\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010)\u001a\u0004\b,\u0010+R\u0017\u0010\u000e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b-\u0010\u001aR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010.\u001a\u0004\b/\u0010\u0018R\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b0\u0010\u001aR\u0016\u00102\u001a\u0004\u0018\u0001018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0011\u00105\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b4\u0010\u001a¨\u00067"}, d2 = {"Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow;", "", "Lcom/stepos/agentframework/chatui/S1;", "item", "", "logicalIndex", "Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow$Kind;", "kind", "Lcom/stepos/agentframework/chatui/longtext/LongTextDocument;", "document", "blockIndex", "", "topOfMessage", "bottomOfMessage", "sliceIndex", "", "sliceMarkdown", "bodyPartIndex", "<init>", "(Lcom/stepos/agentframework/chatui/S1;ILcom/stepos/agentframework/chatui/longtext/ChatRenderRow$Kind;Lcom/stepos/agentframework/chatui/longtext/LongTextDocument;IZZILjava/lang/String;I)V", "other", "l", "(Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow;)Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/agentframework/chatui/S1;", "f", "()Lcom/stepos/agentframework/chatui/S1;", "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow$Kind;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow$Kind;", "Lcom/stepos/agentframework/chatui/longtext/LongTextDocument;", "e", "()Lcom/stepos/agentframework/chatui/longtext/LongTextDocument;", Const.INTENT_KEY_APIKEY, "Z", "k", "()Z", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_PKGNAME, "Lz4/e;", "messageKey", "Lz4/e;", Const.INTENT_KEY_UMID, "displayOffset", "Kind", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ChatRenderRow {
    private final int blockIndex;
    private final int bodyPartIndex;
    private final boolean bottomOfMessage;
    private final LongTextDocument document;
    private final S1 item;
    private final Kind kind;
    private final int logicalIndex;
    private final LongTextKey messageKey;
    private final int sliceIndex;
    private final String sliceMarkdown;
    private final boolean topOfMessage;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow$Kind;", "", "<init>", "(Ljava/lang/String;I)V", "MESSAGE", "PREPARING", "HEADER", "BLOCK", "SLICE", "ATTACHMENTS", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Kind {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Kind[] $VALUES;
        public static final Kind MESSAGE = new Kind("MESSAGE", 0);
        public static final Kind PREPARING = new Kind("PREPARING", 1);
        public static final Kind HEADER = new Kind("HEADER", 2);
        public static final Kind BLOCK = new Kind("BLOCK", 3);
        public static final Kind SLICE = new Kind("SLICE", 4);
        public static final Kind ATTACHMENTS = new Kind("ATTACHMENTS", 5);

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{MESSAGE, PREPARING, HEADER, BLOCK, SLICE, ATTACHMENTS};
        }

        static {
            Kind[] kindArr$values = $values();
            $VALUES = kindArr$values;
            $ENTRIES = kotlin.enums.a.a(kindArr$values);
        }

        private Kind(String str, int i10) {
        }

        public static InterfaceC4149a<Kind> getEntries() {
            return $ENTRIES;
        }

        public static Kind valueOf(String str) {
            return (Kind) Enum.valueOf(Kind.class, str);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Kind.values().length];
            try {
                iArr[Kind.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Kind.ATTACHMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Kind.SLICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ChatRenderRow(S1 item, int i10, Kind kind, LongTextDocument longTextDocument, int i11, boolean z10, boolean z11, int i12, String str, int i13) {
        p.i(item, "item");
        p.i(kind, "kind");
        this.item = item;
        this.logicalIndex = i10;
        this.kind = kind;
        this.document = longTextDocument;
        this.blockIndex = i11;
        this.topOfMessage = z10;
        this.bottomOfMessage = z11;
        this.sliceIndex = i12;
        this.sliceMarkdown = str;
        this.bodyPartIndex = i13;
        DisplayMessage displayMessage = item instanceof DisplayMessage ? (DisplayMessage) item : null;
        this.messageKey = displayMessage != null ? new LongTextKey(displayMessage.getSessionId(), displayMessage.getMessageId()) : null;
    }

    /* renamed from: a, reason: from getter */
    public final int getBlockIndex() {
        return this.blockIndex;
    }

    /* renamed from: b, reason: from getter */
    public final int getBodyPartIndex() {
        return this.bodyPartIndex;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getBottomOfMessage() {
        return this.bottomOfMessage;
    }

    public final int d() {
        List<LongTextDocument.Block> listA;
        LongTextDocument.Block block;
        int i10 = a.$EnumSwitchMapping$0[this.kind.ordinal()];
        if (i10 == 1) {
            return -2;
        }
        if (i10 == 2) {
            return -3;
        }
        if (i10 == 3) {
            return this.sliceIndex;
        }
        LongTextDocument longTextDocument = this.document;
        if (longTextDocument == null || (listA = longTextDocument.a()) == null || (block = (LongTextDocument.Block) F.t0(listA, this.blockIndex)) == null) {
            return -1;
        }
        return block.getStart();
    }

    /* renamed from: e, reason: from getter */
    public final LongTextDocument getDocument() {
        return this.document;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatRenderRow)) {
            return false;
        }
        ChatRenderRow chatRenderRow = (ChatRenderRow) other;
        return p.d(this.item, chatRenderRow.item) && this.logicalIndex == chatRenderRow.logicalIndex && this.kind == chatRenderRow.kind && p.d(this.document, chatRenderRow.document) && this.blockIndex == chatRenderRow.blockIndex && this.topOfMessage == chatRenderRow.topOfMessage && this.bottomOfMessage == chatRenderRow.bottomOfMessage && this.sliceIndex == chatRenderRow.sliceIndex && p.d(this.sliceMarkdown, chatRenderRow.sliceMarkdown) && this.bodyPartIndex == chatRenderRow.bodyPartIndex;
    }

    /* renamed from: f, reason: from getter */
    public final S1 getItem() {
        return this.item;
    }

    /* renamed from: g, reason: from getter */
    public final Kind getKind() {
        return this.kind;
    }

    /* renamed from: h, reason: from getter */
    public final int getLogicalIndex() {
        return this.logicalIndex;
    }

    public int hashCode() {
        int iHashCode = ((((this.item.hashCode() * 31) + Integer.hashCode(this.logicalIndex)) * 31) + this.kind.hashCode()) * 31;
        LongTextDocument longTextDocument = this.document;
        int iHashCode2 = (((((((((iHashCode + (longTextDocument == null ? 0 : longTextDocument.hashCode())) * 31) + Integer.hashCode(this.blockIndex)) * 31) + Boolean.hashCode(this.topOfMessage)) * 31) + Boolean.hashCode(this.bottomOfMessage)) * 31) + Integer.hashCode(this.sliceIndex)) * 31;
        String str = this.sliceMarkdown;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Integer.hashCode(this.bodyPartIndex);
    }

    /* renamed from: i, reason: from getter */
    public final int getSliceIndex() {
        return this.sliceIndex;
    }

    /* renamed from: j, reason: from getter */
    public final String getSliceMarkdown() {
        return this.sliceMarkdown;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getTopOfMessage() {
        return this.topOfMessage;
    }

    public final boolean l(ChatRenderRow other) {
        LongTextKey longTextKey;
        p.i(other, "other");
        LongTextKey longTextKey2 = this.messageKey;
        return ((longTextKey2 == null || (longTextKey = other.messageKey) == null) ? this.item == other.item : p.d(longTextKey2, longTextKey)) && this.kind == other.kind && d() == other.d();
    }

    public String toString() {
        return "ChatRenderRow(item=" + this.item + ", logicalIndex=" + this.logicalIndex + ", kind=" + this.kind + ", document=" + this.document + ", blockIndex=" + this.blockIndex + ", topOfMessage=" + this.topOfMessage + ", bottomOfMessage=" + this.bottomOfMessage + ", sliceIndex=" + this.sliceIndex + ", sliceMarkdown=" + this.sliceMarkdown + ", bodyPartIndex=" + this.bodyPartIndex + ")";
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ ChatRenderRow(com.stepos.agentframework.chatui.S1 r14, int r15, com.stepos.agentframework.chatui.longtext.ChatRenderRow.Kind r16, com.stepos.agentframework.chatui.longtext.LongTextDocument r17, int r18, boolean r19, boolean r20, int r21, java.lang.String r22, int r23, int r24, kotlin.jvm.internal.i r25) {
        /*
            r13 = this;
            r0 = r24
            r1 = r0 & 4
            if (r1 == 0) goto La
            com.stepos.agentframework.chatui.longtext.ChatRenderRow$Kind r1 = com.stepos.agentframework.chatui.longtext.ChatRenderRow.Kind.MESSAGE
            r5 = r1
            goto Lc
        La:
            r5 = r16
        Lc:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L13
            r6 = r2
            goto L15
        L13:
            r6 = r17
        L15:
            r1 = r0 & 16
            r3 = -1
            if (r1 == 0) goto L1c
            r7 = r3
            goto L1e
        L1c:
            r7 = r18
        L1e:
            r1 = r0 & 32
            r4 = 1
            if (r1 == 0) goto L25
            r8 = r4
            goto L27
        L25:
            r8 = r19
        L27:
            r1 = r0 & 64
            if (r1 == 0) goto L2d
            r9 = r4
            goto L2f
        L2d:
            r9 = r20
        L2f:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L35
            r10 = r3
            goto L37
        L35:
            r10 = r21
        L37:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L3d
            r11 = r2
            goto L3f
        L3d:
            r11 = r22
        L3f:
            r0 = r0 & 512(0x200, float:7.17E-43)
            if (r0 == 0) goto L48
            r12 = r3
            r2 = r13
            r4 = r15
            r3 = r14
            goto L4d
        L48:
            r12 = r23
            r2 = r13
            r3 = r14
            r4 = r15
        L4d:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.longtext.ChatRenderRow.<init>(com.stepos.agentframework.chatui.S1, int, com.stepos.agentframework.chatui.longtext.ChatRenderRow$Kind, com.stepos.agentframework.chatui.longtext.LongTextDocument, int, boolean, boolean, int, java.lang.String, int, int, kotlin.jvm.internal.i):void");
    }
}

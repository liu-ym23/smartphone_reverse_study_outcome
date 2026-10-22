package com.obric.aiagent.assistant.idl.bean;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: Block.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Block implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("append_fields")
    private final List<Integer> appendFields;

    @SerializedName("block_id")
    private final String blockId;

    @SerializedName("block_type")
    private final int blockType;

    @SerializedName("content")
    private final BlockContent content;

    @SerializedName("is_finish")
    private final boolean isFinish;

    @SerializedName("meta_info")
    private final List<BlockMetaInfo> metaInfo;

    @SerializedName("parent_id")
    private final String parentId;

    /* JADX INFO: compiled from: Block.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public Block() {
        this(0, null, null, null, false, null, null, 127, null);
    }

    public static /* synthetic */ Block copy$default(Block r9, int r10, String r11, String r12, BlockContent r13, boolean r14, List r15, List r16, int r17, Object r18) {
        List<Integer> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        List<BlockMetaInfo> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        if ((r17 & 1) == 0) goto L5;
        int r3 = r9.blockType;
    L7:
        if ((r17 & 2) == 0) goto L9;
        String r4 = r9.blockId;
    L11:
        if ((r17 & 4) == 0) goto L13;
        String r5 = r9.parentId;
    L15:
        if ((r17 & 8) == 0) goto L17;
        BlockContent r6 = r9.content;
    L19:
        if ((r17 & 16) == 0) goto L21;
        boolean r7 = r9.isFinish;
    L23:
        if ((r17 & 32) == 0) goto L26;
        r1 = r9.appendFields;
    L26:
        if ((r17 & 64) == 0) goto L29;
        r2 = r9.metaInfo;
    L29:
        return r9.copy(r3, r4, r5, r6, r7, r1, r2);
    L21:
        r7 = r14;
        goto L23
    L17:
        r6 = r13;
        goto L19
    L13:
        r5 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    public final int component1() {
        return this.blockType;
    }

    public final String component2() {
        return this.blockId;
    }

    public final String component3() {
        return this.parentId;
    }

    public final BlockContent component4() {
        return this.content;
    }

    public final boolean component5() {
        return this.isFinish;
    }

    public final List<Integer> component6() {
        return this.appendFields;
    }

    public final List<BlockMetaInfo> component7() {
        return this.metaInfo;
    }

    public final Block copy(int r11, String r12, String r13, BlockContent r14, boolean r15, List<Integer> r16, List<BlockMetaInfo> r17) {
        return new Block(r11, r12, r13, r14, r15, (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Block.class) == true) goto L8;
        return false;
    L8:
        Block r6 = (Block) ZeusTransformUtils.preCheckCast(r5, Block.class, "com.obric.aiagent.plugin");
        if (this.blockType == r6.blockType) goto L12;
        return false;
    L12:
        if (o.a(this.blockId, r6.blockId) == true) goto L15;
        return false;
    L15:
        if (o.a(this.parentId, r6.parentId) == true) goto L18;
        return false;
    L18:
        if (o.a(this.content, r6.content) == true) goto L21;
        return false;
    L21:
        if (this.isFinish == r6.isFinish) goto L24;
        return false;
    L24:
        if (o.a(this.appendFields, r6.appendFields) == true) goto L27;
        return false;
    L27:
        if (o.a(this.metaInfo, r6.metaInfo) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.blockType) * 31;
        String r1 = this.blockId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.parentId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        BlockContent r8 = this.content;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((r7 + r9) * 31) + Boolean.hashCode(this.isFinish)) * 31;
        List<Integer> r11 = this.appendFields;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        List<BlockMetaInfo> r14 = this.metaInfo;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "Block(blockType=" + this.blockType + ", blockId=" + this.blockId + ", parentId=" + this.parentId + ", content=" + this.content + ", isFinish=" + this.isFinish + ", appendFields=" + this.appendFields + ", metaInfo=" + this.metaInfo + ')';
    }

    public Block(int r3, String r4, String r5, BlockContent r6, boolean r7, List<Integer> r8, List<BlockMetaInfo> r9) {
        List<Integer> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List<BlockMetaInfo> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        this.blockType = r3;
        this.blockId = r4;
        this.parentId = r5;
        this.content = r6;
        this.isFinish = r7;
        this.appendFields = r10;
        this.metaInfo = r11;
    }

    public /* synthetic */ Block(int r10, String r11, String r12, BlockContent r13, boolean r14, List r15, List r16, int r17, h r18) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        boolean r3 = false;
        if ((r17 & 1) == 0) goto L5;
        int r2 = 0;
    L7:
        if ((r17 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r17 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r17 & 8) == 0) goto L17;
        BlockContent r7 = null;
    L19:
        if ((r17 & 16) != 0) goto L23;
        r3 = r14;
    L23:
        if ((r17 & 32) == 0) goto L26;
        r0 = null;
    L26:
        if ((r17 & 64) == 0) goto L28;
        r1 = null;
    L28:
        this(r2, r4, r6, r7, r3, r0, r1);
        return;
    L17:
        r7 = r13;
        goto L19
    L13:
        r6 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final int getBlockType() {
        return this.blockType;
    }

    public final String getBlockId() {
        return this.blockId;
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final BlockContent getContent() {
        return this.content;
    }

    public final boolean isFinish() {
        return this.isFinish;
    }

    public final List<Integer> getAppendFields() {
        return this.appendFields;
    }

    public final List<BlockMetaInfo> getMetaInfo() {
        return this.metaInfo;
    }
}

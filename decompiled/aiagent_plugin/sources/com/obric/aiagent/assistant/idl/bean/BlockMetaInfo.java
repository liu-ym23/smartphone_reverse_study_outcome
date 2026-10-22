package com.obric.aiagent.assistant.idl.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.io.Serializable;

/* JADX INFO: compiled from: BlockMetaInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BlockMetaInfo implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("tag_info")
    public final String info;

    @SerializedName(DBDefinition.SEGMENT_INFO)
    public final String infoV2;

    @SerializedName("type")
    public final int type;

    /* JADX INFO: compiled from: BlockMetaInfo.kt */
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

    public BlockMetaInfo() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ BlockMetaInfo copy$default(BlockMetaInfo r0, int r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.info;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.infoV2;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.info;
    }

    public final String component3() {
        return this.infoV2;
    }

    public final BlockMetaInfo copy(int r1, String r2, String r3) {
        return new BlockMetaInfo(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BlockMetaInfo.class) == true) goto L8;
        return false;
    L8:
        BlockMetaInfo r6 = (BlockMetaInfo) ZeusTransformUtils.preCheckCast(r5, BlockMetaInfo.class, "com.obric.aiagent.plugin");
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (o.a(this.info, r6.info) == true) goto L15;
        return false;
    L15:
        if (o.a(this.infoV2, r6.infoV2) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.type) * 31;
        String r1 = this.info;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.infoV2;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "BlockMetaInfo(type=" + this.type + ", info=" + this.info + ", infoV2=" + this.infoV2 + ')';
    }

    public BlockMetaInfo(int r1, String r2, String r3) {
        this.type = r1;
        this.info = r2;
        this.infoV2 = r3;
    }

    public /* synthetic */ BlockMetaInfo(int r2, String r3, String r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final String getRealInfo() {
        String r0 = this.infoV2;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.info;
    }
}

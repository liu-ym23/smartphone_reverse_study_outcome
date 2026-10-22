package com.obric.aiagent.assistant.idl.bean;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.io.Serializable;

/* JADX INFO: compiled from: BlockContent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BlockContent implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("applet_block")
    private final AppletBlock appletBlock;

    @SerializedName("text_block")
    private final TextBlock textBlock;

    /* JADX INFO: compiled from: BlockContent.kt */
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

    /* JADX WARN: Multi-variable type inference failed */
    public BlockContent() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BlockContent copy$default(BlockContent r0, TextBlock r1, AppletBlock r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.textBlock;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.appletBlock;
    L9:
        return r0.copy(r1, r2);
    }

    public final TextBlock component1() {
        return this.textBlock;
    }

    public final AppletBlock component2() {
        return this.appletBlock;
    }

    public final BlockContent copy(TextBlock r1, AppletBlock r2) {
        return new BlockContent(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BlockContent.class) == true) goto L8;
        return false;
    L8:
        BlockContent r6 = (BlockContent) ZeusTransformUtils.preCheckCast(r5, BlockContent.class, "com.obric.aiagent.plugin");
        if (o.a(this.textBlock, r6.textBlock) == true) goto L12;
        return false;
    L12:
        if (o.a(this.appletBlock, r6.appletBlock) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        TextBlock r0 = this.textBlock;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        AppletBlock r4 = this.appletBlock;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "BlockContent(textBlock=" + this.textBlock + ", appletBlock=" + this.appletBlock + ')';
    }

    public BlockContent(TextBlock r1, AppletBlock r2) {
        this.textBlock = r1;
        this.appletBlock = r2;
    }

    public /* synthetic */ BlockContent(TextBlock r2, AppletBlock r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final TextBlock getTextBlock() {
        return this.textBlock;
    }

    public final AppletBlock getAppletBlock() {
        return this.appletBlock;
    }
}

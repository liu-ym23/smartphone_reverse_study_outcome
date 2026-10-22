package com.bytedance.android.shopping.commentv3.action.handler.tracker;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/action/handler/tracker/CommentBtmId;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "SKU_PANEL", "SKU_PANEL_RESET", "SKU_PANEL_CONFIRM", "SKU_PANEL_CLOSE", "FLOAT_TO_TOP", "FLOAT_MULTI_SWITCH", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentBtmId extends Enum<CommentBtmId> {
    public static final CommentBtmId FLOAT_MULTI_SWITCH = null;
    public static final CommentBtmId FLOAT_TO_TOP = null;
    public static final CommentBtmId SKU_PANEL = null;
    public static final CommentBtmId SKU_PANEL_CLOSE = null;
    public static final CommentBtmId SKU_PANEL_CONFIRM = null;
    public static final CommentBtmId SKU_PANEL_RESET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentBtmId[] f172592a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f172593id;

    static {
        CommentBtmId r100 = new CommentBtmId("SKU_PANEL", 0, "c67220.d0");
        SKU_PANEL = r100;
        CommentBtmId r101 = new CommentBtmId("SKU_PANEL_RESET", 1, "c67220.d95115");
        SKU_PANEL_RESET = r101;
        CommentBtmId r102 = new CommentBtmId("SKU_PANEL_CONFIRM", 2, "c67220.d10589");
        SKU_PANEL_CONFIRM = r102;
        CommentBtmId r103 = new CommentBtmId("SKU_PANEL_CLOSE", 3, "c67220.d88817");
        SKU_PANEL_CLOSE = r103;
        CommentBtmId r104 = new CommentBtmId("FLOAT_TO_TOP", 4, "c49811.d0");
        FLOAT_TO_TOP = r104;
        CommentBtmId r105 = new CommentBtmId("FLOAT_MULTI_SWITCH", 5, "c20822.d0");
        FLOAT_MULTI_SWITCH = r105;
        f172592a = new CommentBtmId[]{r100, r101, r102, r103, r104, r105};
    }

    public static CommentBtmId valueOf(String r100) {
        return (CommentBtmId) a.a(CommentBtmId.class, r100);
    }

    public static CommentBtmId[] values() {
        return (CommentBtmId[]) f172592a.clone();
    }

    public final String getId() {
        return this.f172593id;
    }

    public CommentBtmId(String r100, int r101, String r102) {
        super(r100, r101);
        this.f172593id = r102;
    }
}

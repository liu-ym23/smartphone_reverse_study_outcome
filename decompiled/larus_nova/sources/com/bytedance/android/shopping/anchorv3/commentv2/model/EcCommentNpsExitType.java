package com.bytedance.android.shopping.anchorv3.commentv2.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/commentv2/model/EcCommentNpsExitType;", "", "", "type", "I", "getType", "()I", "INVALID_TYPE", "LIST_NPS", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EcCommentNpsExitType extends Enum<EcCommentNpsExitType> {
    public static final EcCommentNpsExitType INVALID_TYPE = null;
    public static final EcCommentNpsExitType LIST_NPS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EcCommentNpsExitType[] f164727a = null;
    private final int type;

    static {
        EcCommentNpsExitType r100 = new EcCommentNpsExitType("INVALID_TYPE", 0, -1);
        INVALID_TYPE = r100;
        EcCommentNpsExitType r101 = new EcCommentNpsExitType("LIST_NPS", 1, 2);
        LIST_NPS = r101;
        f164727a = new EcCommentNpsExitType[]{r100, r101};
    }

    public static EcCommentNpsExitType valueOf(String r100) {
        return (EcCommentNpsExitType) r27.a.a(EcCommentNpsExitType.class, r100);
    }

    public static EcCommentNpsExitType[] values() {
        return (EcCommentNpsExitType[]) f164727a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public EcCommentNpsExitType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}

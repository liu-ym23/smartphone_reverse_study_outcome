package com.bytedance.android.shopping.anchorv3.commentv2.model;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/commentv2/model/CommentStatIdEnum;", "", "", "statId", "J", "getStatId", "()J", "setStatId", "(J)V", AccountType.ALL, "PIC_VIDEO", "VERY_GOOD", "JUST_SO_SO", "APPEND_COMMENT", "BAD", "NEWEST", "JUST_SO_SO_OR_BAD", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentStatIdEnum extends Enum<CommentStatIdEnum> {
    public static final CommentStatIdEnum ALL = null;
    public static final CommentStatIdEnum APPEND_COMMENT = null;
    public static final CommentStatIdEnum BAD = null;
    public static final CommentStatIdEnum JUST_SO_SO = null;
    public static final CommentStatIdEnum JUST_SO_SO_OR_BAD = null;
    public static final CommentStatIdEnum NEWEST = null;
    public static final CommentStatIdEnum PIC_VIDEO = null;
    public static final CommentStatIdEnum VERY_GOOD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentStatIdEnum[] f164724a = null;
    private long statId;

    public static CommentStatIdEnum valueOf(String r100) {
        return (CommentStatIdEnum) r27.a.a(CommentStatIdEnum.class, r100);
    }

    public static CommentStatIdEnum[] values() {
        return (CommentStatIdEnum[]) f164724a.clone();
    }

    static {
        CommentStatIdEnum r100 = new CommentStatIdEnum(AccountType.ALL, 0, 1);
        ALL = r100;
        CommentStatIdEnum r101 = new CommentStatIdEnum("PIC_VIDEO", 1, 2);
        PIC_VIDEO = r101;
        CommentStatIdEnum r102 = new CommentStatIdEnum("VERY_GOOD", 2, 3);
        VERY_GOOD = r102;
        CommentStatIdEnum r103 = new CommentStatIdEnum("JUST_SO_SO", 3, 4);
        JUST_SO_SO = r103;
        CommentStatIdEnum r104 = new CommentStatIdEnum("APPEND_COMMENT", 4, 5);
        APPEND_COMMENT = r104;
        CommentStatIdEnum r105 = new CommentStatIdEnum("BAD", 5, 6);
        BAD = r105;
        CommentStatIdEnum r106 = new CommentStatIdEnum("NEWEST", 6, 7);
        NEWEST = r106;
        CommentStatIdEnum r107 = new CommentStatIdEnum("JUST_SO_SO_OR_BAD", 7, 8);
        JUST_SO_SO_OR_BAD = r107;
        f164724a = new CommentStatIdEnum[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final long getStatId() {
        return this.statId;
    }

    public final void setStatId(long r100) {
        this.statId = r100;
    }

    public CommentStatIdEnum(String r100, int r101, long r102) {
        super(r100, r101);
        this.statId = r102;
    }
}

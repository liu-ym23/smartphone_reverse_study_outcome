package com.bytedance.android.livesdk.interactivity.api.comment.event;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/event/QuickCommentTypeEnum;", "", "QUICK_COMMENT_MATCH", "QUICK_COMMENT_FIXED", "QUICK_COMMENT_OGC_FIXED", "DEFAULT", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum QuickCommentTypeEnum extends Enum<QuickCommentTypeEnum> {
    public static final QuickCommentTypeEnum DEFAULT = null;
    public static final QuickCommentTypeEnum QUICK_COMMENT_FIXED = null;
    public static final QuickCommentTypeEnum QUICK_COMMENT_MATCH = null;
    public static final QuickCommentTypeEnum QUICK_COMMENT_OGC_FIXED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ QuickCommentTypeEnum[] f133043a = null;

    static {
        QuickCommentTypeEnum r100 = new QuickCommentTypeEnum("QUICK_COMMENT_MATCH", 0);
        QUICK_COMMENT_MATCH = r100;
        QuickCommentTypeEnum r101 = new QuickCommentTypeEnum("QUICK_COMMENT_FIXED", 1);
        QUICK_COMMENT_FIXED = r101;
        QuickCommentTypeEnum r102 = new QuickCommentTypeEnum("QUICK_COMMENT_OGC_FIXED", 2);
        QUICK_COMMENT_OGC_FIXED = r102;
        QuickCommentTypeEnum r103 = new QuickCommentTypeEnum("DEFAULT", 3);
        DEFAULT = r103;
        f133043a = new QuickCommentTypeEnum[]{r100, r101, r102, r103};
    }

    public static QuickCommentTypeEnum valueOf(String r100) {
        return (QuickCommentTypeEnum) a.a(QuickCommentTypeEnum.class, r100);
    }

    public static QuickCommentTypeEnum[] values() {
        return (QuickCommentTypeEnum[]) f133043a.clone();
    }

    public QuickCommentTypeEnum(String r100, int r101) {
        super(r100, r101);
    }
}

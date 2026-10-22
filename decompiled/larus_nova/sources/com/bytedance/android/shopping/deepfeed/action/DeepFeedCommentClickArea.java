package com.bytedance.android.shopping.deepfeed.action;

import androidx.compose.material3.internal.TextFieldImplKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/action/DeepFeedCommentClickArea;", "", "", "str", "Ljava/lang/String;", "getStr", "()Ljava/lang/String;", TextFieldImplKt.ContainerId, "ContentImageContainer", "CommentContent", "Avatar", "ContentText", "ContentMore", "ImpressionWords", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DeepFeedCommentClickArea extends Enum<DeepFeedCommentClickArea> {
    public static final DeepFeedCommentClickArea Avatar = null;
    public static final DeepFeedCommentClickArea CommentContent = null;
    public static final DeepFeedCommentClickArea Container = null;
    public static final DeepFeedCommentClickArea ContentImageContainer = null;
    public static final DeepFeedCommentClickArea ContentMore = null;
    public static final DeepFeedCommentClickArea ContentText = null;
    public static final DeepFeedCommentClickArea ImpressionWords = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DeepFeedCommentClickArea[] f173031a = null;
    private final String str;

    static {
        DeepFeedCommentClickArea r100 = new DeepFeedCommentClickArea(TextFieldImplKt.ContainerId, 0, KtvSubElement.CONTAINER);
        Container = r100;
        DeepFeedCommentClickArea r101 = new DeepFeedCommentClickArea("ContentImageContainer", 1, "image");
        ContentImageContainer = r101;
        DeepFeedCommentClickArea r102 = new DeepFeedCommentClickArea("CommentContent", 2, "comment_content");
        CommentContent = r102;
        DeepFeedCommentClickArea r103 = new DeepFeedCommentClickArea("Avatar", 3, "avatar");
        Avatar = r103;
        DeepFeedCommentClickArea r104 = new DeepFeedCommentClickArea("ContentText", 4, "text");
        ContentText = r104;
        DeepFeedCommentClickArea r105 = new DeepFeedCommentClickArea("ContentMore", 5, "more");
        ContentMore = r105;
        DeepFeedCommentClickArea r106 = new DeepFeedCommentClickArea("ImpressionWords", 6, EffectConfiguration.KEY_SEARCH_WORD);
        ImpressionWords = r106;
        f173031a = new DeepFeedCommentClickArea[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static DeepFeedCommentClickArea valueOf(String r100) {
        return (DeepFeedCommentClickArea) r27.a.a(DeepFeedCommentClickArea.class, r100);
    }

    public static DeepFeedCommentClickArea[] values() {
        return (DeepFeedCommentClickArea[]) f173031a.clone();
    }

    public final String getStr() {
        return this.str;
    }

    public DeepFeedCommentClickArea(String r100, int r101, String r102) {
        super(r100, r101);
        this.str = r102;
    }
}

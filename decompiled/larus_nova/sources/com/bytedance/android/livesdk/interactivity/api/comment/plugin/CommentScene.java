package com.bytedance.android.livesdk.interactivity.api.comment.plugin;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/plugin/CommentScene;", "", "PublicScreen", "ChatChannel", "SecretChat", "SquareChat", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentScene extends Enum<CommentScene> {
    public static final CommentScene ChatChannel = null;
    public static final CommentScene PublicScreen = null;
    public static final CommentScene SecretChat = null;
    public static final CommentScene SquareChat = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentScene[] f133088a = null;

    static {
        CommentScene r100 = new CommentScene("PublicScreen", 0);
        PublicScreen = r100;
        CommentScene r101 = new CommentScene("ChatChannel", 1);
        ChatChannel = r101;
        CommentScene r102 = new CommentScene("SecretChat", 2);
        SecretChat = r102;
        CommentScene r103 = new CommentScene("SquareChat", 3);
        SquareChat = r103;
        f133088a = new CommentScene[]{r100, r101, r102, r103};
    }

    public static CommentScene valueOf(String r100) {
        return (CommentScene) a.a(CommentScene.class, r100);
    }

    public static CommentScene[] values() {
        return (CommentScene[]) f133088a.clone();
    }

    public CommentScene(String r100, int r101) {
        super(r100, r101);
    }
}

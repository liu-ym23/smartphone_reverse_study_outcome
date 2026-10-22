package com.bytedance.android.gamecp.business.comment.data;

import com.bytedance.android.gamecp.business.h0;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f52041a = 0;

    public static String a() {
        bw.p r100 = com.bytedance.android.gamecp.host_api.a.b().getUserService();
        if (r100 == null) goto L9;
        hw.b r101 = r100.user();
        if (r101 == null) goto L9;
        String r102 = r101.getCurrentUserId();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return null;
    }

    static {
    }

    public static String f(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (r101 == true) goto L5;
        return r100;
    L5:
        return StringsKt.replaceFirst$default(r100, "user", "anchor", false, 4, null);
    }

    public static void c(String r100, String r101, String r102, int r103, boolean r104, String r105, long r106) {
        Intrinsics.checkNotNullParameter(r100, "gameId");
        Intrinsics.checkNotNullParameter(r101, "gameName");
        Intrinsics.checkNotNullParameter(r102, "level");
        Intrinsics.checkNotNullParameter(r105, "tagName");
        String r107 = f("livesdk_game_promote_user_reply_comment_page_publish", r104);
        HashMap r108 = new HashMap();
        r108.put("game_id", r100);
        r108.put(EventConstants.ExtraJson.GAME_NAME, r101);
        String r109 = a();
        if (r109 != null) goto L5;
        r109 = "";
    L5:
        r108.put("user_id", r109);
        if (r104 == false) goto L8;
        String r110 = "anchor";
    L9:
        r108.put(DownloadHelper.IDENTITY, r110);
        r108.put("reply_comment_level", r102);
        r108.put("comment_keyword", r105);
        r108.put("comment_count", String.valueOf(r106));
        h0.c(r107, r108, r103, r104, 16);
        return;
    L8:
        r110 = "user";
        goto L9
    }

    public static void d(String r100, String r101, String r102, String r103, boolean r104, String r105, int r106, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "gameId");
        Intrinsics.checkNotNullParameter(r101, "gameName");
        Intrinsics.checkNotNullParameter(r102, "commentId");
        Intrinsics.checkNotNullParameter(r103, "replyId");
        Intrinsics.checkNotNullParameter(r105, "level");
        String r107 = f("livesdk_game_promote_user_comment_replay_comment_like", r110);
        HashMap r108 = new HashMap();
        r108.put("game_id", r100);
        r108.put(EventConstants.ExtraJson.GAME_NAME, r101);
        String r109 = a();
        if (r109 != null) goto L5;
        r109 = "";
    L5:
        r108.put("user_id", r109);
        if (r110 == false) goto L8;
        String r111 = "anchor";
    L9:
        r108.put(DownloadHelper.IDENTITY, r111);
        r108.put("evaluation_id", r102);
        r108.put("comment_id", r103);
        if (r104 == false) goto L12;
        String r112 = IStrategyStateSupplier.KEY_INFO_LIKE;
    L13:
        r108.put("action", r112);
        r108.put("reply_level", r105);
        h0.c(r107, r108, r106, r110, 16);
        return;
    L12:
        r112 = "unlike";
        goto L13
    L8:
        r111 = "user";
        goto L9
    }

    public static void e(String r100, String r101, String r102, String r103, int r104, boolean r105, String r106, long r110) {
        Intrinsics.checkNotNullParameter(r100, "gameId");
        Intrinsics.checkNotNullParameter(r101, "gameName");
        Intrinsics.checkNotNullParameter(r102, "anchorId");
        Intrinsics.checkNotNullParameter(r103, "level");
        Intrinsics.checkNotNullParameter(r106, "tagName");
        String r107 = f("livesdk_game_promote_user_reply_write_comment_page_show", r105);
        HashMap r108 = new HashMap();
        r108.put("game_id", r100);
        r108.put(EventConstants.ExtraJson.GAME_NAME, r101);
        String r109 = a();
        if (r109 != null) goto L5;
        r109 = "";
    L5:
        r108.put("user_id", r109);
        r108.put("anchor_id", r102);
        r108.put("reply_comment_level", r103);
        r108.put("comment_keyword", r106);
        r108.put("comment_count", String.valueOf(r110));
        h0.c(r107, r108, r104, r105, 16);
    }

    public static void b(String r100, String r101, String r102, boolean r103, String r104, int r105, boolean r106, String r110, long r111) {
        Intrinsics.checkNotNullParameter(r100, "gameId");
        Intrinsics.checkNotNullParameter(r101, "gameName");
        Intrinsics.checkNotNullParameter(r102, "commentId");
        Intrinsics.checkNotNullParameter(r110, "tagName");
        String r107 = f("livesdk_game_promote_user_comment_like", r106);
        HashMap r108 = new HashMap();
        r108.put("game_id", r100);
        r108.put(EventConstants.ExtraJson.GAME_NAME, r101);
        String r109 = a();
        if (r109 != null) goto L5;
        r109 = "";
    L5:
        r108.put("user_id", r109);
        if (r106 == false) goto L8;
        String r112 = "anchor";
    L9:
        r108.put(DownloadHelper.IDENTITY, r112);
        r108.put("evaluation_id", r102);
        if (r103 == false) goto L12;
        String r113 = IStrategyStateSupplier.KEY_INFO_LIKE;
    L13:
        r108.put("action", r113);
        r108.put("enter_from", r104);
        r108.put("comment_keyword", r110);
        r108.put("comment_count", String.valueOf(r111));
        h0.c(r107, r108, r105, r106, 16);
        return;
    L12:
        r113 = "unlike";
        goto L13
    L8:
        r112 = "user";
        goto L9
    }
}

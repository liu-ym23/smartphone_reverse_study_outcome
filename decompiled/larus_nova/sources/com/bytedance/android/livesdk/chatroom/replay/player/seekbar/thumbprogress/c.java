package com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress;

import com.bytedance.common.utility.DigestUtils;
import com.bytedance.common.utility.StringUtils;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.io.File;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.a f109768a;

    public static final class a {
    }

    static {
    }

    public c(d r100) {
        this.f109768a = r100;
    }

    public static boolean a(VideoThumbInfo r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getValueDouble(8) <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static String b(String r100) {
        String r101 = DigestUtils.md5Hex(r100);
        if (StringUtils.isEmpty(r101) == false) goto L6;
        r101 = "thumbs";
    L6:
        return r101 + ".jpeg";
    }

    public static int c(VideoThumbInfo r100) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        ArrayList<String> r101 = r100.mImgUrlList;
        if (r101 != null) goto L14;
        if (r100.mImgUrl.length() != 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L25;
    L20:
        return 1;
    L25:
        return -1;
    L10:
        r102 = false;
        goto L11
    L14:
        if (r101.size() <= 1) goto L17;
    L21:
        return 2;
    L17:
        if (r100.mImgUrlList.size() == 1) goto L19;
        return -1;
    L19:
        if ((r100.mImgXlen * r100.mImgYlen) <= 30) goto L21;
        goto L20
    }

    public static void d(File r100) {
        Intrinsics.checkNotNullParameter(r100, "fileOrDirectory");
        if (r100.isDirectory() == false) goto L21;
        File[] r101 = r100.listFiles();
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.length == 0) goto L23;
        int r102 = r101.length;
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L16;
        File r104 = r101[r103];
        if (r104.isDirectory() == false) goto L14;
        d(r104);
    L15:
        r103 = r103 + 1;
        goto L10
    L14:
        r104.delete();
        goto L15
    L16:
        r100.delete();
        return;
    L23:
        return;
    }
}

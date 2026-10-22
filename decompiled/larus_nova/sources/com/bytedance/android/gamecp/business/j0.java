package com.bytedance.android.gamecp.business;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.gamecenter.base.order.preres.GResourceDownloadFinishInfo;
import com.bytedance.gamecenter.base.r;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f56142a = 0;

    static {
    }

    public static void a(String r100) {
        com.bytedance.gamecenter.base.q.l().getClass();
        my5.a.h().getClass();
        SharedPreferences r101 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_game_res_download_info", 0);
        Map<String, ?> r102 = r101.getAll();
        if (r102 != null) goto L5;
    L23:
        boolean r103 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        return;
    L5:
        if (r102.size() == 0) goto L23;
        if (TextUtils.isEmpty(r100) == true) goto L23;
        Iterator<Map.Entry<String, ?>> r104 = r102.entrySet().iterator();     // Catch: Throwable -> L22
    L11:
        if (r104.hasNext() == false) goto L37;
        Map.Entry<String, ?> r105 = r104.next();     // Catch: Throwable -> L22
        GResourceDownloadFinishInfo r106 = my5.a.n(new JSONObject(String.valueOf(r105.getValue())));     // Catch: Throwable -> L22
        if (r106.getDownloadInfo() == null) goto L11;
        if (r100.equals(r106.getGamePackageName()) == false) goto L11;
        if (my5.a.o(r106) == false) goto L34;
        r101.edit().remove(r105.getKey()).apply();     // Catch: Throwable -> L22
        my5.a.p(r106);     // Catch: Throwable -> L22
        return;
    L34:
        return;
    L37:
        return;
    L22:
        boolean r107 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
    }

    public static void b(List r100) {
        com.bytedance.gamecenter.base.q.l().getClass();
        my5.a.h().getClass();
        SharedPreferences r101 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_game_res_download_info", 0);
        Map<String, ?> r102 = r101.getAll();
        if (r100 != null) goto L5;
    L24:
        boolean r103 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        return;
    L5:
        if (r100.isEmpty() == true) goto L24;
        if (r102 == null) goto L24;
        if (r102.size() == 0) goto L24;
        Iterator<Map.Entry<String, ?>> r104 = r102.entrySet().iterator();     // Catch: Throwable -> L23
    L12:
        if (r104.hasNext() == false) goto L38;
        Map.Entry<String, ?> r105 = r104.next();     // Catch: Throwable -> L23
        GResourceDownloadFinishInfo r106 = my5.a.n(new JSONObject(String.valueOf(r105.getValue())));     // Catch: Throwable -> L23
        if (r106.getDownloadInfo() == null) goto L12;
        String r107 = r106.getDownloadInfo().getPkgFileName();     // Catch: Throwable -> L23
        r106.getDownloadInfo().getDownloadUrl();     // Catch: Throwable -> L23
        boolean r108 = r.f245056a;     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");     // Catch: Throwable -> L23
        if (r100.contains(r107) == false) goto L12;
        if (my5.a.o(r106) == false) goto L35;
        r101.edit().remove(r105.getKey()).apply();     // Catch: Throwable -> L23
        my5.a.p(r106);     // Catch: Throwable -> L23
        return;
    L35:
        return;
    L38:
        return;
    L23:
        boolean r109 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
    }
}

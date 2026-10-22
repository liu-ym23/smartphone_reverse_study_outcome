package com.bytedance.android.gamecp.business.download;

import android.util.LruCache;
import com.bytedance.android.gamecp.base.core.service.depend.PlatformSupportPkg;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.bytedance.common.utility.Logger;
import com.ss.android.downloadlib.addownload.model.DownloadInstallInfo;
import com.ss.android.downloadlib.utils.ToolUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class GameStatusCacheHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, Triple<Integer, Object, Boolean>> f52434a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, Boolean> f52435b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f52436c = null;

    public GameStatusCacheHelper() {
    }

    public static boolean c() {
        return ((Boolean) f52436c.getValue()).booleanValue();
    }

    static {
        f52434a = new LruCache(3);
        f52435b = new LruCache(30);
        f52436c = LazyKt.lazy(GameStatusCacheHelper$cacheEnable$2.INSTANCE);
    }

    public static Boolean a(String r100) {
        if (r100 == null) goto L4;
        Boolean r101 = f52435b.get(r100);
    L5:
        Logger.i("game-promote", "GameStatusCacheHelper:checkAllChannelInstallStatus enable=" + c() + ",pkgName=" + r100 + ",result=" + r101);
        return r101;
    L4:
        r101 = null;
        goto L5
    }

    public static void b(p r100, DownloadView r110) {
        StringBuilder r101 = new StringBuilder("GameStatusCacheHelper:checkGameDownloadStatus enable=");
        r101.append(c());
        r101.append(",gameId=");
        Object r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.f52855k;
    L6:
        r101.append(r103);
        Logger.i("game-promote", r101.toString());
        int r104 = com.bytedance.android.gamecp.business.i0.f56003a;
        if (r100 == null) goto L9;
        Long r105 = r100.Q;
    L11:
        if (com.bytedance.android.gamecp.business.i0.i(r105) == true) goto L14;
        return;
    L14:
        if (c() == true) goto L16;
        return;
    L16:
        if (r100 == null) goto L124;
        Triple<Integer, Object, Boolean> r106 = f52434a.get(r100.f52855k);
        if (r106 == null) goto L125;
        Logger.i("game-promote", "GameStatusCacheHelper:checkGameDownloadStatus,gameId=" + r100.f52855k + ",triple=" + r106);
        int r107 = r106.getFirst().intValue();
        if (r107 == 0) goto L65;
        if (r107 != 1) goto L23;
        d(1, r100, r110);
        Object r108 = r106.getSecond();
        if ((r108 instanceof com.bytedance.android.gamecp.base.core.service.depend.x) == false) goto L60;
        r102 = r108;
    L60:
        com.bytedance.android.gamecp.base.core.service.depend.x r109 = (com.bytedance.android.gamecp.base.core.service.depend.x) r102;
        if (r109 == null) goto L137;
        if (r110 == null) goto L138;
        r110.onProgress(r109);
        return;
    L138:
        return;
    L137:
        return;
    L23:
        if (r107 != 2) goto L25;
        d(2, r100, r110);
        Object r111 = r106.getSecond();
        if ((r111 instanceof com.bytedance.android.gamecp.base.core.service.depend.x) == false) goto L52;
        r102 = r111;
    L52:
        com.bytedance.android.gamecp.base.core.service.depend.x r112 = (com.bytedance.android.gamecp.base.core.service.depend.x) r102;
        if (r112 == null) goto L134;
        if (r110 == null) goto L135;
        r110.onPause(r112);
        return;
    L135:
        return;
    L134:
        return;
    L25:
        if (r107 == 3) goto L40;
        if (r107 == 6) goto L32;
        if (r107 != 7) goto L149;
        d(7, r100, r110);
        if (r110 == null) goto L126;
        r110.onUpdate();
        return;
    L126:
        return;
    L149:
        return;
    L32:
        d(6, r100, r110);
        Object r113 = r106.getSecond();
        if ((r113 instanceof com.bytedance.android.gamecp.base.core.service.depend.v) == false) goto L36;
        r102 = r113;
    L36:
        com.bytedance.android.gamecp.base.core.service.depend.v r114 = (com.bytedance.android.gamecp.base.core.service.depend.v) r102;
        if (r114 == null) goto L128;
        if (r110 == null) goto L129;
        r110.onInstalled(r114);
        return;
    L129:
        return;
    L128:
        return;
    L40:
        d(3, r100, r110);
        Object r115 = r106.getSecond();
        if ((r115 instanceof String) == false) goto L44;
        r102 = r115;
    L44:
        String r116 = (String) r102;
        if (r116 == null) goto L131;
        if (r110 == null) goto L132;
        r110.onDownloaded(r116);
        return;
    L132:
        return;
    L131:
        return;
    L65:
        if (r106.getThird().booleanValue() == false) goto L115;
        String r117 = r100.f52860m0;
        if (r117 != null) goto L69;
    L72:
        boolean r118 = true;
    L74:
        if (r118 == true) goto L87;
        DownloadInstallInfo r119 = ToolUtils.getInstalledAppInfo(r100.f52860m0, r100.f52856k0, "");
        if (r119 == null) goto L87;
        if (r119.isInstall() == false) goto L83;
        d(6, r100, r110);
        if (r110 == null) goto L140;
        r110.onInstalled(new com.bytedance.android.gamecp.base.core.service.depend.v(false, null));
        return;
    L140:
        return;
    L83:
        if (r119.isNeedUpgrade() == false) goto L87;
        d(7, r100, r110);
        if (r110 == null) goto L142;
        r110.onUpdate();
        return;
    L142:
        return;
    L87:
        List<PlatformSupportPkg> r120 = r100.f52835a;
        if (r120 == null) goto L107;
        Iterator<T> r121 = r120.iterator();
    L91:
        if (r121.hasNext() == false) goto L105;
        Object r122 = r121.next();
        PlatformSupportPkg r123 = (PlatformSupportPkg) r122;
        if (r123.getSupportOpen() == true) goto L95;
    L102:
        boolean r124 = false;
    L103:
        if (r124 == false) goto L91;
    L106:
        PlatformSupportPkg r125 = (PlatformSupportPkg) r122;
    L108:
        if (r125 == null) goto L112;
        d(6, r100, r110);
        if (r110 == null) goto L144;
        r110.onInstalled(new com.bytedance.android.gamecp.base.core.service.depend.v(true, null));
        return;
    L144:
        return;
    L112:
        d(0, r100, r110);
        if (r110 == null) goto L146;
        r110.onReady();
        return;
    L146:
        return;
    L95:
        if (UtilsKt.c(r123.getName()) == false) goto L102;
        LruCache<String, Boolean> r126 = f52435b;
        String r127 = r123.getName();
        if (r127 != null) goto L100;
        r127 = "";
    L100:
        if (Intrinsics.areEqual(r126.get(r127), Boolean.TRUE) == false) goto L102;
        r124 = true;
        goto L103
    L105:
        r122 = null;
        goto L106
    L107:
        r125 = null;
        goto L108
    L69:
        if (r117.length() == 0) goto L72;
        r118 = false;
        goto L74
    L115:
        d(0, r100, r110);
        if (r110 == null) goto L148;
        r110.onReady();
        return;
    L148:
        return;
    L125:
        return;
    L124:
        return;
    L9:
        r105 = null;
        goto L11
    L5:
        r103 = null;
        goto L6
    }

    public static void d(int r100, p r101, DownloadView r102) {
        if (r101 == null) goto L4;
        r101.f52880w0 = r100;
    L4:
        if (r102 == null) goto L7;
        r102.c6();
        return;
    }

    public static void e(String r100, int r101, Object r102, boolean r103, int r104) {
        if ((r104 & 4) == 0) goto L5;
        r102 = null;
    L5:
        boolean r105 = false;
        if ((r104 & 8) == 0) goto L8;
        r103 = false;
    L8:
        Logger.i("game-promote", "GameStatusCacheHelper:setGameDownloadStatus enable=" + c() + ",gameId=" + r100 + ",status=" + r101);
        if (c() == true) goto L12;
        return;
    L12:
        if (r100 != null) goto L14;
    L15:
        r105 = true;
    L17:
        if ((true ^ r105) == true) goto L20;
        r100 = null;
    L20:
        if (r100 == null) goto L27;
        if (r103 == false) goto L25;
        Triple<Integer, Object, Boolean> r106 = f52434a.get(r100);
        if (r106 == null) goto L25;
        Logger.i("game-promote", "GameStatusCacheHelper:setGameDownloadStatus return triple=" + r106);
        return;
    L25:
        Triple<Integer, Object, Boolean> r107 = f52434a.put(r100, new Triple(Integer.valueOf(r101), r102, Boolean.valueOf(r103)));
        return;
    L27:
        return;
    L14:
        if (r100.length() != 0) goto L17;
        goto L15
    }
}

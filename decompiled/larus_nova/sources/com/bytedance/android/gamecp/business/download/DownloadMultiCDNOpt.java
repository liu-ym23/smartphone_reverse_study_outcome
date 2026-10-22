package com.bytedance.android.gamecp.business.download;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.gamecenter.base.multicdn.GDownloadMultiCDNConfig;
import com.bytedance.gamecenter.base.multicdn.GDownloadMultiCDNHostConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class DownloadMultiCDNOpt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f52336a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f52337b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f52338c = null;

    static {
        f52336a = LazyKt.lazy(DownloadMultiCDNOpt$strategy$2.INSTANCE);
        f52337b = LazyKt.lazy(DownloadMultiCDNOpt$supAllGameStrategy$2.INSTANCE);
        f52338c = LazyKt.lazy(DownloadMultiCDNOpt$cdnFixStrategy$2.INSTANCE);
    }

    public static JSONObject b(GDownloadMultiCDNConfig r100) {
        JSONObject r101 = new JSONObject();
        r101.putOpt(BdpAppEventConstant.PARAMS_STRATEGY_NAME, Integer.valueOf(r100.getStrategy()));     // Catch: Exception -> L11
        List<GDownloadMultiCDNHostConfig> r102 = r100.getCdnHostList();     // Catch: Exception -> L11
        if (r102 == null) goto L10;
        JSONArray r103 = new JSONArray();     // Catch: Exception -> L11
        Iterator<T> r104 = r102.iterator();     // Catch: Exception -> L11
    L7:
        if (r104.hasNext() == false) goto L9;
        r103.put(c((GDownloadMultiCDNHostConfig) r104.next()));     // Catch: Exception -> L11
        goto L7
    L9:
        r101.put("cdn_array", r103);     // Catch: Exception -> L11
    L10:
        return r101;
    }

    public static JSONObject c(GDownloadMultiCDNHostConfig r100) {
        JSONObject r101 = new JSONObject();
        String r102 = r100.getMainHost();     // Catch: Exception -> L14
        if (r102 == null) goto L6;
        r101.putOpt("main_host", r102);     // Catch: Exception -> L14
    L6:
        JSONArray r103 = new JSONArray();     // Catch: Exception -> L14
        List<String> r104 = r100.getSupCDNList();     // Catch: Exception -> L14
        if (r104 == null) goto L12;
        Iterator<T> r105 = r104.iterator();     // Catch: Exception -> L14
    L10:
        if (r105.hasNext() == false) goto L12;
        r103.put((String) r105.next());     // Catch: Exception -> L14
    L12:
        Unit r106 = Unit.INSTANCE;     // Catch: Exception -> L14
        r101.put("cdn_list", r103);     // Catch: Exception -> L14
    L13:
        return r101;
    }

    public static void a(JSONObject r100, com.bytedance.android.gamecp.business.api.response.b r101) {
        Intrinsics.checkNotNullParameter(r100, "extraObj");
        Intrinsics.checkNotNullParameter(r101, "downloadInfo");
        Lazy r102 = f52338c;
        Integer r103 = (Integer) r102.getValue();
        if (r103 != null) goto L6;
    L17:
        Integer r104 = (Integer) r102.getValue();
        if (r104 != null) goto L21;
    L26:
        yr.c.a("DownloadMultiCDNOpt", "build backup_urls:" + r100.optJSONArray(AdDownloadModel.JsonKey.BACKUP_URLS));
        return;
    L21:
        if (r104.intValue() != 2) goto L26;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L24
        Result.m9449constructorimpl(r100.put(AdDownloadModel.JsonKey.BACKUP_URLS, new JSONArray()));     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L6:
        if (r103.intValue() != 1) goto L17;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L15
        JSONArray r108 = new JSONArray();     // Catch: Throwable -> L15
        List<String> r109 = r101.backupUrls;     // Catch: Throwable -> L15
        if (r109 == null) goto L13;
        Iterator<T> r110 = r109.iterator();     // Catch: Throwable -> L15
    L11:
        if (r110.hasNext() == false) goto L13;
        r108.put((String) r110.next());     // Catch: Throwable -> L15
    L13:
        Result.m9449constructorimpl(r100.put(AdDownloadModel.JsonKey.BACKUP_URLS, r108));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    }
}

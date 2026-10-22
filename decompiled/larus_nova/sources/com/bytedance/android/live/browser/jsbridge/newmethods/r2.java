package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.retrofit2.mime.DigestUtil;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "liveDownloadMedia")
public final class r2 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f63626a = 0;

    public static final class a {
    }

    static {
    }

    public r2() {
    }

    public static final void k(r2 r100) {
        r100.getClass();
        LiveTracingMonitor.EventModule r101 = LiveTracingMonitor.EventModule.OPEN_LIVE;
        JSONObject r102 = new JSONObject();
        r102.put("status_code", 0);     // Catch: JSONException -> L8
    L12:
        r102.put("type", "jsb_download");     // Catch: JSONException -> L9
    L6:
        LiveMonitor r103 = new LiveMonitor();
        r103.mCategory = r102;
        r103.mEventModule = r101;
        r103.mServiceName = "ttlive_anchor_high_light_metadata_monitor";
        r103.mExtraLog = null;
        r103.mMetrics = null;
        LiveMonitor.access$002(r103, true);
        LiveMonitor.access$102(r103, true);
        LiveMonitor.access$202(r103, true);
        LiveMonitor.access$302(r103, false);
        LiveMonitor.access$402(r103, false);
        r103.report();
    }

    public static void o(String r100) {
        IBrowserService r101 = (IBrowserService) jc1.k.n(IBrowserService.class);
        JSONObject r102 = new JSONObject();
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        r102.put("extra_success", true ^ r103);
        r102.put("extra_file_path", r100);
        Unit r104 = Unit.INSTANCE;
        r101.sendEventToAllJsBridges("download_media_callback", r102);
        return;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r103 = false;
        goto L9
    }

    public static final void j(r2 r100, PolarisFileWrapper r101) {
        r100.getClass();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        if (r101.exists() == false) goto L6;
        r101.delete();     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static ParcelFileDescriptor l(ContentResolver r210, Uri r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, "w"};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        f06.d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r210, r101, "android.os.ParcelFileDescriptor", r110);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r210, r211, "w");
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Uri m(String r100, String r101) {
        if (StringsKt.startsWith$default(r100, "image", false, 2, null) == false) goto L6;
        return BdMediaFileSystem.createImageUri(com.bytedance.android.live.core.utils.s1.getContext(), r101);
    L6:
        if (StringsKt.startsWith$default(r100, "audio", false, 2, null) == false) goto L9;
        return BdMediaFileSystem.createMusicUri(com.bytedance.android.live.core.utils.s1.getContext(), r101);
    L9:
        return BdMediaFileSystem.createVideoUri(com.bytedance.android.live.core.utils.s1.getContext(), r101);
    }

    public static JSONObject n(boolean r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("success", r100);
        r102.put("msg", r101);
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [T, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v0, types: [T, java.lang.String] */
    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(JSONObject r110, CallContext r111) {
        JSONObject r112 = r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        ?? r100 = r112.optString("url", "");
        String r101 = r112.optString("mime", "");
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = MapsKt.emptyMap();
        if (com.bytedance.android.livesdk.config.nb.f120818a.getValue().booleanValue() == false) goto L10;
        String r103 = r112.optString("meta_data", "");
        if (r103.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L10;
        r102.element = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("LvMetaInfo", r103)});
        goto L10
    L7:
        r104 = false;
    L10:
        String r105 = r112.optString("success_toast", "");
        File r106 = com.bytedance.android.live.core.utils.s1.getContext().getExternalCacheDir();
        StringBuilder r107 = new StringBuilder();
        Charset r108 = Charsets.UTF_8;
        if (r100 == 0) goto L43;
        r107.append(DigestUtil.md5Hex(r100.getBytes(r108)));
        r107.append('.');
        r107.append(StringsKt.substringAfter$default(r101, '/', null, 2, null));
        String r109 = r107.toString();
        if (r106 != null) goto L15;
    L40:
        String r113 = "file name invalid suffix, params mime is: " + r101 + ", tmp path: " + r106;
        ALogger.w("JSB_DownloadMedia", r113);
        return n(false, r113);
    L15:
        if (StringsKt.isBlank(r101) == true) goto L40;
        if (StringsKt.endsWith$default(r109, '.', false, 2, null) == true) goto L40;
        if (StringsKt.startsWith$default(r101, "image", false, 2, null) == false) goto L23;
        Uri r114 = BdMediaFileSystem.getImageContentUri(com.bytedance.android.live.core.utils.s1.getContext(), r109);
    L26:
        if (r114 == null) goto L28;
        boolean r115 = true;
    L29:
        if (r115 == false) goto L32;
        ALogger.i("JSB_DownloadMedia", "file already downloaded(at " + r109 + "), callback success");
        return n(true, "already downloaded");
    L32:
        if (r112.optBoolean("is_local_file", false) == false) goto L39;
        ALogger.i("JSB_DownloadMedia", "is local file");
        Map r116 = (Map) r102.element;
        Ref.ObjectRef r117 = new Ref.ObjectRef();     // Catch: Throwable -> L36
        r117.element = r100;     // Catch: Throwable -> L36
        TTExecutors.getNormalExecutor().submit(new s2(this, r116, r117, r100, l(r111.getContext().getContentResolver(), m(r101, r109)), r105));     // Catch: Throwable -> L36
    L47:
        return n(true, "begin transform local file");
    L36:
        th = move-exception;
        o(null);
        ALogger.w("JSB_DownloadMedia", th.getMessage());
        goto L47
    L39:
        Downloader.with(com.bytedance.android.live.core.utils.s1.getContext()).url(r100).monitorScene("live_jsb_download_media").name(r109).savePath(r106.getAbsolutePath()).retryCount(3).mainThreadListener(new t2(this, r101, r109, r111, r102, r105, r100)).download();
        return n(true, "begin download");
    L28:
        r115 = false;
        goto L29
    L23:
        if (StringsKt.startsWith$default(r101, "audio", false, 2, null) == false) goto L25;
        r114 = BdMediaFileSystem.getMusicContentUri(com.bytedance.android.live.core.utils.s1.getContext(), r109);
        goto L26
    L25:
        r114 = BdMediaFileSystem.getVideoContentUri(com.bytedance.android.live.core.utils.s1.getContext(), r109);
        goto L26
    L43:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}

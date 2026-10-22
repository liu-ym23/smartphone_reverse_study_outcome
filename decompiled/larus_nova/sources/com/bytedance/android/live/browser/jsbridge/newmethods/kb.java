package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.view.View;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.retrofit2.mime.DigestUtil;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "liveSaveHighlightVideo")
public final class kb extends k<w6, LiveSaveHighlightVideoResultModel> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f63513b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TokenCert f63514a;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kb f63515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f63516b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f63517c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f63518d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f63519e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f63520f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f63521g;

        public b(kb r100, Ref.BooleanRef r101, Context r102, int r103, String r104, String r105, String r106) {
            this.f63515a = r100;
            this.f63516b = r101;
            this.f63517c = r102;
            this.f63518d = r103;
            this.f63519e = r104;
            this.f63520f = r105;
            this.f63521g = r106;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f63516b.element == true) goto L6;
            Downloader.getInstance(this.f63517c).cancel(this.f63518d, true);
            kb r101 = this.f63515a;
            int r102 = kb.f63513b;
            kb.m(r101, null, "CancelDownload", null, "user cancel download, with url " + this.f63519e, 4);
            kb r103 = this.f63515a;
            String r104 = this.f63520f;
            String r105 = this.f63521g;
            r103.getClass();
            kb.l(r104, r105, "fail", 2);
            return;
        }
    }

    public static final class c extends AbsDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kb f63522a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f63523b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f63524c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f63525d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ km3.g f63526e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f63527f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f63528g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f63529h;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f63530a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f63531b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ParcelFileDescriptor f63532c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f63533d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Uri f63534e;

            public a(c r100, String r101, ParcelFileDescriptor r102, DownloadInfo r103, Uri r104) {
                this.f63530a = r100;
                this.f63531b = r101;
                this.f63532c = r102;
                this.f63533d = r103;
                this.f63534e = r104;
            }

            public final void a() {
                PolarisFileInputStreamWrapper r100 = new PolarisFileInputStreamWrapper(this.f63531b);     // Catch: Throwable -> L5
                PolarisFileOutputStreamWrapper r101 = new PolarisFileOutputStreamWrapper(this.f63532c.getFileDescriptor());     // Catch: Throwable -> L5
                int r102 = kb.f63513b;     // Catch: Throwable -> L5
                ALogger.i("JSB_SaveHighlightVideo", "copy from " + r100 + " to " + r101);     // Catch: Throwable -> L5
                FileUtils.fileChannelCopy(r100, r101);     // Catch: Throwable -> L5
                new PolarisFileWrapper(this.f63533d.getTargetFilePath()).delete();     // Catch: Throwable -> L5
                c r103 = this.f63530a;     // Catch: Throwable -> L5
                kb r104 = r103.f63522a;     // Catch: Throwable -> L5
                km3.g r105 = r103.f63526e;     // Catch: Throwable -> L5
                r104.getClass();     // Catch: Throwable -> L5
                MainThreadPostUtils.e(new lb(r105));     // Catch: Throwable -> L5
                kb r106 = this.f63530a.f63522a;     // Catch: Throwable -> L5
                Uri r107 = this.f63534e;     // Catch: Throwable -> L5
                r106.getClass();     // Catch: Throwable -> L5
                kb.m(r106, kb.n(r107), "Success", null, "copy complete, with url " + this.f63530a.f63527f, 4);     // Catch: Throwable -> L5
                c r108 = this.f63530a;     // Catch: Throwable -> L5
                kb r109 = r108.f63522a;     // Catch: Throwable -> L5
                String r110 = r108.f63528g;     // Catch: Throwable -> L5
                String r111 = r108.f63529h;     // Catch: Throwable -> L5
                r109.getClass();     // Catch: Throwable -> L5
                kb.l(r110, r111, "success", null);     // Catch: Throwable -> L5
                return;
            L5:
                th = move-exception;
                c r112 = this.f63530a;
                kb r113 = r112.f63522a;
                km3.g r114 = r112.f63526e;
                int r115 = kb.f63513b;
                r113.getClass();
                MainThreadPostUtils.e(new lb(r114));
                kb.m(this.f63530a.f63522a, null, "DownLoadFail", "inner catch, copy fail, exception:" + th.getMessage(), null, 8);
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onProgress(DownloadInfo r100) {
            super.onProgress(r100);
            if (r100 != null) goto L6;
            return;
        L6:
            if (r100.getTotalBytes() > 0) goto L8;
            int r101 = 0;
        L9:
            this.f63526e.setProgress(r101);
            return;
        L8:
            r101 = (int) ((r100.getCurBytes() / r100.getTotalBytes()) * 100);
            goto L9
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onSuccessed(DownloadInfo r110) {
            Intrinsics.checkNotNullParameter(r110, "entity");
            super.onSuccessed(r110);
            this.f63523b.element = true;
            String r100 = r110.getTargetFilePath();
            kb r101 = this.f63522a;     // Catch: Throwable -> L13
            String r102 = this.f63524c;     // Catch: Throwable -> L13
            r101.getClass();     // Catch: Throwable -> L13
            Uri r103 = BdMediaFileSystem.createVideoUri(com.bytedance.android.live.core.utils.s1.getContext(), r102);     // Catch: Throwable -> L13
            if (r103 != null) goto L7;
            kb.m(this.f63522a, null, "OtherError", "download fail, createMediaUri get null", null, 8);     // Catch: Throwable -> L13
            return;
        L7:
            ParcelFileDescriptor r104 = a(this.f63525d.getContentResolver(), r103);     // Catch: Throwable -> L13
            if (r104 != null) goto L11;
            kb.m(this.f63522a, null, "OtherError", "download fail, file descriptor is null", null, 8);     // Catch: Throwable -> L13
            return;
        L11:
            TTExecutors.getNormalExecutor().submit(new a(this, r100, r104, r110, r103));     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            kb r105 = this.f63522a;
            km3.g r106 = this.f63526e;
            r105.getClass();
            MainThreadPostUtils.e(new lb(r106));
            kb.m(this.f63522a, null, "DownLoadFail", "outer catch, copy fail, exception:" + th.getMessage(), null, 8);
        }

        public static ParcelFileDescriptor a(ContentResolver r210, Uri r211) {
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

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFailed(DownloadInfo r100, BaseException r101) {
            Intrinsics.checkNotNullParameter(r100, "entity");
            Intrinsics.checkNotNullParameter(r101, "e");
            super.onFailed(r100, r101);
            kb r102 = this.f63522a;
            km3.g r103 = this.f63526e;
            r102.getClass();
            MainThreadPostUtils.e(new lb(r103));
            kb.m(this.f63522a, null, "DownLoadFail", "download failed, with url " + this.f63527f, null, 8);
            kb r104 = this.f63522a;
            String r105 = this.f63528g;
            String r106 = this.f63529h;
            r104.getClass();
            kb.l(r105, r106, "fail", 1);
        }

        public c(kb r100, Ref.BooleanRef r101, String r102, Context r103, km3.g r104, String r105, String r106, String r107) {
            this.f63522a = r100;
            this.f63523b = r101;
            this.f63524c = r102;
            this.f63525d = r103;
            this.f63526e = r104;
            this.f63527f = r105;
            this.f63528g = r106;
            this.f63529h = r107;
        }
    }

    static {
    }

    public kb() {
        this.f63514a = TokenCert.Companion.with("bpea-live_saveHighlightVideoMethod_jsb_storage_permission");
    }

    public static String n(Uri r100) {
        String r101 = r100.toString();
        int r102 = StringsKt.lastIndexOf$default(r101, '/', 0, false, 6, null) + 1;
        if (r101 == null) goto L7;
        return r101.substring(r102);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r210, final CallContext r211) {
        w6 r100 = (w6) r210;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = r100.c();
        if (r101 != null) goto L5;
        final String r102 = "";
    L6:
        final String r103 = r100.d();
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        String r104 = r100.b();
        if (r104 != null) goto L12;
        final String r110 = "";
    L13:
        Integer r105 = r100.a();
        boolean r106 = false;
        if (r105 != null) goto L17;
    L18:
        final boolean r107 = true;
    L21:
        if (Intrinsics.areEqual(r102, "") == false) goto L24;
        m(this, null, "OtherError", "check params fail, with url " + r102 + ", with vid " + r103, null, 8);
    L56:
        return;
    L24:
        if (Intrinsics.areEqual(r103, "") == false) goto L30;
        StringBuilder r108 = new StringBuilder();
        String r109 = "highlight".concat(r102);
        Charset r111 = Charsets.UTF_8;
        if (r109 == null) goto L29;
        r108.append(DigestUtil.md5Hex(r109.getBytes(r111)));
        r108.append(".mp4");
        String r112 = r108.toString();
        ALogger.w("JSB_SaveHighlightVideo", "vid is null, use url as filename");
    L31:
        int r113 = Build.VERSION.SDK_INT;
        if (r113 >= 23) goto L34;
    L36:
        if (r106 == false) goto L51;
        Context r114 = r211.getContext();
        if ((r114 instanceof Activity) == true) goto L40;
        r114 = null;
    L40:
        final Activity r115 = (Activity) r114;
        if (r115 != null) goto L44;
        m(this, null, "OtherError", "check permission fail, activity is null", null, 8);
        goto L56
    L44:
        final List r116 = CollectionsKt.listOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"});
        if (m60.c.c(r115, r116) == true) goto L51;
        final String r117 = r112;
        final String r118 = r110;
        final String r119 = r103;
        final Function1<List<? extends String>, Unit> r120 = new SaveHighlightVideoMethod$invoke$1(this, r117, r211, r102, r107, r118, r119);
        final Function1<List<? extends String>, Unit> r121 = new SaveHighlightVideoMethod$invoke$2(this, r110, r103);
        ALogger.i("JSB_SaveHighlightVideo", "show permission dialog");
        z20.c r122 = new z20.c(r115, new SaveHighlightVideoMethod$showPermissionDialog$1(this, r115, r120, r121, r116), new SaveHighlightVideoMethod$showPermissionDialog$2(r121));
        if (DialogLancet.shouldBlockDialogShow(r122) == false) goto L54;
        DialogLancet.handleBlockedDialogShow(r122);
        return;
    L54:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L53
    L50:
        DialogLancet.beforeDialogShow(r122);
        r122.show();
        DialogLancet.afterDialogShow(r122);
        return;
    L51:
        j(r112, r211.getContext(), r102, r107, r110, r103);
        ALogger.i("JSB_SaveHighlightVideo", "no need to request permission");
        return;
    L34:
        if (r113 > 28) goto L36;
        r106 = true;
        goto L36
    L29:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L30:
        r112 = DigestUtil.md5Hex(r103.getBytes(Charsets.UTF_8)) + ".mp4";
        goto L31
    L17:
        if (r105.intValue() != 0) goto L18;
        r107 = false;
        goto L21
    L12:
        r110 = r104;
        goto L13
    L5:
        r102 = r101;
        goto L6
    }

    public static void l(String r100, String r101, String r102, Integer r103) {
        Map<String, String> r104 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("anchor_id", r100), TuplesKt.to("item_id", r101), TuplesKt.to("download_status", r102)});
        if (r103 == null) goto L5;
        r104.put("error_code", String.valueOf(r103.intValue()));
    L5:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_material_download_status", r104, new Object[0]);
    }

    public final void k(Context r110, String r111, String r112, String r113, String r210) {
        km3.g r100 = km3.g.c(r110, "导入中");
        r100.b();
        File r101 = com.bytedance.android.live.core.utils.s1.getContext().getExternalCacheDir();
        if (r101 != null) goto L6;
        m(this, null, "OtherError", "download fail, savePath is null", null, 8);
        return;
    L6:
        Ref.BooleanRef r114 = new Ref.BooleanRef();
        r114.element = false;
        r100.f504062g = new b(this, r114, r110, Downloader.with(com.bytedance.android.live.core.utils.s1.getContext()).url(r112).monitorScene("live_jsb_save_highlight_video").name(r111).savePath(r101.getAbsolutePath()).retryCount(3).mainThreadListener(new c(this, r114, r111, r110, r100, r112, r113, r210)).download(), r112, r113, r210);
    }

    public static void m(kb r100, String r101, String r102, String r103, String r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r103 = null;
    L6:
        if ((r105 & 8) == 0) goto L8;
        r104 = null;
    L8:
        r100.getClass();
        LiveSaveHighlightVideoResultModel r106 = new LiveSaveHighlightVideoResultModel();
        boolean r107 = false;
        if (r101 != null) goto L11;
    L14:
        boolean r108 = true;
    L15:
        if (r108 == true) goto L17;
        LiveSaveHighlightVideoResultModel.Code r109 = LiveSaveHighlightVideoResultModel.Code.Success;
    L18:
        r106.a(r109);
        r106.c(r102);
        LiveSaveHighlightVideoResultModel.a r110 = new LiveSaveHighlightVideoResultModel.a();
        if (r101 != null) goto L21;
    L22:
        r107 = true;
    L23:
        r110.b(Boolean.valueOf(!r107));
        r110.a(r101);
        Unit r111 = Unit.INSTANCE;
        r106.b(r110);
        r100.finishWithResult(r106);
        if (r103 == null) goto L26;
        ALogger.w("JSB_SaveHighlightVideo", r103);
    L26:
        if (r104 == null) goto L29;
        ALogger.i("JSB_SaveHighlightVideo", r104);
        return;
    L29:
        return;
    L21:
        if (StringsKt.isBlank(r101) == false) goto L23;
    L17:
        r109 = LiveSaveHighlightVideoResultModel.Code.Failed;
        goto L18
    L11:
        if (StringsKt.isBlank(r101) == true) goto L14;
        r108 = false;
        goto L15
    }

    public final void j(String r100, Context r101, String r102, boolean r110, String r111, String r112) {
        if (r110 == false) goto L7;
        Uri r113 = BdMediaFileSystem.getVideoContentUri(com.bytedance.android.live.core.utils.s1.getContext(), r100);
        if (r113 == null) goto L6;
        m(this, n(r113), "Success", null, "file already downloaded(at " + r100 + "), callback success", 4);
        l(r111, r112, "success", null);
        return;
    L6:
        k(r101, r100, r102, r111, r112);
        return;
    L7:
        k(r101, r100, r102, r111, r112);
    }
}

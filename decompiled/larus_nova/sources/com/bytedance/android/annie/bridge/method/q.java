package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import com.bytedance.android.annie.util.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class q implements com.bytedance.android.annie.bridge.method.permission.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f38782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f38783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DownloadFileMethod.a f38784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LinkedHashMap<String, String> f38785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f38786e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Integer f38787f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ DownloadFileMethod f38788g;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadFileMethod f38789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DownloadFileMethod.DownloadFileResModel f38790b;

        public a(DownloadFileMethod r100, DownloadFileMethod.DownloadFileResModel r101) {
            this.f38789a = r100;
            this.f38790b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f38789a.finishWithResult(this.f38790b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadFileMethod f38791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f38792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Integer f38793c;

        public b(DownloadFileMethod r100, int r101, Integer r102) {
            this.f38791a = r100;
            this.f38792b = r101;
            this.f38793c = r102;
        }

        public final void a() {
            DownloadFileMethod r100 = this.f38791a;
            DownloadFileMethod.DownloadFileResModel r101 = new DownloadFileMethod.DownloadFileResModel();
            int r102 = this.f38792b;
            Integer r103 = this.f38793c;
            r101.b(DownloadFileMethod.DownloadFileResModel.Code.Failed);
            r101.f("Failed for permission rejected");
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
            Object r105 = Result.m9449constructorimpl(Integer.valueOf(r102));     // Catch: Throwable -> L5
        L8:
            if (Result.m9455isFailureimpl(r105) == false) goto L10;
            r105 = 0;
        L10:
            r101.e((Integer) r105);
            if (r103 != null) goto L26;
            Integer r106 = null;
        L16:
            Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L13
        L20:
            if (Result.m9455isFailureimpl(r107) == false) goto L22;
            r107 = 0;
        L22:
            r101.a((Integer) r107);
            r100.finishWithResult(r101);
            return;
        L13:
            th = move-exception;
            Result.Companion r108 = Result.Companion;
            r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L20
        L26:
            r106 = Integer.valueOf(r103.intValue());     // Catch: Throwable -> L13
        L5:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L8
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

    @Override // com.bytedance.android.annie.bridge.method.permission.b
    public final void onRequestPermissionsResult(int r100, String[] r101, int[] r102) {
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r102, "grantResults");
        if (ContextCompat.checkSelfPermission(this.f38782a, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L51;
        int r103 = com.bytedance.android.annie.util.k.f40065a;
        Context r104 = this.f38782a;
        String r105 = this.f38783b;
        String r106 = this.f38784c.e();
        Intrinsics.checkNotNull(r106);
        Integer r107 = null;
        Pair r108 = com.bytedance.android.annie.util.k.a(r104, r105, Intrinsics.areEqual(r106, "image"), null, null);
        if (r108 == null) goto L7;
        Uri r109 = (Uri) r108.getFirst();
    L9:
        if (r109 == null) goto L11;
        boolean r110 = true;
    L12:
        DownloadFileMethod.DownloadFileResModel r111 = new DownloadFileMethod.DownloadFileResModel();
        LinkedHashMap<String, String> r112 = this.f38785d;
        int r113 = this.f38786e;
        Integer r114 = this.f38787f;
        if (r110 == false) goto L31;
        r111.b(DownloadFileMethod.DownloadFileResModel.Code.Success);
        r111.f("Success");
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L17
        Object r116 = Result.m9449constructorimpl(Integer.valueOf(r113));     // Catch: Throwable -> L17
    L20:
        if (Result.m9455isFailureimpl(r116) == false) goto L22;
        r116 = 0;
    L22:
        r111.e((Integer) r116);
        Object r117 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L25
    L28:
        if (Result.m9455isFailureimpl(r117) == false) goto L30;
        r117 = 0;
    L30:
        r111.a((Integer) r117);
        r111.d(r112);
        r111.c(String.valueOf(r110));
    L50:
        ThreadUtils.a().post(new a(this.f38788g, r111));
        return;
    L25:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L17:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L31:
        r111.b(DownloadFileMethod.DownloadFileResModel.Code.Failed);
        r111.f("Failed");
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L34
        Object r121 = Result.m9449constructorimpl(Integer.valueOf(r113));     // Catch: Throwable -> L34
    L37:
        if (Result.m9455isFailureimpl(r121) == false) goto L39;
        r121 = 0;
    L39:
        r111.e((Integer) r121);
        if (r114 != null) goto L57;
    L42:
        Object r122 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L44
    L47:
        if (Result.m9455isFailureimpl(r122) == false) goto L49;
        r122 = 0;
    L49:
        r111.a((Integer) r122);
    L44:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L47
    L57:
        r107 = Integer.valueOf(r114.intValue());     // Catch: Throwable -> L44
    L34:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L37
    L11:
        r110 = false;
        goto L12
    L7:
        r109 = null;
        goto L9
    L51:
        ThreadUtils.a().post(new b(this.f38788g, this.f38786e, this.f38787f));
    }

    public q(Context r100, String r101, DownloadFileMethod.a r102, LinkedHashMap<String, String> r103, int r104, Integer r105, DownloadFileMethod r106) {
        this.f38782a = r100;
        this.f38783b = r101;
        this.f38784c = r102;
        this.f38785d = r103;
        this.f38786e = r104;
        this.f38787f = r105;
        this.f38788g = r106;
    }
}

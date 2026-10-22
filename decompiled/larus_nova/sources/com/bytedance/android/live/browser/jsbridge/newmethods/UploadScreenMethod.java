package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.base.model.user.UploadResult;
import com.bytedance.android.live.browser.api.UploadApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnetuploader.uploader.api.Parameters;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "uploadScreenshot")
public final class UploadScreenMethod extends com.bytedance.ies.web.jsbridge2.f<JSONObject, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f63277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f63278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ProgressDialog f63279c;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/UploadScreenMethod$b;", "", "", "uri", "Ljava/lang/String;", "getUri", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "localUrl", "getLocalUrl", "setLocalUrl", "localImg", "getLocalImg", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("local_img")
        private String localImg;

        @SerializedName("local_url")
        private String localUrl;

        @SerializedName("uri")
        private String uri;

        public b() {
        }

        public final void a(String r100) {
            this.localImg = r100;
        }

        public final void b(String r100) {
            this.uri = r100;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/UploadScreenMethod$c;", "", "", "code", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/Integer;", "setCode", "(Ljava/lang/Integer;)V", "status", "getStatus", "setStatus", "", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "Ljava/lang/String;", "getStatusMsg", "()Ljava/lang/String;", "setStatusMsg", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/browser/jsbridge/newmethods/UploadScreenMethod$b;", "data", "Lcom/bytedance/android/live/browser/jsbridge/newmethods/UploadScreenMethod$b;", "getData", "()Lcom/bytedance/android/live/browser/jsbridge/newmethods/UploadScreenMethod$b;", "setData", "(Lcom/bytedance/android/live/browser/jsbridge/newmethods/UploadScreenMethod$b;)V", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("code")
        private Integer code;

        @SerializedName("data")
        private b data;

        @SerializedName("status")
        private Integer status;

        @SerializedName("status_msg")
        private String statusMsg;

        public c() {
        }

        public c(int r100, String r101, b r102) {
            Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
            Intrinsics.checkNotNullParameter(r102, "data");
            this.code = 1;
            this.status = Integer.valueOf(r100);
            this.statusMsg = r101;
            this.data = r102;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f63277a;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public UploadScreenMethod() {
        this.f63278b = LazyKt.lazy(UploadScreenMethod$offlineResourceInterceptor$2.INSTANCE);
    }

    public static final void j(UploadScreenMethod r100) {
        ProgressDialog r101 = r100.f63279c;
        if (r101 == null) goto L21;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r101);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r103 == null) goto L18;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r102.getLooper()) goto L9;
        r102.post(DialogLancet.createDismissRunnable(r101));
        return;
    }

    public final void k(b r100) {
        finishWithResult(new c(1, "失败", r100));
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r110) {
        JSONObject r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r102 = r101.optString("scene");
        b r103 = new b();
        String r104 = com.bytedance.android.livesdk.utils.i0.f158982a;
        if (r104 != null) goto L5;
    L8:
        boolean r105 = true;
    L10:
        if (r105 == false) goto L12;
        k(r103);
        ALogger.e("UploadScreenMethod", "path is null");
        return;
    L12:
        if (r102 == null) goto L65;
        int r106 = r102.hashCode();
        if (r106 == (-838595071)) goto L30;
        if (r106 == 3529469) goto L20;
        return;
    L20:
        if (r102.equals("show") == false) goto L60;
        o30.c.f521865b.b(r110.getContext().getCacheDir().getCanonicalPath());     // Catch: IOException -> L23
    L25:
        com.bytedance.android.annie.util.q r107 = com.bytedance.android.annie.util.g.a(r110.getContext(), r104);
        if (r107.f40072a == false) goto L28;
        b r111 = new b();
        o30.c r108 = (o30.c) this.f63278b.getValue();
        String r109 = r107.f40073b;
        r108.getClass();
        r111.a(o30.c.a(r109));
        Unit r112 = Unit.INSTANCE;
        finishWithResult(new c(0, "成功", r111));
        ALogger.i("UploadScreenMethod", "show finish success");
        return;
    L28:
        k(r103);
        return;
    L23:
        e = move-exception;
        ALogger.e("UploadScreenMethod", e);
        goto L25
    L60:
        return;
    L30:
        if (r102.equals("upload") == false) goto L63;
        Intrinsics.checkNotNullParameter(r104, "filePath");
        Intrinsics.checkNotNullParameter(r101, "params");
        PolarisFileWrapper r113 = new PolarisFileWrapper(r104);
        if (r113.exists() == true) goto L34;
        k(new b());
        ALogger.e("UploadScreenMethod", "upload error,file is not exist");
        return;
    L34:
        MultipartTypedOutput r114 = new MultipartTypedOutput();
        r114.addPart("data", new TypedFile(Parameters.CONTENT_TYPE_MULTIPART_FORM, r113));
        if (this.f63279c != null) goto L39;
        ProgressDialog r115 = new ProgressDialog(getCallContext().getContext());
        this.f63279c = r115;
        r115.setMessage(com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_live_uploading_live_pic));
        ProgressDialog r116 = this.f63279c;
        if (r116 == null) goto L39;
        r116.setCancelable(false);
    L39:
        ProgressDialog r117 = this.f63279c;
        if (r117 != null) goto L42;
    L48:
        boolean r118 = r101.optBoolean("use_fe_url", false);
        String r119 = r101.optString("url");
        if (r118 == false) goto L51;
        Single<Response<UploadResult>> r120 = ((UploadApi) com.bytedance.android.live.network.c.b().e(UploadApi.class)).upload(r119, r114);
    L52:
        ((du2.c) r120.compose(RxUtil.rxSchedulerHelper()).as(new du2.d())).a(pd.f63609a).subscribe(new qd(this, r104));
        return;
    L51:
        r120 = ((UploadApi) com.bytedance.android.live.network.c.b().e(UploadApi.class)).upload(r114);
        goto L52
    L42:
        if (r117.isShowing() == true) goto L48;
        if (DialogLancet.shouldBlockDialogShow(r117) == false) goto L55;
        DialogLancet.handleBlockedDialogShow(r117);
        goto L48
    L55:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L54
    L47:
        DialogLancet.beforeDialogShow(r117);
        r117.show();
        DialogLancet.afterDialogShow(r117);
        goto L48
    L63:
        return;
    L65:
        return;
    L5:
        if (r104.length() == 0) goto L8;
        r105 = false;
        goto L10
    }
}

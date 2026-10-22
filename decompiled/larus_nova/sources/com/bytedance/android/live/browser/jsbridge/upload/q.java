package com.bytedance.android.live.browser.jsbridge.upload;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.gaiax.template.GXMode;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.UploadResult;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.TTLiveFileProvider;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livesdk.chatroom.ui.n6;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.internal.ImmutableList;
import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.bduploader.BDImageXInfo;
import com.ss.bduploader.BDImageXUploader;
import com.ss.bduploader.BDImageXUploaderListener;
import com.ss.texturerender.TextureRenderKeys;
import com.ttnetuploader.uploader.api.Parameters;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class q extends com.bytedance.ies.web.jsbridge2.f<JSONObject, f> {
    public String A;
    public TokenCert B;
    public TokenCert C;
    public n6 D;
    public z E;
    public boolean F;
    public final boolean G;
    public Uri H;
    public Uri I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f64048J;
    public boolean K;
    public ByteArrayOutputStream L;
    public Bitmap M;
    public int N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f64049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f64050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f64051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f64052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Fragment f64053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ProgressDialog f64054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CallContext f64055g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f64056h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f64057i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f64058j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f64059k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f64060l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f64061m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f64062n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f64063o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public JSONObject f64064p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f64065q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f64066r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f64067s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f64068t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f64069u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f64070v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f64071w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f64072x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f64073y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f64074z;

    public class a implements o60.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f64075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CallContext f64076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q f64077c;

        @Override // o60.e
        public final void onPermissionDenied(String... r100) {
            UIUtils.displayToastWithIcon(this.f64076b.getContext(), R.drawable.ttlive_close_popup_textpage, R.string.ttlive_core_photo_error_no_camera);
            this.f64077c.finishWithFailure();
        }

        @Override // o60.e
        public final void onPermissionGrant(String... r100) {
            int r101 = this.f64075a.optInt("duration_limit", 10000) / 1000;
            Intent r102 = new Intent("android.media.action.VIDEO_CAPTURE");
            r102.putExtra("android.intent.extra.durationLimit", r101);
            r102.putExtra("android.intent.extra.videoQuality", 1);
            if (this.f64077c.f64053e.getActivity() != null) goto L6;
            this.f64077c.finishWithFailure();
            return;
        L6:
            this.f64077c.f64053e.startActivityForResult(r102, 9001);
        }

        public a(q r100, JSONObject r101, CallContext r102) {
            this.f64077c = r100;
            this.f64075a = r101;
            this.f64076b = r102;
        }
    }

    public class b implements SingleObserver<File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f64078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f64079b;

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable r100) {
            UIUtils.displayToastWithIcon(this.f64078a, R.drawable.ttlive_close_popup_textpage, R.string.ttlive_photo_error_no_photo);
            this.f64079b.B();
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable r100) {
            this.f64079b.f64052d.add(r100);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(File r100) {
            File r101 = r100;
            if (r101.exists() == false) goto L8;
            q r102 = this.f64079b;
            String r103 = r101.getAbsolutePath();
            q r104 = this.f64079b;
            if (r102.z(r103, r104.f64059k, r104.f64058j) == true) goto L7;
            q r105 = this.f64079b;
            com.bytedance.android.live.core.utils.q.o(this.f64078a, r105.f64053e);
            return;
        L7:
            this.f64079b.A(r101.getAbsolutePath());
            return;
        L8:
            UIUtils.displayToastWithIcon(this.f64078a, R.drawable.ttlive_close_popup_textpage, R.string.ttlive_photo_error_no_photo);
            this.f64079b.B();
        }

        public b(q r100, FragmentActivity r101) {
            this.f64079b = r100;
            this.f64078a = r101;
        }
    }

    public class c implements BDImageXUploaderListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f64080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f64081b;

        @Override // com.ss.bduploader.BDImageXUploaderListener
        public final void onLog(int r100, int r101, String r102) {
        }

        public c(q r100, String r101) {
            this.f64081b = r100;
            this.f64080a = r101;
        }

        @Override // com.ss.bduploader.BDImageXUploaderListener
        public final int imageXUploadCheckNetState(int r100, int r101) {
            return NetworkUtils.f(this.f64081b.f64055g.getContext()) ? 1 : 0;
        }

        @Override // com.ss.bduploader.BDImageXUploaderListener
        public final void onNotify(int r100, long r101, BDImageXInfo r102) {
            if (r100 != 6) goto L6;
            UploadResult r103 = new UploadResult();
            r103.setUri(r102.mImageTosKey);
            q.j(this.f64081b, r103, this.f64080a);
            return;
        L6:
            if (r100 != 7) goto L10;
            this.f64081b.B();
            return;
        }
    }

    public class d implements SingleObserver<Response<UploadResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f64082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f64083b;

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable r100) {
            Context r101 = this.f64083b.f64053e.getContext();
            if (r101 == null) goto L6;
            ExceptionUtils.handleException(r101, r100);
        L6:
            if (this.f64082a.length() > 0) goto L8;
            this.f64083b.getClass();
            return;
        L8:
            f2.b(R.string.ttlive_photo_upload_failed, 0);
            this.f64083b.B();
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable r100) {
            this.f64083b.f64050b = r100;
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(Response<UploadResult> r100) {
            Response<UploadResult> r101 = r100;
            UploadResult r102 = r101.data;
            if (r102 != null) goto L5;
            String r103 = "";
        L6:
            q.j(this.f64083b, r101.data, r103);
            return;
        L5:
            r103 = r102.getPath();
            goto L6
        }

        public d(q r100, PolarisFileWrapper r101) {
            this.f64083b = r100;
            this.f64082a = r101;
        }
    }

    public static final class e {

        @SerializedName("local_img")
        String local_img;

        @SerializedName("local_url")
        String local_url;

        @SerializedName("uri")
        String uri;

        public e() {
        }
    }

    public static final class f {

        @SerializedName("code")
        int code;

        @SerializedName("data")
        e data;

        @SerializedName("status")
        int status;

        @SerializedName("status_msg")
        String status_msg;

        public f(int r100, String r101, e r102) {
            this.code = 1;
            this.status = r100;
            this.status_msg = r101;
            this.data = r102;
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Response<UploadResult> f64084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f64085b;

        public g(String r100, Response<UploadResult> r101) {
            this.f64084a = r101;
            this.f64085b = r100;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f64050b;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f64052d.clear();
        Disposable r101 = this.f64051c;
        if (r101 != null) goto L8;
    L10:
        this.f64053e = null;
        this.f64055g = null;
        this.D = null;
        return;
    L8:
        if (r101.isDisposed() == true) goto L10;
        this.f64051c.dispose();
        goto L10
    }

    public final String q() {
        if (this.f64072x == false) goto L7;
        return this.f64049a + HTTP.URL_DEFAULT + r();
    L7:
        return this.f64053e.getContext().getCacheDir() + "/EncryptedUploadMethod/live_jsb_photo/" + r();
    }

    public final String r() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.f64057i + "_" + this.f64056h);
        r100.append(".jpeg");
        return r100.toString();
    }

    public final Uri s() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(q());
        if (r100.exists() == true) goto L12;
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.f64049a);     // Catch: IOException -> L9
        if (r101.exists() == true) goto L7;
        r101.mkdirs();     // Catch: IOException -> L9
    L7:
        r100.createNewFile();     // Catch: IOException -> L9
    L9:
        e = move-exception;
        com.bytedance.android.livesdk.log.b0 r102 = com.bytedance.android.livesdk.log.b0.o();
        StackTraceElement[] r103 = e.getStackTrace();
        r102.getClass();
        com.bytedance.android.live.core.log.g.m(6, r103);
    L12:
        return TTLiveFileProvider.getUri(this.f64053e.getActivity(), this.f64053e.getActivity().getPackageName() + TTLiveFileProvider.NAME, r100);
    }

    public final String t() {
        return this.f64057i + "_" + this.f64056h + GXMode.MODE_TYPE_CROP;
    }

    public final void y() {
        ProgressDialog r100 = this.f64054f;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isShowing() == false) goto L27;
        ProgressDialog r101 = this.f64054f;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r101);
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r103 == null) goto L20;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L9:
        if (Looper.myLooper() == r102.getLooper()) goto L11;
        r102.post(DialogLancet.createDismissRunnable(r101));
        return;
    }

    public final void B() {
        y();
        p(new f(1, "失败", new e()), false);
    }

    public final void C() {
        y();
        p(new f(1, "失败", new e()), false);
    }

    public final Uri u() {
        String r100 = t();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.f64049a + HTTP.URL_DEFAULT + r100);
        if (r101.exists() == true) goto L15;
        PolarisFileWrapper r102 = new PolarisFileWrapper(this.f64049a);     // Catch: IOException -> L12
        if (r102.exists() == true) goto L10;
        r102.mkdirs();     // Catch: IOException -> L12
    L10:
        r101.createNewFile();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    L15:
        return Uri.fromFile(r101);
    }

    public q(Fragment r100) {
        this.f64049a = "";
        this.f64052d = new CompositeDisposable();
        this.f64057i = "upload_photo";
        this.B = TokenCert.with("bpea-live_upload_jsb_encrypted_upload_method");
        this.C = TokenCert.with("bpea-live_upload_jsb_encrypted_upload_method_camera");
        TokenCert.with("bpea-live_upload_jsb_encrypted_upload_method_gallery");
        this.D = null;
        this.E = null;
        this.H = null;
        this.I = null;
        this.f64048J = true;
        this.K = false;
        this.L = null;
        this.M = null;
        this.N = 0;
        this.f64053e = r100;
        int r101 = Build.VERSION.SDK_INT;
        if (r101 <= 29) goto L5;
        this.G = true;
    L16:
        String r102 = r100.getContext().getExternalFilesDir(Environment.DIRECTORY_DCIM) + "/Camera";     // Catch: Exception -> L12
        this.f64049a = r102;     // Catch: Exception -> L12
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);     // Catch: Exception -> L12
        if (r103.exists() == true) goto L18;
        r103.mkdirs();     // Catch: Exception -> L12
    L18:
        o30.c.f521865b.b(r100.getContext().getCacheDir().getCanonicalPath());     // Catch: IOException -> L15
        return;
    L20:
        return;
    L12:
        this.f64049a = com.bytedance.android.live.core.utils.q.h(r100.getContext(), Environment.DIRECTORY_DCIM + "/Camera").getAbsolutePath();
        goto L18
    L5:
        if (r101 != 29) goto L7;
        this.G = !Environment.isExternalStorageLegacy();
        goto L16
    L7:
        this.G = false;
        goto L16
    }

    public final void A(String r110) {
        final PolarisFileWrapper r100 = new PolarisFileWrapper(r110);
        if (r100.exists() == true) goto L7;
        B();
        return;
    L7:
        if (this.f64054f != null) goto L10;
        ProgressDialog r101 = new ProgressDialog(this.f64053e.getActivity());
        this.f64054f = r101;
        r101.setMessage(s1.B(R.string.ttlive_live_uploading));
        this.f64054f.setCancelable(false);
    L10:
        if (this.f64054f.isShowing() == true) goto L16;
        ProgressDialog r102 = this.f64054f;
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L29;
        DialogLancet.handleBlockedDialogShow(r102);
        goto L16
    L29:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
    L15:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
    L16:
        z r103 = this.E;
        if (r103 == null) goto L26;
        int r104 = com.bytedance.android.live.browser.utils.e.f64308a;
        String[] r105 = {r110};
        c r106 = new c(this, r110);
        Intrinsics.checkNotNullParameter(r103, "imageXConfig");
        Intrinsics.checkNotNullParameter(r105, "path");
        Intrinsics.checkNotNullParameter(r106, "listener");
        BDImageXUploader r111 = new BDImageXUploader();
        r111.setUploadDomain(r103.f64100a);
        r111.setTopAccessKey(r103.f64101b);
        r111.setTopSecretKey(r103.f64102c);
        r111.setTopSessionToken(r103.f64103d);
        r111.setServiceID(r103.f64104e);
        r111.setTraceId(r103.f64105f);
        IHostContext r107 = (IHostContext) jc1.k.n(IHostContext.class);
        r111.setServerParameter("appid=" + r107.appId() + "&did=" + r107.getServerDeviceId() + "&uid=" + ((IUserService) jc1.k.n(IUserService.class)).user().n() + "&Region=cn&StoreRegion=cn");
        r111.setObjectType("image");
        r111.setRWTimeout(40);
        r111.setMaxFailTime(70);
        r111.setTranTimeOutUnit(8);
        r111.setFileRetryCount(1);
        r111.setEnableHttps(1);
        int r108 = r103.f64106g;
        if (r108 <= 0) goto L21;
        r111.setSliceSize(r108);
    L21:
        int r109 = r103.f64107h;
        if (r109 <= 0) goto L24;
        r111.setSocketNum(r109);
    L24:
        r111.setFilePath(1, r105);
        r111.setListener(new com.bytedance.android.live.browser.utils.d(r106, r111));
        r111.start();
        return;
    L26:
        Single.just(this.f64062n).subscribeOn(Schedulers.io()).map(new m(this, r100)).zipWith(Single.just(r110).subscribeOn(Schedulers.io()).map(new n(this, r100)), new o()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r100));
    }

    public final void E(int r100) {
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L6
        r101.put("progress", r100);     // Catch: JSONException -> L6
        r101.put("phases", "zip/uplaod");     // Catch: JSONException -> L6
        CallContext r102 = this.f64055g;     // Catch: JSONException -> L6
        if (r102 == null) goto L9;
        r102.b("H5_uploadProgress", r101);     // Catch: JSONException -> L6
        return;
    L9:
        return;
    }

    public final void F(Uri r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Intent r101 = new Intent("com.android.camera.action.CROP");
        r101.addFlags(1);     // Catch: Exception -> L14
        r101.addFlags(2);     // Catch: Exception -> L14
        r101.setDataAndType(r100, "image/*");     // Catch: Exception -> L14
        r101.putExtra(GXMode.MODE_TYPE_CROP, "true");     // Catch: Exception -> L14
        r101.putExtra("scale", true);     // Catch: Exception -> L14
        r101.putExtra("aspectX", this.f64065q);     // Catch: Exception -> L14
        r101.putExtra("aspectY", this.f64066r);     // Catch: Exception -> L14
        r101.putExtra("return-data", false);     // Catch: Exception -> L14
        r101.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());     // Catch: Exception -> L14
        r101.putExtra("noFaceDetection", true);     // Catch: Exception -> L14
        r101.putExtra("scaleUpIfNeeded", true);     // Catch: Exception -> L14
        if (this.G == false) goto L10;
        Uri r102 = v(t());     // Catch: Exception -> L14
        if (r102 == null) goto L11;
        this.H = r102;     // Catch: Exception -> L14
    L11:
        if (r102 == null) goto L24;
        r101.putExtra(BdpAppEventConstant.PARAMS_OUTPUT, r102);     // Catch: Exception -> L14
    L24:
        Fragment r103 = this.f64053e;     // Catch: Exception -> L20
        if (r103 == null) goto L26;
        r103.startActivityForResult(r101, 40002);     // Catch: Exception -> L20
        return;
    L26:
        return;
    L20:
        UIUtils.displayToast(this.f64053e.getContext(), R.string.ttlive_picture_cannot_find_crop_app);
        return;
    L10:
        r102 = u();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public final void k(String r100) {
        FragmentActivity r101 = this.f64053e.getActivity();
        if (r101 != null) goto L7;
        B();
        return;
    L7:
        if (z(r100, this.f64059k, this.f64058j) == true) goto L10;
        com.bytedance.android.live.core.utils.q.o(r101, this.f64053e);
        return;
    L10:
        A(r100);
    }

    public final Uri v(String r210) {
        Uri r100 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentValues r101 = new ContentValues();
        r101.put("title", r210);
        r101.put("date_added", Long.valueOf(System.currentTimeMillis()));
        FragmentActivity r102 = this.f64053e.getActivity();
        if (r102 != null) goto L5;
        return null;
    L5:
        ContentResolver r103 = r102.getContentResolver();
        ArrayList r110 = new ArrayList();
        Object[] r111 = {r100, r101};
        f06.b r112 = new f06.b();
        g06.a r104 = ApiHookConfig.f245611b.get(240017);
        if (r104 == null) goto L8;
        f06.a[] r105 = r104.f479473i;
    L9:
        f06.a[] r113 = r105;
        int r114 = r113.length;
        int r115 = 0;
    L11:
        if (r115 >= r114) goto L18;
        f06.a r106 = r113[r115];
        int r211 = r115;
        int r212 = r114;
        f06.a[] r213 = r113;
        f06.d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r103, r111, "android.net.Uri", r112);     // Catch: Exception -> L24
        if (r107.f474982a == true) goto L20;
        r110.add(r106);     // Catch: Exception -> L24
    L20:
        if (r107.f474982a == false) goto L23;
        return (Uri) r107.f474983b;
    L23:
        return r103.insert(r100, r101);
    L17:
        r115 = r211 + 1;
        r114 = r212;
        r113 = r213;
        goto L11
    L18:
        r107 = new f06.d(false, null);
        goto L20
    L8:
        r105 = ApiHookConfig.f245613d;
        goto L9
    }

    public static ParcelFileDescriptor l(ContentResolver r210, Uri r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, "r"};
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
        return ContentResolverWrapper.openFileDescriptor(r210, r211, "r");
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

    public static Cursor m(ContentResolver r110, Uri r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, null, null, null, null};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r112, false);
        return (Cursor) r113.f474983b;
    L6:
        Cursor r114 = r110.query(r111, null, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r114, r112, true);
        return r114;
    }

    public static String n(MediaMetadataRetriever r110, int r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111)};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return r110.extractMetadata(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static String w(ContentResolver r100, Uri r101) {
        String r102 = "";
        Cursor r103 = null;
        r103 = m(r100, r101);     // Catch: Throwable -> L11 Exception -> L15
        if (r103 != null) goto L6;
    L9:
        if (r103 != null) goto L21;
    L18:
        return r102;
    L21:
        r103.close();     // Catch: Exception -> L19
        goto L18
    L6:
        if (r103.moveToFirst() == false) goto L9;
        r102 = r103.getString(r103.getColumnIndex("_display_name"));     // Catch: Throwable -> L11 Exception -> L15
        goto L9
    L11:
        th = move-exception;
        if (r103 != null) goto L23;
    L14:
        throw th;
    L23:
        r103.close();     // Catch: Exception -> L20
    L16:
        if (r103 == null) goto L18;
        goto L18
    }

    public static ParcelFileDescriptor x(Context r100, Uri r101) {
        if (r100 == null) goto L9;
        if (r101 == null) goto L9;
        return l(r100.getContentResolver(), r101);
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        return null;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject r210, CallContext r211) throws Exception {
        this.f64055g = r211;
        String r100 = r210.optString("type");
        JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(r210, "args");
        if (r101 != null) goto L7;
        p(new f(4, "参数为空", new e()), false);
        return;
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L9;
        boolean r102 = true;
    L10:
        this.F = r102;
        this.f64073y = r101.optInt("action_type", 0);
        if (r101.optInt("disable_edit", 0) == 1) goto L13;
        boolean r103 = true;
    L14:
        this.f64063o = r103;
        this.f64062n = r101.optString("url");
        this.f64068t = r101.optInt("min_upload_duration_limit");
        this.f64069u = r101.optInt("max_upload_duration_limit");
        this.f64074z = r101.optString("min_upload_limit_error_msg");
        this.A = r101.optString("max_upload_limit_error_msg");
        this.f64070v = r101.optBoolean("hide_loading");
        this.f64071w = r101.optBoolean("show_progress");
        this.f64064p = new JSONObject();
        if (JSONObjectProtectorUtils.getJSONObject(r101, "params") == null) goto L17;
        JSONObject r104 = JSONObjectProtectorUtils.getJSONObject(r101, "params");
        this.f64064p = r104;
        int r105 = r104.optInt(LBSLightLocationTraceLogger.ENCRYPT, -1);
    L19:
        if (TextUtils.isEmpty(this.f64062n) == false) goto L21;
    L71:
        p(new f(5, "加密情况下必须是https请求", new e()), false);
        return;
    L21:
        if (this.f64062n.startsWith("https") == true) goto L24;
        if (r105 == 1) goto L71;
    L24:
        String r110 = r210.optString("token", "");
        if (r110 == null) goto L30;
        if (r110.isEmpty() == true) goto L30;
        this.B = TokenCert.with(r110);
    L30:
        if (TextUtils.equals("video", r100) == false) goto L49;
        if ((r211.getContext() instanceof Activity) == false) goto L49;
        int r106 = this.f64073y;
        if (r106 == 0) goto L36;
        if (r106 != 1) goto L74;
        Intent r107 = new Intent("android.intent.action.GET_CONTENT");
        if (r101.optInt("duration_limit", -1) == (-1)) goto L44;
        p(new f(1, "本地视频不支持duration_limit参数", new e()), false);
        return;
    L44:
        r107.setType("video/*");
        if (this.f64053e.getActivity() != null) goto L47;
        finishWithFailure();
        return;
    L47:
        this.f64053e.startActivityForResult(r107, 9002);
        return;
    L74:
        return;
    L36:
        if (this.F == false) goto L38;
        ImmutableList r108 = ImmutableList.of(new String[]{"android.permission.CAMERA"});
    L39:
        Activity r109 = (Activity) r211.getContext();
        SettingKey<Boolean> r111 = m60.i.f512260a;
        new m60.i.b(r109).a(new a(this, r101, r211), this.B, r108);
        return;
    L38:
        r108 = ImmutableList.of(new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE"});
    L49:
        if (TextUtils.equals("picture", r100) == false) goto L78;
        this.f64056h = String.valueOf(System.currentTimeMillis());
        this.f64059k = r101.optInt("min_width");
        this.f64058j = r101.optInt("min_height");
        this.f64060l = r101.optInt(TextureRenderKeys.KEY_IS_MAX_WIDTH);
        this.f64061m = r101.optInt(TextureRenderKeys.KEY_IS_MAX_HEIGHT);
        this.f64065q = r101.optInt("aspect_x", 1);
        this.f64066r = r101.optInt("aspect_y", 1);
        this.f64067s = r101.optInt("max_length");
        this.f64072x = r101.optBoolean("save_album", true);
        FragmentActivity r112 = this.f64053e.getActivity();
        String r113 = r210.optString("token", "");
        int r114 = this.f64073y;
        if (r114 != 0) goto L63;
        if (r113 == null) goto L57;
        if (r113.isEmpty() == true) goto L57;
        this.C = TokenCert.with(r113);
    L57:
        if (this.f64072x == true) goto L59;
        Fragment r115 = this.f64053e;
        String r116 = r();
        TokenCert r117 = this.C;
        TokenCert r118 = com.bytedance.android.live.core.utils.q.f66260a;
        SettingKey<Boolean> r119 = m60.i.f512260a;
        m60.i.b r120 = new m60.i.b(r112);
        r120.f512265d = new com.bytedance.android.live.core.utils.i();
        r120.f512266e = new com.bytedance.android.live.core.utils.i();
        r120.b(new com.bytedance.android.live.core.utils.p(r112, r116, r115), null, r117, new String[]{"android.permission.CAMERA"});
        return;
    L59:
        if (this.F == false) goto L61;
        com.bytedance.android.live.core.utils.q.k(r112, this.f64053e, 40004, this.f64049a, r(), this.C, null);
        return;
    L61:
        com.bytedance.android.live.core.utils.q.j(r112, this.f64053e, this.f64049a, r(), this.C);
        return;
    L63:
        if (r114 != 1) goto L82;
        ((IRoomService) jc1.k.f(IRoomService.class)).setIsOnNeedMuteAudioFullPage(true);
        if (r113 != null) goto L67;
    L69:
        com.bytedance.android.live.core.utils.q.o(r112, this.f64053e);
        return;
    L67:
        if (r113.isEmpty() == true) goto L69;
        TokenCert.with(r113);
        goto L69
    L82:
        return;
    L78:
        return;
    L17:
        r105 = -1;
        goto L19
    L13:
        r103 = false;
        goto L14
    L9:
        r102 = false;
        goto L10
    }

    public final void p(f r100, boolean r101) {
        n6 r102 = this.D;
        if (r102 == null) goto L7;
        if (r101 == false) goto L6;
        r102.z9(r100.data.uri);
        return;
    L6:
        r102.i();
        return;
    L7:
        finishWithResult(r100);
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final /* bridge */ /* synthetic */ void invoke(JSONObject r100, CallContext r101) throws Exception {
        invoke2(r100, r101);
    }

    public static Response G(String r110, File r111, JSONObject r112) throws Exception {
        MultipartTypedOutput r100 = new MultipartTypedOutput();
        r100.addPart("data", new TypedFile(Parameters.CONTENT_TYPE_MULTIPART_FORM, r111));
        IHostNetwork r101 = (IHostNetwork) jc1.k.f(INetworkService.class);
        Uri.Builder r113 = UriProtector.parse(r110).buildUpon();
        if (r112 == null) goto L8;
        Iterator<String> r102 = r112.keys();
    L6:
        if (r102.hasNext() == false) goto L8;
        String r103 = r102.next();
        r113.appendQueryParameter(r103, String.valueOf(r112.opt(r103)));
    L8:
        ByteArrayOutputStream r114 = new ByteArrayOutputStream();
        r100.writeTo(r114);     // Catch: IOException -> L11
    L13:
        String r104 = r113.build().toString();
        ALogger.d("EncryptedUploadMethod", r104);
        String r115 = new String(r101.uploadFile(-1, r104, new ArrayList(1), r100.mimeType(), r114.toByteArray(), r100.length(), r100.md5Stub()).execute().getBody());
        Response r116 = (Response) GsonProtectorUtils.fromJson(GsonHelper.get(), r115, new s().getType());
        if (r116 == null) goto L28;
    L20:
        e = move-exception;
        Logger.e("EncryptedUploadMethod", "uploadFile", e);
        return r116;
    L17:
        if (r116.statusCode == 0) goto L29;
        JSONObject r105 = new JSONObject(r115);     // Catch: JSONException -> L20
        r116.error = (RequestError) GsonProtectorUtils.fromJson(GsonHelper.get(), JSONObjectProtectorUtils.getJSONObject(r105, "data").toString(), RequestError.class);     // Catch: JSONException -> L20
        return r116;
    L29:
        return r116;
    L28:
        return new Response();
    L11:
        e = move-exception;
        Logger.e("EncryptedUploadMethod", "uploadFile", e);
        goto L13
    }

    public static void j(q r100, UploadResult r101, String r102) {
        r100.y();
        e r103 = new e();
        if (r101 != null) goto L5;
        String r104 = null;
    L6:
        r103.uri = r104;
        o30.c.f521865b.getClass();
        r103.local_img = o30.c.a(r102);
        r100.p(new f(0, "成功", r103), true);
        return;
    L5:
        r104 = r101.getUri();
        goto L6
    }

    public static com.bytedance.android.annie.util.q o(Context r100, ParcelFileDescriptor r101, String r102) {
        if (r101 == null) goto L5;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100.getCacheDir(), r102);
        FileUtils.writeStreamToFile(new PolarisFileInputStreamWrapper(r101.getFileDescriptor()), r103.getAbsolutePath());
        if (r103.exists() == false) goto L11;
        return new com.bytedance.android.annie.util.q(true, r103.getPath());
    L11:
        return new com.bytedance.android.annie.util.q(false, "copy failed");
    L5:
        return new com.bytedance.android.annie.util.q(false, "copy failed");
    }

    public final void D(UploadResult r100, String r101, String r102) {
        y();
        e r103 = new e();     // Catch: Exception -> L5
        r103.uri = r100.getUri();     // Catch: Exception -> L5
        o30.c.f521865b.getClass();     // Catch: Exception -> L5
        r103.local_url = o30.c.a(r101);     // Catch: Exception -> L5
        r103.local_img = o30.c.a(r102);     // Catch: Exception -> L5
        f r104 = new f(0, "成功", r103);     // Catch: Exception -> L5
        E(100);     // Catch: Exception -> L5
        this.f64055g.b("H5_uploadVideoStatus", r104);     // Catch: Exception -> L5
        p(r104, true);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public final void onActivityResult(int r100, int r110, Intent r111) {
        int r101 = 0;
        if (9001 != r100) goto L5;
    L86:
        if ((-1) == r110) goto L88;
        p(new f(2, "取消操作", new e()), false);
        return;
    L88:
        if (r111 != null) goto L90;
    L129:
        C();
        return;
    L90:
        if (r111.getData() == null) goto L129;
        FragmentActivity r102 = this.f64053e.getActivity();
        if (r102 != null) goto L95;
        C();
        return;
    L95:
        Uri r112 = r111.getData();
        Logger.d("EncryptedUploadMethod", "onActivityResult: uri=" + r112.toString());
        this.I = r112;
        final ParcelFileDescriptor r103 = x(r102, r112);
        if (r103 != null) goto L99;
        C();
        return;
    L99:
        if (this.f64070v == true) goto L102;
        this.f64054f = ProgressDialog.show(r102, s1.B(R.string.ttlive_webview_live_record_uploading_title), s1.B(R.string.ttlive_webview_live_record_uploading), true, false);
    L102:
        if (this.f64071w == true) goto L104;
    L125:
        final String r104 = w(this.f64053e.getContext().getContentResolver(), r112);
        if (this.f64071w == false) goto L128;
        LivePluginSPIManager.f85856e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new r(this, r103, r104, r110)).syncCallbackIfReady(true).callbackOnMainThread().requireByUser("EncryptedUploadMethod");
        return;
    L128:
        Observable.create(new p(this, r103)).flatMap(new com.bytedance.android.live.browser.jsbridge.upload.c(this, r104)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.browser.jsbridge.upload.d(this), new com.bytedance.android.live.browser.jsbridge.upload.e(this));
        return;
    L104:
        if (this.f64068t <= 0) goto L125;
        MediaMetadataRetriever r105 = new MediaMetadataRetriever();     // Catch: Exception -> L109
        r105.setDataSource(r103.getFileDescriptor());     // Catch: Exception -> L109
        String r106 = n(r105, 9);     // Catch: Exception -> L109
        if (r106 == null) goto L110;
        r101 = CastIntegerProtector.parseInt(r106) / 1000;     // Catch: Exception -> L109
    L110:
        String r107 = s1.B(R.string.ttlive_video_duration_min_limit_error);
        String r108 = s1.B(R.string.ttlive_video_duration_max_limit_error);
        if (TextUtils.isEmpty(this.f64074z) == true) goto L114;
        r107 = this.f64074z;
    L114:
        if (TextUtils.isEmpty(this.A) == true) goto L116;
        r108 = this.A;
    L116:
        if (r101 <= 0) goto L121;
        int r109 = this.f64069u;
        if (r109 <= 0) goto L121;
        if (r101 <= r109) goto L121;
        UIUtils.displayToastWithIcon(r102, R.drawable.ttlive_close_popup_textpage, r108);
        C();
        int r113 = a0.f63990a;
        LiveTracingMonitor.e("ttlive_upload_video_dissatisfy", LiveTracingMonitor.EventModule.ACTIVITY, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, null, null, null);
        return;
    L121:
        if (r101 <= 0) goto L125;
        if (r101 >= this.f64068t) goto L125;
        UIUtils.displayToastWithIcon(r102, R.drawable.ttlive_close_popup_textpage, r107);
        C();
        int r114 = a0.f63990a;
        LiveTracingMonitor.e("ttlive_upload_video_dissatisfy", LiveTracingMonitor.EventModule.ACTIVITY, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, null, null, null);
        return;
    L5:
        if (9002 == r100) goto L86;
        if (r100 != 40003) goto L65;
        if ((-1) == r110) goto L12;
        p(new f(2, "取消操作", new e()), false);
        return;
    L12:
        if (r111 != null) goto L14;
    L62:
        B();
        return;
    L14:
        if (r111.getData() == null) goto L62;
        FragmentActivity r115 = this.f64053e.getActivity();
        if (r115 != null) goto L20;
        B();
        return;
    L20:
        Uri r116 = r111.getData();
        Context r117 = this.f64053e.getContext();
        String r118 = null;
        if (r116 == null) goto L51;
        String r119 = r116.getScheme();
        if (StringUtils.isEmpty(r119) == false) goto L26;
    L49:
        r118 = r116.getPath();
        goto L51
    L26:
        if ("file".equals(r119) == true) goto L49;
        if ("http".equals(r119) == false) goto L32;
        r118 = r116.toString();
        goto L51
    L32:
        if ("content".equals(r119) == false) goto L51;
        String r120 = w(r117.getContentResolver(), r116);
        ParcelFileDescriptor r121 = x(r117, r116);     // Catch: Exception -> L42
        if (r121 == null) goto L51;
        PolarisFileWrapper r122 = new PolarisFileWrapper(r117.getCacheDir(), r120);     // Catch: Exception -> L42
        FileUtils.writeStreamToFile(new PolarisFileInputStreamWrapper(r121.getFileDescriptor()), r122.getAbsolutePath());     // Catch: Exception -> L40
    L45:
        if (r122 == null) goto L51;
        if (r122.exists() == false) goto L51;
        r118 = r122.getAbsolutePath();
    L40:
        e = e;
    L44:
        e.printStackTrace();
    L42:
        e = e;
        r122 = null;
    L51:
        if (StringUtils.isEmpty(r118) == false) goto L54;
        UIUtils.displayToastWithIcon(r115, R.drawable.ttlive_close_popup_textpage, R.string.ttlive_photo_error_no_photo);
        B();
        return;
    L54:
        PolarisFileWrapper r123 = new PolarisFileWrapper(r118);
        if (r123.exists() == true) goto L59;
        UIUtils.displayToastWithIcon(r115, R.drawable.ttlive_close_popup_textpage, R.string.ttlive_photo_error_no_photo);
        B();
        return;
    L59:
        if (this.f64063o == false) goto L61;
        F(r116);
        return;
    L61:
        k(r123.getAbsolutePath());
        return;
    L65:
        if (r100 != 40004) goto L77;
        if ((-1) == r110) goto L70;
        p(new f(2, "取消操作", new e()), false);
        return;
    L70:
        if (this.f64063o == true) goto L131;
        k(q());
        return;
    L131:
        F(s());     // Catch: Exception -> L73
        return;
    L73:
        e = move-exception;
        com.bytedance.android.livesdk.log.b0 r124 = com.bytedance.android.livesdk.log.b0.o();
        StackTraceElement[] r125 = e.getStackTrace();
        r124.getClass();
        com.bytedance.android.live.core.log.g.m(6, r125);
        return;
    L77:
        if (r100 != 40002) goto L143;
        if ((-1) == r110) goto L81;
        p(new f(2, "取消操作", new e()), false);
        return;
    L81:
        final FragmentActivity r126 = this.f64053e.getActivity();
        if (r126 != null) goto L85;
        B();
        return;
    L85:
        Single.fromCallable(new com.bytedance.android.live.browser.jsbridge.upload.b(this, r126)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r126));
        return;
    }

    public final boolean z(String r100, int r101, int r102) {
        PolarisFileInputStreamWrapper r103 = null;
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L24 FileNotFoundException -> L26
        BitmapFactory.Options r105 = new BitmapFactory.Options();     // Catch: Throwable -> L20 FileNotFoundException -> L22
        r105.inJustDecodeBounds = true;     // Catch: Throwable -> L20 FileNotFoundException -> L22
        BitmapFactory.decodeStream(r104, null, r105);     // Catch: Throwable -> L20 FileNotFoundException -> L22
        int r106 = r105.outWidth;     // Catch: Throwable -> L20 FileNotFoundException -> L22
        if (r101 > r106) goto L17;
        int r107 = r105.outHeight;     // Catch: Throwable -> L20 FileNotFoundException -> L22
        if (r102 > r107) goto L17;
        if ((r106 * r107) <= 20971520) goto L14;
        f2.b(R.string.ttlive_picture_too_large, 0);     // Catch: Throwable -> L20 FileNotFoundException -> L22
        r104.close();     // Catch: IOException -> L34
    L13:
        return false;
    L14:
        r104.close();     // Catch: IOException -> L35
    L38:
    L17:
        f2.b(R.string.ttlive_picture_too_small, 0);     // Catch: Throwable -> L20 FileNotFoundException -> L22
        r104.close();     // Catch: IOException -> L36
    L19:
        return false;
    L22:
        e = e;
        r103 = r104;
    L27:
        e.printStackTrace();     // Catch: Throwable -> L24
        if (r103 == null) goto L30;
        r103.close();     // Catch: IOException -> L35
    L20:
        th = th;
        r103 = r104;
    L31:
        if (r103 != null) goto L46;
    L33:
        throw th;
    L46:
        r103.close();     // Catch: IOException -> L37
    L26:
        e = e;
    L24:
        th = th;
    L30:
        return true;
    }
}

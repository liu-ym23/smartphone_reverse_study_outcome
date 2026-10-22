package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livehostapi.business.IHostOCRApiProxy;
import com.bytedance.android.livesdk.config.nd0;
import com.bytedance.android.livesdkapi.ILiveActivityResultListener;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.videosend.tools.VideoTools;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class j8 extends com.bytedance.ies.web.jsbridge2.f<a, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Fragment f63473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IHostOCRApiProxy f63474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f63475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TokenCert f63476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h8 f63477e;

    public static final class a {

        @SerializedName("action_type")
        public int actionType;

        @SerializedName(VideoTools.ERROR_TYPE_COMPRESS)
        public int compress;

        @SerializedName("max_side")
        public int maxSide;

        @SerializedName("token")
        public String token;

        @SerializedName("type")
        public String type;

        public a() {
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        this.f63474b = null;
        this.f63475c = null;
        this.f63473a = null;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.browser.jsbridge.newmethods.h8] */
    public j8(Fragment r100) {
        this.f63476d = TokenCert.with("bpea-live_ocrTakePhoto_jsb_ocr_take_photo_method");
        this.f63477e = new h8(this);
        this.f63473a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r100, CallContext r101) throws Exception {
        a r102 = r100;
        IHostOCRApiProxy r103 = (IHostOCRApiProxy) jc1.k.f(IHostOCRApiProxy.class);
        this.f63474b = r103;
        if (r103 != null) goto L5;
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(-1000, "ocr service proxy is unavaliable"));
        return;
    L5:
        this.f63475c = r102;
        FragmentActivity r104 = this.f63473a.getActivity();
        nd0 r105 = nd0.f120823a;
        if (r105.getValue().booleanValue() == true) goto L8;
    L10:
        int r106 = r102.actionType;
        if (r106 == 0) goto L36;
        if (r106 == 1) goto L15;
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(-1000, "input param error"));
        return;
    L15:
        String r107 = this.f63475c.token;
        if (r107 == null) goto L21;
        if (r107.isEmpty() == true) goto L21;
        this.f63476d = TokenCert.with(this.f63475c.token);
    L21:
        if (r105.getValue().booleanValue() == false) goto L34;
        Fragment r108 = this.f63473a;
        TokenCert r109 = this.f63476d;
        TokenCert r110 = com.bytedance.android.live.core.utils.q.f66260a;
        int r111 = Build.VERSION.SDK_INT;
        if (r111 < 34) goto L28;
        if (r104.getApplicationInfo().targetSdkVersion < 34) goto L28;
        String r112 = "android.permission.READ_MEDIA_VISUAL_USER_SELECTED";
    L33:
        com.bytedance.android.live.core.utils.q.m(r104, r108, 512, r109, new String[]{r112});
        return;
    L28:
        if (r111 >= 33) goto L30;
    L32:
        r112 = "android.permission.READ_EXTERNAL_STORAGE";
        goto L33
    L30:
        if (r104.getApplicationInfo().targetSdkVersion < 33) goto L32;
        r112 = BaseConstants.PERMISSION_READ_MEDIA_IMAGES;
        goto L33
    L34:
        com.bytedance.android.live.core.utils.q.l(r104, this.f63473a, 512, this.f63476d, null);
        return;
    L36:
        if (r105.getValue().booleanValue() == true) goto L38;
        Intent r113 = this.f63474b.getTakeOCRPhotoIntent(r104, r102.type);
        if (r113 != null) goto L43;
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(-1000, "ocr plugin not ready"));
    L43:
        this.f63473a.startActivityForResult(r113, 511);
        return;
    L38:
        if (this.f63474b.startTakeOCRPhoto(r104, r102.type, 511, this.f63477e) == true) goto L49;
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(-1000, "ocr plugin not ready"));
        return;
    L49:
        return;
    L8:
        if ((r104 instanceof ILiveActivityResultListener) == false) goto L10;
        ((ILiveActivityResultListener) r104).setOnLiveActivityResultListener(new i8(this));
        goto L10
    }

    public final void onActivityResult(int r100, int r101, Intent r110) {
        IHostOCRApiProxy r102 = this.f63474b;
        if (r102 != null) goto L5;
    L37:
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(-1000, "ocr service proxy is unavaliable"));
        return;
    L5:
        if (this.f63475c == null) goto L37;
        if (r100 != 511) goto L13;
        if (r101 != (-1)) goto L11;
        Context r103 = this.f63473a.getContext();
        a r104 = this.f63475c;
        finishWithResult(r102.convertOCRData(r103, 0, r104.type, r104.maxSide, r104.compress));
        return;
    L11:
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(1, ""));
        return;
    L13:
        if (r100 != 512) goto L41;
        if (r101 != (-1)) goto L35;
        if (r110 == null) goto L35;
        if (r110.getData() == null) goto L35;
        FragmentActivity r105 = this.f63473a.getActivity();
        if (r105 != null) goto L23;
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(-1000, "ocr service proxy is unavaliable"));
        return;
    L23:
        Uri r106 = r110.getData();
        String r111 = com.bytedance.android.live.core.utils.q.d(r105, r106);
        if (StringUtils.isEmpty(r111) == false) goto L28;
        UIUtils.displayToastWithIcon(r105, R.drawable.ttlive_close_popup_textpage, R.string.ttlive_photo_error_no_photo);
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(-1000, "ocr service proxy is unavaliable"));
        return;
    L28:
        if (new PolarisFileWrapper(r111).exists() == true) goto L32;
        UIUtils.displayToastWithIcon(r105, R.drawable.ttlive_close_popup_textpage, R.string.ttlive_photo_error_no_photo);
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(-1000, "ocr service proxy is unavaliable"));
        return;
    L32:
        if ("file".equals(r106.getScheme()) == false) goto L34;
        r106 = com.bytedance.android.live.core.utils.q.c(r105, r111);
    L34:
        this.f63474b.keepUriPhoto(this.f63473a.getContext(), this.f63475c.type, r106);
        IHostOCRApiProxy r107 = this.f63474b;
        Context r108 = this.f63473a.getContext();
        a r109 = this.f63475c;
        finishWithResult(r107.convertOCRData(r108, 0, r109.type, r109.maxSide, r109.compress));
        return;
    L35:
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(1, "action canceled"));
        return;
    }
}

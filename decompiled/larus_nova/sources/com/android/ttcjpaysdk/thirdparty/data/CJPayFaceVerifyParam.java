package com.android.ttcjpaysdk.thirdparty.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eBA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rR\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CJPayFaceVerifyParam;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "face_veri_ticket", "", "face_sdk_data", "face_app_id", "scene", "face_scene", "face_order_no", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "hasSrc", "", "toJson", "Lorg/json/JSONObject;", "Companion", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFaceVerifyParam implements CJPayObject {
    public static final Companion Companion = null;
    private static final String STD_VERIFY_TAG = "std_verify_tag";
    public String face_app_id;
    public String face_order_no;
    public String face_scene;
    public String face_sdk_data;
    public String face_veri_ticket;
    public String scene;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CJPayFaceVerifyParam$Companion;", "", "()V", "STD_VERIFY_TAG", "", "buildDyFaceParams", "Lorg/json/JSONObject;", "verifyId", "scene", "needTag", "", "hitStdForFace", "json", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final boolean hitStdForFace(JSONObject r100) {
            if (r100 == null) goto L4;
            String r101 = r100.optString(CJPayFaceVerifyParam.STD_VERIFY_TAG);
        L6:
            if (Intrinsics.areEqual(r101, "1") == true) goto L8;
            return false;
        L8:
            if (r100 != null) goto L10;
        L12:
            boolean r102 = false;
        L13:
            if (r102 == false) goto L17;
            return true;
        L17:
            return false;
        L10:
            if (r100.has("verify_id") != true) goto L12;
            r102 = true;
            goto L13
        L4:
            r101 = null;
            goto L6
        }

        @JvmStatic
        public final JSONObject buildDyFaceParams(String r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r101, "scene");
            JSONObject r103 = new JSONObject();
            if (r100 != null) goto L5;
            r100 = "";
        L5:
            KtSafeMethodExtensionKt.safePut(r103, "verify_id", r100);
            if (r102 == false) goto L8;
            KtSafeMethodExtensionKt.safePut(r103, "scene", r101);
            KtSafeMethodExtensionKt.safePut(r103, CJPayFaceVerifyParam.STD_VERIFY_TAG, "1");
        L8:
            return r103;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CJPayFaceVerifyParam() {
        this(null, null, null, null, null, null, 63, null);
    }

    @JvmStatic
    public static final JSONObject buildDyFaceParams(String r100, String r101, boolean r102) {
        return Companion.buildDyFaceParams(r100, r101, r102);
    }

    @JvmStatic
    public static final boolean hitStdForFace(JSONObject r100) {
        return Companion.hitStdForFace(r100);
    }

    public final boolean hasSrc() {
        return TextUtils.equals(this.scene, "cj_live_check");
    }

    public final JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("face_veri_ticket", this.face_veri_ticket);     // Catch: JSONException -> L5
        r100.put("face_sdk_data", this.face_sdk_data);     // Catch: JSONException -> L5
        r100.put("face_app_id", this.face_app_id);     // Catch: JSONException -> L5
        r100.put("scene", this.scene);     // Catch: JSONException -> L5
        r100.put("face_scene", this.face_scene);     // Catch: JSONException -> L5
        r100.put("face_order_no", this.face_order_no);     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayFaceVerifyParam#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayFaceVerifyParam#toJson", e);
        e.printStackTrace();
        goto L7
    }

    public CJPayFaceVerifyParam(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "face_veri_ticket");
        Intrinsics.checkNotNullParameter(r101, "face_sdk_data");
        Intrinsics.checkNotNullParameter(r102, "face_app_id");
        Intrinsics.checkNotNullParameter(r103, "scene");
        Intrinsics.checkNotNullParameter(r104, "face_scene");
        Intrinsics.checkNotNullParameter(r105, "face_order_no");
        this.face_veri_ticket = r100;
        this.face_sdk_data = r101;
        this.face_app_id = r102;
        this.scene = r103;
        this.face_scene = r104;
        this.face_order_no = r105;
    }

    public /* synthetic */ CJPayFaceVerifyParam(String r100, String r101, String r102, String r103, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = "";
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = "";
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = "";
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = "";
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = "";
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = "";
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}

package com.android.ttcjpaysdk.base.h5.cjjsb.base;

import cd4.k;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.utils.CJPayConvertUtils;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000eJ\u0010\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0017\u001a\u00020\bJ\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010 ¨\u0006#"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBResult;", "", "errorCode", "", "errorMsg", "Lorg/json/JSONObject;", "result", "", "onFailed", "getError", "json", "appendError", "wrapCallback", "", "isFatalResult", "isUse", "useNewStructure", LynxVideoManagerLite.CONTAIN, "isOldStructContainCJData", "Lcd4/k;", "callback", "setJsbCallback", "onSuccess", "onFatal", "__cj_error_code", "I", "__cj_error_msg", "Ljava/lang/String;", "jsbCallback", "Lcd4/k;", "isNewStructure", "Z", "<init>", "()V", "base-context_release"}, k = 1, mv = {1, 6, 0})
public class JSBBaseOutput implements IJSBResult {
    private int __cj_error_code;
    private String __cj_error_msg;
    private boolean isNewStructure;
    private boolean isOldStructContainCJData;
    private k jsbCallback;

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBResult
    public final void onSuccess() {
        this.__cj_error_code = 0;
        this.__cj_error_msg = "";
        JSONObject r100 = wrapCallback(CJPayJsonParser.toJsonObject(this));
        k r101 = this.jsbCallback;
        if (r101 == null) goto L5;
        r101.onSuccess(r100);
        Unit r102 = Unit.INSTANCE;
    L6:
        if (r102 != null) goto L11;
        k r103 = this.jsbCallback;
        if (r103 == null) goto L12;
        r103.onSuccess(getError());
        Unit r104 = Unit.INSTANCE;
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r102 = null;
        goto L6
    }

    private final JSONObject getError() {
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r101, "code", Integer.valueOf(this.__cj_error_code));
        KtSafeMethodExtensionKt.safePut(r101, "msg", this.__cj_error_msg);
        Unit r102 = Unit.INSTANCE;
        KtSafeMethodExtensionKt.safePut(r100, "__cj_jsb_error_info", r101);
        return r100;
    }

    public final boolean isFatalResult() {
        if (this.__cj_error_code != 999) goto L5;
        return true;
    L5:
        return false;
    }

    public JSBBaseOutput() {
        this.__cj_error_msg = "";
        this.isOldStructContainCJData = true;
    }

    private final JSONObject appendError(JSONObject r100) {
        JSONObject r101 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r101, "code", Integer.valueOf(this.__cj_error_code));
        KtSafeMethodExtensionKt.safePut(r101, "msg", this.__cj_error_msg);
        Unit r102 = Unit.INSTANCE;
        KtSafeMethodExtensionKt.safePut(r100, "__cj_jsb_error_info", r101);
        return r100;
    }

    private final JSONObject wrapCallback(JSONObject r100) {
        if (r100 != null) goto L4;
        r100 = new JSONObject();
    L4:
        boolean r101 = this.isNewStructure;
        JSONObject r102 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r102, "cj_data", r100);
        Unit r103 = Unit.INSTANCE;
        JSONObject r104 = KtSafeMethodExtensionKt.safeCreate(r100.toString());
        if (this.isOldStructContainCJData == false) goto L8;
        KtSafeMethodExtensionKt.safePut(r104, "cj_data", r100);
    L8:
        return (JSONObject) KtSafeMethodExtensionKt.tf(r101, r102, r104);
    }

    public final void isOldStructContainCJData(boolean r100) {
        this.isOldStructContainCJData = r100;
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBResult
    public final void onSuccess(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        k r101 = this.jsbCallback;
        if (r101 == null) goto L6;
        r101.onSuccess(wrapCallback(r100));
        return;
    }

    public final void setJsbCallback(k r100) {
        this.jsbCallback = r100;
    }

    public final void useNewStructure(boolean r100) {
        this.isNewStructure = r100;
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBResult
    public final void onFailed(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        onFailed(1, r100, r101);
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBResult
    public void onFatal(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        onFailed(999, r100, r101);
    }

    private final void onFailed(int r100, String r101, JSONObject r102) {
        this.__cj_error_code = r100;
        this.__cj_error_msg = r101;
        JSONObject r103 = wrapCallback(CJPayJsonParser.toJsonObject(this));
        k r104 = this.jsbCallback;
        if (r104 == null) goto L5;
        r104.onFailed(r101, CJPayConvertUtils.INSTANCE.jsonMergeJson(appendError(r103), r102));
        Unit r105 = Unit.INSTANCE;
    L6:
        if (r105 != null) goto L11;
        k r106 = this.jsbCallback;
        if (r106 == null) goto L12;
        r106.onFailed(r101, getError());
        Unit r107 = Unit.INSTANCE;
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r105 = null;
        goto L6
    }
}

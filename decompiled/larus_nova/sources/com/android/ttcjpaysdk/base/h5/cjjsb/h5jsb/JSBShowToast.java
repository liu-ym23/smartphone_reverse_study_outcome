package com.android.ttcjpaysdk.base.h5.cjjsb.h5jsb;

import android.content.Context;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.h5.cjjsb.abs.AbsJsbShowToast;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.NothingOutput;
import com.android.ttcjpaysdk.base.ui.component.CJToast;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/h5jsb/JSBShowToast;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbShowToast;", "()V", "TYPE_IMAGE_AND_TEXT", "", "TYPE_TEXT", "callbackStruct", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod$CallbackStruct;", "getCheckInputParamsRuleMap", "", "Lkotlin/Function0;", "", "input", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbShowToast$ShowToastInput;", "realHandle", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", BdpAppEventConstant.PARAMS_OUTPUT, "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/NothingOutput;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JSBShowToast extends AbsJsbShowToast {
    private final String TYPE_IMAGE_AND_TEXT;
    private final String TYPE_TEXT;

    public Map<String, Function0<Boolean>> getCheckInputParamsRuleMap(AbsJsbShowToast.ShowToastInput r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return null;
    }

    public JSBShowToast() {
        this.TYPE_IMAGE_AND_TEXT = "imageAndText";
        this.TYPE_TEXT = "text";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public AbsJSBMethod.CallbackStruct callbackStruct() {
        return AbsJSBMethod.CallbackStruct.ORIGINAL_WITH_WRAP_CJDATA;
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ Map getCheckInputParamsRuleMap(IJSBParams r100) {
        return getCheckInputParamsRuleMap((AbsJsbShowToast.ShowToastInput) r100);
    }

    public void realHandle(Context r110, AbsJsbShowToast.ShowToastInput r111, NothingOutput r112) {
        Intrinsics.checkNotNullParameter(r111, "input");
        Intrinsics.checkNotNullParameter(r112, BdpAppEventConstant.PARAMS_OUTPUT);
        if (r110 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(this.TYPE_IMAGE_AND_TEXT, r111.style) == false) goto L8;
        CJToast.Companion.showToast$default(CJToast.Companion, r110, r111.message, r111.sub_message, Integer.valueOf(r111.image_type), null, 0, 48, null);
        r112.onSuccess();
        return;
    L8:
        if (TextUtils.equals(this.TYPE_TEXT, r111.style) == false) goto L10;
        CJToast.Companion.showToast$default(CJToast.Companion, r110, r111.message, null, null, null, 0, 60, null);
        r112.onSuccess();
        return;
    L10:
        CJToast.Companion.showToast$default(CJToast.Companion, r110, r111.message, null, null, null, 0, 60, null);
        r112.onSuccess();
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ void realHandle(Context r100, IJSBParams r101, JSBBaseOutput r102) {
        realHandle(r100, (AbsJsbShowToast.ShowToastInput) r101, (NothingOutput) r102);
    }
}

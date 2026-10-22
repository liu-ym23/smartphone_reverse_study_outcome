package com.android.ttcjpaysdk.base.h5.cjjsb.h5jsb;

import android.content.Context;
import com.android.ttcjpaysdk.base.h5.cjjsb.abs.AbsJsbBackBlock;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.NothingOutput;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import qd4.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J$\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/h5jsb/JSBBackBlock;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbBackBlock;", "()V", "callbackStruct", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod$CallbackStruct;", "getCheckInputParamsRuleMap", "", "", "Lkotlin/Function0;", "", "input", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbBackBlock$BackBlockInput;", "realHandle", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", BdpAppEventConstant.PARAMS_OUTPUT, "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/NothingOutput;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JSBBackBlock extends AbsJsbBackBlock {
    public Map<String, Function0<Boolean>> getCheckInputParamsRuleMap(AbsJsbBackBlock.BackBlockInput r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return null;
    }

    public JSBBackBlock() {
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public AbsJSBMethod.CallbackStruct callbackStruct() {
        return AbsJSBMethod.CallbackStruct.ORIGINAL_WITH_WRAP_CJDATA;
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ Map getCheckInputParamsRuleMap(IJSBParams r100) {
        return getCheckInputParamsRuleMap((AbsJsbBackBlock.BackBlockInput) r100);
    }

    public void realHandle(Context r100, AbsJsbBackBlock.BackBlockInput r101, NothingOutput r110) {
        Intrinsics.checkNotNullParameter(r101, "input");
        Intrinsics.checkNotNullParameter(r110, BdpAppEventConstant.PARAMS_OUTPUT);
        String r102 = r101.title;
        String r103 = r101.context;
        int r104 = r101.policy;
        String r105 = r101.confirm;
        String r106 = r101.cancel;
        String r107 = r101.enable_animation;
        a r108 = (a) getDependency(a.class);
        if (r108 == null) goto L5;
        r108.executeBackBlock(r102, r103, r104, r105, r106, r107);
    L5:
        r110.onSuccess();
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ void realHandle(Context r100, IJSBParams r101, JSBBaseOutput r102) {
        realHandle(r100, (AbsJsbBackBlock.BackBlockInput) r101, (NothingOutput) r102);
    }
}

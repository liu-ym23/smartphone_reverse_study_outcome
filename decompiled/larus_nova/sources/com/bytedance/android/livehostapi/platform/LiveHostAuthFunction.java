package com.bytedance.android.livehostapi.platform;

import android.app.Activity;
import android.content.Context;
import androidx.autofill.HintConstants;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdkapi.LiveSaaSInternalService;
import com.bytedance.android.livesdkapi.auth.IAuthRoutine;
import com.bytedance.android.livesdkapi.service.ILiveCallback;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J:\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J&\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J&\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J.\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livehostapi/platform/LiveHostAuthFunction;", "Lcom/bytedance/android/livehostapi/platform/IHostAuthFunction;", "()V", "onAuthRoutineEnd", "", "tokenInfo", "Lcom/bytedance/android/livehostapi/platform/TokenInfo;", LynxError.LYNX_THROWABLE, "", "onAuthRoutineStart", "activity", "Landroid/app/Activity;", "extra", "", "", "handler", "Lcom/bytedance/android/livehostapi/platform/IAuthRoutineHandler;", "showDouyinAccountAccessDialog", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "resultCallback", "Lcom/bytedance/android/livesdkapi/service/ILiveCallback;", "Lcom/bytedance/android/livehostapi/platform/UserSelection;", "showDouyinAccountCreateDialog", "showPhoneNumberAuthDialog", Constants.OperatorKey.KEY_CARRIER, "livehostadapter_release"}, k = 1, mv = {1, 4, 3})
public abstract class LiveHostAuthFunction implements IHostAuthFunction {
    public LiveHostAuthFunction() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostAuthFunction
    public final /* synthetic */ void doHostBindPhoneNumber(ILiveCallback r100) {
        IHostAuthFunction.CC.$default$doHostBindPhoneNumber(this, r100);
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostAuthFunction
    public final /* synthetic */ void doPhoneNumberAuth(ILiveCallback r100) {
        IHostAuthFunction.CC.$default$doPhoneNumberAuth(this, r100);
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostAuthFunction
    public void onAuthRoutineEnd(TokenInfo r100, Throwable r101) {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostAuthFunction
    public void onAuthRoutineStart(TokenInfo r100, Activity r101, Map<String, String> r102, IAuthRoutineHandler r103) {
        Intrinsics.checkNotNullParameter(r103, "handler");
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostAuthFunction
    public final /* synthetic */ void resolveBindConflict(Context r100, ILiveCallback r101) {
        IHostAuthFunction.CC.$default$resolveBindConflict(this, r100, r101);
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostAuthFunction
    public final /* synthetic */ void resolveBindConflict(ILiveCallback r100) {
        IHostAuthFunction.CC.$default$resolveBindConflict(this, r100);
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostAuthFunction
    public void showDouyinAccountAccessDialog(Context r110, String r111, final ILiveCallback<UserSelection> r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        Intrinsics.checkNotNullParameter(r112, "resultCallback");
        LiveSaaSInternalService.getSaaSInternalService();
        IAuthRoutine r100 = (IAuthRoutine) TTLiveSDK.getLiveDefaultImplementation(IAuthRoutine.class);
        if (r100 == null) goto L6;
        IAuthRoutine.DefaultImpls.showDefaultAuthDialog$default(r100, r110, r111, new AnonymousClass1(r112), true, false, 16, null);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostAuthFunction
    public void showDouyinAccountCreateDialog(Context r110, String r111, final ILiveCallback<UserSelection> r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        Intrinsics.checkNotNullParameter(r112, "resultCallback");
        LiveSaaSInternalService.getSaaSInternalService();
        IAuthRoutine r100 = (IAuthRoutine) TTLiveSDK.getLiveDefaultImplementation(IAuthRoutine.class);
        if (r100 == null) goto L6;
        IAuthRoutine.DefaultImpls.showDefaultAuthDialog$default(r100, r110, r111, new C99901(r112), false, false, 16, null);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostAuthFunction
    public void showPhoneNumberAuthDialog(Context r100, String r101, String r102, final ILiveCallback<UserSelection> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        Intrinsics.checkNotNullParameter(r102, Constants.OperatorKey.KEY_CARRIER);
        Intrinsics.checkNotNullParameter(r103, "resultCallback");
        IAuthRoutine r104 = (IAuthRoutine) TTLiveSDK.getLiveDefaultImplementation(IAuthRoutine.class);
        if (r104 == null) goto L6;
        r104.showDefaultPhoneNumberAuthDialog(r100, r101, r102, new C99911(r103));
        return;
    }
}

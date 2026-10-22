package com.bytedance.android.livesdkapi.auth;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.platform.TokenRefreshCallback;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import sy.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\u0016\u0010\n\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H&J \u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H&J2\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\tH&J(\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0013H&¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/auth/IAuthRoutine;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/livesdkapi/auth/IAuthReport;", "report", "Lsy/a;", "", "callback", "", "getCurrentAccountPhoneNumber", "", "isPhoneNumberUsedInDouyin", "Landroid/app/Activity;", "activity", "Lcom/bytedance/android/livehostapi/platform/TokenRefreshCallback;", "source", "doDouyinAuth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "encryptedPhoneNumber", "Lcom/bytedance/android/livesdkapi/auth/IAuthDialogCallback;", "isPhoneUsedInDY", "needHint", "Landroid/app/Dialog;", "showDefaultAuthDialog", Constants.OperatorKey.KEY_CARRIER, "showDefaultPhoneNumberAuthDialog", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAuthRoutine extends IService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ Dialog showDefaultAuthDialog$default(IAuthRoutine r100, Context r101, String r102, IAuthDialogCallback r103, boolean r110, boolean r111, int r112, Object r113) {
            if (r113 != null) goto L10;
            if ((r112 & 16) == 0) goto L6;
            boolean r104 = false;
        L8:
            return r100.showDefaultAuthDialog(r101, r102, r103, r110, r104);
        L6:
            r104 = r111;
            goto L8
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showDefaultAuthDialog");
        }
    }

    void doDouyinAuth(Activity r100, TokenRefreshCallback r101, String r102);

    void getCurrentAccountPhoneNumber(a<String> r100);

    void isPhoneNumberUsedInDouyin(a<Boolean> r100);

    IAuthReport report();

    Dialog showDefaultAuthDialog(Context r100, String r101, IAuthDialogCallback r102, boolean r103, boolean r104);

    Dialog showDefaultPhoneNumberAuthDialog(Context r100, String r101, String r102, IAuthDialogCallback r103);
}

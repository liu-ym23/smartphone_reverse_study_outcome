package com.bytedance.android.livesdkapi.auth;

import android.app.Dialog;
import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J4\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&J$\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/auth/IAuthGuideService;", "Lcom/bytedance/android/live/base/IService;", "report", "Lcom/bytedance/android/livesdkapi/auth/INewAuthReport;", "showAuthGuideDialog", "Landroid/app/Dialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "encryptedPhoneNumber", "", "callback", "Lcom/bytedance/android/livesdkapi/auth/IAuthDialogCallback;", "needHint", "", "isPhoneUsedInDY", "showProtocolConfirmDialog", "sourceProvider", "Lcom/bytedance/android/livesdkapi/auth/IAuthDialogSourceProvider;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAuthGuideService extends IService {
    INewAuthReport report();

    Dialog showAuthGuideDialog(Context r100, String r101, IAuthDialogCallback r102, boolean r103, boolean r104);

    Dialog showProtocolConfirmDialog(Context r100, IAuthDialogCallback r101, IAuthDialogSourceProvider r102);
}

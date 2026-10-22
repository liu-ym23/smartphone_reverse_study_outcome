package com.android.ttcjpaysdk.bdpay.counter.outer.sign.helper;

import android.content.Context;
import com.android.ttcjpaysdk.base.service.ICJPaySecurityLoadingService;
import com.android.ttcjpaysdk.base.ui.component.CJLoading;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/helper/CJSignLoading;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "loadingInfo", "", "getLoadingInfo", "()Ljava/lang/String;", "setLoadingInfo", "(Ljava/lang/String;)V", "hideLoading", "", "showSecurityLoading", "", "isPayNewCard", "text", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJSignLoading {
    private final Context context;
    private String loadingInfo;

    public final void hideLoading() {
        CJLoading.Companion.getInstance().dismissDialogViewLoading(AnonymousClass1.INSTANCE);
    }

    public final String getLoadingInfo() {
        return this.loadingInfo;
    }

    public CJSignLoading(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
    }

    public final void setLoadingInfo(String r100) {
        this.loadingInfo = r100;
    }

    public final void showSecurityLoading(String r110) {
        Intrinsics.checkNotNullParameter(r110, "text");
        CJLoading.showDialogViewLoading$default(CJLoading.Companion.getInstance(), this.context, ICJPaySecurityLoadingService.SecurityLoadingScene.SECURITY_LOADING_SCENE_REUSE_AND_UPDATE, null, r110, false, false, null, null, null, null, 980, null);
    }

    public final boolean showSecurityLoading(boolean r110) {
        return CJLoading.showDialogViewLoading$default(CJLoading.Companion.getInstance(), this.context, ICJPaySecurityLoadingService.SecurityLoadingScene.SECURITY_LOADING_SCENE_PAY, this.loadingInfo, null, false, r110, null, null, null, null, 984, null);
    }
}

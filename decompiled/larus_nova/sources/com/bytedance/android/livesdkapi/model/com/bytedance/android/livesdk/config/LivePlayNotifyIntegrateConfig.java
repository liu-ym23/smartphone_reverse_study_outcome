package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.config.ke;
import com.bytedance.android.livesdk.config.ui0;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u000bH\u0007J\b\u0010\r\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LivePlayNotifyIntegrateConfig;", "", "()V", "ANNOUNCEMENT_DIALOG_SHOW", "", "I_WANT_TO_SEE_OFF", "LIVE_DIALOG_MODIFY", "SUBSCRIBE_DIALOG_SHOW", "notifyPanelValue", "openPushValue", "disableIWantToSee", "", "enableLiveModifyDialogClose", "enableSubscribeUGDialog", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayNotifyIntegrateConfig {
    private static final int ANNOUNCEMENT_DIALOG_SHOW = 1;
    public static final LivePlayNotifyIntegrateConfig INSTANCE = null;
    private static final int I_WANT_TO_SEE_OFF = 1;
    private static final int LIVE_DIALOG_MODIFY = 2;
    private static final int SUBSCRIBE_DIALOG_SHOW = 2;
    private static final int notifyPanelValue = 0;
    private static final int openPushValue = 0;

    private LivePlayNotifyIntegrateConfig() {
    }

    static {
        INSTANCE = new LivePlayNotifyIntegrateConfig();
        notifyPanelValue = ui0.f121377a.getValue().intValue();
        openPushValue = ke.f120595a.getValue().intValue();
    }

    @JvmStatic
    public static final boolean disableIWantToSee() {
        if (notifyPanelValue >= 1) goto L7;
        return false;
    L7:
        return true;
    }

    @JvmStatic
    public static final boolean enableLiveModifyDialogClose() {
        if (notifyPanelValue < 2) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean enableSubscribeUGDialog() {
        if (openPushValue < 2) goto L5;
        return true;
    L5:
        return false;
    }
}

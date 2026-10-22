package com.stepos.ailauncher.xui;

import R5.b;
import Y8.j;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.C3250o;
import com.stepos.ailauncher.xui.XuiStateReceiver;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007J\b\u0010\t\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/xui/XuiStateReceiver;", "", "<init>", "()V", "mainHandler", "Landroid/os/Handler;", "onXuiState", "Landroid/os/Bundle;", "input", "ok", "KEY_PAYLOAD", "", "KEY_SESSION_ID", "KEY_TIMESTAMP", "KEY_ERROR_CODE", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class XuiStateReceiver {
    private static final String KEY_ERROR_CODE = "errorCode";
    private static final String KEY_PAYLOAD = "payload";
    private static final String KEY_SESSION_ID = "SESSION_ID";
    private static final String KEY_TIMESTAMP = "TIMESTAMP";
    public static final XuiStateReceiver INSTANCE = new XuiStateReceiver();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    private XuiStateReceiver() {
    }

    private final Bundle ok() {
        Bundle bundle = new Bundle(1);
        bundle.putInt("errorCode", 0);
        return bundle;
    }

    public static final Bundle onXuiState(Bundle input) {
        if (input == null) {
            try {
                input = new Bundle();
            } catch (Throwable th) {
                b.INSTANCE.h("binder.ipc.copy.fail", j.a("exception", th.getClass().getSimpleName()), j.a("message", th.getMessage()));
                return INSTANCE.ok();
            }
        }
        String string = input.getString(KEY_PAYLOAD);
        if (string == null) {
            string = "";
        }
        final String str = string;
        final long j10 = input.getLong("SESSION_ID", 0L);
        final long j11 = input.getLong(KEY_TIMESTAMP, 0L);
        mainHandler.post(new Runnable() { // from class: D6.b
            @Override // java.lang.Runnable
            public final void run() {
                XuiStateReceiver.onXuiState$lambda$0(str, j10, j11);
            }
        });
        return INSTANCE.ok();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onXuiState$lambda$0(String str, long j10, long j11) {
        C3250o.INSTANCE.d(str, j10, j11);
    }
}

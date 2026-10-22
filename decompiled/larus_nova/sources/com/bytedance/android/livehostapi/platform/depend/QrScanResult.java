package com.bytedance.android.livehostapi.platform.depend;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livehostapi/platform/depend/QrScanResult;", "", "result", "", "(Ljava/lang/String;)V", "extraParam", "Landroid/os/Bundle;", "getExtraParam", "()Landroid/os/Bundle;", "getResult", "()Ljava/lang/String;", "Companion", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class QrScanResult {
    public static final Companion Companion = null;
    public static final String DISABLE_BRIDGE_AUTO_JUMP = "disable_bridge_auto_jump";
    private final Bundle extraParam;
    private final String result;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livehostapi/platform/depend/QrScanResult$Companion;", "", "()V", "DISABLE_BRIDGE_AUTO_JUMP", "", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final Bundle getExtraParam() {
        return this.extraParam;
    }

    public final String getResult() {
        return this.result;
    }

    public QrScanResult(String r100) {
        this.result = r100;
        this.extraParam = new Bundle();
    }
}

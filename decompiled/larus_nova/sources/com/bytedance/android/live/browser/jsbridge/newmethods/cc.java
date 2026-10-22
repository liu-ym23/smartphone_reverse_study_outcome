package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/cc;", "", "Lcom/bytedance/android/live/browser/jsbridge/newmethods/cc$a;", "commonInteraction", "Lcom/bytedance/android/live/browser/jsbridge/newmethods/cc$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/browser/jsbridge/newmethods/cc$a;", "setCommonInteraction", "(Lcom/bytedance/android/live/browser/jsbridge/newmethods/cc$a;)V", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class cc {

    @SerializedName("commonInteraction")
    private a commonInteraction;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/cc$a;", "", "", "disableNativeClose", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "setDisableNativeClose", "(Ljava/lang/Boolean;)V", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("disableNativeClose")
        private Boolean disableNativeClose;

        public a() {
        }

        public final Boolean a() {
            return this.disableNativeClose;
        }
    }

    public cc() {
    }

    public final a a() {
        return this.commonInteraction;
    }
}

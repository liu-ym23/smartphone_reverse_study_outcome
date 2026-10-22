package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.auth.IAuthRoutine;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "reportAuth")
public final class za extends com.bytedance.ies.web.jsbridge2.g<b, Unit> {

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR0\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/za$b;", "", "", "action", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "buttonType", "b", "setButtonType", "source", "c", "setSource", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("action")
        private String action;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE)
        private String buttonType;

        @SerializedName("extra")
        private Map<String, String> extra;

        @SerializedName("source")
        private String source;

        public b() {
            this.buttonType = "";
            this.source = "";
        }

        public final String a() {
            return this.action;
        }

        public final String b() {
            return this.buttonType;
        }

        public final String c() {
            return this.source;
        }
    }

    static {
    }

    public za() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Unit invoke(b r100, CallContext r101) {
        b r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ((IAuthRoutine) jc1.k.n(IAuthRoutine.class)).getCurrentAccountPhoneNumber(new ab(this, r102));
        return Unit.INSTANCE;
    }
}

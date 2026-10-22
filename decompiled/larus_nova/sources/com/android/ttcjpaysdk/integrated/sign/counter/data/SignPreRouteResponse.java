package com.android.ttcjpaysdk.integrated.sign.counter.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/data/SignPreRouteResponse;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "code", "", "data", "Lcom/android/ttcjpaysdk/integrated/sign/counter/data/SignPreRouteResponse$DataInfo;", "error", "Lcom/android/ttcjpaysdk/integrated/sign/counter/data/ErrorBean;", "isResponseOk", "", "Companion", "DataInfo", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SignPreRouteResponse implements CJPayObject {
    public static final Companion Companion = null;
    public static final String DATA_BIZ_TYPE_JH = "jh";
    public static final String DATA_BIZ_TYPE_ZG = "zg";
    public static final String DATA_TYPE_LYNX = "lynx";
    public static final String DATA_TYPE_NATIVE = "native";
    public String code;
    public DataInfo data;
    public ErrorBean error;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/data/SignPreRouteResponse$Companion;", "", "()V", "DATA_BIZ_TYPE_JH", "", "DATA_BIZ_TYPE_ZG", "DATA_TYPE_LYNX", "DATA_TYPE_NATIVE", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/data/SignPreRouteResponse$DataInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "data", "", "data_biz_type", "data_type", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DataInfo implements CJPayObject {
        public String data;
        public String data_biz_type;
        public String data_type;

        public DataInfo() {
            this.data = "";
            this.data_type = "";
            this.data_biz_type = "";
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final boolean isResponseOk() {
        if (TextUtils.isEmpty(this.code) == false) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual("CA0000", this.code) == false) goto L7;
        return true;
    }

    public SignPreRouteResponse() {
        this.code = "";
        this.error = new ErrorBean();
        this.data = new DataInfo();
    }
}

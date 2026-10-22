package com.android.ttcjpaysdk.integrated.sign.counter.session;

import com.alipay.sdk.m.x.d;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedSignCallback;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/session/SignPreRouteSession;", "", "cjContext", "Lcom/bytedance/caijing/sdk/infra/base/core/CJContext;", d.D, "", "", "extraInfo", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJPayIntegratedSignCallback;", "state", "Lcom/android/ttcjpaysdk/integrated/sign/counter/session/SignPreRouteSessionState;", "(Lcom/bytedance/caijing/sdk/infra/base/core/CJContext;Ljava/util/Map;Ljava/util/Map;Lcom/android/ttcjpaysdk/base/service/ICJPayIntegratedSignCallback;Lcom/android/ttcjpaysdk/integrated/sign/counter/session/SignPreRouteSessionState;)V", "getCallback", "()Lcom/android/ttcjpaysdk/base/service/ICJPayIntegratedSignCallback;", "getCjContext", "()Lcom/bytedance/caijing/sdk/infra/base/core/CJContext;", "getExtraInfo", "()Ljava/util/Map;", "getSdkInfo", "getState", "()Lcom/android/ttcjpaysdk/integrated/sign/counter/session/SignPreRouteSessionState;", "setState", "(Lcom/android/ttcjpaysdk/integrated/sign/counter/session/SignPreRouteSessionState;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SignPreRouteSession {
    private final ICJPayIntegratedSignCallback callback;
    private final CJContext cjContext;
    private final Map<String, Object> extraInfo;
    private final Map<String, String> sdkInfo;
    private SignPreRouteSessionState state;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SignPreRouteSession copy$default(SignPreRouteSession r100, CJContext r101, Map r102, Map r103, ICJPayIntegratedSignCallback r104, SignPreRouteSessionState r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.cjContext;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.sdkInfo;
    L8:
        Map r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.extraInfo;
    L11:
        Map r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.callback;
    L14:
        ICJPayIntegratedSignCallback r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.state;
    L17:
        CJContext r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final CJContext component1() {
        return this.cjContext;
    }

    public final Map<String, String> component2() {
        return this.sdkInfo;
    }

    public final Map<String, Object> component3() {
        return this.extraInfo;
    }

    public final ICJPayIntegratedSignCallback component4() {
        return this.callback;
    }

    public final SignPreRouteSessionState component5() {
        return this.state;
    }

    public final SignPreRouteSession copy(CJContext r100, Map<String, String> r101, Map<String, ? extends Object> r110, ICJPayIntegratedSignCallback r111, SignPreRouteSessionState r112) {
        Intrinsics.checkNotNullParameter(r100, "cjContext");
        Intrinsics.checkNotNullParameter(r101, d.D);
        Intrinsics.checkNotNullParameter(r112, "state");
        return new SignPreRouteSession(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SignPreRouteSession) == true) goto L8;
        return false;
    L8:
        SignPreRouteSession r101 = (SignPreRouteSession) r100;
        if (Intrinsics.areEqual(this.cjContext, r101.cjContext) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sdkInfo, r101.sdkInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extraInfo, r101.extraInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.callback, r101.callback) == true) goto L21;
        return false;
    L21:
        if (this.state == r101.state) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.cjContext.hashCode() * 31) + this.sdkInfo.hashCode()) * 31;
        Map<String, Object> r101 = this.extraInfo;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        ICJPayIntegratedSignCallback r105 = this.callback;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((r104 + r102) * 31) + this.state.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "SignPreRouteSession(cjContext=" + this.cjContext + ", sdkInfo=" + this.sdkInfo + ", extraInfo=" + this.extraInfo + ", callback=" + this.callback + ", state=" + this.state + ')';
    }

    public final ICJPayIntegratedSignCallback getCallback() {
        return this.callback;
    }

    public final CJContext getCjContext() {
        return this.cjContext;
    }

    public final Map<String, Object> getExtraInfo() {
        return this.extraInfo;
    }

    public final Map<String, String> getSdkInfo() {
        return this.sdkInfo;
    }

    public final SignPreRouteSessionState getState() {
        return this.state;
    }

    public final void setState(SignPreRouteSessionState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.state = r100;
    }

    public SignPreRouteSession(CJContext r100, Map<String, String> r101, Map<String, ? extends Object> r102, ICJPayIntegratedSignCallback r103, SignPreRouteSessionState r104) {
        Intrinsics.checkNotNullParameter(r100, "cjContext");
        Intrinsics.checkNotNullParameter(r101, d.D);
        Intrinsics.checkNotNullParameter(r104, "state");
        this.cjContext = r100;
        this.sdkInfo = r101;
        this.extraInfo = r102;
        this.callback = r103;
        this.state = r104;
    }

    public /* synthetic */ SignPreRouteSession(CJContext r100, Map r101, Map r102, ICJPayIntegratedSignCallback r110, SignPreRouteSessionState r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 16) == 0) goto L5;
        r111 = SignPreRouteSessionState.CREATED;
    L5:
        this(r100, r101, r102, r110, r111);
    }
}

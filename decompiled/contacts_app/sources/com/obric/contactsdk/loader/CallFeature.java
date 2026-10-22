package com.obric.contactsdk.loader;

import com.obric.callsummary.widget.CallSummaryWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallFeatureEntityUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/obric/contactsdk/loader/CallFeature;", "", "()V", "CALL_CREATE_TIME", "", "getCALL_CREATE_TIME", "()Ljava/lang/String;", "setCALL_CREATE_TIME", "(Ljava/lang/String;)V", "SUMMARY", "getSUMMARY", "setSUMMARY", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallFeature {
    private static String CALL_CREATE_TIME;
    public static final CallFeature INSTANCE = null;
    private static String SUMMARY;

    private CallFeature() {
    }

    static {
        INSTANCE = new CallFeature();
        SUMMARY = CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY;
        CALL_CREATE_TIME = "call_create_time";
    }

    public final String getSUMMARY() {
        return SUMMARY;
    }

    public final void setSUMMARY(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        SUMMARY = r1;
    }

    public final String getCALL_CREATE_TIME() {
        return CALL_CREATE_TIME;
    }

    public final void setCALL_CREATE_TIME(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        CALL_CREATE_TIME = r1;
    }
}

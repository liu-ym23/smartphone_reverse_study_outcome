package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.NothingOutput;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbSendPageStatus;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbSendPageStatus$SendPageStatusInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/NothingOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "SendPageStatusInput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbSendPageStatus extends AbsJSBMethod<SendPageStatusInput, NothingOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbSendPageStatus$SendPageStatusInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "code", "", "url", "", LocationMonitorConst.ERR_MSG, "(ILjava/lang/String;Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SendPageStatusInput implements IJSBParams {
        public int code;
        public String err_msg;
        public String url;

        public SendPageStatusInput() {
            this(0, null, null, 7, null);
        }

        public SendPageStatusInput(int r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "url");
            Intrinsics.checkNotNullParameter(r102, LocationMonitorConst.ERR_MSG);
            this.code = r100;
            this.url = r101;
            this.err_msg = r102;
        }

        public /* synthetic */ SendPageStatusInput(int r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = -1;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = "";
        L11:
            this(r100, r101, r102);
        }
    }

    public AbsJsbSendPageStatus() {
        this.name = "ttcjpay.sendPageStatus";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}

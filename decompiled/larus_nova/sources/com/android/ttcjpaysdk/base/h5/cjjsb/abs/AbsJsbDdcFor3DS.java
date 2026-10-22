package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDdcFor3DS;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDdcFor3DS$DdcFor3DSInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDdcFor3DS$DdcFor3DSOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "DdcFor3DSInput", "DdcFor3DSOutput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbDdcFor3DS extends AbsJSBMethod<DdcFor3DSInput, DdcFor3DSOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDdcFor3DS$DdcFor3DSInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "accessToken", "", "ddcURL", "(Ljava/lang/String;Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DdcFor3DSInput implements IJSBParams {
        public String accessToken;
        public String ddcURL;

        /* JADX WARN: Multi-variable type inference failed */
        public DdcFor3DSInput() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public DdcFor3DSInput(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "accessToken");
            Intrinsics.checkNotNullParameter(r101, "ddcURL");
            this.accessToken = r100;
            this.ddcURL = r101;
        }

        public /* synthetic */ DdcFor3DSInput(String r100, String r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = "";
        L8:
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDdcFor3DS$DdcFor3DSOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "devInfo", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DdcFor3DSOutput extends JSBBaseOutput {
        public JSONObject devInfo;

        /* JADX WARN: Multi-variable type inference failed */
        public DdcFor3DSOutput() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public DdcFor3DSOutput(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "devInfo");
            this.devInfo = r100;
        }

        public /* synthetic */ DdcFor3DSOutput(JSONObject r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = new JSONObject();
        L5:
            this(r100);
        }
    }

    public AbsJsbDdcFor3DS() {
        this.name = "ttcjpay.ddcFor3DS";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}

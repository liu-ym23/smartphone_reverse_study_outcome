package com.android.ttcjpaysdk.facelive.jsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/jsb/abs/AbsJsbCertPluginPreload;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/facelive/jsb/abs/AbsJsbCertPluginPreload$CertPluginPreloadInput;", "Lcom/android/ttcjpaysdk/facelive/jsb/abs/AbsJsbCertPluginPreload$CertPluginPreloadOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "CertPluginPreloadInput", "CertPluginPreloadOutput", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbCertPluginPreload extends AbsJSBMethod<CertPluginPreloadInput, CertPluginPreloadOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/jsb/abs/AbsJsbCertPluginPreload$CertPluginPreloadInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "risk_source", "", "silent_install", "", "merchant_id", "(Ljava/lang/String;ZLjava/lang/String;)V", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CertPluginPreloadInput implements IJSBParams {
        public String merchant_id;
        public String risk_source;
        public boolean silent_install;

        public CertPluginPreloadInput() {
            this(null, false, null, 7, null);
        }

        public CertPluginPreloadInput(String r100, boolean r101, String r102) {
            this.risk_source = r100;
            this.silent_install = r101;
            this.merchant_id = r102;
        }

        public /* synthetic */ CertPluginPreloadInput(String r100, boolean r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = true;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = "";
        L11:
            this(r100, r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\tR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/jsb/abs/AbsJsbCertPluginPreload$CertPluginPreloadOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "code", "", "msg", "", "ext", "(ILjava/lang/String;Ljava/lang/String;)V", "buildLogData", "Lorg/json/JSONObject;", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CertPluginPreloadOutput extends JSBBaseOutput {
        public int code;
        public String ext;
        public String msg;

        public CertPluginPreloadOutput() {
            this(0, null, null, 7, null);
        }

        public final JSONObject buildLogData() {
            JSONObject r100 = new JSONObject();
            KtSafeMethodExtensionKt.safePut(r100, "code", Integer.valueOf(this.code));
            KtSafeMethodExtensionKt.safePut(r100, "msg", this.msg);
            KtSafeMethodExtensionKt.safePut(r100, "ext", this.ext);
            return r100;
        }

        public CertPluginPreloadOutput(int r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            Intrinsics.checkNotNullParameter(r102, "ext");
            this.code = r100;
            this.msg = r101;
            this.ext = r102;
        }

        public /* synthetic */ CertPluginPreloadOutput(int r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
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

    public AbsJsbCertPluginPreload() {
        this.name = "ttcjpay.certPluginPreload";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}

package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbEncrypt;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbEncrypt$EncryptInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbEncrypt$EncryptOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "EncryptInput", "EncryptOutput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbEncrypt extends AbsJSBMethod<EncryptInput, EncryptOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbEncrypt$EncryptInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "data", "", "public_key", "isec_key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class EncryptInput implements IJSBParams {
        public String data;
        public String isec_key;
        public String public_key;

        public EncryptInput() {
            this(null, null, null, 7, null);
        }

        public EncryptInput(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Intrinsics.checkNotNullParameter(r101, "public_key");
            Intrinsics.checkNotNullParameter(r102, "isec_key");
            this.data = r100;
            this.public_key = r101;
            this.isec_key = r102;
        }

        public /* synthetic */ EncryptInput(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = "";
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

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012$\b\u0002\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\tR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbEncrypt$EncryptOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "code", "", "version", "data", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(IILjava/util/HashMap;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class EncryptOutput extends JSBBaseOutput {
        public int code;
        public HashMap<String, String> data;
        public int version;

        public EncryptOutput() {
            this(0, 0, null, 7, null);
        }

        public EncryptOutput(int r100, int r101, HashMap<String, String> r102) {
            Intrinsics.checkNotNullParameter(r102, "data");
            this.code = r100;
            this.version = r101;
            this.data = r102;
        }

        public /* synthetic */ EncryptOutput(int r100, int r101, HashMap r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = 0;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = new HashMap();
        L11:
            this(r100, r101, r102);
        }
    }

    public AbsJsbEncrypt() {
        this.name = "ttcjpay.encrypt";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}

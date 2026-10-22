package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCJAuth;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCJAuth$CJAuthInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCJAuth$CJAuthOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "CJAuthInput", "CJAuthOutput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbCJAuth extends AbsJSBMethod<CJAuthInput, CJAuthOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCJAuth$CJAuthInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "app_id", "", "merchant_id", "log_data", "theme", "success_desc", "fail_desc", "scene", "style", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJAuthInput implements IJSBParams {
        public String app_id;
        public String fail_desc;
        public String log_data;
        public String merchant_id;
        public String scene;
        public String style;
        public String success_desc;
        public String theme;

        public CJAuthInput() {
            this(null, null, null, null, null, null, null, null, 255, null);
        }

        public CJAuthInput(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
            Intrinsics.checkNotNullParameter(r100, "app_id");
            Intrinsics.checkNotNullParameter(r101, "merchant_id");
            Intrinsics.checkNotNullParameter(r102, "log_data");
            Intrinsics.checkNotNullParameter(r103, "theme");
            Intrinsics.checkNotNullParameter(r104, "success_desc");
            Intrinsics.checkNotNullParameter(r105, "fail_desc");
            Intrinsics.checkNotNullParameter(r106, "scene");
            Intrinsics.checkNotNullParameter(r107, "style");
            this.app_id = r100;
            this.merchant_id = r101;
            this.log_data = r102;
            this.theme = r103;
            this.success_desc = r104;
            this.fail_desc = r105;
            this.scene = r106;
            this.style = r107;
        }

        public /* synthetic */ CJAuthInput(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, int r118, DefaultConstructorMarker r119) {
            String r100 = "";
            if ((r118 & 1) == 0) goto L5;
            String r101 = "";
        L7:
            if ((r118 & 2) == 0) goto L9;
            String r102 = "";
        L11:
            if ((r118 & 4) == 0) goto L13;
            String r103 = "";
        L15:
            if ((r118 & 8) == 0) goto L17;
            String r104 = "";
        L19:
            if ((r118 & 16) == 0) goto L21;
            String r105 = "";
        L23:
            if ((r118 & 32) == 0) goto L25;
            String r106 = "";
        L27:
            if ((r118 & 64) == 0) goto L29;
            String r107 = "";
        L31:
            if ((r118 & 128) != 0) goto L34;
            r100 = r117;
        L34:
            this(r101, r102, r103, r104, r105, r106, r107, r100);
            return;
        L29:
            r107 = r116;
            goto L31
        L25:
            r106 = r115;
            goto L27
        L21:
            r105 = r114;
            goto L23
        L17:
            r104 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = r110;
            goto L7
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCJAuth$CJAuthOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "code", "", "(I)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJAuthOutput extends JSBBaseOutput {
        public int code;

        public CJAuthOutput() {
            int r100 = 0;
            this(r100, 1, null);
        }

        public CJAuthOutput(int r100) {
            this.code = r100;
        }

        public /* synthetic */ CJAuthOutput(int r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = -1;
        L5:
            this(r100);
        }
    }

    public AbsJsbCJAuth() {
        this.name = "ttcjpay.CJAuth";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}

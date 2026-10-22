package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.NothingOutput;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayLynxStandardKeepActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCloseCallback;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCloseCallback$CloseCallbackInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/NothingOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "CloseCallbackInput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbCloseCallback extends AbsJSBMethod<CloseCallbackInput, NothingOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCloseCallback$CloseCallbackInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "service", "", "code", "data", "amount", "success_desc", "fail_desc", "fail_toast_desc", CJPayLynxStandardKeepActivity.INTENT_CALLBACK_ID, "ext", "style", "pay_token", "is_voucher_expand", "need_close", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CloseCallbackInput implements IJSBParams {
        public String amount;
        public String callback_id;
        public String code;
        public String data;
        public String ext;
        public String fail_desc;
        public String fail_toast_desc;
        public String is_voucher_expand;
        public int need_close;
        public String pay_token;
        public String service;
        public String style;
        public String success_desc;

        public CloseCallbackInput() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, 0, 8191, null);
        }

        public CloseCallbackInput(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112, String r113, int r114) {
            Intrinsics.checkNotNullParameter(r100, "service");
            Intrinsics.checkNotNullParameter(r101, "code");
            Intrinsics.checkNotNullParameter(r102, "data");
            Intrinsics.checkNotNullParameter(r103, "amount");
            Intrinsics.checkNotNullParameter(r104, "success_desc");
            Intrinsics.checkNotNullParameter(r105, "fail_desc");
            Intrinsics.checkNotNullParameter(r106, "fail_toast_desc");
            Intrinsics.checkNotNullParameter(r107, CJPayLynxStandardKeepActivity.INTENT_CALLBACK_ID);
            Intrinsics.checkNotNullParameter(r110, "ext");
            Intrinsics.checkNotNullParameter(r111, "style");
            Intrinsics.checkNotNullParameter(r112, "pay_token");
            Intrinsics.checkNotNullParameter(r113, "is_voucher_expand");
            this.service = r100;
            this.code = r101;
            this.data = r102;
            this.amount = r103;
            this.success_desc = r104;
            this.fail_desc = r105;
            this.fail_toast_desc = r106;
            this.callback_id = r107;
            this.ext = r110;
            this.style = r111;
            this.pay_token = r112;
            this.is_voucher_expand = r113;
            this.need_close = r114;
        }

        public /* synthetic */ CloseCallbackInput(String r110, String r111, String r112, String r113, String r114, String r210, String r211, String r212, String r213, String r214, String r215, String r216, int r217, int r218, DefaultConstructorMarker r219) {
            String r100 = "";
            if ((r218 & 1) == 0) goto L5;
            String r101 = "";
        L7:
            if ((r218 & 2) == 0) goto L9;
            String r102 = "";
        L11:
            if ((r218 & 4) == 0) goto L13;
            String r103 = "";
        L15:
            if ((r218 & 8) == 0) goto L17;
            String r104 = "";
        L19:
            if ((r218 & 16) == 0) goto L21;
            String r105 = "";
        L23:
            if ((r218 & 32) == 0) goto L25;
            String r106 = "";
        L27:
            if ((r218 & 64) == 0) goto L29;
            String r107 = "";
        L31:
            if ((r218 & 128) == 0) goto L33;
            String r108 = "";
        L35:
            if ((r218 & 256) == 0) goto L37;
            String r115 = "";
        L39:
            if ((r218 & 512) == 0) goto L41;
            String r116 = "";
        L43:
            if ((r218 & 1024) == 0) goto L45;
            String r117 = "";
        L47:
            if ((r218 & 2048) != 0) goto L51;
            r100 = r216;
        L51:
            if ((r218 & 4096) == 0) goto L53;
            int r109 = 0;
        L54:
            this(r101, r102, r103, r104, r105, r106, r107, r108, r115, r116, r117, r100, r109);
            return;
        L53:
            r109 = r217;
            goto L54
        L45:
            r117 = r215;
            goto L47
        L41:
            r116 = r214;
            goto L43
        L37:
            r115 = r213;
            goto L39
        L33:
            r108 = r212;
            goto L35
        L29:
            r107 = r211;
            goto L31
        L25:
            r106 = r210;
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

    public AbsJsbCloseCallback() {
        this.name = "ttcjpay.closeCallback";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}

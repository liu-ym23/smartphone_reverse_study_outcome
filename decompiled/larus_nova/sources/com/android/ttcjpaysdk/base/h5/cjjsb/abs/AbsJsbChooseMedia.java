package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbChooseMedia;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbChooseMedia$ChooseMediaInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbChooseMedia$ChooseMediaOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "ChooseMediaInput", "ChooseMediaOutput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbChooseMedia extends AbsJSBMethod<ChooseMediaInput, ChooseMediaOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006¢\u0006\u0002\u0010\u0012R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbChooseMedia$ChooseMediaInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "camera_type", "", "source_type", "compress_size", "", "save_to_dcim", "aid", "timestamp", "signType", "sign", "onlyReturnDeviceType", "", "reuse_compressed_image", "riskInfoParams", "Lorg/json/JSONObject;", "maxCount", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLorg/json/JSONObject;I)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ChooseMediaInput implements IJSBParams {
        public String aid;
        public String camera_type;
        public int compress_size;
        public int maxCount;
        public boolean onlyReturnDeviceType;
        public boolean reuse_compressed_image;
        public JSONObject riskInfoParams;
        public String save_to_dcim;
        public String sign;
        public String signType;
        public String source_type;
        public String timestamp;

        public ChooseMediaInput() {
            this(null, null, 0, null, null, null, null, null, false, false, null, 0, UnixStat.PERM_MASK, null);
        }

        public ChooseMediaInput(String r100, String r101, int r102, String r103, String r104, String r105, String r106, String r107, boolean r110, boolean r111, JSONObject r112, int r113) {
            Intrinsics.checkNotNullParameter(r100, "camera_type");
            Intrinsics.checkNotNullParameter(r101, "source_type");
            Intrinsics.checkNotNullParameter(r103, "save_to_dcim");
            Intrinsics.checkNotNullParameter(r104, "aid");
            Intrinsics.checkNotNullParameter(r105, "timestamp");
            Intrinsics.checkNotNullParameter(r106, "signType");
            Intrinsics.checkNotNullParameter(r107, "sign");
            Intrinsics.checkNotNullParameter(r112, "riskInfoParams");
            this.camera_type = r100;
            this.source_type = r101;
            this.compress_size = r102;
            this.save_to_dcim = r103;
            this.aid = r104;
            this.timestamp = r105;
            this.signType = r106;
            this.sign = r107;
            this.onlyReturnDeviceType = r110;
            this.reuse_compressed_image = r111;
            this.riskInfoParams = r112;
            this.maxCount = r113;
        }

        public /* synthetic */ ChooseMediaInput(String r110, String r111, int r112, String r113, String r114, String r115, String r210, String r211, boolean r212, boolean r213, JSONObject r214, int r215, int r216, DefaultConstructorMarker r217) {
            String r100 = "";
            if ((r216 & 1) == 0) goto L5;
            String r101 = "";
        L7:
            if ((r216 & 2) == 0) goto L9;
            String r102 = "";
        L10:
            int r103 = 0;
            if ((r216 & 4) == 0) goto L13;
            int r104 = 0;
        L15:
            if ((r216 & 8) == 0) goto L17;
            String r105 = "";
        L19:
            if ((r216 & 16) == 0) goto L21;
            String r106 = "";
        L23:
            if ((r216 & 32) == 0) goto L25;
            String r107 = "";
        L27:
            if ((r216 & 64) == 0) goto L29;
            String r108 = "";
        L31:
            if ((r216 & 128) != 0) goto L35;
            r100 = r211;
        L35:
            if ((r216 & 256) == 0) goto L37;
            boolean r116 = false;
        L39:
            if ((r216 & 512) == 0) goto L41;
            boolean r117 = false;
        L43:
            if ((r216 & 1024) == 0) goto L45;
            JSONObject r118 = new JSONObject();
        L47:
            if ((r216 & 2048) != 0) goto L50;
            r103 = r215;
        L50:
            this(r101, r102, r104, r105, r106, r107, r108, r100, r116, r117, r118, r103);
            return;
        L45:
            r118 = r214;
            goto L47
        L41:
            r117 = r213;
            goto L43
        L37:
            r116 = r212;
            goto L39
        L29:
            r108 = r210;
            goto L31
        L25:
            r107 = r115;
            goto L27
        L21:
            r106 = r114;
            goto L23
        L17:
            r105 = r113;
            goto L19
        L13:
            r104 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L10
        L5:
            r101 = r110;
            goto L7
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbChooseMedia$ChooseMediaOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "code", "", "msg", "", "data", "Lorg/json/JSONObject;", "(ILjava/lang/String;Lorg/json/JSONObject;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ChooseMediaOutput extends JSBBaseOutput {
        public int code;
        public JSONObject data;
        public String msg;

        public ChooseMediaOutput() {
            this(0, null, null, 7, null);
        }

        public ChooseMediaOutput(int r100, String r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            Intrinsics.checkNotNullParameter(r102, "data");
            this.code = r100;
            this.msg = r101;
            this.data = r102;
        }

        public /* synthetic */ ChooseMediaOutput(int r100, String r101, JSONObject r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = new JSONObject();
        L11:
            this(r100, r101, r102);
        }
    }

    public AbsJsbChooseMedia() {
        this.name = "ttcjpay.chooseMedia";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}

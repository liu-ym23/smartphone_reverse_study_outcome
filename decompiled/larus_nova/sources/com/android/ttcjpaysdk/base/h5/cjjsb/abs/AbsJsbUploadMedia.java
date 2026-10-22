package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbUploadMedia;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbUploadMedia$UploadMediaInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbUploadMedia$UploadMediaOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "UploadMediaInput", "UploadMediaOutput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbUploadMedia extends AbsJSBMethod<UploadMediaInput, UploadMediaOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0002\u0010\u0014R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbUploadMedia$UploadMediaInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "file_path", "", "file_paths", "", "header", "params", "public_key", "isec_key", "compress_limit", "", "url", "use_binary_upload", "", "ext_request_params", "Lorg/json/JSONObject;", "need_common_params", "reuse_compressed_image", "is_caijing_saas", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLorg/json/JSONObject;ZZLjava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UploadMediaInput implements IJSBParams {
        public int compress_limit;
        public JSONObject ext_request_params;
        public String file_path;
        public List<String> file_paths;
        public String header;
        public String is_caijing_saas;
        public String isec_key;
        public boolean need_common_params;
        public String params;
        public String public_key;
        public boolean reuse_compressed_image;
        public String url;
        public boolean use_binary_upload;

        public UploadMediaInput() {
            this(null, null, null, null, null, null, 0, null, false, null, false, false, null, 8191, null);
        }

        public UploadMediaInput(String r100, List<String> r101, String r102, String r103, String r104, String r105, int r106, String r107, boolean r110, JSONObject r111, boolean r112, boolean r113, String r114) {
            Intrinsics.checkNotNullParameter(r100, "file_path");
            Intrinsics.checkNotNullParameter(r101, "file_paths");
            Intrinsics.checkNotNullParameter(r102, "header");
            Intrinsics.checkNotNullParameter(r103, "params");
            Intrinsics.checkNotNullParameter(r104, "public_key");
            Intrinsics.checkNotNullParameter(r105, "isec_key");
            Intrinsics.checkNotNullParameter(r107, "url");
            Intrinsics.checkNotNullParameter(r111, "ext_request_params");
            Intrinsics.checkNotNullParameter(r114, "is_caijing_saas");
            this.file_path = r100;
            this.file_paths = r101;
            this.header = r102;
            this.params = r103;
            this.public_key = r104;
            this.isec_key = r105;
            this.compress_limit = r106;
            this.url = r107;
            this.use_binary_upload = r110;
            this.ext_request_params = r111;
            this.need_common_params = r112;
            this.reuse_compressed_image = r113;
            this.is_caijing_saas = r114;
        }

        public /* synthetic */ UploadMediaInput(String r110, List r111, String r112, String r113, String r210, String r211, int r212, String r213, boolean r214, JSONObject r215, boolean r216, boolean r217, String r218, int r219, DefaultConstructorMarker r310) {
            String r100 = "";
            if ((r219 & 1) == 0) goto L5;
            String r101 = "";
        L7:
            if ((r219 & 2) == 0) goto L9;
            List r102 = CollectionsKt.emptyList();
        L11:
            if ((r219 & 4) == 0) goto L13;
            String r103 = "";
        L15:
            if ((r219 & 8) == 0) goto L17;
            String r104 = "";
        L19:
            if ((r219 & 16) == 0) goto L21;
            String r105 = "";
        L23:
            if ((r219 & 32) == 0) goto L25;
            String r106 = "";
        L26:
            boolean r107 = false;
            if ((r219 & 64) == 0) goto L29;
            int r108 = 0;
        L31:
            if ((r219 & 128) == 0) goto L33;
            String r114 = "";
        L35:
            if ((r219 & 256) == 0) goto L37;
            boolean r115 = false;
        L39:
            if ((r219 & 512) == 0) goto L41;
            JSONObject r116 = new JSONObject();
        L43:
            if ((r219 & 1024) == 0) goto L45;
            boolean r117 = false;
        L47:
            if ((r219 & 2048) != 0) goto L51;
            r107 = r217;
        L51:
            if ((r219 & 4096) != 0) goto L54;
            r100 = r218;
        L54:
            this(r101, r102, r103, r104, r105, r106, r108, r114, r115, r116, r117, r107, r100);
            return;
        L45:
            r117 = r216;
            goto L47
        L41:
            r116 = r215;
            goto L43
        L37:
            r115 = r214;
            goto L39
        L33:
            r114 = r213;
            goto L35
        L29:
            r108 = r212;
            goto L31
        L25:
            r106 = r211;
            goto L26
        L21:
            r105 = r210;
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
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbUploadMedia$UploadMediaOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "code", "", "msg", "", "data", "Lorg/json/JSONObject;", "(ILjava/lang/String;Lorg/json/JSONObject;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UploadMediaOutput extends JSBBaseOutput {
        public int code;
        public JSONObject data;
        public String msg;

        public UploadMediaOutput() {
            this(0, null, null, 7, null);
        }

        public UploadMediaOutput(int r100, String r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            Intrinsics.checkNotNullParameter(r102, "data");
            this.code = r100;
            this.msg = r101;
            this.data = r102;
        }

        public /* synthetic */ UploadMediaOutput(int r100, String r101, JSONObject r102, int r103, DefaultConstructorMarker r104) {
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

    public AbsJsbUploadMedia() {
        this.name = "ttcjpay.uploadMedia";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}

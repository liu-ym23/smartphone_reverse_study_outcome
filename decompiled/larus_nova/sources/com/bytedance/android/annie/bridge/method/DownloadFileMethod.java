package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.security.MessageDigest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "downloadFile")
public final class DownloadFileMethod extends com.bytedance.ies.web.jsbridge2.f<a, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHybridComponent f38460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.annie.container.fragment.q f38461b;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b(\u0010)R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R0\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R0\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R$\u0010%\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000f¨\u0006+"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/DownloadFileMethod$DownloadFileResModel;", "Le7/k0;", "Lcom/bytedance/android/annie/bridge/method/DownloadFileMethod$DownloadFileResModel$Code;", "code", "Lcom/bytedance/android/annie/bridge/method/DownloadFileMethod$DownloadFileResModel$Code;", "getCode", "()Lcom/bytedance/android/annie/bridge/method/DownloadFileMethod$DownloadFileResModel$Code;", "b", "(Lcom/bytedance/android/annie/bridge/method/DownloadFileMethod$DownloadFileResModel$Code;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "", "clientCode", "Ljava/lang/Integer;", "getClientCode", "()Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/Integer;)V", "httpCode", "getHttpCode", "e", "", "", "header", "Ljava/util/Map;", "getHeader", "()Ljava/util/Map;", "d", "(Ljava/util/Map;)V", "response", "getResponse", "setResponse", "filePath", "getFilePath", "c", "<init>", "()V", "Code", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class DownloadFileResModel implements e7.k0 {

        @SerializedName("clientCode")
        private Integer clientCode;

        @SerializedName("code")
        private Code code;

        @SerializedName("filePath")
        private String filePath;

        @SerializedName("header")
        private Map<String, ? extends Object> header;

        @SerializedName("httpCode")
        private Integer httpCode;

        @SerializedName("msg")
        private String msg;

        @SerializedName("response")
        private Map<String, ? extends Object> response;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/DownloadFileMethod$DownloadFileResModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "FailedPermissionRejected", "annie_release"}, k = 1, mv = {1, 4, 3})
        public static final enum Code extends Enum<Code> implements e7.j0 {
            public static final Code Failed = null;
            public static final Code FailedPermissionRejected = null;
            public static final Code Success = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Code[] f38462a = null;
            private final int value;

            public static Code valueOf(String r100) {
                return (Code) r27.a.a(Code.class, r100);
            }

            public static Code[] values() {
                return (Code[]) f38462a.clone();
            }

            static {
                Code r100 = new Code("Success", 0, 1);
                Success = r100;
                Code r101 = new Code("Failed", 1, 0);
                Failed = r101;
                Code r102 = new Code("FailedPermissionRejected", 2, -6);
                FailedPermissionRejected = r102;
                f38462a = new Code[]{r100, r101, r102};
            }

            @Override // e7.j0
            public int getCode() {
                return this.value;
            }

            public final int getValue() {
                return this.value;
            }

            public Code(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public DownloadFileResModel() {
            this.clientCode = 0;
            this.httpCode = 0;
        }

        public final void a(Integer r100) {
            this.clientCode = r100;
        }

        public final void b(Code r100) {
            this.code = r100;
        }

        public final void c(String r100) {
            this.filePath = r100;
        }

        public final void d(Map<String, ? extends Object> r100) {
            this.header = r100;
        }

        public final void e(Integer r100) {
            this.httpCode = r100;
        }

        public final void f(String r100) {
            this.msg = r100;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR0\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R0\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\b¨\u0006\""}, d2 = {"Lcom/bytedance/android/annie/bridge/method/DownloadFileMethod$a;", "", "", "url", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "extension", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setExtension", "", "header", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setHeader", "(Ljava/util/Map;)V", "params", "d", "setParams", "", "needCommonParams", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "setNeedCommonParams", "(Ljava/lang/Boolean;)V", "saveToAlbum", "e", "setSaveToAlbum", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("extension")
        private String extension;

        @SerializedName("header")
        private Map<String, ? extends Object> header;

        @SerializedName("needCommonParams")
        private Boolean needCommonParams;

        @SerializedName("params")
        private Map<String, ? extends Object> params;

        @SerializedName("saveToAlbum")
        private String saveToAlbum;

        @SerializedName("url")
        private String url;

        public a() {
            this.needCommonParams = Boolean.TRUE;
        }

        public final String a() {
            return this.extension;
        }

        public final Map<String, Object> b() {
            return this.header;
        }

        public final Boolean c() {
            return this.needCommonParams;
        }

        public final Map<String, Object> d() {
            return this.params;
        }

        public final String e() {
            return this.saveToAlbum;
        }

        public final String f() {
            return this.url;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public DownloadFileMethod(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        IHybridComponent r101 = (IHybridComponent) r100.c(IHybridComponent.class);
        if (r101 == null) goto L5;
        this.f38460a = r101;
    L5:
        com.bytedance.android.annie.container.fragment.q r102 = (com.bytedance.android.annie.container.fragment.q) r100.c(com.bytedance.android.annie.container.fragment.q.class);
        if (r102 == null) goto L9;
        this.f38461b = r102;
        return;
    }

    public DownloadFileMethod(IHybridComponent r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridComponent");
        this.f38460a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r110, CallContext r111) {
        a r100 = r110;
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r112 = r100.f();
        boolean r101 = false;
        if (r112 != null) goto L5;
    L8:
        boolean r113 = true;
    L9:
        if (r113 == false) goto L11;
        DownloadFileResModel r114 = new DownloadFileResModel();
        r114.b(DownloadFileResModel.Code.Failed);
        r114.f("url  is  null");
        finishWithResult(r114);
        return;
    L11:
        Context r102 = r111.getContext();
        String r115 = r100.f();
        if (r115 != null) goto L14;
    L17:
        boolean r116 = true;
    L18:
        String r103 = null;
        if (r116 == true) goto L35;
        StringBuilder r117 = new StringBuilder();
        char[] r104 = com.bytedance.android.annie.util.j.f40064a;
        String r105 = r100.f();
        Intrinsics.checkNotNull(r105);
        Intrinsics.checkNotNullParameter(r105, "string");
        byte[] r106 = r105.getBytes(Charsets.UTF_8);     // Catch: Exception -> L31
        MessageDigest r107 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L28
        r107.update(r106);     // Catch: Exception -> L28
        byte[] r108 = r107.digest();     // Catch: Exception -> L28
        char[] r109 = new char[32];     // Catch: Exception -> L28
        int r118 = 0;
        int r119 = 0;
    L24:
        if (r118 >= 16) goto L26;
        byte r120 = r108[r118];     // Catch: Exception -> L28
        int r121 = r119 + 1;     // Catch: Exception -> L28
        char[] r122 = com.bytedance.android.annie.util.j.f40064a;     // Catch: Exception -> L28
        r109[r119] = r122[(r120 >>> 4) & 15];     // Catch: Exception -> L28
        r119 = r121 + 1;     // Catch: Exception -> L28
        r109[r121] = r122[r120 & 15];     // Catch: Exception -> L28
        r118 = r118 + 1;     // Catch: Exception -> L28
        goto L24
    L26:
        String r123 = r109.toString();     // Catch: Exception -> L28
    L34:
        r117.append(r123);
        r117.append('_');
        r117.append(System.currentTimeMillis());
        String r124 = r117.toString();
    L36:
        String r125 = r124 + '.' + r100.a();
        File r126 = r102.getExternalCacheDir();
        if (r126 != null) goto L39;
        r126 = r102.getCacheDir();
    L39:
        if (r126 == null) goto L41;
        r103 = r126.getAbsolutePath();
    L41:
        if (r103 != null) goto L43;
    L44:
        r101 = true;
    L45:
        if (r101 == false) goto L47;
        DownloadFileResModel r127 = new DownloadFileResModel();
        r127.b(DownloadFileResModel.Code.Failed);
        r127.f("cacheDir is null");
        finishWithResult(r127);
        return;
    L47:
        String r128 = r103 + '/' + r125;
        if (new PolarisFileWrapper(r128).exists() == false) goto L50;
        DownloadFileResModel r129 = new DownloadFileResModel();
        r129.b(DownloadFileResModel.Code.Failed);
        r129.f("file path already exist");
        finishWithResult(r129);
        return;
    L50:
        TTExecutors.getNormalExecutor().execute(new r(r100, this, r111, r128, r102));
        return;
    L43:
        if (StringsKt.isBlank(r103) == false) goto L45;
    L28:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L31
    L33:
        r123 = null;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L33
    L35:
        r124 = "base64_" + System.currentTimeMillis();
        goto L36
    L14:
        if (StringsKt.isBlank(r115) == true) goto L17;
        r116 = false;
        goto L18
    L5:
        if (StringsKt.isBlank(r112) == true) goto L8;
        r113 = false;
        goto L9
    }
}

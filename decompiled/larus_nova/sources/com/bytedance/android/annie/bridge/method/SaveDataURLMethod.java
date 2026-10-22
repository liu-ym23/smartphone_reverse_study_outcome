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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "saveDataURL")
public final class SaveDataURLMethod extends com.bytedance.ies.web.jsbridge2.f<a, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHybridComponent f38468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.annie.container.fragment.q f38469b;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/SaveDataURLMethod$SaveDataURLResModel;", "Le7/k0;", "Lcom/bytedance/android/annie/bridge/method/SaveDataURLMethod$SaveDataURLResModel$Code;", "code", "Lcom/bytedance/android/annie/bridge/method/SaveDataURLMethod$SaveDataURLResModel$Code;", "getCode", "()Lcom/bytedance/android/annie/bridge/method/SaveDataURLMethod$SaveDataURLResModel$Code;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lcom/bytedance/android/annie/bridge/method/SaveDataURLMethod$SaveDataURLResModel$Code;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "filePath", "getFilePath", "b", "<init>", "()V", "Code", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class SaveDataURLResModel implements e7.k0 {

        @SerializedName("code")
        private Code code;

        @SerializedName("filePath")
        private String filePath;

        @SerializedName("msg")
        private String msg;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/SaveDataURLMethod$SaveDataURLResModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "Failed_-3", "FailedPermissionRejected", "annie_release"}, k = 1, mv = {1, 4, 3})
        public static final enum Code extends Enum<Code> implements e7.j0 {
            public static final Code Failed = null;
            public static final Code FailedPermissionRejected = null;

            /* JADX INFO: renamed from: Failed_-3, reason: not valid java name */
            public static final Code f57Failed_3 = null;
            public static final Code Success = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Code[] f38470a = null;
            private final int value;

            public static Code valueOf(String r100) {
                return (Code) r27.a.a(Code.class, r100);
            }

            public static Code[] values() {
                return (Code[]) f38470a.clone();
            }

            static {
                Code r100 = new Code("Success", 0, 1);
                Success = r100;
                Code r101 = new Code("Failed", 1, 0);
                Failed = r101;
                Code r102 = new Code("Failed_-3", 2, -3);
                f57Failed_3 = r102;
                Code r103 = new Code("FailedPermissionRejected", 3, -6);
                FailedPermissionRejected = r103;
                f38470a = new Code[]{r100, r101, r102, r103};
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

        public SaveDataURLResModel() {
        }

        public final void a(Code r100) {
            this.code = r100;
        }

        public final void b(String r100) {
            this.filePath = r100;
        }

        public final void c(String r100) {
            this.msg = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/SaveDataURLMethod$a;", "", "", "filename", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setFilename", "(Ljava/lang/String;)V", "dataURL", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDataURL", "extension", "b", "setExtension", "saveToAlbum", "d", "setSaveToAlbum", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("dataURL")
        private String dataURL;

        @SerializedName("extension")
        private String extension;

        @SerializedName("filename")
        private String filename;

        @SerializedName("saveToAlbum")
        private String saveToAlbum;

        public a() {
        }

        public final String a() {
            return this.dataURL;
        }

        public final String b() {
            return this.extension;
        }

        public final String c() {
            return this.filename;
        }

        public final String d() {
            return this.saveToAlbum;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public SaveDataURLMethod(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        IHybridComponent r101 = (IHybridComponent) r100.c(IHybridComponent.class);
        if (r101 == null) goto L5;
        this.f38468a = r101;
    L5:
        com.bytedance.android.annie.container.fragment.q r102 = (com.bytedance.android.annie.container.fragment.q) r100.c(com.bytedance.android.annie.container.fragment.q.class);
        if (r102 == null) goto L9;
        this.f38469b = r102;
        return;
    }

    public SaveDataURLMethod(IHybridComponent r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridComponent");
        this.f38468a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r100, CallContext r101) {
        a r102 = r100;
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        boolean r104 = true;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
        SaveDataURLResModel r106 = new SaveDataURLResModel();
        r106.a(SaveDataURLResModel.Code.f57Failed_3);
        r106.c("dataURL must be provided");
        finishWithResult(r106);
        return;
    L11:
        String r107 = r102.c();
        if (r107 != null) goto L14;
    L17:
        boolean r108 = true;
    L18:
        if (r108 == false) goto L20;
        SaveDataURLResModel r109 = new SaveDataURLResModel();
        r109.a(SaveDataURLResModel.Code.f57Failed_3);
        r109.c("filename must be provided ");
        finishWithResult(r109);
        return;
    L20:
        String r110 = r102.b();
        if (r110 != null) goto L23;
    L26:
        boolean r111 = true;
    L27:
        if (r111 == false) goto L29;
        SaveDataURLResModel r112 = new SaveDataURLResModel();
        r112.a(SaveDataURLResModel.Code.f57Failed_3);
        r112.c("extension must be provided");
        finishWithResult(r112);
        return;
    L29:
        Context r113 = r101.getContext();
        File r114 = r113.getExternalCacheDir();
        if (r114 != null) goto L32;
        r114 = r113.getCacheDir();
    L32:
        if (r114 == null) goto L34;
        String r115 = r114.getAbsolutePath();
    L35:
        if (r115 != null) goto L37;
    L40:
        if (r104 == false) goto L42;
        SaveDataURLResModel r116 = new SaveDataURLResModel();
        r116.a(SaveDataURLResModel.Code.Failed);
        r116.c("cacheDir is null");
        finishWithResult(r116);
        return;
    L42:
        String r117 = r115 + '/' + (r102.c() + '.' + r102.b());
        if (new PolarisFileWrapper(r117).exists() == false) goto L45;
        SaveDataURLResModel r118 = new SaveDataURLResModel();
        r118.a(SaveDataURLResModel.Code.Failed);
        r118.c("file path already exist");
        finishWithResult(r118);
        return;
    L45:
        TTExecutors.getNormalExecutor().execute(new y1(r102, r117, this, r113));
        return;
    L37:
        if (StringsKt.isBlank(r115) == true) goto L40;
        r104 = false;
        goto L40
    L34:
        r115 = null;
        goto L35
    L23:
        if (StringsKt.isBlank(r110) == true) goto L26;
        r111 = false;
        goto L27
    L14:
        if (StringsKt.isBlank(r107) == true) goto L17;
        r108 = false;
        goto L18
    L5:
        if (StringsKt.isBlank(r103) == true) goto L8;
        r105 = false;
        goto L9
    }
}

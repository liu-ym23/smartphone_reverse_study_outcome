package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import com.bytedance.android.annie.bridge.UploadFileResultModel;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "uploadFile")
public final class t2 extends com.bytedance.android.annie.bridge.f<com.bytedance.android.annie.bridge.u, UploadFileResultModel> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public t2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        com.bytedance.android.annie.bridge.u r100 = (com.bytedance.android.annie.bridge.u) r110;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Context r112 = r111.getContext();
        ae7.a r101 = ae7.a.f3109a;
        String r102 = r100.a();
        r101.getClass();
        if (ae7.a.e(r112, r102) == true) goto L6;
        UploadFileResultModel r113 = new UploadFileResultModel();
        r113.b(UploadFileResultModel.Code.Failed);
        r113.d("File not exists");
        finishWithResult(r113);
        return;
    L6:
        if (ae7.a.d(r112, r100.a()) == false) goto L57;
        s2 r103 = new s2(this);
        if (r100.a().length() <= 0) goto L10;
        boolean r104 = true;
    L11:
        LinkedHashMap r105 = null;
        if (r104 == false) goto L53;
        String r106 = r100.a();
        if (r106 != null) goto L16;
    L19:
        boolean r107 = true;
    L20:
        if (r107 == false) goto L22;
        r103.b(UploadFileResultModel.Code.InvalidParam, "The file path should not be empty.The key is filePath", null);
    L49:
        PolarisFileWrapper r108 = null;
    L50:
        if (r108 == null) goto L54;
        r105 = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("file", r108)});
    L54:
        if (r105 == null) goto L61;
        TTExecutors.getNormalExecutor().execute(new r2(r100, this, r111, r105, r103));
        return;
    L61:
        return;
    L22:
        String r114 = ae7.a.a(r112, r106);
        if (r114 != null) goto L25;
    L28:
        boolean r109 = true;
    L30:
        if (r109 == false) goto L32;
        r103.b(UploadFileResultModel.Code.Failed, "File is not exist.The key is filePath", null);
        goto L49
    L32:
        r108 = new PolarisFileWrapper(r114);
        if (r108.exists() == true) goto L36;
        r103.b(UploadFileResultModel.Code.Failed, "File is not exist.The key is filePath", null);
        goto L49
    L36:
        if (r108.isFile() == true) goto L38;
        r103.b(UploadFileResultModel.Code.Failed, "File is not file.The key is filePath", null);
        goto L49
    L38:
        Lazy<ArgusGlobalDelegate> r115 = ArgusGlobalDelegate.f245624c;
        ArgusGlobalDelegate r116 = ArgusGlobalDelegate.a.a();
        if (r116 == null) goto L41;
        com.bytedance.ies.argus.bean.i r117 = r116.b(new com.bytedance.ies.argus.api.params.b(r114, "uploadFile"));
    L42:
        if (r117 != null) goto L44;
    L46:
        boolean r118 = false;
    L47:
        if (r118 == false) goto L50;
        r103.b(UploadFileResultModel.Code.Failed, "file path " + r114 + " contains sensitive content, can not upload.", null);
        goto L49
    L44:
        if (r117.c() != true) goto L46;
        r118 = true;
        goto L47
    L41:
        r117 = null;
        goto L42
    L25:
        if (r114.length() == 0) goto L28;
        r109 = false;
        goto L30
    L16:
        if (r106.length() == 0) goto L19;
        r107 = false;
        goto L20
    L53:
        r103.b(UploadFileResultModel.Code.InvalidParam, "filePath can not be null.", null);
        goto L54
    L10:
        r104 = false;
        goto L11
    L57:
        UploadFileResultModel r119 = new UploadFileResultModel();
        r119.b(UploadFileResultModel.Code.Failed);
        r119.d("has no permission for file");
        finishWithResult(r119);
    }
}

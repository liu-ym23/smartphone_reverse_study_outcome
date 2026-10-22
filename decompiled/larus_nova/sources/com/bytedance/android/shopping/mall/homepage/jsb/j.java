package com.bytedance.android.shopping.mall.homepage.jsb;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class j extends qf3.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f178203d;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return "ec.mallLocalImageDisplayCheck";
    }

    public j(qf3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        super(r100);
        this.f178203d = MSkiaImageRegionDecoder.FILE_PREFIX;
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r100, IBDXBridgeContext r101, Map<String, ? extends Object> r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "result");
        Context r104 = r100.f532722a;
        boolean r105 = true;
        boolean r106 = false;
        if (r104 != null) goto L5;
    L7:
        boolean r107 = false;
    L9:
        if (r107 == false) goto L12;
        r103.put("canDisplayImage", Boolean.FALSE);
        r103.put("displayFailReason", "album_not_authorized");
        return qf3.e.f(this);
    L12:
        Object r108 = r102.get("imageLocalPath");
        if ((r108 instanceof String) == true) goto L15;
        r108 = null;
    L15:
        String r109 = (String) r108;
        if (r109 != null) goto L18;
    L21:
        if (r105 == true) goto L24;
        r106 = new PolarisFileWrapper(r109).exists();
    L24:
        if (r106 == false) goto L27;
        r103.put("canDisplayImage", Boolean.TRUE);
        r103.put("imagePath", this.f178203d + r109);
        return qf3.e.f(this);
    L27:
        r103.put("canDisplayImage", Boolean.FALSE);
        r103.put("displayFailReason", "picture_not_exist");
        return qf3.e.f(this);
    L18:
        if (r109.length() == 0) goto L21;
        r105 = false;
        goto L21
    L5:
        if (ContextCompat.checkSelfPermission(r104, "android.permission.READ_EXTERNAL_STORAGE") != (-1)) goto L7;
        r107 = true;
        goto L9
    }
}

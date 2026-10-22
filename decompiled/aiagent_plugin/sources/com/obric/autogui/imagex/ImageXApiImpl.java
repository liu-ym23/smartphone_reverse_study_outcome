package com.obric.autogui.imagex;

import android.graphics.Bitmap;
import com.obric.autogui.tools.api.IImageXApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import java.util.List;

/* JADX INFO: compiled from: ImageXApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ImageXApiImpl implements IImageXApi {
    public ImageXApiImpl() {
    }

    @Override // com.obric.autogui.tools.api.IImageXApi
    public Object uploadImages(List<Bitmap> r2, d<? super List<String>> r3) {
        List<Bitmap> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d<? super List<String>> r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return b.f29105a.a(r1, r4);
    }
}

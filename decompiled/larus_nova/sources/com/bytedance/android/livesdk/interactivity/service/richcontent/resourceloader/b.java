package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.interactivity.service.textrender.inject.IGiftImageGetter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements hk6.c<ob2.b> {
    public b() {
    }

    @Override // hk6.c
    public final Drawable b(ek6.b r100, ak6.f r101, ek6.d r102) {
        ob2.b r103 = (ob2.b) r100;
        Intrinsics.checkNotNullParameter(r103, "resourceInfo");
        Intrinsics.checkNotNullParameter(r101, "loadConfig");
        Intrinsics.checkNotNullParameter(r102, "content");
        long r104 = r103.f522595a;
        IGiftImageGetter r105 = (IGiftImageGetter) jc1.k.f(IGiftImageGetter.class);
        if (r105 == null) goto L14;
        py.k r106 = r105.getGiftImage(r104);
        if (r106 == null) goto L14;
        String r107 = ((IHostFrescoHelper) jc1.k.n(IHostFrescoHelper.class)).getImageFilePath(r106);
        if (r107 == null) goto L14;
        Bitmap r108 = BitmapFactory.decodeFile(r107);
        if (r108 == null) goto L14;
        return new BitmapDrawable(s1.getResources(), r108);
    L14:
        return null;
    }
}

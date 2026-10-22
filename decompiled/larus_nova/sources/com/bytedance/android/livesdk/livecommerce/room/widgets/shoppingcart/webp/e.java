package com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp;

import android.text.TextUtils;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: classes10.dex */
public final class e extends yk2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f152771a;

    @Override // yk2.d
    public final <T> T a() {
        if (this.f152771a == null) goto L41;
        List<String> r100 = this.f152771a;
        if (r100 != null) goto L8;
    L30:
        ImageRequest[] r101 = null;
    L32:
        if ((r101 instanceof Object) == true) goto L35;
        return null;
    L35:
        return (T) r101;
    L8:
        if (r100.size() == 0) goto L30;
        if (ECLiveImageUtils.k() == false) goto L19;
        Pair<List<ImageRequest>, r> r102 = ImageExtensionsKt.m(r100, null, null, null, null);
        if (r102 == null) goto L19;
        if (r102.getFirst() == null) goto L19;
        if (r102.getFirst().isEmpty() == true) goto L19;
        r101 = (ImageRequest[]) r102.getFirst().toArray(new ImageRequest[0]);
    L19:
        ArrayList r103 = new ArrayList();
        Iterator<String> r104 = r100.iterator();
    L21:
        if (r104.hasNext() == false) goto L27;
        String r105 = r104.next();
        if (TextUtils.isEmpty(r105) == true) goto L21;
        r103.add(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r105)).build());
        goto L21
    L27:
        if (r103.size() == 0) goto L30;
        r101 = (ImageRequest[]) r103.toArray(new ImageRequest[r103.size()]);
        goto L32
    L41:
        return null;
    }

    @Override // yk2.d
    public final List<String> b() {
        return this.f152771a;
    }

    public e(List<String> r100) {
        this.f152771a = r100;
    }
}

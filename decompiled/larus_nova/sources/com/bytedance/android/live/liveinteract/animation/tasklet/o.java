package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Predicate;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class o<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f71232a;

    public o(n r100) {
        this.f71232a = r100;
    }

    @Override // com.facebook.common.internal.Predicate
    public final boolean apply(Object r100) {
        CacheKey r101 = (CacheKey) r100;
        ImageRequest r102 = this.f71232a.f71218h;
        if (r102 == null) goto L9;
        Uri r103 = r102.getSourceUri();
        if (r103 == null) goto L9;
        String r104 = r103.toString();
        if (r104 == null) goto L9;
        String r105 = String.valueOf(r104.hashCode());
    L10:
        String r106 = r105;
        if (r106 != null) goto L13;
    L18:
        return false;
    L13:
        if (TextUtils.isEmpty(r106) == true) goto L18;
        if (StringsKt.indexOf$default(r101.toString(), r106, 0, false, 6, null) == (-1)) goto L18;
        return true;
    L9:
        r105 = null;
        goto L10
    }
}

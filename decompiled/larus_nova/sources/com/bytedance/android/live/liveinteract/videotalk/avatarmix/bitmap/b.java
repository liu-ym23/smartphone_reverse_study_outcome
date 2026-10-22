package com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.liveinteract.videotalk.avatarmix.e;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f79073a;

    public b(String r100) {
        this.f79073a = r100;
    }

    @Override // com.facebook.common.internal.Predicate
    public final boolean apply(Object r100) {
        String r101 = ((CacheKey) r100).getUriString();
        String r102 = null;
        if (r101 == null) goto L7;
        String r103 = StringsKt.substringAfter$default(r101, "://", null, 2, null);
        if (r103 == null) goto L7;
        String r104 = StringsKt.substringAfter$default(r103, HTTP.URL_DEFAULT, null, 2, null);
    L8:
        String r105 = this.f79073a;
        if (r105.length() != 0) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L14;
        r105 = e.f79082a;
    L14:
        if (r105 == null) goto L19;
        String r107 = StringsKt.substringAfter$default(r105, "://", null, 2, null);
        if (r107 == null) goto L19;
        r102 = StringsKt.substringAfter$default(r107, HTTP.URL_DEFAULT, null, 2, null);
    L19:
        return Intrinsics.areEqual(r104, r102);
    L11:
        r106 = false;
    L7:
        r104 = null;
        goto L8
    }
}

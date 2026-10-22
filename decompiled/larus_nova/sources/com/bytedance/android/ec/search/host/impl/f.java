package com.bytedance.android.ec.search.host.impl;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.android.ec.model.ECUrlModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchFrescoService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements ITradeSearchFrescoService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f48173a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f48174b = null;

    public f() {
    }

    static {
        f48173a = new f();
        f48174b = LazyKt.lazy(new e());
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchFrescoService
    public final boolean isDownloaded(Uri r100) {
        ri.b r101 = (ri.b) f48174b.getValue();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.isDownloaded(r100) != true) goto L7;
        return true;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchFrescoService
    public final void bindImage(SimpleDraweeView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "draweeView");
        Intrinsics.checkNotNullParameter(r101, "url");
        ri.b r102 = (ri.b) f48174b.getValue();
        if (r102 == null) goto L6;
        r102.bindImage(r100, r101);
        return;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchFrescoService
    public final void loadBitmapSynchronized(String r100, int r101, int r102, Function1<? super Bitmap, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r103, "postRunnable");
        ECUrlModel r104 = new ECUrlModel();
        r104.setUrlList(CollectionsKt.mutableListOf(new String[]{r100}));
        ri.b r105 = (ri.b) f48174b.getValue();
        if (r105 == null) goto L6;
        r105.c(r104, r103);
        return;
    }
}

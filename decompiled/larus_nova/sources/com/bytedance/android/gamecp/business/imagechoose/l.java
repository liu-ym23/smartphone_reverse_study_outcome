package com.bytedance.android.gamecp.business.imagechoose;

import com.ss.android.lark.videosend.tools.VideoTools;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class l<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f56092a;

    public l(i r100) {
        this.f56092a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        i.b r101 = (i.b) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        i.a(this.f56092a, VideoTools.ERROR_TYPE_COMPRESS, r101);
        return r101;
    }
}

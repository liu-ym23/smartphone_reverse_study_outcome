package com.bytedance.android.livesdk.dslservice.slice;

import com.bytedance.android.livesdk.dslservice.util.o;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SliceDSLProcess$wrapInnerCallback$1 f122943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f122944b;

    public e(SliceDSLProcess$wrapInnerCallback$1 r100, String r101) {
        this.f122943a = r100;
        this.f122944b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        o.f123008f.i(((Long) r100).longValue(), this.f122943a.f122916a.f569037a, this.f122944b);
    }
}

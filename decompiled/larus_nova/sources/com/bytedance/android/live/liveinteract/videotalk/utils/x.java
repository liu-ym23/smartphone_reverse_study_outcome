package com.bytedance.android.live.liveinteract.videotalk.utils;

import android.graphics.Bitmap;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class x<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f79892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f79893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ILinkPlayerInfoBridge f79894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ti6.f f79895d;

    public x(z r100, Ref.ObjectRef r101, ILinkPlayerInfoBridge r102, ti6.f r103) {
        this.f79892a = r100;
        this.f79893b = r101;
        this.f79894c = r102;
        this.f79895d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        this.f79892a.f79903d.put((String) this.f79893b.element, r101);
        this.f79892a.c(this.f79894c, this.f79895d, (String) this.f79893b.element, r101, true);
    }
}

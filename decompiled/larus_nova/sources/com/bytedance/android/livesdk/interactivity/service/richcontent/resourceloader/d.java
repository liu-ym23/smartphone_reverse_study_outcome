package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ob2.c f140972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ hk6.b.a f140973b;

    public d(ob2.c r100, hk6.d r101) {
        this.f140972a = r100;
        this.f140973b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Drawable r102 = s1.m(this.f140972a.f522597b.intValue());
        if (r102 == null) goto L5;
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.a.f140958a.error("download failed,use defaultBitmap:" + this.f140972a.f522597b, null);
        this.f140973b.b(r102);
        return;
    L5:
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.a.f140958a.error("download failed,get defaultBitmap error", r101);
        this.f140973b.a(r101.getMessage(), r101);
    }
}

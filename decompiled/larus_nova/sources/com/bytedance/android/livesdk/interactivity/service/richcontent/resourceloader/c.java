package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveImageResourceLoader f140967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ek6.a f140968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ob2.c f140969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ek6.d f140970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ hk6.b.a f140971e;

    public c(LiveImageResourceLoader r100, ak6.f r101, ob2.c r102, ek6.d r103, hk6.d r104) {
        this.f140967a = r100;
        this.f140968b = r101;
        this.f140969c = r102;
        this.f140970d = r103;
        this.f140971e = r104;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = ((Bitmap) r100).copy(Bitmap.Config.ARGB_8888, false);
        if (r101 != null) goto L5;
        Drawable r102 = s1.m(this.f140969c.f522597b.intValue());
        if (r102 == null) goto L11;
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.a.f140958a.error("download success,use defaultBitmap:" + this.f140969c.f522597b, null);
        this.f140971e.b(r102);
        return;
    L11:
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.a.f140958a.error("download success,defaultBitmap error:" + this.f140969c.f522597b, null);
        hk6.b.a.C6158a.a(this.f140971e, "bitmap is null", null, 2);
        return;
    L5:
        if (com.bytedance.android.livesdk.interactivity.service.richcontent.config.c.a(this.f140968b) == false) goto L7;
        this.f140967a.c(r101, this.f140969c, this.f140970d);
    L7:
        this.f140971e.b(new BitmapDrawable(s1.getResources(), r101));
    }
}

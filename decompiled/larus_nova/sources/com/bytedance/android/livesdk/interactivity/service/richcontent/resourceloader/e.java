package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveImageResourceLoader f140974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ek6.a f140975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ob2.c f140976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ek6.d f140977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ hk6.b.a f140978e;

    public e(LiveImageResourceLoader r100, ak6.f r101, ob2.c r102, ek6.d r103, hk6.d r104) {
        this.f140974a = r100;
        this.f140975b = r101;
        this.f140976c = r102;
        this.f140977d = r103;
        this.f140978e = r104;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = ((Bitmap) r100).copy(Bitmap.Config.ARGB_8888, false);
        if (r101 != null) goto L5;
        hk6.b.a.C6158a.a(this.f140978e, "bitmap is null", null, 2);
        return;
    L5:
        if (com.bytedance.android.livesdk.interactivity.service.richcontent.config.c.a(this.f140975b) == false) goto L7;
        this.f140974a.c(r101, this.f140976c, this.f140977d);
    L7:
        this.f140978e.b(new BitmapDrawable(s1.getResources(), r101));
    }
}

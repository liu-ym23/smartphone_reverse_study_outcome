package com.bytedance.android.livesdk.chatroom.widget;

import android.content.DialogInterface;
import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f118782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Sticker f118783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Sticker f118784c;

    public e(g r100, Sticker r101, Sticker r102) {
        this.f118782a = r100;
        this.f118783b = r101;
        this.f118784c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f118782a.f118811g.invoke2(this.f118783b, this.f118784c);
        zg1.q r102 = this.f118782a.f118809e.f571893d;
        if (r102 == null) goto L5;
        zg1.q.a.a(r102, true);
    L5:
        r100.dismiss();
    }
}

package com.bytedance.android.live.profit.player;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import com.bytedance.android.livesdkapi.depend.live.player.MaskSrc;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EnterEffectProfilePreviewView f88322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ITextureViewPlayerController f88323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f88324c;

    public c(EnterEffectProfilePreviewView r100, ITextureViewPlayerController r101, String r102) {
        this.f88322a = r100;
        this.f88323b = r101;
        this.f88324c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        s r111 = (s) r110;
        List r100 = (List) r111.b();
        if (r100 != null) goto L9;
        StringBuilder r101 = new StringBuilder("MaskSrc list create failed: ");
        Throwable r112 = r111.a();
        if (r112 == null) goto L7;
        String r113 = r112.getMessage();
    L8:
        r101.append(r113);
        ALogger.w("EnterEffectProfilePreview", r101.toString());
        return;
    L7:
        r113 = null;
        goto L8
    L9:
        ITextureViewPlayerController r114 = this.f88323b;
        Iterator<T> r102 = r100.iterator();
    L11:
        if (r102.hasNext() == false) goto L13;
        r114.setMaskSrc((MaskSrc) r102.next());
        goto L11
    L13:
        this.f88323b.attachAlphaView(this.f88322a);
        ITextureViewPlayerController.DefaultImpls.start$default(this.f88323b, this.f88324c, true, false, false, null, 28, null);
    }
}

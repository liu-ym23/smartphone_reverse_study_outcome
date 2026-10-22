package com.bytedance.android.live.profit.player;

import android.content.Context;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes47.dex */
public interface d extends dy0.d {
    Class<? extends Widget> Hm();

    s<o> K(String r100);

    uu0.b Me();

    void Nc(a r100);

    e Qh();

    p f1();

    uu0.a hd(Context r100);

    Disposable lh(long r100, n r101);

    void no(uu0.b r100);

    void w1(IAssetsManager r100, long r101, int r102, Function2 r103);

    PublishSubject x1();
}

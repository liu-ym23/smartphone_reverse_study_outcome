package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class q0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveGiftMenuStickerServiceWidget f119161a;

    public q0(LiveGiftMenuStickerServiceWidget r100) {
        this.f119161a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        JSONObject r101 = (JSONObject) r100;
        if (this.f119161a.f118529h == false) goto L14;
        long r102 = System.currentTimeMillis();
        this.f119161a.f118527f.put(new JSONObject(r101.toString()));
        long r103 = r102 - this.f119161a.f118526e;
        SettingKey<Long> r104 = LiveEffectSettings.LIVE_EFFECT_GIFT_MENU_EVENT_FREQUENCY_CONTROL_TIME;
        if (r103 >= r104.getValue().longValue()) goto L10;
        this.f119161a.getClass();
        long r105 = r104.getValue().longValue();
        LiveGiftMenuStickerServiceWidget r106 = this.f119161a;
        long r107 = r105 - (r102 - r106.f118526e);
        if (r106.f118528g != null) goto L12;
        Disposable r108 = Observable.timer(r107, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new p0(this));
        RxUtilKt.c(r108, this.f119161a.f118522a);
        r106.f118528g = r108;
        return;
    L12:
        return;
    L10:
        LiveGiftMenuStickerServiceWidget.wq(this.f119161a);
        return;
    }
}

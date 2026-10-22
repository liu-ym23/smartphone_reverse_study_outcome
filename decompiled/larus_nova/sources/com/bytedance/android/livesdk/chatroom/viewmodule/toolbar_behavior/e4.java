package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.interfaces.DraweeController;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes8.dex */
public final class e4<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c4 f117130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ko0.e f117131b;

    public e4(c4 r100, ko0.e r101) {
        this.f117130a = r100;
        this.f117131b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.i(this.f117130a.f117101a, "small card anim end after timeout, stop anim");
        HSImageView r102 = this.f117130a.f117105e;
        if (r102 == null) goto L9;
        DraweeController r103 = r102.getController();
        if (r103 == null) goto L9;
        Animatable r104 = r103.getAnimatable();
        if (r104 == null) goto L9;
        r104.stop();
    L9:
        HSImageView r105 = this.f117130a.f117105e;
        if (r105 == null) goto L12;
        r105.setVisibility(8);
    L12:
        Function0<Unit> r106 = this.f117131b.f504366d;
        if (r106 == null) goto L16;
        Unit r107 = r106.invoke();
        return;
    }
}

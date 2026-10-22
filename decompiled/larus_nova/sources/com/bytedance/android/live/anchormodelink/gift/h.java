package com.bytedance.android.live.anchormodelink.gift;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes45.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f58651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f58652b;

    public h(Function2 r100, String r101) {
        this.f58651a = r100;
        this.f58652b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f58651a.invoke(Boolean.FALSE, null);
        ALogger.i("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#error:" + this.f58652b + ", " + ((Throwable) r100));
    }
}

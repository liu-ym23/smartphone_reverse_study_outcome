package com.bytedance.android.livesdk.widgetdescriptor.channel;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageChangeSource;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes11.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f162294a;

    public i(Function1 r100) {
        this.f162294a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.livesdk.interactivity.api.base.d r101 = (com.bytedance.android.livesdk.interactivity.api.base.d) r100;
        if (r101.f132906c == PublicScreenAreaPageChangeSource.Manual) goto L6;
        this.f162294a.invoke(r101);
        return;
    }
}

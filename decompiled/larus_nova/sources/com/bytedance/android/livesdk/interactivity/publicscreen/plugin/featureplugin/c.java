package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f139175a;

    public c(Function1 r100) {
        this.f139175a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IRoom r101 = (IRoom) sh6.c.b((sh6.b) r100);
        if (r101 == null) goto L7;
        this.f139175a.invoke(r101);
        return;
    }
}

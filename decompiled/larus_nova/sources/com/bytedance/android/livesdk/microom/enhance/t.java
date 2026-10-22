package com.bytedance.android.livesdk.microom.enhance;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes11.dex */
public final class t<T> implements h80.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f153887a;

    public t(Function1 r100) {
        this.f153887a = r100;
    }

    @Override // h80.a
    public final void accept(Object r100) {
        Function1 r101 = this.f153887a;
        r101.invoke((Room) r100);
    }
}

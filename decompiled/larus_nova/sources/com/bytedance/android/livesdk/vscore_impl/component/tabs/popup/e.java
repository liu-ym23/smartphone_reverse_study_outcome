package com.bytedance.android.livesdk.vscore_impl.component.tabs.popup;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f159997a;

    public e(Function1 r100) {
        this.f159997a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final /* synthetic */ void accept(Object r100) {
        this.f159997a.invoke(r100);
    }
}

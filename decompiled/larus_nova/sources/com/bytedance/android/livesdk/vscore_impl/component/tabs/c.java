package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import com.bytedance.android.livesdk.vscore_api.tab.MultiTabType;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes11.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseMatchNativeWidget f159945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MultiTabType f159946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f159947c;

    public c(BaseMatchNativeWidget r100, MultiTabType r101, Function1 r102) {
        this.f159945a = r100;
        this.f159946b = r101;
        this.f159947c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((xn1.a) r100).D(this.f159946b.getTabId(), this.f159946b.getTitle(), this.f159945a.contentView, this.f159947c);
    }
}

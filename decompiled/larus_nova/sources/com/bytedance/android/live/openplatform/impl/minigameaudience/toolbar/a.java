package com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CandyToolbarContextService f85339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f85340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f85341c;

    public a(CandyToolbarContextService r100, Function1 r101, Function0 r102) {
        this.f85339a = r100;
        this.f85340b = r101;
        this.f85341c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        List<fr0.b.a> r101 = ((fr0.b) ((Response) r100).data).a();
        if (r101 != null) goto L5;
    L10:
        this.f85340b.invoke("candy entrance error: entrance info list is null or empty.");
        return;
    L5:
        if ((!r101.isEmpty()) != true) goto L10;
        if (((fr0.b.a) ListProtector.get(r101, 0)).c() == false) goto L9;
        this.f85340b.invoke("candy disable entrance is true.");
        this.f85339a.f85312b = null;
        return;
    L9:
        this.f85339a.j((fr0.b.a) ListProtector.get(r101, 0), this.f85341c, false);
    }
}

package com.bytedance.android.shopping.card_list.monitor.fps;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class CardListYataFpsMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f171700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f171701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f171702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f171703d;

    public final void a(final RecyclerView r100) {
        CardListRunCatchExtKt.a(this.f171702c, "CardListYataFpsMonitor-start", new CardListYataFpsMonitor$start$1(this, r100));
    }

    public CardListYataFpsMonitor(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, "baseCategory");
        this.f171702c = r100;
        this.f171703d = r101;
        this.f171700a = LazyKt.lazy(CardListYataFpsMonitor$monitorScene$2.INSTANCE);
        this.f171701b = LazyKt.lazy(new CardListYataFpsMonitor$fpsTracker$2(this));
    }
}

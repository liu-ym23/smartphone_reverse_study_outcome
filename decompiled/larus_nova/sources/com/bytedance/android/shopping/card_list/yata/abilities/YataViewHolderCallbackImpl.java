package com.bytedance.android.shopping.card_list.yata.abilities;

import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.monitor.CardListYataMonitorManager;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class YataViewHolderCallbackImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f172054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f172055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f172056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CardListObjectContainer f172057d;

    public final CardListYataMonitorManager a() {
        return (CardListYataMonitorManager) this.f172056c.getValue();
    }

    public YataViewHolderCallbackImpl(CardListObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        this.f172057d = r100;
        CardPassThroughData r101 = r100.f171545e.f171309a;
        if (r101 == null) goto L5;
        String r102 = r101.getMonitorId();
    L6:
        this.f172054a = r102;
        this.f172055b = new AtomicBoolean(false);
        this.f172056c = LazyKt.lazy(new YataViewHolderCallbackImpl$monitorManager$2(this));
        return;
    L5:
        r102 = null;
        goto L6
    }
}

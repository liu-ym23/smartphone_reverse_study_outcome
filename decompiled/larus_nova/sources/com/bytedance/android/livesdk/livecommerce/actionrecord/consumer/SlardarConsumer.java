package com.bytedance.android.livesdk.livecommerce.actionrecord.consumer;

import com.bytedance.android.livesdk.livecommerce.actionrecord.event.EventType;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes10.dex */
public final class SlardarConsumer implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f147640a;

    @Override // com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a
    public final String a() {
        return "slardar";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a
    public final Set<EventType> b() {
        return SetsKt.setOf(EventType.RATE_FAILURE);
    }

    public SlardarConsumer(Map<String, String> r100) {
        this.f147640a = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a
    public final boolean c(vg2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new SlardarConsumer$receive$1(this, r100, null), 2, null);
        return true;
    }
}

package com.obric.capabilitykit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.logger.Logger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/capabilitykit/EntityProvider$deviceUnlockedReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityProvider$deviceUnlockedReceiver$1 extends BroadcastReceiver {
    public EntityProvider$deviceUnlockedReceiver$1() {
    }

    public static /* synthetic */ void a() {
        b();
    }

    public static final void b() {
        EntityProvider.access$checkIfFirstRunOrDataClean(EntityProvider.INSTANCE);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        Logger.INSTANCE.d(EntityProvider.TAG, "user unlocked");
        IndexTaskManager.INSTANCE.postTask("checkIfFirstRunOrDataClean", new cb.m());
    }
}

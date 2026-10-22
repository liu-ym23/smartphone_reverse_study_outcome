package com.bytedanceos.appstore.buss.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedanceos.appstore.buss.viewmodels.cache.CacheMyAppsRepository;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedanceos/appstore/buss/receiver/PackageBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", MemorySourceLinkType.INTENT, "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "(Landroid/content/Context;)V", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PackageBroadcastReceiver extends BroadcastReceiver {
    public PackageBroadcastReceiver() {
    }

    public final void a(Context r10) {
        CacheMyAppsRepository.o(CacheMyAppsRepository.f8997f.a(), false, 1, null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        a(r10);
    }
}

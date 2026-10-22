package com.obric.matrix.platform.sdk.ones.commonparams;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/obric/matrix/platform/sdk/ones/commonparams/CommonParamUtil$getDeviceBatteryPercent$batteryReceiver$1", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", MemorySourceLinkType.INTENT, "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CommonParamUtil$getDeviceBatteryPercent$batteryReceiver$1 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref$IntRef f11887a;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        q.g(r10, "context");
        q.g(r11, MemorySourceLinkType.INTENT);
        this.f11887a.element = (int) ((r11.getIntExtra("level", -1) / r11.getIntExtra("scale", -1)) * 100);
        r10.unregisterReceiver(this);
    }
}

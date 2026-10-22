package com.bytedance.safetyguard.lxc.internal.service;

import android.os.ParcelFileDescriptor;
import com.bytedance.safetyguard.lxc.api.OutboundPolicyEvaluator;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxyServiceConfigParcel;

/* JADX INFO: compiled from: ServiceProxySession.kt */
/* JADX INFO: loaded from: classes.dex */
public interface ad {
    ac create(ParcelFileDescriptor r1, ProxyServiceConfigParcel r2, OutboundPolicyEvaluator r3, com.bytedance.safetyguard.lxc.internal.d.a r4, af r5);
}

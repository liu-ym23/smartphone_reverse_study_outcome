package com.obric.aiagent.product.platform.api.device;

/* JADX INFO: compiled from: IObricDeviceIdleController.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IObricDeviceIdleController {
    boolean addToTemporaryAllowList(String[] r1, long r2, String r4);

    boolean removeFromTemporaryAllowList(String[] r1, String r2);
}

package com.obric.aiagent.executionengine.capabilitymanager.api.publish;

import d.c.d;
import d.x;

/* JADX INFO: compiled from: IIntentInfoManagerApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IIntentInfoManagerApi {
    void init();

    Object queryIntentInfo(String r1, d<? super a> r2);

    Object scanIntentsForAllPackage(d<? super x> r1);
}

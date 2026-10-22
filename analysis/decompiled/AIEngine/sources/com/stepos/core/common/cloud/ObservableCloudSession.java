package com.stepos.core.common.cloud;

import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface ObservableCloudSession {
    CloudSessionCorrelationState correlationState();

    l<CloudSessionCorrelationState, n> getOnCorrelationEstablished();

    boolean isConnected();

    void setOnCorrelationEstablished(l<? super CloudSessionCorrelationState, n> lVar);
}

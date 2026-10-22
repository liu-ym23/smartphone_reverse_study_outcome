package com.stepos.core.ota.data;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class IAlgorithmState {
    public static final int CHECK_UPDATE_FAIL = -1;
    public static final int CHECK_UPDATE_LOCAL_UPDATABLE = 1;
    public static final int CHECK_UPDATE_NO_UPDATE = 0;
    public static final int CHECK_UPDATE_REMOTE_UPDATABLE = 2;
    public static final IAlgorithmState INSTANCE = new IAlgorithmState();

    private IAlgorithmState() {
    }
}

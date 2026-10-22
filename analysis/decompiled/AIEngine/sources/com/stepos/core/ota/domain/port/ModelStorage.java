package com.stepos.core.ota.domain.port;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface ModelStorage {
    String bucketDir(String str);

    void deleteDir(String str);

    int installedVersion(String str);

    long payloadBytes(String str);

    /* renamed from: promoteAtomically-gIAlu-s */
    Object mo112promoteAtomicallygIAlus(String str, String str2);

    void setInstalledVersion(String str, int i10);

    void setPluginVersion(String str, String str2, int i10);
}

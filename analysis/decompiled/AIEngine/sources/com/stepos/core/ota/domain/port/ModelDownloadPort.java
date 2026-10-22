package com.stepos.core.ota.domain.port;

import kotlin.Result;
import kotlin.jvm.internal.g;
import lb.n;
import qb.b;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface ModelDownloadPort {
    void cancel(String str);

    void discardEngineRecord(String str);

    /* renamed from: download-0E7RQCE */
    Object mo110download0E7RQCE(DownloadSpec downloadSpec, p<? super Long, ? super Long, n> pVar, b<? super Result<String>> bVar);

    String findResumeFile(String str, String str2);

    Long queryPartialDownloadedBytes(String str, String str2);

    void setRate(long j10);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static void discardEngineRecord(ModelDownloadPort modelDownloadPort, String otaId) {
            g.f(otaId, "otaId");
        }

        public static String findResumeFile(ModelDownloadPort modelDownloadPort, String otaId, String defaultFilePath) {
            g.f(otaId, "otaId");
            g.f(defaultFilePath, "defaultFilePath");
            return defaultFilePath;
        }

        public static Long queryPartialDownloadedBytes(ModelDownloadPort modelDownloadPort, String otaId, String targetFilePath) {
            g.f(otaId, "otaId");
            g.f(targetFilePath, "targetFilePath");
            return null;
        }

        public static void setRate(ModelDownloadPort modelDownloadPort, long j10) {
        }
    }
}

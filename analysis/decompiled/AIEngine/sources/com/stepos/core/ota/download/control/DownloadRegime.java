package com.stepos.core.ota.download.control;

import sb.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DownloadRegime {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ DownloadRegime[] $VALUES;
    public static final DownloadRegime FULL = new DownloadRegime("FULL", 0);
    public static final DownloadRegime THROTTLED = new DownloadRegime("THROTTLED", 1);
    public static final DownloadRegime SUSPENDED = new DownloadRegime("SUSPENDED", 2);
    public static final DownloadRegime ABORTED = new DownloadRegime("ABORTED", 3);

    private static final /* synthetic */ DownloadRegime[] $values() {
        return new DownloadRegime[]{FULL, THROTTLED, SUSPENDED, ABORTED};
    }

    static {
        DownloadRegime[] downloadRegimeArr$values = $values();
        $VALUES = downloadRegimeArr$values;
        $ENTRIES = kotlin.enums.a.a(downloadRegimeArr$values);
    }

    private DownloadRegime(String str, int i10) {
    }

    public static a<DownloadRegime> getEntries() {
        return $ENTRIES;
    }

    public static DownloadRegime valueOf(String str) {
        return (DownloadRegime) Enum.valueOf(DownloadRegime.class, str);
    }

    public static DownloadRegime[] values() {
        return (DownloadRegime[]) $VALUES.clone();
    }
}

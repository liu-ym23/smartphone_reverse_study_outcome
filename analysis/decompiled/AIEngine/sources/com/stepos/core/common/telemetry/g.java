package com.stepos.core.common.telemetry;

import java.io.File;
import java.io.FileFilter;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return ShellTempSampler.readCelsius$lambda$1(file);
    }
}

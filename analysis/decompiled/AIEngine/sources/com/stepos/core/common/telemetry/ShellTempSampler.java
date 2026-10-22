package com.stepos.core.common.telemetry;

import com.stepos.core.ability.speech.TtsCloudConfig;
import com.stepos.core.common.utils.SysfsReader;
import com.tonyodev.fetch2core.server.FileResponse;
import gc.o;
import gc.q;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ShellTempSampler {
    private static final String FAST_PATH_EXPECTED_TYPE = "shell_temp_back";
    private static final String FAST_PATH_TEMP = "/sys/class/thermal/thermal_zone59/temp";
    private static final String FAST_PATH_TYPE = "/sys/class/thermal/thermal_zone59/type";
    private static final String FAST_PATH_ZONE = "/sys/class/thermal/thermal_zone59";
    private static volatile String cachedTempPath;
    private static volatile boolean probedAll;
    public static final ShellTempSampler INSTANCE = new ShellTempSampler();
    private static final List<String> HINTS_BY_PRIORITY = m.b0("back", "shell", "skin", "case", "quiet");

    private ShellTempSampler() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean readCelsius$lambda$1(File file) {
        if (file.isDirectory()) {
            String name = file.getName();
            kotlin.jvm.internal.g.e(name, "getName(...)");
            if (o.k0(name, "thermal_zone", false)) {
                return true;
            }
        }
        return false;
    }

    private final float tryReadCelsius(String str) {
        float f8;
        float f9;
        Long l10 = SysfsReader.INSTANCE.readLong(str);
        if (l10 == null) {
            return -1.0f;
        }
        long jLongValue = l10.longValue();
        if (jLongValue <= 0) {
            return -1.0f;
        }
        if (jLongValue > TtsCloudConfig.DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS) {
            f8 = jLongValue;
            f9 = 1000.0f;
        } else if (jLongValue > 1000) {
            f8 = jLongValue;
            f9 = 100.0f;
        } else {
            if (jLongValue <= 100) {
                return jLongValue;
            }
            f8 = jLongValue;
            f9 = 10.0f;
        }
        return f8 / f9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float readCelsius() {
        String lowerCase;
        String str = cachedTempPath;
        if (str != null) {
            return INSTANCE.tryReadCelsius(str);
        }
        if (probedAll) {
            return -1.0f;
        }
        if (kotlin.jvm.internal.g.b(SysfsReader.INSTANCE.readFirstLine(FAST_PATH_TYPE), FAST_PATH_EXPECTED_TYPE)) {
            float fTryReadCelsius = tryReadCelsius(FAST_PATH_TEMP);
            if (fTryReadCelsius > 0.0f) {
                cachedTempPath = FAST_PATH_TEMP;
                return fTryReadCelsius;
            }
        }
        File file = new File("/sys/class/thermal");
        if (!file.isDirectory()) {
            probedAll = true;
            return -1.0f;
        }
        File[] fileArrListFiles = file.listFiles(new g());
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : fileArrListFiles) {
            SysfsReader sysfsReader = SysfsReader.INSTANCE;
            String path = new File(file2, FileResponse.FIELD_TYPE).getPath();
            kotlin.jvm.internal.g.e(path, "getPath(...)");
            String firstLine = sysfsReader.readFirstLine(path);
            Pair pair = null;
            if (firstLine != null) {
                lowerCase = firstLine.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.g.e(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null && lowerCase.length() != 0) {
                pair = new Pair(lowerCase, new File(file2, "temp").getPath());
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        for (String str2 : HINTS_BY_PRIORITY) {
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                Pair pair2 = (Pair) obj;
                String str3 = (String) pair2.f9985a;
                String str4 = (String) pair2.f9986b;
                if (q.l0(str3, str2, false)) {
                    kotlin.jvm.internal.g.c(str4);
                    float fTryReadCelsius2 = tryReadCelsius(str4);
                    if (fTryReadCelsius2 > 0.0f) {
                        cachedTempPath = str4;
                        return fTryReadCelsius2;
                    }
                }
            }
        }
        probedAll = true;
        return -1.0f;
    }
}

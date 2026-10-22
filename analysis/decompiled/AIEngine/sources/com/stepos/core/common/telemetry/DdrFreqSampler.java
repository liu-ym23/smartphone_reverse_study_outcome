package com.stepos.core.common.telemetry;

import com.stepos.core.ability.speech.PcmDumpBudget;
import gc.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import kotlin.Result;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DdrFreqSampler {
    public static final DdrFreqSampler INSTANCE = new DdrFreqSampler();
    private static final List<String> PATHS = m.b0("/sys/class/devfreq/soc:qcom,cpu-llcc-ddr-bw/cur_freq", "/sys/class/devfreq/17000000.cpubw/cur_freq", "/sys/class/devfreq/ddrfreq/cur_freq", "/sys/kernel/debug/clk/ddrclk/clk_rate");
    private static volatile String cachedPath;
    private static volatile boolean probedAll;

    private DdrFreqSampler() {
    }

    private final int tryRead(String str) {
        Object objA;
        String string;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(str)), gc.a.f9106b), PcmDumpBudget.HARD_MAX_DIR_MB);
            try {
                String line = bufferedReader.readLine();
                int i10 = (line == null || (string = q.L0(line).toString()) == null) ? -1 : Integer.parseInt(string);
                bufferedReader.close();
                objA = Integer.valueOf(i10);
            } finally {
            }
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = -1;
        }
        return ((Number) objA).intValue();
    }

    public final int readKhz() {
        String str = cachedPath;
        if (str != null) {
            return INSTANCE.tryRead(str);
        }
        if (probedAll) {
            return -1;
        }
        for (String str2 : PATHS) {
            int iTryRead = tryRead(str2);
            if (iTryRead > 0) {
                cachedPath = str2;
                return iTryRead;
            }
        }
        probedAll = true;
        return -1;
    }
}

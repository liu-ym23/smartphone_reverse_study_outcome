package com.stepos.core.common.telemetry;

import com.stepos.core.ability.speech.PcmDumpBudget;
import gc.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import kotlin.Result;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class McccClkSampler {
    public static final McccClkSampler INSTANCE = new McccClkSampler();
    private static final String PATH = "/sys/kernel/debug/clk/measure_only_mccc_clk/clk_measure";
    private static volatile boolean probeFailed;

    private McccClkSampler() {
    }

    public final int readKhz() {
        Object objA;
        int i10;
        String string;
        if (probeFailed) {
            return -1;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(PATH)), gc.a.f9106b), PcmDumpBudget.HARD_MAX_DIR_MB);
            try {
                String line = bufferedReader.readLine();
                long j10 = (line == null || (string = q.L0(line).toString()) == null) ? -1L : Long.parseLong(string);
                bufferedReader.close();
                if (j10 <= 0) {
                    probeFailed = true;
                    i10 = -1;
                } else {
                    i10 = (int) (j10 / 1000);
                }
                objA = Integer.valueOf(i10);
            } finally {
            }
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (Result.b(objA) != null) {
            probeFailed = true;
            objA = -1;
        }
        return ((Number) objA).intValue();
    }
}

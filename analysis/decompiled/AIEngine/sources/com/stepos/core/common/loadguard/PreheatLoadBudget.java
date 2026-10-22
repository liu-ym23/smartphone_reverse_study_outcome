package com.stepos.core.common.loadguard;

import ai.onnxruntime.a;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import gc.n;
import gc.o;
import gc.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import wb.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PreheatLoadBudget {
    public static final long DEFAULT_BUDGET_MS = 500;
    public static final double MEM_AVAILABLE_LOW_RATIO = 0.01d;
    private static final String TAG = "PreheatLoadBudget";
    public static final PreheatLoadBudget INSTANCE = new PreheatLoadBudget();
    private static final ConcurrentHashMap<String, Long> budgets = new ConcurrentHashMap<>();

    private PreheatLoadBudget() {
    }

    public static final void arm(String modelId, long j10) {
        g.f(modelId, "modelId");
        budgets.put(modelId, Long.valueOf(j10));
    }

    public static /* synthetic */ void arm$default(String str, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 500;
        }
        arm(str, j10);
    }

    public static final void checkOrAbort(String modelId, long j10, String phase) {
        String str;
        g.f(modelId, "modelId");
        g.f(phase, "phase");
        Long l10 = budgets.get(modelId);
        if (l10 != null) {
            long jLongValue = l10.longValue();
            if (j10 <= jLongValue) {
                return;
            }
            Double memAvailableRatio = readMemAvailableRatio();
            if (memAvailableRatio != null && memAvailableRatio.doubleValue() >= 0.01d) {
                LogModule logModule = LogModule.MODEL;
                String str2 = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(memAvailableRatio.doubleValue() * 100)}, 1));
                StringBuilder sbS = a.s("preheat slow but memory healthy: model=", modelId, " ", phase, "=");
                sbS.append(j10);
                a0.a.s(jLongValue, "ms > budget=", "ms, memAvailable=", sbS);
                sbS.append(str2);
                sbS.append("% (boot cold IO, continue preheat)");
                AIEngineLogger.w(logModule, TAG, sbS.toString());
                return;
            }
            LogModule logModule2 = LogModule.MODEL;
            if (memAvailableRatio != null) {
                str = String.format("%.1f%%", Arrays.copyOf(new Object[]{Double.valueOf(100 * memAvailableRatio.doubleValue())}, 1));
            } else {
                str = "n/a";
            }
            StringBuilder sbS2 = a.s("preheat abort: model=", modelId, " ", phase, "=");
            sbS2.append(j10);
            a0.a.s(jLongValue, "ms > budget=", "ms, memAvailable=", sbS2);
            sbS2.append(str);
            sbS2.append(" (memory-storm precursor, abandoning preheat before touching DSP)");
            AIEngineLogger.w(logModule2, TAG, sbS2.toString());
            StringBuilder sbS3 = a.s("preheat load over budget: model=", modelId, " ", phase, "=");
            sbS3.append(j10);
            throw new PreheatAbortedException(a0.a.d(jLongValue, "ms > budget=", "ms", sbS3));
        }
    }

    public static final void disarm(String modelId) {
        g.f(modelId, "modelId");
        budgets.remove(modelId);
    }

    private final long parseKb(String str) {
        g.f(str, "<this>");
        int iQ0 = q.q0(str, ':', 0, 6);
        if (iQ0 != -1) {
            str = str.substring(iQ0 + 1, str.length());
            g.e(str, "substring(...)");
        }
        Long lD0 = n.d0(q.J0(q.L0(str).toString(), ' '));
        if (lD0 != null) {
            return lD0.longValue();
        }
        return -1L;
    }

    public static final Double readMemAvailableRatio() {
        Object objA;
        PreheatLoadBudget preheatLoadBudget = INSTANCE;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/proc/meminfo")), gc.a.f9106b), PcmDumpBudget.HARD_MAX_DIR_MB);
            try {
                Iterator it = new fc.a(new e(bufferedReader)).iterator();
                long kb = -1;
                long kb2 = -1;
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (o.k0(str, "MemTotal:", false)) {
                        kb2 = preheatLoadBudget.parseKb(str);
                    } else if (o.k0(str, "MemAvailable:", false)) {
                        kb = preheatLoadBudget.parseKb(str);
                    }
                    if (kb2 > 0 && kb >= 0) {
                        break;
                    }
                }
                lb.n nVar = lb.n.f10413a;
                bufferedReader.close();
                objA = (kb2 <= 0 || kb < 0) ? null : Double.valueOf(kb / kb2);
            } finally {
            }
        } catch (Throwable th) {
            objA = c.a(th);
        }
        return (Double) (objA instanceof Result.Failure ? null : objA);
    }
}

package com.stepos.backend.qnn.dump;

import com.stepos.backend.qnn.ComputeBucket;
import com.stepos.backend.qnn.QnnNative;
import com.stepos.core.common.log.BaseDumpProvider;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.d;
import java.io.PrintWriter;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.c;
import kotlin.collections.a;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class QnnDumpProvider extends BaseDumpProvider {
    public QnnDumpProvider() {
        super("Qnn", LogModule.MODEL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence dumpStats$lambda$3(Map.Entry entry) {
        g.f(entry, "<destruct>");
        ComputeBucket computeBucket = (ComputeBucket) entry.getKey();
        Pair pair = (Pair) entry.getValue();
        return computeBucket + "=" + pair.f9985a + "/" + pair.f9986b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.stepos.core.common.log.BaseDumpProvider
    public void dumpContent(PrintWriter writer, String[] args) {
        Object objA;
        g.f(writer, "writer");
        g.f(args, "args");
        try {
            objA = QnnNative.INSTANCE.bucketPermits();
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        Map map = (Map) objA;
        if (map == null || map.isEmpty()) {
            writer.println("  DSP permits: (QnnNative 未初始化 / 不可用)");
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            ComputeBucket computeBucket = (ComputeBucket) entry.getKey();
            Pair pair = (Pair) entry.getValue();
            int iIntValue = ((Number) pair.f9985a).intValue();
            int iIntValue2 = ((Number) pair.f9986b).intValue();
            writer.println("  DSP bucket=" + computeBucket + ": available=" + iIntValue + " / max=" + iIntValue2 + (iIntValue >= iIntValue2 ? "  ✓ 全部释放（无 in-flight 推理占用）" : d.e(iIntValue2 - iIntValue, "  ⚠ ", iIntValue2, " 个 permit 被占用中（崩溃后若不回 ", " = NPU 锁泄漏，§8.2）")));
        }
    }

    @Override // com.stepos.core.common.log.BaseDumpProvider, com.stepos.core.common.log.IDumpProvider
    public void dumpStats(PrintWriter writer) {
        Object objA;
        g.f(writer, "writer");
        try {
            objA = QnnNative.INSTANCE.bucketPermits();
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        Map map = (Map) objA;
        if (map == null || map.isEmpty()) {
            writer.println("Qnn: DSP permits unavailable");
        } else {
            d.r("Qnn: DSP permit available/max by bucket: ", a.z0(map.entrySet(), ", ", null, null, new o6.a(0), 30), writer);
        }
    }

    @Override // com.stepos.core.common.log.BaseDumpProvider, com.stepos.core.common.log.IDumpProvider
    public String getHelp() {
        return "Qnn: DSP/NPU 推理信号量 permit 占用（按计算单元桶；崩溃后锁释放验证，§8.2；available 应回到 max）";
    }
}

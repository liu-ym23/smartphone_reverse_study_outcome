package com.stepos.core.common.loadguard;

import a0.a;
import android.os.Process;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.tencent.mmkv.MMKV;
import gc.o;
import gc.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.b;
import kotlin.c;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import lb.d;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LoadJournal {
    private static final String KEY_PREFIX = "load_journal_";
    private static final String MMKV_ID = "aiengine_load_journal";
    private static final String TAG = "LoadJournal";
    public static final LoadJournal INSTANCE = new LoadJournal();
    private static final d kv$delegate = b.b(new com.stepos.cpuset.b(14));

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DeadLoad {
        private final String modelId;
        private final String phase;
        private final int pid;
        private final long wallMs;

        public DeadLoad(String modelId, String phase, long j10, int i10) {
            g.f(modelId, "modelId");
            g.f(phase, "phase");
            this.modelId = modelId;
            this.phase = phase;
            this.wallMs = j10;
            this.pid = i10;
        }

        public static /* synthetic */ DeadLoad copy$default(DeadLoad deadLoad, String str, String str2, long j10, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = deadLoad.modelId;
            }
            if ((i11 & 2) != 0) {
                str2 = deadLoad.phase;
            }
            if ((i11 & 4) != 0) {
                j10 = deadLoad.wallMs;
            }
            if ((i11 & 8) != 0) {
                i10 = deadLoad.pid;
            }
            int i12 = i10;
            return deadLoad.copy(str, str2, j10, i12);
        }

        public final String component1() {
            return this.modelId;
        }

        public final String component2() {
            return this.phase;
        }

        public final long component3() {
            return this.wallMs;
        }

        public final int component4() {
            return this.pid;
        }

        public final DeadLoad copy(String modelId, String phase, long j10, int i10) {
            g.f(modelId, "modelId");
            g.f(phase, "phase");
            return new DeadLoad(modelId, phase, j10, i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DeadLoad)) {
                return false;
            }
            DeadLoad deadLoad = (DeadLoad) obj;
            return g.b(this.modelId, deadLoad.modelId) && g.b(this.phase, deadLoad.phase) && this.wallMs == deadLoad.wallMs && this.pid == deadLoad.pid;
        }

        public final String getModelId() {
            return this.modelId;
        }

        public final String getPhase() {
            return this.phase;
        }

        public final int getPid() {
            return this.pid;
        }

        public final long getWallMs() {
            return this.wallMs;
        }

        public int hashCode() {
            return Integer.hashCode(this.pid) + a.c(v1.d.a(this.modelId.hashCode() * 31, 31, this.phase), this.wallMs, 31);
        }

        public String toString() {
            String str = this.modelId;
            String str2 = this.phase;
            long j10 = this.wallMs;
            int i10 = this.pid;
            StringBuilder sbS = ai.onnxruntime.a.s("DeadLoad(modelId=", str, ", phase=", str2, ", wallMs=");
            sbS.append(j10);
            sbS.append(", pid=");
            sbS.append(i10);
            sbS.append(")");
            return sbS.toString();
        }
    }

    private LoadJournal() {
    }

    public static final void begin(String modelId, String phase) {
        Object objA;
        g.f(modelId, "modelId");
        g.f(phase, "phase");
        MMKV kv = INSTANCE.getKv();
        if (kv == null) {
            return;
        }
        try {
            kv.putString(KEY_PREFIX.concat(modelId), phase + "|" + System.currentTimeMillis() + "|" + Process.myPid());
            kv.r();
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            LogModule logModule = LogModule.MODEL;
            StringBuilder sbS = ai.onnxruntime.a.s("begin(", modelId, ",", phase, ") write failed: ");
            sbS.append(thB);
            AIEngineLogger.w(logModule, TAG, sbS.toString());
        }
    }

    public static final void clearDead(String modelId) {
        Object objA;
        g.f(modelId, "modelId");
        MMKV kv = INSTANCE.getKv();
        if (kv == null) {
            return;
        }
        try {
            kv.p(KEY_PREFIX.concat(modelId));
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.MODEL, TAG, "clearDead(" + modelId + ") failed: " + thB);
        }
    }

    public static final void complete(String modelId) {
        Object objA;
        g.f(modelId, "modelId");
        MMKV kv = INSTANCE.getKv();
        if (kv == null) {
            return;
        }
        try {
            kv.p(KEY_PREFIX.concat(modelId));
            kv.r();
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.MODEL, TAG, "complete(" + modelId + ") failed: " + thB);
        }
    }

    private final MMKV getKv() {
        return (MMKV) kv$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV kv_delegate$lambda$2() {
        Object objA;
        try {
            objA = MMKV.o(MMKV_ID);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.MODEL, TAG, "MMKV unavailable, journal disabled: " + thB);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        return (MMKV) objA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.Result$Failure] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.util.ArrayList] */
    public static final List<DeadLoad> peekDead() {
        Object objA;
        Integer numC0;
        int iIntValue;
        MMKV kv = INSTANCE.getKv();
        if (kv == null) {
            return EmptyList.f10001a;
        }
        try {
            int iMyPid = Process.myPid();
            String[] strArrA = kv.a();
            if (strArrA == null) {
                strArrA = new String[0];
            }
            ArrayList arrayList = new ArrayList();
            for (String str : strArrA) {
                g.c(str);
                if (o.k0(str, KEY_PREFIX, false)) {
                    arrayList.add(str);
                }
            }
            objA = new ArrayList();
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                String str2 = (String) obj;
                String strG = kv.g(str2);
                DeadLoad deadLoad = null;
                if (strG != null) {
                    List listE0 = q.E0(strG, new char[]{'|'});
                    if (listE0.size() == 3 && (numC0 = gc.n.c0((String) listE0.get(2))) != null && (iIntValue = numC0.intValue()) != iMyPid) {
                        g.c(str2);
                        String strZ0 = q.z0(str2, KEY_PREFIX);
                        String str3 = (String) listE0.get(0);
                        Long lD0 = gc.n.d0((String) listE0.get(1));
                        deadLoad = new DeadLoad(strZ0, str3, lD0 != null ? lD0.longValue() : 0L, iIntValue);
                    }
                }
                if (deadLoad != null) {
                    objA.add(deadLoad);
                }
            }
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        EmptyList emptyList = objA;
        if (thB != null) {
            AIEngineLogger.w(LogModule.MODEL, TAG, "peekDead failed: " + thB);
            emptyList = EmptyList.f10001a;
        }
        return emptyList;
    }
}

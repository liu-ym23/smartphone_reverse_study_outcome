package com.stepos.core.ota.push;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.tencent.mmkv.MMKV;
import gc.o;
import gc.q;
import h0.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.b;
import kotlin.c;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import lb.d;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PendingAutoUpdateStore {
    private static final String KEY_LAST_SILENT_REQUEST = "__last_silent_request_wall_ms";
    private static final String MMKV_ID = "ota_pending_auto_update";
    private static final String PREFIX = "pau_";
    private static final String TAG = "PendingAutoUpdateStore";
    public static final PendingAutoUpdateStore INSTANCE = new PendingAutoUpdateStore();
    private static final d kv$delegate = b.b(new a9.b(25));

    private PendingAutoUpdateStore() {
    }

    private final String dataKey(String str) {
        return ai.onnxruntime.a.k(PREFIX, str);
    }

    private final MMKV getKv() {
        return (MMKV) kv$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV kv_delegate$lambda$0() {
        return MMKV.o(MMKV_ID);
    }

    public final List<Record> all() {
        String[] strArrA = getKv().a();
        if (strArrA == null) {
            return EmptyList.f10001a;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (String str : strArrA) {
            g.c(str);
            if (o.k0(str, PREFIX, false)) {
                arrayList.add(str);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            String str2 = (String) obj;
            PendingAutoUpdateStore pendingAutoUpdateStore = INSTANCE;
            g.c(str2);
            Record record = pendingAutoUpdateStore.get(q.z0(str2, PREFIX));
            if (record != null) {
                arrayList2.add(record);
            }
        }
        return arrayList2;
    }

    public final void clearAll() {
        getKv().clearAll();
        AIEngineLogger.i(LogModule.OTA, TAG, "pending cleared all");
    }

    public final String dump() {
        List<Record> listAll = all();
        if (listAll.isEmpty()) {
            return "pending: <empty>";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("pending(" + listAll.size() + "):");
        sb2.append('\n');
        for (Record record : listAll) {
            String otaId = record.getOtaId();
            int versionCode = record.getVersionCode();
            boolean forceUpdate = record.getForceUpdate();
            boolean zIsNewDownload = record.isNewDownload();
            long j10 = 1024;
            long sizeBytes = (record.getSizeBytes() / j10) / j10;
            String taskId = record.getTaskId();
            StringBuilder sbF = e.f("  - ", otaId, " v", versionCode, " force=");
            sbF.append(forceUpdate);
            sbF.append(" newDownload=");
            sbF.append(zIsNewDownload);
            sbF.append(" size=");
            sbF.append(sizeBytes);
            sbF.append("MB task=");
            sbF.append(taskId);
            sb2.append(sbF.toString());
            sb2.append('\n');
        }
        sb2.append("lastSilentRequestWallMs=" + INSTANCE.lastSilentRequestWallMs());
        return sb2.toString();
    }

    public final List<Record> force() {
        List<Record> listAll = all();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listAll) {
            if (((Record) obj).getForceUpdate()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final Record get(String otaId) {
        Object objA;
        g.f(otaId, "otaId");
        String strG = getKv().g(dataKey(otaId));
        if (strG != null) {
            try {
                objA = new JSONObject(strG);
            } catch (Throwable th) {
                objA = c.a(th);
            }
            if (objA instanceof Result.Failure) {
                objA = null;
            }
            JSONObject jSONObject = (JSONObject) objA;
            if (jSONObject != null) {
                int iOptInt = jSONObject.optInt("versionCode", 0);
                boolean zOptBoolean = jSONObject.optBoolean("forceUpdate", false);
                long jOptLong = jSONObject.optLong("sizeBytes", 0L);
                String strOptString = jSONObject.optString("taskId");
                g.c(strOptString);
                return new Record(otaId, iOptInt, zOptBoolean, jOptLong, !q.t0(strOptString) ? strOptString : null, jSONObject.optLong("recordedAtWallMs", 0L), jSONObject.optBoolean("isNewDownload", false));
            }
        }
        return null;
    }

    public final boolean hasNewDownloadPending() {
        List<Record> listAll = all();
        if (listAll != null && listAll.isEmpty()) {
            return false;
        }
        Iterator<T> it = listAll.iterator();
        while (it.hasNext()) {
            if (((Record) it.next()).isNewDownload()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isEmpty() {
        return all().isEmpty();
    }

    public final long lastSilentRequestWallMs() {
        return getKv().f(0L, KEY_LAST_SILENT_REQUEST);
    }

    public final void markSilentRequested(long j10) {
        getKv().j(j10, KEY_LAST_SILENT_REQUEST);
    }

    public final void put(Record record) {
        g.f(record, "record");
        JSONObject jSONObjectPut = new JSONObject().put("versionCode", record.getVersionCode()).put("forceUpdate", record.getForceUpdate()).put("sizeBytes", record.getSizeBytes());
        String taskId = record.getTaskId();
        if (taskId == null) {
            taskId = "";
        }
        getKv().l(dataKey(record.getOtaId()), jSONObjectPut.put("taskId", taskId).put("recordedAtWallMs", record.getRecordedAtWallMs()).put("isNewDownload", record.isNewDownload()).toString());
        LogModule logModule = LogModule.OTA;
        String otaId = record.getOtaId();
        int versionCode = record.getVersionCode();
        boolean forceUpdate = record.getForceUpdate();
        boolean zIsNewDownload = record.isNewDownload();
        long j10 = 1024;
        long sizeBytes = (record.getSizeBytes() / j10) / j10;
        StringBuilder sbF = e.f("pending put: otaId=", otaId, " v", versionCode, " force=");
        sbF.append(forceUpdate);
        sbF.append(" newDownload=");
        sbF.append(zIsNewDownload);
        sbF.append(" size=");
        AIEngineLogger.i(logModule, TAG, ai.onnxruntime.a.m(sbF, sizeBytes, "MB"));
    }

    public final void remove(String otaId) {
        g.f(otaId, "otaId");
        if (getKv().c(dataKey(otaId))) {
            getKv().p(dataKey(otaId));
            AIEngineLogger.i(LogModule.OTA, TAG, "pending removed: otaId=".concat(otaId));
        }
    }

    public final List<Record> silent() {
        List<Record> listAll = all();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listAll) {
            if (!((Record) obj).getForceUpdate()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Record {
        private final boolean forceUpdate;
        private final boolean isNewDownload;
        private final String otaId;
        private final long recordedAtWallMs;
        private final long sizeBytes;
        private final String taskId;
        private final int versionCode;

        public Record(String otaId, int i10, boolean z, long j10, String str, long j11, boolean z3) {
            g.f(otaId, "otaId");
            this.otaId = otaId;
            this.versionCode = i10;
            this.forceUpdate = z;
            this.sizeBytes = j10;
            this.taskId = str;
            this.recordedAtWallMs = j11;
            this.isNewDownload = z3;
        }

        public static /* synthetic */ Record copy$default(Record record, String str, int i10, boolean z, long j10, String str2, long j11, boolean z3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = record.otaId;
            }
            if ((i11 & 2) != 0) {
                i10 = record.versionCode;
            }
            if ((i11 & 4) != 0) {
                z = record.forceUpdate;
            }
            if ((i11 & 8) != 0) {
                j10 = record.sizeBytes;
            }
            if ((i11 & 16) != 0) {
                str2 = record.taskId;
            }
            if ((i11 & 32) != 0) {
                j11 = record.recordedAtWallMs;
            }
            if ((i11 & 64) != 0) {
                z3 = record.isNewDownload;
            }
            String str3 = str2;
            long j12 = j10;
            boolean z10 = z;
            return record.copy(str, i10, z10, j12, str3, j11, z3);
        }

        public final String component1() {
            return this.otaId;
        }

        public final int component2() {
            return this.versionCode;
        }

        public final boolean component3() {
            return this.forceUpdate;
        }

        public final long component4() {
            return this.sizeBytes;
        }

        public final String component5() {
            return this.taskId;
        }

        public final long component6() {
            return this.recordedAtWallMs;
        }

        public final boolean component7() {
            return this.isNewDownload;
        }

        public final Record copy(String otaId, int i10, boolean z, long j10, String str, long j11, boolean z3) {
            g.f(otaId, "otaId");
            return new Record(otaId, i10, z, j10, str, j11, z3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Record)) {
                return false;
            }
            Record record = (Record) obj;
            return g.b(this.otaId, record.otaId) && this.versionCode == record.versionCode && this.forceUpdate == record.forceUpdate && this.sizeBytes == record.sizeBytes && g.b(this.taskId, record.taskId) && this.recordedAtWallMs == record.recordedAtWallMs && this.isNewDownload == record.isNewDownload;
        }

        public final boolean getForceUpdate() {
            return this.forceUpdate;
        }

        public final String getOtaId() {
            return this.otaId;
        }

        public final long getRecordedAtWallMs() {
            return this.recordedAtWallMs;
        }

        public final long getSizeBytes() {
            return this.sizeBytes;
        }

        public final String getTaskId() {
            return this.taskId;
        }

        public final int getVersionCode() {
            return this.versionCode;
        }

        public int hashCode() {
            int iC = a0.a.c(ai.onnxruntime.a.f(ai.onnxruntime.a.d(this.versionCode, this.otaId.hashCode() * 31, 31), 31, this.forceUpdate), this.sizeBytes, 31);
            String str = this.taskId;
            return Boolean.hashCode(this.isNewDownload) + a0.a.c((iC + (str == null ? 0 : str.hashCode())) * 31, this.recordedAtWallMs, 31);
        }

        public final boolean isNewDownload() {
            return this.isNewDownload;
        }

        public String toString() {
            String str = this.otaId;
            int i10 = this.versionCode;
            boolean z = this.forceUpdate;
            long j10 = this.sizeBytes;
            String str2 = this.taskId;
            long j11 = this.recordedAtWallMs;
            boolean z3 = this.isNewDownload;
            StringBuilder sbF = e.f("Record(otaId=", str, ", versionCode=", i10, ", forceUpdate=");
            sbF.append(z);
            sbF.append(", sizeBytes=");
            sbF.append(j10);
            sbF.append(", taskId=");
            sbF.append(str2);
            sbF.append(", recordedAtWallMs=");
            sbF.append(j11);
            sbF.append(", isNewDownload=");
            sbF.append(z3);
            sbF.append(")");
            return sbF.toString();
        }

        public /* synthetic */ Record(String str, int i10, boolean z, long j10, String str2, long j11, boolean z3, int i11, kotlin.jvm.internal.e eVar) {
            this(str, i10, z, j10, str2, j11, (i11 & 64) != 0 ? false : z3);
        }
    }
}

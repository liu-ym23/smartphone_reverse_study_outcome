package com.stepos.core.ota.storage;

import ai.onnxruntime.a;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.ota.domain.OtaError;
import com.stepos.core.ota.domain.OtaState;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.domain.PauseReason;
import com.stepos.core.ota.domain.TriggerSource;
import com.stepos.core.ota.domain.TriggerSourcePolicy;
import com.stepos.core.ota.process.OtaStateCodec;
import com.tencent.mmkv.MMKV;
import dc.h;
import gc.q;
import h0.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.c;
import kotlin.collections.EmptyList;
import kotlin.collections.b;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.internal.g;
import lb.d;
import lb.n;
import mb.m;
import mb.t;
import mb.y;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaTaskSnapshotStore {
    private static final String KEY_ENTRIES = "entries_v1";
    private static final String MMKV_ID = "ota_task_snapshot";
    private static final int PROGRESS_BUCKET_PCT = 5;
    private static final d kv$delegate;
    private static final d pausedOrdinal$delegate;
    public static final OtaTaskSnapshotStore INSTANCE = new OtaTaskSnapshotStore();
    private static volatile String lastSig = "";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class LazyPersistedEntries {
        private Map<String, ? extends JSONObject> index;

        public final JSONObject of(String otaId) {
            g.f(otaId, "otaId");
            Map<String, ? extends JSONObject> mapM0 = this.index;
            if (mapM0 == null) {
                List<JSONObject> entries = OtaTaskSnapshotStore.INSTANCE.readEntries();
                ArrayList arrayList = new ArrayList();
                for (JSONObject jSONObject : entries) {
                    String strOptString = jSONObject.optString("otaId");
                    g.c(strOptString);
                    if (q.t0(strOptString)) {
                        strOptString = null;
                    }
                    Pair pair = strOptString != null ? new Pair(strOptString, jSONObject) : null;
                    if (pair != null) {
                        arrayList.add(pair);
                    }
                }
                mapM0 = b.m0(arrayList);
                this.index = mapM0;
            }
            return mapM0.get(otaId);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class PausedRestoreEntry {
        private final boolean cellularAllowed;
        private final String otaId;
        private final int progress;
        private final PauseReason reason;
        private final Set<TriggerSource> sources;

        /* JADX WARN: Multi-variable type inference failed */
        public PausedRestoreEntry(String otaId, int i10, PauseReason reason, Set<? extends TriggerSource> sources, boolean z) {
            g.f(otaId, "otaId");
            g.f(reason, "reason");
            g.f(sources, "sources");
            this.otaId = otaId;
            this.progress = i10;
            this.reason = reason;
            this.sources = sources;
            this.cellularAllowed = z;
        }

        public static /* synthetic */ PausedRestoreEntry copy$default(PausedRestoreEntry pausedRestoreEntry, String str, int i10, PauseReason pauseReason, Set set, boolean z, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = pausedRestoreEntry.otaId;
            }
            if ((i11 & 2) != 0) {
                i10 = pausedRestoreEntry.progress;
            }
            if ((i11 & 4) != 0) {
                pauseReason = pausedRestoreEntry.reason;
            }
            if ((i11 & 8) != 0) {
                set = pausedRestoreEntry.sources;
            }
            if ((i11 & 16) != 0) {
                z = pausedRestoreEntry.cellularAllowed;
            }
            boolean z3 = z;
            PauseReason pauseReason2 = pauseReason;
            return pausedRestoreEntry.copy(str, i10, pauseReason2, set, z3);
        }

        public final String component1() {
            return this.otaId;
        }

        public final int component2() {
            return this.progress;
        }

        public final PauseReason component3() {
            return this.reason;
        }

        public final Set<TriggerSource> component4() {
            return this.sources;
        }

        public final boolean component5() {
            return this.cellularAllowed;
        }

        public final PausedRestoreEntry copy(String otaId, int i10, PauseReason reason, Set<? extends TriggerSource> sources, boolean z) {
            g.f(otaId, "otaId");
            g.f(reason, "reason");
            g.f(sources, "sources");
            return new PausedRestoreEntry(otaId, i10, reason, sources, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PausedRestoreEntry)) {
                return false;
            }
            PausedRestoreEntry pausedRestoreEntry = (PausedRestoreEntry) obj;
            return g.b(this.otaId, pausedRestoreEntry.otaId) && this.progress == pausedRestoreEntry.progress && this.reason == pausedRestoreEntry.reason && g.b(this.sources, pausedRestoreEntry.sources) && this.cellularAllowed == pausedRestoreEntry.cellularAllowed;
        }

        public final boolean getCellularAllowed() {
            return this.cellularAllowed;
        }

        public final String getOtaId() {
            return this.otaId;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final PauseReason getReason() {
            return this.reason;
        }

        public final Set<TriggerSource> getSources() {
            return this.sources;
        }

        public int hashCode() {
            return Boolean.hashCode(this.cellularAllowed) + ((this.sources.hashCode() + ((this.reason.hashCode() + a.d(this.progress, this.otaId.hashCode() * 31, 31)) * 31)) * 31);
        }

        public String toString() {
            String str = this.otaId;
            int i10 = this.progress;
            PauseReason pauseReason = this.reason;
            Set<TriggerSource> set = this.sources;
            boolean z = this.cellularAllowed;
            StringBuilder sbF = e.f("PausedRestoreEntry(otaId=", str, ", progress=", i10, ", reason=");
            sbF.append(pauseReason);
            sbF.append(", sources=");
            sbF.append(set);
            sbF.append(", cellularAllowed=");
            return a0.a.m(sbF, z, ")");
        }
    }

    static {
        int i10 = 27;
        kv$delegate = kotlin.b.b(new a9.a(i10));
        pausedOrdinal$delegate = kotlin.b.b(new a9.b(i10));
    }

    private OtaTaskSnapshotStore() {
    }

    private final Set<TriggerSource> decodeSources(JSONObject jSONObject) {
        SetBuilder setBuilder = new SetBuilder();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("sources");
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                TriggerSource triggerSource = (TriggerSource) kotlin.collections.a.w0(jSONArrayOptJSONArray.optInt(i10, -1), TriggerSource.getEntries());
                if (triggerSource != null) {
                    setBuilder.add(triggerSource);
                }
            }
        }
        return y.j(setBuilder);
    }

    private final OtaState decodeState(int i10, int i11, int i12) {
        OtaStateCodec otaStateCodec = OtaStateCodec.INSTANCE;
        PauseReason pauseReason = PauseReason.USER;
        if (i10 != otaStateCodec.stateOrdinal(new OtaState.Paused(pauseReason, 0))) {
            return i10 == otaStateCodec.stateOrdinal(new OtaState.Installed(0)) ? new OtaState.Installed(0) : i10 == otaStateCodec.stateOrdinal(new OtaState.Failed(new OtaError.Unknown("", null))) ? new OtaState.Failed(new OtaError.Unknown("", null)) : OtaState.Idle.INSTANCE;
        }
        sb.a<PauseReason> entries = PauseReason.getEntries();
        if (i12 >= 0 && i12 < entries.size()) {
            pauseReason = entries.get(i12);
        }
        return new OtaState.Paused(pauseReason, i11);
    }

    private final JSONObject encode(OtaStateSnapshot otaStateSnapshot, int i10, Integer num) throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("otaId", otaStateSnapshot.getOtaId()).put("stateOrdinal", num != null ? num.intValue() : OtaStateCodec.INSTANCE.stateOrdinal(otaStateSnapshot.getState())).put("progress", otaStateSnapshot.getProgress()).put("installedVersion", otaStateSnapshot.getInstalledVersion()).put("updatedAtMonotonicMs", otaStateSnapshot.getUpdatedAtMonotonicMs()).put("pauseReason", i10).put(ModelFlowMeta.KEY_CELLULAR_ALLOWED, otaStateSnapshot.getCellularAllowed());
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = otaStateSnapshot.getSources().iterator();
        while (it.hasNext()) {
            jSONArray.put(((TriggerSource) it.next()).ordinal());
        }
        n nVar = n.f10413a;
        JSONObject jSONObjectPut2 = jSONObjectPut.put("sources", jSONArray);
        g.e(jSONObjectPut2, "put(...)");
        return jSONObjectPut2;
    }

    public static /* synthetic */ JSONObject encode$default(OtaTaskSnapshotStore otaTaskSnapshotStore, OtaStateSnapshot otaStateSnapshot, int i10, Integer num, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            num = null;
        }
        return otaTaskSnapshotStore.encode(otaStateSnapshot, i10, num);
    }

    private final MMKV getKv() {
        return (MMKV) kv$delegate.getValue();
    }

    private final int getPausedOrdinal() {
        return ((Number) pausedOrdinal$delegate.getValue()).intValue();
    }

    private final JSONObject interruptedCheckpoint(OtaStateSnapshot otaStateSnapshot, LazyPersistedEntries lazyPersistedEntries) {
        if (!OtaTaskSnapshotStoreKt.isCheckpointCarryForwardState(otaStateSnapshot.getState())) {
            return null;
        }
        JSONObject jSONObjectOf = lazyPersistedEntries.of(otaStateSnapshot.getOtaId());
        if (jSONObjectOf != null) {
            return jSONObjectOf;
        }
        if (OtaTaskSnapshotStoreKt.needsFreshInterruptedCheckpoint(otaStateSnapshot)) {
            return encode(otaStateSnapshot, PauseReason.INTERRUPTED.ordinal(), Integer.valueOf(getPausedOrdinal()));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV kv_delegate$lambda$0() {
        return MMKV.o(MMKV_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int pausedOrdinal_delegate$lambda$1() {
        return OtaStateCodec.INSTANCE.stateOrdinal(new OtaState.Paused(PauseReason.USER, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.Result$Failure] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.ArrayList] */
    public final List<JSONObject> readEntries() {
        ?? A;
        String strG = getKv().g(KEY_ENTRIES);
        if (strG == null) {
            return EmptyList.f10001a;
        }
        try {
            JSONArray jSONArray = new JSONArray(strG);
            dc.e eVarE0 = h.e0(0, jSONArray.length());
            A = new ArrayList(m.Z(eVarE0, 10));
            Iterator<Integer> it = eVarE0.iterator();
            while (((dc.d) it).f8456c) {
                A.add(jSONArray.getJSONObject(((t) it).nextInt()));
            }
        } catch (Throwable th) {
            A = c.a(th);
        }
        EmptyList emptyList = EmptyList.f10001a;
        boolean z = A instanceof Result.Failure;
        EmptyList emptyList2 = A;
        if (z) {
            emptyList2 = emptyList;
        }
        return emptyList2;
    }

    private final String sourceSignature(OtaStateSnapshot otaStateSnapshot) {
        Set<TriggerSource> sources = otaStateSnapshot.getSources();
        ArrayList arrayList = new ArrayList(m.Z(sources, 10));
        Iterator<T> it = sources.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((TriggerSource) it.next()).ordinal()));
        }
        return kotlin.collections.a.z0(kotlin.collections.a.H0(arrayList), ",", null, null, null, 62);
    }

    private final void writeEntries(List<? extends JSONObject> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put((JSONObject) it.next());
        }
        getKv().l(KEY_ENTRIES, jSONArray.toString());
    }

    public final void clear(String otaId) {
        g.f(otaId, "otaId");
        if (q.t0(otaId)) {
            return;
        }
        try {
            List<JSONObject> entries = readEntries();
            ArrayList arrayList = new ArrayList();
            for (Object obj : entries) {
                if (!g.b(((JSONObject) obj).getString("otaId"), otaId)) {
                    arrayList.add(obj);
                }
            }
            writeEntries(arrayList);
            n nVar = n.f10413a;
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public final void flushForProcessExit(Map<String, OtaStateSnapshot> snapshots) {
        OtaTaskSnapshotStore otaTaskSnapshotStore;
        g.f(snapshots, "snapshots");
        try {
            JSONArray jSONArray = new JSONArray();
            LazyPersistedEntries lazyPersistedEntries = new LazyPersistedEntries();
            for (OtaStateSnapshot otaStateSnapshot : snapshots.values()) {
                if (UserUninstallStore.INSTANCE.contains(otaStateSnapshot.getOtaId())) {
                    otaTaskSnapshotStore = this;
                } else {
                    OtaState state = otaStateSnapshot.getState();
                    if (state instanceof OtaState.Paused) {
                        otaTaskSnapshotStore = this;
                        jSONArray.put(encode$default(otaTaskSnapshotStore, otaStateSnapshot, ((OtaState.Paused) state).getReason().ordinal(), null, 4, null));
                    } else {
                        otaTaskSnapshotStore = this;
                        if (state instanceof OtaState.Downloading) {
                            jSONArray.put(otaTaskSnapshotStore.encode(otaStateSnapshot, PauseReason.USER.ordinal(), Integer.valueOf(otaTaskSnapshotStore.getPausedOrdinal())));
                        } else if (state instanceof OtaState.Failed) {
                            jSONArray.put(encode$default(otaTaskSnapshotStore, otaStateSnapshot, 0, Integer.valueOf(OtaStateCodec.INSTANCE.stateOrdinal(state)), 2, null));
                        } else {
                            JSONObject jSONObjectInterruptedCheckpoint = otaTaskSnapshotStore.interruptedCheckpoint(otaStateSnapshot, lazyPersistedEntries);
                            if (jSONObjectInterruptedCheckpoint != null) {
                                jSONArray.put(jSONObjectInterruptedCheckpoint);
                                n nVar = n.f10413a;
                            }
                        }
                    }
                }
                this = otaTaskSnapshotStore;
            }
            lastSig = "";
            this.getKv().l(KEY_ENTRIES, jSONArray.toString());
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public final boolean hasUnfinished(String otaId) {
        Object objA;
        g.f(otaId, "otaId");
        try {
            int iStateOrdinal = OtaStateCodec.INSTANCE.stateOrdinal(new OtaState.Failed(new OtaError.Unknown("", null)));
            List<JSONObject> entries = readEntries();
            boolean z = false;
            if (entries == null || !entries.isEmpty()) {
                for (JSONObject jSONObject : entries) {
                    if (g.b(jSONObject.getString("otaId"), otaId) && (jSONObject.getInt("stateOrdinal") == getPausedOrdinal() || jSONObject.getInt("stateOrdinal") == iStateOrdinal)) {
                        z = true;
                        break;
                    }
                }
            }
            objA = Boolean.valueOf(z);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    public final boolean isUserManaged(String otaId) {
        Object objA;
        g.f(otaId, "otaId");
        try {
            int iStateOrdinal = OtaStateCodec.INSTANCE.stateOrdinal(new OtaState.Failed(new OtaError.Unknown("", null)));
            List<JSONObject> entries = readEntries();
            boolean z = false;
            if (entries == null || !entries.isEmpty()) {
                Iterator<T> it = entries.iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    JSONObject jSONObject = (JSONObject) it.next();
                    if (g.b(jSONObject.getString("otaId"), otaId) && (jSONObject.getInt("stateOrdinal") == getPausedOrdinal() || jSONObject.getInt("stateOrdinal") == iStateOrdinal)) {
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("sources");
                        if (jSONArrayOptJSONArray != null) {
                            Iterable iterableE0 = h.e0(0, jSONArrayOptJSONArray.length());
                            if (!(iterableE0 instanceof Collection) || !((Collection) iterableE0).isEmpty()) {
                                Iterator<Integer> it2 = iterableE0.iterator();
                                while (((dc.d) it2).f8456c) {
                                    if (jSONArrayOptJSONArray.getInt(((t) it2).nextInt()) == TriggerSource.USER.ordinal()) {
                                        z = true;
                                        break loop0;
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            objA = Boolean.valueOf(z);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.Result$Failure] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.ArrayList] */
    public final List<PausedRestoreEntry> loadPausedRestoreEntries() {
        ?? A;
        try {
            int iStateOrdinal = OtaStateCodec.INSTANCE.stateOrdinal(new OtaState.Paused(PauseReason.USER, 0));
            List<JSONObject> entries = readEntries();
            A = new ArrayList();
            for (JSONObject jSONObject : entries) {
                PausedRestoreEntry pausedRestoreEntry = null;
                if (jSONObject.getInt("stateOrdinal") == iStateOrdinal) {
                    String string = jSONObject.getString("otaId");
                    UserUninstallStore userUninstallStore = UserUninstallStore.INSTANCE;
                    g.c(string);
                    if (!userUninstallStore.contains(string)) {
                        SetBuilder setBuilder = new SetBuilder();
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("sources");
                        if (jSONArrayOptJSONArray != null) {
                            int length = jSONArrayOptJSONArray.length();
                            for (int i10 = 0; i10 < length; i10++) {
                                TriggerSource triggerSource = (TriggerSource) kotlin.collections.a.w0(jSONArrayOptJSONArray.getInt(i10), TriggerSource.getEntries());
                                if (triggerSource != null) {
                                    setBuilder.add(triggerSource);
                                }
                            }
                        }
                        SetBuilder setBuilderJ = y.j(setBuilder);
                        int i11 = jSONObject.getInt("progress");
                        sb.a<PauseReason> entries2 = PauseReason.getEntries();
                        int iOptInt = jSONObject.optInt("pauseReason", 0);
                        pausedRestoreEntry = new PausedRestoreEntry(string, i11, (iOptInt < 0 || iOptInt >= entries2.size()) ? PauseReason.USER : entries2.get(iOptInt), setBuilderJ, jSONObject.optBoolean(ModelFlowMeta.KEY_CELLULAR_ALLOWED, false));
                    }
                }
                if (pausedRestoreEntry != null) {
                    A.add(pausedRestoreEntry);
                }
            }
        } catch (Throwable th) {
            A = c.a(th);
        }
        EmptyList emptyList = EmptyList.f10001a;
        boolean z = A instanceof Result.Failure;
        EmptyList emptyList2 = A;
        if (z) {
            emptyList2 = emptyList;
        }
        return emptyList2;
    }

    public final void sync(Map<String, OtaStateSnapshot> snapshots) {
        OtaTaskSnapshotStore otaTaskSnapshotStore;
        g.f(snapshots, "snapshots");
        try {
            JSONArray jSONArray = new JSONArray();
            StringBuilder sb2 = new StringBuilder();
            LazyPersistedEntries lazyPersistedEntries = new LazyPersistedEntries();
            for (OtaStateSnapshot otaStateSnapshot : kotlin.collections.a.I0(snapshots.values(), new Comparator() { // from class: com.stepos.core.ota.storage.OtaTaskSnapshotStore$sync$lambda$5$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t8, T t10) {
                    return ob.b.a(((OtaStateSnapshot) t8).getOtaId(), ((OtaStateSnapshot) t10).getOtaId());
                }
            })) {
                if (UserUninstallStore.INSTANCE.contains(otaStateSnapshot.getOtaId())) {
                    otaTaskSnapshotStore = this;
                } else {
                    OtaState state = otaStateSnapshot.getState();
                    if (state instanceof OtaState.Paused) {
                        otaTaskSnapshotStore = this;
                        jSONArray.put(encode$default(otaTaskSnapshotStore, otaStateSnapshot, ((OtaState.Paused) state).getReason().ordinal(), null, 4, null));
                        sb2.append("P:");
                        sb2.append(otaStateSnapshot.getOtaId());
                        sb2.append(':');
                        sb2.append(otaStateSnapshot.getProgress());
                        sb2.append(':');
                        sb2.append(((OtaState.Paused) state).getReason().ordinal());
                        sb2.append(':');
                        sb2.append(otaTaskSnapshotStore.sourceSignature(otaStateSnapshot));
                        sb2.append(':');
                        sb2.append(otaStateSnapshot.getCellularAllowed());
                        sb2.append(';');
                    } else {
                        otaTaskSnapshotStore = this;
                        if (state instanceof OtaState.Downloading) {
                            jSONArray.put(otaTaskSnapshotStore.encode(otaStateSnapshot, PauseReason.INTERRUPTED.ordinal(), Integer.valueOf(otaTaskSnapshotStore.getPausedOrdinal())));
                            sb2.append("D:");
                            sb2.append(otaStateSnapshot.getOtaId());
                            sb2.append(':');
                            sb2.append(otaStateSnapshot.getProgress() / 5);
                            sb2.append(':');
                            sb2.append(otaTaskSnapshotStore.sourceSignature(otaStateSnapshot));
                            sb2.append(':');
                            sb2.append(otaStateSnapshot.getCellularAllowed());
                            sb2.append(';');
                        } else if (!(state instanceof OtaState.Installed)) {
                            if (state instanceof OtaState.Failed) {
                                jSONArray.put(encode$default(otaTaskSnapshotStore, otaStateSnapshot, 0, Integer.valueOf(OtaStateCodec.INSTANCE.stateOrdinal(state)), 2, null));
                                sb2.append("F:");
                                sb2.append(otaStateSnapshot.getOtaId());
                                sb2.append(';');
                            } else {
                                JSONObject jSONObjectInterruptedCheckpoint = otaTaskSnapshotStore.interruptedCheckpoint(otaStateSnapshot, lazyPersistedEntries);
                                if (jSONObjectInterruptedCheckpoint != null) {
                                    jSONArray.put(jSONObjectInterruptedCheckpoint);
                                    sb2.append("K:");
                                    sb2.append(otaStateSnapshot.getOtaId());
                                    sb2.append(':');
                                    sb2.append(otaStateSnapshot.getProgress());
                                    sb2.append(';');
                                }
                            }
                        }
                    }
                }
                this = otaTaskSnapshotStore;
            }
            OtaTaskSnapshotStore otaTaskSnapshotStore2 = this;
            String string = sb2.toString();
            g.e(string, "toString(...)");
            if (!string.equals(lastSig)) {
                lastSig = string;
                otaTaskSnapshotStore2.getKv().l(KEY_ENTRIES, jSONArray.toString());
            }
            n nVar = n.f10413a;
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public final Map<String, OtaStateSnapshot> toSnapshots() {
        Object objA;
        Pair pair;
        try {
            Pair pair2 = null;
            int iStateOrdinal = OtaStateCodec.INSTANCE.stateOrdinal(new OtaState.Failed(new OtaError.Unknown("", null)));
            List<JSONObject> entries = readEntries();
            ArrayList arrayList = new ArrayList();
            for (JSONObject jSONObject : entries) {
                int i10 = jSONObject.getInt("stateOrdinal");
                if (i10 == iStateOrdinal) {
                    pair = pair2;
                } else {
                    String string = jSONObject.getString("otaId");
                    UserUninstallStore userUninstallStore = UserUninstallStore.INSTANCE;
                    g.c(string);
                    if (userUninstallStore.contains(string)) {
                        pair = pair2;
                    } else {
                        int i11 = jSONObject.getInt("progress");
                        int iOptInt = jSONObject.optInt("installedVersion", 0);
                        long jOptLong = jSONObject.optLong("updatedAtMonotonicMs", 0L);
                        OtaState otaStateDecodeState = decodeState(i10, i11, jSONObject.optInt("pauseReason", 0));
                        Set<TriggerSource> setDecodeSources = decodeSources(jSONObject);
                        pair = new Pair(string, new OtaStateSnapshot(string, otaStateDecodeState, i11, iOptInt, jOptLong, setDecodeSources, TriggerSourcePolicy.INSTANCE.primary(setDecodeSources), jSONObject.optBoolean(ModelFlowMeta.KEY_CELLULAR_ALLOWED, false), false, false, 768, null));
                    }
                }
                if (pair != null) {
                    arrayList.add(pair);
                }
                pair2 = null;
            }
            objA = b.m0(arrayList);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Object objD0 = b.d0();
        if (objA instanceof Result.Failure) {
            objA = objD0;
        }
        return (Map) objA;
    }
}

package com.stepos.core.ota.remote;

import android.os.Build;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.ota.crypto.DeviceProof;
import com.stepos.core.ota.d;
import com.stepos.core.ota.data.OtaRemoteModel;
import com.stepos.core.ota.storage.ModelsVersionStore;
import gc.q;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Pair;
import kotlin.jvm.internal.g;
import mb.m;
import sb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class RemoteModelsFetchLogic {
    public static final RemoteModelsFetchLogic INSTANCE = new RemoteModelsFetchLogic();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class EmptyFetchOutcome {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ EmptyFetchOutcome[] $VALUES;
        public static final EmptyFetchOutcome BATCH_EMPTY = new EmptyFetchOutcome("BATCH_EMPTY", 0);
        public static final EmptyFetchOutcome STALE_EVICTED = new EmptyFetchOutcome("STALE_EVICTED", 1);
        public static final EmptyFetchOutcome UP_TO_DATE = new EmptyFetchOutcome("UP_TO_DATE", 2);
        public static final EmptyFetchOutcome UNAVAILABLE = new EmptyFetchOutcome(ModelFlowMeta.PLAN_UNAVAILABLE, 3);

        private static final /* synthetic */ EmptyFetchOutcome[] $values() {
            return new EmptyFetchOutcome[]{BATCH_EMPTY, STALE_EVICTED, UP_TO_DATE, UNAVAILABLE};
        }

        static {
            EmptyFetchOutcome[] emptyFetchOutcomeArr$values = $values();
            $VALUES = emptyFetchOutcomeArr$values;
            $ENTRIES = kotlin.enums.a.a(emptyFetchOutcomeArr$values);
        }

        private EmptyFetchOutcome(String str, int i10) {
        }

        public static a<EmptyFetchOutcome> getEntries() {
            return $ENTRIES;
        }

        public static EmptyFetchOutcome valueOf(String str) {
            return (EmptyFetchOutcome) Enum.valueOf(EmptyFetchOutcome.class, str);
        }

        public static EmptyFetchOutcome[] values() {
            return (EmptyFetchOutcome[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class FetchContext {
        private final int localVer;
        private final boolean multiName;
        private final String name;
        private final boolean upgradeCheck;

        public FetchContext(String name, boolean z, int i10, boolean z3) {
            g.f(name, "name");
            this.name = name;
            this.multiName = z;
            this.localVer = i10;
            this.upgradeCheck = z3;
        }

        public static /* synthetic */ FetchContext copy$default(FetchContext fetchContext, String str, boolean z, int i10, boolean z3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = fetchContext.name;
            }
            if ((i11 & 2) != 0) {
                z = fetchContext.multiName;
            }
            if ((i11 & 4) != 0) {
                i10 = fetchContext.localVer;
            }
            if ((i11 & 8) != 0) {
                z3 = fetchContext.upgradeCheck;
            }
            return fetchContext.copy(str, z, i10, z3);
        }

        public final String component1() {
            return this.name;
        }

        public final boolean component2() {
            return this.multiName;
        }

        public final int component3() {
            return this.localVer;
        }

        public final boolean component4() {
            return this.upgradeCheck;
        }

        public final FetchContext copy(String name, boolean z, int i10, boolean z3) {
            g.f(name, "name");
            return new FetchContext(name, z, i10, z3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FetchContext)) {
                return false;
            }
            FetchContext fetchContext = (FetchContext) obj;
            return g.b(this.name, fetchContext.name) && this.multiName == fetchContext.multiName && this.localVer == fetchContext.localVer && this.upgradeCheck == fetchContext.upgradeCheck;
        }

        public final int getLocalVer() {
            return this.localVer;
        }

        public final boolean getMultiName() {
            return this.multiName;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean getUpgradeCheck() {
            return this.upgradeCheck;
        }

        public int hashCode() {
            return Boolean.hashCode(this.upgradeCheck) + ai.onnxruntime.a.d(this.localVer, ai.onnxruntime.a.f(this.name.hashCode() * 31, 31, this.multiName), 31);
        }

        public String toString() {
            String str = this.name;
            boolean z = this.multiName;
            int i10 = this.localVer;
            boolean z3 = this.upgradeCheck;
            StringBuilder sbM = d.m("FetchContext(name=", str, ", multiName=", ", localVer=", z);
            sbM.append(i10);
            sbM.append(", upgradeCheck=");
            sbM.append(z3);
            sbM.append(")");
            return sbM.toString();
        }
    }

    private RemoteModelsFetchLogic() {
    }

    private static final CharSequence hmacSha256$lambda$8(byte b10) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
    }

    public final boolean acceptsIncoming(Integer num, int i10, int i11) {
        return num == null || num.intValue() <= i10 || i11 <= 0 || num.intValue() > i11;
    }

    public final Pair<Boolean, EmptyFetchOutcome> applyEmptyResponse(FetchContext ctx, Map<String, OtaRemoteModel> resultsMap, Map<String, Long> fetchTime, long j10) {
        EmptyFetchOutcome emptyFetchOutcome;
        g.f(ctx, "ctx");
        g.f(resultsMap, "resultsMap");
        g.f(fetchTime, "fetchTime");
        if (ctx.getMultiName()) {
            emptyFetchOutcome = EmptyFetchOutcome.BATCH_EMPTY;
        } else if (ctx.getUpgradeCheck()) {
            OtaRemoteModel otaRemoteModel = resultsMap.get(ctx.getName());
            if (otaRemoteModel == null || otaRemoteModel.getVersion_code() <= ctx.getLocalVer()) {
                fetchTime.put(ctx.getName(), Long.valueOf(j10));
                emptyFetchOutcome = EmptyFetchOutcome.UP_TO_DATE;
            } else {
                resultsMap.remove(ctx.getName());
                fetchTime.remove(ctx.getName());
                emptyFetchOutcome = EmptyFetchOutcome.STALE_EVICTED;
            }
        } else {
            resultsMap.remove(ctx.getName());
            fetchTime.remove(ctx.getName());
            emptyFetchOutcome = EmptyFetchOutcome.UNAVAILABLE;
        }
        boolean z = false;
        if (ctx.getUpgradeCheck() && (resultsMap.get(ctx.getName()) != null || fetchTime.containsKey(ctx.getName()))) {
            z = true;
        }
        return new Pair<>(Boolean.valueOf(z), emptyFetchOutcome);
    }

    public final List<String> batchKeysContaining(String name, Collection<String> keys) {
        g.f(name, "name");
        g.f(keys, "keys");
        ArrayList arrayList = new ArrayList();
        for (Object obj : keys) {
            String str = (String) obj;
            if (q.m0(str, '|') && q.D0(str, new String[]{"|"}, 6).contains(name)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final FetchContext buildFetchContext(String name) {
        g.f(name, "name");
        boolean z = false;
        boolean zL0 = q.l0(name, "|", false);
        int versionCode = zL0 ? 0 : ModelsVersionStore.INSTANCE.getVersionCode(name);
        if (!zL0 && versionCode > 0) {
            z = true;
        }
        return new FetchContext(name, zL0, versionCode, z);
    }

    public final LinkedHashMap<String, String> buildRequestParams(FetchContext ctx, long j10, long j11, String oaid, String str, String framework) {
        g.f(ctx, "ctx");
        g.f(oaid, "oaid");
        g.f(framework, "framework");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("cts", String.valueOf(j10));
        linkedHashMap.put("cp", "stepos");
        if (ctx.getName().length() > 0) {
            linkedHashMap.put("modelId", ctx.getName());
        }
        if (ctx.getUpgradeCheck()) {
            linkedHashMap.put("versionCode", String.valueOf(ctx.getLocalVer()));
        }
        linkedHashMap.put("os_version", String.valueOf(Build.VERSION.SDK_INT));
        linkedHashMap.put("apk_version", String.valueOf(j11));
        if (str != null) {
            if (q.t0(str)) {
                str = null;
            }
            if (str != null) {
                linkedHashMap.put("soc_model", str);
            }
        }
        if (q.t0(framework)) {
            framework = null;
        }
        if (framework != null) {
            linkedHashMap.put("framework", framework);
        }
        if (q.t0(oaid)) {
            oaid = null;
        }
        if (oaid != null) {
            linkedHashMap.put("oaid", oaid);
        }
        return linkedHashMap;
    }

    public final String hmacSha256(String input, String key) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        g.f(input, "input");
        g.f(key, "key");
        Mac mac = Mac.getInstance(DeviceProof.ALG);
        Charset charset = gc.a.f9106b;
        byte[] bytes = key.getBytes(charset);
        g.e(bytes, "getBytes(...)");
        mac.init(new SecretKeySpec(bytes, DeviceProof.ALG));
        byte[] bytes2 = input.getBytes(charset);
        g.e(bytes2, "getBytes(...)");
        byte[] bArrDoFinal = mac.doFinal(bytes2);
        g.e(bArrDoFinal, "doFinal(...)");
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        int i10 = 0;
        for (byte b10 : bArrDoFinal) {
            i10++;
            if (i10 > 1) {
                sb2.append((CharSequence) "");
            }
            sb2.append(hmacSha256$lambda$8(b10));
        }
        sb2.append((CharSequence) "");
        return sb2.toString();
    }

    public final Set<String> missingNamesInBatch(String batchName, List<OtaRemoteModel> list) {
        g.f(batchName, "batchName");
        g.f(list, "list");
        LinkedHashSet linkedHashSet = new LinkedHashSet(q.D0(batchName, new String[]{"|"}, 6));
        ArrayList arrayList = new ArrayList(m.Z(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((OtaRemoteModel) it.next()).getName());
        }
        linkedHashSet.removeAll(kotlin.collections.a.R0(arrayList));
        return linkedHashSet;
    }

    public final void pruneMissing(Set<String> missing, Map<String, OtaRemoteModel> resultsMap, Map<String, Long> fetchTime) {
        g.f(missing, "missing");
        g.f(resultsMap, "resultsMap");
        g.f(fetchTime, "fetchTime");
        for (String str : missing) {
            resultsMap.remove(str);
            fetchTime.remove(str);
        }
    }

    public final void recordFetchTimes(FetchContext ctx, List<OtaRemoteModel> list, Map<String, Long> fetchTime, long j10) {
        g.f(ctx, "ctx");
        g.f(list, "list");
        g.f(fetchTime, "fetchTime");
        for (OtaRemoteModel otaRemoteModel : list) {
            fetchTime.put(otaRemoteModel.getName(), Long.valueOf(j10));
        }
        if (ctx.getMultiName()) {
            fetchTime.put(ctx.getName(), Long.valueOf(j10));
        }
    }

    public final String signBase(Map<String, String> params) {
        g.f(params, "params");
        TreeMap treeMap = new TreeMap(params);
        ArrayList arrayList = new ArrayList(treeMap.size());
        for (Map.Entry entry : treeMap.entrySet()) {
            arrayList.add(entry.getKey() + "=" + entry.getValue());
        }
        return kotlin.collections.a.z0(arrayList, "&", null, null, null, 62);
    }
}

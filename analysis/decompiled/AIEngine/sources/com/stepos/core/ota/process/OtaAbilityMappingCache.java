package com.stepos.core.ota.process;

import com.google.gson.reflect.TypeToken;
import com.tencent.mmkv.MMKV;
import d5.i;
import h0.e;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import lb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaAbilityMappingCache {
    private static final String KEY = "rows_json";
    private static final String MMKV_ID = "ota_ability_mapping";
    public static final OtaAbilityMappingCache INSTANCE = new OtaAbilityMappingCache();
    private static final i gson = new i();
    private static final d kv$delegate = kotlin.b.b(new a9.a(22));

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Row {
        private final String abilityId;
        private final String modelId;

        public Row(String abilityId, String modelId) {
            g.f(abilityId, "abilityId");
            g.f(modelId, "modelId");
            this.abilityId = abilityId;
            this.modelId = modelId;
        }

        public static /* synthetic */ Row copy$default(Row row, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = row.abilityId;
            }
            if ((i10 & 2) != 0) {
                str2 = row.modelId;
            }
            return row.copy(str, str2);
        }

        public final String component1() {
            return this.abilityId;
        }

        public final String component2() {
            return this.modelId;
        }

        public final Row copy(String abilityId, String modelId) {
            g.f(abilityId, "abilityId");
            g.f(modelId, "modelId");
            return new Row(abilityId, modelId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Row)) {
                return false;
            }
            Row row = (Row) obj;
            return g.b(this.abilityId, row.abilityId) && g.b(this.modelId, row.modelId);
        }

        public final String getAbilityId() {
            return this.abilityId;
        }

        public final String getModelId() {
            return this.modelId;
        }

        public int hashCode() {
            return this.modelId.hashCode() + (this.abilityId.hashCode() * 31);
        }

        public String toString() {
            return e.c("Row(abilityId=", this.abilityId, ", modelId=", this.modelId, ")");
        }
    }

    private OtaAbilityMappingCache() {
    }

    private final MMKV getKv() {
        return (MMKV) kv$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV kv_delegate$lambda$0() {
        return MMKV.o(MMKV_ID);
    }

    public final List<Row> load() {
        Object objA;
        String strG = getKv().g(KEY);
        if (strG == null) {
            return EmptyList.f10001a;
        }
        try {
            Type type = new TypeToken<List<? extends Row>>() { // from class: com.stepos.core.ota.process.OtaAbilityMappingCache$load$1$type$1
            }.getType();
            i iVar = gson;
            iVar.getClass();
            objA = (List) iVar.c(strG, TypeToken.get(type));
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = EmptyList.f10001a;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return (List) objA;
    }

    public final String loadFramework() {
        String strG = getKv().g("framework");
        return strG == null ? "" : strG;
    }

    public final void persist(List<Row> rows) {
        g.f(rows, "rows");
        getKv().l(KEY, gson.h(rows));
    }

    public final void persistFramework(String framework) {
        g.f(framework, "framework");
        getKv().l("framework", framework);
    }
}

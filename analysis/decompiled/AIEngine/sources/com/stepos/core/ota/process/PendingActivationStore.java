package com.stepos.core.ota.process;

import com.tencent.mmkv.MMKV;
import gc.n;
import gc.q;
import h0.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import lb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PendingActivationStore {
    private static final String MMKV_ID = "ota_pending_activation";
    private static final String SEP = "|";
    public static final PendingActivationStore INSTANCE = new PendingActivationStore();
    private static final d kv$delegate = kotlin.b.b(new a9.b(22));

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Pending {
        private final String otaId;
        private final String path;
        private final int version;

        public Pending(String otaId, int i10, String path) {
            g.f(otaId, "otaId");
            g.f(path, "path");
            this.otaId = otaId;
            this.version = i10;
            this.path = path;
        }

        public static /* synthetic */ Pending copy$default(Pending pending, String str, int i10, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = pending.otaId;
            }
            if ((i11 & 2) != 0) {
                i10 = pending.version;
            }
            if ((i11 & 4) != 0) {
                str2 = pending.path;
            }
            return pending.copy(str, i10, str2);
        }

        public final String component1() {
            return this.otaId;
        }

        public final int component2() {
            return this.version;
        }

        public final String component3() {
            return this.path;
        }

        public final Pending copy(String otaId, int i10, String path) {
            g.f(otaId, "otaId");
            g.f(path, "path");
            return new Pending(otaId, i10, path);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pending)) {
                return false;
            }
            Pending pending = (Pending) obj;
            return g.b(this.otaId, pending.otaId) && this.version == pending.version && g.b(this.path, pending.path);
        }

        public final String getOtaId() {
            return this.otaId;
        }

        public final String getPath() {
            return this.path;
        }

        public final int getVersion() {
            return this.version;
        }

        public int hashCode() {
            return this.path.hashCode() + ai.onnxruntime.a.d(this.version, this.otaId.hashCode() * 31, 31);
        }

        public String toString() {
            String str = this.otaId;
            int i10 = this.version;
            return ai.onnxruntime.a.o(e.f("Pending(otaId=", str, ", version=", i10, ", path="), this.path, ")");
        }
    }

    private PendingActivationStore() {
    }

    private final MMKV getKv() {
        return (MMKV) kv$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV kv_delegate$lambda$0() {
        if (MMKV.f8137f != null) {
            return MMKV.b(MMKV.getMMKVWithID(MMKV_ID, 1, null, null, 0L), 1, MMKV_ID);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public final List<Pending> all() {
        int iR0;
        String[] strArrA = getKv().a();
        if (strArrA == null) {
            return EmptyList.f10001a;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArrA) {
            String strG = INSTANCE.getKv().g(str);
            Pending pending = null;
            if (strG != null && (iR0 = q.r0(strG, SEP, 0, false, 6)) > 0) {
                String strSubstring = strG.substring(0, iR0);
                g.e(strSubstring, "substring(...)");
                Integer numC0 = n.c0(strSubstring);
                if (numC0 != null) {
                    int iIntValue = numC0.intValue();
                    g.c(str);
                    String strSubstring2 = strG.substring(iR0 + 1);
                    g.e(strSubstring2, "substring(...)");
                    pending = new Pending(str, iIntValue, strSubstring2);
                }
            }
            if (pending != null) {
                arrayList.add(pending);
            }
        }
        return arrayList;
    }

    public final void put(String otaId, int i10, String path) {
        g.f(otaId, "otaId");
        g.f(path, "path");
        getKv().l(otaId, i10 + SEP + path);
    }

    public final void remove(String otaId) {
        g.f(otaId, "otaId");
        getKv().p(otaId);
    }
}

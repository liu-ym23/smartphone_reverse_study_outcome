package com.stepos.core.ota.display;

import gc.q;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DisplayResourcePolicy {
    public static final DisplayResourcePolicy INSTANCE = new DisplayResourcePolicy();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface Use {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Keyed implements Use {
            private final String key;

            public Keyed(String key) {
                g.f(key, "key");
                this.key = key;
            }

            public static /* synthetic */ Keyed copy$default(Keyed keyed, String str, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = keyed.key;
                }
                return keyed.copy(str);
            }

            public final String component1() {
                return this.key;
            }

            public final Keyed copy(String key) {
                g.f(key, "key");
                return new Keyed(key);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Keyed) && g.b(this.key, ((Keyed) obj).key);
            }

            public final String getKey() {
                return this.key;
            }

            public int hashCode() {
                return this.key.hashCode();
            }

            public String toString() {
                return a0.a.k("Keyed(key=", this.key, ")");
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Lenient implements Use {
            public static final Lenient INSTANCE = new Lenient();

            private Lenient() {
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Lenient);
            }

            public int hashCode() {
                return 1169363528;
            }

            public String toString() {
                return "Lenient";
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class None implements Use {
            public static final None INSTANCE = new None();

            private None() {
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof None);
            }

            public int hashCode() {
                return 987384327;
            }

            public String toString() {
                return "None";
            }
        }
    }

    private DisplayResourcePolicy() {
    }

    private final Use fromRecord(String str) {
        if (str == null) {
            return null;
        }
        return q.t0(str) ? Use.None.INSTANCE : new Use.Keyed(str);
    }

    public final Decision decide(boolean z, boolean z3, int i10, boolean z10, String str, int i11, String str2) {
        boolean z11;
        String str3;
        Use useFromRecord;
        if (z3 && z10 && i11 != i10) {
            z11 = z3;
            str3 = null;
        } else {
            z11 = z3;
            str3 = str;
        }
        if (z) {
            boolean z12 = z11 && z10 && i11 == i10;
            return new Decision(Use.Lenient.INSTANCE, z12 ? str : null, null, z10 && !z12, 4, null);
        }
        if (!z10) {
            if (!z11 || (useFromRecord = fromRecord(str2)) == null) {
                useFromRecord = Use.Lenient.INSTANCE;
            }
            return new Decision(useFromRecord, str3, null, false, 12, null);
        }
        String strRemoteDisplayKey = ModelDisplayResourceStore.INSTANCE.remoteDisplayKey(str, z11 ? i10 : i11);
        if (!z11) {
            return new Decision(strRemoteDisplayKey != null ? new Use.Keyed(strRemoteDisplayKey) : Use.None.INSTANCE, str3, null, false, 12, null);
        }
        if (i11 == i10) {
            Use keyed = strRemoteDisplayKey != null ? new Use.Keyed(strRemoteDisplayKey) : Use.None.INSTANCE;
            if (strRemoteDisplayKey == null) {
                strRemoteDisplayKey = "";
            }
            return new Decision(keyed, str3, strRemoteDisplayKey, false, 8, null);
        }
        Use useFromRecord2 = fromRecord(str2);
        if (useFromRecord2 == null) {
            useFromRecord2 = Use.None.INSTANCE;
        }
        return new Decision(useFromRecord2, str3, null, false, 12, null);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Decision {
        private final String downloadUrl;
        private final boolean dropRemoteLeftover;
        private final String recordKey;
        private final Use use;

        public Decision(Use use, String str, String str2, boolean z) {
            g.f(use, "use");
            this.use = use;
            this.downloadUrl = str;
            this.recordKey = str2;
            this.dropRemoteLeftover = z;
        }

        public static /* synthetic */ Decision copy$default(Decision decision, Use use, String str, String str2, boolean z, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                use = decision.use;
            }
            if ((i10 & 2) != 0) {
                str = decision.downloadUrl;
            }
            if ((i10 & 4) != 0) {
                str2 = decision.recordKey;
            }
            if ((i10 & 8) != 0) {
                z = decision.dropRemoteLeftover;
            }
            return decision.copy(use, str, str2, z);
        }

        public final Use component1() {
            return this.use;
        }

        public final String component2() {
            return this.downloadUrl;
        }

        public final String component3() {
            return this.recordKey;
        }

        public final boolean component4() {
            return this.dropRemoteLeftover;
        }

        public final Decision copy(Use use, String str, String str2, boolean z) {
            g.f(use, "use");
            return new Decision(use, str, str2, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Decision)) {
                return false;
            }
            Decision decision = (Decision) obj;
            return g.b(this.use, decision.use) && g.b(this.downloadUrl, decision.downloadUrl) && g.b(this.recordKey, decision.recordKey) && this.dropRemoteLeftover == decision.dropRemoteLeftover;
        }

        public final String getDownloadUrl() {
            return this.downloadUrl;
        }

        public final boolean getDropRemoteLeftover() {
            return this.dropRemoteLeftover;
        }

        public final String getRecordKey() {
            return this.recordKey;
        }

        public final Use getUse() {
            return this.use;
        }

        public int hashCode() {
            int iHashCode = this.use.hashCode() * 31;
            String str = this.downloadUrl;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.recordKey;
            return Boolean.hashCode(this.dropRemoteLeftover) + ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
        }

        public String toString() {
            return "Decision(use=" + this.use + ", downloadUrl=" + this.downloadUrl + ", recordKey=" + this.recordKey + ", dropRemoteLeftover=" + this.dropRemoteLeftover + ")";
        }

        public /* synthetic */ Decision(Use use, String str, String str2, boolean z, int i10, e eVar) {
            this(use, str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? false : z);
        }
    }
}

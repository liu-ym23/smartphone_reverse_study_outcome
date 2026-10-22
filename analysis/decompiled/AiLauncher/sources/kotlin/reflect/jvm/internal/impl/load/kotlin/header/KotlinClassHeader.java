package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import Z8.C1168p;
import Z8.C1173v;
import Z8.Q;
import ea.C4019c;
import h9.InterfaceC4149a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import v9.C5685n;

/* loaded from: classes5.dex */
public final class KotlinClassHeader {

    /* renamed from: a, reason: collision with root package name */
    public final Kind f35203a;

    /* renamed from: b, reason: collision with root package name */
    public final C4019c f35204b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f35205c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f35206d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f35207e;

    /* renamed from: f, reason: collision with root package name */
    public final String f35208f;

    /* renamed from: g, reason: collision with root package name */
    public final int f35209g;

    /* renamed from: h, reason: collision with root package name */
    public final String f35210h;

    /* renamed from: i, reason: collision with root package name */
    public final byte[] f35211i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Kind {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Kind[] $VALUES;
        public static final a Companion;
        private static final Map<Integer, Kind> entryById;
        private final int id;
        public static final Kind UNKNOWN = new Kind("UNKNOWN", 0, 0);
        public static final Kind CLASS = new Kind("CLASS", 1, 1);
        public static final Kind FILE_FACADE = new Kind("FILE_FACADE", 2, 2);
        public static final Kind SYNTHETIC_CLASS = new Kind("SYNTHETIC_CLASS", 3, 3);
        public static final Kind MULTIFILE_CLASS = new Kind("MULTIFILE_CLASS", 4, 4);
        public static final Kind MULTIFILE_CLASS_PART = new Kind("MULTIFILE_CLASS_PART", 5, 5);

        public static final class a {
            public /* synthetic */ a(i iVar) {
                this();
            }

            public final Kind a(int i10) {
                Kind kind = (Kind) Kind.entryById.get(Integer.valueOf(i10));
                return kind == null ? Kind.UNKNOWN : kind;
            }

            public a() {
            }
        }

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{UNKNOWN, CLASS, FILE_FACADE, SYNTHETIC_CLASS, MULTIFILE_CLASS, MULTIFILE_CLASS_PART};
        }

        static {
            Kind[] kindArr$values = $values();
            $VALUES = kindArr$values;
            $ENTRIES = kotlin.enums.a.a(kindArr$values);
            Companion = new a(null);
            Kind[] kindArrValues = values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(kindArrValues.length), 16));
            for (Kind kind : kindArrValues) {
                linkedHashMap.put(Integer.valueOf(kind.id), kind);
            }
            entryById = linkedHashMap;
        }

        private Kind(String str, int i10, int i11) {
            this.id = i11;
        }

        public static final Kind getById(int i10) {
            return Companion.a(i10);
        }

        public static Kind valueOf(String str) {
            return (Kind) Enum.valueOf(Kind.class, str);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }
    }

    public KotlinClassHeader(Kind kind, C4019c metadataVersion, String[] strArr, String[] strArr2, String[] strArr3, String str, int i10, String str2, byte[] bArr) {
        p.i(kind, "kind");
        p.i(metadataVersion, "metadataVersion");
        this.f35203a = kind;
        this.f35204b = metadataVersion;
        this.f35205c = strArr;
        this.f35206d = strArr2;
        this.f35207e = strArr3;
        this.f35208f = str;
        this.f35209g = i10;
        this.f35210h = str2;
        this.f35211i = bArr;
    }

    public final String[] a() {
        return this.f35205c;
    }

    public final String[] b() {
        return this.f35206d;
    }

    public final Kind c() {
        return this.f35203a;
    }

    public final C4019c d() {
        return this.f35204b;
    }

    public final String e() {
        String str = this.f35208f;
        if (this.f35203a == Kind.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    public final List<String> f() {
        String[] strArr = this.f35205c;
        if (this.f35203a != Kind.MULTIFILE_CLASS) {
            strArr = null;
        }
        List<String> listD = strArr != null ? C1168p.d(strArr) : null;
        return listD == null ? C1173v.m() : listD;
    }

    public final String[] g() {
        return this.f35207e;
    }

    public final boolean h(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    public final boolean i() {
        return h(this.f35209g, 2);
    }

    public final boolean j() {
        return h(this.f35209g, 16) && !h(this.f35209g, 32);
    }

    public String toString() {
        return this.f35203a + " version=" + this.f35204b;
    }
}

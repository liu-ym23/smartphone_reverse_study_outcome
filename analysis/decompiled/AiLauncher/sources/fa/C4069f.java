package fa;

import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.IndexedValue;
import Z8.Q;
import ea.InterfaceC4020d;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import v9.C5685n;

/* renamed from: fa.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4069f implements InterfaceC4020d {

    /* renamed from: d, reason: collision with root package name */
    public static final a f32586d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final String f32587e;

    /* renamed from: f, reason: collision with root package name */
    public static final List<String> f32588f;

    /* renamed from: g, reason: collision with root package name */
    public static final Map<String, Integer> f32589g;

    /* renamed from: a, reason: collision with root package name */
    public final String[] f32590a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<Integer> f32591b;

    /* renamed from: c, reason: collision with root package name */
    public final List<JvmProtoBuf.StringTableTypes.Record> f32592c;

    /* renamed from: fa.f$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* renamed from: fa.f$b */
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32593a;

        static {
            int[] iArr = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f32593a = iArr;
        }
    }

    static {
        String strA0 = F.A0(C1173v.p('k', 'o', 't', 'l', 'i', 'n'), "", null, null, 0, null, null, 62, null);
        f32587e = strA0;
        List<String> listP = C1173v.p(strA0 + "/Any", strA0 + "/Nothing", strA0 + "/Unit", strA0 + "/Throwable", strA0 + "/Number", strA0 + "/Byte", strA0 + "/Double", strA0 + "/Float", strA0 + "/Int", strA0 + "/Long", strA0 + "/Short", strA0 + "/Boolean", strA0 + "/Char", strA0 + "/CharSequence", strA0 + "/String", strA0 + "/Comparable", strA0 + "/Enum", strA0 + "/Array", strA0 + "/ByteArray", strA0 + "/DoubleArray", strA0 + "/FloatArray", strA0 + "/IntArray", strA0 + "/LongArray", strA0 + "/ShortArray", strA0 + "/BooleanArray", strA0 + "/CharArray", strA0 + "/Cloneable", strA0 + "/Annotation", strA0 + "/collections/Iterable", strA0 + "/collections/MutableIterable", strA0 + "/collections/Collection", strA0 + "/collections/MutableCollection", strA0 + "/collections/List", strA0 + "/collections/MutableList", strA0 + "/collections/Set", strA0 + "/collections/MutableSet", strA0 + "/collections/Map", strA0 + "/collections/MutableMap", strA0 + "/collections/Map.Entry", strA0 + "/collections/MutableMap.MutableEntry", strA0 + "/collections/Iterator", strA0 + "/collections/MutableIterator", strA0 + "/collections/ListIterator", strA0 + "/collections/MutableListIterator");
        f32588f = listP;
        Iterable<IndexedValue> iterableU1 = F.u1(listP);
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(iterableU1, 10)), 16));
        for (IndexedValue indexedValue : iterableU1) {
            linkedHashMap.put((String) indexedValue.d(), Integer.valueOf(indexedValue.c()));
        }
        f32589g = linkedHashMap;
    }

    public C4069f(String[] strings, Set<Integer> localNameIndices, List<JvmProtoBuf.StringTableTypes.Record> records) {
        p.i(strings, "strings");
        p.i(localNameIndices, "localNameIndices");
        p.i(records, "records");
        this.f32590a = strings;
        this.f32591b = localNameIndices;
        this.f32592c = records;
    }

    @Override // ea.InterfaceC4020d
    public boolean a(int i10) {
        return this.f32591b.contains(Integer.valueOf(i10));
    }

    @Override // ea.InterfaceC4020d
    public String b(int i10) {
        return getString(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    @Override // ea.InterfaceC4020d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getString(int r14) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fa.C4069f.getString(int):java.lang.String");
    }
}

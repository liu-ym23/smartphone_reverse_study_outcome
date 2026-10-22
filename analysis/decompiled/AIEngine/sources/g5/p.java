package g5;

import androidx.datastore.preferences.protobuf.b1;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p {
    public static final g5.t A;
    public static final u B;

    /* renamed from: a, reason: collision with root package name */
    public static final g5.r f9035a = new g5.r(Class.class, new d5.h(new k(), 1));

    /* renamed from: b, reason: collision with root package name */
    public static final g5.r f9036b = new g5.r(BitSet.class, new d5.h(new v(), 1));

    /* renamed from: c, reason: collision with root package name */
    public static final x f9037c;

    /* renamed from: d, reason: collision with root package name */
    public static final g5.s f9038d;

    /* renamed from: e, reason: collision with root package name */
    public static final g5.s f9039e;

    /* renamed from: f, reason: collision with root package name */
    public static final g5.s f9040f;

    /* renamed from: g, reason: collision with root package name */
    public static final g5.s f9041g;
    public static final g5.r h;

    /* renamed from: i, reason: collision with root package name */
    public static final g5.r f9042i;

    /* renamed from: j, reason: collision with root package name */
    public static final g5.r f9043j;

    /* renamed from: k, reason: collision with root package name */
    public static final b f9044k;

    /* renamed from: l, reason: collision with root package name */
    public static final g5.s f9045l;

    /* renamed from: m, reason: collision with root package name */
    public static final g f9046m;

    /* renamed from: n, reason: collision with root package name */
    public static final h f9047n;

    /* renamed from: o, reason: collision with root package name */
    public static final i f9048o;

    /* renamed from: p, reason: collision with root package name */
    public static final g5.r f9049p;

    /* renamed from: q, reason: collision with root package name */
    public static final g5.r f9050q;
    public static final g5.r r;

    /* renamed from: s, reason: collision with root package name */
    public static final g5.r f9051s;

    /* renamed from: t, reason: collision with root package name */
    public static final g5.r f9052t;

    /* renamed from: u, reason: collision with root package name */
    public static final g5.t f9053u;

    /* renamed from: v, reason: collision with root package name */
    public static final g5.r f9054v;

    /* renamed from: w, reason: collision with root package name */
    public static final g5.r f9055w;

    /* renamed from: x, reason: collision with root package name */
    public static final g5.i f9056x;

    /* renamed from: y, reason: collision with root package name */
    public static final g5.r f9057y;
    public static final t z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends d5.u<AtomicIntegerArray> {
        @Override // d5.u
        public final AtomicIntegerArray a(k5.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.x0()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.J0()));
                } catch (NumberFormatException e10) {
                    throw new JsonSyntaxException(e10);
                }
            }
            aVar.K();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicIntegerArray.set(i10, ((Integer) arrayList.get(i10)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // d5.u
        public final void b(k5.b bVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            bVar.o();
            int length = atomicIntegerArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                bVar.I0(r5.get(i10));
            }
            bVar.K();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a0 extends d5.u<Number> {
        @Override // d5.u
        public final Number a(k5.a aVar) throws IOException {
            if (aVar.R0() == JsonToken.f5478l) {
                aVar.N0();
                return null;
            }
            try {
                return Integer.valueOf(aVar.J0());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // d5.u
        public final void b(k5.b bVar, Number number) throws IOException {
            if (number == null) {
                bVar.c0();
            } else {
                bVar.I0(r4.intValue());
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends d5.u<Number> {
        @Override // d5.u
        public final Number a(k5.a aVar) throws IOException {
            if (aVar.R0() == JsonToken.f5478l) {
                aVar.N0();
                return null;
            }
            try {
                return Long.valueOf(aVar.K0());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // d5.u
        public final void b(k5.b bVar, Number number) throws IOException {
            Number number2 = number;
            if (number2 == null) {
                bVar.c0();
            } else {
                bVar.I0(number2.longValue());
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b0 extends d5.u<AtomicInteger> {
        @Override // d5.u
        public final AtomicInteger a(k5.a aVar) {
            try {
                return new AtomicInteger(aVar.J0());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // d5.u
        public final void b(k5.b bVar, AtomicInteger atomicInteger) throws IOException {
            bVar.I0(atomicInteger.get());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c extends d5.u<Number> {
        @Override // d5.u
        public final Number a(k5.a aVar) throws IOException {
            if (aVar.R0() != JsonToken.f5478l) {
                return Float.valueOf((float) aVar.I0());
            }
            aVar.N0();
            return null;
        }

        @Override // d5.u
        public final void b(k5.b bVar, Number number) throws IOException {
            Number numberValueOf = number;
            if (numberValueOf == null) {
                bVar.c0();
                return;
            }
            if (!(numberValueOf instanceof Float)) {
                numberValueOf = Float.valueOf(numberValueOf.floatValue());
            }
            bVar.J0(numberValueOf);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c0 extends d5.u<AtomicBoolean> {
        @Override // d5.u
        public final AtomicBoolean a(k5.a aVar) {
            return new AtomicBoolean(aVar.H0());
        }

        @Override // d5.u
        public final void b(k5.b bVar, AtomicBoolean atomicBoolean) throws IOException {
            bVar.L0(atomicBoolean.get());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d extends d5.u<Number> {
        @Override // d5.u
        public final Number a(k5.a aVar) throws IOException {
            if (aVar.R0() != JsonToken.f5478l) {
                return Double.valueOf(aVar.I0());
            }
            aVar.N0();
            return null;
        }

        @Override // d5.u
        public final void b(k5.b bVar, Number number) throws IOException {
            Number number2 = number;
            if (number2 == null) {
                bVar.c0();
            } else {
                bVar.H0(number2.doubleValue());
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d0<T extends Enum<T>> extends d5.u<T> {

        /* renamed from: a, reason: collision with root package name */
        public final HashMap f9058a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final HashMap f9059b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        public final HashMap f9060c = new HashMap();

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements PrivilegedAction<Field[]> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Class f9061a;

            public a(Class cls) {
                this.f9061a = cls;
            }

            @Override // java.security.PrivilegedAction
            public final Field[] run() throws SecurityException {
                Field[] declaredFields = this.f9061a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public d0(Class<T> cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(cls))) {
                    Enum r42 = (Enum) field.get(null);
                    String strName = r42.name();
                    String string = r42.toString();
                    e5.b bVar = (e5.b) field.getAnnotation(e5.b.class);
                    if (bVar != null) {
                        strName = bVar.value();
                        for (String str : bVar.alternate()) {
                            this.f9058a.put(str, r42);
                        }
                    }
                    this.f9058a.put(strName, r42);
                    this.f9059b.put(string, r42);
                    this.f9060c.put(r42, strName);
                }
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // d5.u
        public final Object a(k5.a aVar) throws IOException {
            if (aVar.R0() == JsonToken.f5478l) {
                aVar.N0();
                return null;
            }
            String strP0 = aVar.P0();
            Enum r02 = (Enum) this.f9058a.get(strP0);
            return r02 == null ? (Enum) this.f9059b.get(strP0) : r02;
        }

        @Override // d5.u
        public final void b(k5.b bVar, Object obj) throws IOException {
            Enum r22 = (Enum) obj;
            bVar.K0(r22 == null ? null : (String) this.f9060c.get(r22));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class e extends d5.u<Character> {
        @Override // d5.u
        public final Character a(k5.a aVar) throws IOException {
            if (aVar.R0() == JsonToken.f5478l) {
                aVar.N0();
                return null;
            }
            String strP0 = aVar.P0();
            if (strP0.length() == 1) {
                return Character.valueOf(strP0.charAt(0));
            }
            StringBuilder sbQ = a0.a.q("Expecting character, got: ", strP0, "; at ");
            sbQ.append(aVar.g0());
            throw new JsonSyntaxException(sbQ.toString());
        }

        @Override // d5.u
        public final void b(k5.b bVar, Character ch) throws IOException {
            Character ch2 = ch;
            bVar.K0(ch2 == null ? null : String.valueOf(ch2));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class f extends d5.u<String> {
        @Override // d5.u
        public final String a(k5.a aVar) throws IOException {
            JsonToken jsonTokenR0 = aVar.R0();
            if (jsonTokenR0 != JsonToken.f5478l) {
                return jsonTokenR0 == JsonToken.f5477k ? Boolean.toString(aVar.H0()) : aVar.P0();
            }
            aVar.N0();
            return null;
        }

        @Override // d5.u
        public final void b(k5.b bVar, String str) throws IOException {
            bVar.K0(str);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class g extends d5.u<BigDecimal> {
        @Override // d5.u
        public final BigDecimal a(k5.a aVar) throws IOException {
            if (aVar.R0() == JsonToken.f5478l) {
                aVar.N0();
                return null;
            }
            String strP0 = aVar.P0();
            try {
                return b1.R(strP0);
            } catch (NumberFormatException e10) {
                StringBuilder sbQ = a0.a.q("Failed parsing '", strP0, "' as BigDecimal; at path ");
                sbQ.append(aVar.g0());
                throw new JsonSyntaxException(sbQ.toString(), e10);
            }
        }

        @Override // d5.u
        public final void b(k5.b bVar, BigDecimal bigDecimal) throws IOException {
            bVar.J0(bigDecimal);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class h extends d5.u<BigInteger> {
        @Override // d5.u
        public final BigInteger a(k5.a aVar) throws IOException {
            if (aVar.R0() == JsonToken.f5478l) {
                aVar.N0();
                return null;
            }
            String strP0 = aVar.P0();
            try {
                b1.k(strP0);
                return new BigInteger(strP0);
            } catch (NumberFormatException e10) {
                StringBuilder sbQ = a0.a.q("Failed parsing '", strP0, "' as BigInteger; at path ");
                sbQ.append(aVar.g0());
                throw new JsonSyntaxException(sbQ.toString(), e10);
            }
        }

        @Override // d5.u
        public final void b(k5.b bVar, BigInteger bigInteger) throws IOException {
            bVar.J0(bigInteger);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class i extends d5.u<LazilyParsedNumber> {
        @Override // d5.u
        public final LazilyParsedNumber a(k5.a aVar) throws IOException {
            if (aVar.R0() != JsonToken.f5478l) {
                return new LazilyParsedNumber(aVar.P0());
            }
            aVar.N0();
            return null;
        }

        @Override // d5.u
        public final void b(k5.b bVar, LazilyParsedNumber lazilyParsedNumber) throws IOException {
            bVar.J0(lazilyParsedNumber);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class j extends d5.u<StringBuilder> {
        @Override // d5.u
        public final StringBuilder a(k5.a aVar) throws IOException {
            if (aVar.R0() != JsonToken.f5478l) {
                return new StringBuilder(aVar.P0());
            }
            aVar.N0();
            return null;
        }

        @Override // d5.u
        public final void b(k5.b bVar, StringBuilder sb2) throws IOException {
            StringBuilder sb3 = sb2;
            bVar.K0(sb3 == null ? null : sb3.toString());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class k extends d5.u<Class> {
        @Override // d5.u
        public final Class a(k5.a aVar) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("java-lang-class-unsupported"));
        }

        @Override // d5.u
        public final void b(k5.b bVar, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("java-lang-class-unsupported"));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class l extends d5.u<StringBuffer> {
        @Override // d5.u
        public final StringBuffer a(k5.a aVar) throws IOException {
            if (aVar.R0() != JsonToken.f5478l) {
                return new StringBuffer(aVar.P0());
            }
            aVar.N0();
            return null;
        }

        @Override // d5.u
        public final void b(k5.b bVar, StringBuffer stringBuffer) throws IOException {
            StringBuffer stringBuffer2 = stringBuffer;
            bVar.K0(stringBuffer2 == null ? null : stringBuffer2.toString());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class m extends d5.u<URL> {
        @Override // d5.u
        public final URL a(k5.a aVar) throws IOException {
            if (aVar.R0() == JsonToken.f5478l) {
                aVar.N0();
                return null;
            }
            String strP0 = aVar.P0();
            if (strP0.equals("null")) {
                return null;
            }
            return new URL(strP0);
        }

        @Override // d5.u
        public final void b(k5.b bVar, URL url) throws IOException {
            URL url2 = url;
            bVar.K0(url2 == null ? null : url2.toExternalForm());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class n extends d5.u<URI> {
        @Override // d5.u
        public final URI a(k5.a aVar) throws IOException {
            if (aVar.R0() == JsonToken.f5478l) {
                aVar.N0();
                return null;
            }
            try {
                String strP0 = aVar.P0();
                if (strP0.equals("null")) {
                    return null;
                }
                return new URI(strP0);
            } catch (URISyntaxException e10) {
                throw new JsonIOException(e10);
            }
        }

        @Override // d5.u
        public final void b(k5.b bVar, URI uri) throws IOException {
            URI uri2 = uri;
            bVar.K0(uri2 == null ? null : uri2.toASCIIString());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class o extends d5.u<InetAddress> {
        @Override // d5.u
        public final InetAddress a(k5.a aVar) throws IOException {
            if (aVar.R0() != JsonToken.f5478l) {
                return InetAddress.getByName(aVar.P0());
            }
            aVar.N0();
            return null;
        }

        @Override // d5.u
        public final void b(k5.b bVar, InetAddress inetAddress) throws IOException {
            InetAddress inetAddress2 = inetAddress;
            bVar.K0(inetAddress2 == null ? null : inetAddress2.getHostAddress());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: g5.p$p, reason: collision with other inner class name */
    public class C0085p extends d5.u<UUID> {
        @Override // d5.u
        public final UUID a(k5.a aVar) throws IOException {
            if (aVar.R0() == JsonToken.f5478l) {
                aVar.N0();
                return null;
            }
            String strP0 = aVar.P0();
            try {
                return UUID.fromString(strP0);
            } catch (IllegalArgumentException e10) {
                StringBuilder sbQ = a0.a.q("Failed parsing '", strP0, "' as UUID; at path ");
                sbQ.append(aVar.g0());
                throw new JsonSyntaxException(sbQ.toString(), e10);
            }
        }

        @Override // d5.u
        public final void b(k5.b bVar, UUID uuid) throws IOException {
            UUID uuid2 = uuid;
            bVar.K0(uuid2 == null ? null : uuid2.toString());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class q extends d5.u<Currency> {
        @Override // d5.u
        public final Currency a(k5.a aVar) throws IOException {
            String strP0 = aVar.P0();
            try {
                return Currency.getInstance(strP0);
            } catch (IllegalArgumentException e10) {
                StringBuilder sbQ = a0.a.q("Failed parsing '", strP0, "' as Currency; at path ");
                sbQ.append(aVar.g0());
                throw new JsonSyntaxException(sbQ.toString(), e10);
            }
        }

        @Override // d5.u
        public final void b(k5.b bVar, Currency currency) throws IOException {
            bVar.K0(currency.getCurrencyCode());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class r extends d5.u<Calendar> {
        @Override // d5.u
        public final Calendar a(k5.a aVar) throws IOException, NumberFormatException {
            int iJ0;
            if (aVar.R0() == JsonToken.f5478l) {
                aVar.N0();
                return null;
            }
            aVar.o();
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (aVar.R0() != JsonToken.f5474d) {
                String strL0 = aVar.L0();
                iJ0 = aVar.J0();
                strL0.getClass();
                switch (strL0) {
                    case "dayOfMonth":
                        i12 = iJ0;
                        break;
                    case "minute":
                        i14 = iJ0;
                        break;
                    case "second":
                        i15 = iJ0;
                        break;
                    case "year":
                        i10 = iJ0;
                        break;
                    case "month":
                        i11 = iJ0;
                        break;
                    case "hourOfDay":
                        i13 = iJ0;
                        break;
                }
            }
            aVar.P();
            return new GregorianCalendar(i10, i11, i12, i13, i14, i15);
        }

        @Override // d5.u
        public final void b(k5.b bVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                bVar.c0();
                return;
            }
            bVar.w();
            bVar.Q("year");
            bVar.I0(r4.get(1));
            bVar.Q("month");
            bVar.I0(r4.get(2));
            bVar.Q("dayOfMonth");
            bVar.I0(r4.get(5));
            bVar.Q("hourOfDay");
            bVar.I0(r4.get(11));
            bVar.Q("minute");
            bVar.I0(r4.get(12));
            bVar.Q("second");
            bVar.I0(r4.get(13));
            bVar.P();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class s extends d5.u<Locale> {
        @Override // d5.u
        public final Locale a(k5.a aVar) throws IOException {
            if (aVar.R0() == JsonToken.f5478l) {
                aVar.N0();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.P0(), "_");
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
        }

        @Override // d5.u
        public final void b(k5.b bVar, Locale locale) throws IOException {
            Locale locale2 = locale;
            bVar.K0(locale2 == null ? null : locale2.toString());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class t extends d5.u<d5.o> {
        public static d5.o c(k5.a aVar, JsonToken jsonToken) throws IOException {
            int iOrdinal = jsonToken.ordinal();
            if (iOrdinal == 5) {
                return new d5.r(aVar.P0());
            }
            if (iOrdinal == 6) {
                return new d5.r(new LazilyParsedNumber(aVar.P0()));
            }
            if (iOrdinal == 7) {
                return new d5.r(Boolean.valueOf(aVar.H0()));
            }
            if (iOrdinal == 8) {
                aVar.N0();
                return d5.p.f8382a;
            }
            throw new IllegalStateException("Unexpected token: " + jsonToken);
        }

        public static void d(d5.o oVar, k5.b bVar) {
            if (oVar == null || (oVar instanceof d5.p)) {
                bVar.c0();
                return;
            }
            if (oVar instanceof d5.r) {
                d5.r rVarD = oVar.d();
                Serializable serializable = rVarD.f8384a;
                if (serializable instanceof Number) {
                    bVar.J0(rVarD.i());
                    return;
                } else if (serializable instanceof Boolean) {
                    bVar.L0(rVarD.a());
                    return;
                } else {
                    bVar.K0(rVarD.f());
                    return;
                }
            }
            boolean z = oVar instanceof d5.l;
            if (!z) {
                if (!(oVar instanceof d5.q)) {
                    throw new IllegalArgumentException("Couldn't write " + oVar.getClass());
                }
                bVar.w();
                Iterator it = ((LinkedTreeMap.b) oVar.c().f8383a.entrySet()).iterator();
                while (((LinkedTreeMap.d) it).hasNext()) {
                    Map.Entry entryA = ((LinkedTreeMap.b.a) it).a();
                    bVar.Q((String) entryA.getKey());
                    d((d5.o) entryA.getValue(), bVar);
                }
                bVar.P();
                return;
            }
            bVar.o();
            if (!z) {
                throw new IllegalStateException("Not a JSON Array: " + oVar);
            }
            ArrayList<d5.o> arrayList = ((d5.l) oVar).f8381a;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                d5.o oVar2 = arrayList.get(i10);
                i10++;
                d(oVar2, bVar);
            }
            bVar.K();
        }

        @Override // d5.u
        public final d5.o a(k5.a aVar) throws IOException {
            d5.o lVar;
            d5.o lVar2;
            if (aVar instanceof g5.e) {
                g5.e eVar = (g5.e) aVar;
                JsonToken jsonTokenR0 = eVar.R0();
                if (jsonTokenR0 != JsonToken.f5475e && jsonTokenR0 != JsonToken.f5472b && jsonTokenR0 != JsonToken.f5474d && jsonTokenR0 != JsonToken.f5479m) {
                    d5.o oVar = (d5.o) eVar.f1();
                    eVar.Y0();
                    return oVar;
                }
                throw new IllegalStateException("Unexpected " + jsonTokenR0 + " when reading a JsonElement.");
            }
            JsonToken jsonTokenR02 = aVar.R0();
            int iOrdinal = jsonTokenR02.ordinal();
            if (iOrdinal == 0) {
                aVar.a();
                lVar = new d5.l();
            } else if (iOrdinal != 2) {
                lVar = null;
            } else {
                aVar.o();
                lVar = new d5.q();
            }
            if (lVar == null) {
                return c(aVar, jsonTokenR02);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (aVar.x0()) {
                    String strL0 = lVar instanceof d5.q ? aVar.L0() : null;
                    JsonToken jsonTokenR03 = aVar.R0();
                    int iOrdinal2 = jsonTokenR03.ordinal();
                    if (iOrdinal2 == 0) {
                        aVar.a();
                        lVar2 = new d5.l();
                    } else if (iOrdinal2 != 2) {
                        lVar2 = null;
                    } else {
                        aVar.o();
                        lVar2 = new d5.q();
                    }
                    boolean z = lVar2 != null;
                    if (lVar2 == null) {
                        lVar2 = c(aVar, jsonTokenR03);
                    }
                    if (lVar instanceof d5.l) {
                        ((d5.l) lVar).f8381a.add(lVar2 == null ? d5.p.f8382a : lVar2);
                    } else {
                        ((d5.q) lVar).f8383a.put(strL0, lVar2 == null ? d5.p.f8382a : lVar2);
                    }
                    if (z) {
                        arrayDeque.addLast(lVar);
                        lVar = lVar2;
                    }
                } else {
                    if (lVar instanceof d5.l) {
                        aVar.K();
                    } else {
                        aVar.P();
                    }
                    if (arrayDeque.isEmpty()) {
                        return lVar;
                    }
                    lVar = (d5.o) arrayDeque.removeLast();
                }
            }
        }

        @Override // d5.u
        public final /* bridge */ /* synthetic */ void b(k5.b bVar, d5.o oVar) {
            d(oVar, bVar);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class u implements d5.v {
        @Override // d5.v
        public final <T> d5.u<T> b(d5.i iVar, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new d0(rawType);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class v extends d5.u<BitSet> {
        @Override // d5.u
        public final BitSet a(k5.a aVar) throws IOException, NumberFormatException {
            boolean zH0;
            BitSet bitSet = new BitSet();
            aVar.a();
            JsonToken jsonTokenR0 = aVar.R0();
            int i10 = 0;
            while (jsonTokenR0 != JsonToken.f5472b) {
                int iOrdinal = jsonTokenR0.ordinal();
                if (iOrdinal == 5 || iOrdinal == 6) {
                    int iJ0 = aVar.J0();
                    if (iJ0 == 0) {
                        zH0 = false;
                    } else {
                        if (iJ0 != 1) {
                            StringBuilder sbK = com.stepos.core.ota.d.k(iJ0, "Invalid bitset value ", ", expected 0 or 1; at path ");
                            sbK.append(aVar.g0());
                            throw new JsonSyntaxException(sbK.toString());
                        }
                        zH0 = true;
                    }
                } else {
                    if (iOrdinal != 7) {
                        throw new JsonSyntaxException("Invalid bitset value type: " + jsonTokenR0 + "; at path " + aVar.S());
                    }
                    zH0 = aVar.H0();
                }
                if (zH0) {
                    bitSet.set(i10);
                }
                i10++;
                jsonTokenR0 = aVar.R0();
            }
            aVar.K();
            return bitSet;
        }

        @Override // d5.u
        public final void b(k5.b bVar, BitSet bitSet) throws IOException {
            BitSet bitSet2 = bitSet;
            bVar.o();
            int length = bitSet2.length();
            for (int i10 = 0; i10 < length; i10++) {
                bVar.I0(bitSet2.get(i10) ? 1L : 0L);
            }
            bVar.K();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class w extends d5.u<Boolean> {
        @Override // d5.u
        public final Boolean a(k5.a aVar) throws IOException {
            JsonToken jsonTokenR0 = aVar.R0();
            if (jsonTokenR0 != JsonToken.f5478l) {
                return jsonTokenR0 == JsonToken.h ? Boolean.valueOf(Boolean.parseBoolean(aVar.P0())) : Boolean.valueOf(aVar.H0());
            }
            aVar.N0();
            return null;
        }

        @Override // d5.u
        public final void b(k5.b bVar, Boolean bool) throws IOException {
            Boolean bool2 = bool;
            if (bool2 == null) {
                bVar.c0();
                return;
            }
            bVar.M0();
            bVar.a();
            bVar.f9936a.write(bool2.booleanValue() ? "true" : "false");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class x extends d5.u<Boolean> {
        @Override // d5.u
        public final Boolean a(k5.a aVar) throws IOException {
            if (aVar.R0() != JsonToken.f5478l) {
                return Boolean.valueOf(aVar.P0());
            }
            aVar.N0();
            return null;
        }

        @Override // d5.u
        public final void b(k5.b bVar, Boolean bool) throws IOException {
            Boolean bool2 = bool;
            bVar.K0(bool2 == null ? "null" : bool2.toString());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class y extends d5.u<Number> {
        @Override // d5.u
        public final Number a(k5.a aVar) throws IOException {
            if (aVar.R0() == JsonToken.f5478l) {
                aVar.N0();
                return null;
            }
            try {
                int iJ0 = aVar.J0();
                if (iJ0 <= 255 && iJ0 >= -128) {
                    return Byte.valueOf((byte) iJ0);
                }
                StringBuilder sbK = com.stepos.core.ota.d.k(iJ0, "Lossy conversion from ", " to byte; at path ");
                sbK.append(aVar.g0());
                throw new JsonSyntaxException(sbK.toString());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // d5.u
        public final void b(k5.b bVar, Number number) throws IOException {
            if (number == null) {
                bVar.c0();
            } else {
                bVar.I0(r4.byteValue());
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class z extends d5.u<Number> {
        @Override // d5.u
        public final Number a(k5.a aVar) throws IOException {
            if (aVar.R0() == JsonToken.f5478l) {
                aVar.N0();
                return null;
            }
            try {
                int iJ0 = aVar.J0();
                if (iJ0 <= 65535 && iJ0 >= -32768) {
                    return Short.valueOf((short) iJ0);
                }
                StringBuilder sbK = com.stepos.core.ota.d.k(iJ0, "Lossy conversion from ", " to short; at path ");
                sbK.append(aVar.g0());
                throw new JsonSyntaxException(sbK.toString());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // d5.u
        public final void b(k5.b bVar, Number number) throws IOException {
            if (number == null) {
                bVar.c0();
            } else {
                bVar.I0(r4.shortValue());
            }
        }
    }

    static {
        w wVar = new w();
        f9037c = new x();
        f9038d = new g5.s(Boolean.TYPE, Boolean.class, wVar);
        f9039e = new g5.s(Byte.TYPE, Byte.class, new y());
        f9040f = new g5.s(Short.TYPE, Short.class, new z());
        f9041g = new g5.s(Integer.TYPE, Integer.class, new a0());
        h = new g5.r(AtomicInteger.class, new d5.h(new b0(), 1));
        f9042i = new g5.r(AtomicBoolean.class, new d5.h(new c0(), 1));
        f9043j = new g5.r(AtomicIntegerArray.class, new d5.h(new a(), 1));
        f9044k = new b();
        new c();
        new d();
        f9045l = new g5.s(Character.TYPE, Character.class, new e());
        f fVar = new f();
        f9046m = new g();
        f9047n = new h();
        f9048o = new i();
        f9049p = new g5.r(String.class, fVar);
        f9050q = new g5.r(StringBuilder.class, new j());
        r = new g5.r(StringBuffer.class, new l());
        f9051s = new g5.r(URL.class, new m());
        f9052t = new g5.r(URI.class, new n());
        f9053u = new g5.t(InetAddress.class, new o());
        f9054v = new g5.r(UUID.class, new C0085p());
        f9055w = new g5.r(Currency.class, new d5.h(new q(), 1));
        f9056x = new g5.i(new r(), 1);
        f9057y = new g5.r(Locale.class, new s());
        t tVar = new t();
        z = tVar;
        A = new g5.t(d5.o.class, tVar);
        B = new u();
    }
}

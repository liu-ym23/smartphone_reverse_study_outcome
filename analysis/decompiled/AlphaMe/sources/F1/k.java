package F1;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.stepos.activeview.databinding.Constants;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: classes.dex */
public final class k extends A {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f434a;

    public k(int i4) {
        this.f434a = i4;
    }

    public static p f(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        int i4 = H1.x.f772a[jsonToken.ordinal()];
        if (i4 == 1) {
            return new t(new G1.j(jsonReader.nextString()));
        }
        if (i4 == 2) {
            return new t(jsonReader.nextString());
        }
        if (i4 == 3) {
            return new t(Boolean.valueOf(jsonReader.nextBoolean()));
        }
        if (i4 == 6) {
            jsonReader.nextNull();
            return r.f449a;
        }
        throw new IllegalStateException("Unexpected token: " + jsonToken);
    }

    public static p g(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        int i4 = H1.x.f772a[jsonToken.ordinal()];
        if (i4 == 4) {
            jsonReader.beginArray();
            return new o();
        }
        if (i4 != 5) {
            return null;
        }
        jsonReader.beginObject();
        return new s();
    }

    public static void h(p pVar, JsonWriter jsonWriter) throws IOException {
        if (pVar == null || (pVar instanceof r)) {
            jsonWriter.nullValue();
            return;
        }
        boolean z4 = pVar instanceof t;
        if (z4) {
            if (!z4) {
                throw new IllegalStateException("Not a JSON Primitive: " + pVar);
            }
            t tVar = (t) pVar;
            Serializable serializable = tVar.f451a;
            if (serializable instanceof Number) {
                jsonWriter.value(tVar.c());
                return;
            } else if (serializable instanceof Boolean) {
                jsonWriter.value(serializable instanceof Boolean ? ((Boolean) serializable).booleanValue() : Boolean.parseBoolean(tVar.a()));
                return;
            } else {
                jsonWriter.value(tVar.a());
                return;
            }
        }
        boolean z5 = pVar instanceof o;
        if (z5) {
            jsonWriter.beginArray();
            if (!z5) {
                throw new IllegalStateException("Not a JSON Array: " + pVar);
            }
            Iterator it = ((o) pVar).f448a.iterator();
            while (it.hasNext()) {
                h((p) it.next(), jsonWriter);
            }
            jsonWriter.endArray();
            return;
        }
        boolean z6 = pVar instanceof s;
        if (!z6) {
            throw new IllegalArgumentException("Couldn't write " + pVar.getClass());
        }
        jsonWriter.beginObject();
        if (!z6) {
            throw new IllegalStateException("Not a JSON Object: " + pVar);
        }
        Iterator it2 = ((G1.l) ((s) pVar).f450a.entrySet()).iterator();
        while (((G1.m) it2).hasNext()) {
            Map.Entry entry = (Map.Entry) ((G1.k) it2).next();
            jsonWriter.name((String) entry.getKey());
            h((p) entry.getValue(), jsonWriter);
        }
        jsonWriter.endObject();
    }

    @Override // F1.A
    public final Object b(JsonReader jsonReader) throws IOException, NumberFormatException {
        int i4 = 0;
        switch (this.f434a) {
            case 0:
                return e(jsonReader);
            case 1:
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    try {
                        arrayList.add(Integer.valueOf(jsonReader.nextInt()));
                    } catch (NumberFormatException e4) {
                        throw new q(5, e4);
                    }
                }
                jsonReader.endArray();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                while (i4 < size) {
                    atomicIntegerArray.set(i4, ((Integer) arrayList.get(i4)).intValue());
                    i4++;
                }
                return atomicIntegerArray;
            case 2:
                return e(jsonReader);
            case 3:
                return e(jsonReader);
            case 4:
                return e(jsonReader);
            case 5:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String strNextString = jsonReader.nextString();
                if (strNextString.length() == 1) {
                    return Character.valueOf(strNextString.charAt(0));
                }
                StringBuilder sbW = B0.g.w("Expecting character, got: ", strNextString, "; at ");
                sbW.append(jsonReader.getPreviousPath());
                throw new q(sbW.toString(), 5);
            case 6:
                JsonToken jsonTokenPeek = jsonReader.peek();
                if (jsonTokenPeek != JsonToken.NULL) {
                    return jsonTokenPeek == JsonToken.BOOLEAN ? Boolean.toString(jsonReader.nextBoolean()) : jsonReader.nextString();
                }
                jsonReader.nextNull();
                return null;
            case 7:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String strNextString2 = jsonReader.nextString();
                try {
                    return new BigDecimal(strNextString2);
                } catch (NumberFormatException e5) {
                    StringBuilder sbW2 = B0.g.w("Failed parsing '", strNextString2, "' as BigDecimal; at path ");
                    sbW2.append(jsonReader.getPreviousPath());
                    throw new q(sbW2.toString(), 5, e5);
                }
            case 8:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String strNextString3 = jsonReader.nextString();
                try {
                    return new BigInteger(strNextString3);
                } catch (NumberFormatException e6) {
                    StringBuilder sbW3 = B0.g.w("Failed parsing '", strNextString3, "' as BigInteger; at path ");
                    sbW3.append(jsonReader.getPreviousPath());
                    throw new q(sbW3.toString(), 5, e6);
                }
            case 9:
                if (jsonReader.peek() != JsonToken.NULL) {
                    return new G1.j(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
            case 10:
                if (jsonReader.peek() != JsonToken.NULL) {
                    return new StringBuilder(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
            case 11:
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            case 12:
                if (jsonReader.peek() != JsonToken.NULL) {
                    return new StringBuffer(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
            case 13:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String strNextString4 = jsonReader.nextString();
                if ("null".equals(strNextString4)) {
                    return null;
                }
                return new URL(strNextString4);
            case 14:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    String strNextString5 = jsonReader.nextString();
                    if ("null".equals(strNextString5)) {
                        return null;
                    }
                    return new URI(strNextString5);
                } catch (URISyntaxException e7) {
                    throw new q(5, e7);
                }
            case 15:
                if (jsonReader.peek() != JsonToken.NULL) {
                    return InetAddress.getByName(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
            case 16:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String strNextString6 = jsonReader.nextString();
                try {
                    return UUID.fromString(strNextString6);
                } catch (IllegalArgumentException e8) {
                    StringBuilder sbW4 = B0.g.w("Failed parsing '", strNextString6, "' as UUID; at path ");
                    sbW4.append(jsonReader.getPreviousPath());
                    throw new q(sbW4.toString(), 5, e8);
                }
            case 17:
                String strNextString7 = jsonReader.nextString();
                try {
                    return Currency.getInstance(strNextString7);
                } catch (IllegalArgumentException e9) {
                    StringBuilder sbW5 = B0.g.w("Failed parsing '", strNextString7, "' as Currency; at path ");
                    sbW5.append(jsonReader.getPreviousPath());
                    throw new q(sbW5.toString(), 5, e9);
                }
            case 18:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                jsonReader.beginObject();
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                while (jsonReader.peek() != JsonToken.END_OBJECT) {
                    String strNextName = jsonReader.nextName();
                    int iNextInt = jsonReader.nextInt();
                    if ("year".equals(strNextName)) {
                        i5 = iNextInt;
                    } else if (Constants.DEF_VAR_MONTH.equals(strNextName)) {
                        i6 = iNextInt;
                    } else if ("dayOfMonth".equals(strNextName)) {
                        i7 = iNextInt;
                    } else if ("hourOfDay".equals(strNextName)) {
                        i8 = iNextInt;
                    } else if (Constants.DEF_VAR_MINUTE.equals(strNextName)) {
                        i9 = iNextInt;
                    } else if (Constants.DEF_VAR_SECOND.equals(strNextName)) {
                        i10 = iNextInt;
                    }
                }
                jsonReader.endObject();
                return new GregorianCalendar(i5, i6, i7, i8, i9, i10);
            case 19:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), "_");
                String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
            case 20:
                JsonToken jsonTokenPeek2 = jsonReader.peek();
                p pVarG = g(jsonReader, jsonTokenPeek2);
                if (pVarG == null) {
                    return f(jsonReader, jsonTokenPeek2);
                }
                ArrayDeque arrayDeque = new ArrayDeque();
                while (true) {
                    if (jsonReader.hasNext()) {
                        String strNextName2 = pVarG instanceof s ? jsonReader.nextName() : null;
                        JsonToken jsonTokenPeek3 = jsonReader.peek();
                        p pVarG2 = g(jsonReader, jsonTokenPeek3);
                        boolean z4 = pVarG2 != null;
                        if (pVarG2 == null) {
                            pVarG2 = f(jsonReader, jsonTokenPeek3);
                        }
                        if (pVarG instanceof o) {
                            ((o) pVarG).f448a.add(pVarG2);
                        } else {
                            ((s) pVarG).f450a.put(strNextName2, pVarG2);
                        }
                        if (z4) {
                            arrayDeque.addLast(pVarG);
                            pVarG = pVarG2;
                        }
                    } else {
                        if (pVarG instanceof o) {
                            jsonReader.endArray();
                        } else {
                            jsonReader.endObject();
                        }
                        if (arrayDeque.isEmpty()) {
                            return pVarG;
                        }
                        pVarG = (p) arrayDeque.removeLast();
                    }
                }
            case 21:
                BitSet bitSet = new BitSet();
                jsonReader.beginArray();
                JsonToken jsonTokenPeek4 = jsonReader.peek();
                while (jsonTokenPeek4 != JsonToken.END_ARRAY) {
                    int i11 = H1.x.f772a[jsonTokenPeek4.ordinal()];
                    if (i11 == 1 || i11 == 2) {
                        int iNextInt2 = jsonReader.nextInt();
                        if (iNextInt2 != 0) {
                            if (iNextInt2 != 1) {
                                StringBuilder sbT = B0.g.t("Invalid bitset value ", iNextInt2, ", expected 0 or 1; at path ");
                                sbT.append(jsonReader.getPreviousPath());
                                throw new q(sbT.toString(), 5);
                            }
                            bitSet.set(i4);
                        } else {
                            continue;
                        }
                    } else {
                        if (i11 != 3) {
                            throw new q("Invalid bitset value type: " + jsonTokenPeek4 + "; at path " + jsonReader.getPath(), 5);
                        }
                        if (jsonReader.nextBoolean()) {
                            bitSet.set(i4);
                        }
                    }
                    i4++;
                    jsonTokenPeek4 = jsonReader.peek();
                }
                jsonReader.endArray();
                return bitSet;
            case 22:
                return d(jsonReader);
            case 23:
                return d(jsonReader);
            case 24:
                return e(jsonReader);
            case 25:
                return e(jsonReader);
            case 26:
                return e(jsonReader);
            case 27:
                try {
                    return new AtomicInteger(jsonReader.nextInt());
                } catch (NumberFormatException e10) {
                    throw new q(5, e10);
                }
            default:
                return new AtomicBoolean(jsonReader.nextBoolean());
        }
    }

    @Override // F1.A
    public final void c(JsonWriter jsonWriter, Object obj) {
        int i4 = this.f434a;
        int i5 = 0;
        switch (i4) {
            case 0:
                i(jsonWriter, (Number) obj);
                return;
            case 1:
                jsonWriter.beginArray();
                int length = ((AtomicIntegerArray) obj).length();
                while (i5 < length) {
                    jsonWriter.value(r6.get(i5));
                    i5++;
                }
                jsonWriter.endArray();
                return;
            case 2:
                i(jsonWriter, (Number) obj);
                return;
            case 3:
                i(jsonWriter, (Number) obj);
                return;
            case 4:
                i(jsonWriter, (Number) obj);
                return;
            case 5:
                Character ch2 = (Character) obj;
                jsonWriter.value(ch2 != null ? String.valueOf(ch2) : null);
                return;
            case 6:
                jsonWriter.value((String) obj);
                return;
            case 7:
                jsonWriter.value((BigDecimal) obj);
                return;
            case 8:
                jsonWriter.value((BigInteger) obj);
                return;
            case 9:
                jsonWriter.value((G1.j) obj);
                return;
            case 10:
                StringBuilder sb = (StringBuilder) obj;
                jsonWriter.value(sb != null ? sb.toString() : null);
                return;
            case 11:
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + ((Class) obj).getName() + ". Forgot to register a type adapter?");
            case 12:
                StringBuffer stringBuffer = (StringBuffer) obj;
                jsonWriter.value(stringBuffer != null ? stringBuffer.toString() : null);
                return;
            case 13:
                URL url = (URL) obj;
                jsonWriter.value(url != null ? url.toExternalForm() : null);
                return;
            case 14:
                URI uri = (URI) obj;
                jsonWriter.value(uri != null ? uri.toASCIIString() : null);
                return;
            case 15:
                InetAddress inetAddress = (InetAddress) obj;
                jsonWriter.value(inetAddress != null ? inetAddress.getHostAddress() : null);
                return;
            case 16:
                UUID uuid = (UUID) obj;
                jsonWriter.value(uuid != null ? uuid.toString() : null);
                return;
            case 17:
                jsonWriter.value(((Currency) obj).getCurrencyCode());
                return;
            case 18:
                if (((Calendar) obj) == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginObject();
                jsonWriter.name("year");
                jsonWriter.value(r6.get(1));
                jsonWriter.name(Constants.DEF_VAR_MONTH);
                jsonWriter.value(r6.get(2));
                jsonWriter.name("dayOfMonth");
                jsonWriter.value(r6.get(5));
                jsonWriter.name("hourOfDay");
                jsonWriter.value(r6.get(11));
                jsonWriter.name(Constants.DEF_VAR_MINUTE);
                jsonWriter.value(r6.get(12));
                jsonWriter.name(Constants.DEF_VAR_SECOND);
                jsonWriter.value(r6.get(13));
                jsonWriter.endObject();
                return;
            case 19:
                Locale locale = (Locale) obj;
                jsonWriter.value(locale != null ? locale.toString() : null);
                return;
            case 20:
                h((p) obj, jsonWriter);
                return;
            case 21:
                BitSet bitSet = (BitSet) obj;
                jsonWriter.beginArray();
                int length2 = bitSet.length();
                while (i5 < length2) {
                    jsonWriter.value(bitSet.get(i5) ? 1L : 0L);
                    i5++;
                }
                jsonWriter.endArray();
                return;
            case 22:
                Boolean bool = (Boolean) obj;
                switch (i4) {
                    case 22:
                        jsonWriter.value(bool);
                        return;
                    default:
                        jsonWriter.value(bool != null ? bool.toString() : "null");
                        return;
                }
            case 23:
                Boolean bool2 = (Boolean) obj;
                switch (i4) {
                    case 22:
                        jsonWriter.value(bool2);
                        return;
                    default:
                        jsonWriter.value(bool2 != null ? bool2.toString() : "null");
                        return;
                }
            case 24:
                i(jsonWriter, (Number) obj);
                return;
            case 25:
                i(jsonWriter, (Number) obj);
                return;
            case 26:
                i(jsonWriter, (Number) obj);
                return;
            case 27:
                jsonWriter.value(((AtomicInteger) obj).get());
                return;
            default:
                jsonWriter.value(((AtomicBoolean) obj).get());
                return;
        }
    }

    public final Boolean d(JsonReader jsonReader) throws IOException {
        switch (this.f434a) {
            case 22:
                JsonToken jsonTokenPeek = jsonReader.peek();
                if (jsonTokenPeek != JsonToken.NULL) {
                    return jsonTokenPeek == JsonToken.STRING ? Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString())) : Boolean.valueOf(jsonReader.nextBoolean());
                }
                jsonReader.nextNull();
                return null;
            default:
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Boolean.valueOf(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
        }
    }

    public final Number e(JsonReader jsonReader) throws IOException {
        switch (this.f434a) {
            case 0:
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Long.valueOf(jsonReader.nextLong());
                }
                jsonReader.nextNull();
                return null;
            case 2:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return Long.valueOf(jsonReader.nextLong());
                } catch (NumberFormatException e4) {
                    throw new q(5, e4);
                }
            case 3:
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Float.valueOf((float) jsonReader.nextDouble());
                }
                jsonReader.nextNull();
                return null;
            case 4:
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Double.valueOf(jsonReader.nextDouble());
                }
                jsonReader.nextNull();
                return null;
            case 24:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    int iNextInt = jsonReader.nextInt();
                    if (iNextInt <= 255 && iNextInt >= -128) {
                        return Byte.valueOf((byte) iNextInt);
                    }
                    StringBuilder sbT = B0.g.t("Lossy conversion from ", iNextInt, " to byte; at path ");
                    sbT.append(jsonReader.getPreviousPath());
                    throw new q(sbT.toString(), 5);
                } catch (NumberFormatException e5) {
                    throw new q(5, e5);
                }
            case 25:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    int iNextInt2 = jsonReader.nextInt();
                    if (iNextInt2 <= 65535 && iNextInt2 >= -32768) {
                        return Short.valueOf((short) iNextInt2);
                    }
                    StringBuilder sbT2 = B0.g.t("Lossy conversion from ", iNextInt2, " to short; at path ");
                    sbT2.append(jsonReader.getPreviousPath());
                    throw new q(sbT2.toString(), 5);
                } catch (NumberFormatException e6) {
                    throw new q(5, e6);
                }
            default:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return Integer.valueOf(jsonReader.nextInt());
                } catch (NumberFormatException e7) {
                    throw new q(5, e7);
                }
        }
    }

    public final void i(JsonWriter jsonWriter, Number number) throws IOException {
        switch (this.f434a) {
            case 0:
                if (number != null) {
                    jsonWriter.value(number.toString());
                    break;
                } else {
                    jsonWriter.nullValue();
                    break;
                }
            case 2:
                if (number != null) {
                    jsonWriter.value(number.longValue());
                    break;
                } else {
                    jsonWriter.nullValue();
                    break;
                }
            case 3:
                if (number != null) {
                    if (!(number instanceof Float)) {
                        number = Float.valueOf(number.floatValue());
                    }
                    jsonWriter.value(number);
                    break;
                } else {
                    jsonWriter.nullValue();
                    break;
                }
            case 4:
                if (number != null) {
                    jsonWriter.value(number.doubleValue());
                    break;
                } else {
                    jsonWriter.nullValue();
                    break;
                }
            case 24:
                if (number != null) {
                    jsonWriter.value(number.byteValue());
                    break;
                } else {
                    jsonWriter.nullValue();
                    break;
                }
            case 25:
                if (number != null) {
                    jsonWriter.value(number.shortValue());
                    break;
                } else {
                    jsonWriter.nullValue();
                    break;
                }
            default:
                if (number != null) {
                    jsonWriter.value(number.intValue());
                    break;
                } else {
                    jsonWriter.nullValue();
                    break;
                }
        }
    }
}

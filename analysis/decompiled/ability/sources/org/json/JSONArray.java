package org.json;

import androidx.constraintlayout.core.dsl.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class JSONArray implements Iterable<Object> {
    private final ArrayList<Object> myArrayList;

    public JSONArray() {
        this.myArrayList = new ArrayList<>();
    }

    private void addAll(Collection<?> collection, boolean z10, int i, JSONParserConfiguration jSONParserConfiguration) {
        ArrayList<Object> arrayList = this.myArrayList;
        arrayList.ensureCapacity(collection.size() + arrayList.size());
        if (z10) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                put(JSONObject.wrap(it.next(), i + 1, jSONParserConfiguration));
            }
        } else {
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                put(it2.next());
            }
        }
    }

    private static JSONException wrongValueFormatException(int i, String str, Object obj, Throwable th) {
        if (obj == null) {
            return new JSONException("JSONArray[" + i + "] is not a " + str + " (null).", th);
        }
        if ((obj instanceof Map) || (obj instanceof Iterable) || (obj instanceof JSONObject)) {
            StringBuilder sbK = a.k(i, "JSONArray[", "] is not a ", str, " (");
            sbK.append(obj.getClass());
            sbK.append(").");
            return new JSONException(sbK.toString(), th);
        }
        StringBuilder sbK2 = a.k(i, "JSONArray[", "] is not a ", str, " (");
        sbK2.append(obj.getClass());
        sbK2.append(" : ");
        sbK2.append(obj);
        sbK2.append(").");
        return new JSONException(sbK2.toString(), th);
    }

    public void clear() {
        this.myArrayList.clear();
    }

    public Object get(int i) throws JSONException {
        Object objOpt = opt(i);
        if (objOpt != null) {
            return objOpt;
        }
        throw new JSONException(androidx.appfunctions.metadata.a.i(i, "JSONArray[", "] not found."));
    }

    public BigDecimal getBigDecimal(int i) throws JSONException {
        Object obj = get(i);
        BigDecimal bigDecimalObjectToBigDecimal = JSONObject.objectToBigDecimal(obj, null);
        if (bigDecimalObjectToBigDecimal != null) {
            return bigDecimalObjectToBigDecimal;
        }
        throw wrongValueFormatException(i, "BigDecimal", obj, null);
    }

    public BigInteger getBigInteger(int i) throws JSONException {
        Object obj = get(i);
        BigInteger bigIntegerObjectToBigInteger = JSONObject.objectToBigInteger(obj, null);
        if (bigIntegerObjectToBigInteger != null) {
            return bigIntegerObjectToBigInteger;
        }
        throw wrongValueFormatException(i, "BigInteger", obj, null);
    }

    public boolean getBoolean(int i) throws JSONException {
        Object obj = get(i);
        if (obj.equals(Boolean.FALSE)) {
            return false;
        }
        boolean z10 = obj instanceof String;
        if (z10 && ((String) obj).equalsIgnoreCase("false")) {
            return false;
        }
        if (obj.equals(Boolean.TRUE)) {
            return true;
        }
        if (z10 && ((String) obj).equalsIgnoreCase("true")) {
            return true;
        }
        throw wrongValueFormatException(i, TypedValues.Custom.S_BOOLEAN, obj, null);
    }

    public double getDouble(int i) throws JSONException {
        Object obj = get(i);
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        try {
            return Double.parseDouble(obj.toString());
        } catch (Exception e) {
            throw wrongValueFormatException(i, "double", obj, e);
        }
    }

    public <E extends Enum<E>> E getEnum(Class<E> cls, int i) throws JSONException {
        E e = (E) optEnum(cls, i);
        if (e != null) {
            return e;
        }
        throw wrongValueFormatException(i, "enum of type " + JSONObject.quote(cls.getSimpleName()), opt(i), null);
    }

    public float getFloat(int i) throws JSONException {
        Object obj = get(i);
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        try {
            return Float.parseFloat(obj.toString());
        } catch (Exception e) {
            throw wrongValueFormatException(i, TypedValues.Custom.S_FLOAT, obj, e);
        }
    }

    public int getInt(int i) throws JSONException {
        Object obj = get(i);
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        try {
            return Integer.parseInt(obj.toString());
        } catch (Exception e) {
            throw wrongValueFormatException(i, "int", obj, e);
        }
    }

    public JSONArray getJSONArray(int i) throws JSONException {
        Object obj = get(i);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        throw wrongValueFormatException(i, "JSONArray", obj, null);
    }

    public JSONObject getJSONObject(int i) throws JSONException {
        Object obj = get(i);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        throw wrongValueFormatException(i, "JSONObject", obj, null);
    }

    public long getLong(int i) throws JSONException {
        Object obj = get(i);
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        try {
            return Long.parseLong(obj.toString());
        } catch (Exception e) {
            throw wrongValueFormatException(i, "long", obj, e);
        }
    }

    public Number getNumber(int i) throws JSONException {
        Object obj = get(i);
        try {
            return obj instanceof Number ? (Number) obj : JSONObject.stringToNumber(obj.toString());
        } catch (Exception e) {
            throw wrongValueFormatException(i, "number", obj, e);
        }
    }

    public String getString(int i) throws JSONException {
        Object obj = get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        throw wrongValueFormatException(i, "String", obj, null);
    }

    public boolean isEmpty() {
        return this.myArrayList.isEmpty();
    }

    public boolean isNull(int i) {
        return JSONObject.NULL.equals(opt(i));
    }

    @Override // java.lang.Iterable
    public Iterator<Object> iterator() {
        return this.myArrayList.iterator();
    }

    public String join(String str) throws JSONException {
        int length = length();
        if (length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(JSONObject.valueToString(this.myArrayList.get(0)));
        for (int i = 1; i < length; i++) {
            sb.append(str);
            sb.append(JSONObject.valueToString(this.myArrayList.get(i)));
        }
        return sb.toString();
    }

    public int length() {
        return this.myArrayList.size();
    }

    public Object opt(int i) {
        if (i < 0 || i >= length()) {
            return null;
        }
        return this.myArrayList.get(i);
    }

    public BigDecimal optBigDecimal(int i, BigDecimal bigDecimal) {
        return JSONObject.objectToBigDecimal(opt(i), bigDecimal);
    }

    public BigInteger optBigInteger(int i, BigInteger bigInteger) {
        return JSONObject.objectToBigInteger(opt(i), bigInteger);
    }

    public boolean optBoolean(int i) {
        return optBoolean(i, false);
    }

    public Boolean optBooleanObject(int i) {
        return optBooleanObject(i, Boolean.FALSE);
    }

    public double optDouble(int i) {
        return optDouble(i, Double.NaN);
    }

    public Double optDoubleObject(int i) {
        return optDoubleObject(i, Double.valueOf(Double.NaN));
    }

    public <E extends Enum<E>> E optEnum(Class<E> cls, int i) {
        return (E) optEnum(cls, i, null);
    }

    public float optFloat(int i) {
        return optFloat(i, Float.NaN);
    }

    public Float optFloatObject(int i) {
        return optFloatObject(i, Float.valueOf(Float.NaN));
    }

    public int optInt(int i) {
        return optInt(i, 0);
    }

    public Integer optIntegerObject(int i) {
        return optIntegerObject(i, 0);
    }

    public JSONArray optJSONArray(int i) {
        return optJSONArray(i, null);
    }

    public JSONObject optJSONObject(int i) {
        return optJSONObject(i, null);
    }

    public long optLong(int i) {
        return optLong(i, 0L);
    }

    public Long optLongObject(int i) {
        return optLongObject(i, 0L);
    }

    public Number optNumber(int i) {
        return optNumber(i, null);
    }

    public Object optQuery(String str) {
        return optQuery(new JSONPointer(str));
    }

    public String optString(int i) {
        return optString(i, "");
    }

    public JSONArray put(boolean z10) {
        return put(z10 ? Boolean.TRUE : Boolean.FALSE);
    }

    public JSONArray putAll(Collection<?> collection) {
        addAll((Iterable<?>) collection, false);
        return this;
    }

    public Object query(String str) {
        return query(new JSONPointer(str));
    }

    public Object remove(int i) {
        if (i < 0 || i >= length()) {
            return null;
        }
        return this.myArrayList.remove(i);
    }

    public boolean similar(Object obj) {
        if (!(obj instanceof JSONArray)) {
            return false;
        }
        int length = length();
        JSONArray jSONArray = (JSONArray) obj;
        if (length != jSONArray.length()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            Object obj2 = this.myArrayList.get(i);
            Object obj3 = jSONArray.myArrayList.get(i);
            if (obj2 != obj3) {
                if (obj2 == null) {
                    return false;
                }
                if (obj2 instanceof JSONObject) {
                    if (!((JSONObject) obj2).similar(obj3)) {
                        return false;
                    }
                } else if (obj2 instanceof JSONArray) {
                    if (!((JSONArray) obj2).similar(obj3)) {
                        return false;
                    }
                } else if ((obj2 instanceof Number) && (obj3 instanceof Number)) {
                    if (!JSONObject.isNumberSimilar((Number) obj2, (Number) obj3)) {
                        return false;
                    }
                } else if ((obj2 instanceof JSONString) && (obj3 instanceof JSONString)) {
                    if (!((JSONString) obj2).toJSONString().equals(((JSONString) obj3).toJSONString())) {
                        return false;
                    }
                } else if (!obj2.equals(obj3)) {
                    return false;
                }
            }
        }
        return true;
    }

    public JSONObject toJSONObject(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.isEmpty() || isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            jSONObject.put(jSONArray.getString(i), opt(i));
        }
        return jSONObject;
    }

    public List<Object> toList() {
        ArrayList arrayList = new ArrayList(this.myArrayList.size());
        Iterator<Object> it = this.myArrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next == null || JSONObject.NULL.equals(next)) {
                arrayList.add(null);
            } else if (next instanceof JSONArray) {
                arrayList.add(((JSONArray) next).toList());
            } else if (next instanceof JSONObject) {
                arrayList.add(((JSONObject) next).toMap());
            } else {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public String toString() {
        try {
            return toString(0);
        } catch (Exception unused) {
            return null;
        }
    }

    public Writer write(Writer writer) throws JSONException {
        return write(writer, 0, 0);
    }

    public boolean optBoolean(int i, boolean z10) {
        try {
            return getBoolean(i);
        } catch (Exception unused) {
            return z10;
        }
    }

    public Boolean optBooleanObject(int i, Boolean bool) {
        try {
            return Boolean.valueOf(getBoolean(i));
        } catch (Exception unused) {
            return bool;
        }
    }

    public double optDouble(int i, double d) {
        Number numberOptNumber = optNumber(i, null);
        return numberOptNumber == null ? d : numberOptNumber.doubleValue();
    }

    public Double optDoubleObject(int i, Double d) {
        Number numberOptNumber = optNumber(i, null);
        return numberOptNumber == null ? d : Double.valueOf(numberOptNumber.doubleValue());
    }

    public <E extends Enum<E>> E optEnum(Class<E> cls, int i, E e) {
        Object objOpt;
        try {
            objOpt = opt(i);
        } catch (IllegalArgumentException | NullPointerException unused) {
        }
        return JSONObject.NULL.equals(objOpt) ? e : cls.isAssignableFrom(objOpt.getClass()) ? (E) objOpt : (E) Enum.valueOf(cls, objOpt.toString());
    }

    public float optFloat(int i, float f) {
        Number numberOptNumber = optNumber(i, null);
        return numberOptNumber == null ? f : numberOptNumber.floatValue();
    }

    public Float optFloatObject(int i, Float f) {
        Number numberOptNumber = optNumber(i, null);
        return numberOptNumber == null ? f : Float.valueOf(numberOptNumber.floatValue());
    }

    public int optInt(int i, int i6) {
        Number numberOptNumber = optNumber(i, null);
        return numberOptNumber == null ? i6 : numberOptNumber.intValue();
    }

    public Integer optIntegerObject(int i, Integer num) {
        Number numberOptNumber = optNumber(i, null);
        return numberOptNumber == null ? num : Integer.valueOf(numberOptNumber.intValue());
    }

    public JSONArray optJSONArray(int i, JSONArray jSONArray) {
        Object objOpt = opt(i);
        return objOpt instanceof JSONArray ? (JSONArray) objOpt : jSONArray;
    }

    public JSONObject optJSONObject(int i, JSONObject jSONObject) {
        Object objOpt = opt(i);
        return objOpt instanceof JSONObject ? (JSONObject) objOpt : jSONObject;
    }

    public long optLong(int i, long j5) {
        Number numberOptNumber = optNumber(i, null);
        return numberOptNumber == null ? j5 : numberOptNumber.longValue();
    }

    public Long optLongObject(int i, Long l) {
        Number numberOptNumber = optNumber(i, null);
        return numberOptNumber == null ? l : Long.valueOf(numberOptNumber.longValue());
    }

    public Number optNumber(int i, Number number) {
        Object objOpt = opt(i);
        if (!JSONObject.NULL.equals(objOpt)) {
            if (objOpt instanceof Number) {
                return (Number) objOpt;
            }
            if (objOpt instanceof String) {
                try {
                    return JSONObject.stringToNumber((String) objOpt);
                } catch (Exception unused) {
                }
            }
        }
        return number;
    }

    public Object optQuery(JSONPointer jSONPointer) {
        try {
            return jSONPointer.queryFrom(this);
        } catch (JSONPointerException unused) {
            return null;
        }
    }

    public String optString(int i, String str) {
        Object objOpt = opt(i);
        return JSONObject.NULL.equals(objOpt) ? str : objOpt.toString();
    }

    public JSONArray put(Collection<?> collection) {
        return put(new JSONArray(collection));
    }

    public JSONArray putAll(Iterable<?> iterable) {
        addAll(iterable, false);
        return this;
    }

    public Object query(JSONPointer jSONPointer) {
        return jSONPointer.queryFrom(this);
    }

    public String toString(int i) throws JSONException {
        return write(new StringWriter(), i, 0).toString();
    }

    public Writer write(Writer writer, int i, int i6) throws JSONException {
        try {
            int length = length();
            writer.write(91);
            int i10 = 0;
            if (length == 1) {
                try {
                    JSONObject.writeValue(writer, this.myArrayList.get(0), i, i6);
                } catch (Exception e) {
                    throw new JSONException("Unable to write JSONArray value at index: 0", e);
                }
            } else if (length != 0) {
                int i11 = i6 + i;
                boolean z10 = false;
                while (i10 < length) {
                    if (z10) {
                        writer.write(44);
                    }
                    if (i > 0) {
                        writer.write(10);
                    }
                    JSONObject.indent(writer, i11);
                    try {
                        JSONObject.writeValue(writer, this.myArrayList.get(i10), i, i11);
                        i10++;
                        z10 = true;
                    } catch (Exception e6) {
                        throw new JSONException("Unable to write JSONArray value at index: " + i10, e6);
                    }
                }
                if (i > 0) {
                    writer.write(10);
                }
                JSONObject.indent(writer, i6);
            }
            writer.write(93);
            return writer;
        } catch (IOException e9) {
            throw new JSONException(e9);
        }
    }

    public JSONArray(JSONTokener jSONTokener) throws JSONException {
        this();
        if (jSONTokener.nextClean() == '[') {
            char cNextClean = jSONTokener.nextClean();
            if (cNextClean == 0) {
                throw jSONTokener.syntaxError("Expected a ',' or ']'");
            }
            if (cNextClean == ']') {
                return;
            }
            jSONTokener.back();
            while (true) {
                if (jSONTokener.nextClean() == ',') {
                    jSONTokener.back();
                    this.myArrayList.add(JSONObject.NULL);
                } else {
                    jSONTokener.back();
                    this.myArrayList.add(jSONTokener.nextValue());
                }
                char cNextClean2 = jSONTokener.nextClean();
                if (cNextClean2 == 0) {
                    throw jSONTokener.syntaxError("Expected a ',' or ']'");
                }
                if (cNextClean2 != ',') {
                    if (cNextClean2 != ']') {
                        throw jSONTokener.syntaxError("Expected a ',' or ']'");
                    }
                    return;
                }
                char cNextClean3 = jSONTokener.nextClean();
                if (cNextClean3 == 0) {
                    throw jSONTokener.syntaxError("Expected a ',' or ']'");
                }
                if (cNextClean3 == ']') {
                    return;
                } else {
                    jSONTokener.back();
                }
            }
        } else {
            throw jSONTokener.syntaxError("A JSONArray text must start with '['");
        }
    }

    public JSONArray put(double d) throws JSONException {
        return put(Double.valueOf(d));
    }

    public JSONArray putAll(JSONArray jSONArray) {
        this.myArrayList.addAll(jSONArray.myArrayList);
        return this;
    }

    public JSONArray put(float f) throws JSONException {
        return put(Float.valueOf(f));
    }

    public JSONArray putAll(Object obj) throws JSONException {
        addAll(obj, false);
        return this;
    }

    public JSONArray put(int i) {
        return put(Integer.valueOf(i));
    }

    private void addAll(Iterable<?> iterable, boolean z10) {
        if (z10) {
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                put(JSONObject.wrap(it.next()));
            }
        } else {
            Iterator<?> it2 = iterable.iterator();
            while (it2.hasNext()) {
                put(it2.next());
            }
        }
    }

    public JSONArray put(long j5) {
        return put(Long.valueOf(j5));
    }

    public JSONArray put(Map<?, ?> map) {
        return put(new JSONObject(map));
    }

    public JSONArray put(Object obj) {
        JSONObject.testValidity(obj);
        this.myArrayList.add(obj);
        return this;
    }

    private void addAll(Object obj, boolean z10) throws JSONException {
        addAll(obj, z10, 0);
    }

    public JSONArray put(int i, boolean z10) throws JSONException {
        return put(i, z10 ? Boolean.TRUE : Boolean.FALSE);
    }

    private void addAll(Object obj, boolean z10, int i) throws JSONException {
        addAll(obj, z10, i, new JSONParserConfiguration());
    }

    public JSONArray put(int i, Collection<?> collection) throws JSONException {
        return put(i, new JSONArray(collection));
    }

    private void addAll(Object obj, boolean z10, int i, JSONParserConfiguration jSONParserConfiguration) throws JSONException {
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            ArrayList<Object> arrayList = this.myArrayList;
            arrayList.ensureCapacity(arrayList.size() + length);
            int i6 = 0;
            if (z10) {
                while (i6 < length) {
                    put(JSONObject.wrap(Array.get(obj, i6), i + 1, jSONParserConfiguration));
                    i6++;
                }
                return;
            } else {
                while (i6 < length) {
                    put(Array.get(obj, i6));
                    i6++;
                }
                return;
            }
        }
        if (obj instanceof JSONArray) {
            this.myArrayList.addAll(((JSONArray) obj).myArrayList);
        } else if (obj instanceof Collection) {
            addAll((Collection) obj, z10, i);
        } else {
            if (obj instanceof Iterable) {
                addAll((Iterable<?>) obj, z10);
                return;
            }
            throw new JSONException("JSONArray initial value should be a string or collection or array.");
        }
    }

    public JSONArray put(int i, double d) throws JSONException {
        return put(i, Double.valueOf(d));
    }

    public JSONArray put(int i, float f) throws JSONException {
        return put(i, Float.valueOf(f));
    }

    public JSONArray put(int i, int i6) throws JSONException {
        return put(i, Integer.valueOf(i6));
    }

    public JSONArray put(int i, long j5) throws JSONException {
        return put(i, Long.valueOf(j5));
    }

    public JSONArray put(int i, Map<?, ?> map) throws JSONException {
        put(i, new JSONObject(map, new JSONParserConfiguration()));
        return this;
    }

    public JSONArray put(int i, Map<?, ?> map, JSONParserConfiguration jSONParserConfiguration) throws JSONException {
        put(i, new JSONObject(map, jSONParserConfiguration));
        return this;
    }

    public JSONArray put(int i, Object obj) throws JSONException {
        if (i >= 0) {
            if (i < length()) {
                JSONObject.testValidity(obj);
                this.myArrayList.set(i, obj);
                return this;
            }
            if (i == length()) {
                return put(obj);
            }
            this.myArrayList.ensureCapacity(i + 1);
            while (i != length()) {
                this.myArrayList.add(JSONObject.NULL);
            }
            return put(obj);
        }
        throw new JSONException(androidx.appfunctions.metadata.a.i(i, "JSONArray[", "] not found."));
    }

    public JSONArray(String str) throws JSONException {
        this(new JSONTokener(str));
    }

    public JSONArray(Collection<?> collection) {
        this(collection, 0, new JSONParserConfiguration());
    }

    public JSONArray(Collection<?> collection, JSONParserConfiguration jSONParserConfiguration) {
        this(collection, 0, jSONParserConfiguration);
    }

    public JSONArray(Collection<?> collection, int i, JSONParserConfiguration jSONParserConfiguration) {
        if (i > jSONParserConfiguration.getMaxNestingDepth()) {
            throw new JSONException("JSONArray has reached recursion depth limit of " + jSONParserConfiguration.getMaxNestingDepth());
        }
        if (collection == null) {
            this.myArrayList = new ArrayList<>();
        } else {
            this.myArrayList = new ArrayList<>(collection.size());
            addAll(collection, true, i, jSONParserConfiguration);
        }
    }

    public JSONArray(Iterable<?> iterable) {
        this();
        if (iterable == null) {
            return;
        }
        addAll(iterable, true);
    }

    public JSONArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            this.myArrayList = new ArrayList<>();
        } else {
            this.myArrayList = new ArrayList<>(jSONArray.myArrayList);
        }
    }

    public JSONArray(Object obj) throws JSONException {
        this();
        if (obj.getClass().isArray()) {
            addAll(obj, true, 0);
            return;
        }
        throw new JSONException("JSONArray initial value should be a string or collection or array.");
    }

    public JSONArray(int i) throws JSONException {
        if (i >= 0) {
            this.myArrayList = new ArrayList<>(i);
            return;
        }
        throw new JSONException("JSONArray initial capacity cannot be negative.");
    }
}

package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes28.dex */
public class EnumDeserializer implements ObjectDeserializer {
    protected final Class<?> enumClass;
    protected long[] enumNameHashCodes;
    protected final Enum[] enums;
    protected final Enum[] ordinalEnums;

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    public EnumDeserializer(Class<?> r210) {
        this.enumClass = r210;
        this.ordinalEnums = (Enum[]) r210.getEnumConstants();
        HashMap r100 = new HashMap();
        int r101 = 0;
    L3:
        Enum[] r102 = this.ordinalEnums;
        if (r101 >= r102.length) goto L41;
        Enum r103 = r102[r101];
        String r104 = r103.name();
        JSONField r105 = null;
        JSONField r106 = (JSONField) TypeUtils.getAnnotation(r210.getField(r104), JSONField.class);     // Catch: Exception -> L50
        if (r106 != null) goto L53;
    L15:
        int r107 = 0;
        long r110 = TypeUtils.fnv1a_64_magic_hashcode;
        long r111 = TypeUtils.fnv1a_64_magic_hashcode;
    L17:
        if (r107 >= r104.length()) goto L24;
        int r112 = r104.charAt(r107);
        long r108 = ((long) r112) ^ r110;
        if (r112 < 65) goto L23;
        if (r112 > 90) goto L23;
        r112 = r112 + 32;
    L23:
        long r109 = r108 * TypeUtils.fnv1a_64_magic_prime;
        r111 = (((long) r112) ^ r111) * TypeUtils.fnv1a_64_magic_prime;
        r107 = r107 + 1;
        r110 = r109;
        goto L17
    L24:
        r100.put(Long.valueOf(r110), r103);
        if (r110 == r111) goto L27;
        r100.put(Long.valueOf(r111), r103);
    L27:
        if (r106 == null) goto L40;
        String[] r113 = r106.alternateNames();
        int r114 = r113.length;
        int r115 = 0;
    L29:
        if (r115 >= r114) goto L40;
        String r116 = r113[r115];
        int r117 = 0;
        long r118 = TypeUtils.fnv1a_64_magic_hashcode;
    L32:
        if (r117 >= r116.length()) goto L34;
        r118 = (r118 ^ ((long) r116.charAt(r117))) * TypeUtils.fnv1a_64_magic_prime;
        r117 = r117 + 1;
        r101 = r101;
        goto L32
    L34:
        int r211 = r101;
        if (r118 == r110) goto L39;
        if (r118 == r111) goto L39;
        r100.put(Long.valueOf(r118), r103);
    L39:
        r115 = r115 + 1;
        r101 = r211;
    L40:
        r101 = r101 + 1;
        goto L3
    L53:
        String r119 = r106.name();     // Catch: Exception -> L13
        if (r119 == null) goto L15;
        if (r119.length() <= 0) goto L15;
        r104 = r119;
    L13:
        r105 = r106;
    L14:
        r106 = r105;
        goto L15
    L41:
        this.enumNameHashCodes = new long[r100.size()];
        Iterator r120 = r100.keySet().iterator();
        int r121 = 0;
    L43:
        if (r120.hasNext() == false) goto L45;
        Long r122 = (Long) r120.next();
        this.enumNameHashCodes[r121] = r122.longValue();
        r121 = r121 + 1;
        goto L43
    L45:
        Arrays.sort(this.enumNameHashCodes);
        this.enums = new Enum[this.enumNameHashCodes.length];
        int r123 = 0;
    L46:
        long[] r124 = this.enumNameHashCodes;
        if (r123 >= r124.length) goto L49;
        Enum r125 = (Enum) r100.get(Long.valueOf(r124[r123]));
        this.enums[r123] = r125;
        r123 = r123 + 1;
        goto L46
    }

    public Enum getEnumByHashCode(long r100) {
        if (this.enums != null) goto L5;
        return null;
    L5:
        int r101 = Arrays.binarySearch(this.enumNameHashCodes, r100);
        if (r101 >= 0) goto L9;
        return null;
    L9:
        return this.enums[r101];
    }

    public Enum<?> valueOf(int r100) {
        return this.ordinalEnums[r100];
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r110) {
        JSONLexer r102 = r100.lexer;     // Catch: Exception -> L45 JSONException -> L48
        int r111 = r102.token();     // Catch: Exception -> L45 JSONException -> L48
        if (r111 != 2) goto L14;
        int r103 = r102.intValue();     // Catch: Exception -> L45 JSONException -> L48
        r102.nextToken(16);     // Catch: Exception -> L45 JSONException -> L48
        if (r103 < 0) goto L12;
        Object[] r104 = this.ordinalEnums;     // Catch: Exception -> L45 JSONException -> L48
        if (r103 >= r104.length) goto L12;
        return (T) r104[r103];
    L12:
        throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + r103);     // Catch: Exception -> L45 JSONException -> L48
    L14:
        if (r111 != 4) goto L40;
        String r105 = r102.stringVal();     // Catch: Exception -> L45 JSONException -> L48
        r102.nextToken(16);     // Catch: Exception -> L45 JSONException -> L48
        if (r105.length() != 0) goto L18;
        return null;
    L18:
        long r106 = TypeUtils.fnv1a_64_magic_hashcode;
        int r112 = 0;
        long r107 = -3750763034362895579L;
    L20:
        if (r112 >= r105.length()) goto L27;
        int r108 = r105.charAt(r112);     // Catch: Exception -> L45 JSONException -> L48
        long r109 = r106 ^ ((long) r108);     // Catch: Exception -> L45 JSONException -> L48
        if (r108 < 65) goto L26;
        if (r108 > 90) goto L26;
        r108 = r108 + 32;     // Catch: Exception -> L45 JSONException -> L48
    L26:
        r106 = r109 * TypeUtils.fnv1a_64_magic_prime;     // Catch: Exception -> L45 JSONException -> L48
        r107 = (r107 ^ ((long) r108)) * TypeUtils.fnv1a_64_magic_prime;     // Catch: Exception -> L45 JSONException -> L48
        r112 = r112 + 1;     // Catch: Exception -> L45 JSONException -> L48
        goto L20
    L27:
        T r113 = (T) getEnumByHashCode(r106);
        if (r113 == null) goto L30;
    L32:
        if (r113 == null) goto L34;
    L38:
        return r113;
    L34:
        if (r102.isEnabled(Feature.ErrorOnEnumNotMatch) == false) goto L38;
        throw new JSONException("not match enum value, " + this.enumClass.getName() + " : " + r105);     // Catch: Exception -> L45 JSONException -> L48
    L30:
        if (r107 == r106) goto L32;
        r113 = (T) getEnumByHashCode(r107);
        goto L32
    L40:
        if (r111 != 8) goto L44;
        r102.nextToken(16);     // Catch: Exception -> L45 JSONException -> L48
        return null;
    L44:
        throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + r100.parse());     // Catch: Exception -> L45 JSONException -> L48
    L48:
        e = move-exception;
        throw e;
    L45:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);
    }
}

package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import java.lang.reflect.Type;
import java.util.Arrays;

/* loaded from: classes.dex */
public class EnumDeserializer implements ObjectDeserializer {
    private final Class<?> enumClass;
    protected long[] enumNameHashCodes;
    protected final Enum[] enums;
    protected final Enum[] ordinalEnums;

    public EnumDeserializer(Class<?> cls) {
        this.enumClass = cls;
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        this.ordinalEnums = enumArr;
        int length = enumArr.length;
        long[] jArr = new long[length];
        this.enumNameHashCodes = new long[enumArr.length];
        int i4 = 0;
        while (true) {
            Enum[] enumArr2 = this.ordinalEnums;
            if (i4 >= enumArr2.length) {
                break;
            }
            long jCharAt = -3750763034362895579L;
            for (int i5 = 0; i5 < enumArr2[i4].name().length(); i5++) {
                jCharAt = (jCharAt ^ r3.charAt(i5)) * 1099511628211L;
            }
            jArr[i4] = jCharAt;
            this.enumNameHashCodes[i4] = jCharAt;
            i4++;
        }
        Arrays.sort(this.enumNameHashCodes);
        this.enums = new Enum[this.ordinalEnums.length];
        for (int i6 = 0; i6 < this.enumNameHashCodes.length; i6++) {
            int i7 = 0;
            while (true) {
                if (i7 >= length) {
                    break;
                }
                if (this.enumNameHashCodes[i6] == jArr[i7]) {
                    this.enums[i6] = this.ordinalEnums[i7];
                    break;
                }
                i7++;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i4 = jSONLexer.token();
            if (i4 == 2) {
                int iIntValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
                if (iIntValue >= 0) {
                    Object[] objArr = this.ordinalEnums;
                    if (iIntValue <= objArr.length) {
                        return (T) objArr[iIntValue];
                    }
                }
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + iIntValue);
            }
            if (i4 == 4) {
                String strStringVal = jSONLexer.stringVal();
                jSONLexer.nextToken(16);
                if (strStringVal.length() == 0) {
                    return null;
                }
                return (T) Enum.valueOf(this.enumClass, strStringVal);
            }
            if (i4 == 8) {
                jSONLexer.nextToken(16);
                return null;
            }
            throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + defaultJSONParser.parse());
        } catch (JSONException e4) {
            throw e4;
        } catch (Exception e5) {
            throw new JSONException(e5.getMessage(), e5);
        }
    }

    public Enum getEnumByHashCode(long j4) {
        int iBinarySearch;
        if (this.enums != null && (iBinarySearch = Arrays.binarySearch(this.enumNameHashCodes, j4)) >= 0) {
            return this.enums[iBinarySearch];
        }
        return null;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    public Enum<?> valueOf(int i4) {
        return this.ordinalEnums[i4];
    }
}

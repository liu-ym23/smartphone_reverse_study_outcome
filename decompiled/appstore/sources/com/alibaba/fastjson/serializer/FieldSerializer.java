package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.util.FieldInfo;
import com.bytedance.librarian.LibrarianImpl;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Collection;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public final class FieldSerializer implements Comparable<FieldSerializer> {
    protected final int features;
    public final FieldInfo fieldInfo;
    protected final String format;
    protected char[] name_chars;
    private RuntimeSerializerInfo runtimeInfo;
    protected final boolean writeNull;

    public static class RuntimeSerializerInfo {
        ObjectSerializer fieldSerializer;
        Class<?> runtimeFieldClass;

        public RuntimeSerializerInfo(ObjectSerializer r10, Class<?> r11) {
            this.fieldSerializer = r10;
            this.runtimeFieldClass = r11;
        }
    }

    public FieldSerializer(FieldInfo r11) {
        this.fieldInfo = r11;
        JSONField r10 = r11.getAnnotation();
        String r12 = null;
        if (r10 == null) goto L15;
        SerializerFeature[] r13 = r10.serialzeFeatures();
        int r14 = r13.length;
        int r15 = 0;
        boolean r16 = false;
    L5:
        if (r15 >= r14) goto L10;
        if (r13[r15] != SerializerFeature.WriteMapNullValue) goto L9;
        r16 = true;
    L9:
        r15 = r15 + 1;
        goto L5
    L10:
        String r17 = r10.format().trim();
        if (r17.length() == 0) goto L14;
        r12 = r17;
    L14:
        this.features = SerializerFeature.of(r10.serialzeFeatures());
    L16:
        this.writeNull = r16;
        this.format = r12;
        String r18 = r11.name;
        int r19 = r18.length();
        this.name_chars = new char[r19 + 3];
        r18.getChars(0, r18.length(), this.name_chars, 1);
        char[] r110 = this.name_chars;
        r110[0] = TokenParser.DQUOTE;
        r110[r19 + 1] = TokenParser.DQUOTE;
        r110[r19 + 2] = ':';
        return;
    L15:
        this.features = 0;
        r16 = false;
        goto L16
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(FieldSerializer r10) {
        return compareTo2(r10);
    }

    public Object getPropertyValue(Object r10) throws Exception {
        return this.fieldInfo.get(r10);
    L4:
        e = move-exception;
        FieldInfo r11 = this.fieldInfo;
        Member r12 = r11.method;
        if (r12 != null) goto L10;
        r12 = r11.field;
    L10:
        throw new JSONException("get property error。 " + (r12.getDeclaringClass().getName() + LibrarianImpl.Constants.DOT + r12.getName()), e);
    }

    public void writePrefix(JSONSerializer r10) throws IOException {
        SerializeWriter r11 = r10.out;
        int r12 = r11.features;
        if ((SerializerFeature.QuoteFieldNames.mask & r12) != 0) goto L5;
        r11.writeFieldName(this.fieldInfo.name, true);
        return;
    L5:
        if ((r12 & SerializerFeature.UseSingleQuotes.mask) == 0) goto L7;
        r11.writeFieldName(this.fieldInfo.name, true);
        return;
    L7:
        char[] r13 = this.name_chars;
        r11.write(r13, 0, r13.length);
    }

    public void writeValue(JSONSerializer r10, Object r11) throws Exception {
        String r12 = this.format;
        if (r12 == null) goto L7;
        r10.writeWithFormat(r11, r12);
        return;
    L7:
        if (this.runtimeInfo != null) goto L12;
        if (r11 != null) goto L10;
        Class<?> r13 = this.fieldInfo.fieldClass;
    L11:
        this.runtimeInfo = new RuntimeSerializerInfo(r10.config.get(r13), r13);
        goto L12
    L10:
        r13 = r11.getClass();
    L12:
        RuntimeSerializerInfo r14 = this.runtimeInfo;
        if (r11 == null) goto L15;
        Class<?> r15 = r11.getClass();
        if (r15 != r14.runtimeFieldClass) goto L38;
        ObjectSerializer r16 = r14.fieldSerializer;
        FieldInfo r17 = this.fieldInfo;
        r16.write(r10, r11, r17.name, r17.fieldType);
        return;
    L38:
        ObjectSerializer r18 = r10.config.get(r15);
        FieldInfo r19 = this.fieldInfo;
        r18.write(r10, r11, r19.name, r19.fieldType);
        return;
    L15:
        if ((this.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) goto L17;
    L20:
        int r20 = this.features;
        if ((SerializerFeature.WriteNullBooleanAsFalse.mask & r20) == 0) goto L27;
        if (Boolean.class != r14.runtimeFieldClass) goto L27;
        r10.out.write("false");
        return;
    L27:
        if ((r20 & SerializerFeature.WriteNullListAsEmpty.mask) != 0) goto L29;
    L32:
        r14.fieldSerializer.write(r10, null, this.fieldInfo.name, r14.runtimeFieldClass);
        return;
    L29:
        if (Collection.class.isAssignableFrom(r14.runtimeFieldClass) == false) goto L32;
        r10.out.write("[]");
        return;
    L17:
        if (Number.class.isAssignableFrom(r14.runtimeFieldClass) == false) goto L20;
        r10.out.write(48);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FieldSerializer r10) {
        return this.fieldInfo.compareTo2(r10.fieldInfo);
    }
}

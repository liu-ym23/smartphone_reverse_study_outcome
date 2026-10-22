package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/* JADX INFO: loaded from: classes28.dex */
public class OptionalCodec implements ObjectSerializer, ObjectDeserializer {
    public static OptionalCodec instance;

    public OptionalCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    static {
        instance = new OptionalCodec();
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        if (r101 != OptionalInt.class) goto L11;
        Integer r103 = TypeUtils.castToInt(r100.parseObject(Integer.class));
        if (r103 != null) goto L9;
        return (T) OptionalInt.empty();
    L9:
        return (T) OptionalInt.of(r103.intValue());
    L11:
        if (r101 != OptionalLong.class) goto L19;
        Long r104 = TypeUtils.castToLong(r100.parseObject(Long.class));
        if (r104 != null) goto L17;
        return (T) OptionalLong.empty();
    L17:
        return (T) OptionalLong.of(r104.longValue());
    L19:
        if (r101 != OptionalDouble.class) goto L26;
        Double r105 = TypeUtils.castToDouble(r100.parseObject(Double.class));
        if (r105 != null) goto L25;
        return (T) OptionalDouble.empty();
    L25:
        return (T) OptionalDouble.of(r105.doubleValue());
    L26:
        Object r106 = r100.parseObject(TypeUtils.unwrapOptional(r101));
        if (r106 != null) goto L31;
        return (T) Optional.empty();
    L31:
        return (T) Optional.of(r106);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        if (r101 != null) goto L6;
        r100.writeNull();
        return;
    L6:
        if ((r101 instanceof Optional) == false) goto L14;
        Optional r105 = (Optional) r101;
        if (r105.isPresent() == false) goto L10;
        Object r106 = r105.get();
    L11:
        r100.write(r106);
        return;
    L10:
        r106 = null;
        goto L11
    L14:
        if ((r101 instanceof OptionalDouble) == false) goto L21;
        OptionalDouble r107 = (OptionalDouble) r101;
        if (r107.isPresent() == false) goto L18;
        r100.write(Double.valueOf(r107.getAsDouble()));
        return;
    L18:
        r100.writeNull();
        return;
    L21:
        if ((r101 instanceof OptionalInt) == false) goto L28;
        OptionalInt r108 = (OptionalInt) r101;
        if (r108.isPresent() == false) goto L25;
        r100.out.writeInt(r108.getAsInt());
        return;
    L25:
        r100.writeNull();
        return;
    L28:
        if ((r101 instanceof OptionalLong) == false) goto L35;
        OptionalLong r109 = (OptionalLong) r101;
        if (r109.isPresent() == false) goto L32;
        r100.out.writeLong(r109.getAsLong());
        return;
    L32:
        r100.writeNull();
        return;
    L35:
        throw new JSONException("not support optional : " + r101.getClass());
    }
}

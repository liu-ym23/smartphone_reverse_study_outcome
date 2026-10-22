package com.alibaba.fastjson.support.moneta;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.money.Monetary;
import org.javamoney.moneta.Money;

/* JADX INFO: loaded from: classes28.dex */
public class MonetaCodec implements ObjectSerializer, ObjectDeserializer {
    public static final MonetaCodec instance = null;

    public MonetaCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 0;
    }

    static {
        instance = new MonetaCodec();
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        JSONObject r103 = r100.parseObject();
        Object r104 = r103.get("currency");
        if ((r104 instanceof JSONObject) == false) goto L6;
        String r105 = ((JSONObject) r104).getString("currencyCode");
    L9:
        Object r106 = r103.get("numberStripped");
        if ((r106 instanceof BigDecimal) == true) goto L19;
        if ((r106 instanceof Integer) == true) goto L19;
        if ((r106 instanceof BigInteger) == true) goto L19;
        throw new UnsupportedOperationException();
    L19:
        return (T) Money.of((Number) r106, Monetary.getCurrency(r105, new String[0]));
    L6:
        if ((r104 instanceof String) == false) goto L8;
        r105 = (String) r104;
        goto L9
    L8:
        r105 = null;
        goto L9
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        Money r105 = (Money) r101;
        if (r105 != null) goto L6;
        r100.writeNull();
        return;
    L6:
        SerializeWriter r106 = r100.out;
        r106.writeFieldValue('{', "numberStripped", r105.getNumberStripped());
        r106.writeFieldValue(',', "currency", r105.getCurrency().getCurrencyCode());
        r106.write(125);
    }
}

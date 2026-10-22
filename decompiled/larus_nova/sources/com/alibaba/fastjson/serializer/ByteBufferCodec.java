package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes28.dex */
public class ByteBufferCodec implements ObjectSerializer, ObjectDeserializer {
    public static final ByteBufferCodec instance = null;

    public static class ByteBufferBean {
        public byte[] array;
        public int limit;
        public int position;

        public ByteBufferBean() {
        }

        public ByteBuffer byteBuffer() {
            ByteBuffer r100 = ByteBuffer.wrap(this.array);
            r100.limit(this.limit);
            r100.position(this.position);
            return r100;
        }
    }

    public ByteBufferCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 14;
    }

    static {
        instance = new ByteBufferCodec();
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        return (T) ((ByteBufferBean) r100.parseObject(ByteBufferBean.class)).byteBuffer();
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        ByteBuffer r105 = (ByteBuffer) r101;
        byte[] r106 = r105.array();
        SerializeWriter r107 = r100.out;
        r107.write(123);
        r107.writeFieldName("array");
        r107.writeByteArray(r106);
        r107.writeFieldValue(',', VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, r105.limit());
        r107.writeFieldValue(',', "position", r105.position());
        r107.write(125);
    }
}

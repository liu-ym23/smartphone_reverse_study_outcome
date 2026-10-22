package ai.onnxruntime;

import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface OnnxValue extends AutoCloseable {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public enum OnnxValueType {
        ONNX_TYPE_UNKNOWN(0),
        ONNX_TYPE_TENSOR(1),
        ONNX_TYPE_SEQUENCE(2),
        ONNX_TYPE_MAP(3),
        ONNX_TYPE_OPAQUE(4),
        ONNX_TYPE_SPARSETENSOR(5),
        ONNX_TYPE_OPTIONAL(6);

        public final int value;

        OnnxValueType(int i10) {
            this.value = i10;
        }
    }

    static void close(Iterable<? extends OnnxValue> iterable) {
        Iterator<? extends OnnxValue> it = iterable.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    @Override // java.lang.AutoCloseable
    void close();

    ValueInfo getInfo();

    OnnxValueType getType();

    Object getValue();

    boolean isClosed();

    static void close(Map<String, ? extends OnnxValue> map) {
        Iterator<? extends OnnxValue> it = map.values().iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }
}

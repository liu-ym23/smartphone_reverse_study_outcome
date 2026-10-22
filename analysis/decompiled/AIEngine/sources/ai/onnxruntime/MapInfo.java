package ai.onnxruntime;

import ai.onnxruntime.TensorInfo;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class MapInfo implements ValueInfo {
    public final OnnxJavaType keyType;
    public final int size;
    public final OnnxJavaType valueType;

    public MapInfo(OnnxJavaType onnxJavaType, OnnxJavaType onnxJavaType2) {
        this.size = -1;
        this.keyType = onnxJavaType;
        this.valueType = onnxJavaType2;
    }

    public String toString() {
        String str;
        if (this.size == -1) {
            str = "MapInfo(size=UNKNOWN";
        } else {
            str = "MapInfo(size=" + this.size;
        }
        StringBuilder sbP = a0.a.p(str, ",keyType=");
        sbP.append(this.keyType.toString());
        sbP.append(",valueType=");
        sbP.append(this.valueType.toString());
        sbP.append(")");
        return sbP.toString();
    }

    public MapInfo(int i10, OnnxJavaType onnxJavaType, OnnxJavaType onnxJavaType2) {
        this.size = i10;
        this.keyType = onnxJavaType;
        this.valueType = onnxJavaType2;
    }

    public MapInfo(int i10, int i11, int i12) {
        this.size = i10;
        this.keyType = OnnxJavaType.mapFromOnnxTensorType(TensorInfo.OnnxTensorType.mapFromInt(i11));
        this.valueType = OnnxJavaType.mapFromOnnxTensorType(TensorInfo.OnnxTensorType.mapFromInt(i12));
    }
}

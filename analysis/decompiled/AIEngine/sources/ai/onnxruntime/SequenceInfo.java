package ai.onnxruntime;

import ai.onnxruntime.TensorInfo;
import com.stepos.core.common.telemetry.FailStage;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SequenceInfo implements ValueInfo {
    public final int length;
    public final MapInfo mapInfo;
    public final boolean sequenceOfMaps;
    public final OnnxJavaType sequenceType;

    public SequenceInfo(int i10, OnnxJavaType onnxJavaType) {
        this.length = i10;
        this.sequenceType = onnxJavaType;
        this.sequenceOfMaps = false;
        this.mapInfo = null;
    }

    public boolean isSequenceOfMaps() {
        return this.sequenceOfMaps;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SequenceInfo(length=");
        int i10 = this.length;
        sb2.append(i10 == -1 ? FailStage.UNKNOWN : Integer.valueOf(i10));
        String string = sb2.toString();
        if (this.sequenceOfMaps) {
            StringBuilder sbP = a0.a.p(string, ",type=");
            sbP.append(this.mapInfo.toString());
            sbP.append(")");
            return sbP.toString();
        }
        StringBuilder sbP2 = a0.a.p(string, ",type=");
        sbP2.append(this.sequenceType.toString());
        sbP2.append(")");
        return sbP2.toString();
    }

    public SequenceInfo(int i10, int i11) {
        this.length = i10;
        this.sequenceType = OnnxJavaType.mapFromOnnxTensorType(TensorInfo.OnnxTensorType.mapFromInt(i11));
        this.sequenceOfMaps = false;
        this.mapInfo = null;
    }

    public SequenceInfo(int i10, MapInfo mapInfo) {
        this.length = i10;
        this.sequenceOfMaps = true;
        this.mapInfo = mapInfo;
        this.sequenceType = OnnxJavaType.UNKNOWN;
    }

    public SequenceInfo(int i10, OnnxJavaType onnxJavaType, OnnxJavaType onnxJavaType2) {
        this.length = i10;
        this.sequenceType = OnnxJavaType.UNKNOWN;
        this.sequenceOfMaps = true;
        this.mapInfo = new MapInfo(onnxJavaType, onnxJavaType2);
    }
}

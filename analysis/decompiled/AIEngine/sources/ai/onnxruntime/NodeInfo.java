package ai.onnxruntime;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class NodeInfo {
    private final ValueInfo info;
    private final String name;

    public NodeInfo(String str, ValueInfo valueInfo) {
        this.name = str;
        this.info = valueInfo;
    }

    public ValueInfo getInfo() {
        return this.info;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "NodeInfo(name=" + this.name + ",info=" + this.info.toString() + ")";
    }
}

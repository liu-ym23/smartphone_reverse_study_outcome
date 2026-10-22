package F1;

import com.google.gson.stream.JsonReader;

/* loaded from: classes.dex */
public enum u extends y {
    public u() {
        super("DOUBLE", 0);
    }

    @Override // F1.z
    public final Number a(JsonReader jsonReader) {
        return Double.valueOf(jsonReader.nextDouble());
    }
}

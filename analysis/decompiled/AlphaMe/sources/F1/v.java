package F1;

import com.google.gson.stream.JsonReader;

/* loaded from: classes.dex */
public enum v extends y {
    public v() {
        super("LAZILY_PARSED_NUMBER", 1);
    }

    @Override // F1.z
    public final Number a(JsonReader jsonReader) {
        return new G1.j(jsonReader.nextString());
    }
}

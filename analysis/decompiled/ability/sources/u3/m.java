package u3;

import com.fasterxml.jackson.databind.JsonNode;

/* loaded from: classes3.dex */
public interface m {
    void a(f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar);

    default void b(f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar, boolean z10) {
        if (jsonNode != null && z10) {
            a(fVar, jsonNode, jsonNode2, aVar);
        }
    }
}

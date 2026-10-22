package w7;

import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface s {
    default void a(f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10) {
        if (jsonNode != null && z10) {
            b(fVar, jsonNode, jsonNode2, aVar);
        }
    }

    void b(f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar);
}

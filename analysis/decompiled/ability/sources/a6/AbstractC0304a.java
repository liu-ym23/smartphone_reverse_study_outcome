package a6;

import H4.o;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.List;
import kotlin.jvm.internal.k;

/* renamed from: a6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0304a {
    public static final McpSchema.CallToolResult a(int i, String message) {
        k.f(message, "message");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("code", Integer.valueOf(i));
        jsonObject.add("message", new JsonPrimitive(message));
        return new McpSchema.CallToolResult((List<McpSchema.Content>) o.M(new McpSchema.TextContent(jsonObject.toString())), Boolean.TRUE);
    }

    public static final McpSchema.CallToolResult b(String str) {
        if (str == null) {
            str = "ok";
        }
        return new McpSchema.CallToolResult((List<McpSchema.Content>) o.M(new McpSchema.TextContent(str)), Boolean.FALSE);
    }
}

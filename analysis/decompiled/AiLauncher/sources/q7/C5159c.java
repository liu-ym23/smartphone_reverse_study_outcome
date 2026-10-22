package q7;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.jackson.JacksonMcpJsonMapper;
import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import io.modelcontextprotocol.json.schema.jackson.DefaultJsonSchemaValidator;

/* renamed from: q7.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C5159c {

    /* renamed from: a, reason: collision with root package name */
    public static final McpJsonMapper f38612a = new JacksonMcpJsonMapper(new ObjectMapper());

    /* renamed from: b, reason: collision with root package name */
    public static final JsonSchemaValidator f38613b = new DefaultJsonSchemaValidator();
}

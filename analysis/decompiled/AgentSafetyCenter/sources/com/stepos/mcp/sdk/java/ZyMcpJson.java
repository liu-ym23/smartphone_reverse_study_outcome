package com.stepos.mcp.sdk.java;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.jackson.JacksonMcpJsonMapper;
import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import io.modelcontextprotocol.json.schema.jackson.DefaultJsonSchemaValidator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ZyMcpJson {
    public static final McpJsonMapper jsonMapper = new JacksonMcpJsonMapper(new ObjectMapper());
    public static final JsonSchemaValidator jsonSchemaValidator = new DefaultJsonSchemaValidator();
}

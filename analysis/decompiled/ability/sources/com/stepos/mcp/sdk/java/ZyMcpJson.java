package com.stepos.mcp.sdk.java;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.jackson.JacksonMcpJsonMapper;
import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import io.modelcontextprotocol.json.schema.jackson.DefaultJsonSchemaValidator;

/* loaded from: classes3.dex */
public class ZyMcpJson {
    public static final McpJsonMapper jsonMapper = new JacksonMcpJsonMapper(new ObjectMapper());
    public static final JsonSchemaValidator jsonSchemaValidator = new DefaultJsonSchemaValidator();
}

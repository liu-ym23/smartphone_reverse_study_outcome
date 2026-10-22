package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.StringWriter;
import java.lang.reflect.Type;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class DOMSerializer extends StdSerializer<Node> {
    protected final TransformerFactory transformerFactory;

    public DOMSerializer() throws TransformerConfigurationException, TransformerFactoryConfigurationError {
        super(Node.class);
        try {
            TransformerFactory transformerFactoryNewInstance = TransformerFactory.newInstance();
            this.transformerFactory = transformerFactoryNewInstance;
            transformerFactoryNewInstance.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
            setTransformerFactoryAttribute(transformerFactoryNewInstance, "http://javax.xml.XMLConstants/property/accessExternalDTD", "");
            setTransformerFactoryAttribute(transformerFactoryNewInstance, "http://javax.xml.XMLConstants/property/accessExternalStylesheet", "");
        } catch (Exception e10) {
            throw new IllegalStateException("Could not instantiate `TransformerFactory`: " + e10.getMessage(), e10);
        }
    }

    private static void setTransformerFactoryAttribute(TransformerFactory transformerFactory, String str, Object obj) {
        try {
            transformerFactory.setAttribute(str, obj);
        } catch (Exception unused) {
            System.err.println("[DOMSerializer] Failed to set TransformerFactory attribute: " + str);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer, com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) {
        if (jsonFormatVisitorWrapper != null) {
            jsonFormatVisitorWrapper.expectAnyFormat(javaType);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.jsonschema.SchemaAware
    @Deprecated
    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        return createSchemaNode("string", true);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer
    public void serialize(Node node, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws TransformerException, JsonMappingException, IllegalArgumentException {
        try {
            Transformer transformerNewTransformer = this.transformerFactory.newTransformer();
            transformerNewTransformer.setOutputProperty("omit-xml-declaration", "yes");
            transformerNewTransformer.setOutputProperty("indent", "no");
            StreamResult streamResult = new StreamResult(new StringWriter());
            transformerNewTransformer.transform(new DOMSource(node), streamResult);
            jsonGenerator.writeString(streamResult.getWriter().toString());
        } catch (TransformerConfigurationException e10) {
            throw new IllegalStateException("Could not create XML Transformer for writing DOM `Node` value: " + e10.getMessage(), e10);
        } catch (TransformerException e11) {
            serializerProvider.reportMappingProblem(e11, "DOM `Node` value serialization failed: %s", e11.getMessage());
        }
    }
}

package com.alibaba.fastjson.support.jaxrs;

import java.util.Map;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import org.glassfish.jersey.CommonProperties;
import org.glassfish.jersey.internal.util.PropertiesHelper;

/* JADX INFO: loaded from: classes28.dex */
public class FastJsonFeature implements Feature {
    private static final String JSON_FEATURE = null;

    public FastJsonFeature() {
    }

    static {
        JSON_FEATURE = "FastJsonFeature";
    }

    public boolean configure(FeatureContext r100) {
        Configuration r101 = r100.getConfiguration();     // Catch: NoSuchMethodError -> L10
        Map r102 = r101.getProperties();     // Catch: NoSuchMethodError -> L10
        RuntimeType r103 = r101.getRuntimeType();     // Catch: NoSuchMethodError -> L10
        String r104 = JSON_FEATURE;     // Catch: NoSuchMethodError -> L10
        if (r104.equalsIgnoreCase((String) CommonProperties.getValue(r102, r103, "jersey.config.jsonFeature", r104, String.class)) == true) goto L6;
        return false;
    L6:
        r100.property(PropertiesHelper.getPropertyNameForRuntime("jersey.config.jsonFeature", r101.getRuntimeType()), r104);     // Catch: NoSuchMethodError -> L10
        if (r101.isRegistered(FastJsonProvider.class) == true) goto L9;
        r100.register(FastJsonProvider.class, new Class[]{MessageBodyReader.class, MessageBodyWriter.class});     // Catch: NoSuchMethodError -> L10
    L9:
        return true;
    }
}

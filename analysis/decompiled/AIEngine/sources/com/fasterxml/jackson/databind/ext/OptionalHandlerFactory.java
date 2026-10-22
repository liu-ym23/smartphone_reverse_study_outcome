package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import h3.a;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class OptionalHandlerFactory implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final Class<?> f4109c;

    /* renamed from: d, reason: collision with root package name */
    public static final Class<?> f4110d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f4111e;
    public static final OptionalHandlerFactory h;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f4112a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f4113b;

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x0007
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:131)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:57)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:49)
        */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        /*
            r0 = 0
            java.lang.Class<org.w3c.dom.Node> r1 = org.w3c.dom.Node.class
            java.lang.Class<org.w3c.dom.Document> r2 = org.w3c.dom.Document.class
            goto L8
        L6:
            r1 = r0
        L7:
            r2 = r0
        L8:
            com.fasterxml.jackson.databind.ext.OptionalHandlerFactory.f4109c = r1
            com.fasterxml.jackson.databind.ext.OptionalHandlerFactory.f4110d = r2
            h3.a r0 = h3.a.f9290a     // Catch: java.lang.Throwable -> Le
        Le:
            com.fasterxml.jackson.databind.ext.OptionalHandlerFactory.f4111e = r0
            com.fasterxml.jackson.databind.ext.OptionalHandlerFactory r0 = new com.fasterxml.jackson.databind.ext.OptionalHandlerFactory
            r0.<init>()
            com.fasterxml.jackson.databind.ext.OptionalHandlerFactory.h = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ext.OptionalHandlerFactory.<clinit>():void");
    }

    public OptionalHandlerFactory() {
        HashMap map = new HashMap();
        this.f4112a = map;
        map.put("java.sql.Date", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$SqlDateDeserializer");
        map.put("java.sql.Timestamp", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$TimestampDeserializer");
        HashMap map2 = new HashMap();
        this.f4113b = map2;
        map2.put("java.sql.Timestamp", DateSerializer.h);
        map2.put("java.sql.Date", "com.fasterxml.jackson.databind.ser.std.SqlDateSerializer");
        map2.put("java.sql.Time", "com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer");
        map2.put("java.sql.Blob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
        map2.put("javax.sql.rowset.serial.SerialBlob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
    }

    public static Object a(JavaType javaType, Class cls) {
        try {
            return com.fasterxml.jackson.databind.util.a.h(cls, false);
        } catch (Throwable th) {
            throw new IllegalStateException("Failed to create instance of `" + cls.getName() + "` for handling values of type " + com.fasterxml.jackson.databind.util.a.r(javaType) + ", problem: (" + th.getClass().getName() + ") " + th.getMessage());
        }
    }

    public static Object b(JavaType javaType, String str) {
        try {
            return a(javaType, Class.forName(str));
        } catch (Throwable th) {
            StringBuilder sbQ = a0.a.q("Failed to find class `", str, "` for handling values of type ");
            sbQ.append(com.fasterxml.jackson.databind.util.a.r(javaType));
            sbQ.append(", problem: (");
            sbQ.append(th.getClass().getName());
            sbQ.append(") ");
            sbQ.append(th.getMessage());
            throw new IllegalStateException(sbQ.toString());
        }
    }
}

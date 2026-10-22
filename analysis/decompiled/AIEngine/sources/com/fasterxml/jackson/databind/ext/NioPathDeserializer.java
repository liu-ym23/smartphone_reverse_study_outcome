package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.spi.FileSystemProvider;
import java.util.Iterator;
import java.util.ServiceLoader;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class NioPathDeserializer extends StdScalarDeserializer<Path> {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f4108d;

    static {
        File[] fileArrListRoots = File.listRoots();
        int length = fileArrListRoots.length;
        boolean z = false;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            String path = fileArrListRoots[i10].getPath();
            if (path.length() >= 2 && Character.isLetter(path.charAt(0)) && path.charAt(1) == ':') {
                z = true;
                break;
            }
            i10++;
        }
        f4108d = z;
    }

    public NioPathDeserializer() {
        super(Path.class);
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws ValueInstantiationException, MismatchedInputException {
        Class<?> cls = this.f4054a;
        if (!jsonParser.i1(JsonToken.VALUE_STRING)) {
            deserializationContext.C(Path.class, jsonParser);
            throw null;
        }
        String strV0 = jsonParser.V0();
        if (strV0.indexOf(58) < 0) {
            return Paths.get(strV0, new String[0]);
        }
        if (f4108d && strV0.length() >= 2 && Character.isLetter(strV0.charAt(0)) && strV0.charAt(1) == ':') {
            return Paths.get(strV0, new String[0]);
        }
        try {
            URI uri = new URI(strV0);
            try {
                return Paths.get(uri);
            } catch (FileSystemNotFoundException e10) {
                try {
                    String scheme = uri.getScheme();
                    Iterator it = ServiceLoader.load(FileSystemProvider.class).iterator();
                    while (it.hasNext()) {
                        FileSystemProvider fileSystemProvider = (FileSystemProvider) it.next();
                        if (fileSystemProvider.getScheme().equalsIgnoreCase(scheme)) {
                            return fileSystemProvider.getPath(uri);
                        }
                    }
                    throw null;
                } catch (Throwable e102) {
                    e102.addSuppressed(e102);
                    throw null;
                }
            } finally {
                deserializationContext.w(cls, e102);
            }
        } catch (URISyntaxException e1022) {
            throw null;
        }
    }
}

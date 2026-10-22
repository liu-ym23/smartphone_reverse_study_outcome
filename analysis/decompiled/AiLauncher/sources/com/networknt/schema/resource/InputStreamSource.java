package com.networknt.schema.resource;

import java.io.IOException;
import java.io.InputStream;

@FunctionalInterface
/* loaded from: classes2.dex */
public interface InputStreamSource {
    InputStream getInputStream() throws IOException;
}

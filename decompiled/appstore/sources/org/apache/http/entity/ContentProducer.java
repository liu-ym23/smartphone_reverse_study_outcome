package org.apache.http.entity;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
public interface ContentProducer {
    void writeTo(OutputStream r10) throws IOException;
}

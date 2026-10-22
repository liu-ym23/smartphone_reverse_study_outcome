package com.bytedance.services.apm.api;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IMultipartUploader {
    void addFilePart(String r1, File r2, String r3, Map<String, String> r4) throws IOException;

    void addFilePart(String r1, String r2, String r3, Map<String, String> r4) throws IOException;

    void addFormField(String r1, String r2);

    HttpResponse finish() throws IOException;
}

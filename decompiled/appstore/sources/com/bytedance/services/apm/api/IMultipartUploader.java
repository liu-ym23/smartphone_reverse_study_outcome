package com.bytedance.services.apm.api;

import i6.c;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IMultipartUploader {
    void addFilePart(String r10, File r11, String r12, Map<String, String> r13) throws IOException;

    void addFilePart(String r10, String r11, String r12, Map<String, String> r13) throws IOException;

    void addFormField(String r10, String r11);

    c finish() throws IOException;
}

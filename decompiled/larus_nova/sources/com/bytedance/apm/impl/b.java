package com.bytedance.apm.impl;

import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements TypedOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypedFile f190563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f190564b;

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final String fileName() {
        StringBuilder r100 = new StringBuilder(this.f190563a.fileName());
        r100.append("\"");
        Iterator<Map.Entry<String, String>> r101 = this.f190564b.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, String> r102 = r101.next();
        String r103 = r102.getKey();
        String r104 = r102.getValue();
        r100.append("; ");
        r100.append(r103);
        r100.append("=\"");
        r100.append(r104);
        r100.append("\"");
        goto L4
    L6:
        r100.deleteCharAt(r100.length() - 1);
        return r100.toString();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final long length() {
        return this.f190563a.length();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final String md5Stub() {
        return this.f190563a.md5Stub();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final String mimeType() {
        return this.f190563a.mimeType();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final void writeTo(OutputStream r100) throws IOException {
        this.f190563a.writeTo(r100);
    }

    public b(Map<String, String> r100, TypedFile r101) {
        this.f190564b = r100;
        this.f190563a = r101;
    }
}

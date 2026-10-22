package com.stepos.statsapp.v3.lib.plugin.net.multipart;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class d implements i {

    /* renamed from: a, reason: collision with root package name */
    private File f30836a;

    /* renamed from: b, reason: collision with root package name */
    private String f30837b;

    public d(File file) throws FileNotFoundException {
        this.f30837b = null;
        this.f30836a = file;
        if (file != null) {
            if (!file.isFile()) {
                throw new FileNotFoundException("File is not a normal file.");
            }
            if (!file.canRead()) {
                throw new FileNotFoundException("File is not readable.");
            }
            this.f30837b = file.getName();
        }
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.net.multipart.i
    public long a() {
        File file = this.f30836a;
        if (file != null) {
            return file.length();
        }
        return 0L;
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.net.multipart.i
    public InputStream b() throws IOException {
        return this.f30836a != null ? new FileInputStream(this.f30836a) : new ByteArrayInputStream(new byte[0]);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.net.multipart.i
    public String getFileName() {
        String str = this.f30837b;
        return str == null ? "noname" : str;
    }

    public d(String str, File file) throws FileNotFoundException {
        this(file);
        if (str != null) {
            this.f30837b = str;
        }
    }
}

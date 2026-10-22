package com.amap.api.col.jmsl;

import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes.dex */
public class D0 extends AbstractC1614v0 {
    @Override // com.amap.api.col.jmsl.AbstractC1614v0
    public byte[] c(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ZipOutputStream zipOutputStream;
        String[] strArr = C1604s2.f16918a;
        byte[] byteArray = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(com.stepos.statsapp.v3.lib.plugin.events.b.f30786f));
                    zipOutputStream.write(bArr);
                    zipOutputStream.closeEntry();
                    zipOutputStream.finish();
                    byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        zipOutputStream.close();
                    } catch (Throwable th) {
                        C1611u1.b(th, "ut", "zp1");
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        C1611u1.b(th, "ut", "zp");
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (Throwable th3) {
                                C1611u1.b(th3, "ut", "zp1");
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return byteArray;
                    } finally {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                zipOutputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            zipOutputStream = null;
        }
        try {
            byteArrayOutputStream.close();
        } catch (Throwable th6) {
            C1611u1.b(th6, "ut", "zp2");
        }
        return byteArray;
    }
}

package com.stepos.core.ability.speech;

import java.io.File;
import java.io.FileInputStream;
import kotlin.Result;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AudioFormatSniffer {
    private static final int HEADER_BYTES = 16;
    public static final AudioFormatSniffer INSTANCE = new AudioFormatSniffer();

    private AudioFormatSniffer() {
    }

    private final boolean ascii(byte[] bArr, int i10, int i11, String str) {
        if (str.length() + i11 > i10) {
            return false;
        }
        int length = str.length();
        for (int i12 = 0; i12 < length; i12++) {
            if ((bArr[i11 + i12] & 255) != str.charAt(i12)) {
                return false;
            }
        }
        return true;
    }

    private final String detect(byte[] bArr, int i10) {
        if (ascii(bArr, i10, 0, "RIFF") && ascii(bArr, i10, 8, "WAVE")) {
            return "wav";
        }
        if (ascii(bArr, i10, 0, "fLaC")) {
            return "flac";
        }
        if (ascii(bArr, i10, 0, "OggS")) {
            return "ogg";
        }
        if (ascii(bArr, i10, 0, "#!AMR")) {
            return "amr";
        }
        if (ascii(bArr, i10, 4, "ftyp")) {
            return "m4a";
        }
        if (ascii(bArr, i10, 0, "ID3")) {
            return "mp3";
        }
        if (i10 < 2) {
            return null;
        }
        int i11 = bArr[0] & 255;
        byte b10 = bArr[1];
        if (i11 == 255 && (b10 & 224) == 224) {
            return (b10 & 6) == 0 ? "aac" : "mp3";
        }
        return null;
    }

    public final String detectExtension(File file) {
        Object objA;
        kotlin.jvm.internal.g.f(file, "file");
        try {
            byte[] bArr = new byte[16];
            FileInputStream fileInputStream = new FileInputStream(file);
            int i10 = 0;
            while (i10 < 16) {
                try {
                    int i11 = fileInputStream.read(bArr, i10, 16 - i10);
                    if (i11 < 0) {
                        break;
                    }
                    i10 += i11;
                } finally {
                }
            }
            fileInputStream.close();
            objA = i10 < 12 ? null : detect(bArr, i10);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return (String) (objA instanceof Result.Failure ? null : objA);
    }
}

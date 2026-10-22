package com.bumptech.glide.load;

import D0.b;
import K0.n;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class a {
    public static int a(List<ImageHeaderParser> list, InputStream inputStream, b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new n(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            try {
                int iC = list.get(i5).c(inputStream, bVar);
                if (iC != -1) {
                    return iC;
                }
                inputStream.reset();
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType b(List<ImageHeaderParser> list, InputStream inputStream, b bVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new n(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            try {
                ImageHeaderParser.ImageType imageTypeB = list.get(i5).b(inputStream);
                if (imageTypeB != ImageHeaderParser.ImageType.UNKNOWN) {
                    return imageTypeB;
                }
                inputStream.reset();
            } finally {
                inputStream.reset();
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static ImageHeaderParser.ImageType c(List<ImageHeaderParser> list, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            ImageHeaderParser.ImageType imageTypeA = list.get(i5).a(byteBuffer);
            if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeA;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}

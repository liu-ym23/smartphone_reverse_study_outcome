package com.airbnb.lottie;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PathMeasure;
import android.util.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f4554a = new HashMap();

    public static C a(String str, Callable callable) {
        LottieComposition lottieComposition;
        J0.g gVar = J0.g.f874b;
        if (str == null) {
            gVar.getClass();
            lottieComposition = null;
        } else {
            lottieComposition = (LottieComposition) gVar.f875a.a(str);
        }
        int i4 = 0;
        if (lottieComposition != null) {
            return new C(new l(i4, lottieComposition));
        }
        HashMap map = f4554a;
        if (map.containsKey(str)) {
            return (C) map.get(str);
        }
        C c4 = new C(callable);
        c4.b(new i(str, 1));
        c4.a(new i(str, i4));
        map.put(str, c4);
        return c4;
    }

    public static A b(InputStream inputStream, String str, boolean z4) {
        try {
            A aC = c(new JsonReader(new InputStreamReader(inputStream)), str);
            if (z4) {
                PathMeasure pathMeasure = P0.c.f1558a;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (RuntimeException e4) {
                        throw e4;
                    } catch (Exception unused) {
                    }
                }
            }
            return aC;
        } catch (Throwable th) {
            if (z4) {
                PathMeasure pathMeasure2 = P0.c.f1558a;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (RuntimeException e5) {
                        throw e5;
                    } catch (Exception unused2) {
                    }
                }
            }
            throw th;
        }
    }

    public static A c(JsonReader jsonReader, String str) {
        try {
            LottieComposition lottieCompositionY = B0.f.Y(jsonReader);
            J0.g gVar = J0.g.f874b;
            if (str == null) {
                gVar.getClass();
            } else {
                gVar.f875a.b(str, lottieCompositionY);
            }
            return new A(lottieCompositionY);
        } catch (Exception e4) {
            return new A(e4);
        }
    }

    public static A d(ZipInputStream zipInputStream, String str) throws IOException {
        w next;
        HashMap map = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                if (nextEntry.getName().contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    lottieComposition = (LottieComposition) b(zipInputStream, str, false).f4519a;
                } else if (nextEntry.getName().contains(".png")) {
                    map.put(nextEntry.getName().split("/")[r1.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new A(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                Iterator<w> it = lottieComposition.getImages().values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next.f4586a.equals(str2)) {
                        break;
                    }
                }
                if (next != null) {
                    next.f4587b = (Bitmap) entry.getValue();
                }
            }
            for (Map.Entry<String, w> entry2 : lottieComposition.getImages().entrySet()) {
                if (entry2.getValue().f4587b == null) {
                    return new A(new IllegalStateException("There is no image for " + entry2.getValue().f4586a));
                }
            }
            J0.g gVar = J0.g.f874b;
            if (str == null) {
                gVar.getClass();
            } else {
                gVar.f875a.b(str, lottieComposition);
            }
            return new A(lottieComposition);
        } catch (IOException e4) {
            return new A(e4);
        }
    }
}

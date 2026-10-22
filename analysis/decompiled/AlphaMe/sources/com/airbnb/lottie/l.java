package com.airbnb.lottie;

import android.graphics.PathMeasure;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public final class l implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4552a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4553b;

    public /* synthetic */ l(int i4, Object obj) {
        this.f4552a = i4;
        this.f4553b = obj;
    }

    public final A a() throws IOException {
        J.b bVar;
        A aB;
        File fileD;
        int i4 = this.f4552a;
        Object obj = this.f4553b;
        switch (i4) {
            case 0:
                Log.d("Gabe", "call\treturning from cache");
                return new A((LottieComposition) obj);
            default:
                android.support.v4.media.session.c cVar = (android.support.v4.media.session.c) obj;
                N0.a aVar = N0.a.Zip;
                B0.c cVar2 = (B0.c) cVar.f2366d;
                cVar2.getClass();
                LottieComposition lottieComposition = null;
                try {
                    fileD = cVar2.d((String) cVar2.f137b);
                } catch (FileNotFoundException unused) {
                }
                if (fileD == null) {
                    bVar = null;
                } else {
                    FileInputStream fileInputStream = new FileInputStream(fileD);
                    N0.a aVar2 = fileD.getAbsolutePath().endsWith(".zip") ? aVar : N0.a.Json;
                    fileD.getAbsolutePath();
                    HashSet hashSet = AbstractC0398c.f4541a;
                    bVar = new J.b(aVar2, fileInputStream);
                }
                if (bVar != null) {
                    N0.a aVar3 = (N0.a) bVar.f848a;
                    InputStream inputStream = (InputStream) bVar.f849b;
                    if (aVar3 == aVar) {
                        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
                        try {
                            aB = m.d(zipInputStream, (String) cVar.f2364b);
                            PathMeasure pathMeasure = P0.c.f1558a;
                            try {
                                zipInputStream.close();
                            } catch (RuntimeException e4) {
                                throw e4;
                            } catch (Exception unused2) {
                            }
                        } catch (Throwable th) {
                            PathMeasure pathMeasure2 = P0.c.f1558a;
                            try {
                                zipInputStream.close();
                            } catch (RuntimeException e5) {
                                throw e5;
                            } catch (Exception unused3) {
                            }
                            throw th;
                        }
                    } else {
                        aB = m.b(inputStream, (String) cVar.f2364b, true);
                    }
                    Object obj2 = aB.f4519a;
                    if (obj2 != null) {
                        lottieComposition = (LottieComposition) obj2;
                    }
                }
                if (lottieComposition != null) {
                    return new A(lottieComposition);
                }
                HashSet hashSet2 = AbstractC0398c.f4541a;
                try {
                    return cVar.d();
                } catch (IOException e6) {
                    return new A(e6);
                }
        }
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        switch (this.f4552a) {
        }
        return a();
    }
}

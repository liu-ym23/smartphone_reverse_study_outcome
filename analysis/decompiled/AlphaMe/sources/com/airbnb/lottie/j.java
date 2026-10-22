package com.airbnb.lottie;

import android.content.Context;
import android.graphics.PathMeasure;
import android.util.JsonReader;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public final class j implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4547a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4548b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4549c;

    public /* synthetic */ j(int i4, String str, Object obj) {
        this.f4547a = i4;
        this.f4549c = obj;
        this.f4548b = str;
    }

    public final A a() throws IOException {
        int i4 = this.f4547a;
        String str = this.f4548b;
        Object obj = this.f4549c;
        switch (i4) {
            case 0:
                Context context = (Context) obj;
                try {
                    String str2 = "asset_" + str;
                    if (!str.endsWith(".zip")) {
                        return m.b(context.getAssets().open(str), str2, true);
                    }
                    ZipInputStream zipInputStream = new ZipInputStream(context.getAssets().open(str));
                    try {
                        A aD = m.d(zipInputStream, str2);
                        PathMeasure pathMeasure = P0.c.f1558a;
                        try {
                            zipInputStream.close();
                            return aD;
                        } catch (RuntimeException e4) {
                            throw e4;
                        } catch (Exception unused) {
                            return aD;
                        }
                    } catch (Throwable th) {
                        PathMeasure pathMeasure2 = P0.c.f1558a;
                        try {
                            zipInputStream.close();
                        } catch (RuntimeException e5) {
                            throw e5;
                        } catch (Exception unused2) {
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    return new A(e6);
                }
            default:
                return m.c((JsonReader) obj, str);
        }
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        switch (this.f4547a) {
        }
        return a();
    }
}

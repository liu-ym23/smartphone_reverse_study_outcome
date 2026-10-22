package com.bytedance.android.annie.lynx.service.latch;

import io.reactivex.functions.Function;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes43.dex */
public final class n<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f39583a;

    public n(k r100) {
        this.f39583a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        k.a r101 = (k.a) r100;
        Intrinsics.checkNotNullParameter(r101, "channelLoader");
        com.bytedance.android.annie.service.prefetch.n r102 = r101.f39579a;
        String r103 = r101.f39580b;
        this.f39583a.getClass();
        InputStream r104 = r102.a("latch.json", r103);
        if (r104 == null) goto L18;
        Reader r105 = new InputStreamReader(r104, Charsets.UTF_8);
        if ((r105 instanceof BufferedReader) == false) goto L7;
        BufferedReader r106 = (BufferedReader) r105;
    L21:
        String r107 = TextStreamsKt.readText(r106);     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r106, null);
        if (r107 == null) goto L18;
        return new b(r103, r107);
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r106, th);
        throw th;
    L7:
        r106 = new BufferedReader(r105, 8192);
    L18:
        return b.f39548c;
    }
}

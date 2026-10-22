package com.bytedance.android.ec.hybrid.data.network;

import com.bytedance.android.chunkstreamprediction.network.h;
import java.io.InputStreamReader;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements com.bytedance.android.chunkstreamprediction.network.b.InterfaceC0776b<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f46812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ id.e f46813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f46814c;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.chunkstreamprediction.network.b.InterfaceC0776b
    public void call(com.bytedance.android.chunkstreamprediction.network.b<String> r100, com.bytedance.android.chunkstreamprediction.network.a<String> r101) {
        Unit r102 = null;
        h r103 = this.f46812a.f46815a;     // Catch: Throwable -> L12 Exception -> L14
        if (r103 == null) goto L6;
        r103.b();     // Catch: Throwable -> L12 Exception -> L14
    L6:
        id.d r104 = this.f46813b.b();     // Catch: Throwable -> L12 Exception -> L14
    L7:
        InputStreamReader r105 = new InputStreamReader(r104, (String) this.f46814c.element);     // Catch: Throwable -> L12 Exception -> L14
        String r106 = TextStreamsKt.readText(r105);     // Catch: Throwable -> L12 Exception -> L14
        if (r101 == null) goto L10;
        r101.onNext(r106);     // Catch: Throwable -> L12 Exception -> L14
    L10:
        r105.close();     // Catch: Throwable -> L12 Exception -> L14
        r104.close();     // Catch: Throwable -> L12 Exception -> L14
        r104 = this.f46813b.b();     // Catch: Throwable -> L12 Exception -> L14
        goto L7
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L23
        this.f46813b.f489286a.close();     // Catch: Throwable -> L23
        h r108 = this.f46812a.f46815a;     // Catch: Throwable -> L23
        if (r108 == null) goto L21;
        r108.a();     // Catch: Throwable -> L23
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L21:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L23
    L25:
        throw th;
    L23:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L14:
        e = move-exception;
        if (r101 == null) goto L37;
        r101.onFailed(e);     // Catch: Throwable -> L12
    L37:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L31
        this.f46813b.f489286a.close();     // Catch: Throwable -> L31
        h r111 = this.f46812a.f46815a;     // Catch: Throwable -> L31
        if (r111 == null) goto L29;
        r111.a();     // Catch: Throwable -> L31
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L31
    L29:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public a(b r100, id.e r101, Ref.ObjectRef r102) {
        this.f46812a = r100;
        this.f46813b = r101;
        this.f46814c = r102;
    }
}

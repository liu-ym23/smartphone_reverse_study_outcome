package com.bytedance.android.livesdk.chatroom.utils;

import android.view.View;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class SkinLoader$loopLoadImg$2 implements a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SkinLoader f114375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a4 f114376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f114377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f114378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ View f114379e;

    @Override // com.bytedance.android.livesdk.chatroom.utils.a4
    public final void a(Disposable r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a4
    public final void b(final SkinLoadResultType r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        SkinLoader.a r102 = SkinLoader.f114373c;
        Function0<String> r103 = new SkinLoader$loopLoadImg$2$onResult$1(r100, r101);
        r102.getClass();
        SkinLoader.a.c(r103);
        SkinLoadResultType r104 = SkinLoadResultType.ERROR;
        if (r100 != r104) goto L9;
        a4 r105 = this.f114376b;
        if (r105 == null) goto L7;
        r105.b(r104, this.f114377c + " img is error.");
    L7:
        this.f114375a.d(this.f114378d, this.f114377c + 1, this.f114379e, this);
        return;
    L9:
        a4 r106 = this.f114376b;
        if (r106 == null) goto L13;
        r106.b(r100, r101);
        return;
    }

    public SkinLoader$loopLoadImg$2(SkinLoader r100, a4 r101, int r102, ArrayList r103, View r104) {
        this.f114375a = r100;
        this.f114376b = r101;
        this.f114377c = r102;
        this.f114378d = r103;
        this.f114379e = r104;
    }
}

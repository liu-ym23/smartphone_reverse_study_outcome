package com.bytedance.android.livesdk.revenue.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Spannable;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.profit.dress.config.TextAlignType;
import com.bytedance.android.live.profit.player.s;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextRenderUtils f157261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f157262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f157263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f157264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ TextAlignType f157265e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ a5 f157266f;

    public f(TextRenderUtils r100, Context r101, int r102, int r103, TextAlignType r104, a5 r105) {
        this.f157261a = r100;
        this.f157262b = r101;
        this.f157263c = r102;
        this.f157264d = r103;
        this.f157265e = r104;
        this.f157266f = r105;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        s r101 = (s) r100;
        Intrinsics.checkNotNullParameter(r101, "res");
        Throwable r102 = r101.a();
        if (r102 == null) goto L5;
        int r103 = s.f88364a;
        return s.a.a(r102);
    L5:
        Spannable r104 = (Spannable) r101.b();
        if (r104 == null) goto L8;
        TextRenderUtils r105 = this.f157261a;
        Context r106 = this.f157262b;
        int r107 = this.f157263c;
        int r108 = this.f157264d;
        TextAlignType r109 = this.f157265e;
        r105.getClass();
        Bitmap r110 = TextRenderUtils.e(r106, r104, r107, r108, r109);
    L9:
        if (r110 != null) goto L11;
        int r111 = s.f88364a;
        return s.a.a(new Error("text render failed: text=" + this.f157266f));
    L11:
        int r112 = s.f88364a;
        return new s.c(r110);
    L8:
        r110 = null;
        goto L9
    }
}

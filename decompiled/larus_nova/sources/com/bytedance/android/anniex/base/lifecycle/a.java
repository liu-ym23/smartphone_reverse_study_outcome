package com.bytedance.android.anniex.base.lifecycle;

import com.bytedance.android.anniex.container.AnnieXContainer;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.lynx.tasm.LynxError;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a {
    public a() {
    }

    public void a(String r100, ia.c r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
    }

    public void b(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
    }

    public void c(String r100, AnnieXContainer r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
    }

    @Deprecated(message = "This function will be deleted in future")
    public void d(String r100, ia.c r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
    }

    public void e(String r100, ia.c r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
    }

    public void f(String r100, ia.c r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
    }

    public void g(String r100, ia.c r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
    }

    public void h(String r100, ia.c r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
    }

    public void i(String r100, ia.c r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
    }

    public void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
    }

    public void k(String r100, ia.c r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
    }
}

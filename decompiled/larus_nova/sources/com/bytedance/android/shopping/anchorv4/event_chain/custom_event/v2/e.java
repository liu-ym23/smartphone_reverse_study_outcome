package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ecom.arch.slice.g f166623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ecom.arch.slice.g f166624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ fi3.b f166625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f166626d;

    public e(com.bytedance.android.ecom.arch.slice.g r100, com.bytedance.android.ecom.arch.slice.g r101, fi3.b r102, Ref.ObjectRef r103) {
        this.f166623a = r100;
        this.f166624b = r101;
        this.f166625c = r102;
        this.f166626d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        List r102 = (List) this.f166626d.element;
        String r103 = this.f166625c.e();
        if (r102 == null) goto L7;
        TypeIntrinsics.asMutableCollection(r102).remove(r103);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }
}

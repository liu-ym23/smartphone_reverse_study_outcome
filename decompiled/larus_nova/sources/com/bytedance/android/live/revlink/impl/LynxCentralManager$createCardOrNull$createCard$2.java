package com.bytedance.android.live.revlink.impl;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0019\u0010\b\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Landroid/content/Context;", "p1", "Landroid/net/Uri;", "p2", "Lkotlin/Function1;", "Lyy0/c;", "", "Lkotlin/ExtensionFunctionType;", "p3", "Lzy0/b;", AbsMethodDelegate.TAG_INVOKE, "(Landroid/content/Context;Landroid/net/Uri;Lkotlin/jvm/functions/Function1;)Lzy0/b;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class LynxCentralManager$createCardOrNull$createCard$2 extends FunctionReferenceImpl implements Function3<Context, Uri, Function1<? super yy0.c, ? extends Unit>, zy0.b> {
    public LynxCentralManager$createCardOrNull$createCard$2(vy0.c r100) {
        super(3, r100, vy0.c.class, "createCardOrNull", "createCardOrNull(Landroid/content/Context;Landroid/net/Uri;Lkotlin/jvm/functions/Function1;)Lcom/bytedance/android/live/revenue/platform/hybrid/api/ui/IHybridCard;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final zy0.b invoke2(Context r100, Uri r101, Function1<? super yy0.c, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return ((vy0.c) this.receiver).J8(r100, r101, r102);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ zy0.b invoke(Context r100, Uri r101, Function1<? super yy0.c, ? extends Unit> r102) {
        return invoke2(r100, r101, r102);
    }
}

package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.live.broadcastgame.opengame.network.model.PassOpenApiCheck;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", com.alipay.sdk.m.p.e.f25671s, "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class LiveOpenGameClient$checkOpenApi$2 extends Lambda implements Function1<Method, Boolean> {
    public static final LiveOpenGameClient$checkOpenApi$2 INSTANCE = null;

    static {
        INSTANCE = new LiveOpenGameClient$checkOpenApi$2();
    }

    public LiveOpenGameClient$checkOpenApi$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Method r100) {
        Annotation[] r101 = r100.getAnnotations();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        Annotation r104 = r101[r103];
        if ((r104 instanceof PassOpenApiCheck) == true) goto L9;
        r103 = r103 + 1;
    L9:
        if (r104 != null) goto L14;
        return true;
    L14:
        return false;
    L8:
        r104 = null;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Method r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}

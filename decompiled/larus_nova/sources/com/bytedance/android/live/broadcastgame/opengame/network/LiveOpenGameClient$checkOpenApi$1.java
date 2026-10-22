package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", com.alipay.sdk.m.p.e.f25671s, "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class LiveOpenGameClient$checkOpenApi$1 extends Lambda implements Function1<Method, Boolean> {
    final /* synthetic */ Ref.ObjectRef $requestPath;

    public LiveOpenGameClient$checkOpenApi$1(Ref.ObjectRef r100) {
        this.$requestPath = r100;
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Method r100) {
        Ref.ObjectRef r101 = this.$requestPath;
        Annotation[] r102 = r100.getAnnotations();
        int r103 = r102.length;
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L15;
        Annotation r105 = r102[r104];
        if ((r105 instanceof GET) == false) goto L8;
    L11:
        boolean r106 = true;
    L12:
        if (r106 == true) goto L17;
        r104 = r104 + 1;
    L17:
        if ((r105 instanceof GET) == false) goto L20;
        T r107 = ((GET) r105).value();
    L23:
        r101.element = r107;
        return StringsKt.contains$default((String) this.$requestPath.element, "openapi", false, 2, null);
    L20:
        if ((r105 instanceof POST) == false) goto L22;
        r107 = ((POST) r105).value();
        goto L23
    L22:
        r107 = "";
        goto L23
    L8:
        if ((r105 instanceof POST) == true) goto L11;
        r106 = false;
        goto L12
    L15:
        r105 = null;
        goto L17
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Method r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}

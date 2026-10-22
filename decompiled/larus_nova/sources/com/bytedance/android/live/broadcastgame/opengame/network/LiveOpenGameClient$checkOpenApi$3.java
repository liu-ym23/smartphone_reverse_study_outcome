package com.bytedance.android.live.broadcastgame.opengame.network;

import android.os.Build;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "it", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class LiveOpenGameClient$checkOpenApi$3 extends Lambda implements Function1<Method, Method> {
    final /* synthetic */ List $openApiPathList;
    final /* synthetic */ Ref.ObjectRef $requestPath;

    public LiveOpenGameClient$checkOpenApi$3(List r100, Ref.ObjectRef r101) {
        this.$openApiPathList = r100;
        this.$requestPath = r101;
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Method invoke2(Method r100) {
        Type r101 = r100.getGenericReturnType();
        if ((r101 instanceof ParameterizedType) == true) goto L5;
        r101 = null;
    L5:
        ParameterizedType r102 = (ParameterizedType) r101;
        if (r102 != null) goto L8;
    L12:
        return r100;
    L8:
        if (Build.VERSION.SDK_INT < 28) goto L12;
        if (StringsKt.contains$default(r102.getActualTypeArguments()[0].getTypeName(), "OpenPlatformRespExtra", false, 2, null) == true) goto L12;
        this.$openApiPathList.add((String) this.$requestPath.element);
        goto L12
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Method invoke(Method r100) {
        return invoke2(r100);
    }
}

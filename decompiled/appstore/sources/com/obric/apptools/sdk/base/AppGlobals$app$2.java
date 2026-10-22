package com.obric.apptools.sdk.base;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/app/Application;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class AppGlobals$app$2 extends Lambda implements Function0<Application> {
    public static final AppGlobals$app$2 INSTANCE = null;

    static {
        INSTANCE = new AppGlobals$app$2();
    }

    public AppGlobals$app$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Application invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Application invoke() {
        Object r10 = Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
        if (r10 == null) goto L7;
        return (Application) r10;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }
}

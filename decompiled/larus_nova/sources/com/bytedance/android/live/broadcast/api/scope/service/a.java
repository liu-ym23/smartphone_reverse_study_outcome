package com.bytedance.android.live.broadcast.api.scope.service;

import android.content.Context;
import com.bytedance.android.live.broadcast.api.scope.RequireService;
import com.bytedance.android.live.core.utils.v;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a implements hs1.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f59071a;

    @Override // hs1.f
    public abstract /* synthetic */ Context getContext();

    public a() {
        this.f59071a = new b();
    }

    public final <T extends e> T a(Object r110, Class<T> r111) {
        Intrinsics.checkNotNullParameter(r110, "caller");
        Intrinsics.checkNotNullParameter(r111, "c");
        if (v.a() == false) goto L25;
        this.f59071a.getClass();
        Intrinsics.checkNotNullParameter(r110, "curObj");
        Intrinsics.checkNotNullParameter(r111, "c");
        Annotation[] r100 = r110.getClass().getAnnotations();
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        boolean r103 = false;
        int r104 = 0;
    L5:
        if (r104 >= r102) goto L10;
        Annotation r105 = r100[r104];
        if ((r105 instanceof RequireService) == false) goto L9;
        r101.add(r105);
    L9:
        r104 = r104 + 1;
        goto L5
    L10:
        RequireService r106 = (RequireService) CollectionsKt.firstOrNull(r101);
        if (r106 == null) goto L23;
        KClass[] r112 = Reflection.getOrCreateKotlinClasses(r106.value());
        int r107 = r112.length;
        int r108 = 0;
    L13:
        if (r108 >= r107) goto L18;
        if (Intrinsics.areEqual(JvmClassMappingKt.getJavaClass(r112[r108]), r111) == true) goto L16;
        r108 = r108 + 1;
        goto L13
    L16:
        r103 = true;
    L18:
        if (r103 == true) goto L25;
        throw new IllegalArgumentException("Service " + r111.getSimpleName() + " not declared in @RequireService annotation. Required: " + ArraysKt.joinToString$default(Reflection.getOrCreateKotlinClasses(r106.value()), null, null, null, 0, null, BroadcastScopeServiceChecker$checkScopeService$1.INSTANCE, 31, null));
    L23:
        throw new IllegalArgumentException("Widget " + Reflection.getOrCreateKotlinClass(r110.getClass()).getSimpleName() + " not declared @RequireService(" + r111.getSimpleName() + ") ");
    L25:
        return (T) ((com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.d) this).i().getService(r111);
    }
}

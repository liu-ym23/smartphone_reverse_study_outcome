package com.bytedance.android.sdk.bdticketguard;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class TicketGuardApiKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f163509a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f163510b = null;

    static {
        f163509a = new KProperty[]{Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinPackage(TicketGuardApiKt.class, "bd_ticket_guard_api_release"), "gson", "getGson()Lcom/google/gson/Gson;"))};
        f163510b = LazyKt.lazy(TicketGuardApiKt$gson$2.INSTANCE);
    }

    public static final Gson a() {
        Lazy r100 = f163510b;
        KProperty r101 = f163509a[0];
        return (Gson) r100.getValue();
    }
}

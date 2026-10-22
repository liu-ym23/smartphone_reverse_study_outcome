package com.bytedance.android.sdk.bdticketguard.init;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class TicketInitThreadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f163768a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f163769b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TicketInitThreadManager f163770c = null;

    static {
        f163768a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TicketInitThreadManager.class), "executors", "getExecutors()Ljava/util/Map;"))};
        f163770c = new TicketInitThreadManager();
        f163769b = LazyKt.lazy(TicketInitThreadManager$executors$2.INSTANCE);
    }

    public TicketInitThreadManager() {
    }
}

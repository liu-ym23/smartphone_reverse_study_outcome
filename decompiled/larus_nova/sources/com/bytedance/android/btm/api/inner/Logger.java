package com.bytedance.android.btm.api.inner;

import kotlin.Deprecated;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "use ALogger")
public final class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f41997a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final cd.c f41998b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f41999c = null;

    static {
        f41997a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(Logger.class), "logWriter", "getLogWriter()Lcom/bytedance/android/btm/api/inner/ILogWriter;"))};
        f41999c = new Logger();
        f41998b = new cd.c(Logger$logWriter$2.INSTANCE);
    }

    public Logger() {
    }
}

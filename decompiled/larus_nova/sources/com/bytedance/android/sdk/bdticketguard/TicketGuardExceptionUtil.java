package com.bytedance.android.sdk.bdticketguard;

import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes12.dex */
public final class TicketGuardExceptionUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f163521a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f163522b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TicketGuardExceptionUtil f163523c = null;

    static {
        f163521a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TicketGuardExceptionUtil.class), CloudControlInf.SP, "getSp()Landroid/content/SharedPreferences;"))};
        f163523c = new TicketGuardExceptionUtil();
        f163522b = LazyKt.lazy(TicketGuardExceptionUtil$sp$2.INSTANCE);
    }

    public TicketGuardExceptionUtil() {
    }
}

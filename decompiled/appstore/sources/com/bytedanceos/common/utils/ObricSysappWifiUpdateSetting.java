package com.bytedanceos.common.utils;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ObricSysappWifiUpdateSetting implements ValueFlow {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f10176c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AndroidContentFlow f10178b;

    /* JADX INFO: renamed from: com.bytedanceos.common.utils.ObricSysappWifiUpdateSetting$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Context, Continuation<? super Boolean>, Object>, SuspendFunction {
        public AnonymousClass1(Object r10) {
            super(2, r10, Companion.class, "readWifiUpdateEnabled", "readWifiUpdateEnabled(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull Context r10, @NotNull Continuation<? super Boolean> r11) {
            return ((Companion) this.receiver).a(r10, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(Context r10, Continuation<? super Boolean> r11) {
            return invoke2(r10, r11);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final Object a(Context r10, Continuation r11) {
            return kotlinx.coroutines.h.g(l0.b(), new ObricSysappWifiUpdateSetting$Companion$readWifiUpdateEnabled$2(r10, null), r11);
        }

        public final Object b(Context r10, boolean r11, Continuation r12) {
            com.bytedanceos.common.toolbox.j.n("SysAppWifiUpdate setWifiUpdateEnabled: " + r11);
            Object r13 = kotlinx.coroutines.h.g(l0.b(), new ObricSysappWifiUpdateSetting$Companion$setWifiUpdateEnabled$2(r10, r11, null), r12);
            if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L6;
            return r13;
        L6:
            return Unit.f21064a;
        }

        public Companion() {
        }
    }

    static {
        f10176c = new Companion(null);
    }

    public ObricSysappWifiUpdateSetting(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        this.f10177a = r10;
        Uri r11 = Settings.Global.getUriFor("obric_sysapp_wifi_update");
        kotlin.jvm.internal.q.f(r11, "getUriFor(...)");
        this.f10178b = new AndroidContentFlow(r10, r11, new AnonymousClass1(f10176c));
    }

    public final Object a(boolean r10, Continuation r11) {
        Object r12 = f10176c.b(this.f10177a, r10, r11);
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r12;
    L6:
        return Unit.f21064a;
    }

    @Override // com.bytedanceos.common.utils.ValueFlow
    public Flow values() {
        return this.f10178b.values();
    }
}

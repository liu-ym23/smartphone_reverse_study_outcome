package com.bytedanceos.common.utils;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import kotlin.Metadata;
import kotlin.Result;
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
public final class DeviceProvision implements ValueFlow {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f10163c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AndroidContentFlow f10165b;

    /* JADX INFO: renamed from: com.bytedanceos.common.utils.DeviceProvision$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Context, Continuation<? super Boolean>, Object>, SuspendFunction {
        public AnonymousClass1(Object r10) {
            super(2, r10, Companion.class, "readProvisioned", "readProvisioned(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
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
            return kotlinx.coroutines.h.g(l0.b(), new DeviceProvision$Companion$readProvisioned$2(r10, null), r11);
        }

        public final boolean b(Context r10) {
            kotlin.jvm.internal.q.g(r10, "context");
            Result.a r11 = Result.Companion;     // Catch: Throwable -> L9
            boolean r12 = true;
            if (Settings.Global.getInt(r10.getContentResolver(), "device_provisioned", 1) == 1) goto L7;
            r12 = false;
        L7:
            Object r13 = Result.m35constructorimpl(Boolean.valueOf(r12));     // Catch: Throwable -> L9
        L11:
            Boolean r14 = Boolean.FALSE;
            if (Result.m41isFailureimpl(r13) == false) goto L15;
            r13 = r14;
        L15:
            return ((Boolean) r13).booleanValue();
        L9:
            th = move-exception;
            Result.a r15 = Result.Companion;
            r13 = Result.m35constructorimpl(kotlin.c.a(th));
            goto L11
        }

        public Companion() {
        }
    }

    static {
        f10163c = new Companion(null);
    }

    public DeviceProvision(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        this.f10164a = r10;
        Uri r11 = Settings.Global.getUriFor("device_provisioned");
        kotlin.jvm.internal.q.f(r11, "getUriFor(...)");
        this.f10165b = new AndroidContentFlow(r10, r11, new AnonymousClass1(f10163c));
    }

    @Override // com.bytedanceos.common.utils.ValueFlow
    public Flow values() {
        return this.f10165b.values();
    }
}

package com.bytedance.android.ec.host.impl;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.timon.calendar.EventRecord;
import com.bytedance.timon.calendar.ResultCode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements ej.c {

    public static final class a implements com.bytedance.timon.calendar.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ej.b f46203a;

        public a(ej.b r100) {
            this.f46203a = r100;
        }

        @Override // com.bytedance.timon.calendar.a
        public final void a(boolean r100, ResultCode r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "errorCode");
            Intrinsics.checkNotNullParameter(r102, "msg");
            this.f46203a.onResult(r100, r101.getValue(), r102);
        }
    }

    public f() {
    }

    @Override // ej.c
    public final void a(final Activity r100, String r101, ej.a r102, ej.b r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r102, "calendarData");
        Intrinsics.checkNotNullParameter(r103, "callback");
        if ((r100 instanceof FragmentActivity) == true) goto L5;
        return;
    L5:
        Function1<? super com.bytedance.timon.calendar.b, Unit> r104 = com.bytedance.timon.calendar.c.f270568a;
        FragmentActivity r105 = (FragmentActivity) r100;
        com.bytedance.timon.calendar.c.b(r105.getBaseContext());
        Function1<? super com.bytedance.timon.calendar.b, Unit> r106 = new d(r100);
        Intrinsics.checkNotNullParameter(r106, "invoker");
        com.bytedance.timon.calendar.c.f270568a = r106;
        Context r107 = r105.getBaseContext();
        EventRecord r108 = new EventRecord();
        r108.C(r102.f472831d);
        r108.t(r102.f472832e);
        r108.D(r102.f472829b);
        r108.s(r102.f472830c);
        r108.u(r102.f472828a);
        Unit r109 = Unit.INSTANCE;
        com.bytedance.timon.calendar.c.c(r107, r108, new a(r103));
    }
}

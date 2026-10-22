package com.bytedance.android.livesdk.castscreen.utils;

import com.bytedance.android.live.core.log.ALogger;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class LivePadPcTrace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LivePadPcTrace f104724a = null;

    public static final class AlogParamsBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Throwable f104725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Lazy f104726b;

        public final void c() {
            LivePadPcTrace r100 = LivePadPcTrace.f104724a;
            String r101 = ((StringBuilder) this.f104726b.getValue()).toString();
            Throwable r102 = this.f104725a;
            Intrinsics.checkNotNullParameter(r101, "msg");
            r100.getClass();
            if (r102 == null) goto L5;
            ALogger.e("LivePadPcTrace", r101, r102);
            return;
        L5:
            ALogger.i("LivePadPcTrace", r101);
            Unit r103 = Unit.INSTANCE;
        }

        public AlogParamsBuilder() {
            this.f104726b = LazyKt.lazy(LivePadPcTrace$AlogParamsBuilder$strBuilder$2.INSTANCE);
        }

        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            ((StringBuilder) this.f104726b.getValue()).append(r100 + '.');
        }

        public final void d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            ((StringBuilder) this.f104726b.getValue()).append("tag:" + r100 + '\t');
        }

        public final void a(String r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            ((StringBuilder) this.f104726b.getValue()).append("the " + r100 + " is " + r101 + '.');
        }
    }

    public LivePadPcTrace() {
    }

    static {
        f104724a = new LivePadPcTrace();
    }

    public static void a(Function1 r100) {
        AlogParamsBuilder r101 = new AlogParamsBuilder();
        r100.invoke(r101);
        String r102 = ((StringBuilder) r101.f104726b.getValue()).toString();
        Throwable r103 = r101.f104725a;
        Intrinsics.checkNotNullParameter(r102, "msg");
        f104724a.getClass();
        if (r103 == null) goto L5;
        ALogger.e("LivePadPcTrace", r102, r103);
        return;
    L5:
        ALogger.i("LivePadPcTrace", r102);
        Unit r104 = Unit.INSTANCE;
    }

    @JvmStatic
    public static final String b(Collection r100) {
        Intrinsics.checkNotNullParameter(" ", "split");
        StringBuilder r101 = new StringBuilder();
        if (r100 == null) goto L13;
        Iterator r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        if (r103 == null) goto L10;
        String r104 = r103.toString();
    L11:
        r101.append(r104);
        r101.append(" ");
        goto L6
    L10:
        r104 = null;
    L13:
        return r101.toString();
    }
}

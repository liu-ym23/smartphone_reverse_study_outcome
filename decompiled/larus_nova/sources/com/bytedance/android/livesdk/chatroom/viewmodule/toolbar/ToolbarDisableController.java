package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class ToolbarDisableController {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f115737c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f115738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f115739b;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f115740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f115741b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (this.f115740a == r101.f115740a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f115741b, r101.f115741b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public final int hashCode() {
            boolean r100 = this.f115740a;
            ?? r101 = r100;
            if (r100 == false) goto L5;
            r101 = 1;
        L5:
            int r102 = r101 * 31;
            String r103 = this.f115741b;
            if (r103 == null) goto L8;
            int r104 = r103.hashCode();
        L10:
            return r102 + r104;
        L8:
            r104 = 0;
            goto L10
        }

        public final String toString() {
            return "ToolbarStatus(isDisable=" + this.f115740a + ", prompt=" + this.f115741b + ")";
        }

        public b(boolean r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, EventConstant.Key.RETAIN_PROMPT);
            this.f115740a = r100;
            this.f115741b = r101;
        }
    }

    static {
    }

    public final Context getContext() {
        return this.f115739b;
    }

    public ToolbarDisableController(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f115739b = r100;
        this.f115738a = LazyKt.lazy(ToolbarDisableController$cacheStatus$2.INSTANCE);
    }

    public final void b(x3 r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Iterator r101 = ((Map) this.f115738a.getValue()).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry r102 = (Map.Entry) r101.next();
        if (((b) r102.getValue()).f115740a == true) goto L7;
        r100.h((ExtendedToolbarButton) r102.getKey());
        goto L4
    L7:
        r100.l((ExtendedToolbarButton) r102.getKey(), ((b) r102.getValue()).f115741b);
        goto L4
    L9:
        ((Map) this.f115738a.getValue()).clear();
    }

    public final void a(x3 r100, List r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Intrinsics.checkNotNullParameter(r101, "buttons");
        Intrinsics.checkNotNullParameter(r102, "condition");
        if (((Map) this.f115738a.getValue()).isEmpty() == false) goto L8;
        Iterator r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        ExtendedToolbarButton r104 = (ExtendedToolbarButton) r103.next();
        ((Map) this.f115738a.getValue()).put(r104, new b(r100.x(r104), r100.u(r104)));
    L8:
        Iterator r105 = r101.iterator();
    L10:
        if (r105.hasNext() == false) goto L14;
        ExtendedToolbarButton r106 = (ExtendedToolbarButton) r105.next();
        if (((Boolean) r102.invoke(r106)).booleanValue() == false) goto L10;
        r100.l(r106, this.f115739b.getString(R.string.ttlive_broadcast_voluntary_pause_feature_enable_toast));
        goto L10
    }
}

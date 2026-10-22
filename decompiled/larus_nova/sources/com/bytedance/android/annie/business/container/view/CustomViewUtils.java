package com.bytedance.android.annie.business.container.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.container.fragment.flavor.fail.FailSubFragmentProxy;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import ia.c;
import ia.i;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class CustomViewUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f39000a = 0;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f39001a;

        public a(c r100) {
            this.f39001a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            c r101 = this.f39001a;
            if (r101 == null) goto L6;
            r101.reload(null);
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f39002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FailSubFragmentProxy f39003b;

        public b(c r100, FailSubFragmentProxy r101) {
            this.f39002a = r100;
            this.f39003b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            c r101 = this.f39002a;
            if ((r101 instanceof i) == false) goto L5;
            this.f39003b.c();
            return;
        L5:
            if (r101 == null) goto L9;
            r101.close();
            return;
        }
    }

    static {
    }

    public static View b(ViewGroup r100, Context r101, String r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "bizKey");
        v7.b r104 = u7.b.b(new u7.c(0), r100, r101, r102);
        if (r103 == null) goto L5;
        r103.invoke(r104);
    L5:
        View r105 = r104.b();
        r104.d();
        return r105;
    }

    public static View a(ViewGroup r100, Context r101, final c r102, Map r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r104, "bizKey");
        FailSubFragmentProxy r105 = u7.b.a(r100, r101, r103, r104);
        View r106 = r105.b();
        r105.f(r106, new CustomViewUtils$createErrorView$1$1(r102));
        View r107 = r106.findViewById(R.id.web_retry);
        if (r107 == null) goto L5;
        r107.setOnClickListener(new a(r102));
    L5:
        View r108 = r106.findViewById(R.id.fail_close);
        if (r108 == null) goto L8;
        r108.setOnClickListener(new b(r102, r105));
    L8:
        return r106;
    }
}

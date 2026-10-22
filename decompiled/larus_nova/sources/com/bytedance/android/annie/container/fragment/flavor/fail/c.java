package com.bytedance.android.annie.container.fragment.flavor.fail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c extends FailSubFragmentProxy {

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f39358a;

        public a(Function0<Unit> r100) {
            this.f39358a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0<Unit> r101 = this.f39358a;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    @Override // u7.a
    public final View b() {
        return LayoutInflater.from(getContext()).inflate(R.layout.annie_web_fail_sjb, this.f549022b, false);
    }

    public c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        super(r100, r101);
    }

    @Override // com.bytedance.android.annie.container.fragment.flavor.fail.FailSubFragmentProxy
    public final void f(View r100, Function0<Unit> r101) {
        if (r100 == null) goto L7;
        View r102 = r100.findViewById(R.id.web_retry);
        if (r102 == null) goto L8;
        r102.setOnClickListener(new a(r101));
        return;
    L8:
        return;
    }
}

package com.bytedance.android.annie.container.fragment.flavor.fail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.util.m;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends FailSubFragmentProxy {

    /* JADX INFO: renamed from: com.bytedance.android.annie.container.fragment.flavor.fail.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0733a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f39356a;

        public ViewOnClickListenerC0733a(Function0<Unit> r100) {
            this.f39356a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0<Unit> r101 = this.f39356a;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    @Override // u7.a
    public final View b() {
        boolean r100 = m.c();
        LayoutInflater r101 = LayoutInflater.from(getContext());
        if (r100 == true) goto L5;
        int r102 = R.layout.annie_web_fail_dark;
    L6:
        View r103 = r101.inflate(r102, this.f549022b, false);
        g(r103, R.drawable.annie_web_fail_bg_pop_center_dark);
        return r103;
    L5:
        r102 = R.layout.annie_web_fail_dark_landscape;
        goto L6
    }

    public a(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        super(r100, r101);
    }

    @Override // com.bytedance.android.annie.container.fragment.flavor.fail.FailSubFragmentProxy
    public final void f(View r100, Function0<Unit> r101) {
        if (r100 == null) goto L7;
        View r102 = r100.findViewById(R.id.web_retry);
        if (r102 == null) goto L8;
        r102.setOnClickListener(new ViewOnClickListenerC0733a(r101));
        return;
    L8:
        return;
    }
}

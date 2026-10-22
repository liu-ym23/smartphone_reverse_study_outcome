package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.bytedance.common.utility.UIUtils;
import com.google.android.material.tabs.TabLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class d0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f93480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f93481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f93482c;

    public d0(f0 r100, Context r101) {
        this.f93480a = r100;
        this.f93481b = r101;
        this.f93482c = "巅峰赛已开启";
    }

    public final void a() {
        View r100 = this.f93480a.f93487a;
        if (r100 == null) goto L7;
        View r101 = r100.findViewById(R.id.tab);
        if (r101 == null) goto L7;
        KProperty[] r102 = com.bytedance.android.live.revlink.impl.behavior.o.f92183a;
        TabLayout.Tab r103 = ((TabLayout) r101).getTabAt(2);
    L8:
        Object r104 = JavaCalls.getField(r103, "view");
        if ((r104 instanceof View) == true) goto L11;
        r104 = null;
    L11:
        View r105 = (View) r104;
        if (r105 != null) goto L14;
        return;
    L14:
        f0 r106 = this.f93480a;
        yo2.d<?> r107 = r106.f93488b;
        if (r107 == null) goto L17;
        Intrinsics.checkNotNull(r107);
        r107.d();
        r106.f93488b = null;
    L17:
        View r108 = LayoutInflater.from(this.f93481b).inflate(R.layout.ttlive_view_popup_pk_tip, null);
        ((TextView) r108.findViewById(R.id.tv_interact_tip)).setText(this.f93482c);
        f0 r109 = this.f93480a;
        yo2.e r110 = new yo2.e(this.f93481b);
        r110.f568642d = r108;
        r110.f568643e = 0;
        r110.f568651m = 5;
        r110.f568650l = true;
        r110.a();
        r109.f93488b = r110;
        yo2.d<?> r111 = this.f93480a.f93488b;
        if (r111 == null) goto L20;
        r111.i(r105, 1, 0, s1.f(25.0f), s1.f(15.0f));
    L20:
        UIUtils.updateLayoutMargin(r108.findViewById(R.id.iv_interact_tip_arrow), s1.f(14.0f), -3, -3, -3);
        return;
    L7:
        r103 = null;
        goto L8
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

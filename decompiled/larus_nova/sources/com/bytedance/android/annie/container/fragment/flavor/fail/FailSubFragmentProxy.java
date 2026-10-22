package com.bytedance.android.annie.container.fragment.flavor.fail;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.android.annie.util.p;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class FailSubFragmentProxy extends u7.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f39350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f39351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f39352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f39353g;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FailSubFragmentProxy f39354a;

        public a(FailSubFragmentProxy r100) {
            this.f39354a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0<Unit> r101 = this.f39354a.f39352f;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FailSubFragmentProxy f39355a;

        public b(FailSubFragmentProxy r100) {
            this.f39355a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FailSubFragmentProxy r100 = this.f39355a;     // Catch: Throwable -> L7
            if (r100.f39350d != null) goto L5;
            r100.a();     // Catch: Throwable -> L7
        L5:
            FailSubFragmentProxy.e(this.f39355a);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public abstract void f(View r100, Function0<Unit> r101);

    @Override // u7.a
    public final void d() {
        ThreadUtils.c(new b(this));
    }

    @Override // u7.a
    public final View a() {
        View r100 = super.a();
        this.f39350d = r100;
        Intrinsics.checkNotNull(r100);
        f(r100, new FailSubFragmentProxy$createAndInsertView$1$1(this));
        return r100;
    }

    public static final /* synthetic */ void e(FailSubFragmentProxy r100) {
        super.d();
    }

    public FailSubFragmentProxy(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        super(r100, r101);
        this.f39353g = new HashMap();
    }

    public final void g(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        String r102 = (String) ((HashMap) this.f39353g).get("is_popup");
        Integer r103 = null;
        if (r102 == null) goto L5;
        Boolean r104 = Boolean.valueOf(Boolean.parseBoolean(r102));
    L6:
        String r105 = (String) ((HashMap) this.f39353g).get("is_bottom_popup");
        if (r105 == null) goto L9;
        Boolean r106 = Boolean.valueOf(Boolean.parseBoolean(r105));
    L10:
        String r107 = (String) ((HashMap) this.f39353g).get("popup_width");
        if (r107 == null) goto L13;
        r103 = Integer.valueOf(CastIntegerProtector.parseInt(r107));
    L13:
        if (r103 != null) goto L15;
    L19:
        boolean r108 = false;
    L20:
        Boolean r109 = Boolean.TRUE;
        if (Intrinsics.areEqual(r104, r109) == false) goto L33;
        ImageView r110 = (ImageView) r100.findViewById(R.id.fail_background);
        if (r110 == null) goto L33;
        if (Intrinsics.areEqual(r106, Boolean.FALSE) == false) goto L31;
        if (r108 == false) goto L31;
        if (r101 <= 0) goto L29;
        p r111 = p.f40070a;
        Context r112 = getContext();
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        r110.setImageDrawable(r112.getResources().getDrawable(r101));
    L29:
        ViewGroup.LayoutParams r113 = r110.getLayoutParams();
        p r114 = p.f40070a;
        r113.height = r114.a(60.0f);
        r113.width = r114.a(60.0f);
        r110.setLayoutParams(r113);
    L31:
        if (Intrinsics.areEqual(r106, r109) == false) goto L33;
        ViewGroup.LayoutParams r115 = r110.getLayoutParams();
        p r116 = p.f40070a;
        r115.height = r116.a(128.0f);
        r115.width = r116.a(172.0f);
        r110.setLayoutParams(r115);
    L33:
        View r117 = r100.findViewById(R.id.fail_close);
        if (r117 == null) goto L37;
        r117.setOnClickListener(new a(this));
        return;
    L37:
        return;
    L15:
        if (r103.intValue() <= 0) goto L19;
        if (r103.intValue() >= p.f40070a.a(310.0f)) goto L19;
        r108 = true;
        goto L20
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}

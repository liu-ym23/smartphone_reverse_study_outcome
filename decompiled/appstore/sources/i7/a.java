package i7;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.AppStoreActivity;
import com.bytedanceos.appstore.buss.beta.fragment.ContainerContentFragment;
import com.bytedanceos.appstore.buss.beta.fragment.container.ContainerJumpFragment;
import com.bytedanceos.appstore.buss.beta.fragment.container.ContainerPrimaryFragment;
import com.bytedanceos.appstore.buss.beta.fragment.container.ContainerSearchFragment;
import com.bytedanceos.appstore.buss.utilities.j;
import com.obric.appstore.R;
import f9.b;
import h7.c;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final void a(View r10, String r11, String r12, int r13) {
        q.g(r10, "<this>");
        Context r14 = r10.getContext();
        if ((r14 instanceof AppStoreActivity) == true) goto L5;
        return;
    L5:
        Fragment r15 = ((AppStoreActivity) r14).L();
        if (r15 != null) goto L8;
        return;
    L8:
        if ((r15 instanceof ContainerPrimaryFragment) == false) goto L16;
        Fragment r16 = ((ContainerPrimaryFragment) r15).I();
        if (r16 != null) goto L12;
        return;
    L12:
        if ((r16 instanceof ContainerContentFragment) == false) goto L18;
        Fragment r17 = ((ContainerContentFragment) r16).H();
        q.e(r17, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.base.BaseFragment");
        Bundle r18 = new Bundle();
        r18.putString("widget_title", r11);
        r18.putString("widget_type", r12);
        r18.putString("widget_position", String.valueOf(r13));
        r18.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, ((c) r17).p());
        b.b("click_transverse_control_more", r18);
        return;
    L18:
        return;
    }

    public static final void b(FragmentManager r10) {
        if (r10.q0() < 5) goto L6;
        r10.h1(null, 1);
        return;
    }

    public static final void c(Fragment r10, Fragment r11, int r12) {
        Context r13 = r10.getContext();
        if ((r13 instanceof AppStoreActivity) == true) goto L5;
        return;
    L5:
        ((AppStoreActivity) r13).R(r11);
        FragmentManager r14 = r10.getChildFragmentManager();
        q.f(r14, "getChildFragmentManager(...)");
        b(r14);
        r10.getChildFragmentManager().o().u(r12, r11).h(null).j();
    }

    public static /* synthetic */ void d(Fragment r10, Fragment r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = R.id.fl_container;
    L5:
        c(r10, r11, r12);
    }

    public static final void e(View r10, Fragment r11) {
        q.g(r10, "<this>");
        q.g(r11, "fragment");
        Context r12 = r10.getContext();
        if ((r12 instanceof AppStoreActivity) == true) goto L5;
        return;
    L5:
        Fragment r13 = ((AppStoreActivity) r12).L();
        if ((r13 instanceof ContainerPrimaryFragment) == false) goto L11;
        Fragment r14 = ((ContainerPrimaryFragment) r13).I();
        if (r14 == null) goto L18;
        d(r14, r11, 0, 2, null);
        return;
    L18:
        return;
    L11:
        if ((r13 instanceof ContainerSearchFragment) == false) goto L14;
        d(r13, r11, 0, 2, null);
        return;
    L14:
        if ((r13 instanceof ContainerJumpFragment) == false) goto L16;
        d(r13, r11, 0, 2, null);
        return;
    L16:
        j.f8856a.c("not support fragment to replaced");
    }

    public static final void f(Fragment r10, Fragment r11, boolean r12) {
        q.g(r10, "<this>");
        q.g(r11, "fragment");
        Context r13 = r10.getContext();
        if ((r13 instanceof AppStoreActivity) == true) goto L5;
        return;
    L5:
        ((AppStoreActivity) r13).R(r11);
        FragmentManager r14 = r10.getParentFragmentManager();
        q.f(r14, "getParentFragmentManager(...)");
        b(r14);
        FragmentManager r15 = r10.getParentFragmentManager();
        q.f(r15, "getParentFragmentManager(...)");
        FragmentTransaction r16 = r15.o();
        q.f(r16, "beginTransaction()");
        r16.u(R.id.fl_container, r11);
        if (r12 == false) goto L8;
        r16.h(null);
    L8:
        r16.j();
    }

    public static /* synthetic */ void g(Fragment r10, Fragment r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = true;
    L5:
        f(r10, r11, r12);
    }
}

package com.bytedance.ai.applet.login;

import com.bytedance.ai.api.model.view.WidgetEvent;
import k2.u;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class l implements u {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34771a = null;

        static {
            int[] r100 = new int[WidgetEvent.values().length];
            r100[WidgetEvent.SCROLL_TO_BOTTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[WidgetEvent.PAGE_UPDATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[WidgetEvent.TIMING_SETUP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f34771a = r100;
        }
    }

    public l() {
    }

    @Override // k2.u
    public final void a() {
        com.bytedance.ai.utils.g.f37637a.d("LoginProcessor", "widgetLifeCycle onPageStart");
    }

    @Override // k2.u
    public final void b() {
        com.bytedance.ai.utils.g.f37637a.d("LoginProcessor", "widgetLifeCycle onPageError");
    }

    @Override // k2.u
    public final void c() {
        com.bytedance.ai.utils.g.f37637a.d("LoginProcessor", "widgetLifeCycle onPageFinish");
    }

    @Override // k2.u
    public final void onDestroy() {
        com.bytedance.ai.utils.g.f37637a.d("LoginProcessor", "widgetLifeCycle onDestroy");
    }

    @Override // k2.u
    public final void onStart() {
        com.bytedance.ai.utils.g.f37637a.d("LoginProcessor", "widgetLifeCycle onStart");
    }

    @Override // k2.u
    public void onEvent(WidgetEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = a.f34771a[r100.ordinal()];
        if (r101 != 1) goto L5;
        com.bytedance.ai.utils.g.f37637a.d("LoginProcessor", "widgetLifeCycle onEvent SCROLL_TO_BOTTOM");
        return;
    L5:
        if (r101 != 2) goto L7;
        com.bytedance.ai.utils.g.f37637a.d("LoginProcessor", "widgetLifeCycle onEvent PAGE_UPDATE");
        return;
    L7:
        if (r101 != 3) goto L10;
        com.bytedance.ai.utils.g.f37637a.d("LoginProcessor", "widgetLifeCycle onEvent TIMING_SETUP");
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}

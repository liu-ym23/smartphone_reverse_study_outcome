package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Maybe;

/* JADX INFO: loaded from: classes8.dex */
public interface c0 {

    public interface a extends b {
        Maybe<Drawable> getIcon();

        Maybe<String> getTitle();
    }

    public interface b extends View.OnClickListener {
        void Bh(ToolbarButton r100);

        void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100);

        void R9(View r100, DataCenter r101);

        void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100);

        void Y6();

        void dv(e r100);

        com.bytedance.android.livesdk.reddot.a h7();

        void onHide(boolean r100);

        void p4(View r100, DataCenter r101);

        void setAlpha(float r100);

        boolean showRedDot();
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExtendedToolbarButton f115857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f115858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f115859c;

        public c(ExtendedToolbarButton r100, b r101, boolean r102) {
            this.f115857a = r100;
            this.f115858b = r101;
            this.f115859c = r102;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExtendedToolbarButton f115860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f115861b;

        public d(ExtendedToolbarButton r100, boolean r101) {
            this.f115860a = r100;
            this.f115861b = r101;
        }
    }

    void a(ToolbarButton r100, String r101);

    void b(ToolbarButton r100, e r101);

    void c(ExtendedToolbarButton r100);

    void d(ToolbarButton r100, b r101);

    void e(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100, b r101);

    void f(ExtendedToolbarButton r100, b r101);

    boolean g(ToolbarButton r100);

    void h(ExtendedToolbarButton r100);

    void i(ExtendedToolbarButton r100);

    String j(ToolbarButton r100);

    void k(ToolbarButton r100, b r101);

    void l(ExtendedToolbarButton r100, String r101);

    void m(com.bytedance.android.livesdk.chatroom.utils.c0 r100);

    boolean n(ToolbarButton r100);

    void o(ToolbarButton r100);

    void p(ExtendedToolbarButton r100, b r101);
}

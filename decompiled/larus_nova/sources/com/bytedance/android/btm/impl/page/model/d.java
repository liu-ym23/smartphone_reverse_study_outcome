package com.bytedance.android.btm.impl.page.model;

import com.bytedance.android.btm.impl.setting.BtmSetting;

/* JADX INFO: loaded from: classes43.dex */
public interface d extends xc.a<d> {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final a f42336d0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f42337a = null;

        public a() {
        }

        static {
            f42337a = new a();
        }

        public static d a(Object r100) {
            if (BtmSetting.f42469d.c().d().q() != 1) goto L6;
            return new f(r100);
        L6:
            return new e(r100);
        }
    }

    static {
        f42336d0 = a.f42337a;
    }

    Object a();

    h b();

    void c(d r100);

    String d();

    void e(boolean r100, boolean r101);

    void f(String r100);

    void g(d r100);

    d getParentNode();

    String h();

    boolean i();

    boolean isContainer();

    d j();
}

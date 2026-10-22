package com.bytedance.android.live.liveinteract.plantform.camera;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: classes46.dex */
public interface b {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final a f75524o0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f75525a = null;

        public a() {
        }

        static {
            f75525a = new a();
        }

        public static b a() {
            DataContext r100 = d.d("ISwitchCameraManager");
            if ((r100 instanceof SwitchCameraContext) == true) goto L5;
            r100 = null;
        L5:
            SwitchCameraContext r101 = (SwitchCameraContext) r100;
            if (r101 == null) goto L11;
            j<b> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.camera.b$b, reason: collision with other inner class name */
    public static final class C1184b {
        public static /* synthetic */ void a(b r100, boolean r110, boolean r111, boolean r112, boolean r113, String r114, int r115) {
            if ((r115 & 4) == 0) goto L5;
            boolean r101 = false;
        L7:
            if ((r115 & 8) == 0) goto L9;
            boolean r102 = false;
        L10:
            r100.f(r110, r111, r101, r102, null, r114);
            return;
        L9:
            r102 = r113;
            goto L10
        L5:
            r101 = r112;
            goto L7
        }
    }

    static {
        f75524o0 = a.f75525a;
    }

    boolean a();

    void b(String r100, boolean r101);

    int c(String r100);

    boolean d(String r100);

    boolean e();

    void f(boolean r100, boolean r101, boolean r102, boolean r103, com.bytedance.android.live.liveinteract.plantform.camera.a r104, String r105);

    void g();
}

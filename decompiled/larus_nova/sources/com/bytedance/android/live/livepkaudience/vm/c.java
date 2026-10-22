package com.bytedance.android.live.livepkaudience.vm;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: classes46.dex */
public interface c {
    public static final a A0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f82367a = null;

        public a() {
        }

        static {
            f82367a = new a();
        }

        public static c a() {
            DataContext r100 = d.d("ILinkPkSwitchCameraManager");
            if ((r100 instanceof LinkPkSwitchCameraContext) == true) goto L5;
            r100 = null;
        L5:
            LinkPkSwitchCameraContext r101 = (LinkPkSwitchCameraContext) r100;
            if (r101 == null) goto L11;
            j<c> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    public static final class b {
        public static /* synthetic */ void a(c r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, int r116) {
            if ((r116 & 4) == 0) goto L5;
            boolean r100 = false;
        L7:
            if ((r116 & 8) == 0) goto L9;
            boolean r101 = false;
        L11:
            if ((r116 & 32) == 0) goto L13;
            boolean r102 = false;
        L14:
            r110.f(r111, r112, r100, r101, false, r102, null);
            return;
        L13:
            r102 = r115;
            goto L14
        L9:
            r101 = r114;
            goto L11
        L5:
            r100 = r113;
            goto L7
        }
    }

    static {
        A0 = a.f82367a;
    }

    boolean a();

    void b(String r100, boolean r101);

    int c(String r100);

    boolean d(String r100);

    boolean e();

    void f(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, com.bytedance.android.live.livepkaudience.vm.a r106);
}

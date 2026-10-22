package b83;

import c63.c;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f18012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f18013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f18014c;

    public a(c r100) {
        this.f18014c = r100;
        this.f18012a = -1;
    }

    public static void a(a r100, boolean r101, boolean r102, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r110 & 2) == 0) goto L8;
        r102 = false;
    L8:
        if (r101 == false) goto L11;
        String r103 = DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON;
    L10:
        String r104 = r103;
        c r105 = r100.f18014c;
        if (r105 == null) goto L33;
        b r106 = r100.f18013b;
        if (r106 == null) goto L19;
        int r111 = b.f164968f;
        String r107 = r106.k(null);
    L20:
        b r108 = r100.f18013b;
        if (r108 == null) goto L23;
        Integer r109 = r108.h();
    L24:
        b r112 = r100.f18013b;
        if (r112 == null) goto L27;
        String r113 = r112.f164969a;
    L28:
        if (r112 == null) goto L30;
        String r114 = r112.j();
    L31:
        r105.x(com.bytedance.android.ec.core.event.a.VALUE_MAIN_PICTURE, r104, r107, r109, r113, r114);
        return;
    L30:
        r114 = null;
        goto L31
    L27:
        r113 = null;
        goto L28
    L23:
        r109 = null;
        goto L24
    L19:
        r107 = null;
        goto L20
    L33:
        return;
    L11:
        if (r102 == false) goto L13;
        r103 = "click_tab";
        goto L10
    L13:
        r103 = "auto";
        goto L10
    }
}

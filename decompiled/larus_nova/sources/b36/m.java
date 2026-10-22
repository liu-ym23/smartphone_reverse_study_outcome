package b36;

import android.net.Uri;
import android.webkit.PermissionRequest;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class m implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PermissionRequest f17188a;

    @Override // b36.b
    public final void a() {
        PermissionRequest r100 = this.f17188a;
        ArrayList r110 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102606);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r103 = r102;
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r103[r105];
        int r113 = r105;
        int r114 = r104;
        f06.a[] r115 = r103;
        f06.d r107 = r106.preInvoke(102606, "android/webkit/PermissionRequest", "deny", r100, r111, "void", r112);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r110.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == true) goto L27;
        r100.deny();
        return;
    L27:
        return;
    L14:
        r105 = r113 + 1;
        r104 = r114;
        r103 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // b36.b
    public final Uri getOrigin() {
        return this.f17188a.getOrigin();
    }

    @Override // b36.b
    public String[] getResources() {
        String[] r100 = this.f17188a.getResources();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new String[0];
    }

    public m(PermissionRequest r100) {
        this.f17188a = r100;
    }

    @Override // b36.b
    public final void b(String[] r210) {
        Intrinsics.checkNotNullParameter(r210, "resources");
        PermissionRequest r110 = this.f17188a;
        ArrayList r111 = new ArrayList();
        Object[] r112 = {r210};
        f06.b r113 = new f06.b();
        g06.a r100 = ApiHookConfig.f245611b.get(102605);
        if (r100 == null) goto L5;
        f06.a[] r101 = r100.f479473i;
    L6:
        f06.a[] r102 = r101;
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r102[r104];
        int r114 = r104;
        int r115 = r103;
        f06.a[] r211 = r102;
        f06.d r106 = r105.preInvoke(102605, "android/webkit/PermissionRequest", "grant", r110, r112, "void", r113);     // Catch: Exception -> L21
        if (r106.f474982a == true) goto L17;
        r111.add(r105);     // Catch: Exception -> L21
    L17:
        if (r106.f474982a == true) goto L27;
        r110.grant(r210);
        return;
    L27:
        return;
    L14:
        r104 = r114 + 1;
        r103 = r115;
        r102 = r211;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r101 = ApiHookConfig.f245613d;
        goto L6
    }
}

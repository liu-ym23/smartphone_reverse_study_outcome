package b94;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpContextService;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f18247a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f18248b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f18249c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f18250d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j f18251e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0281c f18252f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l f18253g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f18254h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f18255i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f18256j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final k f18257k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final m f18258l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final g f18259m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final n f18260n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final r f18261o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final f f18262p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final h f18263q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final d f18264r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final List<b94.b> f18265s = null;

    public static final class a extends b94.b {
        public a() {
            super("scope.address");
        }

        @Override // b94.b
        public final String a(Context r100) {
            return com.bytedance.bdp.bdpbase.util.o.b(r100, R.string.bdp_auth_permission_address_miniapp);
        }
    }

    public static final class b extends b94.b {
        public b() {
            super("scope.album");
        }

        @Override // b94.b
        public final String a(Context r100) {
            return com.bytedance.bdp.bdpbase.util.o.b(r100, R.string.bdp_auth_permission_album);
        }
    }

    /* JADX INFO: renamed from: b94.c$c, reason: collision with other inner class name */
    public static final class C0281c extends b94.b {
        @Override // b94.b
        public final boolean c() {
            return false;
        }

        public C0281c() {
            super("scope.userLocation");
        }

        @Override // b94.b
        public final String a(Context r100) {
            return com.bytedance.bdp.bdpbase.util.o.b(r100, R.string.bdp_auth_permission_location);
        }
    }

    public static final class d extends b94.b {
        public d() {
            super("scope.calendar");
        }

        @Override // b94.b
        public final String a(Context r100) {
            return com.bytedance.bdp.bdpbase.util.o.b(r100, R.string.bdp_auth_acquire_calendar);
        }
    }

    public static final class e extends b94.b {
        public e() {
            super("scope.camera");
        }

        @Override // b94.b
        public final String a(Context r100) {
            return com.bytedance.bdp.bdpbase.util.o.b(r100, R.string.bdp_auth_permission_camera_miniapp);
        }
    }

    public static final class f extends b94.b {
        public f() {
            super("scope.clipboard");
        }

        @Override // b94.b
        public final String a(Context r100) {
            return com.bytedance.bdp.bdpbase.util.o.b(r100, R.string.bdp_auth_permission_clipboard);
        }
    }

    public static final class g extends b94.b {
        public g() {
            super(null);
        }

        @Override // b94.b
        public final String a(Context r100) {
            return com.bytedance.bdp.bdpbase.util.o.b(r100, R.string.bdp_auth_permission_facial_verify);
        }
    }

    public static final class h extends b94.b {
        public h() {
            super("scope.generalInfo");
        }

        @Override // b94.b
        public final String a(Context r100) {
            return com.bytedance.bdp.bdpbase.util.o.b(r100, R.string.bdp_auth_permission_general_info);
        }
    }

    public static final class i extends b94.b {
        public i() {
            super("scope.hostId");
        }

        @Override // b94.b
        public final String a(Context r100) {
            return com.bytedance.bdp.bdpbase.util.o.b(r100, R.string.bdp_auth_permission_host_id);
        }
    }

    public static final class j extends b94.b {
        public j() {
            super("scope.userLocation");
        }

        @Override // b94.b
        public final String a(Context r100) {
            return com.bytedance.bdp.bdpbase.util.o.b(r100, R.string.bdp_auth_permission_location);
        }
    }

    public static final class k extends b94.b {
        public k() {
            super(null);
        }

        @Override // b94.b
        public final boolean b() {
            return true;
        }
    }

    public static final class l extends b94.b {
        public l() {
            super("scope.record");
        }

        @Override // b94.b
        public final String a(Context r100) {
            return com.bytedance.bdp.bdpbase.util.o.b(r100, R.string.bdp_auth_permission_record_audio);
        }
    }

    public static final class m extends b94.b {
        public m() {
            super("scope.screenRecord");
        }

        @Override // b94.b
        public final String a(Context r100) {
            return com.bytedance.bdp.bdpbase.util.o.b(r100, R.string.bdp_auth_permission_screen_record);
        }
    }

    public static final class n extends b94.b {
        public n() {
            super(null);
        }

        @Override // b94.b
        public final boolean b() {
            return true;
        }

        @Override // b94.b
        public final String a(Context r100) {
            return com.bytedance.bdp.bdpbase.util.o.b(r100, R.string.bdp_auth_subscribe_message);
        }
    }

    public static final class o extends b94.b {
        public o() {
            super("scope.userInfo");
        }

        @Override // b94.b
        public final String a(Context r100) {
            Object[] r101 = new Object[1];
            Application r102 = ((BdpContextService) BdpManager.getInst().getService(BdpContextService.class)).getHostApplication();
            PackageManager r103 = null;
            ApplicationInfo r104 = null;
            PackageManager r105 = r102.getApplicationContext().getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L6
            r104 = r105.getApplicationInfo(r102.getPackageName(), 0);     // Catch: PackageManager.NameNotFoundException -> L12
        L5:
            ApplicationInfo r106 = r104;
            r103 = r105;
        L7:
            r101[0] = (String) r103.getApplicationLabel(r106);
            if (r100 != null) goto L11;
            return "";
        L11:
            return r100.getApplicationContext().getResources().getString(R.string.bdp_auth_permission_user_info_miniapp, r101);
        L6:
            r106 = null;
            goto L7
        }
    }

    public static final class p extends b94.b {
        public p() {
            super(null);
        }

        @Override // b94.b
        public final boolean b() {
            return true;
        }
    }

    public static final class q extends b94.b {
        public q() {
            super(null);
        }

        @Override // b94.b
        public final boolean b() {
            return true;
        }
    }

    public static final class r extends b94.b {
        public r() {
            super("scope.pip");
        }

        @Override // b94.b
        public final String a(Context r100) {
            return com.bytedance.bdp.bdpbase.util.o.b(r100, R.string.bdp_auth_permission_play_in_background);
        }
    }

    static {
        f18247a = new p();
        f18248b = new o();
        f18249c = new q();
        f18250d = new i();
        j r100 = new j();
        f18251e = r100;
        C0281c r101 = new C0281c();
        f18252f = r101;
        l r102 = new l();
        f18253g = r102;
        e r103 = new e();
        f18254h = r103;
        b r104 = new b();
        f18255i = r104;
        f18256j = new a();
        k r105 = new k();
        f18257k = r105;
        f18258l = new m();
        g r106 = new g();
        f18259m = r106;
        f18260n = new n();
        f18261o = new r();
        f r107 = new f();
        f18262p = r107;
        f18263q = new h();
        d r108 = new d();
        f18264r = r108;
        List<b94.b> r109 = CollectionsKt.listOf(new b94.b[]{r103, r107, r100, r104, r102, r108, r106, r100, r101});
        f18265s = r109;
        ArrayList r110 = new ArrayList();
        r110.addAll(r109);
        r110.add(r105);
    }
}

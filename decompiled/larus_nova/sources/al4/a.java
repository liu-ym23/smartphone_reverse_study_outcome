package al4;

import cl4.e;
import cl4.f;
import cl4.g;
import cl4.j;
import com.bytedance.dora.protocol.LinkWrapper;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import pk4.n;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<b> f4128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ak4.a f4129b;

    /* JADX INFO: renamed from: al4.a$a, reason: collision with other inner class name */
    public static class C0080a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4130a = null;

        static {
            f4130a = new a();
        }
    }

    public a() {
        this.f4128a = new CopyOnWriteArraySet();
        this.f4129b = ak4.a.d();
    }

    public final int a(int r110, String r210, String r211, int r212, byte[] r213) {
        String r100 = "";
        if (r210 != null) goto L5;
        String r101 = "";
    L6:
        if (r211 == null) goto L9;
        r100 = r211;
    L9:
        j r102 = j.b.f24104a;
        if (r110 != 2) goto L12;
        r102.f24101a.post(new g(r102, r101));
    L13:
        byte[] r111 = LinkWrapper.wlanConfigCommand((byte) r110, n.u(r101.getBytes(), new byte[]{0}), n.u(r100.getBytes(), new byte[]{0}), (byte) 1, (byte) 1, r212, r213);
        pk4.j.d("DoraSppWifiBridge", "DoraSppWifiBridge.configWifi, mode: " + r110 + ", timeout: 5000");
        int r103 = this.f4129b.j(1, 12, r111, 5000);
        if (r110 != 2) goto L16;
        r102.f24101a.post(new e(r102, r103));
    L18:
        return r103;
    L16:
        if (r110 != 1) goto L18;
        r102.f24101a.post(new f(r102));
        goto L18
    L12:
        r102.getClass();
        goto L13
    L5:
        r101 = r210;
        goto L6
    }
}

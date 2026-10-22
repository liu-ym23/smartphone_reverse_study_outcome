package r7;

import androidx.core.internal.view.SupportMenu;
import bg.c;
import bg.h;
import com.bytedanceos.appstore.utils.d;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.DeviceUtil;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.utils.ReflectTool;
import java.util.UUID;
import kotlin.jvm.internal.q;
import kotlin.random.Random;
import p8.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23768a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f23769b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f23770c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f23771d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f23772e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f23773f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f23774g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f23775h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f23776i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f23777j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f23778k = null;

    static {
        f23768a = new a();
        if (d.a() == false) goto L5;
        int r10 = 1;
    L6:
        f23769b = r10;
        String r11 = com.bytedanceos.common.toolbox.d.f10009a;
        q.f(r11, "MODEL");
        f23770c = r11;
        String r12 = ReflectTool.getBytedanceID();
        q.f(r12, "getBytedanceID(...)");
        f23771d = r12;
        String r13 = e.U(false);
        q.f(r13, "getOsVersion(...)");
        f23772e = r13;
        String r14 = ReflectTool.getBytedanceID();
        q.f(r14, "getBytedanceID(...)");
        f23773f = r14;
        String r15 = ReflectTool.getBytedanceID();
        if (r15.length() != 0) goto L9;
        r15 = UUID.randomUUID().toString();
    L9:
        q.f(r15, "ifEmpty(...)");
        f23774g = r15;
        f23775h = "sn";
        String r16 = e.N(BaseApplication.c());
        q.f(r16, "getKeyType(...)");
        f23776i = r16;
        String r17 = b.f();
        q.f(r17, "getUserAgent(...)");
        f23777j = r17;
        String r18 = DeviceUtil.a();
        q.f(r18, "getAndroidId(...)");
        f23778k = r18;
        return;
    L5:
        r10 = 2;
        goto L6
    }

    public a() {
    }

    public final String a() {
        return f23778k;
    }

    public final String b() {
        return "lkp_appstore";
    }

    public final String c() {
        return f23773f;
    }

    public final String d() {
        return f23771d;
    }

    public final String e() {
        return f23776i;
    }

    public final String f() {
        String r10 = e.P();
        q.f(r10, "getLanguage(...)");
        return r10;
    }

    public final String g() {
        return f23770c;
    }

    public final String h() {
        return String.valueOf(h.n(new c(0, SupportMenu.USER_MASK), Random.Default));
    }

    public final String i() {
        return f23772e;
    }

    public final String j() {
        String r10 = com.bytedanceos.common.toolbox.q.e(BaseApplication.c());
        q.f(r10, "getResolution(...)");
        return r10;
    }

    public final int k() {
        return f23769b;
    }

    public final String l() {
        return String.valueOf(System.currentTimeMillis());
    }

    public final String m() {
        return f23774g;
    }

    public final String n() {
        return f23775h;
    }

    public final String o() {
        return f23777j;
    }
}

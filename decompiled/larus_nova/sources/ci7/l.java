package ci7;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ug.sdk.deeplink.UriType;
import com.bytedance.ug.sdk.deeplink.ZlinkApi;
import com.bytedance.ug.sdk.deeplink.resolver.ResolverType;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Application f23871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static UriType f23872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f23873c = null;

    public static final class a implements ki7.b {
        public a() {
        }

        @Override // ki7.b
        public final void a() {
            ki7.c.d(this);
            Application r100 = l.f23871a;
            mi7.h.f(m.f23874a);
        }
    }

    static {
        f23872b = UriType.ILLEGAL;
        f23873c = new a();
    }

    public static Application a() {
        Application r100 = f23871a;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Application has not init".toString());
    }

    public static void b(Uri r100, boolean r101) {
        if (r100 == null) goto L18;
        UriType r102 = f23872b;
        UriType r103 = UriType.ILLEGAL;
        if (r102 != r103) goto L18;
        if (TextUtils.isEmpty(r100.getScheme()) == true) goto L17;
        ji7.f r104 = ji7.f.b.f499223a;
        ji7.e r105 = r104.f499218a.get(ResolverType.TYPE_APP_LINK);
        ji7.e r106 = r104.f499218a.get(ResolverType.TYPE_DEEP_LINK);
        if (r105 != null) goto L10;
    L12:
        if (r106 != null) goto L14;
        return;
    L14:
        if (r106.a(r100) == false) goto L26;
        r103 = UriType.URI_SCHEME;
        f23872b = r103;
        goto L17
    L26:
        return;
    L10:
        if (r105.a(r100) == false) goto L12;
        r103 = UriType.APP_LINKS;
        f23872b = r103;
    L17:
        mi7.e.a(ZlinkApi.TAG, "ZlinkApi setCallUri uri=" + r100);
        mi7.c.b(r103, r100.toString());
    L18:
        if (r101 == true) goto L20;
        return;
    L20:
        if (p.a() == null) goto L22;
        boolean r107 = p.a().isConfirmedPrivacy();
    L23:
        if (r107 == false) goto L28;
        mi7.h.c().postDelayed(o.f23878a, 1000);
        return;
    L28:
        return;
    L22:
        r107 = false;
        goto L23
    }
}

package b6;

import ad.o;
import ad.q;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.statsrpk.h;
import e6.m;
import i6.d;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.List;
import kb.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1906a;

    public /* synthetic */ a(int i) {
        this.f1906a = i;
    }

    public final Object a(Object obj, m mVar) throws PackageManager.NameNotFoundException {
        String scheme;
        String authority;
        switch (this.f1906a) {
            case 0:
                return ByteBuffer.wrap((byte[]) obj);
            case 1:
                Uri uri = (Uri) obj;
                if (!d.c(uri) && ((scheme = uri.getScheme()) == null || scheme.equals("file"))) {
                    String path = uri.getPath();
                    if (path == null) {
                        path = "";
                    }
                    if (path.length() > 0 && h.m(path.charAt(0), JsonPointer.SEPARATOR, false) && ((String) l.x0(uri.getPathSegments())) != null) {
                        if (!k.a(uri.getScheme(), "file")) {
                            return new File(uri.toString());
                        }
                        String path2 = uri.getPath();
                        if (path2 != null) {
                            return new File(path2);
                        }
                    }
                }
                return null;
            case 2:
                return ((q) obj).i;
            case 3:
                int iIntValue = ((Number) obj).intValue();
                Context context = mVar.f3573a;
                try {
                    if (context.getResources().getResourceEntryName(iIntValue) != null) {
                        return Uri.parse("android.resource://" + context.getPackageName() + JsonPointer.SEPARATOR + iIntValue);
                    }
                } catch (Resources.NotFoundException unused) {
                }
                return null;
            case 4:
                Uri uri2 = (Uri) obj;
                if (k.a(uri2.getScheme(), "android.resource") && (authority = uri2.getAuthority()) != null && !hc.h.g0(authority) && uri2.getPathSegments().size() == 2) {
                    String authority2 = uri2.getAuthority();
                    if (authority2 == null) {
                        authority2 = "";
                    }
                    Resources resourcesForApplication = mVar.f3573a.getPackageManager().getResourcesForApplication(authority2);
                    List<String> pathSegments = uri2.getPathSegments();
                    int identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority2);
                    if (identifier != 0) {
                        return Uri.parse("android.resource://" + authority2 + JsonPointer.SEPARATOR + identifier);
                    }
                    o.e(uri2, "Invalid android.resource URI: ");
                }
                return null;
            default:
                return Uri.parse((String) obj);
        }
    }
}

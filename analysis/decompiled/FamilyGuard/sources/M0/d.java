package M0;

import C0.v;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.util.List;
import z0.C1342h;
import z0.i;

/* loaded from: classes.dex */
public class d implements i<Uri, Drawable> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3995a;

    public d(Context context) {
        this.f3995a = context.getApplicationContext();
    }

    private Context d(Uri uri, String str) {
        if (str.equals(this.f3995a.getPackageName())) {
            return this.f3995a;
        }
        try {
            return this.f3995a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e6) {
            if (str.contains(this.f3995a.getPackageName())) {
                return this.f3995a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e6);
        }
    }

    private int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e6) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e6);
        }
    }

    private int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    private int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // z0.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public v<Drawable> a(Uri uri, int i5, int i6, C1342h c1342h) {
        Context contextD = d(uri, uri.getAuthority());
        return c.f(a.b(this.f3995a, contextD, g(contextD, uri)));
    }

    @Override // z0.i
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri, C1342h c1342h) {
        return uri.getScheme().equals("android.resource");
    }
}

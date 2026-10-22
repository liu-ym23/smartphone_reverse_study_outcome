package t1;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lt1/a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcoil/c;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Lcoil/c;", Const.INTENT_KEY_PKGNAME, "Lcoil/c;", "imageLoader", "Lt1/f;", "c", "Lt1/f;", "imageLoaderFactory", "coil-singleton_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: t1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5503a {

    /* renamed from: a, reason: collision with root package name */
    public static final C5503a f41991a = new C5503a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static coil.c imageLoader;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static f imageLoaderFactory;

    public static final coil.c a(Context context) {
        coil.c cVar = imageLoader;
        return cVar == null ? f41991a.b(context) : cVar;
    }

    public final synchronized coil.c b(Context context) {
        coil.c cVarA;
        try {
            coil.c cVar = imageLoader;
            if (cVar != null) {
                return cVar;
            }
            f fVar = imageLoaderFactory;
            if (fVar == null || (cVarA = fVar.a()) == null) {
                Object applicationContext = context.getApplicationContext();
                f fVar2 = applicationContext instanceof f ? (f) applicationContext : null;
                cVarA = fVar2 != null ? fVar2.a() : coil.d.a(context);
            }
            imageLoaderFactory = null;
            imageLoader = cVarA;
            return cVarA;
        } catch (Throwable th) {
            throw th;
        }
    }
}

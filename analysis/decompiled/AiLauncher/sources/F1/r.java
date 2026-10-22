package F1;

import android.content.Context;
import coil.disk.a;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"LF1/r;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcoil/disk/a;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Lcoil/disk/a;", Const.INTENT_KEY_PKGNAME, "Lcoil/disk/a;", "instance", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f2565a = new r();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static coil.disk.a instance;

    public final synchronized coil.disk.a a(Context context) {
        coil.disk.a aVarA;
        aVarA = instance;
        if (aVarA == null) {
            aVarA = new a.C0196a().c(l9.k.A(j.m(context), "image_cache")).a();
            instance = aVarA;
        }
        return aVarA;
    }
}

package x1;

import A1.k;
import F1.j;
import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lx1/c;", "Lx1/b;", "Landroid/net/Uri;", "<init>", "()V", "data", "LA1/k;", "options", "", Const.INTENT_KEY_PKGNAME, "(Landroid/net/Uri;LA1/k;)Ljava/lang/String;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: x1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5844c implements InterfaceC5843b<Uri> {
    @Override // x1.InterfaceC5843b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String a(Uri data, k options) {
        if (!p.d(data.getScheme(), "android.resource")) {
            return data.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(data);
        sb2.append('-');
        sb2.append(j.k(options.getContext().getResources().getConfiguration()));
        return sb2.toString();
    }
}

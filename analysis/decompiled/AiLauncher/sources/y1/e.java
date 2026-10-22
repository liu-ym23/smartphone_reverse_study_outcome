package y1;

import A1.k;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0006\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ly1/e;", "Ly1/d;", "", "Landroid/net/Uri;", "<init>", "()V", "data", "LA1/k;", "options", "c", "(ILA1/k;)Landroid/net/Uri;", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_PKGNAME, "(ILandroid/content/Context;)Z", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class e implements d<Integer, Uri> {
    @Override // y1.d
    public /* bridge */ /* synthetic */ Uri a(Integer num, k kVar) {
        return c(num.intValue(), kVar);
    }

    public final boolean b(int data, Context context) {
        try {
            return context.getResources().getResourceEntryName(data) != null;
        } catch (Resources.NotFoundException unused) {
            return false;
        }
    }

    public Uri c(int data, k options) {
        if (!b(data, options.getContext())) {
            return null;
        }
        return Uri.parse("android.resource://" + options.getContext().getPackageName() + JsonPointer.SEPARATOR + data);
    }
}

package Nb;

import Mb.AbstractC0971i;
import Mb.C0970h;
import Mb.z;
import Z8.C1165m;
import com.autonavi.aps.amapapi.config.Const;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"LMb/i;", "LMb/z;", "path", "LMb/h;", "c", "(LMb/i;LMb/z;)LMb/h;", "", Const.INTENT_KEY_PKGNAME, "(LMb/i;LMb/z;)Z", Const.JSON_KEY_DIR, "mustCreate", "LY8/t;", Const.INTENT_KEY_APIKEY, "(LMb/i;LMb/z;Z)V", "okio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class d {
    public static final void a(AbstractC0971i abstractC0971i, z dir, boolean z10) throws IOException {
        kotlin.jvm.internal.p.i(abstractC0971i, "<this>");
        kotlin.jvm.internal.p.i(dir, "dir");
        C1165m c1165m = new C1165m();
        for (z zVarK = dir; zVarK != null && !abstractC0971i.J(zVarK); zVarK = zVarK.k()) {
            c1165m.addFirst(zVarK);
        }
        if (z10 && c1165m.isEmpty()) {
            throw new IOException(dir + " already exists.");
        }
        Iterator<E> it = c1165m.iterator();
        while (it.hasNext()) {
            AbstractC0971i.n(abstractC0971i, (z) it.next(), false, 2, null);
        }
    }

    public static final boolean b(AbstractC0971i abstractC0971i, z path) throws IOException {
        kotlin.jvm.internal.p.i(abstractC0971i, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        return abstractC0971i.Y(path) != null;
    }

    public static final C0970h c(AbstractC0971i abstractC0971i, z path) throws IOException {
        kotlin.jvm.internal.p.i(abstractC0971i, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        C0970h c0970hY = abstractC0971i.Y(path);
        if (c0970hY != null) {
            return c0970hY;
        }
        throw new FileNotFoundException("no such file: " + path);
    }
}

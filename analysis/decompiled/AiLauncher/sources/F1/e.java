package F1;

import Mb.AbstractC0971i;
import Mb.z;
import com.autonavi.aps.amapapi.config.Const;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"LMb/i;", "LMb/z;", Const.STR_FILE, "LY8/t;", Const.INTENT_KEY_APIKEY, "(LMb/i;LMb/z;)V", "directory", Const.INTENT_KEY_PKGNAME, "coil-base_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class e {
    public static final void a(AbstractC0971i abstractC0971i, z zVar) throws IOException {
        if (abstractC0971i.J(zVar)) {
            return;
        }
        j.d(abstractC0971i.g0(zVar));
    }

    public static final void b(AbstractC0971i abstractC0971i, z zVar) throws IOException {
        try {
            IOException iOException = null;
            for (z zVar2 : abstractC0971i.U(zVar)) {
                try {
                    if (abstractC0971i.V(zVar2).getIsDirectory()) {
                        b(abstractC0971i, zVar2);
                    }
                    abstractC0971i.A(zVar2);
                } catch (IOException e10) {
                    if (iOException == null) {
                        iOException = e10;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }
}

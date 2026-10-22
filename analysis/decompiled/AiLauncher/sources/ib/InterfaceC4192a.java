package ib;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\f\u0082\u0001\u0001\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lib/a;", "", "Lib/f;", "path", "", Const.INTENT_KEY_APIKEY, "(Lib/f;)Z", "mustExist", "LY8/t;", Const.INTENT_KEY_UMID, "(Lib/f;Z)V", "c", "(Lib/f;)Lib/f;", "Lib/h;", "kotlinx-io-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: ib.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC4192a {
    static /* synthetic */ void b(InterfaceC4192a interfaceC4192a, f fVar, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        interfaceC4192a.d(fVar, z10);
    }

    boolean a(f path);

    f c(f path);

    void d(f path, boolean mustExist);
}

package Z;

import Z.e;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.params.SessionConfiguration;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class a implements e {

    /* renamed from: a, reason: collision with root package name */
    public final List<e> f7087a;

    public a(List<e> list) {
        this.f7087a = list;
    }

    @Override // Z.e
    public e.a a(SessionConfiguration sessionConfiguration) throws CameraAccessException {
        Iterator<e> it = this.f7087a.iterator();
        while (it.hasNext()) {
            e.a aVarA = it.next().a(sessionConfiguration);
            if (aVarA.a() != 0) {
                return aVarA;
            }
        }
        return new e.a(0, 0, 0L);
    }
}

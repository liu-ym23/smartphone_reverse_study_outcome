package O0;

import C0.v;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import z0.C1342h;
import z0.EnumC1337c;

/* loaded from: classes.dex */
public class d implements z0.j<c> {
    @Override // z0.j
    public EnumC1337c a(C1342h c1342h) {
        return EnumC1337c.SOURCE;
    }

    @Override // z0.InterfaceC1338d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean b(v<c> vVar, File file, C1342h c1342h) throws Throwable {
        try {
            X0.a.d(vVar.get().c(), file);
            return true;
        } catch (IOException e6) {
            if (!Log.isLoggable("GifEncoder", 5)) {
                return false;
            }
            Log.w("GifEncoder", "Failed to encode GIF drawable data", e6);
            return false;
        }
    }
}

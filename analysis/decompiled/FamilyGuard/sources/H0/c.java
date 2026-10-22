package H0;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import z0.C1342h;
import z0.InterfaceC1338d;

/* loaded from: classes.dex */
public class c implements InterfaceC1338d<ByteBuffer> {
    @Override // z0.InterfaceC1338d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean b(ByteBuffer byteBuffer, File file, C1342h c1342h) throws Throwable {
        try {
            X0.a.d(byteBuffer, file);
            return true;
        } catch (IOException e6) {
            if (!Log.isLoggable("ByteBufferEncoder", 3)) {
                return false;
            }
            Log.d("ByteBufferEncoder", "Failed to write data", e6);
            return false;
        }
    }
}

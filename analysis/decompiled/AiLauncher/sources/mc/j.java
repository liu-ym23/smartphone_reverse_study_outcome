package mc;

import com.amap.api.services.core.AMapException;
import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidDataException;

/* loaded from: classes5.dex */
public class j extends e {
    public j() {
        super(Opcode.TEXT);
    }

    @Override // mc.e, mc.g
    public void h() throws InvalidDataException {
        super.h();
        if (!pc.c.b(f())) {
            throw new InvalidDataException(AMapException.CODE_AMAP_INVALID_USER_DOMAIN, "Received text is no valid utf8 string!");
        }
    }
}

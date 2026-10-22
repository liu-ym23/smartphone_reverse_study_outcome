package mc;

import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;

/* loaded from: classes5.dex */
public abstract class d extends g {
    public d(Opcode opcode) {
        super(opcode);
    }

    @Override // mc.g
    public void h() throws InvalidDataException {
        if (!e()) {
            throw new InvalidFrameException("Control frame can't have fin==false set");
        }
        if (a()) {
            throw new InvalidFrameException("Control frame can't have rsv1==true set");
        }
        if (b()) {
            throw new InvalidFrameException("Control frame can't have rsv2==true set");
        }
        if (d()) {
            throw new InvalidFrameException("Control frame can't have rsv3==true set");
        }
    }
}

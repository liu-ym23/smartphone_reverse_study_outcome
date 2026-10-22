package io.ktor.websocket;

import h9.InterfaceC4149a;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/websocket/FrameType;", "", "", "controlFrame", "", "opcode", "<init>", "(Ljava/lang/String;IZI)V", "Z", "getControlFrame", "()Z", "I", "getOpcode", "()I", "Companion", "TEXT", "BINARY", "CLOSE", "PING", "PONG", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FrameType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ FrameType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final FrameType[] byOpcodeArray;
    private static final int maxOpcode;
    private final boolean controlFrame;
    private final int opcode;
    public static final FrameType TEXT = new FrameType("TEXT", 0, false, 1);
    public static final FrameType BINARY = new FrameType("BINARY", 1, false, 2);
    public static final FrameType CLOSE = new FrameType("CLOSE", 2, true, 8);
    public static final FrameType PING = new FrameType("PING", 3, true, 9);
    public static final FrameType PONG = new FrameType("PONG", 4, true, 10);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/websocket/FrameType$Companion;", "", "<init>", "()V", "", "opcode", "Lio/ktor/websocket/FrameType;", "get", "(I)Lio/ktor/websocket/FrameType;", "maxOpcode", "I", "", "byOpcodeArray", "[Lio/ktor/websocket/FrameType;", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final FrameType get(int opcode) {
            if (opcode < 0 || opcode > FrameType.maxOpcode) {
                return null;
            }
            return FrameType.byOpcodeArray[opcode];
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ FrameType[] $values() {
        return new FrameType[]{TEXT, BINARY, CLOSE, PING, PONG};
    }

    static {
        FrameType next;
        FrameType[] frameTypeArr$values = $values();
        $VALUES = frameTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(frameTypeArr$values);
        INSTANCE = new Companion(null);
        Iterator<FrameType> it = getEntries().iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int i10 = next.opcode;
                do {
                    FrameType next2 = it.next();
                    int i11 = next2.opcode;
                    if (i10 < i11) {
                        next = next2;
                        i10 = i11;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        p.f(next);
        int i12 = next.opcode;
        maxOpcode = i12;
        int i13 = i12 + 1;
        FrameType[] frameTypeArr = new FrameType[i13];
        for (int i14 = 0; i14 < i13; i14++) {
            Iterator<FrameType> it2 = getEntries().iterator();
            FrameType frameType = null;
            boolean z10 = false;
            while (true) {
                if (!it2.hasNext()) {
                    if (!z10) {
                        break;
                    }
                } else {
                    FrameType next3 = it2.next();
                    if (next3.opcode == i14) {
                        if (z10) {
                            break;
                        }
                        z10 = true;
                        frameType = next3;
                    }
                }
            }
            frameType = null;
            frameTypeArr[i14] = frameType;
        }
        byOpcodeArray = frameTypeArr;
    }

    private FrameType(String str, int i10, boolean z10, int i11) {
        this.controlFrame = z10;
        this.opcode = i11;
    }

    public static InterfaceC4149a<FrameType> getEntries() {
        return $ENTRIES;
    }

    public static FrameType valueOf(String str) {
        return (FrameType) Enum.valueOf(FrameType.class, str);
    }

    public static FrameType[] values() {
        return (FrameType[]) $VALUES.clone();
    }

    public final boolean getControlFrame() {
        return this.controlFrame;
    }

    public final int getOpcode() {
        return this.opcode;
    }
}

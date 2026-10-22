package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e {
    public static final Channel a(int r10, BufferOverflow r11, Function1 r12) {
        if (r10 == (-2)) goto L25;
        if (r10 == (-1)) goto L20;
        if (r10 == 0) goto L15;
        if (r10 == Integer.MAX_VALUE) goto L30;
        if (r11 != BufferOverflow.SUSPEND) goto L29;
        return new BufferedChannel(r10, r12);
    L29:
        return new i(r10, r11, r12);
    L30:
        return new BufferedChannel(Channel.UNLIMITED, r12);
    L15:
        if (r11 != BufferOverflow.SUSPEND) goto L18;
        Channel r13 = new BufferedChannel(0, r12);
    L31:
        return r13;
    L18:
        r13 = new i(1, r11, r12);
        goto L31
    L20:
        if (r11 != BufferOverflow.SUSPEND) goto L23;
        return new i(1, BufferOverflow.DROP_OLDEST, r12);
    L23:
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    L25:
        if (r11 != BufferOverflow.SUSPEND) goto L27;
        r13 = new BufferedChannel(Channel.Factory.a(), r12);
        goto L31
    L27:
        r13 = new i(1, r11, r12);
        goto L31
    }

    public static /* synthetic */ Channel b(int r10, BufferOverflow r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = BufferOverflow.SUSPEND;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = null;
    L12:
        return a(r10, r11, r12);
    }
}

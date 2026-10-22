package o9;

import m9.InterfaceC1717j;
import s9.AbstractC1921a;

/* renamed from: o9.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1777c {

    /* renamed from: a, reason: collision with root package name */
    public static final C1783i f5449a = new C1783i(-1, null, null, 0);
    public static final int b = AbstractC1921a.j(32, 12, "kotlinx.coroutines.bufferedChannel.segmentSize");
    public static final int c = AbstractC1921a.j(10000, 12, "kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations");
    public static final a5.d d = new a5.d("BUFFERED", 6);
    public static final a5.d e = new a5.d("SHOULD_BUFFER", 6);
    public static final a5.d f = new a5.d("S_RESUMING_BY_RCV", 6);
    public static final a5.d g = new a5.d("RESUMING_BY_EB", 6);
    public static final a5.d h = new a5.d("POISONED", 6);
    public static final a5.d i = new a5.d("DONE_RCV", 6);

    /* renamed from: j, reason: collision with root package name */
    public static final a5.d f5450j = new a5.d("INTERRUPTED_SEND", 6);
    public static final a5.d k = new a5.d("INTERRUPTED_RCV", 6);
    public static final a5.d l = new a5.d("CHANNEL_CLOSED", 6);
    public static final a5.d m = new a5.d("SUSPEND", 6);
    public static final a5.d n = new a5.d("SUSPEND_NO_WAITER", 6);
    public static final a5.d o = new a5.d("FAILED", 6);
    public static final a5.d p = new a5.d("NO_RECEIVE_RESULT", 6);

    /* renamed from: q, reason: collision with root package name */
    public static final a5.d f5451q = new a5.d("CLOSE_HANDLER_CLOSED", 6);

    /* renamed from: r, reason: collision with root package name */
    public static final a5.d f5452r = new a5.d("CLOSE_HANDLER_INVOKED", 6);

    /* renamed from: s, reason: collision with root package name */
    public static final a5.d f5453s = new a5.d("NO_CLOSE_CAUSE", 6);

    public static final boolean a(InterfaceC1717j interfaceC1717j, Object obj, S7.o oVar) {
        a5.d dVarH = interfaceC1717j.h(obj, oVar);
        if (dVarH == null) {
            return false;
        }
        interfaceC1717j.v(dVarH);
        return true;
    }
}

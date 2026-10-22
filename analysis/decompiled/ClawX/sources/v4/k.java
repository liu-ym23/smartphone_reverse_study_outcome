package v4;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k implements h5.d, f5.c {

    /* renamed from: a, reason: collision with root package name */
    public static final k f5977a = new k();

    @Override // h5.d
    public final h5.d getCallerFrame() {
        return null;
    }

    @Override // f5.c
    public final f5.h getContext() {
        return f5.i.f2626a;
    }

    @Override // f5.c
    public final void resumeWith(Object obj) {
        throw new IllegalStateException("Failed to capture stack frame. This is usually happens when a coroutine is running so the frame stack is changing quickly and the coroutine debug agent is unable to capture it concurrently. You may retry running your test to see this particular trace.");
    }
}

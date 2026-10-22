package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: classes4.dex */
public final class e1 implements SharingStarted {
    public e1() {
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow command(StateFlow r10) {
        return c.C(SharingCommand.START);
    }

    public String toString() {
        return "SharingStarted.Eagerly";
    }
}

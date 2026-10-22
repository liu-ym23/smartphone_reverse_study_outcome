package h6;

import a6.i0;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j extends i {

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f3064c;

    public j(Runnable runnable, long j4, boolean z) {
        super(j4, z);
        this.f3064c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3064c.run();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.f3064c;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(i0.k(runnable));
        sb.append(", ");
        sb.append(this.f3062a);
        sb.append(", ");
        sb.append(this.f3063b ? "Blocking" : "Non-blocking");
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }
}

package j8;

import android.content.Intent;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends Exception {

    /* renamed from: c, reason: collision with root package name */
    public Intent f6621c;

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f6621c != null ? "intent need to be handled." : super.getMessage();
    }
}

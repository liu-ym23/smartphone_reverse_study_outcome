package s7;

import java.sql.Timestamp;
import java.util.Date;
import p7.g;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends g {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11414b;

    @Override // p7.g
    public final Date a(Date date) {
        switch (this.f11414b) {
            case 0:
                return new java.sql.Date(date.getTime());
            default:
                return new Timestamp(date.getTime());
        }
    }
}

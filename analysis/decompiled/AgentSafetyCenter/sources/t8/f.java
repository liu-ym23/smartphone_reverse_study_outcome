package t8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public String f13233a;

    /* renamed from: b, reason: collision with root package name */
    public String f13234b;

    /* renamed from: c, reason: collision with root package name */
    public String f13235c;

    /* renamed from: d, reason: collision with root package name */
    public String f13236d;

    /* renamed from: e, reason: collision with root package name */
    public long f13237e;

    /* renamed from: f, reason: collision with root package name */
    public int f13238f;

    /* renamed from: g, reason: collision with root package name */
    public String f13239g;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f13233a.equals(fVar.f13233a) && this.f13234b.equals(fVar.f13234b) && this.f13235c.equals(fVar.f13235c) && this.f13236d.equals(fVar.f13236d) && this.f13237e == fVar.f13237e && this.f13238f == fVar.f13238f && yb.k.a(this.f13239g, fVar.f13239g);
    }

    public final int hashCode() {
        int iB = s.f.b(this.f13238f, k0.a.i(this.f13237e, androidx.activity.b.d(androidx.activity.b.d(androidx.activity.b.d(this.f13233a.hashCode() * 31, 31, this.f13234b), 31, this.f13235c), 31, this.f13236d), 31), 31);
        String str = this.f13239g;
        return iB + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        String str = this.f13233a;
        String str2 = this.f13234b;
        String str3 = this.f13235c;
        String str4 = this.f13236d;
        long j10 = this.f13237e;
        int i = this.f13238f;
        String str5 = this.f13239g;
        StringBuilder sbP = androidx.activity.b.p("PendingUndoSyncRecord(revokeKey=", str, ", sessionId=", str2, ", toolCallId=");
        androidx.activity.b.u(sbP, str3, ", taskId=", str4, ", restoredAtMs=");
        sbP.append(j10);
        sbP.append(", retryCount=");
        sbP.append(i);
        sbP.append(", lastError=");
        sbP.append(str5);
        sbP.append(")");
        return sbP.toString();
    }
}

package androidx.emoji2.text;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public int f627a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final w f628b;

    /* renamed from: c, reason: collision with root package name */
    public w f629c;
    public w d;

    /* renamed from: e, reason: collision with root package name */
    public int f630e;

    /* renamed from: f, reason: collision with root package name */
    public int f631f;

    public s(w wVar) {
        this.f628b = wVar;
        this.f629c = wVar;
    }

    public final void a() {
        this.f627a = 1;
        this.f629c = this.f628b;
        this.f631f = 0;
    }

    public final boolean b() {
        o0.a aVarB = this.f629c.f645b.b();
        int iA = aVarB.a(6);
        return !(iA == 0 || ((ByteBuffer) aVarB.d).get(iA + aVarB.f1830a) == 0) || this.f630e == 65039;
    }
}

package q8;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ String f10109c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ long f10110f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ long f10111g;

    @Override // xb.l
    public final Object invoke(Object obj) throws Exception {
        String str = this.f10109c;
        long j10 = this.f10110f;
        long j11 = this.f10111g;
        x4.a aVar = (x4.a) obj;
        aVar.getClass();
        x4.c cVarK = aVar.K(str);
        try {
            cVarK.c(1, j10);
            cVarK.c(2, j11);
            ArrayList arrayList = new ArrayList();
            while (cVarK.G()) {
                arrayList.add(new j((int) cVarK.getLong(1), (int) cVarK.getLong(2), cVarK.getLong(0), cVarK.getLong(3)));
            }
            return arrayList;
        } finally {
            cVarK.close();
        }
    }
}

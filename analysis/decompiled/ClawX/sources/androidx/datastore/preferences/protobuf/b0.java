package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b0 {
    public static w a(Object obj, long j4) {
        w wVar = (w) h1.f488c.h(obj, j4);
        if (((b) wVar).f450a) {
            return wVar;
        }
        s0 s0Var = (s0) wVar;
        int i8 = s0Var.f565c;
        s0 s0VarH = s0Var.h(i8 == 0 ? 10 : i8 * 2);
        h1.o(j4, obj, s0VarH);
        return s0VarH;
    }
}

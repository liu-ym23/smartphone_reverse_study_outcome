package d8;

import android.os.IBinder;
import android.os.IInterface;
import java.util.function.Function;
import org.bouncycastle.asn1.BERTags;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class z implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2238a;

    public /* synthetic */ z(int i8) {
        this.f2238a = i8;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f2238a) {
            case 0:
                return w.f2189a.d(((Integer) obj).intValue());
            case 1:
                return x.f2205a.d(((Integer) obj).intValue());
            case 2:
                return q1.f2121a.d(((Integer) obj).intValue());
            case 3:
                return ((x1) obj).toString();
            case 4:
                return o2.b.a((IBinder) obj);
            case 5:
                IBinder iBinder = (IBinder) obj;
                int i8 = r2.b.f5088a;
                if (iBinder == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.meizu.aiservice.algorithm.imageextend.IImageExtend");
                if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof r2.c)) {
                    return (r2.c) iInterfaceQueryLocalInterface;
                }
                r2.a aVar = new r2.a();
                aVar.f5087a = iBinder;
                return aVar;
            case 6:
                IBinder iBinder2 = (IBinder) obj;
                int i9 = s2.b.f5234a;
                if (iBinder2 == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.meizu.aiservice.algorithm.imageinpaint.IImageInpaint");
                if (iInterfaceQueryLocalInterface2 != null && (iInterfaceQueryLocalInterface2 instanceof s2.c)) {
                    return (s2.c) iInterfaceQueryLocalInterface2;
                }
                s2.a aVar2 = new s2.a();
                aVar2.f5233a = iBinder2;
                return aVar2;
            case 7:
                IBinder iBinder3 = (IBinder) obj;
                int i10 = u2.b.f5625a;
                if (iBinder3 == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface3 = iBinder3.queryLocalInterface("com.meizu.aiservice.algorithm.interactivesegment.IInteractiveSegment");
                if (iInterfaceQueryLocalInterface3 != null && (iInterfaceQueryLocalInterface3 instanceof u2.c)) {
                    return (u2.c) iInterfaceQueryLocalInterface3;
                }
                u2.a aVar3 = new u2.a();
                aVar3.f5624a = iBinder3;
                return aVar3;
            case 8:
                IBinder iBinder4 = (IBinder) obj;
                int i11 = x2.b.f6252a;
                if (iBinder4 == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface4 = iBinder4.queryLocalInterface("com.meizu.aiservice.algorithm.voice.ISpeechRecognition");
                if (iInterfaceQueryLocalInterface4 != null && (iInterfaceQueryLocalInterface4 instanceof x2.c)) {
                    return (x2.c) iInterfaceQueryLocalInterface4;
                }
                x2.a aVar4 = new x2.a();
                aVar4.f6251a = iBinder4;
                return aVar4;
            case 9:
                IBinder iBinder5 = (IBinder) obj;
                int i12 = p2.b.f4728a;
                if (iBinder5 == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface5 = iBinder5.queryLocalInterface("com.meizu.aiservice.algorithm.chineseclip.IChineseClip");
                if (iInterfaceQueryLocalInterface5 != null && (iInterfaceQueryLocalInterface5 instanceof p2.c)) {
                    return (p2.c) iInterfaceQueryLocalInterface5;
                }
                p2.a aVar5 = new p2.a();
                aVar5.f4727a = iBinder5;
                return aVar5;
            case 10:
                IBinder iBinder6 = (IBinder) obj;
                int i13 = q2.b.f4840a;
                if (iBinder6 == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface6 = iBinder6.queryLocalInterface("com.meizu.aiservice.algorithm.embedding.IEmbedding");
                if (iInterfaceQueryLocalInterface6 != null && (iInterfaceQueryLocalInterface6 instanceof q2.c)) {
                    return (q2.c) iInterfaceQueryLocalInterface6;
                }
                q2.a aVar6 = new q2.a();
                aVar6.f4839a = iBinder6;
                return aVar6;
            case BERTags.EMBEDDED_PDV /* 11 */:
                IBinder iBinder7 = (IBinder) obj;
                int i14 = w2.b.f6183a;
                if (iBinder7 == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface7 = iBinder7.queryLocalInterface("com.meizu.aiservice.algorithm.reranking.IReranking");
                if (iInterfaceQueryLocalInterface7 != null && (iInterfaceQueryLocalInterface7 instanceof w2.c)) {
                    return (w2.c) iInterfaceQueryLocalInterface7;
                }
                w2.a aVar7 = new w2.a();
                aVar7.f6182a = iBinder7;
                return aVar7;
            case 12:
                IBinder iBinder8 = (IBinder) obj;
                int i15 = v2.b.f5959a;
                if (iBinder8 == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface8 = iBinder8.queryLocalInterface("com.meizu.aiservice.algorithm.memory.IMemory");
                if (iInterfaceQueryLocalInterface8 != null && (iInterfaceQueryLocalInterface8 instanceof v2.c)) {
                    return (v2.c) iInterfaceQueryLocalInterface8;
                }
                v2.a aVar8 = new v2.a();
                aVar8.f5958a = iBinder8;
                return aVar8;
            default:
                IBinder iBinder9 = (IBinder) obj;
                int i16 = t2.b.f5560a;
                if (iBinder9 == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface9 = iBinder9.queryLocalInterface("com.meizu.aiservice.algorithm.imagematting.IImageMatting");
                if (iInterfaceQueryLocalInterface9 != null && (iInterfaceQueryLocalInterface9 instanceof t2.c)) {
                    return (t2.c) iInterfaceQueryLocalInterface9;
                }
                t2.a aVar9 = new t2.a();
                aVar9.f5559a = iBinder9;
                return aVar9;
        }
    }
}

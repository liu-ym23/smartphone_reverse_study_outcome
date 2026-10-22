package d8;

import java.util.function.Supplier;
import org.bouncycastle.asn1.BERTags;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class g3 implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2007a;

    public /* synthetic */ g3(int i8) {
        this.f2007a = i8;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f2007a) {
            case 0:
                return new k3();
            case 1:
                return new h3(0);
            case 2:
                return new m3();
            case 3:
                return new n3();
            case 4:
                return new h3(1);
            case 5:
                return new j3(0);
            case 6:
                return new h3(2);
            case 7:
                return new f();
            case 8:
                return new w0();
            case 9:
                return new u1();
            case 10:
                return new u2();
            case BERTags.EMBEDDED_PDV /* 11 */:
                return new n1();
            case 12:
                return new o1();
            case BERTags.RELATIVE_OID /* 13 */:
                return new a3();
            case BERTags.TIME /* 14 */:
                return new z0();
            case 15:
                return new r2();
            case 16:
                return new p0();
            case 17:
                return new b();
            case BERTags.NUMERIC_STRING /* 18 */:
                return new k4();
            case 19:
                return new b1();
            case 20:
                return new w1();
            case BERTags.VIDEOTEX_STRING /* 21 */:
                return new d1();
            case BERTags.IA5_STRING /* 22 */:
                return new e3();
            case BERTags.UTC_TIME /* 23 */:
                return new m1();
            case 24:
                return new a1();
            case BERTags.GRAPHIC_STRING /* 25 */:
                return new j();
            case BERTags.VISIBLE_STRING /* 26 */:
                return new a();
            case BERTags.GENERAL_STRING /* 27 */:
                return new t();
            case BERTags.UNIVERSAL_STRING /* 28 */:
                return new n2();
            default:
                return new q2();
        }
    }
}

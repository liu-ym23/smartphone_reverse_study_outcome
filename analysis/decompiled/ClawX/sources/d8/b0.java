package d8;

import java.util.ArrayList;
import java.util.stream.Collectors;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class b0 extends d0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1942b = 1;

    /* renamed from: c, reason: collision with root package name */
    public Object f1943c;

    public /* synthetic */ b0(int i8) {
        super(i8);
    }

    @Override // d8.d0
    public final void a(u uVar) {
        switch (this.f1942b) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f1943c;
                arrayList.clear();
                while (uVar.f2171a.remaining() > 0) {
                    arrayList.add(Integer.valueOf(uVar.f()));
                }
                break;
            default:
                this.f1943c = uVar.a();
                break;
        }
    }

    @Override // d8.d0
    public final String b() {
        z zVar;
        switch (this.f1942b) {
            case 0:
                int i8 = this.f1976a;
                if (i8 == 5) {
                    zVar = new z(0);
                } else if (i8 == 6) {
                    zVar = new z(1);
                } else {
                    if (i8 != 7) {
                        throw new IllegalStateException("Unknown option code");
                    }
                    zVar = new z(2);
                }
                return m0.f.f(new StringBuilder("["), (String) ((ArrayList) this.f1943c).stream().map(zVar).collect(Collectors.joining(", ")), "]");
            default:
                return "<" + b8.h.O((byte[]) this.f1943c) + ">";
        }
    }

    @Override // d8.d0
    public final void c(b0.j jVar) {
        switch (this.f1942b) {
            case 0:
                ((ArrayList) this.f1943c).forEach(new a0(0, jVar));
                break;
            default:
                jVar.h((byte[]) this.f1943c);
                break;
        }
    }

    public b0(int i8, int[] iArr) {
        super(i8);
        if (i8 != 5 && i8 != 6 && i8 != 7) {
            throw new IllegalArgumentException("Invalid option code, must be one of DAU, DHU, N3U");
        }
        this.f1943c = new ArrayList();
        for (int i9 : iArr) {
            ((ArrayList) this.f1943c).add(Integer.valueOf(i9));
        }
    }
}

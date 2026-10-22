package d8;

import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Supplier;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class o3 extends w2 {

    /* renamed from: j, reason: collision with root package name */
    public static final l3 f2102j;

    /* renamed from: f, reason: collision with root package name */
    public int f2103f;

    /* renamed from: g, reason: collision with root package name */
    public x1 f2104g;

    /* renamed from: h, reason: collision with root package name */
    public final TreeMap f2105h = new TreeMap();

    static {
        l3 l3Var = new l3(0);
        f2102j = l3Var;
        l3Var.g(0, "mandatory", new g3(0));
        l3Var.g(1, "alpn", new g3(1));
        l3Var.g(2, "no-default-alpn", new g3(2));
        l3Var.g(3, ConfigIpcContract.KEY_PORT, new g3(3));
        l3Var.g(4, "ipv4hint", new g3(4));
        l3Var.g(5, "ech", new g3(5));
        l3Var.g(6, "ipv6hint", new g3(6));
        l3Var.b(5, "echconfig");
    }

    @Override // d8.w2
    public final void j(u uVar) throws l4 {
        int i8;
        i3 i3Var;
        int iD = uVar.d();
        ByteBuffer byteBuffer = uVar.f2171a;
        this.f2103f = iD;
        this.f2104g = new x1(uVar);
        TreeMap treeMap = this.f2105h;
        treeMap.clear();
        while (true) {
            i8 = 0;
            if (byteBuffer.remaining() < 4) {
                break;
            }
            int iD2 = uVar.d();
            byte[] bArrB = uVar.b(uVar.d());
            Supplier supplier = (Supplier) f2102j.f2074h.get(Integer.valueOf(iD2));
            if (supplier != null) {
                i3Var = (i3) supplier.get();
            } else {
                j3 j3Var = new j3(1);
                j3Var.f2038b = new byte[0];
                i3Var = j3Var;
            }
            i3Var.a(bArrB);
            treeMap.put(Integer.valueOf(iD2), i3Var);
        }
        if (byteBuffer.remaining() > 0) {
            throw new l4("Record had unexpected number of bytes");
        }
        k3 k3Var = (k3) ((i3) treeMap.get(0));
        if (k3Var != null) {
            ArrayList arrayList = k3Var.f2053a;
            int size = arrayList.size();
            while (i8 < size) {
                Object obj = arrayList.get(i8);
                i8++;
                Integer num = (Integer) obj;
                num.getClass();
                if (((i3) treeMap.get(num)) == null) {
                    throw new l4("Not all mandatory SvcParams are specified");
                }
            }
        }
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2103f);
        sb.append(" ");
        sb.append(this.f2104g);
        for (Map.Entry entry : this.f2105h.entrySet()) {
            sb.append(" ");
            sb.append(f2102j.d(((Integer) entry.getKey()).intValue()));
            String string = ((i3) entry.getValue()).toString();
            if (string != null && !string.isEmpty()) {
                sb.append("=");
                sb.append(string);
            }
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.j(this.f2103f);
        this.f2104g.j(jVar, null, z);
        for (Map.Entry entry : this.f2105h.entrySet()) {
            jVar.j(((Integer) entry.getKey()).intValue());
            byte[] bArrB = ((i3) entry.getValue()).b();
            jVar.j(bArrB.length);
            jVar.g(0, bArrB.length, bArrB);
        }
    }
}

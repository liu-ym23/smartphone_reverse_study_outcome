package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public abstract class e1 {

    /* renamed from: a, reason: collision with root package name */
    public static final c1 f843a = new c1();

    /* renamed from: b, reason: collision with root package name */
    public static final d1 f844b = new d1();

    public static String c(g gVar) {
        StringBuilder sb2 = new StringBuilder(gVar.size());
        for (int i2 = 0; i2 < gVar.size(); i2++) {
            byte bA = gVar.a(i2);
            if (bA == 34) {
                sb2.append("\\\"");
            } else if (bA == 39) {
                sb2.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb2.append("\\a");
                        break;
                    case 8:
                        sb2.append("\\b");
                        break;
                    case 9:
                        sb2.append("\\t");
                        break;
                    case 10:
                        sb2.append("\\n");
                        break;
                    case 11:
                        sb2.append("\\v");
                        break;
                    case 12:
                        sb2.append("\\f");
                        break;
                    case 13:
                        sb2.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb2.append('\\');
                            sb2.append((char) (((bA >>> 6) & 3) + 48));
                            sb2.append((char) (((bA >>> 3) & 7) + 48));
                            sb2.append((char) ((bA & 7) + 48));
                            break;
                        } else {
                            sb2.append((char) bA);
                            break;
                        }
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }

    public static boolean d(byte b10) {
        return b10 > -65;
    }

    public abstract String a(byte[] bArr, int i2, int i10);

    public abstract int b(int i2, int i10, String str, byte[] bArr);

    public abstract int e(byte[] bArr, int i2, int i10);

    public abstract void f(byte[] bArr, int i2, int i10);
}

package w6;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f10781a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static volatile y f10782b;

    public final void a() {
        byte[] bArr;
        synchronized (this) {
            y yVar = f10782b;
            if (yVar != null && (bArr = yVar.f10856c) != null) {
                Arrays.fill(bArr, 0, bArr.length, (byte) 0);
            }
            f10782b = null;
        }
    }
}

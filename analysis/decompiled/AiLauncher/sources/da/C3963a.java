package da;

import Z8.C1174w;
import Z8.F;
import Z8.M;
import ea.AbstractC4017a;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import v9.C5680i;

/* renamed from: da.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3963a extends AbstractC4017a {

    /* renamed from: g, reason: collision with root package name */
    public static final C0388a f32146g = new C0388a(null);

    /* renamed from: h, reason: collision with root package name */
    public static final C3963a f32147h = new C3963a(1, 0, 7);

    /* renamed from: i, reason: collision with root package name */
    public static final C3963a f32148i = new C3963a(new int[0]);

    /* renamed from: da.a$a, reason: collision with other inner class name */
    public static final class C0388a {
        public /* synthetic */ C0388a(i iVar) {
            this();
        }

        public final C3963a a(InputStream stream) {
            p.i(stream, "stream");
            DataInputStream dataInputStream = new DataInputStream(stream);
            C5680i c5680i = new C5680i(1, dataInputStream.readInt());
            ArrayList arrayList = new ArrayList(C1174w.x(c5680i, 10));
            Iterator<Integer> it = c5680i.iterator();
            while (it.hasNext()) {
                ((M) it).nextInt();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            int[] iArrL1 = F.l1(arrayList);
            return new C3963a(Arrays.copyOf(iArrL1, iArrL1.length));
        }

        public C0388a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3963a(int... numbers) {
        super(Arrays.copyOf(numbers, numbers.length));
        p.i(numbers, "numbers");
    }

    public boolean h() {
        return f(f32147h);
    }
}

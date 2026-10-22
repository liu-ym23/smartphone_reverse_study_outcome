package K;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public interface V {

    /* renamed from: a, reason: collision with root package name */
    public static final V f3931a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final List<Integer> f3932b = Collections.unmodifiableList(Arrays.asList(13, 10, 8, 11, 6, 5, 4, 9, 3, 7, 2));

    public class a implements V {
        @Override // K.V
        public boolean a(int i10) {
            return false;
        }

        @Override // K.V
        public W b(int i10) {
            return null;
        }
    }

    boolean a(int i10);

    W b(int i10);
}

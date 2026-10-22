package C8;

import java.util.Arrays;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class a extends D8.a {
    public static final a f = new a(1, 0, 7);

    static {
        new a(new int[0]);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int... numbers) {
        super(Arrays.copyOf(numbers, numbers.length));
        k.f(numbers, "numbers");
    }
}

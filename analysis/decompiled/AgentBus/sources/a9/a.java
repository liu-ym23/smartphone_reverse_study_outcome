package a9;

import java.util.Arrays;
import q7.k;

/* loaded from: classes.dex */
public final class a extends b9.a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f467f = new a(1, 0, 7);

    static {
        new a(new int[0]);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int... iArr) {
        super(Arrays.copyOf(iArr, iArr.length));
        k.e(iArr, "numbers");
    }
}

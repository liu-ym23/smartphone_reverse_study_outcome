package n4;

import j4.k;
import java.util.Random;

/* renamed from: n4.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0885b extends AbstractC0884a {

    /* renamed from: c, reason: collision with root package name */
    private final a f18939c = new a();

    /* renamed from: n4.b$a */
    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // n4.AbstractC0884a
    public Random c() {
        Random random = this.f18939c.get();
        k.f(random, "get(...)");
        return random;
    }
}

package kotlin.ranges;

import W3.AbstractC0402m;
import c4.C0586c;
import k4.InterfaceC0814a;

/* loaded from: classes.dex */
public class a implements Iterable<Character>, InterfaceC0814a {

    /* renamed from: d, reason: collision with root package name */
    public static final C0223a f17947d = new C0223a(null);

    /* renamed from: a, reason: collision with root package name */
    private final char f17948a;

    /* renamed from: b, reason: collision with root package name */
    private final char f17949b;

    /* renamed from: c, reason: collision with root package name */
    private final int f17950c;

    /* renamed from: kotlin.ranges.a$a, reason: collision with other inner class name */
    public static final class C0223a {
        public /* synthetic */ C0223a(j4.g gVar) {
            this();
        }

        private C0223a() {
        }
    }

    public a(char c6, char c7, int i5) {
        if (i5 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i5 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f17948a = c6;
        this.f17949b = (char) C0586c.c(c6, c7, i5);
        this.f17950c = i5;
    }

    public final char a() {
        return this.f17948a;
    }

    public final char c() {
        return this.f17949b;
    }

    @Override // java.lang.Iterable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public AbstractC0402m iterator() {
        return new b(this.f17948a, this.f17949b, this.f17950c);
    }
}

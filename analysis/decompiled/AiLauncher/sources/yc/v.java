package yc;

import java.util.Objects;
import tb.AbstractC5531D;
import tb.C5530C;

/* loaded from: classes5.dex */
public final class v<T> {

    /* renamed from: a, reason: collision with root package name */
    public final C5530C f44470a;

    /* renamed from: b, reason: collision with root package name */
    public final T f44471b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC5531D f44472c;

    public v(C5530C c5530c, T t10, AbstractC5531D abstractC5531D) {
        this.f44470a = c5530c;
        this.f44471b = t10;
        this.f44472c = abstractC5531D;
    }

    public static <T> v<T> c(AbstractC5531D abstractC5531D, C5530C c5530c) {
        Objects.requireNonNull(abstractC5531D, "body == null");
        Objects.requireNonNull(c5530c, "rawResponse == null");
        if (c5530c.getIsSuccessful()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new v<>(c5530c, null, abstractC5531D);
    }

    public static <T> v<T> i(T t10, C5530C c5530c) {
        Objects.requireNonNull(c5530c, "rawResponse == null");
        if (c5530c.getIsSuccessful()) {
            return new v<>(c5530c, t10, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public T a() {
        return this.f44471b;
    }

    public int b() {
        return this.f44470a.getCode();
    }

    public AbstractC5531D d() {
        return this.f44472c;
    }

    public tb.u e() {
        return this.f44470a.getHeaders();
    }

    public boolean f() {
        return this.f44470a.getIsSuccessful();
    }

    public String g() {
        return this.f44470a.getMessage();
    }

    public C5530C h() {
        return this.f44470a;
    }

    public String toString() {
        return this.f44470a.toString();
    }
}

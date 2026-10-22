package v9;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0015B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lv9/c;", "Lv9/a;", "", "", "start", "endInclusive", "<init>", "(CC)V", "", "isEmpty", "()Z", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "e", Const.INTENT_KEY_APIKEY, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: v9.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C5674c extends C5672a {

    /* renamed from: f, reason: collision with root package name */
    public static final C5674c f42846f = new C5674c(1, 0);

    public C5674c(char c10, char c11) {
        super(c10, c11, 1);
    }

    public boolean equals(Object other) {
        if (!(other instanceof C5674c)) {
            return false;
        }
        if (isEmpty() && ((C5674c) other).isEmpty()) {
            return true;
        }
        C5674c c5674c = (C5674c) other;
        return getFirst() == c5674c.getFirst() && getLast() == c5674c.getLast();
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    public boolean isEmpty() {
        return p.k(getFirst(), getLast()) > 0;
    }

    public String toString() {
        return getFirst() + ".." + getLast();
    }
}

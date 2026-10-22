package ha;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event$ID;

/* renamed from: ha.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1551g {

    /* renamed from: a, reason: collision with root package name */
    public final Mark f4594a;
    public final Mark b;

    public AbstractC1551g(Mark mark, Mark mark2) {
        this.f4594a = mark;
        this.b = mark2;
    }

    public String a() {
        return "";
    }

    public abstract Event$ID b();

    public final boolean c(Event$ID event$ID) {
        return b() == event$ID;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof AbstractC1551g) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        return "<" + getClass().getName() + "(" + a() + ")>";
    }
}

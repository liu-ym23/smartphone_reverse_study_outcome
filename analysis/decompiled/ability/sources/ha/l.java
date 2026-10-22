package ha;

import org.yaml.snakeyaml.DumperOptions$ScalarStyle;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event$ID;

/* loaded from: classes4.dex */
public final class l extends k {
    public final String d;
    public final DumperOptions$ScalarStyle e;
    public final String f;
    public final h g;

    public l(String str, String str2, h hVar, String str3, Mark mark, Mark mark2, DumperOptions$ScalarStyle dumperOptions$ScalarStyle) {
        super(str, mark, mark2);
        this.d = str2;
        this.g = hVar;
        if (str3 == null) {
            throw new NullPointerException("Value must be provided.");
        }
        this.f = str3;
        if (dumperOptions$ScalarStyle == null) {
            throw new NullPointerException("Style must be provided.");
        }
        this.e = dumperOptions$ScalarStyle;
    }

    @Override // ha.k, ha.AbstractC1551g
    public final String a() {
        return super.a() + ", tag=" + this.d + ", style=" + this.e + "," + this.g + ", value=" + this.f;
    }

    @Override // ha.AbstractC1551g
    public final Event$ID b() {
        return Event$ID.g;
    }
}

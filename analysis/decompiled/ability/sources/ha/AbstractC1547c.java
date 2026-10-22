package ha;

import org.yaml.snakeyaml.DumperOptions$FlowStyle;
import org.yaml.snakeyaml.error.Mark;

/* renamed from: ha.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1547c extends k {
    public final String d;
    public final boolean e;
    public final DumperOptions$FlowStyle f;

    public AbstractC1547c(String str, String str2, boolean z10, Mark mark, Mark mark2, DumperOptions$FlowStyle dumperOptions$FlowStyle) {
        super(str, mark, mark2);
        this.d = str2;
        this.e = z10;
        if (dumperOptions$FlowStyle == null) {
            throw new NullPointerException("Flow style must be provided.");
        }
        this.f = dumperOptions$FlowStyle;
    }

    @Override // ha.k, ha.AbstractC1551g
    public final String a() {
        return super.a() + ", tag=" + this.d + ", implicit=" + this.e;
    }
}

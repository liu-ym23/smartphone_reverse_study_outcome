package ha;

import java.util.Map;
import org.yaml.snakeyaml.DumperOptions$Version;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event$ID;

/* renamed from: ha.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1550f extends AbstractC1551g {
    public final boolean c;
    public final DumperOptions$Version d;
    public final Map e;

    public C1550f(Mark mark, Mark mark2, boolean z10, DumperOptions$Version dumperOptions$Version, Map map) {
        super(mark, mark2);
        this.c = z10;
        this.d = dumperOptions$Version;
        this.e = map;
    }

    @Override // ha.AbstractC1551g
    public final Event$ID b() {
        return Event$ID.d;
    }
}

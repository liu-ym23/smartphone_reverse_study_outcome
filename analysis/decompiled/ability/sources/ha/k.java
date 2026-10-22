package ha;

import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes4.dex */
public abstract class k extends AbstractC1551g {
    public final String c;

    public k(String str, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.c = str;
    }

    @Override // ha.AbstractC1551g
    public String a() {
        return "anchor=" + this.c;
    }
}

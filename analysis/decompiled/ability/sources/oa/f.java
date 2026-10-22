package oa;

import java.util.ArrayList;
import java.util.List;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.tokens.Token$ID;

/* loaded from: classes4.dex */
public final class f extends k {
    public final String c;
    public final List d;

    public f(String str, ArrayList arrayList, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.c = str;
        if (arrayList == null || arrayList.size() == 2) {
            this.d = arrayList;
        } else {
            throw new YAMLException("Two strings must be provided instead of " + arrayList.size());
        }
    }

    @Override // oa.k
    public final Token$ID a() {
        return Token$ID.Directive;
    }
}

package androidx.work;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public final class OverwritingInputMerger extends InputMerger {
    public OverwritingInputMerger() {
    }

    @Override // androidx.work.InputMerger
    public Data merge(List<Data> r100) {
        Data.Builder r101 = new Data.Builder();
        HashMap r102 = new HashMap();
        Iterator<Data> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.putAll(r103.next().getKeyValueMap());
        goto L4
    L6:
        r101.putAll(r102);
        return r101.build();
    }
}

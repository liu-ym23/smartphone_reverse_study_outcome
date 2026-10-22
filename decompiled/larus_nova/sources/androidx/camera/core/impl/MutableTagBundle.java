package androidx.camera.core.impl;

import android.util.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MutableTagBundle extends TagBundle {
    public static MutableTagBundle create() {
        return new MutableTagBundle(new ArrayMap());
    }

    private MutableTagBundle(Map<String, Object> r100) {
        super(r100);
    }

    public static MutableTagBundle from(TagBundle r100) {
        ArrayMap r101 = new ArrayMap();
        Iterator<String> r102 = r100.listKeys().iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        String r103 = r102.next();
        r101.put(r103, r100.getTag(r103));
        goto L4
    L7:
        return new MutableTagBundle(r101);
    }

    public void addTagBundle(TagBundle r100) {
        Map<String, Object> r101 = this.mTagMap;
        if (r101 == null) goto L8;
        Map<String, Object> r102 = r100.mTagMap;
        if (r102 == null) goto L9;
        r101.putAll(r102);
        return;
    L9:
        return;
    }

    public void putTag(String r100, Object r101) {
        this.mTagMap.put(r100, r101);
    }
}

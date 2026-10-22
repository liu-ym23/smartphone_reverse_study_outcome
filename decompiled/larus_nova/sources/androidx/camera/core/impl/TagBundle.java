package androidx.camera.core.impl;

import android.util.ArrayMap;
import android.util.Pair;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class TagBundle {
    private static final String CAMERAX_USER_TAG_PREFIX = "android.hardware.camera2.CaptureRequest.setTag.CX";
    private static final TagBundle EMPTY_TAGBUNDLE = null;
    private static final String USER_TAG_PREFIX = "android.hardware.camera2.CaptureRequest.setTag.";
    protected final Map<String, Object> mTagMap;

    public final String toString() {
        return CAMERAX_USER_TAG_PREFIX;
    }

    static {
        EMPTY_TAGBUNDLE = new TagBundle(new ArrayMap());
    }

    public Set<String> listKeys() {
        return this.mTagMap.keySet();
    }

    public static TagBundle emptyBundle() {
        return EMPTY_TAGBUNDLE;
    }

    public TagBundle(Map<String, Object> r100) {
        this.mTagMap = r100;
    }

    public static TagBundle create(Pair<String, Object> r100) {
        ArrayMap r101 = new ArrayMap();
        r101.put((String) r100.first, r100.second);
        return new TagBundle(r101);
    }

    public static TagBundle from(TagBundle r100) {
        ArrayMap r101 = new ArrayMap();
        Iterator<String> r102 = r100.listKeys().iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        String r103 = r102.next();
        r101.put(r103, r100.getTag(r103));
        goto L4
    L7:
        return new TagBundle(r101);
    }

    public Object getTag(String r100) {
        return this.mTagMap.get(r100);
    }
}

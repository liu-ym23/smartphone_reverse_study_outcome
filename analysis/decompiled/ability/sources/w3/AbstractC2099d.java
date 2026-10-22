package w3;

import java.util.HashMap;

/* renamed from: w3.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2099d {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f6842a;

    static {
        HashMap map = new HashMap();
        Boolean bool = Boolean.TRUE;
        map.put("https://json-schema.org/draft/2019-09/vocab/core", bool);
        map.put("https://json-schema.org/draft/2019-09/vocab/applicator", bool);
        map.put("https://json-schema.org/draft/2019-09/vocab/validation", bool);
        map.put("https://json-schema.org/draft/2019-09/vocab/meta-data", bool);
        map.put("https://json-schema.org/draft/2019-09/vocab/format", Boolean.FALSE);
        map.put("https://json-schema.org/draft/2019-09/vocab/content", bool);
        f6842a = map;
    }
}

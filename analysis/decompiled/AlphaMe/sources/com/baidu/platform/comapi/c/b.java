package com.baidu.platform.comapi.c;

import com.baidu.mapapi.map.MapLanguage;

/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f8736a;

    private b() {
        super("map_language");
    }

    public static b c() {
        if (f8736a != null) {
            return f8736a;
        }
        synchronized (b.class) {
            try {
                if (f8736a != null) {
                    return f8736a;
                }
                f8736a = new b();
                return f8736a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(MapLanguage mapLanguage) {
        if (mapLanguage == null) {
            return;
        }
        writeInt(mapLanguage.ordinal());
    }

    public MapLanguage b() {
        MapLanguage mapLanguage = MapLanguage.CHINESE;
        int i4 = readInt(mapLanguage.ordinal());
        if (mapLanguage.ordinal() == i4) {
            return mapLanguage;
        }
        MapLanguage mapLanguage2 = MapLanguage.ENGLISH;
        if (mapLanguage2.ordinal() == i4) {
            return mapLanguage2;
        }
        throw new IllegalArgumentException();
    }

    public void a() {
        remove();
    }
}

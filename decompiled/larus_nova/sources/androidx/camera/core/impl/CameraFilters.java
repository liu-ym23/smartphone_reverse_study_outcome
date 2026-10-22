package androidx.camera.core.impl;

import androidx.camera.core.CameraFilter;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CameraFilters {
    public static final CameraFilter ANY = null;
    public static final CameraFilter NONE = null;

    public static /* synthetic */ List a(List r100) {
        return lambda$static$0(r100);
    }

    public static /* synthetic */ List b(List r100) {
        return lambda$static$1(r100);
    }

    private static /* synthetic */ List lambda$static$0(List r100) {
        return r100;
    }

    static {
        ANY = new b();
        NONE = new c();
    }

    private CameraFilters() {
    }

    private static /* synthetic */ List lambda$static$1(List r100) {
        return Collections.emptyList();
    }
}

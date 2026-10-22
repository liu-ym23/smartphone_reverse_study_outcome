package androidx.camera.core.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface EncoderProfilesProvider {
    public static final EncoderProfilesProvider EMPTY = null;
    public static final List<Integer> QUALITY_HIGH_TO_LOW = null;

    EncoderProfilesProxy getAll(int r100);

    boolean hasProfile(int r100);

    static {
        EMPTY = new AnonymousClass1();
        QUALITY_HIGH_TO_LOW = Collections.unmodifiableList(Arrays.asList(new Integer[]{13, 10, 8, 11, 6, 5, 4, 9, 3, 7, 2}));
    }
}

package com.stepos.backend.mnn;

import java.util.Set;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MnnBackendKeys {
    public static final MnnBackendKeys INSTANCE = new MnnBackendKeys();
    public static final String MNN_EMBEDDING = "MNN_EMBEDDING";
    public static final String MNN_CLIP = "MNN_CLIP";
    public static final String MNN_SEGMENT = "MNN_SEGMENT";
    public static final String MNN_INPAINT = "MNN_INPAINT";
    public static final String MNN_EXTEND = "MNN_EXTEND";
    public static final String MNN_SUPER_RES = "MNN_SUPER_RES";
    public static final String MNN_FACE = "MNN_FACE";
    public static final String MNN_FACE_DETECT = "MNN_FACE_DETECT";
    public static final String MNN_FACE_EMBED = "MNN_FACE_EMBED";
    public static final String MNN_FACE_QUALITY = "MNN_FACE_QUALITY";
    private static final Set<String> ALL_KEYS = l.s0(new String[]{"MNN", MNN_EMBEDDING, MNN_CLIP, MNN_SEGMENT, MNN_INPAINT, MNN_EXTEND, MNN_SUPER_RES, MNN_FACE, MNN_FACE_DETECT, MNN_FACE_EMBED, MNN_FACE_QUALITY});

    private MnnBackendKeys() {
    }

    public final Set<String> getALL_KEYS() {
        return ALL_KEYS;
    }
}

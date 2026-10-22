package com.airbnb.lottie.model.content;

import n0.d;
import n0.h;

/* JADX INFO: loaded from: classes3.dex */
public final class Mask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaskMode f24818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f24819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f24820c;

    public static final enum MaskMode extends Enum<MaskMode> {
        public static final MaskMode MaskModeAdd = null;
        public static final MaskMode MaskModeIntersect = null;
        public static final MaskMode MaskModeSubtract = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MaskMode[] f24821a = null;

        static {
            MaskMode r100 = new MaskMode("MaskModeAdd", 0);
            MaskModeAdd = r100;
            MaskMode r101 = new MaskMode("MaskModeSubtract", 1);
            MaskModeSubtract = r101;
            MaskMode r102 = new MaskMode("MaskModeIntersect", 2);
            MaskModeIntersect = r102;
            f24821a = new MaskMode[]{r100, r101, r102};
        }

        public static MaskMode[] values() {
            return (MaskMode[]) f24821a.clone();
        }

        public static MaskMode valueOf(String r100) {
            return (MaskMode) r27.a.a(MaskMode.class, r100);
        }

        public MaskMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public Mask(MaskMode r100, h r101, d r102) {
        this.f24818a = r100;
        this.f24819b = r101;
        this.f24820c = r102;
    }
}

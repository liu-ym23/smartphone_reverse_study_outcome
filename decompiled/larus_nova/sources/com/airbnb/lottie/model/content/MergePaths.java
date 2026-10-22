package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.f;
import i0.c;
import i0.l;
import o0.b;

/* JADX INFO: loaded from: classes28.dex */
public final class MergePaths implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MergePathsMode f24822a;

    public static final enum MergePathsMode extends Enum<MergePathsMode> {
        public static final MergePathsMode Add = null;
        public static final MergePathsMode ExcludeIntersections = null;
        public static final MergePathsMode Intersect = null;
        public static final MergePathsMode Merge = null;
        public static final MergePathsMode Subtract = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MergePathsMode[] f24823a = null;

        static {
            MergePathsMode r100 = new MergePathsMode("Merge", 0);
            Merge = r100;
            MergePathsMode r101 = new MergePathsMode("Add", 1);
            Add = r101;
            MergePathsMode r102 = new MergePathsMode("Subtract", 2);
            Subtract = r102;
            MergePathsMode r103 = new MergePathsMode("Intersect", 3);
            Intersect = r103;
            MergePathsMode r104 = new MergePathsMode("ExcludeIntersections", 4);
            ExcludeIntersections = r104;
            f24823a = new MergePathsMode[]{r100, r101, r102, r103, r104};
        }

        public static MergePathsMode[] values() {
            return (MergePathsMode[]) f24823a.clone();
        }

        public static MergePathsMode forId(int r100) {
            if (r100 == 1) goto L23;
            if (r100 == 2) goto L21;
            if (r100 == 3) goto L19;
            if (r100 == 4) goto L17;
            if (r100 == 5) goto L15;
            return Merge;
        L15:
            return ExcludeIntersections;
        L17:
            return Intersect;
        L19:
            return Subtract;
        L21:
            return Add;
        L23:
            return Merge;
        }

        public static MergePathsMode valueOf(String r100) {
            return (MergePathsMode) r27.a.a(MergePathsMode.class, r100);
        }

        public MergePathsMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final String toString() {
        return "MergePaths{mode=" + this.f24822a + '}';
    }

    public MergePaths(String r100, MergePathsMode r101) {
        this.f24822a = r101;
    }

    @Override // o0.b
    public final c a(LottieDrawable r100, com.airbnb.lottie.model.layer.a r101) {
        if (r100.f24737n == true) goto L7;
        f.b("Animation contains merge paths but they are disabled.");
        return null;
    L7:
        return new l(this);
    }
}

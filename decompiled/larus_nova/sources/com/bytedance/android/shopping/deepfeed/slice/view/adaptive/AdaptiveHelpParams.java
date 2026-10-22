package com.bytedance.android.shopping.deepfeed.slice.view.adaptive;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
public final class AdaptiveHelpParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f173444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f173445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Gravity f173446c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/adaptive/AdaptiveHelpParams$Gravity;", "", "LEFT", "RIGHT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Gravity extends Enum<Gravity> {
        public static final Gravity LEFT = null;
        public static final Gravity RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Gravity[] f173447a = null;

        static {
            Gravity r100 = new Gravity("LEFT", 0);
            LEFT = r100;
            Gravity r101 = new Gravity("RIGHT", 1);
            RIGHT = r101;
            f173447a = new Gravity[]{r100, r101};
        }

        public static Gravity valueOf(String r100) {
            return (Gravity) a.a(Gravity.class, r100);
        }

        public static Gravity[] values() {
            return (Gravity[]) f173447a.clone();
        }

        public Gravity(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AdaptiveHelpParams) == false) goto L12;
        AdaptiveHelpParams r101 = (AdaptiveHelpParams) r100;
        if (this.f173444a == r101.f173444a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f173445b, r101.f173445b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f173446c, r101.f173446c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f173444a * 31;
        String r101 = this.f173445b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Gravity r105 = this.f173446c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "AdaptiveHelpParams(priority=" + this.f173444a + ", tag=" + this.f173445b + ", gravity=" + this.f173446c + ")";
    }

    public AdaptiveHelpParams(int r100, String r101, Gravity r102) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, GXTemplateKey.GAIAX_LAYER_GRAVITY);
        this.f173444a = r100;
        this.f173445b = r101;
        this.f173446c = r102;
    }
}

package com.bytedance.android.shopping.store.marquee;

import com.bytedance.android.ec.model.ECUrlModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECStoreTopMultiMarqueeItemVO {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f185616b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f185617a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/marquee/ECStoreTopMultiMarqueeItemVO$MarqueeType;", "", "", "type", "I", "getType", "()I", "OrderMarquee", "RateMarquee", "FootMarquee", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum MarqueeType extends Enum<MarqueeType> {
        public static final MarqueeType FootMarquee = null;
        public static final MarqueeType OrderMarquee = null;
        public static final MarqueeType RateMarquee = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MarqueeType[] f185618a = null;
        private final int type;

        static {
            MarqueeType r100 = new MarqueeType("OrderMarquee", 0, 1);
            OrderMarquee = r100;
            MarqueeType r101 = new MarqueeType("RateMarquee", 1, 2);
            RateMarquee = r101;
            MarqueeType r102 = new MarqueeType("FootMarquee", 2, 3);
            FootMarquee = r102;
            f185618a = new MarqueeType[]{r100, r101, r102};
        }

        public static MarqueeType valueOf(String r100) {
            return (MarqueeType) r27.a.a(MarqueeType.class, r100);
        }

        public static MarqueeType[] values() {
            return (MarqueeType[]) f185618a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public MarqueeType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f185619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<ECUrlModel> f185620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f185621c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f185622d;

        public b() {
            this(null, null, null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f185619a, r101.f185619a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f185620b, r101.f185620b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f185621c, r101.f185621c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f185622d, r101.f185622d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f185619a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            List<ECUrlModel> r104 = this.f185620b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f185621c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.f185622d;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "MultiMarqueeBubbleItemVO(nickName=" + this.f185619a + ", userAvatars=" + this.f185620b + ", marqueeText=" + this.f185621c + ", marqueeType=" + this.f185622d + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(String r100, List<? extends ECUrlModel> r101, String r102, Integer r103) {
            this.f185619a = r100;
            this.f185620b = r101;
            this.f185621c = r102;
            this.f185622d = r103;
        }
    }

    static {
    }

    public ECStoreTopMultiMarqueeItemVO(List<b> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f185617a = r100;
    }
}

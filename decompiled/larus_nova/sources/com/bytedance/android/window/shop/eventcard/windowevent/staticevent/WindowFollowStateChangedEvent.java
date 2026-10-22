package com.bytedance.android.window.shop.eventcard.windowevent.staticevent;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import hp3.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class WindowFollowStateChangedEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f187814a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/window/shop/eventcard/windowevent/staticevent/WindowFollowStateChangedEvent$FollowSource;", "", "", "area", "Ljava/lang/String;", "getArea", "()Ljava/lang/String;", "TOP_BAR", "INFO_AREA", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum FollowSource extends Enum<FollowSource> {
        public static final FollowSource INFO_AREA = null;
        public static final FollowSource TOP_BAR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FollowSource[] f187815a = null;
        private final String area;

        static {
            FollowSource r100 = new FollowSource("TOP_BAR", 0, BitableAnalytic.MemberItemSource.TOP_BAR_SOURCE);
            TOP_BAR = r100;
            FollowSource r101 = new FollowSource("INFO_AREA", 1, "info_area");
            INFO_AREA = r101;
            f187815a = new FollowSource[]{r100, r101};
        }

        public static FollowSource valueOf(String r100) {
            return (FollowSource) r27.a.a(FollowSource.class, r100);
        }

        public static FollowSource[] values() {
            return (FollowSource[]) f187815a.clone();
        }

        public final String getArea() {
            return this.area;
        }

        public FollowSource(String r100, int r101, String r102) {
            super(r100, r101);
            this.area = r102;
        }
    }

    public static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Object> f187816b;

        @Override // hp3.b
        public final Map<String, Object> a() {
            return this.f187816b;
        }

        public a(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "area");
            super("windowFollowStateChanged");
            this.f187816b = MapsKt.mapOf(new Pair[]{TuplesKt.to("followed", Integer.valueOf(r100)), TuplesKt.to("follow_status", Integer.valueOf(r100)), TuplesKt.to("area", r101)});
        }
    }

    static {
    }
}

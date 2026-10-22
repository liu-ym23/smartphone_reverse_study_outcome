package com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner;

import com.bytedance.android.live.base.model.message.h1;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.base.BaseBannerWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class ActivityTopBannerViewIntent {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/activity/banner/ActivityTopBannerViewIntent$LifeCycle;", "", "ON_RESUME", "ON_PAUSE", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LifeCycle extends Enum<LifeCycle> {
        public static final LifeCycle ON_PAUSE = null;
        public static final LifeCycle ON_RESUME = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LifeCycle[] f115103a = null;

        static {
            LifeCycle r100 = new LifeCycle("ON_RESUME", 0);
            ON_RESUME = r100;
            LifeCycle r101 = new LifeCycle("ON_PAUSE", 1);
            ON_PAUSE = r101;
            f115103a = new LifeCycle[]{r100, r101};
        }

        public static LifeCycle valueOf(String r100) {
            return (LifeCycle) r27.a.a(LifeCycle.class, r100);
        }

        public static LifeCycle[] values() {
            return (LifeCycle[]) f115103a.clone();
        }

        public LifeCycle(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a extends ActivityTopBannerViewIntent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h1 f115104a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f115104a, ((a) r100).f115104a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            h1 r100 = this.f115104a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "BannerMessageEventViewIntent(bannerMessage=" + this.f115104a + ")";
        }

        public a(h1 r100) {
            this.f115104a = r100;
        }
    }

    public static final class b extends ActivityTopBannerViewIntent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BaseBannerWidget.BannerPosition f115105a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f115105a, ((b) r100).f115105a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            BaseBannerWidget.BannerPosition r100 = this.f115105a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "FetchBannerDataViewIntent(bannerPosition=" + this.f115105a + ")";
        }

        public b(BaseBannerWidget.BannerPosition r100) {
            Intrinsics.checkNotNullParameter(r100, "bannerPosition");
            this.f115105a = r100;
        }
    }

    public static final class c extends ActivityTopBannerViewIntent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LifeCycle f115106a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f115106a, ((c) r100).f115106a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            LifeCycle r100 = this.f115106a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "JsBannerLifeCycleViewIntent(cycle=" + this.f115106a + ")";
        }

        public c(LifeCycle r100) {
            Intrinsics.checkNotNullParameter(r100, "cycle");
            this.f115106a = r100;
        }
    }

    public static final class d extends ActivityTopBannerViewIntent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BaseBannerWidget.BannerPosition f115107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BannerInRoomCollection.BannerInfo f115108b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L10;
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f115107a, r101.f115107a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f115108b, r101.f115108b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            BaseBannerWidget.BannerPosition r100 = this.f115107a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            BannerInRoomCollection.BannerInfo r104 = this.f115108b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "JsBannerListViewIntent(source=" + this.f115107a + ", bannerInfo=" + this.f115108b + ")";
        }

        public d(BaseBannerWidget.BannerPosition r100, BannerInRoomCollection.BannerInfo r101) {
            Intrinsics.checkNotNullParameter(r100, "source");
            this.f115107a = r100;
            this.f115108b = r101;
        }
    }

    public static final class e extends ActivityTopBannerViewIntent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BaseBannerWidget.BannerPosition f115109a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof e) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f115109a, ((e) r100).f115109a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            BaseBannerWidget.BannerPosition r100 = this.f115109a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "JsBannerStatusViewIntent(source=" + this.f115109a + ")";
        }

        public e(BaseBannerWidget.BannerPosition r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            this.f115109a = r100;
        }
    }

    public static final class f extends ActivityTopBannerViewIntent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UserEvent f115110a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof f) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f115110a, ((f) r100).f115110a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            UserEvent r100 = this.f115110a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "JsBannerUserEventViewIntent(userEvent=" + this.f115110a + ")";
        }

        public f(UserEvent r100) {
            this.f115110a = r100;
        }
    }

    public static final class g extends ActivityTopBannerViewIntent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f115111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f115112b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof g) == false) goto L10;
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.f115111a, r101.f115111a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f115112b, r101.f115112b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f115111a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f115112b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "LoadUrlViewIntent(originUrl=" + this.f115111a + ", logId=" + this.f115112b + ")";
        }

        public g(String r100, String r101) {
            this.f115111a = r100;
            this.f115112b = r101;
        }
    }

    public ActivityTopBannerViewIntent() {
    }
}

package com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner;

import com.bytedance.android.live.browser.jsbridge.event.RoomBannerBarEvent;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.utils.g2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public abstract class a extends g2 {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a$a, reason: collision with other inner class name */
    public static final class C1692a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RoomBannerBarEvent f115146a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C1692a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f115146a, ((C1692a) r100).f115146a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            RoomBannerBarEvent r100 = this.f115146a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "BannerNameBarEventViewState(roomBannerBarEvent=" + this.f115146a + ")";
        }

        public C1692a(RoomBannerBarEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "roomBannerBarEvent");
            this.f115146a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f115147a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (this.f115147a == ((b) r100).f115147a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            boolean r100 = this.f115147a;
            if (r100 == false) goto L6;
            return 1;
        L6:
            return r100 ? 1 : 0;
        }

        public final String toString() {
            return "ContainerVisibilityViewState(isShow=" + this.f115147a + ")";
        }

        public b(boolean r100) {
            this.f115147a = r100;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f115148a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == true) goto L6;
            return false;
        L6:
            if (this.f115148a == ((c) r100).f115148a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            return this.f115148a;
        }

        public final String toString() {
            return "ContentVisibilityViewState(visibility=" + this.f115148a + ")";
        }

        public c(int r100) {
            this.f115148a = r100;
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f115149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BannerInRoomCollection.BannerInfo f115150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f115151c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L12;
            d r101 = (d) r100;
            if (this.f115149a == r101.f115149a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f115150b, r101.f115150b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f115151c, r101.f115151c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public final int hashCode() {
            boolean r100 = this.f115149a;
            ?? r101 = r100;
            if (r100 == false) goto L5;
            r101 = 1;
        L5:
            int r102 = r101 * 31;
            BannerInRoomCollection.BannerInfo r103 = this.f115150b;
            int r104 = 0;
            if (r103 == null) goto L8;
            int r105 = r103.hashCode();
        L9:
            int r106 = (r102 + r105) * 31;
            String r107 = this.f115151c;
            if (r107 == null) goto L13;
            r104 = r107.hashCode();
        L13:
            return r106 + r104;
        L8:
            r105 = 0;
            goto L9
        }

        public final String toString() {
            return "FetchBannerDataViewState(isSuccess=" + this.f115149a + ", data=" + this.f115150b + ", msg=" + this.f115151c + ")";
        }

        public d(boolean r100, BannerInRoomCollection.BannerInfo r101, String r102) {
            this.f115149a = r100;
            this.f115150b = r101;
            this.f115151c = r102;
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f115152a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof e) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f115152a, ((e) r100).f115152a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f115152a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "InitViewState(source=" + this.f115152a + ")";
        }

        public e() {
            this.f115152a = "start";
        }
    }

    public static final class f extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f115153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JSONObject f115154b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof f) == false) goto L10;
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f115153a, r101.f115153a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f115154b, r101.f115154b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f115153a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            JSONObject r104 = this.f115154b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "JsEventViewState(eventName=" + this.f115153a + ", jsonData=" + this.f115154b + ")";
        }

        public f(String r100, JSONObject r101) {
            this.f115153a = r100;
            this.f115154b = r101;
        }
    }

    public static final class g extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f115155a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof g) == true) goto L6;
            return false;
        L6:
            if (this.f115155a == ((g) r100).f115155a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            boolean r100 = this.f115155a;
            if (r100 == false) goto L6;
            return 1;
        L6:
            return r100 ? 1 : 0;
        }

        public final String toString() {
            return "KeyboardStatusViewState(show=" + this.f115155a + ")";
        }

        public g(boolean r100) {
            this.f115155a = r100;
        }
    }

    public static final class h extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BannerInRoomCollection.BannerInfo f115156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f115157b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof h) == false) goto L10;
            h r101 = (h) r100;
            if (Intrinsics.areEqual(this.f115156a, r101.f115156a) == true) goto L8;
            return false;
        L8:
            if (this.f115157b == r101.f115157b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            BannerInRoomCollection.BannerInfo r100 = this.f115156a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L7:
            return (r101 * 31) + this.f115157b;
        L5:
            r101 = 0;
            goto L7
        }

        public final String toString() {
            return "LoadMessageBannerState(bannerInfo=" + this.f115156a + ", operationType=" + this.f115157b + ")";
        }

        public h(BannerInRoomCollection.BannerInfo r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "bannerInfo");
            this.f115156a = r100;
            this.f115157b = r101;
        }
    }

    public static final class i extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f115158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f115159b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof i) == false) goto L10;
            i r101 = (i) r100;
            if (Intrinsics.areEqual(this.f115158a, r101.f115158a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f115159b, r101.f115159b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f115158a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f115159b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "LoadUrlViewState(originUrl=" + this.f115158a + ", finalUrl=" + this.f115159b + ")";
        }

        public i(String r100, String r101) {
            this.f115158a = r100;
            this.f115159b = r101;
        }
    }

    public static final class j extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f115160a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof j) == true) goto L6;
            return false;
        L6:
            if (this.f115160a == ((j) r100).f115160a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            return this.f115160a;
        }

        public final String toString() {
            return "RefreshActivityBannerNumberEventState(bannerNumber=" + this.f115160a + ")";
        }

        public j(int r100) {
            this.f115160a = r100;
        }
    }

    public a() {
    }
}

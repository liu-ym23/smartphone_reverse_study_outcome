package com.bytedance.android.livesdk.livecommerce.userinfo.title.state;

import com.bytedance.android.ec.live.api.commerce.userinfo.ECAuthorArea;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ECUserInfoState implements com.bytedance.android.ec.core.arch.state.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f152996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f152997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f152998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f152999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f153000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f153001f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/state/ECUserInfoState$AnimStateEnum;", "", UserProfileEvent.POSITION_NONE, "FOLLOWED_HIDING", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AnimStateEnum extends Enum<AnimStateEnum> {
        public static final AnimStateEnum FOLLOWED_HIDING = null;
        public static final AnimStateEnum NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnimStateEnum[] f153002a = null;

        static {
            AnimStateEnum r100 = new AnimStateEnum(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            AnimStateEnum r101 = new AnimStateEnum("FOLLOWED_HIDING", 1);
            FOLLOWED_HIDING = r101;
            f153002a = new AnimStateEnum[]{r100, r101};
        }

        public static AnimStateEnum valueOf(String r100) {
            return (AnimStateEnum) r27.a.a(AnimStateEnum.class, r100);
        }

        public static AnimStateEnum[] values() {
            return (AnimStateEnum[]) f153002a.clone();
        }

        public AnimStateEnum(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AnimStateEnum f153003a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f153003a, ((a) r100).f153003a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            AnimStateEnum r100 = this.f153003a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "AnimState(state=" + this.f153003a + ")";
        }

        public a() {
            this(AnimStateEnum.NONE);
        }

        public a(AnimStateEnum r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            this.f153003a = r100;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ECUrlModel f153004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ECUrlModel f153005b;

        public b() {
            this(null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f153004a, r101.f153004a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f153005b, r101.f153005b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            ECUrlModel r100 = this.f153004a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            ECUrlModel r104 = this.f153005b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "AvatarState(avatarThumb=" + this.f153004a + ", avatarBorder=" + this.f153005b + ")";
        }

        public b(ECUrlModel r100, ECUrlModel r101) {
            this.f153004a = r100;
            this.f153005b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Integer f153006a;

        public c() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f153006a, ((c) r100).f153006a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.f153006a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "BackgroundState(backgroundColor=" + this.f153006a + ")";
        }

        public c(Integer r100) {
            this.f153006a = r100;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<ECAuthorArea.e> f153007a;

        public d() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f153007a, ((d) r100).f153007a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            List<ECAuthorArea.e> r100 = this.f153007a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Introduction(introductionList=" + this.f153007a + ")";
        }

        public d(List<ECAuthorArea.e> r100) {
            this.f153007a = r100;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f153008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f153009b;

        public e() {
            this(null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof e) == false) goto L10;
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f153008a, r101.f153008a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f153009b, r101.f153009b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f153008a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            List<String> r104 = this.f153009b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "NicknameState(nickname=" + this.f153008a + ", nickColor=" + this.f153009b + ")";
        }

        public e(String r100, List<String> r101) {
            this.f153008a = r100;
            this.f153009b = r101;
        }
    }

    public ECUserInfoState() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECUserInfoState) == false) goto L18;
        ECUserInfoState r101 = (ECUserInfoState) r100;
        if (Intrinsics.areEqual(this.f152996a, r101.f152996a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f152997b, r101.f152997b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f152998c, r101.f152998c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f152999d, r101.f152999d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f153000e, r101.f153000e) == true) goto L16;
        return false;
    L16:
        if (this.f153001f == r101.f153001f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        b r100 = this.f152996a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        e r104 = this.f152997b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        c r107 = this.f152998c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        d r110 = this.f152999d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        a r113 = this.f153000e;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        int r114 = (r112 + r101) * 31;
        boolean r115 = this.f153001f;
        ?? r116 = r115;
        if (r115 == false) goto L25;
        r116 = 1;
    L25:
        return r114 + r116;
    L17:
        r111 = 0;
        goto L18
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
        return "ECUserInfoState(avatar=" + this.f152996a + ", nickname=" + this.f152997b + ", background=" + this.f152998c + ", introduction=" + this.f152999d + ", animState=" + this.f153000e + ", hasInit=" + this.f153001f + ")";
    }

    public /* synthetic */ ECUserInfoState(int r100) {
        this(new b(null, null), new e(null, null), new c(null), new d(null), new a(AnimStateEnum.NONE), false);
    }

    public ECUserInfoState(b r100, e r101, c r102, d r103, a r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "avatar");
        Intrinsics.checkNotNullParameter(r101, InstantPlayContext.NICKNAME);
        Intrinsics.checkNotNullParameter(r102, "background");
        Intrinsics.checkNotNullParameter(r103, "introduction");
        Intrinsics.checkNotNullParameter(r104, "animState");
        this.f152996a = r100;
        this.f152997b = r101;
        this.f152998c = r102;
        this.f152999d = r103;
        this.f153000e = r104;
        this.f153001f = r105;
    }

    public static ECUserInfoState a(ECUserInfoState r100, b r101, e r102, c r110, d r111, a r112, boolean r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        r101 = r100.f152996a;
    L5:
        b r103 = r101;
        if ((r114 & 2) == 0) goto L8;
        r102 = r100.f152997b;
    L8:
        e r104 = r102;
        if ((r114 & 4) == 0) goto L11;
        r110 = r100.f152998c;
    L11:
        c r105 = r110;
        if ((r114 & 8) == 0) goto L14;
        r111 = r100.f152999d;
    L14:
        d r106 = r111;
        if ((r114 & 16) == 0) goto L17;
        r112 = r100.f153000e;
    L17:
        a r107 = r112;
        if ((r114 & 32) == 0) goto L20;
        r113 = r100.f153001f;
    L20:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "avatar");
        Intrinsics.checkNotNullParameter(r104, InstantPlayContext.NICKNAME);
        Intrinsics.checkNotNullParameter(r105, "background");
        Intrinsics.checkNotNullParameter(r106, "introduction");
        Intrinsics.checkNotNullParameter(r107, "animState");
        return new ECUserInfoState(r103, r104, r105, r106, r107, r113);
    }
}

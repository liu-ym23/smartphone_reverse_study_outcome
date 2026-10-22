package c21;

import com.bytedance.android.live.revlink.impl.mergepk.params.BattleInviteType;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f22142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f22143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22144c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f22145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f22146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PlayMode f22147c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final BattleInviteType f22148d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f22149e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f22150f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<String> f22151g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f22152h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final IBattleConfigSetting f22153i;

        public a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L24;
            a r101 = (a) r100;
            if (this.f22145a == r101.f22145a) goto L8;
            return false;
        L8:
            if (this.f22146b == r101.f22146b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f22147c, r101.f22147c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f22148d, r101.f22148d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f22149e, r101.f22149e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f22150f, r101.f22150f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f22151g, r101.f22151g) == true) goto L20;
            return false;
        L20:
            if (this.f22152h == r101.f22152h) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.f22153i, r101.f22153i) == true) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        public final int hashCode() {
            long r100 = this.f22145a;
            int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f22146b) * 31;
            PlayMode r102 = this.f22147c;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = r102.hashCode();
        L6:
            int r105 = (r101 + r104) * 31;
            BattleInviteType r106 = this.f22148d;
            if (r106 == null) goto L9;
            int r107 = r106.hashCode();
        L10:
            int r108 = (r105 + r107) * 31;
            String r109 = this.f22149e;
            if (r109 == null) goto L13;
            int r110 = r109.hashCode();
        L14:
            int r111 = (r108 + r110) * 31;
            String r112 = this.f22150f;
            if (r112 == null) goto L17;
            int r113 = r112.hashCode();
        L18:
            int r114 = (r111 + r113) * 31;
            List<String> r115 = this.f22151g;
            if (r115 == null) goto L21;
            int r116 = r115.hashCode();
        L22:
            int r117 = (((r114 + r116) * 31) + this.f22152h) * 31;
            IBattleConfigSetting r118 = this.f22153i;
            if (r118 == null) goto L26;
            r103 = r118.hashCode();
        L26:
            return r117 + r103;
        L21:
            r116 = 0;
            goto L22
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        public final String toString() {
            return "CommonParams(duration=" + this.f22145a + ", scene=" + this.f22146b + ", playMode=" + this.f22147c + ", inviteType=" + this.f22148d + ", theme=" + this.f22149e + ", token=" + this.f22150f + ", selectAnchorIds=" + this.f22151g + ", anchorListSize=" + this.f22152h + ", battleConfigSetting=" + this.f22153i + ")";
        }

        public a(long r100, int r101, PlayMode r102, BattleInviteType r103, String r104, String r110, List r111, IBattleConfigSetting r112, int r113) {
            if ((r113 & 2) == 0) goto L6;
            r101 = 1;
        L6:
            if ((r113 & 4) == 0) goto L9;
            r102 = null;
        L9:
            if ((r113 & 8) == 0) goto L12;
            r103 = BattleInviteType.UNKNOWN;
        L12:
            if ((r113 & 16) == 0) goto L15;
            r104 = "";
        L15:
            if ((r113 & 32) == 0) goto L18;
            r110 = "";
        L18:
            if ((r113 & 64) == 0) goto L21;
            r111 = null;
        L21:
            if ((r113 & 256) == 0) goto L23;
            r112 = null;
        L23:
            Intrinsics.checkNotNullParameter(r103, "inviteType");
            Intrinsics.checkNotNullParameter(r104, "theme");
            Intrinsics.checkNotNullParameter(r110, "token");
            this.f22145a = r100;
            this.f22146b = r101;
            this.f22147c = r102;
            this.f22148d = r103;
            this.f22149e = r104;
            this.f22150f = r110;
            this.f22151g = r111;
            this.f22152h = 0;
            this.f22153i = r112;
        }
    }

    public e(a r100, f r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "commonParams");
        Intrinsics.checkNotNullParameter(r101, "battlePlayMode");
        Intrinsics.checkNotNullParameter(r102, "name");
        this.f22142a = r100;
        this.f22143b = r101;
        this.f22144c = r102;
    }
}

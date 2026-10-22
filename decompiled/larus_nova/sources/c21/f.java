package c21;

import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.d4;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.m3;
import com.bytedance.android.livesdk.link.model.u2;
import com.bytedance.android.livesdk.link.model.v0;
import com.bytedance.android.livesdk.link.model.v2;
import com.bytedance.android.livesdk.link.model.w2;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PlayMode f22154a;

    public static final class a extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final m3 f22155b;

        public a(int r100, m3 r101) {
            super(PlayMode.PERSONAL_PK);
            this.f22155b = r101;
        }
    }

    public static final class b extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final v0 f22156b;

        public b(int r100, PlayMode r101, v0 r102) {
            Intrinsics.checkNotNullParameter(r101, Keys.API_EVENT_KEY_PLAY_MODE);
            super(PlayMode.PERSONAL_PK);
            this.f22156b = r102;
        }
    }

    public static final class c extends f {
        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "gameAppId");
            super(PlayMode.PERSONAL_PK);
        }
    }

    public static final class d extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final u2 f22157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final v2 f22158c;

        public d(int r100, PlayMode r101, u2 r102, v2 r103) {
            Intrinsics.checkNotNullParameter(r101, Keys.API_EVENT_KEY_PLAY_MODE);
            super(r101);
            this.f22157b = r102;
            this.f22158c = r103;
        }
    }

    public static final class e extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f22159b;

        public e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "flexActivityId");
            super(PlayMode.PERSONAL_PK);
            this.f22159b = r100;
        }
    }

    /* JADX INFO: renamed from: c21.f$f, reason: collision with other inner class name */
    public static final class C0394f extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IBattleConfigSetting f22160b;

        public C0394f(int r100, PlayMode r101, IBattleConfigSetting r102) {
            Intrinsics.checkNotNullParameter(r101, Keys.API_EVENT_KEY_PLAY_MODE);
            super(r101);
            this.f22160b = r102;
        }
    }

    public static final class g extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d4 f22161b;

        public g(int r100, PlayMode r101, d4 r102) {
            Intrinsics.checkNotNullParameter(r101, Keys.API_EVENT_KEY_PLAY_MODE);
            super(r101);
            this.f22161b = r102;
        }
    }

    public static final class h extends f {
        public h(int r100, PlayMode r101) {
            Intrinsics.checkNotNullParameter(r101, Keys.API_EVENT_KEY_PLAY_MODE);
            super(r101);
        }
    }

    public static final class i extends f {
        public i(PlayMode r100) {
            Intrinsics.checkNotNullParameter(r100, Keys.API_EVENT_KEY_PLAY_MODE);
            super(PlayMode.PERSONAL_PK);
        }
    }

    public static final class j extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final j f22162b = null;

        static {
            f22162b = new j();
        }

        public j() {
            super(PlayMode.PERSONAL_PK);
        }
    }

    public static final class k extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final w2 f22163b;

        public k(int r100, PlayMode r101, w2 r102) {
            Intrinsics.checkNotNullParameter(r101, Keys.API_EVENT_KEY_PLAY_MODE);
            super(r101);
            this.f22163b = r102;
        }
    }

    public static final class l extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h9 f22164b;

        public l(int r100, PlayMode r101, h9 r102) {
            Intrinsics.checkNotNullParameter(r101, Keys.API_EVENT_KEY_PLAY_MODE);
            super(r101);
            this.f22164b = r102;
        }
    }

    public static final class m extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final aa f22165b;

        public m(int r100, aa r101) {
            super(PlayMode.PERSONAL_PK);
            this.f22165b = r101;
        }
    }

    public final String b() {
        if ((this instanceof m) == false) goto L6;
        return "vote";
    L6:
        if ((this instanceof d) == false) goto L9;
        return "customize_pk";
    L9:
        if ((this instanceof e) == false) goto L12;
        return "activity_pk";
    L12:
        if ((this instanceof k) == false) goto L15;
        return "compete";
    L15:
        if ((this instanceof l) == false) goto L18;
        return "focus_gift";
    L18:
        if ((this instanceof a) == false) goto L21;
        return "cooperation";
    L21:
        if ((this instanceof c) == false) goto L24;
        return "cohost_game";
    L24:
        if ((this instanceof i) == false) goto L27;
        return "c_position";
    L27:
        if ((this instanceof b) == false) goto L30;
        return "link_screen";
    L30:
        if ((this instanceof C0394f) == false) goto L33;
        return "interact_compete";
    L33:
        if (this.f22154a != PlayMode.TEAM_PK) goto L35;
        return "team_pk";
    L35:
        return "routine_pk";
    }

    public f(PlayMode r100) {
        this.f22154a = r100;
    }

    public final boolean a(f r100) {
        if ((this instanceof h) == false) goto L7;
        if ((r100 instanceof h) == false) goto L7;
    L46:
        return true;
    L7:
        if ((this instanceof m) == false) goto L11;
        if ((r100 instanceof m) == true) goto L46;
    L11:
        if ((this instanceof e) == false) goto L15;
        if ((r100 instanceof e) == true) goto L46;
    L15:
        if ((this instanceof d) == false) goto L19;
        if ((r100 instanceof d) == true) goto L46;
    L19:
        if ((this instanceof k) == false) goto L23;
        if ((r100 instanceof k) == true) goto L46;
    L23:
        if ((this instanceof a) == false) goto L27;
        if ((r100 instanceof a) == true) goto L46;
    L27:
        if ((this instanceof l) == false) goto L31;
        if ((r100 instanceof l) == true) goto L46;
    L31:
        if ((this instanceof c) == false) goto L35;
        if ((r100 instanceof c) == true) goto L46;
    L35:
        if ((this instanceof i) == false) goto L39;
        if ((r100 instanceof i) == true) goto L46;
    L39:
        if ((this instanceof b) == false) goto L43;
        if ((r100 instanceof b) == true) goto L46;
    L43:
        if ((this instanceof C0394f) == true) goto L45;
    L47:
        return false;
    L45:
        if ((r100 instanceof C0394f) == false) goto L47;
        goto L46
    }
}

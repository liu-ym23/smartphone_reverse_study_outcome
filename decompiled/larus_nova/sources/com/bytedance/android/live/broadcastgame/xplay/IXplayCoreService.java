package com.bytedance.android.live.broadcastgame.xplay;

import android.view.View;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public interface IXplayCoreService {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/IXplayCoreService$State;", "", "Stopped", "Loading", "Loaded", "Running", "SwitchToGuide", "SwitchToHost", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State Loaded = null;
        public static final State Loading = null;
        public static final State Running = null;
        public static final State Stopped = null;
        public static final State SwitchToGuide = null;
        public static final State SwitchToHost = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f61839a = null;

        static {
            State r100 = new State("Stopped", 0);
            Stopped = r100;
            State r101 = new State("Loading", 1);
            Loading = r101;
            State r102 = new State("Loaded", 2);
            Loaded = r102;
            State r103 = new State("Running", 3);
            Running = r103;
            State r104 = new State("SwitchToGuide", 4);
            SwitchToGuide = r104;
            State r105 = new State("SwitchToHost", 5);
            SwitchToHost = r105;
            f61839a = new State[]{r100, r101, r102, r103, r104, r105};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f61839a.clone();
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f61840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f61841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f61842c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f61843d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f61844e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f61845f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f61846g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f61847h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f61848i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f61849j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Map<String, String> f61850k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f61851l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final XplayApi.i f61852m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Long f61853n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final boolean f61854o;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L36;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f61840a, r101.f61840a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f61841b, r101.f61841b) == true) goto L10;
            return false;
        L10:
            if (this.f61842c == r101.f61842c) goto L12;
            return false;
        L12:
            if (this.f61843d == r101.f61843d) goto L14;
            return false;
        L14:
            if (this.f61844e == r101.f61844e) goto L16;
            return false;
        L16:
            if (this.f61845f == r101.f61845f) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f61846g, r101.f61846g) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.f61847h, r101.f61847h) == true) goto L22;
            return false;
        L22:
            if (this.f61848i == r101.f61848i) goto L24;
            return false;
        L24:
            if (this.f61849j == r101.f61849j) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.f61850k, r101.f61850k) == true) goto L28;
            return false;
        L28:
            if (this.f61851l == r101.f61851l) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f61852m, r101.f61852m) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.f61853n, r101.f61853n) == true) goto L34;
            return false;
        L34:
            if (this.f61854o == r101.f61854o) goto L55;
            return false;
        L55:
            return true;
        L36:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20, types: [int] */
        /* JADX WARN: Type inference failed for: r0v30, types: [int] */
        /* JADX WARN: Type inference failed for: r2v15, types: [int] */
        /* JADX WARN: Type inference failed for: r2v26 */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public final int hashCode() {
            String r100 = this.f61840a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f61841b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (((((((((r103 + r105) * 31) + this.f61842c) * 31) + this.f61843d) * 31) + this.f61844e) * 31) + this.f61845f) * 31;
            String r107 = this.f61846g;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f61847h;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (((r109 + r111) * 31) + this.f61848i) * 31;
            boolean r113 = this.f61849j;
            ?? r114 = 1;
            ?? r115 = r113;
            if (r113 == false) goto L21;
            r115 = 1;
        L21:
            int r116 = (r112 + r115) * 31;
            Map<String, String> r117 = this.f61850k;
            if (r117 == null) goto L24;
            int r118 = r117.hashCode();
        L25:
            int r119 = (((r116 + r118) * 31) + this.f61851l) * 31;
            XplayApi.i r120 = this.f61852m;
            if (r120 == null) goto L28;
            int r121 = r120.hashCode();
        L29:
            int r122 = (r119 + r121) * 31;
            Long r123 = this.f61853n;
            if (r123 == null) goto L32;
            r101 = r123.hashCode();
        L32:
            int r124 = (r122 + r101) * 31;
            boolean r125 = this.f61854o;
            if (r125 == true) goto L37;
            r114 = r125;
        L37:
            return r124 + r114;
        L28:
            r121 = 0;
            goto L29
        L24:
            r118 = 0;
            goto L25
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
            return "StartParams(gameId=" + this.f61840a + ", channel=" + this.f61841b + ", displayWidth=" + this.f61842c + ", displayHeight=" + this.f61843d + ", widthRatio=" + this.f61844e + ", heightRatio=" + this.f61845f + ", token=" + this.f61846g + ", openId=" + this.f61847h + ", pushStreamType=" + this.f61848i + ", useTextureView=" + this.f61849j + ", extraToServer=" + this.f61850k + ", pushStreamMode=" + this.f61851l + ", podRtcInfo=" + this.f61852m + ", audioMixType=" + this.f61853n + ", useFullScreen=" + this.f61854o + ")";
        }

        public a(String r100, String r101, int r102, int r103, int r104, int r105, String r106, String r107, int r110, boolean r111, Map r112, XplayApi.i r113, Long r114, boolean r115) {
            Intrinsics.checkNotNullParameter(r100, "gameId");
            Intrinsics.checkNotNullParameter(r101, "channel");
            Intrinsics.checkNotNullParameter(r106, "token");
            Intrinsics.checkNotNullParameter(r107, "openId");
            Intrinsics.checkNotNullParameter(r112, "extraToServer");
            this.f61840a = r100;
            this.f61841b = r101;
            this.f61842c = r102;
            this.f61843d = r103;
            this.f61844e = r104;
            this.f61845f = r105;
            this.f61846g = r106;
            this.f61847h = r107;
            this.f61848i = r110;
            this.f61849j = r111;
            this.f61850k = r112;
            this.f61851l = 2;
            this.f61852m = r113;
            this.f61853n = r114;
            this.f61854o = r115;
        }
    }

    void I();

    void J();

    View K();

    PublishSubject L();

    PublishSubject N();

    void R();

    void S(a r100);

    a U();

    PublishSubject X();

    View Y();

    Boolean g();

    PublishSubject getOnError();

    String getRtcExtInfo();

    State getState();

    void pauseGame();

    void resumeGame();

    void setRtcExtInfo(String r100);

    void updateEnableAudioFrame(boolean r100);

    void updateEnableVideoFrame(boolean r100);
}

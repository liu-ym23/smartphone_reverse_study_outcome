package aha;

import com.obric.assistant.state.api.multitask.state.ModeEndReason;
import com.obric.assistant.state.api.multitask.state.ModeRefreshSource;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class l implements jha.o, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ObricInteractionType f3615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final jha.h f3616e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f3617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f3618g;

    public static final class a extends l {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f3619h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f3620i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f3621j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final ObricInteractionType f3622k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final ModeRefreshSource f3623l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final jha.h f3624m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Map<String, Object> f3625n;

        public a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f3619h, r101.f3619h) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3620i, r101.f3620i) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3621j, r101.f3621j) == true) goto L18;
            return false;
        L18:
            if (this.f3622k == r101.f3622k) goto L21;
            return false;
        L21:
            if (this.f3623l == r101.f3623l) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3624m, r101.f3624m) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f3625n, r101.f3625n) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f3619h.hashCode() * 31;
            String r101 = this.f3620i;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((((((((((r100 + r102) * 31) + this.f3621j.hashCode()) * 31) + this.f3622k.hashCode()) * 31) + this.f3623l.hashCode()) * 31) + this.f3624m.hashCode()) * 31) + this.f3625n.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Active(botId=" + this.f3619h + ", conversationId=" + this.f3620i + ", sessionId=" + this.f3621j + ", interactionType=" + this.f3622k + ", refreshSource=" + this.f3623l + ", lifecycleStage=" + this.f3624m + ", ext=" + this.f3625n + ')';
        }

        @Override // aha.l, jha.a
        public final jha.h a() {
            return this.f3624m;
        }

        @Override // aha.l
        public final String d() {
            return this.f3620i;
        }

        @Override // aha.l
        public final ObricInteractionType e() {
            return this.f3622k;
        }

        @Override // aha.l
        public final String f() {
            return this.f3621j;
        }

        @Override // aha.l, aha.t
        public final String getBotId() {
            return this.f3619h;
        }

        public a(String r100, String r110, String r111, ObricInteractionType r112, ModeRefreshSource r113, Map r114) {
            jha.h.a r101 = jha.h.a.f499136a;
            Intrinsics.checkNotNullParameter(r100, "botId");
            Intrinsics.checkNotNullParameter(r111, "sessionId");
            Intrinsics.checkNotNullParameter(r112, "interactionType");
            Intrinsics.checkNotNullParameter(r113, "refreshSource");
            Intrinsics.checkNotNullParameter(r101, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r114, "ext");
            super(r100, r110, r111, r112, r101, r114);
            this.f3619h = r100;
            this.f3620i = r110;
            this.f3621j = r111;
            this.f3622k = r112;
            this.f3623l = r113;
            this.f3624m = r101;
            this.f3625n = r114;
        }
    }

    public static final class b extends l {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f3626h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f3627i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f3628j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final ObricInteractionType f3629k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final ModeEndReason f3630l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final jha.h f3631m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Map<String, Object> f3632n;

        public b() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f3626h, r101.f3626h) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3627i, r101.f3627i) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3628j, r101.f3628j) == true) goto L18;
            return false;
        L18:
            if (this.f3629k == r101.f3629k) goto L21;
            return false;
        L21:
            if (this.f3630l == r101.f3630l) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3631m, r101.f3631m) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f3632n, r101.f3632n) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f3626h.hashCode() * 31;
            String r101 = this.f3627i;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((((((((((r100 + r102) * 31) + this.f3628j.hashCode()) * 31) + this.f3629k.hashCode()) * 31) + this.f3630l.hashCode()) * 31) + this.f3631m.hashCode()) * 31) + this.f3632n.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "End(botId=" + this.f3626h + ", conversationId=" + this.f3627i + ", sessionId=" + this.f3628j + ", interactionType=" + this.f3629k + ", reason=" + this.f3630l + ", lifecycleStage=" + this.f3631m + ", ext=" + this.f3632n + ')';
        }

        @Override // aha.l, jha.a
        public final jha.h a() {
            return this.f3631m;
        }

        @Override // aha.l
        public final String d() {
            return this.f3627i;
        }

        @Override // aha.l
        public final ObricInteractionType e() {
            return this.f3629k;
        }

        @Override // aha.l
        public final String f() {
            return this.f3628j;
        }

        @Override // aha.l, aha.t
        public final String getBotId() {
            return this.f3626h;
        }

        public b(String r100, String r110, String r111, ObricInteractionType r112, ModeEndReason r113, Map r114) {
            jha.h.c r101 = jha.h.c.f499138a;
            Intrinsics.checkNotNullParameter(r100, "botId");
            Intrinsics.checkNotNullParameter(r111, "sessionId");
            Intrinsics.checkNotNullParameter(r112, "interactionType");
            Intrinsics.checkNotNullParameter(r113, "reason");
            Intrinsics.checkNotNullParameter(r101, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r114, "ext");
            super(r100, r110, r111, r112, r101, r114);
            this.f3626h = r100;
            this.f3627i = r110;
            this.f3628j = r111;
            this.f3629k = r112;
            this.f3630l = r113;
            this.f3631m = r101;
            this.f3632n = r114;
        }
    }

    public static final class c extends l {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f3633h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f3634i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f3635j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final ObricInteractionType f3636k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final jha.h f3637l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Map<String, Object> f3638m;

        public c() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f3633h, r101.f3633h) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3634i, r101.f3634i) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3635j, r101.f3635j) == true) goto L18;
            return false;
        L18:
            if (this.f3636k == r101.f3636k) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3637l, r101.f3637l) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3638m, r101.f3638m) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f3633h.hashCode() * 31;
            String r101 = this.f3634i;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((((((((r100 + r102) * 31) + this.f3635j.hashCode()) * 31) + this.f3636k.hashCode()) * 31) + this.f3637l.hashCode()) * 31) + this.f3638m.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Start(botId=" + this.f3633h + ", conversationId=" + this.f3634i + ", sessionId=" + this.f3635j + ", interactionType=" + this.f3636k + ", lifecycleStage=" + this.f3637l + ", ext=" + this.f3638m + ')';
        }

        @Override // aha.l, jha.a
        public final jha.h a() {
            return this.f3637l;
        }

        @Override // aha.l
        public final String d() {
            return this.f3634i;
        }

        @Override // aha.l
        public final ObricInteractionType e() {
            return this.f3636k;
        }

        @Override // aha.l
        public final String f() {
            return this.f3635j;
        }

        @Override // aha.l, aha.t
        public final String getBotId() {
            return this.f3633h;
        }

        public c(String r100, String r110, String r111, ObricInteractionType r112, Map r113) {
            jha.h.a r101 = jha.h.a.f499136a;
            Intrinsics.checkNotNullParameter(r100, "botId");
            Intrinsics.checkNotNullParameter(r111, "sessionId");
            Intrinsics.checkNotNullParameter(r112, "interactionType");
            Intrinsics.checkNotNullParameter(r101, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r113, "ext");
            super(r100, r110, r111, r112, r101, r113);
            this.f3633h = r100;
            this.f3634i = r110;
            this.f3635j = r111;
            this.f3636k = r112;
            this.f3637l = r101;
            this.f3638m = r113;
        }
    }

    public l() {
        throw null;
    }

    @Override // aha.t
    public final u b() {
        return new u(getBotId(), d(), e(), f());
    }

    @Override // jha.a
    public jha.h a() {
        return this.f3616e;
    }

    @Override // aha.t
    public final String c() {
        return this.f3617f;
    }

    public String d() {
        return this.f3613b;
    }

    public ObricInteractionType e() {
        return this.f3615d;
    }

    public String f() {
        return this.f3614c;
    }

    @Override // aha.t
    public String getBotId() {
        return this.f3612a;
    }

    public l(String r100, String r101, String r102, ObricInteractionType r103, jha.h r104, Map r105) {
        this.f3612a = r100;
        this.f3613b = r101;
        this.f3614c = r102;
        this.f3615d = r103;
        this.f3616e = r104;
        this.f3617f = r102;
        this.f3618g = r105;
    }
}

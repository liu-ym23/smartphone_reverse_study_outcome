package com.bytedance.android.live.liveinteract.videotalk.quickinteract;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.l;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.livesdkapi.message.Text;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes46.dex */
public final class QuickInteractTask {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f79477n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f79478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f79479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f79480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f79481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f79482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f79483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f79484g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Source f79485h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f79486i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Text f79487j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f79488k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer f79489l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final l f79490m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/QuickInteractTask$Source;", "", "Native", "Dynamic", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Source extends Enum<Source> {
        public static final Source Dynamic = null;
        public static final Source Native = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Source[] f79491a = null;

        static {
            Source r100 = new Source("Native", 0);
            Native = r100;
            Source r101 = new Source("Dynamic", 1);
            Dynamic = r101;
            f79491a = new Source[]{r100, r101};
        }

        public static Source valueOf(String r100) {
            return (Source) r27.a.a(Source.class, r100);
        }

        public static Source[] values() {
            return (Source[]) f79491a.clone();
        }

        public Source(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        @JvmStatic
        public static QuickInteractTask a(String r100, l r101) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_SCORE);
            Intrinsics.checkNotNullParameter(r101, "quickInteract");
            return new QuickInteractTask(je0.d.b0(), ThemedCompetitionContext.Companion.a(r100), 4, r101);
        }
    }

    static {
    }

    public QuickInteractTask() {
        this(null, null, 0, null, null, null, 0, null, false, null, null, null, null, 8191);
    }

    public final String toString() {
        return "score: " + this.f79479b + ", receive from: " + this.f79478a + ", duration: " + this.f79480c + ", send from " + this.f79481d + ", content: " + this.f79483f + ", type = " + this.f79484g;
    }

    public final int getType() {
        return this.f79484g;
    }

    public /* synthetic */ QuickInteractTask(String r100, String r101, int r102, l r110) {
        this(r100, r101, r102, r110, Source.Native);
    }

    public QuickInteractTask(String r110, String r111, int r112, l r210, Source r211) {
        Intrinsics.checkNotNullParameter(r110, "usedID");
        Intrinsics.checkNotNullParameter(r111, com.bytedance.android.ec.core.event.a.KEY_SCORE);
        Intrinsics.checkNotNullParameter(r211, "source");
        if (r210 == null) goto L5;
        long r100 = r210.getInteractCarouselDuration();
    L7:
        if (r210 == null) goto L12;
        IBaseUser r101 = r210.getSendGiftUser();
        if (r101 == null) goto L12;
        String r102 = r101.getIdString();
        if (r102 == null) goto L12;
    L14:
        if (r210 == null) goto L18;
        IBaseUser r103 = r210.getSendGiftUser();
        if (r103 == null) goto L18;
        k r104 = r103.getAvatarThumbKt();
    L19:
        if (r210 == null) goto L22;
        CharSequence r105 = r210.getInteractContent();
        if (r105 == null) goto L22;
    L24:
        if (r210 == null) goto L26;
        Text r113 = r210.getText();
    L27:
        if (r210 == null) goto L29;
        String r114 = r210.getSchema();
    L30:
        if (r210 == null) goto L32;
        Integer r115 = Integer.valueOf(r210.getInteractType());
    L33:
        this(r110, r111, r100, r102, r104, r105, r112, r211, false, r113, r114, r115, r210, 256);
        return;
    L32:
        r115 = null;
        goto L33
    L29:
        r114 = null;
        goto L30
    L26:
        r113 = null;
    L22:
        r105 = "";
    L18:
        r104 = null;
    L12:
        r102 = "";
        goto L14
    L5:
        r100 = 0;
        goto L7
    }

    public QuickInteractTask(String r110, String r111, long r112, String r210, k r211, CharSequence r212, int r213, Source r214, boolean r215, Text r216, String r217, Integer r218, l r310, int r311) {
        String r100 = "";
        if ((r311 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r311 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r311 & 4) == 0) goto L13;
        long r103 = 0;
    L15:
        if ((r311 & 8) != 0) goto L18;
        r100 = r210;
    L18:
        l r104 = null;
        if ((r311 & 16) == 0) goto L21;
        k r105 = null;
    L23:
        if ((r311 & 32) == 0) goto L25;
        CharSequence r106 = "感谢TA";
    L26:
        boolean r113 = false;
        if ((r311 & 64) == 0) goto L29;
        int r114 = 0;
    L31:
        if ((r311 & 128) == 0) goto L33;
        Source r115 = Source.Native;
    L35:
        if ((r311 & 256) != 0) goto L39;
        r113 = r215;
    L39:
        if ((r311 & 512) == 0) goto L41;
        Text r116 = null;
    L43:
        if ((r311 & 1024) == 0) goto L45;
        String r117 = null;
    L47:
        if ((r311 & 2048) == 0) goto L49;
        Integer r118 = -1;
    L51:
        if ((r311 & 4096) != 0) goto L54;
        r104 = r310;
    L54:
        Intrinsics.checkNotNullParameter(r101, "receiveGiftUserID");
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_SCORE);
        Intrinsics.checkNotNullParameter(r100, "sendGiftUserID");
        Intrinsics.checkNotNullParameter(r106, "quickInteractContent");
        Intrinsics.checkNotNullParameter(r115, "source");
        this.f79478a = r101;
        this.f79479b = r102;
        this.f79480c = r103;
        this.f79481d = r100;
        this.f79482e = r105;
        this.f79483f = r106;
        this.f79484g = r114;
        this.f79485h = r115;
        this.f79486i = r113;
        this.f79487j = r116;
        this.f79488k = r117;
        this.f79489l = r118;
        this.f79490m = r104;
        return;
    L49:
        r118 = r218;
        goto L51
    L45:
        r117 = r217;
        goto L47
    L41:
        r116 = r216;
        goto L43
    L33:
        r115 = r214;
        goto L35
    L29:
        r114 = r213;
        goto L31
    L25:
        r106 = r212;
        goto L26
    L21:
        r105 = r211;
        goto L23
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}

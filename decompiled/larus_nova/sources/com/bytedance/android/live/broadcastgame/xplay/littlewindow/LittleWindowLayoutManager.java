package com.bytedance.android.live.broadcastgame.xplay.littlewindow;

import android.content.Context;
import android.graphics.Rect;
import com.bytedance.android.live.broadcastgame.api.xplay.LittleWindowPos;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes45.dex */
public final class LittleWindowLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<LayoutMode, d> f62207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f62208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f62209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f62210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f62211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f62212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f62213g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f62214h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/littlewindow/LittleWindowLayoutManager$LayoutMode;", "", "LargeSize", "SmallSize", "CustomSize", "DragIndicator", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LayoutMode extends Enum<LayoutMode> {
        public static final LayoutMode CustomSize = null;
        public static final LayoutMode DragIndicator = null;
        public static final LayoutMode LargeSize = null;
        public static final LayoutMode SmallSize = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LayoutMode[] f62215a = null;

        static {
            LayoutMode r100 = new LayoutMode("LargeSize", 0);
            LargeSize = r100;
            LayoutMode r101 = new LayoutMode("SmallSize", 1);
            SmallSize = r101;
            LayoutMode r102 = new LayoutMode("CustomSize", 2);
            CustomSize = r102;
            LayoutMode r103 = new LayoutMode("DragIndicator", 3);
            DragIndicator = r103;
            f62215a = new LayoutMode[]{r100, r101, r102, r103};
        }

        public static LayoutMode valueOf(String r100) {
            return (LayoutMode) r27.a.a(LayoutMode.class, r100);
        }

        public static LayoutMode[] values() {
            return (LayoutMode[]) f62215a.clone();
        }

        public LayoutMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static abstract class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f62216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f62217b;

        public abstract int b();

        public abstract com.bytedance.android.live.broadcastgame.xplay.j c();

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f62217b = r100;
            this.f62216a = d(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
        }

        public final float d(int r100) {
            return fm3.e.a(this.f62217b, r100);
        }

        @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.LittleWindowLayoutManager.d
        public final Rect a(int r100, int r101, Rect r102, LittleWindowPos r110, com.bytedance.android.live.broadcastgame.api.xplay.c r111) {
            Intrinsics.checkNotNullParameter(r102, "safeArea");
            Intrinsics.checkNotNullParameter(r110, "position");
            float r103 = r100 / this.f62216a;
            if (r110 != LittleWindowPos.CUSTOM) goto L5;
            com.bytedance.android.live.broadcastgame.xplay.j r104 = new com.bytedance.android.live.broadcastgame.xplay.j(c().f62186a, c().f62187b);
        L6:
            int r105 = MathKt.roundToInt(d(b()) * r103);
            int r106 = MathKt.roundToInt(d(r102.left) * r103);
            int r107 = MathKt.roundToInt(d(r102.right) * r103);
            int r108 = MathKt.roundToInt(d(r102.bottom) * r103);
            int r112 = com.bytedance.android.live.broadcastgame.xplay.littlewindow.f.f62261a[r110.ordinal()];
            if (r112 == 1) goto L22;
            if (r112 == 2) goto L26;
            if (r112 == 3) goto L25;
            if (r112 == 4) goto L24;
            if (r112 != 5) goto L17;
            Intrinsics.checkNotNullParameter(r104, "$this$makeCustomRect");
            Rect r109 = new Rect();
            int r113 = r111.f59478b;
            double r114 = ((double) (r101 - r113)) / 2.0d;
            double r115 = ((double) (r100 - r111.f59477a)) / 2.0d;
            r109.top = MathKt.roundToInt(((double) (r113 * r111.f59480d)) + r114);
            r109.left = MathKt.roundToInt(((double) (r111.f59477a * r111.f59479c)) + r115);
            r109.right = MathKt.roundToInt((r115 + ((double) (r111.f59477a * r111.f59479c))) + ((double) r104.f62186a));
            r109.bottom = MathKt.roundToInt((r114 + ((double) (r111.f59478b * r111.f59480d))) + ((double) r104.f62187b));
            return r109;
        L17:
            throw new NoWhenBranchMatchedException();
        L24:
            return com.bytedance.android.live.broadcastgame.xplay.b.a(r104, r100 - r107, r101 - r108, 12);
        L25:
            return com.bytedance.android.live.broadcastgame.xplay.b.a(r104, r100 - r107, r105, 6);
        L26:
            return com.bytedance.android.live.broadcastgame.xplay.b.a(r104, r106, r105, 3);
        L22:
            return com.bytedance.android.live.broadcastgame.xplay.b.a(r104, r100 / 2, 0, 7);
        L5:
            r104 = new com.bytedance.android.live.broadcastgame.xplay.j(MathKt.roundToInt(d(c().f62186a) * r103), MathKt.roundToInt(d(c().f62187b) * r103));
            goto L6
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bytedance.android.live.broadcastgame.xplay.j f62218c;

        @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.LittleWindowLayoutManager.a
        public final int b() {
            return 0;
        }

        @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.LittleWindowLayoutManager.a
        public final com.bytedance.android.live.broadcastgame.xplay.j c() {
            return this.f62218c;
        }

        public b(Context r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.f62218c = new com.bytedance.android.live.broadcastgame.xplay.j(r101, r102);
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bytedance.android.live.broadcastgame.xplay.j f62219c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f62220d;

        @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.LittleWindowLayoutManager.a
        public final int b() {
            return this.f62220d;
        }

        @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.LittleWindowLayoutManager.a
        public final com.bytedance.android.live.broadcastgame.xplay.j c() {
            return this.f62219c;
        }

        public c(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.f62219c = new com.bytedance.android.live.broadcastgame.xplay.j(105, 150);
            this.f62220d = 124;
        }
    }

    public interface d {
        Rect a(int r100, int r101, Rect r102, LittleWindowPos r103, com.bytedance.android.live.broadcastgame.api.xplay.c r104);
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bytedance.android.live.broadcastgame.xplay.j f62221c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f62222d;

        @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.LittleWindowLayoutManager.a
        public final int b() {
            return this.f62222d;
        }

        @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.LittleWindowLayoutManager.a
        public final com.bytedance.android.live.broadcastgame.xplay.j c() {
            return this.f62221c;
        }

        public e(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.f62221c = new com.bytedance.android.live.broadcastgame.xplay.j(90, 130);
            this.f62222d = 124;
        }
    }

    public static final class f extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bytedance.android.live.broadcastgame.xplay.j f62223c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f62224d;

        @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.LittleWindowLayoutManager.a
        public final int b() {
            return this.f62224d;
        }

        @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.LittleWindowLayoutManager.a
        public final com.bytedance.android.live.broadcastgame.xplay.j c() {
            return this.f62223c;
        }

        public f(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.f62223c = new com.bytedance.android.live.broadcastgame.xplay.j(90, 82);
            this.f62224d = 148;
        }
    }

    public final Context getContext() {
        return this.f62214h;
    }

    public LittleWindowLayoutManager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f62214h = r100;
        HashMap<LayoutMode, d> r101 = new HashMap();
        this.f62207a = r101;
        this.f62213g = new Rect();
        r101.put(LayoutMode.LargeSize, new e(r100));
        r101.put(LayoutMode.SmallSize, new f(r100));
        r101.put(LayoutMode.DragIndicator, new c(r100));
    }

    public final Rect a(LayoutMode r100, LittleWindowPos r101, float r110, float r111) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, "position");
        d r102 = this.f62207a.get(r100);
        if (r102 == null) goto L7;
        return r102.a(this.f62208b, this.f62209c, this.f62213g, r101, new com.bytedance.android.live.broadcastgame.api.xplay.c(this.f62210d, this.f62211e, r110, r111));
    L7:
        throw new IllegalArgumentException("no strategy for mode " + r100);
    }
}

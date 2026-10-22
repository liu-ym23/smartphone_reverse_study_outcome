package com.bytedance.android.live.effect.api;

import android.view.SurfaceView;
import com.bytedance.android.live.effect.beauty.presets.LiveBeautyPresetsFragment$waitForRestoreComplete$restoreListener$1;
import com.bytedance.android.live.effect.common.LiveCommonStickerUIViewModel;
import com.bytedance.android.livesdk.widget.BroadcastKtvEffectMusicWidget;
import com.bytedance.android.livesdk.widget.u2;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public interface ILiveEffectComposerManager {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager$EffectInstanceType;", "", "DEFAULT", "SPECIAL", "RENDER_FILTER", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EffectInstanceType extends Enum<EffectInstanceType> {
        public static final EffectInstanceType DEFAULT = null;
        public static final EffectInstanceType RENDER_FILTER = null;
        public static final EffectInstanceType SPECIAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EffectInstanceType[] f66718a = null;

        static {
            EffectInstanceType r100 = new EffectInstanceType("DEFAULT", 0);
            DEFAULT = r100;
            EffectInstanceType r101 = new EffectInstanceType("SPECIAL", 1);
            SPECIAL = r101;
            EffectInstanceType r102 = new EffectInstanceType("RENDER_FILTER", 2);
            RENDER_FILTER = r102;
            f66718a = new EffectInstanceType[]{r100, r101, r102};
        }

        public static EffectInstanceType valueOf(String r100) {
            return (EffectInstanceType) r27.a.a(EffectInstanceType.class, r100);
        }

        public static EffectInstanceType[] values() {
            return (EffectInstanceType[]) f66718a.clone();
        }

        public EffectInstanceType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a();
    }

    public interface b {
        void F(String r100, Sticker r101, String r102, float r103);
    }

    public interface c extends b {

        public static final class a {
            public static void a(c r100, String r101, Sticker r102, String r103, float r110) {
                r100.u2(r101, r102, r103, r110, null);
            }
        }

        void u2(String r100, Sticker r101, String r102, float r103, HashMap<String, String> r104);
    }

    public interface d {
        void a(String r100, Sticker r101);

        void b(boolean r100, String r101, Sticker r102);
    }

    public interface e extends d, k {
        void d(boolean r100, String r101, Sticker r102, HashMap<String, String> r103);

        void e(String r100, Sticker r101);
    }

    public static final class f {
        public static /* synthetic */ void b(ILiveEffectComposerManager r100, String r101, String r102) {
            r100.k(r101, r102, null, true);
        }

        public static /* synthetic */ void e(ILiveEffectComposerManager r100, String r101, Sticker r102, String r103, float r110) {
            r100.J(r101, r102, r103, r110, EffectInstanceType.DEFAULT);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(ILiveEffectComposerManager r100, String r110, Sticker r111, String r112, HashMap r113, com.bytedance.android.live.effect.base.e r114, int r115) {
            EffectInstanceType r101 = null;
            if ((r115 & 8) == 0) goto L5;
            HashMap r102 = null;
        L7:
            if ((r115 & 16) == 0) goto L9;
            com.bytedance.android.live.effect.base.e r103 = null;
        L11:
            if ((r115 & 32) == 0) goto L13;
            r101 = EffectInstanceType.DEFAULT;
        L13:
            r100.I(r110, r111, r112, r102, r103, r101);
            return;
        L9:
            r103 = r114;
            goto L11
        L5:
            r102 = r113;
            goto L7
        }

        public static /* synthetic */ void c(ILiveEffectComposerManager r100, String r101, Sticker r110, Sticker r111, String r112, HashMap r113, com.bytedance.android.live.effect.base.e r114) {
            r100.Q(r101, r110, r111, r112, r113, r114, EffectInstanceType.DEFAULT);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void d(ILiveEffectComposerManager r100, String r110, Sticker r111, String r112, float r113, HashMap r114, int r115) {
            if ((r115 & 16) == 0) goto L5;
            EffectInstanceType r101 = EffectInstanceType.DEFAULT;
        L7:
            if ((r115 & 32) == 0) goto L9;
            HashMap r102 = null;
        L10:
            r100.C(r110, r111, r112, r113, r101, r102);
            return;
        L9:
            r102 = r114;
            goto L10
        L5:
            r101 = null;
            goto L7
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f66719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f66720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f66721c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f66722d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof g) == false) goto L14;
            g r101 = (g) r100;
            if (this.f66719a == r101.f66719a) goto L8;
            return false;
        L8:
            if (this.f66720b == r101.f66720b) goto L10;
            return false;
        L10:
            if (this.f66721c == r101.f66721c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f66722d, r101.f66722d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            int r100 = ((((this.f66719a * 31) + this.f66720b) * 31) + this.f66721c) * 31;
            String r101 = this.f66722d;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 + r102;
        L5:
            r102 = 0;
            goto L7
        }

        public final String toString() {
            return "EffectMsg(messageType=" + this.f66719a + ", arg1=" + this.f66720b + ", arg2=" + this.f66721c + ", arg3=" + this.f66722d + ")";
        }

        public g(int r100, int r101, int r102, String r103) {
            this.f66719a = r100;
            this.f66720b = r101;
            this.f66721c = r102;
            this.f66722d = r103;
        }
    }

    public interface h {
        void a(List<String> r100);
    }

    public interface i {
        void a(boolean r100, String r101, List<Sticker> r102);
    }

    public interface j {
        void a(long r100, Map<String, Long> r101);
    }

    public interface k {
        void c(List<com.bytedance.android.live.effect.composer.n> r100, Map<String, ? extends List<Sticker>> r101);
    }

    void A(LiveBeautyPresetsFragment$waitForRestoreComplete$restoreListener$1 r100);

    boolean B(Sticker r100);

    void C(String r100, Sticker r101, String r102, float r103, EffectInstanceType r104, HashMap<String, String> r105);

    void D();

    boolean E(Sticker r100);

    void F(boolean r100);

    Float G(String r100, String r101);

    Pair<Boolean, Boolean> H();

    void I(String r100, Sticker r101, String r102, HashMap<String, String> r103, com.bytedance.android.live.effect.base.e r104, EffectInstanceType r105);

    void J(String r100, Sticker r101, String r102, float r103, EffectInstanceType r104);

    void K(c r100);

    void L(String r100);

    void M();

    Map<Long, String> N(String r100);

    void O(String r100, Sticker r101, String r102);

    List<com.bytedance.android.live.effect.composer.n> P();

    void Q(String r100, Sticker r101, Sticker r102, String r103, HashMap<String, String> r104, com.bytedance.android.live.effect.base.e r105, EffectInstanceType r106);

    List<com.bytedance.android.live.effect.composer.n> R();

    void S(String r100, Sticker r101, Sticker r102);

    void T(String r100, boolean r101);

    int U(String r100);

    void V(d r100);

    boolean W();

    void a(String r100, Sticker r101, String r102);

    void b(String r100, String r101);

    Map<String, Map<String, Sticker>> c();

    void d(String r100, List<? extends Effect> r101, Function1<? super Effect, Boolean> r102);

    List<com.bytedance.android.live.effect.composer.n> e();

    void f(LiveBeautyPresetsFragment$waitForRestoreComplete$restoreListener$1 r100);

    void g(d r100);

    void h(String r100, LiveCommonStickerUIViewModel.b r101);

    void i(SurfaceView r100);

    void j(String r100, h r101);

    void k(String r100, String r101, HashMap<String, String> r102, boolean r103);

    void l(c r100);

    void m(String r100, LiveCommonStickerUIViewModel.b r101);

    void n(String r100, String r101);

    List<Sticker> o(String r100);

    boolean p();

    void q();

    void r(BroadcastKtvEffectMusicWidget.h r100);

    Disposable s(String r100, String r101, u2.a r102);

    void t(String r100, String r101, HashMap<String, String> r102);

    void u();

    void v(g r100, EffectInstanceType r101, String r102);

    void w(String r100, String r101);

    void x(String r100);

    void y(com.bytedance.android.live.effect.sticker.presenter.q.a r100);

    int z(String[] r100, int[] r101, String r102);
}

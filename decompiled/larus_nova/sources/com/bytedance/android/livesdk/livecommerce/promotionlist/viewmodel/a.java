package com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class a implements com.bytedance.android.ec.core.arch.event.d {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C2330a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JsonObject f151300a;

        public C2330a(JsonObject r100) {
            this.f151300a = r100;
        }
    }

    public static final class a0 extends a {
        public a0() {
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f151301a;

        public b(float r100) {
            this.f151301a = r100;
        }
    }

    public static final class b0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ECLottieAnimationView f151302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f151303b;

        public b0(ECLottieAnimationView r100, boolean r101) {
            this.f151302a = r100;
            this.f151303b = r101;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f151304a;

        public c(int r100) {
            this.f151304a = r100;
        }
    }

    public static final class c0 extends a {
        public c0() {
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f151305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f151306b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f151307c;

        public d(String r100, boolean r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "component");
            this.f151305a = r100;
            this.f151306b = r101;
            this.f151307c = r102;
        }
    }

    public static final class d0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PromotionCategory f151308a;

        public d0(PromotionCategory r100) {
            this.f151308a = r100;
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PromotionCategory f151309a;

        public e(PromotionCategory r100) {
            Intrinsics.checkNotNullParameter(r100, "toCategory");
            this.f151309a = r100;
        }
    }

    public static final class e0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e0 f151310a = null;

        static {
            f151310a = new e0();
        }

        public e0() {
        }
    }

    public static final class f extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f151311a = null;

        static {
            f151311a = new f();
        }

        public f() {
        }
    }

    public static final class f0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f151312a;

        public f0() {
            this.f151312a = false;
        }
    }

    public static final class g extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f151313a;

        public g() {
            this(false);
        }

        public g(boolean r100) {
            this.f151313a = r100;
        }
    }

    public static final class g0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi2.e0 f151314a;

        public g0(xi2.e0 r100) {
            this.f151314a = r100;
        }
    }

    public static final class h extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f151315a;

        public h(boolean r100) {
            this.f151315a = r100;
        }
    }

    public static final class h0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.a f151316a;

        public h0(com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.a r100) {
            Intrinsics.checkNotNullParameter(r100, "cardRegionData");
            this.f151316a = r100;
        }
    }

    public static final class i extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f151317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f151318b;

        public i(int r100) {
            this.f151317a = 0;
            this.f151318b = r100;
        }
    }

    public static final class i0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f151319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f151320b;

        public i0(String r100, List<String> r101) {
            this.f151319a = r100;
            this.f151320b = r101;
        }
    }

    public static final class j extends a {
    }

    public static final class k extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final si2.m f151321a;

        public k(si2.m r100) {
            Intrinsics.checkNotNullParameter(r100, "content");
            this.f151321a = r100;
        }
    }

    public static final class l extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PageListLoadStatus f151322a;

        public l(PageListLoadStatus r100) {
            Intrinsics.checkNotNullParameter(r100, "status");
            this.f151322a = r100;
        }
    }

    public static final class m extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PageListLoadStatus f151323a;

        public m(PageListLoadStatus r100) {
            Intrinsics.checkNotNullParameter(r100, "status");
            this.f151323a = r100;
        }
    }

    public static final class n extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f151324a = null;

        static {
            f151324a = new n();
        }

        public n() {
        }
    }

    public static final class o extends a {
        public o() {
        }
    }

    public static final class p extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f151325a;

        public p(boolean r100) {
            this.f151325a = r100;
        }
    }

    public static final class q extends a {
        public q() {
        }
    }

    public static final class r extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f151326a = null;

        static {
            f151326a = new r();
        }

        public r() {
        }
    }

    public static final class s extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f151327a;

        public s(boolean r100) {
            this.f151327a = r100;
        }
    }

    public static final class t extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<cf.x> f151328a;

        public t(List<cf.x> r100) {
            Intrinsics.checkNotNullParameter(r100, "list");
            this.f151328a = r100;
        }
    }

    public static final class u extends a {
        public u() {
        }
    }

    public static final class v extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final we3.d f151329a;

        public v(we3.d r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f151329a = r100;
        }
    }

    public static final class w extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final w f151330a = null;

        static {
            f151330a = new w();
        }

        public w() {
        }
    }

    public static final class x extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final x f151331a = null;

        static {
            f151331a = new x();
        }

        public x() {
        }
    }

    public static final class y extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ml.b f151332a;

        public y(ml.b r100) {
            Intrinsics.checkNotNullParameter(r100, "selectRoom");
            this.f151332a = r100;
        }
    }

    public static final class z extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<View> f151333a;

        /* JADX WARN: Multi-variable type inference failed */
        public z(Function0<? extends View> r100) {
            Intrinsics.checkNotNullParameter(r100, "getView");
            this.f151333a = r100;
        }
    }

    public a() {
    }
}

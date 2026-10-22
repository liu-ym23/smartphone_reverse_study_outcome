package com.bytedance.android.livesdk.gamesticker.hok;

import com.bytedance.android.livesdk.chatroom.model.b2;
import com.bytedance.android.livesdk.chatroom.model.c3;
import com.bytedance.android.livesdk.chatroom.model.j0;
import com.bytedance.android.livesdk.chatroom.model.k2;
import com.bytedance.android.livesdk.chatroom.model.n0;
import com.bytedance.android.livesdk.chatroom.model.o;
import com.bytedance.android.livesdk.chatroom.model.p;
import com.bytedance.android.livesdk.gamesticker.hok.machine.BattleMachine;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BattleMachine f125593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f125594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f125595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f125596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f125597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f125598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f125599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c3 f125600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b2 f125601i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public k2 f125602j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public j0 f125603k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public o f125604l;

    public final void e() {
        c3 r100 = this.f125600h;
        if (r100 == null) goto L8;
        j0 r101 = this.f125603k;
        if (r101 == null) goto L9;
        this.f125593a.a(new com.bytedance.android.livesdk.gamesticker.hok.machine.a.d(r100, r101));
        return;
    L9:
        return;
    }

    public d(HokGameStickerView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f125593a = new BattleMachine(r100);
    }

    public static final void a(d r100) {
        c3 r101 = r100.f125600h;
        if (r101 == null) goto L8;
        k2 r102 = r100.f125602j;
        if (r102 == null) goto L9;
        r100.f125593a.a(new com.bytedance.android.livesdk.gamesticker.hok.machine.a.e(r101, r102));
        return;
    L9:
        return;
    }

    public static j0 b(o r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.a() == null) goto L17;
        j0 r101 = r100.a();
        if (r101 == null) goto L9;
        long r102 = r101.a();
    L11:
        if (r102 > 0) goto L13;
        return null;
    L13:
        return r100.a();
    L9:
        r102 = 0;
        goto L11
    L17:
        return null;
    }

    public static k2 c(o r100) {
        if (r100 != null) goto L5;
    L29:
        return null;
    L5:
        if (r100.b() == null) goto L29;
        k2 r101 = r100.b();
        if (r101 == null) goto L10;
        String r102 = r101.b();
    L11:
        boolean r103 = true;
        if (r102 != null) goto L14;
    L17:
        boolean r104 = true;
    L18:
        if (r104 == true) goto L29;
        if (r101 == null) goto L21;
        String r105 = r101.a();
    L22:
        if (r105 != null) goto L24;
    L27:
        if (r103 == true) goto L29;
        return r101;
    L24:
        if (r105.length() == 0) goto L27;
        r103 = false;
        goto L27
    L21:
        r105 = null;
        goto L22
    L14:
        if (r102.length() == 0) goto L17;
        r104 = false;
        goto L18
    L10:
        r102 = null;
        goto L11
    }

    public final void d(n0 r110) {
        Intrinsics.checkNotNullParameter(r110, "info");
        c3 r100 = r110.d();
        boolean r101 = false;
        Integer r102 = null;
        if (r100 == null) goto L54;
        String r103 = r100.a();
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == true) goto L21;
        String r105 = r100.b();
        if (r105 != null) goto L16;
    L19:
        boolean r106 = true;
    L20:
        if (r106 == true) goto L21;
    L55:
        this.f125600h = r100;
        b2 r107 = r110.c();
        if (r107 == null) goto L73;
        String r108 = r107.c();
        if (r108 != null) goto L61;
    L64:
        boolean r109 = true;
    L65:
        if (r109 == false) goto L74;
        String r111 = r107.a();
        if (r111 != null) goto L69;
    L70:
        r101 = true;
    L71:
        if (r101 == true) goto L73;
    L69:
        if (r111.length() != 0) goto L71;
    L74:
        this.f125601i = r107;
        this.f125603k = b(r110.a());
        this.f125602j = c(r110.a());
        o r112 = r110.a();
        if (b(r112) == null) goto L77;
    L80:
        this.f125604l = r112;
        p r113 = r110.b();
        if (r113 == null) goto L92;
        this.f125597e = r113.c();
        this.f125598f = r113.a();
        this.f125599g = r113.b();
        r113.toString();
        if (this.f125597e > 0) goto L87;
        this.f125597e = 5;
    L87:
        if (this.f125598f > 0) goto L90;
        this.f125598f = 10;
    L90:
        if (this.f125599g > 0) goto L92;
        this.f125599g = 5;
    L92:
        c3 r114 = this.f125600h;
        if (r114 != null) goto L95;
    L113:
        long r115 = 10;
        long r116 = 5;
        if (r114 != null) goto L116;
    L148:
        if (r114 != null) goto L150;
    L170:
        if (r114 != null) goto L172;
        return;
    L172:
        if (this.f125601i != null) goto L174;
        return;
    L174:
        if (this.f125603k != null) goto L176;
        return;
    L176:
        if (this.f125602j == null) goto L238;
        Objects.toString(this.f125593a.f125607a.b());
        Disposable r117 = this.f125594b;
        if (r117 == null) goto L180;
        r117.dispose();
    L180:
        this.f125594b = null;
        if (Intrinsics.areEqual(this.f125593a.f125607a.b(), com.bytedance.android.livesdk.gamesticker.hok.machine.c.b.f125633a) == true) goto L183;
    L191:
        this.f125593a.a(com.bytedance.android.livesdk.gamesticker.hok.machine.a.C2019a.f125609a);
        b2 r118 = this.f125601i;
        if (r118 == null) goto L194;
        Integer r119 = r118.b();
    L195:
        if (r119 == null) goto L216;
        b2 r120 = this.f125601i;
        if (r120 == null) goto L199;
        r102 = r120.b();
    L199:
        if (r102 != null) goto L202;
    L204:
        c3 r121 = this.f125600h;
        if (r121 == null) goto L209;
        b2 r122 = this.f125601i;
        if (r122 == null) goto L209;
        this.f125593a.a(new com.bytedance.android.livesdk.gamesticker.hok.machine.a.f(r121, r122));
    L209:
        int r123 = this.f125597e;
        if (r123 <= 0) goto L213;
        r116 = r123;
    L213:
        Disposable r124 = Observable.timer(r116, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(new HokGameViewController$enterContinueBattleState$4(this)));
        if (r124 == null) goto L242;
        this.f125596d = r124;
        return;
    L242:
        return;
    L202:
        if (r102.intValue() != 0) goto L204;
    L216:
        e();
        int r125 = this.f125598f;
        if (r125 <= 0) goto L220;
        r115 = r125;
    L220:
        long r126 = r115;
        int r127 = this.f125599g;
        if (r127 <= 0) goto L224;
        r116 = r127;
    L224:
        Disposable r128 = f(r126, r116, new HokGameViewController$enterContinueBattleState$1(this), new HokGameViewController$enterContinueBattleState$2(this));
        if (r128 == null) goto L244;
        this.f125595c = r128;
        return;
    L244:
        return;
    L194:
        r119 = null;
        goto L195
    L183:
        if (this.f125595c == null) goto L185;
    L186:
        c3 r129 = this.f125600h;
        if (r129 == null) goto L239;
        o r130 = this.f125604l;
        if (r130 == null) goto L240;
        this.f125593a.a(new com.bytedance.android.livesdk.gamesticker.hok.machine.a.i(r129, r130));
        return;
    L240:
        return;
    L239:
        return;
    L185:
        if (this.f125596d == null) goto L191;
    L238:
        return;
    L150:
        if (this.f125601i == null) goto L170;
        if (this.f125603k != null) goto L170;
        if (this.f125602j != null) goto L170;
        Disposable r131 = this.f125594b;
        if (r131 == null) goto L158;
        r131.dispose();
    L158:
        this.f125594b = null;
        Disposable r132 = this.f125596d;
        if (r132 == null) goto L161;
        r132.dispose();
    L161:
        this.f125596d = null;
        Disposable r133 = this.f125595c;
        if (r133 == null) goto L164;
        r133.dispose();
    L164:
        this.f125595c = null;
        this.f125593a.a(com.bytedance.android.livesdk.gamesticker.hok.machine.a.b.f125610a);
        c3 r134 = this.f125600h;
        if (r134 == null) goto L233;
        b2 r135 = this.f125601i;
        if (r135 == null) goto L234;
        this.f125593a.a(new com.bytedance.android.livesdk.gamesticker.hok.machine.a.f(r134, r135));
        return;
    L234:
        return;
    L233:
        return;
    L116:
        if (this.f125601i != null) goto L148;
        if (this.f125603k == null) goto L148;
        if (this.f125602j == null) goto L148;
        Disposable r136 = this.f125596d;
        if (r136 == null) goto L124;
        r136.dispose();
    L124:
        this.f125596d = null;
        Disposable r137 = this.f125595c;
        if (r137 == null) goto L127;
        r137.dispose();
    L127:
        this.f125595c = null;
        if (Intrinsics.areEqual(this.f125593a.f125607a.b(), com.bytedance.android.livesdk.gamesticker.hok.machine.c.C2021c.f125634a) == true) goto L130;
    L136:
        this.f125593a.a(com.bytedance.android.livesdk.gamesticker.hok.machine.a.h.f125619a);
        e();
        int r138 = this.f125598f;
        if (r138 <= 0) goto L140;
        r115 = r138;
    L140:
        long r139 = r115;
        int r140 = this.f125599g;
        if (r140 <= 0) goto L144;
        r116 = r140;
    L144:
        Disposable r141 = f(r139, r116, new HokGameViewController$enterInFirstBattleState$1(this), new HokGameViewController$enterInFirstBattleState$2(this));
        if (r141 == null) goto L232;
        this.f125594b = r141;
        return;
    L232:
        return;
    L130:
        if (this.f125594b == null) goto L136;
        c3 r142 = this.f125600h;
        if (r142 == null) goto L229;
        o r143 = this.f125604l;
        if (r143 == null) goto L230;
        this.f125593a.a(new com.bytedance.android.livesdk.gamesticker.hok.machine.a.i(r142, r143));
        return;
    L230:
        return;
    L229:
        return;
    L95:
        if (this.f125601i != null) goto L113;
        if (this.f125603k != null) goto L113;
        if (this.f125602j != null) goto L113;
        Disposable r144 = this.f125594b;
        if (r144 == null) goto L103;
        r144.dispose();
    L103:
        this.f125594b = null;
        Disposable r145 = this.f125596d;
        if (r145 == null) goto L106;
        r145.dispose();
    L106:
        this.f125596d = null;
        Disposable r146 = this.f125595c;
        if (r146 == null) goto L109;
        r146.dispose();
    L109:
        this.f125595c = null;
        this.f125593a.a(com.bytedance.android.livesdk.gamesticker.hok.machine.a.c.f125611a);
        c3 r147 = this.f125600h;
        if (r147 == null) goto L228;
        this.f125593a.a(new com.bytedance.android.livesdk.gamesticker.hok.machine.a.g(r147));
        return;
    L228:
        return;
    L77:
        if (c(r112) != null) goto L80;
        r112 = null;
        goto L80
    L61:
        if (r108.length() == 0) goto L64;
        r109 = false;
    L73:
        r107 = null;
        goto L74
    L16:
        if (r105.length() == 0) goto L19;
        r106 = false;
    L21:
        String r148 = r100.e();
        if (r148 != null) goto L24;
    L27:
        boolean r149 = true;
    L28:
        if (r149 == true) goto L37;
        String r150 = r100.f();
        if (r150 != null) goto L32;
    L35:
        boolean r151 = true;
    L36:
        if (r151 == false) goto L55;
    L32:
        if (r150.length() == 0) goto L35;
        r151 = false;
    L37:
        String r152 = r100.d();
        if (r152 != null) goto L40;
    L43:
        boolean r153 = true;
    L44:
        if (r153 == true) goto L54;
        String r154 = r100.c();
        if (r154 != null) goto L48;
    L51:
        boolean r155 = true;
    L52:
        if (r155 == true) goto L54;
    L48:
        if (r154.length() == 0) goto L51;
        r155 = false;
        goto L52
    L40:
        if (r152.length() == 0) goto L43;
        r153 = false;
        goto L44
    L24:
        if (r148.length() == 0) goto L27;
        r149 = false;
        goto L28
    L8:
        if (r103.length() == 0) goto L11;
        r104 = false;
    L54:
        r100 = null;
        goto L55
    }

    public final Disposable f(long r110, long r111, Function0 r210, Function0 r211) {
        return Observable.intervalRange(0, 1 + (r110 + r111), 0, 1, TimeUnit.SECONDS).repeat().filter(new b(r110, r111)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r110, r211, r111, r210));
    }
}

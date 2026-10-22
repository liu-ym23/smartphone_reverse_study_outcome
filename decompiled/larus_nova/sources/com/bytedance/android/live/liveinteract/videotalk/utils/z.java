package com.bytedance.android.live.liveinteract.videotalk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.utils.s0;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.live.livelink.kmp.api.core.mixer.RTCWaterMarkRegion;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f79900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f79901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, String> f79902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Bitmap> f79903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, Bitmap> f79904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bitmap f79905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f79906g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bitmap f79907h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Bitmap f79908i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CompositeDisposable f79909j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ei6.a f79910k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final v f79911l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f79912m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final IRoom f79913n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f79914o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f79915p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final j1 f79916q;

    public final ei6.a a() {
        if (this.f79910k != null) goto L12;
        com.bytedance.android.live.liveinteract.plantform.base.a.f75481g0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.a r100 = com.bytedance.android.live.liveinteract.plantform.base.a.C1183a.a();
        if (r100 == null) goto L9;
        hg6.g r101 = r100.R1();
        if (r101 == null) goto L9;
        ei6.a r102 = r101.V0();
    L10:
        this.f79910k = r102;
    L9:
        r102 = null;
    L12:
        return this.f79910k;
    }

    public final void d() {
        ei6.a r100 = a();
        this.f79910k = r100;
        if (r100 == null) goto L9;
        ti6.d r101 = r100.p();
        if (r101 == null) goto L9;
        ti6.e r102 = r101.f();
        if (r102 == null) goto L9;
        r102.n();
    L9:
        ei6.a r103 = this.f79910k;
        if (r103 == null) goto L17;
        ti6.d r104 = r103.p();
        if (r104 == null) goto L18;
        ti6.e r105 = r104.f();
        if (r105 == null) goto L19;
        r105.o();
        return;
    L19:
        return;
    L18:
        return;
    }

    public final String b(ILinkPlayerInfoBridge r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(this.f79914o);
        r101.append('_');
        r101.append(this.f79915p);
        r101.append('_');
        r101.append(r100.getUserPosition());
        return r101.toString();
    }

    public final void e(ILinkPlayerInfoBridge r100, boolean r101) {
        ei6.a r102 = a();
        this.f79910k = r102;
        if (r102 == null) goto L9;
        ti6.d r103 = r102.p();
        if (r103 == null) goto L9;
        ti6.e r104 = r103.f();
        if (r104 == null) goto L9;
        r104.k(b(r100));
    L9:
        if (r101 == false) goto L18;
        ei6.a r105 = this.f79910k;
        if (r105 == null) goto L19;
        ti6.d r106 = r105.p();
        if (r106 == null) goto L20;
        ti6.e r107 = r106.f();
        if (r107 == null) goto L21;
        r107.o();
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    public z(IRoom r100, int r101, j1 r102) {
        Intrinsics.checkNotNullParameter(r100, "room");
        this.f79913n = r100;
        boolean r103 = false;
        this.f79914o = 0;
        this.f79915p = r101;
        this.f79916q = r102;
        this.f79900a = new Paint(1);
        this.f79901b = new Paint();
        this.f79902c = new HashMap();
        this.f79903d = new HashMap();
        this.f79904e = new HashMap();
        this.f79905f = BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_video_talk_empty_mixer);
        this.f79906g = 0.4d;
        this.f79908i = BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_icon_video_silence);
        this.f79909j = new CompositeDisposable();
        v.b r104 = v.f79883b;
        monitor-enter(r104);
    L34:
        th = move-exception;
        throw th;
    L5:
        if (v.f79882a != null) goto L7;
        v.f79882a = new v();     // Catch: Throwable -> L34
    L7:
        v r105 = v.f79882a;     // Catch: Throwable -> L34
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L34
        monitor-exit(r104);
        this.f79911l = r105;
        this.f79912m = true;
        ReadOnlyProperty r106 = vm2.d.U1;
        KProperty<?>[] r107 = vm2.d.f555776a;
        if (((Boolean) r106.getValue(null, r107[148(0x94, float:2.07E-43)])).booleanValue() == false) goto L32;
        r105.getClass();
        if (r101 > 0) goto L39;
        Iterator r108 = ((List) vm2.d.f555784a7.getValue(null, r107[414(0x19e, float:5.8E-43)])).iterator();     // Catch: Exception -> L27
    L23:
        if (r108.hasNext() == false) goto L29;
        String r109 = (String) r108.next();     // Catch: Exception -> L27
        if (String.valueOf(0).equals(r109) == false) goto L23;
    L26:
        boolean r110 = false;
    L30:
        if (r110 == false) goto L32;
        r103 = true;
    L29:
        r110 = true;
    L27:
        e = move-exception;
        ALogger.e("supportAudioMixer", e.toString());
        goto L29
    L39:
        Iterator<String> r111 = vm2.d.f555794b7.iterator();     // Catch: Exception -> L19
    L15:
        if (r111.hasNext() == false) goto L29;
        String r112 = r111.next();     // Catch: Exception -> L19
        if (String.valueOf(r101).equals(r112) == false) goto L15;
    L19:
        e = move-exception;
        ALogger.e("supportAudioMixer", e.toString());
    L32:
        this.f79912m = r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v26, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v2, types: [T, com.bytedance.android.live.liveinteract.videotalk.utils.v$a] */
    public final void f(ILinkPlayerInfoBridge r110, ch0.h r111, ti6.f r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "guestInfo");
        rj0.k.f537953m2.getClass();
        rj0.k r100 = rj0.k.a.a();
        if (r100 == null) goto L5;
        MixStreamType r101 = r100.getMixStreamType();
    L6:
        boolean r102 = true;
        if (r101 == MixStreamType.CLIENT_MIX) goto L14;
        if (r101 == MixStreamType.RTC_CLIENT_MIX) goto L14;
        if (r101 == MixStreamType.SERVER_MIX) goto L14;
    L19:
        boolean r103 = true;
    L21:
        if (r103 == false) goto L24;
        return;
    L24:
        if (this.f79912m == true) goto L26;
        return;
    L26:
        if (r110 == null) goto L30;
        IBaseUser r104 = r110.getUser();
        if (r104 == null) goto L30;
        String r105 = r104.getIdString();
    L32:
        if (Intrinsics.areEqual(r105, this.f79913n.getOwnerUserIdString()) == true) goto L63;
        boolean r106 = TextUtils.isEmpty(r110.getMInteractIdStr());
        if (r110.getLinkType() != 2) goto L37;
    L40:
        boolean r114 = true;
    L41:
        j1 r115 = this.f79916q;
        if (r115 == null) goto L44;
        cg6.a r116 = (cg6.a) r115.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    L45:
        if (r111 == null) goto L53;
        if (r116 == null) goto L53;
        hg6.g r117 = r116.getRtcManager();
        if (r117 == null) goto L53;
        if (r117.A() != true) goto L53;
        boolean r107 = r111.f23735c;
    L59:
        if (r106 == true) goto L64;
        if (r114 == true) goto L64;
        if (r107 == false) goto L63;
    L64:
        if (r102 == false) goto L96;
        if (r112 == null) goto L97;
        Ref.ObjectRef r108 = new Ref.ObjectRef();
        v r109 = this.f79911l;
        int r118 = this.f79914o;
        int r119 = this.f79915p;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r112, EffectConfiguration.KEY_REGION);
        if (r118 == 11) goto L72;
        if (r119 == 2) goto L72;
        float r120 = 0.56f;
    L73:
        if (r118 == 15) goto L77;
        if (r119 == 7) goto L77;
        float r121 = 1.0f;
    L78:
        ?? r122 = new v.a(r120, r121, 0.5f);
        r122.f79884a = (int) (((double) 720.0f) * r112.f546164f);
        r122.f79885b = (int) (((double) 1280.0f) * r112.f546165g);
        r108.element = r122;
        if (TextUtils.isEmpty(r110.getMInteractIdStr()) == false) goto L88;
        v.a r123 = (v.a) r108.element;
        int r124 = r123.f79884a;
        int r125 = r123.f79885b;
        String r126 = "e_" + (r124 - (r124 % 16)) + '_' + (r125 - (r125 % 16));
        Bitmap r127 = this.f79904e.get(r126);
        if (r127 == null) goto L83;
        c(r110, r112, r126, r127, false);
        goto L97
    L83:
        v.a r128 = (v.a) r108.element;
        int r129 = r128.f79884a;
        int r130 = r128.f79885b;
        Bitmap r131 = Bitmap.createBitmap(r129 - (r129 % 16), r130 - (r130 % 16), Bitmap.Config.ARGB_8888);
        Canvas r132 = new Canvas(r131);
        this.f79901b.setColor(ColorProtector.parseColor("#1b0c2b"));
        float r133 = r128.f79887d;
        int r134 = r128.f79884a;
        float r135 = r134 - (r134 % 16);
        int r136 = r128.f79885b;
        r132.drawRect(r133, 0.0f, r135, (r136 - (r136 % 16)) - r128.f79888e, this.f79901b);
        int r137 = r128.f79884a;
        int r138 = r137 - (r137 % 16);
        int r139 = r128.f79885b;
        int r140 = r139 - (r139 % 16);
        if (r138 <= r140) goto L86;
        int r141 = r140;
    L87:
        double r142 = ((double) r141) * this.f79906g;
        double r143 = 2;
        double r144 = (((double) r138) - r142) / r143;
        double r145 = (((double) r140) - r142) / r143;
        r132.drawBitmap(this.f79905f, null, new Rect((int) r144, (int) r145, (int) (r144 + r142), (int) (r142 + r145)), this.f79901b);
        this.f79904e.put(r126, r131);
        c(r110, r112, r126, r131, false);
        goto L97
    L86:
        r141 = r138;
        goto L87
    L88:
        Ref.ObjectRef r146 = new Ref.ObjectRef();
        v.a r147 = (v.a) r108.element;
        int r148 = r147.f79884a;
        int r149 = r148 - (r148 % 16);
        int r150 = r147.f79885b;
        int r151 = r150 - (r150 % 16);
        if (r110.getSilenceStatus() != 0) goto L91;
        String r152 = "1";
    L92:
        ?? r153 = r110.getMInteractIdStr() + '_' + this.f79914o + '_' + this.f79915p + '_' + r152 + '_' + r149 + '_' + r151;
        r146.element = r153;
        Bitmap r154 = this.f79903d.get(r153);
        if (r154 == null) goto L95;
        c(r110, r112, (String) r146.element, r154, false);
        goto L97
    L95:
        IBaseUser r155 = r110.getUser();
        Intrinsics.checkNotNull(r155);
        py.k r156 = r155.getAvatarMedium();
        v.a r157 = (v.a) r108.element;
        int r158 = r157.f79884a;
        int r159 = r157.f79885b;
        this.f79909j.add(Observable.create(new s0(r156, r158 - (r158 % 16), r159 - (r159 % 16))).compose(RxUtil.rxSchedulerHelper()).map(new w(this, r110, r112, r108)).subscribe(new x(this, r146, r110, r112), new y(this, r146, r110, r112)));
        goto L97
    L91:
        r152 = "0";
    L77:
        r121 = 0.0f;
    L72:
        r120 = 0.5f;
    L97:
        if (r113 == false) goto L106;
        ei6.a r160 = this.f79910k;
        if (r160 == null) goto L107;
        ti6.d r161 = r160.p();
        if (r161 == null) goto L108;
        ti6.e r162 = r161.f();
        if (r162 == null) goto L109;
        r162.o();
        return;
    L109:
        return;
    L108:
        return;
    L107:
        return;
    L106:
        return;
    L96:
        e(r110, false);
    L53:
        if (r110.getMediaType() != 2) goto L55;
    L58:
        r107 = true;
        goto L59
    L55:
        if (r110.getMediaType() == 0) goto L58;
        r107 = false;
        goto L59
    L44:
        r116 = null;
        goto L45
    L37:
        if (r110.getLinkType() == 0) goto L40;
        r114 = false;
    L63:
        r102 = false;
    L30:
        r105 = null;
    L14:
        if (this.f79914o == 15) goto L18;
        if (this.f79915p == 7) goto L18;
    L20:
        r103 = false;
    L18:
        if (r101 != MixStreamType.SERVER_MIX) goto L20;
    L5:
        r101 = null;
        goto L6
    }

    public final void c(ILinkPlayerInfoBridge r100, ti6.f r101, String r102, Bitmap r103, boolean r110) {
        int r104 = r100.getUserPosition();
        RTCWaterMarkRegion r105 = new RTCWaterMarkRegion();
        boolean r106 = false;
        if (r101 == null) goto L5;
        r105.f255235a = (float) r101.f546162d;
        r105.f255237c = (float) r101.f546164f;
        r105.f255236b = (float) r101.f546163e;
        r105.f255238d = (float) r101.f546165g;
        r105.f255239e = 0;
        r105.f255242h = r103;
    L5:
        String r107 = String.valueOf(r104);
        if (this.f79902c.containsKey(r107) == false) goto L13;
        String r108 = this.f79902c.get(r107);
        if (r108 != null) goto L11;
        r108 = "";
    L11:
        if (r102.equals(r108) == true) goto L13;
        r106 = true;
    L13:
        if (r106 == false) goto L15;
        e(r100, r110);
    L15:
        String r109 = String.valueOf(r104);
        this.f79902c.put(r109, r102);
        ei6.a r111 = a();
        this.f79910k = r111;
        if (r111 == null) goto L22;
        ti6.d r112 = r111.p();
        if (r112 == null) goto L22;
        ti6.e r113 = r112.f();
        if (r113 == null) goto L22;
        String r114 = b(r100);
        System.currentTimeMillis();
        r113.a(r114, r105);
    L22:
        if (r110 == false) goto L31;
        ei6.a r115 = this.f79910k;
        if (r115 == null) goto L32;
        ti6.d r116 = r115.p();
        if (r116 == null) goto L33;
        ti6.e r117 = r116.f();
        if (r117 == null) goto L34;
        r117.o();
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    }
}

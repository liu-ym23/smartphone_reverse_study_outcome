package com.bytedance.android.live.ktv.common.midi.v2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdkapi.depend.message.BackgroundMaterial;
import com.bytedance.android.livesdkapi.depend.message.BuoyMaterial;
import com.bytedance.android.livesdkapi.depend.message.FeedbackMaterial;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import py.k;

/* JADX INFO: loaded from: classes45.dex */
public class d implements com.bytedance.android.live.ktv.common.midi.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MidiSkinDressInfo f69963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, BitmapDrawable> f69964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Bitmap> f69965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f69966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Drawable> f69967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Drawable> f69968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Drawable> f69969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Bitmap> f69970h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Bitmap> f69971i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Bitmap> f69972j;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f69973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f69974b;

        public a(d r100, String r101) {
            this.f69973a = r100;
            this.f69974b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            this.f69973a.f69964b.put(this.f69974b, new BitmapDrawable(s1.getResources(), r101));
            this.f69973a.f69965c.put(this.f69974b, r101);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f69975a = null;

        static {
            f69975a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ((Throwable) r100).printStackTrace();
        }
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public boolean A() {
        return false;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public int C() {
        return 100;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final int F() {
        return 4;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final void H() {
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public boolean L() {
        return false;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final int getCurrentMode() {
        return 0;
    }

    public d() {
        LinkedHashMap r100 = new LinkedHashMap();
        this.f69964b = r100;
        LinkedHashMap r101 = new LinkedHashMap();
        this.f69965c = r101;
        this.f69966d = new CompositeDisposable();
        ArrayList r102 = new ArrayList();
        this.f69968f = r102;
        ArrayList r103 = new ArrayList();
        this.f69971i = r103;
        this.f69967e = CollectionsKt.listOf(s1.m(R.drawable.ttlive_ktv_hit_drawable_1));
        Drawable r104 = (BitmapDrawable) r100.get("advan_scatter_deco_a");
        if (r104 != null) goto L6;
        r104 = s1.m(R.drawable.ttlive_ktv_hit_drawable_4);
    L6:
        Drawable r105 = (BitmapDrawable) r100.get("advan_scatter_deco_b");
        if (r105 != null) goto L10;
        r105 = s1.m(R.drawable.ttlive_ktv_hit_drawable_5);
    L10:
        List r106 = CollectionsKt.listOf(new Drawable[]{s1.m(R.drawable.ttlive_ktv_hit_drawable_1), s1.m(R.drawable.ttlive_ktv_hit_drawable_2), s1.m(R.drawable.ttlive_ktv_hit_drawable_3), r104, r105, r104, r105, r104, r105});
        r102.clear();
        r102.addAll(r106);
        Bitmap r107 = (Bitmap) r101.get("advan_scatter_deco_a");
        if (r107 != null) goto L13;
        r107 = BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_ktv_hit_drawable_4);
    L13:
        Bitmap r108 = (Bitmap) r101.get("advan_scatter_deco_b");
        if (r108 != null) goto L16;
        r108 = BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_ktv_hit_drawable_5);
    L16:
        List r109 = CollectionsKt.listOf(new Bitmap[]{BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_ktv_hit_drawable_1), BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_ktv_hit_drawable_2), BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_ktv_hit_drawable_3), r107, r108, r107, r108, r107, r108});
        r103.clear();
        r103.addAll(r109);
        this.f69969g = CollectionsKt.listOf(new Drawable[]{s1.m(R.drawable.ttlive_ktv_hit_drawable_1), s1.m(R.drawable.ttlive_ktv_hit_drawable_2), s1.m(R.drawable.ttlive_ktv_hit_drawable_3)});
        this.f69970h = CollectionsKt.listOf(BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_ktv_hit_drawable_1));
        this.f69972j = CollectionsKt.listOf(new Bitmap[]{BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_ktv_hit_drawable_1), BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_ktv_hit_drawable_2), BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_ktv_hit_drawable_3)});
    }

    public final boolean a() {
        MidiSkinDressInfo r100 = this.f69963a;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getDressId();
    L7:
        if (TextUtils.isEmpty(r102) == true) goto L14;
        MidiSkinDressInfo r103 = this.f69963a;
        if (r103 == null) goto L12;
        r101 = r103.getDressId();
    L12:
        if ((!Intrinsics.areEqual(r101, "0")) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final void clear() {
        ((LinkedHashMap) this.f69964b).clear();
        ((LinkedHashMap) this.f69965c).clear();
        this.f69966d.dispose();
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final int B() {
        return s1.h(R.color.ttlive_ktv_midi_score_low_text_color);
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final int D() {
        return vm2.h.w();
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final Pair<String, String> E() {
        if (a() == false) goto L19;
        MidiSkinDressInfo r100 = this.f69963a;
        String r101 = null;
        if (r100 == null) goto L11;
        MidiSkinMaterial r102 = r100.getMaterial();
        if (r102 == null) goto L11;
        BackgroundMaterial r103 = r102.getBg();
        if (r103 == null) goto L11;
        String r104 = r103.getToneLineStart();
    L12:
        MidiSkinDressInfo r105 = this.f69963a;
        if (r105 == null) goto L21;
        MidiSkinMaterial r106 = r105.getMaterial();
        if (r106 == null) goto L21;
        BackgroundMaterial r107 = r106.getBg();
        if (r107 == null) goto L21;
        r101 = r107.getToneLineEnd();
    L21:
        return TuplesKt.to(r104, r101);
    L11:
        r104 = null;
        goto L12
    L19:
        r104 = "#FF4BE8";
        r101 = "#FF386B";
        goto L21
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final k G() {
        if (a() == false) goto L12;
        MidiSkinDressInfo r100 = this.f69963a;
        if (r100 == null) goto L13;
        MidiSkinMaterial r101 = r100.getMaterial();
        if (r101 == null) goto L14;
        BackgroundMaterial r102 = r101.getBg();
        if (r102 != null) goto L11;
        return null;
    L11:
        return r102.getBuoyAreaBg();
    L14:
        return null;
    L13:
        return null;
    L12:
        return null;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final String J() {
        if (a() == false) goto L17;
        MidiSkinDressInfo r100 = this.f69963a;
        if (r100 == null) goto L17;
        MidiSkinMaterial r101 = r100.getMaterial();
        if (r101 == null) goto L17;
        FeedbackMaterial r102 = r101.getFeedback();
        if (r102 == null) goto L17;
        k r103 = r102.getAdvanPerfectBg();
        if (r103 == null) goto L17;
        List<String> r104 = r103.getUrls();
        if (r104 == null) goto L17;
        String r105 = (String) CollectionsKt.first(r104);
        if (r105 == null) goto L17;
        return r105;
    L17:
        return com.bytedance.android.live.ktv.common.midi.c.f69839a;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final MidiSkinDressInfo z() {
        return this.f69963a;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final void y(MidiSkinDressInfo r100) {
        this.f69963a = r100;
        if (a() == false) goto L20;
        k r101 = null;
        if (r100 == null) goto L11;
        MidiSkinMaterial r102 = r100.getMaterial();
        if (r102 == null) goto L11;
        BuoyMaterial r103 = r102.getBuoy();
        if (r103 == null) goto L11;
        k r104 = r103.getAdvanScatterDecoA();
    L12:
        b("advan_scatter_deco_a", r104);
        if (r100 == null) goto L19;
        MidiSkinMaterial r105 = r100.getMaterial();
        if (r105 == null) goto L19;
        BuoyMaterial r106 = r105.getBuoy();
        if (r106 == null) goto L19;
        r101 = r106.getAdvanScatterDecoB();
    L19:
        b("advan_scatter_deco_b", r101);
        return;
    L11:
        r104 = null;
        goto L12
    L20:
        ((LinkedHashMap) this.f69965c).clear();
        ((LinkedHashMap) this.f69964b).clear();
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final List<Bitmap> I(Integer r100, boolean r101) {
        if (r100 != null) goto L5;
    L7:
        if (r100 != null) goto L10;
    L12:
        if (r100 == null) goto L20;
        if (r100.intValue() != 3) goto L20;
        if (r101 == false) goto L23;
        return this.f69971i;
    L23:
        return this.f69972j;
    L20:
        return this.f69970h;
    L10:
        if (r100.intValue() != 2) goto L12;
    L21:
        return this.f69970h;
    L5:
        if (r100.intValue() != 1) goto L7;
        goto L7
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final String K(int r100, boolean r101) {
        boolean r102 = a();
        if (r100 != 1) goto L5;
        if (r102 == false) goto L62;
        MidiSkinDressInfo r103 = this.f69963a;
        if (r103 == null) goto L84;
        MidiSkinMaterial r104 = r103.getMaterial();
        if (r104 == null) goto L85;
        FeedbackMaterial r105 = r104.getFeedback();
        if (r105 == null) goto L86;
        k r106 = r105.getNice();
        if (r106 == null) goto L87;
        List<String> r107 = r106.getUrls();
        if (r107 != null) goto L89;
        return null;
    L89:
        return (String) CollectionsKt.first(r107);
    L87:
        return null;
    L86:
        return null;
    L85:
        return null;
    L84:
        return null;
    L62:
        String r108 = com.bytedance.android.live.ktv.common.midi.c.f69839a;
        return com.bytedance.android.live.ktv.common.midi.c.f69843e;
    L5:
        if (r100 != 2) goto L7;
        if (r102 == false) goto L49;
        MidiSkinDressInfo r109 = this.f69963a;
        if (r109 == null) goto L77;
        MidiSkinMaterial r110 = r109.getMaterial();
        if (r110 == null) goto L78;
        FeedbackMaterial r111 = r110.getFeedback();
        if (r111 == null) goto L79;
        k r112 = r111.getGood();
        if (r112 == null) goto L80;
        List<String> r113 = r112.getUrls();
        if (r113 != null) goto L82;
        return null;
    L82:
        return (String) CollectionsKt.first(r113);
    L80:
        return null;
    L79:
        return null;
    L78:
        return null;
    L77:
        return null;
    L49:
        String r114 = com.bytedance.android.live.ktv.common.midi.c.f69839a;
        return com.bytedance.android.live.ktv.common.midi.c.f69844f;
    L7:
        if (r100 != 3) goto L90;
        if (r101 == false) goto L23;
        if (r102 == false) goto L22;
        MidiSkinDressInfo r115 = this.f69963a;
        if (r115 == null) goto L64;
        MidiSkinMaterial r116 = r115.getMaterial();
        if (r116 == null) goto L65;
        FeedbackMaterial r117 = r116.getFeedback();
        if (r117 == null) goto L66;
        k r118 = r117.getAdvanPerfectTx();
        if (r118 == null) goto L67;
        List<String> r119 = r118.getUrls();
        if (r119 != null) goto L69;
        return null;
    L69:
        return (String) CollectionsKt.first(r119);
    L67:
        return null;
    L66:
        return null;
    L65:
        return null;
    L64:
        return null;
    L22:
        String r120 = com.bytedance.android.live.ktv.common.midi.c.f69839a;
        return com.bytedance.android.live.ktv.common.midi.c.f69841c;
    L23:
        if (r102 == false) goto L35;
        MidiSkinDressInfo r121 = this.f69963a;
        if (r121 == null) goto L71;
        MidiSkinMaterial r122 = r121.getMaterial();
        if (r122 == null) goto L72;
        FeedbackMaterial r123 = r122.getFeedback();
        if (r123 == null) goto L73;
        k r124 = r123.getPerfect();
        if (r124 == null) goto L74;
        List<String> r125 = r124.getUrls();
        if (r125 == null) goto L75;
        String r126 = (String) CollectionsKt.first(r125);
    L76:
        return r126;
    L75:
        return null;
    L74:
        return null;
    L73:
        return null;
    L72:
        return null;
    L71:
        return null;
    L35:
        String r127 = com.bytedance.android.live.ktv.common.midi.c.f69839a;
        r126 = com.bytedance.android.live.ktv.common.midi.c.f69845g;
        goto L76
    L90:
        return null;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final List<Drawable> M(Integer r100, boolean r101) {
        if (r100 != null) goto L5;
    L7:
        if (r100 != null) goto L10;
    L12:
        if (r100 == null) goto L20;
        if (r100.intValue() != 3) goto L20;
        if (r101 == false) goto L23;
        return this.f69968f;
    L23:
        return this.f69969g;
    L20:
        return this.f69967e;
    L10:
        if (r100.intValue() != 2) goto L12;
    L21:
        return this.f69967e;
    L5:
        if (r100.intValue() != 1) goto L7;
        goto L7
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final List<Drawable> N(Integer r100, boolean r110) {
        if (r100 == null) goto L9;
        if (r100.intValue() != 1) goto L9;
    L32:
        return CollectionsKt.listOf(s1.m(R.drawable.ttlive_ktv_hit_drawable_1));
    L9:
        if (r100 != null) goto L12;
    L14:
        if (r100 == null) goto L31;
        if (r100.intValue() != 3) goto L31;
        if (r110 == false) goto L34;
        Drawable r111 = (BitmapDrawable) ((LinkedHashMap) this.f69964b).get("advan_scatter_deco_a");
        if (r111 != null) goto L24;
        r111 = s1.m(R.drawable.ttlive_ktv_hit_drawable_4);
    L24:
        Drawable r101 = (BitmapDrawable) ((LinkedHashMap) this.f69964b).get("advan_scatter_deco_b");
        if (r101 != null) goto L33;
        r101 = s1.m(R.drawable.ttlive_ktv_hit_drawable_5);
    L33:
        return CollectionsKt.listOf(new Drawable[]{s1.m(R.drawable.ttlive_ktv_hit_drawable_1), s1.m(R.drawable.ttlive_ktv_hit_drawable_2), s1.m(R.drawable.ttlive_ktv_hit_drawable_3), r111, r101, r111, r101, r111, r101});
    L34:
        return CollectionsKt.listOf(new Drawable[]{s1.m(R.drawable.ttlive_ktv_hit_drawable_1), s1.m(R.drawable.ttlive_ktv_hit_drawable_2), s1.m(R.drawable.ttlive_ktv_hit_drawable_3)});
    L31:
        return CollectionsKt.listOf(s1.m(R.drawable.ttlive_ktv_hit_drawable_1));
    L12:
        if (r100.intValue() != 2) goto L14;
        goto L14
    }

    public final void b(String r100, k r101) {
        if (StringsKt.isBlank(r100) == false) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L13;
        if (r101 != null) goto L9;
    L11:
        RxUtilKt.c(a1.k(r101).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r100), b.f69975a), this.f69966d);
        return;
    L9:
        if (r101.isValid() == true) goto L11;
        return;
    L13:
        return;
    L5:
        r102 = false;
        goto L6
    }
}

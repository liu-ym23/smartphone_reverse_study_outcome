package com.bytedance.android.livesdk.gift.platform.business.normal.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.configmodel.o2;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.j3;
import com.bytedance.android.livesdk.gift.model.n3;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.android.livesdk.gift.model.u3;
import com.bytedance.android.livesdk.gift.model.v3;
import com.bytedance.android.livesdk.gift.model.w;
import com.bytedance.android.livesdk.gift.platform.business.e;
import com.bytedance.android.livesdk.gift.platform.business.j;
import com.bytedance.android.livesdk.gift.platform.business.tray.l;
import com.bytedance.android.livesdk.gift.platform.business.tray.m;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.util.b;
import com.bytedance.android.livesdk.message.model.i6;
import com.bytedance.android.livesdk.message.model.k6;
import com.bytedance.android.livesdk.message.model.m7;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.message.model.q8;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import gm2.h;
import iy1.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.KProperty;
import py.k;
import v12.d;

/* JADX INFO: loaded from: classes9.dex */
public class NormalGiftMessage implements h, Comparable<NormalGiftMessage>, d {
    public Map<Long, a> A;
    public int B;
    public List<String> C;
    public j3 D;
    public w E;
    public List<n3> F;
    public long G;
    public int H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f129770J;
    public boolean K;
    public long L;
    public boolean M;
    public int N;
    public String O;
    public boolean P;
    public boolean Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f129771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f129772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f129773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a5 f129774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IBaseUser f129775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IBaseUser f129776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f129777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f129778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f129779i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<Integer, Long> f129780j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f129781k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f129782l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f129783m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f129784n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public k f129785o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f129786p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f129787q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f129788r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Map<String, Long> f129789s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public gm2.d f129790t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public m7 f129791u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f129792v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public h2 f129793w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f129794x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f129795y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a f129796z;

    public static final enum GiftType extends Enum<GiftType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GiftType[] f129797a = null;
        public static final GiftType group = null;
        public static final GiftType normal = null;

        static {
            GiftType r100 = new GiftType("normal", 0);
            normal = r100;
            GiftType r101 = new GiftType("group", 1);
            group = r101;
            f129797a = new GiftType[]{r100, r101};
        }

        public static GiftType[] values() {
            return (GiftType[]) f129797a.clone();
        }

        public static GiftType valueOf(String r100) {
            return (GiftType) r27.a.a(GiftType.class, r100);
        }

        public GiftType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public long getTotalMoney() {
        return t(false);
    }

    public final int hashCode() {
        return 0;
    }

    @Override // v12.d
    public final long getAssetId() {
        if ((this.f129790t instanceof k6) == false) goto L7;
        return o().getAssetId();
    L7:
        if (n() == null) goto L11;
        return n().getAssetId();
    L11:
        if (s() == null) goto L17;
        h1 r100 = s().getGift();
        if (r100 != null) goto L15;
        return 0;
    L15:
        return r100.getPrimaryEffectId();
    L17:
        h2 r101 = this.f129793w;
        if (r101 != null) goto L20;
        return 0;
    L20:
        return r101.getPrimaryEffectId();
    }

    @Override // v12.d
    public final String getFromUserId() {
        IBaseUser r100 = this.f129775e;
        if (r100 != null) goto L7;
        return "";
    L7:
        return String.valueOf(r100.getIdString());
    }

    @Override // v12.d
    public final String getGiftInfo() {
        StringBuilder r100 = new StringBuilder("giftEnd: ");
        r100.append(this.f129786p);
        r100.append(" ; comboCount: ");
        r100.append(this.f129783m);
        r100.append(" ; combSurplus: ");
        r100.append(this.f129784n);
        r100.append(" ; groupId: ");
        r100.append(this.f129782l);
        r100.append(" ; groupCount");
        r100.append(this.f129781k);
        r100.append(" ; repeatCount");
        if (r() == null) goto L5;
        Object r101 = Integer.valueOf(r().getRepeatEnd());
    L6:
        r100.append(r101);
        return r100.toString();
    L5:
        r101 = "";
        goto L6
    }

    @Override // v12.d
    public final String getLogId() {
        gm2.d r100 = this.f129790t;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getLogId();
    }

    public final long getTotalCount() {
        return (this.f129783m + ((long) this.f129784n)) * this.f129781k;
    }

    public final a5 getTrayDisplayText() {
        com.bytedance.android.livesdk.gift.configmodel.w r100 = (com.bytedance.android.livesdk.gift.configmodel.w) e.G.getValue(null, e.f129015a[31]);
        if (r100 == null) goto L29;
        if (r100.a() == null) goto L29;
        if (r100.a().b() == false) goto L29;
        if (this.f129774d == null) goto L29;
        String r101 = r100.a().a();
        if (r101 == null) goto L29;
        if (r101.matches("#[A-Fa-f0-9]+") == false) goto L29;
        b5 r102 = this.f129774d.getDefaultFormat();
        if (r102 == null) goto L17;
        r102.setColor(r101);
    L17:
        List<c5> r103 = this.f129774d.getPieces();
        if (r103 == null) goto L29;
        int r104 = 0;
    L21:
        if (r104 >= r103.size()) goto L29;
        c5 r105 = (c5) ListProtector.get(r103, r104);
        if (r105 == null) goto L27;
        if (r105.getFormat() == null) goto L27;
        r105.getFormat().setColor(r101);
    L27:
        r104 = r104 + 1;
    L29:
        return this.f129774d;
    }

    public final String m() {
        if (this.f129794x != 0) goto L6;
        this.f129794x = p().longValue();
    L6:
        return "0" + String.valueOf(this.f129794x);
    }

    public final i6 n() {
        gm2.d r100 = this.f129790t;
        if ((r100 instanceof i6) == true) goto L7;
        return null;
    L7:
        return (i6) r100;
    }

    public final k6 o() {
        gm2.d r100 = this.f129790t;
        if ((r100 instanceof k6) == true) goto L7;
        return null;
    L7:
        return (k6) r100;
    }

    public final String q() {
        if (((o2) t02.a.f544122b.getValue(null, t02.a.f544121a[0])).a() == true) goto L6;
        Boolean r100 = Boolean.FALSE;
    L22:
        if (r100.booleanValue() == true) goto L24;
        int r101 = b02.a.f(this);
        if (b02.a.d(this) == false) goto L35;
        if ((this instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L35;
        if (r101 <= 0) goto L35;
        if (this.f129783m <= r101) goto L35;
        return String.format("%d+", new Object[]{Integer.valueOf(r101)});
    L35:
        return String.valueOf(this.f129783m);
    L24:
        return String.format("%d+", new Object[]{Integer.valueOf(b02.a.g(this))});
    L6:
        if ((this instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L8;
    L12:
        boolean r102 = false;
    L13:
        int r103 = b02.a.g(this);
        if (r102 == false) goto L19;
        if (r103 <= 0) goto L19;
        if (this.f129783m <= r103) goto L19;
        boolean r104 = true;
    L20:
        r100 = Boolean.valueOf(r104);
    L19:
        r104 = false;
        goto L20
    L8:
        if ((this instanceof l) == true) goto L12;
        if ((this instanceof m) == true) goto L12;
        r102 = true;
        goto L13
    }

    public final o7 r() {
        gm2.d r100 = this.f129790t;
        if ((r100 instanceof o7) == true) goto L7;
        return null;
    L7:
        return (o7) r100;
    }

    public final q8 s() {
        gm2.d r100 = this.f129790t;
        if ((r100 instanceof q8) == true) goto L7;
        return null;
    L7:
        return (q8) r100;
    }

    public final String u() {
        long r100 = 0;
        if ((this instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L5;
    L6:
        List<n3> r101 = this.F;
        if (r101 != null) goto L9;
    L15:
        StringBuilder r102 = new StringBuilder();
        r102.append(getFromUserId());
        r102.append("-");
        r102.append(String.valueOf(this.f129772b));
        r102.append("-");
        r102.append(String.valueOf(this.f129782l));
        r102.append("-");
        r102.append(String.valueOf(this.f129781k));
        IBaseUser r103 = this.f129775e;
        if (r103 != null) goto L18;
    L20:
        String r104 = "";
    L21:
        r102.append(r104);
        if (s() == null) goto L24;
        r100 = this.L;
    L24:
        r102.append(String.valueOf(r100));
        String r105 = r102.toString();
        IBaseUser r106 = this.f129776f;
        if (r106 != null) goto L27;
        return r105;
    L27:
        return r105 + "_" + r106.getIdString();
    L18:
        if (r103.getWebcastUid() == null) goto L20;
        r104 = this.f129775e.getWebcastUid();
        goto L21
    L9:
        if (r101.isEmpty() == true) goto L15;
    L11:
        if (this.f129794x != 0) goto L14;
        this.f129794x = p().longValue();
    L14:
        return String.valueOf(0) + String.valueOf(this.f129794x);
    L5:
        if (b02.a.b(this) == false) goto L11;
        goto L6
    }

    public final String v() {
        if ((this instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L5;
    L11:
        StringBuilder r100 = new StringBuilder();
        r100.append(getFromUserId());
        r100.append("-");
        r100.append(String.valueOf(this.f129772b));
        r100.append("-");
        r100.append(String.valueOf(this.f129782l));
        IBaseUser r101 = this.f129775e;
        if (r101 != null) goto L14;
    L16:
        String r102 = "";
    L17:
        r100.append(r102);
        String r103 = r100.toString();
        KProperty[] r104 = b02.a.f16821a;
        if (((Boolean) j.f129673c.getValue(null, j.f129671a[1])).booleanValue() == false) goto L23;
        IBaseUser r105 = this.f129776f;
        if (r105 != null) goto L22;
        return r103;
    L22:
        return r103 + "_" + r105.getIdString();
    L23:
        return r103;
    L14:
        if (r101.getWebcastUid() == null) goto L16;
        r102 = this.f129775e.getWebcastUid();
        goto L17
    L5:
        if (b02.a.b(this) == true) goto L11;
        if (this.f129794x != 0) goto L10;
        this.f129794x = p().longValue();
    L10:
        return String.valueOf(0) + String.valueOf(this.f129794x);
    }

    public static Long p() {
        if (b.b() == null) goto L11;
        if (b.b().getBigGiftKeyCount() == null) goto L11;
        if (b.b().getBigGiftKeyCount().getValue() == null) goto L11;
        Long r100 = Long.valueOf(b.b().getBigGiftKeyCount().getValue().longValue() + 1);
        b.b().getBigGiftKeyCount().setValue(r100);
        return r100;
    L11:
        return 0L;
    }

    public final void b() {
        if (b.b() != null) goto L5;
    L8:
        this.f129783m++;
        this.f129784n--;
        return;
    L5:
        if (this.f129792v == true) goto L8;
        x(this.f129783m + ((long) this.f129784n));
        this.f129784n = 0;
    }

    @Override // v12.d
    public final String getTraceId() {
        if (r() != null) goto L7;
        return null;
    L7:
        return r().getTraceId();
    }

    public final Boolean i() {
        o7 r100 = r();
        if (r100 == null) goto L5;
        o0 r101 = r100.getTrayInfo();
        if (r101 == null) goto L9;
        u3 r102 = r101.getTrayPostEffect();
        if (r102 != null) goto L15;
        return Boolean.FALSE;
    L15:
        return Boolean.valueOf(v3.a(r102));
    L9:
        return Boolean.FALSE;
    L5:
        return Boolean.FALSE;
    }

    public final long l() {
        if (r() == null) goto L25;
        List<n3> r100 = this.F;
        if (r100 != null) goto L7;
    L18:
        h2 r101 = u.f(r());
        if (r101 != null) goto L21;
        return 0;
    L21:
        if ((this instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L23;
        return 0;
    L23:
        return r101.getDiamondCount();
    L7:
        if (r100.size() <= 0) goto L18;
        int r102 = 0;
        long r103 = 0;
    L10:
        if (r102 >= this.F.size()) goto L16;
        h1 r104 = ((n3) ListProtector.get(this.F, r102)).getGift();
        if (r104 == null) goto L14;
        r103 = r103 + ((long) r104.getDiamondCount());
    L14:
        r102 = r102 + 1;
        goto L10
    L16:
        if (r103 == 0) goto L18;
        return r103;
    L25:
        if (n() == null) goto L29;
        return n().getPrice();
    L29:
        if (s() == null) goto L39;
        h1 r105 = s().getGift();
        if (r105 != null) goto L33;
        return 0;
    L33:
        return r105.getDiamondCount();
    L39:
        return 0;
    }

    @Override // v12.d
    public final String a() {
        return this.f129787q;
    }

    @Override // v12.d
    public final boolean d() {
        return this.f129786p;
    }

    @Override // v12.d
    public final long e() {
        return this.f129783m;
    }

    @Override // v12.d
    public final String f() {
        return this.f129788r;
    }

    @Override // v12.d
    public final String getDescription() {
        return this.f129773c;
    }

    @Override // v12.d
    public final long getGiftId() {
        return this.f129772b;
    }

    @Override // v12.d
    public final long getGroupCount() {
        return this.f129781k;
    }

    @Override // v12.d
    public final long getGroupId() {
        return this.f129782l;
    }

    @Override // v12.d
    public final long getMsgId() {
        return this.f129771a;
    }

    @Override // v12.d
    public final IBaseUser getToUser() {
        return this.f129776f;
    }

    @Override // v12.d
    public final boolean isLocal() {
        return this.f129792v;
    }

    public final int c(NormalGiftMessage r100) {
        if (o().getPlayPriority() != r100.o().getPlayPriority()) goto L7;
        return (int) 0;
    L7:
        return r100.o().getPlayPriority() - o().getPlayPriority();
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(NormalGiftMessage r100) {
        return h(r100);
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return u().equals(((NormalGiftMessage) r100).u());
    }

    public final int g(NormalGiftMessage r100) {
        if (n() == null) goto L7;
        if (n().getPrice() <= 0) goto L7;
    L10:
        long r101 = r100.n().getPrice();
        long r102 = n().getPrice();
    L12:
        return (int) (r101 - r102);
    L7:
        if (r100.n() == null) goto L14;
        if (r100.n().getPrice() > 0) goto L10;
    L14:
        if (n().getPriority() == r100.n().getPriority()) goto L16;
        r101 = r100.n().getPriority();
        r102 = n().getPriority();
        goto L12
    L16:
        return (int) 0;
    }

    public int h(NormalGiftMessage r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (n() == null) goto L12;
        if (r100.n() == null) goto L12;
        return g(r100);
    L12:
        if (o() != null) goto L14;
    L17:
        long r101 = getTotalMoney();
        long r102 = r100.getTotalMoney();
        if (this.f129792v == true) goto L20;
        long r103 = r101 - r102;
    L22:
        if (r103 != 0) goto L40;
        if ((r100 instanceof l) == false) goto L27;
        return -1;
    L27:
        if (this.f129770J == false) goto L37;
        String r104 = r100.I;
        if (r104 != null) goto L32;
        r104 = r100.u();
    L32:
        String r105 = this.I;
        if (r105 != null) goto L36;
        r105 = u();
    L36:
        int r106 = r104.compareTo(r105);
    L38:
        r103 = r106;
        goto L40
    L37:
        r106 = r100.u().compareTo(u());
    L40:
        if (r103 >= 0) goto L42;
        return 1;
    L42:
        if (r103 != 0) goto L52;
        long r107 = this.G;
        long r108 = r100.G;
        if (r107 <= r108) goto L46;
        return -1;
    L46:
        if (r107 >= r108) goto L49;
        return 1;
    L49:
        if (this.K == false) goto L51;
        return -1;
    L51:
        return 0;
    L52:
        return -1;
    L20:
        r103 = 0;
        goto L22
    L14:
        if (r100.o() == null) goto L17;
        return c(r100);
    }

    public final long t(boolean r100) {
        if (r() == null) goto L31;
        List<n3> r101 = this.F;
        if (r101 != null) goto L7;
    L18:
        h2 r102 = u.f(r());
        if (r102 != null) goto L21;
        return 0;
    L21:
        if ((this instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L23;
    L26:
        if (r100 == false) goto L28;
        long r103 = this.f129783m * this.f129781k;
        int r104 = r102.getDiamondCount();
    L44:
        return r103 * ((long) r104);
    L28:
        r103 = (this.f129783m + ((long) this.f129784n)) * this.f129781k;
        r104 = r102.getDiamondCount();
        goto L44
    L23:
        if (b02.a.b(this) == true) goto L26;
        return r102.getDiamondCount();
    L7:
        if (r101.size() <= 0) goto L18;
        int r105 = 0;
        long r106 = 0;
    L10:
        if (r105 >= this.F.size()) goto L16;
        h1 r107 = ((n3) ListProtector.get(this.F, r105)).getGift();
        if (r107 == null) goto L14;
        r106 = r106 + ((long) r107.getDiamondCount());
    L14:
        r105 = r105 + 1;
        goto L10
    L16:
        if (r106 == 0) goto L18;
        return r106;
    L31:
        if (n() == null) goto L35;
        return n().getPrice();
    L35:
        if (s() == null) goto L45;
        h1 r108 = s().getGift();
        if (r108 != null) goto L39;
        return 0;
    L39:
        return r108.getDiamondCount();
    L45:
        return 0;
    }

    public final void w(NormalGiftMessage r100) {
        long r101 = r100.f129783m - this.f129783m;
        int r102 = this.f129784n;
        long r103 = r101 - ((long) r102);
        if (r103 <= 0) goto L8;
        this.f129784n = (int) (((long) r102) + r103);
        if (b.b() == null) goto L9;
        b.b().getGiftTrayTempComboUpdateEvent().post(Boolean.TRUE);
        return;
    L9:
        return;
    }

    public final void x(long r100) {
        this.f129795y = (int) (((long) this.f129795y) + (r100 - this.f129783m));
        this.f129783m = r100;
    }

    public NormalGiftMessage(long r100, long r101) {
        this.f129777g = 1;
        this.f129779i = false;
        this.f129780j = new HashMap();
        this.f129781k = 1;
        this.f129782l = 0;
        this.f129784n = 0;
        this.f129794x = 0;
        this.f129795y = 0;
        this.A = new LinkedHashMap();
        this.B = -1;
        this.C = new ArrayList();
        this.K = false;
        this.L = 0;
        this.M = false;
        this.Q = false;
        this.f129771a = r100;
        this.f129772b = r101;
    }

    public final void setTimeStampMap(int r100, long r101) {
        this.f129780j.put(Integer.valueOf(r100), Long.valueOf(r101));
    }
}

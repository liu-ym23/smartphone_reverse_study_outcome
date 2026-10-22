package com.bytedance.android.annie.scheme.vo.refactor;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/annie/scheme/vo/refactor/HybridSchemaParam;", "Landroid/os/Parcelable;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "annie_release"}, k = 1, mv = {1, 4, 3})
public class HybridSchemaParam implements Parcelable {
    public static final Parcelable.Creator<HybridSchemaParam> CREATOR = null;
    public final boolean A;
    public final boolean B;
    public final String C;
    public int D;
    public final boolean E;
    public final boolean F;
    public final int G;
    public final int H;
    public final String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final boolean f39812J;
    public final boolean K;
    public final int L;
    public final boolean M;
    public final String N;
    public final boolean O;
    public final boolean P;
    public final boolean Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HybridKitType f39813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f39814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f39815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f39816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f39817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f39818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f39819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f39820h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f39821i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f39822j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f39823k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f39824l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f39825m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f39826n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f39827o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f39828p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f39829q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Boolean f39830r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f39831s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f39832t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f39833u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Integer f39834v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Integer f39835w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f39836x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f39837y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f39838z;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<HybridSchemaParam> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final HybridSchemaParam createFromParcel(Parcel r410) {
            Intrinsics.checkNotNullParameter(r410, "parcel");
            HybridKitType r100 = HybridKitType.valueOf(r410.readString());
            String r101 = r410.readString();
            String r102 = r410.readString();
            String r103 = r410.readString();
            if (r410.readInt() == 0) goto L5;
            boolean r104 = true;
        L7:
            if (r410.readInt() == 0) goto L9;
            boolean r105 = true;
        L11:
            if (r410.readInt() == 0) goto L13;
            boolean r110 = true;
        L15:
            if (r410.readInt() == 0) goto L17;
            boolean r111 = true;
        L19:
            if (r410.readInt() == 0) goto L21;
            boolean r112 = true;
        L23:
            if (r410.readInt() == 0) goto L25;
            boolean r113 = true;
        L26:
            String r114 = r410.readString();
            if (r410.readInt() == 0) goto L29;
            boolean r115 = true;
        L30:
            int r116 = r410.readInt();
            String r117 = r410.readString();
            String r118 = r410.readString();
            if (r410.readInt() == 0) goto L33;
            boolean r119 = true;
        L35:
            if (r410.readInt() == 0) goto L37;
            boolean r210 = true;
        L38:
            Integer r211 = null;
            if (r410.readInt() != 0) goto L42;
            Boolean r212 = null;
        L47:
            if (r410.readInt() == 0) goto L49;
            boolean r213 = true;
        L50:
            String r214 = r410.readString();
            String r215 = r410.readString();
            if (r410.readInt() != 0) goto L53;
            Integer r216 = null;
        L55:
            if (r410.readInt() == 0) goto L58;
            r211 = Integer.valueOf(r410.readInt());
        L58:
            Integer r217 = r211;
            String r218 = r410.readString();
            int r219 = r410.readInt();
            int r310 = r410.readInt();
            if (r410.readInt() == 0) goto L61;
            boolean r311 = true;
        L63:
            if (r410.readInt() == 0) goto L65;
            boolean r312 = true;
        L66:
            String r313 = r410.readString();
            int r314 = r410.readInt();
            if (r410.readInt() == 0) goto L69;
            boolean r315 = true;
        L71:
            if (r410.readInt() == 0) goto L73;
            boolean r316 = true;
        L74:
            int r317 = r410.readInt();
            int r318 = r410.readInt();
            String r319 = r410.readString();
            if (r410.readInt() == 0) goto L77;
            boolean r411 = true;
        L79:
            if (r410.readInt() == 0) goto L81;
            boolean r412 = true;
        L82:
            int r413 = r410.readInt();
            if (r410.readInt() == 0) goto L85;
            boolean r414 = true;
        L86:
            String r415 = r410.readString();
            if (r410.readInt() == 0) goto L89;
            boolean r416 = true;
        L91:
            if (r410.readInt() == 0) goto L93;
            boolean r417 = true;
        L95:
            if (r410.readInt() == 0) goto L97;
            boolean r418 = true;
        L99:
            return new HybridSchemaParam(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r411, r412, r413, r414, r415, r416, r417, r418);
        L97:
            r418 = false;
            goto L99
        L93:
            r417 = false;
            goto L95
        L89:
            r416 = false;
            goto L91
        L85:
            r414 = false;
            goto L86
        L81:
            r412 = false;
            goto L82
        L77:
            r411 = false;
            goto L79
        L73:
            r316 = false;
            goto L74
        L69:
            r315 = false;
            goto L71
        L65:
            r312 = false;
            goto L66
        L61:
            r311 = false;
            goto L63
        L53:
            r216 = Integer.valueOf(r410.readInt());
            goto L55
        L49:
            r213 = false;
            goto L50
        L42:
            if (r410.readInt() == 0) goto L44;
            boolean r220 = true;
        L45:
            r212 = Boolean.valueOf(r220);
            goto L47
        L44:
            r220 = false;
            goto L45
        L37:
            r210 = false;
            goto L38
        L33:
            r119 = false;
            goto L35
        L29:
            r115 = false;
            goto L30
        L25:
            r113 = false;
            goto L26
        L21:
            r112 = false;
            goto L23
        L17:
            r111 = false;
            goto L19
        L13:
            r110 = false;
            goto L15
        L9:
            r105 = false;
            goto L11
        L5:
            r104 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final HybridSchemaParam[] newArray(int r100) {
            return new HybridSchemaParam[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    public HybridSchemaParam() {
        this(0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.f39813a.name());
        r100.writeString(this.f39814b);
        r100.writeString(this.f39815c);
        r100.writeString(this.f39816d);
        r100.writeInt(this.f39817e ? 1 : 0);
        r100.writeInt(this.f39818f ? 1 : 0);
        r100.writeInt(this.f39819g ? 1 : 0);
        r100.writeInt(this.f39820h ? 1 : 0);
        r100.writeInt(this.f39821i ? 1 : 0);
        r100.writeInt(this.f39822j ? 1 : 0);
        r100.writeString(this.f39823k);
        r100.writeInt(this.f39824l ? 1 : 0);
        r100.writeInt(this.f39825m);
        r100.writeString(this.f39826n);
        r100.writeString(this.f39827o);
        r100.writeInt(this.f39828p ? 1 : 0);
        r100.writeInt(this.f39829q ? 1 : 0);
        Boolean r102 = this.f39830r;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeInt(this.f39831s ? 1 : 0);
        r100.writeString(this.f39832t);
        r100.writeString(this.f39833u);
        Integer r103 = this.f39834v;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        Integer r104 = this.f39835w;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        r100.writeString(this.f39836x);
        r100.writeInt(this.f39837y);
        r100.writeInt(this.f39838z);
        r100.writeInt(this.A ? 1 : 0);
        r100.writeInt(this.B ? 1 : 0);
        r100.writeString(this.C);
        r100.writeInt(this.D);
        r100.writeInt(this.E ? 1 : 0);
        r100.writeInt(this.F ? 1 : 0);
        r100.writeInt(this.G);
        r100.writeInt(this.H);
        r100.writeString(this.I);
        r100.writeInt(this.f39812J ? 1 : 0);
        r100.writeInt(this.K ? 1 : 0);
        r100.writeInt(this.L);
        r100.writeInt(this.M ? 1 : 0);
        r100.writeString(this.N);
        r100.writeInt(this.O ? 1 : 0);
        r100.writeInt(this.P ? 1 : 0);
        r100.writeInt(this.Q ? 1 : 0);
        return;
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.intValue());
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.booleanValue() ? 1 : 0);
        goto L6
    }

    public /* synthetic */ HybridSchemaParam(int r410) {
        this(HybridKitType.WEB, "", "", "hybridkit_default_bid", false, false, false, false, false, false, null, false, 1, "", "", false, false, null, false, "default_lynx_group", "", null, null, "", -1, -1, false, true, "", 0, true, false, 0, -1, "", false, false, 0, false, "", false, true, false);
    }

    public HybridSchemaParam(HybridKitType r110, String r111, String r112, String r113, boolean r114, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, String r215, boolean r216, int r217, String r218, String r219, boolean r310, boolean r311, Boolean r312, boolean r313, String r314, String r315, Integer r316, Integer r317, String r318, int r319, int r410, boolean r411, boolean r412, String r413, int r414, boolean r415, boolean r416, int r417, int r418, String r419, boolean r510, boolean r511, int r512, boolean r513, String r514, boolean r515, boolean r516, boolean r517) {
        Intrinsics.checkNotNullParameter(r110, "engineType");
        Intrinsics.checkNotNullParameter(r111, "url");
        Intrinsics.checkNotNullParameter(r112, "fallbackUrl");
        Intrinsics.checkNotNullParameter(r113, "bid");
        Intrinsics.checkNotNullParameter(r218, "bundle");
        Intrinsics.checkNotNullParameter(r219, "channel");
        Intrinsics.checkNotNullParameter(r314, "group");
        Intrinsics.checkNotNullParameter(r315, "initialData");
        Intrinsics.checkNotNullParameter(r318, "preloadFonts");
        Intrinsics.checkNotNullParameter(r413, "surl");
        Intrinsics.checkNotNullParameter(r419, "secLinkScene");
        Intrinsics.checkNotNullParameter(r514, "preloadSettingsKeys");
        this.f39813a = r110;
        this.f39814b = r111;
        this.f39815c = r112;
        this.f39816d = r113;
        this.f39817e = r114;
        this.f39818f = r210;
        this.f39819g = r211;
        this.f39820h = r212;
        this.f39821i = r213;
        this.f39822j = r214;
        this.f39823k = r215;
        this.f39824l = r216;
        this.f39825m = r217;
        this.f39826n = r218;
        this.f39827o = r219;
        this.f39828p = r310;
        this.f39829q = r311;
        this.f39830r = r312;
        this.f39831s = r313;
        this.f39832t = r314;
        this.f39833u = r315;
        this.f39834v = r316;
        this.f39835w = r317;
        this.f39836x = r318;
        this.f39837y = r319;
        this.f39838z = r410;
        this.A = r411;
        this.B = r412;
        this.C = r413;
        this.D = r414;
        this.E = r415;
        this.F = r416;
        this.G = r417;
        this.H = r418;
        this.I = r419;
        this.f39812J = r510;
        this.K = r511;
        this.L = r512;
        this.M = r513;
        this.N = r514;
        this.O = r515;
        this.P = r516;
        this.Q = r517;
    }
}

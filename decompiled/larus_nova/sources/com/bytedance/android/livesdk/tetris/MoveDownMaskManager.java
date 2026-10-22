package com.bytedance.android.livesdk.tetris;

import android.os.Handler;
import android.os.Message;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/tetris/MoveDownMaskManager;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UpdateSource", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MoveDownMaskManager implements Observer<KVData> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f158518m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f158519n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f158520o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f158521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f158522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f158523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f158524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f158525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f158526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f158527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f158528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f158529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f158530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DataCenter f158531k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Handler f158532l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/tetris/MoveDownMaskManager$UpdateSource;", "", "EnterAnimPlayingStateChange", "EnterAnimVisibleStateChange", "GiftTrayPlayingStateChange", "GiftTrayVisibleStateChange", "MaxMaskLengthChange", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum UpdateSource extends Enum<UpdateSource> {
        public static final UpdateSource EnterAnimPlayingStateChange = null;
        public static final UpdateSource EnterAnimVisibleStateChange = null;
        public static final UpdateSource GiftTrayPlayingStateChange = null;
        public static final UpdateSource GiftTrayVisibleStateChange = null;
        public static final UpdateSource MaxMaskLengthChange = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UpdateSource[] f158533a = null;

        static {
            UpdateSource r100 = new UpdateSource("EnterAnimPlayingStateChange", 0);
            EnterAnimPlayingStateChange = r100;
            UpdateSource r101 = new UpdateSource("EnterAnimVisibleStateChange", 1);
            EnterAnimVisibleStateChange = r101;
            UpdateSource r102 = new UpdateSource("GiftTrayPlayingStateChange", 2);
            GiftTrayPlayingStateChange = r102;
            UpdateSource r103 = new UpdateSource("GiftTrayVisibleStateChange", 3);
            GiftTrayVisibleStateChange = r103;
            UpdateSource r104 = new UpdateSource("MaxMaskLengthChange", 4);
            MaxMaskLengthChange = r104;
            f158533a = new UpdateSource[]{r100, r101, r102, r103, r104};
        }

        public static UpdateSource valueOf(String r100) {
            return (UpdateSource) r27.a.a(UpdateSource.class, r100);
        }

        public static UpdateSource[] values() {
            return (UpdateSource[]) f158533a.clone();
        }

        public UpdateSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
        f158518m = s1.f(55.0f);
        f158519n = s1.f(28.0f);
        f158520o = s1.f(15.0f);
    }

    public final void b(int r100) {
        if (r100 != this.f158523c) goto L5;
        return;
    L5:
        int r101 = a(this, 0, 31);
        int r102 = a(this, r100, 30);
        this.f158523c = r100;
        if (r102 >= r101) goto L8;
        this.f158532l.postDelayed(this.f158530j, 300);
        this.f158529i = true;
        return;
    L8:
        c(UpdateSource.GiftTrayPlayingStateChange);
    }

    public final void c(UpdateSource r100) {
        int r101 = a(this, 0, 31);
        if (r101 == this.f158522b) goto L9;
        Message r102 = Message.obtain();
        r102.what = 1003;
        float r103 = r101;
        if (r101 <= 0) goto L7;
        r103 = r103 + f158520o;
    L7:
        r102.obj = Float.valueOf(r103);
        this.f158532l.sendMessage(r102);
        ALogger.i("MoveDownMaskManager", "Mask changed cause of " + r100.name() + ", old length: " + this.f158522b + ", new length: " + r101);
        this.f158522b = r101;
        this.f158529i = false;
        this.f158527g = false;
        return;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L90;
        String r102 = r101.getKey();
        Object r103 = null;
        switch(r102.hashCode()) {
            case -148972461: goto L61;
            case 449264114: goto L49;
            case 1599126101: goto L37;
            case 1755014242: goto L22;
            case 2018820194: goto L9;
            default: goto L91;
        };
    L91:
        return;
    L9:
        if (r102.equals("cmd_top_gift_tray_busy") == false) goto L76;
        Object r104 = r101.getData();
        if ((r104 instanceof Boolean) == false) goto L14;
        r103 = r104;
    L14:
        Boolean r105 = (Boolean) r103;
        if (r105 != null) goto L17;
        return;
    L17:
        if (r105.booleanValue() == false) goto L19;
        int r106 = this.f158523c | 2;
    L20:
        b(r106);
        return;
    L19:
        r106 = this.f158523c & (-3);
        goto L20
    L76:
        return;
    L22:
        if (r102.equals("cmd_bottom_gift_tray_busy") == false) goto L79;
        Boolean r107 = Boolean.FALSE;
        Object r108 = r101.getData();
        if ((r108 instanceof Boolean) == false) goto L27;
        r103 = r108;
    L27:
        Boolean r109 = (Boolean) r103;
        if (r109 == null) goto L32;
        r107 = r109;
    L32:
        if (r107.booleanValue() == false) goto L34;
        int r110 = this.f158523c | 1;
    L35:
        b(r110);
        return;
    L34:
        r110 = this.f158523c & (-2);
        goto L35
    L79:
        return;
    L37:
        if (r102.equals("data_enter_anim_visiable") == false) goto L81;
        Object r111 = r101.getData();
        if ((r111 instanceof Boolean) == false) goto L42;
        r103 = r111;
    L42:
        Boolean r112 = (Boolean) r103;
        if (r112 == null) goto L82;
        boolean r113 = r112.booleanValue();
        if (this.f158525e == r113) goto L92;
        this.f158525e = r113;
        c(UpdateSource.EnterAnimVisibleStateChange);
        return;
    L92:
        return;
    L82:
        return;
    L81:
        return;
    L49:
        if (r102.equals("data_gift_tray_visiable") == false) goto L84;
        Object r114 = r101.getData();
        if ((r114 instanceof Boolean) == false) goto L54;
        r103 = r114;
    L54:
        Boolean r115 = (Boolean) r103;
        if (r115 == null) goto L85;
        boolean r116 = r115.booleanValue();
        if (this.f158526f == r116) goto L93;
        this.f158526f = r116;
        c(UpdateSource.GiftTrayVisibleStateChange);
        return;
    L93:
        return;
    L85:
        return;
    L84:
        return;
    L61:
        if (r102.equals("data_enter_anim_showing") == false) goto L87;
        Object r117 = r101.getData();
        if ((r117 instanceof Boolean) == false) goto L66;
        r103 = r117;
    L66:
        Boolean r118 = (Boolean) r103;
        if (r118 == null) goto L88;
        boolean r119 = r118.booleanValue();
        if (this.f158524d == r119) goto L94;
        this.f158524d = r119;
        if (r119 == true) goto L74;
        this.f158532l.postDelayed(this.f158528h, 300);
        this.f158527g = true;
        return;
    L74:
        c(UpdateSource.EnterAnimPlayingStateChange);
        return;
    L94:
        return;
    L88:
        return;
    L87:
        return;
    }

    public MoveDownMaskManager(DataCenter r100, WeakHandler r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "mainHandler");
        this.f158531k = r100;
        this.f158532l = r101;
        r100.observe("cmd_bottom_gift_tray_busy", this).observe("cmd_top_gift_tray_busy", this).observe("data_enter_anim_showing", this).observe("data_gift_tray_visiable", this).observe("data_enter_anim_visiable", this);
        this.f158525e = true;
        this.f158526f = true;
        this.f158528h = new b(this);
        this.f158530j = new c(this);
    }

    public static int a(MoveDownMaskManager r100, int r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.f158523c;
    L6:
        if ((r102 & 2) == 0) goto L8;
        boolean r103 = r100.f158526f;
    L10:
        if ((r102 & 4) == 0) goto L12;
        boolean r104 = r100.f158524d;
    L14:
        if ((r102 & 8) == 0) goto L16;
        boolean r105 = r100.f158525e;
    L18:
        if ((r102 & 16) == 0) goto L20;
        int r106 = r100.f158521a;
    L21:
        r100.getClass();
        if (r104 == false) goto L24;
        if (r105 == false) goto L24;
        return r106;
    L24:
        if (r106 == 0) goto L41;
        if (r103 == true) goto L29;
    L34:
        int r107 = 0;
    L39:
        return RangesKt.coerceAtLeast(r107, 0);
    L29:
        if (r101 != 1) goto L31;
    L36:
        int r108 = f158519n;
    L37:
        r107 = r106 - r108;
        goto L39
    L31:
        if (r101 != 2) goto L33;
        r106 = r106 - f158519n;
        r108 = f158518m;
        goto L37
    L33:
        if (r101 == 3) goto L36;
    L41:
        return r106;
    L20:
        r106 = 0;
        goto L21
    L16:
        r105 = false;
        goto L18
    L12:
        r104 = false;
        goto L14
    L8:
        r103 = false;
        goto L10
    }
}

package com.bytedance.android.livesdk.interactivity.roomintro.v2;

import android.text.Editable;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.interactivity.api.roomintro.api.IntroGuideButton;
import com.bytedance.android.livesdk.interactivity.api.roomintro.api.LabelGroup;
import com.bytedance.android.livesdk.q2;
import com.bytedance.android.livesdk.widget.TextCorrectionEditText;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.common.utility.UIUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes9.dex */
public final class RoomIntroDataSource {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a f140574x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f140575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f140576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.a f140577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PropertyOwner<sh6.b<Unit>> f140578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PropertyOwner<sh6.b<Integer>> f140579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PropertyOwner f140580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PropertyOwner f140581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PropertyOwner<Unit> f140582h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PropertyOwner f140583i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PropertyOwner f140584j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PropertyOwner f140585k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PropertyOwner f140586l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PropertyOwner f140587m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f140588n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.api.roomintro.api.b f140589o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<LabelGroup> f140590p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<RoomIntroLabel> f140591q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<IntroGuideButton> f140592r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final PropertyOwner<List<RoomIntroLabel>> f140593s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final PropertyOwner<Integer> f140594t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final PropertyOwner<Boolean> f140595u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final PropertyOwner<Boolean> f140596v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final PropertyOwner<gz.b> f140597w;

    public static final class a {
        public a() {
        }

        public static boolean a() {
            return q2.f156875a.getValue().a();
        }
    }

    static {
        f140574x = new a();
    }

    public final String a() {
        com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.a r100 = this.f140577c;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (UIUtils.isViewVisible(r100.f140606c) == false) goto L11;
        TextCorrectionEditText r101 = r100.f140606c;
        if (r101 == null) goto L15;
        Editable r102 = r101.getText();
        if (r102 == null) goto L16;
        String r103 = r102.toString();
    L13:
        return r103;
    L16:
        return null;
    L15:
        return null;
    L11:
        r103 = r100.f140604a;
        goto L13
    }

    public RoomIntroDataSource(c r100, com.bytedance.android.livesdk.interactivity.api.roomintro.api.b r101, List r102, List r103, List r104, PropertyOwner r105, PropertyOwner r106, PropertyOwner r107, PropertyOwner r108, PropertyOwner r110) {
        this.f140588n = r100;
        this.f140589o = r101;
        this.f140590p = r102;
        this.f140591q = r103;
        this.f140592r = r104;
        this.f140593s = r105;
        this.f140594t = r106;
        this.f140595u = r107;
        this.f140596v = r108;
        this.f140597w = r110;
        this.f140575a = LazyKt.lazy(RoomIntroDataSource$customConfig$2.INSTANCE);
        this.f140576b = LazyKt.lazy(RoomIntroDataSource$appointmentConfig$2.INSTANCE);
        sh6.a r109 = sh6.a.f541970a;
        this.f140578d = new PropertyOwner(r109);
        PropertyOwner<sh6.b<Integer>> r111 = new PropertyOwner(r109);
        this.f140579e = r111;
        this.f140580f = r111;
        this.f140581g = r105;
        PropertyOwner<Unit> r112 = new PropertyOwner(Unit.INSTANCE);
        this.f140582h = r112;
        this.f140583i = r112;
        this.f140584j = r106;
        if (r107 != null) goto L6;
        r107 = null;
    L6:
        this.f140585k = r107;
        if (r108 != null) goto L10;
        r108 = null;
    L10:
        this.f140586l = r108;
        if (r110 != null) goto L14;
        r110 = null;
    L14:
        this.f140587m = r110;
    }
}

package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.linkbase.api.SeatItemId;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import nh0.c;
import py.k;
import tf0.d;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.a<MultiLinkNormalEmptyViewBinder.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IVoiceLiveTheme f75669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f75670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f75671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f75672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k f75673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f75674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f75675h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f75676i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageView f75677j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f75678k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ImageView f75679l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f75680m;

    public static final class a {
    }

    static {
    }

    public final c b() {
        MultiLinkNormalEmptyViewBinder.a r100 = (MultiLinkNormalEmptyViewBinder.a) this.f75668a;
        d r101 = null;
        if (r100 == null) goto L7;
        HashMap<String, d> r102 = r100.f545693i;
        if (r102 == null) goto L7;
        d r103 = r102.get(SeatItemId.EMPTY_INFO.name());
    L9:
        if ((r103 instanceof c) == false) goto L13;
        r101 = r103;
    L13:
        return (c) r101;
    L7:
        r103 = null;
        goto L9
    }

    public final String c() {
        return this.f75678k.getText().toString();
    }

    public final boolean a() {
        if (b() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void h() {
        c r100 = b();
        if (r100 != null) goto L5;
        k r101 = this.f75673f;
        if (r101 == null) goto L25;
        this.f75673f = r101;
        if (a() == false) goto L27;
        ImageUtil.loadImage(this.f75677j, r101, 0);
    L27:
        if (this.f75680m == false) goto L29;
        int r102 = this.f75671d;
        ViewGroup.LayoutParams r103 = this.f75677j.getLayoutParams();
        r103.width = r102;
        r103.height = r102;
        this.f75677j.setLayoutParams(r103);
    L29:
        g(this.f75670c);
        Integer r104 = this.f75675h;
        if (r104 == null) goto L34;
        Intrinsics.checkNotNull(r104);
        int r105 = r104.intValue();
        this.f75675h = Integer.valueOf(r105);
        ImageView r106 = this.f75679l;
        if (r106 == null) goto L39;
        r106.setBackgroundResource(r105);
    L39:
        this.f75678k.setTextColor(this.f75676i);
        IVoiceLiveTheme r107 = this.f75669b;
        if (r107 == null) goto L45;
        f(r107);
        return;
    L45:
        return;
    L34:
        int r108 = this.f75674g;
        this.f75674g = r108;
        if (a() == false) goto L39;
        ImageView r109 = this.f75679l;
        if (r109 == null) goto L39;
        r109.setBackgroundColor(r108);
        goto L39
    L25:
        d(this.f75672e);
        goto L27
    L5:
        if (TextUtils.isEmpty(r100.h()) == true) goto L8;
        this.f75678k.setText(r100.h());
    L8:
        if (TextUtils.isEmpty(r100.i()) == true) goto L13;
        ImageView r110 = this.f75677j;
        int r111 = qy.a.f535172a;
        ImageUtil.loadImage(r110, qy.a.a(r100.i()), 0);
        if (this.f75680m == false) goto L13;
        int r112 = this.f75671d / 2;
        ViewGroup.LayoutParams r113 = this.f75677j.getLayoutParams();
        r113.width = r112;
        r113.height = r112;
        this.f75677j.setLayoutParams(r113);
    L13:
        if (TextUtils.isEmpty(r100.g()) == true) goto L18;
        ImageView r114 = this.f75679l;
        if (r114 == null) goto L18;
        r114.setBackgroundColor(ColorProtector.parseColor(r100.g()));
    L18:
        if (TextUtils.isEmpty(r100.j()) == true) goto L43;
        this.f75678k.setTextColor(ColorProtector.parseColor(r100.j()));
        return;
    }

    public final void d(int r100) {
        this.f75672e = r100;
        if (a() == false) goto L6;
        this.f75677j.setImageResource(r100);
        return;
    }

    public final void e(int r100) {
        this.f75677j.setVisibility(r100);
    }

    public final void f(IVoiceLiveTheme r100) {
        this.f75669b = r100;
        if (a() == false) goto L39;
        MultiLinkNormalEmptyViewBinder.a r101 = (MultiLinkNormalEmptyViewBinder.a) this.f75668a;
        if (r101 == null) goto L7;
        int r102 = r101.b();
    L8:
        boolean r103 = false;
        if (r102 < 0) goto L25;
        if (r100 == null) goto L14;
        List<k> r104 = r100.getIconMicNormals();
        if (r104 == null) goto L14;
        int r105 = r104.size();
    L15:
        if (r102 >= r105) goto L25;
        if (r100 == null) goto L20;
        List<k> r106 = r100.getIconMicNormals();
        if (r106 == null) goto L20;
        k r107 = (k) ListProtector.get(r106, r102);
    L22:
        if (IVoiceLiveTheme.Companion.isImageModelValid(r107) == false) goto L25;
        if (r107 == null) goto L25;
        ImageUtil.loadImage(this.f75677j, r107, 0);
    L20:
        r107 = null;
    L14:
        r105 = 0;
    L25:
        if (r100 == null) goto L35;
        String r108 = r100.getColorMicText();
        if (r108 == null) goto L35;
        if (r108.length() <= 0) goto L31;
        r103 = true;
    L31:
        if (r103 != true) goto L35;
        this.f75678k.setTextColor(Color.parseColor(r100.getColorMicText()));     // Catch: Exception -> L34
        return;
    L34:
        ALogger.e("LinkSeatEmptyElement", "set color mic failed, color is " + r100.getColorMicText());
        return;
    L35:
        this.f75678k.setTextColor(this.f75676i);
        return;
    L7:
        r102 = -1;
        goto L8
    }

    public final void g(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f75670c = r100;
        if (a() == false) goto L8;
        this.f75678k.setText(r100);
        return;
    }

    public b(ImageView r100, TextView r101, ImageView r102, int r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "emptyAvatarIv");
        Intrinsics.checkNotNullParameter(r101, "emptyTipsTv");
        this.f75677j = r100;
        this.f75678k = r101;
        this.f75679l = r102;
        this.f75680m = r104;
        this.f75670c = s1.B(R.string.ttlive_live_radio_interact_waiting);
        this.f75671d = s1.j(R.dimen.ttlive_voice_chat_guest_seat_avatar_size);
        this.f75672e = r103;
        this.f75674g = ColorProtector.parseColor("#1AFFFFFF");
        this.f75676i = ColorProtector.parseColor("#87FFFFFF");
    }
}

package com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter;

import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.layout.WrapLineFlowLayout;
import com.bytedance.android.livesdk.config.gr0;
import com.bytedance.android.livesdk.interactivity.api.roomintro.api.IntroGuideButton;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.RoomIntroDataSource;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.TextCorrectionEditText;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f140603f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f140604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoomIntroDataSource f140605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextCorrectionEditText f140606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f140607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f140608e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.a$a, reason: collision with other inner class name */
    public static final class C2232a {
    }

    static {
    }

    public final int b() {
        return ((com.bytedance.android.livesdk.interactivity.api.settings.config.d) this.f140605b.f140575a.getValue()).a();
    }

    public final void c() {
        boolean r100 = true;
        if (gr0.f120309a.getValue().booleanValue() == false) goto L15;
        TextCorrectionEditText r101 = this.f140606c;
        if (r101 == null) goto L15;
        r101.setListener(new h(this));
        r101.setPopDown(false);
        r101.setAdjustSize(true);
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r102 = this.f140605b.f140588n;
        if (r102 == null) goto L9;
        String r103 = r102.c();
    L10:
        r101.setLiveType(r103);
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r104 = this.f140605b.f140588n;
        if (r104 == null) goto L13;
        String r105 = r104.a();
    L14:
        r101.setCurrentUserId(r105);
        r101.addTextChangedListener(new i(r101, this));
        goto L15
    L13:
        r105 = null;
        goto L14
    L9:
        r103 = null;
    L15:
        TextView r106 = this.f140607d;
        if (r106 == null) goto L18;
        UtilityKotlinExtentionsKt.w(r106);
    L18:
        TextCorrectionEditText r107 = this.f140606c;
        if (r107 == null) goto L21;
        UtilityKotlinExtentionsKt.t(r107);
    L21:
        TextCorrectionEditText r108 = this.f140606c;
        if (r108 == null) goto L24;
        r108.addTextChangedListener(new e(this));
    L24:
        TextCorrectionEditText r109 = this.f140606c;
        if (r109 == null) goto L27;
        r109.setOnEditorActionListener(f.f140613a);
    L27:
        String r110 = this.f140605b.f140589o.e();
        if (r110 != null) goto L30;
    L33:
        if (r100 == true) goto L35;
        d(this.f140605b.f140589o.e(), false);
    L35:
        TextView r111 = this.f140607d;
        if (r111 == null) goto L38;
        r111.setText(this.f140604a);
    L38:
        TextView r112 = this.f140607d;
        if (r112 == null) goto L41;
        r112.setHint(((com.bytedance.android.livesdk.interactivity.api.settings.config.d) this.f140605b.f140575a.getValue()).e());
    L41:
        TextCorrectionEditText r113 = this.f140606c;
        if (r113 == null) goto L44;
        r113.setHint(((com.bytedance.android.livesdk.interactivity.api.settings.config.d) this.f140605b.f140575a.getValue()).e());
    L44:
        TextView r114 = this.f140607d;
        if (r114 == null) goto L47;
        r114.setOnClickListener(new g(this));
    L47:
        List<IntroGuideButton> r115 = this.f140605b.f140592r;
        if (r115 == null) goto L70;
        Iterator<T> r116 = r115.iterator();
    L51:
        if (r116.hasNext() == false) goto L78;
        final IntroGuideButton r117 = (IntroGuideButton) r116.next();
        ViewGroup r118 = this.f140608e;
        if (r118 == null) goto L64;
        Context r119 = r118.getContext();
        if (r119 == null) goto L64;
        View r120 = LayoutInflater.from(r119).inflate(R.layout.ttlive_guide_button_layout, this.f140608e, false);
        if (r120 == null) goto L62;
        TextView r121 = (TextView) r120.findViewById(R.id.guide_button_text);
        if (r121 == null) goto L62;
        r121.setText(r117.getButtonText());
    L62:
        if (r120 == null) goto L65;
        r120.setOnClickListener(x0.a(new RoomIntroEditViewAdapter$createGuideButton$2(this, r117)));
    L65:
        if (r120 == null) goto L51;
        ViewGroup r122 = this.f140608e;
        if (r122 == null) goto L51;
        r122.addView(r120);
    L64:
        r120 = null;
        goto L65
    L78:
        return;
    L70:
        return;
    L30:
        if (r110.length() == 0) goto L33;
        r100 = false;
        goto L33
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        String r101 = "";
        if (UIUtils.isViewVisible(this.f140606c) == false) goto L18;
        TextCorrectionEditText r102 = this.f140606c;
        if (r102 == null) goto L12;
        Editable r103 = r102.getText();
        if (r103 == null) goto L12;
        String r104 = r103.toString();
        if (r104 == null) goto L12;
        r101 = r104;
    L12:
        String r105 = r101.concat(r100);
        TextCorrectionEditText r106 = this.f140606c;
        if (r106 == null) goto L15;
        r106.setText(r105);
    L15:
        TextCorrectionEditText r107 = this.f140606c;
        if (r107 == null) goto L33;
        r107.setSelection(RangesKt.coerceAtMost(r105.length(), b()));
        return;
    L33:
        return;
    L18:
        String r108 = this.f140604a;
        if (r108 == null) goto L22;
        r101 = r108;
    L22:
        boolean r109 = true;
        d(r101.concat(r100), true);
        String r110 = this.f140604a;
        if (r110 != null) goto L25;
    L28:
        if (r109 == true) goto L35;
        TextView r111 = this.f140607d;
        if (r111 == null) goto L36;
        r111.setText(this.f140604a);
        return;
    L36:
        return;
    L35:
        return;
    L25:
        if (r110.length() == 0) goto L28;
        r109 = false;
        goto L28
    }

    public final void d(String r100, boolean r101) {
        if (r101 == true) goto L5;
        this.f140604a = r100;
        return;
    L5:
        int r102 = b();
        if (r100 != null) goto L8;
    L11:
        this.f140604a = r100;
        return;
    L8:
        if (r100.length() <= r102) goto L11;
        this.f140604a = r100.substring(0, r102);
        f2.c(s1.C(R.string.ttlive_live_room_intro_update_max_v2, new Object[]{Integer.valueOf(r102)}), 0);
    }

    public a(RoomIntroDataSource r100, TextCorrectionEditText r101, TextView r102, WrapLineFlowLayout r103) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        this.f140605b = r100;
        this.f140606c = r101;
        this.f140607d = r102;
        this.f140608e = r103;
    }
}

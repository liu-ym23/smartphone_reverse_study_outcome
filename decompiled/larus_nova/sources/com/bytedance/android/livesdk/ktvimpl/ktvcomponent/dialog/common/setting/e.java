package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.t3;
import com.bytedance.android.livesdk.utils.x0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f144121f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f144122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f144123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f144124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f144125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f144126e;

    private final Switch getSwitchButton() {
        return (Switch) this.f144124c.getValue();
    }

    private final FrameLayout getSwitchButtonContainer() {
        return (FrameLayout) this.f144125d.getValue();
    }

    private final TextView getSwitchContent() {
        return (TextView) this.f144122a.getValue();
    }

    private final ImageView getSwitchRule() {
        return (ImageView) this.f144123b.getValue();
    }

    public final void b() {
        c(getSwitchRule(), 0);
    }

    public static final /* synthetic */ Switch a(e r100) {
        return r100.getSwitchButton();
    }

    public e(c r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "kSongSwitchView");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        CharSequence r102 = null;
        super(r101, null, 0);
        this.f144126e = r100;
        this.f144122a = LazyKt.lazy(new KSongSwitchView$switchContent$2(this));
        this.f144123b = LazyKt.lazy(new KSongSwitchView$switchRule$2(this));
        this.f144124c = LazyKt.lazy(new KSongSwitchView$switchButton$2(this));
        this.f144125d = LazyKt.lazy(new KSongSwitchView$switchButtonContainer$2(this));
        LayoutInflater.from(r101).inflate(R.layout.ttlive_dialog_ksong_common_switch_layout, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, s1.f(52.0f)));
        Switch r103 = getSwitchButton();
        if (r103 == null) goto L5;
        r103.setChecked(r100.b());
    L5:
        FrameLayout r104 = getSwitchButtonContainer();
        if (r104 == null) goto L8;
        r104.setOnClickListener(x0.a(new KSongSwitchView$1(this)));
    L8:
        ImageView r105 = getSwitchRule();
        if (r105 == null) goto L11;
        r105.setOnClickListener(x0.a(new KSongSwitchView$2(this)));
    L11:
        TextView r106 = getSwitchContent();
        if (r106 == null) goto L14;
        r106.setClickable(true);
    L14:
        FrameLayout r107 = getSwitchButtonContainer();
        if (r107 == null) goto L17;
        r107.setClickable(true);
    L17:
        TextView r108 = getSwitchContent();
        if (r108 == null) goto L20;
        r108.setText(r100.a());
    L20:
        TextView r109 = getSwitchContent();
        TextView r110 = getSwitchContent();
        if (r110 == null) goto L23;
        r102 = r110.getText();
    L23:
        r3.a(r109, String.valueOf(r102));
    }

    public static void c(View r100, int r101) {
        if (r101 != 0) goto L4;
        if (r100 == null) goto L19;
        r100.setVisibility(0);
        return;
    L19:
        return;
    L4:
        if (r101 != 4) goto L6;
        if (r100 == null) goto L17;
        r100.setVisibility(4);
        return;
    L17:
        return;
    L6:
        if (r101 != 8) goto L20;
        if (r100 == null) goto L15;
        r100.setVisibility(8);
        return;
    L15:
        return;
    }

    public final void d(boolean r100, boolean r101) {
        Switch r102 = getSwitchButton();
        if (r102 != null) goto L5;
    L6:
        Switch r103 = getSwitchButton();
        if (r103 == null) goto L9;
        r103.setChecked(r100);
    L9:
        if (r101 == false) goto L15;
        int r104 = r3.f156924a;
        FrameLayout r105 = getSwitchButtonContainer();
        if (r105 == null) goto L16;
        r105.postDelayed(new t3(r105), 100);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (r102.isChecked() != r100) goto L6;
    }
}

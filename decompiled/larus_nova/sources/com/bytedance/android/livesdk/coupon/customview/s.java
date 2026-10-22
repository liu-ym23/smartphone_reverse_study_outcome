package com.bytedance.android.livesdk.coupon.customview;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.utils.p6;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class s extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f121865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f121866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f121867c;

    public interface a {
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        com.bytedance.android.livesdk.f.d().a();
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        com.bytedance.android.livesdk.f.d().f();
    }

    public s(Context r100, com.bytedance.android.livesdk.coupon.b.c r110, com.bytedance.android.livesdk.coupon.f r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "callback");
        super(r100, R.style.ttlive_ug_coupon_dialog);
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_ug_coupon_remain_layout, null);
        this.f121865a = r101;
        HSImageView r102 = (HSImageView) r101.findViewById(R.id.ttlive_ug_coupon_remain_icon);
        FrameLayout r103 = (FrameLayout) r101.findViewById(R.id.ttlive_ug_coupon_remain_close);
        this.f121866b = r103;
        TextView r104 = (TextView) r101.findViewById(R.id.ttlive_ug_coupon_remain_title);
        TextView r105 = (TextView) r101.findViewById(R.id.ttlive_ug_coupon_remain_desc);
        FrameLayout r106 = (FrameLayout) r101.findViewById(R.id.ttlive_ug_coupon_remain_confirm);
        this.f121867c = r106;
        TextView r107 = (TextView) r101.findViewById(R.id.ttlive_ug_coupon_remain_refuse);
        TextView r108 = (TextView) r101.findViewById(R.id.ttlive_ug_coupon_remain_coupon_value);
        TextView r109 = (TextView) r101.findViewById(R.id.ttlive_ug_coupon_remain_coupon_expired);
        setContentView(r101);
        r106.setOnClickListener(new p(this, r111, r110));
        r107.setOnClickListener(new q(this, r111));
        r103.setOnClickListener(new r(this, r111));
        String r112 = r110.icon;
        if (r112 != null) goto L5;
    L8:
        boolean r113 = true;
    L9:
        if (r113 == true) goto L11;
        ImageLoader.bindImage(r102, r110.icon);
    L11:
        String r114 = r110.title;
        if (r114 != null) goto L14;
    L17:
        boolean r115 = true;
    L18:
        if (r115 == true) goto L20;
        r104.setText(r110.title);
    L20:
        String r116 = r110.description;
        if (r116 != null) goto L23;
    L26:
        boolean r117 = true;
    L27:
        if (r117 == true) goto L29;
        r105.setText(r110.description);
    L29:
        double r118 = r110.credit / ((double) 100);
        if (Double.valueOf(r118 % ((double) 1)).equals(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)) == false) goto L32;
        String r119 = String.valueOf((int) r118);
    L33:
        r108.setText(r119);
        r109.setText(LiveResUtil.getString(R.string.ttlive_ug_coupon_remain_coupon_threshold, new Object[]{p6.f159120a.format(new Date(r110.expireTimestamp * ((long) 1000)))}));
        return;
    L32:
        r119 = String.valueOf(r118);
        goto L33
    L23:
        if (r116.length() == 0) goto L26;
        r117 = false;
        goto L27
    L14:
        if (r114.length() == 0) goto L17;
        r115 = false;
        goto L18
    L5:
        if (r112.length() == 0) goto L8;
        r113 = false;
        goto L9
    }
}

package com.bytedance.android.livesdk.dislike.layout;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.livesdk.sharedpref.e;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nt1.c;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/layout/OptionDescItemLayoutV2;", "Landroid/widget/LinearLayout;", "Lnt1/c;", "vo", "", "update", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OptionDescItemLayoutV2 extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f122142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f122143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f122144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f122145d;

    public static final class a {
    }

    static {
    }

    public OptionDescItemLayoutV2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f122145d = "";
        View.inflate(getContext(), R.layout.ttlive_dialog_long_press_option_desc, this);
        setOrientation(1);
        setGravity(17);
        TextView r101 = (TextView) findViewById(R.id.desc);
        this.f122142a = r101;
        this.f122143b = (ImageView) findViewById(R.id.icon);
        this.f122144c = (ImageView) findViewById(R.id.iv_red_dot);
        if (r101 == null) goto L7;
        TextPaint r102 = r101.getPaint();
        if (r102 == null) goto L7;
        r102.setFakeBoldText(true);
    L7:
        setBackgroundResource(R.drawable.ttlive_bg_long_press_option_item);
    }

    public final void update(c r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        ImageModel r101 = r100.f520473g;
        if (r101 == null) goto L5;
        ImageUtil.loadImage(this.f122143b, r101, 0);
    L8:
        TextView r102 = this.f122142a;
        if (r102 != null) goto L51;
    L14:
        String r103 = r100.f520469c;
        boolean r104 = true;
        if (r103 != null) goto L17;
    L24:
        TextView r105 = this.f122142a;
        if (r105 == null) goto L53;
        CharSequence r106 = r105.getText();
        if (r106 == null) goto L54;
        String r107 = r106.toString();
        if (r107 != null) goto L32;
        return;
    L32:
        if (r100.f520472f == false) goto L34;
    L39:
        if (r104 == false) goto L44;
        ImageView r108 = this.f122144c;
        if (r108 == null) goto L43;
        r108.setVisibility(0);
    L43:
        this.f122145d = r107;
    L48:
        if (r100.f520471e == false) goto L55;
        setVisibility(4);
        return;
    L55:
        return;
    L44:
        ImageView r109 = this.f122144c;
        if (r109 == null) goto L48;
        r109.setVisibility(8);
        goto L48
    L34:
        if (r100.f520470d == false) goto L38;
        String r110 = "long_press_dot_".concat(r107);
        Boolean r111 = Boolean.FALSE;
        if (Intrinsics.areEqual((Boolean) new e(r110, r111).getValue(), r111) == true) goto L39;
    L38:
        r104 = false;
        goto L39
    L54:
        return;
    L53:
        return;
    L17:
        if (r103.length() <= 0) goto L19;
        boolean r112 = true;
    L20:
        if (r112 != true) goto L24;
        TextView r113 = this.f122142a;
        if (r113 == null) goto L24;
        r113.setText(r100.f520469c);
        goto L24
    L19:
        r112 = false;
        goto L20
    L51:
        CharSequence r114 = getContext().getResources().getText(r100.f520468b);     // Catch: Exception -> L12
    L13:
        r102.setText(r114);
    L12:
        r114 = "";
        goto L13
    L5:
        ImageView r115 = this.f122143b;
        if (r115 == null) goto L8;
        r115.setImageResource(r100.f520467a);
        goto L8
    }

    public OptionDescItemLayoutV2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f122145d = "";
        View.inflate(getContext(), R.layout.ttlive_dialog_long_press_option_desc, this);
        setOrientation(1);
        setGravity(17);
        TextView r102 = (TextView) findViewById(R.id.desc);
        this.f122142a = r102;
        this.f122143b = (ImageView) findViewById(R.id.icon);
        this.f122144c = (ImageView) findViewById(R.id.iv_red_dot);
        if (r102 == null) goto L7;
        TextPaint r103 = r102.getPaint();
        if (r103 == null) goto L7;
        r103.setFakeBoldText(true);
    L7:
        setBackgroundResource(R.drawable.ttlive_bg_long_press_option_item);
    }

    public OptionDescItemLayoutV2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f122145d = "";
        View.inflate(getContext(), R.layout.ttlive_dialog_long_press_option_desc, this);
        setOrientation(1);
        setGravity(17);
        TextView r103 = (TextView) findViewById(R.id.desc);
        this.f122142a = r103;
        this.f122143b = (ImageView) findViewById(R.id.icon);
        this.f122144c = (ImageView) findViewById(R.id.iv_red_dot);
        if (r103 == null) goto L7;
        TextPaint r104 = r103.getPaint();
        if (r104 == null) goto L7;
        r104.setFakeBoldText(true);
    L7:
        setBackgroundResource(R.drawable.ttlive_bg_long_press_option_item);
    }
}

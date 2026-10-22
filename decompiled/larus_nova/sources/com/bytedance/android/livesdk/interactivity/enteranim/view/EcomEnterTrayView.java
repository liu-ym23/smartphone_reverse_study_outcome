package com.bytedance.android.livesdk.interactivity.enteranim.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public class EcomEnterTrayView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f136827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f136828b;

    public EcomEnterTrayView(Context r100) {
        this(r100, null);
    }

    private void setEcomIcon(k32.b r100) {
        if (TextUtils.isEmpty(r100.f501704u) == false) goto L5;
        this.f136828b.setImageResource(R.drawable.ttlive_icon_ecom_barrage_douyin);
        return;
    L5:
        ImageLoader.bindImage(this.f136828b, r100.f501704u);
    }

    private void setTextContent(k32.b r110) {
        if (TextUtils.isEmpty(r110.f501689f) == false) goto L5;
        String r100 = getContext().getString(R.string.ttlive_ecom_go_shopping);
    L6:
        long r101 = r110.f501703t;
        if (r101 != 1) goto L9;
        String r111 = getContext().getString(R.string.ttlive_ecom_shopping_barrage_simple, new Object[]{r110.f501685b, r100});
    L10:
        this.f136827a.setText(r111);
        return;
    L9:
        String r102 = IESUIUtils.getDisplayCount(r101, "w");
        r111 = getContext().getString(R.string.ttlive_ecom_shopping_barrage, new Object[]{r110.f501685b, r102, r100});
        goto L10
    L5:
        r100 = r110.f501689f;
        goto L6
    }

    public final void a(k32.b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        setTextContent(r100);
        setEcomIcon(r100);
        setBackgroundResource(R.drawable.ttlive_bg_ecom_barrage);
    }

    public EcomEnterTrayView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public EcomEnterTrayView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LinearLayout.inflate(getContext(), R.layout.ttlive_ecom_tray_view, this);
        this.f136827a = (TextView) findViewById(R.id.tv_ecom_content);
        this.f136828b = (HSImageView) findViewById(R.id.iv_ecom_icon);
        setGravity(16);
    }
}

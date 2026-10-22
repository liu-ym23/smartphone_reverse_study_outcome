package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.topbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public class FastGiftDialogHintView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f126958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f126959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f126960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CheckBox f126961d;

    public FastGiftDialogHintView(Context r100) {
        this(r100, null);
    }

    public FastGiftDialogHintView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public FastGiftDialogHintView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_fast_gift_dialog_layout, this);
        this.f126958a = (TextView) findViewById(R.id.center_title);
        this.f126959b = (TextView) findViewById(R.id.center_content);
        this.f126960c = (TextView) findViewById(R.id.center_checked_text);
        this.f126961d = (CheckBox) findViewById(R.id.center_checkbox);
    }
}

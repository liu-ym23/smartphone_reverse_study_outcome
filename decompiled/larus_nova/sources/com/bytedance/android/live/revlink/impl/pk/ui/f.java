package com.bytedance.android.live.revlink.impl.pk.ui;

import android.view.View;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f97035a;

    public f(g r100) {
        this.f97035a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ((AppCompatRadioButton) this.f97035a.a(R.id.rb)).setChecked(!((AppCompatRadioButton) this.f97035a.a(R.id.rb)).isChecked());
    }
}

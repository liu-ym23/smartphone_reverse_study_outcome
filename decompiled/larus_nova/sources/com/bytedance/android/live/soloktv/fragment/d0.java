package com.bytedance.android.live.soloktv.fragment;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.soloktv.view.SoloKtvAlignVoiceView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class d0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoloKtvEditFragment f101206a;

    public d0(SoloKtvEditFragment r100) {
        this.f101206a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        SoloKtvEditFragment r101 = this.f101206a;
        int r102 = ((Integer) r100).intValue();
        SoloKtvAlignVoiceView r103 = r101.f101152f;
        if (r103 == null) goto L5;
        r103.setCurrentAlign(r102);
    L5:
        if (r102 != 0) goto L9;
        TextView r104 = r101.f101155i;
        if (r104 == null) goto L20;
        r104.setVisibility(4);
        return;
    L20:
        return;
    L9:
        TextView r105 = r101.f101155i;
        if (r105 == null) goto L13;
        r105.setVisibility(0);
    L13:
        if (r102 <= 0) goto L15;
        String r106 = s1.C(R.string.ttlive_solo_ktv_edit_voice_align_advance_txt, new Object[]{Integer.valueOf(Math.abs(r102))});
    L16:
        TextView r107 = r101.f101155i;
        if (r107 == null) goto L22;
        r107.setText(r106);
        return;
    L22:
        return;
    L15:
        r106 = s1.C(R.string.ttlive_solo_ktv_edit_voice_align_delay_txt, new Object[]{Integer.valueOf(Math.abs(r102))});
        goto L16
    }
}

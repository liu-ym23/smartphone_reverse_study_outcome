package com.bytedance.android.live.soloktv.view;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FragmentSelectView f101839a;

    public l(FragmentSelectView r100) {
        this.f101839a = r100;
    }

    public final void a() {
        FragmentSelectView r100 = this.f101839a;
        TextView r101 = r100.f101673c;
        if (r101 == null) goto L5;
        r101.setText(s1.C(R.string.ttlive_solo_ktv_fragment_select_start_index_str, new Object[]{r100.f101685o.format(Long.valueOf(r100.f101678h))}));
    L5:
        FragmentSelectView r102 = this.f101839a;
        TextView r103 = r102.f101674d;
        if (r103 == null) goto L9;
        r103.setText(s1.C(R.string.ttlive_solo_ktv_fragment_select_end_index_str, new Object[]{r102.f101685o.format(Long.valueOf(r102.f101679i))}));
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

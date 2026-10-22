package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f93487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public yo2.d<?> f93488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f93489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f93490d;

    public static CharSequence a() {
        b51.b r100 = b51.b.f17721c0;
        if (r100.a().length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return r100.a();
    L9:
        return s1.B(R.string.ttlive_interact_anchor_rank_pk);
    L5:
        r101 = false;
        goto L6
    }

    public f0() {
        this.f93490d = true;
    }
}

package com.bytedance.android.live.room.navi.userinfo_p.element;

import androidx.core.view.accessibility.AccessibilityManagerCompat;
import com.bytedance.android.livesdk.r3;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements AccessibilityManagerCompat.TouchExplorationStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserInfoBasicElement f99898a;

    public d(UserInfoBasicElement r100) {
        this.f99898a = r100;
    }

    @Override // androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean r100) {
        if (r100 == false) goto L5;
        r3.p(this.f99898a.f99841i);
        return;
    }
}

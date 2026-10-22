package com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager;

import com.bytedance.live.datacontext.m;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: classes9.dex */
public interface a {
    PublishSubject<j> getRedDotStatus();

    m<com.bytedance.android.livesdk.interactivity.api.base.d> getState();

    void resetPage(PublicScreenAreaPageChangeSource r100);

    void tryAutoPositionToPage();

    void tryChangePage(PublicScreenAreaPageType r100, long r101, PublicScreenAreaPageChangeSource r102);
}

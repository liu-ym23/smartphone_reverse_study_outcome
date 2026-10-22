package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f72755a;

    public p(o r100) {
        this.f72755a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        c r101 = (c) r100;
        o r102 = this.f72755a;
        VideoShowMode r103 = r101.f72711a;
        DigitAvatarContext r104 = DigitAvatarContext.Companion.getContext();
        if (r104 == null) goto L7;
        boolean r105 = true;
        if (r104.getSkipFrequencyCheck() != true) goto L7;
    L8:
        r101.getClass();
        VideoShowMode r106 = r102.f72742l;
        if (r106 == r103) goto L12;
        r102.c(r106);
        r102.f72742l = r103;
        r102.e(r103, r105, null, "on showmode update");
        return;
    L12:
        return;
    L7:
        r105 = false;
        goto L8
    }
}

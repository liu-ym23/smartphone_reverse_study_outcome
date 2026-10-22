package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.adapter.AudiencePortraitSettingAdapter;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceExperienceSettingDialog f116279a;

    public b(AudienceExperienceSettingDialog r100) {
        this.f116279a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        if (r101.intValue() <= 0) goto L7;
        AudiencePortraitSettingAdapter<? extends np1.b> r102 = this.f116279a.C;
        if (r102 == null) goto L11;
        r102.notifyItemChanged(r101.intValue());
        return;
    L11:
        return;
    L7:
        AudiencePortraitSettingAdapter<? extends np1.b> r103 = this.f116279a.C;
        if (r103 == null) goto L13;
        r103.notifyDataSetChanged();
        return;
    }
}

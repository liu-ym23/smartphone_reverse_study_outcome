package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol;

import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f144275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f144276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f144277c;

    public final void a() {
        ChorusContext.a r100 = ChorusContext.Companion;
        if (r100.c() == false) goto L8;
        ChorusContext r101 = r100.getContext();
        if (r101 == null) goto L7;
        List<MusicPanel> r102 = r101.getChorusNotSelfSeeingMusicList();
    L9:
        if (r102 != null) goto L11;
    L18:
        ImageView r103 = this.f144275a;
        if (r103 == null) goto L21;
        r103.setAlpha(1.0f);
    L21:
        ImageView r104 = this.f144275a;
        if (r104 == null) goto L27;
        r104.setTag(Boolean.TRUE);
        return;
    L27:
        return;
    L11:
        if (r102.isEmpty() != true) goto L18;
        ImageView r105 = this.f144275a;
        if (r105 == null) goto L15;
        r105.setAlpha(0.5f);
    L15:
        ImageView r106 = this.f144275a;
        if (r106 == null) goto L25;
        r106.setTag(Boolean.FALSE);
        return;
    L25:
        return;
    L7:
        r102 = null;
        goto L9
    L8:
        KtvContext.Companion.getClass();
        r102 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.c(KtvContext.a.g());
        goto L9
    }

    public l(LifecycleOwner r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "requestPage");
        this.f144276b = r100;
        this.f144277c = r101;
    }
}

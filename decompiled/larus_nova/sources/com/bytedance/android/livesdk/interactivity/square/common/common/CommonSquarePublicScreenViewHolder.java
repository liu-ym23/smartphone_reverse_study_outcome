package com.bytedance.android.livesdk.interactivity.square.common.common;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.base.AbsPublicScreenMessageViewHolder;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import g52.e;
import h52.c;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/square/common/common/CommonSquarePublicScreenViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/base/AbsPublicScreenMessageViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonSquarePublicScreenViewHolder extends AbsPublicScreenMessageViewHolder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k<c> f141133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f141134g;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.base.AbsPublicScreenMessageViewHolder
    public final void T3(c r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        NoMoreSpaceTextView r101 = this.f133724d;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setTag(R.id.ttlive_tag_public_screen_model, r100);
        r101.setAlpha(1.0f);
        r101.setAlwaysInvalidate(false);
        j r102 = this.f141133f.b(r100, new f(false), new a(this, r100, r101));
        t.a r103 = t.f133651a;
        CharSequence r104 = r102.f133515a;
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        t.b(r101, r104);
        i r105 = r102.f133516b;
        if (r105 != null) goto L12;
    L14:
        e r106 = this.f133725e.f501829e.getTextConfig();
        if (r106 == null) goto L17;
        int r107 = e.f480020j;
        r106.a(r101, true);
    L17:
        d3();
        this.f141133f.a(r100);
        int r108 = com.bytedance.android.livesdk.interactivity.square.e.f141152a;
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        com.bytedance.android.livesdk.interactivity.square.e.f141156e++;
        if (r100.getUser() == null) goto L21;
        com.bytedance.android.livesdk.interactivity.square.e.f141157f++;
        ((ArrayList) com.bytedance.android.livesdk.interactivity.square.e.f141158g).add(Long.valueOf(r100.getMessageId()));
    L21:
        if (com.bytedance.android.livesdk.interactivity.square.e.f141156e <= com.bytedance.android.livesdk.interactivity.square.e.f141152a) goto L24;
        com.bytedance.android.livesdk.interactivity.square.e.b();
        return;
    L24:
        return;
    L12:
        if (r105.f133511a != true) goto L14;
        r101.setAlwaysInvalidate(true);
        goto L14
    }

    public CommonSquarePublicScreenViewHolder(View r100, k52.a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "pipelineConfig");
        super(r100, r101);
        this.f141134g = r100;
        this.f141133f = r101.f501830f;
    }
}

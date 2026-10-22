package com.bytedance.android.livesdk.interactivity.square.common.common;

import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t;
import com.larus.nova.R;
import g52.e;
import h52.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements k.a<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonSquarePublicScreenViewHolder f141135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f141136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ NoMoreSpaceTextView f141137c;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k.a
    public final void a(c r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "rendResult");
        if (Intrinsics.areEqual(this.f141137c.getTag(R.id.ttlive_tag_public_screen_model), this.f141136b) == false) goto L9;
        t.a r102 = t.f133651a;
        NoMoreSpaceTextView r103 = this.f141137c;
        CharSequence r104 = r101.f133515a;
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        t.b(r103, r104);
    L9:
        e r105 = this.f141135a.f133725e.f501829e.getTextConfig();
        if (r105 == null) goto L13;
        r105.c(this.f141137c);
        return;
    }

    public a(CommonSquarePublicScreenViewHolder r100, c r101, NoMoreSpaceTextView r102) {
        this.f141135a = r100;
        this.f141136b = r101;
        this.f141137c = r102;
    }
}

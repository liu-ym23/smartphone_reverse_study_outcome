package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k.a<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PublicScreenCombinedTextViewHolder f139263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NoMoreSpaceTextView f139264b;

    public k(PublicScreenCombinedTextViewHolder r100, NoMoreSpaceTextView r101) {
        this.f139263a = r100;
        this.f139264b = r101;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k.a
    public final void a(s r100, com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "rendResult");
        t.a r102 = t.f133651a;
        NoMoreSpaceTextView r103 = this.f139264b;
        CharSequence r104 = r101.f133515a;
        if (r104 != null) goto L6;
        r104 = "";
    L6:
        t.b(r103, r104);
        PublicScreenCombinedTextViewHolder r105 = this.f139263a;
        NoMoreSpaceTextView r106 = this.f139264b;
        int r107 = PublicScreenCombinedTextViewHolder.f139228l;
        r105.Z3(r106);
    }
}

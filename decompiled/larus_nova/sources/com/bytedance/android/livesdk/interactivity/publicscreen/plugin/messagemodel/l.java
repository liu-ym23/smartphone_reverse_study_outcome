package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l implements ak6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PublicScreenCombinedTextViewHolder f139265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NoMoreSpaceTextView f139266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g52.e f139267c;

    @Override // ak6.e
    public final void a(ak6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        Intrinsics.checkNotNullParameter(r100, "rendResult");
    }

    @Override // ak6.e
    public final void b(ak6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        t.a r101 = t.f133651a;
        t.b(this.f139266b, r100.f4074a);
        PublicScreenCombinedTextViewHolder r102 = this.f139265a;
        NoMoreSpaceTextView r103 = this.f139266b;
        int r104 = PublicScreenCombinedTextViewHolder.f139228l;
        r102.Z3(r103);
        PublicScreenCombinedTextViewHolder r105 = this.f139265a;
        NoMoreSpaceTextView r106 = this.f139266b;
        g52.e r107 = this.f139267c;
        r105.getClass();
        if (r107 == null) goto L6;
        int r108 = g52.e.f480020j;
        r107.a(r106, true);
        return;
    }

    public l(PublicScreenCombinedTextViewHolder r100, NoMoreSpaceTextView r101, g52.e r102) {
        this.f139265a = r100;
        this.f139266b = r101;
        this.f139267c = r102;
    }
}

package com.bytedance.android.gamecp.business.comment.adapter;

import android.text.SpannableString;
import android.text.style.StyleSpan;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GamePromoteCommentDetailViewHolder f52009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Boolean f52010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f52011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f52012d;

    public s(GamePromoteCommentDetailViewHolder r100, Boolean r101, String r102, String r103) {
        this.f52009a = r100;
        this.f52010b = r101;
        this.f52011c = r102;
        this.f52012d = r103;
    }

    public final void a() {
        Boolean r100 = this.f52010b;
        Boolean r101 = Boolean.TRUE;
        if (Intrinsics.areEqual(r100, r101) == false) goto L5;
        int r102 = yt.e.f569004a;
        String r103 = yt.e.a(this.f52009a.f51954m, this.f52011c, ": " + this.f52012d, "官方", y0.a(9.0f), y0.b(2.0f), y0.b(4.0f));
    L6:
        SpannableString r104 = new SpannableString(r103);
        r104.setSpan(new StyleSpan(1), 0, this.f52011c.length(), 17);
        if (Intrinsics.areEqual(this.f52010b, r101) == false) goto L10;
        r104.setSpan(new zt.b(this.f52009a.f51954m.getPaint(), y0.b(4.0f), y0.b(2.0f), y0.b(2.0f), y0.a(9.0f), y0.b(2.0f)), this.f52011c.length(), this.f52011c.length() + 2, 17);
    L10:
        if (Intrinsics.areEqual(this.f52010b, r101) == false) goto L12;
        int r105 = this.f52011c.length() + 2;
    L13:
        r104.setSpan(new StyleSpan(1), r105, r105 + 1, 17);
        this.f52009a.f51954m.setText(r104);
        return;
    L12:
        r105 = this.f52011c.length();
        goto L13
    L5:
        int r106 = yt.e.f569004a;
        r103 = yt.e.a(this.f52009a.f51954m, this.f52011c, ": " + this.f52012d, "", this.f52009a.f51954m.getTextSize(), 0, 0);
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

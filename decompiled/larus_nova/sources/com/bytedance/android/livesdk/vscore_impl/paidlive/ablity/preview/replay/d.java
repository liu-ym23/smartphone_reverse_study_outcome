package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.preview.replay;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.view.BlurImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PaidReplayMLVideoMaskView f160445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f160446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f160447c;

    public d(PaidReplayMLVideoMaskView r100, Bitmap r101, int r102) {
        this.f160445a = r100;
        this.f160446b = r101;
        this.f160447c = r102;
    }

    public final void a() {
        PaidReplayMLVideoMaskView r100 = this.f160445a;
        StringBuilder r101 = new StringBuilder("blur size: width ");
        ViewGroup r102 = this.f160445a.f160346b;
        Integer r103 = null;
        if (r102 == null) goto L5;
        Integer r104 = Integer.valueOf(r102.getWidth());
    L6:
        r101.append(r104);
        r101.append(", height ");
        ViewGroup r105 = this.f160445a.f160346b;
        if (r105 == null) goto L9;
        r103 = Integer.valueOf(r105.getHeight());
    L9:
        r101.append(r103);
        ALogger.d(r100.f160427k, r101.toString());
        BlurImageView r106 = this.f160445a.f160432p;
        int r107 = 0;
        if (r106 == null) goto L12;
        int r108 = r106.getWidth();
    L13:
        if (r108 <= 0) goto L21;
        BlurImageView r109 = this.f160445a.f160432p;
        if (r109 == null) goto L17;
        r107 = r109.getHeight();
    L17:
        if (r107 <= 0) goto L21;
        BlurImageView r110 = this.f160445a.f160432p;
        if (r110 == null) goto L33;
        r110.setBackground(this.f160446b);
        return;
    L33:
        return;
    L21:
        int r111 = this.f160447c;
        if (r111 <= 3) goto L24;
        r111 = 3;
    L24:
        if (r111 > 0) goto L26;
        return;
    L26:
        BlurImageView r112 = this.f160445a.f160432p;
        if (r112 == null) goto L29;
        r112.requestLayout();
    L29:
        PaidReplayMLVideoMaskView r113 = this.f160445a;
        Bitmap r114 = this.f160446b;
        int r115 = r111 - 1;
        BlurImageView r116 = r113.f160432p;
        if (r116 == null) goto L35;
        r116.post(new d(r113, r114, r115));
        return;
    L35:
        return;
    L12:
        r108 = 0;
        goto L13
    L5:
        r104 = null;
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

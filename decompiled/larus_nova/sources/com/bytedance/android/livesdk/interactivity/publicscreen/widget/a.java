package com.bytedance.android.livesdk.interactivity.publicscreen.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.Spannable;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.common.utility.UIUtils;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Spannable f140482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f140483b;

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void onNewResultImpl(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Bitmap r101 = r100.copy(Bitmap.Config.ARGB_8888, true);
        Spannable r102 = this.f140482a;
        if (r101 != null) goto L5;
    L11:
        this.f140483b.setText(this.f140482a);
        return;
    L5:
        if (r101.isRecycled() == false) goto L8;
        if (r102 == null) goto L11;
    L8:
        if (r102.length() == 0) goto L11;
        Context r103 = s1.getContext();
        int r104 = (int) UIUtils.dip2Px(s1.getContext(), 16.0f);
        BitmapDrawable r105 = new BitmapDrawable(r103.getResources(), r101);
        r105.setBounds(0, 0, r104, r104);
        r102.setSpan(new com.bytedance.android.livesdk.widget.a(r105), r102.length() - 1, r102.length(), 33);
        goto L11
    }

    public a(Spannable r100, NoMoreSpaceTextView r101) {
        this.f140482a = r100;
        this.f140483b = r101;
    }
}

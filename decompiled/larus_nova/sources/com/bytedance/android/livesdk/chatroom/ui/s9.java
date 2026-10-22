package com.bytedance.android.livesdk.chatroom.ui;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes8.dex */
public final class s9 extends com.bytedance.android.live.core.utils.q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserFeatureLabelListAdapter.LabelViewHolder f114063a;

    public s9(UserFeatureLabelListAdapter.LabelViewHolder r100) {
        this.f114063a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.q0
    public final void h(py.k r100, int r101, int r102) {
        if (r102 <= 0) goto L22;
        if (r101 <= 0) goto L23;
        ViewGroup.LayoutParams r103 = this.f114063a.f112568b.getLayoutParams();
        UserFeatureLabelListAdapter.LabelViewHolder r104 = this.f114063a;
        int r105 = r104.f112567a;
        r103.height = r105;
        r103.width = (r101 * r105) / r102;
        r104.f112568b.setLayoutParams(r103);
        ImageView r106 = this.f114063a.f112568b;
    L15:
        e = move-exception;
        ALogger.e("UserFeatureLabelListAdapter", "getDesc:" + e);
    L17:
        String r107 = "";
    L18:
        com.bytedance.android.livesdk.r3.c(r106, r107, false);
        return;
    L6:
        if (TextUtils.isEmpty(r100.getUri()) == true) goto L8;
    L9:
        Matcher r108 = PatternProtector.compile(".+_v\\d_(\\d+).png").matcher(r100.getUri());     // Catch: Exception -> L15
        if (r108.find() == false) goto L17;
        if (r108.groupCount() <= 0) goto L17;
        r107 = "用户等级" + r108.group(1);     // Catch: Exception -> L15
        goto L18
    L8:
        if (r100.getUri().contains("user_grade_level") == false) goto L17;
    L23:
        return;
    }
}

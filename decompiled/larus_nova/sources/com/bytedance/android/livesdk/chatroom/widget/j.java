package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.user.IUserService;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class j extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f118829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f118830b;

    public static final class a {
    }

    static {
    }

    public j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f118829a = new LinkedHashMap();
        View.inflate(r100, R.layout.ttlive_layout_chat_auto_join_guide, this);
        py.k r101 = ((IUserService) jc1.k.n(IUserService.class)).user().b().getAvatarMedium();
        if (r101 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.utils.a1.v((ImageView) a(R.id.avatar_iv), r101, R.drawable.ttlive_img_avatar_empty);
    L5:
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f118830b = r102;
        if (r102 == null) goto L8;
        r102.setDuration(1000);
    L8:
        ValueAnimator r103 = this.f118830b;
        if (r103 == null) goto L11;
        r103.setRepeatCount(-1);
    L11:
        ValueAnimator r104 = this.f118830b;
        if (r104 == null) goto L14;
        r104.setInterpolator(new LinearInterpolator());
    L14:
        ValueAnimator r105 = this.f118830b;
        if (r105 == null) goto L17;
        r105.addUpdateListener(new k(this));
    L17:
        ValueAnimator r106 = this.f118830b;
        if (r106 == null) goto L21;
        r106.start();
        return;
    }

    public final View a(int r100) {
        if (this.f118829a != null) goto L5;
        this.f118829a = new LinkedHashMap();
    L5:
        View r101 = this.f118829a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f118829a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setTips(String r100) {
        ((TextView) a(R.id.tv_auto_join_tips)).setText(r100);
    }

    public static final void b(j r100, View r101, float r102) {
        r100.getClass();
        if (r101 == null) goto L6;
        r101.setAlpha(1.0f - r102);
    L6:
        if (r101 == null) goto L10;
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        if (r103 == null) goto L10;
        r103.height = com.bytedance.android.live.core.utils.s1.f((r102 * 30.0f) + 96.0f);
    L10:
        if (r101 == null) goto L15;
        ViewGroup.LayoutParams r104 = r101.getLayoutParams();
        if (r104 == null) goto L16;
        r104.width = com.bytedance.android.live.core.utils.s1.f((r102 * 30.0f) + 96.0f);
        return;
    L16:
        return;
    }
}

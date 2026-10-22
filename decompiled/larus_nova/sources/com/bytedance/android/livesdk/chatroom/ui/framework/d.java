package com.bytedance.android.livesdk.chatroom.ui.framework;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.castscreen.views.bytecast.LiveCastControlLayout;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.widget.SlideGuideView;
import com.bytedance.android.livesdk.chatroom.widget.landscape.r;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdk.widget.GestureDetectLayout;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes8.dex */
public interface d extends IAbility {
    View A8();

    View B9();

    View Bc();

    LinearLayout C6();

    View Co();

    View Dj();

    int En();

    View Eo();

    View Fj();

    @Deprecated(message = "尽量不要获取根布局，只获取指定View")
    View Fo();

    View Ia();

    AnchorPauseTipsView J7();

    ViewGroup M7();

    LottieAnimationView Oc();

    InteractionWidgetsPosContext Om();

    HSImageView Tb();

    LiveCastControlLayout Vo();

    ViewGroup Wa();

    View Wn();

    ViewGroup Yh();

    void af(SlideGuideView r100);

    View b6();

    View b8();

    ViewGroup bg();

    void bk(SlideGuideView r100);

    View c6();

    int c9();

    TextView ch();

    View de();

    View fj();

    View fp();

    View g8();

    @Deprecated(message = "尽量不要获取根布局，只获取指定View")
    View getRootView();

    TextView gp();

    View in();

    View ln();

    View n6();

    ViewGroup nn();

    @Deprecated(message = "尽量不要获取根布局，只获取指定View")
    GestureDetectLayout oh();

    View r7();

    r sl();

    FrameLayout va();

    ViewGroup zb(f70.b r100);
}

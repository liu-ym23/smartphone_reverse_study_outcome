package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.utils;

import android.view.View;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.mt.protector.impl.color.ColorProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class MorePanelButtonAnimUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f116528a = 0;

    static {
    }

    public static void a(View r100, float r101, float r110, boolean r111) {
        if (r100 != null) goto L4;
        return;
    L4:
        u4.c(new MorePanelButtonAnimUtils$showGuideAnim$1(r100, r101, r110, ColorProtector.parseColor("#FFF4F7FF"), ColorProtector.parseColor("#FFC7CFE4"), r111)).c();
    }
}

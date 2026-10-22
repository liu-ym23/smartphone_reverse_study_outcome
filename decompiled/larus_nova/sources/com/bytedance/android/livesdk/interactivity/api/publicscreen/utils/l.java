package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.interactivity.api.IPublicScreenService;
import com.bytedance.android.livesdk.interactivity.api.utils.MessageCommonColorUtil;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f133643a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f133644b = 0;

    static {
        f133643a = ColorProtector.parseColor("#7F000000");
        f133644b = ColorProtector.parseColor("#4C000000");
    }

    public static boolean d() {
        IRoomContextService r100 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        com.bytedance.android.livesdk.chatroom.o r101 = null;
        if (r100 == null) goto L5;
        r101 = IRoomContextService.a.a(r100, null, 0, 3);
    L5:
        if (r101 == null) goto L9;
        Boolean r102 = r101.isPortraitInteraction();
        if (r102 == null) goto L9;
        return r102.booleanValue();
    L9:
        return true;
    }

    @JvmStatic
    public static final float b(e52.a r100) {
        if (r100 == null) goto L6;
        g52.e r101 = r100.getTextConfig();
        if (r101 == null) goto L6;
        return r101.f480029i;
    L6:
        return 1.0f;
    }

    public static yb2.a c(e52.a r100, com.bytedance.android.livesdk.interactivity.api.publicscreen.s r101) {
        Intrinsics.checkNotNullParameter(r100, "textMessageConfig");
        Intrinsics.checkNotNullParameter(r101, "messageModel");
        if (d() == false) goto L5;
        n42.a r102 = r100.h();
    L6:
        r102.getClass();
        yb2.a r103 = r101.k().f133523a.f545243b;
        if (r103 != null) goto L10;
        int r104 = MessageCommonColorUtil.f133766a;
        int r105 = MessageCommonColorUtil.d();
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.s.a(r105, r105);
    L10:
        return r103;
    L5:
        r102 = r100.d();
        goto L6
    }

    @JvmStatic
    public static final void e(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "backgroundView");
        Drawable r102 = r100.getBackground();
        Drawable r103 = null;
        if ((r102 instanceof GradientDrawable) == true) goto L5;
        r102 = null;
    L5:
        GradientDrawable r104 = (GradientDrawable) r102;
        if (r104 != null) goto L12;
        r100.setBackgroundResource(R.drawable.ttlive_bg_message_item_v2);
        Drawable r105 = r100.getBackground();
        if ((r105 instanceof GradientDrawable) == false) goto L11;
        r103 = r105;
    L11:
        r104 = (GradientDrawable) r103;
    L12:
        if (r104 == null) goto L15;
        r104.setColor(r101);
        return;
    }

    @JvmStatic
    public static final int a(boolean r100, com.bytedance.android.livesdk.interactivity.api.entity.f r101, e52.a r102) {
        IPublicScreenService r103 = (IPublicScreenService) jc1.k.f(IPublicScreenService.class);
        Integer r104 = null;
        if (r103 == null) goto L5;
        Integer r105 = r103.getVSMessageBackgroundColor();
    L6:
        if (r105 != null) goto L8;
        if (r101 == null) goto L11;
        String r106 = r101.h();
    L12:
        if (r106 != null) goto L44;
    L17:
        Integer r107 = null;
    L18:
        if (r107 != null) goto L20;
        if (r102 != null) goto L23;
        n42.a r108 = null;
    L27:
        if (r108 == null) goto L37;
        if (r100 == false) goto L31;
    L33:
        if (r100 == false) goto L37;
        if (r108.f517043f == false) goto L37;
        r104 = r108.f517045h;
        goto L37
    L31:
        if (r108.f517042e == false) goto L33;
        r104 = r108.f517044g;
    L37:
        if (r104 != null) goto L39;
        if (r100 == false) goto L43;
        return f133643a;
    L43:
        return f133644b;
    L39:
        return r104.intValue();
    L23:
        if (d() == false) goto L25;
        r108 = r102.h();
        goto L27
    L25:
        r108 = r102.d();
        goto L27
    L20:
        return r107.intValue();
    L44:
        r107 = Integer.valueOf(Color.parseColor(r106));     // Catch: Exception -> L16
    L11:
        r106 = null;
        goto L12
    L8:
        return r105.intValue();
    L5:
        r105 = null;
        goto L6
    }
}

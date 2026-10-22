package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f133452a = 0;

    static {
    }

    @JvmStatic
    public static final String a(DataCenter r100) {
        Integer r101 = null;
        if (r100 == null) goto L5;
        IRoom r102 = gb2.a.e(r100);
    L6:
        IInteractService r103 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r103 == null) goto L9;
        Integer r104 = Integer.valueOf(r103.getCurrentScene());
    L10:
        IInteractService r105 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r105 == null) goto L14;
        r101 = Integer.valueOf(r105.getCurrentUiLayout());
    L14:
        if (r102 != null) goto L16;
    L41:
        if (r104 != null) goto L44;
        return "";
    L44:
        if (r104.intValue() != 12) goto L51;
        return "video";
    L51:
        return "";
    L16:
        if (r102.isLiveTypeAudio() != true) goto L41;
        if (r104 != null) goto L20;
    L22:
        if (r104 != null) goto L24;
    L25:
        if (r101 != null) goto L27;
    L40:
        return "radio";
    L27:
        if (r101.intValue() == 0) goto L40;
    L29:
        if (r104 != null) goto L32;
        return "";
    L32:
        if (r104.intValue() != 9) goto L48;
        if (r101 != null) goto L36;
    L38:
        String r106 = "ktv";
    L49:
        return r106;
    L36:
        if (r101.intValue() != 61) goto L38;
        r106 = "chorus";
        goto L49
    L48:
        return "";
    L24:
        if (r104.intValue() != 0) goto L29;
    L20:
        if (r104.intValue() != 5) goto L22;
        return "voice";
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @JvmStatic
    public static final String b(DataCenter r100) {
        if (r100 == null) goto L6;
        IRoom r101 = gb2.a.e(r100);
        if (r101 == null) goto L6;
        LiveMode r102 = r101.getStreamType();
    L7:
        int r103 = h1.f66189a;
        return i1.a(r102);
    L6:
        r102 = null;
        goto L7
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        ALogger.i("PSHighlightLogger", r100);
    }
}

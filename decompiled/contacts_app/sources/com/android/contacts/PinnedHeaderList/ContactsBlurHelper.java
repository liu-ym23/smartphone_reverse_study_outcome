package com.android.contacts.PinnedHeaderList;

import android.view.View;
import com.GlobalProxyLancet;
import com.bytedance.filemanager.widget.BlurConfig;
import com.obric.common.oea.foundation.blur.BlurUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactsBlurHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\n\u0010\u000b\u001a\u00020\f*\u00020\rJ\n\u0010\u000e\u001a\u00020\u000f*\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/contacts/PinnedHeaderList/ContactsBlurHelper;", "", "()V", "TAG", "", "setBackdropBlurEffect", "", "view", "Landroid/view/View;", "blurConfig", "Lcom/bytedance/filemanager/widget/BlurConfig;", "mapToBlendMode", "Lcom/obric/common/oea/foundation/blur/BlurUtils$BLEND_MODE;", "", "mapToBlurType", "Lcom/obric/common/oea/foundation/blur/BlurUtils$BlurType;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactsBlurHelper {
    public static final ContactsBlurHelper INSTANCE = null;
    private static final String TAG = "OBlurHelper";

    static {
        INSTANCE = new ContactsBlurHelper();
    }

    private ContactsBlurHelper() {
    }

    public final void setBackdropBlurEffect(View r9, BlurConfig r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r10, "blurConfig");
        int[] r0 = r10.getColors();     // Catch: Exception -> L12
        List<BlurUtils.BLEND_MODE> r1 = r10.getBlendModes();     // Catch: Exception -> L12
        if (r0.length == r1.size()) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setBackdropBlurEffect, colors.size!= blendModes.size");     // Catch: Exception -> L12
        return;
    L8:
        if (r0.length != 3) goto L10;
        BlurUtils.setBackdropBlurEffect(r9, r10.getBlurType(), r10.getBlurRadius(), new int[]{r0[0], r1.get(0).ordinal(), r0[1], r1.get(1).ordinal(), r0[2], r1.get(2).ordinal()});     // Catch: Exception -> L12
        return;
    L10:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "setBackdropBlurEffect, colors.size!=3, not supported yet");     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setBackdropBlurEffect, error", e);
    }

    public final BlurUtils.BLEND_MODE mapToBlendMode(int r1) {
        switch(r1) {
            case 0: goto L12;
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L13;
        };
    L13:
        return BlurUtils.BLEND_MODE.DEFAULT;
    L14:
        return BlurUtils.BLEND_MODE.SOFT_LIGHT;
    L15:
        return BlurUtils.BLEND_MODE.OVERLAY;
    L16:
        return BlurUtils.BLEND_MODE.LUMINOSITY;
    L17:
        return BlurUtils.BLEND_MODE.PLUS_LIGHTER;
    L18:
        return BlurUtils.BLEND_MODE.PLUS_DARKER;
    L19:
        return BlurUtils.BLEND_MODE.COLOR_DODGE;
    L20:
        return BlurUtils.BLEND_MODE.COLOR_BURN;
    L12:
        return BlurUtils.BLEND_MODE.DEFAULT;
    }

    public final BlurUtils.BlurType mapToBlurType(int r1) {
        if (r1 == 0) goto L20;
        if (r1 == 1) goto L26;
        if (r1 == 2) goto L25;
        if (r1 == 3) goto L24;
        if (r1 == 4) goto L23;
        if (r1 == 5) goto L22;
        return BlurUtils.BlurType.NONE;
    L22:
        return BlurUtils.BlurType.PROGRESS_BLUR_RIGHT_LEFT;
    L23:
        return BlurUtils.BlurType.PROGRESS_BLUR_LEFT_RIGHT;
    L24:
        return BlurUtils.BlurType.PROGRESS_BLUR_UP_DOWN;
    L25:
        return BlurUtils.BlurType.PROGRESS_BLUR_DOWN_UP;
    L26:
        return BlurUtils.BlurType.NORMAL_BLUR;
    L20:
        return BlurUtils.BlurType.NONE;
    }
}

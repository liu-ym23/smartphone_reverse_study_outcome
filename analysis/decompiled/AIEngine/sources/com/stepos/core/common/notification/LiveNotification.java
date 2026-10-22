package com.stepos.core.common.notification;

import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import com.stepos.core.ability.speech.PcmDumpBudget;
import java.util.ArrayList;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LiveNotification {
    public static final int CAPSULE_STATUS_END = -1;
    public static final int CAPSULE_STATUS_SHOW = 1;
    public static final int CAPSULE_TYPE_ICON_TEXT = 1;
    public static final int CARD_LEVEL_MODEL_DOWNLOAD = 14;
    public static final String EVENT_PROGRESS = "PROGRESS";
    public static final LiveNotification INSTANCE = new LiveNotification();
    public static final String KEY_BG_COLOR_OVERLAY = "notification.live.bgColorOverlay";
    public static final String KEY_CAN_DELETE = "notification.live.can.delete";
    public static final String KEY_CAPSULE = "notification.live.capsule";
    public static final String KEY_CAPSULE_BG_COLOR = "notification.live.capsuleBgColor";
    public static final String KEY_CAPSULE_CLICK_LAUNCH_PI = "notification.live.capsule.click.launch.pending.intent";
    public static final String KEY_CAPSULE_CONTENT = "notification.live.capsuleContent";
    public static final String KEY_CAPSULE_CONTENT_COLOR = "notification.live.capsuleContentColor";
    public static final String KEY_CAPSULE_ICON = "notification.live.capsuleIcon";
    public static final String KEY_CAPSULE_STATUS = "notification.live.capsuleStatus";
    public static final String KEY_CAPSULE_TITLE = "notification.live.capsuleTitle";
    public static final String KEY_CAPSULE_TYPE = "notification.live.capsuleType";
    public static final String KEY_CARD_CUSTOM_VIEW = "notification.live.card.custom.view";
    public static final String KEY_CARD_LEVEL = "notification.live.card.level";
    public static final String KEY_CONTENT_COLOR = "notification.live.contentColor";
    public static final String KEY_CONTENT_OVERLAY = "notification.live.contentOverlay";
    public static final String KEY_EVENT = "notification.live.event";
    public static final String KEY_EXTEND_IMAGE = "notification.live.feature.extendImage";
    public static final String KEY_FEATURE_PROGRESS = "notification.live.feature.progress";
    public static final String KEY_FEATURE_PROGRESS_HIDE = "notification.live.feature.progressHide";
    public static final String KEY_ICON_OVERLAY = "notification.live.iconOverlay";
    public static final String KEY_IS_LIVE = "is_live";
    public static final String KEY_OPERATION = "notification.live.operation";
    public static final String KEY_PINNED = "notification.live.pinned";
    public static final String KEY_PINNED_TIMEOUT = "notification.live.pinned.timeout";
    public static final String KEY_TITLE_COLOR = "notification.live.titleColor";
    public static final String KEY_TITLE_OVERLAY = "notification.live.titleOverlay";
    public static final String KEY_TYPE = "notification.live.type";
    public static final int OP_CREATE = 0;
    public static final int OP_END = 2;
    public static final int OP_UPDATE = 1;
    public static final int TYPE_BASIC = 1;
    public static final int TYPE_CARD = 6;
    public static final int TYPE_REMOTE_VIEWS = 10;

    private LiveNotification() {
    }

    public static /* synthetic */ void applyModelDownload$default(LiveNotification liveNotification, Bundle bundle, int i10, CharSequence charSequence, CharSequence charSequence2, Icon icon, Icon icon2, int i11, int i12, int i13, int i14, CharSequence charSequence3, int i15, PendingIntent pendingIntent, ArrayList arrayList, int i16, boolean z, boolean z3, int i17, boolean z10, int i18, Object obj) {
        boolean z11;
        LiveNotification liveNotification2;
        Bundle bundle2;
        int i19;
        CharSequence charSequence4;
        CharSequence charSequence5;
        Icon icon3;
        Icon icon4;
        int i20;
        int i21;
        int i22;
        int i23;
        CharSequence charSequence6;
        int i24;
        PendingIntent pendingIntent2;
        ArrayList arrayList2 = (i18 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? null : arrayList;
        int i25 = (i18 & 16384) != 0 ? 1 : i16;
        boolean z12 = (32768 & i18) != 0 ? false : z;
        boolean z13 = (65536 & i18) != 0 ? true : z3;
        int i26 = (131072 & i18) != 0 ? -1 : i17;
        if ((i18 & 262144) != 0) {
            z11 = true;
            bundle2 = bundle;
            i19 = i10;
            charSequence4 = charSequence;
            charSequence5 = charSequence2;
            icon3 = icon;
            icon4 = icon2;
            i20 = i11;
            i21 = i12;
            i22 = i13;
            i23 = i14;
            charSequence6 = charSequence3;
            i24 = i15;
            pendingIntent2 = pendingIntent;
            liveNotification2 = liveNotification;
        } else {
            z11 = z10;
            liveNotification2 = liveNotification;
            bundle2 = bundle;
            i19 = i10;
            charSequence4 = charSequence;
            charSequence5 = charSequence2;
            icon3 = icon;
            icon4 = icon2;
            i20 = i11;
            i21 = i12;
            i22 = i13;
            i23 = i14;
            charSequence6 = charSequence3;
            i24 = i15;
            pendingIntent2 = pendingIntent;
        }
        liveNotification2.applyModelDownload(bundle2, i19, charSequence4, charSequence5, icon3, icon4, i20, i21, i22, i23, charSequence6, i24, pendingIntent2, arrayList2, i25, z12, z13, i26, z11);
    }

    public final void applyEnd(Bundle target) {
        g.f(target, "target");
        target.putInt(KEY_OPERATION, 2);
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_CAPSULE_STATUS, -1);
        n nVar = n.f10413a;
        target.putBundle(KEY_CAPSULE, bundle);
    }

    public final void applyModelDownload(Bundle target, int i10, CharSequence expandTitle, CharSequence expandContent, Icon cardIcon, Icon capsuleIcon, int i11, int i12, int i13, int i14, CharSequence capsuleText, int i15, PendingIntent pendingIntent, ArrayList<Icon> arrayList, int i16, boolean z, boolean z3, int i17, boolean z10) {
        g.f(target, "target");
        g.f(expandTitle, "expandTitle");
        g.f(expandContent, "expandContent");
        g.f(cardIcon, "cardIcon");
        g.f(capsuleIcon, "capsuleIcon");
        g.f(capsuleText, "capsuleText");
        target.putBoolean(KEY_IS_LIVE, true);
        target.putInt(KEY_TYPE, i16);
        target.putString(KEY_EVENT, EVENT_PROGRESS);
        target.putInt(KEY_OPERATION, i10);
        target.putInt(KEY_CARD_LEVEL, 14);
        target.putBoolean(KEY_CAN_DELETE, z);
        target.putBoolean(KEY_PINNED, z10);
        if (i17 > 0) {
            target.putInt(KEY_PINNED_TIMEOUT, i17);
        }
        target.putCharSequence(KEY_TITLE_OVERLAY, expandTitle);
        target.putCharSequence(KEY_CONTENT_OVERLAY, expandContent);
        target.putParcelable(KEY_ICON_OVERLAY, cardIcon);
        target.putInt(KEY_BG_COLOR_OVERLAY, i11);
        target.putInt(KEY_TITLE_COLOR, i13);
        target.putInt(KEY_CONTENT_COLOR, i14);
        if (arrayList != null) {
            target.putParcelableArrayList(KEY_EXTEND_IMAGE, arrayList);
        }
        if (z3) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_CAPSULE_STATUS, 1);
            bundle.putInt(KEY_CAPSULE_TYPE, 1);
            bundle.putParcelable(KEY_CAPSULE_ICON, capsuleIcon);
            bundle.putInt(KEY_CAPSULE_BG_COLOR, i12);
            bundle.putCharSequence(KEY_CAPSULE_CONTENT, capsuleText);
            bundle.putInt(KEY_CAPSULE_CONTENT_COLOR, i15);
            if (pendingIntent != null) {
                bundle.putParcelable(KEY_CAPSULE_CLICK_LAUNCH_PI, pendingIntent);
            }
            target.putBundle(KEY_CAPSULE, bundle);
        }
    }
}

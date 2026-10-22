package com.stepos.ailauncher.chat.activity;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0019\u001a/\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a9\u0010\u000e\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001f\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a7\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"", "minify", "homeCollapsed", "circleActive", "voiceActive", Const.INTENT_KEY_UMID, "(ZZZZ)Z", ChatTracker.STAGE_HALF, "c", "(ZZZ)Z", "holdListen", "minifyListening", "halfExpanded", "typingEngaged", Const.INTENT_KEY_APIKEY, "(ZZZZZ)Z", "canDismissFromOutside", "capturesFullWindow", "e", "(ZZ)Z", "expanded", "maskPassthrough", "homeFollowing", "hiddenForRecents", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class H0 {
    public static final boolean a(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        return z10 || z11 || z12 || z13 || z14;
    }

    public static final boolean b(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        return (!z10 || !z11 || z12 || z13 || z14) ? false : true;
    }

    public static final boolean c(boolean z10, boolean z11, boolean z12) {
        return (!z10 || z11 || z12) ? false : true;
    }

    public static final boolean d(boolean z10, boolean z11, boolean z12, boolean z13) {
        return (!z10 || z11 || z12 || z13) ? false : true;
    }

    public static final boolean e(boolean z10, boolean z11) {
        return z10 && !z11;
    }
}

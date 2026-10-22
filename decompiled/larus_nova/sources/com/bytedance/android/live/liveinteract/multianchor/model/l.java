package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.livesdk.link.model.bridge.Linkmic2DAvatar;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes46.dex */
public final class l implements am3.c<ListUserLinkmicAudienceContent> {
    public l() {
    }

    @Override // am3.c
    public final ListUserLinkmicAudienceContent decode(am3.g r100) throws Exception {
        ListUserLinkmicAudienceContent r101 = new ListUserLinkmicAudienceContent();
        r101.setThreadSafe(false);
        r101.rankUserOpenIds = new ArrayList();
        r101.rankUserIds = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L44;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 21) goto L8;
        r101.selfDisciplineStartTime = r100.j();
        goto L3
    L8:
        if (r103 != 23) goto L10;
        r101.selfDisciplineTargetDuration = r100.j();
        goto L3
    L10:
        if (r103 != 31) goto L12;
        r101.isMicHidden = am3.h.a(r100);
        goto L3
    L12:
        if (r103 != 5000) goto L13;
        r101.rankUserOpenIds.add(am3.h.c(r100));
        goto L3
    L13:
        switch(r103) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L28;
            case 8: goto L27;
            case 9: goto L26;
            case 10: goto L25;
            case 11: goto L24;
            case 12: goto L23;
            case 13: goto L22;
            case 14: goto L21;
            case 15: goto L20;
            case 16: goto L19;
            case 17: goto L18;
            case 18: goto L17;
            case 19: goto L16;
            default: goto L14;
        };
    L16:
        r101.mIsAnonymous = am3.h.a(r100);
        goto L3
    L17:
        r101.mSelfDisciplineDurationTime = r100.j();
        goto L3
    L18:
        r101.mIsEnlarged = am3.h.a(r100);
        goto L3
    L19:
        r101.mPaidCount = r100.j();
        goto L3
    L20:
        r101.micDress = (MicDress) vh7.f.a(r100, MicDress.class);
        goto L3
    L21:
        r101.rankUserIds.add(Long.valueOf(r100.j()));
        goto L3
    L22:
        r101.mFanTicketRealStr = am3.h.c(r100);
        goto L3
    L23:
        r101.mListUserRole = r100.i();
        goto L3
    L24:
        r101.mFanTicketFuzzyStr = am3.h.c(r100);
        goto L3
    L25:
        r101.mCurrentTime = r100.j();
        goto L3
    L26:
        r101.extra = am3.h.c(r100);
        goto L3
    L27:
        r101.isInWaitingList = am3.h.a(r100);
        goto L3
    L28:
        r101.mExpectLeaveTime = r100.j();
        goto L3
    L29:
        r101.mJoinChannelTime = r100.j();
        goto L3
    L30:
        r101.mDevicePlatform = am3.h.c(r100);
        goto L3
    L31:
        r101.mClientVersion = r100.j();
        goto L3
    L32:
        r101.mAppId = r100.j();
        goto L3
    L33:
        r101.mIsHost = am3.h.a(r100);
        goto L3
    L34:
        r101.mFanTicket = r100.j();
        goto L3
    L14:
        switch(r103) {
            case 25: goto L39;
            case 26: goto L38;
            case 27: goto L37;
            case 28: goto L36;
            case 29: goto L35;
            default: goto L15;
        };
    L35:
        r101.aiGuestType = r100.i();
        goto L3
    L36:
        r101.originLinkType = r100.j();
        goto L3
    L37:
        r101.chorusGuestStatus = r100.j();
        goto L3
    L38:
        r101.linkmic2DAvatar = (Linkmic2DAvatar) vh7.f.a(r100, Linkmic2DAvatar.class);
        goto L3
    L39:
        r101.themedCompetitionRole = r100.i();
        goto L3
    L15:
        am3.h.d(r104, r100);
        goto L3
    L44:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }
}

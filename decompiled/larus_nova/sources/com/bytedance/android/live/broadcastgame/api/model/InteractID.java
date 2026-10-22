package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveOpenFeatureChooseConfig;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b1\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2¨\u00063"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/InteractID;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Unknown", "Comment", "Lottery", "DrawSth", "KTV", "Blinked", "GiftVote", "EffectGame", "WGameX", "WMiniGame", "CloudGame", "DynamicItem", "LinkMicEmojiItem", "Predictor", "InteractiveSong", "VProject", "KtvRoomSelect", "PkOperationalPlayBo3", "GuestBattle", "DigitAvatar", "KTVChallenge", "TeamFight", "PlayTogether", "VideoKtv", "PaidLink", "LinkRoomFight", "SelfDiscipline", "InteractiveSong2", "ThemedCompetition", "Adventure", "StarWish", "InteractActing", "RevenueGameEffect", "RevenueGameEffectDynamic", "OpenGame", "Zhufen", "OpenMicroApp", "SonicMiniGame", "InteractLoki", "InteractGamePlus", "InteractMiniApp", "OpenMicroGame", "livebroadcastgame-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InteractID extends Enum<InteractID> {
    public static final InteractID Adventure = null;
    public static final InteractID Blinked = null;
    public static final InteractID CloudGame = null;
    public static final InteractID Comment = null;
    public static final a Companion = null;
    public static final InteractID DigitAvatar = null;
    public static final InteractID DrawSth = null;
    public static final InteractID DynamicItem = null;
    public static final InteractID EffectGame = null;
    public static final InteractID GiftVote = null;
    public static final InteractID GuestBattle = null;
    public static final InteractID InteractActing = null;
    public static final InteractID InteractGamePlus = null;
    public static final InteractID InteractLoki = null;
    public static final InteractID InteractMiniApp = null;
    public static final InteractID InteractiveSong = null;
    public static final InteractID InteractiveSong2 = null;
    public static final InteractID KTV = null;
    public static final InteractID KTVChallenge = null;
    public static final InteractID KtvRoomSelect = null;
    public static final InteractID LinkMicEmojiItem = null;
    public static final InteractID LinkRoomFight = null;
    public static final InteractID Lottery = null;
    public static final InteractID OpenGame = null;
    public static final InteractID OpenMicroApp = null;
    public static final InteractID OpenMicroGame = null;
    public static final InteractID PaidLink = null;
    public static final InteractID PkOperationalPlayBo3 = null;
    public static final InteractID PlayTogether = null;
    public static final InteractID Predictor = null;
    public static final InteractID RevenueGameEffect = null;
    public static final InteractID RevenueGameEffectDynamic = null;
    public static final InteractID SelfDiscipline = null;
    public static final InteractID SonicMiniGame = null;
    public static final InteractID StarWish = null;
    public static final InteractID TeamFight = null;
    public static final InteractID ThemedCompetition = null;
    public static final InteractID Unknown = null;
    public static final InteractID VProject = null;
    public static final InteractID VideoKtv = null;
    public static final InteractID WGameX = null;
    public static final InteractID WMiniGame = null;
    public static final InteractID Zhufen = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InteractID[] f59326a = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static boolean a(InteractID r100) {
            Intrinsics.checkNotNullParameter(r100, "$this$isGamePlay");
            if (LiveOpenFeatureChooseConfig.useV3() == true) goto L5;
        L9:
            return false;
        L5:
            if (r100 != InteractID.SonicMiniGame) goto L7;
        L8:
            return true;
        L7:
            if (r100 != InteractID.OpenMicroGame) goto L9;
            goto L8
        }

        public static InteractID b(int r100) {
            InteractID[] r101 = InteractID.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            InteractID r104 = r101[r103];
            if (r100 != r104.getValue()) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L14;
            return r104;
        L14:
            return InteractID.Unknown;
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    public static InteractID valueOf(String r100) {
        return (InteractID) r27.a.a(InteractID.class, r100);
    }

    public static InteractID[] values() {
        return (InteractID[]) f59326a.clone();
    }

    static {
        InteractID r100 = new InteractID("Unknown", 0, 0);
        Unknown = r100;
        InteractID r101 = new InteractID("Comment", 1, 1);
        Comment = r101;
        InteractID r102 = new InteractID("Lottery", 2, 2);
        Lottery = r102;
        InteractID r103 = new InteractID("DrawSth", 3, 3);
        DrawSth = r103;
        InteractID r104 = new InteractID("KTV", 4, 4);
        KTV = r104;
        InteractID r105 = new InteractID("Blinked", 5, 5);
        Blinked = r105;
        InteractID r106 = new InteractID("GiftVote", 6, 6);
        GiftVote = r106;
        InteractID r107 = new InteractID("EffectGame", 7, 7);
        EffectGame = r107;
        InteractID r108 = new InteractID("WGameX", 8, 8);
        WGameX = r108;
        InteractID r109 = new InteractID("WMiniGame", 9, 9);
        WMiniGame = r109;
        InteractID r110 = new InteractID("CloudGame", 10, 10);
        CloudGame = r110;
        InteractID r111 = new InteractID("DynamicItem", 11, 11);
        DynamicItem = r111;
        InteractID r112 = new InteractID("LinkMicEmojiItem", 12, 12);
        LinkMicEmojiItem = r112;
        InteractID r113 = new InteractID("Predictor", 13, 13);
        Predictor = r113;
        InteractID r114 = new InteractID("InteractiveSong", 14, 14);
        InteractiveSong = r114;
        InteractID r115 = new InteractID("VProject", 15, 15);
        VProject = r115;
        InteractID r116 = new InteractID("KtvRoomSelect", 16, 16);
        KtvRoomSelect = r116;
        InteractID r117 = new InteractID("PkOperationalPlayBo3", 17, 17);
        PkOperationalPlayBo3 = r117;
        InteractID r118 = new InteractID("GuestBattle", 18, 18);
        GuestBattle = r118;
        InteractID r119 = new InteractID("DigitAvatar", 19, 19);
        DigitAvatar = r119;
        InteractID r120 = new InteractID("KTVChallenge", 20, 20);
        KTVChallenge = r120;
        InteractID r121 = new InteractID("TeamFight", 21, 21);
        TeamFight = r121;
        InteractID r122 = new InteractID("PlayTogether", 22, 22);
        PlayTogether = r122;
        InteractID r123 = new InteractID("VideoKtv", 23, 23);
        VideoKtv = r123;
        InteractID r124 = new InteractID("PaidLink", 24, 25);
        PaidLink = r124;
        InteractID r125 = new InteractID("LinkRoomFight", 25, 26);
        LinkRoomFight = r125;
        InteractID r126 = new InteractID("SelfDiscipline", 26, 27);
        SelfDiscipline = r126;
        InteractID r127 = new InteractID("InteractiveSong2", 27, 29);
        InteractiveSong2 = r127;
        InteractID r128 = new InteractID("ThemedCompetition", 28, 30);
        ThemedCompetition = r128;
        InteractID r129 = new InteractID("Adventure", 29, 31);
        Adventure = r129;
        InteractID r130 = new InteractID("StarWish", 30, 34);
        StarWish = r130;
        InteractID r131 = new InteractID("InteractActing", 31, 42);
        InteractActing = r131;
        InteractID r132 = new InteractID("RevenueGameEffect", 32, 69);
        RevenueGameEffect = r132;
        InteractID r133 = new InteractID("RevenueGameEffectDynamic", 33, 70);
        RevenueGameEffectDynamic = r133;
        InteractID r134 = new InteractID("OpenGame", 34, 100);
        OpenGame = r134;
        InteractID r135 = new InteractID("Zhufen", 35, 101);
        Zhufen = r135;
        InteractID r136 = new InteractID("OpenMicroApp", 36, 103);
        OpenMicroApp = r136;
        InteractID r137 = new InteractID("SonicMiniGame", 37, 104);
        SonicMiniGame = r137;
        InteractID r138 = new InteractID("InteractLoki", 38, 105);
        InteractLoki = r138;
        InteractID r139 = new InteractID("InteractGamePlus", 39, 106);
        InteractGamePlus = r139;
        InteractID r140 = new InteractID("InteractMiniApp", 40, 107);
        InteractMiniApp = r140;
        InteractID r141 = new InteractID("OpenMicroGame", 41, 108);
        OpenMicroGame = r141;
        f59326a = new InteractID[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141};
        Companion = new a();
    }

    public final int getValue() {
        return this.value;
    }

    public InteractID(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

package com.bytedance.android.live.liveinteract.pre;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.utils.t0;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import java.util.List;
import jc1.k;

/* JADX INFO: loaded from: classes46.dex */
public final class VerticalNitaInflate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray<List<zo2.a>> f77859a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SparseArray<List<zo2.a>> f77860b = null;

    public static final enum Tag extends Enum<Tag> {
        public static final Tag AudioRoomFeedView_container = null;
        public static final Tag BaseEqualTalkRoomAdapter_holder_empty = null;
        public static final Tag BaseEqualTalkRoomAdapter_holder_guest = null;
        public static final Tag BattleVideoEqualGuestMicSeatLayer = null;
        public static final Tag BattleVideoGuestMicSeatLayer = null;
        public static final Tag CEqualTalkRoomAdapter_holder_empty = null;
        public static final Tag CEqualTalkRoomAdapter_holder_guest = null;
        public static final Tag CEqualTalkRoomAdapter_holder_guest_large = null;
        public static final Tag CVideoEqualGuestMicSeatBasicLayer = null;
        public static final Tag CVideoEqualGuestMicSeatBasicLayer_large = null;
        public static final Tag CVideoTalkRoomFeedView_container = null;
        public static final Tag CameraTalkRoomNewFeedView_container = null;
        public static final Tag CommonMultiLinkFeedView_container = null;
        public static final Tag EqualTalkRoomFeedView_container = null;
        public static final Tag GuestBattleQuickInteractView = null;
        public static final Tag LinkInRoomAudioGuestAdapter_holder_empty_1v8 = null;
        public static final Tag LinkInRoomAudioGuestAdapter_holder_empty_3x3 = null;
        public static final Tag LinkInRoomAudioGuestAdapter_holder_guest_1v8 = null;
        public static final Tag LinkInRoomAudioGuestAdapter_holder_guest_3x3 = null;
        public static final Tag LinkRoomFightAdapter_holder_empty = null;
        public static final Tag LinkRoomFightAdapter_holder_guest = null;
        public static final Tag LinkRoomFightBasicLayer = null;
        public static final Tag LinkRoomFightBusinessLayer = null;
        public static final Tag LinkRoomFightEmptyLayer = null;
        public static final Tag LinkRoomFightFeedView_container = null;
        public static final Tag MultiLinkAudioCommonCPositionAnimLayer = null;
        public static final Tag MultiLinkAudioCommonCPositionEmptyBasicLayer = null;
        public static final Tag MultiLinkAudioCommonCPositionGuestMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioCommonCPositionGuestMicSeatStatusLayer = null;
        public static final Tag MultiLinkAudioCommonEmptyBasicLayer = null;
        public static final Tag MultiLinkAudioCommonEnlargeStageAnimLayer = null;
        public static final Tag MultiLinkAudioCommonEnlargeStageEmptyBasicLayer = null;
        public static final Tag MultiLinkAudioCommonEnlargeStageGuestMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioCommonFirstUserEnlargeStageCustomizeMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioCommonFirstUserEnlargeStageMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioCommonFirstUserGuestMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioCommonFirstUserV2GuestMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioCommonGuestAnimLayer = null;
        public static final Tag MultiLinkAudioCommonGuestMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioCommonGuestStatusLayer = null;
        public static final Tag MultiLinkAudioCommonHamletAnimLayer = null;
        public static final Tag MultiLinkAudioCommonHamletAvatarGuestMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioCommonHamletEmptyBasicLayer = null;
        public static final Tag MultiLinkAudioCommonLargeEmptyBasicLayer = null;
        public static final Tag MultiLinkAudioCommonLargeGuestMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioCommonLargeGuestMicSeatStatusLayer = null;
        public static final Tag MultiLinkAudioCommonLargePreOnlineLayer = null;
        public static final Tag MultiLinkAudioCommonPreOnlineLayer = null;
        public static final Tag MultiLinkAudioCommonThemedCompetitionBusinessLayer = null;
        public static final Tag MultiLinkAudioCommonVirtualAvatarAnimLayer = null;
        public static final Tag MultiLinkAudioFirstUserVirtualAvatarMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioHamletEmptyLargeLayer = null;
        public static final Tag MultiLinkAvatarTalkoverPlaceHolderLayer = null;
        public static final Tag MultiLinkCommonEmptyMicSeatBasicLayer = null;
        public static final Tag MultiLinkCommonGuestMicSeatBasicLayer = null;
        public static final Tag MultiLinkCommonGuestStatusLayer = null;
        public static final Tag MultiLinkCommonSpecialMicSeatBasicLayer = null;
        public static final Tag MultiLinkDummyLayer = null;
        public static final Tag MultiLinkDynamicFloatWindowEmptyLayer = null;
        public static final Tag MultiLinkDynamicFloatWindowEmptyLayerOld = null;
        public static final Tag MultiLinkDynamicFloatWindowFirstUserBasicLayer = null;
        public static final Tag MultiLinkDynamicFloatWindowFirstUserStatusLayer = null;
        public static final Tag MultiLinkDynamicTeamFightView = null;
        public static final Tag MultiLinkFixedFloatWindowFirstUserBasicLayer = null;
        public static final Tag MultiLinkFixedFloatWindowFirstUserStatusLayer = null;
        public static final Tag MultiLinkFloatWindow1v8SmallGuestBasicLayer = null;
        public static final Tag MultiLinkFloatWindow1v8SmallGuestStatusLayer = null;
        public static final Tag MultiLinkGameFunctionLayer = null;
        public static final Tag MultiLinkHamletAvatarRevealUserInfoLayer = null;
        public static final Tag MultiLinkHamletAvatarUserInfoLayer = null;
        public static final Tag MultiLinkHamletMainUserAnimLayer = null;
        public static final Tag MultiLinkMicSeatAnimLayer = null;
        public static final Tag MultiLinkMicSelfDisciplineLayer = null;
        public static final Tag MultiLinkPCLandscapeMicSeatBasicLayer = null;
        public static final Tag MultiLinkRadioMainSeatLayer = null;
        public static final Tag MultiLinkRadioWidgetView = null;
        public static final Tag MultiLinkRequestSongAvatarMicSeatLayer = null;
        public static final Tag MultiLinkVideoCommonThemedCompetitionBusinessLayer = null;
        public static final Tag MultiLinkVideoCommonWindowView = null;
        public static final Tag MultiLinkVideoGuestWidgetViewV2 = null;
        public static final Tag MultiLinkVoiceCommonWindowView = null;
        public static final Tag MultiLinkVoiceGuestWidgetView = null;
        public static final Tag SeatAnimationView = null;
        public static final Tag SelfDisciplineMicSeatLayer = null;
        public static final Tag VideoCameraRoomWindowAdapterV2_holder_empty = null;
        public static final Tag VideoCameraRoomWindowAdapterV2_holder_guest = null;
        public static final Tag VideoDynamicTalkRoomFeedView_container = null;
        public static final Tag VideoEmptyMicSeatBasicLayer = null;
        public static final Tag VideoEqualEmptyMicSeatBasicLayer = null;
        public static final Tag VideoEqualGuestMicSeatBasicLayer = null;
        public static final Tag VideoGuestMicSeatBasicLayer = null;
        public static final Tag VideoMicSeatStatusLayer = null;
        public static final Tag VideoTeamFightAdapter_holder_anchor = null;
        public static final Tag VideoTeamFightAdapter_holder_empty = null;
        public static final Tag VideoTeamFightAdapter_holder_guest = null;
        public static final Tag VideoTeamFightFeedView_container = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Tag[] f77861a = null;

        static {
            Tag r100 = new Tag("GuestBattleQuickInteractView", 0);
            GuestBattleQuickInteractView = r100;
            Tag r101 = new Tag("SeatAnimationView", 1);
            SeatAnimationView = r101;
            Tag r102 = new Tag("VideoEqualEmptyMicSeatBasicLayer", 2);
            VideoEqualEmptyMicSeatBasicLayer = r102;
            Tag r103 = new Tag("VideoEqualGuestMicSeatBasicLayer", 3);
            VideoEqualGuestMicSeatBasicLayer = r103;
            Tag r104 = new Tag("VideoMicSeatStatusLayer", 4);
            VideoMicSeatStatusLayer = r104;
            Tag r105 = new Tag("BattleVideoGuestMicSeatLayer", 5);
            BattleVideoGuestMicSeatLayer = r105;
            Tag r110 = new Tag("BattleVideoEqualGuestMicSeatLayer", 6);
            BattleVideoEqualGuestMicSeatLayer = r110;
            Tag r111 = new Tag("SelfDisciplineMicSeatLayer", 7);
            SelfDisciplineMicSeatLayer = r111;
            Tag r112 = new Tag("CVideoEqualGuestMicSeatBasicLayer_large", 8);
            CVideoEqualGuestMicSeatBasicLayer_large = r112;
            Tag r113 = new Tag("CVideoEqualGuestMicSeatBasicLayer", 9);
            CVideoEqualGuestMicSeatBasicLayer = r113;
            Tag r114 = new Tag("VideoEmptyMicSeatBasicLayer", 10);
            VideoEmptyMicSeatBasicLayer = r114;
            Tag r115 = new Tag("VideoGuestMicSeatBasicLayer", 11);
            VideoGuestMicSeatBasicLayer = r115;
            Tag r106 = new Tag("EqualTalkRoomFeedView_container", 12);
            EqualTalkRoomFeedView_container = r106;
            Tag r107 = new Tag("BaseEqualTalkRoomAdapter_holder_empty", 13);
            BaseEqualTalkRoomAdapter_holder_empty = r107;
            Tag r108 = new Tag("BaseEqualTalkRoomAdapter_holder_guest", 14);
            BaseEqualTalkRoomAdapter_holder_guest = r108;
            Tag r109 = new Tag("CEqualTalkRoomAdapter_holder_empty", 15);
            CEqualTalkRoomAdapter_holder_empty = r109;
            Tag r116 = new Tag("CEqualTalkRoomAdapter_holder_guest", 16);
            CEqualTalkRoomAdapter_holder_guest = r116;
            Tag r117 = new Tag("CEqualTalkRoomAdapter_holder_guest_large", 17);
            CEqualTalkRoomAdapter_holder_guest_large = r117;
            Tag r118 = new Tag("CommonMultiLinkFeedView_container", 18);
            CommonMultiLinkFeedView_container = r118;
            Tag r119 = new Tag("CVideoTalkRoomFeedView_container", 19);
            CVideoTalkRoomFeedView_container = r119;
            Tag r120 = new Tag("CameraTalkRoomNewFeedView_container", 20);
            CameraTalkRoomNewFeedView_container = r120;
            Tag r121 = new Tag("VideoDynamicTalkRoomFeedView_container", 21);
            VideoDynamicTalkRoomFeedView_container = r121;
            Tag r122 = new Tag("VideoCameraRoomWindowAdapterV2_holder_empty", 22);
            VideoCameraRoomWindowAdapterV2_holder_empty = r122;
            Tag r123 = new Tag("VideoCameraRoomWindowAdapterV2_holder_guest", 23);
            VideoCameraRoomWindowAdapterV2_holder_guest = r123;
            Tag r124 = new Tag("VideoTeamFightFeedView_container", 24);
            VideoTeamFightFeedView_container = r124;
            Tag r125 = new Tag("VideoTeamFightAdapter_holder_anchor", 25);
            VideoTeamFightAdapter_holder_anchor = r125;
            Tag r126 = new Tag("VideoTeamFightAdapter_holder_guest", 26);
            VideoTeamFightAdapter_holder_guest = r126;
            Tag r127 = new Tag("VideoTeamFightAdapter_holder_empty", 27);
            VideoTeamFightAdapter_holder_empty = r127;
            Tag r128 = new Tag("LinkRoomFightFeedView_container", 28);
            LinkRoomFightFeedView_container = r128;
            Tag r129 = new Tag("LinkRoomFightAdapter_holder_guest", 29);
            LinkRoomFightAdapter_holder_guest = r129;
            Tag r130 = new Tag("LinkRoomFightAdapter_holder_empty", 30);
            LinkRoomFightAdapter_holder_empty = r130;
            Tag r131 = new Tag("LinkRoomFightBasicLayer", 31);
            LinkRoomFightBasicLayer = r131;
            Tag r132 = new Tag("LinkRoomFightBusinessLayer", 32);
            LinkRoomFightBusinessLayer = r132;
            Tag r133 = new Tag("LinkRoomFightEmptyLayer", 33);
            LinkRoomFightEmptyLayer = r133;
            Tag r134 = new Tag("AudioRoomFeedView_container", 34);
            AudioRoomFeedView_container = r134;
            Tag r135 = new Tag("LinkInRoomAudioGuestAdapter_holder_empty_3x3", 35);
            LinkInRoomAudioGuestAdapter_holder_empty_3x3 = r135;
            Tag r136 = new Tag("LinkInRoomAudioGuestAdapter_holder_empty_1v8", 36);
            LinkInRoomAudioGuestAdapter_holder_empty_1v8 = r136;
            Tag r137 = new Tag("LinkInRoomAudioGuestAdapter_holder_guest_3x3", 37);
            LinkInRoomAudioGuestAdapter_holder_guest_3x3 = r137;
            Tag r138 = new Tag("LinkInRoomAudioGuestAdapter_holder_guest_1v8", 38);
            LinkInRoomAudioGuestAdapter_holder_guest_1v8 = r138;
            Tag r139 = new Tag("MultiLinkVideoCommonWindowView", 39);
            MultiLinkVideoCommonWindowView = r139;
            Tag r140 = new Tag("MultiLinkVideoGuestWidgetViewV2", 40);
            MultiLinkVideoGuestWidgetViewV2 = r140;
            Tag r141 = new Tag("MultiLinkVoiceCommonWindowView", 41);
            MultiLinkVoiceCommonWindowView = r141;
            Tag r142 = new Tag("MultiLinkRadioWidgetView", 42);
            MultiLinkRadioWidgetView = r142;
            Tag r143 = new Tag("MultiLinkVoiceGuestWidgetView", 43);
            MultiLinkVoiceGuestWidgetView = r143;
            Tag r144 = new Tag("MultiLinkDynamicTeamFightView", 44);
            MultiLinkDynamicTeamFightView = r144;
            Tag r145 = new Tag("MultiLinkCommonGuestMicSeatBasicLayer", 45);
            MultiLinkCommonGuestMicSeatBasicLayer = r145;
            Tag r146 = new Tag("MultiLinkCommonEmptyMicSeatBasicLayer", 46);
            MultiLinkCommonEmptyMicSeatBasicLayer = r146;
            Tag r147 = new Tag("MultiLinkCommonSpecialMicSeatBasicLayer", 47);
            MultiLinkCommonSpecialMicSeatBasicLayer = r147;
            Tag r148 = new Tag("MultiLinkCommonGuestStatusLayer", 48);
            MultiLinkCommonGuestStatusLayer = r148;
            Tag r149 = new Tag("MultiLinkMicSelfDisciplineLayer", 49);
            MultiLinkMicSelfDisciplineLayer = r149;
            Tag r150 = new Tag("MultiLinkMicSeatAnimLayer", 50);
            MultiLinkMicSeatAnimLayer = r150;
            Tag r151 = new Tag("MultiLinkVideoCommonThemedCompetitionBusinessLayer", 51);
            MultiLinkVideoCommonThemedCompetitionBusinessLayer = r151;
            Tag r152 = new Tag("MultiLinkDummyLayer", 52);
            MultiLinkDummyLayer = r152;
            Tag r153 = new Tag("MultiLinkFixedFloatWindowFirstUserBasicLayer", 53);
            MultiLinkFixedFloatWindowFirstUserBasicLayer = r153;
            Tag r154 = new Tag("MultiLinkDynamicFloatWindowFirstUserBasicLayer", 54);
            MultiLinkDynamicFloatWindowFirstUserBasicLayer = r154;
            Tag r155 = new Tag("MultiLinkFloatWindow1v8SmallGuestBasicLayer", 55);
            MultiLinkFloatWindow1v8SmallGuestBasicLayer = r155;
            Tag r156 = new Tag("MultiLinkDynamicFloatWindowEmptyLayer", 56);
            MultiLinkDynamicFloatWindowEmptyLayer = r156;
            Tag r157 = new Tag("MultiLinkDynamicFloatWindowEmptyLayerOld", 57);
            MultiLinkDynamicFloatWindowEmptyLayerOld = r157;
            Tag r158 = new Tag("MultiLinkDynamicFloatWindowFirstUserStatusLayer", 58);
            MultiLinkDynamicFloatWindowFirstUserStatusLayer = r158;
            Tag r159 = new Tag("MultiLinkFixedFloatWindowFirstUserStatusLayer", 59);
            MultiLinkFixedFloatWindowFirstUserStatusLayer = r159;
            Tag r160 = new Tag("MultiLinkFloatWindow1v8SmallGuestStatusLayer", 60);
            MultiLinkFloatWindow1v8SmallGuestStatusLayer = r160;
            Tag r161 = new Tag("MultiLinkGameFunctionLayer", 61);
            MultiLinkGameFunctionLayer = r161;
            Tag r162 = new Tag("MultiLinkPCLandscapeMicSeatBasicLayer", 62);
            MultiLinkPCLandscapeMicSeatBasicLayer = r162;
            Tag r163 = new Tag("MultiLinkAudioCommonGuestMicSeatBasicLayer", 63);
            MultiLinkAudioCommonGuestMicSeatBasicLayer = r163;
            Tag r164 = new Tag("MultiLinkAudioCommonLargeGuestMicSeatBasicLayer", 64);
            MultiLinkAudioCommonLargeGuestMicSeatBasicLayer = r164;
            Tag r165 = new Tag("MultiLinkAudioCommonCPositionGuestMicSeatBasicLayer", 65);
            MultiLinkAudioCommonCPositionGuestMicSeatBasicLayer = r165;
            Tag r166 = new Tag("MultiLinkAudioCommonFirstUserGuestMicSeatBasicLayer", 66);
            MultiLinkAudioCommonFirstUserGuestMicSeatBasicLayer = r166;
            Tag r167 = new Tag("MultiLinkAudioCommonFirstUserV2GuestMicSeatBasicLayer", 67);
            MultiLinkAudioCommonFirstUserV2GuestMicSeatBasicLayer = r167;
            Tag r168 = new Tag("MultiLinkAudioFirstUserVirtualAvatarMicSeatBasicLayer", 68);
            MultiLinkAudioFirstUserVirtualAvatarMicSeatBasicLayer = r168;
            Tag r169 = new Tag("MultiLinkAudioCommonFirstUserEnlargeStageMicSeatBasicLayer", 69);
            MultiLinkAudioCommonFirstUserEnlargeStageMicSeatBasicLayer = r169;
            Tag r170 = new Tag("MultiLinkAudioCommonFirstUserEnlargeStageCustomizeMicSeatBasicLayer", 70);
            MultiLinkAudioCommonFirstUserEnlargeStageCustomizeMicSeatBasicLayer = r170;
            Tag r171 = new Tag("MultiLinkAudioCommonGuestStatusLayer", 71);
            MultiLinkAudioCommonGuestStatusLayer = r171;
            Tag r172 = new Tag("MultiLinkAudioCommonLargeGuestMicSeatStatusLayer", 72);
            MultiLinkAudioCommonLargeGuestMicSeatStatusLayer = r172;
            Tag r173 = new Tag("MultiLinkAudioCommonCPositionGuestMicSeatStatusLayer", 73);
            MultiLinkAudioCommonCPositionGuestMicSeatStatusLayer = r173;
            Tag r174 = new Tag("MultiLinkAudioCommonThemedCompetitionBusinessLayer", 74);
            MultiLinkAudioCommonThemedCompetitionBusinessLayer = r174;
            Tag r175 = new Tag("MultiLinkAudioCommonGuestAnimLayer", 75);
            MultiLinkAudioCommonGuestAnimLayer = r175;
            Tag r176 = new Tag("MultiLinkAudioCommonCPositionAnimLayer", 76);
            MultiLinkAudioCommonCPositionAnimLayer = r176;
            Tag r177 = new Tag("MultiLinkAudioCommonVirtualAvatarAnimLayer", 77);
            MultiLinkAudioCommonVirtualAvatarAnimLayer = r177;
            Tag r178 = new Tag("MultiLinkAudioCommonEmptyBasicLayer", 78);
            MultiLinkAudioCommonEmptyBasicLayer = r178;
            Tag r179 = new Tag("MultiLinkAudioCommonLargeEmptyBasicLayer", 79);
            MultiLinkAudioCommonLargeEmptyBasicLayer = r179;
            Tag r180 = new Tag("MultiLinkAudioCommonCPositionEmptyBasicLayer", 80);
            MultiLinkAudioCommonCPositionEmptyBasicLayer = r180;
            Tag r181 = new Tag("MultiLinkAudioCommonPreOnlineLayer", 81);
            MultiLinkAudioCommonPreOnlineLayer = r181;
            Tag r182 = new Tag("MultiLinkAudioCommonLargePreOnlineLayer", 82);
            MultiLinkAudioCommonLargePreOnlineLayer = r182;
            Tag r183 = new Tag("MultiLinkRadioMainSeatLayer", 83);
            MultiLinkRadioMainSeatLayer = r183;
            Tag r184 = new Tag("MultiLinkAudioCommonEnlargeStageGuestMicSeatBasicLayer", 84);
            MultiLinkAudioCommonEnlargeStageGuestMicSeatBasicLayer = r184;
            Tag r185 = new Tag("MultiLinkAudioCommonEnlargeStageAnimLayer", 85);
            MultiLinkAudioCommonEnlargeStageAnimLayer = r185;
            Tag r186 = new Tag("MultiLinkAudioCommonHamletAvatarGuestMicSeatBasicLayer", 86);
            MultiLinkAudioCommonHamletAvatarGuestMicSeatBasicLayer = r186;
            Tag r187 = new Tag("MultiLinkAudioCommonHamletAnimLayer", 87);
            MultiLinkAudioCommonHamletAnimLayer = r187;
            Tag r188 = new Tag("MultiLinkAudioCommonHamletEmptyBasicLayer", 88);
            MultiLinkAudioCommonHamletEmptyBasicLayer = r188;
            Tag r189 = new Tag("MultiLinkAudioCommonEnlargeStageEmptyBasicLayer", 89);
            MultiLinkAudioCommonEnlargeStageEmptyBasicLayer = r189;
            Tag r190 = new Tag("MultiLinkAudioHamletEmptyLargeLayer", 90);
            MultiLinkAudioHamletEmptyLargeLayer = r190;
            Tag r191 = new Tag("MultiLinkHamletAvatarRevealUserInfoLayer", 91);
            MultiLinkHamletAvatarRevealUserInfoLayer = r191;
            Tag r192 = new Tag("MultiLinkHamletAvatarUserInfoLayer", 92);
            MultiLinkHamletAvatarUserInfoLayer = r192;
            Tag r193 = new Tag("MultiLinkAvatarTalkoverPlaceHolderLayer", 93);
            MultiLinkAvatarTalkoverPlaceHolderLayer = r193;
            Tag r194 = new Tag("MultiLinkRequestSongAvatarMicSeatLayer", 94);
            MultiLinkRequestSongAvatarMicSeatLayer = r194;
            Tag r195 = new Tag("MultiLinkHamletMainUserAnimLayer", 95);
            MultiLinkHamletMainUserAnimLayer = r195;
            f77861a = new Tag[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r190, r191, r192, r193, r194, r195};
        }

        public static Tag[] values() {
            return (Tag[]) f77861a.clone();
        }

        public static Tag valueOf(String r100) {
            return (Tag) r27.a.a(Tag.class, r100);
        }

        public Tag(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a implements zo2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f77862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f77863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f77864c;

        @Override // zo2.a
        public int getType() {
            return 0;
        }

        public final int hashCode() {
            int r100 = this.f77862a * 31;
            String r101 = this.f77863b;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return ((((r100 + r102) * 31) + this.f77864c) * 31) + 0;
        L5:
            r102 = 0;
            goto L7
        }

        public final String toString() {
            return "Item{resId=" + this.f77862a + ", tag='" + this.f77863b + "', count=" + this.f77864c + ", scene=0}";
        }

        @Override // zo2.a
        public final int getCount() {
            return this.f77864c;
        }

        @Override // zo2.a
        public final int getResId() {
            return this.f77862a;
        }

        @Override // zo2.a
        public final String getTag() {
            return this.f77863b;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L20:
            return false;
        L8:
            if (a.class != r100.getClass()) goto L20;
            a r101 = (a) r100;
            if (this.f77862a == r101.f77862a) goto L13;
            return false;
        L13:
            String r102 = this.f77863b;
            String r103 = r101.f77863b;
            if (r102 != null) goto L21;
            if (r103 == null) goto L22;
            return false;
        L22:
            return true;
        L21:
            return r102.equals(r103);
        }

        public a(Tag r100, int r101) {
            this.f77862a = r101;
            this.f77863b = r100.name();
            this.f77864c = 1;
        }
    }

    static {
        f77859a = new SparseArray();
        f77860b = new SparseArray();
    }

    public static View a(String r110, int r111, Context r112, ViewGroup r113, boolean r114) {
        IMiddlewareHostBusiness r100 = (IMiddlewareHostBusiness) k.f(IMiddlewareHostBusiness.class);
        System.nanoTime();
        boolean r101 = false;
        if (r110.isEmpty() == false) goto L5;
    L4:
        boolean r102 = false;
    L10:
        if (r102 == true) goto L12;
    L17:
        View r103 = LayoutInflater.from(r112).inflate(r111, r113, r114);
        com.bytedance.android.live.liveinteract.pre.a.c.f77878a.b(r110, false);
        ALogger.i("VerticalNitaInflate", "[layoutLoad] load " + r110 + " by inflater");
        int r104 = t0.f78832a;
        StringBuilder r105 = new StringBuilder("[Nita][layoutLoad] load ");
        r105.append(r110);
        r105.append(" by inflater,extra: hasCachedView=");
        if (r110.isEmpty() == true) goto L24;
        IMiddlewareHostBusiness r106 = (IMiddlewareHostBusiness) k.f(IMiddlewareHostBusiness.class);
        if (r106 == null) goto L24;
        r101 = r106.hasCachedView(r110, r111);
    L24:
        r105.append(r101);
        r105.append(", context=");
        r105.append(r112);
        r105.append(", hostBusiness=");
        r105.append(r100);
        r105.append(", nitaTag=");
        r105.append(r110);
        t0.a("VerticalNitaInflate", r105.toString());
        return r103;
    L12:
        if ((r112 instanceof Activity) == false) goto L17;
        if (r100 == null) goto L17;
        if (TextUtils.isEmpty(r110) == true) goto L17;
        View r107 = r100.tryGetPreLoadLiveLayouts(r111, r110, (Activity) r112, r113, Boolean.valueOf(r114), Boolean.FALSE, null);
        com.bytedance.android.live.liveinteract.pre.a.c.f77878a.b(r110, true);
        ALogger.i("VerticalNitaInflate", "[layoutLoad] load " + r110 + " by nita");
        int r108 = t0.f78832a;
        t0.a("VerticalNitaInflate", "[Nita][layoutLoad] load " + r110 + " by nita");
        return r107;
    L5:
        IMiddlewareHostBusiness r109 = (IMiddlewareHostBusiness) k.f(IMiddlewareHostBusiness.class);
        if (r109 == null) goto L4;
        r102 = r109.hasCachedView(r110, r111);
        goto L10
    }
}

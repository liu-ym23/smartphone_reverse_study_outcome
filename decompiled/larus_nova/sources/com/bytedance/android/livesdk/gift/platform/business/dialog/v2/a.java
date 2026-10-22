package com.bytedance.android.livesdk.gift.platform.business.dialog.v2;

import android.content.Context;
import com.amap.api.col.s.ce;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.livesdk.gift.model.p3;
import com.bytedance.android.livesdk.gift.model.w0;
import com.bytedance.android.livesdk.gift.model.y0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.live.kmp.util.e;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.j;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f126623b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zy0.d f126624a;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v2.a$a, reason: collision with other inner class name */
    public static final class C2032a {
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001:\u0002 \u000fB\u0007¢\u0006\u0004\b1\u00102R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\f\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b&\u0010(\"\u0004\b)\u0010*R\"\u0010+\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0013\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R\"\u0010.\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\f\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0010¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/a$b;", "", "", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/a$b$b;", "groupShowUsers", "Ljava/util/List;", "getGroupShowUsers", "()Ljava/util/List;", "d", "(Ljava/util/List;)V", "", "descriptionStyle", "J", "getDescriptionStyle", "()J", "b", "(J)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "h", "(Ljava/lang/String;)V", "subTitle", "getSubTitle", ce.f26391f, "Lpy/k;", "backgroundImage", "Lpy/k;", "getBackgroundImage", "()Lpy/k;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lpy/k;)V", "groupShowScene", "getGroupShowScene", "c", "", "isLiveShow", "Z", "()Z", "e", "(Z)V", "toastText", "getToastText", RXScreenCaptureService.KEY_INDEX, "serverTime", "getServerTime", "f", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("background_image")
        private k backgroundImage;

        @SerializedName("description_style")
        private long descriptionStyle;

        @SerializedName("group_show_scene")
        private long groupShowScene;

        @SerializedName("group_show_users")
        private List<C2034b> groupShowUsers;

        @SerializedName("is_live_show")
        private boolean isLiveShow;

        @SerializedName("server_time")
        private long serverTime;

        @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
        private String subTitle;

        @SerializedName("title")
        private String title;

        @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_TASK_TOKEN_TOAST_TEXT)
        private String toastText;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v2.a$b$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/a$b$a;", "", "Lpy/k;", "avatarThumb", "Lpy/k;", "getAvatarThumb", "()Lpy/k;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lpy/k;)V", "", "nickName", "Ljava/lang/String;", "getNickName", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "", "followerCount", "J", "getFollowerCount", "()J", "b", "(J)V", "id", "getId", "c", "secUid", "getSecUid", "e", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C2033a {

            @SerializedName("avatar_thumb")
            private k avatarThumb;

            @SerializedName("follower_count")
            private long followerCount;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            @SerializedName("id")
            private String f126625id;

            @SerializedName(InstantPlayContext.NICKNAME)
            private String nickName;

            @SerializedName("sec_uid")
            private String secUid;

            public C2033a() {
                this.f126625id = "";
            }

            public final void a(k r100) {
                this.avatarThumb = r100;
            }

            public final void b(long r100) {
                this.followerCount = r100;
            }

            public final void c(String r100) {
                Intrinsics.checkNotNullParameter(r100, "<set-?>");
                this.f126625id = r100;
            }

            public final void d(String r100) {
                this.nickName = r100;
            }

            public final void e(String r100) {
                this.secUid = r100;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v2.a$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bA\u0010BR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R$\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b9\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\"\u001a\u0004\b?\u0010$\"\u0004\b@\u0010&¨\u0006C"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/a$b$b;", "", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/a$b$a;", "simpleUser", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/a$b$a;", "getSimpleUser", "()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/a$b$a;", "l", "(Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/a$b$a;)V", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "sendButtonText", "getSendButtonText", "h", "", "fanTicketCount", "J", "getFanTicketCount", "()J", ce.f26391f, "(J)V", "curRoundFanTicketCount", "getCurRoundFanTicketCount", "e", "showEndTime", "getShowEndTime", RXScreenCaptureService.KEY_INDEX, "", "anchorType", "I", "getAnchorType", "()I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(I)V", "Lpy/k;", "avatarBorder", "Lpy/k;", "getAvatarBorder", "()Lpy/k;", "b", "(Lpy/k;)V", "bestShowerBgImage", "getBestShowerBgImage", "c", "Lcom/bytedance/android/livesdk/gift/model/p3;", "showStatusLabel", "Lcom/bytedance/android/livesdk/gift/model/p3;", "getShowStatusLabel", "()Lcom/bytedance/android/livesdk/gift/model/p3;", ce.f26396k, "(Lcom/bytedance/android/livesdk/gift/model/p3;)V", "", "isBestUser", "Z", "()Z", "d", "(Z)V", "showStatus", "getShowStatus", ce.f26395j, "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C2034b {

            @SerializedName("identity_label")
            private int anchorType;

            @SerializedName("live_avatar_frame_image")
            private k avatarBorder;

            @SerializedName("bg_image")
            private k bestShowerBgImage;

            @SerializedName("group_show_cur_round_fan_ticket_count")
            private long curRoundFanTicketCount;

            @SerializedName("description")
            private String description;

            @SerializedName("group_show_fan_ticket_count")
            private long fanTicketCount;

            @SerializedName("is_best_shower")
            private boolean isBestUser;

            @SerializedName("send_button_text")
            private String sendButtonText;

            @SerializedName("show_end_time")
            private long showEndTime;

            @SerializedName("show_status")
            private int showStatus;

            @SerializedName("show_status_label")
            private p3 showStatusLabel;

            @SerializedName("group_show_user")
            private C2033a simpleUser;

            public C2034b() {
            }

            public final void a(int r100) {
                this.anchorType = r100;
            }

            public final void b(k r100) {
                this.avatarBorder = r100;
            }

            public final void c(k r100) {
                this.bestShowerBgImage = r100;
            }

            public final void d(boolean r100) {
                this.isBestUser = r100;
            }

            public final void e(long r100) {
                this.curRoundFanTicketCount = r100;
            }

            public final void f(String r100) {
                this.description = r100;
            }

            public final void g(long r100) {
                this.fanTicketCount = r100;
            }

            public final void h(String r100) {
                this.sendButtonText = r100;
            }

            public final void i(long r100) {
                this.showEndTime = r100;
            }

            public final void j(int r100) {
                this.showStatus = r100;
            }

            public final void k(p3 r100) {
                this.showStatusLabel = r100;
            }

            public final void l(C2033a r100) {
                this.simpleUser = r100;
            }
        }

        public b() {
            this.toastText = "";
        }

        public final void a(k r100) {
            this.backgroundImage = r100;
        }

        public final void b(long r100) {
            this.descriptionStyle = r100;
        }

        public final void c(long r100) {
            this.groupShowScene = r100;
        }

        public final void d(List<C2034b> r100) {
            this.groupShowUsers = r100;
        }

        public final void e(boolean r100) {
            this.isLiveShow = r100;
        }

        public final void f(long r100) {
            this.serverTime = r100;
        }

        public final void g(String r100) {
            this.subTitle = r100;
        }

        public final void h(String r100) {
            this.title = r100;
        }

        public final void i(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.toastText = r100;
        }
    }

    static {
    }

    public final Context getContext() {
        return null;
    }

    public static b a(w0 r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        b r101 = new b();
        r101.b(r100.getDescriptionStyle());
        r101.h(r100.getTitle());
        r101.g(r100.getSubTitle());
        r101.a(r100.getBackgroundImage());
        r101.c(r100.getGroupShowScene());
        r101.e(r100.isLiveShow());
        r101.i(r100.getToastText());
        List<y0> r102 = r100.getGroupShowUsers();
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L7:
        if (r104.hasNext() == false) goto L13;
        y0 r105 = (y0) r104.next();
        b.C2034b r106 = new b.C2034b();
        r106.f(r105.getDescription());
        r106.h(r105.getSendButtonText());
        r106.g(r105.getFanTicketCount());
        r106.e(r105.getCurRoundFanTicketCount());
        r106.i(r105.getShowEndTime());
        r106.a(r105.getAnchorType());
        r106.b(r105.getAvatarBorder());
        r106.c(r105.getBestShowerBgImage());
        r106.k(r105.getShowStatusLabel());
        r106.d(r105.isBestUser());
        r106.j(r105.getShowStatus());
        b.C2033a r107 = new b.C2033a();
        r107.c(r105.getGroupShowUser().getIdString());
        r107.a(r105.getGroupShowUser().getAvatarThumbKt());
        r107.d(r105.getGroupShowUser().getNickName());
        j r108 = r105.getGroupShowUser().getFollowInfo();
        if (r108 == null) goto L11;
        long r109 = r108.getFollowerCount();
    L12:
        r107.b(r109);
        r107.e(o.a(r105.getGroupShowUser()));
        Unit r110 = Unit.INSTANCE;
        r106.l(r107);
        r103.add(r106);
        goto L7
    L11:
        r109 = 0;
        goto L12
    L13:
        r101.d(r103);
        r101.f(e.b());
        return r101;
    }
}

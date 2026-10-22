package com.bytedance.android.livesdk.interactivity.chatchannel.model;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.fifa.core.IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class ChannelLinkUserInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final User f134346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f134347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkUserInfo f134348c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/model/ChannelLinkUserInfo$ChannelUserRole;", "", "UNKNOWN", "Manager", "Audience", "Guest", "LinkApplicant", "LinkInvitee", "GuestApplicant", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ChannelUserRole extends Enum<ChannelUserRole> {
        public static final ChannelUserRole Audience = null;
        public static final ChannelUserRole Guest = null;
        public static final ChannelUserRole GuestApplicant = null;
        public static final ChannelUserRole LinkApplicant = null;
        public static final ChannelUserRole LinkInvitee = null;
        public static final ChannelUserRole Manager = null;
        public static final ChannelUserRole UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChannelUserRole[] f134349a = null;

        static {
            ChannelUserRole r100 = new ChannelUserRole("UNKNOWN", 0);
            UNKNOWN = r100;
            ChannelUserRole r101 = new ChannelUserRole("Manager", 1);
            Manager = r101;
            ChannelUserRole r102 = new ChannelUserRole("Audience", 2);
            Audience = r102;
            ChannelUserRole r103 = new ChannelUserRole("Guest", 3);
            Guest = r103;
            ChannelUserRole r104 = new ChannelUserRole("LinkApplicant", 4);
            LinkApplicant = r104;
            ChannelUserRole r105 = new ChannelUserRole("LinkInvitee", 5);
            LinkInvitee = r105;
            ChannelUserRole r106 = new ChannelUserRole("GuestApplicant", 6);
            GuestApplicant = r106;
            f134349a = new ChannelUserRole[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static ChannelUserRole valueOf(String r100) {
            return (ChannelUserRole) r27.a.a(ChannelUserRole.class, r100);
        }

        public static ChannelUserRole[] values() {
            return (ChannelUserRole[]) f134349a.clone();
        }

        public ChannelUserRole(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/model/ChannelLinkUserInfo$LinkUserInfo;", "Ljava/io/Serializable;", "rtcUserId", "", "linkStatus", "", "silenceStatus", "volumeLevel", "Lcom/bytedance/android/live/fifa/core/IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel;", "(Ljava/lang/String;IILcom/bytedance/android/live/fifa/core/IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel;)V", "getLinkStatus", "()I", "getRtcUserId", "()Ljava/lang/String;", "getSilenceStatus", "getVolumeLevel", "()Lcom/bytedance/android/live/fifa/core/IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LinkUserInfo implements Serializable {
        private final int linkStatus;
        private final String rtcUserId;
        private final int silenceStatus;
        private final IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel volumeLevel;

        public final int getLinkStatus() {
            return this.linkStatus;
        }

        public final String getRtcUserId() {
            return this.rtcUserId;
        }

        public final int getSilenceStatus() {
            return this.silenceStatus;
        }

        public final IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel getVolumeLevel() {
            return this.volumeLevel;
        }

        public LinkUserInfo(String r100, int r101, int r102, IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r103) {
            Intrinsics.checkNotNullParameter(r100, "rtcUserId");
            Intrinsics.checkNotNullParameter(r103, "volumeLevel");
            this.rtcUserId = r100;
            this.linkStatus = r101;
            this.silenceStatus = r102;
            this.volumeLevel = r103;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ChannelUserRole f134350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f134351b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f134350a, r101.f134350a) == true) goto L8;
            return false;
        L8:
            if (this.f134351b == r101.f134351b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public final int hashCode() {
            ChannelUserRole r100 = this.f134350a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            int r102 = r101 * 31;
            boolean r103 = this.f134351b;
            ?? r104 = r103;
            if (r103 == false) goto L10;
            r104 = 1;
        L10:
            return r102 + r104;
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "ChannelUserInfo(channelUserRole=" + this.f134350a + ", channelLinkMicSwitch=" + this.f134351b + ")";
        }

        public a(ChannelUserRole r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "channelUserRole");
            this.f134350a = r100;
            this.f134351b = r101;
        }
    }

    public static final class b {
    }

    static {
    }

    public ChannelLinkUserInfo(User r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r101, "channelUserInfo");
        this.f134346a = r100;
        this.f134347b = r101;
        this.f134348c = null;
    }
}

package com.bytedance.android.livesdkapi.shortvideo;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.shortvideo.impl.base.common.data.UserRole;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.shortvideo.IShortVideoComponentBase.CommonParams;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0003\u000e\u000f\u0010R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/shortvideo/IShortVideoComponentBase;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/livesdkapi/shortvideo/IShortVideoComponentBase$CommonParams;", "", "currentRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getCurrentRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "onlinePlayerStateListObservable", "Lio/reactivex/Observable;", "", "Lcom/bytedance/android/livesdkapi/shortvideo/IShortVideoComponentBase$IOnlinePlayerState;", "getOnlinePlayerStateListObservable", "()Lio/reactivex/Observable;", "CommonParams", "ExtraOpenParams", "IOnlinePlayerState", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IShortVideoComponentBase<T extends CommonParams> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0018\u0010\u0010\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0005\"\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u0018\u0010\u0016\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0005\"\u0004\b\u0018\u0010\u0013R\u0012\u0010\u0019\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0005R\u0012\u0010\u001b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0005R\u0012\u0010\u001d\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0005R\u0012\u0010#\u001a\u00020$X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0012\u0010'\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010 R\u0012\u0010)\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010 R\u0012\u0010+\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0005R\u0012\u0010-\u001a\u00020.X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdkapi/shortvideo/IShortVideoComponentBase$CommonParams;", "", ReportConstant.COMMON_ACTION_TYPE, "", "getActionType", "()Ljava/lang/String;", "anchorStartType", "", "getAnchorStartType$annotations", "()V", "getAnchorStartType", "()I", "awemeAuthorId", "getAwemeAuthorId", "awemeGroupId", "getAwemeGroupId", "beforeUserType", "getBeforeUserType", "setBeforeUserType", "(Ljava/lang/String;)V", "desiredTopSpaceHeight", "getDesiredTopSpaceHeight", "enterFrom", "getEnterFrom", "setEnterFrom", "enterFromMerge", "getEnterFromMerge", "enterMethod", "getEnterMethod", "enterTime", "", "getEnterTime", "()J", "eventPage", "getEventPage", "extraOpenParams", "Lcom/bytedance/android/livesdkapi/shortvideo/IShortVideoComponentBase$ExtraOpenParams;", "getExtraOpenParams", "()Lcom/bytedance/android/livesdkapi/shortvideo/IShortVideoComponentBase$ExtraOpenParams;", "invitorUserId", "getInvitorUserId", "roomId", "getRoomId", "subEventPage", "getSubEventPage", "userRole", "Lcom/bytedance/android/live/shortvideo/impl/base/common/data/UserRole;", "getUserRole", "()Lcom/bytedance/android/live/shortvideo/impl/base/common/data/UserRole;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface CommonParams {

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
        public static final class DefaultImpls {
            public static /* synthetic */ void getAnchorStartType$annotations() {
            }
        }

        String getActionType();

        int getAnchorStartType();

        String getAwemeAuthorId();

        String getAwemeGroupId();

        String getBeforeUserType();

        int getDesiredTopSpaceHeight();

        String getEnterFrom();

        String getEnterFromMerge();

        String getEnterMethod();

        long getEnterTime();

        String getEventPage();

        ExtraOpenParams getExtraOpenParams();

        long getInvitorUserId();

        long getRoomId();

        String getSubEventPage();

        UserRole getUserRole();

        void setBeforeUserType(String r100);

        void setEnterFrom(String r100);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/shortvideo/IShortVideoComponentBase$ExtraOpenParams;", "", "enterFrom", "", "idOfToInvite", "secIdOfToInvite", "nameOfToInvite", "isConversation", "", "isFollowEach", "roomOwnerSecId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V", "getEnterFrom", "()Ljava/lang/String;", "getIdOfToInvite", "()Z", "getNameOfToInvite", "getRoomOwnerSecId", "getSecIdOfToInvite", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ExtraOpenParams {
        private final String enterFrom;
        private final String idOfToInvite;
        private final boolean isConversation;
        private final boolean isFollowEach;
        private final String nameOfToInvite;
        private final String roomOwnerSecId;
        private final String secIdOfToInvite;

        public static /* synthetic */ ExtraOpenParams copy$default(ExtraOpenParams r100, String r101, String r102, String r103, String r104, boolean r110, boolean r111, String r112, int r113, Object r114) {
            if ((r113 & 1) == 0) goto L6;
            r101 = r100.enterFrom;
        L6:
            if ((r113 & 2) == 0) goto L8;
            r102 = r100.idOfToInvite;
        L8:
            String r115 = r102;
            if ((r113 & 4) == 0) goto L11;
            r103 = r100.secIdOfToInvite;
        L11:
            String r105 = r103;
            if ((r113 & 8) == 0) goto L14;
            r104 = r100.nameOfToInvite;
        L14:
            String r106 = r104;
            if ((r113 & 16) == 0) goto L17;
            r110 = r100.isConversation;
        L17:
            boolean r107 = r110;
            if ((r113 & 32) == 0) goto L20;
            r111 = r100.isFollowEach;
        L20:
            boolean r108 = r111;
            if ((r113 & 64) == 0) goto L23;
            r112 = r100.roomOwnerSecId;
        L23:
            String r109 = r101;
            return r100.copy(r109, r115, r105, r106, r107, r108, r112);
        }

        public final String component1() {
            return this.enterFrom;
        }

        public final String component2() {
            return this.idOfToInvite;
        }

        public final String component3() {
            return this.secIdOfToInvite;
        }

        public final String component4() {
            return this.nameOfToInvite;
        }

        public final boolean component5() {
            return this.isConversation;
        }

        public final boolean component6() {
            return this.isFollowEach;
        }

        public final String component7() {
            return this.roomOwnerSecId;
        }

        public final ExtraOpenParams copy(String r110, String r111, String r112, String r113, boolean r114, boolean r115, String r116) {
            Intrinsics.checkNotNullParameter(r110, "enterFrom");
            Intrinsics.checkNotNullParameter(r111, "idOfToInvite");
            Intrinsics.checkNotNullParameter(r112, "secIdOfToInvite");
            Intrinsics.checkNotNullParameter(r113, "nameOfToInvite");
            Intrinsics.checkNotNullParameter(r116, "roomOwnerSecId");
            return new ExtraOpenParams(r110, r111, r112, r113, r114, r115, r116);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof ExtraOpenParams) == false) goto L20;
            ExtraOpenParams r101 = (ExtraOpenParams) r100;
            if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.idOfToInvite, r101.idOfToInvite) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.secIdOfToInvite, r101.secIdOfToInvite) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.nameOfToInvite, r101.nameOfToInvite) == true) goto L14;
            return false;
        L14:
            if (this.isConversation == r101.isConversation) goto L16;
            return false;
        L16:
            if (this.isFollowEach == r101.isFollowEach) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.roomOwnerSecId, r101.roomOwnerSecId) == true) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10, types: [int] */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            String r100 = this.enterFrom;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.idOfToInvite;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.secIdOfToInvite;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.nameOfToInvite;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            boolean r113 = this.isConversation;
            ?? r114 = 1;
            ?? r115 = r113;
            if (r113 == false) goto L21;
            r115 = 1;
        L21:
            int r116 = (r112 + r115) * 31;
            boolean r117 = this.isFollowEach;
            if (r117 == true) goto L25;
            r114 = r117;
        L25:
            int r118 = (r116 + r114) * 31;
            String r119 = this.roomOwnerSecId;
            if (r119 == null) goto L29;
            r101 = r119.hashCode();
        L29:
            return r118 + r101;
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "ExtraOpenParams(enterFrom=" + this.enterFrom + ", idOfToInvite=" + this.idOfToInvite + ", secIdOfToInvite=" + this.secIdOfToInvite + ", nameOfToInvite=" + this.nameOfToInvite + ", isConversation=" + this.isConversation + ", isFollowEach=" + this.isFollowEach + ", roomOwnerSecId=" + this.roomOwnerSecId + ")";
        }

        public final String getEnterFrom() {
            return this.enterFrom;
        }

        public final String getIdOfToInvite() {
            return this.idOfToInvite;
        }

        public final String getNameOfToInvite() {
            return this.nameOfToInvite;
        }

        public final String getRoomOwnerSecId() {
            return this.roomOwnerSecId;
        }

        public final String getSecIdOfToInvite() {
            return this.secIdOfToInvite;
        }

        public final boolean isConversation() {
            return this.isConversation;
        }

        public final boolean isFollowEach() {
            return this.isFollowEach;
        }

        public ExtraOpenParams(String r100, String r101, String r102, String r103, boolean r104, boolean r105, String r106) {
            Intrinsics.checkNotNullParameter(r100, "enterFrom");
            Intrinsics.checkNotNullParameter(r101, "idOfToInvite");
            Intrinsics.checkNotNullParameter(r102, "secIdOfToInvite");
            Intrinsics.checkNotNullParameter(r103, "nameOfToInvite");
            Intrinsics.checkNotNullParameter(r106, "roomOwnerSecId");
            this.enterFrom = r100;
            this.idOfToInvite = r101;
            this.secIdOfToInvite = r102;
            this.nameOfToInvite = r103;
            this.isConversation = r104;
            this.isFollowEach = r105;
            this.roomOwnerSecId = r106;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0015R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/shortvideo/IShortVideoComponentBase$IOnlinePlayerState;", "", "isBackground", "", "()Z", "joinTimestamp", "", "getJoinTimestamp", "()J", "linkId", "", "getLinkId", "()Ljava/lang/String;", "micState", "Lcom/bytedance/android/livesdkapi/shortvideo/IShortVideoComponentBase$IOnlinePlayerState$MicState;", "getMicState", "()Lcom/bytedance/android/livesdkapi/shortvideo/IShortVideoComponentBase$IOnlinePlayerState$MicState;", "user", "Lcom/bytedance/android/live/base/model/user/User;", "getUser", "()Lcom/bytedance/android/live/base/model/user/User;", "MicState", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IOnlinePlayerState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/shortvideo/IShortVideoComponentBase$IOnlinePlayerState$MicState;", "", "(Ljava/lang/String;I)V", "SPEAKING", "IDLE", "TURNED_OFF", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum MicState extends Enum<MicState> {
            private static final /* synthetic */ MicState[] $VALUES = null;
            public static final MicState IDLE = null;
            public static final MicState SPEAKING = null;
            public static final MicState TURNED_OFF = null;

            static {
                MicState r100 = new MicState("SPEAKING", 0);
                SPEAKING = r100;
                MicState r101 = new MicState("IDLE", 1);
                IDLE = r101;
                MicState r102 = new MicState("TURNED_OFF", 2);
                TURNED_OFF = r102;
                $VALUES = new MicState[]{r100, r101, r102};
            }

            public static MicState valueOf(String r100) {
                return (MicState) a.a(MicState.class, r100);
            }

            public static MicState[] values() {
                return (MicState[]) $VALUES.clone();
            }

            private MicState(String r100, int r101) {
                super(r100, r101);
            }
        }

        long getJoinTimestamp();

        String getLinkId();

        MicState getMicState();

        User getUser();

        boolean isBackground();
    }

    Room getCurrentRoom();

    Observable<List<IOnlinePlayerState>> getOnlinePlayerStateListObservable();
}

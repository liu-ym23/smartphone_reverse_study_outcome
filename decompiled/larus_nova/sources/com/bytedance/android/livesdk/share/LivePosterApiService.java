package com.bytedance.android.livesdk.share;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.QueryMap;
import com.google.gson.annotations.SerializedName;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0007\u0013\u0014\u0015\u0016\u0017\u0018\u0019J*\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H'J*\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H'J*\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00040\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H'J*\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H'J*\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00040\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H'J*\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/share/LivePosterApiService;", "", "grabPaidLiveTicket", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/share/LivePosterApiService$PaidLiveGrabTicketResponse;", "map", "Ljava/util/HashMap;", "", "queryLivePoster", "Lcom/bytedance/android/livesdk/share/LivePosterApiService$PosterResponse;", "queryLivePosterContent", "Lcom/bytedance/android/livesdk/share/LivePosterApiService$PosterContentResponse;", "queryPaidLiveViewRight", "Lcom/bytedance/android/livesdk/share/LivePosterApiService$PaidLiveRightResponse;", "queryShareTicketData", "Lcom/bytedance/android/livesdk/share/LivePosterApiService$PaidLiveShareTicketDataResponse;", "returnPaidLiveTicket", "Lcom/bytedance/android/livesdk/share/LivePosterApiService$ReturnPaidLiveTicketResponse;", "PaidLiveGrabTicketResponse", "PaidLiveRightResponse", "PaidLiveShareTicketDataResponse", "PosterContentResponse", "PosterImages", "PosterResponse", "ReturnPaidLiveTicketResponse", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LivePosterApiService {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/share/LivePosterApiService$PaidLiveGrabTicketResponse;", "", "retType", "", "ticketType", "ticketId", "", "fromUser", "Lcom/bytedance/android/live/base/model/user/User;", "msg", "", "(IIJLcom/bytedance/android/live/base/model/user/User;Ljava/lang/String;)V", "getFromUser", "()Lcom/bytedance/android/live/base/model/user/User;", "getMsg", "()Ljava/lang/String;", "getRetType", "()I", "getTicketId", "()J", "getTicketType", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PaidLiveGrabTicketResponse {

        @SerializedName("from_user")
        private final User fromUser;

        @SerializedName("fail_reason")
        private final String msg;

        @SerializedName("ret_type")
        private final int retType;

        @SerializedName("ticket_id")
        private final long ticketId;

        @SerializedName("ticket_type")
        private final int ticketType;

        public PaidLiveGrabTicketResponse() {
            this(0, 0, 0, null, null, 31, null);
        }

        public final User getFromUser() {
            return this.fromUser;
        }

        public final String getMsg() {
            return this.msg;
        }

        public final int getRetType() {
            return this.retType;
        }

        public final long getTicketId() {
            return this.ticketId;
        }

        public final int getTicketType() {
            return this.ticketType;
        }

        public PaidLiveGrabTicketResponse(int r100, int r101, long r102, User r103, String r104) {
            this.retType = r100;
            this.ticketType = r101;
            this.ticketId = r102;
            this.fromUser = r103;
            this.msg = r104;
        }

        public /* synthetic */ PaidLiveGrabTicketResponse(int r100, int r101, long r102, User r103, String r110, int r111, DefaultConstructorMarker r112) {
            if ((r111 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r111 & 2) == 0) goto L8;
            int r113 = 4;
        L10:
            if ((r111 & 4) == 0) goto L12;
            r102 = 0;
        L12:
            long r104 = r102;
            if ((r111 & 8) == 0) goto L15;
            r103 = null;
        L15:
            User r105 = r103;
            if ((r111 & 16) == 0) goto L18;
            r110 = "";
        L18:
            int r106 = r100;
            int r107 = r113;
            this(r106, r107, r104, r105, r110);
            return;
        L8:
            r113 = r101;
            goto L10
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/share/LivePosterApiService$PaidLiveRightResponse;", "", "viewRight", "", "fromUser", "Lcom/bytedance/android/live/base/model/user/User;", "(ILcom/bytedance/android/live/base/model/user/User;)V", "getFromUser", "()Lcom/bytedance/android/live/base/model/user/User;", "getViewRight", "()I", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PaidLiveRightResponse {

        @SerializedName("from_user")
        private final User fromUser;

        @SerializedName("view_right")
        private final int viewRight;

        /* JADX WARN: Multi-variable type inference failed */
        public PaidLiveRightResponse() {
            int r100 = 0;
            this(r100, null, 3, 0 == true ? 1 : 0);
        }

        public final User getFromUser() {
            return this.fromUser;
        }

        public final int getViewRight() {
            return this.viewRight;
        }

        public PaidLiveRightResponse(int r100, User r101) {
            this.viewRight = r100;
            this.fromUser = r101;
        }

        public /* synthetic */ PaidLiveRightResponse(int r100, User r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/share/LivePosterApiService$PaidLiveShareTicketDataResponse;", "", "title", "", "releaseTime", "", "fullPrice", "avatar", "Lcom/bytedance/android/live/base/model/ImageModel;", "greyImage", "ticketDetailUrl", "purchaseUsers", "", "Lcom/bytedance/android/live/base/model/user/User;", "purchaseUserCount", "", "(Ljava/lang/String;JLjava/lang/String;Lcom/bytedance/android/live/base/model/ImageModel;Lcom/bytedance/android/live/base/model/ImageModel;Ljava/lang/String;Ljava/util/List;I)V", "getAvatar", "()Lcom/bytedance/android/live/base/model/ImageModel;", "getFullPrice", "()Ljava/lang/String;", "getGreyImage", "getPurchaseUserCount", "()I", "getPurchaseUsers", "()Ljava/util/List;", "getReleaseTime", "()J", "getTicketDetailUrl", "getTitle", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PaidLiveShareTicketDataResponse {

        @SerializedName("original_image")
        private final ImageModel avatar;

        @SerializedName("full_price")
        private final String fullPrice;

        @SerializedName("grey_image")
        private final ImageModel greyImage;

        @SerializedName("purchase_user_count")
        private final int purchaseUserCount;

        @SerializedName("purchase_users")
        private final List<User> purchaseUsers;

        @SerializedName("release_time")
        private final long releaseTime;

        @SerializedName("ticket_detail_url")
        private final String ticketDetailUrl;

        @SerializedName("title")
        private final String title;

        public PaidLiveShareTicketDataResponse() {
            this(null, 0, null, null, null, null, null, 0, 255, null);
        }

        public final ImageModel getAvatar() {
            return this.avatar;
        }

        public final String getFullPrice() {
            return this.fullPrice;
        }

        public final ImageModel getGreyImage() {
            return this.greyImage;
        }

        public final int getPurchaseUserCount() {
            return this.purchaseUserCount;
        }

        public final List<User> getPurchaseUsers() {
            return this.purchaseUsers;
        }

        public final long getReleaseTime() {
            return this.releaseTime;
        }

        public final String getTicketDetailUrl() {
            return this.ticketDetailUrl;
        }

        public final String getTitle() {
            return this.title;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PaidLiveShareTicketDataResponse(String r100, long r101, String r102, ImageModel r103, ImageModel r104, String r105, List<? extends User> r106, int r107) {
            this.title = r100;
            this.releaseTime = r101;
            this.fullPrice = r102;
            this.avatar = r103;
            this.greyImage = r104;
            this.ticketDetailUrl = r105;
            this.purchaseUsers = r106;
            this.purchaseUserCount = r107;
        }

        public /* synthetic */ PaidLiveShareTicketDataResponse(String r110, long r111, String r112, ImageModel r113, ImageModel r114, String r115, List r116, int r117, int r210, DefaultConstructorMarker r211) {
            String r100 = "";
            if ((r210 & 1) == 0) goto L5;
            String r101 = "";
        L7:
            if ((r210 & 2) == 0) goto L9;
            long r102 = 0;
        L11:
            if ((r210 & 4) == 0) goto L13;
            String r103 = "";
        L14:
            List r104 = null;
            if ((r210 & 8) == 0) goto L17;
            ImageModel r105 = null;
        L19:
            if ((r210 & 16) == 0) goto L21;
            ImageModel r106 = null;
        L23:
            if ((r210 & 32) != 0) goto L27;
            r100 = r115;
        L27:
            if ((r210 & 64) != 0) goto L31;
            r104 = r116;
        L31:
            if ((r210 & 128) == 0) goto L33;
            int r107 = 0;
        L34:
            this(r101, r102, r103, r105, r106, r100, r104, r107);
            return;
        L33:
            r107 = r117;
            goto L34
        L21:
            r106 = r114;
            goto L23
        L17:
            r105 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L14
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = r110;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/share/LivePosterApiService$PosterContentResponse;", "", "image", "Lcom/bytedance/android/live/base/model/ImageModel;", "imageVertical", "content", "", "dateImage", "date", "(Lcom/bytedance/android/live/base/model/ImageModel;Lcom/bytedance/android/live/base/model/ImageModel;Ljava/lang/String;Lcom/bytedance/android/live/base/model/ImageModel;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getDate", "getDateImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "getImage", "getImageVertical", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PosterContentResponse {

        @SerializedName("content")
        private final String content;

        @SerializedName("date")
        private final String date;

        @SerializedName("date_image")
        private final ImageModel dateImage;

        @SerializedName("image")
        private final ImageModel image;

        @SerializedName("image_vertical")
        private final ImageModel imageVertical;

        public final String getContent() {
            return this.content;
        }

        public final String getDate() {
            return this.date;
        }

        public final ImageModel getDateImage() {
            return this.dateImage;
        }

        public final ImageModel getImage() {
            return this.image;
        }

        public final ImageModel getImageVertical() {
            return this.imageVertical;
        }

        public PosterContentResponse(ImageModel r100, ImageModel r101, String r102, ImageModel r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "image");
            Intrinsics.checkNotNullParameter(r101, "imageVertical");
            Intrinsics.checkNotNullParameter(r102, "content");
            Intrinsics.checkNotNullParameter(r103, "dateImage");
            Intrinsics.checkNotNullParameter(r104, "date");
            this.image = r100;
            this.imageVertical = r101;
            this.content = r102;
            this.dateImage = r103;
            this.date = r104;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/share/LivePosterApiService$PosterImages;", "", "preImage", "Lcom/bytedance/android/live/base/model/ImageModel;", "saveImage", "(Lcom/bytedance/android/live/base/model/ImageModel;Lcom/bytedance/android/live/base/model/ImageModel;)V", "getPreImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "getSaveImage", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PosterImages {

        @SerializedName("preview_image")
        private final ImageModel preImage;

        @SerializedName("image")
        private final ImageModel saveImage;

        /* JADX WARN: Multi-variable type inference failed */
        public PosterImages() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public final ImageModel getPreImage() {
            return this.preImage;
        }

        public final ImageModel getSaveImage() {
            return this.saveImage;
        }

        public PosterImages(ImageModel r100, ImageModel r101) {
            this.preImage = r100;
            this.saveImage = r101;
        }

        public /* synthetic */ PosterImages(ImageModel r100, ImageModel r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0002\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/share/LivePosterApiService$PosterResponse;", "", "image", "Lcom/bytedance/android/live/base/model/ImageModel;", "shareOrder", "", "shareContent", "", "posterOrder", "", "posterNumber", "posterText", "posters", "", "Lcom/bytedance/android/livesdk/share/LivePosterApiService$PosterImages;", "(Lcom/bytedance/android/live/base/model/ImageModel;JLjava/lang/String;IILjava/lang/String;Ljava/util/List;)V", "getImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "getPosterNumber", "()I", "getPosterOrder", "getPosterText", "()Ljava/lang/String;", "getPosters", "()Ljava/util/List;", "getShareContent", "getShareOrder", "()J", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PosterResponse {

        @SerializedName("image")
        private final ImageModel image;

        @SerializedName("poster_nums")
        private final int posterNumber;

        @SerializedName("poster_order")
        private final int posterOrder;

        @SerializedName("poster_text")
        private final String posterText;

        @SerializedName("image_list")
        private final List<PosterImages> posters;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHARE_CONTENT)
        private final String shareContent;

        @SerializedName("share_order")
        private final long shareOrder;

        public final ImageModel getImage() {
            return this.image;
        }

        public final int getPosterNumber() {
            return this.posterNumber;
        }

        public final int getPosterOrder() {
            return this.posterOrder;
        }

        public final String getPosterText() {
            return this.posterText;
        }

        public final List<PosterImages> getPosters() {
            return this.posters;
        }

        public final String getShareContent() {
            return this.shareContent;
        }

        public final long getShareOrder() {
            return this.shareOrder;
        }

        public PosterResponse(ImageModel r100, long r101, String r102, int r103, int r104, String r105, List<PosterImages> r106) {
            Intrinsics.checkNotNullParameter(r100, "image");
            Intrinsics.checkNotNullParameter(r102, "shareContent");
            this.image = r100;
            this.shareOrder = r101;
            this.shareContent = r102;
            this.posterOrder = r103;
            this.posterNumber = r104;
            this.posterText = r105;
            this.posters = r106;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/share/LivePosterApiService$ReturnPaidLiveTicketResponse;", "", "retType", "", "ticketId", "", "msg", "", "(IJLjava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "getRetType", "()I", "getTicketId", "()J", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ReturnPaidLiveTicketResponse {

        @SerializedName("fail_reason")
        private final String msg;

        @SerializedName("ret_type")
        private final int retType;

        @SerializedName("ticket_id")
        private final long ticketId;

        public ReturnPaidLiveTicketResponse() {
            this(0, 0, null, 7, null);
        }

        public final String getMsg() {
            return this.msg;
        }

        public final int getRetType() {
            return this.retType;
        }

        public final long getTicketId() {
            return this.ticketId;
        }

        public ReturnPaidLiveTicketResponse(int r100, long r101, String r102) {
            this.retType = r100;
            this.ticketId = r101;
            this.msg = r102;
        }

        public /* synthetic */ ReturnPaidLiveTicketResponse(int r100, long r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = 0;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = "";
        L11:
            this(r100, r101, r102);
        }
    }

    @GET("/webcast/room/paid_live_grab_ticket/")
    Observable<Response<PaidLiveGrabTicketResponse>> grabPaidLiveTicket(@QueryMap HashMap<String, String> r100);

    @GET("/webcast/room/poster/")
    Observable<Response<PosterResponse>> queryLivePoster(@QueryMap HashMap<String, String> r100);

    @GET("/webcast/room/poster_content/")
    Observable<Response<PosterContentResponse>> queryLivePosterContent(@QueryMap HashMap<String, String> r100);

    @GET("/webcast/room/paid_live_view_right/")
    Observable<Response<PaidLiveRightResponse>> queryPaidLiveViewRight(@QueryMap HashMap<String, String> r100);

    @GET("/webcast/room/paid_live_ticket_data/")
    Observable<Response<PaidLiveShareTicketDataResponse>> queryShareTicketData(@QueryMap HashMap<String, String> r100);

    @GET("/webcast/room/paid_live_share_ticket_return/")
    Observable<Response<ReturnPaidLiveTicketResponse>> returnPaidLiveTicket(@QueryMap HashMap<String, String> r100);
}

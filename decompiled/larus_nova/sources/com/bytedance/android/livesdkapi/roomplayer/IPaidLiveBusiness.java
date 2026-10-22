package com.bytedance.android.livesdkapi.roomplayer;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/IPaidLiveBusiness;", "Lcom/bytedance/android/livesdkapi/roomplayer/IPlayerBusiness;", "ShareTicketResponse", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPaidLiveBusiness extends IPlayerBusiness {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/IPaidLiveBusiness$ShareTicketResponse;", "", "", "canGetShareTicket", "", "totalCount", "J", "getTotalCount", "()J", "receiveCount", "getReceiveCount", "", "panelUrl", "Ljava/lang/String;", "getPanelUrl", "()Ljava/lang/String;", "investorUrl", "getInvestorUrl", "Lpy/k;", "cover", "Lpy/k;", "getCover", "()Lpy/k;", "<init>", "(JJLjava/lang/String;Ljava/lang/String;Lpy/k;)V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ShareTicketResponse {

        @SerializedName("guide_img")
        private final k cover;

        @SerializedName("investor_url")
        private final String investorUrl;

        @SerializedName("share_ticket_url")
        private final String panelUrl;

        @SerializedName("receive_count")
        private final long receiveCount;

        @SerializedName(a.KEY_TOTAL_COUNT)
        private final long totalCount;

        public ShareTicketResponse() {
            this(0, 0, null, null, null, 31, null);
        }

        public final boolean canGetShareTicket() {
            if (this.totalCount <= this.receiveCount) goto L5;
            return true;
        L5:
            return false;
        }

        public final k getCover() {
            return this.cover;
        }

        public final String getInvestorUrl() {
            return this.investorUrl;
        }

        public final String getPanelUrl() {
            return this.panelUrl;
        }

        public final long getReceiveCount() {
            return this.receiveCount;
        }

        public final long getTotalCount() {
            return this.totalCount;
        }

        public ShareTicketResponse(long r100, long r101, String r102, String r103, k r104) {
            this.totalCount = r100;
            this.receiveCount = r101;
            this.panelUrl = r102;
            this.investorUrl = r103;
            this.cover = r104;
        }

        public /* synthetic */ ShareTicketResponse(long r100, long r101, String r110, String r111, k r112, int r113, DefaultConstructorMarker r114) {
            long r102 = 0;
            if ((r113 & 1) == 0) goto L5;
            long r103 = 0;
        L7:
            if ((r113 & 2) != 0) goto L11;
            r102 = r101;
        L11:
            if ((r113 & 4) == 0) goto L13;
            String r115 = "";
        L15:
            if ((r113 & 8) == 0) goto L17;
            String r104 = "";
        L19:
            if ((r113 & 16) == 0) goto L21;
            r112 = null;
        L21:
            this(r103, r102, r115, r104, r112);
            return;
        L17:
            r104 = r111;
            goto L19
        L13:
            r115 = r110;
            goto L15
        L5:
            r103 = r100;
            goto L7
        }
    }
}

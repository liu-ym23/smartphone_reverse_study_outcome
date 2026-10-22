package com.bytedance.android.livesdkapi.depend.model.live.pay;

import com.bytedance.android.livesdkapi.depend.model.live.episode.IAsyncAuthData;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.pay.main.IMainPaidLiveData;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class PaidLiveData extends FlexModelBase<IPaidLiveData> implements IPaidLiveData {
    public static final int CREATE_AND_SELL_PERMISSION = 3;
    public static final int CREATE_PAID_LIVE_PERMISSION = 1;
    public static final int DATA_TYPE_PAID_CAMERA = 1;
    public static final int DATA_TYPE_PAID_ROOM = 0;
    public static final int DELIVERY_DONE = 1;
    public static final int DELIVERY_UNDONE = 0;
    public static final int NO_PERMISSION = 0;
    public static final int RIGHT_FRIEND = 3;
    public static final int RIGHT_HELP = 4;
    public static final int RIGHT_NONE = 0;
    public static final int RIGHT_PAID = 1;
    public static final int RIGHT_VIP = 9;
    public static final int RIGHT_WHITE = 2;
    public static final int SELL_TICKET_PERMISSION = 2;
    public String dataId;
    public int dataType;

    @SerializedName("paid_type")
    public int paidType;

    @SerializedName("view_right")
    public int viewRight;

    public static class JumpType {
        public static int PAID_PANEL = 1;

        public JumpType() {
        }
    }

    public PaidLiveData() {
        super(IPaidLiveData.class);
        this.dataType = 0;
        this.dataId = "";
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveDataEx
    public Long getAsyncAuthAB() {
        IMainPaidLiveData r100 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r100 == null) goto L9;
        if (r100.getAsyncAuthData() == null) goto L9;
        return Long.valueOf(r100.getAsyncAuthData().asyncAuthAB);
    L9:
        return 0L;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveDataEx
    public AsyncAuthData getAsyncAuthData() {
        IMainPaidLiveData r100 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.getAsyncAuthData() != null) goto L7;
        return null;
    L7:
        return r100.getAsyncAuthData();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveDataEx
    /* JADX INFO: renamed from: getDelivery */
    public Integer mo8272getDelivery() {
        IMainPaidLiveData r100 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r100 == null) goto L7;
        return Integer.valueOf(r100.getDelivery());
    L7:
        return 0;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveDataEx
    /* JADX INFO: renamed from: getDuration */
    public Long mo8273getDuration() {
        IMainPaidLiveData r100 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r100 != null) goto L5;
        return null;
    L5:
        return Long.valueOf(r100.getDuration());
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveDataEx
    public Long getKeepAliveTime() {
        IMainPaidLiveData r100 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r100 == null) goto L9;
        if (r100.getAsyncAuthData() == null) goto L9;
        return Long.valueOf(r100.getAsyncAuthData().keepAliveTime);
    L9:
        return 0L;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveDataEx
    /* JADX INFO: renamed from: getMaxViewDuration */
    public Long mo8274getMaxViewDuration() {
        IMainPaidLiveData r100 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r100 != null) goto L5;
        return null;
    L5:
        return Long.valueOf(r100.getMaxViewDuration());
    }

    public Integer getPaidLiveAnchorRight() {
        IMainPaidLiveData r100 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r100 != null) goto L5;
        return null;
    L5:
        return Integer.valueOf(r100.getPaidLiveAnchorRight());
    }

    public PaidProductData getPaidProductData() {
        IMainPaidLiveData r100 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r100 != null) goto L8;
    L6:
        return null;
    L8:
        return r100.getProductsData();
    }

    public Map<String, PrivilegeInfo> getPrivilegeInfo() {
        IMainPaidLiveData r100 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getPrivilegeInfo();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveDataEx
    public Boolean getShowDeliveryTip() {
        IMainPaidLiveData r100 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r100 != null) goto L5;
        return null;
    L5:
        return Boolean.valueOf(r100.mo8275getShowDeliveryTip());
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveDataEx
    public int getSubscribeRoomViewRight() {
        IMainPaidLiveData r100 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r100 != null) goto L8;
    L6:
        return 0;
    L8:
        return r100.getPrivilegeInfo().get(String.valueOf(101)).entityConfig.userRight.viewRight;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveDataEx
    public String getSubscribeRoomWatchStatus() {
        IMainPaidLiveData r100 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r100 != null) goto L8;
    L6:
        return null;
    L8:
        return r100.getPrivilegeInfo().get(String.valueOf(101)).getWatchStatus();
    }

    public Long getTempWatchBuffer() {
        IMainPaidLiveData r100 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r100 == null) goto L9;
        if (r100.getAsyncAuthData() == null) goto L9;
        return Long.valueOf(r100.getAsyncAuthData().tempWatchBuffer);
    L9:
        return 0L;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveDataEx
    public ITicketData getTicketSession() {
        IMainPaidLiveData r100 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getTicketSession();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveDataEx
    public Long needRefreshStream() {
        IMainPaidLiveData r100 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r100 == null) goto L9;
        if (r100.getAsyncAuthData() == null) goto L9;
        return Long.valueOf(r100.getAsyncAuthData().needRefreshStream);
    L9:
        return 0L;
    }

    public String toString() {
        return "PaidLiveData{paidType=" + this.paidType + ", viewRight=" + this.viewRight + ", dataType=" + this.dataType + ", dataId='" + this.dataId + ", keepAliveTime=" + getKeepAliveTime() + ", asyncAuthAb=" + getAsyncAuthAB() + ", buffer=" + getTempWatchBuffer() + ", needRefreshStream=" + needRefreshStream() + "'}";
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveDataEx
    public String getDataId() {
        return this.dataId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveDataEx
    public int getDataType() {
        return this.dataType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveData
    public int getPaidType() {
        return this.paidType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveData
    public int getViewRight() {
        return this.viewRight;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveDataEx
    public /* bridge */ /* synthetic */ IAsyncAuthData getAsyncAuthData() {
        return getAsyncAuthData();
    }

    public void setAsyncAuthData(AsyncAuthData r100) {
        IMainPaidLiveData r101 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r101 == null) goto L6;
        r101.setAsyncAuthData(r100);
        return;
    }

    public void setDelivery(int r100) {
        IMainPaidLiveData r101 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r101 == null) goto L6;
        r101.setDelivery(r100);
        return;
    }

    public void setDuration(long r100) {
        IMainPaidLiveData r101 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r101 == null) goto L6;
        r101.setDuration(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveDataEx
    public void setKeepAliveTime(long r100) {
        IMainPaidLiveData r101 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getAsyncAuthData() == null) goto L9;
        r101.getAsyncAuthData().keepAliveTime = r100;
        return;
    }

    public void setPaidLiveAnchorRight(int r100) {
        IMainPaidLiveData r101 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r101 == null) goto L6;
        r101.setPaidLiveAnchorRight(r100);
        return;
    }

    public void setPrivilegeInfo(Map<String, PrivilegeInfo> r100) {
        IMainPaidLiveData r101 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r101 == null) goto L6;
        r101.setPrivilegeInfo(r100);
        return;
    }

    public void setShowDeliveryTip(boolean r100) {
        IMainPaidLiveData r101 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r101 == null) goto L6;
        r101.setShowDeliveryTip(r100);
        return;
    }

    public void setTicketSession(TicketData r100) {
        IMainPaidLiveData r101 = (IMainPaidLiveData) castToOrNull(IMainPaidLiveData.class);
        if (r101 == null) goto L6;
        r101.setTicketSession(r100);
        return;
    }
}

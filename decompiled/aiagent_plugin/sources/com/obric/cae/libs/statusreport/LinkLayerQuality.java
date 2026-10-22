package com.obric.cae.libs.statusreport;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class LinkLayerQuality implements Parcelable {
    public static final Parcelable.Creator<LinkLayerQuality> CREATOR = null;
    private static final String TAG = "LinkLayerQuality";
    private int arpNeighbourCount;
    private String band;
    private String band1;
    private int ccaScore;
    private int contentionAtimeBk;
    private int contentionAtimeVi;
    private int currentChannelAPCount;
    private List<Integer> delaySizeMatrix;
    private int deltaRxBytes;
    private int deltaRxFcsErr;
    private int deltaTxBytes;
    private int delta_channel_cca_busy_time;
    private int delta_channel_on_time;
    private int delta_channel_rx_time;
    private int delta_channel_tx_time;
    private int freq;
    private String ifName;
    private boolean is_mlo_iface;
    private List<LinkStatsParcel> linkStats;
    private int perScore;
    private int rssiScore;
    private int rxBw;
    private int rxFcsErrLevel;
    private int rxMcs;
    private int rxMode;
    private int rxNss;
    private int rxRealSpeed;
    private int rxTputPred;
    private int rxlink_speed;
    private int scenario;
    private int totalRxBytes;
    private int totalTxBytes;
    private int txBw;
    private float txDelayAvg;
    private float txDelayP10;
    private float txDelayP90;
    private long txDelayPkts;
    private int txMcs;
    private int txMode;
    private int txNss;
    private int txRealSpeed;
    private int txTputPred;
    private int txlink_speed;
    private String wifiGeneration;
    private int wifiStandard;

    public class a implements Parcelable.Creator<LinkLayerQuality> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LinkLayerQuality createFromParcel(Parcel r5) {
            LinkLayerQuality r4 = new LinkLayerQuality();
            LinkLayerQuality.a(r4, r5.readString());
            LinkLayerQuality.b(r4, r5.readInt());
            LinkLayerQuality.m(r4, r5.readInt());
            LinkLayerQuality.x(r4, r5.readInt());
            LinkLayerQuality.b(r4, r5.readString());
            LinkLayerQuality.c(r4, r5.readString());
            LinkLayerQuality.d(r4, r5.readString());
            LinkLayerQuality.F(r4, r5.readInt());
            LinkLayerQuality.G(r4, r5.readInt());
            LinkLayerQuality.H(r4, r5.readInt());
            LinkLayerQuality.a(r4, r5.readInt());
            LinkLayerQuality.c(r4, r5.readInt());
            LinkLayerQuality.d(r4, r5.readInt());
            LinkLayerQuality.e(r4, r5.readInt());
            LinkLayerQuality.f(r4, r5.readInt());
            LinkLayerQuality.g(r4, r5.readInt());
            LinkLayerQuality.h(r4, r5.readInt());
            LinkLayerQuality.i(r4, r5.readInt());
            LinkLayerQuality.j(r4, r5.readInt());
            LinkLayerQuality.k(r4, r5.readInt());
            LinkLayerQuality.l(r4, r5.readInt());
            LinkLayerQuality.n(r4, r5.readInt());
            LinkLayerQuality.o(r4, r5.readInt());
            LinkLayerQuality.p(r4, r5.readInt());
            LinkLayerQuality.q(r4, r5.readInt());
            LinkLayerQuality.r(r4, r5.readInt());
            LinkLayerQuality.s(r4, r5.readInt());
            LinkLayerQuality.t(r4, r5.readInt());
            LinkLayerQuality.u(r4, r5.readInt());
            LinkLayerQuality.v(r4, r5.readInt());
            LinkLayerQuality.w(r4, r5.readInt());
            LinkLayerQuality.y(r4, r5.readInt());
            LinkLayerQuality.z(r4, r5.readInt());
            int r1 = 0;
            if (r5.readByte() == 0) goto L5;
            boolean r0 = true;
        L6:
            LinkLayerQuality.a(r4, r0);
            r5.readTypedList(LinkLayerQuality.a(r4), LinkStatsParcel.CREATOR);
            LinkLayerQuality.A(r4, r5.readInt());
            LinkLayerQuality.B(r4, r5.readInt());
            LinkLayerQuality.C(r4, r5.readInt());
            LinkLayerQuality.D(r4, r5.readInt());
            LinkLayerQuality.E(r4, r5.readInt());
            LinkLayerQuality.a(r4, r5.readFloat());
            LinkLayerQuality.b(r4, r5.readFloat());
            LinkLayerQuality.c(r4, r5.readFloat());
            LinkLayerQuality.a(r4, r5.readLong());
            int r2 = r5.readInt();
            LinkLayerQuality.a(r4, new ArrayList(r2));
        L7:
            if (r1 >= r2) goto L9;
            LinkLayerQuality.b(r4).add(Integer.valueOf(r5.readInt()));
            r1 = r1 + 1;
            goto L7
        L9:
            return r4;
        L5:
            r0 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final LinkLayerQuality[] newArray(int r1) {
            return new LinkLayerQuality[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public LinkLayerQuality() {
        this.linkStats = new ArrayList();
        this.delaySizeMatrix = new ArrayList();
    }

    public static /* synthetic */ void A(LinkLayerQuality r0, int r1) {
        r0.rxTputPred = r1;
    }

    public static /* synthetic */ void B(LinkLayerQuality r0, int r1) {
        r0.txTputPred = r1;
    }

    public static /* synthetic */ void C(LinkLayerQuality r0, int r1) {
        r0.wifiStandard = r1;
    }

    public static /* synthetic */ void D(LinkLayerQuality r0, int r1) {
        r0.contentionAtimeBk = r1;
    }

    public static /* synthetic */ void E(LinkLayerQuality r0, int r1) {
        r0.contentionAtimeVi = r1;
    }

    public static /* synthetic */ void F(LinkLayerQuality r0, int r1) {
        r0.deltaRxFcsErr = r1;
    }

    public static /* synthetic */ void G(LinkLayerQuality r0, int r1) {
        r0.rxFcsErrLevel = r1;
    }

    public static /* synthetic */ void H(LinkLayerQuality r0, int r1) {
        r0.totalTxBytes = r1;
    }

    public static /* synthetic */ void a(LinkLayerQuality r0, String r1) {
        r0.ifName = r1;
    }

    public static /* synthetic */ void b(LinkLayerQuality r0, int r1) {
        r0.freq = r1;
    }

    public static /* synthetic */ void c(LinkLayerQuality r0, int r1) {
        r0.txRealSpeed = r1;
    }

    public static /* synthetic */ void d(LinkLayerQuality r0, int r1) {
        r0.totalRxBytes = r1;
    }

    public static /* synthetic */ void e(LinkLayerQuality r0, int r1) {
        r0.deltaRxBytes = r1;
    }

    public static /* synthetic */ void f(LinkLayerQuality r0, int r1) {
        r0.rxRealSpeed = r1;
    }

    public static /* synthetic */ void g(LinkLayerQuality r0, int r1) {
        r0.txMode = r1;
    }

    public static /* synthetic */ void h(LinkLayerQuality r0, int r1) {
        r0.txMcs = r1;
    }

    public static /* synthetic */ void i(LinkLayerQuality r0, int r1) {
        r0.txBw = r1;
    }

    public static /* synthetic */ void j(LinkLayerQuality r0, int r1) {
        r0.txNss = r1;
    }

    public static /* synthetic */ void k(LinkLayerQuality r0, int r1) {
        r0.rxMode = r1;
    }

    public static /* synthetic */ void l(LinkLayerQuality r0, int r1) {
        r0.rxMcs = r1;
    }

    public static /* synthetic */ void m(LinkLayerQuality r0, int r1) {
        r0.txlink_speed = r1;
    }

    public static /* synthetic */ void n(LinkLayerQuality r0, int r1) {
        r0.rxBw = r1;
    }

    public static /* synthetic */ void o(LinkLayerQuality r0, int r1) {
        r0.rxNss = r1;
    }

    public static /* synthetic */ void p(LinkLayerQuality r0, int r1) {
        r0.delta_channel_on_time = r1;
    }

    public static /* synthetic */ void q(LinkLayerQuality r0, int r1) {
        r0.delta_channel_tx_time = r1;
    }

    public static /* synthetic */ void r(LinkLayerQuality r0, int r1) {
        r0.delta_channel_rx_time = r1;
    }

    public static /* synthetic */ void s(LinkLayerQuality r0, int r1) {
        r0.delta_channel_cca_busy_time = r1;
    }

    public static /* synthetic */ void t(LinkLayerQuality r0, int r1) {
        r0.ccaScore = r1;
    }

    public static /* synthetic */ void u(LinkLayerQuality r0, int r1) {
        r0.perScore = r1;
    }

    public static /* synthetic */ void v(LinkLayerQuality r0, int r1) {
        r0.rssiScore = r1;
    }

    public static /* synthetic */ void w(LinkLayerQuality r0, int r1) {
        r0.scenario = r1;
    }

    public static /* synthetic */ void x(LinkLayerQuality r0, int r1) {
        r0.rxlink_speed = r1;
    }

    public static /* synthetic */ void y(LinkLayerQuality r0, int r1) {
        r0.currentChannelAPCount = r1;
    }

    public static /* synthetic */ void z(LinkLayerQuality r0, int r1) {
        r0.arpNeighbourCount = r1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getArpNeighbourCount() {
        return this.arpNeighbourCount;
    }

    public String getBand() {
        return this.band;
    }

    public String getBand1() {
        return this.band1;
    }

    public int getCcaScore() {
        return this.ccaScore;
    }

    public int getContentionAtimeBk() {
        return this.contentionAtimeBk;
    }

    public int getContentionAtimeVi() {
        return this.contentionAtimeVi;
    }

    public int getCurrentChannelAPCount() {
        return this.currentChannelAPCount;
    }

    public List<Integer> getDelaySizeMatrix() {
        return this.delaySizeMatrix;
    }

    public int getDeltaRxBytes() {
        return this.deltaRxBytes;
    }

    public int getDeltaRxFcsErr() {
        return this.deltaRxFcsErr;
    }

    public int getDeltaTxBytes() {
        return this.deltaTxBytes;
    }

    public int getDelta_channel_cca_busy_time() {
        return this.delta_channel_cca_busy_time;
    }

    public int getDelta_channel_on_time() {
        return this.delta_channel_on_time;
    }

    public int getDelta_channel_rx_time() {
        return this.delta_channel_rx_time;
    }

    public int getDelta_channel_tx_time() {
        return this.delta_channel_tx_time;
    }

    public int getFreq() {
        return this.freq;
    }

    public String getIfName() {
        return this.ifName;
    }

    public List<LinkStatsParcel> getLinkStats() {
        return this.linkStats;
    }

    public int getPerScore() {
        return this.perScore;
    }

    public int getRssiScore() {
        return this.rssiScore;
    }

    public int getRxBw() {
        return this.rxBw;
    }

    public int getRxFcsErrLevel() {
        return this.rxFcsErrLevel;
    }

    public int getRxMcs() {
        return this.rxMcs;
    }

    public int getRxMode() {
        return this.rxMode;
    }

    public int getRxNss() {
        return this.rxNss;
    }

    public int getRxRealSpeed() {
        return this.rxRealSpeed;
    }

    public int getRxTputPred() {
        return this.rxTputPred;
    }

    public int getRxlinkSpeed() {
        return this.rxlink_speed;
    }

    public int getScenario() {
        return this.scenario;
    }

    public int getTotalRxBytes() {
        return this.totalRxBytes;
    }

    public int getTotalTxBytes() {
        return this.totalTxBytes;
    }

    public int getTxBw() {
        return this.txBw;
    }

    public float getTxDelayAvg() {
        return this.txDelayAvg;
    }

    public float getTxDelayP10() {
        return this.txDelayP10;
    }

    public float getTxDelayP90() {
        return this.txDelayP90;
    }

    public long getTxDelayPkts() {
        return this.txDelayPkts;
    }

    public int getTxMcs() {
        return this.txMcs;
    }

    public int getTxMode() {
        return this.txMode;
    }

    public int getTxNss() {
        return this.txNss;
    }

    public int getTxRealSpeed() {
        return this.txRealSpeed;
    }

    public int getTxTputPred() {
        return this.txTputPred;
    }

    public int getTxlinkSpeed() {
        return this.txlink_speed;
    }

    public String getWifiGeneration() {
        return this.wifiGeneration;
    }

    public int getWifiStandard() {
        return this.wifiStandard;
    }

    public boolean isMloIface() {
        return this.is_mlo_iface;
    }

    public void setArpNeighbourCount(int r1) {
        this.arpNeighbourCount = r1;
    }

    public void setBand(String r1) {
        this.band = r1;
    }

    public void setBand1(String r1) {
        this.band1 = r1;
    }

    public void setCcaScore(int r1) {
        this.ccaScore = r1;
    }

    public void setContentionAtimeBk(int r1) {
        this.contentionAtimeBk = r1;
    }

    public void setContentionAtimeVi(int r1) {
        this.contentionAtimeVi = r1;
    }

    public void setCurrentChannelAPCount(int r1) {
        this.currentChannelAPCount = r1;
    }

    public void setDelaySizeMatrix(List<Integer> r3) {
        this.delaySizeMatrix = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public void setDeltaRxBytes(int r1) {
        this.deltaRxBytes = r1;
    }

    public void setDeltaRxFcsErr(int r1) {
        this.deltaRxFcsErr = r1;
    }

    public void setDeltaTxBytes(int r1) {
        this.deltaTxBytes = r1;
    }

    public void setDelta_channel_cca_busy_time(int r1) {
        this.delta_channel_cca_busy_time = r1;
    }

    public void setDelta_channel_on_time(int r1) {
        this.delta_channel_on_time = r1;
    }

    public void setDelta_channel_rx_time(int r1) {
        this.delta_channel_rx_time = r1;
    }

    public void setDelta_channel_tx_time(int r1) {
        this.delta_channel_tx_time = r1;
    }

    public void setFreq(int r1) {
        this.freq = r1;
    }

    public void setIfName(String r1) {
        this.ifName = r1;
    }

    public void setLinkStats(List<LinkStatsParcel> r3) {
        this.linkStats = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public void setMloIface(boolean r1) {
        this.is_mlo_iface = r1;
    }

    public void setPerScore(int r1) {
        this.perScore = r1;
    }

    public void setRssiScore(int r1) {
        this.rssiScore = r1;
    }

    public void setRxBw(int r1) {
        this.rxBw = r1;
    }

    public void setRxFcsErrLevel(int r1) {
        this.rxFcsErrLevel = r1;
    }

    public void setRxMcs(int r1) {
        this.rxMcs = r1;
    }

    public void setRxMode(int r1) {
        this.rxMode = r1;
    }

    public void setRxNss(int r1) {
        this.rxNss = r1;
    }

    public void setRxRealSpeed(int r1) {
        this.rxRealSpeed = r1;
    }

    public void setRxTputPred(int r1) {
        this.rxTputPred = r1;
    }

    public void setRxlinkSpeed(int r1) {
        this.rxlink_speed = r1;
    }

    public void setScenario(int r1) {
        this.scenario = r1;
    }

    public void setTotalRxBytes(int r1) {
        this.totalRxBytes = r1;
    }

    public void setTotalTxBytes(int r1) {
        this.totalTxBytes = r1;
    }

    public void setTxBw(int r1) {
        this.txBw = r1;
    }

    public void setTxDelayAvg(float r1) {
        this.txDelayAvg = r1;
    }

    public void setTxDelayP10(float r1) {
        this.txDelayP10 = r1;
    }

    public void setTxDelayP90(float r1) {
        this.txDelayP90 = r1;
    }

    public void setTxDelayPkts(long r1) {
        this.txDelayPkts = r1;
    }

    public void setTxMcs(int r1) {
        this.txMcs = r1;
    }

    public void setTxMode(int r1) {
        this.txMode = r1;
    }

    public void setTxNss(int r1) {
        this.txNss = r1;
    }

    public void setTxRealSpeed(int r1) {
        this.txRealSpeed = r1;
    }

    public void setTxTputPred(int r1) {
        this.txTputPred = r1;
    }

    public void setTxlinkSpeed(int r1) {
        this.txlink_speed = r1;
    }

    public void setWifiGeneration(String r1) {
        this.wifiGeneration = r1;
    }

    public void setWifiStandard(int r1) {
        this.wifiStandard = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(" LinkLayerQuality:  ifName: ");
        r0.append(this.ifName);
        r0.append(" freq: ").append(this.freq);
        r0.append(" txlink_speed: ").append(this.txlink_speed);
        r0.append(" rxlink_speed: ").append(this.rxlink_speed);
        r0.append(" band: ").append(this.band);
        r0.append(" band1: ").append(this.band1);
        r0.append(" wifiGeneration: ").append(this.wifiGeneration);
        r0.append(" deltaRxFcsErr: ").append(this.deltaRxFcsErr);
        r0.append(" rxFcsErrLevel: ").append(this.rxFcsErrLevel);
        r0.append(" totalTxBytes: ").append(this.totalTxBytes);
        r0.append(" deltaTxBytes: ").append(this.deltaTxBytes);
        r0.append(" txRealSpeed: ").append(this.txRealSpeed);
        r0.append(" totalRxBytes: ").append(this.totalRxBytes);
        r0.append(" deltaRxBytes: ").append(this.deltaRxBytes);
        r0.append(" rxRealSpeed: ").append(this.rxRealSpeed);
        r0.append(" txMode: ").append(this.txMode);
        r0.append(" txMcs: ").append(this.txMcs);
        r0.append(" txBw: ").append(this.txBw);
        r0.append(" txNss: ").append(this.txNss);
        r0.append(" rxMode: ").append(this.rxMode);
        r0.append(" rxMcs: ").append(this.rxMcs);
        r0.append(" rxBw: ").append(this.rxBw);
        r0.append(" rxNss: ").append(this.rxNss);
        r0.append(" delta_channel_on_time: ").append(this.delta_channel_on_time);
        r0.append(" delta_channel_tx_time: ").append(this.delta_channel_tx_time);
        r0.append(" delta_channel_rx_time: ").append(this.delta_channel_rx_time);
        r0.append(" delta_channel_cca_busy_time: ").append(this.delta_channel_cca_busy_time);
        r0.append(" ccaScore: ").append(this.ccaScore);
        r0.append(" perScore: ").append(this.perScore);
        r0.append(" rssiScore: ").append(this.rssiScore);
        r0.append(" scenario: ").append(this.scenario);
        r0.append(" currentChannelAPCount: ").append(this.currentChannelAPCount);
        r0.append(" arpNeighbourCount: ").append(this.arpNeighbourCount);
        r0.append(" is_mlo_iface: ").append(this.is_mlo_iface);
        if (this.linkStats == null) goto L5;
        r0.append(" linkStats size: ").append(this.linkStats.size());
    L6:
        r0.append(" rxTputPred: ").append(this.rxTputPred);
        r0.append(" txTputPred: ").append(this.txTputPred);
        r0.append(" wifiStandard: ").append(this.wifiStandard);
        r0.append(" contentionAtimeBk: ").append(this.contentionAtimeBk);
        r0.append(" contentionAtimeVi: ").append(this.contentionAtimeVi);
        r0.append(" txDelayAvg: ").append(this.txDelayAvg);
        r0.append(" txDelayP10: ").append(this.txDelayP10);
        r0.append(" txDelayP90: ").append(this.txDelayP90);
        r0.append(" txDelayPkts: ").append(this.txDelayPkts);
        if (this.delaySizeMatrix == null) goto L9;
        r0.append(" delaySizeMatrix size: ").append(this.delaySizeMatrix.size());
    L11:
        return r0.toString();
    L9:
        r0.append(" delaySizeMatrix is null");
        goto L11
    L5:
        r0.append(" linkStats is null");
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        r4.writeString(this.ifName);
        r4.writeInt(this.freq);
        r4.writeInt(this.txlink_speed);
        r4.writeInt(this.rxlink_speed);
        r4.writeString(this.band);
        r4.writeString(this.band1);
        r4.writeString(this.wifiGeneration);
        r4.writeInt(this.deltaRxFcsErr);
        r4.writeInt(this.rxFcsErrLevel);
        r4.writeInt(this.totalTxBytes);
        r4.writeInt(this.deltaTxBytes);
        r4.writeInt(this.txRealSpeed);
        r4.writeInt(this.totalRxBytes);
        r4.writeInt(this.deltaRxBytes);
        r4.writeInt(this.rxRealSpeed);
        r4.writeInt(this.txMode);
        r4.writeInt(this.txMcs);
        r4.writeInt(this.txBw);
        r4.writeInt(this.txNss);
        r4.writeInt(this.rxMode);
        r4.writeInt(this.rxMcs);
        r4.writeInt(this.rxBw);
        r4.writeInt(this.rxNss);
        r4.writeInt(this.delta_channel_on_time);
        r4.writeInt(this.delta_channel_tx_time);
        r4.writeInt(this.delta_channel_rx_time);
        r4.writeInt(this.delta_channel_cca_busy_time);
        r4.writeInt(this.ccaScore);
        r4.writeInt(this.perScore);
        r4.writeInt(this.rssiScore);
        r4.writeInt(this.scenario);
        r4.writeInt(this.currentChannelAPCount);
        r4.writeInt(this.arpNeighbourCount);
        r4.writeByte(this.is_mlo_iface ? 1 : 0);
        r4.writeTypedList(this.linkStats);
        r4.writeInt(this.rxTputPred);
        r4.writeInt(this.txTputPred);
        r4.writeInt(this.wifiStandard);
        r4.writeInt(this.contentionAtimeBk);
        r4.writeInt(this.contentionAtimeVi);
        r4.writeFloat(this.txDelayAvg);
        r4.writeFloat(this.txDelayP10);
        r4.writeFloat(this.txDelayP90);
        r4.writeLong(this.txDelayPkts);
        List<Integer> r6 = this.delaySizeMatrix;
        if (r6 == null) goto L12;
        r4.writeInt(r6.size());
        Iterator<Integer> r3 = this.delaySizeMatrix.iterator();
    L6:
        if (r3.hasNext() == false) goto L17;
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r3.next(), Integer.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L10;
        int r8 = r7.intValue();
    L11:
        r4.writeInt(r8);
        goto L6
    L10:
        r8 = 0;
        goto L11
    L17:
        return;
    L12:
        r4.writeInt(0);
    }

    public static /* synthetic */ void a(LinkLayerQuality r0, int r1) {
        r0.deltaTxBytes = r1;
    }

    public static /* synthetic */ void b(LinkLayerQuality r0, String r1) {
        r0.band = r1;
    }

    public static /* synthetic */ void c(LinkLayerQuality r0, float r1) {
        r0.txDelayP90 = r1;
    }

    public static /* synthetic */ void d(LinkLayerQuality r0, String r1) {
        r0.wifiGeneration = r1;
    }

    public static /* synthetic */ void a(LinkLayerQuality r0, boolean r1) {
        r0.is_mlo_iface = r1;
    }

    public static /* synthetic */ void b(LinkLayerQuality r0, float r1) {
        r0.txDelayP10 = r1;
    }

    public static /* synthetic */ void c(LinkLayerQuality r0, String r1) {
        r0.band1 = r1;
    }

    public LinkLayerQuality(LinkLayerQuality r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        this.ifName = r3.ifName;
        this.freq = r3.freq;
        this.txlink_speed = r3.txlink_speed;
        this.rxlink_speed = r3.rxlink_speed;
        this.band = r3.band;
        this.band1 = r3.band1;
        this.wifiGeneration = r3.wifiGeneration;
        this.deltaRxFcsErr = r3.deltaRxFcsErr;
        this.rxFcsErrLevel = r3.rxFcsErrLevel;
        this.totalTxBytes = r3.totalTxBytes;
        this.deltaTxBytes = r3.deltaTxBytes;
        this.txRealSpeed = r3.txRealSpeed;
        this.totalRxBytes = r3.totalRxBytes;
        this.deltaRxBytes = r3.deltaRxBytes;
        this.rxRealSpeed = r3.rxRealSpeed;
        this.txMode = r3.txMode;
        this.txMcs = r3.txMcs;
        this.txBw = r3.txBw;
        this.txNss = r3.txNss;
        this.rxMode = r3.rxMode;
        this.rxMcs = r3.rxMcs;
        this.rxBw = r3.rxBw;
        this.rxNss = r3.rxNss;
        this.delta_channel_on_time = r3.delta_channel_on_time;
        this.delta_channel_tx_time = r3.delta_channel_tx_time;
        this.delta_channel_rx_time = r3.delta_channel_rx_time;
        this.delta_channel_cca_busy_time = r3.delta_channel_cca_busy_time;
        this.ccaScore = r3.ccaScore;
        this.perScore = r3.perScore;
        this.rssiScore = r3.rssiScore;
        this.scenario = r3.scenario;
        this.currentChannelAPCount = r3.currentChannelAPCount;
        this.arpNeighbourCount = r3.arpNeighbourCount;
        this.is_mlo_iface = r3.is_mlo_iface;
        if (r3.linkStats == null) goto L8;
        this.linkStats = new ArrayList(r3.linkStats);
    L9:
        this.rxTputPred = r3.rxTputPred;
        this.txTputPred = r3.txTputPred;
        this.wifiStandard = r3.wifiStandard;
        this.contentionAtimeBk = r3.contentionAtimeBk;
        this.contentionAtimeVi = r3.contentionAtimeVi;
        this.txDelayAvg = r3.txDelayAvg;
        this.txDelayP10 = r3.txDelayP10;
        this.txDelayP90 = r3.txDelayP90;
        this.txDelayPkts = r3.txDelayPkts;
        if (r3.delaySizeMatrix == null) goto L12;
        this.delaySizeMatrix = new ArrayList(r3.delaySizeMatrix);
        return;
    L12:
        this.delaySizeMatrix = new ArrayList();
        return;
    L8:
        this.linkStats = new ArrayList();
        goto L9
    }

    public static /* synthetic */ List a(LinkLayerQuality r0) {
        return r0.linkStats;
    }

    public static /* synthetic */ List b(LinkLayerQuality r0) {
        return r0.delaySizeMatrix;
    }

    public static /* synthetic */ void a(LinkLayerQuality r0, float r1) {
        r0.txDelayAvg = r1;
    }

    public static /* synthetic */ void a(LinkLayerQuality r0, long r1) {
        r0.txDelayPkts = r1;
    }

    public static /* synthetic */ void a(LinkLayerQuality r0, ArrayList r1) {
        r0.delaySizeMatrix = r1;
    }
}

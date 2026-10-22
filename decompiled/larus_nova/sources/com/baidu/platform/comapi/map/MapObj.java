package com.baidu.platform.comapi.map;

import androidx.camera.video.AudioStats;
import com.baidu.platform.comapi.basestruct.Point;

/* JADX INFO: loaded from: classes39.dex */
public class MapObj {

    /* JADX INFO: renamed from: ad, reason: collision with root package name */
    public int f33070ad;
    public String adLog;
    public int adstyle;
    public String bid;
    public String clickAction;
    public int dynamicSrc;
    public int dysrc;
    public int dystge;
    public String exJson;
    public Point geoPt;
    public float geoZ;
    public int index;
    public boolean indoorpoi;
    public boolean isAgg;
    public int layer_id;
    public int level;
    public int nIndex;
    public int nType;
    public int offset;
    public int poiOnlineType;
    public String puid;
    public String qid;
    public int routeId;
    public String routeType;
    public int slobj;
    public int sltime;
    public int slvisi;
    public String ssData;
    public String ssIndoorId;
    public String ssName;
    public String ssPanoId;
    public String ssPoiUid;
    public double ssRotation;
    public String ssType;
    public int ssZ;
    public int statisticValue;
    public int status;
    public String strText;
    public String strUid;
    public double streetArrowCenterX;
    public double streetArrowCenterY;
    public int style_id;
    public String url;

    public MapObj() {
        this.dysrc = -1;
        this.dystge = -1;
        this.level = -1;
        this.strUid = "";
        this.nIndex = 0;
        this.nType = 26;
        this.strText = "";
        this.geoPt = new Point();
        this.offset = 0;
        this.sltime = 0;
        this.slobj = 0;
        this.ssName = "";
        this.ssIndoorId = "";
        this.ssPoiUid = "";
        this.ssZ = 0;
        this.ssRotation = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.ssPanoId = "";
        this.routeId = 0;
        this.index = 0;
        this.status = 0;
        this.routeType = "";
        this.poiOnlineType = 0;
        this.bid = "";
        this.clickAction = "";
        this.statisticValue = 0;
        this.isAgg = false;
    }
}

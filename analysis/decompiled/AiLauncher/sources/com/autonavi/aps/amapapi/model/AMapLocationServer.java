package com.autonavi.aps.amapapi.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.location.support.bean.location.AmapLocation;
import com.amap.location.support.bean.location.AmapLocationNetwork;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.AMapLocationUtil;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AMapLocationServer extends AMapLocation {

    /* renamed from: d0, reason: collision with root package name */
    private String f18250d0;
    protected String desc;

    /* renamed from: e0, reason: collision with root package name */
    private String f18251e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f18252f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f18253g0;

    /* renamed from: h0, reason: collision with root package name */
    private JSONObject f18254h0;

    /* renamed from: i0, reason: collision with root package name */
    private String f18255i0;

    /* renamed from: j0, reason: collision with root package name */
    private String f18256j0;

    /* renamed from: k0, reason: collision with root package name */
    private String f18257k0;

    public AMapLocationServer(String str) {
        super(str);
        this.desc = "";
        this.f18250d0 = null;
        this.f18251e0 = "";
        this.f18252f0 = "";
        this.f18253g0 = Const.STR_NEW;
        this.f18254h0 = null;
        this.f18255i0 = "";
        this.f18256j0 = "";
        this.f18257k0 = null;
    }

    public void constructorByJSON(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                CoreUtil.transformLocation(this, jSONObject);
                setCacheType(jSONObject.optString("type", this.f18253g0));
                setRetype(jSONObject.optString(Const.JSON_KEY_RETYPE, this.f18252f0));
                setCens(jSONObject.optString(Const.JSON_KEY_CENS, this.f18256j0));
                setDesc(jSONObject.optString(Const.JSON_KEY_DESC, this.desc));
                setMcell(jSONObject.optString(Const.JSON_KEY_MCELL, this.f18255i0));
                if (Utils.joHasK(jSONObject, Const.JSON_KEY_POIID)) {
                    setBuildingId(jSONObject.optString(Const.JSON_KEY_POIID));
                }
                if (Utils.joHasK(jSONObject, "pid")) {
                    setBuildingId(jSONObject.optString("pid"));
                }
                if (Utils.joHasK(jSONObject, Const.JSON_KEY_FLOOR)) {
                    setFloor(jSONObject.optString(Const.JSON_KEY_FLOOR));
                }
                if (Utils.joHasK(jSONObject, Const.JSON_KEY_FLR)) {
                    setFloor(jSONObject.optString(Const.JSON_KEY_FLR));
                }
            } catch (Throwable th) {
                CoreUtil.reportError(th, "AmapLoc", "AmapLoc");
            }
        }
    }

    public String getCacheType() {
        return this.f18253g0;
    }

    public String getCens() {
        return this.f18256j0;
    }

    public String getDesc() {
        return this.desc;
    }

    public JSONObject getExtra() {
        return this.f18254h0;
    }

    public String getMcell() {
        return this.f18255i0;
    }

    public AMapLocationServer getMcellLoc() {
        String mcell = getMcell();
        if (TextUtils.isEmpty(mcell)) {
            return null;
        }
        String[] strArrSplit = mcell.split(Const.STR_MART_COMMA);
        if (strArrSplit.length != 3) {
            return null;
        }
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        aMapLocationServer.setProvider(getProvider());
        aMapLocationServer.setLongitude(Utils.parseDouble(strArrSplit[0]));
        aMapLocationServer.setLatitude(Utils.parseDouble(strArrSplit[1]));
        aMapLocationServer.setAccuracy(Utils.parseFloat(strArrSplit[2]));
        aMapLocationServer.setCityCode(getCityCode());
        aMapLocationServer.setAdCode(getAdCode());
        aMapLocationServer.setCountry(getCountry());
        aMapLocationServer.setProvince(getProvince());
        aMapLocationServer.setCity(getCity());
        aMapLocationServer.setTime(getTime());
        aMapLocationServer.setCacheType(getCacheType());
        aMapLocationServer.setCoord(String.valueOf(getCoord()));
        if (Utils.locCorrect(aMapLocationServer)) {
            return aMapLocationServer;
        }
        return null;
    }

    public String getNb() {
        return this.f18257k0;
    }

    public String getRdesc() {
        return this.f18251e0;
    }

    public String getRetype() {
        return this.f18252f0;
    }

    public String getsCxtFromServer() {
        return this.f18250d0;
    }

    public void setCacheType(String str) {
        this.f18253g0 = str;
    }

    public void setCens(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] strArrSplit = str.split("\\*");
        int length = strArrSplit.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            String str2 = strArrSplit[i10];
            if (!TextUtils.isEmpty(str2)) {
                String[] strArrSplit2 = str2.split(Const.STR_MART_COMMA);
                setLongitude(Utils.parseDouble(strArrSplit2[0]));
                setLatitude(Utils.parseDouble(strArrSplit2[1]));
                setAccuracy(Utils.parseInt(strArrSplit2[2]));
                break;
            }
            i10++;
        }
        this.f18256j0 = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setExtra(JSONObject jSONObject) {
        this.f18254h0 = jSONObject;
    }

    @Override // com.amap.api.location.AMapLocation
    public void setLocationType(int i10) {
        if (i10 == 2 || i10 == 4 || i10 == 9) {
            AMapLocationUtil.cacheLocationType(this);
        }
        super.setLocationType(i10);
    }

    public void setMcell(String str) {
        this.f18255i0 = str;
    }

    public void setNb(String str) {
        this.f18257k0 = str;
    }

    public void setRdesc(String str) {
        this.f18251e0 = str;
    }

    public void setRetype(String str) {
        this.f18252f0 = str;
    }

    public void setsCxtFromServer(String str) {
        this.f18250d0 = str;
    }

    @Override // com.amap.api.location.AMapLocation
    public JSONObject toJson(int i10) {
        try {
            JSONObject json = super.toJson(i10);
            if (i10 == 1) {
                json.put(Const.JSON_KEY_RETYPE, this.f18252f0);
                json.put(Const.JSON_KEY_CENS, this.f18256j0);
                json.put(Const.JSON_KEY_MCELL, this.f18255i0);
                json.put(Const.JSON_KEY_DESC, this.desc);
                json.put(Const.JSON_KEY_ADDRESS, getAddress());
                if (this.f18254h0 != null && Utils.joHasK(json, Const.JSON_KEY_OFFPCT)) {
                    json.put(Const.JSON_KEY_OFFPCT, this.f18254h0.getString(Const.JSON_KEY_OFFPCT));
                }
            } else if (i10 != 2 && i10 != 3) {
                return json;
            }
            json.put("type", this.f18253g0);
            return json;
        } catch (Throwable th) {
            CoreUtil.reportError(th, "AmapLoc", "toStr");
            return null;
        }
    }

    @Override // com.amap.api.location.AMapLocation
    public String toStr() {
        return toStr(1);
    }

    @Override // com.amap.api.location.AMapLocation
    public String toStr(int i10) {
        JSONObject json;
        try {
            json = toJson(i10);
            json.put("nb", this.f18257k0);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "AMapLocation", "toStr part2");
            json = null;
        }
        if (json == null) {
            return null;
        }
        return json.toString();
    }

    public AMapLocationServer(AmapLocationNetwork amapLocationNetwork) {
        super(amapLocationNetwork);
        this.desc = "";
        this.f18250d0 = null;
        this.f18251e0 = "";
        this.f18252f0 = "";
        this.f18253g0 = Const.STR_NEW;
        this.f18254h0 = null;
        this.f18255i0 = "";
        this.f18256j0 = "";
        this.f18257k0 = null;
        this.desc = amapLocationNetwork.P();
        this.f18251e0 = amapLocationNetwork.W();
        this.f18252f0 = amapLocationNetwork.X();
        this.f18253g0 = amapLocationNetwork.J();
        this.f18256j0 = amapLocationNetwork.K();
        this.f18255i0 = amapLocationNetwork.S();
        Bundle bundle = new Bundle();
        bundle.putString(Const.JSON_KEY_CITYCODE, amapLocationNetwork.M());
        bundle.putString(Const.JSON_KEY_DESC, amapLocationNetwork.P());
        bundle.putString(Const.JSON_KEY_ADCODE, amapLocationNetwork.G());
        setExtras(bundle);
    }

    public AMapLocationServer(AmapLocation amapLocation) {
        super(amapLocation);
        this.desc = "";
        this.f18250d0 = null;
        this.f18251e0 = "";
        this.f18252f0 = "";
        this.f18253g0 = Const.STR_NEW;
        this.f18254h0 = null;
        this.f18255i0 = "";
        this.f18256j0 = "";
        this.f18257k0 = null;
    }
}

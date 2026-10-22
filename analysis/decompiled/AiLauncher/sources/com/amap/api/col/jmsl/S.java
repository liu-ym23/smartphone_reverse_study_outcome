package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class S extends Q1<InputtipsQuery, ArrayList<Tip>> {
    public S(Context context, InputtipsQuery inputtipsQuery) {
        super(context, inputtipsQuery);
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        try {
            return C1531a0.g0(new JSONObject(str));
        } catch (JSONException e10) {
            C1631z1.o(e10, "InputtipsHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.c(this.f16099B) + "/assistant/inputtips?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String strM = m(((InputtipsQuery) this.f16103z).getKeyword());
        if (!TextUtils.isEmpty(strM)) {
            stringBuffer.append("&keywords=");
            stringBuffer.append(strM);
        }
        String city = ((InputtipsQuery) this.f16103z).getCity();
        if (!C1531a0.m(city)) {
            String strM2 = m(city);
            stringBuffer.append("&city=");
            stringBuffer.append(strM2);
        }
        String type = ((InputtipsQuery) this.f16103z).getType();
        if (!C1531a0.m(type)) {
            String strM3 = m(type);
            stringBuffer.append("&type=");
            stringBuffer.append(strM3);
        }
        if (((InputtipsQuery) this.f16103z).getCityLimit()) {
            stringBuffer.append("&citylimit=true");
        } else {
            stringBuffer.append("&citylimit=false");
        }
        LatLonPoint location = ((InputtipsQuery) this.f16103z).getLocation();
        if (location != null) {
            stringBuffer.append("&location=");
            stringBuffer.append(location.getLongitude());
            stringBuffer.append(Const.STR_MART_COMMA);
            stringBuffer.append(location.getLatitude());
        }
        stringBuffer.append("&key=");
        stringBuffer.append(C1567j0.n(this.f16099B));
        return stringBuffer.toString();
    }
}

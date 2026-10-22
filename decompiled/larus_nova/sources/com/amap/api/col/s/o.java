package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class o extends b<InputtipsQuery, ArrayList<Tip>> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final String a() {
        StringBuffer r100 = new StringBuffer("output=json");
        String r101 = b.b(((InputtipsQuery) this.f25991b).getKeyword());
        if (TextUtils.isEmpty(r101) == true) goto L5;
        r100.append("&keywords=");
        r100.append(r101);
    L5:
        String r102 = ((InputtipsQuery) this.f25991b).getCity();
        if (p.f(r102) == true) goto L8;
        String r103 = b.b(r102);
        r100.append("&city=");
        r100.append(r103);
    L8:
        String r104 = ((InputtipsQuery) this.f25991b).getType();
        if (p.f(r104) == true) goto L12;
        String r105 = b.b(r104);
        r100.append("&type=");
        r100.append(r105);
    L12:
        if (((InputtipsQuery) this.f25991b).getCityLimit() == false) goto L14;
        r100.append("&citylimit=true");
    L15:
        LatLonPoint r106 = ((InputtipsQuery) this.f25991b).getLocation();
        if (r106 == null) goto L18;
        r100.append("&location=");
        r100.append(r106.getLongitude());
        r100.append(",");
        r100.append(r106.getLatitude());
    L18:
        r100.append("&key=");
        r100.append(bi.f(this.f25994e));
        return r100.toString();
    L14:
        r100.append("&citylimit=false");
        goto L15
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.a() + "/assistant/inputtips?";
    }

    private static ArrayList<Tip> c(String r100) throws AMapException {
        return p.h(new JSONObject(r100));
    L4:
        e = move-exception;
        i.a(e, "InputtipsHandler", "paseJSON");
        return null;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ Object a(String r100) throws AMapException {
        return c(r100);
    }

    public o(Context r100, InputtipsQuery r101) {
        super(r100, r101);
    }
}

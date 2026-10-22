package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;

/* renamed from: com.amap.api.col.jmsl.g1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1556g1 {

    /* renamed from: a, reason: collision with root package name */
    public Context f16633a;

    public C1556g1(Context context) {
        this.f16633a = context.getApplicationContext();
    }

    public String a() {
        StringBuilder sb2 = new StringBuilder("");
        sb2.append("personal_switch=");
        sb2.append(W4.a.ENABLE_OFF);
        sb2.append("&autodiv=");
        sb2.append("ANDA0605000");
        if (!TextUtils.isEmpty("")) {
            sb2.append("&tid=");
            sb2.append("");
        }
        String strQ = S0.q(this.f16633a);
        if (!TextUtils.isEmpty(strQ)) {
            sb2.append("&adiu=");
            sb2.append(strQ);
        }
        if (!TextUtils.isEmpty("9.8.1")) {
            sb2.append("&app_version=");
            sb2.append("9.8.1");
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&cifa=");
            sb2.append("");
        }
        String strH = S0.h();
        if (!TextUtils.isEmpty(strH)) {
            sb2.append("&deviceid=");
            sb2.append(strH);
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&did=");
            sb2.append("");
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&didv=");
            sb2.append("");
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&dic=");
            sb2.append("");
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&dip=");
            sb2.append("");
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&diu=");
            sb2.append("");
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&diu2=");
            sb2.append("");
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&diu3=");
            sb2.append("");
        }
        if (!TextUtils.isEmpty("ANDH070308")) {
            sb2.append("&div=");
            sb2.append("ANDH070308");
        }
        if (!TextUtils.isEmpty(UxipConstants.f30662a)) {
            sb2.append("&os=");
            sb2.append(UxipConstants.f30662a);
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&stepid=");
            sb2.append("");
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&session=");
            sb2.append("");
        }
        return sb2.toString();
    }
}

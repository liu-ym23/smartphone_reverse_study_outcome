package com.stepos.familyguard.provider.processor;

import l0.AbstractC0822a;
import l2.m;

/* loaded from: classes.dex */
public final class AntiSupportProcessor$AntiRelation {
    public String deviceId;
    public long id;
    public String imsi;
    public String phone;
    public String relationImei;
    public String relationImsi;
    public String relationPhone;
    public int role;
    public int status;
    public int type;
    public long updateTime;
    public int watchDays;

    public AntiSupportProcessor$AntiRelation(m mVar) {
        long j5 = mVar.f18247e;
        this.id = j5;
        this.phone = mVar.f18246d;
        this.relationImei = mVar.f18251i;
        this.relationPhone = mVar.f18252j;
        this.role = mVar.f18243a;
        this.status = mVar.f18254l;
        this.type = mVar.f18256n;
        this.imsi = String.valueOf(j5);
        this.relationImsi = String.valueOf(mVar.f18247e);
        this.updateTime = System.currentTimeMillis();
        this.watchDays = mVar.f18255m;
    }

    public String toString() {
        return AbstractC0822a.F(this);
    }
}

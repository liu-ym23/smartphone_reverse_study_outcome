package com.autonavi.aps.protocol.aps.request.model.fields.wifi;

import com.autonavi.aps.protocol.aps.common.e.g;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class NbWifis extends ArrayList<a> {

    /* renamed from: a, reason: collision with root package name */
    private short f19058a = 0;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private com.autonavi.aps.protocol.aps.request.model.fields.wifi.a f19059a = new com.autonavi.aps.protocol.aps.request.model.fields.wifi.a();

        /* renamed from: b, reason: collision with root package name */
        private String f19060b = "";

        /* renamed from: c, reason: collision with root package name */
        private byte f19061c = 0;

        /* renamed from: d, reason: collision with root package name */
        private short f19062d = 0;

        /* renamed from: e, reason: collision with root package name */
        private short f19063e = 0;

        public com.autonavi.aps.protocol.aps.request.model.fields.wifi.a a() {
            return this.f19059a;
        }

        public String b() {
            return this.f19060b;
        }

        public byte c() {
            return this.f19061c;
        }

        public int d() {
            return g.a(this.f19062d);
        }

        public short e() {
            return this.f19063e;
        }

        public String toString() {
            return "NbWifi{mac=" + this.f19059a + ", ssid='" + this.f19060b + "', rssi=" + ((int) this.f19061c) + ", age=" + ((int) this.f19062d) + ", freq=" + ((int) this.f19063e) + '}';
        }

        public void a(com.autonavi.aps.protocol.aps.request.model.fields.wifi.a aVar) {
            this.f19059a = aVar;
        }

        public void a(String str) {
            this.f19060b = str;
        }

        public void a(byte b10) {
            this.f19061c = b10;
        }

        public void a(int i10) {
            Integer num = com.autonavi.aps.protocol.aps.common.constant.a.f18510c;
            if (i10 > num.intValue()) {
                i10 = num.intValue();
            }
            Integer num2 = com.autonavi.aps.protocol.aps.common.constant.a.f18511d;
            if (i10 < num2.intValue()) {
                i10 = num2.intValue();
            }
            this.f19062d = (short) i10;
        }

        public void a(short s10) {
            this.f19063e = s10;
        }
    }

    public int getMacsAge() {
        return g.a(this.f19058a);
    }

    public void setMacsAge(int i10) {
        Integer num = com.autonavi.aps.protocol.aps.common.constant.a.f18510c;
        if (i10 > num.intValue()) {
            i10 = num.intValue();
        }
        Integer num2 = com.autonavi.aps.protocol.aps.common.constant.a.f18511d;
        if (i10 < num2.intValue()) {
            i10 = num2.intValue();
        }
        this.f19058a = (short) i10;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return "NbWifis{" + super.toString() + "macsAge=" + ((int) this.f19058a) + '}';
    }
}

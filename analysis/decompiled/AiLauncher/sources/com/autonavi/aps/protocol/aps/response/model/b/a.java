package com.autonavi.aps.protocol.aps.response.model.b;

import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.protocol.aps.common.a.c;
import com.autonavi.aps.protocol.aps.common.enums.Version;
import com.autonavi.aps.protocol.aps.response.model.vo.fields.Redesc;
import com.autonavi.aps.protocol.aps.response.model.vo.fields.Retype;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: b, reason: collision with root package name */
    private byte[] f19099b = null;

    /* renamed from: c, reason: collision with root package name */
    private C0216a f19100c = new C0216a();

    /* renamed from: com.autonavi.aps.protocol.aps.response.model.b.a$a, reason: collision with other inner class name */
    public static class C0216a {

        /* renamed from: a, reason: collision with root package name */
        private String f19101a;

        /* renamed from: c, reason: collision with root package name */
        private Short f19103c;

        /* renamed from: b, reason: collision with root package name */
        private Byte f19102b = null;

        /* renamed from: d, reason: collision with root package name */
        private Map<String, String> f19104d = new HashMap();

        public String a() {
            return this.f19101a;
        }

        public boolean b() {
            return false;
        }

        public Short c() {
            return this.f19103c;
        }

        public Byte d() {
            return this.f19102b;
        }

        public boolean e() {
            return false;
        }

        public boolean f() {
            return false;
        }

        public void a(String str) {
            this.f19101a = str;
            if (str != null) {
                this.f19104d.put("rt", str);
            } else {
                this.f19104d.remove("rt");
            }
        }

        public void a(Short sh) {
            if (sh == null) {
                this.f19103c = null;
                this.f19104d.put("rdesc", "");
                return;
            }
            if (!Redesc.OK.getCode().equals(sh)) {
                if (a(sh.shortValue())) {
                    a(Retype.CITY.getCode());
                } else {
                    a(Retype.FAILUR.getCode());
                }
            }
            this.f19103c = sh;
            this.f19104d.put("rdesc", Short.toString(sh.shortValue()));
        }

        public void a(Byte b10) {
            if (b10 == null) {
                this.f19102b = null;
            } else {
                this.f19102b = b10;
                this.f19104d.put(Const.JSON_KEY_RETYPE, Byte.toString(b10.byteValue()));
            }
        }

        public boolean a(short s10) {
            return s10 == Redesc.LICENSE_LIMIT.getCode().shortValue() || s10 == Redesc.KEY_LIMIT.getCode().shortValue();
        }
    }

    @Override // com.autonavi.aps.protocol.aps.common.a.c
    public Version a() {
        return this.f18491a;
    }

    public C0216a b() {
        return this.f19100c;
    }

    public byte[] c() {
        return this.f19099b;
    }

    public void a(byte[] bArr) {
        this.f19099b = bArr;
    }
}

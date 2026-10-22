package com.autonavi.aps.protocol.aps.request.model.message;

import com.autonavi.aps.protocol.aps.common.enums.Version;
import com.autonavi.aps.protocol.aps.request.model.fields.RgeoLanguage;
import com.autonavi.aps.protocol.aps.response.model.vo.fields.FormatType;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a extends com.autonavi.aps.protocol.aps.common.a.b {

    /* renamed from: b, reason: collision with root package name */
    private C0215a f19072b = new C0215a();

    /* renamed from: c, reason: collision with root package name */
    private b f19073c = new b();

    /* renamed from: d, reason: collision with root package name */
    private byte[] f19074d;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private Version f19082a = Version.UNKNOWN;

        /* renamed from: b, reason: collision with root package name */
        private FormatType f19083b = FormatType.XML;

        /* renamed from: c, reason: collision with root package name */
        private RgeoLanguage f19084c = RgeoLanguage.CHINESE;

        /* renamed from: d, reason: collision with root package name */
        private Map<String, String> f19085d = new HashMap();

        public String a(String str) {
            return this.f19085d.get(str);
        }

        public String toString() {
            return "Params{version=" + this.f19082a + ", responseType=" + this.f19083b + ", rgeoLanguage=" + this.f19084c + ", samsungSkyhookQ=false, paramsMap=" + this.f19085d + '}';
        }

        public b a(Version version) {
            this.f19082a = version;
            if (version == null) {
                this.f19085d.remove("ver");
                return this;
            }
            if (version.toFloat() <= Version.V30.toFloat()) {
                this.f19085d.remove("ver");
                return this;
            }
            this.f19085d.put("ver", this.f19082a.toString());
            return this;
        }

        public b a(FormatType formatType) {
            this.f19083b = formatType;
            if (formatType == null) {
                this.f19085d.remove("rt");
                return this;
            }
            this.f19085d.put("rt", formatType.toString());
            return this;
        }

        public Version a() {
            return this.f19082a;
        }
    }

    public byte[] a() {
        return this.f19074d;
    }

    public C0215a b() {
        return this.f19072b;
    }

    public b c() {
        return this.f19073c;
    }

    public void a(byte[] bArr) {
        this.f19074d = bArr;
    }

    public void a(C0215a c0215a) {
        this.f19072b = c0215a;
    }

    public void a(b bVar) {
        this.f19073c = bVar;
    }

    /* renamed from: com.autonavi.aps.protocol.aps.request.model.message.a$a, reason: collision with other inner class name */
    public static class C0215a {

        /* renamed from: a, reason: collision with root package name */
        private com.autonavi.aps.protocol.aps.request.model.fields.a f19075a = new com.autonavi.aps.protocol.aps.request.model.fields.a();

        /* renamed from: b, reason: collision with root package name */
        private boolean f19076b = false;

        /* renamed from: c, reason: collision with root package name */
        private boolean f19077c = false;

        /* renamed from: d, reason: collision with root package name */
        private boolean f19078d = false;

        /* renamed from: e, reason: collision with root package name */
        private boolean f19079e = false;

        /* renamed from: f, reason: collision with root package name */
        private Map<String, String> f19080f = new HashMap();

        /* renamed from: g, reason: collision with root package name */
        private int f19081g = 99;

        static {
            new HashMap<String, Integer>() { // from class: com.autonavi.aps.protocol.aps.request.model.message.ApsRequestMsg$Header$1
                {
                    put("appip", 0);
                    put("x-forwarded-for", 1);
                    put("proxy-client-ip", 2);
                    put("wl-proxy-client-ip", 3);
                }
            };
        }

        public C0215a a(boolean z10) {
            this.f19076b = z10;
            if (!this.f19080f.containsKey("et")) {
                this.f19080f.put("et", "100");
            }
            if (!z10) {
                char[] charArray = this.f19080f.get("et").toCharArray();
                charArray[2] = '0';
                this.f19080f.put("et", new String(charArray));
                return this;
            }
            char[] charArray2 = this.f19080f.get("et").toCharArray();
            charArray2[2] = '1';
            charArray2[0] = '1';
            this.f19080f.put("et", new String(charArray2));
            return this;
        }

        public C0215a b(boolean z10) {
            this.f19077c = z10;
            if (!this.f19080f.containsKey("et")) {
                this.f19080f.put("et", "100");
            }
            if (!z10) {
                char[] charArray = this.f19080f.get("et").toCharArray();
                charArray[1] = '0';
                this.f19080f.put("et", new String(charArray));
                return this;
            }
            char[] charArray2 = this.f19080f.get("et").toCharArray();
            charArray2[1] = '1';
            charArray2[0] = '1';
            this.f19080f.put("et", new String(charArray2));
            return this;
        }

        public C0215a c(boolean z10) {
            this.f19078d = z10;
            if (z10) {
                this.f19080f.put("gzipped", "1");
                return this;
            }
            this.f19080f.remove("gzipped");
            return this;
        }

        public C0215a d(boolean z10) {
            this.f19079e = z10;
            if (z10) {
                this.f19080f.put("accept-encoding", "gzip");
                return this;
            }
            this.f19080f.remove("accept-encoding");
            return this;
        }

        public String toString() {
            return "Header{responseCtrl=" + this.f19075a + ", responseEncrypted=false, responseXxteaEncrypted=" + this.f19076b + ", requestXxteaEncrypted=" + this.f19077c + ", requestGzipped=" + this.f19078d + ", responseGzipped=" + this.f19079e + ", appIP='" + ((String) null) + "', isSupporToMac=false, osInfo='" + ((String) null) + "', host='" + ((String) null) + "', paramsMap=" + this.f19080f + ", currAppipPriority=" + this.f19081g + '}';
        }

        public boolean a() {
            return this.f19078d;
        }
    }
}

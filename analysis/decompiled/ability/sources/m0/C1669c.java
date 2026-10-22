package m0;

import org.json.JSONObject;

/* renamed from: m0.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1669c {

    /* renamed from: a, reason: collision with root package name */
    public long f5294a;
    public String b;
    public String c;
    public JSONObject d;
    public long e;

    public C1669c(long j5, long j6, String str, String str2) {
        this.f5294a = j5;
        this.b = str;
        try {
            this.d = new JSONObject(str2);
        } catch (Exception unused) {
        }
        this.e = j6;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LocalLog{id=");
        sb.append(this.f5294a);
        sb.append(", type='");
        sb.append(this.b);
        sb.append("', type2='");
        sb.append(this.c);
        sb.append("', data='");
        sb.append(this.d);
        sb.append("', versionId=");
        return androidx.constraintlayout.core.dsl.a.e(this.e, ", createTime=0, isSampled=false}", sb);
    }
}

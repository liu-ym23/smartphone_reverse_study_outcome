package C5;

import H4.o;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cc.dd.ee.dd.cc.ff.cc.c$a;
import com.fasterxml.jackson.databind.JsonNode;
import g1.AbstractC1451a;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import z3.G;
import z3.x;

/* loaded from: classes3.dex */
public final class b implements G {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f298a;
    public long b;
    public Serializable c;
    public Object d;

    public /* synthetic */ b() {
        this.f298a = 2;
    }

    public static b a(JSONObject jSONObject) {
        if (AbstractC1451a.f4467a) {
            o.r(S0.a.f1163a, "DowngradeRule=" + jSONObject.toString());
        }
        b bVar = new b();
        HashMap map = new HashMap();
        bVar.c = map;
        bVar.d = jSONObject;
        long jOptLong = jSONObject.optLong(TypedValues.TransitionType.S_DURATION, 0L);
        long jOptLong2 = jSONObject.optLong("expire_time", 0L);
        if (jOptLong2 > 0) {
            bVar.b = jOptLong2;
        } else {
            if (AbstractC1451a.f4470r && jOptLong > 86400) {
                if (AbstractC1451a.f4467a) {
                    o.r(S0.a.f1163a, "APMPlus duration:" + jOptLong + " -> 86400");
                }
                jOptLong = 86400;
            }
            bVar.b = (jOptLong * 1000) + System.currentTimeMillis();
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("other");
        if (jSONObjectOptJSONObject != null) {
            map.put(c$a.OTHER_LOG_TYPE, X0.b.a(jSONObjectOptJSONObject));
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("service_monitor");
        if (jSONObjectOptJSONObject2 != null) {
            map.put(c$a.SERVICE_MONITOR, X0.b.a(jSONObjectOptJSONObject2));
        }
        return bVar;
    }

    public JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expire_time", this.b);
            for (Map.Entry entry : ((HashMap) this.c).entrySet()) {
                jSONObject.put(((c$a) entry.getKey()).f2137a, ((X0.b) entry.getValue()).b());
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0187 A[Catch: all -> 0x0065, TryCatch #2 {all -> 0x0065, blocks: (B:4:0x000f, B:9:0x003f, B:11:0x0043, B:14:0x0068, B:42:0x0182, B:44:0x0187, B:46:0x01ab, B:47:0x01bc, B:50:0x01c4, B:51:0x01c9, B:53:0x01d0, B:56:0x01e8, B:58:0x01ec, B:59:0x01f3), top: B:69:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01d0 A[Catch: all -> 0x0065, TRY_LEAVE, TryCatch #2 {all -> 0x0065, blocks: (B:4:0x000f, B:9:0x003f, B:11:0x0043, B:14:0x0068, B:42:0x0182, B:44:0x0187, B:46:0x01ab, B:47:0x01bc, B:50:0x01c4, B:51:0x01c9, B:53:0x01d0, B:56:0x01e8, B:58:0x01ec, B:59:0x01f3), top: B:69:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void c() {
        /*
            Method dump skipped, instructions count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: C5.b.c():void");
    }

    public synchronized String[] d() {
        try {
            File[] fileArrListFiles = S0.b.i().listFiles(new R1.a(2));
            if (fileArrListFiles == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (File file : fileArrListFiles) {
                arrayList.add(file.getName());
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void e() {
        ByteBuffer byteBuffer = (ByteBuffer) this.d;
        byteBuffer.clear();
        byteBuffer.putShort((short) 2082);
        byteBuffer.putLong(this.b);
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
    }

    @Override // z3.G
    public String w() {
        switch (this.f298a) {
        }
        return String.valueOf(this.b);
    }

    @Override // z3.G
    public boolean x(JsonNode jsonNode) {
        switch (this.f298a) {
            case 3:
                if (jsonNode.isBigInteger()) {
                    int iCompareTo = jsonNode.bigIntegerValue().compareTo(new BigInteger(((JsonNode) this.d).asText()));
                    if (iCompareTo > 0 || iCompareTo == 0) {
                    }
                } else if (jsonNode.isTextual()) {
                    int iCompareTo2 = new BigDecimal(jsonNode.asText()).compareTo(new BigDecimal((String) this.c));
                    if (iCompareTo2 > 0 || iCompareTo2 == 0) {
                    }
                } else {
                    long jAsLong = jsonNode.asLong();
                    long j5 = this.b;
                    if (j5 < jAsLong || j5 == jAsLong) {
                    }
                }
                break;
            default:
                String str = (String) this.c;
                x xVar = (x) this.d;
                if (jsonNode.isBigInteger()) {
                    int iCompareTo3 = jsonNode.bigIntegerValue().compareTo(new BigInteger(str));
                    if (iCompareTo3 >= 0) {
                        if (xVar.g && iCompareTo3 == 0) {
                        }
                    }
                } else if (jsonNode.isTextual()) {
                    int iCompareTo4 = new BigDecimal(jsonNode.asText()).compareTo(new BigDecimal(str));
                    if (iCompareTo4 >= 0) {
                        if (xVar.g && iCompareTo4 == 0) {
                        }
                    }
                } else {
                    long jAsLong2 = jsonNode.asLong();
                    long j6 = this.b;
                    if (j6 <= jAsLong2) {
                        if (xVar.g && j6 == jAsLong2) {
                        }
                    }
                }
                break;
        }
        return true;
    }

    public /* synthetic */ b(Object obj, String str, long j5, int i) {
        this.f298a = i;
        this.d = obj;
        this.c = str;
        this.b = j5;
    }

    public b(long j5, File file, File file2) {
        this.f298a = 1;
        this.c = file2;
        this.b = j5;
        try {
            FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
            channel.tryLock();
            this.d = channel.map(FileChannel.MapMode.READ_WRITE, 0L, 262162L);
            c();
        } catch (Throwable th) {
            o.g(S0.a.f1163a, "create MappedByteBuffer failed. will fallback into HeapByteBuffer", th);
        }
        if (((ByteBuffer) this.d) == null) {
            this.d = ByteBuffer.allocate(262162);
        }
        e();
    }

    public b(String str) {
        this.f298a = 0;
        this.d = str;
    }
}

package L9;

import F9.v;
import F9.w;
import H4.o;
import g1.AbstractC1451a;
import h2.C1483a;
import j9.m;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import org.json.JSONObject;
import w2.i;
import z7.AbstractC2188i;
import z7.InterfaceC2180a;
import z7.RunnableC2181b;

/* loaded from: classes4.dex */
public final class a implements n2.b, InterfaceC2180a {

    /* renamed from: a, reason: collision with root package name */
    public long f944a;
    public Object b;

    @Override // z7.InterfaceC2180a
    public void a(RunnableC2181b runnableC2181b) {
        ((List) this.b).remove(runnableC2181b);
    }

    @Override // z7.InterfaceC2180a
    public void b() {
        Iterator it = new ArrayList((List) this.b).iterator();
        while (it.hasNext()) {
            RunnableC2181b runnableC2181b = (RunnableC2181b) it.next();
            AbstractC2188i.d(runnableC2181b.f6974a);
            AbstractC2188i.d(runnableC2181b.b);
        }
    }

    @Override // n2.b
    public void c(JSONObject jSONObject) {
        i.a().d(jSONObject, this.f944a, ((C1483a) this.b).e, com.apm.insight.g.g(), true, null);
    }

    @Override // z7.InterfaceC2180a
    public void d(RunnableC2181b runnableC2181b) {
        this.f944a++;
        Thread thread = new Thread(runnableC2181b);
        thread.setDaemon(true);
        thread.setName("NanoHttpd Request Processor (#" + this.f944a + ")");
        ((List) this.b).add(runnableC2181b);
        thread.start();
    }

    public long e() {
        if (((MappedByteBuffer) this.b) == null) {
            try {
                File file = new File(S0.b.x0(), AbstractC1451a.A().replace(".", "_").replace(":", "-") + "_seq_num.txt");
                boolean zExists = file.exists();
                if (!zExists) {
                    file.createNewFile();
                }
                MappedByteBuffer map = new RandomAccessFile(file, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, 8L);
                this.b = map;
                if (!zExists) {
                    map.putLong(0, 0L);
                    return 0L;
                }
            } catch (Throwable th) {
                o.g(S0.a.f1163a, "prepare seq_number fail.", th);
            }
        }
        MappedByteBuffer mappedByteBuffer = (MappedByteBuffer) this.b;
        if (mappedByteBuffer == null) {
            long j5 = this.f944a;
            this.f944a = 1 + j5;
            return j5;
        }
        long j6 = mappedByteBuffer.getLong(0) + 1;
        this.f944a = j6;
        ((MappedByteBuffer) this.b).putLong(0, j6);
        return this.f944a;
    }

    public w f() {
        v vVar = new v(0);
        while (true) {
            String strJ = ((V9.i) this.b).j(this.f944a);
            this.f944a -= strJ.length();
            if (strJ.length() == 0) {
                return vVar.g();
            }
            int iP0 = m.p0(strJ, ':', 1, 4);
            if (iP0 != -1) {
                String strSubstring = strJ.substring(0, iP0);
                k.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring2 = strJ.substring(iP0 + 1);
                k.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
                vVar.d(strSubstring, strSubstring2);
            } else if (strJ.charAt(0) == ':') {
                String strSubstring3 = strJ.substring(1);
                k.e(strSubstring3, "this as java.lang.String).substring(startIndex)");
                vVar.d("", strSubstring3);
            } else {
                vVar.d("", strJ);
            }
        }
    }
}

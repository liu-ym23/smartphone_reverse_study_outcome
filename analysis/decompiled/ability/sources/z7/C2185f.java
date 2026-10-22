package z7;

import M0.k;
import androidx.autofill.HintConstants;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import fi.iki.elonen.NanoHTTPD$Method;
import fi.iki.elonen.NanoHTTPD$Response$Status;
import fi.iki.elonen.NanoHTTPD$ResponseException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.regex.Matcher;
import javax.net.ssl.SSLException;

/* renamed from: z7.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2185f {

    /* renamed from: a, reason: collision with root package name */
    public final k f6978a;
    public final OutputStream b;
    public final BufferedInputStream c;
    public int d;
    public int e;
    public String f;
    public NanoHTTPD$Method g;
    public HashMap h;
    public HashMap i;

    /* renamed from: j, reason: collision with root package name */
    public C2183d f6979j;
    public final String k;
    public String l;
    public final /* synthetic */ AbstractC2188i m;

    public C2185f(AbstractC2188i abstractC2188i, k kVar, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
        this.m = abstractC2188i;
        this.f6978a = kVar;
        this.c = new BufferedInputStream(inputStream, 8192);
        this.b = outputStream;
        this.k = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "127.0.0.1" : inetAddress.getHostAddress().toString();
        if (!inetAddress.isLoopbackAddress() && !inetAddress.isAnyLocalAddress()) {
            inetAddress.getHostName().getClass();
        }
        this.i = new HashMap();
    }

    public static void c(String str, Map map) {
        String strTrim;
        String strB;
        if (str == null) {
            return;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            int iIndexOf = strNextToken.indexOf(61);
            if (iIndexOf >= 0) {
                strTrim = AbstractC2188i.b(strNextToken.substring(0, iIndexOf)).trim();
                strB = AbstractC2188i.b(strNextToken.substring(iIndexOf + 1));
            } else {
                strTrim = AbstractC2188i.b(strNextToken).trim();
                strB = "";
            }
            List arrayList = (List) map.get(strTrim);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(strTrim, arrayList);
            }
            arrayList.add(strB);
        }
    }

    public static int e(int i, byte[] bArr) {
        int i6;
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (i11 >= i) {
                return 0;
            }
            byte b = bArr[i10];
            if (b == 13 && bArr[i11] == 10 && (i6 = i10 + 3) < i && bArr[i10 + 2] == 13 && bArr[i6] == 10) {
                return i10 + 4;
            }
            if (b == 10 && bArr[i11] == 10) {
                return i10 + 2;
            }
            i10 = i11;
        }
    }

    public static int[] f(ByteBuffer byteBuffer, byte[] bArr) {
        int[] iArr = new int[0];
        if (byteBuffer.remaining() < bArr.length) {
            return iArr;
        }
        int length = bArr.length + 4096;
        byte[] bArr2 = new byte[length];
        int iRemaining = byteBuffer.remaining() < length ? byteBuffer.remaining() : length;
        byteBuffer.get(bArr2, 0, iRemaining);
        int length2 = iRemaining - bArr.length;
        int i = 0;
        do {
            for (int i6 = 0; i6 < length2; i6++) {
                for (int i10 = 0; i10 < bArr.length && bArr2[i6 + i10] == bArr[i10]; i10++) {
                    if (i10 == bArr.length - 1) {
                        int[] iArr2 = new int[iArr.length + 1];
                        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                        iArr2[iArr.length] = i + i6;
                        iArr = iArr2;
                    }
                }
            }
            i += length2;
            System.arraycopy(bArr2, length - bArr.length, bArr2, 0, bArr.length);
            length2 = length - bArr.length;
            if (byteBuffer.remaining() < length2) {
                length2 = byteBuffer.remaining();
            }
            byteBuffer.get(bArr2, bArr.length, length2);
        } while (length2 > 0);
        return iArr;
    }

    public final void a(BufferedReader bufferedReader, HashMap map, HashMap map2, HashMap map3) throws NanoHTTPD$ResponseException, IOException {
        String strB;
        try {
            String line = bufferedReader.readLine();
            if (line == null) {
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            boolean zHasMoreTokens = stringTokenizer.hasMoreTokens();
            NanoHTTPD$Response$Status nanoHTTPD$Response$Status = NanoHTTPD$Response$Status.BAD_REQUEST;
            if (!zHasMoreTokens) {
                throw new NanoHTTPD$ResponseException(nanoHTTPD$Response$Status, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
            }
            map.put(GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, stringTokenizer.nextToken());
            if (!stringTokenizer.hasMoreTokens()) {
                throw new NanoHTTPD$ResponseException(nanoHTTPD$Response$Status, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
            }
            String strNextToken = stringTokenizer.nextToken();
            int iIndexOf = strNextToken.indexOf(63);
            if (iIndexOf >= 0) {
                c(strNextToken.substring(iIndexOf + 1), map2);
                strB = AbstractC2188i.b(strNextToken.substring(0, iIndexOf));
            } else {
                strB = AbstractC2188i.b(strNextToken);
            }
            if (stringTokenizer.hasMoreTokens()) {
                this.l = stringTokenizer.nextToken();
            } else {
                this.l = "HTTP/1.1";
                AbstractC2188i.i.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
            }
            String line2 = bufferedReader.readLine();
            while (line2 != null && !line2.trim().isEmpty()) {
                int iIndexOf2 = line2.indexOf(58);
                if (iIndexOf2 >= 0) {
                    map3.put(line2.substring(0, iIndexOf2).trim().toLowerCase(Locale.US), line2.substring(iIndexOf2 + 1).trim());
                }
                line2 = bufferedReader.readLine();
            }
            map.put("uri", strB);
        } catch (IOException e) {
            throw new NanoHTTPD$ResponseException("SERVER INTERNAL ERROR: IOException: " + e.getMessage(), e);
        }
    }

    public final void b(C2182c c2182c, ByteBuffer byteBuffer, HashMap map, HashMap map2) throws Throwable {
        String str;
        C2182c c2182c2 = c2182c;
        String str2 = c2182c2.d;
        NanoHTTPD$Response$Status nanoHTTPD$Response$Status = NanoHTTPD$Response$Status.INTERNAL_ERROR;
        try {
            int[] iArrF = f(byteBuffer, str2.getBytes());
            int length = iArrF.length;
            NanoHTTPD$Response$Status nanoHTTPD$Response$Status2 = NanoHTTPD$Response$Status.BAD_REQUEST;
            if (length < 2) {
                throw new NanoHTTPD$ResponseException(nanoHTTPD$Response$Status2, "BAD REQUEST: Content type is multipart/form-data but contains less than two boundary strings.");
            }
            int i = 1024;
            byte[] bArr = new byte[1024];
            int i6 = 0;
            int i10 = 0;
            int i11 = 0;
            while (i10 < iArrF.length - 1) {
                byteBuffer.position(iArrF[i10]);
                int iRemaining = byteBuffer.remaining() < i ? byteBuffer.remaining() : i;
                byteBuffer.get(bArr, i6, iRemaining);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, i6, iRemaining), Charset.forName(c2182c2.a())), iRemaining);
                String line = bufferedReader.readLine();
                if (line == null || !line.contains(str2)) {
                    throw new NanoHTTPD$ResponseException(nanoHTTPD$Response$Status2, "BAD REQUEST: Content type is multipart/form-data but chunk does not start with boundary.");
                }
                String line2 = bufferedReader.readLine();
                String strGroup = null;
                String strTrim = null;
                int i12 = i11;
                int i13 = 2;
                String str3 = null;
                while (line2 != null && line2.trim().length() > 0) {
                    Matcher matcher = AbstractC2188i.f.matcher(line2);
                    if (matcher.matches()) {
                        str = str2;
                        Matcher matcher2 = AbstractC2188i.h.matcher(matcher.group(2));
                        while (matcher2.find()) {
                            int[] iArr = iArrF;
                            String strGroup2 = matcher2.group(1);
                            if (HintConstants.AUTOFILL_HINT_NAME.equalsIgnoreCase(strGroup2)) {
                                strGroup = matcher2.group(2);
                            } else if ("filename".equalsIgnoreCase(strGroup2)) {
                                String strGroup3 = matcher2.group(2);
                                if (strGroup3.isEmpty()) {
                                    str3 = strGroup3;
                                } else if (i12 > 0) {
                                    str3 = strGroup3;
                                    i12++;
                                    strGroup = strGroup + String.valueOf(i12);
                                } else {
                                    i12++;
                                    str3 = strGroup3;
                                }
                            }
                            iArrF = iArr;
                        }
                    } else {
                        str = str2;
                    }
                    int[] iArr2 = iArrF;
                    Matcher matcher3 = AbstractC2188i.g.matcher(line2);
                    if (matcher3.matches()) {
                        strTrim = matcher3.group(2).trim();
                    }
                    line2 = bufferedReader.readLine();
                    i13++;
                    iArrF = iArr2;
                    str2 = str;
                }
                String str4 = str2;
                int[] iArr3 = iArrF;
                int i14 = 0;
                while (true) {
                    int i15 = i13 - 1;
                    if (i13 <= 0) {
                        break;
                    }
                    while (bArr[i14] != 10) {
                        i14++;
                    }
                    i14++;
                    i13 = i15;
                }
                if (i14 >= iRemaining - 4) {
                    throw new NanoHTTPD$ResponseException(nanoHTTPD$Response$Status, "Multipart header size exceeds MAX_HEADER_SIZE.");
                }
                int i16 = iArr3[i10] + i14;
                i10++;
                int i17 = iArr3[i10] - 4;
                byteBuffer.position(i16);
                List arrayList = (List) map.get(strGroup);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(strGroup, arrayList);
                }
                if (strTrim == null) {
                    byte[] bArr2 = new byte[i17 - i16];
                    byteBuffer.get(bArr2);
                    arrayList.add(new String(bArr2, c2182c.a()));
                } else {
                    String strH = h(byteBuffer, i16, i17 - i16);
                    if (map2.containsKey(strGroup)) {
                        int i18 = 2;
                        while (true) {
                            if (!map2.containsKey(strGroup + i18)) {
                                break;
                            } else {
                                i18++;
                            }
                        }
                        map2.put(strGroup + i18, strH);
                    } else {
                        map2.put(strGroup, strH);
                    }
                    arrayList.add(str3);
                }
                c2182c2 = c2182c;
                iArrF = iArr3;
                i11 = i12;
                str2 = str4;
                i = 1024;
                i6 = 0;
            }
        } catch (NanoHTTPD$ResponseException e) {
            throw e;
        } catch (Exception e6) {
            throw new NanoHTTPD$ResponseException(nanoHTTPD$Response$Status, e6.toString());
        }
    }

    public final void d() throws Exception {
        NanoHTTPD$Response$Status nanoHTTPD$Response$Status = NanoHTTPD$Response$Status.INTERNAL_ERROR;
        AbstractC2188i abstractC2188i = this.m;
        k kVar = this.f6978a;
        BufferedInputStream bufferedInputStream = this.c;
        OutputStream outputStream = this.b;
        try {
            try {
                try {
                    try {
                        byte[] bArr = new byte[8192];
                        boolean z10 = false;
                        this.d = 0;
                        this.e = 0;
                        bufferedInputStream.mark(8192);
                        try {
                            int i = bufferedInputStream.read(bArr, 0, 8192);
                            if (i == -1) {
                                AbstractC2188i.d(bufferedInputStream);
                                AbstractC2188i.d(outputStream);
                                throw new SocketException("NanoHttpd Shutdown");
                            }
                            while (i > 0) {
                                int i6 = this.e + i;
                                this.e = i6;
                                int iE = e(i6, bArr);
                                this.d = iE;
                                if (iE > 0) {
                                    break;
                                }
                                int i10 = this.e;
                                i = bufferedInputStream.read(bArr, i10, 8192 - i10);
                            }
                            if (this.d < this.e) {
                                bufferedInputStream.reset();
                                bufferedInputStream.skip(this.d);
                            }
                            this.h = new HashMap();
                            HashMap map = this.i;
                            if (map == null) {
                                this.i = new HashMap();
                            } else {
                                map.clear();
                            }
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, 0, this.e)));
                            HashMap map2 = new HashMap();
                            a(bufferedReader, map2, this.h, this.i);
                            String str = this.k;
                            if (str != null) {
                                this.i.put("remote-addr", str);
                                this.i.put("http-client-ip", str);
                            }
                            NanoHTTPD$Method nanoHTTPD$MethodA = NanoHTTPD$Method.a((String) map2.get(GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD));
                            this.g = nanoHTTPD$MethodA;
                            if (nanoHTTPD$MethodA == null) {
                                throw new NanoHTTPD$ResponseException(NanoHTTPD$Response$Status.BAD_REQUEST, "BAD REQUEST: Syntax error. HTTP verb " + ((String) map2.get(GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD)) + " unhandled.");
                            }
                            this.f = (String) map2.get("uri");
                            this.f6979j = new C2183d(this.i);
                            String str2 = (String) this.i.get("connection");
                            boolean z11 = "HTTP/1.1".equals(this.l) && (str2 == null || !str2.matches("(?i).*close.*"));
                            fi.iki.elonen.a aVarE = abstractC2188i.e(this);
                            String str3 = (String) this.i.get("accept-encoding");
                            this.f6979j.b();
                            aVarE.w(this.g);
                            if (AbstractC2188i.h(aVarE) && str3 != null && str3.contains("gzip")) {
                                z10 = true;
                            }
                            aVarE.r(z10);
                            aVarE.s(z11);
                            aVarE.k(outputStream);
                            if (!z11 || aVarE.g()) {
                                throw new SocketException("NanoHttpd Shutdown");
                            }
                            AbstractC2188i.d(aVarE);
                            kVar.n();
                        } catch (SSLException e) {
                            throw e;
                        } catch (IOException unused) {
                            AbstractC2188i.d(bufferedInputStream);
                            AbstractC2188i.d(outputStream);
                            throw new SocketException("NanoHttpd Shutdown");
                        }
                    } catch (NanoHTTPD$ResponseException e6) {
                        AbstractC2188i.c(e6.a(), "text/plain", e6.getMessage()).k(outputStream);
                        AbstractC2188i.d(outputStream);
                        AbstractC2188i.d(null);
                        kVar.n();
                    }
                } catch (SSLException e9) {
                    AbstractC2188i.c(nanoHTTPD$Response$Status, "text/plain", "SSL PROTOCOL FAILURE: " + e9.getMessage()).k(outputStream);
                    AbstractC2188i.d(outputStream);
                    AbstractC2188i.d(null);
                    kVar.n();
                } catch (IOException e10) {
                    AbstractC2188i.c(nanoHTTPD$Response$Status, "text/plain", "SERVER INTERNAL ERROR: IOException: " + e10.getMessage()).k(outputStream);
                    AbstractC2188i.d(outputStream);
                    AbstractC2188i.d(null);
                    kVar.n();
                }
            } catch (SocketException e11) {
                throw e11;
            } catch (SocketTimeoutException e12) {
                throw e12;
            }
        } catch (Throwable th) {
            AbstractC2188i.d(null);
            kVar.n();
            throw th;
        }
    }

    public final void g(HashMap map) {
        long j5;
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutput dataOutputStream;
        ByteBuffer map2;
        RandomAccessFile randomAccessFile = null;
        try {
            if (this.i.containsKey("content-length")) {
                j5 = Long.parseLong((String) this.i.get("content-length"));
            } else {
                j5 = this.d < this.e ? r4 - r3 : 0L;
            }
            if (j5 < 1024) {
                byteArrayOutputStream = new ByteArrayOutputStream();
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            } else {
                try {
                    k kVar = this.f6978a;
                    C2184e c2184e = new C2184e((File) kVar.b);
                    ((ArrayList) kVar.c).add(c2184e);
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(c2184e.f6977a.getAbsolutePath(), "rw");
                    byteArrayOutputStream = null;
                    randomAccessFile = randomAccessFile2;
                    dataOutputStream = randomAccessFile2;
                } catch (Exception e) {
                    throw new Error(e);
                }
            }
            byte[] bArr = new byte[512];
            while (this.e >= 0 && j5 > 0) {
                int i = this.c.read(bArr, 0, (int) Math.min(j5, 512L));
                this.e = i;
                j5 -= i;
                if (i > 0) {
                    dataOutputStream.write(bArr, 0, i);
                }
            }
            if (byteArrayOutputStream != null) {
                map2 = ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
            } else {
                map2 = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, randomAccessFile.length());
                randomAccessFile.seek(0L);
            }
            if (NanoHTTPD$Method.b.equals(this.g)) {
                C2182c c2182c = new C2182c((String) this.i.get("content-type"));
                String str = c2182c.b;
                if (!"multipart/form-data".equalsIgnoreCase(str)) {
                    byte[] bArr2 = new byte[map2.remaining()];
                    map2.get(bArr2);
                    String strTrim = new String(bArr2, c2182c.a()).trim();
                    if ("application/x-www-form-urlencoded".equalsIgnoreCase(str)) {
                        c(strTrim, this.h);
                    } else if (strTrim.length() != 0) {
                        map.put("postData", strTrim);
                    }
                } else {
                    if (c2182c.d == null) {
                        throw new NanoHTTPD$ResponseException(NanoHTTPD$Response$Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                    }
                    b(c2182c, map2, this.h, map);
                }
            } else if (NanoHTTPD$Method.f4449a.equals(this.g)) {
                map.put("content", h(map2, 0, map2.limit()));
            }
        } finally {
            AbstractC2188i.d(null);
        }
    }

    public final String h(ByteBuffer byteBuffer, int i, int i6) throws Throwable {
        File file;
        ByteBuffer byteBufferDuplicate;
        FileOutputStream fileOutputStream;
        if (i6 <= 0) {
            return "";
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                k kVar = this.f6978a;
                C2184e c2184e = new C2184e((File) kVar.b);
                ((ArrayList) kVar.c).add(c2184e);
                file = c2184e.f6977a;
                byteBufferDuplicate = byteBuffer.duplicate();
                fileOutputStream = new FileOutputStream(file.getAbsolutePath());
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            FileChannel channel = fileOutputStream.getChannel();
            byteBufferDuplicate.position(i).limit(i + i6);
            channel.write(byteBufferDuplicate.slice());
            String absolutePath = file.getAbsolutePath();
            AbstractC2188i.d(fileOutputStream);
            return absolutePath;
        } catch (Exception e6) {
            e = e6;
            throw new Error(e);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            AbstractC2188i.d(fileOutputStream2);
            throw th;
        }
    }
}

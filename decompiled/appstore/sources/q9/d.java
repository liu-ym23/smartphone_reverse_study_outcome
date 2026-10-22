package q9;

import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.media.cache.VideoCacheException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static void a(File r10, a r11) {
        File r12 = new File(r10, "remote.m3u8");
        if (r12.exists() == false) goto L5;
        return;
    L5:
        BufferedWriter r13 = new BufferedWriter(new FileWriter(r12, false));
        r13.write("#EXTM3U\n");
        r13.write("#EXT-X-VERSION:" + r11.g() + "\n");
        r13.write("#EXT-X-MEDIA-SEQUENCE:" + r11.c() + "\n");
        r13.write("#EXT-X-TARGETDURATION:" + r11.d() + "\n");
        Iterator r14 = r11.f().iterator();
    L7:
        if (r14.hasNext() == false) goto L26;
        c r15 = (c) r14.next();
        if (r15.l() == false) goto L23;
        if (r15.g() == null) goto L23;
        String r16 = "METHOD=" + r15.g();
        if (r15.e() == null) goto L21;
        String r17 = r15.e();
        r16 = r16 + ",URI=\"" + r17 + "\"";
        BufferedReader r18 = new BufferedReader(new InputStreamReader(new URL(r17).openStream()));
        StringBuilder r19 = new StringBuilder();
    L15:
        String r20 = r18.readLine();
        if (r20 == null) goto L18;
        r19.append(r20);
        goto L15
    L18:
        r15.o(u9.d.h(r19.toString()));
        FileOutputStream r21 = new FileOutputStream(new File(r10, r15.f()));
        r21.write(r19.toString().getBytes());
        r18.close();
        r21.close();
        if (r15.d() == null) goto L21;
        r16 = r16 + ",IV=" + r15.d();
    L21:
        r13.write("#EXT-X-KEY:" + r16 + "\n");
    L23:
        if (r15.k() == false) goto L25;
        r13.write("#EXT-X-DISCONTINUITY\n");
    L25:
        r13.write("#EXTINF:" + r15.b() + ",\n");
        r13.write(r15.j());
        r13.newLine();
        goto L7
    L26:
        r13.write("#EXT-X-ENDLIST");
        r13.flush();
        r13.close();
    }

    public static a b(p9.a r30, String r31, boolean r32, File r33) {
        o0.a.a("M3U8Utils parseM3U8Info url=" + r31 + ", isLocalFile=" + r32);
        URL r10 = new URL(r31);
        if (r32 == false) goto L5;
        InputStreamReader r11 = new InputStreamReader(new FileInputStream(r33));
        BufferedReader r12 = new BufferedReader(r11);
    L11:
        String r13 = r31.substring(0, r31.lastIndexOf(LibrarianImpl.Constants.SEPARATOR) + 1);
        a r14 = new a(r31, r13, r31.substring(0, r31.indexOf(r10.getPath()) + 1));
        int r15 = 0;
        int r16 = 0;
        boolean r17 = false;
        boolean r18 = false;
        int r19 = 0;
        boolean r20 = false;
        int r22 = 0;
        boolean r23 = false;
    L12:
        float r110 = 0.0f;
        String r24 = null;
        String r25 = null;
        String r26 = null;
    L13:
        String r111 = r12.readLine();
        if (r111 == null) goto L119;
        StringBuilder r112 = new StringBuilder();
        r18 = r18;
        r112.append("M3U8Utils parseM3U8Info line=");
        r112.append(r111);
        o0.a.d(r112.toString());
        int r28 = r16;
        int r29 = r15;
        if (r111.startsWith("#EXT") == false) goto L73;
        if (r111.startsWith("#EXTINF") == true) goto L19;
        if (r111.startsWith("#EXT-X-TARGETDURATION") == true) goto L27;
        if (r111.startsWith("#EXT-X-VERSION") == true) goto L32;
        if (r111.startsWith("#EXT-X-MEDIA-SEQUENCE") == true) goto L39;
        if (r111.startsWith("#EXT-X-DISCONTINUITY") == false) goto L48;
        r18 = r18;
        r16 = r28;
        r15 = r29;
        r17 = true;
        r20 = true;
        goto L13
    L48:
        if (r111.startsWith("#EXT-X-ENDLIST") == false) goto L51;
        r16 = r28;
        r15 = r29;
        r17 = true;
        r18 = true;
        goto L13
    L51:
        if (r111.startsWith("#EXT-X-KEY") == false) goto L22;
        String r113 = c(r111, b.f23581e);
        String r114 = c(r111, b.f23582f);
        if ("NONE".equals(r113) == true) goto L72;
        String r21 = c(r111, b.f23584h);
        if ("identity".equals(r114) == true) goto L58;
        if (r114 == null) goto L58;
    L65:
        r25 = r21;
    L58:
        if ("AES-128".equals(r113) == false) goto L65;
        String r27 = d(r111, b.f23583g);
        if (r27 == null) goto L65;
        if (r27.startsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L67;
        r27 = r31.substring(0, r31.indexOf(r27.substring(0, r27.indexOf(47, 1)))) + r27;
    L64:
        r26 = r27;
        goto L65
    L67:
        if (r27.startsWith(HttpHost.DEFAULT_SCHEME_NAME) == true) goto L64;
        if (r27.startsWith("https") == true) goto L64;
        r27 = r13 + r27;
    L72:
        r24 = r113;
        r18 = r18;
        r16 = r28;
        r15 = r29;
        r17 = true;
        r23 = true;
    L22:
        r16 = r28;
    L23:
        r15 = r29;
    L24:
        r17 = true;
        goto L13
    L39:
        String r34 = d(r111, b.f23580d);
        if (TextUtils.isEmpty(r34) == true) goto L42;
        r16 = Integer.parseInt(r34);
        goto L23
    L42:
        r16 = r28;
        goto L23
    L32:
        String r35 = d(r111, b.f23579c);
        if (TextUtils.isEmpty(r35) == true) goto L35;
        r15 = Integer.parseInt(r35);
    L36:
        r18 = r18;
        r16 = r28;
        goto L24
    L35:
        r15 = r29;
        goto L36
    L27:
        String r36 = d(r111, b.f23577a);
        if (TextUtils.isEmpty(r36) == true) goto L22;
        r19 = Integer.parseInt(r36);
        goto L22
    L19:
        String r37 = d(r111, b.f23578b);
        if (TextUtils.isEmpty(r37) == true) goto L22;
        r110 = Float.parseFloat(r37);
        goto L22
    L73:
        if (r17 == false) goto L118;
        if (r111.endsWith(".m3u8") == true) goto L77;
        c r38 = new c();
        if (r32 == false) goto L97;
        r38.m(r111, r110, r22, r20, r23);
        boolean r115 = false;
    L114:
        if (r23 == false) goto L116;
        r38.p(r24, r26, r25);
    L116:
        r14.a(r38);
        r22 = r22 + 1;
        r20 = r115;
        r23 = r20;
        r18 = r18;
        r16 = r28;
        r15 = r29;
        goto L12
    L97:
        if (r111.startsWith("https") == false) goto L99;
    L100:
        r115 = false;
        r38.m(r111, r110, r22, r20, r23);
        goto L114
    L99:
        if (r111.startsWith(HttpHost.DEFAULT_SCHEME_NAME) == true) goto L100;
        if (r111.startsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L112;
        int r116 = r111.indexOf(47, 1);
        if (r116 != (-1)) goto L107;
        String r117 = r13 + r111.substring(1);
    L106:
        r115 = false;
    L111:
        r38.m(r117, r110, r22, r20, r23);
        goto L114
    L107:
        int r39 = r31.indexOf(r111.substring(0, r116));
        if (r39 != (-1)) goto L110;
        r117 = r13 + r111.substring(1);
        goto L106
    L110:
        StringBuilder r118 = new StringBuilder();
        r115 = false;
        r118.append(r31.substring(0, r39));
        r118.append(r111);
        r117 = r118.toString();
        goto L111
    L112:
        r115 = false;
        r38.m(r13 + r111, r110, r22, r20, r23);
        goto L114
    L77:
        if (r111.startsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L85;
        int r40 = r111.indexOf(47, 1);
        if (r40 != (-1)) goto L81;
        String r41 = r13 + r111.substring(1);
    L83:
        return b(r30, r41, r32, r33);
    L81:
        r41 = r31.substring(0, r31.indexOf(r111.substring(0, r40))) + r111;
        goto L83
    L85:
        if (r111.startsWith(HttpHost.DEFAULT_SCHEME_NAME) == true) goto L92;
        if (r111.startsWith("https") == true) goto L92;
        return b(r30, r13 + r111, r32, r33);
    L92:
        return b(r30, r111, r32, r33);
    L118:
        throw new VideoCacheException("M3U8 File content error");
    L119:
        int r210 = r15;
        int r211 = r16;
        boolean r212 = r18;
        if (r11 == null) goto L122;
        r11.close();
    L122:
        r12.close();
        r14.l(r19);
        r14.m(r210);
        r14.k(r211);
        r14.j(r212);
        return r14;
    L5:
        HttpURLConnection r42 = (HttpURLConnection) r10.openConnection();
        if (r30.k() == true) goto L8;
    L10:
        r12 = new BufferedReader(new InputStreamReader(r42.getInputStream()));
        r11 = null;
        goto L11
    L8:
        if ((r42 instanceof HttpsURLConnection) == false) goto L10;
        u9.b.h((HttpsURLConnection) r42);
        goto L10
    }

    public static String c(String r10, Pattern r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        Matcher r12 = r11.matcher(r10);
        if (r12.find() == true) goto L8;
        return null;
    L8:
        return r12.group(1);
    }

    public static String d(String r10, Pattern r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        Matcher r12 = r11.matcher(r10);
        if (r12.find() == true) goto L8;
    L11:
        return null;
    L8:
        if (r12.groupCount() != 1) goto L11;
        return r12.group(1);
    }
}

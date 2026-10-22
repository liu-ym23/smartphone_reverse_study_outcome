package com.bytedance.article.common.monitor.stack;

import android.text.TextUtils;
import android.util.Pair;
import com.android.vcard.VCardBuilder;
import com.bytedance.apm.util.NetUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.core.encrypt.RequestEncryptUtils;
import com.bytedance.frameworks.core.encrypt.TTEncryptUtils;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.obric.appintents.contacts.ContactsCreateIntent;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class HttpUtil {
    private static final boolean DEBUG_MOBILE = false;

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        final int nativeInt;

        public static CompressType valueOf(String r1) {
            return (CompressType) Enum.valueOf(CompressType.class, r1);
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
        }

        static {
            CompressType r0 = new CompressType("NONE", 0, 0);
            NONE = r0;
            CompressType r1 = new CompressType("GZIP", 1, 1);
            GZIP = r1;
            CompressType r3 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r3;
            $VALUES = new CompressType[]{r0, r1, r3};
        }

        private CompressType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }
    }

    public static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;
        final int nativeInt;

        public static NetworkType valueOf(String r1) {
            return (NetworkType) Enum.valueOf(NetworkType.class, r1);
        }

        public static NetworkType[] values() {
            return (NetworkType[]) $VALUES.clone();
        }

        static {
            NetworkType r0 = new NetworkType("NONE", 0, 0);
            NONE = r0;
            NetworkType r1 = new NetworkType(ContactsCreateIntent.CREATE_TEL_TYPE_MOBILE, 1, 1);
            MOBILE = r1;
            NetworkType r3 = new NetworkType("MOBILE_2G", 2, 2);
            MOBILE_2G = r3;
            NetworkType r5 = new NetworkType("MOBILE_3G", 3, 3);
            MOBILE_3G = r5;
            NetworkType r7 = new NetworkType("WIFI", 4, 4);
            WIFI = r7;
            NetworkType r9 = new NetworkType("MOBILE_4G", 5, 5);
            MOBILE_4G = r9;
            $VALUES = new NetworkType[]{r0, r1, r3, r5, r7, r9};
        }

        private NetworkType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }

        public int getValue() {
            return this.nativeInt;
        }
    }

    public HttpUtil() {
    }

    public static byte[] getRequest(String r7, String r8, boolean r9) throws Throwable {
        if (TextUtils.isDigitsOnly(r7) == false) goto L7;
        return null;
    L7:
        return excuteRequest(r7, null, r8, null, HttpMethodContrants.GET, false, r9);
    }

    public static byte[] excuteRequest(String r4, byte[] r5, String r6, String r7, String r8, boolean r9, boolean r10) throws Throwable {
        InputStream r1 = null;
        if (r10 == false) goto L15;
        LinkedList r11 = new LinkedList();     // Catch: Throwable -> L47
        HttpURLConnection r12 = NetUtils.getUrlConnection(RequestEncryptUtils.tryEncryptRequest(r4, r11));     // Catch: Throwable -> L47
    L45:
        th = th;
    L64:
        throw th;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        if (0 != 0) goto L68;
    L53:
        if (r12 == null) goto L79;
        r12.disconnect();     // Catch: Exception -> L59
        throw th;
    L80:
        throw th;
    L79:
        throw th;
    L68:
        r1.close();     // Catch: Exception -> L58
        goto L53
    L6:
        if (r11.isEmpty() == true) goto L16;
        Iterator r13 = r11.iterator();     // Catch: Throwable -> L45
    L9:
        if (r13.hasNext() == false) goto L16;
        Pair r2 = (Pair) r13.next();     // Catch: Throwable -> L45
        if (r2 == null) goto L9;
        r12.setRequestProperty((String) r2.first, (String) r2.second);     // Catch: Throwable -> L45
    L16:
        r12.setDoOutput(r9);     // Catch: Throwable -> L45
        if (r6 == null) goto L19;
        r12.setRequestProperty("Content-Type", r6);     // Catch: Throwable -> L45
    L19:
        if (r7 == null) goto L21;
        r12.setRequestProperty("Content-Encoding", r7);     // Catch: Throwable -> L45
    L21:
        r12.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L45
        r12.setRequestProperty("Version-Code", "1");     // Catch: Throwable -> L45
        if (r8 == null) goto L44;
        r12.setRequestMethod(r8);     // Catch: Throwable -> L45
        if (r5 != null) goto L26;
    L28:
        int r14 = r12.getResponseCode();     // Catch: Throwable -> L45
        if (r14 != 200) goto L42;
        InputStream r3 = r12.getInputStream();     // Catch: Throwable -> L45
        String r15 = r12.getContentEncoding();     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r15) == false) goto L33;
    L35:
        byte[] r16 = toByteArray(r3);     // Catch: Throwable -> L45
    L36:
        if (r3 != null) goto L70;
    L38:
        if (r12 != null) goto L66;
    L40:
        return r16;
    L66:
        r12.disconnect();     // Catch: Exception -> L57
        goto L40
    L70:
        r3.close();     // Catch: Exception -> L56
        goto L38
    L33:
        if (r15.equalsIgnoreCase("gzip") == false) goto L35;
        GZIPInputStream r17 = new GZIPInputStream(r3);     // Catch: Throwable -> L45
        r16 = toByteArray(r17);     // Catch: Throwable -> L45
        r17.close();     // Catch: Throwable -> L45
        goto L36
    L42:
        throw new HttpResponseException(r14, r12.getResponseMessage());     // Catch: Throwable -> L45
    L26:
        if (r5.length <= 0) goto L28;
        DataOutputStream r18 = new DataOutputStream(r12.getOutputStream());     // Catch: Throwable -> L45
        r18.write(r5);     // Catch: Throwable -> L45
        r18.flush();     // Catch: Throwable -> L45
        r18.close();     // Catch: Throwable -> L45
        goto L28
    L44:
        throw new IllegalArgumentException("request method is not null");     // Catch: Throwable -> L45
    L15:
        r12 = NetUtils.getUrlConnection(r4);     // Catch: Throwable -> L47
    L47:
        th = th;
        r12 = null;
        goto L64
    }

    public static byte[] toByteArray(InputStream r4) throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[8192];
    L3:
        int r2 = r4.read(r1);
        if ((-1) == r2) goto L6;
        r0.write(r1, 0, r2);
        goto L3
    L6:
        if (r4 == null) goto L9;
        r4.close();
    L9:
        return r0.toByteArray();
    }

    public static byte[] excutePost(long r7, String r9, byte[] r10, CompressType r11, String r12, boolean r13) throws Throwable {
        String r8 = null;
        if (r9 != null) goto L6;
        return null;
    L6:
        if (r10 != null) goto L8;
        r10 = new byte[0];
    L8:
        int r0 = r10.length;
        if (CompressType.GZIP != r11) goto L17;
        if (r0 <= 128) goto L17;
        ByteArrayOutputStream r14 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r15 = new GZIPOutputStream(r14);
        r15.write(r10);     // Catch: Throwable -> L14
        r15.close();
        r10 = r14.toByteArray();
        r8 = "gzip";
    L24:
        String r3 = r8;
        byte[] r1 = r10;
        if (r13 == false) goto L40;
        byte[] r16 = TTEncryptUtils.encrypt(r1, r1.length);
        if (r16 == null) goto L38;
        if (TextUtils.isEmpty(new URL(r9).getQuery()) == false) goto L34;
        if (r9.endsWith("?") == true) goto L36;
        r9 = r9 + "?";
    L36:
        r9 = r9 + "tt_data=a";
        r12 = "application/octet-stream;tt-data=a";
        r1 = r16;
        goto L38
    L34:
        if (r9.endsWith("&") == true) goto L36;
        r9 = r9 + "&";
    L38:
        return excuteRequest(r9, r1, r12, r3, "POST", true, true);
    L40:
        return excuteRequest(r9, r1, r12, r3, "POST", true, false);
    L14:
        r15.close();
        return null;
    L17:
        if (CompressType.DEFLATER != r11) goto L24;
        if (r0 <= 128) goto L24;
        ByteArrayOutputStream r17 = new ByteArrayOutputStream(8192);
        Deflater r18 = new Deflater();
        r18.setInput(r10);
        r18.finish();
        byte[] r19 = new byte[8192];
    L21:
        if (r18.finished() == true) goto L23;
        r17.write(r19, 0, r18.deflate(r19));
        goto L21
    L23:
        r18.end();
        r10 = r17.toByteArray();
        r8 = "deflate";
        goto L24
    }

    public static String uploadFile(String r11, File r12, Map<String, String> r13, String r14, boolean r15) throws Throwable {
        if (TextUtils.isEmpty(r11) == true) goto L95;
        if (r12 == null) goto L95;
        if (r12.exists() == false) goto L95;
        String r1 = "tt_file_upload" + UUID.randomUUID().toString();
        File r4 = null;
        HttpURLConnection r16 = NetUtils.getUrlConnection(r11);     // Catch: Throwable -> L80
        r16.setReadTimeout(30000);     // Catch: Throwable -> L78
        r16.setConnectTimeout(30000);     // Catch: Throwable -> L78
        r16.setDoInput(true);     // Catch: Throwable -> L78
        r16.setDoOutput(true);     // Catch: Throwable -> L78
        r16.setUseCaches(false);     // Catch: Throwable -> L78
        r16.setRequestMethod("POST");     // Catch: Throwable -> L78
        r16.setRequestProperty("Charset", r14);     // Catch: Throwable -> L78
        r16.setRequestProperty(WsConstants.KEY_CONNECTION, "keep-alive");     // Catch: Throwable -> L78
        r16.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + r1);     // Catch: Throwable -> L78
        if (r15 == false) goto L14;
        r16.setRequestProperty("Content-Encoding", "gzip");     // Catch: Throwable -> L78
    L14:
        if (r13 != null) goto L16;
    L26:
        DataOutputStream r17 = new DataOutputStream(r16.getOutputStream());     // Catch: Throwable -> L78
        if (r12 == null) goto L75;
        StringBuffer r6 = new StringBuffer();     // Catch: Throwable -> L78
        r6.append("--");     // Catch: Throwable -> L78
        r6.append(r1);     // Catch: Throwable -> L78
        r6.append(VCardBuilder.VCARD_END_OF_LINE);     // Catch: Throwable -> L78
        if (r15 == false) goto L36;
        StringBuilder r8 = new StringBuilder().append("Content-Disposition: form-data; name=\"file\"; filename=\"");     // Catch: Throwable -> L78
        if (r12.getName().endsWith(".zip") == false) goto L34;
        String r9 = r12.getName();     // Catch: Throwable -> L78
    L35:
        r6.append(r8.append(r9).append("\"").append(VCardBuilder.VCARD_END_OF_LINE).toString());     // Catch: Throwable -> L78
        goto L36
    L34:
        r9 = r12.getName() + ".zip";     // Catch: Throwable -> L78
    L36:
        r6.append("Content-Type: application/octet-stream; charset=" + r14 + VCardBuilder.VCARD_END_OF_LINE);     // Catch: Throwable -> L78
        r6.append(VCardBuilder.VCARD_END_OF_LINE);     // Catch: Throwable -> L78
        r17.write(r6.toString().getBytes());     // Catch: Throwable -> L78
        if (r15 == false) goto L47;
        if (r12.getName().endsWith(".zip") == true) goto L47;
        File r18 = new File(r12.getAbsolutePath() + "_tmp.zip");     // Catch: Throwable -> L78
    L73:
        th = th;
        HttpURLConnection r19 = r16;
        InputStream r110 = null;
        r4 = r18;
    L112:
        th.printStackTrace();     // Catch: Throwable -> L84
        throw th;     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        if (r4 != null) goto L87;
    L89:
        if (r110 != null) goto L108;
    L91:
        if (r19 == null) goto L126;
        r19.disconnect();     // Catch: Exception -> L99
        throw th;
    L127:
        throw th;
    L126:
        throw th;
    L108:
        r110.close();     // Catch: Exception -> L98
        goto L91
    L87:
        if (r4.exists() == false) goto L89;
        r4.delete();
        goto L89
    L42:
        if (r18.exists() == false) goto L44;
        r18.delete();     // Catch: Throwable -> L73
    L44:
        zipFile(r12, r18);     // Catch: Throwable -> L73
        FileInputStream r111 = new FileInputStream(r18);     // Catch: Throwable -> L73
    L49:
        byte[] r112 = new byte[1024];     // Catch: Throwable -> L73
    L50:
        int r7 = r111.read(r112);     // Catch: Throwable -> L73
        if (r7 == (-1)) goto L53;
        r17.write(r112, 0, r7);     // Catch: Throwable -> L73
        goto L50
    L53:
        r111.close();     // Catch: Throwable -> L73
        r17.write(VCardBuilder.VCARD_END_OF_LINE.getBytes());     // Catch: Throwable -> L73
        r17.write(("--" + r1 + "--" + VCardBuilder.VCARD_END_OF_LINE).getBytes());     // Catch: Throwable -> L73
        r17.flush();     // Catch: Throwable -> L73
        r17.close();     // Catch: Throwable -> L73
        int r113 = r16.getResponseCode();     // Catch: Throwable -> L73
        if (r113 != 200) goto L72;
        InputStream r5 = r16.getInputStream();     // Catch: Throwable -> L73
        String r114 = r16.getContentEncoding();     // Catch: Throwable -> L73
        if (TextUtils.isEmpty(r114) == false) goto L58;
    L60:
        byte[] r115 = toByteArray(r5);     // Catch: Throwable -> L73
    L61:
        String r116 = new String(r115);     // Catch: Throwable -> L73
        if (r18 != null) goto L64;
    L66:
        if (r5 != null) goto L114;
    L68:
        if (r16 != null) goto L110;
    L70:
        return r116;
    L110:
        r16.disconnect();     // Catch: Exception -> L97
        goto L70
    L114:
        r5.close();     // Catch: Exception -> L96
        goto L68
    L64:
        if (r18.exists() == false) goto L66;
        r18.delete();
        goto L66
    L58:
        if (r114.equalsIgnoreCase("gzip") == false) goto L60;
        GZIPInputStream r117 = new GZIPInputStream(r5);     // Catch: Throwable -> L73
        r115 = toByteArray(r117);     // Catch: Throwable -> L73
        r117.close();     // Catch: Throwable -> L73
        goto L61
    L72:
        throw new HttpResponseException(r113, r16.getResponseMessage());     // Catch: Throwable -> L73
    L47:
        r111 = new FileInputStream(r12);     // Catch: Throwable -> L78
        r18 = null;
        goto L49
    L75:
        if (r16 != null) goto L103;
    L77:
        return null;
    L103:
        r16.disconnect();     // Catch: Exception -> L100
        goto L77
    L16:
        if (r13.isEmpty() == true) goto L26;
        Iterator<Map.Entry<String, String>> r118 = r13.entrySet().iterator();     // Catch: Throwable -> L78
    L19:
        if (r118.hasNext() == false) goto L26;
        Map.Entry<String, String> r10 = r118.next();     // Catch: Throwable -> L78
        String r20 = r10.getKey();     // Catch: Throwable -> L78
        String r21 = r10.getValue();     // Catch: Throwable -> L78
        if (TextUtils.isEmpty(r20) == true) goto L19;
        if (TextUtils.isEmpty(r21) == true) goto L19;
        r16.setRequestProperty(r20, r21);     // Catch: Throwable -> L78
    L78:
        th = th;
        r19 = r16;
        r110 = null;
    L80:
        th = th;
        r110 = null;
        r19 = null;
    L95:
        throw new IllegalArgumentException("url and file not be null ");
    }

    public static void zipFile(File r5, File r6) throws IOException {
        FileInputStream r1 = new FileInputStream(r5);     // Catch: Throwable -> L20
        FileOutputStream r7 = new FileOutputStream(r6);     // Catch: Throwable -> L18
        GZIPOutputStream r8 = new GZIPOutputStream(r7);     // Catch: Throwable -> L16
        byte[] r0 = new byte[1024];     // Catch: Throwable -> L14
    L8:
        int r2 = r1.read(r0);     // Catch: Throwable -> L14
        if (r2 == (-1)) goto L12;
        r8.write(r0, 0, r2);     // Catch: Throwable -> L14
        goto L8
    L12:
        r8.close();
        r7.close();
        r1.close();
        return;
    L14:
        Throwable th = th;
    L22:
        if (r8 == null) goto L24;
        r8.close();
    L24:
        if (r7 == null) goto L26;
        r7.close();
    L26:
        if (r1 == null) goto L28;
        r1.close();
    L28:
        throw th;
    L16:
        th = move-exception;
        th = th;
        r8 = null;
    L18:
        th = move-exception;
        r8 = null;
        th = th;
        r7 = null;
    L20:
        th = move-exception;
        r8 = null;
        r1 = null;
        th = th;
        r7 = null;
        goto L22
    }
}

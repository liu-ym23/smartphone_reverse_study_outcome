package com.stepos.statsapp.v3.lib.plugin.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import com.stepos.statsapp.v3.lib.plugin.utils.FailureRestrict;
import com.stepos.statsapp.v3.utils.CommonUtils;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes2.dex */
public class HttpSecureRequester {
    private static final String APPLICATION_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String MULTIPART_FORM_CONTENT_TYPE = "multipart/form-data";
    private static String MULTI_BOUNDARY = "******--W17By8q--";
    private static final String TAG = "HttpSecureRequester";
    private static final Object lock = new Object();
    private static HttpSecureRequester sInstance;
    private Context context;

    private HttpSecureRequester(Context context) {
        this.context = context;
        try {
            System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        com.stepos.statsapp.v3.lib.plugin.secure.a.a(context);
    }

    private Map<String, String> attachKeyHeader(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        byte[] bArrF = com.stepos.statsapp.v3.lib.plugin.secure.a.d().f();
        if (bArrF != null && bArrF.length > 0) {
            String str = new String(bArrF);
            Logger.d(TAG, "attach x_s_key: " + str);
            map.put("X-S-Key", str);
            return map;
        }
        byte[] bArrE = com.stepos.statsapp.v3.lib.plugin.secure.a.d().e();
        if (bArrE != null && bArrE.length > 0) {
            String str2 = new String(com.stepos.statsapp.v3.lib.plugin.secure.a.d().e());
            Logger.d(TAG, "attach x_a_key: " + str2);
            map.put("X-A-Key", "V1:" + str2);
        }
        return map;
    }

    private String generateEf(URL url) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        byte[] bArrB = com.stepos.statsapp.v3.lib.plugin.secure.a.d().b(url.getFile().getBytes());
        if (bArrB == null) {
            return null;
        }
        String strEncodeToString = Base64.encodeToString(bArrB, 2);
        try {
            strEncodeToString = URLEncoder.encode(strEncodeToString, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
        Logger.d(TAG, "generated ef: " + strEncodeToString);
        return strEncodeToString;
    }

    private byte[] getByteArrayByInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int i10 = inputStream.read();
                if (i10 == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    CommonUtils.closeQuietly(byteArrayOutputStream);
                    return byteArray;
                }
                byteArrayOutputStream.write(i10);
            } catch (Throwable th) {
                CommonUtils.closeQuietly(byteArrayOutputStream);
                throw th;
            }
        }
    }

    private URL getEfURL(URL url) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        URL url2;
        try {
            String strGenerateEf = generateEf(url);
            url2 = new URL(url.getProtocol(), url.getHost(), "lighttps?ef=" + strGenerateEf);
        } catch (MalformedURLException e10) {
            e10.printStackTrace();
            url2 = null;
        }
        return url2 == null ? url : url2;
    }

    public static HttpSecureRequester getInstance(Context context) {
        if (sInstance == null) {
            synchronized (lock) {
                try {
                    if (sInstance == null) {
                        sInstance = new HttpSecureRequester(context);
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    private void getsKey(URLConnection uRLConnection) {
        try {
            String headerField = uRLConnection.getHeaderField("X-S-Key");
            Logger.d(TAG, "get x_s_key = " + headerField);
            if (TextUtils.isEmpty(headerField)) {
                return;
            }
            com.stepos.statsapp.v3.lib.plugin.secure.a.d().b(headerField);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.stepos.statsapp.v3.lib.plugin.net.NetResponse realMultipartRequest(java.net.URL r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, byte[] r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.statsapp.v3.lib.plugin.net.HttpSecureRequester.realMultipartRequest(java.net.URL, java.lang.String, java.util.Map, byte[]):com.stepos.statsapp.v3.lib.plugin.net.NetResponse");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.stepos.statsapp.v3.lib.plugin.net.HttpSecureRequester] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.DataOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v6 */
    private NetResponse realStringPartRequest(URL url, String str, String str2, Map<String, String> map, String str3) throws Throwable {
        InputStream inputStream;
        ?? dataOutputStream;
        InputStream inputStream2;
        byte[] byteArrayByInputStream;
        InputStream inputStream3 = null;
        if (url == null) {
            Logger.e(TAG, "url is null");
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setConnectTimeout(Const.I_LOC_JUMP_DELAY);
        httpURLConnection.setReadTimeout(Const.I_LOC_JUMP_DELAY);
        try {
            httpURLConnection.setRequestProperty(e.f30852k, str);
            httpURLConnection.setRequestProperty(e.f30851j, "keep-alive");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type", APPLICATION_CONTENT_TYPE);
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (str3 != null) {
            try {
                Logger.d(TAG, "content:\n" + str3);
                httpURLConnection.setDoOutput(true);
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    byte[] bArrB = com.stepos.statsapp.v3.lib.plugin.secure.a.d().b(str3.getBytes());
                    inputStream2 = dataOutputStream;
                    if (bArrB != null) {
                        dataOutputStream.write(bArrB);
                        dataOutputStream.flush();
                        inputStream2 = dataOutputStream;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.closeQuietly(dataOutputStream);
                    CommonUtils.closeQuietly(inputStream3);
                    httpURLConnection.disconnect();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                dataOutputStream = inputStream3;
                inputStream3 = inputStream;
                CommonUtils.closeQuietly(dataOutputStream);
                CommonUtils.closeQuietly(inputStream3);
                httpURLConnection.disconnect();
                throw th;
            }
        } else {
            inputStream2 = null;
        }
        try {
            getsKey(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            Logger.d(TAG, "code = " + responseCode);
            inputStream = httpURLConnection.getInputStream();
            if (inputStream != null) {
                try {
                    byteArrayByInputStream = getByteArrayByInputStream(inputStream);
                    if (byteArrayByInputStream != null) {
                        Logger.d(TAG, "body = " + new String(byteArrayByInputStream));
                        byteArrayByInputStream = com.stepos.statsapp.v3.lib.plugin.secure.a.d().a(byteArrayByInputStream);
                        if (byteArrayByInputStream != null) {
                            Logger.d(TAG, "decrypt body = " + new String(byteArrayByInputStream));
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream3 = inputStream2;
                    dataOutputStream = inputStream3;
                    inputStream3 = inputStream;
                    CommonUtils.closeQuietly(dataOutputStream);
                    CommonUtils.closeQuietly(inputStream3);
                    httpURLConnection.disconnect();
                    throw th;
                }
            } else {
                byteArrayByInputStream = null;
            }
            if (responseCode != 200 && responseCode != 304) {
                if (responseCode == 495) {
                    com.stepos.statsapp.v3.lib.plugin.secure.a.d().h();
                }
                CommonUtils.closeQuietly(inputStream2);
                CommonUtils.closeQuietly(inputStream);
                httpURLConnection.disconnect();
                return null;
            }
            if (byteArrayByInputStream != null) {
                NetResponse netResponse = new NetResponse(responseCode, new String(byteArrayByInputStream));
                CommonUtils.closeQuietly(inputStream2);
                CommonUtils.closeQuietly(inputStream);
                httpURLConnection.disconnect();
                return netResponse;
            }
            NetResponse netResponse2 = new NetResponse(responseCode, null);
            CommonUtils.closeQuietly(inputStream2);
            CommonUtils.closeQuietly(inputStream);
            httpURLConnection.disconnect();
            return netResponse2;
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
    }

    public NetResponse postMultipart(String str, Map<String, String> map, byte[] bArr) {
        NetResponse netResponseRealMultipartRequest = null;
        if (!FailureRestrict.check("HttpSecureRequester.postMultipart")) {
            Logger.w(TAG, "postMultipart fail, FailureRestrict check is false");
            return null;
        }
        try {
            URL url = new URL(str);
            URL efURL = getEfURL(url);
            Map<String, String> mapAttachKeyHeader = attachKeyHeader(map);
            Logger.d(TAG, "gslb conversion failure. efURL = " + efURL + ", host = " + url.getHost());
            try {
                netResponseRealMultipartRequest = realMultipartRequest(efURL, url.getHost(), mapAttachKeyHeader, bArr);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (netResponseRealMultipartRequest == null || (netResponseRealMultipartRequest.getResponseCode() > 400 && netResponseRealMultipartRequest.getResponseCode() != 495)) {
                FailureRestrict.addFail("HttpSecureRequester.postMultipart");
            }
            return netResponseRealMultipartRequest;
        } catch (MalformedURLException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public NetResponse stringPartRequest(String str, String str2, Map<String, String> map, String str3) throws Throwable {
        NetResponse netResponseRealStringPartRequest = null;
        if (!FailureRestrict.check("HttpSecureRequester.stringPartRequest")) {
            return null;
        }
        try {
            URL url = new URL(str);
            try {
                netResponseRealStringPartRequest = realStringPartRequest(getEfURL(url), url.getHost(), str2, attachKeyHeader(map), str3);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (netResponseRealStringPartRequest == null || (netResponseRealStringPartRequest.getResponseCode() > 400 && netResponseRealStringPartRequest.getResponseCode() != 495)) {
                FailureRestrict.addFail("HttpSecureRequester.stringPartRequest");
            }
            return netResponseRealStringPartRequest;
        } catch (MalformedURLException e11) {
            e11.printStackTrace();
            return null;
        }
    }
}

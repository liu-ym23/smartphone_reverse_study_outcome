package com.baidu.naviapi.okhttp;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes39.dex */
public class RequestEntity {
    public static final String DEFAULT_TAG = "default";
    private int mBitmapHeight;
    private int mBitmapWidth;
    private ByteArrayOutputStream mBody;
    private String mCharset;
    private String mContentType;
    public ConcurrentHashMap<String, FileWrapper> mFileParams;
    private Map<String, String> mHeaders;
    private HttpMethod mMethod;
    private boolean mNeedEncode;
    private Map mParams;
    private int mRetries;
    private boolean mShouldCache;
    private String mTag;
    private int mTimeout;
    private String mUrl;

    /* JADX INFO: renamed from: com.baidu.naviapi.okhttp.RequestEntity$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        public static final String DEFAULT_TAG = "MultipartRequestEntity";
        private static final char[] MULTIPART_CHARS = null;
        private String boundary;
        private int mBitmapHeight;
        private int mBitmapWidth;
        private String mCharset;
        private String mContentType;
        private ConcurrentHashMap<String, FileWrapper> mFileParams;
        private Map<String, String> mHeaders;
        private HttpMethod mMethod;
        private boolean mNeedEncode;
        private Map mParams;
        private int mRetries;
        private boolean mShouldCache;
        private String mTag;
        private int mTimeout;
        private String mUrl;
        private ByteArrayOutputStream out;

        static {
            MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        }

        private void setBoundary() {
            StringBuffer r100 = new StringBuffer();
            Random r101 = new Random();
            int r102 = 0;
        L4:
            if (r102 >= 30) goto L6;
            char[] r103 = MULTIPART_CHARS;
            r100.append(r103[r101.nextInt(r103.length)]);
            r102 = r102 + 1;
            goto L4
        L6:
            this.boundary = r100.toString();
        }

        public RequestEntity build() {
            return new RequestEntity(this, null);
        }

        public Builder(String r100) {
            this.boundary = null;
            this.out = new ByteArrayOutputStream();
            this.mUrl = r100;
            this.mTag = DEFAULT_TAG;
            this.mCharset = "UTF-8";
            this.mMethod = HttpMethod.GET;
            this.mShouldCache = false;
            this.mNeedEncode = false;
            this.mTimeout = -1;
            this.mRetries = -1;
            this.mBitmapHeight = 0;
            this.mBitmapWidth = 0;
        }

        public static /* synthetic */ String access$000(Builder r100) {
            return r100.mUrl;
        }

        public static /* synthetic */ String access$100(Builder r100) {
            return r100.mTag;
        }

        public static /* synthetic */ String access$1000(Builder r100) {
            return r100.mContentType;
        }

        public static /* synthetic */ Map access$1100(Builder r100) {
            return r100.mHeaders;
        }

        public static /* synthetic */ int access$1200(Builder r100) {
            return r100.mBitmapWidth;
        }

        public static /* synthetic */ int access$1300(Builder r100) {
            return r100.mBitmapHeight;
        }

        public static /* synthetic */ ByteArrayOutputStream access$1400(Builder r100) {
            return r100.out;
        }

        public static /* synthetic */ String access$200(Builder r100) {
            return r100.mCharset;
        }

        public static /* synthetic */ HttpMethod access$300(Builder r100) {
            return r100.mMethod;
        }

        public static /* synthetic */ boolean access$400(Builder r100) {
            return r100.mShouldCache;
        }

        public static /* synthetic */ boolean access$500(Builder r100) {
            return r100.mNeedEncode;
        }

        public static /* synthetic */ int access$600(Builder r100) {
            return r100.mTimeout;
        }

        public static /* synthetic */ int access$700(Builder r100) {
            return r100.mRetries;
        }

        public static /* synthetic */ Map access$800(Builder r100) {
            return r100.mParams;
        }

        public static /* synthetic */ ConcurrentHashMap access$900(Builder r100) {
            return r100.mFileParams;
        }

        private void addMultiPart(ConcurrentHashMap<String, FileWrapper> r110) {
            if (r110 != null) goto L5;
            return;
        L5:
            if (r110.size() <= 0) goto L41;
            contentType("multipart/form-data;boundary=" + this.boundary);
            this.out.write((com.baidu.mapapi.http.HttpClient.ENDFLAG + this.boundary + "\r\n").getBytes());     // Catch: IOException -> L9
        L11:
            Iterator r100 = ((HashMap) this.mParams).entrySet().iterator();
        L13:
            if (r100.hasNext() == false) goto L19;
            Map.Entry r101 = (Map.Entry) r100.next();
            this.out.write(("Content-Disposition: form-data; name=\"" + ((String) r101.getKey()) + "\"\r\n\r\n").getBytes());     // Catch: IOException -> L17
            this.out.write(((String) r101.getValue()).getBytes());     // Catch: IOException -> L17
            this.out.write(("\r\n--" + this.boundary + "\r\n").getBytes());     // Catch: IOException -> L17
        L17:
            e = move-exception;
            e.printStackTrace();
            goto L13
        L19:
            int r102 = r110.entrySet().size() - 1;
            Iterator<Map.Entry<String, FileWrapper>> r111 = r110.entrySet().iterator();
            int r103 = 0;
        L21:
            if (r111.hasNext() == false) goto L42;
            Map.Entry<String, FileWrapper> r104 = r111.next();
            FileWrapper r105 = r104.getValue();
            if (r103 != r102) goto L25;
            boolean r112 = true;
        L26:
            if (r105 == null) goto L28;
            addPart(r104.getKey(), r105.getFileName(), r105.inputStream, r105.contentType, r112);
        L28:
            r103 = r103 + 1;
            goto L21
        L25:
            r112 = false;
            goto L26
        L42:
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            goto L11
        }

        public Builder bitmapHeight(int r100) {
            this.mBitmapHeight = r100;
            return this;
        }

        public Builder bitmapWidth(int r100) {
            this.mBitmapWidth = r100;
            return this;
        }

        public Builder charSet(String r100) {
            this.mCharset = r100;
            return this;
        }

        public Builder contentType(String r100) {
            this.mContentType = r100;
            return this;
        }

        public Builder encode(boolean r100) {
            this.mNeedEncode = r100;
            return this;
        }

        public Builder fileParams(ConcurrentHashMap<String, FileWrapper> r100) {
            setBoundary();
            if (r100 != null) goto L5;
        L7:
            return this;
        L5:
            if (r100.size() <= 0) goto L7;
            ConcurrentHashMap<String, FileWrapper> r101 = new ConcurrentHashMap();
            this.mFileParams = r101;
            r101.putAll(r100);
            addMultiPart(this.mFileParams);
            goto L7
        }

        public Builder headers(Map<String, String> r100) {
            HashMap r101 = new HashMap();
            this.mHeaders = r101;
            r101.putAll(r100);
            return this;
        }

        public Builder method(HttpMethod r100) {
            this.mMethod = r100;
            return this;
        }

        public Builder params(Map r100) {
            this.mParams = r100;
            return this;
        }

        public Builder retries(int r100) {
            this.mRetries = r100;
            return this;
        }

        public Builder shouldCache(boolean r100) {
            this.mShouldCache = r100;
            return this;
        }

        public Builder tag(String r100) {
            this.mTag = r100;
            return this;
        }

        public Builder timeout(int r100) {
            this.mTimeout = r100;
            return this;
        }

        private void addPart(String r100, String r101, InputStream r102, String r103, boolean r104) {
            if (TextUtils.isEmpty(r103) == true) goto L5;
            String r105 = "Content-Type: " + r103 + "\r\n";
        L32:
            this.out.write(("Content-Disposition: form-data; name=\"" + r100 + "\"; filename=\"" + r101 + "\"\r\n").getBytes());     // Catch: Throwable -> L18 IOException -> L20
            this.out.write(r105.getBytes());     // Catch: Throwable -> L18 IOException -> L20
            this.out.write("Content-Transfer-Encoding: binary\r\n\r\n".getBytes());     // Catch: Throwable -> L18 IOException -> L20
            byte[] r106 = new byte[4096];     // Catch: Throwable -> L18 IOException -> L20
        L7:
            int r107 = r102.read(r106);     // Catch: Throwable -> L18 IOException -> L20
            if (r107 == (-1)) goto L12;
            this.out.write(r106, 0, r107);     // Catch: Throwable -> L18 IOException -> L20
            goto L7
        L12:
            if (r104 == true) goto L14;
            this.out.write(("\r\n--" + this.boundary + "\r\n").getBytes());     // Catch: Throwable -> L18 IOException -> L20
        L15:
            this.out.flush();     // Catch: Throwable -> L18 IOException -> L20
            r102.close();     // Catch: IOException -> L24
        L33:
            return;
        L14:
            this.out.write(("\r\n--" + this.boundary + "--\r\n").getBytes());     // Catch: Throwable -> L18 IOException -> L20
        L18:
            th = move-exception;
            r102.close();     // Catch: IOException -> L29
        L31:
            throw th;
        L29:
            e = move-exception;
            e.printStackTrace();
        L24:
            e = move-exception;
            e.printStackTrace();
            return;
        L20:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L18
            r102.close();     // Catch: IOException -> L24
            goto L33
        L5:
            r105 = "Content-Type: application/octet-stream\r\n";
            goto L32
        }
    }

    public static class FileWrapper {
        public String contentType;
        public String fileName;
        public InputStream inputStream;

        public String getFileName() {
            String r100 = this.fileName;
            if (r100 == null) goto L5;
            return r100;
        L5:
            return "";
        }

        public FileWrapper(InputStream r100, String r101, String r102) {
            this.inputStream = r100;
            this.fileName = r101;
            this.contentType = r102;
        }
    }

    public static final enum HttpMethod extends Enum<HttpMethod> {
        private static final /* synthetic */ HttpMethod[] $VALUES = null;
        public static final HttpMethod DELETE = null;
        public static final HttpMethod GET = null;
        public static final HttpMethod POST = null;

        static {
            HttpMethod r100 = new HttpMethod("GET", 0);
            GET = r100;
            HttpMethod r101 = new HttpMethod("POST", 1);
            POST = r101;
            HttpMethod r102 = new HttpMethod("DELETE", 2);
            DELETE = r102;
            $VALUES = new HttpMethod[]{r100, r101, r102};
        }

        public static HttpMethod[] values() {
            return (HttpMethod[]) $VALUES.clone();
        }

        public static HttpMethod valueOf(String r100) {
            return (HttpMethod) r27.a.a(HttpMethod.class, r100);
        }

        private HttpMethod(String r100, int r101) {
            super(r100, r101);
        }
    }

    public byte[] getBody() {
        return this.mBody.toByteArray();
    }

    public RequestEntity() {
    }

    public int getBitmapHeight() {
        return this.mBitmapHeight;
    }

    public int getBitmapWidth() {
        return this.mBitmapWidth;
    }

    public String getCharset() {
        return this.mCharset;
    }

    public String getContentType() {
        return this.mContentType;
    }

    public Map getFileParams() {
        return this.mFileParams;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public HttpMethod getMethod() {
        return this.mMethod;
    }

    public Map getParams() {
        return this.mParams;
    }

    public int getRetries() {
        return this.mRetries;
    }

    public String getTag() {
        return this.mTag;
    }

    public int getTimeout() {
        return this.mTimeout;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean isNeedEncode() {
        return this.mNeedEncode;
    }

    public boolean useCache() {
        return this.mShouldCache;
    }

    private RequestEntity(Builder r100) {
        this.mUrl = Builder.access$000(r100);
        this.mTag = Builder.access$100(r100);
        this.mCharset = Builder.access$200(r100);
        this.mMethod = Builder.access$300(r100);
        this.mShouldCache = Builder.access$400(r100);
        this.mNeedEncode = Builder.access$500(r100);
        this.mTimeout = Builder.access$600(r100);
        this.mRetries = Builder.access$700(r100);
        this.mParams = Builder.access$800(r100);
        this.mFileParams = Builder.access$900(r100);
        this.mContentType = Builder.access$1000(r100);
        this.mHeaders = Builder.access$1100(r100);
        this.mBitmapWidth = Builder.access$1200(r100);
        this.mBitmapHeight = Builder.access$1300(r100);
        this.mBody = Builder.access$1400(r100);
    }

    public void setUrl(String r100) {
        this.mUrl = r100;
    }

    public void setmTag(String r100) {
        this.mTag = r100;
    }

    public /* synthetic */ RequestEntity(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}

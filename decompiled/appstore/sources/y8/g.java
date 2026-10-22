package y8;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.common.network.error.SSLNetworkError;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.c0;
import com.bytedanceos.common.toolbox.j;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends Request {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f26156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f26157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f26158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f26159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Request.Priority f26160e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f26161f;

    public g(int r10, String r11, a r12) {
        this(r10, r11, r12, 0);
    }

    public static String a(Map r10) {
        JSONObject r11 = new JSONObject();
        Iterator r12 = r10.entrySet().iterator();     // Catch: Exception -> L8
    L5:
        if (r12.hasNext() == false) goto L11;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Exception -> L8
        r11.put((String) r13.getKey(), r13.getValue());     // Catch: Exception -> L8
    L11:
        return r11.toString();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static String h(String r10, Map r11) {
        StringBuilder r12 = new StringBuilder();
        r12.append(r10);
        if (r11 == null) goto L18;
        if (r11.size() == 0) goto L18;
        Iterator r13 = r11.keySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L18;
        String r14 = (String) r13.next();
        String r15 = URLEncoder.encode((String) r11.get(r14), "UTF-8");     // Catch: Exception -> L16
        if (r12.toString().contains("?") == false) goto L14;
        r12.append("&");
    L15:
        r12.append(r14);
        r12.append("=");
        r12.append(r15);
        goto L8
    L14:
        r12.append("?");
    L16:
        j.b("params error:" + r14);
    L18:
        return r12.toString();
    }

    public long b() {
        int r10 = this.f26161f;
        if (r10 != 600001) goto L5;
        return 300;
    L5:
        if (r10 != 1100000) goto L8;
        return 300;
    L8:
        if (r10 != 1600000) goto L11;
        return 86400;
    L11:
        return 60;
    }

    public final boolean c(int r10) {
        if (r10 != 100001) goto L5;
    L22:
        return true;
    L5:
        if (r10 == 300001) goto L22;
        if (r10 == 300002) goto L22;
        if (r10 == 300003) goto L22;
        if (r10 == 400001) goto L22;
        if (r10 == 1100000) goto L22;
        if (r10 == 1600000) goto L22;
        if (r10 == 400003) goto L22;
        if (r10 == 600001) goto L22;
        return false;
    }

    public boolean d(int r10) {
        if (this.f26161f != r10) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.volley.Request
    public void deliverError(VolleyError r10) {
        if (isCanceled() == false) goto L5;
        return;
    L5:
        r10.printStackTrace();
        if ((r10 instanceof SSLNetworkError) == true) goto L9;
        boolean r11 = r10 instanceof NetworkError;
    L9:
        a r12 = this.f26156a;
        if (r12 == null) goto L13;
        r12.a(new a.C0414a(r10));
        return;
    }

    @Override // com.android.volley.Request
    public /* bridge */ /* synthetic */ void deliverResponse(Object r10) {
        deliverResponse((String) r10);
    }

    public g e(byte[] r10) {
        this.f26159d = r10;
        return this;
    }

    public final void f(int r10, String r11) {
        if (r10 < 400) goto L21;
        setShouldCache(false);
        return;
    L21:
        JSONObject r12 = new JSONObject(r11);     // Catch: Exception -> L11
        if (r12.isNull(ServerElements.HEAD) == true) goto L14;
        if (r12.getJSONObject(ServerElements.HEAD).optInt(ServerElements.CODE) != 0) goto L14;
        return;
    L14:
        if (r12.isNull(ServerElements.ERRNO) == true) goto L19;
        if (r12.optInt(ServerElements.ERRNO) != 0) goto L19;
        return;
    L19:
        setShouldCache(false);
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public g g(Map r10) {
        this.f26157b.putAll(r10);
        return this;
    }

    @Override // com.android.volley.Request
    public byte[] getBody() {
        byte[] r10 = this.f26159d;
        if (r10 == null) goto L8;
        if (r10.length == 0) goto L8;
        return r10;
    L8:
        return super.getBody();
    }

    @Override // com.android.volley.Request
    public String getBodyContentType() {
        return "application/json";
    }

    @Override // com.android.volley.Request
    public Map getHeaders() {
        Map r10 = this.f26157b;
        if (r10 == null) goto L9;
        if (r10.size() == 0) goto L9;
        return this.f26157b;
    L9:
        return super.getHeaders();
    }

    @Override // com.android.volley.Request
    public Map getParams() {
        Map r10 = this.f26158c;
        if (r10 == null) goto L9;
        if (r10.size() == 0) goto L9;
        return this.f26158c;
    L9:
        return super.getParams();
    }

    @Override // com.android.volley.Request
    public String getParamsEncoding() {
        return "UTF-8";
    }

    @Override // com.android.volley.Request
    public Request.Priority getPriority() {
        Request.Priority r10 = this.f26160e;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Request.Priority.HIGH;
    }

    public final JSONObject i(Map r10) {
        JSONObject r11 = new JSONObject();
        Iterator r12 = r10.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        String r13 = (String) r12.next();
        r11.put(r13, r10.get(r13));
        goto L4
    L6:
        return r11;
    }

    public final Map j(JSONObject r10) {
        HashMap r11 = new HashMap();
        JSONObject r12 = r10.getJSONObject("Response-Header");
        Iterator<String> r13 = r12.keys();
    L4:
        if (r13.hasNext() == false) goto L6;
        String r14 = r13.next();
        r11.put(r14, r12.getString(r14));
        goto L4
    L6:
        return r11;
    }

    @Override // com.android.volley.Request
    public Response parseNetworkResponse(NetworkResponse r10) {
        if (isCanceled() == true) goto L14;
        if (r10 == null) goto L14;
        String r11 = new String(r10.data, getParamsEncoding());     // Catch: UnsupportedEncodingException -> L8
    L22:
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L11
        r12.put("Status-Code", r10.statusCode);     // Catch: JSONException -> L11
        r12.put("Response-Header", i(r10.headers));     // Catch: JSONException -> L11
        r12.put("Response-Body", r11);     // Catch: JSONException -> L11
        f(r10.statusCode, r11);     // Catch: JSONException -> L11
        return Response.success(r12.toString(), HttpHeaderParser.parseCacheHeaders(r10));
    L11:
        e = move-exception;
        f(400, null);
        return Response.error(new VolleyError(e));
    L8:
        r11 = new String(r10.data, c0.e());
    L14:
        StringBuilder r13 = new StringBuilder();
        r13.append("parseNetworkResponse error with canceled: ");
        r13.append(isCanceled());
        r13.append(LibrarianImpl.Constants.SEPARATOR);
        if (r10 != null) goto L17;
        boolean r14 = true;
    L18:
        r13.append(r14);
        return Response.error(new VolleyError(r13.toString()));
    L17:
        r14 = false;
        goto L18
    }

    public g(int r10, String r11, a r12, int r13) {
        super(r10, r11, null);
        this.f26160e = null;
        int r14 = 0;
        this.f26161f = 0;
        this.f26157b = new HashMap();
        this.f26158c = new HashMap();
        this.f26156a = r12;
        int r15 = 5000;
        if (r13 != 1100002) goto L6;
    L9:
        setRetryPolicy(new DefaultRetryPolicy(r15, r14, 0.2f));
        this.f26161f = r13;
        setShouldCache(c(r13));
        return;
    L6:
        if (r13 != 1300000) goto L8;
        r15 = 20000;
    L8:
        r14 = 1;
        goto L9
    }

    public void deliverResponse(String r10) {
        if (isCanceled() == false) goto L6;
        return;
    L6:
        if (this.f26156a == null) goto L33;
        Map r11 = null;
        String r12 = null;
        int r13 = 0;
        JSONObject r14 = new JSONObject(r10);     // Catch: JSONException -> L11
        if (r14.isNull("Status-Code") == true) goto L14;
        r13 = r14.getInt("Status-Code");     // Catch: JSONException -> L11
    L14:
        if (r14.isNull("Response-Header") == true) goto L17;
        Map r15 = j(r14);     // Catch: JSONException -> L11
    L32:
    L21:
        e = move-exception;
        r11 = r15;
        e = e;
    L28:
        e.printStackTrace();
        this.f26156a.a(new a.C0414a(r13, r11, new VolleyError(e)));
        return;
    L19:
        if (r14.isNull("Response-Body") == true) goto L24;
        r12 = r14.getString("Response-Body");     // Catch: JSONException -> L21
    L24:
        if (r13 >= 400) goto L26;
        this.f26156a.c(new a.C0414a(r13, r15, r12, getUrl()));     // Catch: JSONException -> L21
        return;
    L26:
        this.f26156a.b(new a.C0414a(r13, r15, r12));     // Catch: JSONException -> L21
        return;
    L17:
        r15 = null;
    L11:
        e = e;
        goto L28
    }
}

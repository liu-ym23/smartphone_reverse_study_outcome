package q1;

import android.text.TextUtils;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b implements TypedOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f23491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23492c;

    public b(String r10, String r11, Map r12) {
        this.f23490a = r10;
        this.f23491b = r12;
        if (TextUtils.isEmpty(r11) == false) goto L7;
        JSONObject r13 = new JSONObject();
        r13.put("defaultData", "none commonParams");     // Catch: JSONException -> L9
    L6:
        this.f23492c = r13.toString();
        return;
    L7:
        this.f23492c = r11;
    }

    public final String a(String r10, Map r11) {
        StringBuilder r12 = new StringBuilder(r10);
        r12.append("\"");
        Iterator r13 = r11.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry r14 = (Map.Entry) r13.next();
        String r15 = (String) r14.getKey();
        String r16 = (String) r14.getValue();
        r12.append("; ");
        r12.append(r15);
        r12.append("=\"");
        r12.append(r16);
        r12.append("\"");
        goto L4
    L6:
        r12.deleteCharAt(r12.length() - 1);
        return r12.toString();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return a(this.f23490a, this.f23491b);
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.f23492c.getBytes().length;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return HTTP.PLAIN_TEXT_TYPE;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r10) {
        r10.write(this.f23492c.getBytes());
    }
}

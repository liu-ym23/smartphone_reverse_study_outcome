package q1;

import com.bytedance.retrofit2.mime.TypedOutput;
import h6.g;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c implements TypedOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f23493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f23494b;

    public c(Map r10, g r11) {
        this.f23494b = r10;
        this.f23493a = r11;
    }

    public final String a() {
        StringBuilder r10 = new StringBuilder(this.f23493a.fileName());
        r10.append("\"");
        Iterator r11 = this.f23494b.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry r12 = (Map.Entry) r11.next();
        String r13 = (String) r12.getKey();
        String r14 = (String) r12.getValue();
        r10.append("; ");
        r10.append(r13);
        r10.append("=\"");
        r10.append(r14);
        r10.append("\"");
        goto L4
    L6:
        r10.deleteCharAt(r10.length() - 1);
        return r10.toString();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return a();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.f23493a.length();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        return this.f23493a.md5Stub();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return this.f23493a.mimeType();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r10) {
        this.f23493a.writeTo(r10);
    }
}

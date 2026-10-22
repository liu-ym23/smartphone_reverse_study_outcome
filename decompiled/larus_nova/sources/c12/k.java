package c12;

import android.text.TextUtils;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedInput;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements IDownloadHttpService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.revenue.network.c<com.bytedance.android.livesdk.revenue.network.b> f22036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.revenue.network.b f22037b;

    public class a implements TypedInput {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f22038a;

        @Override // com.bytedance.retrofit2.mime.TypedInput
        public final InputStream in() throws IOException {
            return new ByteArrayInputStream(this.f22038a.f22037b.getBody());
        }

        @Override // com.bytedance.retrofit2.mime.TypedInput
        public final long length() throws IOException {
            return this.f22038a.f22037b.getBody().length;
        }

        @Override // com.bytedance.retrofit2.mime.TypedInput
        public final String mimeType() {
            return this.f22038a.f22037b.getMimeType();
        }

        public a(k r100) {
            this.f22038a = r100;
        }
    }

    public class b implements IDownloadHttpConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f22039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Response f22040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f22041c;

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
        public final void end() {
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
        public final void cancel() {
            com.bytedance.android.livesdk.revenue.network.c<com.bytedance.android.livesdk.revenue.network.b> r100 = this.f22041c.f22036a;
            if (r100 == null) goto L11;
            r100.cancel();     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
        public final int getResponseCode() throws IOException {
            return this.f22040b.getStatus();
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
        public final InputStream getInputStream() throws IOException {
            return this.f22039a;
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
        public final String getResponseHeaderField(String r100) {
            k r101 = this.f22041c;
            List<Header> r102 = this.f22040b.getHeaders();
            r101.getClass();
            if (r102 != null) goto L5;
        L12:
            return null;
        L5:
            if (TextUtils.isEmpty(r100) == true) goto L12;
            Iterator<Header> r103 = r102.iterator();
        L8:
            if (r103.hasNext() == false) goto L12;
            Header r104 = r103.next();
            if (r100.equalsIgnoreCase(r104.getName()) == false) goto L8;
            return r104.getValue();
        }

        public b(k r100, InputStream r101, Response r102) {
            this.f22041c = r100;
            this.f22039a = r101;
            this.f22040b = r102;
        }
    }

    public k() {
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
    public final IDownloadHttpConnection downloadWithConnection(int r100, String r101, List<HttpHeader> r102) throws IOException {
        HashMap r103 = new HashMap();
        if (r102 == null) goto L8;
        Iterator<HttpHeader> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        HttpHeader r105 = r104.next();
        r103.put(r105.getName(), r105.getValue());
    L8:
        r103.put("Accept-Encoding", DownloadHelper.IDENTITY);
        com.bytedance.android.livesdk.revenue.network.i r106 = ((com.bytedance.android.livesdk.revenue.service.network.a) com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.network.a.class)).di(r100, r101, r103);
        this.f22036a = r106;
        com.bytedance.android.livesdk.revenue.network.b r107 = (com.bytedance.android.livesdk.revenue.network.b) r106.a();
        this.f22037b = r107;
        if (r107 != null) goto L12;
        return null;
    L12:
        ArrayList r108 = new ArrayList();
        if (this.f22037b.getHeaders() == null) goto L18;
        Iterator<String> r109 = this.f22037b.getHeaders().keySet().iterator();
    L16:
        if (r109.hasNext() == false) goto L18;
        String r110 = r109.next();
        r108.add(new Header(r110, this.f22037b.getHeaders().get(r110)));
    L18:
        Response r111 = new Response(r101, this.f22037b.getStatusCode(), this.f22037b.getReason(), r108, new a(this));
        return new b(this, new ByteArrayInputStream(this.f22037b.getBody()), r111);
    }
}

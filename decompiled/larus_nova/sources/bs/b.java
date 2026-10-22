package bs;

import android.text.TextUtils;
import com.bytedance.android.gamecp.host_api.model.network.NameValuePair;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements Client {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f20209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Boolean f20210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ yv.b f20211c;

    public static final class a implements SsCall {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public zv.a<xv.a> f20212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f20213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Request f20214c;

        /* JADX INFO: renamed from: bs.b$a$a, reason: collision with other inner class name */
        public static final class C0352a implements TypedInput {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ xv.a f20215a;

            @Override // com.bytedance.retrofit2.mime.TypedInput
            public final InputStream in() throws IOException {
                return new ByteArrayInputStream(this.f20215a.f565133e);
            }

            @Override // com.bytedance.retrofit2.mime.TypedInput
            public final long length() throws IOException {
                return this.f20215a.f565133e.length;
            }

            @Override // com.bytedance.retrofit2.mime.TypedInput
            public final String mimeType() {
                return this.f20215a.f565132d;
            }

            public C0352a(xv.a r100) {
                this.f20215a = r100;
            }
        }

        @Override // com.bytedance.retrofit2.client.SsCall
        public final boolean setThrottleNetSpeed(long r100) {
            return false;
        }

        @Override // com.bytedance.retrofit2.client.SsCall
        public final void cancel() {
            zv.a<xv.a> r100 = this.f20212a;
            if (r100 == null) goto L11;
            Intrinsics.checkNotNull(r100);     // Catch: IOException -> L6
            r100.cancel();     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        @Override // com.bytedance.retrofit2.client.SsCall
        public final Response execute() {
            String r100 = this.f20214c.getMethod();
            if ((!Intrinsics.areEqual("GET", r100)) == true) goto L5;
        L8:
            ArrayList r101 = new ArrayList();
            List<Header> r102 = this.f20214c.getHeaders();
            if (r102 == null) goto L15;
            Iterator<Header> r103 = r102.iterator();
        L12:
            if (r103.hasNext() == false) goto L15;
            Header r104 = r103.next();
            r101.add(new NameValuePair(r104.getName(), r104.getValue()));
        L15:
            if (Intrinsics.areEqual(this.f20213b.f20210b, Boolean.TRUE) == false) goto L18;
            r101.add(new NameValuePair("game-preload", "1"));
        L18:
            if (TextUtils.equals("GET", r100) == false) goto L20;
            this.f20212a = this.f20213b.f20211c.get(this.f20214c.getUrl(), r101);
        L27:
            zv.a<xv.a> r105 = this.f20212a;
            Intrinsics.checkNotNull(r105);
            xv.a r106 = r105.execute();
            ArrayList r107 = new ArrayList();
            if (this.f20214c.isResponseStreaming() == false) goto L30;
            TypedInput r108 = new C0352a(r106);
        L32:
            return new Response(r106.f565129a, r106.f565130b, r106.f565135g, r107, r108);
        L30:
            r108 = new TypedByteArray(r106.f565132d, r106.f565133e, new String[0]);
            goto L32
        L20:
            ByteArrayOutputStream r109 = new ByteArrayOutputStream();
            if (this.f20214c.getBody() == null) goto L24;
            this.f20214c.getBody().writeTo(r109);
        L24:
            if ((this.f20214c.getBody() instanceof MultipartTypedOutput) == false) goto L26;
            this.f20212a = this.f20213b.f20211c.uploadFile(this.f20214c.getMaxLength(), this.f20214c.getUrl(), r101, this.f20214c.getBody().mimeType(), r109.toByteArray(), this.f20214c.getBody().length(), this.f20214c.getBody().md5Stub());
            goto L27
        L26:
            this.f20212a = this.f20213b.f20211c.post(this.f20214c.getUrl(), r101, this.f20214c.getBody().mimeType(), r109.toByteArray());
            goto L27
        L5:
            if ((!Intrinsics.areEqual("POST", r100)) == false) goto L8;
            LocalTestManager.a(new Class[]{uv.a.class});
            this.f20213b.f20209a.getClass();
            yr.c.b("DefaultRetrofitProvider", "REQUEST NOT GET OR POST");
            return null;
        }

        @Override // com.bytedance.retrofit2.client.SsCall
        public final Request getRequest() {
            return this.f20214c;
        }

        public a(b r100, Request r101) {
            this.f20213b = r100;
            this.f20214c = r101;
        }
    }

    public b(c r100, Boolean r101, yv.b r102) {
        this.f20209a = r100;
        this.f20210b = r101;
        this.f20211c = r102;
    }

    @Override // com.bytedance.retrofit2.client.Client
    public final SsCall newSsCall(Request r100) {
        return new a(this, r100);
    }
}

package n8;

import ad.l;
import ad.s;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Ref$LongRef;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g extends s {

    /* renamed from: a, reason: collision with root package name */
    public final Context f10667a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f10668b;

    /* renamed from: c, reason: collision with root package name */
    public final l f10669c;

    /* renamed from: d, reason: collision with root package name */
    public final Long f10670d;

    /* renamed from: e, reason: collision with root package name */
    public final zb.l<Long, n> f10671e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends sd.n {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$LongRef f10672a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f10673b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Ref$LongRef ref$LongRef, g gVar, sd.d dVar) {
            super(dVar);
            this.f10672a = ref$LongRef;
            this.f10673b = gVar;
        }

        @Override // sd.n, sd.e0
        public final long read(sd.e sink, long j10) {
            kotlin.jvm.internal.g.f(sink, "sink");
            long j11 = super.read(sink, j10);
            if (j11 > 0) {
                this.f10672a.f10075a += j11;
                zb.l<Long, n> lVar = this.f10673b.f10671e;
                if (lVar != null) {
                    lVar.invoke(Long.valueOf(j11));
                }
            }
            return j11;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Context context, Uri uri, l lVar, Long l10, zb.l<? super Long, n> lVar2) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(uri, "uri");
        this.f10667a = context;
        this.f10668b = uri;
        this.f10669c = lVar;
        this.f10670d = l10;
        this.f10671e = lVar2;
    }

    @Override // ad.s
    public final long contentLength() {
        Long l10 = this.f10670d;
        if (l10 != null) {
            return l10.longValue();
        }
        return -1L;
    }

    @Override // ad.s
    public final l contentType() {
        return this.f10669c;
    }

    @Override // ad.s
    public final void writeTo(sd.g sink) throws IOException {
        long jLongValue;
        Long l10 = this.f10670d;
        Uri uri = this.f10668b;
        kotlin.jvm.internal.g.f(sink, "sink");
        try {
            InputStream inputStreamOpenInputStream = this.f10667a.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                Log.w("FileStorage.Tos", "✗ open uri=" + uri + " returned null (source missing?)");
                throw new IOException("openInputStream returned null for " + uri);
            }
            Ref$LongRef ref$LongRef = new Ref$LongRef();
            try {
                try {
                    a aVar = new a(ref$LongRef, this, jd.b.J(inputStreamOpenInputStream));
                    try {
                        sink.u(aVar);
                        aVar.close();
                        inputStreamOpenInputStream.close();
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e10) {
                long j10 = ref$LongRef.f10075a;
                jLongValue = l10 != null ? l10.longValue() : -1L;
                String simpleName = e10.getClass().getSimpleName();
                String message = e10.getMessage();
                StringBuilder sb2 = new StringBuilder("✗ stream uri=");
                sb2.append(uri);
                sb2.append(" wrote=");
                sb2.append(j10);
                a0.a.s(jLongValue, "/", " ", sb2);
                sb2.append(simpleName);
                sb2.append(": ");
                sb2.append(message);
                Log.w("FileStorage.Tos", sb2.toString());
                throw e10;
            } catch (Throwable th) {
                long j11 = ref$LongRef.f10075a;
                jLongValue = l10 != null ? l10.longValue() : -1L;
                String simpleName2 = th.getClass().getSimpleName();
                String message2 = th.getMessage();
                StringBuilder sb3 = new StringBuilder("✗ stream uri=");
                sb3.append(uri);
                sb3.append(" wrote=");
                sb3.append(j11);
                a0.a.s(jLongValue, "/", " ", sb3);
                sb3.append(simpleName2);
                sb3.append(": ");
                sb3.append(message2);
                Log.w("FileStorage.Tos", sb3.toString());
                long j12 = ref$LongRef.f10075a;
                String message3 = th.getMessage();
                StringBuilder sb4 = new StringBuilder("Upload stream error for ");
                sb4.append(uri);
                sb4.append(" after ");
                sb4.append(j12);
                throw new IOException(ai.onnxruntime.a.o(sb4, " bytes: ", message3), th);
            }
        } catch (SecurityException e11) {
            Log.w("FileStorage.Tos", "✗ open uri=" + uri + " SecurityException: " + e11.getMessage());
            throw new IOException("No read permission for " + uri + " (SAF grant lost?)", e11);
        } catch (Throwable th2) {
            Log.w("FileStorage.Tos", "✗ open uri=" + uri + " " + th2.getClass().getSimpleName() + ": " + th2.getMessage());
            throw new IOException("Cannot open " + uri + ": " + th2.getMessage(), th2);
        }
    }
}

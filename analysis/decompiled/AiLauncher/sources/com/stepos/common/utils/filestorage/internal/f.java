package com.stepos.common.utils.filestorage.internal;

import Mb.AbstractC0974l;
import Mb.C0966d;
import Mb.I;
import Mb.InterfaceC0967e;
import Mb.u;
import Y8.t;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import tb.AbstractC5529B;
import tb.x;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0011BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001aR\"\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/stepos/common/utils/filestorage/internal/f;", "Ltb/B;", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "Ltb/x;", "media", "", "length", "Lkotlin/Function1;", "LY8/t;", "onBytesWritten", "<init>", "(Landroid/content/Context;Landroid/net/Uri;Ltb/x;Ljava/lang/Long;Lp9/l;)V", Const.INTENT_KEY_PKGNAME, "()Ltb/x;", Const.INTENT_KEY_APIKEY, "()J", "LMb/e;", "sink", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LMb/e;)V", "Landroid/content/Context;", "Landroid/net/Uri;", "Ltb/x;", "Ljava/lang/Long;", "Lp9/l;", "Companion", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class f extends AbstractC5529B {

    @Deprecated
    public static final String BODY_TAG = "FileStorage.Tos";
    private static final a Companion = new a(null);
    private final Context context;
    private final Long length;
    private final x media;
    private final InterfaceC5074l<Long, t> onBytesWritten;
    private final Uri uri;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/common/utils/filestorage/internal/f$a;", "", "<init>", "()V", "", "BODY_TAG", "Ljava/lang/String;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/stepos/common/utils/filestorage/internal/f$b", "LMb/l;", "LMb/d;", "sink", "", "byteCount", "u0", "(LMb/d;J)J", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends AbstractC0974l {
        final /* synthetic */ Ref$LongRef $written;
        final /* synthetic */ f this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref$LongRef ref$LongRef, f fVar, I i10) {
            super(i10);
            this.$written = ref$LongRef;
            this.this$0 = fVar;
        }

        @Override // Mb.AbstractC0974l, Mb.I
        public long u0(C0966d sink, long byteCount) throws IOException {
            p.i(sink, "sink");
            long jU0 = super.u0(sink, byteCount);
            if (jU0 > 0) {
                this.$written.f34819a += jU0;
                InterfaceC5074l interfaceC5074l = this.this$0.onBytesWritten;
                if (interfaceC5074l != null) {
                    interfaceC5074l.invoke(Long.valueOf(jU0));
                }
            }
            return jU0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Context context, Uri uri, x xVar, Long l10, InterfaceC5074l<? super Long, t> interfaceC5074l) {
        p.i(context, "context");
        p.i(uri, "uri");
        this.context = context;
        this.uri = uri;
        this.media = xVar;
        this.length = l10;
        this.onBytesWritten = interfaceC5074l;
    }

    @Override // tb.AbstractC5529B
    public long a() {
        Long l10 = this.length;
        if (l10 != null) {
            return l10.longValue();
        }
        return -1L;
    }

    @Override // tb.AbstractC5529B
    /* renamed from: b, reason: from getter */
    public x getMedia() {
        return this.media;
    }

    @Override // tb.AbstractC5529B
    public void g(InterfaceC0967e sink) throws IOException {
        long jLongValue;
        p.i(sink, "sink");
        try {
            InputStream inputStreamOpenInputStream = this.context.getContentResolver().openInputStream(this.uri);
            if (inputStreamOpenInputStream == null) {
                Log.w(BODY_TAG, "✗ open uri=" + this.uri + " returned null (source missing?)");
                throw new IOException("openInputStream returned null for " + this.uri);
            }
            Ref$LongRef ref$LongRef = new Ref$LongRef();
            try {
                try {
                    b bVar = new b(ref$LongRef, this, u.l(inputStreamOpenInputStream));
                    try {
                        sink.V0(bVar);
                        l9.b.a(bVar, null);
                        l9.b.a(inputStreamOpenInputStream, null);
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e10) {
                Uri uri = this.uri;
                long j10 = ref$LongRef.f34819a;
                Long l10 = this.length;
                jLongValue = l10 != null ? l10.longValue() : -1L;
                Log.w(BODY_TAG, "✗ stream uri=" + uri + " wrote=" + j10 + "/" + jLongValue + " " + e10.getClass().getSimpleName() + ": " + e10.getMessage());
                throw e10;
            } catch (Throwable th) {
                Uri uri2 = this.uri;
                long j11 = ref$LongRef.f34819a;
                Long l11 = this.length;
                jLongValue = l11 != null ? l11.longValue() : -1L;
                Log.w(BODY_TAG, "✗ stream uri=" + uri2 + " wrote=" + j11 + "/" + jLongValue + " " + th.getClass().getSimpleName() + ": " + th.getMessage());
                throw new IOException("Upload stream error for " + this.uri + " after " + ref$LongRef.f34819a + " bytes: " + th.getMessage(), th);
            }
        } catch (SecurityException e11) {
            Log.w(BODY_TAG, "✗ open uri=" + this.uri + " SecurityException: " + e11.getMessage());
            throw new IOException("No read permission for " + this.uri + " (SAF grant lost?)", e11);
        } catch (Throwable th2) {
            Log.w(BODY_TAG, "✗ open uri=" + this.uri + " " + th2.getClass().getSimpleName() + ": " + th2.getMessage());
            throw new IOException("Cannot open " + this.uri + ": " + th2.getMessage(), th2);
        }
    }
}

package C;

import android.media.Image;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005J\u000f\u0010\u0002\u001a\u00020\u0000H&¢\u0006\u0004\b\u0002\u0010\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"LC/r;", "LC/q;", "acquire", "()LC/r;", "l0", Const.INTENT_KEY_APIKEY, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface r extends q {

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f1615a;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"LC/r$a;", "", "<init>", "()V", "LC/q;", "image", "LC/r;", Const.INTENT_KEY_APIKEY, "(LC/q;)LC/r;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: C.r$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f1615a = new Companion();

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\tJ)\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\f*\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"LC/r$a$a;", "LC/q;", "LC/r;", "outputImage", "LC/s;", "sharedReference", "<init>", "(LC/q;LC/s;)V", "acquire", "()LC/r;", "e", "", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", "LY8/t;", "close", "()V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "LC/q;", Const.INTENT_KEY_PKGNAME, "LC/s;", "LOa/a;", "c", "LOa/a;", AlipayXuiIsland.REASON_CLOSED, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: C.r$a$a, reason: collision with other inner class name */
        public static final class C0014a implements q, r {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final q outputImage;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            public final s<q> sharedReference;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            public final Oa.a closed;

            public C0014a(q outputImage, s<q> sharedReference) {
                kotlin.jvm.internal.p.i(outputImage, "outputImage");
                kotlin.jvm.internal.p.i(sharedReference, "sharedReference");
                this.outputImage = outputImage;
                this.sharedReference = sharedReference;
                this.closed = Oa.b.a(false);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // w.U
            public <T> T R0(InterfaceC5745d<T> type) {
                kotlin.jvm.internal.p.i(type, "type");
                if (this.closed.b()) {
                    return null;
                }
                if (kotlin.jvm.internal.p.d(type, t.b(r.class)) || kotlin.jvm.internal.p.d(type, t.b(q.class)) || kotlin.jvm.internal.p.d(type, t.b(n.class))) {
                    return this;
                }
                if (!kotlin.jvm.internal.p.d(type, t.b(Image.class))) {
                    return (T) this.outputImage.R0(type);
                }
                throw new UnsupportedOperationException("Cannot unwrap " + this + " as android.media.Image. Use setFinalizerinstead and close all outstanding references.");
            }

            @Override // C.r
            public r acquire() {
                r rVarE = e();
                if (rVarE != null) {
                    return rVarE;
                }
                throw new IllegalStateException("Required value was null.");
            }

            @Override // java.lang.AutoCloseable
            public void close() {
                if (this.closed.a(false, true)) {
                    this.sharedReference.b();
                }
            }

            public r e() {
                if (this.closed.b() || this.sharedReference.a() == null) {
                    return null;
                }
                return new C0014a(this.outputImage, this.sharedReference);
            }

            public String toString() {
                return this.outputImage.toString();
            }
        }

        public final r a(q image) {
            kotlin.jvm.internal.p.i(image, "image");
            if (image instanceof r) {
                return ((r) image).acquire();
            }
            r rVar = (r) image.R0(t.b(r.class));
            return rVar != null ? rVar.acquire() : new C0014a(image, new s(image, e.f1611a));
        }
    }

    r acquire();
}

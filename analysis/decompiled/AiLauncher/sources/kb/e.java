package kb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import fb.o;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\" \u0010\u0006\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0001\u0010\u0002\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0001\u0010\u0003\" \u0010\f\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u000b\u0010\u0005\u001a\u0004\b\b\u0010\n\" \u0010\u0013\u001a\u00020\r8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lkb/b;", Const.INTENT_KEY_APIKEY, "Lkb/b;", "()Lkb/b;", "getSegmentReadContextImpl$annotations", "()V", "SegmentReadContextImpl", "Lkb/c;", Const.INTENT_KEY_PKGNAME, "Lkb/c;", "()Lkb/c;", "getSegmentWriteContextImpl$annotations", "SegmentWriteContextImpl", "Lkb/a;", "c", "Lkb/a;", "getBufferIterationContextImpl", "()Lkb/a;", "getBufferIterationContextImpl$annotations", "BufferIterationContextImpl", "kotlinx-io-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final InterfaceC4843b f34667a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final InterfaceC4844c f34668b = new c();

    /* renamed from: c, reason: collision with root package name */
    public static final InterfaceC4842a f34669c = new a();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"kb/e$a", "Lkb/a;", "Lfb/o;", "segment", "", "offset", "", Const.INTENT_KEY_APIKEY, "(Lfb/o;I)B", "kotlinx-io-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements InterfaceC4842a {
        @Override // kb.InterfaceC4843b
        public byte a(o segment, int offset) {
            p.i(segment, "segment");
            return e.f34667a.a(segment, offset);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"kb/e$b", "Lkb/b;", "Lfb/o;", "segment", "", "offset", "", Const.INTENT_KEY_APIKEY, "(Lfb/o;I)B", "kotlinx-io-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements InterfaceC4843b {
        @Override // kb.InterfaceC4843b
        public byte a(o segment, int offset) {
            p.i(segment, "segment");
            return segment.k(offset);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ/\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J?\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kb/e$c", "Lkb/c;", "Lfb/o;", "segment", "", "offset", "", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_UMID, "(Lfb/o;IB)V", "b0", "b1", Const.INTENT_KEY_APIKEY, "(Lfb/o;IBB)V", "b2", Const.INTENT_KEY_PKGNAME, "(Lfb/o;IBBB)V", "b3", "c", "(Lfb/o;IBBBB)V", "kotlinx-io-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements InterfaceC4844c {
        @Override // kb.InterfaceC4844c
        public void a(o segment, int offset, byte b02, byte b12) {
            p.i(segment, "segment");
            segment.x(offset, b02, b12);
        }

        @Override // kb.InterfaceC4844c
        public void b(o segment, int offset, byte b02, byte b12, byte b22) {
            p.i(segment, "segment");
            segment.y(offset, b02, b12, b22);
        }

        @Override // kb.InterfaceC4844c
        public void c(o segment, int offset, byte b02, byte b12, byte b22, byte b32) {
            p.i(segment, "segment");
            segment.z(offset, b02, b12, b22, b32);
        }

        @Override // kb.InterfaceC4844c
        public void d(o segment, int offset, byte value) {
            p.i(segment, "segment");
            segment.w(offset, value);
        }
    }
}

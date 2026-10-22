package p;

import D.B;
import Z8.X;
import android.hardware.camera2.params.DynamicRangeProfiles;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Set;
import kotlin.Metadata;
import p.C5027i;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lp/k;", "Lp/i$b;", "<init>", "()V", "LD/B;", "dynamicRange", "", Const.INTENT_KEY_PKGNAME, "(LD/B;)Ljava/util/Set;", "Landroid/hardware/camera2/params/DynamicRangeProfiles;", Const.INTENT_KEY_APIKEY, "()Landroid/hardware/camera2/params/DynamicRangeProfiles;", "c", "()Ljava/util/Set;", "supportedDynamicRanges", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: p.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5029k implements C5027i.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    public static final C5027i f37979b = new C5027i(new C5029k());

    /* renamed from: c, reason: collision with root package name */
    public static final Set<B> f37980c = X.d(B.f1998d);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\f\u001a\r\u0012\t\u0012\u00070\n¢\u0006\u0002\b\u000b0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lp/k$a;", "", "<init>", "()V", "Lp/i;", "COMPAT_INSTANCE", "Lp/i;", Const.INTENT_KEY_APIKEY, "()Lp/i;", "", "LD/B;", "Lkotlin/jvm/internal/EnhancedNullability;", "SDR_ONLY", "Ljava/util/Set;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: p.k$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final C5027i a() {
            return C5029k.f37979b;
        }

        public Companion() {
        }
    }

    @Override // p.C5027i.b
    /* renamed from: a */
    public DynamicRangeProfiles getDynamicRangeProfiles() {
        return null;
    }

    @Override // p.C5027i.b
    public Set<B> b(B dynamicRange) {
        kotlin.jvm.internal.p.i(dynamicRange, "dynamicRange");
        B0.h.b(kotlin.jvm.internal.p.d(B.f1998d, dynamicRange), "DynamicRange is not supported: " + dynamicRange);
        return f37980c;
    }

    @Override // p.C5027i.b
    public Set<B> c() {
        return f37980c;
    }
}

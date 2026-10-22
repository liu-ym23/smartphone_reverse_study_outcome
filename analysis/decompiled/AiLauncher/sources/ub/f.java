package ub;

import Ka.t;
import Z8.F;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;
import o9.C5013a;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B%\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ1\u0010\u000b\u001a\u00020\u0003\"\b\b\u0001\u0010\n*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0004\b\u000b\u0010\fJ*\u0010\r\u001a\u0004\u0018\u00018\u0001\"\b\b\u0001\u0010\n*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0014\u0010\u0006\u001a\u00028\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lub/f;", "", "K", "Lub/g;", "Lw9/d;", "key", UxipConstants.f30680s, "next", "<init>", "(Lw9/d;Ljava/lang/Object;Lub/g;)V", ExifInterface.GPS_DIRECTION_TRUE, Const.INTENT_KEY_PKGNAME, "(Lw9/d;Ljava/lang/Object;)Lub/g;", Const.INTENT_KEY_APIKEY, "(Lw9/d;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lw9/d;", "Ljava/lang/Object;", "c", "Lub/g;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class f<K> extends g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5745d<K> key;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final K value;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final g next;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(InterfaceC5745d<K> key, K value, g next) {
        super(null);
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(value, "value");
        kotlin.jvm.internal.p.i(next, "next");
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public static final f e(f it) {
        kotlin.jvm.internal.p.i(it, "it");
        g gVar = it.next;
        if (gVar instanceof f) {
            return (f) gVar;
        }
        return null;
    }

    public static final CharSequence f(f it) {
        kotlin.jvm.internal.p.i(it, "it");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(it.key);
        sb2.append('=');
        sb2.append(it.value);
        return sb2.toString();
    }

    @Override // ub.g
    public <T> T a(InterfaceC5745d<T> key) {
        kotlin.jvm.internal.p.i(key, "key");
        return kotlin.jvm.internal.p.d(key, this.key) ? (T) C5013a.b(key).cast(this.value) : (T) this.next.a(key);
    }

    @Override // ub.g
    public <T> g b(InterfaceC5745d<T> key, T value) {
        kotlin.jvm.internal.p.i(key, "key");
        if (kotlin.jvm.internal.p.d(key, this.key)) {
            this = (f<K>) this.next;
        } else {
            g gVarB = this.next.b(key, null);
            if (gVarB != this.next) {
                this = new f<>(this.key, this.value, gVarB);
            }
        }
        return value != null ? new f(key, value, this) : this;
    }

    public String toString() {
        return F.A0(F.V0(SequencesKt___SequencesKt.d0(t.q(this, new InterfaceC5074l() { // from class: ub.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return f.e((f) obj);
            }
        }))), null, Const.STR_MART_JSON_BEGIN, "}", 0, null, new InterfaceC5074l() { // from class: ub.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return f.f((f) obj);
            }
        }, 25, null);
    }
}

package Ya;

import Xa.t;
import Ya.c;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import io.ktor.http.ContentDisposition;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00060\u0003j\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00028\u0000H$¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000b2\u0006\u0010\n\u001a\u00020\tH$¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0011\u0010\u0012R8\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000b2\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000b8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0$8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010%¨\u0006'"}, d2 = {"LYa/a;", "LYa/c;", ExifInterface.LATITUDE_SOUTH, "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "<init>", "()V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()LYa/c;", "", ContentDisposition.Parameters.Size, "", "k", "(I)[LYa/c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "slot", "LY8/t;", "l", "(LYa/c;)V", UxipConstants.f30680s, Const.INTENT_KEY_APIKEY, "[LYa/c;", "n", "()[LYa/c;", "slots", Const.INTENT_KEY_PKGNAME, "I", "m", "()I", "nCollectors", "c", "nextIndex", "LYa/q;", Const.INTENT_KEY_UMID, "LYa/q;", "_subscriptionCount", "LXa/t;", "()LXa/t;", "subscriptionCount", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class a<S extends c<?>> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public S[] slots;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int nCollectors;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int nextIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public q _subscriptionCount;

    public final t<Integer> c() {
        q qVar;
        synchronized (this) {
            qVar = this._subscriptionCount;
            if (qVar == null) {
                qVar = new q(this.nCollectors);
                this._subscriptionCount = qVar;
            }
        }
        return qVar;
    }

    public final S i() {
        S s10;
        q qVar;
        synchronized (this) {
            try {
                S[] sArr = this.slots;
                if (sArr == null) {
                    sArr = (S[]) k(2);
                    this.slots = sArr;
                } else if (this.nCollectors >= sArr.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(sArr, sArr.length * 2);
                    kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
                    this.slots = (S[]) ((c[]) objArrCopyOf);
                    sArr = (S[]) ((c[]) objArrCopyOf);
                }
                int i10 = this.nextIndex;
                do {
                    s10 = sArr[i10];
                    if (s10 == null) {
                        s10 = (S) j();
                        sArr[i10] = s10;
                    }
                    i10++;
                    if (i10 >= sArr.length) {
                        i10 = 0;
                    }
                    kotlin.jvm.internal.p.g(s10, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!s10.a(this));
                this.nextIndex = i10;
                this.nCollectors++;
                qVar = this._subscriptionCount;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (qVar != null) {
            qVar.a0(1);
        }
        return s10;
    }

    public abstract S j();

    public abstract S[] k(int size);

    public final void l(S slot) {
        q qVar;
        int i10;
        InterfaceC4014c<Y8.t>[] interfaceC4014cArrB;
        synchronized (this) {
            try {
                int i11 = this.nCollectors - 1;
                this.nCollectors = i11;
                qVar = this._subscriptionCount;
                if (i11 == 0) {
                    this.nextIndex = 0;
                }
                kotlin.jvm.internal.p.g(slot, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                interfaceC4014cArrB = slot.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (InterfaceC4014c<Y8.t> interfaceC4014c : interfaceC4014cArrB) {
            if (interfaceC4014c != null) {
                Result.Companion companion = Result.INSTANCE;
                interfaceC4014c.resumeWith(Result.b(Y8.t.f7040a));
            }
        }
        if (qVar != null) {
            qVar.a0(-1);
        }
    }

    /* renamed from: m, reason: from getter */
    public final int getNCollectors() {
        return this.nCollectors;
    }

    public final S[] n() {
        return this.slots;
    }
}

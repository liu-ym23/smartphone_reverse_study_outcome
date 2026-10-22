package b7;

import a6.c1;
import a6.j1;
import a6.r0;
import b5.a0;
import c5.m;
import c5.n;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.prefs.SharedSecurePrefs;
import com.stepos.stepclaw.base.util.StepAccount;
import com.stepos.stepclaw.config.JsonConfigStore;
import com.stepos.stepclaw.memory.lightmem.LightMemClient;
import com.stepos.stepclaw.memory.lightmem.LightMemException;
import com.stepos.stepclaw.memory.lightmem.local.LocalInferenceEngine;
import com.stepos.stepclaw.memory.lightmem.remote.AutoRecallResponse;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateResponse;
import com.stepos.stepclaw.memory.search.QueryRewriteStage;
import com.stepos.stepclaw.memory.storage.persist.IndexPersistence;
import io.ktor.utils.io.h0;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import org.bouncycastle.asn1.BERTags;
import r6.o;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f936a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f937b;

    public /* synthetic */ c(int i8, Object obj) {
        this.f936a = i8;
        this.f937b = obj;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f936a;
        Object obj = this.f937b;
        switch (i8) {
            case 0:
                o6.d.a((l) obj);
                return a0.f883a;
            case 1:
                o6.d.a((Closeable) ((y) obj).f3686a);
                return a0.f883a;
            case 2:
                o oVar = ((h) obj).f954h;
                p.b(oVar);
                oVar.d();
                return a0.f883a;
            case 3:
                c4.b bVar = (c4.b) obj;
                return h0.v(c1.f144a, r0.f211b, new c4.a(bVar.f1071c, bVar, null, 0), 2);
            case 4:
                return d0.c((Object[]) obj);
            case 5:
                return ((Iterable) obj).iterator();
            case 6:
                return SecurePrefs.masterKey_delegate$lambda$0((SecurePrefs) obj);
            case 7:
                return StepAccount.init$lambda$1((a4.b) obj);
            case 8:
                return Boolean.valueOf(((JsonConfigStore) obj).hasApiKeySync());
            case 9:
                return LightMemClient.postOfflineTrigger$lambda$4((h4.c) obj);
            case 10:
                return LightMemClient.postOfflineUpdate$lambda$3((OfflineUpdateResponse) obj);
            case BERTags.EMBEDDED_PDV /* 11 */:
                return ((LocalInferenceEngine) obj).applicationContext;
            case 12:
                return QueryRewriteStage.tryRemote$lambda$4((LightMemException) obj);
            case BERTags.RELATIVE_OID /* 13 */:
                return QueryRewriteStage.tryRemote$lambda$0((AutoRecallResponse) obj);
            case BERTags.TIME /* 14 */:
                j6.a aVar = new j6.a();
                x.e.C0(aVar, (byte[]) obj);
                return aVar;
            case 15:
                ArrayList arrayList = (ArrayList) obj;
                if (arrayList.isEmpty()) {
                    return s.f1092a;
                }
                return arrayList.subList((((CharSequence) m.u0(arrayList)).length() != 0 || arrayList.size() <= 1) ? 0 : 1, ((CharSequence) m.B0(arrayList)).length() == 0 ? n.j0(arrayList) : 1 + n.j0(arrayList));
            case 16:
                return Integer.valueOf(SerialDescriptorImpl._hashCode_delegate$lambda$0((SerialDescriptorImpl) obj));
            case 17:
                return SharedSecurePrefs.masterKey_delegate$lambda$0((SharedSecurePrefs) obj);
            case BERTags.NUMERIC_STRING /* 18 */:
                try {
                    return (List) ((p5.a) obj).invoke();
                } catch (SSLPeerUnverifiedException unused) {
                    return s.f1092a;
                }
            case 19:
                return (List) obj;
            case 20:
                return IndexPersistence.loadPersistedMeta$lambda$1((IndexPersistence) obj);
            case BERTags.VIDEOTEX_STRING /* 21 */:
                u6.n nVar = (u6.n) obj;
                nVar.getClass();
                try {
                    nVar.y.l(2, 0, false);
                } catch (IOException e9) {
                    u6.b bVar2 = u6.b.d;
                    nVar.a(bVar2, bVar2, e9);
                }
                return a0.f883a;
            case BERTags.IA5_STRING /* 22 */:
                ((j1) obj).f0();
                return a0.f883a;
            default:
                return ((c4.d) obj).a();
        }
    }
}

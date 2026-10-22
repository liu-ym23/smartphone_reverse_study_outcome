package x5;

import La.H;
import Y8.t;
import Z8.F;
import Z8.Y;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.sdk.client.v;
import com.stepos.ailauncher.common.utils.C3197a;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u0003J\u001f\u0010\f\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lx5/b;", "", "<init>", "()V", "", "", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Set;", "LY8/t;", Const.INTENT_KEY_UMID, "", "raw", "c", "([Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "ids", "Ljava/util/Set;", "Lcom/stepos/ability/sdk/client/v;", "client", "Lcom/stepos/ability/sdk/client/v;", "", "connecting", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: x5.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5851b {
    private static final String TAG = "TrainedWakeWords";
    private static v client;
    private static boolean connecting;
    public static final C5851b INSTANCE = new C5851b();
    private static volatile Set<String> ids = Y.e();

    public static final t e(v vVar) {
        connecting = false;
        INSTANCE.c(vVar.f());
        return t.f7040a;
    }

    public final Set<String> b() {
        return ids;
    }

    public final void c(String[] raw) {
        if (raw == null) {
            raw = new String[0];
        }
        ArrayList arrayList = new ArrayList(raw.length);
        for (String str : raw) {
            String lowerCase = H.D1(str).toString().toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
            arrayList.add(lowerCase);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        Set<String> setR1 = F.r1(arrayList2);
        if (p.d(setR1, ids)) {
            return;
        }
        ids = setR1;
        C4148a.k(TAG, "trained wake words=" + setR1, false, 4, null);
    }

    public final void d() {
        Context applicationContext = C3197a.INSTANCE.a().getApplicationContext();
        final v vVar = client;
        if (vVar == null) {
            p.f(applicationContext);
            vVar = new v(applicationContext);
            client = vVar;
        }
        if (vVar.g()) {
            c(vVar.f());
        } else {
            if (connecting) {
                return;
            }
            connecting = true;
            vVar.e(new InterfaceC5063a() { // from class: x5.a
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return C5851b.e(vVar);
                }
            });
        }
    }
}

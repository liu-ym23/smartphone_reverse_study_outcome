package m6;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.tencent.mmkv.MMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import o6.C5009a;
import p6.C5059c;
import p6.InterfaceC5057a;
import p6.InterfaceC5058b;
import p6.InterfaceC5060d;
import q6.c;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lm6/a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", "c", "(Landroid/content/Context;)V", "Lp6/b;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)Lp6/b;", Const.INTENT_KEY_APIKEY, "()Lp6/b;", "Lp6/d;", "taskRepository", "Lp6/d;", "keyValueRepository", "Lp6/b;", "secureKeyValueRepository", "Lp6/a;", "installedSkillRepository", "Lp6/a;", "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: m6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4904a {
    public static final C4904a INSTANCE = new C4904a();
    private static volatile InterfaceC5057a installedSkillRepository;
    private static volatile InterfaceC5058b keyValueRepository;
    private static volatile InterfaceC5058b secureKeyValueRepository;
    private static volatile InterfaceC5060d taskRepository;

    public final InterfaceC5058b a() throws RuntimeException {
        MMKV mmkvK = MMKV.k();
        p.h(mmkvK, "defaultMMKV(...)");
        return new C5059c(mmkvK);
    }

    public final InterfaceC5058b b(Context context) {
        InterfaceC5058b interfaceC5058bA;
        p.i(context, "context");
        InterfaceC5058b interfaceC5058b = keyValueRepository;
        if (interfaceC5058b != null) {
            return interfaceC5058b;
        }
        synchronized (this) {
            interfaceC5058bA = keyValueRepository;
            if (interfaceC5058bA == null) {
                interfaceC5058bA = INSTANCE.a();
                keyValueRepository = interfaceC5058bA;
            }
        }
        return interfaceC5058bA;
    }

    public final void c(Context context) throws RuntimeException {
        p.i(context, "context");
        C5009a.INSTANCE.w(context);
        c.INSTANCE.i(context);
    }
}

package androidx.room;

import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import i1.InterfaceC4162d;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/room/l;", "", "sql", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroidx/room/l;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class D {
    public static final Object b(l lVar, String str, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objD = lVar.d(str, new InterfaceC5074l() { // from class: androidx.room.C
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(D.c((InterfaceC4162d) obj));
            }
        }, interfaceC4014c);
        return objD == C4063a.g() ? objD : Y8.t.f7040a;
    }

    public static final boolean c(InterfaceC4162d it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.n1();
    }
}

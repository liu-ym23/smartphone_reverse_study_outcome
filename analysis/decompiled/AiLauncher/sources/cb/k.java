package cb;

import Ua.InterfaceC1066l;
import Y8.t;
import Za.C;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import p9.q;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\b\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00010\u00002\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000e\"6\u0010\u0011\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0010\"\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0017\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014\"\u0014\u0010\u0019\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014\"\u0014\u0010\u001b\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014\"\u001a\u0010\u001f\u001a\u00020\u00128\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u001e*H\b\u0007\u0010!\" \u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030 \u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00010\u00022 \u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030 \u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00010\u0002*H\b\u0007\u0010\"\" \u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022 \u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002*\u0080\u0001\b\u0000\u0010#\"<\u0012\b\u0012\u0006\u0012\u0002\b\u00030 \u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00020\u00022<\u0012\b\u0012\u0006\u0012\u0002\b\u00030 \u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00020\u0002¨\u0006$"}, d2 = {"LUa/l;", "LY8/t;", "Lkotlin/Function3;", "", "", "Lkotlin/coroutines/d;", "onCancellation", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(LUa/l;Lp9/q;)Z", "", "trySelectInternalResult", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", Const.INTENT_KEY_APIKEY, "(I)Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "Lp9/q;", "DUMMY_PROCESS_RESULT_FUNCTION", "LZa/C;", Const.INTENT_KEY_PKGNAME, "LZa/C;", "STATE_REG", "c", "STATE_COMPLETED", Const.INTENT_KEY_UMID, "STATE_CANCELLED", "e", "NO_RESULT", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()LZa/C;", "PARAM_CLAUSE_0", "Lcb/j;", "RegistrationFunction", "ProcessResultFunction", "OnCancellationConstructor", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final q<Object, Object, Object, Object> f15506a = a.f15512a;

    /* renamed from: b, reason: collision with root package name */
    public static final C f15507b = new C("STATE_REG");

    /* renamed from: c, reason: collision with root package name */
    public static final C f15508c = new C("STATE_COMPLETED");

    /* renamed from: d, reason: collision with root package name */
    public static final C f15509d = new C("STATE_CANCELLED");

    /* renamed from: e, reason: collision with root package name */
    public static final C f15510e = new C("NO_RESULT");

    /* renamed from: f, reason: collision with root package name */
    public static final C f15511f = new C("PARAM_CLAUSE_0");

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements q {

        /* renamed from: a, reason: collision with root package name */
        public static final a f15512a = new a();

        @Override // p9.q
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj, Object obj2, Object obj3) {
            return null;
        }
    }

    public static final TrySelectDetailedResult a(int i10) {
        if (i10 == 0) {
            return TrySelectDetailedResult.SUCCESSFUL;
        }
        if (i10 == 1) {
            return TrySelectDetailedResult.REREGISTER;
        }
        if (i10 == 2) {
            return TrySelectDetailedResult.CANCELLED;
        }
        if (i10 == 3) {
            return TrySelectDetailedResult.ALREADY_SELECTED;
        }
        throw new IllegalStateException(("Unexpected internal result: " + i10).toString());
    }

    public static final C i() {
        return f15511f;
    }

    public static final boolean j(InterfaceC1066l<? super t> interfaceC1066l, q<? super Throwable, Object, ? super kotlin.coroutines.d, t> qVar) {
        Object objL = interfaceC1066l.l(t.f7040a, null, qVar);
        if (objL == null) {
            return false;
        }
        interfaceC1066l.x(objL);
        return true;
    }
}

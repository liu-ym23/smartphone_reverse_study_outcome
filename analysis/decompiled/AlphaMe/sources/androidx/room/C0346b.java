package androidx.room;

import Z2.C0127g0;
import android.content.Context;
import com.stepos.policy.sdk.C0518q;
import com.stepos.policy.sdk.C0524x;
import com.stepos.policy.sdk.PolicyManager;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import g3.C0580d;
import k0.InterfaceC0674b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import t0.J;

/* renamed from: androidx.room.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0346b extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4198a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4199b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4200c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0346b(int i4, Object obj, Object obj2) {
        super(1);
        this.f4198a = i4;
        this.f4199b = obj;
        this.f4200c = obj2;
    }

    public final Object a(InterfaceC0674b db) {
        int i4 = this.f4198a;
        Object obj = this.f4200c;
        Object obj2 = this.f4199b;
        switch (i4) {
            case 0:
                Intrinsics.checkNotNullParameter(db, "db");
                db.execSQL((String) obj2, (Object[]) obj);
                return null;
            default:
                Intrinsics.checkNotNullParameter(db, "db");
                AbstractC0347c abstractC0347c = (AbstractC0347c) obj2;
                abstractC0347c.getClass();
                db.compileStatement(null);
                abstractC0347c.getClass();
                throw null;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C0127g0 c0127g0 = C0127g0.f2215a;
        int i4 = this.f4198a;
        Object obj2 = this.f4200c;
        Object obj3 = this.f4199b;
        switch (i4) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                PolicySdkResultBean policySdkResultBean = (PolicySdkResultBean) obj;
                Intrinsics.checkNotNullParameter(policySdkResultBean, "policySdkResultBean");
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = "";
                if (policySdkResultBean.getCode() == 0) {
                    J.y(c0127g0, PolicyManager.INSTANCE.getExceptionHandler(), new C0518q((PolicyManager) obj3, (Context) obj2, objectRef, null), 2);
                }
                break;
            case 3:
                PolicySdkResultBean policySdkResultBean2 = (PolicySdkResultBean) obj;
                Intrinsics.checkNotNullParameter(policySdkResultBean2, "policySdkResultBean");
                J.y(c0127g0, PolicyManager.INSTANCE.getExceptionHandler(), new C0524x(policySdkResultBean2, (Ref.ObjectRef) obj3, (Context) obj2, null), 2);
                break;
            default:
                ((C0580d) obj3).e(obj2);
                break;
        }
        return Unit.INSTANCE;
    }
}

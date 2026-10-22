package com.stepos.policy.sdk;

import com.stepos.policy.sdk.bean.DeleteInfoBean;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class F extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11999a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f12000b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f12001c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1 f12002d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ F(ArrayList arrayList, ArrayList arrayList2, Function1 function1, int i4) {
        super(1);
        this.f11999a = i4;
        this.f12000b = arrayList;
        this.f12001c = arrayList2;
        this.f12002d = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i4 = this.f11999a;
        Function1 function1 = this.f12002d;
        ArrayList arrayList = this.f12001c;
        ArrayList arrayList2 = this.f12000b;
        switch (i4) {
            case 0:
                DeleteInfoBean deleteInfoBean = (DeleteInfoBean) obj;
                Intrinsics.checkNotNullParameter(deleteInfoBean, "deleteInfoBean");
                PolicyManager policyManager = PolicyManager.INSTANCE;
                arrayList2.add(deleteInfoBean);
                if (arrayList2.size() == arrayList.size()) {
                    function1.invoke(arrayList2);
                }
                break;
            default:
                DeleteInfoBean deleteInfoBean2 = (DeleteInfoBean) obj;
                Intrinsics.checkNotNullParameter(deleteInfoBean2, "deleteInfoBean");
                PolicyManager policyManager2 = PolicyManager.INSTANCE;
                arrayList2.add(deleteInfoBean2);
                if (arrayList2.size() == arrayList.size()) {
                    function1.invoke(arrayList2);
                }
                break;
        }
        return Unit.INSTANCE;
    }
}

package com.obric.structure.omvvm.core.util;

import androidx.fragment.app.FragmentActivity;
import com.obric.structure.omvvm.core.presenter.QPresenter;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultContextChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0002\u0010\tR\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00040\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/structure/omvvm/core/util/DefaultContextChecker;", "Lkotlin/Function0;", "", "presenter", "Lcom/obric/structure/omvvm/core/presenter/QPresenter;", "(Lcom/obric/structure/omvvm/core/presenter/QPresenter;)V", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/lang/Boolean;", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultContextChecker implements Function0<Boolean> {
    private final WeakReference<QPresenter> presenter;

    public DefaultContextChecker(QPresenter r2) {
        Intrinsics.checkNotNullParameter(r2, "presenter");
        this.presenter = new WeakReference(r2);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public Boolean invoke() {
        QPresenter r2 = this.presenter.get();
        boolean r0 = false;
        if (r2 == null) goto L5;
        FragmentActivity r3 = (FragmentActivity) r2.getQContext().activityNullable();
        if (r3 == null) goto L12;
        if (r3.isFinishing() == true) goto L12;
        r0 = true;
    L12:
        return Boolean.valueOf(!r0);
    L5:
        return false;
    }
}

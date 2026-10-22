package com.obric.structure.omvvm.core.ui;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModelProvider;
import com.obric.structure.omvvm.core.viewmodel.QViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QUIManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"getVM", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/structure/omvvm/core/viewmodel/QViewModel;", "Lcom/obric/structure/omvvm/core/ui/QUIManager;", "clazz", "Ljava/lang/Class;", "(Lcom/obric/structure/omvvm/core/ui/QUIManager;Ljava/lang/Class;)Lcom/obric/structure/omvvm/core/viewmodel/QViewModel;", "omvvm-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class QUIManagerKt {
    public static final <T extends QViewModel> T getVM(QUIManager r1, Class<T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return (T) new ViewModelProvider(r1.getVmStoreOwner$omvvm_core_release()).get(r2);
    L5:
        return null;
    }
}

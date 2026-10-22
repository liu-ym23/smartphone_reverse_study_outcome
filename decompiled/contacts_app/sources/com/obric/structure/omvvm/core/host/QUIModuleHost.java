package com.obric.structure.omvvm.core.host;

import com.obric.structure.omvvm.core.presenter.QIPresenter;
import com.obric.structure.omvvm.core.ui.QUIModule;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: QUIModuleHost.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/obric/structure/omvvm/core/host/QUIModuleHost;", "", "sync", "", "getSync", "()Z", "presenter", "Lcom/obric/structure/omvvm/core/presenter/QIPresenter;", "subModules", "", "Lcom/obric/structure/omvvm/core/ui/QUIModule;", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface QUIModuleHost {

    /* JADX INFO: compiled from: QUIModuleHost.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean getSync(QUIModuleHost r0) {
            return true;
        }

        public static QIPresenter presenter(QUIModuleHost r0) {
            return null;
        }

        public static List<QUIModule> subModules(QUIModuleHost r0) {
            return null;
        }
    }

    boolean getSync();

    QIPresenter presenter();

    List<QUIModule> subModules();
}

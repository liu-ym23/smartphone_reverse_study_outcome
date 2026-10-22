package kotlinx.coroutines.internal;

import java.util.List;
import kotlinx.coroutines.cm;

/* JADX INFO: compiled from: MainDispatcherFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface MainDispatcherFactory {
    cm createDispatcher(List<? extends MainDispatcherFactory> r1);

    int getLoadPriority();

    String hintOnError();
}

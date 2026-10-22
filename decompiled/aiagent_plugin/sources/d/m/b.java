package d.m;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: KCallable.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface b<R> extends a {
    R call(Object... r1);

    R callBy(Map<Object, ? extends Object> r1);

    String getName();

    List<Object> getParameters();

    k getReturnType();

    List<Object> getTypeParameters();

    l getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}

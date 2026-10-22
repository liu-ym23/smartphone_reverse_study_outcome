package ch.qos.logback.core;

import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.LifeCycle;

/* loaded from: classes.dex */
public interface Layout<E> extends ContextAware, LifeCycle {
    String doLayout(E e4);

    String getContentType();

    String getFileFooter();

    String getFileHeader();

    String getPresentationFooter();

    String getPresentationHeader();
}

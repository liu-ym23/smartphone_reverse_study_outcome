package ch.qos.logback.core.read;

import ch.qos.logback.core.AppenderBase;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ListAppender<E> extends AppenderBase<E> {
    public List<E> list = new ArrayList();

    @Override // ch.qos.logback.core.AppenderBase
    public void append(E e4) {
        this.list.add(e4);
    }
}

package wc;

import java.util.List;
import org.slf4j.Marker;
import org.slf4j.event.Level;

/* loaded from: classes5.dex */
public interface c {
    Object[] a();

    List<Marker> b();

    List<b> c();

    default String d() {
        return null;
    }

    Level getLevel();

    String getMessage();

    Throwable getThrowable();
}

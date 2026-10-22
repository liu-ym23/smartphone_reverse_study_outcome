package w7;

import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter;
import java.util.List;

/* loaded from: classes.dex */
public interface c extends b {
    u f();

    String getName();

    List getParameters();

    Object h(Object... objArr);

    Object n(KotlinJsonAdapter.IndexedParameterMap indexedParameterMap);

    boolean o();
}

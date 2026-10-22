package retrofit2;

import h3.V;
import java.io.IOException;
import k3.C0683E;

/* loaded from: classes2.dex */
public interface Call<T> extends Cloneable {
    void cancel();

    Call<T> clone();

    void enqueue(Callback<T> callback);

    Response<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    V request();

    C0683E timeout();
}

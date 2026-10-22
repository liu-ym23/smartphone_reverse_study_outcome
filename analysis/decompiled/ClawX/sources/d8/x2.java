package d8;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public interface x2 {
    default j1 a(j1 j1Var) throws IOException {
        try {
            return (j1) d(j1Var).toCompletableFuture().get(c().toMillis(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e9) {
            Thread.currentThread().interrupt();
            throw new IOException(e9);
        } catch (ExecutionException e10) {
            if (e10.getCause() instanceof IOException) {
                throw ((IOException) e10.getCause());
            }
            if (e10.getCause() != null) {
                throw new IOException(e10.getCause());
            }
            throw new IOException(e10);
        } catch (TimeoutException e11) {
            throw new IOException("Timed out while trying to resolve " + j1Var.d().f2195a + "/" + f4.f1995a.d(j1Var.d().f2196b) + ", id=" + j1Var.f2031a.f2175a, e11);
        }
    }

    CompletionStage b(j1 j1Var, Executor executor);

    Duration c();

    CompletionStage d(j1 j1Var);
}

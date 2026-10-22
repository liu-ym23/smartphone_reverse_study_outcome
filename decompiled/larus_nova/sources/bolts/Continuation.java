package bolts;

/* JADX INFO: loaded from: classes28.dex */
public interface Continuation<TTaskResult, TContinuationResult> {
    TContinuationResult then(Task<TTaskResult> r100) throws Exception;
}

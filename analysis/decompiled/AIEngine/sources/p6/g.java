package p6;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface g {
    void onAfterInfer(String str, String str2, long j10);

    void onAfterLoad(String str, String str2, boolean z, String str3, long j10);

    void onBeforeInfer(String str, String str2);

    void onBeforeLoad(String str, String str2, boolean z, String str3);

    void onInferCancelled(String str, String str2);

    void onInferError(String str, String str2, Throwable th);

    void onLoadEmpty(String str, String str2, boolean z, String str3, String str4);

    void onLoadFailed(String str, String str2, boolean z, String str3, Throwable th);

    void onLoadedToInvoke(String str, String str2, boolean z, String str3);
}

package com.stepos.core;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.core.ability.AbilityInfo;
import com.stepos.core.data.base.Content;
import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J9\u0010\u000f\u001a\u00020\u000e\"\b\b\u0000\u0010\t*\u00020\b\"\b\b\u0001\u0010\n*\u00020\b2\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\fH&¢\u0006\u0004\b\u000f\u0010\u0010JA\u0010\u000f\u001a\u00020\u000e\"\b\b\u0000\u0010\t*\u00020\b\"\b\b\u0001\u0010\n*\u00020\b2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\fH&¢\u0006\u0004\b\u000f\u0010\u0013JA\u0010\u000f\u001a\u00020\u000e\"\b\b\u0000\u0010\t*\u00020\b\"\b\b\u0001\u0010\n*\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\fH&¢\u0006\u0004\b\u000f\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000eH&¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u000eH&¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001dH&¢\u0006\u0004\b\"\u0010#J+\u0010'\u001a\u00020\u001d2\u001a\u0010&\u001a\u0016\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001d\u0018\u00010$H&¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/stepos/core/IAbilityHandle;", "", "", "prepare", "()Z", "Lcom/stepos/core/ability/AbilityInfo;", "getAbilityInfo", "()Lcom/stepos/core/ability/AbilityInfo;", "Lcom/stepos/core/data/base/Content;", ExifInterface.GPS_DIRECTION_TRUE, "R", "input", "Lcom/stepos/core/InferenceCallback;", "callback", "", "infer", "(Lcom/stepos/core/data/base/Content;Lcom/stepos/core/InferenceCallback;)Ljava/lang/String;", "Ljava/util/concurrent/Executor;", "executor", "(Lcom/stepos/core/data/base/Content;Ljava/util/concurrent/Executor;Lcom/stepos/core/InferenceCallback;)Ljava/lang/String;", "requestId", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;Lcom/stepos/core/InferenceCallback;)Ljava/lang/String;", "inferId", "cancel", "(Ljava/lang/String;)Z", "action", "params", "execute", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;)Lcom/stepos/core/data/base/Content;", "LY8/t;", "feedInput", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;)V", "completeInput", "(Ljava/lang/String;)V", "release", "()V", "Lkotlin/Function2;", "", "listener", "setOnModelReleased", "(Lp9/p;)V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IAbilityHandle {
    boolean cancel(String inferId);

    void completeInput(String inferId);

    Content execute(String action, Content params);

    void feedInput(String inferId, Content input);

    AbilityInfo getAbilityInfo();

    <T extends Content, R extends Content> String infer(T input, InferenceCallback<? super R> callback);

    <T extends Content, R extends Content> String infer(T input, Executor executor, InferenceCallback<? super R> callback);

    <T extends Content, R extends Content> String infer(String requestId, T input, InferenceCallback<? super R> callback);

    boolean prepare();

    void release();

    void setOnModelReleased(p9.p<? super Integer, ? super String, Y8.t> listener);
}

package com.obric.capabilitykit.common.intent;

import android.os.Parcelable;
import androidx.annotation.Keep;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@ServiceImpl(service = {IntentFunction.class})
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0017\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/capabilitykit/common/intent/BaseRecorderDeleteIntent;", "Lcom/obric/capabilitykit/common/intent/IntentFunction;", "Lcom/obric/capabilitykit/common/intent/RecorderDeleteParams;", "", "Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "()V", "name", "", "getName", "()Ljava/lang/String;", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class BaseRecorderDeleteIntent implements IntentFunction<RecorderDeleteParams, RecordingEntity[]> {

    @NotNull
    private final String name;

    public BaseRecorderDeleteIntent() {
        this.name = "Recorder_Delete";
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public boolean cancelTask(@NotNull String r10) {
        return IntentFunction.DefaultImpls.cancelTask(this, r10);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r10, DispatchContext r11, Continuation<? super IntentResult<RecordingEntity[]>> r12) {
        return doAction((RecorderDeleteParams) r10, r11, r12);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    @NotNull
    public final String getName() {
        return this.name;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return IntentFunction.DefaultImpls.isBlock(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    @Nullable
    public Boolean isTaskOnGoing(@NotNull DispatchContext r10) {
        return IntentFunction.DefaultImpls.isTaskOnGoing(this, r10);
    }

    @Nullable
    public Object doAction(@NotNull RecorderDeleteParams r10, @NotNull DispatchContext r11, @NotNull Continuation<? super IntentResult<RecordingEntity[]>> r12) {
        return IntentFunction.DefaultImpls.doAction(this, r10, r11, r12);
    }
}

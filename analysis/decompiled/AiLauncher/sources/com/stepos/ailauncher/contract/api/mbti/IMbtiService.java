package com.stepos.ailauncher.contract.api.mbti;

import android.content.Context;
import com.stepos.ailauncher.contract.model.MbtiStatus;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007H¦@¢\u0006\u0004\b\n\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/mbti/IMbtiService;", "", "Landroid/content/Context;", "context", "LY8/t;", "startMbti", "(Landroid/content/Context;)V", "Lcom/stepos/ailauncher/contract/model/MbtiStatus;", "getMbtiStatus", "()Lcom/stepos/ailauncher/contract/model/MbtiStatus;", "fetchMbtiStatus", "(Le9/c;)Ljava/lang/Object;", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IMbtiService {
    Object fetchMbtiStatus(InterfaceC4014c<? super MbtiStatus> interfaceC4014c);

    MbtiStatus getMbtiStatus();

    void startMbti(Context context);
}

package com.stepos.ailauncher.chat.sheet;

import android.content.res.Resources;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant;
import com.stepos.ailauncher.contract.api.homegesture.HomeRootToken;
import com.stepos.ailauncher.sheet.SheetLaunchOptions;
import io.ktor.sse.ServerSentEventKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/chat/sheet/e;", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeGroupExitParticipant;", "Lcom/stepos/ailauncher/chat/activity/ChatActivity;", "activity", "<init>", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;)V", "", "isShowing", "()Z", "prepareForHomeGroupExit", "", "positionPx", "progress", "LY8/t;", "applyHomeGroupExit", "(FF)V", "finishHomeGroupExit", "()V", "cancelHomeGroupExit", "Lcom/stepos/ailauncher/chat/activity/ChatActivity;", "", "participantId", "Ljava/lang/String;", "getParticipantId", "()Ljava/lang/String;", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "getVisualStackRootToken", "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "visualStackRootToken", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.sheet.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2734e implements HomeGroupExitParticipant {
    private final ChatActivity activity;
    private final String participantId;

    public C2734e(ChatActivity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        this.activity = activity;
        this.participantId = "root:" + activity.getClass().getName() + ServerSentEventKt.COLON + System.identityHashCode(activity);
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
    public void applyHomeGroupExit(float positionPx, float progress) {
        this.activity.D0(positionPx, progress);
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
    public void cancelHomeGroupExit() {
        this.activity.T0();
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
    public void finishHomeGroupExit() throws Resources.NotFoundException {
        this.activity.H1();
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
    public String getParticipantId() {
        return this.participantId;
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
    public HomeRootToken getVisualStackRootToken() {
        return HomeRootToken.INSTANCE.fromWire(SheetLaunchOptions.INSTANCE.d(this.activity.getIntent()));
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
    public boolean isShowing() {
        return !this.activity.isFinishing() && !this.activity.isDestroyed() && this.activity.r2() && this.activity.P7();
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
    public boolean prepareForHomeGroupExit() {
        return this.activity.r3();
    }
}

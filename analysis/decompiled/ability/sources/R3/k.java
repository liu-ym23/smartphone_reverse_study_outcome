package R3;

import C7.r;
import android.content.Context;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.MediatorLiveData;
import android.view.Transformations;
import android.view.compose.LifecycleEffectKt;
import android.view.compose.LifecycleResumePauseEffectScope;
import android.view.compose.LifecycleStartStopEffectScope;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.State;
import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.stepos.ability.database.dao.AtomicAbilityDao_Impl;
import com.stepos.ability.voicewakeup.service.WakeupEngine;
import com.stepos.agentframework.adapter.bff.BffClient;
import com.stepos.agentframework.adapter.bff.CacheBean;
import com.stepos.taskrobot.llmapi.stepfun.ZyqlStepService;
import com.zyql.agentfront.bean.Message;
import com.zyql.common.utils.update.UpdateManager;
import com.zyql.common.utils.update.model.UpdateCheckResponse;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import stepai.aios.guiagent.llm.MessageContent;
import stepai.android.llm.base.ImageContentBuilder;

/* loaded from: classes3.dex */
public final /* synthetic */ class k implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1149a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ k(Object obj, Object obj2, Object obj3, int i) {
        this.f1149a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1149a) {
            case 0:
                return AtomicAbilityDao_Impl.deleteByPackageNameExceptFunctionNames$lambda$0((String) this.b, (String) this.c, (List) this.d, (SQLiteConnection) obj);
            case 1:
                return Transformations.switchMap$lambda$3((S7.k) this.b, (Ref$ObjectRef) this.c, (MediatorLiveData) this.d, obj);
            case 2:
                return LifecycleEffectKt.LifecycleEventEffect$lambda$4$lambda$3((LifecycleOwner) this.b, (Lifecycle.Event) this.c, (State) this.d, (DisposableEffectScope) obj);
            case 3:
                return LifecycleEffectKt.LifecycleStartEffectImpl$lambda$19$lambda$18((LifecycleOwner) this.b, (LifecycleStartStopEffectScope) this.c, (S7.k) this.d, (DisposableEffectScope) obj);
            case 4:
                return LifecycleEffectKt.LifecycleResumeEffectImpl$lambda$34$lambda$33((LifecycleOwner) this.b, (LifecycleResumePauseEffectScope) this.c, (S7.k) this.d, (DisposableEffectScope) obj);
            case 5:
                return Integer.valueOf(AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.delete$lambda$5((String) this.b, (String) this.c, (Object[]) this.d, (SupportSQLiteDatabase) obj));
            case 6:
                com.stepos.ability.voicewakeup.service.l lVar = (com.stepos.ability.voicewakeup.service.l) this.b;
                WakeupEngine wakeupEngine = (WakeupEngine) this.c;
                com.stepos.ability.voicewakeup.service.a aVar = (com.stepos.ability.voicewakeup.service.a) this.d;
                F4.b result = (F4.b) obj;
                kotlin.jvm.internal.k.f(result, "result");
                com.stepos.ability.voicewakeup.service.l.o(false, new H4.b(lVar, wakeupEngine, aVar, result, 1));
                return r.f317a;
            case 7:
                return BffClient.onDataReceived$lambda$1((Ref$BooleanRef) this.b, (r7.f) this.c, (r7.k) this.d, (CacheBean) obj);
            case 8:
                return ZyqlStepService.chat$lambda$2$0$0$0$0$1((Map) this.b, (MessageContent) this.c, (Map) this.d, (ImageContentBuilder) obj);
            case 9:
                Message message = (Message) this.b;
                com.zyql.agentfront.sdk.client.c cVar = (com.zyql.agentfront.sdk.client.c) this.c;
                com.zyql.agentfront.sdk.client.b bVar = (com.zyql.agentfront.sdk.client.b) this.d;
                String str = (String) obj;
                com.zyql.agentfront.sdk.client.b.f4243s.a("AgentFrontClient", B7.a.n("Failed to connect service for message: ", message.getMessageId(), ", reason: ", str), null);
                String messageId = message.getMessageId();
                if (str == null) {
                    str = "Service connection failed";
                }
                cVar.onError(messageId, str);
                bVar.k.remove(message.getMessageId());
                return r.f317a;
            default:
                return UpdateManager.checkAndDownloadUpdate$lambda$24((S7.a) this.b, (Context) this.c, (S7.k) this.d, (UpdateCheckResponse) obj);
        }
    }
}

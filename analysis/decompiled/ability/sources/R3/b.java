package R3;

import C7.r;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.view.serialization.SavedStateConfiguration;
import androidx.appfunctions.AppFunctionUriGrant;
import androidx.appfunctions.ExecuteAppFunctionResponse;
import androidx.appfunctions.internal.AppSearchAppFunctionReader;
import androidx.appsearch.app.SearchResult;
import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.changelist.Operations;
import androidx.compose.runtime.saveable.serialization.SerializableSaverKt;
import androidx.compose.runtime.snapshots.SnapshotStateList$Companion$CREATOR$1;
import androidx.compose.ui.text.font.FontFamilyResolverImpl;
import androidx.compose.ui.text.font.TypefaceRequest;
import androidx.compose.ui.text.font.TypefaceRequestCache;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.sqlite.SQLiteConnection;
import com.stepos.ability.IAgentServiceManager;
import com.stepos.ability.ITaskListener;
import com.stepos.ability.database.dao.AbilityDao_Impl;
import com.stepos.ability.database.dao.AbilityReportDao_Impl;
import com.stepos.ability.database.dao.AbilityTaskDao_Impl;
import com.stepos.ability.database.dao.AtomicAbilityDao_Impl;
import com.stepos.ability.database.dao.SyncCacheMetaDao_Impl;
import com.stepos.ability.database.entity.AbilityEntity;
import com.stepos.ability.database.entity.AbilityReportTaskEntity;
import com.stepos.ability.database.entity.AbilityTaskEntity;
import com.stepos.ability.database.entity.AtomicAbilityEntity;
import com.stepos.ability.database.entity.SyncCacheMetaEntity;
import com.stepos.ability.sdk.client.AgentServiceClient;
import com.stepos.agentframework.adapter.bff.BffClient;
import com.stepos.agentframework.adapter.bff.CacheBean;
import com.stepos.common.RequiredAction;
import com.stepos.taskrobot.taskmemory.dao.TaskDao_Impl;
import com.zyql.common.utils.update.UpdateManager;
import com.zyql.common.utils.update.UpdateProgressDialog;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import n9.C1748d;
import w9.C2109b;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1143a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ b(int i, Object obj, Object obj2) {
        this.f1143a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1143a) {
            case 0:
                return AbilityDao_Impl.insertOrUpdate$lambda$0((AbilityDao_Impl) this.b, (AbilityEntity) this.c, (SQLiteConnection) obj);
            case 1:
                return AbilityDao_Impl.batchInsertOrUpdate$lambda$0((AbilityDao_Impl) this.b, (List) this.c, (SQLiteConnection) obj);
            case 2:
                return AbilityReportDao_Impl.insert$lambda$0((AbilityReportDao_Impl) this.b, (AbilityReportTaskEntity) this.c, (SQLiteConnection) obj);
            case 3:
                return AbilityTaskDao_Impl.insert$lambda$0((AbilityTaskDao_Impl) this.b, (AbilityTaskEntity) this.c, (SQLiteConnection) obj);
            case 4:
                return AtomicAbilityDao_Impl.getByAppNames$lambda$0((String) this.b, (List) this.c, (SQLiteConnection) obj);
            case 5:
                return AtomicAbilityDao_Impl.insertOrReplaceAll$lambda$0((AtomicAbilityDao_Impl) this.b, (List) this.c, (SQLiteConnection) obj);
            case 6:
                return AtomicAbilityDao_Impl.insertOrReplace$lambda$0((AtomicAbilityDao_Impl) this.b, (AtomicAbilityEntity) this.c, (SQLiteConnection) obj);
            case 7:
                return SyncCacheMetaDao_Impl.insertOrReplace$lambda$0((SyncCacheMetaDao_Impl) this.b, (SyncCacheMetaEntity) this.c, (SQLiteConnection) obj);
            case 8:
                return ExecuteAppFunctionResponse.Success.grantUriAccess$lambda$0((Context) this.b, (String) this.c, (AppFunctionUriGrant) obj);
            case 9:
                return AppSearchAppFunctionReader.searchTopLevelComponent$lambda$1((AppSearchAppFunctionReader) this.b, (LinkedHashMap) this.c, (SearchResult) obj);
            case 10:
                return AppSearchAppFunctionReader.performSearch$lambda$0((AppSearchAppFunctionReader) this.b, (Map) this.c, (SearchResult) obj);
            case 11:
                return Recomposer.effectJob$lambda$10$lambda$9$lambda$8$lambda$7((Recomposer) this.b, (Throwable) this.c, (Throwable) obj);
            case 12:
                return Recomposer.writeObserverOf$lambda$86((ControlledComposition) this.b, (MutableScatterSet) this.c, obj);
            case 13:
                return Operations.toCollectionString$lambda$14((Operations) this.b, (String) this.c, obj);
            case 14:
                return SnapshotStateList$Companion$CREATOR$1.createFromParcel$lambda$0((Parcel) this.b, (ClassLoader) this.c, ((Integer) obj).intValue());
            case 15:
                return FontFamilyResolverImpl.resolve$lambda$5((FontFamilyResolverImpl) this.b, (TypefaceRequest) this.c, (S7.k) obj);
            case 16:
                return TypefaceRequestCache.runCached$lambda$3((TypefaceRequestCache) this.b, (TypefaceRequest) this.c, (TypefaceResult) obj);
            case 17:
                return EditProcessor.generateBatchErrorMessage$lambda$4$lambda$3((EditCommand) this.b, (EditProcessor) this.c, (EditCommand) obj);
            case 18:
                return AgentServiceClient.updateGuiAgent$lambda$0((String) this.b, (com.stepos.ability.sdk.client.g) this.c, (IAgentServiceManager) obj);
            case 19:
                return AgentServiceClient.withService$lambda$0((String) this.b, (S7.k) this.c, ((Boolean) obj).booleanValue());
            case 20:
                return AgentServiceClient.registerTaskListener$lambda$0((ITaskListener) this.b, (String) this.c, (IAgentServiceManager) obj);
            case 21:
                return AgentServiceClient.showFullScreenGuiV2$lambda$0((String) this.b, (Bundle) this.c, (IAgentServiceManager) obj);
            case 22:
                return BffClient.callTool$lambda$0((RequiredAction) this.b, (String) this.c, (CacheBean) obj);
            case 23:
                return UpdateManager.checkAndDownloadUpdate$lambda$24$lambda$22$lambda$20((UpdateProgressDialog) this.b, (Context) this.c, (File) obj);
            case 24:
                return UpdateManager.checkAndDownloadUpdate$lambda$24$lambda$22$lambda$21((UpdateProgressDialog) this.b, (S7.k) this.c, (Throwable) obj);
            case 25:
                return SerializableSaverKt.serializableSaver$lambda$1((x9.b) this.b, (SavedStateConfiguration) this.c, (Bundle) obj);
            case 26:
                C1748d c1748d = (C1748d) this.b;
                c1748d.f5370a.removeCallbacks((A.a) this.c);
                return r.f317a;
            case 27:
                return TaskDao_Impl.insertList$lambda$0((TaskDao_Impl) this.b, (List) this.c, (SQLiteConnection) obj);
            default:
                ((kotlinx.coroutines.sync.a) this.b).unlock(((C2109b) this.c).b);
                return r.f317a;
        }
    }
}

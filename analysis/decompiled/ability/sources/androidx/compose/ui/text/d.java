package androidx.compose.ui.text;

import C7.r;
import C9.g;
import S7.k;
import android.animation.Animator;
import android.content.pm.Signature;
import android.os.Handler;
import android.os.Looper;
import android.view.serialization.SavedStateConfig_androidKt;
import androidx.compose.ui.text.font.FontFamilyResolverImpl;
import androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter;
import androidx.compose.ui.text.font.TypefaceRequest;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.core.animation.AnimatorKt;
import androidx.room.RoomRawQuery;
import androidx.room.TransactorKt;
import androidx.room.TriggerBasedInvalidationTracker;
import androidx.sqlite.SQLiteStatement;
import com.stepos.ability.commoninternal.AppInfoUtils;
import com.stepos.ability.sdk.client.AgentServiceClient;
import com.stepos.agentframework.adapter.ApiManager;
import com.stepos.agentframework.adapter.bff.BffClient;
import com.stepos.agentframework.adapter.bff.CacheBean;
import com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient;
import com.stepos.motionkit.EffectDefinition;
import com.stepos.motionkit.FxConfig;
import com.stepos.motionkit.FxModule;
import com.stepos.motionkit.fx.backend.SfBackend;
import com.stepos.motionkit.fx.material.MaterialBuilder;
import com.stepos.motionkit.fx.material.MaterialHandle;
import com.stepos.motionkit.fx.material.MaterialParams;
import com.stepos.motionkit.fx.material.backend.CrossWindowMaterialBackend;
import com.stepos.motionkit.fx.material.backend.InWindowMaterialBackend;
import com.stepos.net.exception.ApiException;
import com.uxsense.core.pattern.PatternMatchResult;
import com.uxsense.file.FileStorageConfig;
import com.uxsense.parse.ApexParserManager;
import com.zyql.agentfront.bean.MessageContent;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final /* synthetic */ class d implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1900a;

    public /* synthetic */ d(int i) {
        this.f1900a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1900a) {
            case 0:
                return Savers_androidKt.LineBreakSaver$lambda$3(obj);
            case 1:
                return Savers_androidKt.TextMotionSaver$lambda$5(obj);
            case 2:
                return FontFamilyResolverImpl.preload$lambda$4$lambda$2((TypefaceResult.Immutable) obj);
            case 3:
                return FontFamilyResolverImpl.preload$lambda$4$lambda$3((TypefaceResult.Immutable) obj);
            case 4:
                return FontListFontFamilyTypefaceAdapter.preload$lambda$4$lambda$3((TypefaceRequest) obj);
            case 5:
                return TextFieldValue.Saver$lambda$1(obj);
            case 6:
                return AnimatorKt.addPauseListener$lambda$0((Animator) obj);
            case 7:
                return AnimatorKt.addPauseListener$lambda$1((Animator) obj);
            case 8:
                return RoomRawQuery._init_$lambda$0((SQLiteStatement) obj);
            case 9:
                return Boolean.valueOf(TransactorKt.execSQL$lambda$0((SQLiteStatement) obj));
            case 10:
                return TriggerBasedInvalidationTracker.checkInvalidatedTables$lambda$14((SQLiteStatement) obj);
            case 11:
                return SavedStateConfig_androidKt.getDefaultSerializersModuleOnPlatform$lambda$1$lambda$0((List) obj);
            case 12:
                return AppInfoUtils.calcSignatureSha256$lambda$1((Signature) obj);
            case 13:
                Map.Entry it = (Map.Entry) obj;
                kotlin.jvm.internal.k.f(it, "it");
                return Boolean.valueOf(((Set) it.getValue()).isEmpty());
            case 14:
                Map.Entry it2 = (Map.Entry) obj;
                kotlin.jvm.internal.k.f(it2, "it");
                return Boolean.valueOf(((Set) it2.getValue()).isEmpty());
            case 15:
                return AgentServiceClient.init$lambda$0(((Boolean) obj).booleanValue());
            case 16:
                Runnable r5 = (Runnable) obj;
                kotlin.jvm.internal.k.f(r5, "r");
                new Handler(Looper.getMainLooper()).post(r5);
                return r.f317a;
            case 17:
                return ApiManager.init$lambda$0$0$0((ApiException) obj);
            case 18:
                return BffClient.send$lambda$0((CacheBean) obj);
            case 19:
                return OpenClawCoreAgentClient.handleRemoteToolEvent$lambda$1((MessageContent) obj);
            case 20:
                return OpenClawCoreAgentClient.handlePushMessage$lambda$1((MessageContent) obj);
            case 21:
                return OpenClawCoreAgentClient.AnonymousClass1.onReply$lambda$1((MessageContent) obj);
            case 22:
                return FxModule.DefaultImpls.play$lambda$0((FxConfig) obj);
            case 23:
                return SfBackend.channelFactory$lambda$3((EffectDefinition) obj);
            case 24:
                return MaterialBuilder.bindPending$lambda$12((MaterialHandle.Entry) obj);
            case 25:
                return MaterialBuilder.apply$lambda$0((MaterialParams) obj);
            case 26:
                return CrossWindowMaterialBackend.Token.release$lambda$0(obj);
            case 27:
                return InWindowMaterialBackend.Token.release$lambda$0((InWindowMaterialBackend.Config) obj);
            case 28:
                return FileStorageConfig._init_$lambda$0((g) obj);
            default:
                return Long.valueOf(ApexParserManager.parseComments$lambda$6((PatternMatchResult) obj));
        }
    }
}

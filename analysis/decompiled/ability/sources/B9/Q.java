package B9;

import D7.AbstractC0209a;
import D7.AbstractC0216h;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.OnBackPressedCallback;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.PlatformFontVariationSettings_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.room.AmbiguousColumnResolver;
import androidx.room.CoroutinesRoom;
import androidx.room.DatabaseConfiguration;
import androidx.room.RoomConnectionManager;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.google.gson.Gson;
import com.stepos.ability.bean.Task;
import com.stepos.ability.bean.ToolCallEvent;
import com.stepos.ability.beaninternal.ability.ProgressNotification;
import com.stepos.ability.sdk.client.AgentServiceClient;
import com.stepos.ability.voicewakeup.setting.WakeupWordSelectionActivity;
import com.stepos.agentframework.adapter.bff.BffClient;
import com.stepos.agentframework.adapter.bff.CacheBean;
import com.stepos.motionkit.MotionHost;
import com.stepos.motionkit.fx.material.CrossWindowGlass;
import com.stepos.motionkit.fx.material.capability.BlendParams;
import com.stepos.motionkit.fx.material.capability.BlurParams;
import com.stepos.motionkit.fx.material.capability.InnerShadowParams;
import com.stepos.motionkit.fx.material.capability.RefractionParams;
import com.stepos.motionkit.fx.material.capability.StrokeParams;
import com.stepos.motionkit.fx.shader.ShaderLoader;
import j9.InterfaceC1616j;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Ref$ObjectRef;
import m9.C1724q;
import z9.C2199a;

/* loaded from: classes4.dex */
public final /* synthetic */ class Q implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f228a;
    public final /* synthetic */ Object b;

    public /* synthetic */ Q(com.stepos.ability.task.executor.g gVar, Task task) {
        this.f228a = 26;
        this.b = gVar;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f228a;
        C7.r rVar = C7.r.f317a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                C2199a buildSerialDescriptor = (C2199a) obj;
                kotlin.jvm.internal.k.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
                List list = ((S) obj2).b;
                kotlin.jvm.internal.k.f(list, "<set-?>");
                buildSerialDescriptor.b = list;
                return rVar;
            case 1:
                V v10 = (V) obj2;
                int iIntValue = ((Integer) obj).intValue();
                return v10.e[iIntValue] + ": " + v10.g(iIntValue).h();
            case 2:
                BlurParams blurParams = (BlurParams) obj2;
                BlurParams apply = (BlurParams) obj;
                kotlin.jvm.internal.k.f(apply, "$this$apply");
                apply.setRadius(blurParams.getRadius());
                apply.setTintColor(blurParams.getTintColor());
                apply.setBlendColor(blurParams.getBlendColor());
                apply.setFrost(blurParams.getFrost());
                apply.setOverlay(blurParams.getOverlay());
                apply.setUseAospBlur(blurParams.getUseAospBlur());
                return rVar;
            case 3:
                StrokeParams strokeParams = (StrokeParams) obj2;
                StrokeParams apply2 = (StrokeParams) obj;
                kotlin.jvm.internal.k.f(apply2, "$this$apply");
                apply2.setEnabled(strokeParams.getEnabled());
                apply2.setWidth(strokeParams.getWidth());
                apply2.setSoftness(strokeParams.getSoftness());
                apply2.setIntensity(strokeParams.getIntensity());
                apply2.setSpread(strokeParams.getSpread());
                apply2.setColor(strokeParams.getColor());
                apply2.setLight0X(strokeParams.getLight0X());
                apply2.setLight0Y(strokeParams.getLight0Y());
                apply2.setLight1X(strokeParams.getLight1X());
                apply2.setLight1Y(strokeParams.getLight1Y());
                apply2.setAmbient(strokeParams.getAmbient());
                apply2.setAnisotropicRim(strokeParams.getAnisotropicRim());
                apply2.setEdgeColor(strokeParams.getEdgeColor());
                apply2.setDarkColor(strokeParams.getDarkColor());
                apply2.setDarkWidth(strokeParams.getDarkWidth());
                apply2.setEdgeWidth(strokeParams.getEdgeWidth());
                return rVar;
            case 4:
                InnerShadowParams innerShadowParams = (InnerShadowParams) obj2;
                InnerShadowParams apply3 = (InnerShadowParams) obj;
                kotlin.jvm.internal.k.f(apply3, "$this$apply");
                apply3.setEnabled(innerShadowParams.getEnabled());
                apply3.setColor(innerShadowParams.getColor());
                apply3.setRadius(innerShadowParams.getRadius());
                apply3.setOffsetX(innerShadowParams.getOffsetX());
                apply3.setOffsetY(innerShadowParams.getOffsetY());
                apply3.setIntensity(innerShadowParams.getIntensity());
                return rVar;
            case 5:
                RefractionParams refractionParams = (RefractionParams) obj2;
                RefractionParams apply4 = (RefractionParams) obj;
                kotlin.jvm.internal.k.f(apply4, "$this$apply");
                apply4.setEnabled(refractionParams.getEnabled());
                apply4.setStrength(refractionParams.getStrength());
                apply4.setWidth(refractionParams.getWidth());
                apply4.setDispersion(refractionParams.getDispersion());
                apply4.setDepthEffect(refractionParams.getDepthEffect());
                return rVar;
            case 6:
                BlendParams apply5 = (BlendParams) obj;
                kotlin.jvm.internal.k.f(apply5, "$this$apply");
                apply5.setStages(((BlendParams) obj2).getStages());
                return rVar;
            case 7:
                return obj == ((AbstractC0209a) obj2) ? "(this Collection)" : String.valueOf(obj);
            case 8:
                AbstractC0216h abstractC0216h = (AbstractC0216h) obj2;
                Map.Entry it = (Map.Entry) obj;
                kotlin.jvm.internal.k.f(it, "it");
                StringBuilder sb = new StringBuilder();
                Object key = it.getKey();
                sb.append(key == abstractC0216h ? "(this Map)" : String.valueOf(key));
                sb.append('=');
                Object value = it.getValue();
                sb.append(value != abstractC0216h ? String.valueOf(value) : "(this Map)");
                return sb.toString();
            case 9:
                x9.b bVar = (x9.b) obj2;
                kotlin.jvm.internal.k.f((List) obj, "it");
                return bVar;
            case 10:
                WakeupWordSelectionActivity wakeupWordSelectionActivity = (WakeupWordSelectionActivity) obj2;
                OnBackPressedCallback addCallback = (OnBackPressedCallback) obj;
                int i6 = WakeupWordSelectionActivity.f;
                kotlin.jvm.internal.k.f(addCallback, "$this$addCallback");
                if (wakeupWordSelectionActivity.q()) {
                    com.stepos.statsrpk.d.n("wakeword_select", "cancel");
                }
                wakeupWordSelectionActivity.finish();
                return rVar;
            case 11:
                float fFloatValue = ((Float) obj).floatValue();
                Drawable drawable = (Drawable) ((G6.f) obj2).d;
                if (drawable == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                CrossWindowGlass.setCornerRadius(drawable, fFloatValue);
                return rVar;
            case 12:
                ((C1724q) obj2).U(Boolean.FALSE);
                return rVar;
            case 13:
                ((com.stepos.ability.voicewakeup.training.b) obj2).b.setVisibility(((Boolean) obj).booleanValue() ? 0 : 4);
                return rVar;
            case 14:
                return SnapshotStateObserver.readObserver$lambda$7((SnapshotStateObserver) obj2, obj);
            case 15:
                return PlatformFontVariationSettings_androidKt.toAndroidString$lambda$0((Density) obj2, (FontVariation.Setting) obj);
            case 16:
                return AmbiguousColumnResolver.resolve$lambda$19((Ref$ObjectRef) obj2, (List) obj);
            case 17:
                return CoroutinesRoom.Companion.createFlow$lambda$1((Callable) obj2, (SQLiteConnection) obj);
            case 18:
                return RoomConnectionManager._init_$lambda$1((RoomConnectionManager) obj2, (SupportSQLiteDatabase) obj);
            case 19:
                return RoomDatabase.createConnectionManager$lambda$2((RoomDatabase) obj2, (DatabaseConfiguration) obj);
            case 20:
                return RoomSQLiteQuery.toRoomRawQuery$lambda$1((RoomSQLiteQuery) obj2, (SQLiteStatement) obj);
            case 21:
                return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.setLocale$lambda$10((Locale) obj2, (SupportSQLiteDatabase) obj);
            case 22:
                String it2 = (String) obj;
                kotlin.jvm.internal.k.f(it2, "it");
                return Boolean.valueOf(j9.t.e0(it2, ((com.stepos.ability.screenops.service.b) obj2).f3240a.concat(":"), false));
            case 23:
                return AgentServiceClient.submitToolTask$lambda$0((com.stepos.ability.sdk.client.h) obj2, ((Boolean) obj).booleanValue());
            case 24:
                return AgentServiceClient.submitGuiTask$lambda$0((com.stepos.ability.sdk.client.g) obj2, ((Boolean) obj).booleanValue());
            case 25:
                return AgentServiceClient.submitTooCallEvent$lambda$0((ToolCallEvent) obj2, ((Boolean) obj).booleanValue());
            case 26:
                com.stepos.ability.task.executor.g gVar = (com.stepos.ability.task.executor.g) obj2;
                ProgressNotification progress = (ProgressNotification) obj;
                kotlin.jvm.internal.k.f(progress, "progress");
                Map<String, Object> meta = progress.getMeta();
                String str = (String) (meta != null ? meta.get("key_custom") : null);
                try {
                } catch (Exception e) {
                    Log.w(gVar.getTAG(), "progress is not NotifyAppUIPayload: payloadLen=" + (str != null ? Integer.valueOf(str.length()) : null), e);
                }
                if (new Gson().fromJson(str, com.stepos.ability.task.executor.e.class) == null) {
                    return rVar;
                }
                throw new ClassCastException();
            case 27:
                return BffClient.send$lambda$1((Exception) obj2, (CacheBean) obj);
            case 28:
                return MotionHost.resume$lambda$2((MotionHost) obj2, ((Float) obj).floatValue());
            default:
                return ShaderLoader.resolveIncludes$lambda$1((ShaderLoader) obj2, (InterfaceC1616j) obj);
        }
    }

    public /* synthetic */ Q(Object obj, int i) {
        this.f228a = i;
        this.b = obj;
    }
}

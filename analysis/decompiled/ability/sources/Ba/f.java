package Ba;

import C7.r;
import C9.l;
import C9.o;
import D9.u;
import S7.k;
import android.content.res.Resources;
import android.util.Log;
import android.view.SystemBarStyle;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import androidx.core.view.ViewCompat;
import androidx.sqlite.SQLiteConnection;
import com.stepos.ability.database.dao.AbilityTaskDao_Impl;
import com.stepos.ability.database.dao.AtomicAbilityDao_Impl;
import com.stepos.motionkit.FxConfig;
import com.stepos.motionkit.SurfaceConfig;
import com.stepos.motionkit.SurfacePresentation;
import com.stepos.motionkit.SurfaceRendererType;
import com.stepos.motionkit.fx.material.capability.BlendParams;
import com.stepos.motionkit.fx.material.capability.BlurParams;
import com.stepos.motionkit.fx.material.capability.RefractionParams;
import com.stepos.motionkit.fx.material.capability.StrokeParams;
import com.uxsense.core.parse.PatternResultJsonKt;
import j9.m;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.text.Regex;
import z9.C2199a;

/* loaded from: classes4.dex */
public final /* synthetic */ class f implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f270a;

    public /* synthetic */ f(int i) {
        this.f270a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f270a) {
            case 0:
                kotlin.jvm.internal.k.f((String) obj, "it");
                return new AtomicBoolean(false);
            case 1:
                C2199a buildSerialDescriptor = (C2199a) obj;
                kotlin.jvm.internal.k.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
                C2199a.a(buildSerialDescriptor, "JsonPrimitive", new o(new a(7)));
                C2199a.a(buildSerialDescriptor, "JsonNull", new o(new a(8)));
                C2199a.a(buildSerialDescriptor, "JsonLiteral", new o(new a(9)));
                C2199a.a(buildSerialDescriptor, "JsonObject", new o(new a(10)));
                C2199a.a(buildSerialDescriptor, "JsonArray", new o(new a(11)));
                return r.f317a;
            case 2:
                Map.Entry entry = (Map.Entry) obj;
                kotlin.jvm.internal.k.f(entry, "<destruct>");
                String str = (String) entry.getKey();
                l lVar = (l) entry.getValue();
                StringBuilder sb = new StringBuilder();
                u.a(sb, str);
                sb.append(':');
                sb.append(lVar);
                return sb.toString();
            case 3:
                RefractionParams apply = (RefractionParams) obj;
                kotlin.jvm.internal.k.f(apply, "$this$apply");
                apply.setEnabled(true);
                apply.setStrength(64.0f);
                apply.setWidth(99.0f);
                apply.setDispersion(20.0f);
                apply.setDepthEffect(0.2f);
                return r.f317a;
            case 4:
                BlendParams apply2 = (BlendParams) obj;
                kotlin.jvm.internal.k.f(apply2, "$this$apply");
                apply2.setStages(H4.o.M(new Pair(0, 731486617)));
                return r.f317a;
            case 5:
                BlurParams apply3 = (BlurParams) obj;
                kotlin.jvm.internal.k.f(apply3, "$this$apply");
                apply3.setRadius(30.0f);
                apply3.setTintColor(ViewCompat.MEASURED_SIZE_MASK);
                apply3.setFrost(0.06f);
                return r.f317a;
            case 6:
                StrokeParams apply4 = (StrokeParams) obj;
                kotlin.jvm.internal.k.f(apply4, "$this$apply");
                apply4.setWidth(1.0f);
                apply4.setIntensity(0.18f);
                apply4.setSpread(4.0f);
                apply4.setSoftness(4.0f);
                apply4.setDarkWidth(1.0f);
                apply4.setEdgeWidth(1.0f);
                apply4.setAnisotropicRim(true);
                apply4.setAmbient(1.0f);
                apply4.setEdgeColor(866559654);
                apply4.setDarkColor(866559654);
                double radians = Math.toRadians(270.0d);
                double radians2 = Math.toRadians(45.0d);
                apply4.setLight0X((float) Math.cos(radians));
                apply4.setLight0Y((float) Math.sin(radians));
                apply4.setLight1X((float) Math.cos(radians2));
                apply4.setLight1Y((float) Math.sin(radians2));
                return r.f317a;
            case 7:
                RefractionParams apply5 = (RefractionParams) obj;
                kotlin.jvm.internal.k.f(apply5, "$this$apply");
                apply5.setEnabled(true);
                apply5.setStrength(64.0f);
                apply5.setWidth(99.0f);
                apply5.setDispersion(20.0f);
                apply5.setDepthEffect(0.2f);
                return r.f317a;
            case 8:
                BlendParams apply6 = (BlendParams) obj;
                kotlin.jvm.internal.k.f(apply6, "$this$apply");
                apply6.setStages(H4.o.M(new Pair(0, 731486617)));
                return r.f317a;
            case 9:
                BlurParams apply7 = (BlurParams) obj;
                kotlin.jvm.internal.k.f(apply7, "$this$apply");
                apply7.setRadius(30.0f);
                apply7.setTintColor(ViewCompat.MEASURED_SIZE_MASK);
                apply7.setFrost(0.06f);
                return r.f317a;
            case 10:
                StrokeParams apply8 = (StrokeParams) obj;
                kotlin.jvm.internal.k.f(apply8, "$this$apply");
                apply8.setWidth(1.0f);
                apply8.setIntensity(0.18f);
                apply8.setSpread(4.0f);
                apply8.setSoftness(4.0f);
                apply8.setDarkWidth(1.0f);
                apply8.setEdgeWidth(1.0f);
                apply8.setAnisotropicRim(true);
                apply8.setAmbient(1.0f);
                apply8.setEdgeColor(-2136562010);
                apply8.setDarkColor(866559654);
                double radians3 = Math.toRadians(270.0d);
                double radians4 = Math.toRadians(45.0d);
                apply8.setLight0X((float) Math.cos(radians3));
                apply8.setLight0Y((float) Math.sin(radians3));
                apply8.setLight1X((float) Math.cos(radians4));
                apply8.setLight1Y((float) Math.sin(radians4));
                return r.f317a;
            case 11:
                Throwable it = (Throwable) obj;
                kotlin.jvm.internal.k.f(it, "it");
                return it.getCause();
            case 12:
                Exception error = (Exception) obj;
                kotlin.jvm.internal.k.f(error, "error");
                Log.w("StepOSLiteSheetGlass", "Corner update unavailable; keeping glass material", error);
                return r.f317a;
            case 13:
                Throwable it2 = (Throwable) obj;
                kotlin.jvm.internal.k.f(it2, "it");
                Log.w("TrainingListen", "Listening effect unavailable; training continues", it2);
                return r.f317a;
            case 14:
                SurfaceConfig surface = (SurfaceConfig) obj;
                kotlin.jvm.internal.k.f(surface, "$this$surface");
                surface.setRenderer(SurfaceRendererType.GLES);
                surface.setPresentation(SurfacePresentation.SURFACE_VIEW);
                return r.f317a;
            case 15:
                SurfaceConfig surface2 = (SurfaceConfig) obj;
                kotlin.jvm.internal.k.f(surface2, "$this$surface");
                surface2.setRenderer(SurfaceRendererType.AGSL);
                surface2.setPresentation(SurfacePresentation.SURFACE_VIEW);
                return r.f317a;
            case 16:
                SurfaceConfig surface3 = (SurfaceConfig) obj;
                kotlin.jvm.internal.k.f(surface3, "$this$surface");
                surface3.setRenderer(SurfaceRendererType.AGSL);
                surface3.setPresentation(SurfacePresentation.TEXTURE_VIEW);
                return r.f317a;
            case 17:
                FxConfig start = (FxConfig) obj;
                kotlin.jvm.internal.k.f(start, "$this$start");
                start.surface(new f(14));
                return r.f317a;
            case 18:
                AppFunctionMetadata meta = (AppFunctionMetadata) obj;
                kotlin.jvm.internal.k.f(meta, "meta");
                if (!meta.getIsEnabled()) {
                    androidx.constraintlayout.core.dsl.a.x("AppFunction disabled pkg=", meta.getPackageName(), " functionId=", meta.getId(), "JetpackAppFunctionsCallToolHandler");
                }
                return Boolean.valueOf(meta.getIsEnabled());
            case 19:
                return PatternResultJsonKt.json$lambda$0((C9.g) obj);
            case 20:
                return AbilityTaskDao_Impl.cleanAll$lambda$0("DELETE FROM t_ability_task", (SQLiteConnection) obj);
            case 21:
                return AbilityTaskDao_Impl.loadUnfinishedTasks$lambda$0("SELECT * FROM t_ability_task WHERE status IN ('pending','running')", (SQLiteConnection) obj);
            case 22:
                return AbilityTaskDao_Impl.cleanFinished$lambda$0("DELETE FROM t_ability_task WHERE status IN ('success','failed')", (SQLiteConnection) obj);
            case 23:
                return AtomicAbilityDao_Impl.deleteAll$lambda$0("DELETE FROM t_atomic_ability", (SQLiteConnection) obj);
            case 24:
                return Integer.valueOf(AtomicAbilityDao_Impl.count$lambda$0("SELECT COUNT(*) FROM t_atomic_ability", (SQLiteConnection) obj));
            case 25:
                return AtomicAbilityDao_Impl.getAll$lambda$0("SELECT * FROM t_atomic_ability", (SQLiteConnection) obj);
            case 26:
                return AtomicAbilityDao_Impl.getAllPackageNames$lambda$0("SELECT DISTINCT packageName FROM t_atomic_ability", (SQLiteConnection) obj);
            case 27:
                C9.g Json = (C9.g) obj;
                kotlin.jvm.internal.k.f(Json, "$this$Json");
                Json.f325a = true;
                return r.f317a;
            case 28:
                String part = (String) obj;
                kotlin.jvm.internal.k.f(part, "part");
                String lowerCase = new Regex("(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])|(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)").f(m.I0('.', part, part), "_").toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.k.e(lowerCase, "toLowerCase(...)");
                return lowerCase;
            default:
                return Boolean.valueOf(SystemBarStyle.Companion.light$lambda$2((Resources) obj));
        }
    }
}

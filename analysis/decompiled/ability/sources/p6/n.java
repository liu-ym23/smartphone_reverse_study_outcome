package p6;

import C7.r;
import android.content.Context;
import android.os.Handler;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.stepos.taskrobot.common.ITaskProgressCallback;
import com.stepos.taskrobot.settingsprovider.WhitelistCacheManager;
import f6.AbstractC1436a;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.jvm.internal.Ref$ObjectRef;
import stepai.aios.guiagent.config.GuiAgentConfigKt;

/* loaded from: classes3.dex */
public final /* synthetic */ class n implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5552a = 1;
    public final /* synthetic */ String b;
    public final /* synthetic */ WhitelistCacheManager c;
    public final /* synthetic */ ITaskProgressCallback d;
    public final /* synthetic */ Serializable e;
    public final /* synthetic */ Serializable f;
    public final /* synthetic */ Object g;
    public final /* synthetic */ Object h;

    public /* synthetic */ n(S7.k kVar, Context context, ITaskProgressCallback iTaskProgressCallback, WhitelistCacheManager whitelistCacheManager, String str, String str2, String str3) {
        this.b = str;
        this.e = str2;
        this.f = str3;
        this.g = context;
        this.c = whitelistCacheManager;
        this.d = iTaskProgressCallback;
        this.h = kVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [kotlin.Result$Failure] */
    @Override // S7.a
    public final Object invoke() {
        String strA;
        int i = this.f5552a;
        r rVar = r.f317a;
        Object obj = this.h;
        Object obj2 = this.g;
        Serializable serializable = this.f;
        Serializable serializable2 = this.e;
        String str = this.b;
        switch (i) {
            case 0:
                ((AtomicBoolean) serializable2).set(true);
                Handler handler = p.f5554a;
                p.c(this.c, (WhitelistCacheManager.OnMasterSwitchChangedListener) ((Ref$ObjectRef) serializable).f4920a, (WhitelistCacheManager.OnSafetySettingsDismissedListener) ((Ref$ObjectRef) obj2).f4920a, (Runnable) ((Ref$ObjectRef) obj).f4920a);
                p.f(this.d, str, "用户拒绝Amoo操作手机授权");
                break;
            default:
                String str2 = (String) serializable2;
                String str3 = (String) serializable;
                Context context = (Context) obj2;
                S7.k kVar = (S7.k) obj;
                p.b.set(false);
                try {
                    Gson gson = p.d;
                    JsonObject jsonObject = (JsonObject) gson.fromJson(str, JsonObject.class);
                    if (jsonObject == null) {
                        strA = str;
                    } else {
                        jsonObject.addProperty(GuiAgentConfigKt.META_KEY_APP_NAME, str2);
                        JsonObject asJsonObject = jsonObject.getAsJsonObject("gui_agent_param");
                        if (asJsonObject != null) {
                            asJsonObject.addProperty(GuiAgentConfigKt.META_KEY_APP_NAME, str2);
                        }
                        strA = gson.toJson((JsonElement) jsonObject);
                    }
                } catch (Throwable th) {
                    strA = kotlin.b.a(th);
                }
                Throwable thA = Result.a(strA);
                if (thA != null) {
                    AbstractC1436a.c("SafetyComplianceGuard", "rewriteAppNameInParamsJson failed, fallback to original", thA);
                }
                if (!(strA instanceof Result.Failure)) {
                    str = strA;
                }
                AbstractC1436a.d("SafetyComplianceGuard", B7.a.n("[LOOP-DEBUG] redirect confirmed, proceed with target=", str2, ", taskId=", str3), true);
                Handler handler2 = p.f5554a;
                p.a(context, this.c, str3, str2, str, true, this.d, kVar);
                break;
        }
        return rVar;
    }

    public /* synthetic */ n(ITaskProgressCallback iTaskProgressCallback, WhitelistCacheManager whitelistCacheManager, String str, AtomicBoolean atomicBoolean, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3) {
        this.e = atomicBoolean;
        this.c = whitelistCacheManager;
        this.f = ref$ObjectRef;
        this.g = ref$ObjectRef2;
        this.h = ref$ObjectRef3;
        this.d = iTaskProgressCallback;
        this.b = str;
    }
}

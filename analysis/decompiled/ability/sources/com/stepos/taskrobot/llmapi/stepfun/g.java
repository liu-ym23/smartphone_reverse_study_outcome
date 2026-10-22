package com.stepos.taskrobot.llmapi.stepfun;

import B9.h0;
import C7.r;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import com.stepos.ability.beaninternal.ability.AbilityTask;
import com.stepos.ability.beaninternal.ability.IAbilityExecuteCallback;
import com.stepos.ability.beaninternal.ability.ProgressNotification;
import com.stepos.ability.runtime.model.CoroutinePriorityTask;
import com.stepos.deepbinder.core.cache.CallbackCache;
import com.stepos.motionkit.FxInstance;
import com.stepos.motionkit.fx.FxInstanceImpl;
import com.stepos.motionkit.fx.FxModuleImpl;
import com.stepos.motionkit.fx.material.capability.BlurParams;
import com.stepos.taskrobot.llmapi.stepfun.view.AntiMistouchBubbleView;
import com.stepos.taskrobot.llmapi.stepfun.view.blur.BlurCardView;
import com.zyql.common.utils.update.UpdateManager;
import com.zyql.common.utils.update.UpdateProgressDialog;
import j9.C1617k;
import java.util.Map;
import kotlin.collections.EmptyList;
import org.json.JSONException;
import stepai.aios.guiagent.ability.DefaultGuiAbilityProvider;
import stepai.aios.guiagent.llm.cell.StepGelabModelCell;
import stepai.android.llm.base.log.ILLMLogger;
import stepai.android.mindx.base.LLMInterface;
import stepai.android.mindx.client.config.ConfigsKt;
import u5.C2038b;
import z9.C2199a;

/* loaded from: classes3.dex */
public final /* synthetic */ class g implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4035a;
    public final /* synthetic */ Object b;

    public /* synthetic */ g(Object obj, int i) {
        this.f4035a = i;
        this.b = obj;
    }

    @Override // S7.k
    public final Object invoke(Object obj) throws JSONException {
        boolean z10;
        int i = this.f4035a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                return SystemSdkBridge.init$lambda$0$2((SystemSdkBridge) obj2, (String) obj);
            case 1:
                return AntiMistouchBubbleView.commitBlurIfNeeded$lambda$0((AntiMistouchBubbleView) obj2, (BlurParams) obj);
            case 2:
                return UpdateManager.checkAndDownloadUpdate$lambda$24$lambda$22$lambda$18((UpdateProgressDialog) obj2, ((Integer) obj).intValue());
            case 3:
                return BlurCardView.commitBlurIfNeeded$lambda$0((BlurCardView) obj2, (BlurParams) obj);
            case 4:
                return ((C1617k) obj2).b(((Integer) obj).intValue());
            case 5:
                return Boolean.valueOf(CallbackCache.removeCallback$lambda$6(obj2, (Map.Entry) obj));
            case 6:
                ((com.stepos.ability.permission.cache.a) obj2).e.set(false);
                return r.f317a;
            case 7:
                ((com.stepos.ability.permission.cache.b) obj2).f.set(false);
                return r.f317a;
            case 8:
                return Boolean.valueOf(FxModuleImpl.stop$lambda$2((FxInstance) obj2, (FxInstanceImpl) obj));
            case 9:
                return DefaultGuiAbilityProvider.bitmap2Base64Converter$lambda$0((DefaultGuiAbilityProvider) obj2, (Bitmap) obj);
            case 10:
                return ((StepGelabModelCell) obj2).toJsonValue(obj);
            case 11:
                stepai.android.mindx.client.inner.e eVar = (stepai.android.mindx.client.inner.e) obj2;
                String str = "service changed: " + (((LLMInterface) obj) != null);
                eVar.getClass();
                ILLMLogger.DefaultImpls.printI(eVar, str, ConfigsKt.TAG);
                return r.f317a;
            case 12:
                Point point = (Point) obj2;
                AccessibilityNodeInfo node = (AccessibilityNodeInfo) obj;
                kotlin.jvm.internal.k.f(node, "node");
                Rect rect = new Rect();
                node.getBoundsInScreen(rect);
                boolean zContains = rect.contains(point.x, point.y);
                boolean zIsEditable = node.isEditable();
                boolean zIsEnabled = node.isEnabled();
                boolean zIsFocusable = node.isFocusable();
                N9.j.I("Node check: className=" + ((Object) node.getClassName()) + ", inBounds=" + zContains + ", editable=" + zIsEditable + ", enabled=" + zIsEnabled + ", focusable=" + zIsFocusable, "AccessibilityActionExecutor");
                if (zContains && zIsEditable && zIsEnabled && zIsFocusable) {
                    N9.j.H("Found suitable editable node: " + ((Object) node.getClassName()), "AccessibilityActionExecutor");
                    z10 = true;
                } else {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            case 13:
                return Boolean.valueOf(kotlin.jvm.internal.k.b(((CoroutinePriorityTask) obj).getBaseTask().getTaskCode(), ((AbilityTask) obj2).getTaskCode()));
            case 14:
                CoroutinePriorityTask coroutinePriorityTask = (CoroutinePriorityTask) obj2;
                ProgressNotification progressNotification = (ProgressNotification) obj;
                String jsonString = progressNotification.toJsonString();
                IAbilityExecuteCallback callback = coroutinePriorityTask.getBaseTask().getCallback();
                if (callback != null) {
                    callback.onProgress(coroutinePriorityTask.getBaseTask().getTaskCode(), jsonString);
                }
                Log.i("RuntimeManager", "Receive taskCode: " + coroutinePriorityTask.getBaseTask().getTaskCode() + " progress: " + progressNotification.getProgress());
                return r.f317a;
            case 15:
                String key = (String) obj;
                kotlin.jvm.internal.k.f(key, "key");
                return ((C2038b) obj2).e.baseUrlOf(key);
            case 16:
                x9.c cVar = (x9.c) obj2;
                C2199a buildSerialDescriptor = (C2199a) obj;
                kotlin.jvm.internal.k.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
                C2199a.a(buildSerialDescriptor, "type", h0.b);
                C2199a.a(buildSerialDescriptor, "value", z2.l.m("kotlinx.serialization.Polymorphic<" + cVar.f6883a.m() + '>', z9.i.c, new z9.g[0]));
                EmptyList emptyList = cVar.b;
                kotlin.jvm.internal.k.f(emptyList, "<set-?>");
                buildSerialDescriptor.b = emptyList;
                return r.f317a;
            default:
                z9.h hVar = (z9.h) obj2;
                int iIntValue = ((Integer) obj).intValue();
                return hVar.f[iIntValue] + ": " + hVar.g[iIntValue].h();
        }
    }
}

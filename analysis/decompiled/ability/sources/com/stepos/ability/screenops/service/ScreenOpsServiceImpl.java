package com.stepos.ability.screenops.service;

import D7.w;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.TaskManager;
import com.mdisdk.capability.TagWriteMode;
import com.mdisdk.capability.UiCapabilityManager;
import com.mdisdk.capability.model.RequestInfo;
import com.mdisdk.capability.model.ViewNode;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.capability.request.DisplaySnapshot;
import com.mdisdk.capability.request.UiSnapshot;
import com.stepos.ability.IScreenOpsService;
import com.uxsense.ApexSDK;
import com.uxsense.core.base.parse.KRect;
import com.uxsense.core.base.parse.KViewNode;
import com.uxsense.core.pattern.PatternMatchResult;
import com.uxsense.core.pattern.ViewPattern;
import com.uxsense.core.pattern.ViewTreeMatcher;
import com.uxsense.ruleTrigger.TriggerRule;
import j9.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.C1703V;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/stepos/ability/screenops/service/ScreenOpsServiceImpl;", "Landroid/app/Service;", AppAgent.CONSTRUCT, "()V", "ScreenOpsBinder", "screenops_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ScreenOpsServiceImpl extends Service {
    public static final C1703V b;
    public static final Map c;

    /* renamed from: a, reason: collision with root package name */
    public final ScreenOpsBinder f3231a = new ScreenOpsBinder();

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0082@¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0014\u001a\u00020\u00112\u001c\u0010\u0013\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b\u001d\u0010\u001bJ!\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b!\u0010\"J\u0013\u0010%\u001a\u00020$*\u00020#H\u0002¢\u0006\u0004\b%\u0010&J'\u0010)\u001a\b\u0012\u0004\u0012\u00020#0(2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b)\u0010*J%\u0010/\u001a\u00020.2\u0006\u0010+\u001a\u00020#2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020#0,H\u0002¢\u0006\u0004\b/\u00100J!\u00101\u001a\u00020\u00112\u0006\u0010+\u001a\u00020#2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b1\u00102J\u001f\u00105\u001a\u00020\u00112\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\u0006H\u0002¢\u0006\u0004\b5\u00106J#\u00107\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b7\u00108J\u0019\u00109\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b9\u0010:J\u0019\u0010;\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b;\u0010:R$\u0010<\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006B"}, d2 = {"Lcom/stepos/ability/screenops/service/ScreenOpsServiceImpl$ScreenOpsBinder;", "Lcom/stepos/ability/IScreenOpsService$Stub;", AppAgent.CONSTRUCT, "()V", "Lcom/mdisdk/capability/UiCapabilityManager;", "manager", "", "packageName", "text", "", "x", "y", "", "writeWithAppPolicy", "(Lcom/mdisdk/capability/UiCapabilityManager;Ljava/lang/String;Ljava/lang/String;IILH7/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "LH7/c;", "Landroid/os/Bundle;", "", "block", "runOnWorker", "(LS7/k;)Landroid/os/Bundle;", "targetNode", "performSetText", "(Landroid/os/Bundle;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "targets", "performSetTextBatch", "(Landroid/os/Bundle;LH7/c;)Ljava/lang/Object;", "params", "performGetTextList", "Lcom/mdisdk/capability/request/UiSnapshot;", RequestInfo.FUNCTION_SNAPSHOT, "pkg", "matchPatternTexts", "(Lcom/mdisdk/capability/request/UiSnapshot;Ljava/lang/String;)Ljava/lang/String;", "Lcom/mdisdk/capability/model/ViewNode;", "Lcom/uxsense/core/base/parse/KViewNode;", "toKViewNode", "(Lcom/mdisdk/capability/model/ViewNode;)Lcom/uxsense/core/base/parse/KViewNode;", "filterPkg", "", "findAllEditTexts", "(Lcom/mdisdk/capability/request/UiSnapshot;Ljava/lang/String;)Ljava/util/List;", "node", "", "result", "LC7/r;", "collectEditTexts", "(Lcom/mdisdk/capability/model/ViewNode;Ljava/util/List;)V", "viewNodeToBundle", "(Lcom/mdisdk/capability/model/ViewNode;Ljava/lang/String;)Landroid/os/Bundle;", "code", "message", "resultBundle", "(ILjava/lang/String;)Landroid/os/Bundle;", "setEditContent", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Bundle;", "setEditContentBatch", "(Landroid/os/Bundle;)Landroid/os/Bundle;", "getEditContent", "uiManager", "Lcom/mdisdk/capability/UiCapabilityManager;", "getUiManager", "()Lcom/mdisdk/capability/UiCapabilityManager;", "setUiManager", "(Lcom/mdisdk/capability/UiCapabilityManager;)V", "screenops_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ScreenOpsBinder extends IScreenOpsService.Stub {
        private UiCapabilityManager uiManager;

        private final void collectEditTexts(ViewNode node, List<ViewNode> result) {
            if (!node.isTextEditor()) {
                String className = node.getClassName();
                k.e(className, "getClassName(...)");
                if (!m.h0(className, "Edit", false)) {
                    for (ViewNode viewNode : node.getChildren()) {
                        k.c(viewNode);
                        collectEditTexts(viewNode, result);
                    }
                    return;
                }
            }
            int right = node.getBounds().getRight() - node.getBounds().getLeft();
            int bottom = node.getBounds().getBottom() - node.getBounds().getTop();
            if (right <= 0 || bottom <= 0) {
                return;
            }
            result.add(node);
        }

        private final List<ViewNode> findAllEditTexts(UiSnapshot snapshot, String filterPkg) {
            List<DisplaySnapshot> displays = snapshot.getDisplays();
            List<DisplaySnapshot> list = displays;
            if (list == null || list.isEmpty()) {
                return EmptyList.f4893a;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<DisplaySnapshot> it = displays.iterator();
            while (it.hasNext()) {
                for (WindowStateInfo windowStateInfo : it.next().getAllWindows()) {
                    if (filterPkg == null || k.b(windowStateInfo.getPackageName(), filterPkg)) {
                        ViewNode rootNode = windowStateInfo.getRootNode();
                        if (rootNode != null) {
                            collectEditTexts(rootNode, arrayList);
                        }
                    }
                }
            }
            return arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final String matchPatternTexts(UiSnapshot snapshot, String pkg) throws JSONException {
            ViewNode rootNode;
            if (pkg == null) {
                return "";
            }
            List<DisplaySnapshot> displays = snapshot.getDisplays();
            List<DisplaySnapshot> list = displays;
            if (list == null || list.isEmpty()) {
                return "";
            }
            List<TriggerRule> listListTriggerRules = ApexSDK.listTriggerRules(pkg);
            ArrayList<TriggerRule> arrayList = new ArrayList();
            for (Object obj : listListTriggerRules) {
                TriggerRule triggerRule = (TriggerRule) obj;
                if (triggerRule.isEnabled() && triggerRule.getViewPattern() != null) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            Iterator<DisplaySnapshot> it = displays.iterator();
            while (it.hasNext()) {
                for (WindowStateInfo windowStateInfo : it.next().getAllWindows()) {
                    if (k.b(windowStateInfo.getPackageName(), pkg) && (rootNode = windowStateInfo.getRootNode()) != null) {
                        KViewNode kViewNode = toKViewNode(rootNode);
                        for (TriggerRule triggerRule2 : arrayList) {
                            ViewPattern viewPattern = triggerRule2.getViewPattern();
                            if (viewPattern != null) {
                                List<PatternMatchResult> listMatchAll$default = ViewTreeMatcher.matchAll$default(new ViewTreeMatcher(viewPattern, null, 2, 0 == true ? 1 : 0), kViewNode, false, 2, null);
                                if (!listMatchAll$default.isEmpty()) {
                                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(triggerRule2.getName());
                                    if (jSONArrayOptJSONArray == null) {
                                        jSONArrayOptJSONArray = new JSONArray();
                                        jSONObject.put(triggerRule2.getName(), jSONArrayOptJSONArray);
                                    }
                                    for (PatternMatchResult patternMatchResult : listMatchAll$default) {
                                        JSONObject jSONObject2 = new JSONObject();
                                        for (String str : patternMatchResult.getNodes().keySet()) {
                                            String value = patternMatchResult.getValue(str);
                                            if (value != null && value.length() != 0) {
                                                jSONObject2.put(str, value);
                                            }
                                        }
                                        if (jSONObject2.length() > 0) {
                                            jSONArrayOptJSONArray.put(jSONObject2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (jSONObject.length() == 0) {
                return "";
            }
            String string = jSONObject.toString();
            k.e(string, "toString(...)");
            return string;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object performGetTextList(android.os.Bundle r20, H7.c<? super android.os.Bundle> r21) {
            /*
                Method dump skipped, instructions count: 373
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.screenops.service.ScreenOpsServiceImpl.ScreenOpsBinder.performGetTextList(android.os.Bundle, H7.c):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:33:0x007e A[Catch: Exception -> 0x00ae, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ae, blocks: (B:19:0x003e, B:23:0x0049, B:36:0x0088, B:33:0x007e), top: B:53:0x003e }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0093 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object performSetText(android.os.Bundle r11, java.lang.String r12, H7.c<? super android.os.Bundle> r13) {
            /*
                r10 = this;
                boolean r0 = r13 instanceof com.stepos.ability.screenops.service.ScreenOpsServiceImpl$ScreenOpsBinder$performSetText$1
                if (r0 == 0) goto L14
                r0 = r13
                com.stepos.ability.screenops.service.ScreenOpsServiceImpl$ScreenOpsBinder$performSetText$1 r0 = (com.stepos.ability.screenops.service.ScreenOpsServiceImpl$ScreenOpsBinder$performSetText$1) r0
                int r1 = r0.c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L14
                int r1 = r1 - r2
                r0.c = r1
            L12:
                r7 = r0
                goto L1a
            L14:
                com.stepos.ability.screenops.service.ScreenOpsServiceImpl$ScreenOpsBinder$performSetText$1 r0 = new com.stepos.ability.screenops.service.ScreenOpsServiceImpl$ScreenOpsBinder$performSetText$1
                r0.<init>(r10, r13)
                goto L12
            L1a:
                java.lang.Object r13 = r7.f3234a
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r7.c
                r8 = 0
                r9 = -2
                r2 = 1
                if (r1 == 0) goto L3a
                if (r1 != r2) goto L32
                kotlin.b.b(r13)     // Catch: java.lang.Exception -> L2d
                r1 = r10
                goto L94
            L2d:
                r0 = move-exception
                r11 = r0
                r1 = r10
                goto Lb1
            L32:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L3a:
                kotlin.b.b(r13)
                r13 = r2
                com.mdisdk.capability.UiCapabilityManager r2 = r10.uiManager     // Catch: java.lang.Exception -> Lae
                if (r2 != 0) goto L49
                java.lang.String r11 = "service not ready"
                android.os.Bundle r10 = r10.resultBundle(r9, r11)     // Catch: java.lang.Exception -> L2d
                return r10
            L49:
                java.lang.String r1 = "x"
                int r1 = r11.getInt(r1)     // Catch: java.lang.Exception -> Lae
                java.lang.String r3 = "y"
                int r3 = r11.getInt(r3)     // Catch: java.lang.Exception -> Lae
                java.lang.String r4 = "width"
                int r4 = r11.getInt(r4)     // Catch: java.lang.Exception -> Lae
                java.lang.String r5 = "height"
                int r5 = r11.getInt(r5)     // Catch: java.lang.Exception -> Lae
                int r4 = r4 / 2
                int r1 = r1 + r4
                int r5 = r5 / 2
                int r6 = r3 + r5
                java.lang.String r3 = "packageName"
                java.lang.String r11 = r11.getString(r3)     // Catch: java.lang.Exception -> Lae
                r3 = 0
                if (r11 == 0) goto L7e
                int r4 = r11.length()     // Catch: java.lang.Exception -> L2d
                if (r4 <= 0) goto L78
                goto L79
            L78:
                r11 = r3
            L79:
                if (r11 != 0) goto L7c
                goto L7e
            L7c:
                r3 = r11
                goto L88
            L7e:
                com.mdisdk.observer.ForegroundAppInfo r11 = com.mdisdk.TaskManager.getTopApp(r8)     // Catch: java.lang.Exception -> Lae
                if (r11 == 0) goto L88
                java.lang.String r3 = r11.getPackageName()     // Catch: java.lang.Exception -> L2d
            L88:
                r7.c = r13     // Catch: java.lang.Exception -> Lae
                r4 = r12
                r5 = r1
                r1 = r10
                java.lang.Object r13 = r1.writeWithAppPolicy(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> La3
                if (r13 != r0) goto L94
                return r0
            L94:
                java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch: java.lang.Exception -> La3
                boolean r10 = r13.booleanValue()     // Catch: java.lang.Exception -> La3
                if (r10 == 0) goto La6
                java.lang.String r10 = "success"
                android.os.Bundle r10 = r1.resultBundle(r8, r10)     // Catch: java.lang.Exception -> La3
                return r10
            La3:
                r0 = move-exception
            La4:
                r11 = r0
                goto Lb1
            La6:
                java.lang.String r10 = "setText failed"
                r11 = -3
                android.os.Bundle r10 = r1.resultBundle(r11, r10)     // Catch: java.lang.Exception -> La3
                return r10
            Lae:
                r0 = move-exception
                r1 = r10
                goto La4
            Lb1:
                java.lang.String r10 = "ScreenOpsService"
                java.lang.String r12 = "performSetText failed"
                android.util.Log.e(r10, r12, r11)
                java.lang.String r10 = r11.getMessage()
                java.lang.String r11 = "setText failed: "
                java.lang.String r10 = B7.a.k(r11, r10)
                android.os.Bundle r10 = r1.resultBundle(r9, r10)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.screenops.service.ScreenOpsServiceImpl.ScreenOpsBinder.performSetText(android.os.Bundle, java.lang.String, H7.c):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't wrap try/catch for region: R(9:36|(9:38|(1:41)|(0)|68|44|45|66|46|(1:48)(4:49|50|(0)(0)|54))|43|68|44|45|66|46|(0)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0138, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0139, code lost:
        
            r3 = r7;
            r7 = r2;
            r4 = r9;
            r5 = r10;
            r6 = r12;
            r3 = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0141, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0142, code lost:
        
            r9 = r2;
            r10 = r3;
            r2 = r4;
            r12 = r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0147, code lost:
        
            android.util.Log.e("ScreenOpsService", "performSetTextBatch item " + r3 + " failed", r0);
            r5.add(resultBundle(-2, B7.a.k("setText failed: ", r0.getMessage())));
            r7 = r3;
            r2 = r4;
            r4 = r7;
            r15 = r3;
            r16 = 65534;
            r3 = 65535;
         */
        /* JADX WARN: Path cross not found for [B:43:0x00dd, B:38:0x00d3], limit reached: 68 */
        /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00fb A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00fc  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x010b A[Catch: Exception -> 0x003b, TryCatch #0 {Exception -> 0x003b, blocks: (B:12:0x0036, B:50:0x0103, B:52:0x010b, B:53:0x0115), top: B:64:0x0036 }] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0115 A[Catch: Exception -> 0x003b, TRY_LEAVE, TryCatch #0 {Exception -> 0x003b, blocks: (B:12:0x0036, B:50:0x0103, B:52:0x010b, B:53:0x0115), top: B:64:0x0036 }] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0194  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00fc -> B:50:0x0103). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x017a -> B:61:0x018c). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object performSetTextBatch(android.os.Bundle r18, H7.c<? super android.os.Bundle> r19) {
            /*
                Method dump skipped, instructions count: 421
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.screenops.service.ScreenOpsServiceImpl.ScreenOpsBinder.performSetTextBatch(android.os.Bundle, H7.c):java.lang.Object");
        }

        private final Bundle resultBundle(int code, String message) {
            Bundle bundle = new Bundle();
            bundle.putInt("code", code);
            bundle.putString("message", message);
            return bundle;
        }

        private final Bundle runOnWorker(S7.k block) {
            return (Bundle) AbstractC1683A.r(ScreenOpsServiceImpl.b, new ScreenOpsServiceImpl$ScreenOpsBinder$runOnWorker$1(block, null));
        }

        private final KViewNode toKViewNode(ViewNode viewNode) {
            long jHashCode = viewNode.hashCode();
            String className = viewNode.getClassName();
            String viewId = viewNode.getViewId();
            String contentDescription = viewNode.getContentDescription();
            String text = viewNode.getText();
            List<ViewNode> children = viewNode.getChildren();
            k.e(children, "getChildren(...)");
            List<ViewNode> list = children;
            ArrayList arrayList = new ArrayList(w.c0(list, 10));
            for (ViewNode viewNode2 : list) {
                k.c(viewNode2);
                arrayList.add(toKViewNode(viewNode2));
            }
            return new KViewNode(0, jHashCode, className, viewId, (KRect) null, contentDescription, text, (String) null, (List) arrayList, viewNode.isClickable(), false, false, viewNode.isHorizontalScrollable(), viewNode.isVerticalScrollable(), viewNode.isCheckable(), false, viewNode.getProgress(), viewNode.getProgressMax(), viewNode.getProgressMin(), 128, (e) null);
        }

        private final Bundle viewNodeToBundle(ViewNode node, String packageName) {
            Bundle bundle = new Bundle();
            String viewId = node.getViewId();
            if (viewId == null) {
                viewId = "";
            }
            bundle.putString("viewId", viewId);
            String text = node.getText();
            if (text == null) {
                text = "";
            }
            bundle.putString("text", text);
            String hint = node.getHint();
            if (hint == null) {
                hint = "";
            }
            bundle.putString("hint", hint);
            if (packageName == null) {
                packageName = "";
            }
            bundle.putString("packageName", packageName);
            bundle.putInt("x", node.getBounds().getLeft());
            bundle.putInt("y", node.getBounds().getTop());
            bundle.putInt("width", node.getBounds().getRight() - node.getBounds().getLeft());
            bundle.putInt("height", node.getBounds().getBottom() - node.getBounds().getTop());
            bundle.putBoolean("isFocused", node.isFocused());
            bundle.putBoolean("isEditable", true);
            bundle.putInt("windowId", 0);
            bundle.putInt("nodeHashCode", node.hashCode());
            return bundle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object writeWithAppPolicy(UiCapabilityManager uiCapabilityManager, String str, String str2, int i, int i6, H7.c<? super Boolean> cVar) {
            d dVar = (d) ScreenOpsServiceImpl.c.get(str);
            return dVar == null ? UiCapabilityManager.setTextWithTags$default(uiCapabilityManager, 0, str2, new Integer(i), new Integer(i6), str, null, null, 5000L, cVar, 96, null) : uiCapabilityManager.setTextWithTags(0, str2, 100L, dVar.f3242a, (384 & 16) != 0 ? null : new Integer(i), (384 & 32) != 0 ? null : new Integer(i6), (384 & 64) != 0 ? null : str, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? null : null, (384 & 512) != 0 ? 3000L : 5000L, cVar);
        }

        @Override // com.stepos.ability.IScreenOpsService
        public Bundle getEditContent(Bundle params) {
            return runOnWorker(new ScreenOpsServiceImpl$ScreenOpsBinder$getEditContent$1(this, params, null));
        }

        public final UiCapabilityManager getUiManager() {
            return this.uiManager;
        }

        @Override // com.stepos.ability.IScreenOpsService
        public Bundle setEditContent(Bundle targetNode, String text) {
            return (targetNode == null || text == null) ? resultBundle(-1, "invalid parameters") : runOnWorker(new ScreenOpsServiceImpl$ScreenOpsBinder$setEditContent$1(this, targetNode, text, null));
        }

        @Override // com.stepos.ability.IScreenOpsService
        public Bundle setEditContentBatch(Bundle targets) {
            return targets == null ? resultBundle(-1, "invalid parameters") : runOnWorker(new ScreenOpsServiceImpl$ScreenOpsBinder$setEditContentBatch$1(this, targets, null));
        }

        public final void setUiManager(UiCapabilityManager uiCapabilityManager) {
            this.uiManager = uiCapabilityManager;
        }
    }

    static {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(2);
        k.e(executorServiceNewFixedThreadPool, "newFixedThreadPool(...)");
        b = new C1703V(executorServiceNewFixedThreadPool);
        c = kotlin.collections.a.Q(new Pair("com.dianping.v1", new d(TagWriteMode.HASH_BOUNDARY)));
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f3231a;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        TaskManager.initialize$default(this, false, 2, null);
        Context applicationContext = getApplicationContext();
        k.e(applicationContext, "getApplicationContext(...)");
        this.f3231a.setUiManager(new UiCapabilityManager(applicationContext));
        Log.i("ScreenOpsService", "ScreenOpsServiceImpl created");
    }

    @Override // android.app.Service
    public final void onDestroy() {
        this.f3231a.setUiManager(null);
        super.onDestroy();
        Log.i("ScreenOpsService", "ScreenOpsServiceImpl destroyed");
    }
}

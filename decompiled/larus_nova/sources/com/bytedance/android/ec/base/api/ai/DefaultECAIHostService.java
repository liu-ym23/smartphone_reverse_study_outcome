package com.bytedance.android.ec.base.api.ai;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.base.api.ai.framework.component.BackComponent;
import com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent;
import com.bytedance.android.ec.base.api.ai.framework.model.PanelItem;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\u001dH\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u001dH\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020%H\u0016J&\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00062\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010)H\u0016J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001dH\u0016J<\u0010.\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00062\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00182\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u000202\u0018\u00010)H\u0016¨\u00063"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/DefaultECAIHostService;", "Lcom/bytedance/android/ec/base/api/ai/IECAIHostService;", "()V", "associateSnapshot", "", "snapshotId", "", "messageId", "capture", "request", "Lcom/bytedance/android/ec/base/api/ai/AISnapshotRequest;", "closeApplet", "scene", "createBackComponent", "Lcom/bytedance/android/ec/base/api/ai/framework/component/BackComponent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "createCapsuleComponent", "Lcom/bytedance/android/ec/base/api/ai/framework/component/CapsuleComponent;", "createChatComponent", "Lcom/bytedance/android/ec/base/api/ai/AIChatComponentHandle;", "param", "Lcom/bytedance/android/ec/base/api/ai/AIChatComponentParam;", "getHostActivityStyleRes", "", "", "getMiniAppConfig", "Lcom/bytedance/android/ec/base/api/ai/MiniAppConfig;", "isAIInputDelayAttachEnabled", "", "pageName", "isChatComponentEnabled", "isGoToLandingPage", "isInApplet", "isInAppletAnim", "isLandingPage", "reportLog", "Lcom/bytedance/android/ec/base/api/ai/AIStateLogRequest;", "sendAppletLog", "name", "params", "", "setExcludedFromCapture", "view", "Landroid/view/View;", "excluded", "showAppletPanel", "items", "Lcom/bytedance/android/ec/base/api/ai/framework/model/PanelItem;", "extra", "", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class DefaultECAIHostService implements IECAIHostService {
    public static final DefaultECAIHostService INSTANCE = null;

    private DefaultECAIHostService() {
    }

    @Override // com.bytedance.android.ec.base.api.ai.IECAIHostService
    public void associateSnapshot(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "snapshotId");
        Intrinsics.checkNotNullParameter(r101, "messageId");
    }

    @Override // com.bytedance.android.ec.base.api.ai.IECAIHostService
    public void capture(AISnapshotRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
    }

    @Override // com.bytedance.android.ec.base.api.ai.IECAIHostService
    public void closeApplet(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    @Override // com.bytedance.android.ec.base.api.ai.IECAIHostService
    public BackComponent createBackComponent(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // com.bytedance.android.ec.base.api.ai.IECAIHostService
    public CapsuleComponent createCapsuleComponent(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // com.bytedance.android.ec.base.api.ai.IECAIHostService
    public AIChatComponentHandle createChatComponent(AIChatComponentParam r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        return null;
    }

    @Override // com.bytedance.android.ec.base.api.ai.IECAIHostService
    public MiniAppConfig getMiniAppConfig() {
        return null;
    }

    @Override // com.bytedance.android.ec.base.api.ai.IECAIHostService
    public boolean isAIInputDelayAttachEnabled(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        return false;
    }

    @Override // com.bytedance.android.ec.base.api.ai.IECAIHostService
    public boolean isChatComponentEnabled(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        return false;
    }

    @Override // com.bytedance.android.ec.base.api.ai.IECAIHostService
    public boolean isGoToLandingPage() {
        return false;
    }

    @Override // com.bytedance.android.ec.base.api.ai.IECAIHostService
    public boolean isInApplet() {
        return false;
    }

    @Override // com.bytedance.android.ec.base.api.ai.IECAIHostService
    public boolean isInAppletAnim() {
        return false;
    }

    @Override // com.bytedance.android.ec.base.api.ai.IECAIHostService
    public boolean isLandingPage() {
        return false;
    }

    @Override // com.bytedance.android.ec.base.api.ai.IECAIHostService
    public void reportLog(AIStateLogRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
    }

    @Override // com.bytedance.android.ec.base.api.ai.IECAIHostService
    public void sendAppletLog(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
    }

    @Override // com.bytedance.android.ec.base.api.ai.IECAIHostService
    public void setExcludedFromCapture(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // com.bytedance.android.ec.base.api.ai.IECAIHostService
    public void showAppletPanel(Context r100, String r101, List<PanelItem> r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "items");
    }

    static {
        INSTANCE = new DefaultECAIHostService();
    }

    @Override // com.bytedance.android.ec.base.api.ai.IECAIHostService
    public List<Integer> getHostActivityStyleRes() {
        return new ArrayList();
    }

    @Override // com.bytedance.android.ec.base.api.ai.IECAIHostService
    public void applyHostStyle(Activity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "pageName");
        IECAIHostService.b.a(this, r100, r101);
    }
}

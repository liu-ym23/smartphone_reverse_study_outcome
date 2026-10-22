package com.bytedance.android.shopping.anchorv4.ai;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.base.api.ai.ECAIConstants;
import com.bytedance.android.ec.base.api.ai.GuiContext;
import com.bytedance.android.ec.base.api.ai.GuiView;
import com.bytedance.android.ec.base.api.ai.conversation.ConversationConstants;
import com.bytedance.android.ec.base.api.ai.conversation.ConversationContext;
import com.bytedance.android.ec.base.api.ai.conversation.ConversationContextStore;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class s implements xe.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k0 f165683a;

    @Override // xe.c
    public final String getPageName() {
        return ECAIConstants.SCENE_ECOM_PRODUCT;
    }

    @Override // xe.c
    public final Integer getSource() {
        return 1;
    }

    @Override // xe.c
    public final String b() {
        return this.f165683a.b();
    }

    @Override // xe.c
    public final boolean c() {
        FragmentActivity r100 = this.f165683a.getActivity();
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        ConversationContextStore r102 = ConversationContextStore.f42797b;
        monitor-enter(r102);
        Intrinsics.checkNotNullParameter(r100, "activity");     // Catch: Throwable -> L12
        ConversationContextStore.a r103 = ConversationContextStore.b(r100);     // Catch: Throwable -> L12
        if (r103 == null) goto L10;
        r101 = r103.f42799b.f42803d;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r102);
        return r101;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // xe.c
    public final String m() {
        ConversationContext r100 = this.f165683a.h();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getOriginMessageId();
    }

    @Override // xe.c
    public final Map<String, String> getExtra() {
        return xe.c.a.a();
    }

    @Override // xe.c
    public final Map<String, String> getLogExtra() {
        Map r100 = xe.c.a.b();
        if (r100 == null) goto L6;
        Map<String, String> r101 = MapsKt.toMutableMap(r100);
        if (r101 == null) goto L6;
    L7:
        ConversationContext r102 = this.f165683a.h();
        if (r102 == null) goto L10;
        String r103 = r102.getOriginBcmId();
    L11:
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        r101.put(ConversationConstants.KEY_ORIGIN_BCM_ID, r103);
        return r101;
    L10:
        r103 = null;
    L6:
        r101 = new LinkedHashMap();
        goto L7
    }

    public s(k0 r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        this.f165683a = r100;
    }

    @Override // xe.c
    public final GuiContext a(Map<String, String> r110) {
        Intrinsics.checkNotNullParameter(r110, "extra");
        return new GuiContext(ECAIConstants.SCENE_ECOM_PRODUCT, null, null, null, new GuiView(this.f165683a.d()), 14, null);
    }
}

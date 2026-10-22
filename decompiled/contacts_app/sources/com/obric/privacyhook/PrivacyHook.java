package com.obric.privacyhook;

import android.app.assist.AssistContent;
import android.content.Intent;
import android.os.Bundle;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.privacy.PrivacyUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.This;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: PrivacyHook.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\b\u0010\u000e\u001a\u00020\u0004H\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0007J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\b\u0010\u0014\u001a\u00020\u0004H\u0007¨\u0006\u0015"}, d2 = {"Lcom/obric/privacyhook/PrivacyHook;", "", "()V", "finish", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onPause", "onPostCreate", "onPostResume", "onProvideAssistContent", "outContent", "Landroid/app/assist/AssistContent;", "onResume", "onStart", "onStop", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PrivacyHook {
    public static final PrivacyHook INSTANCE = null;

    static {
        INSTANCE = new PrivacyHook();
    }

    public PrivacyHook() {
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public final void onCreate(Bundle r1) {
        Object r0 = This.get();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        LifeHookActivity r2 = (LifeHookActivity) r0;
        if (r2.isPrivacyOk() == true) goto L6;
        r2.onCreateWhenPrivacyNotOk(null);
        r2.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        Origin.callVoid();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onPostCreate")
    public final void onPostCreate(Bundle r2) {
        Object r1 = This.get();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        LifeHookActivity r3 = (LifeHookActivity) r1;
        if (r3.isPrivacyOk() == true) goto L6;
        r3.onSuperPostCreate(r2);
        return;
    L6:
        Origin.callVoid();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStart")
    public final void onStart() {
        Object r1 = This.get();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        LifeHookActivity r2 = (LifeHookActivity) r1;
        if (r2.isPrivacyOk() == true) goto L6;
        r2.onSuperStart();
        return;
    L6:
        Origin.callVoid();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onResume")
    public final void onResume() {
        Object r1 = This.get();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        LifeHookActivity r2 = (LifeHookActivity) r1;
        if (r2.isPrivacyOk() == true) goto L6;
        r2.onSuperResume();
        return;
    L6:
        Origin.callVoid();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onPostResume")
    public final void onPostResume() {
        Object r1 = This.get();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        LifeHookActivity r2 = (LifeHookActivity) r1;
        if (r2.isPrivacyOk() == true) goto L6;
        r2.onSuperPostResume();
        return;
    L6:
        Origin.callVoid();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onPause")
    public final void onPause() {
        Object r1 = This.get();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        LifeHookActivity r2 = (LifeHookActivity) r1;
        if (r2.isPrivacyOk() == true) goto L6;
        r2.onSuperPause();
        return;
    L6:
        Origin.callVoid();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public final void onStop() {
        Object r1 = This.get();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        LifeHookActivity r2 = (LifeHookActivity) r1;
        if (r2.isPrivacyOk() == true) goto L6;
        r2.onSuperStop();
        return;
    L6:
        Origin.callVoid();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onDestroy")
    public final void onDestroy() {
        Object r1 = This.get();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        LifeHookActivity r2 = (LifeHookActivity) r1;
        if (r2.isPrivacyOk() == true) goto L6;
        r2.onSuperDestroy();
        return;
    L6:
        Origin.callVoid();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("finish")
    public final void finish() {
        Object r1 = This.get();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        LifeHookActivity r2 = (LifeHookActivity) r1;
        if (r2.isPrivacyOk() == true) goto L6;
        r2.superFinish();
        return;
    L6:
        Origin.callVoid();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onNewIntent")
    public final void onNewIntent(Intent r2) {
        Object r1 = This.get();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        LifeHookActivity r3 = (LifeHookActivity) r1;
        if (r3.isPrivacyOk() == true) goto L6;
        r3.onNewIntentWhenPrivacyNotOk(null);
        r3.superOnNewIntent(r2);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        Origin.callVoid();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onProvideAssistContent")
    public final void onProvideAssistContent(AssistContent r2) {
        Intrinsics.checkNotNullParameter(r2, "outContent");
        Object r1 = This.get();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        LifeHookActivity r3 = (LifeHookActivity) r1;
        if (r3.isPrivacyOk() == true) goto L6;
        r3.superOnProvideAssistContent(r2);
        return;
    L6:
        Origin.callVoid();
    }
}

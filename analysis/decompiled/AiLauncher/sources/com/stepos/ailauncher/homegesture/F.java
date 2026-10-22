package com.stepos.ailauncher.homegesture;

import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import com.stepos.ailauncher.contract.api.homegesture.HomeDismissReason;
import com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant;
import com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle;
import com.stepos.ailauncher.contract.api.homegesture.HomeRootToken;
import com.stepos.ailauncher.contract.api.homegesture.HomeSharedOffsetExitParticipant;
import com.stepos.ailauncher.contract.api.homegesture.HomeTopKind;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.sheet.SheetLaunchOptions;
import io.ktor.sse.ServerSentEventKt;
import java.lang.ref.WeakReference;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00020\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u001b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010!\u001a\u00020 8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/stepos/ailauncher/homegesture/F;", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeLayerHandle;", "Lcom/stepos/ailauncher/sheet/O;", "activity", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "rootToken", "<init>", "(Lcom/stepos/ailauncher/sheet/O;Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;)V", "", "isShowing", "()Z", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeDismissReason;", "reason", DidiCardProvider.ACTION_DISMISS, "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeDismissReason;)Z", "suspendForPeek", "resumeAfterPeek", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeGroupExitParticipant;", "homeGroupExitParticipant", "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeGroupExitParticipant;", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "getRootToken", "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "ref", "Ljava/lang/ref/WeakReference;", "", "layerId", "Ljava/lang/String;", "getLayerId", "()Ljava/lang/String;", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;", "kind", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;", "getKind", "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;", "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class F implements HomeLayerHandle {
    private final HomeTopKind kind;
    private final String layerId;
    private final WeakReference<com.stepos.ailauncher.sheet.O> ref;
    private final HomeRootToken rootToken;

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"com/stepos/ailauncher/homegesture/F$a", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeSharedOffsetExitParticipant;", "", "isShowing", "()Z", "prepareForHomeGroupExit", "", "positionPx", "progress", "LY8/t;", "applyHomeGroupExit", "(FF)V", "prepareSharedOffsetExit", "()Ljava/lang/Float;", "offsetPx", "applySharedOffsetExit", "finishHomeGroupExit", "()V", "cancelHomeGroupExit", "", "participantId", "Ljava/lang/String;", "getParticipantId", "()Ljava/lang/String;", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "getVisualStackRootToken", "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "visualStackRootToken", "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements HomeSharedOffsetExitParticipant {
        private final String participantId;

        public a() {
            this.participantId = F.this.getLayerId();
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
        public void applyHomeGroupExit(float positionPx, float progress) {
            com.stepos.ailauncher.sheet.O o10 = (com.stepos.ailauncher.sheet.O) F.this.ref.get();
            if (o10 != null) {
                o10.D0(positionPx, progress);
            }
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeSharedOffsetExitParticipant
        public void applySharedOffsetExit(float offsetPx, float progress) {
            com.stepos.ailauncher.sheet.O o10 = (com.stepos.ailauncher.sheet.O) F.this.ref.get();
            if (o10 != null) {
                o10.P0(offsetPx, progress);
            }
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
        public void cancelHomeGroupExit() {
            com.stepos.ailauncher.sheet.O o10 = (com.stepos.ailauncher.sheet.O) F.this.ref.get();
            if (o10 != null) {
                o10.T0();
            }
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
        public void finishHomeGroupExit() {
            com.stepos.ailauncher.sheet.O o10 = (com.stepos.ailauncher.sheet.O) F.this.ref.get();
            if (o10 != null) {
                o10.H1();
            }
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
        public String getParticipantId() {
            return this.participantId;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
        public HomeRootToken getVisualStackRootToken() {
            com.stepos.ailauncher.sheet.O o10 = (com.stepos.ailauncher.sheet.O) F.this.ref.get();
            if (o10 != null) {
                return HomeRootToken.INSTANCE.fromWire(SheetLaunchOptions.INSTANCE.d(o10.getIntent()));
            }
            return null;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
        public boolean isShowing() {
            com.stepos.ailauncher.sheet.O o10;
            Window window;
            View decorView;
            return (!F.this.isShowing() || (o10 = (com.stepos.ailauncher.sheet.O) F.this.ref.get()) == null || (window = o10.getWindow()) == null || (decorView = window.getDecorView()) == null || o10.getHiddenForRecentsPeek() || decorView.getVisibility() != 0 || decorView.getAlpha() < 0.08f) ? false : true;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
        public boolean prepareForHomeGroupExit() {
            com.stepos.ailauncher.sheet.O o10 = (com.stepos.ailauncher.sheet.O) F.this.ref.get();
            if (o10 == null || o10.isFinishing() || o10.isDestroyed()) {
                return false;
            }
            return o10.r3();
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeSharedOffsetExitParticipant
        public Float prepareSharedOffsetExit() {
            com.stepos.ailauncher.sheet.O o10 = (com.stepos.ailauncher.sheet.O) F.this.ref.get();
            if (o10 != null) {
                return o10.s3();
            }
            return null;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeSharedOffsetExitParticipant
        public /* bridge */ void startSharedOffsetExit(InterfaceC5063a<Y8.t> interfaceC5063a, InterfaceC5063a<Y8.t> interfaceC5063a2) {
            super.startSharedOffsetExit(interfaceC5063a, interfaceC5063a2);
        }
    }

    public F(com.stepos.ailauncher.sheet.O activity, HomeRootToken rootToken) {
        kotlin.jvm.internal.p.i(activity, "activity");
        kotlin.jvm.internal.p.i(rootToken, "rootToken");
        this.rootToken = rootToken;
        this.ref = new WeakReference<>(activity);
        this.layerId = "sheet:" + activity.getClass().getName() + ServerSentEventKt.COLON + System.identityHashCode(activity);
        this.kind = HomeTopKind.SHEET;
    }

    public static final void d(com.stepos.ailauncher.sheet.O o10, F f10) {
        if (o10.isFinishing() || o10.isDestroyed()) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            o10.g1();
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public static final void e(F f10) {
        com.stepos.ailauncher.sheet.O o10 = f10.ref.get();
        if (o10 == null || o10.isFinishing() || o10.isDestroyed() || !o10.getHiddenForRecentsPeek()) {
            return;
        }
        o10.O0();
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle
    public boolean dismiss(HomeDismissReason reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        final com.stepos.ailauncher.sheet.O o10 = this.ref.get();
        if (o10 == null || o10.isFinishing() || o10.isDestroyed()) {
            return false;
        }
        o10.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.homegesture.E
            @Override // java.lang.Runnable
            public final void run() {
                F.d(o10, this);
            }
        });
        return true;
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle
    public HomeTopKind getKind() {
        return this.kind;
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle
    public String getLayerId() {
        return this.layerId;
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle
    public HomeRootToken getRootToken() {
        return this.rootToken;
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle
    public HomeGroupExitParticipant homeGroupExitParticipant() {
        return new a();
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle
    public boolean isShowing() {
        com.stepos.ailauncher.sheet.O o10 = this.ref.get();
        if (o10 == null || o10.isFinishing() || o10.isDestroyed()) {
            return false;
        }
        return !o10.getHiddenForRecentsPeek();
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle
    public boolean resumeAfterPeek() throws Resources.NotFoundException {
        com.stepos.ailauncher.sheet.O o10 = this.ref.get();
        if (o10 == null || o10.isFinishing() || o10.isDestroyed()) {
            return false;
        }
        o10.E3();
        return true;
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle
    public boolean suspendForPeek() {
        com.stepos.ailauncher.sheet.O o10 = this.ref.get();
        if (o10 == null || o10.isFinishing() || o10.isDestroyed()) {
            return false;
        }
        if (o10.getHiddenForRecentsPeek()) {
            Window window = o10.getWindow();
            if (window != null) {
                window.addFlags(16);
            }
            o10.O0();
            return true;
        }
        Window window2 = o10.getWindow();
        if (window2 == null) {
            return false;
        }
        View decorView = window2.getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        o10.R0();
        window2.addFlags(16);
        decorView.animate().cancel();
        if (decorView.getVisibility() != 0) {
            decorView.setVisibility(0);
        }
        if (decorView.getAlpha() <= 0.01f) {
            decorView.setAlpha(1.0f);
        }
        decorView.animate().alpha(0.0f).setDuration(180L).withEndAction(new Runnable() { // from class: com.stepos.ailauncher.homegesture.D
            @Override // java.lang.Runnable
            public final void run() {
                F.e(this.f27425a);
            }
        }).start();
        return true;
    }
}

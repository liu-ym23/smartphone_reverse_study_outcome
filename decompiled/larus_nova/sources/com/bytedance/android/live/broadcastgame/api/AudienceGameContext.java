package com.bytedance.android.live.broadcastgame.api;

import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000  2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0011¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/AudienceGameContext;", "Lcom/bytedance/android/live/broadcastgame/api/InteractGameContext;", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/live/broadcastgame/api/model/r;", "currentGame$delegate", "Lcom/bytedance/live/datacontext/p;", "getCurrentGame", "()Lcom/bytedance/live/datacontext/n;", "currentGame", "Lcom/bytedance/android/live/broadcastgame/api/model/h;", "anchorCurrentGameIconInfo$delegate", "getAnchorCurrentGameIconInfo", "anchorCurrentGameIconInfo", "Lcom/bytedance/live/datacontext/m;", "", "openInteractGameIconShouldShow$delegate", "getOpenInteractGameIconShouldShow", "()Lcom/bytedance/live/datacontext/m;", "openInteractGameIconShouldShow", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ExtendedToolbarButton$c;", "openInteractGameIcon$delegate", "getOpenInteractGameIcon", "openInteractGameIcon", "Lcom/bytedance/android/live/broadcastgame/api/openplatform/a;", "gameIntroCardInfo$delegate", "getGameIntroCardInfo", "gameIntroCardInfo", "disableEntrance$delegate", "getDisableEntrance", "disableEntrance", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceGameContext extends InteractGameContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p anchorCurrentGameIconInfo$delegate;
    private final p currentGame$delegate;
    private final p disableEntrance$delegate;
    private final p gameIntroCardInfo$delegate;
    private final p openInteractGameIcon$delegate;
    private final p openInteractGameIconShouldShow$delegate;

    public static final class a {
        @JvmStatic
        public static AudienceGameContext a() {
            return (AudienceGameContext) com.bytedance.live.datacontext.d.e(InteractGameContext.CONTEXT_KEY, AudienceGameContext.class);
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(AudienceGameContext.class, "currentGame", "getCurrentGame()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AudienceGameContext.class, "anchorCurrentGameIconInfo", "getAnchorCurrentGameIconInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AudienceGameContext.class, "openInteractGameIconShouldShow", "getOpenInteractGameIconShouldShow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AudienceGameContext.class, "openInteractGameIcon", "getOpenInteractGameIcon()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AudienceGameContext.class, "gameIntroCardInfo", "getGameIntroCardInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AudienceGameContext.class, "disableEntrance", "getDisableEntrance()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final AudienceGameContext getGameContext() {
        Companion.getClass();
        return a.a();
    }

    public final n<com.bytedance.android.live.broadcastgame.api.model.h> getAnchorCurrentGameIconInfo() {
        return (n) this.anchorCurrentGameIconInfo$delegate.a(this, $$delegatedProperties[1]);
    }

    public final n<r> getCurrentGame() {
        return (n) this.currentGame$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<Boolean> getDisableEntrance() {
        return (m) this.disableEntrance$delegate.a(this, $$delegatedProperties[5]);
    }

    public final n<com.bytedance.android.live.broadcastgame.api.openplatform.a> getGameIntroCardInfo() {
        return (n) this.gameIntroCardInfo$delegate.a(this, $$delegatedProperties[4]);
    }

    public final n<ExtendedToolbarButton.c> getOpenInteractGameIcon() {
        return (n) this.openInteractGameIcon$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<Boolean> getOpenInteractGameIconShouldShow() {
        return (m) this.openInteractGameIconShouldShow$delegate.a(this, $$delegatedProperties[2]);
    }

    public AudienceGameContext() {
        this.currentGame$delegate = q.c(this);
        this.anchorCurrentGameIconInfo$delegate = q.c(this);
        Boolean r100 = Boolean.FALSE;
        this.openInteractGameIconShouldShow$delegate = q.d(this, r100);
        this.openInteractGameIcon$delegate = q.c(this);
        this.gameIntroCardInfo$delegate = q.c(this);
        this.disableEntrance$delegate = q.d(this, r100);
    }
}

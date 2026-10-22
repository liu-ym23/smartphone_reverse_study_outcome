package com.bytedance.android.live.openplatform.api.minigame.datacontext;

import android.graphics.Rect;
import com.bytedance.android.live.broadcast.api.model.OpenPlatformMgInfoModel;
import com.bytedance.android.live.broadcastgame.api.model.c0;
import com.bytedance.android.live.openplatform.api.model.datacontext.OpenPlatformDataContext;
import com.bytedance.android.livesdk.config.c90;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 42\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b2\u00103R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0015R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007R1\u0010 \u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001d0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007R)\u0010$\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010\u00120\u00120\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0015R!\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0005\u001a\u0004\b'\u0010\u0015R!\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010\u0015R!\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0005\u001a\u0004\b-\u0010\u0015R!\u00101\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0005\u001a\u0004\b0\u0010\u0015¨\u00066"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/minigame/datacontext/AnchorMiniGameDataContext;", "Lcom/bytedance/android/live/openplatform/api/minigame/datacontext/MiniGameDataContext;", "Lcom/bytedance/live/datacontext/n;", "", "liveType$delegate", "Lcom/bytedance/live/datacontext/p;", "getLiveType", "()Lcom/bytedance/live/datacontext/n;", "liveType", "Lcom/bytedance/android/live/broadcast/api/model/OpenPlatformMgInfoModel;", "openPlatformMg$delegate", "getOpenPlatformMg", "openPlatformMg", "Lcom/bytedance/android/live/broadcastgame/api/model/c0;", "microGameInfo$delegate", "getMicroGameInfo", "microGameInfo", "Lcom/bytedance/live/datacontext/m;", "", "supportChangeMount$delegate", "getSupportChangeMount", "()Lcom/bytedance/live/datacontext/m;", "supportChangeMount", "openFeatureBinderId$delegate", "getOpenFeatureBinderId", "openFeatureBinderId", "firstMountGameId$delegate", "getFirstMountGameId", "firstMountGameId", "Lkotlin/Pair;", "sourceFromDetailPage$delegate", "getSourceFromDetailPage", "sourceFromDetailPage", "kotlin.jvm.PlatformType", "openCamera$delegate", "getOpenCamera", "openCamera", "Landroid/graphics/Rect;", "littleWindowRect$delegate", "getLittleWindowRect", "littleWindowRect", "openInteractPanel$delegate", "getOpenInteractPanel", "openInteractPanel", "openAudiencePanel$delegate", "getOpenAudiencePanel", "openAudiencePanel", "openLynxPanelInGame$delegate", "getOpenLynxPanelInGame", "openLynxPanelInGame", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorMiniGameDataContext extends MiniGameDataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p firstMountGameId$delegate;
    private final p littleWindowRect$delegate;
    private final p liveType$delegate;
    private final p microGameInfo$delegate;
    private final p openAudiencePanel$delegate;
    private final p openCamera$delegate;
    private final p openFeatureBinderId$delegate;
    private final p openInteractPanel$delegate;
    private final p openLynxPanelInGame$delegate;
    private final p openPlatformMg$delegate;
    private final p sourceFromDetailPage$delegate;
    private final p supportChangeMount$delegate;

    public static final class a {
        @JvmStatic
        public static AnchorMiniGameDataContext a() {
            OpenPlatformDataContext.Companion.getClass();
            return (AnchorMiniGameDataContext) OpenPlatformDataContext.a.a(AnchorMiniGameDataContext.class);
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(AnchorMiniGameDataContext.class, "liveType", "getLiveType()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorMiniGameDataContext.class, "openPlatformMg", "getOpenPlatformMg()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorMiniGameDataContext.class, "microGameInfo", "getMicroGameInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorMiniGameDataContext.class, "supportChangeMount", "getSupportChangeMount()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorMiniGameDataContext.class, "openFeatureBinderId", "getOpenFeatureBinderId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorMiniGameDataContext.class, "firstMountGameId", "getFirstMountGameId()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorMiniGameDataContext.class, "sourceFromDetailPage", "getSourceFromDetailPage()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorMiniGameDataContext.class, "openCamera", "getOpenCamera()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorMiniGameDataContext.class, "littleWindowRect", "getLittleWindowRect()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorMiniGameDataContext.class, "openInteractPanel", "getOpenInteractPanel()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorMiniGameDataContext.class, "openAudiencePanel", "getOpenAudiencePanel()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorMiniGameDataContext.class, "openLynxPanelInGame", "getOpenLynxPanelInGame()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final AnchorMiniGameDataContext getShared() {
        Companion.getClass();
        return a.a();
    }

    public final n<String> getFirstMountGameId() {
        return (n) this.firstMountGameId$delegate.a(this, $$delegatedProperties[5]);
    }

    public final m<Rect> getLittleWindowRect() {
        return (m) this.littleWindowRect$delegate.a(this, $$delegatedProperties[8]);
    }

    public final n<String> getLiveType() {
        return (n) this.liveType$delegate.a(this, $$delegatedProperties[0]);
    }

    public final n<c0> getMicroGameInfo() {
        return (n) this.microGameInfo$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Boolean> getOpenAudiencePanel() {
        return (m) this.openAudiencePanel$delegate.a(this, $$delegatedProperties[10]);
    }

    public final m<Boolean> getOpenCamera() {
        return (m) this.openCamera$delegate.a(this, $$delegatedProperties[7]);
    }

    public final m<String> getOpenFeatureBinderId() {
        return (m) this.openFeatureBinderId$delegate.a(this, $$delegatedProperties[4]);
    }

    public final m<Boolean> getOpenInteractPanel() {
        return (m) this.openInteractPanel$delegate.a(this, $$delegatedProperties[9]);
    }

    public final m<Boolean> getOpenLynxPanelInGame() {
        return (m) this.openLynxPanelInGame$delegate.a(this, $$delegatedProperties[11]);
    }

    public final n<OpenPlatformMgInfoModel> getOpenPlatformMg() {
        return (n) this.openPlatformMg$delegate.a(this, $$delegatedProperties[1]);
    }

    public final n<Pair<String, String>> getSourceFromDetailPage() {
        return (n) this.sourceFromDetailPage$delegate.a(this, $$delegatedProperties[6]);
    }

    public final m<Boolean> getSupportChangeMount() {
        return (m) this.supportChangeMount$delegate.a(this, $$delegatedProperties[3]);
    }

    public AnchorMiniGameDataContext() {
        this.liveType$delegate = q.c(this);
        this.openPlatformMg$delegate = q.c(this);
        this.microGameInfo$delegate = q.c(this);
        Boolean r100 = Boolean.FALSE;
        this.supportChangeMount$delegate = q.d(this, r100);
        this.openFeatureBinderId$delegate = q.d(this, "");
        this.firstMountGameId$delegate = q.c(this);
        this.sourceFromDetailPage$delegate = q.c(this);
        this.openCamera$delegate = q.d(this, c90.f119929a.getValue());
        this.littleWindowRect$delegate = q.d(this, new Rect());
        this.openInteractPanel$delegate = q.d(this, r100);
        this.openAudiencePanel$delegate = q.d(this, r100);
        this.openLynxPanelInGame$delegate = q.d(this, r100);
    }
}

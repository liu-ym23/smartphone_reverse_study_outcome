package com.obric.autogui.common.api.space.vd;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.display.SurfaceChangeable;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.BaseDisplayOperatingSpace;
import com.obric.autogui.common.api.space.handusing.HandUsingConfigResult;
import com.obric.autogui.common.api.space.handusing.HandUsingEventsCallback;
import com.obric.autogui.common.api.space.monitor.DisplayHost;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.h;
import d.h.b.o;
import d.x;
import kotlinx.coroutines.f.a;

/* JADX INFO: compiled from: VDSpace.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VDSpace extends BaseDisplayOperatingSpace {
    public static final Companion Companion = null;
    private static final String TAG = "VD/Space";
    private final String logTag;
    private final Surface mBackgroundSurface;
    private final SurfaceTexture mBackgroundTexture;
    private final String spaceId;
    private final AOOperatingSpace.SpaceType type;

    /* JADX INFO: compiled from: VDSpace.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.space.vd.VDSpace$destroyVD$1, reason: invalid class name */
    /* JADX INFO: compiled from: VDSpace.kt */
    @f(b = "VDSpace.kt", c = {82}, d = "destroyVD", e = "com.obric.autogui.common.api.space.vd.VDSpace")
    static final class AnonymousClass1 extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ VDSpace this$0;

        AnonymousClass1(VDSpace r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.destroyVD((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public VDSpace(DisplayAccessor r4) {
        DisplayAccessor r5 = (DisplayAccessor) ZeusTransformUtils.wrapperContextForParams(r4, DisplayAccessor.class, "com.obric.aiagent.plugin");
        o.e(r5, "displayAccessor");
        super(r5);
        this.logTag = TAG;
        this.spaceId = "VDS." + r5.getDisplayId();
        this.type = AOOperatingSpace.SpaceType.VirtualDisplay;
        SurfaceTexture r0 = new SurfaceTexture(false);
        this.mBackgroundTexture = r0;
        Surface r2 = new Surface(r0);
        this.mBackgroundSurface = r2;
        initializeDisplaySpace();
        if (ZeusTransformUtils.instanceOf(r5, SurfaceChangeable.class) == false) goto L6;
        ((SurfaceChangeable) ZeusTransformUtils.preCheckCast(r5, SurfaceChangeable.class, "com.obric.aiagent.plugin")).setSurface(r2);
        return;
    }

    @Override // com.obric.autogui.common.api.space.BaseDisplayOperatingSpace
    public String getLogTag() {
        return this.logTag;
    }

    @Override // com.obric.autogui.common.api.space.AOOperatingSpace
    public String getSpaceId() {
        return this.spaceId;
    }

    @Override // com.obric.autogui.common.api.space.AOOperatingSpace
    public AOOperatingSpace.SpaceType getType() {
        return this.type;
    }

    @Override // com.obric.autogui.common.api.space.AOOperatingSpace
    public a getLock() {
        return VDSpaceManager.INSTANCE.getVDLock();
    }

    public final Object destroyVD(d.c.d<? super x> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r7, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = b.a();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        VDSpace this = (VDSpace) ZeusTransformUtils.preCheckCast(r0.L$0, VDSpace.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
    L17:
        this.mBackgroundTexture.release();
        this.mBackgroundSurface.release();
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r8);
        stopHandUsingSession();
        DisplayAccessor r9 = getDisplayAccessor();
        r0.L$0 = this;
        r0.label = 1;
        if (r9.destroy(r0) != r2) goto L17;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r7);
        goto L8
    }

    @Override // com.obric.autogui.common.api.space.BaseDisplayOperatingSpace
    public HandUsingConfigResult configureNonSurfaceHandUsing(boolean r2, DisplayHost r3, HandUsingEventsCallback r4) {
        HandUsingEventsCallback r5 = (HandUsingEventsCallback) ZeusTransformUtils.wrapperContextForParams(r4, HandUsingEventsCallback.class, "com.obric.aiagent.plugin");
        o.e(r3, "host");
        if (ZeusTransformUtils.instanceOf(r3, DisplayHost.Mirror.class) == false) goto L6;
        Loog.INSTANCE.w(TAG, logPrefix() + " configureHandUsing -> Mirror host is not supported by VD.");
    L6:
        return new HandUsingConfigResult(HandUsingConfigResult.Status.NotSupported);
    }

    @Override // com.obric.autogui.common.api.space.BaseDisplayOperatingSpace
    public Surface resolveSurfaceToAttach(Surface r1) {
        if (r1 == null) goto L4;
        return r1;
    L4:
        return this.mBackgroundSurface;
    }

    @Override // com.obric.autogui.common.api.space.BaseDisplayOperatingSpace
    public String logPrefix() {
        return "[VDS/" + getDisplayId() + ']';
    }
}

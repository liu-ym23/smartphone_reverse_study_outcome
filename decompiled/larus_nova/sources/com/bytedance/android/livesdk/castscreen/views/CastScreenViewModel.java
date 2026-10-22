package com.bytedance.android.livesdk.castscreen.views;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import pm1.f;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 '2\u00020\u0001:\u0001(B\t\b\u0016¢\u0006\u0004\b$\u0010%B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b$\u0010&R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\nR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\nR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u001b\u0010\nR!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001f\u0010\nR!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\b\u001a\u0004\b\"\u0010\n¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/views/CastScreenViewModel;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Lcom/bytedance/live/datacontext/m;", "", "castScreenMode$delegate", "Lcom/bytedance/live/datacontext/p;", "getCastScreenMode", "()Lcom/bytedance/live/datacontext/m;", "castScreenMode", "mirrorScreenMode$delegate", "getMirrorScreenMode", "mirrorScreenMode", "needReturnSearchView$delegate", "getNeedReturnSearchView", "needReturnSearchView", "needReturnGuideView$delegate", "getNeedReturnGuideView", "needReturnGuideView", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "replaySwitched", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getReplaySwitched", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "replayShowDanmaku$delegate", "getReplayShowDanmaku", "replayShowDanmaku", "", "jumpSchema$delegate", "getJumpSchema", "jumpSchema", "castOrMirrorScreenMode$delegate", "getCastOrMirrorScreenMode", "castOrMirrorScreenMode", "<init>", "()V", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CastScreenViewModel extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "CastScreenViewModel";
    private final p castOrMirrorScreenMode$delegate;
    private final p castScreenMode$delegate;
    private DataCenter dataCenter;
    private final p jumpSchema$delegate;
    private final p mirrorScreenMode$delegate;
    private final p needReturnGuideView$delegate;
    private final p needReturnSearchView$delegate;
    private final p replayShowDanmaku$delegate;
    private final NextLiveData<Boolean> replaySwitched;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static CastScreenViewModel a() {
            StringBuilder r100 = new StringBuilder();
            DataContext r101 = null;
            RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r102 == null) goto L5;
            int r103 = r102.hashCode();
        L6:
            r100.append(String.valueOf(r103));
            r100.append(CastScreenViewModel.TAG);
            DataContext r104 = com.bytedance.live.datacontext.d.d(r100.toString());
            if ((r104 instanceof CastScreenViewModel) == false) goto L11;
            r101 = r104;
        L11:
            return (CastScreenViewModel) r101;
        L5:
            r103 = 0;
            goto L6
        }

        public static CastScreenViewModel b(DataCenter r100) {
            int r101 = 0;
            String r102 = CastScreenViewModel.TAG;
            if (r100 == null) goto L17;
            VSDataContext.Companion.getClass();
            VSDataContext r103 = VSDataContext.a.b(r100);
            boolean r104 = true;
            if (r103 != null) goto L7;
        L9:
            boolean r105 = false;
        L10:
            if (r105 == false) goto L12;
        L21:
            DataContext r106 = com.bytedance.live.datacontext.d.d(r102);
            if ((r106 instanceof CastScreenViewModel) == true) goto L25;
            r106 = null;
        L25:
            return (CastScreenViewModel) r106;
        L12:
            if (f.d(r100) != null) goto L15;
            r104 = false;
        L15:
            if (r104 == false) goto L17;
        L7:
            if (r103.isVSRoom() != true) goto L9;
            r105 = true;
        L17:
            StringBuilder r107 = new StringBuilder();
            RoomContext r108 = RoomContext.a.c(RoomContext.Companion, r100, 0, 2);
            if (r108 == null) goto L20;
            r101 = r108.hashCode();
        L20:
            r107.append(String.valueOf(r101));
            r107.append(CastScreenViewModel.TAG);
            r102 = r107.toString();
            goto L21
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(CastScreenViewModel.class, "castScreenMode", "getCastScreenMode()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(CastScreenViewModel.class, "mirrorScreenMode", "getMirrorScreenMode()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(CastScreenViewModel.class, "needReturnSearchView", "getNeedReturnSearchView()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(CastScreenViewModel.class, "needReturnGuideView", "getNeedReturnGuideView()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(CastScreenViewModel.class, "replayShowDanmaku", "getReplayShowDanmaku()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(CastScreenViewModel.class, "jumpSchema", "getJumpSchema()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(CastScreenViewModel.class, "castOrMirrorScreenMode", "getCastOrMirrorScreenMode()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final CastScreenViewModel getShared() {
        Companion.getClass();
        return a.a();
    }

    public final m<Boolean> getCastOrMirrorScreenMode() {
        return (m) this.castOrMirrorScreenMode$delegate.a(this, $$delegatedProperties[6]);
    }

    public final m<Boolean> getCastScreenMode() {
        return (m) this.castScreenMode$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<String> getJumpSchema() {
        return (m) this.jumpSchema$delegate.a(this, $$delegatedProperties[5]);
    }

    public final m<Boolean> getMirrorScreenMode() {
        return (m) this.mirrorScreenMode$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Boolean> getNeedReturnGuideView() {
        return (m) this.needReturnGuideView$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<Boolean> getNeedReturnSearchView() {
        return (m) this.needReturnSearchView$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Boolean> getReplayShowDanmaku() {
        return (m) this.replayShowDanmaku$delegate.a(this, $$delegatedProperties[4]);
    }

    public CastScreenViewModel() {
        Boolean r100 = Boolean.FALSE;
        this.castScreenMode$delegate = q.d(this, r100);
        this.mirrorScreenMode$delegate = q.d(this, r100);
        this.needReturnSearchView$delegate = q.d(this, r100);
        this.needReturnGuideView$delegate = q.d(this, r100);
        this.replaySwitched = new NextLiveData();
        this.replayShowDanmaku$delegate = q.d(this, Boolean.TRUE);
        this.jumpSchema$delegate = q.d(this, "");
        this.castOrMirrorScreenMode$delegate = q.d(this, r100);
        StringBuilder r101 = new StringBuilder();
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L6:
        r101.append(String.valueOf(r103));
        r101.append(TAG);
        com.bytedance.live.datacontext.b.a(this, r101.toString());
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public final NextLiveData<Boolean> getReplaySwitched() {
        return this.replaySwitched;
    }

    public CastScreenViewModel(DataCenter r100) {
        Boolean r101 = Boolean.FALSE;
        this.castScreenMode$delegate = q.d(this, r101);
        this.mirrorScreenMode$delegate = q.d(this, r101);
        this.needReturnSearchView$delegate = q.d(this, r101);
        this.needReturnGuideView$delegate = q.d(this, r101);
        this.replaySwitched = new NextLiveData();
        this.replayShowDanmaku$delegate = q.d(this, Boolean.TRUE);
        this.jumpSchema$delegate = q.d(this, "");
        this.castOrMirrorScreenMode$delegate = q.d(this, r101);
        this.dataCenter = r100;
        int r102 = 0;
        String r103 = TAG;
        if (r100 == null) goto L17;
        Companion.getClass();
        VSDataContext.Companion.getClass();
        VSDataContext r104 = VSDataContext.a.b(r100);
        boolean r105 = true;
        if (r104 != null) goto L7;
    L9:
        boolean r106 = false;
    L10:
        if (r106 == false) goto L12;
    L21:
        com.bytedance.live.datacontext.b.a(this, r103);
        return;
    L12:
        if (f.d(r100) != null) goto L15;
        r105 = false;
    L15:
        if (r105 == false) goto L17;
    L7:
        if (r104.isVSRoom() != true) goto L9;
        r106 = true;
    L17:
        StringBuilder r107 = new StringBuilder();
        RoomContext r108 = RoomContext.a.c(RoomContext.Companion, r100, 0, 2);
        if (r108 == null) goto L20;
        r102 = r108.hashCode();
    L20:
        r107.append(String.valueOf(r102));
        r107.append(TAG);
        r103 = r107.toString();
        goto L21
    }
}

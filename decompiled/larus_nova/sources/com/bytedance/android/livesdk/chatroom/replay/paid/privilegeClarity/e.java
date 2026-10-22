package com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeDefinitionInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VideoResolutionItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IEpisodeDefinitionInfo f109430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VideoResolutionItem f109431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VideoResolutionItem f109432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Observer<KVData> f109433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Observer<KVData> f109434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f109435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f109436g;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoResolutionItem f109437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f109438b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity.b f109439c;

        public a(VideoResolutionItem r100, e r101, com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity.b r102) {
            this.f109437a = r100;
            this.f109438b = r101;
            this.f109439c = r102;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            KVData r101 = (KVData) r100;
            if (r101 == null) goto L5;
            VideoResolutionItem r102 = (VideoResolutionItem) r101.getData();
        L6:
            if (r102 != null) goto L8;
        L13:
            e r103 = this.f109438b;
            r103.f109435f.removeObserver(r103.f109433d);
            e r104 = this.f109438b;
            r104.f109435f.removeObserver(r104.f109434e);
            return;
        L8:
            if (Intrinsics.areEqual(r102, this.f109438b.f109432c) == false) goto L13;
            com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity.b r105 = this.f109439c;
            if (r105 == null) goto L12;
            r105.b();
        L12:
            String r106 = rm3.c.f538539a;
            rm3.c.g(this.f109438b.getContext(), "清晰度已切换至" + this.f109437a.getName(), 0, false, 28);
            goto L13
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f109440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity.b f109441b;

        public b(e r100, com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity.b r101) {
            this.f109440a = r100;
            this.f109441b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            KVData r101 = (KVData) r100;
            com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity.b r102 = this.f109441b;
            if (r102 == null) goto L5;
            r102.a();
        L5:
            e r103 = this.f109440a;
            r103.f109435f.removeObserver(r103.f109433d);
            e r104 = this.f109440a;
            r104.f109435f.removeObserver(r104.f109434e);
        }
    }

    public final boolean c() {
        IEpisodeDefinitionInfo r100 = this.f109430a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getDisable() != 0) goto L7;
        return true;
    }

    public final String d() {
        VideoResolutionItem r100 = this.f109431b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getName();
    }

    public final Context getContext() {
        return this.f109436g;
    }

    public final void a(o r100) {
        VideoContext r101 = VideoContext.n0(this.f109436g);
        if (r101 == null) goto L21;
        nic.p r102 = r101.p0();
        if (r102 == null) goto L21;
        Resolution r103 = r102.getResolution();
        if (r103 == null) goto L21;
        String r104 = r103.toString(VideoRef.TYPE_VIDEO);
        if (r104 == null) goto L21;
        VideoResolutionItem r105 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.l.b(r104);
        if (Intrinsics.areEqual(r105, this.f109431b) == false) goto L15;
        p.a("changeToPaidResolution current is paid resolution ignore");
        return;
    L15:
        this.f109432c = r105;
        VideoResolutionItem r106 = this.f109431b;
        if (r106 == null) goto L19;
        int r107 = p.f109456a;
        p.a("changeToPaidResolution paid videoResolutionItem = " + r106.getName());
        this.f109435f.removeObserver(this.f109433d);
        this.f109435f.removeObserver(this.f109434e);
        c r108 = new c(this, r100);
        this.f109433d = r108;
        this.f109434e = new d(this, r100);
        this.f109435f.observe("replay_switch_resolution_success", r108);
        this.f109435f.observe("cmd_switch_resolution_fail", this.f109434e);
        if (this.f109435f.put("data_replay_target_resolution_quietly", r106) == null) goto L19;
        return;
    L19:
        p.a("changeToPaidResolution error paid videoResolutionItem = null");
        Unit r109 = Unit.INSTANCE;
        return;
    L21:
        p.a("changeToPaidResolution current resolution  = null");
    }

    public final void e(com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity.b r100) {
        VideoResolutionItem r101 = this.f109432c;
        if (r101 == null) goto L6;
        int r102 = p.f109456a;
        p.a("returnToOriginResolution origin videoResolutionItem = " + r101.getName());
        this.f109435f.removeObserver(this.f109433d);
        this.f109435f.removeObserver(this.f109434e);
        a r103 = new a(r101, this, r100);
        this.f109433d = r103;
        this.f109434e = new b(this, r100);
        this.f109435f.observe("replay_switch_resolution_success", r103);
        this.f109435f.observe("cmd_switch_resolution_fail", this.f109434e);
        if (this.f109435f.put("data_replay_target_resolution_quietly", r101) == null) goto L6;
        return;
    L6:
        p.a("returnToOriginResolution error origin videoResolutionItem = null");
        Unit r104 = Unit.INSTANCE;
    }

    public e(DataCenter r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f109435f = r100;
        this.f109436g = r101;
    }

    public final void b(String r100, Episode r101) {
        Intrinsics.checkNotNullParameter(r100, "definition");
        Intrinsics.checkNotNullParameter(r101, "episode");
        List<IEpisodeDefinitionInfo> r102 = r101.video.getVideoDefinitionInfoList();
        VideoResolutionItem r103 = null;
        if (r102 == null) goto L19;
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L17;
        Object r105 = r104.next();
        IEpisodeDefinitionInfo r106 = (IEpisodeDefinitionInfo) r105;
        boolean r107 = true;
        if (Intrinsics.areEqual(r106.getDefinition(), r100) == true) goto L15;
        String r108 = r106.getDefinition();
        if (r108 != null) goto L12;
    L14:
        r107 = false;
        goto L15
    L12:
        if (StringsKt.startsWith(r108, r100, true) != true) goto L14;
    L15:
        if (r107 == false) goto L6;
    L18:
        IEpisodeDefinitionInfo r109 = (IEpisodeDefinitionInfo) r105;
    L20:
        this.f109430a = r109;
        if (r109 == null) goto L25;
        String r110 = r109.getDefinition();
        if (r110 == null) goto L25;
        r103 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.l.b(r110);
    L25:
        this.f109431b = r103;
        return;
    L17:
        r105 = null;
        goto L18
    L19:
        r109 = null;
        goto L20
    }
}

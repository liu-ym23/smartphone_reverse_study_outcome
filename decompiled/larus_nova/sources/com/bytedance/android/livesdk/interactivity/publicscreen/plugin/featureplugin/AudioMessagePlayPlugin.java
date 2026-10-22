package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin;

import am2.x;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.message.r;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.interactivity.api.PublicScreenContext;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.k;
import com.bytedance.android.livesdk.interactivity.api.l;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ShowArea;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.plugin.FeaturePluginType;
import com.bytedance.android.livesdk.interactivity.api.settings.config.s0;
import com.bytedance.android.livesdk.interactivity.api.textaudio.TextAudioManagerDummy;
import com.bytedance.android.livesdk.interactivity.textmessage.model.AudioChatTextMessage;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.j;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import u22.e;
import zg1.s;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002\n\u000fJ\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005R\u001a\u0010\u000e\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/plugin/featureplugin/AudioMessagePlayPlugin;", "Lcom/bytedance/android/livesdk/interactivity/api/k;", "Lt52/a$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lu22/e;", "e", "", "onEvent", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/plugin/FeaturePluginType;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/plugin/FeaturePluginType;", "getType", "()Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/plugin/FeaturePluginType;", "type", "b", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioMessagePlayPlugin implements k, t52.a.b, Observer<KVData> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f139145i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FeaturePluginType f139146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f139147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f139148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f139149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f139150e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public t52.a f139151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PublicScreenContext f139152g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DataCenter f139153h;

    public static final class a {
    }

    public static final class b extends t52.a.C7687a {
        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            super(r100);
        }
    }

    public static final class c implements s42.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioMessagePlayPlugin f139154a;

        @Override // s42.b
        public final void f() {
        }

        @Override // s42.b
        public final void g() {
        }

        @Override // s42.b
        public final void h(f<?> r100) {
        }

        @Override // s42.b
        public final void m(f<?> r100) {
        }

        public c(AudioMessagePlayPlugin r100) {
            this.f139154a = r100;
        }

        @Override // s42.b
        public final void a(t r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            Intrinsics.checkNotNullParameter(r100, "message");
        }

        @Override // s42.b
        public final void i(f<?> r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            Intrinsics.checkNotNullParameter(r100, "message");
        }

        @Override // s42.b
        public final void j(f<?> r100, ShowArea r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            Intrinsics.checkNotNullParameter(r101, "showArea");
            if ((r100 instanceof AudioChatTextMessage) == true) goto L5;
            return;
        L5:
            if (r101 != ShowArea.Scroll) goto L44;
            f72.a.b("Receive Audio Message");
            AudioMessagePlayPlugin r102 = this.f139154a;
            AudioChatTextMessage r103 = (AudioChatTextMessage) r100;
            if (r102.f139150e == true) goto L49;
            t52.a r104 = r102.f139151f;
            if (r104 == null) goto L15;
            if (r104.isPlaying() != true) goto L15;
            ALogger.i("AudioMessagePlayPlugin", "newAudioMessageReceived, audioManager.isPlaying() == true");
            return;
        L15:
            if (r102.f139148c == false) goto L50;
            IRoom r105 = (IRoom) r102.f139153h.get("data_room");
            if (r105 != null) goto L21;
            return;
        L21:
            if (r105.isThirdParty() == true) goto L52;
            DataCenter r106 = r102.f139153h;
            Boolean r107 = Boolean.TRUE;
            if (((Boolean) r106.get("data_room_audio_comment_enable", r107)).booleanValue() == true) goto L26;
            return;
        L26:
            if (((Boolean) r102.f139153h.get("data_room_audio_comment_auto_play", r107)).booleanValue() == false) goto L53;
            f72.a.b("Need Auto Play When Receive Message");
            t52.a r108 = r102.f139151f;
            if (r108 != null) goto L31;
        L32:
            r r109 = (r) r103.f133141b;
            String r110 = null;
            if (r109 == null) goto L35;
            String r111 = r109.getAudioUrl();
        L37:
            if (TextUtils.isEmpty(r111) == true) goto L48;
            Application r112 = jc1.a.b();
            r r113 = (r) r103.f133141b;
            if (r113 == null) goto L41;
            r110 = r113.getAudioUrl();
        L41:
            r102.d(r112, r110);
            return;
        L48:
            return;
        L35:
            r111 = null;
            goto L37
        L31:
            if (r108.isPlaying() != true) goto L32;
            return;
        L53:
            return;
        L52:
            return;
        L50:
            return;
        L49:
            return;
        }
    }

    static {
    }

    @Override // v42.a
    public final void onLoad() {
    }

    @Override // v42.a
    public final void onUnload() {
    }

    public final void g() {
        f72.a.b("AudioMessagePresenter stopPlayAudio");
        ALogger.i("AudioMessagePlayPlugin", "stopPlayAudio");
        t52.a r100 = this.f139151f;
        if (r100 == null) goto L6;
        r100.stopAudio();
        return;
    }

    @Override // v42.a
    public final void onDestroy() {
        this.f139152g.removeMessageListener(this.f139147b);
        this.f139149d.clear();
        this.f139153h.removeObserver(this);
        t52.a r100 = this.f139151f;
        if (r100 == null) goto L6;
        r100.unregister(this);
        return;
    }

    @Override // v42.a
    public final void onInit() {
        this.f139153h.observeForever("cmd_widget_loaded", this);
        this.f139152g.addMessageListener(this.f139147b);
        e(u22.d.class, new com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin.a(new AudioMessagePlayPlugin$registerEvents$1(this)));
        e(e.class, new com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin.a(new AudioMessagePlayPlugin$registerEvents$2(this)));
        e(s.class, new com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin.a(new AudioMessagePlayPlugin$registerEvents$3(this)));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.k, v42.a
    public FeaturePluginType getType() {
        return this.f139146a;
    }

    @Override // t52.a.b
    public final void a(t52.a.C7687a r100) {
        Intrinsics.checkNotNullParameter(r100, "audioInfo");
        if ((r100 instanceof b) == false) goto L15;
        String r101 = r100.f544618a;
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L16;
        f72.a.b("AudioMessagePresenter Notify Audio Chat Play End");
        kc2.a r103 = kc2.d.a(((b) r100).f544618a);
        r103.updateField = 2;
        r103.readStatus = 1;
        h(r103);
        return;
    L16:
        return;
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    }

    @Override // t52.a.b
    public final void b(final t52.a.C7687a r100) {
        Intrinsics.checkNotNullParameter(r100, "audioInfo");
        if ((r100 instanceof b) == false) goto L42;
        String r101 = r100.f544618a;
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L43;
        kc2.a r103 = kc2.d.a(((b) r100).f544618a);
        r103.updateField = 2;
        r103.readStatus = 1;
        h(r103);
        if (this.f139150e == false) goto L16;
        return;
    L16:
        t52.a r104 = this.f139151f;
        if (r104 != null) goto L19;
    L21:
        l r105 = this.f139152g.getMessageLogicFacade().getValue();
        if (r105 == null) goto L24;
        int r106 = r105.z(new AudioMessagePlayPlugin$onPlayComplete$currentIndex$1(r100), new IntRange(-1, -1));
    L25:
        if (r106 != (-1)) goto L27;
        return;
    L27:
        l r107 = this.f139152g.getMessageLogicFacade().getValue();
        Object r108 = null;
        if (r107 == null) goto L32;
        f<?> r109 = r107.t(AudioMessagePlayPlugin$onPlayComplete$nextAudioMessage$1.INSTANCE, new IntRange(r106, -1));
        if (r109 == null) goto L32;
        Object r110 = r109.f133141b;
    L34:
        if ((r110 instanceof r) == false) goto L37;
        r108 = r110;
    L37:
        r r111 = (r) r108;
        if (r111 != null) goto L40;
        return;
    L40:
        f72.a.b("AudioMessagePresenter Auto Play Next Unread Message");
        d(jc1.a.b(), r111.getAudioUrl());
        return;
    L32:
        r110 = null;
        goto L34
    L24:
        r106 = -1;
        goto L25
    L19:
        if (r104.isPlaying() != true) goto L21;
        return;
    L43:
        return;
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    }

    @Override // t52.a.b
    public final void c(t52.a.C7687a r100) {
        Intrinsics.checkNotNullParameter(r100, "audioInfo");
        if ((r100 instanceof b) == false) goto L15;
        String r101 = r100.f544618a;
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L16;
        f72.a.b("AudioMessagePresenter Notify Audio Chat Play Start");
        kc2.a r103 = kc2.d.a(r100.f544618a);
        r103.updateField = 2;
        r103.readStatus = 2;
        h(r103);
        return;
    L16:
        return;
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    }

    public final void h(final kc2.a r100) {
        l r101 = this.f139152g.getMessageLogicFacade().getValue();
        if (r101 == null) goto L5;
        f<?> r102 = r101.m(new AudioMessagePlayPlugin$tryUpdateAudioTextMessage$targetMsg$1(r100));
    L6:
        if (r102 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.textmessage.utils.d.b(r100, r102);
        return;
    L9:
        l r103 = this.f139152g.getMessageLogicFacade().getValue();
        if (r103 == null) goto L13;
        r103.l(new AudioMessagePlayPlugin$tryUpdateAudioTextMessage$1(r100), new AudioMessagePlayPlugin$tryUpdateAudioTextMessage$2(r100));
        return;
    L13:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L29;
        String r102 = r101.getKey();
        if (r102.hashCode() == (-1836833765)) goto L8;
        return;
    L8:
        if (r102.equals("cmd_widget_loaded") == false) goto L30;
        IRoomContextService r103 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        int r104 = t52.b.f544619a;
        Object r105 = null;
        if (r103 == null) goto L16;
        o r106 = IRoomContextService.a.a(r103, null, 0, 3);
        if (r106 == null) goto L16;
        j<ViewModel> r107 = r106.L2();
        if (r107 == null) goto L16;
        ViewModel r108 = r107.getValue();
    L18:
        if ((r108 instanceof t52.a) == false) goto L21;
        r105 = r108;
    L21:
        t52.a r109 = (t52.a) r105;
        if (r109 != null) goto L24;
        r109 = TextAudioManagerDummy.INSTANCE;
    L24:
        r109.register(this);
        if ((r109 instanceof TextAudioManagerDummy) == false) goto L27;
        s0 r110 = PublicScreenTraceMonitor.f133304a;
        PublicScreenTraceMonitor.e("get dummy manager");
    L27:
        Unit r111 = Unit.INSTANCE;
        this.f139151f = r109;
        ALogger.i("AudioMessagePlayPlugin", "widget loaded, audioManager is " + this.f139151f);
        return;
    L16:
        r108 = null;
        goto L18
    L30:
        return;
    }

    public final void onEvent(e r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        g();
    }

    public AudioMessagePlayPlugin(PublicScreenContext r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f139152g = r100;
        this.f139153h = r101;
        this.f139146a = FeaturePluginType.AudioMessagePlay;
        this.f139147b = new c(this);
        Boolean r102 = Boolean.FALSE;
        Object r103 = null;
        Object r104 = r101.get("data_is_anchor", null);
        if ((r104 instanceof Boolean) == false) goto L6;
        r103 = r104;
    L6:
        Boolean r105 = (Boolean) r103;
        if (r105 == null) goto L10;
        r102 = r105;
    L10:
        this.f139148c = r102.booleanValue();
        this.f139149d = new CompositeDisposable();
    }

    public final void d(Context r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L7;
        s0 r102 = PublicScreenTraceMonitor.f133304a;
        PublicScreenTraceMonitor.e("audio url empty");
        return;
    L7:
        f72.a.b("AudioMessagePresenter playAudioUseUrl");
        t52.a r103 = this.f139151f;
        if (r103 == null) goto L11;
        r103.playAudioByUrl(r100, new b(r101));
        return;
    }

    public final <T> void e(Class<T> r100, Consumer<T> r101) {
        com.bytedance.revenue.platform.api.core.rx.f.a(xs2.b.a().b(r100).subscribe(r101), this.f139149d);
    }

    public final void f(long r100, String r101) {
        Boolean r102 = (Boolean) this.f139153h.get("data_is_anchor", Boolean.FALSE);
        HashMap r103 = new HashMap();
        if (r102.booleanValue() == false) goto L5;
        String r104 = "anchor";
    L6:
        r103.put("user_type", r104);
        r103.put("duration", String.valueOf(r100));
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        r103.put(EventConstant.Key.RETAIN_PROMPT, r101);
        j0 r105 = j0.l();
        x r106 = new x();
        r106.f4350b = "live_detail";
        r105.sendLog("livesdk_vocal_message_play", r103, new Object[]{r106, IRoom.class});
        return;
    L5:
        r104 = SourceType.DEFAULT;
        goto L6
    }
}

package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.model.ReloadPanelType;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.et0;
import com.bytedance.android.livesdk.config.f30;
import com.bytedance.android.livesdk.config.lh;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.android.livesdk.widget.BroadcastKtvEffectMusicWidget;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class m3 implements f10.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f116484g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DataCenter f116485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f116486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f116487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f116488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public id2.c f116489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.api.model.u f116490f;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/m3$a;", "", "", "mergeBeats", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setMergeBeats", "(Ljava/lang/String;)V", "beatsTracker", "getBeatsTracker", "setBeatsTracker", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("beats_tracker")
        private String beatsTracker;

        @SerializedName("merged_beats")
        private String mergeBeats;

        public a() {
            this.mergeBeats = "";
            this.beatsTracker = "";
        }

        public final String a() {
            return this.mergeBeats;
        }
    }

    public static final class b {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/m3$c;", "", "", "url", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("cover_hd")
        private String url;

        public c() {
            this.url = "";
        }

        public final String a() {
            return this.url;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/m3$d;", "", "Lcom/bytedance/android/live/core/resources/h$a;", "audioGraph", "Lcom/bytedance/android/live/core/resources/h$a;", "getAudioGraph", "()Lcom/bytedance/android/live/core/resources/h$a;", "setAudioGraph", "(Lcom/bytedance/android/live/core/resources/h$a;)V", "", "", "musicLib", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setMusicLib", "(Ljava/util/List;)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("audio_graph")
        private com.bytedance.android.live.core.resources.h.a audioGraph;

        @SerializedName("music_lib")
        private List<String> musicLib;

        public d() {
            this.musicLib = new ArrayList();
        }

        public final List<String> a() {
            return this.musicLib;
        }
    }

    public static final class e implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m3 f116491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f116492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f116493c;

        public e(m3 r100, String r101, boolean r102) {
            this.f116491a = r100;
            this.f116492b = r101;
            this.f116493c = r102;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            m3.d(this.f116491a, this.f116492b, com.bytedance.android.live.effect.api.d0.f66754d, false, this.f116493c, 16);
            this.f116491a.f(this.f116492b, "click", "confirm");
            r100.dismiss();
        }
    }

    public static final class f implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m3 f116494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f116495b;

        public f(m3 r100, String r101) {
            this.f116494a = r100;
            this.f116495b = r101;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f116494a.f(this.f116495b, "click", "cancel");
            r100.dismiss();
        }
    }

    public static final class g implements IFetchEffectListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m3 f116496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f116497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f116498c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ id2.c f116499d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f116500e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f116501f;

        @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener
        public final void onStart(Effect r100) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v3, types: [T, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0] */
        @Override // com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener
        public final void onSuccess(Effect r110) {
            Effect r100 = r110;
            JSONObject r111 = new JSONObject();
            String r101 = null;
            RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r102 == null) goto L7;
            com.bytedance.live.datacontext.j<com.bytedance.android.live.pushstream.d> r103 = r102.getLiveStream();
            if (r103 == null) goto L7;
            com.bytedance.android.live.pushstream.d r104 = r103.getValue();
        L8:
            Ref.ObjectRef r105 = new Ref.ObjectRef();
            r105.element = null;
            boolean r106 = true;
            boolean r107 = false;
            String r108 = "";
            if (this.f116497b == true) goto L11;
        L118:
            if (r100 == null) goto L209;
            xs2.b r112 = xs2.b.a();
            String r109 = this.f116501f;
            boolean r113 = this.f116498c;
            n3 r114 = new n3(this, r100, r104);
            Bundle r115 = new Bundle();
            if (f30.f120173a.getValue().booleanValue() == false) goto L135;
            String r116 = this.f116496a.f116490f.extra;
            LiveSeiUtil.f71508i.getClass();     // Catch: Exception -> L138
            JSONObject r117 = LiveSeiUtil.c(r116);     // Catch: Exception -> L138
            if (r117.optInt("version_type", -1) == 1) goto L145;
            r106 = false;
        L145:
            r101 = LiveSeiUtil.c(r117.optString("debug_button")).optString("schema");     // Catch: Exception -> L129
        L130:
            if (r101 == null) goto L133;
            r108 = r101;
        L133:
            Unit r118 = Unit.INSTANCE;     // Catch: Exception -> L137
        L134:
            r107 = r106;
        L135:
            r115.putBoolean("extra_key_enable_debug_mode", r107);
            r115.putString("extra_key_debug_schema_url", r108);
            Unit r119 = Unit.INSTANCE;
            r112.post(new zg1.o(r109, r100, r113, r114, r115));
            return;
        L209:
            return;
        L11:
            if (this.f116498c == false) goto L118;
            if (lh.f120679a.getValue().booleanValue() == false) goto L118;
            Gson r120 = GsonHelper.get();
            if (r100 == null) goto L17;
            String r121 = r100.getSdk_extra();
        L18:
            d r122 = (d) GsonProtectorUtils.fromJson(r120, r121, d.class);
            r105.element = new i0();
            if (this.f116499d == null) goto L118;
            if ((!r122.a().isEmpty()) == false) goto L118;
            JSONObject r123 = new JSONObject(this.f116499d.f489305b);     // Catch: Exception -> L24
        L25:
            Iterator<T> r124 = r122.a().iterator();
        L27:
            if (r124.hasNext() == false) goto L111;
            String r125 = (String) r124.next();
            switch(r125.hashCode()) {
                case -1992012396: goto L104;
                case -1406328437: goto L95;
                case -1361215066: goto L86;
                case -1087772684: goto L83;
                case 97759: goto L80;
                case 3154575: goto L77;
                case 3237446: goto L74;
                case 3351329: goto L71;
                case 92896879: goto L68;
                case 93610877: goto L54;
                case 94852023: goto L35;
                case 110371416: goto L32;
                default: goto L27;
            };
        L32:
            if (r125.equals("title") == false) goto L27;
        L97:
            if (r123.has(r125) == false) goto L99;
            String r126 = JSONObjectProtectorUtils.getString(r123, r125);
        L101:
            if (k81.c.b(r126) == false) goto L27;
            r111.put(r125, r126);
            goto L27
        L99:
            r126 = "";
            goto L101
        L35:
            if (r125.equals("cover") == false) goto L27;
            String r127 = this.f116499d.f489311h;     // Catch: Exception -> L66
            if (r127.length() != 0) goto L39;
            boolean r128 = true;
        L40:
            if (r128 == false) goto L47;
            Gson r129 = GsonHelper.get();     // Catch: Exception -> L66
            if (r123.has(r125) == false) goto L44;
            String r130 = JSONObjectProtectorUtils.getString(r123, r125);     // Catch: Exception -> L66
        L45:
            r127 = ((c) r129.fromJson(r130, c.class)).a();     // Catch: Exception -> L66
            goto L47
        L44:
            r130 = "";
        L47:
            if (r127.length() <= 0) goto L49;
            boolean r131 = true;
        L50:
            if (r131 == false) goto L27;
            ((i0) r105.element).a(new i0.c(r127));     // Catch: Exception -> L66
            goto L27
        L49:
            r131 = false;
            goto L50
        L39:
            r128 = false;
            goto L40
        L54:
            if (r125.equals("beats") == false) goto L27;
            Gson r132 = GsonHelper.get();     // Catch: Exception -> L66
            if (r123.has(r125) == false) goto L58;
            String r133 = JSONObjectProtectorUtils.getString(r123, r125);     // Catch: Exception -> L66
        L59:
            a r134 = (a) r132.fromJson(r133, a.class);     // Catch: Exception -> L66
            if (r134.a().length() <= 0) goto L62;
            boolean r135 = true;
        L63:
            if (r135 == false) goto L27;
            ((i0) r105.element).a(new i0.a(r134.a()));     // Catch: Exception -> L66
            goto L27
        L62:
            r135 = false;
            goto L63
        L58:
            r133 = "";
            goto L59
        L68:
            if (r125.equals("album") == false) goto L27;
        L71:
            if (r125.equals(KtvSubElement.MIDI) == false) goto L27;
            r111.put(r125, this.f116499d.f489308e);
            goto L27
        L74:
            if (r125.equals("inst") == false) goto L27;
            r111.put(r125, this.f116499d.f489307d);
            goto L27
        L77:
            if (r125.equals("full") == false) goto L27;
            r111.put(r125, this.f116499d.f489306c);
            goto L27
        L80:
            if (r125.equals("bpm") == false) goto L27;
        L106:
            if (r123.has(r125) == false) goto L108;
            int r136 = JSONObjectProtectorUtils.getInt(r123, r125);
        L109:
            if (r136 <= 0) goto L27;
            r111.put(r125, r136);
            goto L27
        L108:
            r136 = 0;
            goto L109
        L83:
            if (r125.equals("lyrics") == false) goto L27;
            id2.c r137 = this.f116499d;
            ((i0) r105.element).a(new i0.e(r137.f489309f, r137.f489310g));
            goto L27
        L86:
            if (r125.equals("chorus") == false) goto L27;
            if (r123.has(r125) == false) goto L90;
            String r138 = JSONObjectProtectorUtils.getString(r123, r125);
        L92:
            if (k81.c.b(r138) == false) goto L27;
            r111.put(r125, new JSONObject(r138));
            goto L27
        L90:
            r138 = "";
            goto L92
        L95:
            if (r125.equals("author") == false) goto L27;
        L104:
            if (r125.equals("duration") == false) goto L27;
        L111:
            i0 r139 = (i0) r105.element;
            o3 r140 = new o3(this, r105, r111, r104);
            r139.getClass();
            Intrinsics.checkNotNullParameter(r140, "taskCallBack");
            if (((ArrayList) r139.f116331c).isEmpty() == false) goto L114;
            r140.onFinish();
            goto L118
        L114:
            r139.f116330b = r140;
            Iterator r141 = ((ArrayList) r139.f116331c).iterator();
        L116:
            if (r141.hasNext() == false) goto L118;
            ((i0.d) r141.next()).a(r139.f116329a);
        L24:
            r123 = new JSONObject();
            goto L25
        L17:
            r121 = null;
        L7:
            r104 = null;
            goto L8
        }

        @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener
        public final void onFail(Effect r100, ExceptionResult r101) {
            Intrinsics.checkNotNullParameter(r101, "e");
            RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r102 == null) goto L7;
            com.bytedance.live.datacontext.n<String> r103 = r102.getDownLoadingInteractEffectId();
            if (r103 == null) goto L7;
            r103.setValue(null);
        L7:
            this.f116496a.e();
        }

        public g(m3 r100, boolean r101, boolean r102, id2.c r103, String r104, String r105) {
            this.f116496a = r100;
            this.f116497b = r101;
            this.f116498c = r102;
            this.f116499d = r103;
            this.f116500e = r104;
            this.f116501f = r105;
        }
    }

    public static final class h implements BroadcastKtvEffectMusicWidget.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m3 f116502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f116503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f116504c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f116505d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f116506e;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.livesdk.widget.BroadcastKtvEffectMusicWidget.b
        public final void a() {
            if (this.f116503b.element == true) goto L13;
            int r100 = k81.c.f502081a;
            String r101 = null;
            RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r102 == null) goto L10;
            com.bytedance.live.datacontext.n<String> r103 = r102.getDownLoadingInteractEffectId();
            if (r103 == null) goto L10;
            r101 = r103.getValue();
        L10:
            if (k81.c.b(r101) == true) goto L13;
            this.f116502a.g((String) this.f116505d.element, (String) this.f116506e.element);
            return;
        L13:
            this.f116502a.h(this.f116504c.getContext());
        }

        public h(m3 r100, Ref.BooleanRef r101, View r102, Ref.ObjectRef r103, Ref.ObjectRef r104) {
            this.f116502a = r100;
            this.f116503b = r101;
            this.f116504c = r102;
            this.f116505d = r103;
            this.f116506e = r104;
        }
    }

    public static final class i implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f116507a = null;

        static {
            f116507a = new i();
        }

        public i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void e() {
        xs2.b.a().post(new com.bytedance.android.live.broadcastgame.api.model.f0(this.f116490f.e(), ReloadPanelType.FROM_CAHCE, false, false, 12));
    }

    public m3(com.bytedance.android.live.broadcastgame.api.model.u r100) {
        Intrinsics.checkNotNullParameter(r100, "interactItem");
        this.f116490f = r100;
    }

    public static final /* synthetic */ DataCenter a(m3 r100) {
        DataCenter r101 = r100.f116485a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L5:
        return r101;
    }

    public final void h(Context r100) {
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_interactive_extension_conflict_popup", MapsKt.mapOf(TuplesKt.to("action_type", "show")), new Object[]{IRoom.class});
        if (et0.f120153a.getValue().booleanValue() == false) goto L5;
        String r101 = "特效下载中，请稍后";
    L6:
        com.bytedance.android.livesdk.chatroom.view.e r102 = new com.bytedance.android.livesdk.chatroom.view.e(r100, "请先退出当前特效/互动特效", r101);
        com.bytedance.android.livesdk.widget.z0.a().getClass();
        com.bytedance.android.livesdk.widget.x0.d r103 = new com.bytedance.android.livesdk.widget.x0.d();
        r103.f162243b = r100;
        r103.f162242a = 4;
        r103.f162253l = false;
        r103.f162247f = r102;
        i r104 = i.f116507a;
        com.bytedance.android.livesdk.widget.x0.c[] r105 = r103.f162248g;
        com.bytedance.android.livesdk.widget.x0.c r106 = r105[0];
        if (r106 != null) goto L9;
        r106 = new com.bytedance.android.livesdk.widget.x0.c();
        r105[0] = r106;
    L9:
        r106.f162239a = "我知道了";
        r106.f162240b = r104;
        com.bytedance.android.livesdk.widget.x0.c[] r107 = r103.f162248g;
        com.bytedance.android.livesdk.widget.x0.c r108 = r107[0];
        if (r108 != null) goto L12;
        r108 = new com.bytedance.android.livesdk.widget.x0.c();
        r107[0] = r108;
    L12:
        r108.f162241c = true;
        com.bytedance.android.livesdk.widget.x0.b.g(new com.bytedance.android.livesdk.widget.x0(r103.f162243b, r103));
        return;
    L5:
        r101 = "最多可同时使用一种特效/互动特效";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v7, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v16, types: [T, java.lang.String] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r210) {
        Intrinsics.checkNotNullParameter(r210, "view");
        long r100 = System.currentTimeMillis();
        if ((r100 - this.f116487c) <= 500) goto L5;
        boolean r101 = false;
    L6:
        this.f116487c = r100;
        if (r101 == false) goto L9;
        return;
    L9:
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = "";
        Ref.BooleanRef r103 = new Ref.BooleanRef();
        r103.element = false;
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r104 = ILiveWrappedEffectSDKService.a.a();
        if (r104 == null) goto L13;
        String r105 = r104.getSdkVersion();
        if (r105 == null) goto L13;
    L14:
        Ref.ObjectRef r106 = new Ref.ObjectRef();
        r106.element = "";
        String r110 = this.f116490f.extra;
        LiveSeiUtil.f71508i.getClass();     // Catch: Exception -> L34
        JSONObject r111 = LiveSeiUtil.c(r110);     // Catch: Exception -> L34
        String r112 = r111.optString("button_schema_url");     // Catch: Exception -> L34
        int r113 = ln1.a.C6715a.f509979a;     // Catch: Exception -> L32
        JSONObject r114 = ln1.a.C6715a.b(r111.optString("button_extra"));     // Catch: Exception -> L32
        r102.element = r111.optString("app_id");     // Catch: Exception -> L171
        String r115 = r111.optString("schema");     // Catch: Exception -> L171
        String r116 = r111.optString("plugin_type");     // Catch: Exception -> L30
        r106.element = r111.optString("music_info_requirement");     // Catch: Exception -> L170
        int r117 = r111.optInt("version_type", -1);     // Catch: Exception -> L170
        String r107 = LiveSeiUtil.c(r111.optString("debug_button")).optString("schema");     // Catch: Exception -> L23
    L24:
        if (r107 != null) goto L182;
        r107 = "";
    L182:
        Unit r118 = Unit.INSTANCE;     // Catch: Exception -> L169
    L29:
        int r119 = r117;
        boolean r120 = false;
    L35:
        this.f116486b = r120;
        List<String> r121 = LiveEffectContext.f66734h;
        List<Sticker> r108 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().o(com.bytedance.android.live.effect.api.d0.f66754d);
        Iterator<Sticker> r122 = r108.iterator();
    L37:
        if (r122.hasNext() == false) goto L45;
        long r123 = r122.next().getId();
        Iterator<Sticker> r211 = r122;
        Long r124 = StringsKt.toLongOrNull((String) r102.element);
        if (r124 == null) goto L44;
        if (r123 != r124.longValue()) goto L44;
        this.f116486b = true;
        String r125 = "open";
    L46:
        List<String> r126 = LiveEffectContext.f66734h;
        String r127 = r115;
        String r128 = r107;
        this.f116488d = !LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().o(com.bytedance.android.live.effect.api.d0.f66753c).isEmpty();
        if (et0.f120153a.getValue().booleanValue() == false) goto L50;
        r103.element = false;
    L56:
        RoomContext.a r109 = RoomContext.Companion;
        RoomContext r212 = RoomContext.a.c(r109, null, 0, 3);
        if (r212 == null) goto L62;
        com.bytedance.live.datacontext.n<String> r129 = r212.getDownLoadingInteractEffectId();
        if (r129 == null) goto L62;
        String r130 = r129.getValue();
        if (r130 == null) goto L62;
    L63:
        Map r131 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("interact_app_id", (String) r102.element), TuplesKt.to("status", r125), TuplesKt.to("interact_app_type", r116), TuplesKt.to("effect_sdk_version", r105), TuplesKt.to("downloading_id", r130), TuplesKt.to("extension_type_level2", "null")});
        if (r119 <= (-1)) goto L69;
        if (f30.f120173a.getValue().booleanValue() == false) goto L69;
        r131.put("version_type", String.valueOf(r119));
    L69:
        if (Intrinsics.areEqual(r210.getTag(), "button") == false) goto L142;
        if (r114 == null) goto L72;
        Object r132 = r114.get(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE);
    L74:
        if (Intrinsics.areEqual(r132, "open_url") == false) goto L83;
        if (r112 == null) goto L83;
        if (r112.length() <= 0) goto L79;
        boolean r133 = true;
    L81:
        if (r133 != true) goto L83;
        dp1.a.a(r210, r112, r131, false);
    L165:
        boolean r134 = true;
    L166:
        if (r134 == false) goto L192;
        xs2.b.a().post(new com.bytedance.android.live.broadcastgame.api.model.f0(this.f116490f.e(), ReloadPanelType.FROM_CAHCE, false, this.f116486b, 4));
        return;
    L192:
        return;
    L79:
        r133 = false;
    L83:
        if (r114 == null) goto L85;
        Object r135 = r114.get(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE);
    L87:
        if (Intrinsics.areEqual(r135, "open_effect") == true) goto L89;
    L110:
        if (r114 == null) goto L112;
        Object r136 = r114.get(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE);
    L114:
        if (Intrinsics.areEqual(r136, "open_ktv_effect") == true) goto L116;
    L140:
        com.bytedance.android.live.core.utils.f2.c("互动工具打开失败", 0);
        goto L165
    L116:
        if (((String) r102.element).length() <= 0) goto L118;
        boolean r137 = true;
    L119:
        if (r137 == false) goto L140;
        String r138 = (String) r106.element;
        if (r103.element == true) goto L139;
        int r139 = k81.c.f502081a;
        RoomContext r140 = RoomContext.a.c(r109, null, 0, 3);
        if (r140 == null) goto L127;
        com.bytedance.live.datacontext.n<String> r141 = r140.getDownLoadingInteractEffectId();
        if (r141 == null) goto L127;
        String r142 = r141.getValue();
    L129:
        if (k81.c.b(r142) == true) goto L139;
        if (this.f116486b == false) goto L135;
        b((String) r102.element, r210.getContext(), true);
        goto L165
    L135:
        if (lh.f120679a.getValue().booleanValue() == false) goto L137;
        g((String) r102.element, (String) r106.element);
        goto L165
    L137:
        d(this, (String) r102.element, com.bytedance.android.live.effect.api.d0.f66754d, true, false, 24);
    L138:
        r134 = false;
    L127:
        r142 = null;
    L139:
        h(r210.getContext());
        goto L165
    L118:
        r137 = false;
        goto L119
    L112:
        r136 = null;
        goto L114
    L89:
        if (((String) r102.element).length() <= 0) goto L91;
        boolean r143 = true;
    L92:
        if (r143 == false) goto L110;
        if (r103.element == true) goto L108;
        int r144 = k81.c.f502081a;
        RoomContext r145 = RoomContext.a.c(r109, null, 0, 3);
        if (r145 == null) goto L100;
        com.bytedance.live.datacontext.n<String> r146 = r145.getDownLoadingInteractEffectId();
        if (r146 == null) goto L100;
        String r147 = r146.getValue();
    L102:
        if (k81.c.b(r147) == true) goto L108;
        if (this.f116486b == false) goto L107;
        b((String) r102.element, r210.getContext(), false);
        goto L165
    L107:
        d(this, (String) r102.element, com.bytedance.android.live.effect.api.d0.f66754d, true, false, 24);
    L100:
        r147 = null;
    L108:
        h(r210.getContext());
        goto L165
    L91:
        r143 = false;
        goto L92
    L85:
        r135 = null;
        goto L87
    L72:
        r132 = null;
        goto L74
    L142:
        if (Intrinsics.areEqual(r210.getTag(), "debug_button") == false) goto L145;
        int r148 = dp1.a.f469571a;
        dp1.a.a(r210, r128, MapsKt.emptyMap(), false);
        xs2.b.a().post(new d10.b(true));
        goto L165
    L145:
        if (r114 == null) goto L147;
        Object r149 = r114.get(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE);
    L149:
        if (Intrinsics.areEqual(r149, "open_ktv_effect") == true) goto L151;
    L160:
        xs2.b.a().post(new BroadcastKtvEffectMusicWidget.d((String) r102.element, null));
    L162:
        if (r103.element == false) goto L164;
        r131.put("repel_status", "effect");
    L164:
        dp1.a.a(r210, r127, r131, false);
        goto L165
    L151:
        if (((String) r102.element).length() <= 0) goto L153;
        boolean r150 = true;
    L154:
        if (r150 == false) goto L160;
        if (this.f116486b == true) goto L160;
        if (lh.f120679a.getValue().booleanValue() == false) goto L160;
        xs2.b.a().post(new BroadcastKtvEffectMusicWidget.d((String) r102.element, new h(this, r103, r210, r102, r106)));
        goto L162
    L153:
        r150 = false;
        goto L154
    L147:
        r149 = null;
    L62:
        r130 = "";
        goto L63
    L50:
        if ((!r108.isEmpty()) == false) goto L54;
        if (this.f116486b == true) goto L54;
    L55:
        r103.element = true;
    L54:
        if (this.f116488d == false) goto L56;
    L44:
        r122 = r211;
        goto L37
    L45:
        r125 = "close";
    L23:
        r107 = null;
    L28:
        r107 = "";
    L31:
        r107 = "";
        r120 = false;
        r119 = -1;
    L30:
        r116 = "";
    L33:
        r107 = "";
        r116 = r107;
        r120 = false;
        r119 = -1;
        r115 = null;
    L32:
        r114 = null;
    L34:
        r107 = "";
        r116 = r107;
        r120 = false;
        r119 = -1;
        r115 = null;
        r114 = null;
        r112 = null;
    L13:
        r105 = "";
        goto L14
    L5:
        r101 = true;
        goto L6
    }

    @Override // f10.a
    public final void xg(com.bytedance.android.live.broadcastgame.api.model.u r100) {
        Intrinsics.checkNotNullParameter(r100, "interactItem");
        Intrinsics.checkNotNullParameter(r100, "interactItem");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f116490f = r100;
    }

    public final void g(String r100, String r101) {
        RoomContext.a r102 = RoomContext.Companion;
        DataCenter r103 = this.f116485a;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L5:
        RoomContext r104 = RoomContext.a.c(r102, r103, 0, 2);
        if (r104 == null) goto L17;
        com.bytedance.live.datacontext.m<Room> r105 = r104.getRoom();
        if (r105 == null) goto L17;
        Room r106 = r105.getValue();
        if (r106 == null) goto L17;
        RoomSpecificSceneTypeInfo r107 = r106.getSceneTypeInfo();
        if (r107 == null) goto L17;
        if (r107.isLandscapeVertical() != true) goto L17;
        com.bytedance.android.live.core.utils.f2.c("横屏开播无法使用互动特效", 0);
        xs2.b r108 = xs2.b.a();
        String r109 = this.f116490f.e();
        boolean r110 = this.f116486b;
        r108.post(new com.bytedance.android.live.broadcastgame.api.model.f0(r109, ReloadPanelType.FROM_CAHCE, false, r110, 4));
        return;
    L17:
        IKtvService r111 = (IKtvService) jc1.k.f(IKtvService.class);
        if (r111 != null) goto L20;
    L24:
        IKtvService r112 = (IKtvService) jc1.k.f(IKtvService.class);
        if (r112 == null) goto L30;
        r112.openEffectMusicSelect(r101, new p3(this, r100));
        return;
    L30:
        return;
    L20:
        if (r111.isKtvComponentOpen() != true) goto L24;
        com.bytedance.android.live.core.utils.f2.c("建议关闭k歌后再开启互动特效", 0);
        IKtvService r113 = (IKtvService) jc1.k.f(IKtvService.class);
        if (r113 == null) goto L28;
        r113.openEffectMusicSelect(r101, new p3(this, r100));
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f116485a = r101;
    }

    public final void b(String r100, Context r101, boolean r102) {
        f(r100, "show", "");
        View r103 = LayoutInflater.from(r101).inflate(R.layout.ttlive_view_dialog_text, null);
        TextView r104 = (TextView) r103.findViewById(R.id.title);
        TextView r105 = (TextView) r103.findViewById(R.id.sub_title);
        r104.setText("确认退出互动特效");
        UtilityKotlinExtentionsKt.z(r105, false);
        com.bytedance.android.livesdk.widget.z0.a().getClass();
        com.bytedance.android.livesdk.widget.x0.b r106 = new com.bytedance.android.livesdk.widget.x0.b(r101, 4);
        com.bytedance.android.livesdk.widget.x0.d r107 = r106.f162238a;
        r107.f162253l = false;
        r107.f162247f = r103;
        r106.j(0, "确认", new e(this, r100, r102));
        r106.j(1, "取消", new f(this, r100));
        r106.k(0, true);
        r106.n();
    }

    public final void f(String r100, String r101, String r102) {
        Map<String, String> r103 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("app_id", r100), TuplesKt.to(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "interactive_extension_homepage"), TuplesKt.to("extension_name", this.f116490f.name), TuplesKt.to("extension_type", "互动特效"), TuplesKt.to("click_btn_type", r102), TuplesKt.to("action_type", r101)});
        String r104 = this.f116490f.extra;
        LiveSeiUtil.f71508i.getClass();     // Catch: Exception -> L6
        JSONObject r105 = LiveSeiUtil.c(r104);     // Catch: Exception -> L6
        r103.put("plugin_type", r105.optString("plugin_type"));     // Catch: Exception -> L6
        r103.put("price", r105.optString("single_month_price"));     // Catch: Exception -> L6
        r103.put("app_type", r105.optString("plugin_type"));     // Catch: Exception -> L6
        Unit r106 = Unit.INSTANCE;     // Catch: Exception -> L6
    L4:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_interactive_extension_quit_popup", r103, new Object[]{IRoom.class});
    }

    public final void c(String r110, String r111, boolean r112, boolean r113, id2.c r114) {
        RoomContext.a r100 = RoomContext.Companion;
        RoomContext r101 = RoomContext.a.c(r100, null, 0, 3);
        boolean r102 = false;
        if (r101 == null) goto L19;
        com.bytedance.live.datacontext.i<Boolean> r103 = r101.isAnchor();
        if (r103 == null) goto L19;
        if (r103.getValue().booleanValue() != true) goto L19;
        RoomContext r104 = RoomContext.a.c(r100, null, 0, 3);
        if (r104 == null) goto L13;
        com.bytedance.live.datacontext.i<LiveMode> r105 = r104.getLiveMode();
        if (r105 == null) goto L13;
        LiveMode r106 = r105.getValue();
    L15:
        if (r106 == LiveMode.VIDEO) goto L19;
        com.bytedance.android.live.core.utils.f2.c("请在视频开播时使用特效", 0);
        e();
        return;
    L13:
        r106 = null;
    L19:
        if (r111.length() != 0) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == false) goto L24;
    L34:
        e();
        return;
    L24:
        if (r110.length() != 0) goto L26;
        r102 = true;
    L26:
        if (r102 == true) goto L34;
        RoomContext r108 = RoomContext.a.c(r100, null, 0, 3);
        if (r108 == null) goto L33;
        com.bytedance.live.datacontext.n<String> r109 = r108.getDownLoadingInteractEffectId();
        if (r109 == null) goto L33;
        r109.setValue(r110);
    L33:
        List<String> r115 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).d().fetchEffect(r110, new g(this, r113, r112, r114, r110, r111));
        return;
    L21:
        r107 = false;
        goto L22
    }

    public static /* synthetic */ void d(m3 r100, String r101, String r102, boolean r103, boolean r110, int r111) {
        if ((r111 & 8) == 0) goto L5;
        boolean r104 = false;
    L6:
        r100.c(r101, r102, r103, r104, null);
        return;
    L5:
        r104 = r110;
        goto L6
    }
}

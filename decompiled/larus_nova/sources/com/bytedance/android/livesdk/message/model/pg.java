package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.NotifyEffectMessage")
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0003?@AB\u0007¢\u0006\u0004\b=\u0010>R*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R0\u0010)\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006B"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/pg;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/live/base/model/message/h3;", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "icons", "Ljava/util/List;", "getIcons", "()Ljava/util/List;", "setIcons", "(Ljava/util/List;)V", "Lcom/bytedance/android/livesdkapi/message/Text;", "text", "Lcom/bytedance/android/livesdkapi/message/Text;", "getText", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "Lcom/bytedance/android/livesdk/message/model/pg$a;", "background", "Lcom/bytedance/android/livesdk/message/model/pg$a;", "getBackground", "()Lcom/bytedance/android/livesdk/message/model/pg$a;", ExifInterface.LONGITUDE_EAST, "(Lcom/bytedance/android/livesdk/message/model/pg$a;)V", "Lcom/bytedance/android/livesdk/message/model/pg$b;", "dynamicConfig", "Lcom/bytedance/android/livesdk/message/model/pg$b;", "getDynamicConfig", "()Lcom/bytedance/android/livesdk/message/model/pg$b;", FaceService.neutralLabel, "(Lcom/bytedance/android/livesdk/message/model/pg$b;)V", "Lcom/bytedance/android/livesdk/message/model/pg$c;", "sceneConfig", "Lcom/bytedance/android/livesdk/message/model/pg$c;", "getSceneConfig", "()Lcom/bytedance/android/livesdk/message/model/pg$c;", "P", "(Lcom/bytedance/android/livesdk/message/model/pg$c;)V", "", "", "buriedPoint", "Ljava/util/Map;", "getBuriedPoint", "()Ljava/util/Map;", "setBuriedPoint", "(Ljava/util/Map;)V", "Lcom/bytedance/android/live/base/model/message/d;", "combinedText", "Lcom/bytedance/android/live/base/model/message/d;", "I0", "()Lcom/bytedance/android/live/base/model/message/d;", "G", "(Lcom/bytedance/android/live/base/model/message/d;)V", "", "supportLandscape", "Z", "O", "()Z", "setSupportLandscape", "(Z)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class pg extends o0 implements com.bytedance.android.live.base.model.message.h3, vh7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f153681a;

    @SerializedName("background")
    protected a background;

    @SerializedName("buried_point")
    protected Map<String, String> buriedPoint;

    @SerializedName("text_v2")
    protected com.bytedance.android.live.base.model.message.d combinedText;

    @SerializedName("dynamic_config")
    protected b dynamicConfig;

    @SerializedName("icons")
    protected List<? extends ImageModel> icons;

    @SerializedName("scene_config")
    protected c sceneConfig;

    @SerializedName("support_landscape")
    protected boolean supportLandscape;

    @SerializedName("text")
    protected Text text;

    @ProtoMessage("webcast.im.NotifyEffectMessage.Background")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/pg$a;", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "backgroundImage", "Lcom/bytedance/android/live/base/model/ImageModel;", "getBackgroundImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "d", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "backgroundColor", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "backgroundEffect", "getBackgroundEffect", "setBackgroundEffect", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("background_color")
        protected String backgroundColor;

        @SerializedName("background_effect")
        protected ImageModel backgroundEffect;

        @SerializedName("background_image")
        protected ImageModel backgroundImage;

        public a() {
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            if (r102 != 1) goto L8;
            this.backgroundImage = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L8:
            if (r102 != 10) goto L10;
            this.backgroundColor = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 11) goto L11;
            this.backgroundEffect = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
        }

        public final py.k a() {
            return this.backgroundImage;
        }

        public final String b() {
            return this.backgroundColor;
        }

        public final ImageModel c() {
            return this.backgroundEffect;
        }

        public final void d(ImageModel r100) {
            this.backgroundImage = r100;
        }
    }

    @ProtoMessage("webcast.im.NotifyEffectMessage.DynamicConfig")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/pg$b;", "Lcom/bytedance/android/live/base/model/message/u0;", "", "stayTime", "I", "getStayTime", "()I", "d", "(I)V", "maxStayTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "c", "displayEffectType", "b", "setDisplayEffectType", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements com.bytedance.android.live.base.model.message.u0, vh7.h {

        @SerializedName("display_effect_type")
        protected int displayEffectType;

        @SerializedName("max_stay_time")
        protected int maxStayTime;

        @SerializedName("stay_time")
        protected int stayTime;

        public b() {
        }

        public final void c() {
            this.maxStayTime = 3001;
        }

        public final void d() {
            this.stayTime = 3000;
        }

        @Override // com.bytedance.android.live.base.model.message.u0
        public final int a() {
            return this.maxStayTime;
        }

        public final int b() {
            return this.displayEffectType;
        }

        @Override // com.bytedance.android.live.base.model.message.u0
        public final int getStayTime() {
            return this.stayTime;
        }

        public b(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            if (r102 != 1) goto L8;
            this.stayTime = r100.i();
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.maxStayTime = r100.i();
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.displayEffectType = r100.i();
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
        }
    }

    @ProtoMessage("webcast.im.NotifyEffectMessage.SceneConfig")
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/pg$c;", "Lcom/bytedance/android/live/base/model/message/g4;", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", RXScreenCaptureService.KEY_INDEX, "(Ljava/lang/String;)V", "", "priority", "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "h", "(Ljava/lang/Long;)V", "", "needAggregate", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "setNeedAggregate", "(Ljava/lang/Boolean;)V", "aggregateNum", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, com.amap.api.col.s.ce.f26391f, "Lcom/bytedance/android/livesdkapi/message/Text;", "aggregateText", "Lcom/bytedance/android/livesdkapi/message/Text;", "getAggregateText", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setAggregateText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "subScene", "e", "setSubScene", "validTime", "J", "f", "()J", "setValidTime", "(J)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c implements com.bytedance.android.live.base.model.message.g4, vh7.h {

        @SerializedName("aggregate_num")
        protected Long aggregateNum;

        @SerializedName("aggregate_text")
        protected Text aggregateText;

        @SerializedName("need_aggregate")
        protected Boolean needAggregate;

        @SerializedName("priority")
        protected Long priority;

        @SerializedName("scene")
        protected String scene;

        @SerializedName(BdpAppEventConstant.PARAMS_SUB_SCENE)
        protected String subScene;

        @SerializedName("max_wait_time")
        protected long validTime;

        public c() {
        }

        public final Long a() {
            return this.aggregateNum;
        }

        public final Text b() {
            return this.aggregateText;
        }

        public final Boolean c() {
            return this.needAggregate;
        }

        public final Long d() {
            return this.priority;
        }

        public final String e() {
            return this.subScene;
        }

        public final long f() {
            return this.validTime;
        }

        @Override // com.bytedance.android.live.base.model.message.g4
        public final String getScene() {
            return this.scene;
        }

        public c(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L14;
            switch(r102) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            this.validTime = r100.j();
            goto L3
        L8:
            this.subScene = am3.h.c(r100);
            goto L3
        L9:
            this.aggregateText = _Text_ProtoDecoder.decodeStatic(r100);
            goto L3
        L10:
            this.aggregateNum = Long.valueOf(r100.j());
            goto L3
        L11:
            this.needAggregate = Boolean.valueOf(am3.h.a(r100));
            goto L3
        L12:
            this.priority = Long.valueOf(r100.j());
            goto L3
        L13:
            this.scene = am3.h.c(r100);
            goto L3
        L6:
            am3.h.e(r100);
            goto L3
        L14:
            r100.d(r101);
        }

        public final void g(Long r100) {
            this.aggregateNum = r100;
        }

        public final void h(Long r100) {
            this.priority = r100;
        }

        public final void i(String r100) {
            this.scene = "livehead_enter_prompt_interact_gift";
        }
    }

    @Override // com.bytedance.android.live.base.model.message.h3
    public final long o1() {
        c r100 = this.sceneConfig;
        if (r100 == null) goto L7;
        Long r101 = r100.priority;
        if (r101 == null) goto L7;
        return r101.longValue();
    L7:
        return 0;
    }

    public pg() {
        this.type = MessageType.NOTIFY_EFFECT;
    }

    @Override // com.bytedance.android.live.base.model.message.h3
    public final com.bytedance.android.live.base.model.message.d I0() {
        return this.combinedText;
    }

    @Override // com.bytedance.android.live.base.model.message.h3
    public final c M() {
        return this.sceneConfig;
    }

    @Override // com.bytedance.android.live.base.model.message.h3
    public final List<py.k> N() {
        return this.icons;
    }

    @Override // com.bytedance.android.live.base.model.message.h3
    public final boolean O() {
        return this.supportLandscape;
    }

    @Override // com.bytedance.android.live.base.model.message.h3
    public final a getBackground() {
        return this.background;
    }

    @Override // com.bytedance.android.live.base.model.message.h3
    public final Map<String, String> getBuriedPoint() {
        return this.buriedPoint;
    }

    @Override // com.bytedance.android.live.base.model.message.h3
    public final b getDynamicConfig() {
        return this.dynamicConfig;
    }

    @Override // com.bytedance.android.live.base.model.message.h3
    public final long getShowTime() {
        return this.f153681a;
    }

    @Override // com.bytedance.android.live.base.model.message.h3
    public final com.bytedance.android.live.base.model.message.a5 getText() {
        return this.text;
    }

    public pg(am3.g r110) {
        this.icons = new ArrayList();
        this.buriedPoint = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L37;
        if (r101 != 10) goto L8;
        this.sceneConfig = new c(r110);
        goto L3
    L8:
        if (r101 != 20) goto L9;
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L19:
        int r105 = r110.f();
        if (r105 == (-1)) goto L28;
        if (r105 != 1) goto L24;
        r103 = am3.h.c(r110);
        goto L19
    L24:
        if (r105 != 2) goto L25;
        r104 = am3.h.c(r110);
        goto L19
    L25:
        am3.h.e(r110);
        goto L19
    L28:
        r110.d(r102);
        Map<String, String> r106 = this.buriedPoint;
        if (r103 == null) goto L35;
        if (r104 == null) goto L33;
        r106.put(r103, r104);
        goto L3
    L33:
        throw new IllegalStateException("Value must not be null");
    L35:
        throw new IllegalStateException("Key must not be null");
    L9:
        switch(r101) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L10;
        };
    L11:
        this.supportLandscape = am3.h.a(r110);
        goto L3
    L12:
        this.combinedText = new com.bytedance.android.live.base.model.message.d(r110);
        goto L3
    L13:
        this.dynamicConfig = new b(r110);
        goto L3
    L14:
        this.background = new a(r110);
        goto L3
    L15:
        this.text = _Text_ProtoDecoder.decodeStatic(r110);
        goto L3
    L16:
        this.icons.add(com.bytedance.android.live.base.model.x.a(r110));
        goto L3
    L17:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r110);
        goto L3
    L10:
        am3.h.e(r110);
        goto L3
    L37:
        r110.d(r100);
        this.type = MessageType.NOTIFY_EFFECT;
    }

    public final void E(a r100) {
        this.background = r100;
    }

    public final void G(com.bytedance.android.live.base.model.message.d r100) {
        this.combinedText = r100;
    }

    public final void H(b r100) {
        this.dynamicConfig = r100;
    }

    public final void P(c r100) {
        this.sceneConfig = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.h3
    public final void l1(long r100) {
        this.f153681a = r100;
    }
}

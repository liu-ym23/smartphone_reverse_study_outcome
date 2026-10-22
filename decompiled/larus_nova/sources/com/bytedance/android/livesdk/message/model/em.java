package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.FlexImageStruct;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ToolbarItemMessage")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0004()*+B\u0007¢\u0006\u0004\b&\u0010'R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR0\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/em;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "", "toolbarItemId", "I", FaceService.neutralLabel, "()I", "setToolbarItemId", "(I)V", ReportConstant.COMMON_ACTION_TYPE, "getActionType", "setActionType", "", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "messageType", "getMessageType", "setMessageType", "Lcom/bytedance/android/livesdk/message/model/em$a;", "bubbleConfig", "Lcom/bytedance/android/livesdk/message/model/em$a;", "G", "()Lcom/bytedance/android/livesdk/message/model/em$a;", "setBubbleConfig", "(Lcom/bytedance/android/livesdk/message/model/em$a;)V", "Lcom/bytedance/android/livesdk/message/model/em$d;", "behaviourParams", "Lcom/bytedance/android/livesdk/message/model/em$d;", "getBehaviourParams", "()Lcom/bytedance/android/livesdk/message/model/em$d;", "setBehaviourParams", "(Lcom/bytedance/android/livesdk/message/model/em$d;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class em extends o0 implements vh7.h {

    @SerializedName("action_type")
    protected int actionType;

    @SerializedName("behaviour_params")
    protected d behaviourParams;

    @SerializedName("bubble_config")
    protected a bubbleConfig;

    @SerializedName("extra")
    protected Map<String, String> extra;

    @SerializedName("message_type")
    protected int messageType;

    @SerializedName("toolbar_item_id")
    protected int toolbarItemId;

    @ProtoMessage("webcast.im.BubbleConfig")
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b3\u0010\nR(\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR$\u0010-\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010%\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R$\u00100\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010%\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/em$a;", "", "", "content", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getContent$annotations", "()V", "Lcom/bytedance/android/livesdkapi/message/Text;", "richText", "Lcom/bytedance/android/livesdkapi/message/Text;", com.amap.api.col.s.ce.f26391f, "()Lcom/bytedance/android/livesdkapi/message/Text;", "setRichText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "schemeUrl", "h", "setSchemeUrl", "", "duration", "I", "d", "()I", "setDuration", "(I)V", "Lcom/bytedance/android/live/base/model/FlexImageStruct;", "backgroundImage", "Lcom/bytedance/android/live/base/model/FlexImageStruct;", "getBackgroundImage", "()Lcom/bytedance/android/live/base/model/FlexImageStruct;", "setBackgroundImage", "(Lcom/bytedance/android/live/base/model/FlexImageStruct;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "arrowImage", "Lcom/bytedance/android/live/base/model/ImageModel;", "getArrowImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setArrowImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "title", RXScreenCaptureService.KEY_INDEX, com.alipay.sdk.m.x.d.f25925o, "icon", "e", "setIcon", "landingIcon", "f", "setLandingIcon", "<init>", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Text f153636a = null;

        @SerializedName("arrow_image")
        protected ImageModel arrowImage;

        @SerializedName("background_image")
        protected FlexImageStruct backgroundImage;

        @SerializedName("content")
        protected String content;

        @SerializedName("duration")
        protected int duration;

        @SerializedName("icon")
        protected ImageModel icon;

        @SerializedName("landing_icon")
        protected ImageModel landingIcon;

        @SerializedName("rich_text")
        protected Text richText;

        @SerializedName("scheme_url")
        protected String schemeUrl;

        @SerializedName("title")
        protected String title;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.message.model.em$a$a, reason: collision with other inner class name */
        public static final class C2364a {
        }

        static {
            f153636a = new Text();
        }

        public final ImageModel a() {
            ImageModel r100 = this.arrowImage;
            if (r100 == null) goto L9;
            Intrinsics.checkNotNull(r100);
            if (r100.getUrls() == null) goto L9;
            ImageModel r101 = this.arrowImage;
            Intrinsics.checkNotNull(r101);
            if (r101.getUrls().size() <= 0) goto L9;
            return this.arrowImage;
        L9:
            return null;
        }

        public final ImageModel b() {
            FlexImageStruct r100 = this.backgroundImage;
            if (r100 == null) goto L9;
            Intrinsics.checkNotNull(r100);
            if (r100.urlList == null) goto L9;
            FlexImageStruct r101 = this.backgroundImage;
            Intrinsics.checkNotNull(r101);
            List<String> r102 = r101.urlList;
            Intrinsics.checkNotNull(r102);
            if (r102.size() <= 0) goto L9;
            FlexImageStruct r103 = this.backgroundImage;
            Intrinsics.checkNotNull(r103);
            String r104 = r103.uri;
            FlexImageStruct r105 = this.backgroundImage;
            Intrinsics.checkNotNull(r105);
            return new ImageModel(r104, r105.urlList);
        L9:
            return null;
        }

        public a() {
            this.content = "";
            this.richText = f153636a;
            this.schemeUrl = "";
            this.duration = 3;
            this.title = "";
        }

        public final String c() {
            return this.content;
        }

        public final int d() {
            return this.duration;
        }

        public final ImageModel e() {
            return this.icon;
        }

        public final ImageModel f() {
            return this.landingIcon;
        }

        public final Text g() {
            return this.richText;
        }

        public final String h() {
            return this.schemeUrl;
        }

        public final String i() {
            return this.title;
        }

        public a(am3.g r100) {
            long r101 = r100.c();
            boolean r102 = false;
        L3:
            int r103 = r100.f();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            this.landingIcon = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L8:
            this.icon = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L9:
            this.title = am3.h.c(r100);
            goto L3
        L10:
            this.arrowImage = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L11:
            this.backgroundImage = new FlexImageStruct(r100);
            goto L3
        L12:
            this.schemeUrl = am3.h.c(r100);
            goto L3
        L13:
            this.richText = _Text_ProtoDecoder.decodeStatic(r100);
            goto L3
        L14:
            this.duration = (int) r100.j();
            r102 = r102 | true;
            goto L3
        L15:
            this.content = am3.h.c(r100);
            goto L3
        L6:
            am3.h.e(r100);
            goto L3
        L16:
            r100.d(r101);
            if (this.content != null) goto L20;
            this.content = "";
        L20:
            if (this.richText != null) goto L23;
            this.richText = f153636a;
        L23:
            if (this.schemeUrl != null) goto L26;
            this.schemeUrl = "";
        L26:
            if ((r102 & true) == true) goto L29;
            this.duration = 3;
        L29:
            if (this.title != null) goto L54;
            this.title = "";
            return;
        }
    }

    public static final class b {
    }

    @ProtoMessage("webcast.im.ToolbarItemBehaviourParam")
    public static final class c extends gm2.a implements vh7.h {
        public c() {
            this.values = "";
        }

        public c(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.behaviourType = r100.i();
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.values = am3.h.c(r100);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
            if (this.values != null) goto L25;
            this.values = "";
            return;
        }
    }

    @ProtoMessage("webcast.im.ToolbarItemBehaviourParams")
    public static final class d extends gm2.b implements vh7.h {
        public d(am3.g r100) {
            this.params = new ArrayList();
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.key = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.params.add(new c(r100));
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
            if (this.key != null) goto L16;
            this.key = "";
        L16:
            if (this.params.isEmpty() == false) goto L28;
            this.params = new ArrayList();
            return;
        }
    }

    static {
    }

    public em() {
        this.messageType = 1;
        this.bubbleConfig = new a();
        this.type = MessageType.TOOLBAR_ITEM_MESSAGE;
    }

    public final a G() {
        return this.bubbleConfig;
    }

    public final int H() {
        return this.toolbarItemId;
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final int getMessageType() {
        return this.messageType;
    }

    public em(am3.g r110) {
        this.extra = new HashMap();
        long r100 = r110.c();
        boolean r101 = false;
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L30;
        switch(r102) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.behaviourParams = new d(r110);
        goto L3
    L8:
        this.messageType = r110.i();
        r101 = r101 | true;
        goto L3
    L9:
        long r103 = r110.c();
        String r104 = null;
        String r105 = null;
    L10:
        int r106 = r110.f();
        if (r106 == (-1)) goto L18;
        if (r106 != 1) goto L14;
        r104 = am3.h.c(r110);
        goto L10
    L14:
        if (r106 != 2) goto L15;
        r105 = am3.h.c(r110);
        goto L10
    L15:
        am3.h.e(r110);
        goto L10
    L18:
        r110.d(r103);
        Map<String, String> r107 = this.extra;
        if (r104 == null) goto L25;
        if (r105 == null) goto L23;
        r107.put(r104, r105);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L26:
        this.bubbleConfig = new a(r110);
        goto L3
    L27:
        this.actionType = r110.i();
        goto L3
    L28:
        this.toolbarItemId = r110.i();
        goto L3
    L29:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r110);
        goto L3
    L6:
        am3.h.e(r110);
        goto L3
    L30:
        r110.d(r100);
        if ((r101 & true) == true) goto L34;
        this.messageType = 1;
    L34:
        if (this.bubbleConfig != null) goto L36;
        this.bubbleConfig = new a();
    L36:
        this.type = MessageType.TOOLBAR_ITEM_MESSAGE;
    }

    public final boolean E(String r110, long r111) {
        int r100 = this.actionType;
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 != 2) goto L7;
        return true;
    L7:
        if (r100 == 3) goto L9;
    L34:
        return false;
    L9:
        if (this.behaviourParams == null) goto L48;
        SimpleDateFormat r101 = gm2.p.f481658a;
        Intrinsics.checkNotNull(r110);
        String r112 = String.valueOf(r111);
        d r113 = this.behaviourParams;
        Intrinsics.checkNotNull(r113);
        Intrinsics.checkNotNullParameter(r110, "userId");
        Intrinsics.checkNotNullParameter(r112, "roomId");
        Intrinsics.checkNotNullParameter(r113, "behaviourParams");
    L29:
        th = move-exception;
        th.printStackTrace();
    L31:
        boolean r114 = true;
    L32:
        if (r114 == false) goto L34;
        return true;
    L12:
        if (ListUtils.isEmpty(r113.params) == true) goto L31;
        String r102 = r113.key;     // Catch: Throwable -> L29
        String r103 = gm2.p.f481658a.format(new Date());     // Catch: Throwable -> L29
        com.bytedance.android.livesdk.sharedpref.e<Map<String, Map<String, Double>>> r104 = com.bytedance.android.livesdk.sharedpref.b.f158215t2;     // Catch: Throwable -> L29
        Map<String, Map<String, Double>> r105 = r104.getValue();     // Catch: Throwable -> L29
        Map<String, Double> r106 = r105.get(r102);     // Catch: Throwable -> L29
        if (r106 != null) goto L16;
        HashMap r115 = new HashMap();     // Catch: Throwable -> L29
        gm2.p.b(r115, r102, r103, r110, r112);     // Catch: Throwable -> L29
        r105.put(r102, r115);     // Catch: Throwable -> L29
        r104.getClass();     // Catch: Throwable -> L29
        com.bytedance.android.livesdk.sharedpref.f.d(r104, r105);     // Catch: Throwable -> L29
        goto L31
    L16:
        Iterator<c> r116 = r113.params.iterator();     // Catch: Throwable -> L29
    L18:
        if (r116.hasNext() == false) goto L27;
        c r107 = r116.next();     // Catch: Throwable -> L29
        if (ListUtils.isEmpty(r107.a()) == true) goto L18;
        long r108 = ((Number) ListProtector.get(r107.a(), 0)).longValue();     // Catch: Throwable -> L29
        Double r109 = r106.get(gm2.p.a(r107.behaviourType, r102, r103, r110, r112));     // Catch: Throwable -> L29
        if (r109 == null) goto L18;
        if (r109.doubleValue() < r108) goto L18;
        r114 = false;
        goto L32
    L27:
        gm2.p.b(r106, r102, r103, r110, r112);     // Catch: Throwable -> L29
        r105.put(r102, r106);     // Catch: Throwable -> L29
        com.bytedance.android.livesdk.sharedpref.e<Map<String, Map<String, Double>>> r117 = com.bytedance.android.livesdk.sharedpref.b.f158215t2;     // Catch: Throwable -> L29
        r117.getClass();     // Catch: Throwable -> L29
        com.bytedance.android.livesdk.sharedpref.f.d(r117, r105);     // Catch: Throwable -> L29
        goto L31
    L48:
        return true;
    }
}

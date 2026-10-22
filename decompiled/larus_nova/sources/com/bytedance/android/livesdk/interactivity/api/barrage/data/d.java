package com.bytedance.android.livesdk.interactivity.api.barrage.data;

import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0001vB\u0007¢\u0006\u0004\bt\u0010uR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010!\u001a\u0004\b.\u0010#\"\u0004\b/\u0010%R$\u00100\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010!\u001a\u0004\b1\u0010#\"\u0004\b2\u0010%R\"\u00103\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u000b\u001a\u0004\b4\u0010\r\"\u0004\b5\u0010\u000fR*\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R*\u0010?\u001a\n\u0012\u0004\u0012\u00020>\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u00109\u001a\u0004\b@\u0010;\"\u0004\bA\u0010=R\"\u0010B\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010\u000b\u001a\u0004\bC\u0010\r\"\u0004\bD\u0010\u000fR\"\u0010E\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u000b\u001a\u0004\bF\u0010\r\"\u0004\bG\u0010\u000fR\"\u0010H\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bH\u0010\u000b\u001a\u0004\bI\u0010\r\"\u0004\bJ\u0010\u000fR0\u0010L\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010K8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR*\u0010R\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u00109\u001a\u0004\bS\u0010;\"\u0004\bT\u0010=R*\u0010U\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u00109\u001a\u0004\bV\u0010;\"\u0004\bW\u0010=R*\u0010X\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bX\u00109\u001a\u0004\bY\u0010;\"\u0004\bZ\u0010=R$\u0010[\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010!\u001a\u0004\b\\\u0010#\"\u0004\b]\u0010%R\"\u0010^\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b^\u0010\u000b\u001a\u0004\b_\u0010\r\"\u0004\b`\u0010\u000fR\"\u0010a\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u0010\u000b\u001a\u0004\bb\u0010\r\"\u0004\bc\u0010\u000fR\"\u0010d\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bd\u0010\u000b\u001a\u0004\be\u0010\r\"\u0004\bf\u0010\u000fR\"\u0010g\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bg\u0010\u000b\u001a\u0004\bh\u0010\r\"\u0004\bi\u0010\u000fR$\u0010k\u001a\u0004\u0018\u00010j8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010q\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bq\u0010\u000b\u001a\u0004\br\u0010\r\"\u0004\bs\u0010\u000f¨\u0006w"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/d;", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;", "Lcom/bytedance/android/live/base/model/message/m0;", "commonData", "Lcom/bytedance/android/live/base/model/message/m0;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "", "notifyType", "J", "getNotifyType", "()J", "setNotifyType", "(J)V", "anchorStartTimestamp", "getAnchorStartTimestamp", "setAnchorStartTimestamp", "anchorStartSecond", "getAnchorStartSecond", "setAnchorStartSecond", "userStartTimestamp", "x", "setUserStartTimestamp", "userStartSecond", "getUserStartSecond", "setUserStartSecond", "duration", "getDuration", "setDuration", "", "trayBackgroundColor", "Ljava/lang/String;", "getTrayBackgroundColor", "()Ljava/lang/String;", "setTrayBackgroundColor", "(Ljava/lang/String;)V", "Lpy/k;", "titleImage", "Lpy/k;", "getTitleImage", "()Lpy/k;", "setTitleImage", "(Lpy/k;)V", "preContent", "getPreContent", "setPreContent", "content", "getContent", "setContent", "moveSpeed", "t", "setMoveSpeed", "", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/f;", "chatItem", "Ljava/util/List;", "q", "()Ljava/util/List;", "setChatItem", "(Ljava/util/List;)V", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/i;", "eggItem", "r", "setEggItem", "pathType", "u", "setPathType", "wordDirection", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "setWordDirection", "moveDirection", ce.f26396k, "setMoveDirection", "", "remoteExtraInfo", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "setRemoteExtraInfo", "(Ljava/util/Map;)V", "eggShowRange", "s", "setEggShowRange", "sizeAndAlpha", BaseSwitches.V, "setSizeAndAlpha", "verticalOffset", "y", "setVerticalOffset", "trayWordColor", "getTrayWordColor", "setTrayWordColor", "showWebp", "getShowWebp", "setShowWebp", "usePrivilegeRegion", "getUsePrivilegeRegion", "setUsePrivilegeRegion", "canOpenContour", "p", "setCanOpenContour", "supportShowType", "w", "setSupportShowType", "Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "highlightAreaPriorityConfig", "Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "getHighlightAreaPriorityConfig", "()Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "setHighlightAreaPriorityConfig", "(Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;)V", "angle", ce.f26395j, "setAngle", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d implements com.bytedance.android.livesdk.interactivity.api.barrage.model.a, vh7.h {

    @SerializedName("anchor_start_second")
    protected long anchorStartSecond;

    @SerializedName("anchor_start_timestamp")
    protected long anchorStartTimestamp;

    @SerializedName("orientations")
    protected long angle;

    @SerializedName("can_open_contour")
    protected long canOpenContour;

    @SerializedName("chat_style")
    protected List<f> chatItem;

    @SerializedName("common")
    protected m0 commonData;

    @SerializedName("content")
    protected String content;

    @SerializedName("duration")
    protected long duration;

    @SerializedName("egg_style")
    protected List<i> eggItem;

    @SerializedName("egg_show_range")
    protected List<Long> eggShowRange;

    @SerializedName("highlight_area_priority_config")
    protected HighlightAreaPriorityConfig highlightAreaPriorityConfig;

    @SerializedName("move_direction")
    protected long moveDirection;

    @SerializedName("move_speed")
    protected long moveSpeed;

    @SerializedName("notify_type")
    protected long notifyType;

    @SerializedName("path")
    protected long pathType;

    @SerializedName("pre_content")
    protected String preContent;

    @SerializedName("extra")
    protected Map<String, String> remoteExtraInfo;

    @SerializedName("show_webp")
    protected long showWebp;

    @SerializedName("size_and_alpha")
    protected List<Long> sizeAndAlpha;

    @SerializedName("support_show_type")
    protected long supportShowType;

    @SerializedName("title_image")
    protected py.k titleImage;

    @SerializedName("background_color")
    protected String trayBackgroundColor;

    @SerializedName("word_color")
    protected String trayWordColor;

    @SerializedName("use_privilege_region")
    protected long usePrivilegeRegion;

    @SerializedName("user_start_second")
    protected long userStartSecond;

    @SerializedName("user_start_timestamp")
    protected long userStartTimestamp;

    @SerializedName("vertical_offset")
    protected List<Long> verticalOffset;

    @SerializedName("word_orientation")
    protected long wordDirection;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final boolean a() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final long getMessageId() {
        m0 r100 = this.commonData;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getMessageId();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final long n() {
        long r100 = this.userStartTimestamp;
        if (r100 != 0) goto L6;
        return this.duration;
    L6:
        return ((r100 * ((long) 1000)) + this.duration) - (com.bytedance.android.livesdk.utils.ntp.a.f159087a + System.currentTimeMillis());
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final boolean o() {
        if (this.canOpenContour != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public d() {
        this.trayWordColor = CustomHeaderConfig.COLOR_LIGHT;
        this.supportShowType = 2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final String b() {
        return this.trayBackgroundColor;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final long c() {
        return this.showWebp;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final long d() {
        return this.usePrivilegeRegion;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final py.k e() {
        return this.titleImage;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final Map<String, String> f() {
        return this.remoteExtraInfo;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final long g() {
        return this.moveSpeed;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final HighlightAreaPriorityConfig getHighlightAreaPriorityConfig() {
        return this.highlightAreaPriorityConfig;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final long h() {
        return this.notifyType;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final String i() {
        return this.preContent;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final long j() {
        return this.angle;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final long k() {
        return this.moveDirection;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final String l() {
        return this.trayWordColor;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final String m() {
        return this.content;
    }

    public final long p() {
        return this.canOpenContour;
    }

    public final List<f> q() {
        return this.chatItem;
    }

    public final List<i> r() {
        return this.eggItem;
    }

    public final List<Long> s() {
        return this.eggShowRange;
    }

    public final long t() {
        return this.moveSpeed;
    }

    public final long u() {
        return this.pathType;
    }

    public final List<Long> v() {
        return this.sizeAndAlpha;
    }

    public final long w() {
        return this.supportShowType;
    }

    public final long x() {
        return this.userStartTimestamp;
    }

    public final List<Long> y() {
        return this.verticalOffset;
    }

    public final long z() {
        return this.wordDirection;
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.bytedance.android.live.base.model.message.m0, java.lang.Object] */
    public d(am3.g r110) {
        this.chatItem = new ArrayList();
        this.eggItem = new ArrayList();
        this.remoteExtraInfo = new HashMap();
        this.eggShowRange = new ArrayList();
        this.sizeAndAlpha = new ArrayList();
        this.verticalOffset = new ArrayList();
        long r100 = r110.c();
        boolean r101 = false;
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L53;
        switch(r102) {
            case 1: goto L52;
            case 2: goto L51;
            case 3: goto L50;
            case 4: goto L49;
            case 5: goto L48;
            case 6: goto L47;
            case 7: goto L46;
            case 8: goto L45;
            case 9: goto L44;
            case 10: goto L43;
            case 11: goto L42;
            case 12: goto L41;
            case 13: goto L40;
            case 14: goto L38;
            case 15: goto L37;
            case 16: goto L36;
            case 17: goto L35;
            case 18: goto L33;
            case 19: goto L32;
            case 20: goto L31;
            case 21: goto L30;
            case 22: goto L29;
            case 23: goto L28;
            case 24: goto L27;
            case 25: goto L26;
            case 26: goto L25;
            case 27: goto L8;
            case 28: goto L7;
            default: goto L6;
        };
    L7:
        this.highlightAreaPriorityConfig = new HighlightAreaPriorityConfig(r110);
        goto L3
    L8:
        long r103 = r110.c();
        String r104 = null;
        String r105 = null;
    L9:
        int r106 = r110.f();
        if (r106 == (-1)) goto L17;
        if (r106 != 1) goto L13;
        r104 = am3.h.c(r110);
        goto L9
    L13:
        if (r106 != 2) goto L14;
        r105 = am3.h.c(r110);
        goto L9
    L14:
        am3.h.e(r110);
        goto L9
    L17:
        r110.d(r103);
        Map<String, String> r107 = this.remoteExtraInfo;
        if (r104 == null) goto L24;
        if (r105 == null) goto L22;
        r107.put(r104, r105);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        this.supportShowType = r110.j();
        r101 = r101 | true;
        goto L3
    L26:
        this.canOpenContour = r110.j();
        goto L3
    L27:
        this.usePrivilegeRegion = r110.j();
        goto L3
    L28:
        this.showWebp = r110.j();
        goto L3
    L29:
        this.trayWordColor = am3.h.c(r110);
        goto L3
    L30:
        this.pathType = r110.j();
        goto L3
    L31:
        List r108 = this.verticalOffset;
    L34:
        Object r109 = Long.valueOf(r110.j());
    L39:
        r108.add(r109);
        goto L3
    L32:
        r108 = this.sizeAndAlpha;
        goto L34
    L33:
        r108 = this.eggShowRange;
        goto L34
    L35:
        this.moveDirection = r110.j();
        goto L3
    L36:
        this.wordDirection = r110.j();
        goto L3
    L37:
        r108 = this.eggItem;
        r109 = new i(r110);
        goto L39
    L38:
        r108 = this.chatItem;
        r109 = new f(r110);
        goto L39
    L40:
        this.moveSpeed = r110.j();
        goto L3
    L41:
        this.angle = r110.j();
        goto L3
    L42:
        this.content = am3.h.c(r110);
        goto L3
    L43:
        this.preContent = am3.h.c(r110);
        goto L3
    L44:
        this.titleImage = vh7.f.a(r110, py.k.class);
        goto L3
    L45:
        this.trayBackgroundColor = am3.h.c(r110);
        goto L3
    L46:
        this.duration = r110.j();
        goto L3
    L47:
        this.userStartSecond = r110.j();
        goto L3
    L48:
        this.userStartTimestamp = r110.j();
        goto L3
    L49:
        this.anchorStartSecond = r110.j();
        goto L3
    L50:
        this.anchorStartTimestamp = r110.j();
        goto L3
    L51:
        this.notifyType = r110.j();
        goto L3
    L52:
        this.commonData = vh7.f.a(r110, m0.class);
        goto L3
    L6:
        am3.h.e(r110);
        goto L3
    L53:
        r110.d(r100);
        if (this.trayWordColor != null) goto L57;
        this.trayWordColor = CustomHeaderConfig.COLOR_LIGHT;
    L57:
        if ((r101 & true) == true) goto L127;
        this.supportShowType = 2;
        return;
    }

    public final boolean A(boolean r100) {
        if (r100 == false) goto L9;
        long r101 = this.supportShowType;
        if (r101 != 2) goto L7;
    L13:
        return true;
    L7:
        if (r101 == 3) goto L13;
        return false;
    L9:
        long r102 = this.supportShowType;
        if (r102 == 1) goto L13;
        if (r102 == 3) goto L13;
        return false;
    }
}

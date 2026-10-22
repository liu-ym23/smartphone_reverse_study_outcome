package com.bytedance.android.livesdk.message.model;

import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;
import com.bytedance.android.livesdkapi.message.SameTypePKStrategy;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0002\n\u000fB\u0007¢\u0006\u0004\b0\u00101R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001c\u0010(\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\t\u001a\u0004\b-\u0010\u000bR\u001c\u0010.\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/b6;", "", "", "type", "Ljava/lang/Long;", "getType", "()Ljava/lang/Long;", "", "bizScene", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "Lcom/bytedance/android/live/base/model/message/a5;", "displayText", "Lcom/bytedance/android/live/base/model/message/a5;", "b", "()Lcom/bytedance/android/live/base/model/message/a5;", "sceneId", "f", "", "extra", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "priorityConfig", "Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "e", "()Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "showDuration", "h", "", "Lcom/bytedance/android/livesdk/message/model/b6$b;", "triggers", "Ljava/util/List;", RXScreenCaptureService.KEY_INDEX, "()Ljava/util/List;", "animType", "getAnimType", "Lcom/bytedance/android/livesdkapi/message/SameTypePKStrategy;", "sameTypePkStrategy", "Lcom/bytedance/android/livesdkapi/message/SameTypePKStrategy;", "getSameTypePkStrategy", "()Lcom/bytedance/android/livesdkapi/message/SameTypePKStrategy;", "schema", com.amap.api.col.s.ce.f26391f, "operate", "d", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b6 implements vh7.h {

    @SerializedName("anim_type")
    protected Long animType;

    @SerializedName(DyVerifyEventConstants.EventParam.BIZ_SCENE)
    protected String bizScene;

    @SerializedName("display_text")
    protected com.bytedance.android.live.base.model.message.a5 displayText;

    @SerializedName("extra")
    protected Map<String, String> extra;

    @SerializedName("operate")
    protected Long operate;

    @SerializedName("area_priority_config")
    protected HighlightAreaPriorityConfig priorityConfig;

    @SerializedName("same_type_pk_strategy")
    protected SameTypePKStrategy sameTypePkStrategy;

    @SerializedName("scene_id")
    protected Long sceneId;

    @SerializedName("schema")
    protected String schema;

    @SerializedName("show_duration_ms")
    protected Long showDuration;

    @SerializedName("triggers")
    protected List<b> triggers;

    @SerializedName("type")
    protected Long type;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/b6$b;", "", "", "event", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "c", "(Ljava/lang/Long;)V", "", "", "extra", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b implements vh7.h {

        @SerializedName("event")
        protected Long event;

        @SerializedName("extra")
        protected Map<String, String> extra;

        public static final class a {
        }

        static {
        }

        public b() {
            this.event = 0L;
        }

        public final Long a() {
            return this.event;
        }

        public final Map<String, String> b() {
            return this.extra;
        }

        public b(am3.g r110) {
            this.extra = new HashMap();
            long r100 = r110.c();
        L3:
            int r101 = r110.f();
            if (r101 == (-1)) goto L27;
            if (r101 != 1) goto L8;
            this.event = Long.valueOf(r110.j());
            goto L3
        L8:
            if (r101 != 2) goto L9;
            long r102 = r110.c();
            String r103 = null;
            String r104 = null;
        L11:
            int r105 = r110.f();
            if (r105 == (-1)) goto L18;
            if (r105 != 1) goto L14;
            r103 = am3.h.c(r110);
            goto L11
        L14:
            if (r105 != 2) goto L15;
            r104 = am3.h.c(r110);
            goto L11
        L15:
            am3.h.e(r110);
            goto L11
        L18:
            r110.d(r102);
            Map<String, String> r106 = this.extra;
            if (r103 == null) goto L25;
            if (r104 == null) goto L23;
            r106.put(r103, r104);
            goto L3
        L23:
            throw new IllegalStateException("Value must not be null");
        L25:
            throw new IllegalStateException("Key must not be null");
        L9:
            am3.h.e(r110);
            goto L3
        L27:
            r110.d(r100);
            if (this.event != null) goto L51;
            this.event = 0L;
            return;
        }

        public final void c(Long r100) {
            this.event = r100;
        }
    }

    static {
    }

    public b6() {
        this.type = 0L;
    }

    public final String a() {
        return this.bizScene;
    }

    public final com.bytedance.android.live.base.model.message.a5 b() {
        return this.displayText;
    }

    public final Map<String, String> c() {
        return this.extra;
    }

    public final Long d() {
        return this.operate;
    }

    public final HighlightAreaPriorityConfig e() {
        return this.priorityConfig;
    }

    public final Long f() {
        return this.sceneId;
    }

    public final String g() {
        return this.schema;
    }

    public final Long getType() {
        return this.type;
    }

    public final Long h() {
        return this.showDuration;
    }

    public final List<b> i() {
        return this.triggers;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public b6(am3.g r110) {
        this.extra = new HashMap();
        this.triggers = new ArrayList();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L36;
        switch(r101) {
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L6;
            case 12: goto L8;
            case 13: goto L7;
            default: goto L6;
        };
    L7:
        this.operate = Long.valueOf(r110.j());
        goto L3
    L8:
        this.schema = am3.h.c(r110);
        goto L3
    L9:
        this.sameTypePkStrategy = new SameTypePKStrategy(r110);
        goto L3
    L10:
        this.animType = Long.valueOf(r110.j());
        goto L3
    L11:
        this.triggers.add(new b(r110));
        goto L3
    L12:
        this.showDuration = Long.valueOf(r110.j());
        goto L3
    L13:
        this.priorityConfig = new HighlightAreaPriorityConfig(r110);
        goto L3
    L14:
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L15:
        int r105 = r110.f();
        if (r105 == (-1)) goto L24;
        if (r105 != 1) goto L20;
        r103 = am3.h.c(r110);
        goto L15
    L20:
        if (r105 != 2) goto L21;
        r104 = am3.h.c(r110);
        goto L15
    L21:
        am3.h.e(r110);
        goto L15
    L24:
        r110.d(r102);
        Map<String, String> r106 = this.extra;
        if (r103 == null) goto L31;
        if (r104 == null) goto L29;
        r106.put(r103, r104);
        goto L3
    L29:
        throw new IllegalStateException("Value must not be null");
    L31:
        throw new IllegalStateException("Key must not be null");
    L32:
        this.sceneId = Long.valueOf(r110.j());
        goto L3
    L33:
        this.displayText = vh7.f.a(r110, com.bytedance.android.live.base.model.message.a5.class);
        goto L3
    L34:
        this.bizScene = am3.h.c(r110);
        goto L3
    L35:
        this.type = Long.valueOf(r110.j());
        goto L3
    L6:
        am3.h.e(r110);
        goto L3
    L36:
        r110.d(r100);
        if (this.type != null) goto L79;
        this.type = 0L;
        return;
    }
}

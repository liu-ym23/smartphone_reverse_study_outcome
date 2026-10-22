package com.bytedance.android.live.base.model.message;

import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\bg\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003:\u0005;<=>?R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000e\u0010\n\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\n\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\n\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010+\u001a\u0004\u0018\u00010%8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\n\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R0\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010,8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b1\u0010\n\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00109\u001a\u0004\u0018\u0001038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b8\u0010\n\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006@"}, d2 = {"Lcom/bytedance/android/live/base/model/message/n5;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/c3;", "", "", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "getScene$annotations", "()V", "scene", "getSubScene", "setSubScene", "getSubScene$annotations", "subScene", "Lcom/bytedance/android/live/base/model/message/d;", "getContent", "()Lcom/bytedance/android/live/base/model/message/d;", "setContent", "(Lcom/bytedance/android/live/base/model/message/d;)V", "getContent$annotations", "content", "Lcom/bytedance/android/live/base/model/message/n5$a;", "getBackground", "()Lcom/bytedance/android/live/base/model/message/n5$a;", "setBackground", "(Lcom/bytedance/android/live/base/model/message/n5$a;)V", "getBackground$annotations", "background", "Lcom/bytedance/android/live/base/model/message/n5$e;", "getDynamicConfig", "()Lcom/bytedance/android/live/base/model/message/n5$e;", "setDynamicConfig", "(Lcom/bytedance/android/live/base/model/message/n5$e;)V", "getDynamicConfig$annotations", "dynamicConfig", "Lcom/bytedance/android/live/base/model/message/n5$f;", "getPriorityConfig", "()Lcom/bytedance/android/live/base/model/message/n5$f;", "setPriorityConfig", "(Lcom/bytedance/android/live/base/model/message/n5$f;)V", "getPriorityConfig$annotations", "priorityConfig", "", "getEventParams", "()Ljava/util/Map;", "setEventParams", "(Ljava/util/Map;)V", "getEventParams$annotations", "eventParams", "Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "getHighlightAreaPriorityConfig", "()Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "setHighlightAreaPriorityConfig", "(Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;)V", "getHighlightAreaPriorityConfig$annotations", "highlightAreaPriorityConfig", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "e", "f", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface n5 extends vh7.c<n5>, c3 {
    public static final c Companion = null;
    public static final long DEFAULT_SHOW_DURATION = 5000;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/base/model/message/n5$a;", "", "Lpy/k;", "backgroundImage", "Lpy/k;", "", "backgroundColor", "Ljava/lang/String;", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a implements vh7.h {

        @SerializedName("background_color")
        public String backgroundColor;

        @SerializedName("background_image")
        public py.k backgroundImage;

        public a() {
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.backgroundImage = vh7.f.a(r100, py.k.class);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.backgroundColor = am3.h.c(r100);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/base/model/message/n5$b;", "", "", "seqId", "J", "", "numList", "Ljava/util/List;", "durationList", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b implements vh7.h {

        @SerializedName("duration_list")
        public List<Long> durationList;

        @SerializedName("num_list")
        public List<Long> numList;

        @SerializedName("seq_id")
        public long seqId;

        public b() {
        }

        public b(am3.g r100) {
            this.numList = new ArrayList();
            this.durationList = new ArrayList();
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L16;
            if (r102 != 1) goto L8;
            this.seqId = r100.j();
            goto L3
        L8:
            if (r102 == 2) goto L13;
            if (r102 != 3) goto L11;
            List<Long> r103 = this.durationList;
        L14:
            r103.add(Long.valueOf(r100.j()));
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L13:
            r103 = this.numList;
            goto L14
        L16:
            r100.d(r101);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ c f58894a = null;

        public c() {
        }

        static {
            f58894a = new c();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class d {
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/base/model/message/n5$e;", "", "", "delayTime", "I", "", "startTimestamp", "J", "allowExceedTime", "endTimestamp", "duration", "displayEffectType", "Lcom/bytedance/android/live/base/model/message/n5$b;", "comboInfo", "Lcom/bytedance/android/live/base/model/message/n5$b;", "", "isAssemble", "Z", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class e implements vh7.h {

        @SerializedName("allow_exceed_time")
        public long allowExceedTime;

        @SerializedName("combo_info")
        public b comboInfo;

        @SerializedName("delay_time")
        public int delayTime;

        @SerializedName("display_effect_type")
        public int displayEffectType;

        @SerializedName("duration")
        public int duration;

        @SerializedName("end_time_stamp")
        public long endTimestamp;

        @SerializedName("is_assemble")
        public boolean isAssemble;

        @SerializedName("start_time_stamp")
        public long startTimestamp;

        public static final class a {
        }

        static {
        }

        public e() {
        }

        public e(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            switch(r102) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            this.isAssemble = am3.h.a(r100);
            goto L3
        L8:
            this.comboInfo = new b(r100);
            goto L3
        L9:
            this.displayEffectType = r100.i();
            goto L3
        L10:
            this.duration = r100.i();
            goto L3
        L11:
            this.endTimestamp = r100.j();
            goto L3
        L12:
            this.allowExceedTime = r100.j();
            goto L3
        L13:
            this.startTimestamp = r100.j();
            goto L3
        L14:
            this.delayTime = r100.i();
            goto L3
        L6:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/base/model/message/n5$f;", "", "", "priority", "I", "priorityLowerStrategy", "priorityEqualStrategy", "priorityHigherStrategy", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class f implements vh7.h {

        @SerializedName("priority")
        public int priority;

        @SerializedName("priority_equal_strategy")
        public int priorityEqualStrategy;

        @SerializedName("priority_higher_strategy")
        public int priorityHigherStrategy;

        @SerializedName("priority_lower_strategy")
        public int priorityLowerStrategy;

        public static final class a {
        }

        static {
        }

        public f() {
            this.priorityEqualStrategy = 1;
            this.priorityHigherStrategy = 2;
        }

        public f(am3.g r100) {
            long r101 = r100.c();
            int r102 = 0;
        L3:
            int r103 = r100.f();
            if (r103 == (-1)) goto L16;
            if (r103 != 1) goto L6;
            this.priority = r100.i();
            goto L3
        L6:
            if (r103 != 2) goto L8;
            this.priorityLowerStrategy = r100.i();
            goto L3
        L8:
            if (r103 != 3) goto L10;
            this.priorityEqualStrategy = r100.i();
            r102 = r102 | 1;
            goto L3
        L10:
            if (r103 != 4) goto L11;
            this.priorityHigherStrategy = r100.i();
            r102 = r102 | 2;
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L16:
            r100.d(r101);
            if ((r102 & 1) != 0) goto L20;
            this.priorityEqualStrategy = 1;
        L20:
            if ((r102 & 2) != 0) goto L38;
            this.priorityHigherStrategy = 2;
            return;
        }
    }

    static {
        Companion = c.f58894a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "background")
    a getBackground();

    /* synthetic */ m0 getCommon();

    /* synthetic */ long getConsumeTime();

    @FieldName(name = "content")
    com.bytedance.android.live.base.model.message.d getContent();

    /* synthetic */ long getDecodeEndTime();

    /* synthetic */ long getDecodeStartTime();

    /* synthetic */ long getDelayDispatchMs();

    @FieldName(name = "dynamic_config")
    e getDynamicConfig();

    /* synthetic */ long getEnqueueDispatchTime();

    @FieldName(name = "event_params")
    Map<String, String> getEventParams();

    /* synthetic */ int getGeneralMessageType();

    @FieldName(name = "highlight_area_priority_config")
    HighlightAreaPriorityConfig getHighlightAreaPriorityConfig();

    /* synthetic */ long getHttpSendTime();

    /* synthetic */ int getIntType();

    /* synthetic */ Map<String, String> getMessageExtra();

    /* synthetic */ int getMessageFrom();

    /* synthetic */ long getMessageId();

    /* synthetic */ String getMessageMethod();

    /* synthetic */ int getPriority();

    @FieldName(name = "priority_config")
    f getPriorityConfig();

    /* synthetic */ byte[] getRawPayload();

    /* synthetic */ long getReceiveTime();

    /* synthetic */ long getRoomId();

    @FieldName(name = "scene")
    String getScene();

    /* synthetic */ long getShowTimestamp();

    @FieldName(name = BdpAppEventConstant.PARAMS_SUB_SCENE)
    String getSubScene();

    /* synthetic */ long getTimestamp();

    /* synthetic */ String getWRDSKey();

    /* synthetic */ String getWRDSSubKey();

    /* synthetic */ long getWRDSVersion();

    /* synthetic */ boolean isFromFirstRequest();

    /* synthetic */ boolean isGlobalMessage();

    /* synthetic */ boolean isTimeCostCanUse();

    /* synthetic */ boolean isWRDSMessage();

    /* synthetic */ boolean needMonitor();

    @FieldName(name = "background#setter")
    void setBackground(a r100);

    /* synthetic */ void setCommon(m0 r100);

    /* synthetic */ void setCommonMessageData(m0 r100);

    /* synthetic */ void setConsumeTime(long r100);

    @FieldName(name = "content#setter")
    void setContent(com.bytedance.android.live.base.model.message.d r100);

    /* synthetic */ void setDecodeEndTime(long r100);

    /* synthetic */ void setDecodeStartTime(long r100);

    @FieldName(name = "dynamic_config#setter")
    void setDynamicConfig(e r100);

    /* synthetic */ void setEnqueueDispatchTime(long r100);

    @FieldName(name = "event_params#setter")
    void setEventParams(Map<String, String> r100);

    /* synthetic */ void setGeneralMessageType(int r100);

    @FieldName(name = "highlight_area_priority_config#setter")
    void setHighlightAreaPriorityConfig(HighlightAreaPriorityConfig r100);

    /* synthetic */ void setHttpSendTime(long r100);

    /* synthetic */ void setIsFromFirstRequest(boolean r100);

    /* synthetic */ void setIsInsert(boolean r100);

    /* synthetic */ void setMessageExtra(Map<String, String> r100);

    /* synthetic */ void setMessageFrom(int r100);

    /* synthetic */ void setMessageMethod(String r100);

    @FieldName(name = "priority_config#setter")
    void setPriorityConfig(f r100);

    /* synthetic */ void setRawPayload(byte[] r100);

    /* synthetic */ void setReceiveTime(long r100);

    @FieldName(name = "scene#setter")
    void setScene(String r100);

    /* synthetic */ void setShowTimestamp(long r100);

    @FieldName(name = "sub_scene#setter")
    void setSubScene(String r100);

    /* synthetic */ void setTimestamp(long r100);

    /* synthetic */ void setWRDSMessage(boolean r100);

    /* synthetic */ void setWRDSSubKey(String r100);

    /* synthetic */ void setWRDSVersion(long r100);
}

package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\b)*+,-./0B\u0005¢\u0006\u0002\u0010\u0002R0\u0010\u0003\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR,\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR,\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR&\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR,\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\nR \u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R,\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020&\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010\n¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig;", "", "()V", "bigCardDisplayStrategy", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$BigCardDisplayStrategy;", "getBigCardDisplayStrategy", "()Ljava/util/Map;", "setBigCardDisplayStrategy", "(Ljava/util/Map;)V", SlcElement.KEY_ELEMENTS, "", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$Element;", "getElements", "setElements", "forbiddenTypesMap", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$ForbiddenType;", "getForbiddenTypesMap", "setForbiddenTypesMap", "strategyFeatWhitelist", "", "", "getStrategyFeatWhitelist", "()Ljava/util/List;", "setStrategyFeatWhitelist", "(Ljava/util/List;)V", "tempStateConditionMap", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$TempStateCondition;", "getTempStateConditionMap", "setTempStateConditionMap", "tempStateGlobalCondition", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$TempStateGlobalCondition;", "getTempStateGlobalCondition", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$TempStateGlobalCondition;", "setTempStateGlobalCondition", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$TempStateGlobalCondition;)V", "tempStateStrategyMap", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$TempStateStrategy;", "getTempStateStrategyMap", "setTempStateStrategyMap", "BigCardDisplayStrategy", "Element", "ElementType", "ForbiddenType", "TempStateCondition", "TempStateGlobalCondition", "TempStateStrategy", "TempStateType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ShortTermIndicatorConfig implements h {

    @SerializedName("big_card_display_strategy")
    protected Map<Integer, BigCardDisplayStrategy> bigCardDisplayStrategy;

    @SerializedName(SlcElement.KEY_ELEMENTS)
    protected Map<Integer, Element> elements;

    @SerializedName("forbidden_types_map")
    protected Map<Integer, ForbiddenType> forbiddenTypesMap;

    @SerializedName("strategy_feat_whitelist")
    protected List<String> strategyFeatWhitelist;

    @SerializedName("temp_state_condition_map")
    protected Map<Integer, TempStateCondition> tempStateConditionMap;

    @SerializedName("temp_state_global_condition")
    protected TempStateGlobalCondition tempStateGlobalCondition;

    @SerializedName("temp_state_strategy")
    protected Map<Integer, TempStateStrategy> tempStateStrategyMap;

    @ForMain
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$BigCardDisplayStrategy;", "", "()V", "allowRepeatDisplay", "", "getAllowRepeatDisplay", "()Ljava/lang/Boolean;", "setAllowRepeatDisplay", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "type", "", "getType", "()I", "setType", "(I)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class BigCardDisplayStrategy implements h {

        @SerializedName("allow_repeat_display")
        protected Boolean allowRepeatDisplay;

        @SerializedName("type")
        protected int type;

        public BigCardDisplayStrategy() {
        }

        public final Boolean getAllowRepeatDisplay() {
            return this.allowRepeatDisplay;
        }

        public final int getType() {
            return this.type;
        }

        public BigCardDisplayStrategy(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.type = r100.i();
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.allowRepeatDisplay = Boolean.valueOf(am3.h.a(r100));
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }

        public final void setAllowRepeatDisplay(Boolean r100) {
            this.allowRepeatDisplay = r100;
        }

        public final void setType(int r100) {
            this.type = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$Element;", "", "()V", "priority", "", "getPriority", "()I", "setPriority", "(I)V", "type", "getType", "setType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Element implements h {

        @SerializedName("priority")
        protected int priority;

        @SerializedName("type")
        protected int type;

        public Element() {
        }

        public final int getPriority() {
            return this.priority;
        }

        public final int getType() {
            return this.type;
        }

        public Element(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.type = r100.i();
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.priority = r100.i();
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }

        public final void setPriority(int r100) {
            this.priority = r100;
        }

        public final void setType(int r100) {
            this.type = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$ElementType;", "", "typeId", "", "(Ljava/lang/String;II)V", "getTypeId", "()I", "Unknown", "CNYALuckyBox", "DTaskLuckyBox", "OfficialInteractiveLuckyBox", "RegularLuckyBox", "GiftVote", "Lottery", "CommerceRaffleTicket", "PopularCard", "LiveTC", "CommerceLottery", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum ElementType extends Enum<ElementType> {
        private static final /* synthetic */ ElementType[] $VALUES = null;
        public static final ElementType CNYALuckyBox = null;
        public static final ElementType CommerceLottery = null;
        public static final ElementType CommerceRaffleTicket = null;
        public static final Companion Companion = null;
        public static final ElementType DTaskLuckyBox = null;
        public static final ElementType GiftVote = null;
        public static final ElementType LiveTC = null;
        public static final ElementType Lottery = null;
        public static final ElementType OfficialInteractiveLuckyBox = null;
        public static final ElementType PopularCard = null;
        public static final ElementType RegularLuckyBox = null;
        public static final ElementType Unknown = null;
        private final int typeId;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$ElementType$Companion;", "", "()V", "getByTypeId", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$ElementType;", "typeId", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final ElementType getByTypeId(int r100) {
                ElementType[] r101 = ElementType.values();
                int r102 = r101.length;
                int r103 = 0;
            L3:
                if (r103 >= r102) goto L8;
                ElementType r104 = r101[r103];
                if (r104.getTypeId() == r100) goto L6;
                r103 = r103 + 1;
                goto L3
            L6:
                return r104;
            L8:
                return null;
            }
        }

        public static ElementType valueOf(String r100) {
            return (ElementType) a.a(ElementType.class, r100);
        }

        public static ElementType[] values() {
            return (ElementType[]) $VALUES.clone();
        }

        static {
            ElementType r100 = new ElementType("Unknown", 0, 0);
            Unknown = r100;
            ElementType r101 = new ElementType("CNYALuckyBox", 1, 1);
            CNYALuckyBox = r101;
            ElementType r102 = new ElementType("DTaskLuckyBox", 2, 2);
            DTaskLuckyBox = r102;
            ElementType r103 = new ElementType("OfficialInteractiveLuckyBox", 3, 3);
            OfficialInteractiveLuckyBox = r103;
            ElementType r104 = new ElementType("RegularLuckyBox", 4, 4);
            RegularLuckyBox = r104;
            ElementType r105 = new ElementType("GiftVote", 5, 6);
            GiftVote = r105;
            ElementType r106 = new ElementType("Lottery", 6, 7);
            Lottery = r106;
            ElementType r107 = new ElementType("CommerceRaffleTicket", 7, 8);
            CommerceRaffleTicket = r107;
            ElementType r108 = new ElementType("PopularCard", 8, 10);
            PopularCard = r108;
            ElementType r109 = new ElementType("LiveTC", 9, 22);
            LiveTC = r109;
            ElementType r110 = new ElementType("CommerceLottery", 10, 27);
            CommerceLottery = r110;
            $VALUES = new ElementType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
            Companion = new Companion(null);
        }

        public final int getTypeId() {
            return this.typeId;
        }

        private ElementType(String r100, int r101, int r102) {
            super(r100, r101);
            this.typeId = r102;
        }
    }

    @ForMain
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$ForbiddenType;", "", "()V", "reason", "", "getReason", "()Ljava/lang/String;", "setReason", "(Ljava/lang/String;)V", "type", "", "getType", "()I", "setType", "(I)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ForbiddenType implements h {

        @SerializedName("reason")
        protected String reason;

        @SerializedName("type")
        protected int type;

        public ForbiddenType() {
        }

        public final String getReason() {
            return this.reason;
        }

        public final int getType() {
            return this.type;
        }

        public ForbiddenType(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.type = r100.i();
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.reason = am3.h.c(r100);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }

        public final void setReason(String r100) {
            this.reason = r100;
        }

        public final void setType(int r100) {
            this.type = r100;
        }
    }

    @ForMain
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$TempStateCondition;", "", "()V", "minimumGap", "", "getMinimumGap", "()I", "setMinimumGap", "(I)V", "tempStateType", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$TempStateType;", "getTempStateType", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$TempStateType;", "setTempStateType", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$TempStateType;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class TempStateCondition implements h {

        @SerializedName("minimum_gap")
        protected int minimumGap;

        @SerializedName("type")
        protected TempStateType tempStateType;

        public TempStateCondition() {
        }

        public final int getMinimumGap() {
            return this.minimumGap;
        }

        public final TempStateType getTempStateType() {
            return this.tempStateType;
        }

        public TempStateCondition(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.tempStateType = new TempStateType(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.minimumGap = r100.i();
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }

        public final void setMinimumGap(int r100) {
            this.minimumGap = r100;
        }

        public final void setTempStateType(TempStateType r100) {
            this.tempStateType = r100;
        }
    }

    @ForMain
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR&\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$TempStateGlobalCondition;", "", "()V", "allowCount", "", "getAllowCount", "()I", "setAllowCount", "(I)V", "durationGap", "getDurationGap", "setDurationGap", "ignoreStrategyTypes", "", "getIgnoreStrategyTypes", "()Ljava/util/List;", "setIgnoreStrategyTypes", "(Ljava/util/List;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class TempStateGlobalCondition implements h {

        @SerializedName("allow_count")
        protected int allowCount;

        @SerializedName("duration_gap")
        protected int durationGap;

        @SerializedName("ignore_strategy_types")
        protected List<Integer> ignoreStrategyTypes;

        public TempStateGlobalCondition() {
        }

        public final int getAllowCount() {
            return this.allowCount;
        }

        public final int getDurationGap() {
            return this.durationGap;
        }

        public final List<Integer> getIgnoreStrategyTypes() {
            return this.ignoreStrategyTypes;
        }

        public TempStateGlobalCondition(g r100) {
            this.ignoreStrategyTypes = new ArrayList();
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            if (r102 != 1) goto L8;
            this.durationGap = r100.i();
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.allowCount = r100.i();
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.ignoreStrategyTypes.add(Integer.valueOf(r100.i()));
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
        }

        public final void setAllowCount(int r100) {
            this.allowCount = r100;
        }

        public final void setDurationGap(int r100) {
            this.durationGap = r100;
        }

        public final void setIgnoreStrategyTypes(List<Integer> r100) {
            this.ignoreStrategyTypes = r100;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$TempStateStrategy;", "", "()V", "shortTouchType", "", "getShortTouchType", "()I", "setShortTouchType", "(I)V", "strategyMap", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$TempStateStrategy$TempStateStrategyInfo;", "getStrategyMap", "()Ljava/util/Map;", "setStrategyMap", "(Ljava/util/Map;)V", "TempStateStrategyInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    @ForMain
    public static final class TempStateStrategy implements h {

        @SerializedName("short_touch_type")
        protected int shortTouchType;

        @SerializedName("strategy_map")
        protected Map<Integer, TempStateStrategyInfo> strategyMap;

        @ForMain
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$TempStateStrategy$TempStateStrategyInfo;", "", "()V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "", "getStrategy", "()Ljava/lang/String;", "setStrategy", "(Ljava/lang/String;)V", "type", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$TempStateType;", "getType", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$TempStateType;", "setType", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$TempStateType;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
        public static final class TempStateStrategyInfo implements h {

            @SerializedName("duration")
            protected long duration;

            @SerializedName("strategy_method")
            protected String strategy;

            @SerializedName("type")
            protected TempStateType type;

            public TempStateStrategyInfo() {
            }

            public final long getDuration() {
                return this.duration;
            }

            public final String getStrategy() {
                return this.strategy;
            }

            public final TempStateType getType() {
                return this.type;
            }

            public TempStateStrategyInfo(g r100) {
                long r101 = r100.c();
            L3:
                int r102 = r100.f();
                if (r102 == (-1)) goto L15;
                if (r102 != 1) goto L8;
                this.type = new TempStateType(r100);
                goto L3
            L8:
                if (r102 != 2) goto L10;
                this.duration = r100.i();
                goto L3
            L10:
                if (r102 != 3) goto L11;
                this.strategy = am3.h.c(r100);
                goto L3
            L11:
                am3.h.e(r100);
                goto L3
            L15:
                r100.d(r101);
            }

            public final void setDuration(long r100) {
                this.duration = r100;
            }

            public final void setStrategy(String r100) {
                this.strategy = r100;
            }

            public final void setType(TempStateType r100) {
                this.type = r100;
            }
        }

        public TempStateStrategy() {
        }

        public final int getShortTouchType() {
            return this.shortTouchType;
        }

        public final Map<Integer, TempStateStrategyInfo> getStrategyMap() {
            return this.strategyMap;
        }

        public TempStateStrategy(g r110) {
            this.strategyMap = new HashMap();
            long r100 = r110.c();
        L3:
            int r101 = r110.f();
            if (r101 == (-1)) goto L27;
            if (r101 != 1) goto L8;
            this.shortTouchType = r110.i();
            goto L3
        L8:
            if (r101 != 2) goto L9;
            long r102 = r110.c();
            Integer r103 = null;
            TempStateStrategyInfo r104 = null;
        L11:
            int r105 = r110.f();
            if (r105 == (-1)) goto L18;
            if (r105 != 1) goto L14;
            r103 = Integer.valueOf(r110.i());
            goto L11
        L14:
            if (r105 != 2) goto L15;
            r104 = new TempStateStrategyInfo(r110);
            goto L11
        L15:
            am3.h.e(r110);
            goto L11
        L18:
            r110.d(r102);
            Map<Integer, TempStateStrategyInfo> r106 = this.strategyMap;
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
        }

        public final void setShortTouchType(int r100) {
            this.shortTouchType = r100;
        }

        public final void setStrategyMap(Map<Integer, TempStateStrategyInfo> r100) {
            this.strategyMap = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$TempStateType;", "", "()V", "priority", "", "getPriority", "()I", "setPriority", "(I)V", ControlRule.KEY_STRATEGY_TYPE, "getStrategyType", "setStrategyType", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    @ForMain
    public static final class TempStateType implements h {
        public static final Companion Companion = null;
        public static final int DEFAULT_PRIORITY = 1000;
        public static final int STRATEGY_COUNTDOWN = 3;
        public static final int STRATEGY_HOT = 2;
        public static final int STRATEGY_MANUALHOST = 4;
        public static final int STRATEGY_SINGLE = 1;
        public static final int STRATEGY_UNKNOWN = 0;

        @SerializedName("priority")
        protected int priority;

        @SerializedName(GearStrategy.GEAR_STRATEGY_KEY_STRATEGY_TYPE)
        protected int strategyType;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$TempStateType$Companion;", "", "()V", "DEFAULT_PRIORITY", "", "STRATEGY_COUNTDOWN", "STRATEGY_HOT", "STRATEGY_MANUALHOST", "STRATEGY_SINGLE", "STRATEGY_UNKNOWN", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public TempStateType() {
        }

        public final int getPriority() {
            return this.priority;
        }

        public final int getStrategyType() {
            return this.strategyType;
        }

        public TempStateType(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.strategyType = r100.i();
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.priority = r100.i();
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }

        public final void setPriority(int r100) {
            this.priority = r100;
        }

        public final void setStrategyType(int r100) {
            this.strategyType = r100;
        }
    }

    public ShortTermIndicatorConfig() {
    }

    public final Map<Integer, BigCardDisplayStrategy> getBigCardDisplayStrategy() {
        return this.bigCardDisplayStrategy;
    }

    public final Map<Integer, Element> getElements() {
        return this.elements;
    }

    public final Map<Integer, ForbiddenType> getForbiddenTypesMap() {
        return this.forbiddenTypesMap;
    }

    public final List<String> getStrategyFeatWhitelist() {
        return this.strategyFeatWhitelist;
    }

    public final Map<Integer, TempStateCondition> getTempStateConditionMap() {
        return this.tempStateConditionMap;
    }

    public final TempStateGlobalCondition getTempStateGlobalCondition() {
        return this.tempStateGlobalCondition;
    }

    public final Map<Integer, TempStateStrategy> getTempStateStrategyMap() {
        return this.tempStateStrategyMap;
    }

    public ShortTermIndicatorConfig(g r110) {
        this.elements = new HashMap();
        this.forbiddenTypesMap = new HashMap();
        this.tempStateConditionMap = new HashMap();
        this.tempStateStrategyMap = new HashMap();
        this.strategyFeatWhitelist = new ArrayList();
        this.bigCardDisplayStrategy = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L90;
        Integer r102 = null;
        switch(r101) {
            case 1: goto L74;
            case 2: goto L7;
            case 3: goto L58;
            case 4: goto L42;
            case 5: goto L26;
            case 6: goto L25;
            case 7: goto L24;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        long r103 = r110.c();
        Object r104 = null;
    L9:
        int r111 = r110.f();
        if (r111 == (-1)) goto L16;
        if (r111 != 1) goto L12;
        r102 = Integer.valueOf(r110.i());
        goto L9
    L12:
        if (r111 != 2) goto L13;
        r104 = new BigCardDisplayStrategy(r110);
        goto L9
    L13:
        am3.h.e(r110);
        goto L9
    L16:
        r110.d(r103);
        Map r105 = this.bigCardDisplayStrategy;
        if (r102 == null) goto L23;
        if (r104 == null) goto L21;
    L85:
        r105.put(r102, r104);
        goto L3
    L21:
        throw new IllegalStateException("Value must not be null");
    L23:
        throw new IllegalStateException("Key must not be null");
    L24:
        this.tempStateGlobalCondition = new TempStateGlobalCondition(r110);
        goto L3
    L25:
        this.strategyFeatWhitelist.add(am3.h.c(r110));
        goto L3
    L26:
        long r106 = r110.c();
        r104 = null;
    L27:
        int r112 = r110.f();
        if (r112 == (-1)) goto L34;
        if (r112 != 1) goto L30;
        r102 = Integer.valueOf(r110.i());
        goto L27
    L30:
        if (r112 != 2) goto L31;
        r104 = new TempStateStrategy(r110);
        goto L27
    L31:
        am3.h.e(r110);
        goto L27
    L34:
        r110.d(r106);
        r105 = this.tempStateStrategyMap;
        if (r102 == null) goto L41;
        if (r104 != null) goto L85;
        throw new IllegalStateException("Value must not be null");
    L41:
        throw new IllegalStateException("Key must not be null");
    L42:
        long r107 = r110.c();
        r104 = null;
    L43:
        int r113 = r110.f();
        if (r113 == (-1)) goto L50;
        if (r113 != 1) goto L46;
        r102 = Integer.valueOf(r110.i());
        goto L43
    L46:
        if (r113 != 2) goto L47;
        r104 = new TempStateCondition(r110);
        goto L43
    L47:
        am3.h.e(r110);
        goto L43
    L50:
        r110.d(r107);
        r105 = this.tempStateConditionMap;
        if (r102 == null) goto L57;
        if (r104 != null) goto L85;
        throw new IllegalStateException("Value must not be null");
    L57:
        throw new IllegalStateException("Key must not be null");
    L58:
        long r108 = r110.c();
        r104 = null;
    L59:
        int r114 = r110.f();
        if (r114 == (-1)) goto L66;
        if (r114 != 1) goto L62;
        r102 = Integer.valueOf(r110.i());
        goto L59
    L62:
        if (r114 != 2) goto L63;
        r104 = new ForbiddenType(r110);
        goto L59
    L63:
        am3.h.e(r110);
        goto L59
    L66:
        r110.d(r108);
        r105 = this.forbiddenTypesMap;
        if (r102 == null) goto L73;
        if (r104 != null) goto L85;
        throw new IllegalStateException("Value must not be null");
    L73:
        throw new IllegalStateException("Key must not be null");
    L74:
        long r109 = r110.c();
        r104 = null;
    L75:
        int r115 = r110.f();
        if (r115 == (-1)) goto L82;
        if (r115 != 1) goto L78;
        r102 = Integer.valueOf(r110.i());
        goto L75
    L78:
        if (r115 != 2) goto L79;
        r104 = new Element(r110);
        goto L75
    L79:
        am3.h.e(r110);
        goto L75
    L82:
        r110.d(r109);
        r105 = this.elements;
        if (r102 == null) goto L89;
        if (r104 != null) goto L85;
        throw new IllegalStateException("Value must not be null");
    L89:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.e(r110);
        goto L3
    L90:
        r110.d(r100);
    }

    public final void setBigCardDisplayStrategy(Map<Integer, BigCardDisplayStrategy> r100) {
        this.bigCardDisplayStrategy = r100;
    }

    public final void setElements(Map<Integer, Element> r100) {
        this.elements = r100;
    }

    public final void setForbiddenTypesMap(Map<Integer, ForbiddenType> r100) {
        this.forbiddenTypesMap = r100;
    }

    public final void setStrategyFeatWhitelist(List<String> r100) {
        this.strategyFeatWhitelist = r100;
    }

    public final void setTempStateConditionMap(Map<Integer, TempStateCondition> r100) {
        this.tempStateConditionMap = r100;
    }

    public final void setTempStateGlobalCondition(TempStateGlobalCondition r100) {
        this.tempStateGlobalCondition = r100;
    }

    public final void setTempStateStrategyMap(Map<Integer, TempStateStrategy> r100) {
        this.tempStateStrategyMap = r100;
    }
}

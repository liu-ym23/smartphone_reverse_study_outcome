package com.bytedance.android.livesdkapi.room.handler.viewinterface;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IWidgetType;", "", "getWidgetType", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IWidgetType$ExternalWidgetType;", "ExternalWidgetType", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IWidgetType {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static ExternalWidgetType getWidgetType(IWidgetType r100) {
            return ExternalWidgetType.UNKNOWN;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IWidgetType$ExternalWidgetType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ECOMMERCE_SIZE_COMPONENTS", "ECOMMERCE_PROPERTY_COMPONENTS", "LOCAL_LIFE_PROPERTY_COMPONENTS", "OPEN_COMMON_COMPONENT", "ECOMMERCE_POP_CARD", "MINI_APP_POP_CARD", "LOCAL_LIFE_POP_CARD", "GAME_PROMPT_POP_CARD", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ExternalWidgetType extends Enum<ExternalWidgetType> {
        private static final /* synthetic */ ExternalWidgetType[] $VALUES = null;
        public static final ExternalWidgetType ECOMMERCE_POP_CARD = null;
        public static final ExternalWidgetType ECOMMERCE_PROPERTY_COMPONENTS = null;
        public static final ExternalWidgetType ECOMMERCE_SIZE_COMPONENTS = null;
        public static final ExternalWidgetType GAME_PROMPT_POP_CARD = null;
        public static final ExternalWidgetType LOCAL_LIFE_POP_CARD = null;
        public static final ExternalWidgetType LOCAL_LIFE_PROPERTY_COMPONENTS = null;
        public static final ExternalWidgetType MINI_APP_POP_CARD = null;
        public static final ExternalWidgetType OPEN_COMMON_COMPONENT = null;
        public static final ExternalWidgetType UNKNOWN = null;
        private final int value;

        public static ExternalWidgetType valueOf(String r100) {
            return (ExternalWidgetType) a.a(ExternalWidgetType.class, r100);
        }

        public static ExternalWidgetType[] values() {
            return (ExternalWidgetType[]) $VALUES.clone();
        }

        static {
            ExternalWidgetType r100 = new ExternalWidgetType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ExternalWidgetType r101 = new ExternalWidgetType("ECOMMERCE_SIZE_COMPONENTS", 1, 1);
            ECOMMERCE_SIZE_COMPONENTS = r101;
            ExternalWidgetType r102 = new ExternalWidgetType("ECOMMERCE_PROPERTY_COMPONENTS", 2, 2);
            ECOMMERCE_PROPERTY_COMPONENTS = r102;
            ExternalWidgetType r103 = new ExternalWidgetType("LOCAL_LIFE_PROPERTY_COMPONENTS", 3, 10);
            LOCAL_LIFE_PROPERTY_COMPONENTS = r103;
            ExternalWidgetType r104 = new ExternalWidgetType("OPEN_COMMON_COMPONENT", 4, 50);
            OPEN_COMMON_COMPONENT = r104;
            ExternalWidgetType r105 = new ExternalWidgetType("ECOMMERCE_POP_CARD", 5, 101);
            ECOMMERCE_POP_CARD = r105;
            ExternalWidgetType r106 = new ExternalWidgetType("MINI_APP_POP_CARD", 6, 102);
            MINI_APP_POP_CARD = r106;
            ExternalWidgetType r107 = new ExternalWidgetType("LOCAL_LIFE_POP_CARD", 7, 103);
            LOCAL_LIFE_POP_CARD = r107;
            ExternalWidgetType r108 = new ExternalWidgetType("GAME_PROMPT_POP_CARD", 8, 104);
            GAME_PROMPT_POP_CARD = r108;
            $VALUES = new ExternalWidgetType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
        }

        public final int getValue() {
            return this.value;
        }

        private ExternalWidgetType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    ExternalWidgetType getWidgetType();
}

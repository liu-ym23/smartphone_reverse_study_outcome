package com.stepos.launcher.assistant.widgetdrag;

/* loaded from: classes.dex */
public interface GlobalDragItemInfoParser {
    public static final GlobalDragItemInfoParser DEFAULT_PARSER = new GlobalDragItemInfoDefaultParser();

    public static class GlobalDragItemInfoDefaultParser implements GlobalDragItemInfoParser {
        @Override // com.stepos.launcher.assistant.widgetdrag.GlobalDragItemInfoParser
        public GlobalDragItemInfo parse(String str, int i10) {
            if (i10 == 1) {
                return (GlobalDragItemInfo) G1.a.y(str, GlobalDragWidgetInfo.class);
            }
            if (i10 != 2) {
                if (i10 == 4) {
                    return (GlobalDragItemInfo) G1.a.y(str, GlobalDragWidgetStackInfo.class);
                }
                if (i10 != 5) {
                    return null;
                }
            }
            return (GlobalDragItemInfo) G1.a.y(str, GlobalDragItemInfo.class);
        }

        @Override // com.stepos.launcher.assistant.widgetdrag.GlobalDragItemInfoParser
        public String toJson(GlobalDragItemInfo globalDragItemInfo) {
            return G1.a.N(globalDragItemInfo);
        }
    }

    GlobalDragItemInfo parse(String str, int i10);

    String toJson(GlobalDragItemInfo globalDragItemInfo);
}

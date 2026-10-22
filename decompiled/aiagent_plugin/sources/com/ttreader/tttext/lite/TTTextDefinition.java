package com.ttreader.tttext.lite;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class TTTextDefinition {
    private static final CanvasOp[] canvas_ordinal_ = null;
    private static final CharacterVerticalAlign[] character_vertical_ordinal_ = null;
    private static final LayoutResult[] layout_result_ordinal_ = null;
    private static final LinkStyle[] link_ordinal_ = null;
    private static final ParagraphHorizontalAlign[] paragraph_horizon_ordinal_ = null;
    private static final ParagraphVerticalAlign[] paragraph_vertical_ordinal_ = null;
    private static final PathType[] path_ordinal_ = null;
    private static final FontStyle[] style_ordinal_ = null;
    private static final ThemeColorType[] theme_color_ordinal = null;
    private static final FontWeight[] weight_ordinal_ = null;

    public static final enum CanvasOp extends Enum<CanvasOp> {
        private static final /* synthetic */ CanvasOp[] $VALUES = null;
        public static final CanvasOp kClear = null;
        public static final CanvasOp kClearRect = null;
        public static final CanvasOp kClipRect = null;
        public static final CanvasOp kDrawArc = null;
        public static final CanvasOp kDrawArcTo = null;
        public static final CanvasOp kDrawBackgroundDelegate = null;
        public static final CanvasOp kDrawBlockRegion = null;
        public static final CanvasOp kDrawCircle = null;
        public static final CanvasOp kDrawColor = null;
        public static final CanvasOp kDrawGlyphs = null;
        public static final CanvasOp kDrawImage = null;
        public static final CanvasOp kDrawImageRect = null;
        public static final CanvasOp kDrawLine = null;
        public static final CanvasOp kDrawOval = null;
        public static final CanvasOp kDrawPath = null;
        public static final CanvasOp kDrawRect = null;
        public static final CanvasOp kDrawRoundRect = null;
        public static final CanvasOp kDrawRunDelegate = null;
        public static final CanvasOp kDrawText = null;
        public static final CanvasOp kEndPaint = null;
        public static final CanvasOp kFillRect = null;
        public static final CanvasOp kRestore = null;
        public static final CanvasOp kRotate = null;
        public static final CanvasOp kSave = null;
        public static final CanvasOp kScale = null;
        public static final CanvasOp kSkew = null;
        public static final CanvasOp kStartPaint = null;
        public static final CanvasOp kTranslate = null;

        private CanvasOp(String r1, int r2) {
            super(r1, r2);
        }

        public static CanvasOp valueOf(String r2) {
            return (CanvasOp) ZeusTransformUtils.preCheckCast(Enum.valueOf(CanvasOp.class, r2), CanvasOp.class, "com.obric.aiagent.plugin");
        }

        public static CanvasOp[] values() {
            return (CanvasOp[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CanvasOp[].class, "com.obric.aiagent.plugin");
        }

        static {
            CanvasOp r0 = new CanvasOp("kStartPaint", 0);
            kStartPaint = r0;
            CanvasOp r1 = new CanvasOp("kEndPaint", 1);
            kEndPaint = r1;
            CanvasOp r3 = new CanvasOp("kSave", 2);
            kSave = r3;
            CanvasOp r5 = new CanvasOp("kRestore", 3);
            kRestore = r5;
            CanvasOp r7 = new CanvasOp("kTranslate", 4);
            kTranslate = r7;
            CanvasOp r9 = new CanvasOp("kScale", 5);
            kScale = r9;
            CanvasOp r11 = new CanvasOp("kRotate", 6);
            kRotate = r11;
            CanvasOp r13 = new CanvasOp("kSkew", 7);
            kSkew = r13;
            CanvasOp r15 = new CanvasOp("kClipRect", 8);
            kClipRect = r15;
            CanvasOp r14 = new CanvasOp("kClear", 9);
            kClear = r14;
            CanvasOp r12 = new CanvasOp("kClearRect", 10);
            kClearRect = r12;
            CanvasOp r10 = new CanvasOp("kFillRect", 11);
            kFillRect = r10;
            CanvasOp r8 = new CanvasOp("kDrawColor", 12);
            kDrawColor = r8;
            CanvasOp r6 = new CanvasOp("kDrawLine", 13);
            kDrawLine = r6;
            CanvasOp r4 = new CanvasOp("kDrawRect", 14);
            kDrawRect = r4;
            CanvasOp r2 = new CanvasOp("kDrawOval", 15);
            kDrawOval = r2;
            CanvasOp r16 = new CanvasOp("kDrawCircle", 16);
            kDrawCircle = r16;
            CanvasOp r17 = new CanvasOp("kDrawArc", 17);
            kDrawArc = r17;
            CanvasOp r18 = new CanvasOp("kDrawPath", 18);
            kDrawPath = r18;
            CanvasOp r19 = new CanvasOp("kDrawArcTo", 19);
            kDrawArcTo = r19;
            CanvasOp r20 = new CanvasOp("kDrawText", 20);
            kDrawText = r20;
            CanvasOp r21 = new CanvasOp("kDrawGlyphs", 21);
            kDrawGlyphs = r21;
            CanvasOp r22 = new CanvasOp("kDrawRunDelegate", 22);
            kDrawRunDelegate = r22;
            CanvasOp r23 = new CanvasOp("kDrawImage", 23);
            kDrawImage = r23;
            CanvasOp r24 = new CanvasOp("kDrawImageRect", 24);
            kDrawImageRect = r24;
            CanvasOp r25 = new CanvasOp("kDrawBackgroundDelegate", 25);
            kDrawBackgroundDelegate = r25;
            CanvasOp r26 = new CanvasOp("kDrawBlockRegion", 26);
            kDrawBlockRegion = r26;
            CanvasOp r27 = new CanvasOp("kDrawRoundRect", 27);
            kDrawRoundRect = r27;
            $VALUES = new CanvasOp[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27};
        }
    }

    public static final enum CharacterVerticalAlign extends Enum<CharacterVerticalAlign> {
        private static final /* synthetic */ CharacterVerticalAlign[] $VALUES = null;
        public static final CharacterVerticalAlign kBaseLine = null;
        public static final CharacterVerticalAlign kBottom = null;
        public static final CharacterVerticalAlign kMiddle = null;
        public static final CharacterVerticalAlign kSubScript = null;
        public static final CharacterVerticalAlign kSuperScript = null;
        public static final CharacterVerticalAlign kTop = null;

        private CharacterVerticalAlign(String r1, int r2) {
            super(r1, r2);
        }

        public static CharacterVerticalAlign valueOf(String r2) {
            return (CharacterVerticalAlign) ZeusTransformUtils.preCheckCast(Enum.valueOf(CharacterVerticalAlign.class, r2), CharacterVerticalAlign.class, "com.obric.aiagent.plugin");
        }

        public static CharacterVerticalAlign[] values() {
            return (CharacterVerticalAlign[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CharacterVerticalAlign[].class, "com.obric.aiagent.plugin");
        }

        static {
            CharacterVerticalAlign r0 = new CharacterVerticalAlign("kBaseLine", 0);
            kBaseLine = r0;
            CharacterVerticalAlign r1 = new CharacterVerticalAlign("kSuperScript", 1);
            kSuperScript = r1;
            CharacterVerticalAlign r3 = new CharacterVerticalAlign("kSubScript", 2);
            kSubScript = r3;
            CharacterVerticalAlign r5 = new CharacterVerticalAlign("kTop", 3);
            kTop = r5;
            CharacterVerticalAlign r7 = new CharacterVerticalAlign("kBottom", 4);
            kBottom = r7;
            CharacterVerticalAlign r9 = new CharacterVerticalAlign("kMiddle", 5);
            kMiddle = r9;
            $VALUES = new CharacterVerticalAlign[]{r0, r1, r3, r5, r7, r9};
        }
    }

    public static final enum DecorationType extends Enum<DecorationType> {
        private static final /* synthetic */ DecorationType[] $VALUES = null;
        public static final DecorationType kNone = null;
        public static final DecorationType kUnderLine = null;

        static {
            DecorationType r0 = new DecorationType("kNone", 0);
            kNone = r0;
            DecorationType r1 = new DecorationType("kUnderLine", 1);
            kUnderLine = r1;
            $VALUES = new DecorationType[]{r0, r1};
        }

        private DecorationType(String r1, int r2) {
            super(r1, r2);
        }

        public static DecorationType valueOf(String r2) {
            return (DecorationType) ZeusTransformUtils.preCheckCast(Enum.valueOf(DecorationType.class, r2), DecorationType.class, "com.obric.aiagent.plugin");
        }

        public static DecorationType[] values() {
            return (DecorationType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DecorationType[].class, "com.obric.aiagent.plugin");
        }
    }

    public static class FontFace {
        public String font_family;
        public String[] resource;

        public FontFace() {
        }
    }

    public static final enum FontStyle extends Enum<FontStyle> {
        private static final /* synthetic */ FontStyle[] $VALUES = null;
        public static final FontStyle kItalic = null;
        public static final FontStyle kNormal = null;
        public static final FontStyle kUndefined = null;

        private FontStyle(String r1, int r2) {
            super(r1, r2);
        }

        public static FontStyle valueOf(String r2) {
            return (FontStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(FontStyle.class, r2), FontStyle.class, "com.obric.aiagent.plugin");
        }

        public static FontStyle[] values() {
            return (FontStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FontStyle[].class, "com.obric.aiagent.plugin");
        }

        static {
            FontStyle r0 = new FontStyle("kUndefined", 0);
            kUndefined = r0;
            FontStyle r1 = new FontStyle("kNormal", 1);
            kNormal = r1;
            FontStyle r3 = new FontStyle("kItalic", 2);
            kItalic = r3;
            $VALUES = new FontStyle[]{r0, r1, r3};
        }
    }

    public static final enum FontWeight extends Enum<FontWeight> {
        private static final /* synthetic */ FontWeight[] $VALUES = null;
        public static final FontWeight kBlack_900 = null;
        public static final FontWeight kBold_700 = null;
        public static final FontWeight kExtraBold_800 = null;
        public static final FontWeight kExtraLight_200 = null;
        public static final FontWeight kLight_300 = null;
        public static final FontWeight kMedium_500 = null;
        public static final FontWeight kNormal_400 = null;
        public static final FontWeight kSemiBold_600 = null;
        public static final FontWeight kThin_100 = null;
        public static final FontWeight kUndefined = null;

        private FontWeight(String r1, int r2) {
            super(r1, r2);
        }

        public static FontWeight valueOf(String r2) {
            return (FontWeight) ZeusTransformUtils.preCheckCast(Enum.valueOf(FontWeight.class, r2), FontWeight.class, "com.obric.aiagent.plugin");
        }

        public static FontWeight[] values() {
            return (FontWeight[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FontWeight[].class, "com.obric.aiagent.plugin");
        }

        static {
            FontWeight r0 = new FontWeight("kUndefined", 0);
            kUndefined = r0;
            FontWeight r1 = new FontWeight("kThin_100", 1);
            kThin_100 = r1;
            FontWeight r3 = new FontWeight("kExtraLight_200", 2);
            kExtraLight_200 = r3;
            FontWeight r5 = new FontWeight("kLight_300", 3);
            kLight_300 = r5;
            FontWeight r7 = new FontWeight("kNormal_400", 4);
            kNormal_400 = r7;
            FontWeight r9 = new FontWeight("kMedium_500", 5);
            kMedium_500 = r9;
            FontWeight r11 = new FontWeight("kSemiBold_600", 6);
            kSemiBold_600 = r11;
            FontWeight r13 = new FontWeight("kBold_700", 7);
            kBold_700 = r13;
            FontWeight r15 = new FontWeight("kExtraBold_800", 8);
            kExtraBold_800 = r15;
            FontWeight r14 = new FontWeight("kBlack_900", 9);
            kBlack_900 = r14;
            $VALUES = new FontWeight[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        }
    }

    public static class LayoutPosition {
        public int char_index_;
        public int run_index_;

        public LayoutPosition() {
            this.run_index_ = 0;
            this.char_index_ = 0;
        }

        public LayoutPosition(int r2, int r3) {
            this.run_index_ = 0;
            this.char_index_ = 0;
            this.run_index_ = r2;
            this.char_index_ = r3;
        }
    }

    public static final enum LayoutResult extends Enum<LayoutResult> {
        private static final /* synthetic */ LayoutResult[] $VALUES = null;
        public static final LayoutResult kBreakColumn = null;
        public static final LayoutResult kBreakPage = null;
        public static final LayoutResult kNormal = null;
        public static final LayoutResult kParagraphEnd = null;
        public static final LayoutResult kRelayoutLine = null;
        public static final LayoutResult kRelayoutPage = null;

        private LayoutResult(String r1, int r2) {
            super(r1, r2);
        }

        public static LayoutResult valueOf(String r2) {
            return (LayoutResult) ZeusTransformUtils.preCheckCast(Enum.valueOf(LayoutResult.class, r2), LayoutResult.class, "com.obric.aiagent.plugin");
        }

        public static LayoutResult[] values() {
            return (LayoutResult[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LayoutResult[].class, "com.obric.aiagent.plugin");
        }

        static {
            LayoutResult r0 = new LayoutResult("kNormal", 0);
            kNormal = r0;
            LayoutResult r1 = new LayoutResult("kRelayoutPage", 1);
            kRelayoutPage = r1;
            LayoutResult r3 = new LayoutResult("kRelayoutLine", 2);
            kRelayoutLine = r3;
            LayoutResult r5 = new LayoutResult("kBreakPage", 3);
            kBreakPage = r5;
            LayoutResult r7 = new LayoutResult("kBreakColumn", 4);
            kBreakColumn = r7;
            LayoutResult r9 = new LayoutResult("kParagraphEnd", 5);
            kParagraphEnd = r9;
            $VALUES = new LayoutResult[]{r0, r1, r3, r5, r7, r9};
        }
    }

    public static final enum LinkStyle extends Enum<LinkStyle> {
        private static final /* synthetic */ LinkStyle[] $VALUES = null;
        public static final LinkStyle kNone = null;
        public static final LinkStyle kUnderline = null;

        static {
            LinkStyle r0 = new LinkStyle("kNone", 0);
            kNone = r0;
            LinkStyle r1 = new LinkStyle("kUnderline", 1);
            kUnderline = r1;
            $VALUES = new LinkStyle[]{r0, r1};
        }

        private LinkStyle(String r1, int r2) {
            super(r1, r2);
        }

        public static LinkStyle valueOf(String r2) {
            return (LinkStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(LinkStyle.class, r2), LinkStyle.class, "com.obric.aiagent.plugin");
        }

        public static LinkStyle[] values() {
            return (LinkStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LinkStyle[].class, "com.obric.aiagent.plugin");
        }
    }

    public static final enum ParagraphHorizontalAlign extends Enum<ParagraphHorizontalAlign> {
        private static final /* synthetic */ ParagraphHorizontalAlign[] $VALUES = null;
        public static final ParagraphHorizontalAlign kCenter = null;
        public static final ParagraphHorizontalAlign kDistributed = null;
        public static final ParagraphHorizontalAlign kJustify = null;
        public static final ParagraphHorizontalAlign kLeft = null;
        public static final ParagraphHorizontalAlign kRight = null;

        private ParagraphHorizontalAlign(String r1, int r2) {
            super(r1, r2);
        }

        public static ParagraphHorizontalAlign valueOf(String r2) {
            return (ParagraphHorizontalAlign) ZeusTransformUtils.preCheckCast(Enum.valueOf(ParagraphHorizontalAlign.class, r2), ParagraphHorizontalAlign.class, "com.obric.aiagent.plugin");
        }

        public static ParagraphHorizontalAlign[] values() {
            return (ParagraphHorizontalAlign[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ParagraphHorizontalAlign[].class, "com.obric.aiagent.plugin");
        }

        static {
            ParagraphHorizontalAlign r0 = new ParagraphHorizontalAlign("kLeft", 0);
            kLeft = r0;
            ParagraphHorizontalAlign r1 = new ParagraphHorizontalAlign("kCenter", 1);
            kCenter = r1;
            ParagraphHorizontalAlign r3 = new ParagraphHorizontalAlign("kRight", 2);
            kRight = r3;
            ParagraphHorizontalAlign r5 = new ParagraphHorizontalAlign("kJustify", 3);
            kJustify = r5;
            ParagraphHorizontalAlign r7 = new ParagraphHorizontalAlign("kDistributed", 4);
            kDistributed = r7;
            $VALUES = new ParagraphHorizontalAlign[]{r0, r1, r3, r5, r7};
        }
    }

    public static final enum ParagraphVerticalAlign extends Enum<ParagraphVerticalAlign> {
        private static final /* synthetic */ ParagraphVerticalAlign[] $VALUES = null;
        public static final ParagraphVerticalAlign kBaseline = null;
        public static final ParagraphVerticalAlign kBottom = null;
        public static final ParagraphVerticalAlign kCenter = null;
        public static final ParagraphVerticalAlign kTop = null;

        private ParagraphVerticalAlign(String r1, int r2) {
            super(r1, r2);
        }

        public static ParagraphVerticalAlign valueOf(String r2) {
            return (ParagraphVerticalAlign) ZeusTransformUtils.preCheckCast(Enum.valueOf(ParagraphVerticalAlign.class, r2), ParagraphVerticalAlign.class, "com.obric.aiagent.plugin");
        }

        public static ParagraphVerticalAlign[] values() {
            return (ParagraphVerticalAlign[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ParagraphVerticalAlign[].class, "com.obric.aiagent.plugin");
        }

        static {
            ParagraphVerticalAlign r0 = new ParagraphVerticalAlign("kTop", 0);
            kTop = r0;
            ParagraphVerticalAlign r1 = new ParagraphVerticalAlign("kCenter", 1);
            kCenter = r1;
            ParagraphVerticalAlign r3 = new ParagraphVerticalAlign("kBaseline", 2);
            kBaseline = r3;
            ParagraphVerticalAlign r5 = new ParagraphVerticalAlign("kBottom", 3);
            kBottom = r5;
            $VALUES = new ParagraphVerticalAlign[]{r0, r1, r3, r5};
        }
    }

    public static final enum PathType extends Enum<PathType> {
        private static final /* synthetic */ PathType[] $VALUES = null;
        public static final PathType kArc = null;
        public static final PathType kBezier = null;
        public static final PathType kLines = null;
        public static final PathType kMoveTo = null;
        public static final PathType kMultiPath = null;

        static {
            PathType r0 = new PathType("kLines", 0);
            kLines = r0;
            PathType r1 = new PathType("kArc", 1);
            kArc = r1;
            PathType r3 = new PathType("kBezier", 2);
            kBezier = r3;
            PathType r5 = new PathType("kMoveTo", 3);
            kMoveTo = r5;
            PathType r7 = new PathType("kMultiPath", 4);
            kMultiPath = r7;
            $VALUES = new PathType[]{r0, r1, r3, r5, r7};
        }

        private PathType(String r1, int r2) {
            super(r1, r2);
        }

        public static PathType valueOf(String r2) {
            return (PathType) ZeusTransformUtils.preCheckCast(Enum.valueOf(PathType.class, r2), PathType.class, "com.obric.aiagent.plugin");
        }

        public static PathType[] values() {
            return (PathType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PathType[].class, "com.obric.aiagent.plugin");
        }
    }

    public static class Size {
        public float height;
        public float width;

        public Size(float r1, float r2) {
            this.width = r1;
            this.height = r2;
        }
    }

    public static final enum ThemeColorType extends Enum<ThemeColorType> {
        private static final /* synthetic */ ThemeColorType[] $VALUES = null;
        public static final ThemeColorType kBackground = null;
        public static final ThemeColorType kBlock = null;
        public static final ThemeColorType kFootnote = null;
        public static final ThemeColorType kLink = null;
        public static final ThemeColorType kNormal = null;
        public static final ThemeColorType kPressedLink = null;

        static {
            ThemeColorType r0 = new ThemeColorType("kNormal", 0);
            kNormal = r0;
            ThemeColorType r1 = new ThemeColorType("kLink", 1);
            kLink = r1;
            ThemeColorType r3 = new ThemeColorType("kBackground", 2);
            kBackground = r3;
            ThemeColorType r5 = new ThemeColorType("kBlock", 3);
            kBlock = r5;
            ThemeColorType r7 = new ThemeColorType("kFootnote", 4);
            kFootnote = r7;
            ThemeColorType r9 = new ThemeColorType("kPressedLink", 5);
            kPressedLink = r9;
            $VALUES = new ThemeColorType[]{r0, r1, r3, r5, r7, r9};
        }

        private ThemeColorType(String r1, int r2) {
            super(r1, r2);
        }

        public static ThemeColorType valueOf(String r2) {
            return (ThemeColorType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ThemeColorType.class, r2), ThemeColorType.class, "com.obric.aiagent.plugin");
        }

        public static ThemeColorType[] values() {
            return (ThemeColorType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ThemeColorType[].class, "com.obric.aiagent.plugin");
        }
    }

    public TTTextDefinition() {
    }

    public static FontWeight GetFontWeight(int r2) {
        if (r2 < 0) goto L9;
        FontWeight[] r0 = weight_ordinal_;
        if (r2 >= r0.length) goto L9;
        return r0[r2];
    L9:
        return FontWeight.kNormal_400;
    }

    public static FontStyle GetFontStyle(int r2) {
        if (r2 < 0) goto L9;
        FontStyle[] r0 = style_ordinal_;
        if (r2 >= r0.length) goto L9;
        return r0[r2];
    L9:
        return FontStyle.kNormal;
    }

    public static LinkStyle GetLinkStyle(int r2) {
        if (r2 < 0) goto L9;
        LinkStyle[] r0 = link_ordinal_;
        if (r2 >= r0.length) goto L9;
        return r0[r2];
    L9:
        return LinkStyle.kNone;
    }

    public static ThemeColorType GetThemeColorType(int r2) {
        if (r2 < 0) goto L9;
        ThemeColorType[] r0 = theme_color_ordinal;
        if (r2 >= r0.length) goto L9;
        return r0[r2];
    L9:
        return ThemeColorType.kNormal;
    }

    public static CanvasOp GetCanvasOp(int r1) {
        return canvas_ordinal_[r1];
    }

    public static PathType GetPathType(int r1) {
        return path_ordinal_[r1];
    }

    public static CharacterVerticalAlign GetCharacterVerticalAlign(int r1) {
        return character_vertical_ordinal_[r1];
    }

    public static ParagraphHorizontalAlign GetParagraphHorizontalAlign(int r1) {
        return paragraph_horizon_ordinal_[r1];
    }

    public static ParagraphVerticalAlign GetParagraphVerticalAlign(int r1) {
        return paragraph_vertical_ordinal_[r1];
    }

    public static LayoutResult GetLayoutResult(int r1) {
        return layout_result_ordinal_[r1];
    }

    static {
        weight_ordinal_ = FontWeight.values();
        style_ordinal_ = FontStyle.values();
        link_ordinal_ = LinkStyle.values();
        theme_color_ordinal = ThemeColorType.values();
        canvas_ordinal_ = CanvasOp.values();
        path_ordinal_ = PathType.values();
        character_vertical_ordinal_ = CharacterVerticalAlign.values();
        paragraph_horizon_ordinal_ = ParagraphHorizontalAlign.values();
        paragraph_vertical_ordinal_ = ParagraphVerticalAlign.values();
        layout_result_ordinal_ = LayoutResult.values();
    }
}

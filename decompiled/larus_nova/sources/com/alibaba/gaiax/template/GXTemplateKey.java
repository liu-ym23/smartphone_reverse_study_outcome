package com.alibaba.gaiax.template;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0003\b\u0092\u0001\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010_\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b`\u0010\u0002R\u000e\u0010a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010b\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bc\u0010\u0002R\u000e\u0010d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0081\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0083\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008a\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008b\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0092\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0094\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0095\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0096\u0001"}, d2 = {"Lcom/alibaba/gaiax/template/GXTemplateKey;", "", "()V", "FLEXBOX_ALIGN_CONTENT", "", "FLEXBOX_ALIGN_ITEMS", "FLEXBOX_ALIGN_SELF", "FLEXBOX_ASPECT_RATIO", "FLEXBOX_BORDER", "FLEXBOX_BORDER_BOTTOM", "FLEXBOX_BORDER_LEFT", "FLEXBOX_BORDER_RIGHT", "FLEXBOX_BORDER_TOP", "FLEXBOX_DIRECTION", "FLEXBOX_DISPLAY", "FLEXBOX_FLEX_BASIS", "FLEXBOX_FLEX_DIRECTION", "FLEXBOX_FLEX_GROW", "FLEXBOX_FLEX_SHRINK", "FLEXBOX_FLEX_WRAP", "FLEXBOX_JUSTIFY_CONTENT", "FLEXBOX_MARGIN", "FLEXBOX_MARGIN_BOTTOM", "FLEXBOX_MARGIN_LEFT", "FLEXBOX_MARGIN_RIGHT", "FLEXBOX_MARGIN_TOP", "FLEXBOX_MAX_HEIGHT", "FLEXBOX_MAX_SIZE", "FLEXBOX_MAX_WIDTH", "FLEXBOX_MIN_HEIGHT", "FLEXBOX_MIN_SIZE", "FLEXBOX_MIN_WIDTH", "FLEXBOX_OVERFLOW", "FLEXBOX_PADDING", "FLEXBOX_PADDING_BOTTOM", "FLEXBOX_PADDING_LEFT", "FLEXBOX_PADDING_RIGHT", "FLEXBOX_PADDING_TOP", "FLEXBOX_POSITION_BOTTOM", "FLEXBOX_POSITION_LEFT", "FLEXBOX_POSITION_RIGHT", "FLEXBOX_POSITION_TOP", "FLEXBOX_POSITION_TYPE", "FLEXBOX_SIZE", "FLEXBOX_SIZE_HEIGHT", "FLEXBOX_SIZE_WIDTH", "GAIAX_ACCESSIBILITY_DESC", "GAIAX_ACCESSIBILITY_ENABLE", "GAIAX_ANIMATION", "GAIAX_ANIMATION_TYPE_LOTTIE", "GAIAX_ANIMATION_TYPE_PROP", "GAIAX_AUTO", "GAIAX_CONFIG", "GAIAX_CONTAINER_FOOTER", "GAIAX_CONTAINER_HAS_MORE", "GAIAX_CSS", "GAIAX_CUSTOM_PROPERTY_GRID_COMPUTE_CONTAINER_HEIGHT", "GAIAX_CUSTOM_PROPERTY_SCROLL_COMPUTE_CONTAINER_HEIGHT", "GAIAX_CUSTOM_PROPERTY_VIEW_PORT_WIDTH", "GAIAX_DATA", "GAIAX_DATABINDING", "GAIAX_DATABINDING_HOLDING_OFFSET", "GAIAX_DATABINDING_ITEM_TYPE", "GAIAX_DATABINDING_ITEM_TYPE_CONFIG", "GAIAX_DATABINDING_ITEM_TYPE_PATH", "GAIAX_EVENT", "GAIAX_EXTEND", "GAIAX_GESTURE_TYPE", "GAIAX_GESTURE_TYPE_JS_TAP", "GAIAX_GESTURE_TYPE_LONGPRESS", "GAIAX_GESTURE_TYPE_TAP", "GAIAX_HIGHLIGHT_COLOR", "GAIAX_HIGHLIGHT_FONT_FAMILY", "GAIAX_HIGHLIGHT_FONT_SIZE", "GAIAX_HIGHLIGHT_FONT_WEIGHT", "GAIAX_HIGHLIGHT_REGEX", "GAIAX_HIGHLIGHT_TAG", "GAIAX_HORIZONTAL", "GAIAX_ICONFONT_FONT_FAMILY_DEFAULT_NAME", "GAIAX_INDEX_CSS", "GAIAX_INDEX_DATABINDING", "GAIAX_INDEX_JS", "GAIAX_INDEX_JSON", "GAIAX_INDEX_MOCK", "GAIAX_JS", "GAIAX_LAYER", "GAIAX_LAYERS", "GAIAX_LAYER_CLASS", "GAIAX_LAYER_COLUMN", "GAIAX_LAYER_CUSTOM_VIEW_CLASS", "GAIAX_LAYER_DIRECTION", "GAIAX_LAYER_EDGE_INSETS", "GAIAX_LAYER_EXP_VERSION", "GAIAX_LAYER_GRAVITY", "GAIAX_LAYER_ID", "GAIAX_LAYER_INTERITEM_SPACING", "getGAIAX_LAYER_INTERITEM_SPACING$annotations", "GAIAX_LAYER_ITEM_SPACING", "GAIAX_LAYER_LINE_SPACING", "getGAIAX_LAYER_LINE_SPACING$annotations", "GAIAX_LAYER_PROGRESS_ANIMATED", "GAIAX_LAYER_PROGRESS_STROKE_COLOR", "GAIAX_LAYER_PROGRESS_TRAIL_COLOR", "GAIAX_LAYER_PROGRESS_TYPE", "GAIAX_LAYER_ROW_SPACING", "GAIAX_LAYER_SCROLL_ENABLE", "GAIAX_LAYER_SLIDER_HAS_INDICATOR", "GAIAX_LAYER_SLIDER_INDICATOR_SELECTED_COLOR", "GAIAX_LAYER_SLIDER_INDICATOR_UNSELECTED_COLOR", "GAIAX_LAYER_SLIDER_INFINITY_SCROLL", "GAIAX_LAYER_SLIDER_SCROLL_TIME_INTERVAL", "GAIAX_LAYER_SLIDER_SELECTED_INDEX", "GAIAX_LAYER_SUB_TYPE", "GAIAX_LAYER_TYPE", "GAIAX_PE", "GAIAX_PLACEHOLDER", "GAIAX_PT", "GAIAX_PX", "GAIAX_TEMPLATE_BIZ", "GAIAX_TEMPLATE_ID", "GAIAX_TEMPLATE_TYPE", "GAIAX_TEMPLATE_VERSION", "GAIAX_TRACK", "GAIAX_VALUE", "GAIAX_VERTICAL", "STYLE_BACKDROP_FILTER", "STYLE_BACKGROUND_COLOR", "STYLE_BACKGROUND_IMAGE", "STYLE_BORDER_BOTTOM_LEFT_RADIUS", "STYLE_BORDER_BOTTOM_RIGHT_RADIUS", "STYLE_BORDER_COLOR", "STYLE_BORDER_RADIUS", "STYLE_BORDER_TOP_LEFT_RADIUS", "STYLE_BORDER_TOP_RIGHT_RADIUS", "STYLE_BORDER_WIDTH", "STYLE_BOX_SHADOW", "STYLE_FIT_CONTENT", "STYLE_FONT_COLOR", "STYLE_FONT_FAMILY", "STYLE_FONT_LINES", "STYLE_FONT_LINE_HEIGHT", "STYLE_FONT_SIZE", "STYLE_FONT_TEXT_ALIGN", "STYLE_FONT_TEXT_DECORATION", "STYLE_FONT_TEXT_OVERFLOW", "STYLE_FONT_WEIGHT", "STYLE_HIDDEN", "STYLE_MODE", "STYLE_MODE_TYPE", "STYLE_OPACITY", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXTemplateKey {
    public static final String FLEXBOX_ALIGN_CONTENT = "align-content";
    public static final String FLEXBOX_ALIGN_ITEMS = "align-items";
    public static final String FLEXBOX_ALIGN_SELF = "align-self";
    public static final String FLEXBOX_ASPECT_RATIO = "aspect-ratio";
    public static final String FLEXBOX_BORDER = "border";
    public static final String FLEXBOX_BORDER_BOTTOM = "border-bottom";
    public static final String FLEXBOX_BORDER_LEFT = "border-left";
    public static final String FLEXBOX_BORDER_RIGHT = "border-right";
    public static final String FLEXBOX_BORDER_TOP = "border-top";
    public static final String FLEXBOX_DIRECTION = "direction";
    public static final String FLEXBOX_DISPLAY = "display";
    public static final String FLEXBOX_FLEX_BASIS = "flex-basis";
    public static final String FLEXBOX_FLEX_DIRECTION = "flex-direction";
    public static final String FLEXBOX_FLEX_GROW = "flex-grow";
    public static final String FLEXBOX_FLEX_SHRINK = "flex-shrink";
    public static final String FLEXBOX_FLEX_WRAP = "flex-wrap";
    public static final String FLEXBOX_JUSTIFY_CONTENT = "justify-content";
    public static final String FLEXBOX_MARGIN = "margin";
    public static final String FLEXBOX_MARGIN_BOTTOM = "margin-bottom";
    public static final String FLEXBOX_MARGIN_LEFT = "margin-left";
    public static final String FLEXBOX_MARGIN_RIGHT = "margin-right";
    public static final String FLEXBOX_MARGIN_TOP = "margin-top";
    public static final String FLEXBOX_MAX_HEIGHT = "max-height";
    public static final String FLEXBOX_MAX_SIZE = "max-size";
    public static final String FLEXBOX_MAX_WIDTH = "max-width";
    public static final String FLEXBOX_MIN_HEIGHT = "min-height";
    public static final String FLEXBOX_MIN_SIZE = "min-size";
    public static final String FLEXBOX_MIN_WIDTH = "min-width";
    public static final String FLEXBOX_OVERFLOW = "overflow";
    public static final String FLEXBOX_PADDING = "padding";
    public static final String FLEXBOX_PADDING_BOTTOM = "padding-bottom";
    public static final String FLEXBOX_PADDING_LEFT = "padding-left";
    public static final String FLEXBOX_PADDING_RIGHT = "padding-right";
    public static final String FLEXBOX_PADDING_TOP = "padding-top";
    public static final String FLEXBOX_POSITION_BOTTOM = "bottom";
    public static final String FLEXBOX_POSITION_LEFT = "left";
    public static final String FLEXBOX_POSITION_RIGHT = "right";
    public static final String FLEXBOX_POSITION_TOP = "top";
    public static final String FLEXBOX_POSITION_TYPE = "position";
    public static final String FLEXBOX_SIZE = "size";
    public static final String FLEXBOX_SIZE_HEIGHT = "height";
    public static final String FLEXBOX_SIZE_WIDTH = "width";
    public static final String GAIAX_ACCESSIBILITY_DESC = "accessibilityDesc";
    public static final String GAIAX_ACCESSIBILITY_ENABLE = "accessibilityEnable";
    public static final String GAIAX_ANIMATION = "animation";
    public static final String GAIAX_ANIMATION_TYPE_LOTTIE = "'LOTTIE'";
    public static final String GAIAX_ANIMATION_TYPE_PROP = "'PROP'";
    public static final String GAIAX_AUTO = "auto";
    public static final String GAIAX_CONFIG = "config";
    public static final String GAIAX_CONTAINER_FOOTER = "item-footer-type";
    public static final String GAIAX_CONTAINER_HAS_MORE = "hasMore";
    public static final String GAIAX_CSS = "css";
    public static final String GAIAX_CUSTOM_PROPERTY_GRID_COMPUTE_CONTAINER_HEIGHT = "grid-compute-container-height";
    public static final String GAIAX_CUSTOM_PROPERTY_SCROLL_COMPUTE_CONTAINER_HEIGHT = "scroll-compute-container-height";
    public static final String GAIAX_CUSTOM_PROPERTY_VIEW_PORT_WIDTH = "view-port-width";
    public static final String GAIAX_DATA = "data";
    public static final String GAIAX_DATABINDING = "databinding";
    public static final String GAIAX_DATABINDING_HOLDING_OFFSET = "holding-offset";
    public static final String GAIAX_DATABINDING_ITEM_TYPE = "item-type";
    public static final String GAIAX_DATABINDING_ITEM_TYPE_CONFIG = "config";
    public static final String GAIAX_DATABINDING_ITEM_TYPE_PATH = "path";
    public static final String GAIAX_EVENT = "event";
    public static final String GAIAX_EXTEND = "extend";
    public static final String GAIAX_GESTURE_TYPE = "type";
    public static final String GAIAX_GESTURE_TYPE_JS_TAP = "click";
    public static final String GAIAX_GESTURE_TYPE_LONGPRESS = "longpress";
    public static final String GAIAX_GESTURE_TYPE_TAP = "tap";
    public static final String GAIAX_HIGHLIGHT_COLOR = "highlight-color";
    public static final String GAIAX_HIGHLIGHT_FONT_FAMILY = "highlight-font-family";
    public static final String GAIAX_HIGHLIGHT_FONT_SIZE = "highlight-font-size";
    public static final String GAIAX_HIGHLIGHT_FONT_WEIGHT = "highlight-font-weight";
    public static final String GAIAX_HIGHLIGHT_REGEX = "(.*?)";
    public static final String GAIAX_HIGHLIGHT_TAG = "highlight-tag";
    public static final String GAIAX_HORIZONTAL = "horizontal";
    public static final String GAIAX_ICONFONT_FONT_FAMILY_DEFAULT_NAME = "iconfont";
    public static final String GAIAX_INDEX_CSS = "index.css";
    public static final String GAIAX_INDEX_DATABINDING = "index.databinding";
    public static final String GAIAX_INDEX_JS = "index.js";
    public static final String GAIAX_INDEX_JSON = "index.json";
    public static final String GAIAX_INDEX_MOCK = "index.mock";
    public static final String GAIAX_JS = "js";
    public static final String GAIAX_LAYER = "layer";
    public static final String GAIAX_LAYERS = "layers";
    public static final String GAIAX_LAYER_CLASS = "class";
    public static final String GAIAX_LAYER_COLUMN = "column";
    public static final String GAIAX_LAYER_CUSTOM_VIEW_CLASS = "view-class-android";
    public static final String GAIAX_LAYER_DIRECTION = "direction";
    public static final String GAIAX_LAYER_EDGE_INSETS = "edge-insets";
    public static final String GAIAX_LAYER_EXP_VERSION = "exp-version";
    public static final String GAIAX_LAYER_GRAVITY = "gravity";
    public static final String GAIAX_LAYER_ID = "id";
    public static final String GAIAX_LAYER_INTERITEM_SPACING = "interitem-spacing";
    public static final String GAIAX_LAYER_ITEM_SPACING = "item-spacing";
    public static final String GAIAX_LAYER_LINE_SPACING = "line-spacing";
    public static final String GAIAX_LAYER_PROGRESS_ANIMATED = "animated";
    public static final String GAIAX_LAYER_PROGRESS_STROKE_COLOR = "stroke-color";
    public static final String GAIAX_LAYER_PROGRESS_TRAIL_COLOR = "trail-color";
    public static final String GAIAX_LAYER_PROGRESS_TYPE = "progress-type";
    public static final String GAIAX_LAYER_ROW_SPACING = "row-spacing";
    public static final String GAIAX_LAYER_SCROLL_ENABLE = "scroll-enable";
    public static final String GAIAX_LAYER_SLIDER_HAS_INDICATOR = "slider-has-indicator";
    public static final String GAIAX_LAYER_SLIDER_INDICATOR_SELECTED_COLOR = "slider-indicator-selected-color";
    public static final String GAIAX_LAYER_SLIDER_INDICATOR_UNSELECTED_COLOR = "slider-indicator-unselected-color";
    public static final String GAIAX_LAYER_SLIDER_INFINITY_SCROLL = "slider-infinity-scroll";
    public static final String GAIAX_LAYER_SLIDER_SCROLL_TIME_INTERVAL = "slider-scroll-time-interval";
    public static final String GAIAX_LAYER_SLIDER_SELECTED_INDEX = "slider-selected-index";
    public static final String GAIAX_LAYER_SUB_TYPE = "sub-type";
    public static final String GAIAX_LAYER_TYPE = "type";
    public static final String GAIAX_PE = "%";
    public static final String GAIAX_PLACEHOLDER = "placeholder";
    public static final String GAIAX_PT = "pt";
    public static final String GAIAX_PX = "px";
    public static final String GAIAX_TEMPLATE_BIZ = "templateBiz";
    public static final String GAIAX_TEMPLATE_ID = "templateId";
    public static final String GAIAX_TEMPLATE_TYPE = "templateType";
    public static final String GAIAX_TEMPLATE_VERSION = "templateVersion";
    public static final String GAIAX_TRACK = "track";
    public static final String GAIAX_VALUE = "value";
    public static final String GAIAX_VERTICAL = "vertical";
    public static final GXTemplateKey INSTANCE = null;
    public static final String STYLE_BACKDROP_FILTER = "backdrop-filter";
    public static final String STYLE_BACKGROUND_COLOR = "background-color";
    public static final String STYLE_BACKGROUND_IMAGE = "background-image";
    public static final String STYLE_BORDER_BOTTOM_LEFT_RADIUS = "border-bottom-left-radius";
    public static final String STYLE_BORDER_BOTTOM_RIGHT_RADIUS = "border-bottom-right-radius";
    public static final String STYLE_BORDER_COLOR = "border-color";
    public static final String STYLE_BORDER_RADIUS = "border-radius";
    public static final String STYLE_BORDER_TOP_LEFT_RADIUS = "border-top-left-radius";
    public static final String STYLE_BORDER_TOP_RIGHT_RADIUS = "border-top-right-radius";
    public static final String STYLE_BORDER_WIDTH = "border-width";
    public static final String STYLE_BOX_SHADOW = "box-shadow";
    public static final String STYLE_FIT_CONTENT = "fit-content";
    public static final String STYLE_FONT_COLOR = "color";
    public static final String STYLE_FONT_FAMILY = "font-family";
    public static final String STYLE_FONT_LINES = "lines";
    public static final String STYLE_FONT_LINE_HEIGHT = "line-height";
    public static final String STYLE_FONT_SIZE = "font-size";
    public static final String STYLE_FONT_TEXT_ALIGN = "text-align";
    public static final String STYLE_FONT_TEXT_DECORATION = "text-decoration";
    public static final String STYLE_FONT_TEXT_OVERFLOW = "text-overflow";
    public static final String STYLE_FONT_WEIGHT = "font-weight";
    public static final String STYLE_HIDDEN = "hidden";
    public static final String STYLE_MODE = "mode";
    public static final String STYLE_MODE_TYPE = "mode-type";
    public static final String STYLE_OPACITY = "opacity";

    static {
        INSTANCE = new GXTemplateKey();
    }

    private GXTemplateKey() {
    }

    @Deprecated(message = "Compatible")
    public static /* synthetic */ void getGAIAX_LAYER_INTERITEM_SPACING$annotations() {
    }

    @Deprecated(message = "Compatible")
    public static /* synthetic */ void getGAIAX_LAYER_LINE_SPACING$annotations() {
    }
}

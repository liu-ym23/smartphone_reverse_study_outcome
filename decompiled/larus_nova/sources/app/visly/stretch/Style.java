package app.visly.stretch;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u.d;
import u.e;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b3\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\bb\b\u0087\b\u0018\u0000 ×\u00012\u00020\u0001:\u0002Ø\u0001B\u0087\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020H\u0012\b\b\u0002\u0010\b\u001a\u00020J\u0012\b\b\u0002\u0010\t\u001a\u00020L\u0012\b\b\u0002\u0010\n\u001a\u00020N\u0012\b\b\u0002\u0010\u000b\u001a\u00020P\u0012\b\b\u0002\u0010\f\u001a\u00020R\u0012\b\b\u0002\u0010\r\u001a\u00020T\u0012\b\b\u0002\u0010\u000e\u001a\u00020V\u0012\b\b\u0002\u0010\u000f\u001a\u00020X\u0012\b\b\u0002\u0010\u0010\u001a\u00020Z\u0012\u000e\b\u0002\u0010k\u001a\b\u0012\u0004\u0012\u00020]0\\\u0012\u000e\b\u0002\u0010l\u001a\b\u0012\u0004\u0012\u00020]0\\\u0012\u000e\b\u0002\u0010m\u001a\b\u0012\u0004\u0012\u00020]0\\\u0012\u000e\b\u0002\u0010n\u001a\b\u0012\u0004\u0012\u00020]0\\\u0012\b\b\u0002\u00102\u001a\u00020\u0012\u0012\b\b\u0002\u00103\u001a\u00020\u0012\u0012\b\b\u0002\u0010o\u001a\u00020]\u0012\u000e\b\u0002\u0010p\u001a\b\u0012\u0004\u0012\u00020]0e\u0012\u000e\b\u0002\u0010q\u001a\b\u0012\u0004\u0012\u00020]0e\u0012\u000e\b\u0002\u0010r\u001a\b\u0012\u0004\u0012\u00020]0e\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0012¢\u0006\u0006\bÕ\u0001\u0010Ö\u0001J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082 Já\u0003\u0010C\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u0012H\u0082 J\u0006\u0010D\u001a\u00020\u0004J\u0006\u0010E\u001a\u00020\u0004J\b\u0010G\u001a\u00020FH\u0016J\t\u0010I\u001a\u00020HHÆ\u0003J\t\u0010K\u001a\u00020JHÆ\u0003J\t\u0010M\u001a\u00020LHÆ\u0003J\t\u0010O\u001a\u00020NHÆ\u0003J\t\u0010Q\u001a\u00020PHÆ\u0003J\t\u0010S\u001a\u00020RHÆ\u0003J\t\u0010U\u001a\u00020THÆ\u0003J\t\u0010W\u001a\u00020VHÆ\u0003J\t\u0010Y\u001a\u00020XHÆ\u0003J\t\u0010[\u001a\u00020ZHÆ\u0003J\u000f\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\\HÆ\u0003J\u000f\u0010_\u001a\b\u0012\u0004\u0012\u00020]0\\HÆ\u0003J\u000f\u0010`\u001a\b\u0012\u0004\u0012\u00020]0\\HÆ\u0003J\u000f\u0010a\u001a\b\u0012\u0004\u0012\u00020]0\\HÆ\u0003J\t\u0010b\u001a\u00020\u0012HÆ\u0003J\t\u0010c\u001a\u00020\u0012HÆ\u0003J\t\u0010d\u001a\u00020]HÆ\u0003J\u000f\u0010f\u001a\b\u0012\u0004\u0012\u00020]0eHÆ\u0003J\u000f\u0010g\u001a\b\u0012\u0004\u0012\u00020]0eHÆ\u0003J\u000f\u0010h\u001a\b\u0012\u0004\u0012\u00020]0eHÆ\u0003J\u0012\u0010i\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\bi\u0010jJ\u008e\u0002\u0010s\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020H2\b\b\u0002\u0010\b\u001a\u00020J2\b\b\u0002\u0010\t\u001a\u00020L2\b\b\u0002\u0010\n\u001a\u00020N2\b\b\u0002\u0010\u000b\u001a\u00020P2\b\b\u0002\u0010\f\u001a\u00020R2\b\b\u0002\u0010\r\u001a\u00020T2\b\b\u0002\u0010\u000e\u001a\u00020V2\b\b\u0002\u0010\u000f\u001a\u00020X2\b\b\u0002\u0010\u0010\u001a\u00020Z2\u000e\b\u0002\u0010k\u001a\b\u0012\u0004\u0012\u00020]0\\2\u000e\b\u0002\u0010l\u001a\b\u0012\u0004\u0012\u00020]0\\2\u000e\b\u0002\u0010m\u001a\b\u0012\u0004\u0012\u00020]0\\2\u000e\b\u0002\u0010n\u001a\b\u0012\u0004\u0012\u00020]0\\2\b\b\u0002\u00102\u001a\u00020\u00122\b\b\u0002\u00103\u001a\u00020\u00122\b\b\u0002\u0010o\u001a\u00020]2\u000e\b\u0002\u0010p\u001a\b\u0012\u0004\u0012\u00020]0e2\u000e\b\u0002\u0010q\u001a\b\u0012\u0004\u0012\u00020]0e2\u000e\b\u0002\u0010r\u001a\b\u0012\u0004\u0012\u00020]0e2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0004\bs\u0010tJ\t\u0010u\u001a\u00020\u0006HÖ\u0001J\u0013\u0010x\u001a\u00020w2\b\u0010v\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0007\u001a\u00020H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R%\u0010\b\u001a\u00020J8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0004\b\b\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R'\u0010\t\u001a\u00020L8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\t\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R'\u0010\n\u001a\u00020N8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\n\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R'\u0010\u000b\u001a\u00020P8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u000b\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R'\u0010\f\u001a\u00020R8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\f\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R'\u0010\r\u001a\u00020T8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\r\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R'\u0010\u000e\u001a\u00020V8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u000e\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001R'\u0010\u000f\u001a\u00020X8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u000f\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R'\u0010\u0010\u001a\u00020Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0010\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R-\u0010k\u001a\b\u0012\u0004\u0012\u00020]0\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bk\u0010«\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0006\b®\u0001\u0010¯\u0001R-\u0010l\u001a\b\u0012\u0004\u0012\u00020]0\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bl\u0010«\u0001\u001a\u0006\b°\u0001\u0010\u00ad\u0001\"\u0006\b±\u0001\u0010¯\u0001R-\u0010m\u001a\b\u0012\u0004\u0012\u00020]0\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bm\u0010«\u0001\u001a\u0006\b²\u0001\u0010\u00ad\u0001\"\u0006\b³\u0001\u0010¯\u0001R-\u0010n\u001a\b\u0012\u0004\u0012\u00020]0\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bn\u0010«\u0001\u001a\u0006\b´\u0001\u0010\u00ad\u0001\"\u0006\bµ\u0001\u0010¯\u0001R'\u00102\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b2\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R'\u00103\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b3\u0010¶\u0001\u001a\u0006\b»\u0001\u0010¸\u0001\"\u0006\b¼\u0001\u0010º\u0001R'\u0010o\u001a\u00020]8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bo\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R-\u0010p\u001a\b\u0012\u0004\u0012\u00020]0e8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bp\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R-\u0010q\u001a\b\u0012\u0004\u0012\u00020]0e8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bq\u0010Â\u0001\u001a\u0006\bÇ\u0001\u0010Ä\u0001\"\u0006\bÈ\u0001\u0010Æ\u0001R-\u0010r\u001a\b\u0012\u0004\u0012\u00020]0e8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\br\u0010Â\u0001\u001a\u0006\bÉ\u0001\u0010Ä\u0001\"\u0006\bÊ\u0001\u0010Æ\u0001R(\u0010B\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\bB\u0010Ë\u0001\u001a\u0005\bÌ\u0001\u0010j\"\u0006\bÍ\u0001\u0010Î\u0001R)\u0010Ï\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÏ\u0001\u0010Ð\u0001\u001a\u0006\bÑ\u0001\u0010Ò\u0001\"\u0006\bÓ\u0001\u0010Ô\u0001¨\u0006Ù\u0001"}, d2 = {"Lapp/visly/stretch/Style;", "", "", "ptr", "", "nFree", "", "display", "positionType", "direction", "flexDirection", "flexWrap", "overflow", "alignItems", "alignSelf", "alignContent", "justifyContent", "positionStartType", "", "positionStartValue", "positionEndType", "positionEndValue", "positionTopType", "positionTopValue", "positionBottomType", "positionBottomValue", "marginStartType", "marginStartValue", "marginEndType", "marginEndValue", "marginTopType", "marginTopValue", "marginBottomType", "marginBottomValue", "paddingStartType", "paddingStartValue", "paddingEndType", "paddingEndValue", "paddingTopType", "paddingTopValue", "paddingBottomType", "paddingBottomValue", "borderStartType", "borderStartValue", "borderEndType", "borderEndValue", "borderTopType", "borderTopValue", "borderBottomType", "borderBottomValue", "flexGrow", "flexShrink", "flexBasisType", "flexBasisValue", "widthType", "widthValue", "heightType", "heightValue", "minWidthType", "minWidthValue", "minHeightType", "minHeightValue", "maxWidthType", "maxWidthValue", "maxHeightType", "maxHeightValue", "aspectRatio", "nConstruct", "init", "free", "", "toString", "Lapp/visly/stretch/Display;", "component1", "Lapp/visly/stretch/PositionType;", "component2", "Lapp/visly/stretch/Direction;", "component3", "Lapp/visly/stretch/FlexDirection;", "component4", "Lapp/visly/stretch/FlexWrap;", "component5", "Lapp/visly/stretch/Overflow;", "component6", "Lapp/visly/stretch/AlignItems;", "component7", "Lapp/visly/stretch/AlignSelf;", "component8", "Lapp/visly/stretch/AlignContent;", "component9", "Lapp/visly/stretch/JustifyContent;", "component10", "Lu/d;", "Lu/a;", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "Lu/e;", "component18", "component19", "component20", "component21", "()Ljava/lang/Float;", "position", GXTemplateKey.FLEXBOX_MARGIN, GXTemplateKey.FLEXBOX_PADDING, "border", "flexBasis", "size", "minSize", "maxSize", "copy", "(Lapp/visly/stretch/Display;Lapp/visly/stretch/PositionType;Lapp/visly/stretch/Direction;Lapp/visly/stretch/FlexDirection;Lapp/visly/stretch/FlexWrap;Lapp/visly/stretch/Overflow;Lapp/visly/stretch/AlignItems;Lapp/visly/stretch/AlignSelf;Lapp/visly/stretch/AlignContent;Lapp/visly/stretch/JustifyContent;Lu/d;Lu/d;Lu/d;Lu/d;FFLu/a;Lu/e;Lu/e;Lu/e;Ljava/lang/Float;)Lapp/visly/stretch/Style;", "hashCode", "other", "", "equals", "Lapp/visly/stretch/Display;", "getDisplay", "()Lapp/visly/stretch/Display;", "setDisplay", "(Lapp/visly/stretch/Display;)V", "Lapp/visly/stretch/PositionType;", "getPositionType", "()Lapp/visly/stretch/PositionType;", "setPositionType", "(Lapp/visly/stretch/PositionType;)V", "Lapp/visly/stretch/Direction;", "getDirection", "()Lapp/visly/stretch/Direction;", "setDirection", "(Lapp/visly/stretch/Direction;)V", "Lapp/visly/stretch/FlexDirection;", "getFlexDirection", "()Lapp/visly/stretch/FlexDirection;", "setFlexDirection", "(Lapp/visly/stretch/FlexDirection;)V", "Lapp/visly/stretch/FlexWrap;", "getFlexWrap", "()Lapp/visly/stretch/FlexWrap;", "setFlexWrap", "(Lapp/visly/stretch/FlexWrap;)V", "Lapp/visly/stretch/Overflow;", "getOverflow", "()Lapp/visly/stretch/Overflow;", "setOverflow", "(Lapp/visly/stretch/Overflow;)V", "Lapp/visly/stretch/AlignItems;", "getAlignItems", "()Lapp/visly/stretch/AlignItems;", "setAlignItems", "(Lapp/visly/stretch/AlignItems;)V", "Lapp/visly/stretch/AlignSelf;", "getAlignSelf", "()Lapp/visly/stretch/AlignSelf;", "setAlignSelf", "(Lapp/visly/stretch/AlignSelf;)V", "Lapp/visly/stretch/AlignContent;", "getAlignContent", "()Lapp/visly/stretch/AlignContent;", "setAlignContent", "(Lapp/visly/stretch/AlignContent;)V", "Lapp/visly/stretch/JustifyContent;", "getJustifyContent", "()Lapp/visly/stretch/JustifyContent;", "setJustifyContent", "(Lapp/visly/stretch/JustifyContent;)V", "Lu/d;", "getPosition", "()Lu/d;", "setPosition", "(Lu/d;)V", "getMargin", "setMargin", "getPadding", "setPadding", "getBorder", "setBorder", FaceService.girlLabel, "getFlexGrow", "()F", "setFlexGrow", "(F)V", "getFlexShrink", "setFlexShrink", "Lu/a;", "getFlexBasis", "()Lu/a;", "setFlexBasis", "(Lu/a;)V", "Lu/e;", "getSize", "()Lu/e;", "setSize", "(Lu/e;)V", "getMinSize", "setMinSize", "getMaxSize", "setMaxSize", "Ljava/lang/Float;", "getAspectRatio", "setAspectRatio", "(Ljava/lang/Float;)V", "rustptr", "J", "getRustptr", "()J", "setRustptr", "(J)V", "<init>", "(Lapp/visly/stretch/Display;Lapp/visly/stretch/PositionType;Lapp/visly/stretch/Direction;Lapp/visly/stretch/FlexDirection;Lapp/visly/stretch/FlexWrap;Lapp/visly/stretch/Overflow;Lapp/visly/stretch/AlignItems;Lapp/visly/stretch/AlignSelf;Lapp/visly/stretch/AlignContent;Lapp/visly/stretch/JustifyContent;Lu/d;Lu/d;Lu/d;Lu/d;FFLu/a;Lu/e;Lu/e;Lu/e;Ljava/lang/Float;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "GaiaX"}, k = 1, mv = {1, 7, 1})
public final class Style {
    public static final a Companion = null;
    private AlignContent alignContent;
    private AlignItems alignItems;
    private AlignSelf alignSelf;
    private Float aspectRatio;
    private d<u.a> border;
    private Direction direction;
    private Display display;
    private u.a flexBasis;
    private FlexDirection flexDirection;
    private float flexGrow;
    private float flexShrink;
    private FlexWrap flexWrap;
    private JustifyContent justifyContent;
    private d<u.a> margin;
    private e<u.a> maxSize;
    private e<u.a> minSize;
    private Overflow overflow;
    private d<u.a> padding;
    private d<u.a> position;
    private PositionType positionType;
    private long rustptr;
    private e<u.a> size;

    public static final class a {
        public a() {
        }
    }

    public Style() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0.0f, 0.0f, null, null, null, null, null, 2097151, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Style copy$default(Style r110, Display r111, PositionType r112, Direction r210, FlexDirection r211, FlexWrap r212, Overflow r213, AlignItems r214, AlignSelf r215, AlignContent r216, JustifyContent r217, d r218, d r219, d r310, d r311, float r312, float r313, u.a r314, e r315, e r316, e r317, Float r318, int r319, Object r410) {
        if ((r319 & 1) == 0) goto L5;
        Display r100 = r110.display;
    L7:
        if ((r319 & 2) == 0) goto L9;
        PositionType r101 = r110.positionType;
    L11:
        if ((r319 & 4) == 0) goto L13;
        Direction r102 = r110.direction;
    L15:
        if ((r319 & 8) == 0) goto L17;
        FlexDirection r103 = r110.flexDirection;
    L19:
        if ((r319 & 16) == 0) goto L21;
        FlexWrap r104 = r110.flexWrap;
    L23:
        if ((r319 & 32) == 0) goto L25;
        Overflow r105 = r110.overflow;
    L27:
        if ((r319 & 64) == 0) goto L29;
        AlignItems r106 = r110.alignItems;
    L31:
        if ((r319 & 128) == 0) goto L33;
        AlignSelf r107 = r110.alignSelf;
    L35:
        if ((r319 & 256) == 0) goto L37;
        AlignContent r113 = r110.alignContent;
    L39:
        if ((r319 & 512) == 0) goto L41;
        JustifyContent r114 = r110.justifyContent;
    L43:
        if ((r319 & 1024) == 0) goto L45;
        d r115 = r110.position;
    L47:
        if ((r319 & 2048) == 0) goto L49;
        d r116 = r110.margin;
    L51:
        if ((r319 & 4096) == 0) goto L53;
        d r117 = r110.padding;
    L55:
        if ((r319 & 8192) == 0) goto L57;
        d r118 = r110.border;
    L58:
        d r320 = r118;
        if ((r319 & 16384) == 0) goto L61;
        float r119 = r110.flexGrow;
    L62:
        float r321 = r119;
        if ((r319 & 32768) == 0) goto L65;
        float r120 = r110.flexShrink;
    L66:
        float r322 = r120;
        if ((r319 & 65536) == 0) goto L69;
        u.a r121 = r110.flexBasis;
    L70:
        u.a r323 = r121;
        if ((r319 & 131072) == 0) goto L73;
        e r122 = r110.size;
    L74:
        e r324 = r122;
        if ((r319 & 262144) == 0) goto L77;
        e r123 = r110.minSize;
    L78:
        e r325 = r123;
        if ((r319 & 524288) == 0) goto L81;
        e r124 = r110.maxSize;
    L83:
        if ((r319 & 1048576) == 0) goto L85;
        Float r108 = r110.aspectRatio;
    L87:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r124, r108);
    L85:
        r108 = r318;
        goto L87
    L81:
        r124 = r317;
        goto L83
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    private final native long nConstruct(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r110, int r111, float r112, int r113, float r114, int r115, float r116, int r117, float r118, int r119, float r210, int r211, float r212, int r213, float r214, int r215, float r216, int r217, float r218, int r219, float r310, int r311, float r312, int r313, float r314, int r315, float r316, int r317, float r318, int r319, float r410, int r411, float r412, float r413, float r414, int r415, float r416, int r417, float r418, int r419, float r510, int r511, float r512, int r513, float r514, int r515, float r516, int r517, float r518, float r519);

    private final native void nFree(long r100);

    public final Display component1() {
        return this.display;
    }

    public final JustifyContent component10() {
        return this.justifyContent;
    }

    public final d<u.a> component11() {
        return this.position;
    }

    public final d<u.a> component12() {
        return this.margin;
    }

    public final d<u.a> component13() {
        return this.padding;
    }

    public final d<u.a> component14() {
        return this.border;
    }

    public final float component15() {
        return this.flexGrow;
    }

    public final float component16() {
        return this.flexShrink;
    }

    public final u.a component17() {
        return this.flexBasis;
    }

    public final e<u.a> component18() {
        return this.size;
    }

    public final e<u.a> component19() {
        return this.minSize;
    }

    public final PositionType component2() {
        return this.positionType;
    }

    public final e<u.a> component20() {
        return this.maxSize;
    }

    public final Float component21() {
        return this.aspectRatio;
    }

    public final Direction component3() {
        return this.direction;
    }

    public final FlexDirection component4() {
        return this.flexDirection;
    }

    public final FlexWrap component5() {
        return this.flexWrap;
    }

    public final Overflow component6() {
        return this.overflow;
    }

    public final AlignItems component7() {
        return this.alignItems;
    }

    public final AlignSelf component8() {
        return this.alignSelf;
    }

    public final AlignContent component9() {
        return this.alignContent;
    }

    public final Style copy(Display r210, PositionType r211, Direction r212, FlexDirection r213, FlexWrap r214, Overflow r310, AlignItems r311, AlignSelf r312, AlignContent r313, JustifyContent r314, d<u.a> r315, d<u.a> r316, d<u.a> r317, d<u.a> r318, float r319, float r410, u.a r411, e<u.a> r412, e<u.a> r413, e<u.a> r414, Float r415) {
        Intrinsics.checkNotNullParameter(r210, "display");
        Intrinsics.checkNotNullParameter(r211, "positionType");
        Intrinsics.checkNotNullParameter(r212, "direction");
        Intrinsics.checkNotNullParameter(r213, "flexDirection");
        Intrinsics.checkNotNullParameter(r214, "flexWrap");
        Intrinsics.checkNotNullParameter(r310, "overflow");
        Intrinsics.checkNotNullParameter(r311, "alignItems");
        Intrinsics.checkNotNullParameter(r312, "alignSelf");
        Intrinsics.checkNotNullParameter(r313, "alignContent");
        Intrinsics.checkNotNullParameter(r314, "justifyContent");
        Intrinsics.checkNotNullParameter(r315, "position");
        Intrinsics.checkNotNullParameter(r316, GXTemplateKey.FLEXBOX_MARGIN);
        Intrinsics.checkNotNullParameter(r317, GXTemplateKey.FLEXBOX_PADDING);
        Intrinsics.checkNotNullParameter(r318, "border");
        Intrinsics.checkNotNullParameter(r411, "flexBasis");
        Intrinsics.checkNotNullParameter(r412, "size");
        Intrinsics.checkNotNullParameter(r413, "minSize");
        Intrinsics.checkNotNullParameter(r414, "maxSize");
        return new Style(r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Style) == true) goto L8;
        return false;
    L8:
        Style r101 = (Style) r100;
        if (this.display == r101.display) goto L12;
        return false;
    L12:
        if (this.positionType == r101.positionType) goto L15;
        return false;
    L15:
        if (this.direction == r101.direction) goto L18;
        return false;
    L18:
        if (this.flexDirection == r101.flexDirection) goto L21;
        return false;
    L21:
        if (this.flexWrap == r101.flexWrap) goto L24;
        return false;
    L24:
        if (this.overflow == r101.overflow) goto L27;
        return false;
    L27:
        if (this.alignItems == r101.alignItems) goto L30;
        return false;
    L30:
        if (this.alignSelf == r101.alignSelf) goto L33;
        return false;
    L33:
        if (this.alignContent == r101.alignContent) goto L36;
        return false;
    L36:
        if (this.justifyContent == r101.justifyContent) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.position, r101.position) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.margin, r101.margin) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.padding, r101.padding) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.border, r101.border) == true) goto L51;
        return false;
    L51:
        if (Float.compare(this.flexGrow, r101.flexGrow) == 0) goto L54;
        return false;
    L54:
        if (Float.compare(this.flexShrink, r101.flexShrink) == 0) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.flexBasis, r101.flexBasis) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.size, r101.size) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.minSize, r101.minSize) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.maxSize, r101.maxSize) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.aspectRatio, r101.aspectRatio) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((((((((((((((((((((((((((((((((this.display.hashCode() * 31) + this.positionType.hashCode()) * 31) + this.direction.hashCode()) * 31) + this.flexDirection.hashCode()) * 31) + this.flexWrap.hashCode()) * 31) + this.overflow.hashCode()) * 31) + this.alignItems.hashCode()) * 31) + this.alignSelf.hashCode()) * 31) + this.alignContent.hashCode()) * 31) + this.justifyContent.hashCode()) * 31) + this.position.hashCode()) * 31) + this.margin.hashCode()) * 31) + this.padding.hashCode()) * 31) + this.border.hashCode()) * 31) + Float.floatToIntBits(this.flexGrow)) * 31) + Float.floatToIntBits(this.flexShrink)) * 31) + this.flexBasis.hashCode()) * 31) + this.size.hashCode()) * 31) + this.minSize.hashCode()) * 31) + this.maxSize.hashCode()) * 31;
        Float r101 = this.aspectRatio;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    static {
        Companion = new a();
        Stretch.Companion.getClass();
        Stretch.a.b();
    }

    public final void free() {
        long r100 = this.rustptr;
        if (r100 == (-1)) goto L6;
        nFree(r100);
        this.rustptr = -1;
        return;
    }

    public final void init() {
        int r100 = this.display.ordinal();
        int r101 = this.positionType.ordinal();
        int r102 = this.direction.ordinal();
        int r103 = this.flexDirection.ordinal();
        int r104 = this.flexWrap.ordinal();
        int r105 = this.overflow.ordinal();
        int r106 = this.alignItems.ordinal();
        int r107 = this.alignSelf.ordinal();
        int r108 = this.alignContent.ordinal();
        int r110 = this.justifyContent.ordinal();
        int r111 = this.position.f548090a.getType();
        float r112 = this.position.f548090a.a();
        int r113 = this.position.f548091b.getType();
        float r114 = this.position.f548091b.a();
        int r115 = this.position.f548092c.getType();
        float r116 = this.position.f548092c.a();
        int r117 = this.position.f548093d.getType();
        float r118 = this.position.f548093d.a();
        int r210 = this.margin.f548090a.getType();
        float r211 = this.margin.f548090a.a();
        int r212 = this.margin.f548091b.getType();
        float r213 = this.margin.f548091b.a();
        int r214 = this.margin.f548092c.getType();
        float r215 = this.margin.f548092c.a();
        int r216 = this.margin.f548093d.getType();
        float r217 = this.margin.f548093d.a();
        int r218 = this.padding.f548090a.getType();
        float r219 = this.padding.f548090a.a();
        int r310 = this.padding.f548091b.getType();
        float r311 = this.padding.f548091b.a();
        int r312 = this.padding.f548092c.getType();
        float r313 = this.padding.f548092c.a();
        int r314 = this.padding.f548093d.getType();
        float r315 = this.padding.f548093d.a();
        int r316 = this.border.f548090a.getType();
        float r317 = this.border.f548090a.a();
        int r318 = this.border.f548091b.getType();
        float r319 = this.border.f548091b.a();
        int r410 = this.border.f548092c.getType();
        float r411 = this.border.f548092c.a();
        int r412 = this.border.f548093d.getType();
        float r413 = this.border.f548093d.a();
        float r109 = this.flexGrow;
        float r119 = this.flexShrink;
        int r414 = this.flexBasis.getType();
        float r415 = this.flexBasis.a();
        int r416 = this.size.f548094a.getType();
        float r417 = this.size.f548094a.a();
        int r510 = this.size.f548095b.getType();
        float r511 = this.size.f548095b.a();
        int r512 = this.minSize.f548094a.getType();
        float r513 = this.minSize.f548094a.a();
        int r514 = this.minSize.f548095b.getType();
        float r515 = this.minSize.f548095b.a();
        int r516 = this.maxSize.f548094a.getType();
        float r517 = this.maxSize.f548094a.a();
        int r518 = this.maxSize.f548095b.getType();
        float r519 = this.maxSize.f548095b.a();
        Float r120 = this.aspectRatio;
        if (r120 == null) goto L5;
        float r610 = r120.floatValue();
    L6:
        this.rustptr = nConstruct(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116, r117, r118, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r109, r119, r414, r415, r416, r417, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610);
        return;
    L5:
        r610 = Float.NaN;
        goto L6
    }

    public String toString() {
        return "Style(display=" + this.display + ", positionType=" + this.positionType + ", direction=" + this.direction + ", flexDirection=" + this.flexDirection + ", flexWrap=" + this.flexWrap + ", overflow=" + this.overflow + ", alignItems=" + this.alignItems + ", alignSelf=" + this.alignSelf + ", alignContent=" + this.alignContent + ", justifyContent=" + this.justifyContent + ", position=" + this.position + ", margin=" + this.margin + ", padding=" + this.padding + ", border=" + this.border + ", flexGrow=" + this.flexGrow + ", flexShrink=" + this.flexShrink + ", flexBasis=" + this.flexBasis + ", size=" + this.size + ", minSize=" + this.minSize + ", maxSize=" + this.maxSize + ", aspectRatio=" + this.aspectRatio + ", rustptr=" + this.rustptr + ')';
    }

    public final AlignContent getAlignContent() {
        return this.alignContent;
    }

    public final AlignItems getAlignItems() {
        return this.alignItems;
    }

    public final AlignSelf getAlignSelf() {
        return this.alignSelf;
    }

    public final Float getAspectRatio() {
        return this.aspectRatio;
    }

    public final d<u.a> getBorder() {
        return this.border;
    }

    public final Direction getDirection() {
        return this.direction;
    }

    public final Display getDisplay() {
        return this.display;
    }

    public final u.a getFlexBasis() {
        return this.flexBasis;
    }

    public final FlexDirection getFlexDirection() {
        return this.flexDirection;
    }

    public final float getFlexGrow() {
        return this.flexGrow;
    }

    public final float getFlexShrink() {
        return this.flexShrink;
    }

    public final FlexWrap getFlexWrap() {
        return this.flexWrap;
    }

    public final JustifyContent getJustifyContent() {
        return this.justifyContent;
    }

    public final d<u.a> getMargin() {
        return this.margin;
    }

    public final e<u.a> getMaxSize() {
        return this.maxSize;
    }

    public final e<u.a> getMinSize() {
        return this.minSize;
    }

    public final Overflow getOverflow() {
        return this.overflow;
    }

    public final d<u.a> getPadding() {
        return this.padding;
    }

    public final d<u.a> getPosition() {
        return this.position;
    }

    public final PositionType getPositionType() {
        return this.positionType;
    }

    public final long getRustptr() {
        return this.rustptr;
    }

    public final e<u.a> getSize() {
        return this.size;
    }

    public final void setAlignContent(AlignContent r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.alignContent = r100;
    }

    public final void setAlignItems(AlignItems r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.alignItems = r100;
    }

    public final void setAlignSelf(AlignSelf r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.alignSelf = r100;
    }

    public final void setAspectRatio(Float r100) {
        this.aspectRatio = r100;
    }

    public final void setBorder(d<u.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.border = r100;
    }

    public final void setDirection(Direction r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.direction = r100;
    }

    public final void setDisplay(Display r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.display = r100;
    }

    public final void setFlexBasis(u.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.flexBasis = r100;
    }

    public final void setFlexDirection(FlexDirection r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.flexDirection = r100;
    }

    public final void setFlexGrow(float r100) {
        this.flexGrow = r100;
    }

    public final void setFlexShrink(float r100) {
        this.flexShrink = r100;
    }

    public final void setFlexWrap(FlexWrap r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.flexWrap = r100;
    }

    public final void setJustifyContent(JustifyContent r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.justifyContent = r100;
    }

    public final void setMargin(d<u.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.margin = r100;
    }

    public final void setMaxSize(e<u.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.maxSize = r100;
    }

    public final void setMinSize(e<u.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.minSize = r100;
    }

    public final void setOverflow(Overflow r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.overflow = r100;
    }

    public final void setPadding(d<u.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.padding = r100;
    }

    public final void setPosition(d<u.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.position = r100;
    }

    public final void setPositionType(PositionType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.positionType = r100;
    }

    public final void setRustptr(long r100) {
        this.rustptr = r100;
    }

    public final void setSize(e<u.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.size = r100;
    }

    public Style(Display r110, PositionType r111, Direction r112, FlexDirection r210, FlexWrap r211, Overflow r212, AlignItems r213, AlignSelf r214, AlignContent r215, JustifyContent r216, d<u.a> r217, d<u.a> r218, d<u.a> r219, d<u.a> r310, float r311, float r312, u.a r313, e<u.a> r314, e<u.a> r315, e<u.a> r316, Float r317) {
        Intrinsics.checkNotNullParameter(r110, "display");
        Intrinsics.checkNotNullParameter(r111, "positionType");
        Intrinsics.checkNotNullParameter(r112, "direction");
        Intrinsics.checkNotNullParameter(r210, "flexDirection");
        Intrinsics.checkNotNullParameter(r211, "flexWrap");
        Intrinsics.checkNotNullParameter(r212, "overflow");
        Intrinsics.checkNotNullParameter(r213, "alignItems");
        Intrinsics.checkNotNullParameter(r214, "alignSelf");
        Intrinsics.checkNotNullParameter(r215, "alignContent");
        Intrinsics.checkNotNullParameter(r216, "justifyContent");
        Intrinsics.checkNotNullParameter(r217, "position");
        Intrinsics.checkNotNullParameter(r218, GXTemplateKey.FLEXBOX_MARGIN);
        Intrinsics.checkNotNullParameter(r219, GXTemplateKey.FLEXBOX_PADDING);
        Intrinsics.checkNotNullParameter(r310, "border");
        Intrinsics.checkNotNullParameter(r313, "flexBasis");
        Intrinsics.checkNotNullParameter(r314, "size");
        Intrinsics.checkNotNullParameter(r315, "minSize");
        Intrinsics.checkNotNullParameter(r316, "maxSize");
        this.display = r110;
        this.positionType = r111;
        this.direction = r112;
        this.flexDirection = r210;
        this.flexWrap = r211;
        this.overflow = r212;
        this.alignItems = r213;
        this.alignSelf = r214;
        this.alignContent = r215;
        this.justifyContent = r216;
        this.position = r217;
        this.margin = r218;
        this.padding = r219;
        this.border = r310;
        this.flexGrow = r311;
        this.flexShrink = r312;
        this.flexBasis = r313;
        this.size = r314;
        this.minSize = r315;
        this.maxSize = r316;
        this.aspectRatio = r317;
        this.rustptr = -1;
    }

    public /* synthetic */ Style(Display r210, PositionType r211, Direction r212, FlexDirection r213, FlexWrap r214, Overflow r215, AlignItems r216, AlignSelf r217, AlignContent r310, JustifyContent r311, d r312, d r313, d r314, d r315, float r316, float r317, u.a r318, e r319, e r410, e r411, Float r412, int r413, DefaultConstructorMarker r414) {
        if ((r413 & 1) == 0) goto L5;
        Display r100 = Display.Flex;
    L7:
        if ((r413 & 2) == 0) goto L9;
        PositionType r101 = PositionType.Relative;
    L11:
        if ((r413 & 4) == 0) goto L13;
        Direction r102 = Direction.Inherit;
    L15:
        if ((r413 & 8) == 0) goto L17;
        FlexDirection r103 = FlexDirection.Row;
    L19:
        if ((r413 & 16) == 0) goto L21;
        FlexWrap r104 = FlexWrap.NoWrap;
    L23:
        if ((r413 & 32) == 0) goto L25;
        Overflow r105 = Overflow.Hidden;
    L27:
        if ((r413 & 64) == 0) goto L29;
        AlignItems r106 = AlignItems.Stretch;
    L31:
        if ((r413 & 128) == 0) goto L33;
        AlignSelf r107 = AlignSelf.Auto;
    L35:
        if ((r413 & 256) == 0) goto L37;
        AlignContent r108 = AlignContent.FlexStart;
    L39:
        if ((r413 & 512) == 0) goto L41;
        JustifyContent r110 = JustifyContent.FlexStart;
    L43:
        if ((r413 & 1024) == 0) goto L45;
        u.a.d r111 = u.a.d.f548081a;
        d r112 = new d(r111, r111, r111, r111);
    L47:
        if ((r413 & 2048) == 0) goto L49;
        u.a.d r113 = u.a.d.f548081a;
        d r114 = new d(r113, r113, r113, r113);
    L51:
        if ((r413 & 4096) == 0) goto L53;
        u.a.d r115 = u.a.d.f548081a;
        d r116 = new d(r115, r115, r115, r115);
    L55:
        if ((r413 & 8192) == 0) goto L57;
        u.a.d r117 = u.a.d.f548081a;
        d r118 = new d(r117, r117, r117, r117);
    L58:
        float r119 = 0.0f;
        if ((r413 & 16384) == 0) goto L61;
        float r120 = 0.0f;
    L63:
        if ((r413 & 32768) != 0) goto L67;
        r119 = r317;
    L67:
        if ((r413 & 65536) == 0) goto L69;
        u.a r121 = u.a.C7810a.f548078a;
    L71:
        if ((r413 & 131072) == 0) goto L73;
        u.a.C7810a r122 = u.a.C7810a.f548078a;
        e r123 = new e(r122, r122);
    L75:
        if ((262144 & r413) == 0) goto L77;
        u.a.C7810a r124 = u.a.C7810a.f548078a;
        e r125 = new e(r124, r124);
    L79:
        if ((524288 & r413) == 0) goto L81;
        u.a.C7810a r126 = u.a.C7810a.f548078a;
        e r127 = new e(r126, r126);
    L83:
        if ((r413 & 1048576) == 0) goto L85;
        Float r109 = null;
    L86:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r112, r114, r116, r118, r120, r119, r121, r123, r125, r127, r109);
        return;
    L85:
        r109 = r412;
        goto L86
    L81:
        r127 = r411;
        goto L83
    L77:
        r125 = r410;
        goto L79
    L73:
        r123 = r319;
        goto L75
    L69:
        r121 = r318;
        goto L71
    L61:
        r120 = r316;
        goto L63
    L57:
        r118 = r315;
        goto L58
    L53:
        r116 = r314;
        goto L55
    L49:
        r114 = r313;
        goto L51
    L45:
        r112 = r312;
        goto L47
    L41:
        r110 = r311;
        goto L43
    L37:
        r108 = r310;
        goto L39
    L33:
        r107 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}

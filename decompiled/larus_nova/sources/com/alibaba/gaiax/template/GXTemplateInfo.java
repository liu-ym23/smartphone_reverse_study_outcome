package com.alibaba.gaiax.template;

import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.alibaba.gaiax.template.animation.GXAnimationBinding;
import com.alibaba.gaiax.template.factory.GXDataBindingFactory;
import com.alibaba.gaiax.template.factory.GXExpressionFactory;
import com.alibaba.gaiax.template.utils.GXCssFileParserUtils;
import com.alibaba.gaiax.utils.GXExtJsonKt;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 [2\u00020\u0001:\u0001[B§\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0013J\b\u0010C\u001a\u00020&H\u0002J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\u0015\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J\u0017\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005HÆ\u0003J\u0017\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005HÆ\u0003J\u0017\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005HÆ\u0003J\u0017\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0005HÆ\u0003J\u0017\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u00ad\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u00052\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00052\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u00052\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00052\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010M\u001a\u00020&2\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u000f2\u0006\u0010P\u001a\u00020\u0006J\u0010\u0010Q\u001a\u0004\u0018\u00010\u00072\u0006\u0010P\u001a\u00020\u0006J\u0010\u0010R\u001a\u0004\u0018\u00010\t2\u0006\u0010P\u001a\u00020\u0006J\u0010\u0010S\u001a\u0004\u0018\u00010\u000b2\u0006\u0010P\u001a\u00020\u0006J\u0010\u0010T\u001a\u0004\u0018\u00010\u00032\u0006\u0010P\u001a\u00020\u0006J\u001a\u0010T\u001a\u0004\u0018\u00010\u00032\u0006\u0010P\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010U\u001a\u0004\u0018\u00010\r2\u0006\u0010P\u001a\u00020\u0006J\u0010\u0010V\u001a\u0004\u0018\u00010\u00002\u0006\u0010P\u001a\u00020\u0006J\u0010\u0010\u001c\u001a\u00020.2\b\u0010\b\u001a\u0004\u0018\u00010.J\t\u0010W\u001a\u00020XHÖ\u0001J\u0006\u0010Y\u001a\u00020&J\t\u0010Z\u001a\u00020\u0006HÖ\u0001R\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001f\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u001c\u0010 \u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b%\u0010'R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020.X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u001a\u00106\u001a\u00020.X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00100\"\u0004\b8\u00102R\u001a\u00109\u001a\u00020.X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00100\"\u0004\b;\u00102R\u001a\u0010<\u001a\u00020=X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0015¨\u0006\\"}, d2 = {"Lcom/alibaba/gaiax/template/GXTemplateInfo;", "", GXTemplateKey.GAIAX_LAYER, "Lcom/alibaba/gaiax/template/GXLayer;", GXTemplateKey.GAIAX_CSS, "", "", "Lcom/alibaba/gaiax/template/GXCss;", "data", "Lcom/alibaba/gaiax/template/GXDataBinding;", "event", "Lcom/alibaba/gaiax/template/GXEventBinding;", GXTemplateKey.GAIAX_TRACK, "Lcom/alibaba/gaiax/template/GXTrackBinding;", GXTemplateKey.GAIAX_ANIMATION, "Lcom/alibaba/gaiax/template/animation/GXAnimationBinding;", "config", "Lcom/alibaba/gaiax/template/GXIExpression;", GXTemplateKey.GAIAX_JS, "(Lcom/alibaba/gaiax/template/GXLayer;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;)V", "getAnimation", "()Ljava/util/Map;", "children", "", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "getConfig", "getCss", "getData", "getEvent", "expVersion", "getExpVersion", "()Ljava/lang/String;", "setExpVersion", "(Ljava/lang/String;)V", "isJsExist", "", "()Z", "isJsExist$delegate", "Lkotlin/Lazy;", "getJs", "getLayer", "()Lcom/alibaba/gaiax/template/GXLayer;", "rawConfigJson", "Lorg/json/JSONObject;", "getRawConfigJson", "()Lorg/json/JSONObject;", "setRawConfigJson", "(Lorg/json/JSONObject;)V", "rawCssJson", "getRawCssJson", "setRawCssJson", "rawDataBindingJson", "getRawDataBindingJson", "setRawDataBindingJson", "rawLayerJson", "getRawLayerJson", "setRawLayerJson", ThumbGlideUrl.SOURCE_TEMPLATE, "Lcom/alibaba/gaiax/template/GXTemplate;", "getTemplate", "()Lcom/alibaba/gaiax/template/GXTemplate;", "setTemplate", "(Lcom/alibaba/gaiax/template/GXTemplate;)V", "getTrack", "checkJS", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "findAnimation", "id", "findCss", "findData", "findEvent", "findLayer", "findTrack", "getChildTemplateInfo", "hashCode", "", "isTemplate", "toString", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXTemplateInfo {
    public static final Companion Companion = null;
    private final Map<String, GXAnimationBinding> animation;
    private List<GXTemplateInfo> children;
    private final Map<String, GXIExpression> config;
    private final Map<String, GXCss> css;
    private final Map<String, GXDataBinding> data;
    private final Map<String, GXEventBinding> event;
    private String expVersion;
    private final Lazy isJsExist$delegate;

    /* JADX INFO: renamed from: js, reason: collision with root package name */
    private final String f24982js;
    private final GXLayer layer;
    public JSONObject rawConfigJson;
    public JSONObject rawCssJson;
    public JSONObject rawDataBindingJson;
    public JSONObject rawLayerJson;
    public GXTemplate template;
    private final Map<String, GXTrackBinding> track;

    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0002J(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\tH\u0002J$\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0002J8\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\tH\u0002J(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\tH\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ(\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 \u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\tH\u0002J3\u0010!\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u00102!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\"0$H\u0002J\u0018\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010)\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010*\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0005¨\u0006,"}, d2 = {"Lcom/alibaba/gaiax/template/GXTemplateInfo$Companion;", "", "()V", "createAnimation", "", "", "Lcom/alibaba/gaiax/template/animation/GXAnimationBinding;", "expVersion", "animationJson", "Lorg/json/JSONObject;", "createConfig", "Lcom/alibaba/gaiax/template/GXIExpression;", "configJson", "createCss", "Lcom/alibaba/gaiax/template/GXCss;", GXTemplateKey.GAIAX_LAYER, "Lcom/alibaba/gaiax/template/GXLayer;", "srcCssJson", "value", "createData", "Lcom/alibaba/gaiax/template/GXDataBinding;", "dataJson", "createEvent", "Lcom/alibaba/gaiax/template/GXEventBinding;", "eventJson", "createTemplate", "Lcom/alibaba/gaiax/template/GXTemplateInfo;", ThumbGlideUrl.SOURCE_TEMPLATE, "Lcom/alibaba/gaiax/template/GXTemplate;", "templateItem", "Lcom/alibaba/gaiax/template/GXTemplateItem;", "createTrack", "Lcom/alibaba/gaiax/template/GXTrackBinding;", "forChildrenTemplate", "", "function", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "initChildren", "templateInfo", "parseCss", "parseDataBinding", "parseLayer", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final GXTemplateInfo createTemplate(GXTemplate r210) {
            JSONObject r100 = GXExtJsonKt.safeParseToJson(r210.getLayer());
            if (r100.length() <= 0) goto L29;
            JSONObject r101 = GXCssFileParserUtils.Companion.getInstance().parseToJson(r210.getCss());
            JSONObject r102 = GXExtJsonKt.safeParseToJson(r210.getDataBind());
            String r103 = r210.getJs();
            JSONObject r104 = r102.optJSONObject("data");
            if (r104 != null) goto L7;
            r104 = new JSONObject();
        L7:
            JSONObject r105 = r102.optJSONObject("event");
            if (r105 != null) goto L10;
            r105 = new JSONObject();
        L10:
            JSONObject r106 = r102.optJSONObject(GXTemplateKey.GAIAX_TRACK);
            if (r106 != null) goto L13;
            r106 = new JSONObject();
        L13:
            JSONObject r107 = r102.optJSONObject("config");
            if (r107 != null) goto L16;
            r107 = new JSONObject();
        L16:
            JSONObject r108 = r102.optJSONObject(GXTemplateKey.GAIAX_ANIMATION);
            if (r108 != null) goto L19;
            r108 = new JSONObject();
        L19:
            String r110 = r100.optString(GXTemplateKey.GAIAX_LAYER_EXP_VERSION, null);
            GXLayer r111 = GXLayer.Companion.create(r100);
            Map<String, GXCss> r112 = createCss(r111, r101);
            Map<String, GXDataBinding> r113 = createData(r110, r104);
            Map<String, GXEventBinding> r114 = createEvent(r110, r105);
            Map<String, GXTrackBinding> r115 = createTrack(r110, r106);
            Map<String, GXIExpression> r211 = createConfig(r110, r107);
            Map<String, GXAnimationBinding> r116 = createAnimation(r110, r108);
            if (r103.length() != 0) goto L22;
            boolean r109 = true;
        L23:
            if (r109 == false) goto L25;
            String r212 = null;
        L26:
            GXTemplateInfo r117 = new GXTemplateInfo(r111, r112, r113, r114, r115, r116, r211, r212);
            r117.setTemplate(r210);
            r117.setRawCssJson(r101);
            r117.setRawDataBindingJson(r102);
            r117.setRawLayerJson(r100);
            r117.setRawConfigJson(r107);
            r117.setExpVersion(r110);
            return r117;
        L25:
            r212 = r103;
            goto L26
        L22:
            r109 = false;
            goto L23
        L29:
            throw new IllegalArgumentException("Template layer mustn't empty");
        }

        public final JSONObject parseCss(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            return GXCssFileParserUtils.Companion.getInstance().parseToJson(r100);
        }

        public final JSONObject parseDataBinding(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            return GXExtJsonKt.safeParseToJson(r100);
        }

        public final JSONObject parseLayer(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            return GXExtJsonKt.safeParseToJson(r100);
        }

        public final GXTemplateInfo createTemplate(GXTemplateItem r100) {
            Intrinsics.checkNotNullParameter(r100, "templateItem");
            GXTemplateInfo r101 = createTemplate(GXTemplateEngine.Companion.getInstance().getData$GaiaX().getTemplateSource().getTemplate(r100));
            GXTemplateInfo.Companion.initChildren(r101, r100);
            return r101;
        }

        private final Map<String, GXAnimationBinding> createAnimation(String r100, JSONObject r101) {
            if (r101.length() <= 0) goto L20;
            LinkedHashMap r102 = new LinkedHashMap();
            Iterator<String> r103 = r101.keys();
        L6:
            if (r103.hasNext() == false) goto L35;
            String r104 = r103.next();
            Object r105 = r101.opt(r104);
            if (r104 == null) goto L6;
            if (r105 == null) goto L6;
            if (r104.length() <= 0) goto L13;
            boolean r106 = true;
        L14:
            if (r106 == false) goto L6;
            if ((r105 instanceof JSONObject) == false) goto L6;
            GXAnimationBinding r107 = GXAnimationBinding.Companion.create(r100, (JSONObject) r105);
            if (r107 == null) goto L6;
            r102.put(r104, r107);
            goto L6
        L13:
            r106 = false;
            goto L14
        L35:
            return r102;
        L20:
            return null;
        }

        private final Map<String, GXIExpression> createConfig(String r100, JSONObject r101) {
            if (r101.length() <= 0) goto L31;
            LinkedHashMap r102 = new LinkedHashMap();
            Iterator<String> r103 = r101.keys();
        L6:
            if (r103.hasNext() == false) goto L19;
            String r104 = r103.next();
            String r105 = r101.optString(r104, null);
            if (r104 == null) goto L6;
            if (r105 == null) goto L6;
            if (r104.length() <= 0) goto L13;
            boolean r106 = true;
        L14:
            if (r106 == false) goto L6;
            GXIExpression r107 = GXExpressionFactory.INSTANCE.create(r100, r105);
            if (r107 == null) goto L6;
            r102.put(r104, r107);
            goto L6
        L13:
            r106 = false;
            goto L14
        L19:
            return r102;
        L31:
            return null;
        }

        private final Map<String, GXCss> createCss(GXLayer r100, JSONObject r101) {
            return createCss(new LinkedHashMap(), r101, r100);
        }

        private final Map<String, GXDataBinding> createData(String r100, JSONObject r101) {
            if (r101.length() <= 0) goto L13;
            LinkedHashMap r102 = new LinkedHashMap();
            Iterator<String> r103 = r101.keys();
        L6:
            if (r103.hasNext() == false) goto L24;
            String r104 = r103.next();
            Object r105 = r101.opt(r104);
            if (r104 == null) goto L6;
            if (r105 == null) goto L6;
            GXDataBinding r106 = GXDataBindingFactory.INSTANCE.create(r100, r105);
            if (r106 == null) goto L6;
            r102.put(r104, r106);
            goto L6
        L24:
            return r102;
        L13:
            return null;
        }

        private final Map<String, GXEventBinding> createEvent(String r100, JSONObject r101) {
            if (r101.length() <= 0) goto L18;
            LinkedHashMap r102 = new LinkedHashMap();
            Iterator<String> r103 = r101.keys();
        L6:
            if (r103.hasNext() == false) goto L31;
            String r104 = r103.next();
            Object r105 = r101.opt(r104);
            if (r104 == null) goto L6;
            if (r105 == null) goto L6;
            if (r104.length() <= 0) goto L13;
            boolean r106 = true;
        L14:
            if (r106 == false) goto L6;
            GXIExpression r107 = GXExpressionFactory.INSTANCE.create(r100, r105);
            if (r107 == null) goto L6;
            r102.put(r104, new GXEventBinding(r107));
            goto L6
        L13:
            r106 = false;
            goto L14
        L31:
            return r102;
        L18:
            return null;
        }

        private final Map<String, GXTrackBinding> createTrack(String r100, JSONObject r101) {
            if (r101.length() <= 0) goto L18;
            LinkedHashMap r102 = new LinkedHashMap();
            Iterator<String> r103 = r101.keys();
        L6:
            if (r103.hasNext() == false) goto L31;
            String r104 = r103.next();
            Object r105 = r101.opt(r104);
            if (r104 == null) goto L6;
            if (r105 == null) goto L6;
            if (r104.length() <= 0) goto L13;
            boolean r106 = true;
        L14:
            if (r106 == false) goto L6;
            GXIExpression r107 = GXExpressionFactory.INSTANCE.create(r100, r105);
            if (r107 == null) goto L6;
            r102.put(r104, new GXTrackBinding(r107));
            goto L6
        L13:
            r106 = false;
            goto L14
        L31:
            return r102;
        L18:
            return null;
        }

        private final void forChildrenTemplate(GXLayer r100, Function1<? super GXLayer, Unit> r101) {
            Iterator<T> r102 = r100.getLayers().iterator();
        L4:
            if (r102.hasNext() == false) goto L9;
            GXLayer r103 = (GXLayer) r102.next();
            if (r103.isNestChildTemplateType() == false) goto L8;
            r101.invoke(r103);
        L8:
            GXTemplateInfo.Companion.forChildrenTemplate(r103, r101);
            goto L4
        }

        private final void initChildren(final GXTemplateInfo r100, final GXTemplateItem r101) {
            forChildrenTemplate(r100.getLayer(), new GXTemplateInfo$Companion$initChildren$1(r101, r100));
        }

        private final Map<String, GXCss> createCss(Map<String, GXCss> r100, JSONObject r101, GXLayer r110) {
            String r102 = r110.getId();
            JSONObject r103 = r101.optJSONObject(r110.getCss());
            if (r103 != null) goto L5;
            r103 = new JSONObject();
        L5:
            JSONObject r104 = r101.optJSONObject(r102);
            if (r104 != null) goto L9;
            r104 = new JSONObject();
        L9:
            if (r103.length() <= 0) goto L11;
        L12:
            JSONObject r105 = new JSONObject();
            Iterator<String> r106 = r103.keys();
        L14:
            if (r106.hasNext() == false) goto L16;
            String r107 = r106.next();
            r105.put(r107, r103.opt(r107));
            goto L14
        L16:
            Iterator<String> r108 = r104.keys();
        L18:
            if (r108.hasNext() == false) goto L20;
            String r109 = r108.next();
            r105.put(r109, r104.opt(r109));
            goto L18
        L20:
            r100.put(r102, GXCss.Companion.create(r105));
        L21:
            Iterator<T> r111 = r110.getLayers().iterator();
        L23:
            if (r111.hasNext() == false) goto L25;
            GXLayer r112 = (GXLayer) r111.next();
            GXTemplateInfo.Companion.createCss(r100, r101, r112);
            goto L23
        L25:
            return r100;
        L11:
            if (r104.length() <= 0) goto L21;
            goto L12
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GXTemplateInfo copy$default(GXTemplateInfo r100, GXLayer r110, Map r111, Map r112, Map r113, Map r114, Map r115, Map r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        GXLayer r101 = r100.layer;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Map r102 = r100.css;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Map r103 = r100.data;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Map r104 = r100.event;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Map r105 = r100.track;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Map r106 = r100.animation;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Map r107 = r100.config;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.f24982js;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final GXLayer component1() {
        return this.layer;
    }

    public final Map<String, GXCss> component2() {
        return this.css;
    }

    public final Map<String, GXDataBinding> component3() {
        return this.data;
    }

    public final Map<String, GXEventBinding> component4() {
        return this.event;
    }

    public final Map<String, GXTrackBinding> component5() {
        return this.track;
    }

    public final Map<String, GXAnimationBinding> component6() {
        return this.animation;
    }

    public final Map<String, GXIExpression> component7() {
        return this.config;
    }

    public final String component8() {
        return this.f24982js;
    }

    public final GXTemplateInfo copy(GXLayer r110, Map<String, GXCss> r111, Map<String, GXDataBinding> r112, Map<String, GXEventBinding> r113, Map<String, GXTrackBinding> r114, Map<String, GXAnimationBinding> r115, Map<String, GXIExpression> r116, String r117) {
        Intrinsics.checkNotNullParameter(r110, GXTemplateKey.GAIAX_LAYER);
        Intrinsics.checkNotNullParameter(r111, GXTemplateKey.GAIAX_CSS);
        return new GXTemplateInfo(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GXTemplateInfo) == true) goto L8;
        return false;
    L8:
        GXTemplateInfo r101 = (GXTemplateInfo) r100;
        if (Intrinsics.areEqual(this.layer, r101.layer) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.css, r101.css) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.event, r101.event) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.track, r101.track) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.animation, r101.animation) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f24982js, r101.f24982js) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.layer.hashCode() * 31) + this.css.hashCode()) * 31;
        Map<String, GXDataBinding> r101 = this.data;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Map<String, GXEventBinding> r105 = this.event;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Map<String, GXTrackBinding> r108 = this.track;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Map<String, GXAnimationBinding> r111 = this.animation;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Map<String, GXIExpression> r114 = this.config;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f24982js;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "GXTemplateInfo(layer=" + this.layer + ", css=" + this.css + ", data=" + this.data + ", event=" + this.event + ", track=" + this.track + ", animation=" + this.animation + ", config=" + this.config + ", js=" + this.f24982js + ')';
    }

    private final boolean checkJS() {
        String r100 = this.f24982js;
        if (r100 != null) goto L5;
        Boolean r101 = null;
    L11:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L13;
        return true;
    L13:
        List<GXTemplateInfo> r102 = this.children;
        if (r102 == null) goto L21;
        Iterator<T> r103 = r102.iterator();
    L17:
        if (r103.hasNext() == false) goto L21;
        if (((GXTemplateInfo) r103.next()).checkJS() == false) goto L17;
        return true;
    L21:
        return false;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        r101 = Boolean.valueOf(r104);
        goto L11
    L7:
        r104 = false;
        goto L8
    }

    public final JSONObject getRawConfigJson() {
        JSONObject r100 = this.rawConfigJson;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rawConfigJson");
        return null;
    }

    public final JSONObject getRawCssJson() {
        JSONObject r100 = this.rawCssJson;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rawCssJson");
        return null;
    }

    public final JSONObject getRawDataBindingJson() {
        JSONObject r100 = this.rawDataBindingJson;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rawDataBindingJson");
        return null;
    }

    public final JSONObject getRawLayerJson() {
        JSONObject r100 = this.rawLayerJson;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rawLayerJson");
        return null;
    }

    public final GXTemplate getTemplate() {
        GXTemplate r100 = this.template;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(ThumbGlideUrl.SOURCE_TEMPLATE);
        return null;
    }

    public final boolean isJsExist() {
        return ((Boolean) this.isJsExist$delegate.getValue()).booleanValue();
    }

    public final boolean isTemplate() {
        return Intrinsics.areEqual(this.layer.getType(), GXViewKey.VIEW_TYPE_GAIA_TEMPLATE);
    }

    public final Map<String, GXAnimationBinding> getAnimation() {
        return this.animation;
    }

    public final List<GXTemplateInfo> getChildren() {
        return this.children;
    }

    public final Map<String, GXIExpression> getConfig() {
        return this.config;
    }

    public final Map<String, GXCss> getCss() {
        return this.css;
    }

    public final Map<String, GXDataBinding> getData() {
        return this.data;
    }

    public final Map<String, GXEventBinding> getEvent() {
        return this.event;
    }

    public final String getExpVersion() {
        return this.expVersion;
    }

    public final String getJs() {
        return this.f24982js;
    }

    public final GXLayer getLayer() {
        return this.layer;
    }

    public final Map<String, GXTrackBinding> getTrack() {
        return this.track;
    }

    public static final /* synthetic */ boolean access$checkJS(GXTemplateInfo r100) {
        return r100.checkJS();
    }

    public final GXAnimationBinding findAnimation(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Map<String, GXAnimationBinding> r101 = this.animation;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public final GXCss findCss(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        return this.css.get(r100);
    }

    public final GXDataBinding findData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Map<String, GXDataBinding> r101 = this.data;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public final GXEventBinding findEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Map<String, GXEventBinding> r101 = this.event;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public final GXLayer findLayer(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        return findLayer(r100, this.layer);
    }

    public final GXTrackBinding findTrack(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Map<String, GXTrackBinding> r101 = this.track;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public final GXTemplateInfo getChildTemplateInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        List<GXTemplateInfo> r101 = this.children;
        if (r101 == null) goto L10;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L15;
        GXTemplateInfo r103 = (GXTemplateInfo) r102.next();
        if (Intrinsics.areEqual(r103.layer.getId(), r100) == false) goto L6;
        return r103;
    L15:
        return null;
    L10:
        return null;
    }

    public final JSONObject getConfig(JSONObject r100) {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L5;
        r100 = new JSONObject();
    L5:
        Map<String, GXIExpression> r102 = this.config;
        if (r102 == null) goto L14;
        Iterator<Map.Entry<String, GXIExpression>> r103 = r102.entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        Map.Entry<String, GXIExpression> r104 = r103.next();
        String r105 = r104.getKey();
        Object r106 = r104.getValue().value(r100);
        if (r106 != null) goto L13;
        r106 = "";
    L13:
        r101.put(r105, r106);
    L14:
        return r101;
    }

    public final void setChildren(List<GXTemplateInfo> r100) {
        this.children = r100;
    }

    public final void setExpVersion(String r100) {
        this.expVersion = r100;
    }

    public final void setRawConfigJson(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rawConfigJson = r100;
    }

    public final void setRawCssJson(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rawCssJson = r100;
    }

    public final void setRawDataBindingJson(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rawDataBindingJson = r100;
    }

    public final void setRawLayerJson(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rawLayerJson = r100;
    }

    public final void setTemplate(GXTemplate r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.template = r100;
    }

    private final GXLayer findLayer(String r100, GXLayer r101) {
        if (Intrinsics.areEqual(r100, r101.getId()) == false) goto L5;
        return r101;
    L5:
        Iterator<T> r102 = r101.getLayers().iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        GXLayer r103 = findLayer(r100, (GXLayer) r102.next());
        if (r103 == null) goto L7;
        return r103;
    L11:
        return null;
    }

    public GXTemplateInfo(GXLayer r100, Map<String, GXCss> r101, Map<String, GXDataBinding> r102, Map<String, GXEventBinding> r103, Map<String, GXTrackBinding> r104, Map<String, GXAnimationBinding> r105, Map<String, GXIExpression> r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.GAIAX_CSS);
        this.layer = r100;
        this.css = r101;
        this.data = r102;
        this.event = r103;
        this.track = r104;
        this.animation = r105;
        this.config = r106;
        this.f24982js = r107;
        this.isJsExist$delegate = LazyKt.lazy(new AnonymousClass2(this));
    }

    public /* synthetic */ GXTemplateInfo(GXLayer r100, Map r110, Map r111, Map r112, Map r113, Map r114, Map r115, String r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 2) == 0) goto L5;
        Map r101 = new LinkedHashMap();
    L6:
        String r102 = null;
        if ((r117 & 4) == 0) goto L9;
        Map r103 = null;
    L11:
        if ((r117 & 8) == 0) goto L13;
        Map r104 = null;
    L15:
        if ((r117 & 16) == 0) goto L17;
        Map r105 = null;
    L19:
        if ((r117 & 32) == 0) goto L21;
        Map r106 = null;
    L23:
        if ((r117 & 64) == 0) goto L25;
        Map r107 = null;
    L27:
        if ((r117 & 128) != 0) goto L30;
        r102 = r116;
    L30:
        this(r100, r101, r103, r104, r105, r106, r107, r102);
        return;
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}

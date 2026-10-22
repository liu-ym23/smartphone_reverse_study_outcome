package com.alibaba.gaiax.template.utils;

import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0004J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0012\u0010\b\u001a\u00060\tj\u0002`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00060\tj\u0002`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00060\tj\u0002`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/alibaba/gaiax/template/utils/GXCssFileParserUtils;", "", "()V", "lastSelectorName", "", "previousChar", "", "Ljava/lang/Character;", "propertyName", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "selectorName", "state", "", "valueName", "values", "", "parse", "", "rules", "Lorg/json/JSONObject;", "c", "parsePropertyName", "parseSelector", "parseToJson", GXTemplateKey.GAIAX_CSS, "parseValue", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXCssFileParserUtils {
    public static final Companion Companion = null;
    private static final int INSIDE_PROPERTY_NAME = 1;
    private static final int INSIDE_SELECTOR = 0;
    private static final int INSIDE_VALUE = 2;
    private static final GXCssFileParserUtils instance = null;
    private String lastSelectorName;
    private Character previousChar;
    private StringBuilder propertyName;
    private StringBuilder selectorName;
    private int state;
    private StringBuilder valueName;
    private final Map<String, Object> values;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/alibaba/gaiax/template/utils/GXCssFileParserUtils$Companion;", "", "()V", "INSIDE_PROPERTY_NAME", "", "INSIDE_SELECTOR", "INSIDE_VALUE", "instance", "Lcom/alibaba/gaiax/template/utils/GXCssFileParserUtils;", "getInstance", "()Lcom/alibaba/gaiax/template/utils/GXCssFileParserUtils;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final GXCssFileParserUtils getInstance() {
            return GXCssFileParserUtils.access$getInstance$cp();
        }
    }

    static {
        Companion = new Companion(null);
        instance = new GXCssFileParserUtils();
    }

    public GXCssFileParserUtils() {
        this.selectorName = new StringBuilder();
        this.lastSelectorName = "";
        this.propertyName = new StringBuilder();
        this.valueName = new StringBuilder();
        this.values = new LinkedHashMap();
    }

    public static final /* synthetic */ GXCssFileParserUtils access$getInstance$cp() {
        return instance;
    }

    private final void parseSelector(char r100) {
        if ('{' != r100) goto L6;
        this.state = 1;
        this.lastSelectorName = StringsKt.trim(this.selectorName.toString()).toString().substring(1);
        StringsKt.clear(this.selectorName);
        return;
    L6:
        this.selectorName.append(r100);
    }

    private final void parseValue(char r100) {
        if (';' != r100) goto L6;
        this.values.put(StringsKt.trim(this.propertyName.toString()).toString(), StringsKt.trim(this.valueName.toString()).toString());
        StringsKt.clear(this.propertyName);
        StringsKt.clear(this.valueName);
        this.state = 1;
        return;
    L6:
        this.valueName.append(r100);
    }

    public final JSONObject parseToJson(String r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        JSONObject r101 = new JSONObject();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        parse(r101, r100.charAt(r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    private final void parse(JSONObject r100, char r101) {
        int r102 = this.state;
        if (r102 != 0) goto L5;
        parseSelector(r101);
    L12:
        this.previousChar = Character.valueOf(r101);
        return;
    L5:
        if (r102 != 1) goto L7;
        parsePropertyName(r100, r101);
        goto L12
    L7:
        if (r102 != 2) goto L12;
        parseValue(r101);
        goto L12
    }

    private final void parsePropertyName(JSONObject r100, char r101) {
        if (r101 != ':') goto L6;
        this.state = 2;
        return;
    L6:
        if (r101 != '}') goto L8;
        JSONObject r102 = new JSONObject(this.values);
        r100.put(this.lastSelectorName, r102);
        this.values.clear();
        this.state = 0;
        return;
    L8:
        this.propertyName.append(r101);
    }
}

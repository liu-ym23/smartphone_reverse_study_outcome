package com.uxsense.core.pattern.builder;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.mdisdk.capability.model.RequestInfo;
import com.uxsense.core.dsl.ViewPatternDsl;
import com.uxsense.core.pattern.NodeCondition;
import java.util.List;
import kotlin.Metadata;

@ViewPatternDsl
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010s\u001a\u00020tH\u0000¢\u0006\u0002\buR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001e\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010,\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010\tR\u001c\u0010/\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0007\"\u0004\b1\u0010\tR\u001e\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u00109\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b:\u00105\"\u0004\b;\u00107R\u001e\u0010<\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b=\u00105\"\u0004\b>\u00107R\u001e\u0010?\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b@\u00105\"\u0004\bA\u00107R\u001e\u0010B\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u0010\n\u0002\u0010H\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001e\u0010I\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u0010\n\u0002\u0010H\u001a\u0004\bJ\u0010E\"\u0004\bK\u0010GR\u001e\u0010L\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\bM\u0010(\"\u0004\bN\u0010*R\u001e\u0010O\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\bP\u0010(\"\u0004\bQ\u0010*R\u001e\u0010R\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\bS\u0010(\"\u0004\bT\u0010*R\u001e\u0010U\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\bV\u0010(\"\u0004\bW\u0010*R\u001e\u0010X\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\bY\u0010(\"\u0004\bZ\u0010*R\u001e\u0010[\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b\\\u0010(\"\u0004\b]\u0010*R\u001e\u0010^\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b_\u0010(\"\u0004\b`\u0010*R\u001e\u0010a\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\bb\u00105\"\u0004\bc\u00107R\u001e\u0010d\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\be\u00105\"\u0004\bf\u00107R\u001e\u0010g\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\bh\u0010(\"\u0004\bi\u0010*R\u001e\u0010j\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\bk\u00105\"\u0004\bl\u00107R\u001e\u0010m\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\bn\u00105\"\u0004\bo\u00107R\u001c\u0010p\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0007\"\u0004\br\u0010\t¨\u0006v"}, d2 = {"Lcom/uxsense/core/pattern/builder/ConditionBuilder;", "", AppAgent.CONSTRUCT, "()V", "className", "", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "classNameContains", "getClassNameContains", "setClassNameContains", "classNameRegex", "getClassNameRegex", "setClassNameRegex", "classNameIn", "", "getClassNameIn", "()Ljava/util/List;", "setClassNameIn", "(Ljava/util/List;)V", "viewId", "getViewId", "setViewId", "viewIdRegex", "getViewIdRegex", "setViewIdRegex", "text", "getText", RequestInfo.FUNCTION_SET_TEXT, "textContains", "getTextContains", "setTextContains", "textRegex", "getTextRegex", "setTextRegex", "textNotEmpty", "", "getTextNotEmpty", "()Ljava/lang/Boolean;", "setTextNotEmpty", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "description", "getDescription", "setDescription", "descriptionContains", "getDescriptionContains", "setDescriptionContains", "minWidth", "", "getMinWidth", "()Ljava/lang/Integer;", "setMinWidth", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "maxWidth", "getMaxWidth", "setMaxWidth", "minHeight", "getMinHeight", "setMinHeight", "maxHeight", "getMaxHeight", "setMaxHeight", "widthHeightRatioMin", "", "getWidthHeightRatioMin", "()Ljava/lang/Float;", "setWidthHeightRatioMin", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "widthHeightRatioMax", "getWidthHeightRatioMax", "setWidthHeightRatioMax", "touchable", "getTouchable", "setTouchable", "clickable", "getClickable", "setClickable", "longClickable", "getLongClickable", "setLongClickable", "checkable", "getCheckable", "setCheckable", "checked", "getChecked", "setChecked", "horizontalScrollable", "getHorizontalScrollable", "setHorizontalScrollable", "verticalScrollable", "getVerticalScrollable", "setVerticalScrollable", "minChildCount", "getMinChildCount", "setMinChildCount", "maxChildCount", "getMaxChildCount", "setMaxChildCount", "hasChildren", "getHasChildren", "setHasChildren", "minProgress", "getMinProgress", "setMinProgress", "maxProgress", "getMaxProgress", "setMaxProgress", "customPredicate", "getCustomPredicate", "setCustomPredicate", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/uxsense/core/pattern/NodeCondition;", "build$uxsense_release", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConditionBuilder {
    private Boolean checkable;
    private Boolean checked;
    private String className;
    private String classNameContains;
    private List<String> classNameIn;
    private String classNameRegex;
    private Boolean clickable;
    private String customPredicate;
    private String description;
    private String descriptionContains;
    private Boolean hasChildren;
    private Boolean horizontalScrollable;
    private Boolean longClickable;
    private Integer maxChildCount;
    private Integer maxHeight;
    private Integer maxProgress;
    private Integer maxWidth;
    private Integer minChildCount;
    private Integer minHeight;
    private Integer minProgress;
    private Integer minWidth;
    private String text;
    private String textContains;
    private Boolean textNotEmpty;
    private String textRegex;
    private Boolean touchable;
    private Boolean verticalScrollable;
    private String viewId;
    private String viewIdRegex;
    private Float widthHeightRatioMax;
    private Float widthHeightRatioMin;

    public final NodeCondition build$uxsense_release() {
        return new NodeCondition(this.className, this.classNameContains, this.classNameRegex, this.classNameIn, this.viewId, this.viewIdRegex, this.text, this.textContains, this.textRegex, this.textNotEmpty, this.description, this.descriptionContains, this.minWidth, this.maxWidth, this.minHeight, this.maxHeight, this.widthHeightRatioMin, this.widthHeightRatioMax, this.touchable, this.clickable, this.longClickable, this.checkable, this.checked, this.horizontalScrollable, this.verticalScrollable, this.minChildCount, this.maxChildCount, this.hasChildren, this.minProgress, this.maxProgress, this.customPredicate);
    }

    public final Boolean getCheckable() {
        return this.checkable;
    }

    public final Boolean getChecked() {
        return this.checked;
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getClassNameContains() {
        return this.classNameContains;
    }

    public final List<String> getClassNameIn() {
        return this.classNameIn;
    }

    public final String getClassNameRegex() {
        return this.classNameRegex;
    }

    public final Boolean getClickable() {
        return this.clickable;
    }

    public final String getCustomPredicate() {
        return this.customPredicate;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDescriptionContains() {
        return this.descriptionContains;
    }

    public final Boolean getHasChildren() {
        return this.hasChildren;
    }

    public final Boolean getHorizontalScrollable() {
        return this.horizontalScrollable;
    }

    public final Boolean getLongClickable() {
        return this.longClickable;
    }

    public final Integer getMaxChildCount() {
        return this.maxChildCount;
    }

    public final Integer getMaxHeight() {
        return this.maxHeight;
    }

    public final Integer getMaxProgress() {
        return this.maxProgress;
    }

    public final Integer getMaxWidth() {
        return this.maxWidth;
    }

    public final Integer getMinChildCount() {
        return this.minChildCount;
    }

    public final Integer getMinHeight() {
        return this.minHeight;
    }

    public final Integer getMinProgress() {
        return this.minProgress;
    }

    public final Integer getMinWidth() {
        return this.minWidth;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextContains() {
        return this.textContains;
    }

    public final Boolean getTextNotEmpty() {
        return this.textNotEmpty;
    }

    public final String getTextRegex() {
        return this.textRegex;
    }

    public final Boolean getTouchable() {
        return this.touchable;
    }

    public final Boolean getVerticalScrollable() {
        return this.verticalScrollable;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final String getViewIdRegex() {
        return this.viewIdRegex;
    }

    public final Float getWidthHeightRatioMax() {
        return this.widthHeightRatioMax;
    }

    public final Float getWidthHeightRatioMin() {
        return this.widthHeightRatioMin;
    }

    public final void setCheckable(Boolean bool) {
        this.checkable = bool;
    }

    public final void setChecked(Boolean bool) {
        this.checked = bool;
    }

    public final void setClassName(String str) {
        this.className = str;
    }

    public final void setClassNameContains(String str) {
        this.classNameContains = str;
    }

    public final void setClassNameIn(List<String> list) {
        this.classNameIn = list;
    }

    public final void setClassNameRegex(String str) {
        this.classNameRegex = str;
    }

    public final void setClickable(Boolean bool) {
        this.clickable = bool;
    }

    public final void setCustomPredicate(String str) {
        this.customPredicate = str;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setDescriptionContains(String str) {
        this.descriptionContains = str;
    }

    public final void setHasChildren(Boolean bool) {
        this.hasChildren = bool;
    }

    public final void setHorizontalScrollable(Boolean bool) {
        this.horizontalScrollable = bool;
    }

    public final void setLongClickable(Boolean bool) {
        this.longClickable = bool;
    }

    public final void setMaxChildCount(Integer num) {
        this.maxChildCount = num;
    }

    public final void setMaxHeight(Integer num) {
        this.maxHeight = num;
    }

    public final void setMaxProgress(Integer num) {
        this.maxProgress = num;
    }

    public final void setMaxWidth(Integer num) {
        this.maxWidth = num;
    }

    public final void setMinChildCount(Integer num) {
        this.minChildCount = num;
    }

    public final void setMinHeight(Integer num) {
        this.minHeight = num;
    }

    public final void setMinProgress(Integer num) {
        this.minProgress = num;
    }

    public final void setMinWidth(Integer num) {
        this.minWidth = num;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final void setTextContains(String str) {
        this.textContains = str;
    }

    public final void setTextNotEmpty(Boolean bool) {
        this.textNotEmpty = bool;
    }

    public final void setTextRegex(String str) {
        this.textRegex = str;
    }

    public final void setTouchable(Boolean bool) {
        this.touchable = bool;
    }

    public final void setVerticalScrollable(Boolean bool) {
        this.verticalScrollable = bool;
    }

    public final void setViewId(String str) {
        this.viewId = str;
    }

    public final void setViewIdRegex(String str) {
        this.viewIdRegex = str;
    }

    public final void setWidthHeightRatioMax(Float f) {
        this.widthHeightRatioMax = f;
    }

    public final void setWidthHeightRatioMin(Float f) {
        this.widthHeightRatioMin = f;
    }
}

package com.uxsense.core.pattern.builder;

import D7.q;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.mdisdk.capability.model.RequestInfo;
import com.uxsense.core.dsl.ViewPatternDsl;
import com.uxsense.core.model.ViewTrigger;
import com.uxsense.core.pattern.NodeCondition;
import com.uxsense.core.pattern.ValueSource;
import com.uxsense.core.pattern.ViewPattern;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@ViewPatternDsl
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b?\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\t2\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u000e\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\u000e\u0010\u0010J!\u0010\u0012\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\u0012\u0010\u0010J!\u0010\u0014\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\u0014\u0010\u0010J!\u0010\u0016\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\u0016\u0010\u0010J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u0005R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u0005R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001c\"\u0004\b#\u0010\u0005R$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u0005R*\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u0005R$\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u001a\u001a\u0004\b2\u0010\u001c\"\u0004\b3\u0010\u0005R$\u00104\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u001a\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u0010\u0005R$\u00107\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010\u001a\u001a\u0004\b8\u0010\u001c\"\u0004\b9\u0010\u0005R$\u0010:\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010\u001a\u001a\u0004\b;\u0010\u001c\"\u0004\b<\u0010\u0005R$\u0010>\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010D\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010\u001a\u001a\u0004\bE\u0010\u001c\"\u0004\bF\u0010\u0005R$\u0010G\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010\u001a\u001a\u0004\bH\u0010\u001c\"\u0004\bI\u0010\u0005R$\u0010K\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010Q\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010L\u001a\u0004\bR\u0010N\"\u0004\bS\u0010PR$\u0010T\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010L\u001a\u0004\bU\u0010N\"\u0004\bV\u0010PR$\u0010W\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010L\u001a\u0004\bX\u0010N\"\u0004\bY\u0010PR$\u0010[\u001a\u0004\u0018\u00010Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010a\u001a\u0004\u0018\u00010Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010\\\u001a\u0004\bb\u0010^\"\u0004\bc\u0010`R$\u0010d\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010?\u001a\u0004\be\u0010A\"\u0004\bf\u0010CR$\u0010g\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010?\u001a\u0004\bh\u0010A\"\u0004\bi\u0010CR$\u0010j\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010?\u001a\u0004\bk\u0010A\"\u0004\bl\u0010CR$\u0010m\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010?\u001a\u0004\bn\u0010A\"\u0004\bo\u0010CR$\u0010p\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010?\u001a\u0004\bq\u0010A\"\u0004\br\u0010CR$\u0010s\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010?\u001a\u0004\bt\u0010A\"\u0004\bu\u0010CR$\u0010v\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010?\u001a\u0004\bw\u0010A\"\u0004\bx\u0010CR$\u0010y\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\by\u0010L\u001a\u0004\bz\u0010N\"\u0004\b{\u0010PR$\u0010|\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b|\u0010L\u001a\u0004\b}\u0010N\"\u0004\b~\u0010PR&\u0010\u007f\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010?\u001a\u0005\b\u0080\u0001\u0010A\"\u0005\b\u0081\u0001\u0010CR(\u0010\u0082\u0001\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010L\u001a\u0005\b\u0083\u0001\u0010N\"\u0005\b\u0084\u0001\u0010PR(\u0010\u0085\u0001\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0085\u0001\u0010L\u001a\u0005\b\u0086\u0001\u0010N\"\u0005\b\u0087\u0001\u0010PR(\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0088\u0001\u0010\u001a\u001a\u0005\b\u0089\u0001\u0010\u001c\"\u0005\b\u008a\u0001\u0010\u0005R)\u0010\u008b\u0001\u001a\u00020=8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R)\u0010\u0091\u0001\u001a\u00020=8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u008c\u0001\u001a\u0006\b\u0092\u0001\u0010\u008e\u0001\"\u0006\b\u0093\u0001\u0010\u0090\u0001R)\u0010\u0094\u0001\u001a\u00020J8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R*\u0010\u009b\u0001\u001a\u00030\u009a\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001R,\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070'8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¡\u0001\u0010)\u001a\u0005\b¢\u0001\u0010+\"\u0005\b£\u0001\u0010-R\u001e\u0010¦\u0001\u001a\n\u0012\u0005\u0012\u00030¥\u00010¤\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b¦\u0001\u0010)¨\u0006§\u0001"}, d2 = {"Lcom/uxsense/core/pattern/builder/NodePatternBuilder;", "", "", HintConstants.AUTOFILL_HINT_NAME, AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "", "Lcom/uxsense/core/model/ViewTrigger;", "trigger", "LC7/r;", "onTrigger", "([Lcom/uxsense/core/model/ViewTrigger;)V", "Lkotlin/Function1;", "block", "node", "(Ljava/lang/String;LS7/k;)V", "(LS7/k;)V", "Lcom/uxsense/core/pattern/builder/AnyOfBuilder;", "anyOf", "Lcom/uxsense/core/pattern/builder/NoneOfBuilder;", "noneOf", "Lcom/uxsense/core/pattern/builder/BranchesBuilder;", "branches", "Lcom/uxsense/core/pattern/ViewPattern$NodePattern;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lcom/uxsense/core/pattern/ViewPattern$NodePattern;", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "className", "getClassName", "setClassName", "classNameContains", "getClassNameContains", "setClassNameContains", "classNameRegex", "getClassNameRegex", "setClassNameRegex", "", "classNameIn", "Ljava/util/List;", "getClassNameIn", "()Ljava/util/List;", "setClassNameIn", "(Ljava/util/List;)V", "viewId", "getViewId", "setViewId", "viewIdRegex", "getViewIdRegex", "setViewIdRegex", "text", "getText", RequestInfo.FUNCTION_SET_TEXT, "textContains", "getTextContains", "setTextContains", "textRegex", "getTextRegex", "setTextRegex", "", "textNotEmpty", "Ljava/lang/Boolean;", "getTextNotEmpty", "()Ljava/lang/Boolean;", "setTextNotEmpty", "(Ljava/lang/Boolean;)V", "description", "getDescription", "setDescription", "descriptionContains", "getDescriptionContains", "setDescriptionContains", "", "minWidth", "Ljava/lang/Integer;", "getMinWidth", "()Ljava/lang/Integer;", "setMinWidth", "(Ljava/lang/Integer;)V", "maxWidth", "getMaxWidth", "setMaxWidth", "minHeight", "getMinHeight", "setMinHeight", "maxHeight", "getMaxHeight", "setMaxHeight", "", "widthHeightRatioMin", "Ljava/lang/Float;", "getWidthHeightRatioMin", "()Ljava/lang/Float;", "setWidthHeightRatioMin", "(Ljava/lang/Float;)V", "widthHeightRatioMax", "getWidthHeightRatioMax", "setWidthHeightRatioMax", "touchable", "getTouchable", "setTouchable", "clickable", "getClickable", "setClickable", "longClickable", "getLongClickable", "setLongClickable", "checkable", "getCheckable", "setCheckable", "checked", "getChecked", "setChecked", "horizontalScrollable", "getHorizontalScrollable", "setHorizontalScrollable", "verticalScrollable", "getVerticalScrollable", "setVerticalScrollable", "minChildCount", "getMinChildCount", "setMinChildCount", "maxChildCount", "getMaxChildCount", "setMaxChildCount", "hasChildren", "getHasChildren", "setHasChildren", "minProgress", "getMinProgress", "setMinProgress", "maxProgress", "getMaxProgress", "setMaxProgress", "customPredicate", "getCustomPredicate", "setCustomPredicate", "optional", "Z", "getOptional", "()Z", "setOptional", "(Z)V", "captureChildren", "getCaptureChildren", "setCaptureChildren", "depth", "I", "getDepth", "()I", "setDepth", "(I)V", "Lcom/uxsense/core/pattern/ValueSource;", "valueSource", "Lcom/uxsense/core/pattern/ValueSource;", "getValueSource", "()Lcom/uxsense/core/pattern/ValueSource;", "setValueSource", "(Lcom/uxsense/core/pattern/ValueSource;)V", "triggers", "getTriggers", "setTriggers", "", "Lcom/uxsense/core/pattern/ViewPattern;", "children", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NodePatternBuilder {
    private boolean captureChildren;
    private Boolean checkable;
    private Boolean checked;
    private final List<ViewPattern> children;
    private String className;
    private String classNameContains;
    private List<String> classNameIn;
    private String classNameRegex;
    private Boolean clickable;
    private String customPredicate;
    private int depth;
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
    private String name;
    private boolean optional;
    private String text;
    private String textContains;
    private Boolean textNotEmpty;
    private String textRegex;
    private Boolean touchable;
    private List<? extends ViewTrigger> triggers;
    private ValueSource valueSource;
    private Boolean verticalScrollable;
    private String viewId;
    private String viewIdRegex;
    private Float widthHeightRatioMax;
    private Float widthHeightRatioMin;

    public NodePatternBuilder(String name) {
        k.f(name, "name");
        this.name = name;
        this.depth = 1;
        this.valueSource = ValueSource.TEXT_OR_DESC;
        this.triggers = EmptyList.f4893a;
        this.children = new ArrayList();
    }

    public final void anyOf(S7.k block) {
        k.f(block, "block");
        AnyOfBuilder anyOfBuilder = new AnyOfBuilder();
        block.invoke(anyOfBuilder);
        List<ViewPattern> listBuild$uxsense_release = anyOfBuilder.build$uxsense_release();
        if (listBuild$uxsense_release.isEmpty()) {
            return;
        }
        this.children.add(new ViewPattern.AnyOf(listBuild$uxsense_release));
    }

    public final void branches(S7.k block) {
        k.f(block, "block");
        BranchesBuilder branchesBuilder = new BranchesBuilder();
        block.invoke(branchesBuilder);
        List<ViewPattern.Branches.Branch> listBuild$uxsense_release = branchesBuilder.build$uxsense_release();
        if (listBuild$uxsense_release.isEmpty()) {
            return;
        }
        this.children.add(new ViewPattern.Branches((List) listBuild$uxsense_release, false, 2, (e) null));
    }

    public final ViewPattern.NodePattern build() {
        return new ViewPattern.NodePattern(this.name, new NodeCondition(this.className, this.classNameContains, this.classNameRegex, this.classNameIn, this.viewId, this.viewIdRegex, this.text, this.textContains, this.textRegex, this.textNotEmpty, this.description, this.descriptionContains, this.minWidth, this.maxWidth, this.minHeight, this.maxHeight, this.widthHeightRatioMin, this.widthHeightRatioMax, this.touchable, this.clickable, this.longClickable, this.checkable, this.checked, this.horizontalScrollable, this.verticalScrollable, this.minChildCount, this.maxChildCount, this.hasChildren, this.minProgress, this.maxProgress, this.customPredicate), this.children, this.optional, this.captureChildren, this.depth, this.valueSource, this.triggers);
    }

    public final boolean getCaptureChildren() {
        return this.captureChildren;
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

    public final int getDepth() {
        return this.depth;
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

    public final String getName() {
        return this.name;
    }

    public final boolean getOptional() {
        return this.optional;
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

    public final List<ViewTrigger> getTriggers() {
        return this.triggers;
    }

    public final ValueSource getValueSource() {
        return this.valueSource;
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

    public final void node(String name, S7.k block) {
        k.f(name, "name");
        k.f(block, "block");
        List<ViewPattern> list = this.children;
        NodePatternBuilder nodePatternBuilder = new NodePatternBuilder(name);
        block.invoke(nodePatternBuilder);
        list.add(nodePatternBuilder.build());
    }

    public final void noneOf(S7.k block) {
        k.f(block, "block");
        NoneOfBuilder noneOfBuilder = new NoneOfBuilder();
        block.invoke(noneOfBuilder);
        List<ViewPattern> listBuild$uxsense_release = noneOfBuilder.build$uxsense_release();
        if (listBuild$uxsense_release.isEmpty()) {
            return;
        }
        this.children.add(new ViewPattern.NoneOf(listBuild$uxsense_release));
    }

    public final void onTrigger(ViewTrigger... trigger) {
        k.f(trigger, "trigger");
        this.triggers = q.I0(trigger);
    }

    public final void setCaptureChildren(boolean z10) {
        this.captureChildren = z10;
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

    public final void setDepth(int i) {
        this.depth = i;
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

    public final void setName(String str) {
        k.f(str, "<set-?>");
        this.name = str;
    }

    public final void setOptional(boolean z10) {
        this.optional = z10;
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

    public final void setTriggers(List<? extends ViewTrigger> list) {
        k.f(list, "<set-?>");
        this.triggers = list;
    }

    public final void setValueSource(ValueSource valueSource) {
        k.f(valueSource, "<set-?>");
        this.valueSource = valueSource;
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

    public final void node(S7.k block) {
        k.f(block, "block");
        List<ViewPattern> list = this.children;
        NodePatternBuilder nodePatternBuilder = new NodePatternBuilder(NodePatternBuilderKt.generateNodeName());
        block.invoke(nodePatternBuilder);
        list.add(nodePatternBuilder.build());
    }
}

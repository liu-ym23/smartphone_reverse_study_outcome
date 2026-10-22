package com.chad.library.adapter.base;

import androidx.annotation.IntRange;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedanceos.common.toolbox.ServerElements;
import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.entity.node.NodeFooterImp;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0014\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J2\u0010\u0017\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J<\u0010\u0017\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J2\u0010\u001e\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J2\u0010\u001f\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J<\u0010\u001f\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\u00192\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J2\u0010!\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007JR\u0010\"\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001cH\u0007J2\u0010'\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u000e\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0002J\u0010\u0010(\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\bJ-\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\bH\u0014J\u0016\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002J\u001e\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002J$\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fJ\u0016\u00103\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u0002J\u0016\u00103\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\bJ\u001c\u00105\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fJ\u001e\u00106\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002J\u0010\u00107\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u00108\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u00109\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0018\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u001e\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020>2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016J\u0018\u0010<\u001a\u00020\u000b2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016J\u0018\u0010?\u001a\u00020\u000b2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fH\u0016J\u0018\u0010@\u001a\u00020\u000b2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/chad/library/adapter/base/BaseNodeAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "nodeList", "", "(Ljava/util/List;)V", "fullSpanNodeTypeSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "addData", "", "data", "position", "newData", "", "addFooterNodeProvider", "provider", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "addFullSpanNodeProvider", "addItemProvider", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "addNodeProvider", "collapse", "animate", "", "notify", "parentPayload", "", "isChangeChildCollapse", "collapseAndChild", "expand", "isChangeChildExpand", "expandAndChild", "expandAndCollapseOther", "isExpandedChild", "isCollapseChild", "expandPayload", "collapsePayload", "expandOrCollapse", "findParentNode", "node", "flatData", ServerElements.LIST, "isExpanded", "(Ljava/util/Collection;Ljava/lang/Boolean;)Ljava/util/List;", "isFixedViewType", "type", "nodeAddData", "parentNode", "childIndex", "nodeRemoveData", "childNode", "nodeReplaceChildData", "nodeSetData", "removeAt", "removeChildAt", "removeNodesAt", "setData", SlideCard.KEY_INDEX, "setDiffNewData", "diffResult", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "setList", "setNewInstance", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
public abstract class BaseNodeAdapter extends BaseProviderMultiAdapter<BaseNode> {
    private final HashSet<Integer> fullSpanNodeTypeSet;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseNodeAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ int collapse$default(BaseNodeAdapter r10, int r11, boolean r12, boolean r13, boolean r14, Object r15, int r16, Object r17) {
        if (r17 != null) goto L20;
        if ((r16 & 2) == 0) goto L6;
        r12 = false;
    L6:
        boolean r18 = r12;
        if ((r16 & 4) == 0) goto L9;
        boolean r19 = true;
    L11:
        if ((r16 & 8) == 0) goto L13;
        boolean r20 = true;
    L15:
        if ((r16 & 16) == 0) goto L18;
        r15 = null;
    L18:
        return r10.collapse(r11, r18, r19, r20, r15);
    L13:
        r20 = r14;
        goto L15
    L9:
        r19 = r13;
        goto L11
    L20:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapse");
    }

    public static /* synthetic */ int collapseAndChild$default(BaseNodeAdapter r10, int r11, boolean r12, boolean r13, Object r14, int r15, Object r16) {
        if (r16 != null) goto L15;
        if ((r15 & 2) == 0) goto L7;
        r12 = true;
    L7:
        if ((r15 & 4) == 0) goto L10;
        r13 = true;
    L10:
        if ((r15 & 8) == 0) goto L13;
        r14 = null;
    L13:
        return r10.collapseAndChild(r11, r12, r13, r14);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapseAndChild");
    }

    public static /* synthetic */ int expand$default(BaseNodeAdapter r10, int r11, boolean r12, boolean r13, boolean r14, Object r15, int r16, Object r17) {
        if (r17 != null) goto L20;
        if ((r16 & 2) == 0) goto L6;
        r12 = false;
    L6:
        boolean r18 = r12;
        if ((r16 & 4) == 0) goto L9;
        boolean r19 = true;
    L11:
        if ((r16 & 8) == 0) goto L13;
        boolean r20 = true;
    L15:
        if ((r16 & 16) == 0) goto L18;
        r15 = null;
    L18:
        return r10.expand(r11, r18, r19, r20, r15);
    L13:
        r20 = r14;
        goto L15
    L9:
        r19 = r13;
        goto L11
    L20:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expand");
    }

    public static /* synthetic */ int expandAndChild$default(BaseNodeAdapter r10, int r11, boolean r12, boolean r13, Object r14, int r15, Object r16) {
        if (r16 != null) goto L15;
        if ((r15 & 2) == 0) goto L7;
        r12 = true;
    L7:
        if ((r15 & 4) == 0) goto L10;
        r13 = true;
    L10:
        if ((r15 & 8) == 0) goto L13;
        r14 = null;
    L13:
        return r10.expandAndChild(r11, r12, r13, r14);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandAndChild");
    }

    public static /* synthetic */ void expandAndCollapseOther$default(BaseNodeAdapter r10, int r11, boolean r12, boolean r13, boolean r14, boolean r15, Object r16, Object r17, int r18, Object r19) {
        if (r19 != null) goto L30;
        if ((r18 & 2) == 0) goto L6;
        boolean r20 = false;
    L7:
        boolean r21 = true;
        if ((r18 & 4) == 0) goto L10;
        boolean r22 = true;
    L12:
        if ((r18 & 8) == 0) goto L14;
        boolean r23 = true;
    L16:
        if ((r18 & 16) != 0) goto L19;
        r21 = r15;
    L19:
        Object r24 = null;
        if ((r18 & 32) == 0) goto L22;
        Object r25 = null;
    L24:
        if ((r18 & 64) != 0) goto L27;
        r24 = r17;
    L27:
        r10.expandAndCollapseOther(r11, r20, r22, r23, r21, r25, r24);
        return;
    L22:
        r25 = r16;
        goto L24
    L14:
        r23 = r14;
        goto L16
    L10:
        r22 = r13;
        goto L12
    L6:
        r20 = r12;
        goto L7
    L30:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandAndCollapseOther");
    }

    public static /* synthetic */ int expandOrCollapse$default(BaseNodeAdapter r10, int r11, boolean r12, boolean r13, Object r14, int r15, Object r16) {
        if (r16 != null) goto L15;
        if ((r15 & 2) == 0) goto L7;
        r12 = true;
    L7:
        if ((r15 & 4) == 0) goto L10;
        r13 = true;
    L10:
        if ((r15 & 8) == 0) goto L13;
        r14 = null;
    L13:
        return r10.expandOrCollapse(r11, r12, r13, r14);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandOrCollapse");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<BaseNode> flatData(Collection<? extends BaseNode> r10, Boolean r11) {
        ArrayList r12 = new ArrayList();
        Iterator<? extends BaseNode> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L30;
        BaseNode r14 = r13.next();
        r12.add(r14);
        if ((r14 instanceof BaseExpandNode) == true) goto L8;
        List<BaseNode> r15 = r14.getChildNode();
        if (r15 != null) goto L22;
    L26:
        if ((r14 instanceof NodeFooterImp) == false) goto L4;
        BaseNode r16 = ((NodeFooterImp) r14).getFooterNode();
        if (r16 == null) goto L4;
        r12.add(r16);
        goto L4
    L22:
        if (r15.isEmpty() == true) goto L26;
        r12.addAll(flatData(r15, r11));
        goto L26
    L8:
        if (q.b(r11, Boolean.TRUE) == false) goto L10;
    L11:
        List<BaseNode> r17 = r14.getChildNode();
        if (r17 != null) goto L14;
    L17:
        if (r11 == null) goto L26;
        BaseExpandNode r18 = (BaseExpandNode) r14;
        r18.setExpanded(r11.booleanValue());
        goto L26
    L14:
        if (r17.isEmpty() == true) goto L17;
        r12.addAll(flatData(r17, r11));
        goto L17
    L10:
        if (((BaseExpandNode) r14).isExpanded() == false) goto L17;
    L30:
        return r12;
    }

    public static /* synthetic */ List flatData$default(BaseNodeAdapter r10, Collection r11, Boolean r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L7;
        r12 = null;
    L7:
        return r10.flatData(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flatData");
    }

    private final int removeChildAt(int r10) {
        if (r10 < getData().size()) goto L5;
        return 0;
    L5:
        BaseNode r11 = getData().get(r10);
        List<BaseNode> r12 = r11.getChildNode();
        if (r12 != null) goto L8;
        return 0;
    L8:
        if (r12.isEmpty() == false) goto L11;
        return 0;
    L11:
        if ((r11 instanceof BaseExpandNode) == true) goto L13;
        List<BaseNode> r13 = r11.getChildNode();
        if (r13 != null) goto L21;
        q.s();
    L21:
        List r14 = flatData$default(this, r13, null, 2, null);
        getData().removeAll(r14);
        return r14.size();
    L13:
        if (((BaseExpandNode) r11).isExpanded() == false) goto L24;
        List<BaseNode> r15 = r11.getChildNode();
        if (r15 != null) goto L17;
        q.s();
    L17:
        List r16 = flatData$default(this, r15, null, 2, null);
        getData().removeAll(r16);
        return r16.size();
    L24:
        return 0;
    }

    private final int removeNodesAt(int r10) {
        if (r10 < getData().size()) goto L6;
        return 0;
    L6:
        int r11 = removeChildAt(r10);
        getData().remove(r10);
        int r12 = r11 + 1;
        Object r13 = (BaseNode) getData().get(r10);
        if ((r13 instanceof NodeFooterImp) == true) goto L9;
        return r12;
    L9:
        if (((NodeFooterImp) r13).getFooterNode() == null) goto L13;
        getData().remove(r10);
        return r11 + 2;
    L13:
        return r12;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void addData(int r10, Object r11) {
        addData(r10, (BaseNode) r11);
    }

    public final void addFooterNodeProvider(@NotNull BaseNodeProvider r10) {
        q.h(r10, "provider");
        addFullSpanNodeProvider(r10);
    }

    public final void addFullSpanNodeProvider(@NotNull BaseNodeProvider r10) {
        q.h(r10, "provider");
        this.fullSpanNodeTypeSet.add(Integer.valueOf(r10.getItemViewType()));
        addItemProvider(r10);
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public void addItemProvider(@NotNull BaseItemProvider<BaseNode> r10) {
        q.h(r10, "provider");
        if ((r10 instanceof BaseNodeProvider) == false) goto L7;
        super.addItemProvider(r10);
        return;
    L7:
        throw new IllegalStateException("Please add BaseNodeProvider, no BaseItemProvider!");
    }

    public final void addNodeProvider(@NotNull BaseNodeProvider r10) {
        q.h(r10, "provider");
        addItemProvider(r10);
    }

    @JvmOverloads
    public final int collapse(@IntRange(from = 0) int r10) {
        return collapse$default(this, r10, false, false, null, 14, null);
    }

    @JvmOverloads
    public final int collapseAndChild(@IntRange(from = 0) int r10) {
        return collapseAndChild$default(this, r10, false, false, null, 14, null);
    }

    @JvmOverloads
    public final int expand(@IntRange(from = 0) int r10) {
        return expand$default(this, r10, false, false, null, 14, null);
    }

    @JvmOverloads
    public final int expandAndChild(@IntRange(from = 0) int r10) {
        return expandAndChild$default(this, r10, false, false, null, 14, null);
    }

    @JvmOverloads
    public final void expandAndCollapseOther(@IntRange(from = 0) int r11) {
        expandAndCollapseOther$default(this, r11, false, false, false, false, null, null, 126, null);
    }

    @JvmOverloads
    public final int expandOrCollapse(@IntRange(from = 0) int r10) {
        return expandOrCollapse$default(this, r10, false, false, null, 14, null);
    }

    public final int findParentNode(@NotNull BaseNode r10) {
        q.h(r10, "node");
        int r11 = getData().indexOf(r10);
        if (r11 == (-1)) goto L14;
        if (r11 == 0) goto L14;
        int r12 = r11 - 1;
    L7:
        if (r12 < 0) goto L14;
        List<BaseNode> r13 = getData().get(r12).getChildNode();
        if (r13 == null) goto L13;
        if (r13.contains(r10) != true) goto L13;
        return r12;
    L13:
        r12 = r12 - 1;
    L14:
        return -1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public boolean isFixedViewType(int r10) {
        if (super.isFixedViewType(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.fullSpanNodeTypeSet.contains(Integer.valueOf(r10)) == true) goto L8;
        return false;
    }

    public final void nodeAddData(@NotNull BaseNode r10, @NotNull BaseNode r11) {
        q.h(r10, "parentNode");
        q.h(r11, "data");
        List<BaseNode> r12 = r10.getChildNode();
        if (r12 == null) goto L11;
        r12.add(r11);
        if ((r10 instanceof BaseExpandNode) == true) goto L7;
    L9:
        addData(getData().indexOf(r10) + r12.size(), r11);
        return;
    L7:
        if (((BaseExpandNode) r10).isExpanded() == true) goto L9;
        return;
    }

    public final void nodeRemoveData(@NotNull BaseNode r10, int r11) {
        q.h(r10, "parentNode");
        List<BaseNode> r12 = r10.getChildNode();
        if (r12 != null) goto L5;
        return;
    L5:
        if (r11 < r12.size()) goto L8;
        return;
    L8:
        if ((r10 instanceof BaseExpandNode) == true) goto L10;
    L13:
        remove((getData().indexOf(r10) + 1) + r11);
        BaseNode r13 = r12.remove(r11);
        return;
    L10:
        if (((BaseExpandNode) r10).isExpanded() == true) goto L13;
        r12.remove(r11);
    }

    public final void nodeReplaceChildData(@NotNull BaseNode r10, @NotNull Collection<? extends BaseNode> r11) {
        q.h(r10, "parentNode");
        q.h(r11, "newData");
        List<BaseNode> r12 = r10.getChildNode();
        if (r12 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof BaseExpandNode) == true) goto L7;
    L10:
        int r13 = getData().indexOf(r10);
        int r14 = removeChildAt(r13);
        r12.clear();
        r12.addAll(r11);
        List r15 = flatData$default(this, r11, null, 2, null);
        int r16 = r13 + 1;
        getData().addAll(r16, r15);
        int r17 = r16 + getHeaderLayoutCount();
        if (r14 != r15.size()) goto L13;
        notifyItemRangeChanged(r17, r14);
        return;
    L13:
        notifyItemRangeRemoved(r17, r14);
        notifyItemRangeInserted(r17, r15.size());
        return;
    L7:
        if (((BaseExpandNode) r10).isExpanded() == true) goto L10;
        r12.clear();
        r12.addAll(r11);
    }

    public final void nodeSetData(@NotNull BaseNode r10, int r11, @NotNull BaseNode r12) {
        q.h(r10, "parentNode");
        q.h(r12, "data");
        List<BaseNode> r13 = r10.getChildNode();
        if (r13 != null) goto L5;
        return;
    L5:
        if (r11 < r13.size()) goto L8;
        return;
    L8:
        if ((r10 instanceof BaseExpandNode) == true) goto L10;
    L13:
        setData((getData().indexOf(r10) + 1) + r11, r12);
        r13.set(r11, r12);
        return;
    L10:
        if (((BaseExpandNode) r10).isExpanded() == true) goto L13;
        r13.set(r11, r12);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void removeAt(int r10) {
        int r11 = removeNodesAt(r10);
        notifyItemRangeRemoved(r10 + getHeaderLayoutCount(), r11);
        compatibilityDataSizeChanged(0);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void setData(int r10, Object r11) {
        setData(r10, (BaseNode) r11);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setDiffNewData(@Nullable List<BaseNode> r10) {
        if (hasEmptyView() == false) goto L6;
        setNewInstance(r10);
        return;
    L6:
        if (r10 != null) goto L9;
        r10 = new ArrayList();
    L9:
        super.setDiffNewData(flatData$default(this, r10, null, 2, null));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setList(@Nullable Collection<? extends BaseNode> r10) {
        if (r10 != null) goto L5;
        r10 = new ArrayList();
    L5:
        super.setList(flatData$default(this, r10, null, 2, null));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewInstance(@Nullable List<BaseNode> r10) {
        if (r10 != null) goto L5;
        r10 = new ArrayList();
    L5:
        super.setNewInstance(flatData$default(this, r10, null, 2, null));
    }

    public /* synthetic */ BaseNodeAdapter(List r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        this(r10);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void addData(Object r10) {
        addData((BaseNode) r10);
    }

    @JvmOverloads
    public final int collapse(@IntRange(from = 0) int r10, boolean r11) {
        return collapse$default(this, r10, r11, false, null, 12, null);
    }

    @JvmOverloads
    public final int collapseAndChild(@IntRange(from = 0) int r10, boolean r11) {
        return collapseAndChild$default(this, r10, r11, false, null, 12, null);
    }

    @JvmOverloads
    public final int expand(@IntRange(from = 0) int r10, boolean r11) {
        return expand$default(this, r10, r11, false, null, 12, null);
    }

    @JvmOverloads
    public final int expandAndChild(@IntRange(from = 0) int r10, boolean r11) {
        return expandAndChild$default(this, r10, r11, false, null, 12, null);
    }

    @JvmOverloads
    public final void expandAndCollapseOther(@IntRange(from = 0) int r11, boolean r12) {
        expandAndCollapseOther$default(this, r11, r12, false, false, false, null, null, 124, null);
    }

    @JvmOverloads
    public final int expandOrCollapse(@IntRange(from = 0) int r10, boolean r11) {
        return expandOrCollapse$default(this, r10, r11, false, null, 12, null);
    }

    public void setData(int r10, @NotNull BaseNode r11) {
        q.h(r11, "data");
        int r12 = removeNodesAt(r10);
        List r13 = flatData$default(this, t.g(new BaseNode[]{r11}), null, 2, null);
        getData().addAll(r10, r13);
        if (r12 != r13.size()) goto L5;
        notifyItemRangeChanged(r10 + getHeaderLayoutCount(), r12);
        return;
    L5:
        notifyItemRangeRemoved(getHeaderLayoutCount() + r10, r12);
        notifyItemRangeInserted(r10 + getHeaderLayoutCount(), r13.size());
    }

    public BaseNodeAdapter(@Nullable List<BaseNode> r10) {
        super(null);
        this.fullSpanNodeTypeSet = new HashSet();
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L10;
        List r11 = flatData$default(this, r10, null, 2, null);
        getData().addAll(r11);
        return;
    }

    public static /* synthetic */ int collapse$default(BaseNodeAdapter r10, int r11, boolean r12, boolean r13, Object r14, int r15, Object r16) {
        if (r16 != null) goto L15;
        if ((r15 & 2) == 0) goto L7;
        r12 = true;
    L7:
        if ((r15 & 4) == 0) goto L10;
        r13 = true;
    L10:
        if ((r15 & 8) == 0) goto L13;
        r14 = null;
    L13:
        return r10.collapse(r11, r12, r13, r14);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapse");
    }

    public static /* synthetic */ int expand$default(BaseNodeAdapter r10, int r11, boolean r12, boolean r13, Object r14, int r15, Object r16) {
        if (r16 != null) goto L15;
        if ((r15 & 2) == 0) goto L7;
        r12 = true;
    L7:
        if ((r15 & 4) == 0) goto L10;
        r13 = true;
    L10:
        if ((r15 & 8) == 0) goto L13;
        r14 = null;
    L13:
        return r10.expand(r11, r12, r13, r14);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expand");
    }

    public void addData(int r10, @NotNull BaseNode r11) {
        q.h(r11, "data");
        addData(r10, t.g(new BaseNode[]{r11}));
    }

    @JvmOverloads
    public final int collapse(@IntRange(from = 0) int r10, boolean r11, boolean r12) {
        return collapse$default(this, r10, r11, r12, null, 8, null);
    }

    @JvmOverloads
    public final int collapseAndChild(@IntRange(from = 0) int r10, boolean r11, boolean r12) {
        return collapseAndChild$default(this, r10, r11, r12, null, 8, null);
    }

    @JvmOverloads
    public final int expand(@IntRange(from = 0) int r10, boolean r11, boolean r12) {
        return expand$default(this, r10, r11, r12, null, 8, null);
    }

    @JvmOverloads
    public final int expandAndChild(@IntRange(from = 0) int r10, boolean r11, boolean r12) {
        return expandAndChild$default(this, r10, r11, r12, null, 8, null);
    }

    @JvmOverloads
    public final void expandAndCollapseOther(@IntRange(from = 0) int r11, boolean r12, boolean r13) {
        expandAndCollapseOther$default(this, r11, r12, r13, false, false, null, null, 120, null);
    }

    @JvmOverloads
    public final int expandOrCollapse(@IntRange(from = 0) int r10, boolean r11, boolean r12) {
        return expandOrCollapse$default(this, r10, r11, r12, null, 8, null);
    }

    private final int collapse(@IntRange(from = 0) int r10, boolean r11, boolean r12, boolean r13, Object r14) {
        BaseNode r15 = getData().get(r10);
        if ((r15 instanceof BaseExpandNode) == false) goto L24;
        BaseExpandNode r16 = (BaseExpandNode) r15;
        if (r16.isExpanded() == false) goto L24;
        int r17 = r10 + getHeaderLayoutCount();
        r16.setExpanded(false);
        List<BaseNode> r18 = r15.getChildNode();
        if (r18 != null) goto L9;
    L23:
        notifyItemChanged(r17, r14);
        goto L24
    L9:
        if (r18.isEmpty() == true) goto L23;
        List<BaseNode> r19 = r15.getChildNode();
        if (r19 != null) goto L14;
        q.s();
    L14:
        if (r11 == false) goto L16;
        Boolean r20 = Boolean.FALSE;
    L17:
        List<BaseNode> r21 = flatData(r19, r20);
        int r22 = r21.size();
        getData().removeAll(r21);
        if (r13 == false) goto L22;
        if (r12 == false) goto L21;
        notifyItemChanged(r17, r14);
        notifyItemRangeRemoved(r17 + 1, r22);
        goto L22
    L21:
        notifyDataSetChanged();
    L22:
        return r22;
    L16:
        r20 = null;
    L24:
        return 0;
    }

    private final int expand(@IntRange(from = 0) int r10, boolean r11, boolean r12, boolean r13, Object r14) {
        BaseNode r15 = getData().get(r10);
        if ((r15 instanceof BaseExpandNode) == false) goto L24;
        BaseExpandNode r16 = (BaseExpandNode) r15;
        if (r16.isExpanded() == true) goto L24;
        int r17 = getHeaderLayoutCount() + r10;
        r16.setExpanded(true);
        List<BaseNode> r18 = r15.getChildNode();
        if (r18 != null) goto L9;
    L23:
        notifyItemChanged(r17, r14);
        goto L24
    L9:
        if (r18.isEmpty() == true) goto L23;
        List<BaseNode> r19 = r15.getChildNode();
        if (r19 != null) goto L14;
        q.s();
    L14:
        if (r11 == false) goto L16;
        Boolean r20 = Boolean.TRUE;
    L17:
        List<BaseNode> r21 = flatData(r19, r20);
        int r22 = r21.size();
        getData().addAll(r10 + 1, r21);
        if (r13 == false) goto L22;
        if (r12 == false) goto L21;
        notifyItemChanged(r17, r14);
        notifyItemRangeInserted(r17 + 1, r22);
        goto L22
    L21:
        notifyDataSetChanged();
    L22:
        return r22;
    L16:
        r20 = null;
    L24:
        return 0;
    }

    public void addData(@NotNull BaseNode r10) {
        q.h(r10, "data");
        addData(t.g(new BaseNode[]{r10}));
    }

    @JvmOverloads
    public final int collapseAndChild(@IntRange(from = 0) int r10, boolean r11, boolean r12, @Nullable Object r13) {
        return collapse(r10, true, r11, r12, r13);
    }

    @JvmOverloads
    public final int expandAndChild(@IntRange(from = 0) int r10, boolean r11, boolean r12, @Nullable Object r13) {
        return expand(r10, true, r11, r12, r13);
    }

    @JvmOverloads
    public final void expandAndCollapseOther(@IntRange(from = 0) int r11, boolean r12, boolean r13, boolean r14) {
        expandAndCollapseOther$default(this, r11, r12, r13, r14, false, null, null, 112, null);
    }

    @JvmOverloads
    public final int expandOrCollapse(@IntRange(from = 0) int r10, boolean r11, boolean r12, @Nullable Object r13) {
        BaseNode r14 = getData().get(r10);
        if ((r14 instanceof BaseExpandNode) == true) goto L5;
        return 0;
    L5:
        if (((BaseExpandNode) r14).isExpanded() == false) goto L8;
        return collapse(r10, false, r11, r12, r13);
    L8:
        return expand(r10, false, r11, r12, r13);
    }

    public final int findParentNode(@IntRange(from = 0) int r10) {
        if (r10 != 0) goto L5;
        return -1;
    L5:
        BaseNode r11 = getData().get(r10);
        int r12 = r10 - 1;
    L6:
        if (r12 < 0) goto L13;
        List<BaseNode> r13 = getData().get(r12).getChildNode();
        if (r13 == null) goto L12;
        if (r13.contains(r11) != true) goto L12;
        return r12;
    L12:
        r12 = r12 - 1;
        goto L6
    L13:
        return -1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setDiffNewData(@NotNull DiffUtil.DiffResult r10, @NotNull List<BaseNode> r11) {
        q.h(r10, "diffResult");
        q.h(r11, ServerElements.LIST);
        if (hasEmptyView() == false) goto L6;
        setNewInstance(r11);
        return;
    L6:
        super.setDiffNewData(r10, flatData$default(this, r11, null, 2, null));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(int r10, @NotNull Collection<? extends BaseNode> r11) {
        q.h(r11, "newData");
        super.addData(r10, flatData$default(this, r11, null, 2, null));
    }

    @JvmOverloads
    public final void expandAndCollapseOther(@IntRange(from = 0) int r11, boolean r12, boolean r13, boolean r14, boolean r15) {
        expandAndCollapseOther$default(this, r11, r12, r13, r14, r15, null, null, 96, null);
    }

    @JvmOverloads
    public final void expandAndCollapseOther(@IntRange(from = 0) int r11, boolean r12, boolean r13, boolean r14, boolean r15, @Nullable Object r16) {
        expandAndCollapseOther$default(this, r11, r12, r13, r14, r15, r16, null, 64, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(@NotNull Collection<? extends BaseNode> r10) {
        q.h(r10, "newData");
        super.addData(flatData$default(this, r10, null, 2, null));
    }

    @JvmOverloads
    public final void expandAndCollapseOther(@IntRange(from = 0) int r13, boolean r14, boolean r15, boolean r16, boolean r17, @Nullable Object r18, @Nullable Object r19) {
        int r10 = expand(r13, r14, r16, r17, r18);
        if (r10 != 0) goto L5;
        return;
    L5:
        int r11 = findParentNode(r13);
        int r12 = 0;
        if (r11 != (-1)) goto L8;
        int r20 = 0;
    L10:
        if ((r13 - r20) <= 0) goto L15;
        int r110 = r20;
        int r21 = r13;
    L12:
        int r22 = collapse(r110, r15, r16, r17, r19);
        r110 = r110 + 1;
        r21 = r21 - r22;
        if (r110 < r21) goto L12;
    L16:
        if (r11 != (-1)) goto L18;
        int r23 = getData().size() - 1;
    L22:
        int r24 = r21 + r10;
        if (r24 >= r23) goto L27;
        int r25 = r24 + 1;
    L25:
        if (r25 > r23) goto L31;
        int r26 = collapse(r25, r15, r16, r17, r19);
        r25 = r25 + 1;
        r23 = r23 - r26;
        goto L25
    L31:
        return;
    L27:
        return;
    L18:
        List<BaseNode> r27 = getData().get(r11).getChildNode();
        if (r27 == null) goto L21;
        r12 = r27.size();
    L21:
        r23 = (r11 + r12) + r10;
        goto L22
    L15:
        r21 = r13;
        goto L16
    L8:
        r20 = r11 + 1;
        goto L10
    }

    public final void nodeAddData(@NotNull BaseNode r10, int r11, @NotNull BaseNode r12) {
        q.h(r10, "parentNode");
        q.h(r12, "data");
        List<BaseNode> r13 = r10.getChildNode();
        if (r13 == null) goto L11;
        r13.add(r11, r12);
        if ((r10 instanceof BaseExpandNode) == true) goto L7;
    L9:
        addData((getData().indexOf(r10) + 1) + r11, r12);
        return;
    L7:
        if (((BaseExpandNode) r10).isExpanded() == true) goto L9;
        return;
    }

    public final void nodeRemoveData(@NotNull BaseNode r10, @NotNull BaseNode r11) {
        q.h(r10, "parentNode");
        q.h(r11, "childNode");
        List<BaseNode> r12 = r10.getChildNode();
        if (r12 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof BaseExpandNode) == true) goto L7;
    L10:
        remove(r11);
        r12.remove(r11);
        return;
    L7:
        if (((BaseExpandNode) r10).isExpanded() == true) goto L10;
        r12.remove(r11);
    }

    public final void nodeAddData(@NotNull BaseNode r10, int r11, @NotNull Collection<? extends BaseNode> r12) {
        q.h(r10, "parentNode");
        q.h(r12, "newData");
        List<BaseNode> r13 = r10.getChildNode();
        if (r13 == null) goto L11;
        r13.addAll(r11, r12);
        if ((r10 instanceof BaseExpandNode) == true) goto L7;
    L9:
        addData((getData().indexOf(r10) + 1) + r11, r12);
        return;
    L7:
        if (((BaseExpandNode) r10).isExpanded() == true) goto L9;
        return;
    }

    @JvmOverloads
    public final int collapse(@IntRange(from = 0) int r10, boolean r11, boolean r12, @Nullable Object r13) {
        return collapse(r10, false, r11, r12, r13);
    }

    @JvmOverloads
    public final int expand(@IntRange(from = 0) int r10, boolean r11, boolean r12, @Nullable Object r13) {
        return expand(r10, false, r11, r12, r13);
    }
}

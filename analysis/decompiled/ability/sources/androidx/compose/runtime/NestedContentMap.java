package androidx.compose.runtime;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectList;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\u00020\b2\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u0003J\u001f\u0010\r\u001a\u0004\u0018\u00010\u00062\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0010\u001a\u00020\u000f2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R(\u0010\u0017\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004\u0012\u0004\u0012\u00020\u00060\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/NestedContentMap;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/MovableContent;", "content", "Landroidx/compose/runtime/NestedMovableContent;", "nestedContent", "LC7/r;", "add", "(Landroidx/compose/runtime/MovableContent;Landroidx/compose/runtime/NestedMovableContent;)V", "clear", "key", "removeLast", "(Landroidx/compose/runtime/MovableContent;)Landroidx/compose/runtime/NestedMovableContent;", "", "contains", "(Landroidx/compose/runtime/MovableContent;)Z", "Landroidx/compose/runtime/MovableContentStateReference;", TypedValues.Custom.S_REFERENCE, "usedContainer", "(Landroidx/compose/runtime/MovableContentStateReference;)V", "Landroidx/compose/runtime/collection/MultiValueMap;", "contentMap", "Landroidx/collection/MutableScatterMap;", "containerMap", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class NestedContentMap {
    private final MutableScatterMap<Object, Object> contentMap = MultiValueMap.m3553constructorimpl$default(null, 1, null);
    private final MutableScatterMap<Object, Object> containerMap = MultiValueMap.m3553constructorimpl$default(null, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean usedContainer$lambda$2$lambda$1(MovableContentStateReference movableContentStateReference, NestedMovableContent nestedMovableContent) {
        return kotlin.jvm.internal.k.b(nestedMovableContent.getContainer(), movableContentStateReference);
    }

    public final void add(MovableContent<Object> content, NestedMovableContent nestedContent) {
        MultiValueMap.m3549addimpl(this.contentMap, content, nestedContent);
        MultiValueMap.m3549addimpl(this.containerMap, nestedContent.getContainer(), content);
    }

    public final void clear() {
        MultiValueMap.m3551clearimpl(this.contentMap);
        MultiValueMap.m3551clearimpl(this.containerMap);
    }

    public final boolean contains(MovableContent<Object> key) {
        return MultiValueMap.m3554containsimpl(this.contentMap, key);
    }

    public final NestedMovableContent removeLast(MovableContent<Object> key) {
        NestedMovableContent nestedMovableContent = (NestedMovableContent) MultiValueMap.m3563removeLastimpl(this.contentMap, key);
        if (MultiValueMap.m3560isEmptyimpl(this.contentMap)) {
            MultiValueMap.m3551clearimpl(this.containerMap);
        }
        return nestedMovableContent;
    }

    public final void usedContainer(MovableContentStateReference reference) {
        Object obj = this.containerMap.get(reference);
        if (obj != null) {
            if (!(obj instanceof MutableObjectList)) {
                MultiValueMap.m3564removeValueIfimpl(this.contentMap, (MovableContent) obj, new g(reference, 0));
                return;
            }
            ObjectList objectList = (ObjectList) obj;
            Object[] objArr = objectList.content;
            int i = objectList._size;
            for (int i6 = 0; i6 < i; i6++) {
                Object obj2 = objArr[i6];
                kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap");
                MultiValueMap.m3564removeValueIfimpl(this.contentMap, (MovableContent) obj2, new g(reference, 0));
            }
        }
    }
}

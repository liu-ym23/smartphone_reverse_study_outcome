package androidx.compose.foundation.text.input.internal;

import S7.k;
import S7.n;
import android.content.ClipDescription;
import android.view.DragEvent;
import androidx.compose.foundation.content.MediaType;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropModifierNode;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropTarget;
import androidx.compose.ui.draganddrop.DragAndDrop_androidKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aá\u0001\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00002\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u0000¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lkotlin/Function0;", "", "Landroidx/compose/foundation/content/MediaType;", "hintMediaTypes", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/ClipEntry;", "Landroidx/compose/ui/platform/ClipMetadata;", "", "onDrop", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "LC7/r;", "dragAndDropRequestPermission", "onStarted", "onEntered", "Landroidx/compose/ui/geometry/Offset;", "onMoved", "onChanged", "onExited", "onEnded", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "textFieldDragAndDropNode", "(LS7/a;LS7/n;LS7/k;LS7/k;LS7/k;LS7/k;LS7/k;LS7/k;LS7/k;)Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldDragAndDropNode_androidKt {
    public static final DragAndDropModifierNode textFieldDragAndDropNode(final S7.a aVar, final n nVar, final k kVar, final k kVar2, final k kVar3, final k kVar4, final k kVar5, final k kVar6, final k kVar7) {
        return DragAndDropNodeKt.DragAndDropModifierNode(new k() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDragAndDropNode_androidKt.textFieldDragAndDropNode.1
            {
                super(1);
            }

            @Override // S7.k
            public final Boolean invoke(DragAndDropEvent dragAndDropEvent) {
                ClipDescription clipDescription = DragAndDrop_androidKt.toAndroidDragEvent(dragAndDropEvent).getClipDescription();
                Iterable<MediaType> iterable = (Iterable) aVar.invoke();
                boolean z10 = false;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    for (MediaType mediaType : iterable) {
                        if (kotlin.jvm.internal.k.b(mediaType, MediaType.INSTANCE.getAll()) || clipDescription.hasMimeType(mediaType.getRepresentation())) {
                            z10 = true;
                            break;
                        }
                    }
                }
                return Boolean.valueOf(z10);
            }
        }, new DragAndDropTarget() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDragAndDropNode_androidKt.textFieldDragAndDropNode.2
            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public void onChanged(DragAndDropEvent event) {
                k kVar8 = kVar5;
                if (kVar8 != null) {
                    kVar8.invoke(event);
                }
            }

            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public boolean onDrop(DragAndDropEvent event) {
                kVar.invoke(event);
                return ((Boolean) nVar.invoke(AndroidClipboardManager_androidKt.toClipEntry(DragAndDrop_androidKt.toAndroidDragEvent(event).getClipData()), AndroidClipboardManager_androidKt.toClipMetadata(DragAndDrop_androidKt.toAndroidDragEvent(event).getClipDescription()))).booleanValue();
            }

            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public void onEnded(DragAndDropEvent event) {
                k kVar8 = kVar7;
                if (kVar8 != null) {
                    kVar8.invoke(event);
                }
            }

            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public void onEntered(DragAndDropEvent event) {
                k kVar8 = kVar3;
                if (kVar8 != null) {
                    kVar8.invoke(event);
                }
            }

            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public void onExited(DragAndDropEvent event) {
                k kVar8 = kVar6;
                if (kVar8 != null) {
                    kVar8.invoke(event);
                }
            }

            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public void onMoved(DragAndDropEvent event) {
                DragEvent androidDragEvent = DragAndDrop_androidKt.toAndroidDragEvent(event);
                k kVar8 = kVar4;
                if (kVar8 != null) {
                    kVar8.invoke(Offset.m3884boximpl(OffsetKt.Offset(androidDragEvent.getX(), androidDragEvent.getY())));
                }
            }

            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public void onStarted(DragAndDropEvent event) {
                k kVar8 = kVar2;
                if (kVar8 != null) {
                    kVar8.invoke(event);
                }
            }
        });
    }

    public static /* synthetic */ DragAndDropModifierNode textFieldDragAndDropNode$default(S7.a aVar, n nVar, k kVar, k kVar2, k kVar3, k kVar4, k kVar5, k kVar6, k kVar7, int i, Object obj) {
        if ((i & 8) != 0) {
            kVar2 = null;
        }
        if ((i & 16) != 0) {
            kVar3 = null;
        }
        if ((i & 32) != 0) {
            kVar4 = null;
        }
        if ((i & 64) != 0) {
            kVar5 = null;
        }
        if ((i & 128) != 0) {
            kVar6 = null;
        }
        if ((i & 256) != 0) {
            kVar7 = null;
        }
        return textFieldDragAndDropNode(aVar, nVar, kVar, kVar2, kVar3, kVar4, kVar5, kVar6, kVar7);
    }
}

package j1;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h extends e0.b {
    public final /* synthetic */ int d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ View f3507e;

    public /* synthetic */ h(View view, int i8) {
        this.d = i8;
        this.f3507e = view;
    }

    @Override // e0.b
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.d) {
            case 1:
                super.c(view, accessibilityEvent);
                accessibilityEvent.setChecked(((CheckableImageButton) this.f3507e).d);
                break;
            default:
                super.c(view, accessibilityEvent);
                break;
        }
    }

    @Override // e0.b
    public final void d(View view, f0.g gVar) {
        int i8;
        int i9 = this.d;
        View view2 = this.f3507e;
        View.AccessibilityDelegate accessibilityDelegate = this.f2288a;
        switch (i9) {
            case 0:
                AccessibilityNodeInfo accessibilityNodeInfo = gVar.f2542a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) view2;
                int i10 = MaterialButtonToggleGroup.f1280r;
                if (view instanceof MaterialButton) {
                    int i11 = 0;
                    for (int i12 = 0; i12 < materialButtonToggleGroup.getChildCount(); i12++) {
                        if (materialButtonToggleGroup.getChildAt(i12) == view) {
                            i8 = i11;
                        } else {
                            if ((materialButtonToggleGroup.getChildAt(i12) instanceof MaterialButton) && materialButtonToggleGroup.getChildAt(i12).getVisibility() != 8) {
                                i11++;
                            }
                        }
                    }
                    i8 = -1;
                } else {
                    i8 = -1;
                }
                accessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(0, 1, i8, 1, false, ((MaterialButton) view).f1271p));
                break;
            case 1:
                AccessibilityNodeInfo accessibilityNodeInfo2 = gVar.f2542a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                CheckableImageButton checkableImageButton = (CheckableImageButton) view2;
                accessibilityNodeInfo2.setCheckable(checkableImageButton.f1319e);
                accessibilityNodeInfo2.setChecked(checkableImageButton.d);
                break;
            default:
                AccessibilityNodeInfo accessibilityNodeInfo3 = gVar.f2542a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo3);
                accessibilityNodeInfo3.setCheckable(((NavigationMenuItemView) view2).y);
                break;
        }
    }
}

package r0;

import K.C0069b;
import L.g;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;
import com.stepos.textinputlayout.TextInputLayout;

/* loaded from: classes.dex */
public final class d extends C0069b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14004a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f14005b;

    public /* synthetic */ d(int i4, View view) {
        this.f14004a = i4;
        this.f14005b = view;
    }

    @Override // K.C0069b
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        int i4 = this.f14004a;
        View view2 = this.f14005b;
        switch (i4) {
            case 0:
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setClassName(ViewPager.class.getName());
                ((ViewPager) view2).getClass();
                accessibilityEvent.setScrollable(false);
                if (accessibilityEvent.getEventType() == 4096) {
                    ((ViewPager) view2).getClass();
                    break;
                }
                break;
            case 2:
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setChecked(((CheckableImageButton) view2).f10751d);
                break;
            case 5:
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setClassName("TextInputLayout");
                break;
            default:
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                break;
        }
    }

    @Override // K.C0069b
    public final void onInitializeAccessibilityNodeInfo(View view, g gVar) {
        int i4;
        int i5 = this.f14004a;
        View view2 = this.f14005b;
        switch (i5) {
            case 0:
                super.onInitializeAccessibilityNodeInfo(view, gVar);
                gVar.g(ViewPager.class.getName());
                ((ViewPager) view2).getClass();
                gVar.h(false);
                ((ViewPager) view2).getClass();
                break;
            case 1:
                super.onInitializeAccessibilityNodeInfo(view, gVar);
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) view2;
                int i6 = MaterialButtonToggleGroup.f10500q;
                materialButtonToggleGroup.getClass();
                if (view instanceof MaterialButton) {
                    int i7 = 0;
                    for (int i8 = 0; i8 < materialButtonToggleGroup.getChildCount(); i8++) {
                        if (materialButtonToggleGroup.getChildAt(i8) == view) {
                            i4 = i7;
                        } else {
                            if ((materialButtonToggleGroup.getChildAt(i8) instanceof MaterialButton) && materialButtonToggleGroup.getChildAt(i8).getVisibility() != 8) {
                                i7++;
                            }
                        }
                    }
                    i4 = -1;
                } else {
                    i4 = -1;
                }
                gVar.f1142a.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(0, 1, i4, 1, false, ((MaterialButton) view).f10487o));
                break;
            case 2:
                super.onInitializeAccessibilityNodeInfo(view, gVar);
                CheckableImageButton checkableImageButton = (CheckableImageButton) view2;
                boolean z4 = checkableImageButton.f10752e;
                AccessibilityNodeInfo accessibilityNodeInfo = gVar.f1142a;
                accessibilityNodeInfo.setCheckable(z4);
                accessibilityNodeInfo.setChecked(checkableImageButton.f10751d);
                break;
            case 3:
                super.onInitializeAccessibilityNodeInfo(view, gVar);
                gVar.f1142a.setCheckable(((NavigationMenuItemView) view2).f10765x);
                break;
            case 4:
                super.onInitializeAccessibilityNodeInfo(view, gVar);
                gVar.f1142a.setVisibleToUser(false);
                break;
            default:
                super.onInitializeAccessibilityNodeInfo(view, gVar);
                gVar.g("TextInputLayout");
                TextInputLayout textInputLayout = (TextInputLayout) view2;
                CharSequence charSequence = textInputLayout.f12403o.f2015s;
                if (!TextUtils.isEmpty(charSequence)) {
                    gVar.i(charSequence);
                }
                EditText editText = textInputLayout.f12390b;
                AccessibilityNodeInfo accessibilityNodeInfo2 = gVar.f1142a;
                if (editText != null) {
                    accessibilityNodeInfo2.setLabelFor(editText);
                }
                TextView textView = textInputLayout.f12394f;
                CharSequence text = textView != null ? textView.getText() : null;
                if (!TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo2.setContentInvalid(true);
                    accessibilityNodeInfo2.setError(text);
                    break;
                }
                break;
        }
    }

    @Override // K.C0069b
    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f14004a) {
            case 5:
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
                CharSequence charSequence = ((TextInputLayout) this.f14005b).f12403o.f2015s;
                if (!TextUtils.isEmpty(charSequence)) {
                    accessibilityEvent.getText().add(charSequence);
                    break;
                }
                break;
            default:
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
                break;
        }
    }

    @Override // K.C0069b
    public final boolean performAccessibilityAction(View view, int i4, Bundle bundle) {
        switch (this.f14004a) {
            case 0:
                if (super.performAccessibilityAction(view, i4, bundle)) {
                    return true;
                }
                View view2 = this.f14005b;
                if (i4 == 4096 || i4 == 8192) {
                    ((ViewPager) view2).getClass();
                }
                return false;
            default:
                return super.performAccessibilityAction(view, i4, bundle);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(TextInputLayout textInputLayout) {
        this(5, textInputLayout);
        this.f14004a = 5;
    }
}

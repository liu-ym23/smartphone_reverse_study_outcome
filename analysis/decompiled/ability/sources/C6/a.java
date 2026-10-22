package C6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.internal.ParcelableSparseArray;
import com.stepos.widget.editinput.StepOSEditInputView$SavedState;
import com.stepos.widget.list.StepOSSwipeActionLayout$SavedState;
import com.stepos.widget.recipient.StepOSRecipientEdit$SavedState;
import com.stepos.widget.searchbar.StepOSSearchBar$SavedState;
import com.stepos.widget.tabbar.StepOSCollapsibleTabBar$SavedState;
import com.stepos.widget.tabbar.StepOSTabBar$SavedState;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a implements Parcelable.ClassLoaderCreator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f303a;

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel source, ClassLoader classLoader) {
        switch (this.f303a) {
            case 0:
                k.f(source, "source");
                return new StepOSEditInputView$SavedState(source, classLoader);
            case 1:
                k.f(source, "source");
                return new StepOSSwipeActionLayout$SavedState(source, classLoader);
            case 2:
                k.f(source, "source");
                return new StepOSRecipientEdit$SavedState(source, classLoader);
            case 3:
                k.f(source, "source");
                return new StepOSSearchBar$SavedState(source, classLoader);
            case 4:
                k.f(source, "source");
                return new StepOSCollapsibleTabBar$SavedState(source, classLoader);
            case 5:
                k.f(source, "source");
                return new StepOSTabBar$SavedState(source, classLoader);
            default:
                return new ParcelableSparseArray(source, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f303a) {
            case 0:
                return new StepOSEditInputView$SavedState[i];
            case 1:
                return new StepOSSwipeActionLayout$SavedState[i];
            case 2:
                return new StepOSRecipientEdit$SavedState[i];
            case 3:
                return new StepOSSearchBar$SavedState[i];
            case 4:
                return new StepOSCollapsibleTabBar$SavedState[i];
            case 5:
                return new StepOSTabBar$SavedState[i];
            default:
                return new ParcelableSparseArray[i];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel source) {
        switch (this.f303a) {
            case 0:
                k.f(source, "source");
                return new StepOSEditInputView$SavedState(source, null);
            case 1:
                k.f(source, "source");
                return new StepOSSwipeActionLayout$SavedState(source, null);
            case 2:
                k.f(source, "source");
                return new StepOSRecipientEdit$SavedState(source, null);
            case 3:
                k.f(source, "source");
                return new StepOSSearchBar$SavedState(source, null);
            case 4:
                k.f(source, "source");
                return new StepOSCollapsibleTabBar$SavedState(source, null);
            case 5:
                k.f(source, "source");
                return new StepOSTabBar$SavedState(source, null);
            default:
                return new ParcelableSparseArray(source, null);
        }
    }
}

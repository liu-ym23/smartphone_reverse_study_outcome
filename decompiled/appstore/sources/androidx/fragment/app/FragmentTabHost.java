package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabHost;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FragmentManager f3239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TabHost.OnTabChangeListener f3241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3242e;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        String curTab;

        public class a implements Parcelable.Creator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10);
            }

            public SavedState[] b(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }

        @NonNull
        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.curTab + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeString(this.curTab);
        }

        public SavedState(Parcel r10) {
            super(r10);
            this.curTab = r10.readString();
        }
    }

    public static final class a {
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context r10) {
        super(r10, null);
        this.f3238a = new ArrayList();
        c(r10, null);
    }

    public final FragmentTransaction a(String r10, FragmentTransaction r11) {
        b(r10);
        return r11;
    }

    public final a b(String r10) {
        if (this.f3238a.size() > 0) goto L5;
        return null;
    L5:
        androidx.appcompat.widget.p.a(this.f3238a.get(0));
        throw null;
    }

    public final void c(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, new int[]{R.attr.inflatedId}, 0, 0);
        this.f3240c = r12.getResourceId(0, 0);
        r12.recycle();
        super.setOnTabChangedListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r10 = getCurrentTabTag();
        if (this.f3238a.size() > 0) goto L8;
        this.f3242e = true;
        FragmentTransaction r11 = a(r10, null);
        if (r11 == null) goto L10;
        r11.j();
        this.f3239b.e0();
        return;
    L10:
        return;
    L8:
        androidx.appcompat.widget.p.a(this.f3238a.get(0));
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3242e = false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        setCurrentTabByTag(r11.curTab);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.curTab = getCurrentTabTag();
        return r10;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String r10) {
        if (this.f3242e == false) goto L7;
        FragmentTransaction r11 = a(r10, null);
        if (r11 == null) goto L7;
        r11.j();
    L7:
        TabHost.OnTabChangeListener r12 = this.f3241d;
        if (r12 == null) goto L11;
        r12.onTabChanged(r10);
        return;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(@Nullable TabHost.OnTabChangeListener r10) {
        this.f3241d = r10;
    }

    @Override // android.widget.TabHost
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.f3238a = new ArrayList();
        c(r10, r11);
    }
}

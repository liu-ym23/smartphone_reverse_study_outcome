package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.appcompat.widget.C0446p;
import androidx.core.view.C0456a;
import androidx.core.view.H;
import androidx.recyclerview.widget.RecyclerView;
import g.C0728a;

/* loaded from: classes.dex */
public class CheckableImageButton extends C0446p implements Checkable {

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f12903g = {R.attr.state_checked};

    /* renamed from: d, reason: collision with root package name */
    private boolean f12904d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f12905e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f12906f;

    class a extends C0456a {
        a() {
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityNodeInfo(View view, E.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.b0(CheckableImageButton.this.a());
            cVar.c0(CheckableImageButton.this.isChecked());
        }
    }

    static class b extends androidx.customview.view.a {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        boolean f12908a;

        class a implements Parcelable.ClassLoaderCreator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i5) {
                return new b[i5];
            }
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(Parcel parcel) {
            this.f12908a = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f12908a ? 1 : 0);
        }

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel);
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16810G);
    }

    public boolean a() {
        return this.f12905e;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f12904d;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i5) {
        if (!this.f12904d) {
            return super.onCreateDrawableState(i5);
        }
        int[] iArr = f12903g;
        return View.mergeDrawableStates(super.onCreateDrawableState(i5 + iArr.length), iArr);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        setChecked(bVar.f12908a);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f12908a = this.f12904d;
        return bVar;
    }

    public void setCheckable(boolean z5) {
        if (this.f12905e != z5) {
            this.f12905e = z5;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z5) {
        if (!this.f12905e || this.f12904d == z5) {
            return;
        }
        this.f12904d = z5;
        refreshDrawableState();
        sendAccessibilityEvent(RecyclerView.ItemAnimator.FLAG_MOVED);
    }

    public void setPressable(boolean z5) {
        this.f12906f = z5;
    }

    @Override // android.view.View
    public void setPressed(boolean z5) {
        if (this.f12906f) {
            super.setPressed(z5);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f12904d);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f12905e = true;
        this.f12906f = true;
        H.k0(this, new a());
    }
}

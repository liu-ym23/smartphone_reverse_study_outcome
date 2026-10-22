package com.stepos.widget.toolbar;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a implements Parcelable.ClassLoaderCreator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4190a;

    public /* synthetic */ a(int i) {
        this.f4190a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel source) {
        switch (this.f4190a) {
            case 0:
                k.f(source, "source");
                return new StepOSCollapsingTitleBar$SavedState(source, null, 0 == true ? 1 : 0);
            default:
                k.f(source, "source");
                return new StepOSMultiChoiceTitleBar$SavedState(source, null);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f4190a) {
            case 0:
                return new StepOSCollapsingTitleBar$SavedState[i];
            default:
                return new StepOSMultiChoiceTitleBar$SavedState[i];
        }
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel source, ClassLoader classLoader) {
        switch (this.f4190a) {
            case 0:
                k.f(source, "source");
                return new StepOSCollapsingTitleBar$SavedState(source, classLoader, null);
            default:
                k.f(source, "source");
                return new StepOSMultiChoiceTitleBar$SavedState(source, classLoader);
        }
    }
}
